import UIKit

final class GameView: UIView {
    var bilinear = true { didSet { imageView.layer.magnificationFilter = bilinear ? .linear : .nearest } }
    var lockAspect = true { didSet { setNeedsLayout() } }
    var integerScale = false { didSet { setNeedsLayout() } }
    var scanlines = false { didSet { scanView.isHidden = !scanlines; scanView.setNeedsDisplay() } }
    var brightness = 100
    /// Contrast around mid gray, 50-150; 100 leaves colors as-is.
    var contrast = 100 {
        didSet {
            let clamped = min(150, max(50, contrast))
            if clamped != contrast {
                contrast = clamped
            }
        }
    }
    /// Screen filter id (Shaders.functionNames); 0 keeps the software blit.
    var filter = 0 {
        didSet {
            guard filter != oldValue else { return }
            renderer?.filter = filter
            updateFilterVisibility()
        }
    }
    private(set) var srcW = 240
    private(set) var srcH = 160
    private let imageView = UIImageView()
    private let scanView = ScanlineOverlay()
    private var last: UIImage?
    /// The frame behind `last`, packed RGBA8; screenshots and GIF captures
    /// hand it to the Metal filter pass so they can match the display.
    private var lastRaw: Data?
    /// Metal path for screen filters; the software path stays as the fallback.
    private var renderer: ShaderRenderer?
    private var filterView: FilterView?

    override init(frame: CGRect) {
        super.init(frame: frame)
        isOpaque = true
        backgroundColor = .black
        imageView.contentMode = .scaleToFill
        imageView.layer.magnificationFilter = .linear
        imageView.layer.minificationFilter = .linear
        addSubview(imageView)
        if let renderer = ShaderRenderer() {
            self.renderer = renderer
            let view = FilterView(renderer: renderer)
            view.isHidden = true
            addSubview(view)
            filterView = view
        }
        addSubview(scanView)
    }

    required init?(coder: NSCoder) { nil }

    func copyLast() -> UIImage? { last }

    /// Rect of the game picture inside the view, letterbox excluded, in view
    /// coordinates. Overlays that align to the picture use this rather than
    /// the full bounds (which may include black bars or the shell's bezel).
    var pictureRect: CGRect {
        placed(bounds.size, src: CGSize(width: srcW, height: srcH))
    }

    /// True when what is on screen differs from the raw core frame.
    var showsFilteredOutput: Bool {
        filter != 0 || scanlines
    }

    /// Captures what the display actually shows — filter and scanline overlay
    /// included — as packed RGBA8 rows of `outWidth` × `outHeight`. Nil when
    /// the Metal path cannot run (the caller keeps the raw frame). Main thread
    /// only, right after a `present` so the uploaded texture is current.
    func captureFilteredFrame(pixels: UnsafeRawPointer, width: Int, height: Int,
                              outWidth: Int, outHeight: Int, brightness: Float,
                              contrast: Float) -> [UInt8]? {
        guard let renderer else { return nil }
        let filtered = filter != 0 && renderer.usable
        if !filtered {
            // The display ran on the CPU path; hand the filter pass the raw
            // frame. Filter 0 keeps the history ring untouched.
            renderer.uploadFrame(pixels: pixels, width: width, height: height)
        }
        return renderer.captureRGBA(
            filter: filter,
            linear: filtered ? (filter == 11 || filter == ExternalShader.filterId) : bilinear,
            scanlines: scanlines,
            // The CPU-path bytes already carry brightness and contrast.
            brightness: filtered ? brightness : 1,
            contrast: filtered ? contrast : 1,
            outWidth: outWidth,
            outHeight: outHeight)
    }

    /// Screenshot variant: renders at the display resolution so the saved PNG
    /// matches the picture on screen, the way the Android PixelCopy does.
    func captureFilteredScreenshot() -> UIImage? {
        guard let renderer, let filterView, let raw = lastRaw,
              filterView.frame.width > 0, filterView.frame.height > 0 else {
            return nil
        }
        let scale = filterView.metalLayer.contentsScale
        let outW = max(1, Int(filterView.frame.width * scale))
        let outH = max(1, Int(filterView.frame.height * scale))
        let bytes = raw.withUnsafeBytes { (rawPtr: UnsafeRawBufferPointer) -> [UInt8]? in
            guard let base = rawPtr.baseAddress else { return nil }
            return captureFilteredFrame(pixels: base, width: srcW, height: srcH,
                                        outWidth: outW, outHeight: outH,
                                        brightness: Float(min(150, max(50, brightness))) / 100,
                                        contrast: Float(min(150, max(50, contrast))) / 100)
        }
        guard let bytes else { return nil }
        return Self.image(fromRGBA: bytes, width: outW, height: outH)
    }

    private static func image(fromRGBA bytes: [UInt8], width: Int, height: Int) -> UIImage? {
        let data = Data(bytes)
        guard let provider = CGDataProvider(data: data as CFData) else { return nil }
        let info = CGBitmapInfo(rawValue: CGImageAlphaInfo.last.rawValue | CGBitmapInfo.byteOrder32Big.rawValue)
        guard let image = CGImage(width: width, height: height, bitsPerComponent: 8, bitsPerPixel: 32,
                                  bytesPerRow: width * 4, space: CGColorSpaceCreateDeviceRGB(),
                                  bitmapInfo: info, provider: provider, decode: nil,
                                  shouldInterpolate: false, intent: .defaultIntent) else { return nil }
        return UIImage(cgImage: image)
    }

    func present(pixels: UnsafePointer<UInt32>, width: Int, height: Int, stride: Int) {
        if width != srcW || height != srcH {
            srcW = max(1, width)
            srcH = max(1, height)
            setNeedsLayout()
        }
        let filtering = filter != 0 && renderer?.usable == true && filterView != nil
        // With a filter active the shader applies brightness and contrast
        // itself; the CPU copy stays unscaled so both paths agree.
        let bright = Float(min(150, max(50, brightness))) / 100
        let contrastValue = Float(min(150, max(50, contrast))) / 100
        let scale = filtering ? 1 : bright * contrastValue
        let lift = filtering ? 0 : Float(128) * (1 - contrastValue)
        let count = width * height * 4
        var bytes = [UInt8](repeating: 0, count: count)
        for y in 0..<height {
            for x in 0..<width {
                let pix = pixels[y * stride + x]
                let base = (y * width + x) * 4
                bytes[base] = UInt8(max(0, min(255, Int(Float(pix & 0xFF) * scale + lift))))
                bytes[base + 1] = UInt8(max(0, min(255, Int(Float((pix >> 8) & 0xFF) * scale + lift))))
                bytes[base + 2] = UInt8(max(0, min(255, Int(Float((pix >> 16) & 0xFF) * scale + lift))))
                bytes[base + 3] = 255
            }
        }
        let data = Data(bytes)
        lastRaw = data
        guard let provider = CGDataProvider(data: data as CFData) else { return }
        let info = CGBitmapInfo(rawValue: CGImageAlphaInfo.last.rawValue | CGBitmapInfo.byteOrder32Big.rawValue)
        guard let image = CGImage(width: width, height: height, bitsPerComponent: 8, bitsPerPixel: 32, bytesPerRow: width * 4, space: CGColorSpaceCreateDeviceRGB(), bitmapInfo: info, provider: provider, decode: nil, shouldInterpolate: bilinear, intent: .defaultIntent) else { return }
        let ui = UIImage(cgImage: image)
        last = ui
        imageView.image = ui
        imageView.layer.magnificationFilter = bilinear ? .linear : .nearest
        setNeedsDisplay()
        if filtering, let filterView, let renderer {
            filterView.isHidden = false
            bytes.withUnsafeBytes { raw in
                guard let base = raw.baseAddress else { return }
                _ = renderer.present(layer: filterView.metalLayer, pixels: base, width: width, height: height,
                                     stride: stride, brightness: Float(min(150, max(50, brightness))) / 100,
                                     contrast: Float(min(150, max(50, contrast))) / 100)
            }
        } else if let filterView {
            filterView.isHidden = true
        }
    }

    private func updateFilterVisibility() {
        guard let filterView else { return }
        filterView.isHidden = !(filter != 0 && renderer?.usable == true)
    }

    override func layoutSubviews() {
        super.layoutSubviews()
        let frame = placed(bounds.size, src: CGSize(width: srcW, height: srcH))
        imageView.frame = frame
        filterView?.frame = frame
        scanView.frame = frame
        scanView.isHidden = !scanlines
    }

    private func placed(_ view: CGSize, src: CGSize) -> CGRect {
        if view.width <= 0 || view.height <= 0 || src.width <= 0 || src.height <= 0 {
            return .zero
        }
        if !lockAspect {
            return CGRect(origin: .zero, size: view)
        }
        let screen = window?.screen.scale ?? traitCollection.displayScale
        let viewW = view.width * screen
        let viewH = view.height * screen
        if integerScale && viewW >= src.width && viewH >= src.height {
            let scale = floor(min(viewW / src.width, viewH / src.height))
            let w = src.width * scale / screen
            let h = src.height * scale / screen
            return CGRect(x: (view.width - w) / 2, y: (view.height - h) / 2, width: w, height: h)
        }
        let scale = min(view.width / src.width, view.height / src.height)
        let w = max(1, (src.width * scale).rounded())
        let h = max(1, (src.height * scale).rounded())
        return CGRect(x: (view.width - w) / 2, y: (view.height - h) / 2, width: w, height: h)
    }
}

private final class ScanlineOverlay: UIView {
    override init(frame: CGRect) {
        super.init(frame: frame)
        isUserInteractionEnabled = false
        backgroundColor = .clear
        isOpaque = false
        isHidden = true
    }

    required init?(coder: NSCoder) { nil }

    override func draw(_ rect: CGRect) {
        guard bounds.height > 2, let ctx = UIGraphicsGetCurrentContext() else { return }
        ctx.setStrokeColor(UIColor(white: 0, alpha: 0.4).cgColor)
        ctx.setLineWidth(1)
        var y: CGFloat = 1
        while y < bounds.height {
            ctx.move(to: CGPoint(x: 0, y: y))
            ctx.addLine(to: CGPoint(x: bounds.width, y: y))
            y += 2
        }
        ctx.strokePath()
    }
}
