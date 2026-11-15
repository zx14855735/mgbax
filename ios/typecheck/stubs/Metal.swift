// Metal 的最小替身。只声明 ShaderRenderer.swift / EmulatorViewController.swift 实际用到的成员。

public typealias MTLTimeInterval = Double

public protocol MTLDevice: AnyObject {
    var name: String { get }
    var maxThreadsPerThreadgroup: MTLSize { get }
    var supportsFamily: (Any) -> Bool { get }
    func makeCommandQueue() -> MTLCommandQueue?
    func makeDefaultLibrary() -> MTLLibrary?
    func makeLibrary(source: String, options: MTLCompileOptions?) throws -> MTLLibrary
    func makeSamplerState(descriptor: MTLSamplerDescriptor) -> MTLSamplerState?
    func makeRenderPipelineState(descriptor: MTLRenderPipelineDescriptor) throws -> MTLRenderPipelineState
    func makeTexture(descriptor: MTLTextureDescriptor) -> MTLTexture?
    func makeBuffer(bytes: UnsafeRawPointer?, length: Int, options: MTLResourceOptions) -> MTLBuffer?
    func makeBuffer(length: Int, options: MTLResourceOptions) -> MTLBuffer?
}

public func MTLCreateSystemDefaultDevice() -> MTLDevice? { nil }

public struct MTLCompileOptions {
    public var fastMathEnabled: Bool
    public var languageVersion: MTLLanguageVersion
    public init() { fastMathEnabled = true; languageVersion = .version2_0 }
}

public enum MTLLanguageVersion: UInt {
    case version1_0 = 0x10000, version1_1 = 0x10001, version1_2 = 0x10002
    case version2_0 = 0x20000, version2_1 = 0x20001, version2_2 = 0x20002
    case version2_3 = 0x20003, version2_4 = 0x20004, version3_0 = 0x30000
}

public struct MTLResourceOptions: OptionSet {
    public let rawValue: UInt
    public init(rawValue: UInt) { self.rawValue = rawValue }
    public static let cpuCacheModeDefault = MTLResourceOptions(rawValue: 0)
    public static let storageModeShared = MTLResourceOptions(rawValue: 1 << 4)
    public static let storageModePrivate = MTLResourceOptions(rawValue: 2 << 4)
    public static let storageModeMemoryless = MTLResourceOptions(rawValue: 3 << 4)
}

public enum MTLStorageMode: UInt {
    case shared = 0, managed = 1, `private` = 2, memoryless = 3
}

public struct MTLTextureUsage: OptionSet {
    public let rawValue: UInt
    public init(rawValue: UInt) { self.rawValue = rawValue }
    public static let unknown = MTLTextureUsage(rawValue: 0)
    public static let shaderRead = MTLTextureUsage(rawValue: 1 << 0)
    public static let shaderWrite = MTLTextureUsage(rawValue: 1 << 1)
    public static let renderTarget = MTLTextureUsage(rawValue: 1 << 2)
    public static let pixelFormatView = MTLTextureUsage(rawValue: 1 << 4)
}

public enum MTLPixelFormat: UInt {
    case invalid = 0
    case a8Unorm = 1
    case r8Unorm = 10
    case r8Unorm_srgb = 11
    case r16Float = 25
    case rg8Unorm = 30
    case rg16Float = 65
    case rgba8Unorm = 70
    case rgba8Unorm_srgb = 71
    case rgba8Snorm = 72
    case rgba16Float = 115
    case bgra8Unorm = 80
    case bgra8Unorm_srgb = 81
    case depth32Float = 252
    case depth24Unorm_stencil8 = 255
}

public enum MTLPrimitiveType: UInt {
    case point = 0, line = 1, lineStrip = 2, triangle = 3, triangleStrip = 4
}

public enum MTLLoadAction: UInt { case dontCare = 0, load = 1, clear = 2 }

public enum MTLStoreAction: UInt {
    case dontCare = 0, store = 1, multisampleResolve = 2, storeAndMultisampleResolve = 3, unknown = 4
}

public enum MTLSamplerMinMagFilter: UInt { case nearest = 0, linear = 1 }
public enum MTLSamplerMipFilter: UInt { case notMipmapped = 0, nearest = 1, linear = 2 }
public enum MTLSamplerAddressMode: UInt {
    case clampToEdge = 0, mirrorClampToEdge = 1, `repeat` = 2, mirrorRepeat = 3, clampToZero = 4, clampToBorderColor = 5
}
public enum MTLSamplerBorderColor: UInt { case transparentBlack = 0, opaqueBlack = 1, opaqueWhite = 2 }

public class MTLSamplerDescriptor: NSObject {
    public var minFilter: MTLSamplerMinMagFilter
    public var magFilter: MTLSamplerMinMagFilter
    public var mipFilter: MTLSamplerMipFilter
    public var sAddressMode: MTLSamplerAddressMode
    public var tAddressMode: MTLSamplerAddressMode
    public var rAddressMode: MTLSamplerAddressMode
    public var borderColor: MTLSamplerBorderColor
    public var maxAnisotropy: Int
    public var normalizedCoordinates: Bool
    public var lodMinClamp: Float
    public var lodMaxClamp: Float
    public var compareFunction: MTLCompareFunction
    public var label: String?
    public override init() {
        minFilter = .nearest; magFilter = .nearest; mipFilter = .notMipmapped
        sAddressMode = .clampToEdge; tAddressMode = .clampToEdge; rAddressMode = .clampToEdge
        borderColor = .transparentBlack; maxAnisotropy = 1; normalizedCoordinates = true
        lodMinClamp = 0; lodMaxClamp = 0; compareFunction = .never
        super.init()
    }
}

public enum MTLCompareFunction: UInt { case never = 0, less = 1, equal = 2, lessEqual = 3, greater = 4, notEqual = 5, greaterEqual = 6, always = 7 }

public protocol MTLSamplerState: AnyObject {
    var label: String? { get }
}

public protocol MTLFunction: AnyObject {
    var label: String? { get }
    var name: String { get }
}

public protocol MTLLibrary: AnyObject {
    var label: String? { get }
    var functionNames: [String] { get }
    func makeFunction(name: String) -> MTLFunction?
}

public protocol MTLRenderPipelineState: AnyObject {
    var label: String? { get }
}

public class MTLRenderPipelineColorAttachmentDescriptor: NSObject {
    public var pixelFormat: MTLPixelFormat = .invalid
    public var isBlendingEnabled: Bool = false
    public var writeMask: UInt32 = 0xF
}

public class MTLRenderPipelineColorAttachmentDescriptorArray: NSObject {
    public subscript(index: Int) -> MTLRenderPipelineColorAttachmentDescriptor { fatalError() }
}

public class MTLRenderPipelineDescriptor: NSObject {
    public var label: String?
    public var vertexFunction: MTLFunction?
    public var fragmentFunction: MTLFunction?
    public var vertexDescriptor: MTLVertexDescriptor?
    public var sampleCount: Int = 1
    public var rasterizationEnabled: Bool = true
    public var colorAttachments: MTLRenderPipelineColorAttachmentDescriptorArray
    public var depthAttachmentPixelFormat: MTLPixelFormat = .invalid
    public var stencilAttachmentPixelFormat: MTLPixelFormat = .invalid
    public override init() { colorAttachments = MTLRenderPipelineColorAttachmentDescriptorArray(); super.init() }
}

public class MTLVertexDescriptor: NSObject {}
public class MTLDepthStencilDescriptor: NSObject {}

public struct MTLSize {
    public var width: Int
    public var height: Int
    public var depth: Int
    public init(width: Int, height: Int, depth: Int) { self.width = width; self.height = height; self.depth = depth }
    public init() { width = 0; height = 0; depth = 0 }
}

public struct MTLOrigin {
    public var x: Int
    public var y: Int
    public var z: Int
    public init(x: Int, y: Int, z: Int) { self.x = x; self.y = y; self.z = z }
    public init() { x = 0; y = 0; z = 0 }
}

public struct MTLRegion {
    public var origin: MTLOrigin
    public var size: MTLSize
    public init(origin: MTLOrigin, size: MTLSize) { self.origin = origin; self.size = size }
    public init() { origin = MTLOrigin(); size = MTLSize() }
}

public func MTLRegionMake2D(_ x: Int, _ y: Int, _ width: Int, _ height: Int) -> MTLRegion {
    MTLRegion(origin: MTLOrigin(x: x, y: y, z: 0), size: MTLSize(width: width, height: height, depth: 1))
}

public struct MTLViewport {
    public var originX: Double
    public var originY: Double
    public var width: Double
    public var height: Double
    public var znear: Double
    public var zfar: Double
    public init(originX: Double, originY: Double, width: Double, height: Double, znear: Double, zfar: Double) {
        self.originX = originX; self.originY = originY; self.width = width
        self.height = height; self.znear = znear; self.zfar = zfar
    }
}

public struct MTLClearColor {
    public var red: Double
    public var green: Double
    public var blue: Double
    public var alpha: Double
    public init(red: Double, green: Double, blue: Double, alpha: Double) {
        self.red = red; self.green = green; self.blue = blue; self.alpha = alpha
    }
}

public class MTLTextureDescriptor: NSObject {
    public var textureType: MTLTextureType = .type2D
    public var pixelFormat: MTLPixelFormat = .invalid
    public var width: Int = 0
    public var height: Int = 0
    public var depth: Int = 1
    public var mipmapLevelCount: Int = 1
    public var sampleCount: Int = 1
    public var arrayLength: Int = 1
    public var resourceOptions: MTLResourceOptions = []
    public var usage: MTLTextureUsage = .unknown
    public var storageMode: MTLStorageMode = .shared
    public var cpuCacheMode: UInt = 0
    public override init() { super.init() }
    public static func texture2DDescriptor(pixelFormat: MTLPixelFormat, width: Int, height: Int, mipmapped: Bool) -> MTLTextureDescriptor {
        let d = MTLTextureDescriptor()
        d.pixelFormat = pixelFormat; d.width = width; d.height = height
        d.mipmapLevelCount = mipmapped ? 2 : 1
        return d
    }
}

public enum MTLTextureType: UInt {
    case type1D = 0, type1DArray = 1, type2D = 2, type2DArray = 3, type2DMultisample = 4
    case typeCube = 5, typeCubeArray = 6, type3D = 7, type2DMultisampleArray = 8
}

public protocol MTLTexture: AnyObject {
    var label: String? { get }
    var width: Int { get }
    var height: Int { get }
    var depth: Int { get }
    var pixelFormat: MTLPixelFormat { get }
    var mipmapLevelCount: Int { get }
    var arrayLength: Int { get }
    var textureType: MTLTextureType { get }
    func replace(region: MTLRegion, mipmapLevel level: Int, withBytes pixelBytes: UnsafeRawPointer, bytesPerRow: Int)
    func replace(region: MTLRegion, mipmapLevel level: Int, slice: Int, withBytes pixelBytes: UnsafeRawPointer, bytesPerRow: Int, bytesPerImage: Int)
    func getBytes(_ pixelBytes: UnsafeMutableRawPointer, bytesPerRow: Int, from region: MTLRegion, mipmapLevel level: Int)
    func getBytes(_ pixelBytes: UnsafeMutableRawPointer, bytesPerRow: Int, bytesPerImage: Int, from region: MTLRegion, mipmapLevel level: Int, slice: Int)
    func makeTextureView(pixelFormat: MTLPixelFormat) -> MTLTexture?
}

public protocol MTLBuffer: AnyObject {
    var length: Int { get }
    func contents() -> UnsafeMutableRawPointer
}

public protocol MTLCommandQueue: AnyObject {
    var label: String? { get }
    func makeCommandBuffer() -> MTLCommandBuffer?
    func makeCommandBufferWithUnretainedReferences() -> MTLCommandBuffer?
}

public protocol MTLDrawable: AnyObject {
    func present()
}

public protocol MTLCommandBuffer: AnyObject {
    var label: String? { get }
    var status: MTLCommandBufferStatus { get }
    var error: Error? { get }
    func makeRenderCommandEncoder(descriptor: MTLRenderPassDescriptor) -> MTLRenderCommandEncoder?
    func makeBlitCommandEncoder() -> MTLBlitCommandEncoder?
    func makeComputeCommandEncoder() -> MTLComputeCommandEncoder?
    func present(_ drawable: MTLDrawable)
    func commit()
    func waitUntilCompleted()
    func waitUntilScheduled()
    func enqueue()
    var commandBufferStatusHandler: (() -> Void)? { get set }
}

public enum MTLCommandBufferStatus: UInt {
    case notEnqueued = 0, enqueued = 1, committed = 2, scheduled = 3, completed = 4, error = 5
}

public protocol MTLCommandEncoder: AnyObject {
    func endEncoding()
    func insertDebugSignpost(_ string: String)
    func pushDebugGroup(_ string: String)
    func popDebugGroup()
}

public protocol MTLRenderCommandEncoder: MTLCommandEncoder {
    func setRenderPipelineState(_ pipelineState: MTLRenderPipelineState)
    func setVertexBytes(_ bytes: UnsafeRawPointer, length: Int, index: Int)
    func setVertexBuffer(_ buffer: MTLBuffer?, offset: Int, index: Int)
    func setVertexTexture(_ texture: MTLTexture?, index: Int)
    func setVertexSamplerState(_ sampler: MTLSamplerState?, index: Int)
    func setFragmentBytes(_ bytes: UnsafeRawPointer, length: Int, index: Int)
    func setFragmentBuffer(_ buffer: MTLBuffer?, offset: Int, index: Int)
    func setFragmentTexture(_ texture: MTLTexture?, index: Int)
    func setFragmentSamplerState(_ sampler: MTLSamplerState?, index: Int)
    func setFragmentSamplerState(_ sampler: MTLSamplerState?, lodMinClamp: Float, lodMaxClamp: Float, index: Int)
    func setViewport(_ viewport: MTLViewport)
    func setScissorRect(_ rect: MTLScissorRect)
    func setCullMode(_ mode: MTLCullMode)
    func setFrontFacing(_ winding: MTLWinding)
    func drawPrimitives(type primitiveType: MTLPrimitiveType, vertexStart: Int, vertexCount: Int)
    func drawPrimitives(type primitiveType: MTLPrimitiveType, vertexStart: Int, vertexCount: Int, instanceCount: Int)
    func drawPrimitives(type primitiveType: MTLPrimitiveType, vertexStart: Int, vertexCount: Int, instanceCount: Int, baseInstance: Int)
    func drawIndexedPrimitives(type primitiveType: MTLPrimitiveType, indexCount: Int, indexType: MTLIndexType, indexBuffer: MTLBuffer, indexBufferOffset: Int)
}

public protocol MTLBlitCommandEncoder: MTLCommandEncoder {
    func copy(from sourceTexture: MTLTexture, sourceSlice: Int, sourceLevel: Int, sourceOrigin: MTLOrigin, sourceSize: MTLSize, to destinationTexture: MTLTexture, destinationSlice: Int, destinationLevel: Int, destinationOrigin: MTLOrigin)
    func copy(from sourceBuffer: MTLBuffer, sourceOffset: Int, sourceBytesPerRow: Int, sourceBytesPerImage: Int, sourceSize: MTLSize, to destinationTexture: MTLTexture, destinationSlice: Int, destinationLevel: Int, destinationOrigin: MTLOrigin)
    func synchronize(resource: Any)
}

public protocol MTLComputeCommandEncoder: MTLCommandEncoder {
    func setComputePipelineState(_ state: AnyObject)
    func setTexture(_ texture: MTLTexture?, index: Int)
    func setBuffer(_ buffer: MTLBuffer?, offset: Int, index: Int)
    func setBytes(_ bytes: UnsafeRawPointer, length: Int, index: Int)
    func dispatchThreadgroups(_ threadgroupsPerGrid: MTLSize, threadsPerThreadgroup: MTLSize)
    func dispatchThreads(_ threadsPerGrid: MTLSize, threadsPerThreadgroup: MTLSize)
}

public struct MTLScissorRect {
    public var x: Int, y: Int, width: Int, height: Int
    public init(x: Int, y: Int, width: Int, height: Int) { self.x = x; self.y = y; self.width = width; self.height = height }
}

public enum MTLCullMode: UInt { case none = 0, front = 1, back = 2 }
public enum MTLWinding: UInt { case clockwise = 0, counterClockwise = 1 }
public enum MTLIndexType: UInt { case uint16 = 0, uint32 = 1 }

public class MTLRenderPassAttachmentDescriptor: NSObject {
    public var texture: MTLTexture?
    public var level: Int = 0
    public var slice: Int = 0
    public var depthPlane: Int = 0
    public var resolveTexture: MTLTexture?
    public var loadAction: MTLLoadAction = .dontCare
    public var storeAction: MTLStoreAction = .dontCare
    public var clearColor: MTLClearColor = MTLClearColor(red: 0, green: 0, blue: 0, alpha: 0)
    public var clearDepth: Double = 1
    public var clearStencil: UInt32 = 0
}

public class MTLRenderPassColorAttachmentDescriptor: MTLRenderPassAttachmentDescriptor {}
public class MTLRenderPassDepthAttachmentDescriptor: MTLRenderPassAttachmentDescriptor {}
public class MTLRenderPassStencilAttachmentDescriptor: MTLRenderPassAttachmentDescriptor {}

public class MTLRenderPassColorAttachmentDescriptorArray: NSObject {
    public subscript(index: Int) -> MTLRenderPassColorAttachmentDescriptor { fatalError() }
}

public class MTLRenderPassDescriptor: NSObject {
    public var colorAttachments: MTLRenderPassColorAttachmentDescriptorArray
    public var depthAttachment: MTLRenderPassDepthAttachmentDescriptor
    public var stencilAttachment: MTLRenderPassStencilAttachmentDescriptor
    public var renderTargetWidth: Int = 0
    public var renderTargetHeight: Int = 0
    public override init() {
        colorAttachments = MTLRenderPassColorAttachmentDescriptorArray()
        depthAttachment = MTLRenderPassDepthAttachmentDescriptor()
        stencilAttachment = MTLRenderPassStencilAttachmentDescriptor()
        super.init()
    }
}

public class MTLDepthStencilState: NSObject {}
