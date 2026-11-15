// Foundation 的最小替身声明。
//
// 为什么需要它：Windows 版 Swift 工具链没有 MSVC/UCRT 头文件，
// `import Foundation` 会在 C 模块 'SwiftOverlayShims' 处直接失败
// （`'errno.h' file not found`），所以 Foundation 也必须自建。
//
// 只保证“签名成立”，实现一律 fatalError()。value type 允许实现，方便泛型推导。
// 这是 ios/typecheck 的已知边界：对 Foundation API 的签名核对强度有限，
// 真正被严格检查的是 Swift 语言层面（可选、泛型、闭包、override、穷尽性等）。

// MARK: - 基础

public typealias TimeInterval = Double
public typealias NSTimeInterval = Double

@_transparent
public func NSLog(_ format: String, _ args: Any...) {}

open class NSObject: Hashable {
    public init() {}
    public static func == (lhs: NSObject, rhs: NSObject) -> Bool { lhs === rhs }
    public func hash(into hasher: inout Hasher) { hasher.combine(ObjectIdentifier(self)) }
    open var description: String { fatalError() }
    open var debugDescription: String { fatalError() }
    open var hash: Int { fatalError() }
    open var hashValue: Int { fatalError() }
    open func isEqual(_ object: Any?) -> Bool { fatalError() }
    open func setValue(_ value: Any?, forKey key: String) {}
    open func setValue(_ value: Any?, forKeyPath keyPath: String) {}
    open func value(forKey key: String) -> Any? { nil }
    open func value(forKeyPath keyPath: String) -> Any? { nil }
    open func responds(to aSelector: Selector!) -> Bool { fatalError() }
    open func perform(_ aSelector: Selector!) -> Unmanaged<AnyObject>! { fatalError() }
    open class func isSubclass(of aClass: AnyClass) -> Bool { fatalError() }
}

public struct Selector: Hashable {
    public init() {}
    public init(_ str: String) {}
}

public typealias AnyClass = AnyObject.Type

public struct NSNull {
    public init() {}
    public static let `nil`: NSNull = NSNull()
}

public class NSError: NSObject {
    public var domain: String = ""
    public var code: Int = 0
    public var userInfo: [String: Any] = [:]
    open var localizedDescription: String { get { fatalError() } set { fatalError() } }
    public init(domain: String, code: Int, userInfo: [String: Any]? = nil) {
        self.domain = domain; self.code = code; super.init()
    }
}

public protocol LocalizedError: Error {
    var errorDescription: String? { get }
    var failureReason: String? { get }
    var recoverySuggestion: String? { get }
    var helpAnchor: String? { get }
}
public extension LocalizedError {
    var errorDescription: String? { nil }
    var failureReason: String? { nil }
    var recoverySuggestion: String? { nil }
    var helpAnchor: String? { nil }
}

public protocol CustomNSError: Error {
    static var errorDomain: String { get }
    var errorCode: Int { get }
    var errorUserInfo: [String: Any] { get }
}

public protocol RecoverableError: Error {
    func attemptRecovery(optionIndex recoveryOptionIndex: Int) -> Bool
}

public extension Error {
    var localizedDescription: String { fatalError() }
}

public protocol NSCopying { func copy(with zone: NSZone?) -> Any }
public protocol NSMutableCopying { func mutableCopy(with zone: NSZone?) -> Any }
public typealias NSZone = OpaquePointer

public struct NSRange {
    public var location: Int
    public var length: Int
    public init() { location = 0; length = 0 }
    public init(location: Int, length: Int) { self.location = location; self.length = length }
    public static let notFound: NSRange = NSRange(location: Int.max, length: 0)
    public init<R: RangeExpression>(_ region: R, in string: String) where R.Bound == String.Index {
        self.init(location: 0, length: string.count)
    }
    public init(location: Int, length: Int, in string: String) { self.init(location: location, length: length) }
}

// MARK: - 数值装盒

public class NSNumber: NSObject {
    public var intValue: Int { get { fatalError() } set { fatalError() } }
    public var int32Value: Int32 { get { fatalError() } set { fatalError() } }
    public var int64Value: Int64 { get { fatalError() } set { fatalError() } }
    public var uintValue: UInt { get { fatalError() } set { fatalError() } }
    public var doubleValue: Double { get { fatalError() } set { fatalError() } }
    public var floatValue: Float { get { fatalError() } set { fatalError() } }
    public var boolValue: Bool { get { fatalError() } set { fatalError() } }
    public var stringValue: String { get { fatalError() } set { fatalError() } }
    public init(value: Int) { super.init() }
    public init(value: Int32) { super.init() }
    public init(value: Int64) { super.init() }
    public init(value: UInt) { super.init() }
    public init(value: Double) { super.init() }
    public init(value: Float) { super.init() }
    public init(value: Bool) { super.init() }
}

// 近似点：Darwin 上 String 与 NSString 是桥接的；这里把 NSString 直接当成 String，
// 于是 `x as NSString` 语义变成无操作转换，NSString 的方法挂在 String 扩展上。
public typealias NSString = String

public extension String {
    init(format: String, _ args: Any...) { self = format }
    var length: Int { utf8.count }
    func substring(with range: NSRange) -> String { fatalError() }
    func substring(from index: Int) -> String { fatalError() }
    func substring(to index: Int) -> String { fatalError() }
    func boundingRect(with size: CGSize, options: NSStringDrawingOptions = [], attributes: [NSAttributedString.Key: Any]? = nil, context: NSStringDrawingContext? = nil) -> CGRect { fatalError() }
    func draw(with rect: CGRect, options: NSStringDrawingOptions = [], attributes: [NSAttributedString.Key: Any]? = nil, context: NSStringDrawingContext? = nil) {}
    func draw(at point: CGPoint, withAttributes attrs: [NSAttributedString.Key: Any]? = nil) {}
    func size(withAttributes attrs: [NSAttributedString.Key: Any]? = nil) -> CGSize { fatalError() }
    func replacingOccurrences(of target: String, with replacement: String, options: CompareOptions = [], range searchRange: Range<Index>? = nil) -> String { fatalError() }
    func components(separatedBy separator: String) -> [String] { fatalError() }
    func components(separatedBy separator: CharacterSet) -> [String] { fatalError() }
    var trimmingWhitespace: String { fatalError() }
    func trimmingCharacters(in set: CharacterSet) -> String { fatalError() }
    func addingPercentEncoding(withAllowedCharacters allowedCharacters: CharacterSet) -> String? { fatalError() }
    func range(of searchString: String, options mask: CompareOptions = [], range searchRange: Range<Index>? = nil, locale: Locale? = nil) -> Range<Index>? { fatalError() }
    func localizedStandardCompare(_ string: String) -> ComparisonResult { fatalError() }
    func compare(_ aString: String, options mask: CompareOptions = [], range: Range<Index>? = nil, locale: Locale? = nil) -> ComparisonResult { fatalError() }
    var removingPercentEncoding: String? { fatalError() }
    func addingPercentEscapes(using: String.Encoding) -> String? { fatalError() }
}

public struct CompareOptions: OptionSet {
    public let rawValue: UInt
    public init(rawValue: UInt) { self.rawValue = rawValue }
    public static let caseInsensitive = CompareOptions(rawValue: 1)
    public static let literal = CompareOptions(rawValue: 2)
    public static let backwards = CompareOptions(rawValue: 3)
    public static let anchored = CompareOptions(rawValue: 4)
    public static let numeric = CompareOptions(rawValue: 1 << 6)
    public static let regularExpression = CompareOptions(rawValue: 1 << 9)
    public static let caseInsensitiveRaw = CompareOptions(rawValue: 1)
}

public enum ComparisonResult: Int { case orderedAscending = -1, orderedSame = 0, orderedDescending = 1 }

public class NSAttributedString: NSObject {
    public struct Key: Hashable, RawRepresentable {
        public var rawValue: String
        public init(rawValue: String) { self.rawValue = rawValue }
        public static let font = Key(rawValue: "NSFont")
        public static let foregroundColor = Key(rawValue: "NSColor")
        public static let backgroundColor = Key(rawValue: "NSBackgroundColor")
        public static let paragraphStyle = Key(rawValue: "NSParagraphStyle")
        public static let kern = Key(rawValue: "NSKern")
        public static let strokeColor = Key(rawValue: "NSStrokeColor")
        public static let strokeWidth = Key(rawValue: "NSStrokeWidth")
        public static let shadow = Key(rawValue: "NSShadow")
        public static let baselineOffset = Key(rawValue: "NSBaselineOffset")
        public static let link = Key(rawValue: "NSLink")
    }
    public struct KeyColor: Hashable, RawRepresentable {
        public var rawValue: String
        public init(rawValue: String) { self.rawValue = rawValue }
    }
    public struct KeyFont: Hashable, RawRepresentable {
        public var rawValue: String
        public init(rawValue: String) { self.rawValue = rawValue }
    }
    public var string: String { get { fatalError() } set { fatalError() } }
    public var length: Int { get { fatalError() } set { fatalError() } }
    public init(string: String) { super.init() }
    public init(string: String, attributes: [NSAttributedString.Key: Any]?) { super.init() }
    public func attribute(_ attrName: NSAttributedString.Key, at location: Int, effectiveRange range: NSRangePointer?) -> Any? { fatalError() }
    public func enumerateAttribute(_ attrName: NSAttributedString.Key, in enumerationRange: NSRange, options opts: Int, using block: (Any?, NSRange, UnsafeMutablePointer<ObjCBool>) -> Void) {}
}

public class NSMutableAttributedString: NSAttributedString {
    public func append(_ attrString: NSAttributedString) {}
    public func addAttribute(_ name: NSAttributedString.Key, value: Any, range: NSRange) {}
}

public typealias NSRangePointer = UnsafeMutablePointer<NSRange>
public struct ObjCBool: ExpressibleByBooleanLiteral {
    public var boolValue: Bool
    public init(_ value: Bool) { boolValue = value }
    public init(booleanLiteral value: Bool) { boolValue = value }
}

public let NSForegroundColorAttributeName = NSAttributedString.KeyColor(rawValue: "NSColor")
public let NSFontAttributeName = NSAttributedString.KeyFont(rawValue: "NSFont")

// MARK: - Data

public struct Data: RandomAccessCollection, MutableCollection, RangeReplaceableCollection, Hashable {
    public typealias Element = UInt8
    public typealias Index = Int
    private var storage: [UInt8]

    public var bytes: [UInt8] { storage }

    public init() { storage = [] }
    public init(_ bytes: [UInt8]) { storage = bytes }
    public init<S: Sequence>(_ elements: S) where S.Element == UInt8 { storage = Array(elements) }
    public init(repeating repeatedValue: UInt8, count: Int) { storage = [UInt8](repeating: repeatedValue, count: count) }
    public init(count: Int) { storage = [UInt8](repeating: 0, count: count) }
    public init(capacity: Int) { storage = []; storage.reserveCapacity(capacity) }
    public init(bytes: [UInt8]) { storage = bytes }
    public init(bytes: UnsafeRawPointer, count: Int) {
        storage = Array(UnsafeBufferPointer(start: bytes.assumingMemoryBound(to: UInt8.self), count: count))
    }
    public init(base64Encoded base64String: String, options: Base64DecodingOptions = []) { storage = [] }
    public init(contentsOf url: URL, options: Data.ReadingOptions = []) throws { storage = [] }

    public typealias SubSequence = Data
    public var startIndex: Int { storage.startIndex }
    public var endIndex: Int { storage.endIndex }
    public subscript(position: Int) -> UInt8 {
        get { storage[position] }
        set { storage[position] = newValue }
    }
    public subscript(bounds: Range<Int>) -> Data {
        get { Data(Array(storage[bounds])) }
        set { storage[bounds] = ArraySlice(newValue.storage) }
    }
    public mutating func replaceSubrange<C: Collection>(_ subrange: Range<Int>, with newElements: C) where C.Element == UInt8 {
        storage.replaceSubrange(subrange, with: newElements)
    }

    public struct Base64DecodingOptions: OptionSet {
        public let rawValue: Int
        public init(rawValue: Int) { self.rawValue = rawValue }
        public static let ignoreUnknownCharacters = Base64DecodingOptions(rawValue: 1)
    }
    public struct Base64EncodingOptions: OptionSet {
        public let rawValue: Int
        public init(rawValue: Int) { self.rawValue = rawValue }
        public static let lineLength64Characters = Base64EncodingOptions(rawValue: 1)
        public static let lineLength76Characters = Base64EncodingOptions(rawValue: 2)
        public static let endLineWithCarriageReturn = Base64EncodingOptions(rawValue: 4)
        public static let endLineWithLineFeed = Base64EncodingOptions(rawValue: 8)
    }

    public func base64EncodedString(options: Base64EncodingOptions = []) -> String { fatalError() }
    public func base64EncodedData(options: Base64EncodingOptions = []) -> Data { fatalError() }
    public func subdata(in range: Range<Int>) -> Data { Data(Array(storage[range])) }
    public mutating func append(_ other: Data) { storage.append(contentsOf: other.storage) }
    public func withUnsafeBytes<ResultType>(_ body: (UnsafeRawBufferPointer) throws -> ResultType) rethrows -> ResultType {
        try storage.withUnsafeBytes(body)
    }
    public mutating func withUnsafeMutableBytes<ResultType>(_ body: (UnsafeMutableRawBufferPointer) throws -> ResultType) rethrows -> ResultType {
        try storage.withUnsafeMutableBytes(body)
    }
    public func write(to url: URL, options: Data.WritingOptions = []) throws {}
    public func write(toFile path: String, options: Data.WritingOptions = []) throws {}
    public func range(of dataToFind: Data, options: Data.SearchOptions = [], in range: Range<Int>? = nil) -> Range<Int>? { fatalError() }

    public struct WritingOptions: OptionSet {
        public let rawValue: Int
        public init(rawValue: Int) { self.rawValue = rawValue }
        public static let atomic = WritingOptions(rawValue: 1)
        public static let withoutOverwriting = WritingOptions(rawValue: 2)
    }
    public struct ReadingOptions: OptionSet {
        public let rawValue: Int
        public init(rawValue: Int) { self.rawValue = rawValue }
        public static let mappedIfSafe = ReadingOptions(rawValue: 1)
        public static let uncached = ReadingOptions(rawValue: 2)
    }
    public struct SearchOptions: OptionSet {
        public let rawValue: Int
        public init(rawValue: Int) { self.rawValue = rawValue }
        public static let backwards = SearchOptions(rawValue: 1)
        public static let anchored = SearchOptions(rawValue: 2)
    }

    public func advanced(by n: Int) -> Data { fatalError() }
    public func map<T>(_ transform: (UInt8) throws -> T) rethrows -> [T] { try storage.map(transform) }
    public var first: UInt8? { storage.first }
    public var last: UInt8? { storage.last }
    public static func random(in range: Range<UInt8>) -> Data { fatalError() }
}

public extension String {
    init(decoding data: Data, as: UTF8.Type) { self.init() }
    init?(data: Data, encoding: String.Encoding) { fatalError() }
    init?<S: Sequence>(bytes: S, encoding: String.Encoding) where S.Element == UInt8 { fatalError() }
    init?(bytes: UnsafePointer<UInt8>, length: Int, encoding: String.Encoding) { fatalError() }
    init(contentsOf url: URL, encoding: String.Encoding) throws { fatalError() }
    init?(data: Data, encoding: String.Encoding, flag: Bool) { fatalError() }
    func data(using encoding: String.Encoding, allowLossyConversion: Bool = false) -> Data? { fatalError() }
    var utf8Encoded: Data { fatalError() }
    struct Encoding: Hashable, RawRepresentable {
        public var rawValue: UInt
        public init(rawValue: UInt) { self.rawValue = rawValue }
        public static let utf8 = Encoding(rawValue: 4)
        public static let ascii = Encoding(rawValue: 1)
        public static let utf16 = Encoding(rawValue: 10)
        public static let isoLatin1 = Encoding(rawValue: 5)
    }
    func appendingPathComponent(_ str: String) -> String { fatalError() }
    func appendingPathExtension(_ str: String) -> String { fatalError() }
    var deletingPathExtension: String { fatalError() }
    var lastPathComponent: String { fatalError() }
    var pathExtension: String { fatalError() }
    var deletingLastPathComponent: String { fatalError() }
}

// MARK: - URL

public struct URL: Hashable, CustomStringConvertible {
    public var absoluteString: String
    public var path: String
    public var relativePath: String
    public var lastPathComponent: String
    public var pathExtension: String
    public var query: String?
    public var fragment: String?
    public var scheme: String?
    public var host: String?
    public var port: Int?
    public var isFileURL: Bool
    public var absoluteURL: URL { self }
    public var description: String { absoluteString }
    public var pathComponents: [String] { get { fatalError() } set { fatalError() } }

    public init?(string: String) {
        guard !string.isEmpty else { return nil }
        absoluteString = string; path = string; relativePath = string
        lastPathComponent = ""; pathExtension = ""; isFileURL = false
    }
    public init(fileURLWithPath path: String, isDirectory: Bool = false) {
        absoluteString = path; self.path = path; relativePath = path
        lastPathComponent = ""; pathExtension = ""; isFileURL = true
    }
    public init(fileURLWithPath path: String, relativeTo base: URL?) {
        absoluteString = path; self.path = path; relativePath = path
        lastPathComponent = ""; pathExtension = ""; isFileURL = true
    }
    public init?(string: String, relativeTo base: URL?) { self.init(string: string) }

    public var standardized: URL { self }
    public var standardizingPath: URL { self }
    public func deletingLastPathComponent() -> URL { self }
    public var standardizedFileURL: URL { self }
    public var resolvingSymlinksInPathURL: URL { self }
    public func deletingPathExtension() -> URL { self }
    public func appendingPathComponent(_ pathComponent: String, isDirectory: Bool = false) -> URL { self }
    public func appendingPathExtension(_ ext: String) -> URL { self }
    public func appending(queryItems: [URLQueryItem]) -> URL { self }
    public func resolvingSymlinksInPath() -> URL { self }
    public func startAccessingSecurityScopedResource() -> Bool { false }
    public func stopAccessingSecurityScopedResource() {}
    public func bookmarkData(options: URL.BookmarkCreationOptions = [], includingResourceValuesForKeys keys: Set<URLResourceKey>? = nil, relativeTo url: URL? = nil) throws -> Data { fatalError() }
    public init(resolvingBookmarkData data: Data, options: URL.BookmarkResolutionOptions = [], relativeTo url: URL? = nil, bookmarkDataIsStale: UnsafeMutablePointer<ObjCBool>? = nil) throws { fatalError() }
    public struct BookmarkCreationOptions: OptionSet {
        public let rawValue: UInt
        public init(rawValue: UInt) { self.rawValue = rawValue }
        public static let minimalBookmark = BookmarkCreationOptions(rawValue: 1 << 9)
        public static let suitableForBookmarkFile = BookmarkCreationOptions(rawValue: 1 << 10)
        public static let withSecurityScope = BookmarkCreationOptions(rawValue: 1 << 11)
        public static let securityScopeAllowOnlyReadAccess = BookmarkCreationOptions(rawValue: 1 << 12)
    }
    public struct BookmarkResolutionOptions: OptionSet {
        public let rawValue: UInt
        public init(rawValue: UInt) { self.rawValue = rawValue }
        public static let withoutUI = BookmarkResolutionOptions(rawValue: 1 << 8)
        public static let withoutMounting = BookmarkResolutionOptions(rawValue: 1 << 9)
        public static let withSecurityScope = BookmarkResolutionOptions(rawValue: 1 << 10)
    }

    public static let homeDirectory = URL(fileURLWithPath: "/")

    public func resourceValues(forKeys keys: Set<URLResourceKey>) throws -> URLResourceValues { fatalError() }
    public func setResourceValues(_ values: URLResourceValues) throws {}
    public var absoluteStringValue: String { absoluteString }

    public var queryItems: [URLQueryItem]? { get { fatalError() } set { fatalError() } }
    public var baseURL: URL? { nil }
}

public struct URLQueryItem: Hashable {
    public var name: String
    public var value: String?
    public init(name: String, value: String?) { self.name = name; self.value = value }
}

public struct URLComponents {
    public var scheme: String?
    public var host: String?
    public var port: Int?
    public var path: String
    public var query: String?
    public var queryItems: [URLQueryItem]?
    public var url: URL? { get { fatalError() } set { fatalError() } }
    public init() { path = "" }
    public init?(string: String) { path = "" }
    public init?(url: URL, resolvingAgainstBaseURL: Bool) { path = "" }
}

public struct URLRequest {
    public enum CachePolicy { case useProtocolCachePolicy, reloadIgnoringLocalCacheData }
    public var url: URL?
    public var httpMethod: String?
    public var httpBody: Data?
    public var httpShouldHandleCookies: Bool
    public var timeoutInterval: TimeInterval
    public var allHTTPHeaderFields: [String: String]?
    public var cachePolicy: CachePolicy
    public init(url: URL, cachePolicy: CachePolicy = .useProtocolCachePolicy, timeoutInterval: TimeInterval = 60) {
        self.url = url; httpMethod = "GET"; httpShouldHandleCookies = true
        self.timeoutInterval = timeoutInterval; self.cachePolicy = cachePolicy
    }
    public init(url: URL) { self.init(url: url, cachePolicy: .useProtocolCachePolicy, timeoutInterval: 60) }
    public mutating func setValue(_ value: String?, forHTTPHeaderField field: String) {}
    public func value(forHTTPHeaderField field: String) -> String? { fatalError() }
    public mutating func addValue(_ value: String, forHTTPHeaderField field: String) {}
}

open class URLResponse: NSObject {
    public var url: URL? { get { fatalError() } set { fatalError() } }
    public var mimeType: String? { get { fatalError() } set { fatalError() } }
    public var expectedContentLength: Int64 { get { fatalError() } set { fatalError() } }
    public var textEncodingName: String? { get { fatalError() } set { fatalError() } }
    public var suggestedFilename: String? { get { fatalError() } set { fatalError() } }
    public override init() { super.init() }
}

public class HTTPURLResponse: URLResponse {
    public var statusCode: Int { get { fatalError() } set { fatalError() } }
    public var allHeaderFields: [AnyHashable: Any] { get { fatalError() } set { fatalError() } }
    public func value(forHTTPHeaderField field: String) -> String? { fatalError() }
}

public class URLCredential: NSObject {
    public enum Persistence: UInt { case none = 0, session = 1, permanent = 2 }
    public init(trust: SecTrust) { super.init() }
    public init(user: String, password: String, persistence: Persistence) { super.init() }
}

public class SecTrust {}

open class URLAuthenticationChallenge: NSObject {
    public var protectionSpace: URLProtectionSpace { fatalError() }
    public var previousFailureCount: Int { fatalError() }
    public var proposedCredential: URLCredential? { fatalError() }
    public var error: Error? { fatalError() }
    public var failureResponse: URLResponse? { fatalError() }
    public var sender: AnyObject? { fatalError() }
}

public let NSURLAuthenticationMethodServerTrust = "NSURLAuthenticationMethodServerTrust"
public let NSURLAuthenticationMethodDefault = "NSURLAuthenticationMethodDefault"
public let NSURLAuthenticationMethodHTTPBasic = "NSURLAuthenticationMethodHTTPBasic"

open class URLSessionConfiguration: NSObject {
    public static let `default` = URLSessionConfiguration()
    public static let ephemeral = URLSessionConfiguration()
    public var timeoutIntervalForRequest: TimeInterval
    public var timeoutIntervalForResource: TimeInterval
    public var waitsForConnectivity: Bool
    public var allowsCellularAccess: Bool
    public var httpMaximumConnectionsPerHost: Int
    public var requestCachePolicy: URLRequest.CachePolicy
    public var httpAdditionalHeaders: [AnyHashable: Any]?
    public var urlCache: Any?
    public var protocolClasses: [AnyClass]?
    public override init() {
        timeoutIntervalForRequest = 60; timeoutIntervalForResource = 604800
        waitsForConnectivity = false; allowsCellularAccess = true
        httpMaximumConnectionsPerHost = 6
        requestCachePolicy = .useProtocolCachePolicy
        super.init()
    }
}

open class URLSessionWebSocketTask: URLSessionTask {
    public enum Message {
        case data(Data)
        case string(String)
    }
    public struct CloseCode: RawRepresentable, Hashable {
        public var rawValue: Int
        public init(rawValue: Int) { self.rawValue = rawValue }
        public static let invalid = CloseCode(rawValue: 0)
        public static let normalClosure = CloseCode(rawValue: 1000)
        public static let goingAway = CloseCode(rawValue: 1001)
        public static let protocolError = CloseCode(rawValue: 1002)
        public static let unsupportedData = CloseCode(rawValue: 1003)
        public static let noStatusReceived = CloseCode(rawValue: 1005)
        public static let abnormalClosure = CloseCode(rawValue: 1006)
        public static let invalidFramePayloadData = CloseCode(rawValue: 1007)
        public static let policyViolation = CloseCode(rawValue: 1008)
        public static let messageTooBig = CloseCode(rawValue: 1009)
        public static let mandatoryExtensionMissing = CloseCode(rawValue: 1010)
        public static let internalServerError = CloseCode(rawValue: 1011)
    }
    public var maximumMessageSize: Int { fatalError() }
    public var closeCode: CloseCode { fatalError() }
    public var closeReason: Data? { fatalError() }
    public func send(_ message: Message, completionHandler: ((Error?) -> Void)? = nil) {}
    public func receive(completionHandler: @escaping (Result<Message, Error>) -> Void) {}
    public func sendPing(pongReceiveHandler: @escaping (Error?) -> Void) {}
    public func cancel(with closeCode: CloseCode, reason: Data?) {}
}

public extension URLSessionDelegate {
    func urlSession(_ session: URLSession, didReceive challenge: URLAuthenticationChallenge,
                    completionHandler: @escaping (URLSession.AuthChallengeDisposition, URLCredential?) -> Void) {}
}

public class URLCredentialStorage: NSObject {
    public static let shared = URLCredentialStorage()
    public func set(_ credential: URLCredential, for protectionSpace: URLProtectionSpace) {}
    public func remove(_ credential: URLCredential, for protectionSpace: URLProtectionSpace) {}
}

public class URLProtectionSpace: NSObject {
    public var host: String { get { fatalError() } set { fatalError() } }
    public var port: Int { get { fatalError() } set { fatalError() } }
    public var realm: String? { get { fatalError() } set { fatalError() } }
    public var authenticationMethod: String { get { fatalError() } set { fatalError() } }
    public var serverTrust: SecTrust? { get { fatalError() } set { fatalError() } }
    public var `protocol`: String? { get { fatalError() } set { fatalError() } }
    public var isProxy: Bool { get { fatalError() } set { fatalError() } }
}

public protocol URLSessionDelegate: AnyObject {}
public protocol URLSessionTaskDelegate: URLSessionDelegate {}
public protocol URLSessionDataDelegate: URLSessionTaskDelegate {}
public protocol URLSessionDownloadDelegate: URLSessionTaskDelegate {
    func urlSession(_ session: URLSession, downloadTask: URLSessionDownloadTask, didFinishDownloadingTo location: URL)
}

open class URLSessionTask: NSObject {
    public var taskIdentifier: Int { get { fatalError() } set { fatalError() } }
    public var originalRequest: URLRequest? { get { fatalError() } set { fatalError() } }
    public var response: URLResponse? { get { fatalError() } set { fatalError() } }
    public var error: Error? { get { fatalError() } set { fatalError() } }
    public func resume() {}
    public func suspend() {}
    public func cancel() {}
    public var state: URLSessionTask.State { fatalError() }
    public enum State { case running, suspended, canceling, completed }
}

open class URLSessionDataTask: URLSessionTask {}
open class URLSessionUploadTask: URLSessionDataTask {}
open class URLSessionDownloadTask: URLSessionTask {}

open class URLSession: NSObject {
    public enum AuthChallengeDisposition {
        case useCredential
        case performDefaultHandling
        case cancelAuthenticationChallenge
        case rejectProtectionSpace
    }

    public struct Configuration {
        public var timeoutIntervalForRequest: TimeInterval
        public var timeoutIntervalForResource: TimeInterval
        public var httpMaximumConnectionsPerHost: Int
        public var requestCachePolicy: URLRequest.CachePolicy
        public var allowsCellularAccess: Bool
        public var waitsForConnectivity: Bool
        public init() {
            timeoutIntervalForRequest = 60; timeoutIntervalForResource = 604800
            httpMaximumConnectionsPerHost = 6
            requestCachePolicy = .useProtocolCachePolicy
            allowsCellularAccess = true; waitsForConnectivity = false
        }
        public static var `default`: Configuration { Configuration() }
        public static var ephemeral: Configuration { Configuration() }
    }

    public static let shared = URLSession(configuration: .default)
    public var delegate: URLSessionDelegate? { get { fatalError() } set { fatalError() } }
    public var configuration: Configuration { get { fatalError() } set { fatalError() } }
    public var delegateQueue: OperationQueue? { get { fatalError() } set { fatalError() } }

    public init(configuration: URLSessionConfiguration, delegate: URLSessionDelegate? = nil, delegateQueue queue: OperationQueue? = nil) {}
    public func webSocketTask(with request: URLRequest) -> URLSessionWebSocketTask { fatalError() }
    public func webSocketTask(with url: URL) -> URLSessionWebSocketTask { fatalError() }
    public func webSocketTask(with url: URL, protocols: [String]) -> URLSessionWebSocketTask { fatalError() }
    public init(configuration: Configuration) {}
    override public init() {}

    public func dataTask(with request: URLRequest, completionHandler: @escaping (Data?, URLResponse?, Error?) -> Void) -> URLSessionDataTask { fatalError() }
    public func dataTask(with url: URL, completionHandler: @escaping (Data?, URLResponse?, Error?) -> Void) -> URLSessionDataTask { fatalError() }
    public func uploadTask(with request: URLRequest, from bodyData: Data?, completionHandler: @escaping (Data?, URLResponse?, Error?) -> Void) -> URLSessionUploadTask { fatalError() }
    public func uploadTask(with request: URLRequest, fromFile fileURL: URL, completionHandler: @escaping (Data?, URLResponse?, Error?) -> Void) -> URLSessionUploadTask { fatalError() }
    public func downloadTask(with request: URLRequest, completionHandler: @escaping (URL?, URLResponse?, Error?) -> Void) -> URLSessionDownloadTask { fatalError() }
    public func downloadTask(with url: URL, completionHandler: @escaping (URL?, URLResponse?, Error?) -> Void) -> URLSessionDownloadTask { fatalError() }
    public func data(for request: URLRequest, delegate: URLSessionTaskDelegate? = nil) async throws -> (Data, URLResponse) { fatalError() }
    public func data(from url: URL, delegate: URLSessionTaskDelegate? = nil) async throws -> (Data, URLResponse) { fatalError() }
    public func upload(for request: URLRequest, from bodyData: Data, delegate: URLSessionTaskDelegate? = nil) async throws -> (Data, URLResponse) { fatalError() }
    public func download(for request: URLRequest, delegate: URLSessionTaskDelegate? = nil) async throws -> (URL, URLResponse) { fatalError() }
    public func invalidateAndCancel() {}
    public func finishTasksAndInvalidate() {}
    public func flush(completionHandler: @escaping () -> Void) {}
}

// MARK: - Date / 时间

public struct Date: Hashable, Comparable, CustomStringConvertible {
    public var timeIntervalSince1970: TimeInterval
    public var timeIntervalSinceNow: TimeInterval { get { fatalError() } set { fatalError() } }
    public var timeIntervalSinceReferenceDate: TimeInterval { get { fatalError() } set { fatalError() } }
    public var description: String { fatalError() }
    public init() { timeIntervalSince1970 = 0 }
    public init(timeIntervalSince1970: TimeInterval) { self.timeIntervalSince1970 = timeIntervalSince1970 }
    public init(timeIntervalSince1970: TimeInterval, /* ignore */ _ x: Int = 0) { self.timeIntervalSince1970 = timeIntervalSince1970 }
    public init(timeIntervalSinceNow: TimeInterval) { timeIntervalSince1970 = timeIntervalSinceNow }
    public init(timeIntervalSinceReferenceDate: TimeInterval) { timeIntervalSince1970 = timeIntervalSinceReferenceDate }
    public static func < (lhs: Date, rhs: Date) -> Bool { lhs.timeIntervalSince1970 < rhs.timeIntervalSince1970 }
    public static let distantPast = Date(timeIntervalSince1970: -62135769600)
    public static let distantFuture = Date(timeIntervalSince1970: 64092211200)
    public func addingTimeInterval(_ ti: TimeInterval) -> Date { Date(timeIntervalSince1970: timeIntervalSince1970 + ti) }
    public func timeIntervalSince(_ date: Date) -> TimeInterval { timeIntervalSince1970 - date.timeIntervalSince1970 }
    public var description2: String { get { fatalError() } set { fatalError() } }
}

public struct Calendar {
    public struct Identifier: RawRepresentable, Hashable {
        public var rawValue: String
        public init(rawValue: String) { self.rawValue = rawValue }
        public static let gregorian = Identifier(rawValue: "gregorian")
    }
    public struct Component { public static let year = 1, month = 2, day = 3 }
    public var identifier: Identifier
    public var timeZone: TimeZone
    public init(identifier: Identifier) { self.identifier = identifier; timeZone = TimeZone(identifier: "UTC") ?? TimeZone() }
    public static var current: Calendar { Calendar(identifier: .gregorian) }
    public var isDateInToday: (Date) -> Bool { { _ in false } }
    public func date(from components: DateComponents) -> Date? { fatalError() }
    public func dateComponents(_ components: [Int], from date: Date) -> DateComponents { fatalError() }
    public var component: (Int, Date) -> Int { { _, _ in 0 } }
}

public struct DateComponents {
    public var year: Int?
    public var month: Int?
    public var day: Int?
    public var hour: Int?
    public var minute: Int?
    public var second: Int?
    public init() {}
}

public struct TimeZone {
    public var identifier: String { get { fatalError() } set { fatalError() } }
    public init() {}
    public init?(identifier: String) { return nil }
    public init(secondsFromGMT: Int) {}
    public static var current: TimeZone { TimeZone() }
    public var secondsFromGMT: Int { 0 }
}

public struct Locale {
    public var identifier: String
    public init(identifier: String) { self.identifier = identifier }
    public static var current: Locale { Locale(identifier: "en_US") }
}

public class DateFormatter: NSObject {
    public enum Style { case none, short, medium, long, full }
    public var dateFormat: String = ""
    public var dateStyle: Style = .medium
    public var timeStyle: Style = .medium
    public var timeZone: TimeZone? = nil
    public var locale: Locale = .current
    public var string: (Date) -> String { { _ in "" } }
    public func string(from date: Date) -> String { fatalError() }
    public func date(from string: String) -> Date? { fatalError() }
}

public class ISO8601DateFormatter: NSObject {
    public enum Options: UInt {
        case withInternetDateTime = 1
        case withFractionalSeconds = 2
    }
    public var formatOptions: Options = .withInternetDateTime
    public func string(from date: Date) -> String { fatalError() }
    public func date(from string: String) -> Date? { fatalError() }
}

// MARK: - 文件系统

open class FileManager: NSObject {
    public static let `default` = FileManager()
    public var currentDirectoryPath: String { get { fatalError() } set { fatalError() } }
    public var homeDirectoryForCurrentUser: URL { URL(fileURLWithPath: "/") }
    public var temporaryDirectory: URL { URL(fileURLWithPath: "/tmp") }
    public var urls: (Int, Int) -> [URL] { { _, _ in [] } }

    public func urls(for directory: FileManager.SearchPathDirectory, in domainMask: FileManager.SearchPathDomainMask) -> [URL] { fatalError() }
    public func url(for directory: FileManager.SearchPathDirectory, in domain: FileManager.SearchPathDomainMask, appropriateFor url: URL?, create shouldCreate: Bool) throws -> URL { fatalError() }
    public func fileExists(atPath path: String) -> Bool { fatalError() }
    public func fileExists(atPath path: String, isDirectory: UnsafeMutablePointer<ObjCBool>?) -> Bool { fatalError() }
    public func createDirectory(at url: URL, withIntermediateDirectories createIntermediates: Bool, attributes: [FileAttributeKey: Any]? = nil) throws {}
    public func createDirectory(atPath path: String, withIntermediateDirectories createIntermediates: Bool, attributes: [FileAttributeKey: Any]? = nil) throws {}
    public func contentsOfDirectory(at url: URL, includingPropertiesForKeys keys: [URLResourceKey]?, options mask: FileManager.DirectoryEnumerationOptions = []) throws -> [URL] { fatalError() }
    public func contentsOfDirectory(atPath path: String) throws -> [String] { fatalError() }
    public func removeItem(at url: URL) throws {}
    public func removeItem(atPath path: String) throws {}
    public func copyItem(at srcURL: URL, to dstURL: URL) throws {}
    public func copyItem(atPath srcPath: String, toPath dstPath: String) throws {}
    public func moveItem(at srcURL: URL, to dstURL: URL) throws {}
    public func moveItem(atPath srcPath: String, toPath dstPath: String) throws {}
    public func attributesOfItem(atPath path: String) throws -> [FileAttributeKey: Any] { fatalError() }
    public func setAttributes(_ attributes: [FileAttributeKey: Any], ofItemAtPath path: String) throws {}
    public func contents(atPath path: String) -> Data? { fatalError() }
    public func createFile(atPath path: String, contents data: Data?, attributes attr: [FileAttributeKey: Any]? = nil) -> Bool { fatalError() }
    public func replaceItemAt(_ originalItemURL: URL, withItemAt newItemURL: URL, backupItemName: String?, options: FileManager.ItemReplacementOptions = []) throws -> URL? { fatalError() }
    public func isDeletableFile(atPath path: String) -> Bool { fatalError() }
    public func isReadableFile(atPath path: String) -> Bool { fatalError() }
    public func isWritableFile(atPath path: String) -> Bool { fatalError() }
    public func isExecutableFile(atPath path: String) -> Bool { fatalError() }
    public func enumerator(at url: URL, includingPropertiesForKeys keys: [URLResourceKey]?, options mask: FileManager.DirectoryEnumerationOptions = [], errorHandler handler: ((URL, Error) -> Bool)? = nil) -> FileManager.DirectoryEnumerator? { fatalError() }
    public func enumerator(atPath path: String) -> FileManager.DirectoryEnumerator? { fatalError() }

    public struct SearchPathDirectory: Hashable, RawRepresentable {
        public var rawValue: UInt
        public init(rawValue: UInt) { self.rawValue = rawValue }
        public static let applicationDirectory = SearchPathDirectory(rawValue: 1)
        public static let demoApplicationDirectory = SearchPathDirectory(rawValue: 2)
        public static let developerApplicationDirectory = SearchPathDirectory(rawValue: 3)
        public static let adminApplicationDirectory = SearchPathDirectory(rawValue: 4)
        public static let libraryDirectory = SearchPathDirectory(rawValue: 5)
        public static let developerDirectory = SearchPathDirectory(rawValue: 6)
        public static let userDirectory = SearchPathDirectory(rawValue: 7)
        public static let documentationDirectory = SearchPathDirectory(rawValue: 8)
        public static let documentDirectory = SearchPathDirectory(rawValue: 9)
        public static let coreServiceDirectory = SearchPathDirectory(rawValue: 10)
        public static let cachesDirectory = SearchPathDirectory(rawValue: 13)
        public static let applicationSupportDirectory = SearchPathDirectory(rawValue: 14)
        public static let downloadsDirectory = SearchPathDirectory(rawValue: 15)
        public static let moviesDirectory = SearchPathDirectory(rawValue: 17)
        public static let musicDirectory = SearchPathDirectory(rawValue: 18)
        public static let picturesDirectory = SearchPathDirectory(rawValue: 19)
        public static let temporaryDirectory = SearchPathDirectory(rawValue: 99)
    }
    public struct SearchPathDomainMask: OptionSet {
        public let rawValue: UInt
        public init(rawValue: UInt) { self.rawValue = rawValue }
        public static let userDomainMask = SearchPathDomainMask(rawValue: 1)
    }
    public struct DirectoryEnumerationOptions: OptionSet {
        public let rawValue: UInt
        public init(rawValue: UInt) { self.rawValue = rawValue }
        public static let skipsHiddenFiles = DirectoryEnumerationOptions(rawValue: 1)
    }
    public struct ItemReplacementOptions: OptionSet {
        public let rawValue: UInt
        public init(rawValue: UInt) { self.rawValue = rawValue }
    }
}

public extension FileManager {
    class DirectoryEnumerator: NSEnumerator, Sequence {
        public func makeIterator() -> AnyIterator<Any> { AnyIterator { nil } }
        public var level: Int { fatalError() }
        public var fileAttributes: [FileAttributeKey: Any]? { fatalError() }
        public var directoryAttributes: [FileAttributeKey: Any]? { fatalError() }
    }
}

open class NSEnumerator: NSObject {
    open func nextObject() -> Any? { nil }
    open var allObjects: [Any] { fatalError() }
}

public struct FileAttributeKey: Hashable, RawRepresentable {
    public var rawValue: String
    public init(rawValue: String) { self.rawValue = rawValue }
    public static let modificationDate = FileAttributeKey(rawValue: "NSFileModificationDate")
    public static let size = FileAttributeKey(rawValue: "NSFileSize")
}

public struct URLResourceKey: Hashable, RawRepresentable {
    public var rawValue: String
    public init(rawValue: String) { self.rawValue = rawValue }
    public static let fileSizeKey = URLResourceKey(rawValue: "NSURLFileSizeKey")
    public static let isDirectoryKey = URLResourceKey(rawValue: "NSURLIsDirectoryKey")
    public static let contentModificationDateKey = URLResourceKey(rawValue: "NSURLContentModificationDateKey")
}

public struct URLResourceValues {
    public var isDirectory: Bool?
    public var fileSize: Int?
    public var contentModificationDate: Date?
    public var creationDate: Date?
    public var isRegularFile: Bool?
    public var name: String?
    public var fileExtension: String?
    public var isReadable: Bool?
    public var isWritable: Bool?
    public var totalFileAllocatedSize: Int?
    public init() {}
}

public class FileHandle: NSObject {
    public var availableData: Data { get { fatalError() } set { fatalError() } }
    public var offsetInFile: UInt64 { get { fatalError() } set { fatalError() } }
    public var readabilityHandler: ((FileHandle) -> Void)? { get { fatalError() } set { fatalError() } }
    public init(fileDescriptor fd: Int32) { super.init() }
    public convenience init(forReadingFrom url: URL) throws { self.init(fileDescriptor: -1) }
    public convenience init(forWritingTo url: URL) throws { self.init(fileDescriptor: -1) }
    public convenience init(forUpdating url: URL) throws { self.init(fileDescriptor: -1) }
    public func readDataToEndOfFile() -> Data { fatalError() }
    public func readData(ofLength length: Int) -> Data { fatalError() }
    public func write(_ data: Data) {}
    public func write(contentsOf data: Data) throws {}
    public func seekToEnd() -> UInt64 { fatalError() }
    public func seek(toFileOffset offset: UInt64) {}
    public func closeFile() {}
    public func read(upToCount count: Int) throws -> Data? { fatalError() }
    public func close() throws {}
    public var isClosed: Bool { get { fatalError() } set { fatalError() } }
    public class func fileHandleForReadingAtPath(_ path: String) -> FileHandle? { fatalError() }
    public class func fileHandleForWritingAtPath(_ path: String) -> FileHandle? { fatalError() }
    public class func fileHandleForUpdatingAtPath(_ path: String) -> FileHandle? { fatalError() }
}

// MARK: - Bundle / 进程 / 偏好

open class Bundle: NSObject {
    public static let main = Bundle()
    public var bundleIdentifier: String? { get { fatalError() } set { fatalError() } }
    public var infoDictionary: [String: Any]? { get { fatalError() } set { fatalError() } }
    public var bundlePath: String { get { fatalError() } set { fatalError() } }
    public func path(forResource name: String?, ofType ext: String?) -> String? { fatalError() }
    public func url(forResource name: String?, withExtension ext: String?) -> URL? { fatalError() }
    public func object(forInfoDictionaryKey key: String) -> Any? { fatalError() }
}

open class ProcessInfo: NSObject {
    public static let processInfo = ProcessInfo()
    public var processIdentifier: Int32 { get { fatalError() } set { fatalError() } }
    public var environment: [String: String] { get { fatalError() } set { fatalError() } }
    public var arguments: [String] { get { fatalError() } set { fatalError() } }
    public var operatingSystemVersion: OperatingSystemVersion { get { fatalError() } set { fatalError() } }
    public var physicalMemory: UInt64 { get { fatalError() } set { fatalError() } }
    public var processorCount: Int { get { fatalError() } set { fatalError() } }
    public var systemUptime: TimeInterval { get { fatalError() } set { fatalError() } }
    public func isOperatingSystemAtLeast(_ version: OperatingSystemVersion) -> Bool { fatalError() }
    public var isLowPowerModeEnabled: Bool { get { fatalError() } set { fatalError() } }
}

public struct OperatingSystemVersion {
    public var majorVersion: Int
    public var minorVersion: Int
    public var patchVersion: Int
    public init(majorVersion: Int, minorVersion: Int, patchVersion: Int) {
        self.majorVersion = majorVersion; self.minorVersion = minorVersion; self.patchVersion = patchVersion
    }
}

open class UserDefaults: NSObject {
    public static let standard = UserDefaults()
    public func object(forKey defaultName: String) -> Any? { fatalError() }
    public func set(_ value: Any?, forKey defaultName: String) {}
    public func string(forKey defaultName: String) -> String? { fatalError() }
    public func integer(forKey defaultName: String) -> Int { fatalError() }
    public func bool(forKey defaultName: String) -> Bool { fatalError() }
    public func double(forKey defaultName: String) -> Double { fatalError() }
    public func data(forKey defaultName: String) -> Data? { fatalError() }
    public func dictionary(forKey defaultName: String) -> [String: Any]? { fatalError() }
    public func array(forKey defaultName: String) -> [Any]? { fatalError() }
    public func removeObject(forKey defaultName: String) {}
    public func synchronize() -> Bool { fatalError() }
    public func register(defaults registrationDictionary: [String: Any]) {}
    public func persistentDomain(forName domainName: String) -> [String: Any]? { fatalError() }
    public func stringArray(forKey defaultName: String) -> [String]? { fatalError() }
    public func float(forKey defaultName: String) -> Float { fatalError() }
    public func object_isForced(forKey key: String) -> Bool { false }
}

// MARK: - 通知 / 定时器 / 线程

public struct Notification {
    public struct Name: Hashable, RawRepresentable {
        public var rawValue: String
        public init(rawValue: String) { self.rawValue = rawValue }
    }
    public var name: Notification.Name
    public var object: Any?
    public var userInfo: [AnyHashable: Any]?
    public init(name: Notification.Name, object: Any? = nil, userInfo: [AnyHashable: Any]? = nil) {
        self.name = name; self.object = object; self.userInfo = userInfo
    }
}

open class NotificationCenter: NSObject {
    public static let `default` = NotificationCenter()
    public func addObserver(forName name: Notification.Name?, object obj: Any?, queue: OperationQueue?, using block: @escaping (Notification) -> Void) -> NSObjectProtocol { fatalError() }
    public func addObserver(_ observer: Any, selector aSelector: Selector, name aName: Notification.Name?, object anObject: Any?) {}
    public func removeObserver(_ observer: Any) {}
    public func removeObserver(_ observer: Any, name aName: Notification.Name?, object anObject: Any?) {}
    public func post(_ notification: Notification) {}
    public func post(name aName: Notification.Name, object anObject: Any?, userInfo aUserInfo: [AnyHashable: Any]? = nil) {}
}

public protocol NSObjectProtocol: AnyObject {}
extension NSObject: NSObjectProtocol {}

open class Timer: NSObject {
    public var timeInterval: TimeInterval { get { fatalError() } set { fatalError() } }
    public var isValid: Bool { get { fatalError() } set { fatalError() } }
    public var fireDate: Date { get { fatalError() } set { fatalError() } }
    public static func scheduledTimer(timeInterval ti: TimeInterval, target aTarget: Any, selector aSelector: Selector, userInfo: Any?, repeats yesOrNo: Bool) -> Timer { fatalError() }
    public static func scheduledTimer(timeInterval ti: TimeInterval, repeats yesOrNo: Bool, block: @escaping (Timer) -> Void) -> Timer { fatalError() }
    public static func scheduledTimer(withTimeInterval interval: TimeInterval, repeats: Bool, block: @escaping (Timer) -> Void) -> Timer { fatalError() }
    public init(timeInterval ti: TimeInterval, repeats yesOrNo: Bool, block: @escaping (Timer) -> Void) { super.init() }
    public func invalidate() {}
    public func fire() {}
}

open class RunLoop: NSObject {
    public static let main = RunLoop()
    public static var current: RunLoop { RunLoop() }
    public var currentMode: Any? { nil }
    public func run() {}
    public func run(mode: Any, before limitDate: Date) -> Bool { false }
    public func add(_ timer: Timer, forMode mode: RunLoop.Mode) {}
    public func run(mode: RunLoop.Mode, before limitDate: Date) -> Bool { false }
    public struct Mode: Hashable, RawRepresentable {
        public var rawValue: String
        public init(rawValue: String) { self.rawValue = rawValue }
        public static let `default` = Mode(rawValue: "kCFRunLoopDefaultMode")
        public static let common = Mode(rawValue: "kCFRunLoopCommonModes")
        public static let tracking = Mode(rawValue: "UITrackingRunLoopMode")
        public static let eventTracking = Mode(rawValue: "NSEventTrackingRunLoopMode")
    }
}

open class Thread: NSObject {
    public var isMainThread: Bool { get { fatalError() } set { fatalError() } }
    public static var isMainThread: Bool { fatalError() }
    public static var current: Thread { Thread() }
    public var threadDictionary: NSMutableDictionary { get { fatalError() } set { fatalError() } }
    public override init() { super.init() }
    public init(block: @escaping () -> Void) { super.init() }
    public func start() {}
    public class func sleep(forTimeInterval ti: TimeInterval) {}
    public class func sleep(until date: Date) {}
    public var name: String? { get { fatalError() } set { fatalError() } }
}

// MARK: - 锁

open class NSLock: NSObject {
    public override init() { super.init() }
    public func lock() {}
    public func unlock() {}
    public func tryLock() -> Bool { fatalError() }
    public var name: String? { get { fatalError() } set { fatalError() } }
}

open class NSRecursiveLock: NSObject {
    public override init() { super.init() }
    public func lock() {}
    public func unlock() {}
    public func tryLock() -> Bool { fatalError() }
}

open class NSCondition: NSObject {
    public override init() { super.init() }
    public func lock() {}
    public func unlock() {}
    public func wait() {}
    public func wait(until limitDate: Date) -> Bool { fatalError() }
    public func signal() {}
    public func broadcast() {}
}

open class NSConditionLock: NSObject {
    public var condition: Int { get { fatalError() } set { fatalError() } }
    public init(condition: Int) { super.init() }
    public func lock(whenCondition condition: Int) {}
    public func unlock(withCondition condition: Int) {}
}

// MARK: - JSON / 序列化

public class JSONSerialization: NSObject {
    public struct ReadingOptions: OptionSet {
        public let rawValue: UInt
        public init(rawValue: UInt) { self.rawValue = rawValue }
        public static let mutableContainers = ReadingOptions(rawValue: 1)
        public static let fragmentsAllowed = ReadingOptions(rawValue: 4)
    }
    public struct WritingOptions: OptionSet {
        public let rawValue: UInt
        public init(rawValue: UInt) { self.rawValue = rawValue }
        public static let prettyPrinted = WritingOptions(rawValue: 1)
        public static let sortedKeys = WritingOptions(rawValue: 2)
        public static let fragmentsAllowed = WritingOptions(rawValue: 4)
    }
    public class func jsonObject(with data: Data, options opt: ReadingOptions = []) throws -> Any { fatalError() }
    public class func data(withJSONObject obj: Any, options opt: WritingOptions = []) throws -> Data { fatalError() }
    public class func isValidJSONObject(_ obj: Any) -> Bool { fatalError() }
}

public protocol Encoder { func encode<T: Encodable>(_ value: T) throws -> Data }
public protocol Decoder { func decode<T: Decodable>(_ type: T.Type, from data: Data) throws -> T }

public class JSONEncoder: Encoder {
    public struct OutputFormatting: OptionSet {
        public let rawValue: UInt
        public init(rawValue: UInt) { self.rawValue = rawValue }
        public static let prettyPrinted = OutputFormatting(rawValue: 1)
        public static let sortedKeys = OutputFormatting(rawValue: 2)
    }
    public struct DateEncodingStrategy {
        public static let iso8601 = DateEncodingStrategy()
        public static let secondsSince1970 = DateEncodingStrategy()
    }
    public var outputFormatting: OutputFormatting = []
    public var dateEncodingStrategy: DateEncodingStrategy = .iso8601
    public init() {}
    public func encode<T: Encodable>(_ value: T) throws -> Data { fatalError() }
}

public class JSONDecoder: Decoder {
    public struct DateDecodingStrategy {
        public static let iso8601 = DateDecodingStrategy()
        public static let secondsSince1970 = DateDecodingStrategy()
    }
    public struct DataDecodingStrategy {
        public static let base64 = DataDecodingStrategy()
    }
    public var dateDecodingStrategy: DateDecodingStrategy = .iso8601
    public var dataDecodingStrategy: DataDecodingStrategy = .base64
    public init() {}
    public func decode<T: Decodable>(_ type: T.Type, from data: Data) throws -> T { fatalError() }
}

public class NSKeyedArchiver: NSObject {
    public class func archivedData(withRootObject object: Any, requiringSecureCoding: Bool) throws -> Data { fatalError() }
    public class func archiveRootObject(_ rootObject: Any, toFile path: String) -> Bool { fatalError() }
}

public class NSKeyedUnarchiver: NSObject {
    public class func unarchiveTopLevelObjectWithData(_ data: Data) throws -> Any? { fatalError() }
    public class func unarchivedObject(ofClass cls: AnyClass, from data: Data) throws -> Any? { fatalError() }
    public class func setClass(_ cls: AnyClass?, forClassName codedName: String) {}
}

public class PropertyListSerialization: NSObject {
    public struct ReadingOptions: OptionSet {
        public let rawValue: UInt
        public init(rawValue: UInt) { self.rawValue = rawValue }
        public static let mutableContainers = ReadingOptions(rawValue: 1)
    }
    public class func propertyList(with data: Data, options opt: ReadingOptions = [], format: UnsafeMutablePointer<PropertyListFormat>?) throws -> Any { fatalError() }
    public class func data(fromPropertyList obj: Any, format: PropertyListFormat, options opt: UInt) throws -> Data { fatalError() }
}
public enum PropertyListFormat: UInt { case binary = 200, xml = 100 }

// MARK: - 杂项

public struct UUID: Hashable {
    public var uuidString: String
    public init() { uuidString = "" }
    public init(uuidString: String) { self.uuidString = uuidString }
    public var description: String { uuidString }
}

public struct ScanOptions: OptionSet {
    public let rawValue: UInt
    public init(rawValue: UInt) { self.rawValue = rawValue }
    public static let caseInsensitive = ScanOptions(rawValue: 1)
    public static let upTo = ScanOptions(rawValue: 2)
}

public class Scanner: NSObject {
    public var string: String = ""
    public var isAtEnd = false
    public var scanLocation = 0
    public init(string: String) { self.string = string; super.init() }
    public func scanUpToString(_ stopString: String, into result: UnsafeMutablePointer<String?>?) -> Bool { fatalError() }
    public func scanString(_ searchString: String, into result: UnsafeMutablePointer<String?>?) -> Bool { fatalError() }
    public func scanInt32(_ result: UnsafeMutablePointer<Int32>?) -> Bool { fatalError() }
    public func scanInt(_ result: UnsafeMutablePointer<Int>?) -> Bool { fatalError() }
    public func scanFloat(_ result: UnsafeMutablePointer<Float>?) -> Bool { fatalError() }
    public func scanDouble(_ result: UnsafeMutablePointer<Double>?) -> Bool { fatalError() }
}

public struct CharacterSet {
    public init() {}
    public init(charactersIn string: String) {}
    public init(charactersIn range: Range<Unicode.Scalar>) {}
    public static let whitespacesAndNewlines = CharacterSet()
    public static let whitespaces = CharacterSet()
    public static let decimalDigits = CharacterSet()
    public static let alphanumerics = CharacterSet()
    public static let urlQueryAllowed = CharacterSet()
    public static let urlPathAllowed = CharacterSet()
    public static let urlHostAllowed = CharacterSet()
    public static let urlFragmentAllowed = CharacterSet()
    public static let symbols = CharacterSet()
    public static let punctuationCharacters = CharacterSet()
    public static let uppercaseLetters = CharacterSet()
    public static let lowercaseLetters = CharacterSet()
    public func contains(_ member: Unicode.Scalar) -> Bool { false }
    public func union(_ other: CharacterSet) -> CharacterSet { self }
}

public class NSRegularExpression: NSObject {
    public struct Options: OptionSet {
        public let rawValue: UInt
        public init(rawValue: UInt) { self.rawValue = rawValue }
        public static let caseInsensitive = Options(rawValue: 1)
        public static let allowCommentsAndWhitespace = Options(rawValue: 2)
        public static let ignoreMetacharacters = Options(rawValue: 4)
        public static let dotMatchesLineSeparators = Options(rawValue: 8)
        public static let anchorsMatchLines = Options(rawValue: 16)
        public static let useUnixLineSeparators = Options(rawValue: 32)
        public static let useUnicodeWordBoundaries = Options(rawValue: 64)
        public init() { self.rawValue = 0 }
    }
    public struct MatchingOptions: OptionSet {
        public let rawValue: UInt
        public init(rawValue: UInt) { self.rawValue = rawValue }
    }
    public class TextCheckingResult: NSObject {
        public var range: NSRange { get { fatalError() } set { fatalError() } }
        public var numberOfRanges: Int { get { fatalError() } set { fatalError() } }
        public func range(at idx: Int) -> NSRange { fatalError() }
    }
    public init(pattern: String, options: Options = []) throws { super.init() }
    public var numberOfCaptureGroups: Int { get { fatalError() } set { fatalError() } }
    public func matches(in string: String, options: MatchingOptions = [], range: NSRange) -> [TextCheckingResult] { fatalError() }
    public func numberOfMatches(in string: String, options: MatchingOptions = [], range: NSRange) -> Int { fatalError() }
    public func stringByReplacingMatches(in string: String, options: MatchingOptions = [], range: NSRange, withTemplate templ: String) -> String { fatalError() }
    public func firstMatch(in string: String, options: MatchingOptions = [], range: NSRange) -> TextCheckingResult? { fatalError() }

    public class func escapedPattern(for string: String) -> String { fatalError() }
}

public struct IndexSet: Hashable {
    public init() {}
    public mutating func insert(_ integer: Int) {}
    public var count: Int { fatalError() }
}

public class NumberFormatter: NSObject {
    public enum Style { case none, decimal, currency, percent, scientific }
    public var numberStyle: Style = .decimal
    public var minimumFractionDigits = 0
    public var maximumFractionDigits = 0
    public func string(from number: NSNumber) -> String? { fatalError() }
}

open class OperationQueue: NSObject {
    public static let main = OperationQueue()
    public static var current: OperationQueue? { nil }
    public var maxConcurrentOperationCount = 0
    public var isSuspended = false
    public override init() { super.init() }
    public func addOperation(_ block: @escaping () -> Void) {}
    public func addOperation(_ op: Operation) {}
    public func cancelAllOperations() {}
    public var operationCount: Int { get { fatalError() } set { fatalError() } }
}

open class Operation: NSObject {
    public var isCancelled: Bool { get { fatalError() } set { fatalError() } }
    public func cancel() {}
    public func start() {}
    public override init() { super.init() }
    public var completionBlock: (() -> Void)?
}

open class BlockOperation: Operation {
    public convenience init(block: @escaping () -> Void) { self.init() }
}

open class NSData: NSObject {}
open class NSMutableData: NSData {}

open class NSDictionary: NSObject {}
open class NSMutableDictionary: NSDictionary {}
open class NSArray: NSObject {}
open class NSMutableArray: NSArray {}

public struct Measurement<UnitType: Dimension> {
    public var value: Double
    public init(value: Double, unit: UnitType) { self.value = value }
}
open class Dimension: NSObject {}

// GCD（Dispatch 模块在 Windows 上也建不出来，这里一起替身）

public struct DispatchQueue {
    public struct Attributes: OptionSet {
        public let rawValue: UInt
        public init(rawValue: UInt) { self.rawValue = rawValue }
        public static let concurrent = Attributes(rawValue: 1)
    }
    public struct AutoreleaseFrequency { public static let workItem = AutoreleaseFrequency() }
    public var label: String
    public var qos: DispatchQoS
    public init(label: String, qos: DispatchQoS = .default, attributes: Attributes = [], autoreleaseFrequency: AutoreleaseFrequency = .workItem, target: DispatchQueue? = nil) {
        self.label = label; self.qos = qos
    }
    public static let main = DispatchQueue(label: "main")
    public static func global(qos: DispatchQoS.QoSClass = .default) -> DispatchQueue { DispatchQueue(label: "global") }
    public func async(group: DispatchGroup? = nil, qos: DispatchQoS = .default, flags: DispatchWorkItemFlags = [], execute work: @escaping @Sendable () -> Void) {}
    public func asyncAfter(deadline: DispatchTime, qos: DispatchQoS = .default, flags: DispatchWorkItemFlags = [], execute work: @escaping @Sendable () -> Void) {}
    public func asyncAfter(deadline: DispatchTime, execute work: @escaping @Sendable () -> Void) {}
    public func asyncAfter(deadline: DispatchWallTime, execute work: @escaping @Sendable () -> Void) {}
    public func sync(execute work: () -> Void) {}
    public func sync<T>(execute work: () throws -> T) rethrows -> T { try work() }
    public func asyncAndWait(execute work: @escaping () -> Void) {}
    public var isMain: Bool { get { fatalError() } set { fatalError() } }
    public static func getSpecific<T>(key: DispatchSpecificKey<T>) -> T? { nil }
    public func setSpecific<T>(key: DispatchSpecificKey<T>, value: T?) {}
}

public final class DispatchSpecificKey<T> {
    public init() {}
}

public struct DispatchQoS {
    public struct QoSClass: Hashable {
        public let raw: String
        public init(raw: String) { self.raw = raw }
        public static let `default` = QoSClass(raw: "default")
        public static let userInteractive = QoSClass(raw: "userInteractive")
        public static let userInitiated = QoSClass(raw: "userInitiated")
        public static let utility = QoSClass(raw: "utility")
        public static let background = QoSClass(raw: "background")
        public static let unspecified = QoSClass(raw: "unspecified")
    }
    public var qosClass: QoSClass
    public static let `default` = DispatchQoS(qosClass: QoSClass(raw: "default"))
    public static let userInteractive = DispatchQoS(qosClass: QoSClass(raw: "userInteractive"))
    public static let userInitiated = DispatchQoS(qosClass: QoSClass(raw: "userInitiated"))
    public static let utility = DispatchQoS(qosClass: QoSClass(raw: "utility"))
    public static let background = DispatchQoS(qosClass: QoSClass(raw: "background"))
    public static let unspecified = DispatchQoS(qosClass: QoSClass(raw: "unspecified"))
    public var qosClassValue: QoSClass { qosClass }
}

public struct DispatchWorkItemFlags: OptionSet {
    public let rawValue: UInt
    public init(rawValue: UInt) { self.rawValue = rawValue }
    public static let barrier = DispatchWorkItemFlags(rawValue: 1)
    public static let noQoS = DispatchWorkItemFlags(rawValue: 2)
}

public struct DispatchTime: Comparable {
    public var uptimeNanoseconds: UInt64
    public init(uptimeNanoseconds: UInt64) { self.uptimeNanoseconds = uptimeNanoseconds }
    public static func now() -> DispatchTime { DispatchTime(uptimeNanoseconds: 0) }
    public static let distantFuture = DispatchTime(uptimeNanoseconds: .max)
    public func adding(_ interval: DispatchTimeInterval) -> DispatchTime { self }
    public static func < (lhs: DispatchTime, rhs: DispatchTime) -> Bool { lhs.uptimeNanoseconds < rhs.uptimeNanoseconds }
    public static func + (lhs: DispatchTime, rhs: Double) -> DispatchTime { lhs }
    public static func - (lhs: DispatchTime, rhs: DispatchTime) -> Double { 0 }
}

public struct DispatchWallTime: Comparable {
    public static let now = DispatchWallTime()
    public static func < (lhs: DispatchWallTime, rhs: DispatchWallTime) -> Bool { false }
}

public enum DispatchTimeInterval {
    case seconds(Int)
    case milliseconds(Int)
    case microseconds(Int)
    case nanoseconds(Int)
    case never
}

public func dispatchPrecondition(condition: @autoclosure () -> DispatchPredicate) {}

public enum DispatchPredicate {
    case onQueue(DispatchQueue)
    case onQueueAsBarrier(DispatchQueue)
    case notOnQueue(DispatchQueue)
}

public class DispatchGroup {
    public init() {}
    public func enter() {}
    public func leave() {}
    public func wait() {}
    public func wait(timeout: DispatchTime) -> DispatchTimeoutResult { .success }
    public func notify(queue: DispatchQueue, execute: @escaping () -> Void) {}
}

public enum DispatchTimeoutResult { case success, timedOut }

public class DispatchSemaphore {
    public init(value: Int) {}
    public func wait() {}
    public func wait(timeout: DispatchTime) -> DispatchTimeoutResult { .success }
    public func signal() -> Int { 0 }
}

public class DispatchWorkItem {
    public init(qos: DispatchQoS = .default, flags: DispatchWorkItemFlags = [], block: @escaping () -> Void) {}
    public func cancel() {}
    public func notify(queue: DispatchQueue, execute: @escaping () -> Void) {}
    public func wait() {}
}

public class DispatchSource {
    public class Timer {
        public static func makeTimerSource(flags: DispatchSourceTimerFlags = [], queue: DispatchQueue? = nil) -> DispatchSourceTimer { DispatchSourceTimer() }
        public static func makeTimerSource(queue: DispatchQueue) -> DispatchSourceTimer { DispatchSourceTimer() }
    }
}

public struct DispatchSourceTimerFlags: OptionSet {
    public let rawValue: UInt
    public init(rawValue: UInt) { self.rawValue = rawValue }
    public static let strict = DispatchSourceTimerFlags(rawValue: 1)
}

public class DispatchSourceTimer {
    public func schedule(deadline: DispatchTime, repeating interval: DispatchTimeInterval = .never, leeway: DispatchTimeInterval = .nanoseconds(0)) {}
    public func schedule(deadline: DispatchWallTime, repeating interval: DispatchTimeInterval = .never) {}
    public func setEventHandler(qos: DispatchQoS = .default, flags: DispatchWorkItemFlags = [], handler: @escaping () -> Void) {}
    public func setEventHandler(handler: DispatchSourceProtocol.Handler) {}
    public func resume() {}
    public func suspend() {}
    public func cancel() {}
}

public protocol DispatchSourceProtocol: AnyObject {
    typealias Handler = @convention(block) () -> Void
}
extension DispatchSourceTimer: DispatchSourceProtocol {}

public func sleep(until deadline: DispatchTime) {}


// MARK: - NSAttributedString.Key 常用键

public extension NSAttributedString.KeyColor {
    static let foregroundColorRaw = Self(rawValue: "NSColor")
}

// MARK: - NSCoder

open class NSCoder: NSObject {
    open func encode(_ objv: Any?, forKey key: String) {}
    open func decodeObject(forKey key: String) -> Any? { nil }
    open func decodeInteger(forKey key: String) -> Int { 0 }
    open func decodeDouble(forKey key: String) -> Double { 0 }
    open func decodeBool(forKey key: String) -> Bool { false }
    open var allowsKeyedCoding: Bool { false }
}

// MARK: - 其它常用类型

public class NSValue: NSObject {
    public var cgPointValue: CGPoint { get { fatalError() } set { fatalError() } }
    public var cgRectValue: CGRect { get { fatalError() } set { fatalError() } }
    public var cgSizeValue: CGSize { get { fatalError() } set { fatalError() } }
    public init(cgPoint point: CGPoint) { super.init() }
    public init(cgRect rect: CGRect) { super.init() }
    public init(cgSize size: CGSize) { super.init() }
}


// MARK: - IndexPath

public struct IndexPath: Hashable {
    public var item: Int
    public var row: Int { item }
    public var section: Int
    public init(index: Int) { item = index; section = 0 }
    public init(item: Int, section: Int) { self.item = item; self.section = section }
    public init(row: Int, section: Int) { self.item = row; self.section = section }
    public init(indexes: [Int]) { item = indexes.last ?? 0; section = indexes.first ?? 0 }
    public subscript(position: Int) -> Int { position == 0 ? section : item }
}

// MARK: - CoreFoundation 的最小替身（仅签名）

public typealias CFTypeRef = AnyObject
public typealias CFAllocatorRef = CFAllocator
public typealias CFData = Data
// 近似点：Darwin 上 `[T] as CFArray` 是桥接转换；这里把 CFArray 当成 [Any]，
// 于是 `colors as CFArray` 变成 [CGColor] -> [Any] 的普通上转，语义等价。
public typealias CFArray = [Any]
// 近似点：CFString 与 String 在 Darwin 上可无缝桥接，这里直接当别名。
public typealias CFString = String
public typealias CFDictionary = [String: Any]
public typealias CFNumber = NSNumber
public typealias CFURL = URL


// MARK: - CFAllocator（CoreFoundation）
public class CFAllocator {}
public let kCFAllocatorDefault: CFAllocator? = nil
public class CFBoolean {}
public let kCFBooleanTrue: CFBoolean? = nil
public let kCFBooleanFalse: CFBoolean? = nil
public typealias CFIndex = Int
