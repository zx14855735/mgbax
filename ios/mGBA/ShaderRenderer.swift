/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
import Metal
import UIKit

/// Uniform block shared with Shaders.metal; the layout must stay in sync.
struct FilterUniforms {
    var texSize: SIMD2<Float>
    var outSize: SIMD2<Float>
    var brightness: Float
    var contrast: Float
    var scanlines: Float
}

/// Renders the emulator frame through a screen filter with Metal, mirroring
/// the Android OpenGL ES ShaderRenderer: a frame is uploaded as a texture,
/// the filter program draws it into the picture rect and the result is swapped
/// to the CAMetalLayer. When Metal is unavailable or a filter program fails to
/// compile, the owner keeps its software blit path, so every filter degrades
/// gracefully.
final class ShaderRenderer {
    /// Fragment function per filter id; index 0 stays empty (no Metal pass).
    static let functionNames = [
        "",
        "filterGbaColor",
        "filterGrayscale",
        "filterHq2x",
        "filterHq4x",
        "filterXbr2",
        "filterXbr4",
        "filterMotionBlur",
        "filterDot",
        "filterLcd3x",
        "filterScanlines",
        "filterQuilez",
    ]

    /// Extra textures holding previous frames for the LCD ghosting filter.
    private static let historySlots = 8
    private static let maxHistory = 7

    let device: MTLDevice
    private let queue: MTLCommandQueue
    private let library: MTLLibrary
    private var vertexFunc: MTLFunction?
    private var pipelines: [Int: MTLRenderPipelineState] = [:]
    private var broken: Set<Int> = []
    private let samplerNearest: MTLSamplerState
    private let samplerLinear: MTLSamplerState

    private var frameTex: MTLTexture?
    private var frameW = 0
    private var frameH = 0
    private var history: [MTLTexture] = []
    private var historyCount = 0
    private var historyIndex = 0

    private var filterId = 0
    private var passthroughState: MTLRenderPipelineState?
    /// Runtime-compiled library for the user-installed shader.
    private var externalVersion = -1

    init?() {
        guard let device = MTLCreateSystemDefaultDevice(),
              let queue = device.makeCommandQueue(),
              let library = device.makeDefaultLibrary() else {
            return nil
        }
        self.device = device
        self.queue = queue
        self.library = library
        vertexFunc = library.makeFunction(name: "filterVertex")
        let descriptor = MTLSamplerDescriptor()
        descriptor.minFilter = .nearest
        descriptor.magFilter = .nearest
        descriptor.sAddressMode = .clampToEdge
        descriptor.tAddressMode = .clampToEdge
        descriptor.mipFilter = .nearest
        guard let nearest = device.makeSamplerState(descriptor: descriptor) else { return nil }
        samplerNearest = nearest
        descriptor.minFilter = .linear
        descriptor.magFilter = .linear
        guard let linear = device.makeSamplerState(descriptor: descriptor) else { return nil }
        samplerLinear = linear
    }

    /** Selects a screen filter; 0 uses the software path. */
    var filter: Int {
        get { filterId }
        set {
            if newValue == filterId { return }
            filterId = newValue
            historyCount = 0
        }
    }

    /** True when a filter is active and Metal has not permanently failed for it. */
    var usable: Bool {
        filterId != 0 && !broken.contains(filterId)
    }

    /**
     * Draws one frame with the selected filter. Returns false when Metal could
     * not run (the caller then falls back to its software path for the frame).
     * `pixels` holds RGBA8 rows of `width` pixels (packed, `stride` pixels per
     * source row); the picture fills the layer, letterboxing is the view's job.
     */
    func present(layer: CAMetalLayer, pixels: UnsafeRawPointer, width: Int, height: Int,
                 stride: Int, brightness: Float, contrast: Float) -> Bool {
        let filter = filterId
        if filter == 0 || broken.contains(filter) {
            return false
        }
        guard width > 0, height > 0, layer.drawableSize.width > 0, layer.drawableSize.height > 0,
              let pipeline = pipeline(for: filter),
              let drawable = layer.nextDrawable(),
              let commandBuffer = queue.makeCommandBuffer() else {
            return false
        }
        guard upload(pixels, width: width, height: height, stride: stride, filter: filter) else {
            return false
        }
        let pass = MTLRenderPassDescriptor()
        pass.colorAttachments[0].texture = drawable.texture
        pass.colorAttachments[0].loadAction = .clear
        pass.colorAttachments[0].clearColor = MTLClearColor(red: 0, green: 0, blue: 0, alpha: 1)
        pass.colorAttachments[0].storeAction = .store
        guard let encoder = commandBuffer.makeRenderCommandEncoder(descriptor: pass) else {
            return false
        }
        let size = layer.drawableSize
        encoder.setViewport(MTLViewport(originX: 0, originY: 0, width: size.width, height: size.height, znear: 0, zfar: 1))
        encoder.setRenderPipelineState(pipeline)
        encoder.setFragmentTexture(frameTex, index: 0)
        // history[0] is the newest previous frame. Slots beyond what has
        // accumulated bind the current frame, whose EMA terms cancel out,
        // so the smear warms up cleanly on the first frames.
        let available = min(historyCount, Self.maxHistory)
        for i in 0..<Self.maxHistory {
            let slot = (historyIndex + Self.historySlots - 2 - i) % Self.historySlots
            if i < available, history.count == Self.historySlots {
                encoder.setFragmentTexture(history[slot], index: i + 1)
            } else {
                encoder.setFragmentTexture(frameTex, index: i + 1)
            }
        }
        // The external shader samples the frame like the sharp filters do.
        let linear = filter == 11 || filter == ExternalShader.filterId
        encoder.setFragmentSamplerState(linear ? samplerLinear : samplerNearest, index: 0)
        var uniforms = FilterUniforms(
            texSize: SIMD2(Float(width), Float(height)),
            outSize: SIMD2(Float(size.width), Float(size.height)),
            brightness: brightness,
            contrast: contrast,
            scanlines: 0
        )
        encoder.setFragmentBytes(&uniforms, length: MemoryLayout<FilterUniforms>.stride, index: 0)
        encoder.drawPrimitives(type: .triangleStrip, vertexStart: 0, vertexCount: 4)
        encoder.endEncoding()
        commandBuffer.present(drawable)
        commandBuffer.commit()
        return true
    }

    private func pipeline(for filter: Int) -> MTLRenderPipelineState? {
        if filter == ExternalShader.filterId {
            return externalPipeline()
        }
        if let cached = pipelines[filter] {
            return cached
        }
        guard filter >= 1, filter < Self.functionNames.count, let vertex = vertexFunc,
              let fragment = library.makeFunction(name: Self.functionNames[filter]) else {
            broken.insert(filter)
            return nil
        }
        let descriptor = MTLRenderPipelineDescriptor()
        descriptor.vertexFunction = vertex
        descriptor.fragmentFunction = fragment
        descriptor.colorAttachments[0].pixelFormat = .bgra8Unorm
        do {
            let state = try device.makeRenderPipelineState(descriptor: descriptor)
            pipelines[filter] = state
            return state
        } catch {
            broken.insert(filter)
            return nil
        }
    }

    /**
     * The pipeline for the user-installed shader. The source is compiled at
     * runtime, so a changed shader drops the cached pipeline; a shader that
     * fails to compile marks itself broken and the caller falls back to the
     * software path.
     */
    private func externalPipeline() -> MTLRenderPipelineState? {
        let version = ExternalShader.version
        if version != externalVersion {
            externalVersion = version
            pipelines[ExternalShader.filterId] = nil
            broken.remove(ExternalShader.filterId)
        }
        if let cached = pipelines[ExternalShader.filterId] {
            return cached
        }
        guard let source = ExternalShader.source, let vertex = vertexFunc else {
            broken.insert(ExternalShader.filterId)
            return nil
        }
        let descriptor = MTLRenderPipelineDescriptor()
        descriptor.vertexFunction = vertex
        descriptor.colorAttachments[0].pixelFormat = .bgra8Unorm
        do {
            let library = try device.makeLibrary(source: source, options: nil)
            guard let fragment = library.makeFunction(name: ExternalShader.fragmentName) else {
                broken.insert(ExternalShader.filterId)
                return nil
            }
            descriptor.fragmentFunction = fragment
            let state = try device.makeRenderPipelineState(descriptor: descriptor)
            pipelines[ExternalShader.filterId] = state
            return state
        } catch {
            broken.insert(ExternalShader.filterId)
            return nil
        }
    }

    /** The plain blit program for captures without (or with a broken) filter. */
    private func passthroughPipeline() -> MTLRenderPipelineState? {
        if let cached = passthroughState {
            return cached
        }
        guard let vertex = vertexFunc, let fragment = library.makeFunction(name: "filterPassthrough") else {
            return nil
        }
        let descriptor = MTLRenderPipelineDescriptor()
        descriptor.vertexFunction = vertex
        descriptor.fragmentFunction = fragment
        descriptor.colorAttachments[0].pixelFormat = .bgra8Unorm
        do {
            let state = try device.makeRenderPipelineState(descriptor: descriptor)
            passthroughState = state
            return state
        } catch {
            return nil
        }
    }

    /** Uploads a packed RGBA8 frame; the capture path uses it for filter 0. */
    func uploadFrame(pixels: UnsafeRawPointer, width: Int, height: Int) {
        _ = upload(pixels, width: width, height: height, stride: width, filter: 0)
    }

    /**
     * Renders the frame that is already uploaded (the display pass or
     * `uploadFrame`) through the active filter — or a plain blit — into an
     * offscreen texture of `outWidth` × `outHeight` and reads the pixels back.
     * Returns packed RGBA8 rows; nil when Metal could not run. Must be called
     * from the same thread as `present` (the main thread).
     */
    func captureRGBA(filter: Int, linear: Bool, scanlines: Bool, brightness: Float,
                     contrast: Float, outWidth: Int, outHeight: Int) -> [UInt8]? {
        let filtered = filter != 0 && !broken.contains(filter)
        guard outWidth > 0, outHeight > 0, let frameTex,
              let pipeline = filtered ? pipeline(for: filter) : passthroughPipeline(),
              let commandBuffer = queue.makeCommandBuffer() else {
            return nil
        }
        let targetDesc = MTLTextureDescriptor.texture2DDescriptor(pixelFormat: .bgra8Unorm, width: outWidth, height: outHeight, mipmapped: false)
        targetDesc.usage = [.renderTarget, .shaderRead]
        guard let target = device.makeTexture(descriptor: targetDesc) else { return nil }
        let readDesc = MTLTextureDescriptor.texture2DDescriptor(pixelFormat: .bgra8Unorm, width: outWidth, height: outHeight, mipmapped: false)
        readDesc.storageMode = .shared
        readDesc.usage = [.shaderRead]
        guard let readback = device.makeTexture(descriptor: readDesc) else { return nil }

        let pass = MTLRenderPassDescriptor()
        pass.colorAttachments[0].texture = target
        pass.colorAttachments[0].loadAction = .clear
        pass.colorAttachments[0].clearColor = MTLClearColor(red: 0, green: 0, blue: 0, alpha: 1)
        pass.colorAttachments[0].storeAction = .store
        guard let encoder = commandBuffer.makeRenderCommandEncoder(descriptor: pass) else {
            return nil
        }
        encoder.setViewport(MTLViewport(originX: 0, originY: 0, width: Double(outWidth), height: Double(outHeight), znear: 0, zfar: 1))
        encoder.setRenderPipelineState(pipeline)
        encoder.setFragmentTexture(frameTex, index: 0)
        let available = min(historyCount, Self.maxHistory)
        for i in 0..<Self.maxHistory {
            let slot = (historyIndex + Self.historySlots - 2 - i) % Self.historySlots
            if i < available, history.count == Self.historySlots {
                encoder.setFragmentTexture(history[slot], index: i + 1)
            } else {
                encoder.setFragmentTexture(frameTex, index: i + 1)
            }
        }
        encoder.setFragmentSamplerState(linear ? samplerLinear : samplerNearest, index: 0)
        var uniforms = FilterUniforms(
            texSize: SIMD2(Float(frameTex.width), Float(frameTex.height)),
            outSize: SIMD2(Float(outWidth), Float(outHeight)),
            brightness: brightness,
            contrast: contrast,
            scanlines: scanlines ? 1 : 0
        )
        encoder.setFragmentBytes(&uniforms, length: MemoryLayout<FilterUniforms>.stride, index: 0)
        encoder.drawPrimitives(type: .triangleStrip, vertexStart: 0, vertexCount: 4)
        encoder.endEncoding()
        if let blit = commandBuffer.makeBlitCommandEncoder() {
            blit.copy(from: target, sourceSlice: 0, sourceLevel: 0, sourceOrigin: MTLOrigin(x: 0, y: 0, z: 0),
                      sourceSize: MTLSize(width: outWidth, height: outHeight, depth: 1),
                      to: readback, destinationSlice: 0, destinationLevel: 0,
                      destinationOrigin: MTLOrigin(x: 0, y: 0, z: 0))
            blit.endEncoding()
        }
        commandBuffer.commit()
        commandBuffer.waitUntilCompleted()

        var bytes = [UInt8](repeating: 0, count: outWidth * outHeight * 4)
        let got = bytes.withUnsafeMutableBytes { raw -> Bool in
            guard let base = raw.baseAddress else { return false }
            readback.getBytes(base, bytesPerRow: outWidth * 4,
                              from: MTLRegionMake2D(0, 0, outWidth, outHeight), mipmapLevel: 0)
            return true
        }
        guard got else { return nil }
        // The pipelines draw in BGRA (the display format); hand back RGBA
        // like the CPU path produces.
        var i = 0
        while i + 3 < bytes.count {
            bytes.swapAt(i, i + 2)
            i += 4
        }
        return bytes
    }

    private func upload(_ pixels: UnsafeRawPointer, width: Int, height: Int, stride: Int, filter: Int) -> Bool {
        if frameTex == nil || frameW != width || frameH != height {
            let descriptor = MTLTextureDescriptor.texture2DDescriptor(pixelFormat: .rgba8Unorm, width: width, height: height, mipmapped: false)
            descriptor.usage = [.shaderRead, .renderTarget]
            frameTex = device.makeTexture(descriptor: descriptor)
            frameW = width
            frameH = height
            historyCount = 0
        }
        guard let frameTex else { return false }
        if stride == width {
            frameTex.replace(region: MTLRegionMake2D(0, 0, width, height), mipmapLevel: 0, withBytes: pixels, bytesPerRow: width * 4)
        } else {
            let source = pixels.assumingMemoryBound(to: UInt8.self)
            var row = [UInt8](repeating: 0, count: width * 4)
            for y in 0..<height {
                memcpy(&row, source + y * stride * 4, width * 4)
                row.withUnsafeBytes { raw in
                    frameTex.replace(region: MTLRegionMake2D(0, y, width, 1), mipmapLevel: 0, withBytes: raw.baseAddress!, bytesPerRow: width * 4)
                }
            }
        }

        if filter == 7 {
            if history.count != Self.historySlots || history.first?.width != width || history.first?.height != height {
                var slots: [MTLTexture] = []
                for _ in 0..<Self.historySlots {
                    let descriptor = MTLTextureDescriptor.texture2DDescriptor(pixelFormat: .rgba8Unorm, width: width, height: height, mipmapped: false)
                    descriptor.usage = [.shaderRead, .renderTarget]
                    slots.append(device.makeTexture(descriptor: descriptor)!)
                }
                history = slots
                historyCount = 0
            }
            if let commandBuffer = queue.makeCommandBuffer(), let blit = commandBuffer.makeBlitCommandEncoder() {
                blit.copy(from: frameTex, sourceSlice: 0, sourceLevel: 0, sourceOrigin: MTLOrigin(x: 0, y: 0, z: 0),
                          sourceSize: MTLSize(width: width, height: height, depth: 1),
                          to: history[historyIndex], destinationSlice: 0, destinationLevel: 0,
                          destinationOrigin: MTLOrigin(x: 0, y: 0, z: 0))
                blit.endEncoding()
                commandBuffer.commit()
            }
            historyIndex = (historyIndex + 1) % Self.historySlots
            historyCount = min(historyCount + 1, Self.maxHistory)
        }
        return true
    }
}

/// UIView-backed CAMetalLayer the filters render into; sized and scaled like
/// any other subview, present() drives it directly.
final class FilterView: UIView {
    let renderer: ShaderRenderer

    var metalLayer: CAMetalLayer { layer as! CAMetalLayer }

    init(renderer: ShaderRenderer) {
        self.renderer = renderer
        super.init(frame: .zero)
        isUserInteractionEnabled = false
        isOpaque = true
        backgroundColor = .black
        let metalLayer = layer as! CAMetalLayer
        metalLayer.device = renderer.device
        metalLayer.pixelFormat = .bgra8Unorm
        metalLayer.isOpaque = true
    }

    required init?(coder: NSCoder) { nil }

    override static var layerClass: AnyClass { CAMetalLayer.self }

    override func layoutSubviews() {
        super.layoutSubviews()
        let scale = window?.screen.scale ?? traitCollection.displayScale
        let metalLayer = layer as! CAMetalLayer
        metalLayer.contentsScale = scale
        metalLayer.drawableSize = CGSize(width: bounds.width * scale, height: bounds.height * scale)
    }
}
