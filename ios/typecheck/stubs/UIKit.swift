// UIKit 的最小替身（含 CoreGraphics 里 UI 相关部分、QuartzCore 的少量项）。
// 只保证签名，实现一律 fatalError()。继承链按真实 UIKit 搭好，
// 否则子类的 override 会报错。

// MARK: - UIResponder / 事件

public enum UIKeyCommandInput {}

open class UIResponder: NSObject {
    open var next: UIResponder? { get { fatalError() } set { fatalError() } }
    open var canBecomeFirstResponder: Bool { get { fatalError() } set { fatalError() } }
    open var isFirstResponder: Bool { fatalError() }
    open func becomeFirstResponder() -> Bool { fatalError() }
    open func resignFirstResponder() -> Bool { fatalError() }
    open func touchesBegan(_ touches: Set<UITouch>, with event: UIEvent?) {}
    open func touchesMoved(_ touches: Set<UITouch>, with event: UIEvent?) {}
    open func touchesEnded(_ touches: Set<UITouch>, with event: UIEvent?) {}
    open func touchesCancelled(_ touches: Set<UITouch>, with event: UIEvent?) {}
    open func pressesBegan(_ presses: Set<UIPress>, with event: UIPressesEvent?) {}
    open func pressesEnded(_ presses: Set<UIPress>, with event: UIPressesEvent?) {}
    open func pressesChanged(_ presses: Set<UIPress>, with event: UIPressesEvent?) {}
    open func pressesCancelled(_ presses: Set<UIPress>, with event: UIPressesEvent?) {}
    open func motionBegan(_ motion: UIEvent.EventSubtype, with event: UIEvent?) {}
    open func motionEnded(_ motion: UIEvent.EventSubtype, with event: UIEvent?) {}
    open func motionCancelled(_ motion: UIEvent.EventSubtype, with event: UIEvent?) {}
}

open class UIEvent: NSObject {
    public enum EventType: Int { case touches = 0, motion = 1, remoteControl = 2, presses = 3 }
    public enum EventSubtype: Int { case none = 0, motionShake = 1, remoteControlPlay = 100 }
    open var type: EventType { get { fatalError() } set { fatalError() } }
    open var subtype: EventSubtype { get { fatalError() } set { fatalError() } }
    open var timestamp: TimeInterval { get { fatalError() } set { fatalError() } }
    open var allTouches: Set<UITouch>? { get { fatalError() } set { fatalError() } }
    open func touches(for window: UIWindow?) -> Set<UITouch>? { fatalError() }
}

open class UITouch: NSObject {
    public enum Phase: Int { case began = 0, moved = 1, stationary = 2, ended = 3, cancelled = 4, regionEntered = 5, regionMoved = 6, regionExited = 7 }
    public enum TouchType: Int { case direct = 0, indirectPointer = 1, pencil = 2, indirectPointer2 = 3 }
    open var phase: Phase { get { fatalError() } set { fatalError() } }
    open var tapCount: Int { get { fatalError() } set { fatalError() } }
    open var timestamp: TimeInterval { get { fatalError() } set { fatalError() } }
    open var view: UIView? { get { fatalError() } set { fatalError() } }
    open var window: UIWindow? { fatalError() }
    open var type: TouchType { get { fatalError() } set { fatalError() } }
    open var force: CGFloat { get { fatalError() } set { fatalError() } }
    open var maximumPossibleForce: CGFloat { get { fatalError() } set { fatalError() } }
    open var majorRadius: CGFloat { get { fatalError() } set { fatalError() } }
    open func location(in view: UIView?) -> CGPoint { fatalError() }
    open func previousLocation(in view: UIView?) -> CGPoint { fatalError() }
    open func preciseLocation(in view: UIView?) -> CGPoint { fatalError() }
}

open class UIPress: NSObject {
    open var key: UIKey? { get { fatalError() } set { fatalError() } }
    open var type: UIPress.PressType { get { fatalError() } set { fatalError() } }
    open var timestamp: TimeInterval { get { fatalError() } set { fatalError() } }
    public enum PressType: Int { case unknown = 0, playPause = 1, menu = 2 }
}

open class UIKey: NSObject, NSCopying {
    open var keyCode: UIKeyboardHIDUsage { get { fatalError() } set { fatalError() } }
    open var characters: String { get { fatalError() } set { fatalError() } }
    open var charactersIgnoringModifiers: String { get { fatalError() } set { fatalError() } }
    open var modifierFlags: UIKeyModifierFlags { get { fatalError() } set { fatalError() } }
    public func copy(with zone: NSZone?) -> Any { fatalError() }
}

public enum UIKeyboardHIDUsage: Int, Hashable {
    case keyboardErrorRollOver = 1
    case keyboardA = 4, keyboardB = 5, keyboardC = 6, keyboardD = 7, keyboardE = 8, keyboardF = 9
    case keyboardG = 10, keyboardH = 11, keyboardI = 12, keyboardJ = 13, keyboardK = 14, keyboardL = 15
    case keyboardM = 16, keyboardN = 17, keyboardO = 18, keyboardP = 19, keyboardQ = 20, keyboardR = 21
    case keyboardS = 22, keyboardT = 23, keyboardU = 24, keyboardV = 25, keyboardW = 26, keyboardX = 27
    case keyboardY = 28, keyboardZ = 29
    case keyboard1 = 30, keyboard2 = 31, keyboard3 = 32, keyboard4 = 33, keyboard5 = 34
    case keyboard6 = 35, keyboard7 = 36, keyboard8 = 37, keyboard9 = 38, keyboard0 = 39
    case keyboardReturnOrEnter = 40, keyboardEscape = 41, keyboardDeleteOrBackspace = 42, keyboardTab = 43
    case keyboardSpacebar = 44, keyboardHyphen = 45, keyboardEqualSign = 46, keyboardOpenBracket = 47
    case keyboardCloseBracket = 48, keyboardBackslash = 49, keyboardNonUSPound = 50, keyboardSemicolon = 51
    case keyboardQuote = 52, keyboardGraveAccentAndTilde = 53, keyboardComma = 54, keyboardPeriod = 55
    case keyboardSlash = 56, keyboardCapsLock = 57
    case keyboardF1 = 58, keyboardF2 = 59, keyboardF3 = 60, keyboardF4 = 61, keyboardF5 = 62, keyboardF6 = 63
    case keyboardF7 = 64, keyboardF8 = 65, keyboardF9 = 66, keyboardF10 = 67, keyboardF11 = 68, keyboardF12 = 69
    case keyboardPrintScreen = 70, keyboardScrollLock = 71, keyboardPause = 72, keyboardInsert = 73
    case keyboardHome = 74, keyboardPageUp = 75, keyboardDeleteForward = 76, keyboardEnd = 77
    case keyboardPageDown = 78, keyboardRightArrow = 79, keyboardLeftArrow = 80, keyboardDownArrow = 81
    case keyboardUpArrow = 82
    case keyboardLeftControl = 224, keyboardLeftShift = 225, keyboardLeftAlt = 226, keyboardLeftGUI = 227
    case keyboardRightControl = 228, keyboardRightShift = 229, keyboardRightAlt = 230, keyboardRightGUI = 231
}

public struct UIKeyModifierFlags: OptionSet, Hashable {
    public let rawValue: Int
    public init(rawValue: Int) { self.rawValue = rawValue }
    public static let alphaShift = UIKeyModifierFlags(rawValue: 1 << 16)
    public static let shift = UIKeyModifierFlags(rawValue: 1 << 17)
    public static let control = UIKeyModifierFlags(rawValue: 1 << 18)
    public static let alternate = UIKeyModifierFlags(rawValue: 1 << 19)
    public static let command = UIKeyModifierFlags(rawValue: 1 << 20)
    public static let numericPad = UIKeyModifierFlags(rawValue: 1 << 21)
}

open class UIPressesEvent: UIEvent {
    open var allPresses: Set<UIPress> { get { fatalError() } set { fatalError() } }
}

// MARK: - 颜色 / 字体 / 图片

open class UIColor: NSObject {
    open var cgColor: CGColor { get { fatalError() } set { fatalError() } }
    open var ciColor: AnyObject { get { fatalError() } set { fatalError() } }
    open func set() {}
    open func setFill() {}
    open func setStroke() {}
    open func getRed(_ red: UnsafeMutablePointer<CGFloat>?, green: UnsafeMutablePointer<CGFloat>?, blue: UnsafeMutablePointer<CGFloat>?, alpha: UnsafeMutablePointer<CGFloat>?) -> Bool { fatalError() }
    open func withAlphaComponent(_ alpha: CGFloat) -> UIColor { fatalError() }
    open var resolvedColorWithTraitCollection: (Any) -> UIColor { { _ in self } }

    public init(white: CGFloat, alpha: CGFloat) { super.init() }
    public init(red: CGFloat, green: CGFloat, blue: CGFloat, alpha: CGFloat) { super.init() }
    public init(hue: CGFloat, saturation: CGFloat, brightness: CGFloat, alpha: CGFloat) { super.init() }
    public init(cgColor: CGColor) { super.init() }
    public init(patternImage: UIImage) { super.init() }

    public static let clear = UIColor(white: 0, alpha: 0)
    public static let black = UIColor(white: 0, alpha: 1)
    public static let white = UIColor(white: 1, alpha: 1)
    public static let gray = UIColor(white: 0.5, alpha: 1)
    public static let red = UIColor(red: 1, green: 0, blue: 0, alpha: 1)
    public static let green = UIColor(red: 0, green: 1, blue: 0, alpha: 1)
    public static let blue = UIColor(red: 0, green: 0, blue: 1, alpha: 1)
    public static let yellow = UIColor(red: 1, green: 1, blue: 0, alpha: 1)
    public static let orange = UIColor(red: 1, green: 0.5, blue: 0, alpha: 1)
    public static let purple = UIColor(red: 0.5, green: 0, blue: 0.5, alpha: 1)
    public static let brown = UIColor(red: 0.6, green: 0.4, blue: 0.2, alpha: 1)
    public static let cyan = UIColor(red: 0, green: 1, blue: 1, alpha: 1)
    public static let magenta = UIColor(red: 1, green: 0, blue: 1, alpha: 1)
    public static let darkGray = UIColor(white: 0.33, alpha: 1)
    public static let lightGray = UIColor(white: 0.66, alpha: 1)
    public static let darkText = UIColor(white: 0, alpha: 1)
    public static let lightText = UIColor(white: 1, alpha: 1)
    public static let label = UIColor(white: 0, alpha: 1)
    public static let secondaryLabel = UIColor(white: 0.3, alpha: 1)
    public static let systemBackground = UIColor(white: 1, alpha: 1)
    public static let secondarySystemBackground = UIColor(white: 0.95, alpha: 1)
    public static let tertiarySystemBackground = UIColor(white: 0.9, alpha: 1)
    public static let systemGroupedBackground = UIColor(white: 0.95, alpha: 1)
    public static let systemBlue = UIColor(red: 0, green: 0.478, blue: 1, alpha: 1)
    public static let systemGreen = UIColor(red: 0.2, green: 0.78, blue: 0.35, alpha: 1)
    public static let systemRed = UIColor(red: 1, green: 0.23, blue: 0.19, alpha: 1)
    public static let systemOrange = UIColor(red: 1, green: 0.58, blue: 0, alpha: 1)
    public static let systemYellow = UIColor(red: 1, green: 0.8, blue: 0, alpha: 1)
    public static let systemGray = UIColor(white: 0.56, alpha: 1)
    public static let systemGray2 = UIColor(white: 0.68, alpha: 1)
    public static let systemGray3 = UIColor(white: 0.78, alpha: 1)
    public static let systemGray4 = UIColor(white: 0.82, alpha: 1)
    public static let systemGray5 = UIColor(white: 0.9, alpha: 1)
    public static let systemGray6 = UIColor(white: 0.95, alpha: 1)
    public static let separator = UIColor(white: 0.6, alpha: 1)
    public static let opaqueSeparator = UIColor(white: 0.8, alpha: 1)
}

public struct UIFontDescriptor: Hashable {
    public struct AttributeName: Hashable, RawRepresentable {
        public var rawValue: String
        public init(rawValue: String) { self.rawValue = rawValue }
        public static let name = AttributeName(rawValue: "NSFontNameAttribute")
        public static let size = AttributeName(rawValue: "NSFontSizeAttribute")
        public static let family = AttributeName(rawValue: "NSFontFamilyAttribute")
    }
    public init() {}
    public var familyName: String { get { fatalError() } set { fatalError() } }
    public var pointSize: CGFloat { get { fatalError() } set { fatalError() } }
    public func withSize(_ newSize: CGFloat) -> UIFontDescriptor { self }
}

open class UIFont: NSObject {
    public struct Weight: Hashable, RawRepresentable {
        public var rawValue: CGFloat
        public init(rawValue: CGFloat) { self.rawValue = rawValue }
        public static let ultraLight = Weight(rawValue: -0.8)
        public static let thin = Weight(rawValue: -0.6)
        public static let light = Weight(rawValue: -0.4)
        public static let regular = Weight(rawValue: 0)
        public static let medium = Weight(rawValue: 0.23)
        public static let semibold = Weight(rawValue: 0.3)
        public static let bold = Weight(rawValue: 0.4)
        public static let heavy = Weight(rawValue: 0.56)
        public static let black = Weight(rawValue: 0.62)
    }
    public struct TextStyle: Hashable, RawRepresentable {
        public var rawValue: String
        public init(rawValue: String) { self.rawValue = rawValue }
        public static let body = TextStyle(rawValue: "UICTFontTextStyleBody")
        public static let caption1 = TextStyle(rawValue: "UICTFontTextStyleCaption1")
        public static let caption2 = TextStyle(rawValue: "UICTFontTextStyleCaption2")
        public static let footnote = TextStyle(rawValue: "UICTFontTextStyleFootnote")
        public static let headline = TextStyle(rawValue: "UICTFontTextStyleHeadline")
        public static let subheadline = TextStyle(rawValue: "UICTFontTextStyleSubheadline")
        public static let title1 = TextStyle(rawValue: "UICTFontTextStyleTitle1")
        public static let title2 = TextStyle(rawValue: "UICTFontTextStyleTitle2")
        public static let title3 = TextStyle(rawValue: "UICTFontTextStyleTitle3")
    }
    open var pointSize: CGFloat { get { fatalError() } set { fatalError() } }
    open var familyName: String { get { fatalError() } set { fatalError() } }
    open var fontName: String { get { fatalError() } set { fatalError() } }
    open var lineHeight: CGFloat { get { fatalError() } set { fatalError() } }
    open var ascender: CGFloat { get { fatalError() } set { fatalError() } }
    open var descender: CGFloat { get { fatalError() } set { fatalError() } }
    open var capHeight: CGFloat { get { fatalError() } set { fatalError() } }
    open var xHeight: CGFloat { get { fatalError() } set { fatalError() } }
    open var fontDescriptor: UIFontDescriptor { get { fatalError() } set { fatalError() } }
    open func withSize(_ fontSize: CGFloat) -> UIFont { fatalError() }
    open class func systemFont(ofSize fontSize: CGFloat) -> UIFont { fatalError() }
    open class func systemFont(ofSize fontSize: CGFloat, weight: UIFont.Weight) -> UIFont { fatalError() }
    open class func boldSystemFont(ofSize fontSize: CGFloat) -> UIFont { fatalError() }
    open class func italicSystemFont(ofSize fontSize: CGFloat) -> UIFont { fatalError() }
    open class func monospacedSystemFont(ofSize fontSize: CGFloat, weight: UIFont.Weight) -> UIFont { fatalError() }
    open class func monospacedDigitSystemFont(ofSize fontSize: CGFloat, weight: UIFont.Weight) -> UIFont { fatalError() }
    open class func preferredFont(forTextStyle style: UIFont.TextStyle) -> UIFont { fatalError() }
    public init?(name fontName: String, size fontSize: CGFloat) { super.init() }
}

open class UIImage: NSObject {
    public struct RenderingMode: RawRepresentable, Hashable {
        public var rawValue: Int
        public init(rawValue: Int) { self.rawValue = rawValue }
        public static let automatic = RenderingMode(rawValue: 0)
        public static let alwaysOriginal = RenderingMode(rawValue: 1)
        public static let alwaysTemplate = RenderingMode(rawValue: 2)
    }
    public enum Orientation: Int { case up = 0, down = 1, left = 2, right = 3, upMirrored = 4 }
    public enum ResizingMode: Int { case tile = 0, stretch = 1 }
    open var size: CGSize { get { fatalError() } set { fatalError() } }
    open var scale: CGFloat { get { fatalError() } set { fatalError() } }
    open var cgImage: CGImage? { get { fatalError() } set { fatalError() } }
    open var imageOrientation: Orientation { get { fatalError() } set { fatalError() } }
    open var renderingMode: RenderingMode { get { fatalError() } set { fatalError() } }
    open var capInsets: UIEdgeInsets { get { fatalError() } set { fatalError() } }
    open var resizingMode: ResizingMode { get { fatalError() } set { fatalError() } }
    open var images: [UIImage]? { get { fatalError() } set { fatalError() } }
    open var duration: TimeInterval { get { fatalError() } set { fatalError() } }
    open var isSymbolImage: Bool { get { fatalError() } set { fatalError() } }

    public init?(named name: String) { super.init() }
    public init?(named name: String, in bundle: Bundle?, compatibleWith traitCollection: Any?) { super.init() }
    public init?(contentsOfFile path: String) { super.init() }
    public init(cgImage: CGImage) { super.init() }
    public init(cgImage: CGImage, scale: CGFloat, orientation: Orientation) { super.init() }
    public init?(data: Data) { super.init() }
    public init?(data: Data, scale: CGFloat) { super.init() }

    open func pngData() -> Data? { fatalError() }
    open func jpegData(compressionQuality quality: CGFloat) -> Data? { fatalError() }
    open func draw(in rect: CGRect) {}
    open func draw(at point: CGPoint) {}
    open func draw(at point: CGPoint, blendMode: CGBlendMode, alpha: CGFloat) {}
    open func draw(in rect: CGRect, blendMode: CGBlendMode, alpha: CGFloat) {}
    open func withRenderingMode(_ renderingMode: RenderingMode) -> UIImage { self }
    open func resizableImage(withCapInsets insets: UIEdgeInsets, resizingMode: ResizingMode = .tile) -> UIImage { self }
    open func imageFlippedForRightToLeftLayoutDirection() -> UIImage { self }
    open class func animatedImage(with images: [UIImage], duration: TimeInterval) -> UIImage? { fatalError() }
    open class func systemName(_ name: String) -> UIImage? { fatalError() }
    open class func systemName(_ name: String, withConfiguration configuration: Any?) -> UIImage? { fatalError() }
}

public func UIImagePNGRepresentation(_ image: UIImage) -> Data? { nil }
public func UIImageJPEGRepresentation(_ image: UIImage, _ quality: CGFloat) -> Data? { nil }
public func UIImageWriteToSavedPhotosAlbum(_ image: UIImage, _ target: Any?, _ selector: Selector?, _ context: UnsafeMutableRawPointer?) {}

public extension UIEdgeInsets {
    init(top: Int, left: Int, bottom: Int, right: Int) {
        self.init(top: CGFloat(top), left: CGFloat(left), bottom: CGFloat(bottom), right: CGFloat(right))
    }
}

public struct UIEdgeInsets: Equatable {
    public var top: CGFloat, left: CGFloat, bottom: CGFloat, right: CGFloat
    public init() { top = 0; left = 0; bottom = 0; right = 0 }
    public init(top: CGFloat, left: CGFloat, bottom: CGFloat, right: CGFloat) {
        self.top = top; self.left = left; self.bottom = bottom; self.right = right
    }
    public static let zero = UIEdgeInsets()
}

public struct NSDirectionalEdgeInsets: Equatable {
    public var top: CGFloat, leading: CGFloat, bottom: CGFloat, trailing: CGFloat
    public init(top: CGFloat, leading: CGFloat, bottom: CGFloat, trailing: CGFloat) {
        self.top = top; self.leading = leading; self.bottom = bottom; self.trailing = trailing
    }
}

public class NSMutableParagraphStyle: NSObject {
    public enum Alignment: Int { case left = 0, center = 1, right = 2, justified = 3, natural = 4 }
    public enum LineBreakMode: Int {
        case byWordWrapping = 0, byCharWrapping = 1, byClipping = 2, byTruncatingHead = 3
        case byTruncatingTail = 4, byTruncatingMiddle = 5
    }
    public var alignment: Alignment = .natural
    public var lineBreakMode: LineBreakMode = .byWordWrapping
    public var lineSpacing: CGFloat = 0
    public var paragraphSpacing: CGFloat = 0
    public var minimumLineHeight: CGFloat = 0
    public var maximumLineHeight: CGFloat = 0
    public var firstLineHeadIndent: CGFloat = 0
    public var headIndent: CGFloat = 0
    public override init() { super.init() }
}

public class NSParagraphStyle: NSObject {
    public var alignment: NSMutableParagraphStyle.Alignment { get { fatalError() } set { fatalError() } }
    public var lineBreakMode: NSMutableParagraphStyle.LineBreakMode { get { fatalError() } set { fatalError() } }
}

public struct NSStringDrawingOptions: OptionSet {
    public let rawValue: Int
    public init(rawValue: Int) { self.rawValue = rawValue }
    public static let usesLineFragmentOrigin = NSStringDrawingOptions(rawValue: 1)
    public static let usesFontLeading = NSStringDrawingOptions(rawValue: 2)
    public static let usesDeviceMetrics = NSStringDrawingOptions(rawValue: 8)
    public static let truncatesLastVisibleLine = NSStringDrawingOptions(rawValue: 32)
}

public struct NSStringDrawingContext {}

// MARK: - 手势

open class UIGestureRecognizer: NSObject {
    public enum State: Int { case possible = 0, began = 1, changed = 2, ended = 3, cancelled = 4, failed = 5 }
    open var state: State { fatalError() }
    open var view: UIView? { get { fatalError() } set { fatalError() } }
    open var isEnabled: Bool { get { fatalError() } set { fatalError() } }
    open var cancelsTouchesInView: Bool { get { fatalError() } set { fatalError() } }
    open var delaysTouchesBegan: Bool { get { fatalError() } set { fatalError() } }
    open var delaysTouchesEnded: Bool { get { fatalError() } set { fatalError() } }
    open var delegate: UIGestureRecognizerDelegate? { get { fatalError() } set { fatalError() } }
    open func location(in view: UIView?) -> CGPoint { fatalError() }
    open func require(toFail other: UIGestureRecognizer) {}
    open func addTarget(_ target: Any, action: Selector) {}
    open func removeTarget(_ target: Any?, action: Selector?) {}
    open func reset() {}
}

public protocol UIGestureRecognizerDelegate: AnyObject {
    func gestureRecognizerShouldBegin(_ gestureRecognizer: UIGestureRecognizer) -> Bool
}

open class UITapGestureRecognizer: UIGestureRecognizer {
    open var numberOfTapsRequired: Int { get { fatalError() } set { fatalError() } }
    open var numberOfTouchesRequired: Int { get { fatalError() } set { fatalError() } }
    public init(target: Any?, action: Selector?) { super.init() }
    public override init() { super.init() }
}

open class UIPinchGestureRecognizer: UIGestureRecognizer {
    open var scale: CGFloat { get { fatalError() } set { fatalError() } }
    open var velocity: CGFloat { get { fatalError() } set { fatalError() } }
    public init(target: Any?, action: Selector?) { super.init() }
    public override init() { super.init() }
}

open class UIPanGestureRecognizer: UIGestureRecognizer {
    open var minimumNumberOfTouches: Int { get { fatalError() } set { fatalError() } }
    open var maximumNumberOfTouches: Int { get { fatalError() } set { fatalError() } }
    open func translation(in view: UIView?) -> CGPoint { fatalError() }
    open func velocity(in view: UIView?) -> CGPoint { fatalError() }
    open func setTranslation(_ translation: CGPoint, in view: UIView?) {}
    public init(target: Any?, action: Selector?) { super.init() }
    public override init() { super.init() }
}

open class UILongPressGestureRecognizer: UIGestureRecognizer {
    open var minimumPressDuration: TimeInterval { get { fatalError() } set { fatalError() } }
    open var numberOfTouchesRequired: Int { get { fatalError() } set { fatalError() } }
    open var allowableMovement: CGFloat { get { fatalError() } set { fatalError() } }
    public init(target: Any?, action: Selector?) { super.init() }
    public override init() { super.init() }
}

open class UISwipeGestureRecognizer: UIGestureRecognizer {
    public struct Direction: OptionSet {
        public let rawValue: UInt
        public init(rawValue: UInt) { self.rawValue = rawValue }
        public static let right = Direction(rawValue: 1)
        public static let left = Direction(rawValue: 2)
        public static let up = Direction(rawValue: 4)
        public static let down = Direction(rawValue: 8)
    }
    open var direction: Direction { get { fatalError() } set { fatalError() } }
    open var numberOfTouchesRequired: Int { get { fatalError() } set { fatalError() } }
    public init(target: Any?, action: Selector?) { super.init() }
    public override init() { super.init() }
}

open class UIScreenEdgePanGestureRecognizer: UIPanGestureRecognizer {}

// MARK: - 视图

open class UIView: UIResponder {
    public struct AnimationOptions: OptionSet {
        public let rawValue: UInt
        public init(rawValue: UInt) { self.rawValue = rawValue }
        public static let layoutSubviews = AnimationOptions(rawValue: 1)
        public static let allowUserInteraction = AnimationOptions(rawValue: 1 << 1)
        public static let beginFromCurrentState = AnimationOptions(rawValue: 1 << 2)
        public static let repeat1 = AnimationOptions(rawValue: 1 << 3)
        public static let autoreverse = AnimationOptions(rawValue: 1 << 4)
        public static let `overrideInheritedDuration` = AnimationOptions(rawValue: 1 << 5)
        public static let overrideInheritedCurve = AnimationOptions(rawValue: 1 << 6)
        public static let allowAnimatedContent = AnimationOptions(rawValue: 1 << 7)
        public static let showHideTransitionViews = AnimationOptions(rawValue: 1 << 8)
        public static let overrideInheritedOptions = AnimationOptions(rawValue: 1 << 9)
        public static let curveEaseInOut = AnimationOptions(rawValue: 0 << 16)
        public static let curveEaseIn = AnimationOptions(rawValue: 1 << 16)
        public static let curveEaseOut = AnimationOptions(rawValue: 2 << 16)
        public static let curveLinear = AnimationOptions(rawValue: 3 << 16)
    }

    public struct AnimationTransition: RawRepresentable {
        public var rawValue: Int
        public init(rawValue: Int) { self.rawValue = rawValue }
        public static let none = AnimationTransition(rawValue: 0)
        public static let flipFromLeft = AnimationTransition(rawValue: 1)
        public static let flipFromRight = AnimationTransition(rawValue: 2)
        public static let curlUp = AnimationTransition(rawValue: 3)
        public static let curlDown = AnimationTransition(rawValue: 4)
    }

    public enum ContentMode: Int {
        case scaleToFill = 0, scaleAspectFit, scaleAspectFill, redraw
        case center, top, bottom, left, right, topLeft, topRight, bottomLeft, bottomRight
    }

    public enum TintAdjustmentMode: Int { case automatic, normal, dimmed }

    public struct AutoresizingMask: OptionSet {
        public let rawValue: UInt
        public init(rawValue: UInt) { self.rawValue = rawValue }
        public static let none = AutoresizingMask(rawValue: 0)
        public static let flexibleLeftMargin = AutoresizingMask(rawValue: 1)
        public static let flexibleWidth = AutoresizingMask(rawValue: 2)
        public static let flexibleRightMargin = AutoresizingMask(rawValue: 4)
        public static let flexibleTopMargin = AutoresizingMask(rawValue: 8)
        public static let flexibleHeight = AutoresizingMask(rawValue: 16)
        public static let flexibleBottomMargin = AutoresizingMask(rawValue: 32)
    }

    open var frame: CGRect { get { fatalError() } set { fatalError() } }
    open var bounds: CGRect { get { fatalError() } set { fatalError() } }
    open var center: CGPoint { get { fatalError() } set { fatalError() } }
    open var transform: CGAffineTransform { get { fatalError() } set { fatalError() } }
    open var transform3D: Any? { get { fatalError() } set { fatalError() } }
    open var contentScaleFactor: CGFloat { get { fatalError() } set { fatalError() } }
    open var isMultipleTouchEnabled: Bool { get { fatalError() } set { fatalError() } }
    open var isExclusiveTouch: Bool { get { fatalError() } set { fatalError() } }
    open var clipsToBounds: Bool { get { fatalError() } set { fatalError() } }
    open var backgroundColor: UIColor? { get { fatalError() } set { fatalError() } }
    open var alpha: CGFloat { get { fatalError() } set { fatalError() } }
    open var isOpaque: Bool { get { fatalError() } set { fatalError() } }
    open var isHidden: Bool { get { fatalError() } set { fatalError() } }
    open var clearsContextBeforeDrawing: Bool { get { fatalError() } set { fatalError() } }
    open var isUserInteractionEnabled: Bool { get { fatalError() } set { fatalError() } }
    open var contentMode: ContentMode { get { fatalError() } set { fatalError() } }
    open var tag: Int { get { fatalError() } set { fatalError() } }
    open var layer: CALayer { fatalError() }
    open class var layerClass: AnyClass { fatalError() }
    open var tintColor: UIColor! { get { fatalError() } set { fatalError() } }
    open var tintAdjustmentMode: TintAdjustmentMode { get { fatalError() } set { fatalError() } }
    open var gestureRecognizers: [UIGestureRecognizer]? { get { fatalError() } set { fatalError() } }
    open var autoresizingMask: AutoresizingMask { get { fatalError() } set { fatalError() } }
    open var translatesAutoresizingMaskIntoConstraints: Bool { get { fatalError() } set { fatalError() } }
    open var superview: UIView? { fatalError() }
    open var subviews: [UIView] { fatalError() }
    open var window: UIWindow? { fatalError() }
    open var safeAreaInsets: UIEdgeInsets { get { fatalError() } set { fatalError() } }
    open var safeAreaLayoutGuide: UILayoutGuide { get { fatalError() } set { fatalError() } }
    open var layoutMargins: UIEdgeInsets { get { fatalError() } set { fatalError() } }
    open var preservesSuperviewLayoutMargins: Bool { get { fatalError() } set { fatalError() } }
    open var semanticContentAttribute: UISemanticContentAttribute { get { fatalError() } set { fatalError() } }
    open var effectiveUserInterfaceLayoutDirection: UIUserInterfaceLayoutDirection { get { fatalError() } set { fatalError() } }
    open var overrideUserInterfaceStyle: UIUserInterfaceStyle { get { fatalError() } set { fatalError() } }
    open var traitCollection: UITraitCollection { fatalError() }
    open var restorationIdentifier: String? { get { fatalError() } set { fatalError() } }
    open var isFocused: Bool { get { fatalError() } set { fatalError() } }
    open var canBecomeFocused: Bool { get { fatalError() } set { fatalError() } }
    open var isAccessibilityElement: Bool { get { fatalError() } set { fatalError() } }
    open var accessibilityLabel: String? { get { fatalError() } set { fatalError() } }
    open var accessibilityHint: String? { get { fatalError() } set { fatalError() } }
    open var accessibilityIdentifier: String? { get { fatalError() } set { fatalError() } }
    open var accessibilityValue: String? { get { fatalError() } set { fatalError() } }
    open var accessibilityTraits: UIAccessibilityTraits { get { fatalError() } set { fatalError() } }
    open var mask: UIView? { get { fatalError() } set { fatalError() } }

    public init(frame: CGRect) { super.init() }
    public required init?(coder: NSCoder) { super.init() }
    // 真实 UIKit 里 UIView() 对子类也永远可用（ObjC 初始化器继承）。
    // 这里用 convenience init 复现：只要子类实现了全部指定初始化器就会继承它。
    public override convenience init() { self.init(frame: .zero) }

    open func layoutSubviews() {}
    open func layoutIfNeeded() {}
    open func setNeedsLayout() {}
    open func setNeedsDisplay() {}
    open func setNeedsDisplay(_ rect: CGRect) {}
    open func draw(_ rect: CGRect) {}
    open func drawRect(_ rect: CGRect) {}
    open func addSubview(_ view: UIView) {}
    open func insertSubview(_ view: UIView, at index: Int) {}
    open func insertSubview(_ view: UIView, aboveSubview siblingSubview: UIView) {}
    open func insertSubview(_ view: UIView, belowSubview siblingSubview: UIView) {}
    open func bringSubviewToFront(_ view: UIView) {}
    open func sendSubviewToBack(_ view: UIView) {}
    open func removeFromSuperview() {}
    open func exchangeSubview(at index1: Int, withSubviewAt index2: Int) {}
    open func willMove(toSuperview newSuperview: UIView?) {}
    open func didMoveToSuperview() {}
    open func willMove(toWindow newWindow: UIWindow?) {}
    open func didMoveToWindow() {}
    open func didAddSubview(_ subview: UIView) {}
    open func layoutMarginsDidChange() {}
    open func safeAreaInsetsDidChange() {}
    open func convert(_ point: CGPoint, to view: UIView?) -> CGPoint { fatalError() }
    open func convert(_ point: CGPoint, from view: UIView?) -> CGPoint { fatalError() }
    open func convert(_ rect: CGRect, to view: UIView?) -> CGRect { fatalError() }
    open func convert(_ rect: CGRect, from view: UIView?) -> CGRect { fatalError() }
    open func hitTest(_ point: CGPoint, with event: UIEvent?) -> UIView? { fatalError() }
    open func point(inside point: CGPoint, with event: UIEvent?) -> Bool { fatalError() }
    open func sizeThatFits(_ size: CGSize) -> CGSize { fatalError() }
    open func sizeToFit() {}
    open func systemLayoutSizeFitting(_ targetSize: CGSize) -> CGSize { fatalError() }
    open func systemLayoutSizeFitting(_ targetSize: CGSize, withHorizontalFittingPriority horizontalFittingPriority: UILayoutPriority, verticalFittingPriority: UILayoutPriority) -> CGSize { fatalError() }
    open func addGestureRecognizer(_ gestureRecognizer: UIGestureRecognizer) {}
    open func removeGestureRecognizer(_ gestureRecognizer: UIGestureRecognizer) {}
    open func addConstraint(_ constraint: NSLayoutConstraint) {}
    open func addConstraints(_ constraints: [NSLayoutConstraint]) {}
    open func removeConstraint(_ constraint: NSLayoutConstraint) {}
    open func removeConstraints(_ constraints: [NSLayoutConstraint]) {}
    open var constraints: [NSLayoutConstraint] { get { fatalError() } set { fatalError() } }
    open func setContentHuggingPriority(_ priority: UILayoutPriority, for axis: NSLayoutConstraint.Axis) {}
    open func setContentCompressionResistancePriority(_ priority: UILayoutPriority, for axis: NSLayoutConstraint.Axis) {}
    open func invalidateIntrinsicContentSize() {}
    open var intrinsicContentSize: CGSize { get { fatalError() } set { fatalError() } }
    open func snapshotView(afterScreenUpdates afterUpdates: Bool) -> UIView? { fatalError() }
    open func drawHierarchy(in rect: CGRect, afterScreenUpdates afterUpdates: Bool) -> Bool { fatalError() }
    open var hasAmbiguousLayout: Bool { get { fatalError() } set { fatalError() } }
    open func exerciseAmbiguityInLayout() {}

    open class func animate(withDuration duration: TimeInterval, animations: @escaping () -> Void) {}
    open class func animate(withDuration duration: TimeInterval, animations: @escaping () -> Void, completion: ((Bool) -> Void)? = nil) {}
    open class func animate(withDuration duration: TimeInterval, delay: TimeInterval, options: AnimationOptions, animations: @escaping () -> Void, completion: ((Bool) -> Void)? = nil) {}
    open class func animateKeyframes(withDuration duration: TimeInterval, delay: TimeInterval, options: AnimationOptions, animations: @escaping () -> Void, completion: ((Bool) -> Void)? = nil) {}
    open class func addKeyframe(withRelativeStartTime frameStartTime: Double, relativeDuration frameDuration: Double, animations: @escaping () -> Void) {}
    open class func transition(with view: UIView, duration: TimeInterval, options: AnimationOptions, animations: (() -> Void)?, completion: ((Bool) -> Void)? = nil) {}
    open class func transition(from fromView: UIView, to toView: UIView, duration: TimeInterval, options: AnimationOptions, completion: ((Bool) -> Void)? = nil) {}
    open class func performWithoutAnimation(_ actionsWithoutAnimation: () -> Void) {}
    open class func animate(withSpringDuration duration: TimeInterval, animations: @escaping () -> Void) {}
}

public struct UILayoutPriority: Hashable, RawRepresentable, ExpressibleByFloatLiteral {
    public var rawValue: Float
    public init(rawValue: Float) { self.rawValue = rawValue }
    public init(floatLiteral value: Float) { rawValue = value }
    public static let required = UILayoutPriority(rawValue: 1000)
    public static let defaultHigh = UILayoutPriority(rawValue: 750)
    public static let defaultLow = UILayoutPriority(rawValue: 250)
    public static let fittingSizeLevel = UILayoutPriority(rawValue: 50)
}

open class UILayoutGuide: NSObject {
    open var layoutFrame: CGRect { get { fatalError() } set { fatalError() } }
    open var owningView: UIView? { get { fatalError() } set { fatalError() } }
    open var identifier: String { get { fatalError() } set { fatalError() } }
    open var leadingAnchor: NSLayoutXAxisAnchor { get { fatalError() } set { fatalError() } }
    open var trailingAnchor: NSLayoutXAxisAnchor { get { fatalError() } set { fatalError() } }
    open var leftAnchor: NSLayoutXAxisAnchor { get { fatalError() } set { fatalError() } }
    open var rightAnchor: NSLayoutXAxisAnchor { get { fatalError() } set { fatalError() } }
    open var topAnchor: NSLayoutYAxisAnchor { get { fatalError() } set { fatalError() } }
    open var bottomAnchor: NSLayoutYAxisAnchor { get { fatalError() } set { fatalError() } }
    open var widthAnchor: NSLayoutDimension { get { fatalError() } set { fatalError() } }
    open var heightAnchor: NSLayoutDimension { get { fatalError() } set { fatalError() } }
    open var centerXAnchor: NSLayoutXAxisAnchor { get { fatalError() } set { fatalError() } }
    open var centerYAnchor: NSLayoutYAxisAnchor { get { fatalError() } set { fatalError() } }
}

public enum UISemanticContentAttribute: Int { case unspecified = 0, playback, spatial, forceLeftToRight, forceRightToLeft }
public enum UIUserInterfaceLayoutDirection: Int { case leftToRight = 0, rightToLeft = 1 }
public enum UIUserInterfaceStyle: Int { case unspecified = 0, light = 1, dark = 2 }
public enum UIUserInterfaceIdiom: Int { case unspecified = -1, phone = 0, pad = 1, tv = 2, carPlay = 3, mac = 5, vision = 6 }

public struct UIAccessibilityTraits: OptionSet {
    public let rawValue: UInt64
    public init(rawValue: UInt64) { self.rawValue = rawValue }
    public static let none = UIAccessibilityTraits(rawValue: 0)
    public static let button = UIAccessibilityTraits(rawValue: 1)
    public static let image = UIAccessibilityTraits(rawValue: 1 << 1)
    public static let selected = UIAccessibilityTraits(rawValue: 1 << 2)
}

open class UITraitCollection: NSObject {
    open var userInterfaceIdiom: UIUserInterfaceIdiom { get { fatalError() } set { fatalError() } }
    open var userInterfaceStyle: UIUserInterfaceStyle { get { fatalError() } set { fatalError() } }
    open var displayScale: CGFloat { get { fatalError() } set { fatalError() } }
    open var horizontalSizeClass: UIUserInterfaceSizeClass { get { fatalError() } set { fatalError() } }
    open var verticalSizeClass: UIUserInterfaceSizeClass { get { fatalError() } set { fatalError() } }
    open var hasDifferentColorAppearance: (UITraitCollection) -> Bool { { _ in false } }
    open func hasDifferentColorAppearance(comparedTo traitCollection: UITraitCollection?) -> Bool { false }
}

public enum UIUserInterfaceSizeClass: Int { case unspecified = 0, compact = 1, regular = 2 }

// MARK: - 自动布局约束

open class NSLayoutConstraint: NSObject {
    public enum Axis: Int { case horizontal = 0, vertical = 1 }
    public struct Relation: RawRepresentable {
        public var rawValue: Int
        public init(rawValue: Int) { self.rawValue = rawValue }
        public static let lessThanOrEqual = Relation(rawValue: -1)
        public static let equal = Relation(rawValue: 0)
        public static let greaterThanOrEqual = Relation(rawValue: 1)
    }
    public struct Attribute: RawRepresentable {
        public var rawValue: Int
        public init(rawValue: Int) { self.rawValue = rawValue }
        public static let left = Attribute(rawValue: 1)
        public static let right = Attribute(rawValue: 2)
        public static let top = Attribute(rawValue: 3)
        public static let bottom = Attribute(rawValue: 4)
        public static let leading = Attribute(rawValue: 5)
        public static let trailing = Attribute(rawValue: 6)
        public static let width = Attribute(rawValue: 7)
        public static let height = Attribute(rawValue: 8)
        public static let centerX = Attribute(rawValue: 9)
        public static let centerY = Attribute(rawValue: 10)
        public static let notAnAttribute = Attribute(rawValue: 0)
    }
    public enum Orientation: Int { case horizontal = 0, vertical = 1 }
    open var isActive: Bool { get { fatalError() } set { fatalError() } }
    open var constant: CGFloat { get { fatalError() } set { fatalError() } }
    open var multiplier: CGFloat { get { fatalError() } set { fatalError() } }
    open var priority: UILayoutPriority { get { fatalError() } set { fatalError() } }
    open var firstItem: AnyObject? { fatalError() }
    open var secondItem: AnyObject? { fatalError() }
    open var identifier: String? { get { fatalError() } set { fatalError() } }
    public init(item view1: Any, attribute attr1: Attribute, relatedBy relation: Relation, toItem view2: Any?, attribute attr2: Attribute, multiplier: CGFloat, constant c: CGFloat) { super.init() }
    open class func activate(_ constraints: [NSLayoutConstraint]) {}
    open class func deactivate(_ constraints: [NSLayoutConstraint]) {}
}

open class NSLayoutAnchor<AnchorType: AnyObject>: NSObject {
    open func constraint(equalTo anchor: NSLayoutAnchor<AnchorType>) -> NSLayoutConstraint { fatalError() }
    open func constraint(equalTo anchor: NSLayoutAnchor<AnchorType>, constant c: CGFloat) -> NSLayoutConstraint { fatalError() }
    open func constraint(greaterThanOrEqualTo anchor: NSLayoutAnchor<AnchorType>) -> NSLayoutConstraint { fatalError() }
    open func constraint(greaterThanOrEqualTo anchor: NSLayoutAnchor<AnchorType>, constant c: CGFloat) -> NSLayoutConstraint { fatalError() }
    open func constraint(lessThanOrEqualTo anchor: NSLayoutAnchor<AnchorType>) -> NSLayoutConstraint { fatalError() }
    open func constraint(lessThanOrEqualTo anchor: NSLayoutAnchor<AnchorType>, constant c: CGFloat) -> NSLayoutConstraint { fatalError() }
}

open class NSLayoutXAxisAnchor: NSLayoutAnchor<NSLayoutXAxisAnchor> {
    open func constraint(equalToSystemSpacingAfter anchor: NSLayoutXAxisAnchor, multiplier: CGFloat) -> NSLayoutConstraint { fatalError() }
    open func anchorWithOffset(to otherAnchor: NSLayoutXAxisAnchor) -> NSLayoutDimension { fatalError() }
}
open class NSLayoutYAxisAnchor: NSLayoutAnchor<NSLayoutYAxisAnchor> {
    open func constraint(equalToSystemSpacingBelow anchor: NSLayoutYAxisAnchor, multiplier: CGFloat) -> NSLayoutConstraint { fatalError() }
    open func anchorWithOffset(to otherAnchor: NSLayoutYAxisAnchor) -> NSLayoutDimension { fatalError() }
}
open class NSLayoutDimension: NSLayoutAnchor<NSLayoutDimension> {
    open func constraint(equalToConstant c: CGFloat) -> NSLayoutConstraint { fatalError() }
    open func constraint(greaterThanOrEqualToConstant c: CGFloat) -> NSLayoutConstraint { fatalError() }
    open func constraint(lessThanOrEqualToConstant c: CGFloat) -> NSLayoutConstraint { fatalError() }
    open func constraint(equalTo anchor: NSLayoutDimension, multiplier m: CGFloat) -> NSLayoutConstraint { fatalError() }
    open func constraint(equalTo anchor: NSLayoutDimension, multiplier m: CGFloat, constant c: CGFloat) -> NSLayoutConstraint { fatalError() }
}

public extension UIView {
    var leadingAnchor: NSLayoutXAxisAnchor { fatalError() }
    var trailingAnchor: NSLayoutXAxisAnchor { fatalError() }
    var leftAnchor: NSLayoutXAxisAnchor { fatalError() }
    var rightAnchor: NSLayoutXAxisAnchor { fatalError() }
    var topAnchor: NSLayoutYAxisAnchor { fatalError() }
    var bottomAnchor: NSLayoutYAxisAnchor { fatalError() }
    var widthAnchor: NSLayoutDimension { fatalError() }
    var heightAnchor: NSLayoutDimension { fatalError() }
    var centerXAnchor: NSLayoutXAxisAnchor { fatalError() }
    var centerYAnchor: NSLayoutYAxisAnchor { fatalError() }
    var firstBaselineAnchor: NSLayoutYAxisAnchor { fatalError() }
    var lastBaselineAnchor: NSLayoutYAxisAnchor { fatalError() }
}

public struct UILayoutGuideGroup {}

// MARK: - 控件

open class UIControl: UIView {
    public struct State: OptionSet, Hashable {
        public let rawValue: UInt
        public init(rawValue: UInt) { self.rawValue = rawValue }
        public static let normal = State(rawValue: 0)
        public static let highlighted = State(rawValue: 1)
        public static let disabled = State(rawValue: 2)
        public static let selected = State(rawValue: 4)
        public static let focused = State(rawValue: 8)
        public static let application = State(rawValue: 1 << 24)
        public static let reserved = State(rawValue: 1 << 25)
    }
    public struct Event: OptionSet, Hashable {
        public let rawValue: UInt
        public init(rawValue: UInt) { self.rawValue = rawValue }
        public static let touchDown = Event(rawValue: 1 << 0)
        public static let touchDownRepeat = Event(rawValue: 1 << 1)
        public static let touchDragInside = Event(rawValue: 1 << 2)
        public static let touchDragOutside = Event(rawValue: 1 << 3)
        public static let touchDragEnter = Event(rawValue: 1 << 4)
        public static let touchDragExit = Event(rawValue: 1 << 5)
        public static let touchUpInside = Event(rawValue: 1 << 6)
        public static let touchUpOutside = Event(rawValue: 1 << 7)
        public static let touchCancel = Event(rawValue: 1 << 8)
        public static let valueChanged = Event(rawValue: 1 << 12)
        public static let primaryActionTriggered = Event(rawValue: 1 << 13)
        public static let menuActionTriggered = Event(rawValue: 1 << 14)
        public static let editingDidBegin = Event(rawValue: 1 << 16)
        public static let editingChanged = Event(rawValue: 1 << 17)
        public static let editingDidEnd = Event(rawValue: 1 << 18)
        public static let editingDidEndOnExit = Event(rawValue: 1 << 19)
        public static let allTouchEvents = Event(rawValue: 0x00000FFF)
        public static let allEditingEvents = Event(rawValue: 0x000F0000)
        public static let applicationReserved = Event(rawValue: 0x0F000000)
        public static let systemReserved = Event(rawValue: 0xF0000000)
        public static let allEvents = Event(rawValue: 0xFFFFFFFF)
    }
    public enum ContentVerticalAlignment: Int { case center, top, bottom, fill }
    public enum ContentHorizontalAlignment: Int { case center, left, right, fill, leading, trailing }
    open var isEnabled: Bool { get { fatalError() } set { fatalError() } }
    open var isSelected: Bool { get { fatalError() } set { fatalError() } }
    open var isHighlighted: Bool { get { fatalError() } set { fatalError() } }
    open var contentVerticalAlignment: ContentVerticalAlignment { get { fatalError() } set { fatalError() } }
    open var contentEdgeInsets: UIEdgeInsets { get { fatalError() } set { fatalError() } }
    open var contentHorizontalAlignment: ContentHorizontalAlignment { get { fatalError() } set { fatalError() } }
    open var state: State { fatalError() }
    open var isTracking: Bool { get { fatalError() } set { fatalError() } }
    open var isTouchInside: Bool { get { fatalError() } set { fatalError() } }
    open func addTarget(_ target: Any?, action: Selector, for controlEvents: Event) {}
    open func removeTarget(_ target: Any?, action: Selector?, for controlEvents: Event) {}
    open func sendAction(_ action: Selector, to target: Any?, for event: UIEvent?) {}
    open func sendActions(for controlEvents: Event) {}
    open func addAction(_ action: UIAction, for controlEvents: Event) {}
    open func removeAction(identifiedBy actionIdentifier: UIAction.Identifier, for controlEvents: Event) {}
    open func beginTracking(_ touch: UITouch, with event: UIEvent?) -> Bool { fatalError() }
    open func endTracking(_ touch: UITouch?, with event: UIEvent?) {}
    open func continueTracking(_ touch: UITouch, with event: UIEvent?) -> Bool { false }
    open func cancelTracking(with event: UIEvent?) {}
}

open class UILabel: UIView {
    open var text: String? { get { fatalError() } set { fatalError() } }
    open var attributedText: NSAttributedString? { get { fatalError() } set { fatalError() } }
    open var font: UIFont! { get { fatalError() } set { fatalError() } }
    open var textColor: UIColor! { get { fatalError() } set { fatalError() } }
    open var textAlignment: NSTextAlignment { get { fatalError() } set { fatalError() } }
    open var numberOfLines: Int { get { fatalError() } set { fatalError() } }
    open var lineBreakMode: NSMutableParagraphStyle.LineBreakMode { get { fatalError() } set { fatalError() } }
    open var adjustsFontSizeToFitWidth: Bool { get { fatalError() } set { fatalError() } }
    open var minimumScaleFactor: CGFloat { get { fatalError() } set { fatalError() } }
    open var baselineAdjustment: UIBaselineAdjustment { get { fatalError() } set { fatalError() } }
    open var shadowColor: UIColor? { get { fatalError() } set { fatalError() } }
    open var shadowOffset: CGSize { get { fatalError() } set { fatalError() } }
    open var isUserInteractionEnabledLabel: Bool { get { fatalError() } set { fatalError() } }
    open var preferredMaxLayoutWidth: CGFloat { get { fatalError() } set { fatalError() } }
    open var allowsDefaultTighteningForTruncation: Bool { get { fatalError() } set { fatalError() } }
    open var lineBreakStrategy: Any { get { fatalError() } set { fatalError() } }
}

public enum NSTextAlignment: Int { case left = 0, center = 1, right = 2, justified = 3, natural = 4 }
public enum UIBaselineAdjustment: Int { case alignBaselines = 0, alignCenters = 1, none = 2 }
public enum NSLineBreakMode: Int { case byWordWrapping = 0, byCharWrapping = 1, byClipping = 2 }

open class UIButton: UIControl {
    public enum ButtonType: Int {
        case custom = 0, system = 1, detailDisclosure = 2, infoLight = 3, infoDark = 4
        case contactAdd = 5, close = 7
    }
    open var titleLabel: UILabel? { get { fatalError() } set { fatalError() } }
    open var imageView: UIImageView? { get { fatalError() } set { fatalError() } }
    open var currentTitle: String? { get { fatalError() } set { fatalError() } }
    open var currentImage: UIImage? { get { fatalError() } set { fatalError() } }
    open var currentTitleColor: UIColor { get { fatalError() } set { fatalError() } }
    open var adjustsImageWhenHighlighted: Bool { get { fatalError() } set { fatalError() } }
    open var adjustsImageWhenDisabled: Bool { get { fatalError() } set { fatalError() } }
    open var showsTouchWhenHighlighted: Bool { get { fatalError() } set { fatalError() } }
    open var tintColorButton: UIColor? { get { fatalError() } set { fatalError() } }
    open var configuration: Any? { get { fatalError() } set { fatalError() } }
    open var menu: UIMenu? { get { fatalError() } set { fatalError() } }
    open func setTitle(_ title: String?, for state: UIControl.State) {}
    open func setTitleColor(_ color: UIColor?, for state: UIControl.State) {}
    open func setTitleShadowColor(_ color: UIColor?, for state: UIControl.State) {}
    open func setImage(_ image: UIImage?, for state: UIControl.State) {}
    open func setBackgroundImage(_ image: UIImage?, for state: UIControl.State) {}
    open func setAttributedTitle(_ title: NSAttributedString?, for state: UIControl.State) {}
    open func title(for state: UIControl.State) -> String? { fatalError() }
    open func image(for state: UIControl.State) -> UIImage? { fatalError() }
    open func titleRect(forContentRect contentRect: CGRect) -> CGRect { fatalError() }
    open func imageRect(forContentRect contentRect: CGRect) -> CGRect { fatalError() }
    open func backgroundRect(forBounds bounds: CGRect) -> CGRect { fatalError() }
    open class func buttonWithType(_ buttonType: UIButton.ButtonType) -> UIButton { fatalError() }
    public convenience init(type buttonType: UIButton.ButtonType) { self.init(frame: .zero) }
    public convenience init(type buttonType: UIButton.ButtonType, primaryAction: UIAction?) { self.init(frame: .zero) }
}

open class UIImageView: UIView {
    public override init(frame: CGRect) { super.init(frame: frame) }
    open var image: UIImage? { get { fatalError() } set { fatalError() } }
    open var highlightedImage: UIImage? { get { fatalError() } set { fatalError() } }
    open var animationImages: [UIImage]? { get { fatalError() } set { fatalError() } }
    open var animationDuration: TimeInterval { get { fatalError() } set { fatalError() } }
    open var animationRepeatCount: Int { get { fatalError() } set { fatalError() } }
    open var isAnimating: Bool { get { fatalError() } set { fatalError() } }
    open var contentModeImageView: UIView.ContentMode { get { fatalError() } set { fatalError() } }
    open func startAnimating() {}
    open func stopAnimating() {}
    public init(image: UIImage?) { super.init(frame: .zero) }
    public init(image: UIImage?, highlightedImage: UIImage?) { super.init(frame: .zero) }
    public required init?(coder: NSCoder) { super.init(coder: coder) }
}

open class UITextField: UIControl {
    public enum BorderStyle: Int { case none = 0, line = 1, bezel = 2, roundedRect = 3 }
    public enum ViewMode: Int { case never = 0, whileEditing = 1, unlessEditing = 2, always = 3 }
    open var text: String? { get { fatalError() } set { fatalError() } }
    open var attributedText: NSAttributedString? { get { fatalError() } set { fatalError() } }
    open var textColor: UIColor? { get { fatalError() } set { fatalError() } }
    open var font: UIFont? { get { fatalError() } set { fatalError() } }
    open var textAlignment: NSTextAlignment { get { fatalError() } set { fatalError() } }
    open var placeholder: String? { get { fatalError() } set { fatalError() } }
    open var attributedPlaceholder: NSAttributedString? { get { fatalError() } set { fatalError() } }
    open var borderStyle: BorderStyle { get { fatalError() } set { fatalError() } }
    open var keyboardType: UIKeyboardType { get { fatalError() } set { fatalError() } }
    open var returnKeyType: UIReturnKeyType { get { fatalError() } set { fatalError() } }
    open var isSecureTextEntry: Bool { get { fatalError() } set { fatalError() } }
    open var clearsOnBeginEditing: Bool { get { fatalError() } set { fatalError() } }
    open var adjustsFontSizeToFitWidth: Bool { get { fatalError() } set { fatalError() } }
    open var minimumFontSize: CGFloat { get { fatalError() } set { fatalError() } }
    open var delegate: UITextFieldDelegate? { get { fatalError() } set { fatalError() } }
    open var clearButtonMode: ViewMode { get { fatalError() } set { fatalError() } }
    open var leftView: UIView? { get { fatalError() } set { fatalError() } }
    open var rightView: UIView? { get { fatalError() } set { fatalError() } }
    open var leftViewMode: ViewMode { get { fatalError() } set { fatalError() } }
    open var rightViewMode: ViewMode { get { fatalError() } set { fatalError() } }
    open var autocorrectionType: UITextAutocorrectionType { get { fatalError() } set { fatalError() } }
    open var autocapitalizationType: UITextAutocapitalizationType { get { fatalError() } set { fatalError() } }
    open var inputAccessoryView: UIView? { get { fatalError() } set { fatalError() } }
    open func becomeFirstResponderTextField() -> Bool { fatalError() }
    open func selectAll(_ sender: Any?) {}
}

public enum UIKeyboardType: Int {
    case `default` = 0, asciiCapable = 1, numbersAndPunctuation = 2, URL = 3, numberPad = 4
    case phonePad = 5, namePhonePad = 6, emailAddress = 7, decimalPad = 8, twitter = 9
    case webSearch = 10, asciiCapableNumberPad = 11
}
public enum UIReturnKeyType: Int {
    case `default` = 0, go = 1, google = 2, join = 3, next = 4, route = 5, search = 6
    case send = 7, yahoo = 8, done = 9, emergencyCall = 10, `continue` = 11
}
public enum UITextAutocorrectionType: Int { case `default` = 0, no = 1, yes = 2 }
public enum UITextAutocapitalizationType: Int { case none = 0, words = 1, sentences = 2, allCharacters = 3 }

public protocol UITextFieldDelegate: AnyObject {
    func textFieldShouldReturn(_ textField: UITextField) -> Bool
    func textFieldDidEndEditing(_ textField: UITextField)
    func textField(_ textField: UITextField, shouldChangeCharactersIn range: NSRange, replacementString string: String) -> Bool
}

open class UIScrollView: UIView {
    public struct KeyboardDismissMode: RawRepresentable {
        public var rawValue: Int
        public init(rawValue: Int) { self.rawValue = rawValue }
        public static let none = KeyboardDismissMode(rawValue: 0)
        public static let onDrag = KeyboardDismissMode(rawValue: 1)
        public static let interactive = KeyboardDismissMode(rawValue: 2)
    }
    public struct IndicatorStyle: RawRepresentable {
        public var rawValue: Int
        public init(rawValue: Int) { self.rawValue = rawValue }
        public static let `default` = IndicatorStyle(rawValue: 0)
        public static let black = IndicatorStyle(rawValue: 1)
        public static let white = IndicatorStyle(rawValue: 2)
    }
    public struct ContentInsetAdjustmentBehavior: RawRepresentable {
        public var rawValue: Int
        public init(rawValue: Int) { self.rawValue = rawValue }
        public static let automatic = ContentInsetAdjustmentBehavior(rawValue: 0)
        public static let never = ContentInsetAdjustmentBehavior(rawValue: 2)
        public static let always = ContentInsetAdjustmentBehavior(rawValue: 3)
    }
    open var contentOffset: CGPoint { get { fatalError() } set { fatalError() } }
    open var contentSize: CGSize { get { fatalError() } set { fatalError() } }
    open var contentInset: UIEdgeInsets { get { fatalError() } set { fatalError() } }
    open var adjustedContentInset: UIEdgeInsets { get { fatalError() } set { fatalError() } }
    open var contentInsetAdjustmentBehavior: ContentInsetAdjustmentBehavior { get { fatalError() } set { fatalError() } }
    open var isScrollEnabled: Bool { get { fatalError() } set { fatalError() } }
    open var isDirectionalLockEnabled: Bool { get { fatalError() } set { fatalError() } }
    open var isPagingEnabled: Bool { get { fatalError() } set { fatalError() } }
    open var bounces: Bool { get { fatalError() } set { fatalError() } }
    open var alwaysBounceVertical: Bool { get { fatalError() } set { fatalError() } }
    open var alwaysBounceHorizontal: Bool { get { fatalError() } set { fatalError() } }
    open var showsHorizontalScrollIndicator: Bool { get { fatalError() } set { fatalError() } }
    open var showsVerticalScrollIndicator: Bool { get { fatalError() } set { fatalError() } }
    open var scrollIndicatorInsets: UIEdgeInsets { get { fatalError() } set { fatalError() } }
    open var indicatorStyle: IndicatorStyle { get { fatalError() } set { fatalError() } }
    open var decelerationRate: CGFloat { get { fatalError() } set { fatalError() } }
    open var zoomScale: CGFloat { get { fatalError() } set { fatalError() } }
    open var minimumZoomScale: CGFloat { get { fatalError() } set { fatalError() } }
    open var maximumZoomScale: CGFloat { get { fatalError() } set { fatalError() } }
    open var isZooming: Bool { get { fatalError() } set { fatalError() } }
    open var delegate: UIScrollViewDelegate? { get { fatalError() } set { fatalError() } }
        open var contentLayoutGuide: UILayoutGuide { fatalError() }
    open var frameLayoutGuide: UILayoutGuide { fatalError() }
open var keyboardDismissMode: KeyboardDismissMode { get { fatalError() } set { fatalError() } }
    open var panGestureRecognizer: UIPanGestureRecognizer { get { fatalError() } set { fatalError() } }
    open func setContentOffset(_ contentOffset: CGPoint, animated: Bool) {}
    open func scrollRectToVisible(_ rect: CGRect, animated: Bool) {}
    open func flashScrollIndicators() {}
}

public protocol UIScrollViewDelegate: AnyObject {
    func scrollViewDidScroll(_ scrollView: UIScrollView)
    func scrollViewDidZoom(_ scrollView: UIScrollView)
    func viewForZooming(in scrollView: UIScrollView) -> UIView?
}

open class UITextView: UIScrollView {
    open var text: String! { get { fatalError() } set { fatalError() } }
    open var attributedText: NSAttributedString! { get { fatalError() } set { fatalError() } }
    open var font: UIFont? { get { fatalError() } set { fatalError() } }
    open var textColor: UIColor? { get { fatalError() } set { fatalError() } }
    open var textAlignment: NSTextAlignment { get { fatalError() } set { fatalError() } }
    open var isEditable: Bool { get { fatalError() } set { fatalError() } }
    open var isSelectable: Bool { get { fatalError() } set { fatalError() } }
    open var dataDetectorTypes: Any { get { fatalError() } set { fatalError() } }
    open var textDelegate: UITextViewDelegate? { get { fatalError() } set { fatalError() } }
    open var textContainerInset: UIEdgeInsets { get { fatalError() } set { fatalError() } }
    open var isScrollEnabledTextView: Bool { get { fatalError() } set { fatalError() } }
    open func scrollRangeToVisible(_ range: NSRange) {}
}

public protocol UITextViewDelegate: AnyObject {
    func textViewDidChange(_ textView: UITextView)
}

open class UISwitch: UIControl {
    open var isOn: Bool { get { fatalError() } set { fatalError() } }
    open var onTintColor: UIColor? { get { fatalError() } set { fatalError() } }
    open var thumbTintColor: UIColor? { get { fatalError() } set { fatalError() } }
    open var onImage: UIImage? { get { fatalError() } set { fatalError() } }
    open var offImage: UIImage? { get { fatalError() } set { fatalError() } }
    open func setOn(_ on: Bool, animated: Bool) {}
}

open class UISlider: UIControl {
    open var value: Float { get { fatalError() } set { fatalError() } }
    open var minimumValue: Float { get { fatalError() } set { fatalError() } }
    open var maximumValue: Float { get { fatalError() } set { fatalError() } }
    open var isContinuous: Bool { get { fatalError() } set { fatalError() } }
    open var minimumTrackTintColor: UIColor? { get { fatalError() } set { fatalError() } }
    open var maximumTrackTintColor: UIColor? { get { fatalError() } set { fatalError() } }
    open var thumbTintColor: UIColor? { get { fatalError() } set { fatalError() } }
    open var currentThumbImage: UIImage? { get { fatalError() } set { fatalError() } }
    open func setValue(_ value: Float, animated: Bool) {}
    open func setThumbImage(_ image: UIImage?, for state: UIControl.State) {}
}

open class UIStepper: UIControl {
    open var value: Double { get { fatalError() } set { fatalError() } }
    open var minimumValue: Double { get { fatalError() } set { fatalError() } }
    open var maximumValue: Double { get { fatalError() } set { fatalError() } }
    open var stepValue: Double { get { fatalError() } set { fatalError() } }
    open var isContinuous: Bool { get { fatalError() } set { fatalError() } }
    open var autorepeat: Bool { get { fatalError() } set { fatalError() } }
    open var wraps: Bool { get { fatalError() } set { fatalError() } }
}

open class UISegmentedControl: UIControl {
    open var selectedSegmentIndex: Int { get { fatalError() } set { fatalError() } }
    open var isMomentary: Bool { get { fatalError() } set { fatalError() } }
    open var numberOfSegments: Int { get { fatalError() } set { fatalError() } }
    open var apportionsSegmentWidthsByContent: Bool { get { fatalError() } set { fatalError() } }
    open func insertSegment(withTitle title: String?, at segment: Int, animated: Bool) {}
    open func insertSegment(with image: UIImage?, at segment: Int, animated: Bool) {}
    open func removeAllSegments() {}
    open func removeSegment(at segment: Int, animated: Bool) {}
    open func setTitle(_ title: String?, forSegmentAt segment: Int) {}
    open func setImage(_ image: UIImage?, forSegmentAt segment: Int) {}
    open func setEnabled(_ enabled: Bool, forSegmentAt segment: Int) {}
    open func titleForSegment(at segment: Int) -> String? { fatalError() }
    public convenience init(items: [Any]?) { self.init(frame: .zero) }
}

open class UIActivityIndicatorView: UIView {
    public override init(frame: CGRect) { super.init(frame: frame) }
    public enum Style: Int { case medium = 100, large = 101 }
    open var isAnimating: Bool { get { fatalError() } set { fatalError() } }
    open var color: UIColor? { get { fatalError() } set { fatalError() } }
    open var hidesWhenStopped: Bool { get { fatalError() } set { fatalError() } }
    open func startAnimating() {}
    open func stopAnimating() {}
    public init(style: Style) { super.init(frame: .zero) }
    public required init?(coder: NSCoder) { super.init(coder: coder) }
}

open class UIDatePicker: UIControl {
    public enum Style: Int { case automatic = 0, wheels = 1, compact = 2, inline = 3 }
    public enum Mode: Int { case time = 0, date = 1, dateAndTime = 2, countDownTimer = 3 }
    open var date: Date { get { fatalError() } set { fatalError() } }
    open var datePickerMode: Mode { get { fatalError() } set { fatalError() } }
    open var preferredDatePickerStyle: Style { get { fatalError() } set { fatalError() } }
    open var minimumDate: Date? { get { fatalError() } set { fatalError() } }
    open var maximumDate: Date? { get { fatalError() } set { fatalError() } }
    open var minuteInterval: Int { get { fatalError() } set { fatalError() } }
    open func setDate(_ date: Date, animated: Bool) {}
}

open class UIStackView: UIView {
    public override init(frame: CGRect) { super.init(frame: frame) }
    public enum Distribution: Int {
        case fill = 0, fillEqually = 1, fillProportionally = 2, equalSpacing = 3, equalCentering = 4
    }
    public enum Alignment: Int {
        case fill = 0, leading = 1, firstBaseline = 2, center = 3, trailing = 4
        case lastBaseline = 5
    }
    open var arrangedSubviews: [UIView] { get { fatalError() } set { fatalError() } }
    open var axis: NSLayoutConstraint.Axis { get { fatalError() } set { fatalError() } }
    open var distribution: Distribution { get { fatalError() } set { fatalError() } }
    open var alignment: Alignment { get { fatalError() } set { fatalError() } }
    open var spacing: CGFloat { get { fatalError() } set { fatalError() } }
    open var isBaselineRelativeArrangement: Bool { get { fatalError() } set { fatalError() } }
    open var isLayoutMarginsRelativeArrangement: Bool { get { fatalError() } set { fatalError() } }
    open func addArrangedSubview(_ view: UIView) {}
    open func removeArrangedSubview(_ view: UIView) {}
    open func insertArrangedSubview(_ view: UIView, at stackIndex: Int) {}
    public init(arrangedSubviews: [UIView]) { super.init(frame: .zero) }
    public required init?(coder: NSCoder) { super.init(coder: coder) }
}

open class UIVisualEffect: NSObject {}
open class UIBlurEffect: UIVisualEffect {
    public enum Style: Int { case extraLight = 0, light = 1, dark = 2, regular = 4, prominent = 5, systemUltraThinMaterial = 6 }
    public init(style: UIBlurEffect.Style) { super.init() }
}
open class UIVisualEffectView: UIView {
    public override init(frame: CGRect) { super.init(frame: frame) }
    open var contentView: UIView { get { fatalError() } set { fatalError() } }
    open var effect: UIVisualEffect? { get { fatalError() } set { fatalError() } }
    public init(effect: UIVisualEffect?) { super.init(frame: .zero) }
    public required init?(coder: NSCoder) { super.init(coder: coder) }
}

open class UIPickerView: UIView {
    open var dataSource: AnyObject? { get { fatalError() } set { fatalError() } }
    open var delegate: AnyObject? { get { fatalError() } set { fatalError() } }
    open var numberOfComponents: Int { get { fatalError() } set { fatalError() } }
    open func selectedRow(inComponent component: Int) -> Int { fatalError() }
    open func reloadAllComponents() {}
    open func selectRow(_ row: Int, inComponent component: Int, animated: Bool) {}
}

open class UIPageControl: UIControl {
    open var numberOfPages: Int { get { fatalError() } set { fatalError() } }
    open var currentPage: Int { get { fatalError() } set { fatalError() } }
    open var hidesForSinglePage: Bool { get { fatalError() } set { fatalError() } }
}

open class UITableView: UIScrollView {
    public override init(frame: CGRect) { super.init(frame: frame) }
    public enum Style: Int { case plain = 0, grouped = 1, insetGrouped = 2 }
    public struct CellSeparatorStyle: RawRepresentable {
        public var rawValue: Int
        public init(rawValue: Int) { self.rawValue = rawValue }
        public static let none = CellSeparatorStyle(rawValue: 0)
        public static let singleLine = CellSeparatorStyle(rawValue: 1)
    }
    open var dataSource: UITableViewDataSource? { get { fatalError() } set { fatalError() } }
    open var delegateTableView: UITableViewDelegate? { get { fatalError() } set { fatalError() } }
    open var rowHeight: CGFloat { get { fatalError() } set { fatalError() } }
    open var separatorStyle: CellSeparatorStyle { get { fatalError() } set { fatalError() } }
    open var separatorColor: UIColor? { get { fatalError() } set { fatalError() } }
    open var tableHeaderView: UIView? { get { fatalError() } set { fatalError() } }
    open var tableFooterView: UIView? { get { fatalError() } set { fatalError() } }
    open var isEditingTableView: Bool { get { fatalError() } set { fatalError() } }
    open var allowsSelection: Bool { get { fatalError() } set { fatalError() } }
    open var backgroundColorTable: UIColor? { get { fatalError() } set { fatalError() } }
    open var registerCell: Bool { get { fatalError() } set { fatalError() } }
    open func reloadData() {}
    open func reloadRows(at indexPaths: [IndexPath], with animation: UITableView.RowAnimation) {}
    open func insertRows(at indexPaths: [IndexPath], with animation: UITableView.RowAnimation) {}
    open func deleteRows(at indexPaths: [IndexPath], with animation: UITableView.RowAnimation) {}
    open func deselectRow(at indexPath: IndexPath, animated: Bool) {}
    open func register(_ cellClass: AnyClass?, forCellReuseIdentifier identifier: String) {}
    open func register(_ nib: Any?, forCellReuseIdentifier identifier: String) {}
    open func dequeueReusableCell(withIdentifier identifier: String, for indexPath: IndexPath) -> UITableViewCell? { fatalError() }
    open func dequeueReusableCell(withIdentifier identifier: String) -> UITableViewCell? { fatalError() }
    public init(frame: CGRect, style: Style) { super.init(frame: frame) }
    public required init?(coder: NSCoder) { super.init(coder: coder) }
    public enum RowAnimation: Int { case fade = 0, right = 1, left = 2, top = 3, bottom = 4, none = 5, automatic = 100 }
}

public protocol UITableViewDataSource: AnyObject {
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell
}
public protocol UITableViewDelegate: AnyObject {
    func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath)
}

open class UITableViewCell: UIView {
    public override init(frame: CGRect) { super.init(frame: frame) }
    public enum CellStyle: Int { case `default` = 0, value1 = 1, value2 = 2, subtitle = 3 }
    open var textLabel: UILabel? { get { fatalError() } set { fatalError() } }
    open var detailTextLabel: UILabel? { get { fatalError() } set { fatalError() } }
    open var imageViewCell: UIImageView? { get { fatalError() } set { fatalError() } }
    open var contentViewCell: UIView { get { fatalError() } set { fatalError() } }
    open var accessoryType: UITableViewCell.AccessoryType { get { fatalError() } set { fatalError() } }
    open var selectionStyle: UITableViewCell.SelectionStyle { get { fatalError() } set { fatalError() } }
    open var reuseIdentifier: String? { get { fatalError() } set { fatalError() } }
    public init(style: CellStyle, reuseIdentifier: String?) { super.init(frame: .zero) }
    public required init?(coder: NSCoder) { super.init(coder: coder) }
    public enum AccessoryType: Int { case none = 0, disclosureIndicator = 1, detailDisclosureButton = 2, checkmark = 3, detailButton = 4 }
    public enum SelectionStyle: Int { case none = 0, blue = 1, gray = 2, `default` = 3 }
}

open class UICollectionView: UIScrollView {}
open class UICollectionViewCell: UIView {}
open class UICollectionViewFlowLayout: NSObject {}

// MARK: - 弹窗 / 菜单 / 动作

open class UIAction: NSObject {
    public struct Identifier: Hashable, RawRepresentable {
        public var rawValue: String
        public init(rawValue: String) { self.rawValue = rawValue }
    }
    open var title: String { get { fatalError() } set { fatalError() } }
    open var identifier: UIAction.Identifier { get { fatalError() } set { fatalError() } }
    open var isEnabled: Bool { get { fatalError() } set { fatalError() } }
    open var state: UIControl.State { fatalError() }
    open var attributes: UIMenuElement.Attributes { get { fatalError() } set { fatalError() } }
    open var image: UIImage? { get { fatalError() } set { fatalError() } }
    public init(title: String = "", image: UIImage? = nil, identifier: UIAction.Identifier? = nil, handler: @escaping (UIAction) -> Void) { super.init() }
    public init(title: String = "", image: UIImage? = nil, identifier: UIAction.Identifier? = nil, discoverabilityTitle: String? = nil, attributes: UIMenuElement.Attributes = [], state: UIControl.State = .normal, handler: @escaping (UIAction) -> Void) { super.init() }
}

open class UIMenuElement: NSObject {
    public struct Attributes: OptionSet {
        public let rawValue: UInt
        public init(rawValue: UInt) { self.rawValue = rawValue }
        public static let disabled = Attributes(rawValue: 1)
        public static let destructive = Attributes(rawValue: 2)
        public static let hidden = Attributes(rawValue: 4)
    }
    open var title: String { get { fatalError() } set { fatalError() } }
    open var image: UIImage? { get { fatalError() } set { fatalError() } }
}

open class UIMenu: UIMenuElement {
    public struct Options: OptionSet {
        public let rawValue: UInt
        public init(rawValue: UInt) { self.rawValue = rawValue }
        public static let displayInline = Options(rawValue: 1)
        public static let destructive = Options(rawValue: 2)
    }
    open var children: [UIMenuElement] { get { fatalError() } set { fatalError() } }
    open var options: Options { get { fatalError() } set { fatalError() } }
    public init(title: String, children: [UIMenuElement]) { super.init() }
    public init(title: String, subtitle: String?, image: UIImage?, identifier: UIMenu.Identifier? = nil, options: Options = [], children: [UIMenuElement]) { super.init() }
    public typealias Identifier = UIAction.Identifier
    public static func menu(title: String, children: [UIMenuElement]) -> UIMenu { UIMenu(title: title, children: children) }
}

open class UIContextMenuInteraction: NSObject {}

public struct UIAlertActionStylePlaceholder {}

open class UIAlertAction: NSObject {
    public enum Style: Int { case `default` = 0, cancel = 1, destructive = 2 }
    open var title: String? { get { fatalError() } set { fatalError() } }
    open var style: Style { get { fatalError() } set { fatalError() } }
    open var isEnabled: Bool { get { fatalError() } set { fatalError() } }
    public init(title: String?, style: Style, handler: ((UIAlertAction) -> Void)? = nil) { super.init() }
    public convenience init(title: String?, style: Style, handler: @escaping (UIAlertAction) -> Void) {
        self.init(title: title, style: style, handler: Optional(handler))
    }
}

open class UIAlertController: UIViewController {
    public override init(nibName nibNameOrNil: String?, bundle nibBundleOrNil: Bundle?) { super.init(nibName: nibNameOrNil, bundle: nibBundleOrNil) }
    public enum Style: Int { case actionSheet = 0, alert = 1 }
    open var titleAlert: String? { get { fatalError() } set { fatalError() } }
    open var message: String? { get { fatalError() } set { fatalError() } }
    open var actions: [UIAlertAction] { get { fatalError() } set { fatalError() } }
    open var preferredStyle: Style { get { fatalError() } set { fatalError() } }
    open var textFields: [UITextField]? { get { fatalError() } set { fatalError() } }
    open var isModalInPresentationAlert: Bool { get { fatalError() } set { fatalError() } }
    public init(title: String?, message: String?, preferredStyle: Style) { super.init(nibName: nil, bundle: nil) }
    public required init?(coder: NSCoder) { super.init(coder: coder) }
    open func addAction(_ action: UIAlertAction) {}
    open func addTextField(configurationHandler: ((UITextField) -> Void)? = nil) {}
}

open class UIPasteboard: NSObject {
    public static let general = UIPasteboard()
    open var string: String? { get { fatalError() } set { fatalError() } }
    open var image: UIImage? { get { fatalError() } set { fatalError() } }
    open var strings: [String]? { get { fatalError() } set { fatalError() } }
    open var hasStrings: Bool { get { fatalError() } set { fatalError() } }
    open func setItems(_ items: [[String: Any]], options: [UIPasteboard.OptionsKey: Any] = [:]) {}
    public struct OptionsKey: Hashable, RawRepresentable {
        public var rawValue: String
        public init(rawValue: String) { self.rawValue = rawValue }
    }
}

open class UIDocumentPickerViewController: UIViewController {
    public override init(nibName nibNameOrNil: String?, bundle nibBundleOrNil: Bundle?) { super.init(nibName: nibNameOrNil, bundle: nibBundleOrNil) }
    public enum SizingOption: Int { case `default` = 0, compact = 1 }
    open var delegate: UIDocumentPickerDelegate? { get { fatalError() } set { fatalError() } }
    open var allowsMultipleSelection: Bool { get { fatalError() } set { fatalError() } }
    open var shouldShowFileExtensions: Bool { get { fatalError() } set { fatalError() } }
    public init(forOpeningContentTypes contentTypes: [UTType], asCopy: Bool) { super.init(nibName: nil, bundle: nil) }
    public init(forOpeningContentTypes contentTypes: [UTType]) { super.init(nibName: nil, bundle: nil) }
    public init(documentTypes: [String], in mode: UIDocumentPickerViewController.Mode) { super.init(nibName: nil, bundle: nil) }
    public init(url: URL, in mode: UIDocumentPickerViewController.Mode) { super.init(nibName: nil, bundle: nil) }
    public enum Mode: Int { case `import` = 0, open = 1, exportToService = 2, moveToService = 3 }
    public required init?(coder: NSCoder) { super.init(coder: coder) }
}

public protocol UIDocumentPickerDelegate: AnyObject {
    func documentPicker(_ controller: UIDocumentPickerViewController, didPickDocumentsAt urls: [URL])
    func documentPickerWasCancelled(_ controller: UIDocumentPickerViewController)
}

// MARK: - 反馈 / 设备 / 应用

open class UIImpactFeedbackGenerator: NSObject {
    public enum Style: Int { case light = 0, medium = 1, heavy = 2, rigid = 3, soft = 4 }
    public init(style: UIImpactFeedbackGenerator.Style) { super.init() }
    open func prepare() {}
    open func impactOccurred() {}
    open func impactOccurred(intensity: CGFloat) {}
}

open class UISelectionFeedbackGenerator: NSObject {
    open func selectionChanged() {}
}

open class UINotificationFeedbackGenerator: NSObject {
    public enum FeedbackType: Int { case success = 0, warning = 1, error = 2 }
    open func notificationOccurred(_ notificationType: UINotificationFeedbackGenerator.FeedbackType) {}
}

open class UIDevice: NSObject {
    public enum Orientation: Int { case unknown = 0, portrait = 1, portraitUpsideDown = 2, landscapeLeft = 3, landscapeRight = 4, faceUp = 5, faceDown = 6 }
    public enum BatteryState: Int { case unknown = 0, unplugged = 1, charging = 2, full = 3 }
    public static let current = UIDevice()
    open var userInterfaceIdiom: UIUserInterfaceIdiom { get { fatalError() } set { fatalError() } }
    open var orientation: Orientation { get { fatalError() } set { fatalError() } }
    open var name: String { get { fatalError() } set { fatalError() } }
    open var systemName: String { get { fatalError() } set { fatalError() } }
    open var systemVersion: String { get { fatalError() } set { fatalError() } }
    open var model: String { get { fatalError() } set { fatalError() } }
    open var isMultitaskingSupported: Bool { get { fatalError() } set { fatalError() } }
    open var batteryLevel: Float { get { fatalError() } set { fatalError() } }
    open var batteryState: BatteryState { get { fatalError() } set { fatalError() } }
    open var isBatteryMonitoringEnabled: Bool { get { fatalError() } set { fatalError() } }
    open var identifierForVendor: UUID? { get { fatalError() } set { fatalError() } }
    open var proximityState: Bool { get { fatalError() } set { fatalError() } }
    open func beginGeneratingDeviceOrientationNotifications() {}
    open func endGeneratingDeviceOrientationNotifications() {}
    open func playInputClick() {}
}

open class UIScreen: NSObject {
    public struct OverscanCompensation: RawRepresentable {
        public var rawValue: Int
        public init(rawValue: Int) { self.rawValue = rawValue }
    }
    public static let main = UIScreen()
    open var bounds: CGRect { get { fatalError() } set { fatalError() } }
    open var scale: CGFloat { get { fatalError() } set { fatalError() } }
    open var nativeBounds: CGRect { get { fatalError() } set { fatalError() } }
    open var nativeScale: CGFloat { get { fatalError() } set { fatalError() } }
    open var brightness: CGFloat { get { fatalError() } set { fatalError() } }
    open var isCaptured: Bool { get { fatalError() } set { fatalError() } }
    open var maximumFramesPerSecond: Int { get { fatalError() } set { fatalError() } }
    open var displayLink: Any? { get { fatalError() } set { fatalError() } }
}

open class UIApplication: NSObject {
    public static let shared = UIApplication()
    open var delegate: UIApplicationDelegate? { get { fatalError() } set { fatalError() } }
    open var keyWindow: UIWindow? { get { fatalError() } set { fatalError() } }
    open var windows: [UIWindow] { get { fatalError() } set { fatalError() } }
    open var applicationState: UIApplication.State { get { fatalError() } set { fatalError() } }
    open var statusBarOrientation: UIInterfaceOrientation { get { fatalError() } set { fatalError() } }
    public static let willResignActiveNotification = Notification.Name(rawValue: "UIApplicationWillResignActiveNotification")
    public static let didEnterBackgroundNotification = Notification.Name(rawValue: "UIApplicationDidEnterBackgroundNotification")
    public static let willEnterForegroundNotification = Notification.Name(rawValue: "UIApplicationWillEnterForegroundNotification")
    public static let didBecomeActiveNotification = Notification.Name(rawValue: "UIApplicationDidBecomeActiveNotification")
    open var isIdleTimerDisabled: Bool { get { fatalError() } set { fatalError() } }
    open var isStatusBarHidden: Bool { get { fatalError() } set { fatalError() } }
    open var userInterfaceLayoutDirection: UIUserInterfaceLayoutDirection { get { fatalError() } set { fatalError() } }
    open var supportsMultipleScenes: Bool { get { fatalError() } set { fatalError() } }
    open func open(_ url: URL, options: [UIApplication.OpenExternalURLOptionsKey: Any] = [:], completionHandler completion: ((Bool) -> Void)? = nil) {}
    open var connectedScenes: Set<AnyHashable> { get { fatalError() } set { fatalError() } }
    public enum State: Int { case active = 0, inactive = 1, background = 2 }
    public struct OpenExternalURLOptionsKey: Hashable, RawRepresentable {
        public var rawValue: String
        public init(rawValue: String) { self.rawValue = rawValue }
    }
}

public protocol UIApplicationDelegate: AnyObject {
    func application(_ application: UIApplication, didFinishLaunchingWithOptions launchOptions: [UIApplication.LaunchOptionsKey: Any]?) -> Bool
    func application(_ application: UIApplication, configurationForConnecting connectingSceneSession: UISceneSession, options: UIScene.ConnectionOptions) -> UISceneConfiguration
}

// UIKit 真实实现里 UIApplicationMain 由协议扩展提供的 static main() 承载，
// @main 才能挂在 UIApplicationDelegate 上。
public extension UIApplicationDelegate {
    static func main() {}
}
public extension UIApplication {
    struct LaunchOptionsKey: Hashable, RawRepresentable {
        public var rawValue: String
        public init(rawValue: String) { self.rawValue = rawValue }
        public static let url = LaunchOptionsKey(rawValue: "UIApplicationLaunchOptionsURLKey")
    }
    struct OpenURLOptionsKey: Hashable, RawRepresentable {
        public var rawValue: String
        public init(rawValue: String) { self.rawValue = rawValue }
    }
}

open class UIWindow: UIView {
    open var rootViewController: UIViewController? { get { fatalError() } set { fatalError() } }
    open var screen: UIScreen { get { fatalError() } set { fatalError() } }
    open var windowScene: UIWindowScene? { get { fatalError() } set { fatalError() } }
    open var isKeyWindow: Bool { get { fatalError() } set { fatalError() } }
    open var windowLevel: CGFloat { get { fatalError() } set { fatalError() } }
    open func makeKeyAndVisible() {}
    open func makeKey() {}
    public override init(frame: CGRect) { super.init(frame: frame) }
    public init(windowScene: UIWindowScene) { super.init(frame: .zero) }
    public required init?(coder: NSCoder) { super.init(coder: coder) }
}

public extension UIScene {
    struct ConnectionOptions {
        public var urlContexts: Set<UIOpenURLContext>
        public var userActivities: Set<AnyHashable>
        public var handoffUserActivityType: String?
        public var cloudKitShareMetadata: Any?
        public var notificationResponse: Any?
        public var shortcutItem: Any?
        public var sourceApplication: String?
        public init() { urlContexts = []; userActivities = []; handoffUserActivityType = nil
            cloudKitShareMetadata = nil; notificationResponse = nil; shortcutItem = nil
            sourceApplication = nil }
    }
}

open class UIScene: NSObject {
    open var delegate: UISceneDelegate? { get { fatalError() } set { fatalError() } }
    open var activationState: UIScene.ActivationState { get { fatalError() } set { fatalError() } }
    open var session: UISceneSession { get { fatalError() } set { fatalError() } }
    public enum ActivationState: Int { case unattached = 0, foregroundInactive = 1, foregroundActive = 2, background = 3 }
}

public protocol UISceneDelegate: AnyObject {}
public protocol UIWindowSceneDelegate: UISceneDelegate {
    var window: UIWindow? { get set }
}

open class UISceneSession: NSObject {
    open var role: UISceneSession.Role { get { fatalError() } set { fatalError() } }
    open var configuration: UISceneConfiguration { get { fatalError() } set { fatalError() } }
    open var scene: UIScene? { get { fatalError() } set { fatalError() } }
    open var persistentIdentifier: String { get { fatalError() } set { fatalError() } }
    public struct Role: Hashable, RawRepresentable {
        public var rawValue: String
        public init(rawValue: String) { self.rawValue = rawValue }
        public static let windowApplication = Role(rawValue: "UIWindowSceneSessionRoleApplication")
    }
}

open class UISceneConfiguration: NSObject, NSCopying {
    open var name: String? { get { fatalError() } set { fatalError() } }
    open var role: UISceneSession.Role { get { fatalError() } set { fatalError() } }
    open var sceneClass: AnyClass? { get { fatalError() } set { fatalError() } }
    open var delegateClass: AnyClass? { get { fatalError() } set { fatalError() } }
    open var storyboard: Any? { get { fatalError() } set { fatalError() } }
    public init(name: String?, sessionRole: UISceneSession.Role) { super.init() }
    public func copy(with zone: NSZone?) -> Any { fatalError() }
}

open class UISceneSessionActivationRequest: NSObject {}

open class UIWindowScene: UIScene {
    open func requestGeometryUpdate(_ geometryPreferences: UIWindowSceneGeometryPreferences) {}
    open var effectiveGeometry: UIWindowSceneGeometry { fatalError() }
    open var screen: UIScreen { get { fatalError() } set { fatalError() } }
    open var windows: [UIWindow] { get { fatalError() } set { fatalError() } }
    open var coordinateSpace: Any { get { fatalError() } set { fatalError() } }
    open var interfaceOrientation: UIInterfaceOrientation { get { fatalError() } set { fatalError() } }
    open var keyWindow: UIWindow? { get { fatalError() } set { fatalError() } }
}

open class UIWindowSceneGeometry: NSObject {}
open class UIWindowSceneGeometryPreferences: NSObject {
    public init(interfaceOrientations: UIInterfaceOrientationMask) { super.init() }
}

public enum UIInterfaceOrientation: Int { case unknown = 0, portrait = 1, portraitUpsideDown = 2, landscapeLeft = 3, landscapeRight = 4 }
public struct UIInterfaceOrientationMask: OptionSet {
    public let rawValue: UInt
    public init(rawValue: UInt) { self.rawValue = rawValue }
    public static let portrait = UIInterfaceOrientationMask(rawValue: 1 << 1)
    public static let landscapeLeft = UIInterfaceOrientationMask(rawValue: 1 << 4)
    public static let landscapeRight = UIInterfaceOrientationMask(rawValue: 1 << 3)
    public static let portraitUpsideDown = UIInterfaceOrientationMask(rawValue: 1 << 2)
    public static let landscape = UIInterfaceOrientationMask(rawValue: (1 << 4) | (1 << 3))
    public static let all = UIInterfaceOrientationMask(rawValue: 0x1E)
    public static let allButUpsideDown = UIInterfaceOrientationMask(rawValue: 0x1A)
}

open class UIOpenURLContext: NSObject {
    open var url: URL { get { fatalError() } set { fatalError() } }
    open var options: UIScene.OpenURLOptions { get { fatalError() } set { fatalError() } }
}
public extension UIScene {
    struct OpenURLOptions { public var sourceApplication: String?; public var annotation: Any? }
}

public extension UIWindowSceneDelegate {
    func scene(_ scene: UIScene, willConnectTo session: UISceneSession, options connectionOptions: UIScene.ConnectionOptions) {}
    func scene(_ scene: UIScene, openURLContexts URLContexts: Set<UIOpenURLContext>) {}
    func sceneDidBecomeActive(_ scene: UIScene) {}
    func sceneWillResignActive(_ scene: UIScene) {}
    func sceneWillEnterForeground(_ scene: UIScene) {}
    func sceneDidEnterBackground(_ scene: UIScene) {}
}

// MARK: - 绘图上下文

public func UIGraphicsGetCurrentContext() -> CGContext? { nil }
public func UIGraphicsPushContext(_ context: CGContext) {}
public func UIGraphicsPopContext() {}
public func UIGraphicsBeginImageContext(_ size: CGSize) {}
public func UIGraphicsBeginImageContextWithOptions(_ size: CGSize, _ opaque: Bool, _ scale: CGFloat) {}
public func UIGraphicsEndImageContext() {}
public func UIGraphicsGetImageFromCurrentImageContext() -> UIImage? { nil }
public func UIRectFill(_ rect: CGRect) {}
public func UIRectFrame(_ rect: CGRect) {}

open class UIGraphicsImageRendererFormat: NSObject {
    open var scale: CGFloat { get { fatalError() } set { fatalError() } }
    open var opaque: Bool { get { fatalError() } set { fatalError() } }
    open var preferredRange: Int { get { fatalError() } set { fatalError() } }
    public override init() { super.init() }
    public init(scale: CGFloat) { super.init() }
}

open class UIGraphicsImageRendererContext: NSObject {
    open var cgContext: CGContext { get { fatalError() } set { fatalError() } }
    open func currentImage() -> UIImage { fatalError() }
}

open class UIGraphicsImageRenderer: NSObject {
    public init(size: CGSize) { super.init() }
    public init(size: CGSize, format: UIGraphicsImageRendererFormat) { super.init() }
    open func image(actions: (UIGraphicsImageRendererContext) -> Void) -> UIImage { fatalError() }
    open func pngData(actions: (UIGraphicsImageRendererContext) -> Void) -> Data { fatalError() }
}

open class UIBezierPath: NSObject, NSCopying {
    public enum LineCapStyle: Int { case butt = 0, round = 1, square = 2 }
    public enum LineJoinStyle: Int { case miter = 0, round = 1, bevel = 2 }
    open var lineWidth: CGFloat { get { fatalError() } set { fatalError() } }
    open var lineCapStyle: LineCapStyle { get { fatalError() } set { fatalError() } }
    open var lineJoinStyle: LineJoinStyle { get { fatalError() } set { fatalError() } }
    open var miterLimit: CGFloat { get { fatalError() } set { fatalError() } }
    open var flatness: CGFloat { get { fatalError() } set { fatalError() } }
    open var usesEvenOddFillRule: Bool { get { fatalError() } set { fatalError() } }
    open var isEmpty: Bool { fatalError() }
    open var bounds: CGRect { get { fatalError() } set { fatalError() } }
    open var currentPoint: CGPoint { get { fatalError() } set { fatalError() } }
    open var cgPath: CGPath { get { fatalError() } set { fatalError() } }
    public init(rect: CGRect) { super.init() }
    public init(ovalIn rect: CGRect) { super.init() }
    public init(roundedRect rect: CGRect, cornerRadius: CGFloat) { super.init() }
    public init(roundedRect rect: CGRect, byRoundingCorners corners: UIRectCorner, cornerRadii: CGSize) { super.init() }
    public init(cgPath: CGPath) { super.init() }
    public override init() { super.init() }
    open func move(to point: CGPoint) {}
    open func addLine(to point: CGPoint) {}
    open func addArc(withCenter center: CGPoint, radius: CGFloat, startAngle: CGFloat, endAngle: CGFloat, clockwise: Bool) {}
    open func addQuadCurve(to point: CGPoint, controlPoint: CGPoint) {}
    open func addCurve(to point: CGPoint, controlPoint1: CGPoint, controlPoint2: CGPoint) {}
    open func addRect(_ rect: CGRect) {}
    open func addOval(in rect: CGRect) {}
    open func append(_ bezierPath: UIBezierPath) {}
    open func close() {}
    open func removeAllPoints() {}
    open func apply(_ transform: CGAffineTransform) {}
    open func fill() {}
    open func fill(with blendMode: CGBlendMode, alpha: CGFloat) {}
    open func stroke() {}
    open func addClip() {}
    open func contains(_ point: CGPoint) -> Bool { fatalError() }
    open func copy(with zone: NSZone?) -> Any { fatalError() }
    open class func roundedRectPath(_ rect: CGRect, cornerRadius: CGFloat) -> UIBezierPath { UIBezierPath(roundedRect: rect, cornerRadius: cornerRadius) }
}

public extension UIButton {
    var contentEdgeInsetsButton: UIEdgeInsets { get { fatalError() } set { fatalError() } }
    var titleEdgeInsets: UIEdgeInsets { get { fatalError() } set { fatalError() } }
    var imageEdgeInsets: UIEdgeInsets { get { fatalError() } set { fatalError() } }
}

public struct UIRectCorner: OptionSet {
    public let rawValue: UInt
    public init(rawValue: UInt) { self.rawValue = rawValue }
    public static let topLeft = UIRectCorner(rawValue: 1 << 0)
    public static let topRight = UIRectCorner(rawValue: 1 << 1)
    public static let bottomLeft = UIRectCorner(rawValue: 1 << 2)
    public static let bottomRight = UIRectCorner(rawValue: 1 << 3)
    public static let allCorners = UIRectCorner(rawValue: ~0)
}

open class UICollectionViewLayout: NSObject {}
open class UIFontMetrics: NSObject {}

open class UIViewControllerContextTransitioning: NSObject {}
open class UIPresentationController: NSObject {}
open class UITextPosition: NSObject {}
open class UITextRange: NSObject {}
open class UITextInputMode: NSObject {}

open class UIViewController: UIResponder {
    public enum ModalPresentationStyle: Int {
        case automatic = -2, none = -1, fullScreen = 0, pageSheet = 1, formSheet = 2
        case currentContext = 3, custom = 4, overFullScreen = 5, overCurrentContext = 6
        case popover = 7, blurOverFullScreen = 8
    }
    public enum ModalTransitionStyle: Int {
        case coverVertical = 0, flipHorizontal = 1, crossDissolve = 2, partialCurl = 3
    }
    open var view: UIView! { get { fatalError() } set { fatalError() } }
    open var title: String? { get { fatalError() } set { fatalError() } }
    open var nibName: String? { get { fatalError() } set { fatalError() } }
    open var nibBundle: Bundle? { get { fatalError() } set { fatalError() } }
    open var isViewLoaded: Bool { get { fatalError() } set { fatalError() } }
    open var viewIfLoaded: UIView? { get { fatalError() } set { fatalError() } }
    open var parent: UIViewController? { get { fatalError() } set { fatalError() } }
    open var children: [UIViewController] { get { fatalError() } set { fatalError() } }
    open var presentedViewController: UIViewController? { get { fatalError() } set { fatalError() } }
    open var presentingViewController: UIViewController? { get { fatalError() } set { fatalError() } }
    open var modalPresentationStyle: ModalPresentationStyle { get { fatalError() } set { fatalError() } }
    open var modalTransitionStyle: ModalTransitionStyle { get { fatalError() } set { fatalError() } }
    open var modalPresentationCapturesStatusBarAppearance: Bool { get { fatalError() } set { fatalError() } }
    open var isModalInPresentation: Bool { get { fatalError() } set { fatalError() } }
    open var definesPresentationContext: Bool { get { fatalError() } set { fatalError() } }
    open var providesPresentationContextTransitionStyle: Bool { get { fatalError() } set { fatalError() } }
    open var presentationController: UIPresentationController? { get { fatalError() } set { fatalError() } }
    open var preferredContentSize: CGSize { get { fatalError() } set { fatalError() } }
    open var navigationController: UINavigationController? { get { fatalError() } set { fatalError() } }
    open var navigationItem: UINavigationItem { get { fatalError() } set { fatalError() } }
    open var toolbarItems: [UIBarButtonItem]? { get { fatalError() } set { fatalError() } }
    open var tabBarController: UITabBarController? { get { fatalError() } set { fatalError() } }
    open var splitViewController: UISplitViewController? { get { fatalError() } set { fatalError() } }
    open var extensionContext: Any? { get { fatalError() } set { fatalError() } }
    open var preferredStatusBarStyle: UIStatusBarStyle { get { fatalError() } set { fatalError() } }
    open var prefersStatusBarHidden: Bool { fatalError() }
    open var preferredStatusBarUpdateAnimation: UIStatusBarAnimation { get { fatalError() } set { fatalError() } }
    open var preferredScreenEdgesDeferringSystemGestures: UIRectEdge { get { fatalError() } set { fatalError() } }
    open var childForScreenEdgesDeferringSystemGestures: UIViewController? { get { fatalError() } set { fatalError() } }
    open var prefersHomeIndicatorAutoHidden: Bool { fatalError() }
    open var childForHomeIndicatorAutoHidden: UIViewController? { get { fatalError() } set { fatalError() } }
    open var supportedInterfaceOrientations: UIInterfaceOrientationMask { fatalError() }
    open var shouldAutorotate: Bool { fatalError() }
    open var preferredInterfaceOrientationForPresentation: UIInterfaceOrientation { fatalError() }
    open var overrideUserInterfaceStyle: UIUserInterfaceStyle { get { fatalError() } set { fatalError() } }
    open var traitCollection: UITraitCollection { fatalError() }
    open var presentingModal: Bool { get { fatalError() } set { fatalError() } }

    public init(nibName nibNameOrNil: String?, bundle nibBundleOrNil: Bundle?) { super.init() }
    public required init?(coder: NSCoder) { super.init() }
    public override convenience init() { self.init(nibName: nil, bundle: nil) }

    open func loadView() {}
    open func loadViewIfNeeded() {}
    open func viewDidLoad() {}
    open func viewWillAppear(_ animated: Bool) {}
    open func viewWillLayoutSubviews() {}
    open func viewDidLayoutSubviews() {}
    open func viewDidAppear(_ animated: Bool) {}
    open func viewWillDisappear(_ animated: Bool) {}
    open func viewDidDisappear(_ animated: Bool) {}
    open func viewWillTransition(to size: CGSize, with coordinator: UIViewControllerTransitionCoordinator) {}
    open func viewSafeAreaInsetsDidChange() {}
    open func viewDidChangeLayoutMargins() {}
    open func didReceiveMemoryWarning() {}
    open func setNeedsStatusBarAppearanceUpdate() {}
    open func setNeedsUpdateOfScreenEdgesDeferringSystemGestures() {}
    open func setNeedsUpdateOfHomeIndicatorAutoHidden() {}
    open func updateViewConstraints() {}
    open func present(_ viewControllerToPresent: UIViewController, animated flag: Bool, completion: (() -> Void)? = nil) {}
    open func dismiss(animated flag: Bool, completion: (() -> Void)? = nil) {}
    open func addChild(_ childController: UIViewController) {}
    open func removeFromParent() {}
    open func didMove(toParent parent: UIViewController?) {}
    open func willMove(toParent parent: UIViewController?) {}
    open func show(_ vc: UIViewController, sender: Any?) {}
    open func showDetailViewController(_ vc: UIViewController, sender: Any?) {}
    open func presentAsSheet(_ viewController: UIViewController) {}
    open func dismissViewControllerAnimated(_ flag: Bool, completion: (() -> Void)?) {}
    open func beginAppearanceTransition(_ isAppearing: Bool, animated: Bool) {}
    open func endAppearanceTransition() {}
    open func setOverrideTraitCollection(_ collection: UITraitCollection?, forChild childViewController: UIViewController) {}
    open func canPerformAction(_ action: Selector, withSender sender: Any?) -> Bool { fatalError() }
}

public protocol UIViewControllerTransitionCoordinatorContext: AnyObject {}
open class UIViewControllerTransitionCoordinator: NSObject, UIViewControllerTransitionCoordinatorContext {}

public enum UIStatusBarStyle: Int { case `default` = 0, lightContent = 1, darkContent = 3 }
public enum UIStatusBarAnimation: Int { case none = 0, fade = 1, slide = 2 }
public struct UIRectEdge: OptionSet {
    public let rawValue: UInt
    public init(rawValue: UInt) { self.rawValue = rawValue }
    public static let none = UIRectEdge(rawValue: 0)
    public static let top = UIRectEdge(rawValue: 1)
    public static let left = UIRectEdge(rawValue: 2)
    public static let bottom = UIRectEdge(rawValue: 4)
    public static let right = UIRectEdge(rawValue: 8)
    public static let all = UIRectEdge(rawValue: 15)
}

open class UINavigationController: UIViewController {
    public override init(nibName nibNameOrNil: String?, bundle nibBundleOrNil: Bundle?) { super.init(nibName: nibNameOrNil, bundle: nibBundleOrNil) }
    open var viewControllers: [UIViewController] { get { fatalError() } set { fatalError() } }
    open var topViewController: UIViewController? { get { fatalError() } set { fatalError() } }
    open var isNavigationBarHidden: Bool { get { fatalError() } set { fatalError() } }
    open var navigationBar: UINavigationBar { get { fatalError() } set { fatalError() } }
    open var isToolbarHidden: Bool { get { fatalError() } set { fatalError() } }
    public init(rootViewController: UIViewController) { super.init(nibName: nil, bundle: nil) }
    public required init?(coder: NSCoder) { super.init(coder: coder) }
    open func pushViewController(_ viewController: UIViewController, animated: Bool) {}
    open func popViewController(animated: Bool) -> UIViewController? { fatalError() }
    open func popToRootViewController(animated: Bool) -> [UIViewController]? { fatalError() }
    open func setNavigationBarHidden(_ hidden: Bool, animated: Bool) {}
    open func setViewControllers(_ viewControllers: [UIViewController], animated: Bool) {}
}

open class UINavigationBar: UIView {
    open var barStyle: UIBarStyle { get { fatalError() } set { fatalError() } }
    open var isTranslucent: Bool { get { fatalError() } set { fatalError() } }
    open var titleTextAttributes: [NSAttributedString.Key: Any]? { get { fatalError() } set { fatalError() } }
    open var preferredHeight: CGFloat { get { fatalError() } set { fatalError() } }
    open func setBackgroundImage(_ backgroundImage: UIImage?, for barMetrics: UIBarMetrics) {}
    open func setShadowImage(_ shadowImage: UIImage?) {}
}

public enum UIBarStyle: Int { case `default` = 0, black = 1 }
public enum UIBarMetrics: Int { case `default` = 0, compact = 1 }

open class UINavigationItem: NSObject {
    open var title: String? { get { fatalError() } set { fatalError() } }
    open var titleView: UIView? { get { fatalError() } set { fatalError() } }
    open var prompt: String? { get { fatalError() } set { fatalError() } }
    open var leftBarButtonItem: UIBarButtonItem? { get { fatalError() } set { fatalError() } }
    open var rightBarButtonItem: UIBarButtonItem? { get { fatalError() } set { fatalError() } }
    open var leftBarButtonItems: [UIBarButtonItem]? { get { fatalError() } set { fatalError() } }
    open var rightBarButtonItems: [UIBarButtonItem]? { get { fatalError() } set { fatalError() } }
    open var backBarButtonItem: UIBarButtonItem? { get { fatalError() } set { fatalError() } }
    public init(title: String) { super.init() }
}

open class UIBarButtonItem: NSObject {
    public enum Style: Int { case plain = 0, bordered = 1, done = 2, cancel = 3 }
    public enum SystemItem: Int { case done = 0, cancel = 1, edit = 2, add = 4, flexibleSpace = 5, fixedSpace = 6 }
    open var title: String? { get { fatalError() } set { fatalError() } }
    open var image: UIImage? { get { fatalError() } set { fatalError() } }
    open var style: Style { get { fatalError() } set { fatalError() } }
    open var isEnabled: Bool { get { fatalError() } set { fatalError() } }
    open var tintColor: UIColor? { get { fatalError() } set { fatalError() } }
    open var menu: Any? { get { fatalError() } set { fatalError() } }
    public init(title: String?, style: Style, target: Any?, action: Selector?) { super.init() }
    public init(image: UIImage?, style: Style, target: Any?, action: Selector?) { super.init() }
    public init(barButtonSystemItem systemItem: SystemItem, target: Any?, action: Selector?) { super.init() }
    public init(customView: UIView) { super.init() }
}

public protocol UINavigationControllerDelegate: AnyObject {}

open class UITabBarController: UIViewController {
    open var viewControllers: [UIViewController]? { get { fatalError() } set { fatalError() } }
    open var selectedViewController: UIViewController? { get { fatalError() } set { fatalError() } }
    open var selectedIndex: Int { get { fatalError() } set { fatalError() } }
    open var tabBar: UITabBar { get { fatalError() } set { fatalError() } }
}
open class UITabBar: UIView {}
open class UISplitViewController: UIViewController {}

open class UIPopoverPresentationController: NSObject {
    open var barButtonItem: UIBarButtonItem?
    open var sourceView: UIView?
    open var sourceRect: CGRect
    open var permittedArrowDirections: UIPopoverArrowDirection
    open var popoverLayoutMargins: UIEdgeInsets
    open var backgroundColor: UIColor?
    open var delegate: UIPopoverPresentationControllerDelegate?
    public override init() { sourceRect = .zero; permittedArrowDirections = .any; popoverLayoutMargins = .zero; super.init() }
}

public struct UIPopoverArrowDirection: OptionSet {
    public let rawValue: UInt
    public init(rawValue: UInt) { self.rawValue = rawValue }
    public static let up = UIPopoverArrowDirection(rawValue: 1)
    public static let down = UIPopoverArrowDirection(rawValue: 2)
    public static let left = UIPopoverArrowDirection(rawValue: 4)
    public static let right = UIPopoverArrowDirection(rawValue: 8)
    public static let any = UIPopoverArrowDirection(rawValue: 15)
    public static let unknown = UIPopoverArrowDirection(rawValue: ~0)
}

public protocol UIPopoverPresentationControllerDelegate: AnyObject {}

open class UIContextMenuConfiguration: NSObject {}

open class UIDocumentInteractionController: NSObject {}

open class UIViewPropertyAnimator: NSObject {}
open class UIVisualEffectViewDimming {}

open class UINib: NSObject {}

open class UIKeyCommand: NSObject {}

// MARK: - 触觉 / 键盘通知

public extension Notification.Name {
    static let UIKeyboardWillShow = Notification.Name(rawValue: "UIKeyboardWillShowNotification")
    static let UIKeyboardWillHide = Notification.Name(rawValue: "UIKeyboardWillHideNotification")
    static let UIKeyboardDidShow = Notification.Name(rawValue: "UIKeyboardDidShowNotification")
    static let UIKeyboardWillChangeFrame = Notification.Name(rawValue: "UIKeyboardWillChangeFrameNotification")
    static let UIApplicationDidEnterBackground = Notification.Name(rawValue: "UIApplicationDidEnterBackgroundNotification")
    static let UIApplicationWillEnterForeground = Notification.Name(rawValue: "UIApplicationWillEnterForegroundNotification")
    static let UIApplicationDidBecomeActive = Notification.Name(rawValue: "UIApplicationDidBecomeActiveNotification")
    static let UIApplicationWillResignActive = Notification.Name(rawValue: "UIApplicationWillResignActiveNotification")
    static let UIDeviceOrientationDidChange = Notification.Name(rawValue: "UIDeviceOrientationDidChangeNotification")
    static let UIWindowDidBecomeKey = Notification.Name(rawValue: "UIWindowDidBecomeKeyNotification")
}
