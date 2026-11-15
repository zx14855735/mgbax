// CoreGraphics 的最小替身。
//
// 近似点（刻意为之）：64 位上 CGFloat == Double，这里直接 typealias，
// 于是 CGFloat/Double 的混用不会被检查出来 —— 与真机行为一致，不算放宽。

public typealias CGFloat = Double
public typealias CGLineWidth = CGFloat

public struct CGPoint: Equatable {
    public var x: CGFloat
    public var y: CGFloat
    public init() { x = 0; y = 0 }
    public init(x: CGFloat, y: CGFloat) { self.x = x; self.y = y }
    public static let zero = CGPoint(x: 0, y: 0)
    public func applying(_ t: CGAffineTransform) -> CGPoint { fatalError() }
}

public struct CGSize: Equatable {
    public var width: CGFloat
    public var height: CGFloat
    public init() { width = 0; height = 0 }
    public init(width: CGFloat, height: CGFloat) { self.width = width; self.height = height }
    public static let zero = CGSize(width: 0, height: 0)
    public func applying(_ t: CGAffineTransform) -> CGSize { fatalError() }
}

public struct CGVector: Equatable {
    public var dx: CGFloat
    public var dy: CGFloat
    public init() { dx = 0; dy = 0 }
    public init(dx: CGFloat, dy: CGFloat) { self.dx = dx; self.dy = dy }
}

public struct CGRect: Equatable {
    public var origin: CGPoint
    public var size: CGSize
    public init() { origin = .zero; size = .zero }
    public init(origin: CGPoint, size: CGSize) { self.origin = origin; self.size = size }
    public init(x: CGFloat, y: CGFloat, width: CGFloat, height: CGFloat) {
        origin = CGPoint(x: x, y: y); size = CGSize(width: width, height: height)
    }
    public static let zero = CGRect()
    public static let null = CGRect(x: CGFloat.infinity, y: CGFloat.infinity, width: 0, height: 0)
    public var width: CGFloat { get { size.width } set { size.width = newValue } }
    public var height: CGFloat { get { size.height } set { size.height = newValue } }
    public var minX: CGFloat { origin.x }
    public var minY: CGFloat { origin.y }
    public var midX: CGFloat { origin.x + size.width / 2 }
    public var midY: CGFloat { origin.y + size.height / 2 }
    public var maxX: CGFloat { origin.x + size.width }
    public var maxY: CGFloat { origin.y + size.height }
    public var isEmpty: Bool { size.width <= 0 || size.height <= 0 }
    public var isNull: Bool { false }
    public var isInfinite: Bool { false }
    public var standardized: CGRect { self }
    public var integral: CGRect { self }
    public var insetBy: (CGFloat, CGFloat) -> CGRect { { _, _ in self } }
    public func insetBy(dx: CGFloat, dy: CGFloat) -> CGRect { self }
    public func offsetBy(dx: CGFloat, dy: CGFloat) -> CGRect { self }
    public func union(_ r2: CGRect) -> CGRect { self }
    public func intersection(_ r2: CGRect) -> CGRect { self }
    public func intersects(_ r2: CGRect) -> Bool { false }
    public func contains(_ point: CGPoint) -> Bool { false }
    public func contains(_ rect2: CGRect) -> Bool { false }
    public func equalTo(_ rect2: CGRect) -> Bool { false }
    public func applying(_ t: CGAffineTransform) -> CGRect { self }
}

public struct CGAffineTransform: Equatable {
    public var a: CGFloat, b: CGFloat, c: CGFloat, d: CGFloat, tx: CGFloat, ty: CGFloat
    public init() { a = 1; b = 0; c = 0; d = 1; tx = 0; ty = 0 }
    public init(a: CGFloat, b: CGFloat, c: CGFloat, d: CGFloat, tx: CGFloat, ty: CGFloat) {
        self.a = a; self.b = b; self.c = c; self.d = d; self.tx = tx; self.ty = ty
    }
    public init(translationX: CGFloat, y: CGFloat) { self.init(); tx = translationX; ty = y }
    public init(scaleX: CGFloat, y: CGFloat) { self.init(); a = scaleX; d = y }
    public init(rotationAngle: CGFloat) { self.init() }
    public static let identity = CGAffineTransform()
    public func translatedBy(x: CGFloat, y: CGFloat) -> CGAffineTransform { self }
    public func scaledBy(x: CGFloat, y: CGFloat) -> CGAffineTransform { self }
    public func concatenating(_ t2: CGAffineTransform) -> CGAffineTransform { self }
    public func inverted() -> CGAffineTransform { self }
}

public struct CGColor: Equatable {
    public var components: [CGFloat]? { nil }
    public var numberOfComponents: Int { get { fatalError() } set { fatalError() } }
    public var alpha: CGFloat { get { fatalError() } set { fatalError() } }
    public var colorSpace: CGColorSpace? { nil }
    public static func == (lhs: CGColor, rhs: CGColor) -> Bool { false }
}

public class CGColorSpace {
    public static let sRGB: CGColorSpace? = CGColorSpace()
    public static let genericRGB: CGColorSpace? = CGColorSpace()
    public init() {}
}

public class CGImage {
    public var width: Int { get { fatalError() } set { fatalError() } }
    public var height: Int { get { fatalError() } set { fatalError() } }
    public var bitsPerComponent: Int { get { fatalError() } set { fatalError() } }
    public var bitsPerPixel: Int { get { fatalError() } set { fatalError() } }
    public var bytesPerRow: Int { get { fatalError() } set { fatalError() } }
    public var dataProvider: CGDataProvider? { nil }
    public var colorSpace: CGColorSpace? { nil }
    public var alphaInfo: CGImageAlphaInfo { get { fatalError() } set { fatalError() } }
    public func copy() -> CGImage? { fatalError() }
    public func cropping(to rect: CGRect) -> CGImage? { fatalError() }
    public init?(width: Int, height: Int, bitsPerComponent: Int, bitsPerPixel: Int, bytesPerRow: Int, space: CGColorSpace, bitmapInfo: CGBitmapInfo, provider: CGDataProvider, decode: UnsafePointer<CGFloat>?, shouldInterpolate: Bool, intent: CGColorRenderingIntent) { fatalError() }
}

public class CGDataProvider {
    public init?(data: Data) { fatalError() }
    public init?(dataInfo: UnsafeRawPointer?, size: Int) { fatalError() }
    public init(data: Data, size: Int) { fatalError() }
}

public enum CGImageAlphaInfo: UInt32 {
    case none = 0
    case premultipliedLast = 1
    case premultipliedFirst = 2
    case last = 3
    case first = 4
    case noneSkipLast = 5
    case noneSkipFirst = 6
    case alphaOnly = 7
}

public struct CGBitmapInfo: OptionSet {
    public let rawValue: UInt32
    public init(rawValue: UInt32) { self.rawValue = rawValue }
    public static let alphaInfoMask = CGBitmapInfo(rawValue: 0x1F)
    public static let floatComponents = CGBitmapInfo(rawValue: 1 << 8)
    public static let byteOrderMask = CGBitmapInfo(rawValue: 0x7000)
    public static let byteOrderDefault = CGBitmapInfo(rawValue: 0 << 12)
    public static let byteOrder16Little = CGBitmapInfo(rawValue: 1 << 12)
    public static let byteOrder32Little = CGBitmapInfo(rawValue: 2 << 12)
    public static let byteOrder16Big = CGBitmapInfo(rawValue: 3 << 12)
    public static let byteOrder32Big = CGBitmapInfo(rawValue: 4 << 12)
    public static let premultipliedLast = CGBitmapInfo(rawValue: CGImageAlphaInfo.premultipliedLast.rawValue)
    public static let premultipliedFirst = CGBitmapInfo(rawValue: CGImageAlphaInfo.premultipliedFirst.rawValue)
}

public enum CGColorRenderingIntent: Int32 {
    case defaultIntent = 0
    case absoluteColorimetric = 1
    case relativeColorimetric = 2
    case perceptual = 3
    case saturation = 4
}

public enum CGBlendMode: Int32 {
    case normal = 0, multiply = 1, screen = 2, overlay = 3, darken = 4, lighten = 5
    case colorDodge = 6, colorBurn = 7, softLight = 8, hardLight = 9, difference = 10
    case exclusion = 11, hue = 12, saturation = 13, color = 14, luminosity = 15
    case clear = 16, copy = 17, sourceIn = 18, sourceOut = 19, sourceAtop = 20
    case destinationOver = 21, destinationIn = 22, destinationOut = 23, destinationAtop = 24
    case xor = 25, plusDarker = 26, plusLighter = 27
}

public enum CGLineCap: Int32 { case butt = 0, round = 1, square = 2 }
public enum CGLineJoin: Int32 { case miter = 0, round = 1, bevel = 2 }
public enum CGPathDrawingMode: Int32 { case fill = 0, eoFill = 1, stroke = 2, fillStroke = 3, eoFillStroke = 4 }
public enum CGTextDrawingMode: Int32 { case fill = 0, stroke = 1, fillStroke = 2, invisible = 3 }
public enum CGInterpolationQuality: Int32 { case `default` = 0, none = 1, low = 2, medium = 3, high = 4 }

public class CGContext {
    public init?(data: UnsafeMutableRawPointer?, width: Int, height: Int, bitsPerComponent: Int,
                 bytesPerRow: Int, space: CGColorSpace?, bitmapInfo: UInt32) { fatalError() }
    public init?(data: UnsafeMutableRawPointer?, width: Int, height: Int, bitsPerComponent: Int,
                 bytesPerRow: Int, space: CGColorSpace?, bitmapInfo: CGBitmapInfo) { fatalError() }
    public var width: Int { get { fatalError() } set { fatalError() } }
    public var height: Int { get { fatalError() } set { fatalError() } }
    public var bitsPerComponent: Int { get { fatalError() } set { fatalError() } }
    public var bytesPerRow: Int { get { fatalError() } set { fatalError() } }
    public func saveGState() {}
    public func restoreGState() {}
    public func setFillColor(_ color: CGColor) {}
    public func setFillColor(_ components: UnsafePointer<CGFloat>) {}
    public func setStrokeColor(_ color: CGColor) {}
    public func setStrokeColor(_ components: UnsafePointer<CGFloat>) {}
    public func setLineWidth(_ width: CGFloat) {}
    public func setLineCap(_ cap: CGLineCap) {}
    public func setLineJoin(_ join: CGLineJoin) {}
    public func setBlendMode(_ mode: CGBlendMode) {}
    public func setAlpha(_ alpha: CGFloat) {}
    public func setShadow(offset: CGSize, blur: CGFloat, color: CGColor?) {}
    public func setShadow(offset: CGSize, blur: CGFloat) {}
    public func setPatternPhase(_ phase: CGSize) {}
    public func setShouldAntialias(_ shouldAntialias: Bool) {}
    public func setInterpolationQuality(_ quality: CGInterpolationQuality) {}
    public var interpolationQuality: CGInterpolationQuality { get { fatalError() } set { fatalError() } }
    public var shouldAntialias: Bool { get { fatalError() } set { fatalError() } }
    public var shouldSmoothFonts: Bool { get { fatalError() } set { fatalError() } }
    public func fill(_ rect: CGRect) {}
    public func stroke(_ rect: CGRect) {}
    public func clear(_ rect: CGRect) {}
    public func beginPath() {}
    public func closePath() {}
    public func move(to point: CGPoint) {}
    public func addLine(to point: CGPoint) {}
    public func addRect(_ rect: CGRect) {}
    public func addEllipse(in rect: CGRect) {}
    public func addPath(_ path: CGPath) {}
    public func drawPath(using mode: CGPathDrawingMode) {}
    public func fillPath() {}
    public func strokePath() {}
    public func clip() {}
    public func clip(to rect: CGRect) {}
    public func translateBy(x: CGFloat, y: CGFloat) {}
    public func scaleBy(x: CGFloat, y: CGFloat) {}
    public func rotate(by angle: CGFloat) {}
    public func concatenate(_ transform: CGAffineTransform) {}
    public func draw(_ image: CGImage, in rect: CGRect) {}
    public func draw(_ image: CGImage, in rect: CGRect, byTiling tile: Bool) {}
    public func makeImage() -> CGImage? { fatalError() }
    public func drawLinearGradient(_ gradient: CGGradient, start startPoint: CGPoint, end endPoint: CGPoint, options: CGGradientDrawingOptions) {}
    public func drawRadialGradient(_ gradient: CGGradient, startCenter: CGPoint, startRadius: CGFloat, endCenter: CGPoint, endRadius: CGFloat, options: CGGradientDrawingOptions) {}
    public func drawCGImage(_ image: CGImage, in rect: CGRect) {}
    public func setTextMatrix(_ t: CGAffineTransform) {}
    public func showGlyphsAtPositions(glyphs: UnsafePointer<CGGlyph>, positions: UnsafePointer<CGPoint>, count: Int) {}
    public func flush() {}
}

public typealias CGGlyph = UInt16

public struct CGGradientDrawingOptions: OptionSet {
    public let rawValue: UInt32
    public init(rawValue: UInt32) { self.rawValue = rawValue }
    public static let drawsBeforeStartLocation = CGGradientDrawingOptions(rawValue: 1)
    public static let drawsAfterEndLocation = CGGradientDrawingOptions(rawValue: 2)
}

public class CGGradient {
    public init?(colorSpace space: CGColorSpace, colorComponents components: UnsafePointer<CGFloat>, locations: UnsafePointer<CGFloat>?, count: Int) { fatalError() }
    public init?(colorsSpace space: CGColorSpace?, colors: CFArray, locations: UnsafePointer<CGFloat>?) { fatalError() }
}

public class CGPath {
    public var isEmpty: Bool { fatalError() }
    public var boundingBox: CGRect { get { fatalError() } set { fatalError() } }
    public init() {}
    public func addRect(_ rect: CGRect, transform: UnsafePointer<CGAffineTransform>?) {}
    public func addEllipse(in rect: CGRect, transform: UnsafePointer<CGAffineTransform>?) {}
    public func move(to point: CGPoint, transform: UnsafePointer<CGAffineTransform>?) {}
    public func addLine(to point: CGPoint, transform: UnsafePointer<CGAffineTransform>?) {}
    public func copy() -> CGPath? { fatalError() }
}

public class CGMutablePath: CGPath {}

public struct CGAffineTransformIdentityProviderPlaceholder {}

// 常用全局绘图函数
public func CGContextFillRect(_ c: CGContext?, _ rect: CGRect) {}
public func CGContextStrokeRect(_ c: CGContext?, _ rect: CGRect) {}
public func CGContextClearRect(_ c: CGContext?, _ rect: CGRect) {}
public func CGContextSetFillColorWithColor(_ c: CGContext?, _ color: CGColor?) {}
public func CGContextSetStrokeColorWithColor(_ c: CGContext?, _ color: CGColor?) {}
public func CGContextSetLineWidth(_ c: CGContext?, _ width: CGFloat) {}
public func CGContextTranslateCTM(_ c: CGContext?, _ tx: CGFloat, _ ty: CGFloat) {}
public func CGContextScaleCTM(_ c: CGContext?, _ sx: CGFloat, _ sy: CGFloat) {}
public func CGContextSaveGState(_ c: CGContext?) {}
public func CGContextRestoreGState(_ c: CGContext?) {}
public func CGContextDrawImage(_ c: CGContext?, _ rect: CGRect, _ image: CGImage?) {}
public func CGColorSpaceCreateDeviceRGB() -> CGColorSpace! { CGColorSpace() }
public func CGColorSpaceCreateDeviceGray() -> CGColorSpace! { CGColorSpace() }
public func CGColorCreate(_ space: CGColorSpace?, _ components: UnsafePointer<CGFloat>?) -> CGColor? { nil }
public func CGBitmapContextCreate(_ data: UnsafeMutableRawPointer?, _ width: Int, _ height: Int, _ bitsPerComponent: Int, _ bytesPerRow: Int, _ space: CGColorSpace?, _ bitmapInfo: UInt32) -> CGContext? { nil }
public func CGBitmapContextGetData(_ c: CGContext?) -> UnsafeMutableRawPointer? { nil }
public func CGImageCreate(_ width: Int, _ height: Int, _ bitsPerComponent: Int, _ bitsPerPixel: Int, _ bytesPerRow: Int, _ space: CGColorSpace?, _ bitmapInfo: CGBitmapInfo, _ provider: CGDataProvider?, _ decode: UnsafePointer<CGFloat>?, _ shouldInterpolate: Bool, _ intent: CGColorRenderingIntent) -> CGImage? { nil }


// CoreGraphics 在 Swift overlay 里为 Int 提供了平行初始化器
// （`CGRect(x: 0, y: 0, width: w, height: h)` 里 w/h 是 Int 也能编过），
// 这里照实补上，否则会误报真实代码。
public extension CGPoint {
    init(x: Int, y: Int) { self.init(x: CGFloat(x), y: CGFloat(y)) }
}

public extension CGSize {
    init(width: Int, height: Int) { self.init(width: CGFloat(width), height: CGFloat(height)) }
}

public extension CGRect {
    init(x: Int, y: Int, width: Int, height: Int) {
        self.init(x: CGFloat(x), y: CGFloat(y), width: CGFloat(width), height: CGFloat(height))
    }
}

public extension CGVector {
    init(dx: Int, dy: Int) { self.init(dx: CGFloat(dx), dy: CGFloat(dy)) }
}
