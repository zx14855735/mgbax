// 追加声明：迭代类型检查时陆续发现的漏声明，集中放这里，便于维护。
// 全部只补签名（实现一律 fatalError 或空实现），不含任何业务逻辑。

// MARK: - Foundation

public extension String {
    init(contentsOf url: URL) throws { self.init() }
    init(contentsOfFile path: String) throws { self.init() }
    func write(to url: URL, atomically useAuxiliaryFile: Bool, encoding enc: String.Encoding) throws {}
    func write(toFile path: String, atomically useAuxiliaryFile: Bool, encoding enc: String.Encoding) throws {}
}

public extension Substring {
    func trimmingCharacters(in set: CharacterSet) -> String { fatalError() }
}

public extension FileHandle {
    func seekToEndOfFile() -> UInt64 { 0 }
    func readToEnd() throws -> Data? { nil }
    func synchronizeFile() {}
}

public enum QualityOfService: Int {
    case userInteractive = 0x21
    case userInitiated = 0x19
    case utility = 0x11
    case background = 0x09
    case `default` = -1
}

public extension Thread {
    convenience init(target: Any, selector: Selector, object argument: Any?) { self.init() }
    var stackSize: Int { get { fatalError() } set { fatalError() } }
    var qualityOfService: QualityOfService { get { fatalError() } set { fatalError() } }
}

public extension DispatchQueue {
    func async(execute work: DispatchWorkItem) {}
    func asyncAfter(deadline: DispatchTime, execute work: DispatchWorkItem) {}
}

// MARK: - UIKit

public extension UIViewController {
    var isBeingDismissed: Bool { fatalError() }
}

public extension UILabel {
    var isEnabled: Bool { get { fatalError() } set { fatalError() } }
}

public extension UIDocumentPickerViewController {
    convenience init(forExporting urls: [URL], asCopy: Bool) { self.init(forOpeningContentTypes: []) }
}

// MARK: - AVFoundation

public extension AVAudioFormat {
    var formatDescription: CMFormatDescription { fatalError() }
}

public extension CMTime {
    init(value: Int64, timescale: Int32) {
        self.init(value: value, timescale: timescale, flags: 1, epoch: 0)
    }
}

public extension PHAssetChangeRequest {
    var creationDate: Date? { get { fatalError() } set { fatalError() } }
}

// URL 书签 API：源码里用 `var stale = false`（Bool）取地址，
// Darwin 上 `UnsafeMutablePointer<ObjCBool>` 与 `&Bool` 之间是可用的，
// 这里用重载表达同一件事。
public extension URL {
    init(resolvingBookmarkData data: Data, options: URL.BookmarkResolutionOptions = [],
         relativeTo url: URL? = nil, bookmarkDataIsStale: UnsafeMutablePointer<Bool>? = nil) throws {
        fatalError()
    }
}

// MARK: - UIKit：旋转 / 弹窗

public extension UIViewController {
    var popoverPresentationController: UIPopoverPresentationController? { fatalError() }
    func setNeedsUpdateOfSupportedInterfaceOrientations() {}
    static func attemptRotationToDeviceOrientation() {}
}

public extension UIWindowScene {
    struct GeometryPreferences {
        public init() {}
        public static func iOS(interfaceOrientations: UIInterfaceOrientationMask) -> GeometryPreferences {
            GeometryPreferences()
        }
    }
    func requestGeometryUpdate(_ geometryPreferences: UIWindowScene.GeometryPreferences,
                               errorHandler: ((Error) -> Void)? = nil) {}
}

public extension FileHandle {
    convenience init?(forReadingAtPath path: String) { self.init(fileDescriptor: -1) }
}

public extension UserDefaults {
    func dictionaryRepresentation() -> [String: Any] { fatalError() }
    func set(_ value: Int, forKey defaultName: String) {}
    func set(_ value: Bool, forKey defaultName: String) {}
    func set(_ value: Double, forKey defaultName: String) {}
    func set(_ value: Float, forKey defaultName: String) {}
}

// MARK: - FoundationXML（Darwin 上 XMLParser 在 Foundation 里）

public protocol XMLParserDelegate: AnyObject {
    func parser(_ parser: XMLParser, didStartElement elementName: String,
                namespaceURI: String?, qualifiedName qName: String?,
                attributes attributeDict: [String: String])
    func parser(_ parser: XMLParser, didEndElement elementName: String,
                namespaceURI: String?, qualifiedName qName: String?)
    func parser(_ parser: XMLParser, foundCharacters string: String)
    func parser(_ parser: XMLParser, parseErrorOccurred parseError: Error)
    func parserDidEndDocument(_ parser: XMLParser)
    func parserDidStartDocument(_ parser: XMLParser)
}

public extension XMLParserDelegate {
    func parser(_ parser: XMLParser, didStartElement elementName: String,
                namespaceURI: String?, qualifiedName qName: String?,
                attributes attributeDict: [String: String]) {}
    func parser(_ parser: XMLParser, didEndElement elementName: String,
                namespaceURI: String?, qualifiedName qName: String?) {}
    func parser(_ parser: XMLParser, foundCharacters string: String) {}
    func parser(_ parser: XMLParser, parseErrorOccurred parseError: Error) {}
    func parserDidEndDocument(_ parser: XMLParser) {}
    func parserDidStartDocument(_ parser: XMLParser) {}
}

public class XMLParser: NSObject {
    public var delegate: XMLParserDelegate?
    public var shouldProcessNamespaces: Bool
    public var shouldReportNamespacePrefixes: Bool
    public var shouldResolveExternalEntities: Bool
    public var parseErrorOccurred: Bool { fatalError() }
    public var parserError: Error? { fatalError() }
    public init(data: Data) { shouldProcessNamespaces = false
        shouldReportNamespacePrefixes = false; shouldResolveExternalEntities = false
        super.init() }
    public init(stream: Any) { shouldProcessNamespaces = false
        shouldReportNamespacePrefixes = false; shouldResolveExternalEntities = false
        super.init() }
    public func parse() -> Bool { false }
}

public extension String {
    func caseInsensitiveCompare(_ aString: String) -> ComparisonResult { fatalError() }
}

public extension CharacterSet {
    mutating func remove(charactersIn string: String) {}
    mutating func remove(charactersIn range: Range<Unicode.Scalar>) {}
    mutating func insert(charactersIn string: String) {}
    mutating func formUnion(_ other: CharacterSet) {}
}
