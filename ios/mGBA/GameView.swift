import UIKit

final class GameView: UIView {
    var bilinear = true { didSet { imageView.layer.magnificationFilter = bilinear ? .linear : .nearest } }
    var lockAspect = true { didSet { setNeedsLayout() } }
    var integerScale = false { didSet { setNeedsLayout() } }
    var scanlines = false { didSet { scanView.isHidden = !scanlines; scanView.setNeedsDisplay() } }
    var brightness = 100
    private(set) var srcW = 240
    private(set) var srcH = 160
    private let imageView = UIImageView()
    private let scanView = ScanlineOverlay()
    private var last: UIImage?

    override init(frame: CGRect) {
        super.init(frame: frame)
        isOpaque = true
        backgroundColor = .black
        imageView.contentMode = .scaleToFill
        imageView.layer.magnificationFilter = .linear
        imageView.layer.minificationFilter = .linear
        addSubview(imageView)
        addSubview(scanView)
    }

    required init?(coder: NSCoder) { nil }

    func copyLast() -> UIImage? { last }

    func present(pixels: UnsafePointer<UInt32>, width: Int, height: Int, stride: Int) {
        if width != srcW || height != srcH {
            srcW = max(1, width)
            srcH = max(1, height)
            setNeedsLayout()
        }
        let count = width * height * 4
        var bytes = [UInt8](repeating: 0, count: count)
        let scale = Float(min(150, max(50, brightness))) / 100
        for y in 0..<height {
            for x in 0..<width {
                let pix = pixels[y * stride + x]
                let base = (y * width + x) * 4
                bytes[base] = UInt8(min(255, Int(Float(pix & 0xFF) * scale)))
                bytes[base + 1] = UInt8(min(255, Int(Float((pix >> 8) & 0xFF) * scale)))
                bytes[base + 2] = UInt8(min(255, Int(Float((pix >> 16) & 0xFF) * scale)))
                bytes[base + 3] = 255
            }
        }
        let data = Data(bytes)
        guard let provider = CGDataProvider(data: data as CFData) else { return }
        let info = CGBitmapInfo(rawValue: CGImageAlphaInfo.last.rawValue | CGBitmapInfo.byteOrder32Big.rawValue)
        guard let image = CGImage(width: width, height: height, bitsPerComponent: 8, bitsPerPixel: 32, bytesPerRow: width * 4, space: CGColorSpaceCreateDeviceRGB(), bitmapInfo: info, provider: provider, decode: nil, shouldInterpolate: bilinear, intent: .defaultIntent) else { return }
        let ui = UIImage(cgImage: image)
        last = ui
        imageView.image = ui
        imageView.layer.magnificationFilter = bilinear ? .linear : .nearest
        setNeedsDisplay()
    }

    override func layoutSubviews() {
        super.layoutSubviews()
        let frame = placed(bounds.size, src: CGSize(width: srcW, height: srcH))
        imageView.frame = frame
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
