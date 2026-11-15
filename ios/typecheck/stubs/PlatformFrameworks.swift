// CryptoKit / Compression / UniformTypeIdentifiers / Photos / UserNotifications /
// GameController / CoreMotion 的最小替身。

// MARK: - CryptoKit

public enum Insecure {
    public struct MD5 {
        public struct Digest: Sequence, Hashable {
            public typealias Element = UInt8
            public var bytes: [UInt8]
            public init(_ bytes: [UInt8]) { self.bytes = bytes }
            public func makeIterator() -> Array<UInt8>.Iterator { bytes.makeIterator() }
            public var description: String { fatalError() }
            public subscript(index: Int) -> UInt8 { bytes[index] }
            public var count: Int { bytes.count }
            public func map<T>(_ transform: (UInt8) throws -> T) rethrows -> [T] { try bytes.map(transform) }
        }
        public init() {}
        public mutating func update(data: Data) {}
        public mutating func update(bufferPointer: UnsafeRawBufferPointer) {}
        public func finalize() -> Digest { Digest([]) }
        public static func hash(data: Data) -> Digest { Digest([]) }
        public static func hash(bufferPointer: UnsafeRawBufferPointer) -> Digest { Digest([]) }
    }
    public struct SHA1 {
        public struct Digest: Sequence, Hashable {
            public typealias Element = UInt8
            public var bytes: [UInt8]
            public init(_ bytes: [UInt8]) { self.bytes = bytes }
            public func makeIterator() -> Array<UInt8>.Iterator { bytes.makeIterator() }
            public var description: String { fatalError() }
            public subscript(index: Int) -> UInt8 { bytes[index] }
            public var count: Int { bytes.count }
            public func map<T>(_ transform: (UInt8) throws -> T) rethrows -> [T] { try bytes.map(transform) }
        }
        public init() {}
        public mutating func update(data: Data) {}
        public func finalize() -> Digest { Digest([]) }
        public static func hash(data: Data) -> Digest { Digest([]) }
    }
}

public struct SHA256 {
    public struct Digest: Sequence, Hashable {
        public typealias Element = UInt8
        public var bytes: [UInt8]
        public init(_ bytes: [UInt8]) { self.bytes = bytes }
        public func makeIterator() -> Array<UInt8>.Iterator { bytes.makeIterator() }
        public var description: String { fatalError() }
        public subscript(index: Int) -> UInt8 { bytes[index] }
        public var count: Int { bytes.count }
        public func map<T>(_ transform: (UInt8) throws -> T) rethrows -> [T] { try bytes.map(transform) }
    }
    public init() {}
    public mutating func update(data: Data) {}
    public func finalize() -> Digest { Digest([]) }
    public static func hash(data: Data) -> Digest { Digest([]) }
}

public struct SymmetricKey {
    public init(size: SymmetricKeySize) {}
    public init(data: Data) {}
    public var withUnsafeBytes: (UnsafeRawBufferPointer) -> Void { { _ in } }
}

public struct SymmetricKeySize {
    public static let bits128 = SymmetricKeySize()
    public static let bits192 = SymmetricKeySize()
    public static let bits256 = SymmetricKeySize()
    public init() {}
}

public enum HMAC<S: HashFunctionPlaceholder> {
    public static func authenticationCode(for data: Data, using key: SymmetricKey) -> HashedAuthenticationCode { HashedAuthenticationCode() }
}

public protocol HashFunctionPlaceholder {}
extension SHA256: HashFunctionPlaceholder {}
extension Insecure.MD5: HashFunctionPlaceholder {}

public struct HashedAuthenticationCode: Sequence {
    public typealias Element = UInt8
    public func makeIterator() -> Array<UInt8>.Iterator { [].makeIterator() }
    public func map<T>(_ transform: (UInt8) throws -> T) rethrows -> [T] { [] }
}

// MARK: - Compression

public typealias compression_algorithm = Int32
public let COMPRESSION_LZ4: compression_algorithm = 0x100
public let COMPRESSION_ZLIB: compression_algorithm = 0x205
public let COMPRESSION_LZMA: compression_algorithm = 0x306
public let COMPRESSION_LZFSE: compression_algorithm = 0x801
public let COMPRESSION_LZ4_RAW: compression_algorithm = 0x101

public func compression_decode_buffer(_ dst_buffer: UnsafeMutablePointer<UInt8>,
                                      _ dst_size: Int,
                                      _ src_buffer: UnsafePointer<UInt8>,
                                      _ src_size: Int,
                                      _ scratch_buffer: UnsafeMutableRawPointer?,
                                      _ algorithm: compression_algorithm) -> Int { 0 }

public func compression_encode_buffer(_ dst_buffer: UnsafeMutablePointer<UInt8>,
                                      _ dst_size: Int,
                                      _ src_buffer: UnsafePointer<UInt8>,
                                      _ src_size: Int,
                                      _ scratch_buffer: UnsafeMutableRawPointer?,
                                      _ algorithm: compression_algorithm) -> Int { 0 }

// MARK: - UniformTypeIdentifiers

public struct UTType: Hashable {
    public var identifier: String
    public init(_ identifier: String) { self.identifier = identifier }
    public init?(filenameExtension: String, conformingTo supertype: UTType) { return nil }
    public var preferredFilenameExtension: String? { nil }
    public var preferredMIMEType: String? { nil }
    public var conforms: (UTType) -> Bool { { _ in false } }
    public func conforms(to type: UTType) -> Bool { false }

    public static let item = UTType("public.item")
    public static let data = UTType("public.data")
    public static let image = UTType("public.image")
    public static let png = UTType("public.png")
    public static let jpeg = UTType("public.jpeg")
    public static let gif = UTType("com.compuserve.gif")
    public static let heic = UTType("public.heic")
    public static let movie = UTType("public.movie")
    public static let video = UTType("public.video")
    public static let mpeg4Movie = UTType("public.mpeg-4")
    public static let quickTimeMovie = UTType("com.apple.quicktime-movie")
    public static let plainText = UTType("public.plain-text")
    public static let text = UTType("public.text")
    public static let folder = UTType("public.folder")
    public static let directory = UTType("public.directory")
    public static let zip = UTType("public.zip-archive")
    public static let archive = UTType("public.archive")
    public static let audio = UTType("public.audio")
}

// MARK: - Photos

public class PHPhotoLibrary: NSObject {
    public struct AccessLevel: RawRepresentable {
        public var rawValue: Int
        public init(rawValue: Int) { self.rawValue = rawValue }
        public static let addOnly = AccessLevel(rawValue: 1)
        public static let readWrite = AccessLevel(rawValue: 2)
    }
    public struct AuthorizationStatus: RawRepresentable {
        public var rawValue: Int
        public init(rawValue: Int) { self.rawValue = rawValue }
        public static let notDetermined = AuthorizationStatus(rawValue: 0)
        public static let restricted = AuthorizationStatus(rawValue: 1)
        public static let denied = AuthorizationStatus(rawValue: 2)
        public static let authorized = AuthorizationStatus(rawValue: 3)
        public static let limited = AuthorizationStatus(rawValue: 4)
    }
    public static func shared() -> PHPhotoLibrary { PHPhotoLibrary() }
    public static func requestAuthorization(for accessLevel: AccessLevel, handler: @escaping (AuthorizationStatus) -> Void) {}
    public static func authorizationStatus(for accessLevel: AccessLevel) -> AuthorizationStatus { .notDetermined }
    public func performChanges(_ changeBlock: @escaping () -> Void, completionHandler: ((Bool, Error?) -> Void)? = nil) {}
    public func performChangesAndWait(_ changeBlock: () -> Void) throws {}
}

public class PHAssetCreationRequest: PHAssetChangeRequest {
    public var addResourceWithType: (Any, URL, PHAssetResourceCreationOptions?) -> Void { { _, _, _ in } }
    public static func forAsset() -> PHAssetCreationRequest { PHAssetCreationRequest() }
    public var creationRequestForAsset: Bool { false }
    public func addResource(with type: PHAssetResourceType, fileURL: URL, options: PHAssetResourceCreationOptions?) {}
    public func addResource(with type: PHAssetResourceType, data: Data, options: PHAssetResourceCreationOptions?) {}
}

public class PHAssetChangeRequest: NSObject {
    public static func creationRequestForAssetFromImage(atFileURL fileURL: URL) -> PHAssetChangeRequest? { nil }
    public static func creationRequestForAssetFromVideo(atFileURL fileURL: URL) -> PHAssetChangeRequest? { nil }
    public static func deleteAssets(_ assets: [Any]) {}
}

public class PHAssetResourceCreationOptions: NSObject {
    public var originalFilename: String?
    public var uniformTypeIdentifier: String?
    public var shouldMoveFile: Bool = false
}

public struct PHAssetResourceType: RawRepresentable {
    public var rawValue: Int
    public init(rawValue: Int) { self.rawValue = rawValue }
    public static let photo = PHAssetResourceType(rawValue: 1)
    public static let video = PHAssetResourceType(rawValue: 2)
    public static let audio = PHAssetResourceType(rawValue: 3)
}

public class PHAsset: NSObject {}
public class PHAssetCollection: NSObject {}

// MARK: - UserNotifications

public class UNUserNotificationCenter: NSObject {
    public struct Options: OptionSet {
        public let rawValue: UInt
        public init(rawValue: UInt) { self.rawValue = rawValue }
        public static let badge = Options(rawValue: 1)
        public static let sound = Options(rawValue: 2)
        public static let alert = Options(rawValue: 4)
        public static let carPlay = Options(rawValue: 8)
        public static let criticalAlert = Options(rawValue: 16)
        public static let providesAppNotificationSettings = Options(rawValue: 32)
        public static let provisional = Options(rawValue: 64)
    }
    public static func current() -> UNUserNotificationCenter { UNUserNotificationCenter() }
    public func requestAuthorization(options: Options, completionHandler: @escaping (Bool, Error?) -> Void) {}
    public func add(_ request: UNNotificationRequest, withCompletionHandler completionHandler: ((Error?) -> Void)? = nil) {}
    public func removePendingNotificationRequests(withIdentifiers identifiers: [String]) {}
    public func removeAllPendingNotificationRequests() {}
    public func removeDeliveredNotifications(withIdentifiers identifiers: [String]) {}
    public func setNotificationCategories(_ categories: Set<AnyHashable>) {}
    public func getNotificationSettings(completionHandler: @escaping (Any) -> Void) {}
}

public class UNNotificationContent: NSObject {
    public var title: String
    public var subtitle: String
    public var body: String
    public var sound: UNNotificationSound?
    public var badge: NSNumber?
    public var userInfo: [AnyHashable: Any]
    public var categoryIdentifier: String
    public override init() {
        title = ""; subtitle = ""; body = ""; sound = nil; badge = nil
        userInfo = [:]; categoryIdentifier = ""
        super.init()
    }
}

public class UNMutableNotificationContent: UNNotificationContent {}

public class UNNotificationSound: NSObject {
    public static func `default`() -> UNNotificationSound { UNNotificationSound() }
    public static func criticalSoundNamed(_ name: String) -> UNNotificationSound { UNNotificationSound() }
}

public class UNNotificationTrigger: NSObject {}

public class UNTimeIntervalNotificationTrigger: UNNotificationTrigger {
    public init(timeInterval: TimeInterval, repeats: Bool) { super.init() }
}

public class UNNotificationRequest: NSObject {
    public var identifier: String
    public var content: UNNotificationContent
    public var trigger: UNNotificationTrigger?
    public init(identifier: String, content: UNNotificationContent, trigger: UNNotificationTrigger?) {
        self.identifier = identifier; self.content = content; self.trigger = trigger
        super.init()
    }
}

public class UNNotification: NSObject {}
public class UNNotificationResponse: NSObject {}
public class UNNotificationSettings: NSObject {}

// MARK: - GameController

public class GCControllerElement: NSObject {
    public var isPressed: Bool { false }
    public var value: Float { 0 }
    public var isAnalog: Bool { false }
    public var uncheckedValue: Float { 0 }
}

public class GCControllerButtonInput: GCControllerElement {}

public class GCControllerDirectionPad: GCControllerElement {
    public var up: GCControllerButtonInput { GCControllerButtonInput() }
    public var down: GCControllerButtonInput { GCControllerButtonInput() }
    public var left: GCControllerButtonInput { GCControllerButtonInput() }
    public var right: GCControllerButtonInput { GCControllerButtonInput() }
    public var xAxis: GCControllerAxisInput { GCControllerAxisInput() }
    public var yAxis: GCControllerAxisInput { GCControllerAxisInput() }
}

public class GCControllerAxisInput: GCControllerElement {}

public class GCControllerTouchpad: NSObject {}

public class GCExtendedGamepad: NSObject {
    public var buttonA: GCControllerButtonInput { GCControllerButtonInput() }
    public var buttonB: GCControllerButtonInput { GCControllerButtonInput() }
    public var buttonX: GCControllerButtonInput { GCControllerButtonInput() }
    public var buttonY: GCControllerButtonInput { GCControllerButtonInput() }
    public var leftShoulder: GCControllerButtonInput { GCControllerButtonInput() }
    public var rightShoulder: GCControllerButtonInput { GCControllerButtonInput() }
    public var leftTrigger: GCControllerButtonInput { GCControllerButtonInput() }
    public var rightTrigger: GCControllerButtonInput { GCControllerButtonInput() }
    public var leftThumbstick: GCControllerDirectionPad { GCControllerDirectionPad() }
    public var rightThumbstick: GCControllerDirectionPad { GCControllerDirectionPad() }
    public var dpad: GCControllerDirectionPad { GCControllerDirectionPad() }
    public var buttonMenu: GCControllerButtonInput { GCControllerButtonInput() }
    public var buttonOptions: GCControllerButtonInput? { nil }
    public var buttonHome: GCControllerButtonInput? { nil }
    public var valueChangedHandler: ((GCExtendedGamepad, GCControllerElement) -> Void)? { get { fatalError() } set { fatalError() } }
}

public class GCGamepad: NSObject {
    public var valueChangedHandler: ((GCGamepad, GCControllerElement) -> Void)? { get { fatalError() } set { fatalError() } }
}

public class GCMicroGamepad: NSObject {
    public var valueChangedHandler: ((GCMicroGamepad, GCControllerElement) -> Void)? { get { fatalError() } set { fatalError() } }
}

public class GCController: NSObject {
    public var extendedGamepad: GCExtendedGamepad? { nil }
    public var gamepad: GCGamepad? { nil }
    public var microGamepad: GCMicroGamepad? { nil }
    public var vendorName: String? { nil }
    public var playerIndex: Int { get { fatalError() } set { fatalError() } }
    public static func controllers() -> [GCController] { [] }
    public static var shouldMonitorBackgroundEvents: Bool { fatalError() }
    public static func startWirelessControllerDiscovery(completionHandler: (() -> Void)? = nil) {}
    public static func stopWirelessControllerDiscovery() {}
    public func capture() {}
}

public extension Notification.Name {
    static let GCControllerDidConnect = Notification.Name(rawValue: "GCControllerDidConnectNotification")
    static let GCControllerDidDisconnect = Notification.Name(rawValue: "GCControllerDidDisconnectNotification")
}

// MARK: - CoreMotion

public class CMMotionManager: NSObject {
    public var deviceMotionAvailable: Bool { false }
    public var isDeviceMotionAvailable: Bool { false }
    public var isDeviceMotionActive: Bool { false }
    public var deviceMotionUpdateInterval: TimeInterval
    public var accelerometerAvailable: Bool { false }
    public var isAccelerometerActive: Bool { false }
    public var gyroAvailable: Bool { false }
    public var isGyroAvailable: Bool { false }
    public var startDeviceMotionUpdates: (OperationQueue) -> Void { { _ in } }
    public override init() { deviceMotionUpdateInterval = 0.01; super.init() }
    public func startDeviceMotionUpdates(to queue: OperationQueue, withHandler handler: @escaping (CMDeviceMotion?, Error?) -> Void) {}
    public func stopDeviceMotionUpdates() {}
    public func startAccelerometerUpdates(to queue: OperationQueue, withHandler handler: @escaping (CMAccelerometerData?, Error?) -> Void) {}
    public func startAccelerometerUpdates() {}
    public func stopAccelerometerUpdates() {}
    public var accelerometerData: CMAccelerometerData? { nil }
    public var deviceMotion: CMDeviceMotion? { nil }
}

public class CMLogItem: NSObject {
    public var timestamp: TimeInterval { 0 }
}

public class CMAccelerometerData: CMLogItem {
    public var acceleration: CMAcceleration { CMAcceleration() }
}

public struct CMAcceleration {
    public var x: Double
    public var y: Double
    public var z: Double
    public init() { x = 0; y = 0; z = 0 }
}

public class CMGyroData: CMLogItem {
    public var rotationRate: CMRotationRate { CMRotationRate() }
}

public struct CMRotationRate {
    public var x: Double
    public var y: Double
    public var z: Double
    public init() { x = 0; y = 0; z = 0 }
}

public class CMDeviceMotion: CMLogItem {
    public var gravity: CMAcceleration { CMAcceleration() }
    public var userAcceleration: CMAcceleration { CMAcceleration() }
    public var rotationRate: CMRotationRate { CMRotationRate() }
    public var attitude: CMAttitude { CMAttitude() }
    public var magneticField: Any? { nil }
    public var heading: Double { 0 }
}

public class CMAttitude: NSObject {
    public var roll: Double { 0 }
    public var pitch: Double { 0 }
    public var yaw: Double { 0 }
    public var quaternion: (Double, Double, Double, Double) { (0, 0, 0, 0) }
}

public class CMAltimeter: NSObject {}
