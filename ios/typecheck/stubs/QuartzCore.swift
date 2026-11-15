// QuartzCore（CALayer / CAMetalLayer / 工具函数）的最小替身。
// CAMetalLayer 属于 QuartzCore，但用到了 Metal 的类型，这里只给签名。

public typealias CATimeInterval = Double

public func CACurrentMediaTime() -> CFTimeInterval { 0 }
public typealias CFTimeInterval = Double

open class CALayer: NSObject {
    public struct ContentsGravity: RawRepresentable {
        public var rawValue: String
        public init(rawValue: String) { self.rawValue = rawValue }
        public static let resize = ContentsGravity(rawValue: "resize")
        public static let resizeAspect = ContentsGravity(rawValue: "resizeAspect")
        public static let resizeAspectFill = ContentsGravity(rawValue: "resizeAspectFill")
        public static let center = ContentsGravity(rawValue: "center")
    }
    open var frame: CGRect { get { fatalError() } set { fatalError() } }
    open var bounds: CGRect { get { fatalError() } set { fatalError() } }
    open var position: CGPoint { get { fatalError() } set { fatalError() } }
    open var anchorPoint: CGPoint { get { fatalError() } set { fatalError() } }
    open var transform: CATransform3D { get { fatalError() } set { fatalError() } }
    open var isHidden: Bool { get { fatalError() } set { fatalError() } }
    open var opacity: Float { get { fatalError() } set { fatalError() } }
    open var backgroundColor: CGColor? { get { fatalError() } set { fatalError() } }
    open var cornerRadius: CGFloat { get { fatalError() } set { fatalError() } }
    open var borderWidth: CGFloat { get { fatalError() } set { fatalError() } }
    open var borderColor: CGColor? { get { fatalError() } set { fatalError() } }
    open var masksToBounds: Bool { get { fatalError() } set { fatalError() } }
    open var contents: Any? { get { fatalError() } set { fatalError() } }
    open var contentsGravity: ContentsGravity { get { fatalError() } set { fatalError() } }
    open var contentsScale: CGFloat { get { fatalError() } set { fatalError() } }
    open var isOpaque: Bool { get { fatalError() } set { fatalError() } }
    open var drawsAsynchronously: Bool { get { fatalError() } set { fatalError() } }
    open var allowsEdgeAntialiasing: Bool { get { fatalError() } set { fatalError() } }
    open var magnificationFilter: CALayerContentsFilter { get { fatalError() } set { fatalError() } }
    open var minificationFilter: CALayerContentsFilter { get { fatalError() } set { fatalError() } }
    open var sublayers: [CALayer]? { get { fatalError() } set { fatalError() } }
    open var superlayer: CALayer? { get { fatalError() } set { fatalError() } }
    open var delegate: CALayerDelegate? { get { fatalError() } set { fatalError() } }
    open var needsDisplayOnBoundsChange: Bool { get { fatalError() } set { fatalError() } }
    open var shadowOpacity: Float { get { fatalError() } set { fatalError() } }
    open var shadowColor: CGColor? { get { fatalError() } set { fatalError() } }
    open var shadowOffset: CGSize { get { fatalError() } set { fatalError() } }
    open var shadowRadius: CGFloat { get { fatalError() } set { fatalError() } }
    open var speed: Float { get { fatalError() } set { fatalError() } }
    open var edgeAntialiasingMask: UInt32 { get { fatalError() } set { fatalError() } }
    open func setNeedsDisplay() {}
    open func setNeedsLayout() {}
    open func display() {}
    open func layoutSublayers() {}
    open func addSublayer(_ layer: CALayer) {}
    open func removeFromSuperlayer() {}
    open func insertSublayer(_ layer: CALayer, at index: UInt32) {}
    open func insertSublayer(_ layer: CALayer, above sibling: CALayer?) {}
    open func insertSublayer(_ layer: CALayer, below sibling: CALayer?) {}
    open func render(in ctx: CGContext) {}
    open func presentation() -> CALayer? { fatalError() }
    open func model() -> CALayer { self }
    open class func animate(withDuration duration: TimeInterval, animations: () -> Void) {}
}

public protocol CALayerDelegate: AnyObject {
    func draw(_ layer: CALayer, in ctx: CGContext)
}

public struct CALayerContentsFilter: Hashable, RawRepresentable {
    public var rawValue: String
    public init(rawValue: String) { self.rawValue = rawValue }
    public static let nearest = CALayerContentsFilter(rawValue: "nearest")
    public static let linear = CALayerContentsFilter(rawValue: "linear")
    public static let trilinear = CALayerContentsFilter(rawValue: "trilinear")
}

public struct CATransform3D {
    public init() {}
    public static let identity = CATransform3D()
}

public class CATransaction: NSObject {
    public class func begin() {}
    public class func commit() {}
    public class func setDisableActions(_ flag: Bool) {}
    public class func setAnimationDuration(_ dur: CFTimeInterval) {}
}

public class CADisplayLink: NSObject {
    public var timestamp: CFTimeInterval { get { fatalError() } set { fatalError() } }
    public var duration: CFTimeInterval { get { fatalError() } set { fatalError() } }
    public var targetTimestamp: CFTimeInterval { get { fatalError() } set { fatalError() } }
    public var isPaused: Bool { get { fatalError() } set { fatalError() } }
    public var preferredFramesPerSecond: Int { get { fatalError() } set { fatalError() } }
    public class func displayLink(target: Any, selector: Selector) -> CADisplayLink { fatalError() }
    open func add(to runloop: RunLoop, forMode mode: RunLoop.Mode) {}
    open func remove(from runloop: RunLoop, forMode mode: RunLoop.Mode) {}
    open func invalidate() {}
}

// CAMetalLayer 提供了 Metal 绘制所需的 CAMetalLayer 接口
open class CAMetalLayer: CALayer {
    open var device: MTLDevice? { get { fatalError() } set { fatalError() } }
    open var pixelFormat: MTLPixelFormat { get { fatalError() } set { fatalError() } }
    open var framebufferOnly: Bool { get { fatalError() } set { fatalError() } }
    open var drawableSize: CGSize { get { fatalError() } set { fatalError() } }
    open var maximumDrawableCount: Int { get { fatalError() } set { fatalError() } }
    open var presentsWithTransaction: Bool { get { fatalError() } set { fatalError() } }
    open var allowsNextDrawableTimeout: Bool { get { fatalError() } set { fatalError() } }
    open var colorspace: CGColorSpace? { get { fatalError() } set { fatalError() } }
    open func nextDrawable() -> CAMetalDrawable? { fatalError() }
    open var displaySyncEnabled: Bool { get { fatalError() } set { fatalError() } }
}

public protocol CAMetalDrawable: MTLDrawable {
    var texture: MTLTexture { get }
}

