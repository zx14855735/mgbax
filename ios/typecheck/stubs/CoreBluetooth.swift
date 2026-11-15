// CoreBluetooth 的最小替身。

public struct CBUUID: Hashable {
    public var data: Data { get { fatalError() } set { fatalError() } }
    public var uuidString: String { fatalError() }
    public init(string theString: String) {}
    public init(data theData: Data) {}
    public init(NSUUID theUUID: UUID) {}
}

public struct CBManagerState: RawRepresentable, Hashable {
    public var rawValue: Int
    public init(rawValue: Int) { self.rawValue = rawValue }
    public static let unknown = CBManagerState(rawValue: 0)
    public static let resetting = CBManagerState(rawValue: 1)
    public static let unsupported = CBManagerState(rawValue: 2)
    public static let unauthorized = CBManagerState(rawValue: 3)
    public static let poweredOff = CBManagerState(rawValue: 4)
    public static let poweredOn = CBManagerState(rawValue: 5)
}

public struct CBAttributePermissions: OptionSet {
    public let rawValue: UInt
    public init(rawValue: UInt) { self.rawValue = rawValue }
    public static let readable = CBAttributePermissions(rawValue: 1)
    public static let writeable = CBAttributePermissions(rawValue: 2)
    public static let readEncryptionRequired = CBAttributePermissions(rawValue: 4)
    public static let writeEncryptionRequired = CBAttributePermissions(rawValue: 8)
}

public struct CBCharacteristicProperties: OptionSet {
    public let rawValue: UInt
    public init(rawValue: UInt) { self.rawValue = rawValue }
    public static let broadcast = CBCharacteristicProperties(rawValue: 1)
    public static let read = CBCharacteristicProperties(rawValue: 2)
    public static let writeWithoutResponse = CBCharacteristicProperties(rawValue: 4)
    public static let write = CBCharacteristicProperties(rawValue: 8)
    public static let notify = CBCharacteristicProperties(rawValue: 16)
    public static let indicate = CBCharacteristicProperties(rawValue: 32)
    public static let authenticatedSignedWrites = CBCharacteristicProperties(rawValue: 64)
    public static let extendedProperties = CBCharacteristicProperties(rawValue: 128)
    public static let notifyEncryptionRequired = CBCharacteristicProperties(rawValue: 256)
    public static let indicateEncryptionRequired = CBCharacteristicProperties(rawValue: 512)
}

public struct CBCharacteristicWriteType: RawRepresentable {
    public var rawValue: Int
    public init(rawValue: Int) { self.rawValue = rawValue }
    public static let withResponse = CBCharacteristicWriteType(rawValue: 0)
    public static let withoutResponse = CBCharacteristicWriteType(rawValue: 1)
}

public struct CBATTError: RawRepresentable {
    public var rawValue: Int
    public init(rawValue: Int) { self.rawValue = rawValue }
    public static let success = CBATTError(rawValue: 0)
    public static let invalidHandle = CBATTError(rawValue: 1)
}

open class CBCentral: NSObject, NSCopying {
    open var identifier: UUID { get { fatalError() } set { fatalError() } }
    open var maximumUpdateValueLength: Int { get { fatalError() } set { fatalError() } }
    public func copy(with zone: NSZone?) -> Any { fatalError() }
}

open class CBPeer: NSObject, NSCopying {
    open var identifier: UUID { get { fatalError() } set { fatalError() } }
    public func copy(with zone: NSZone?) -> Any { fatalError() }
}

open class CBAttribute: NSObject {
    open var uuid: CBUUID { get { fatalError() } set { fatalError() } }
}

open class CBCharacteristic: CBAttribute {
    open var value: Data? { get { fatalError() } set { fatalError() } }
    open var isNotifying: Bool { get { fatalError() } set { fatalError() } }
    open var properties: CBCharacteristicProperties { get { fatalError() } set { fatalError() } }
    open var service: CBService? { get { fatalError() } set { fatalError() } }
    open var descriptors: [CBDescriptor]? { get { fatalError() } set { fatalError() } }
}

open class CBMutableCharacteristic: CBCharacteristic {
    public init(type UUID: CBUUID, properties: CBCharacteristicProperties, value: Data?, permissions: CBAttributePermissions) {}
    open var subscribedCentrals: [CBCentral]? { get { fatalError() } set { fatalError() } }
}

open class CBDescriptor: CBAttribute {
    open var value: Any? { get { fatalError() } set { fatalError() } }
    open var characteristic: CBCharacteristic? { get { fatalError() } set { fatalError() } }
}

open class CBService: CBAttribute {
    open var isPrimary: Bool { get { fatalError() } set { fatalError() } }
    open var characteristics: [CBCharacteristic]? { get { fatalError() } set { fatalError() } }
    open var includedServices: [CBService]? { get { fatalError() } set { fatalError() } }
}

open class CBMutableService: CBService {
    public init(type UUID: CBUUID, primary isPrimary: Bool) {}
    open var mutableCharacteristics: [CBCharacteristic]?
}

open class CBPeripheral: CBPeer {
    open var name: String? { get { fatalError() } set { fatalError() } }
    open var state: CBPeripheralState { fatalError() }
    open var services: [CBService]? { get { fatalError() } set { fatalError() } }
    open var delegate: CBPeripheralDelegate? { get { fatalError() } set { fatalError() } }
    open var canSendWriteWithoutResponse: Bool { get { fatalError() } set { fatalError() } }
    open func discoverServices(_ serviceUUIDs: [CBUUID]?) {}
    open func discoverCharacteristics(_ characteristicUUIDs: [CBUUID]?, for service: CBService) {}
    open func setNotifyValue(_ enabled: Bool, for characteristic: CBCharacteristic) {}
    open func writeValue(_ data: Data, for characteristic: CBCharacteristic, type: CBCharacteristicWriteType) {}
    open func readValue(for characteristic: CBCharacteristic) {}
    open func discoverDescriptors(for characteristic: CBCharacteristic) {}
    open var ancsAuthorized: Bool { get { fatalError() } set { fatalError() } }
}

public struct CBPeripheralState: RawRepresentable {
    public var rawValue: Int
    public init(rawValue: Int) { self.rawValue = rawValue }
    public static let disconnected = CBPeripheralState(rawValue: 0)
    public static let connecting = CBPeripheralState(rawValue: 1)
    public static let connected = CBPeripheralState(rawValue: 2)
    public static let disconnecting = CBPeripheralState(rawValue: 3)
}

open class CBATTRequest: NSObject {
    open var central: CBCentral { get { fatalError() } set { fatalError() } }
    open var characteristic: CBCharacteristic { get { fatalError() } set { fatalError() } }
    open var offset: Int { get { fatalError() } set { fatalError() } }
    open var value: Data? { get { fatalError() } set { fatalError() } }
}

public protocol CBCentralManagerDelegate: AnyObject {
    func centralManagerDidUpdateState(_ central: CBCentralManager)
    func centralManager(_ central: CBCentralManager, didDiscover peripheral: CBPeripheral, advertisementData: [String: Any], rssi RSSI: NSNumber)
    func centralManager(_ central: CBCentralManager, didConnect peripheral: CBPeripheral)
    func centralManager(_ central: CBCentralManager, didFailToConnect peripheral: CBPeripheral, error: Error?)
    func centralManager(_ central: CBCentralManager, didDisconnectPeripheral peripheral: CBPeripheral, error: Error?)
}

public extension CBCentralManagerDelegate {
    func centralManager(_ central: CBCentralManager, didDiscover peripheral: CBPeripheral, advertisementData: [String: Any], rssi RSSI: NSNumber) {}
    func centralManager(_ central: CBCentralManager, didConnect peripheral: CBPeripheral) {}
    func centralManager(_ central: CBCentralManager, didFailToConnect peripheral: CBPeripheral, error: Error?) {}
    func centralManager(_ central: CBCentralManager, didDisconnectPeripheral peripheral: CBPeripheral, error: Error?) {}
}

public protocol CBPeripheralDelegate: AnyObject {
    func peripheral(_ peripheral: CBPeripheral, didDiscoverServices error: Error?)
    func peripheral(_ peripheral: CBPeripheral, didDiscoverCharacteristicsFor service: CBService, error: Error?)
    func peripheral(_ peripheral: CBPeripheral, didUpdateValueFor characteristic: CBCharacteristic, error: Error?)
    func peripheral(_ peripheral: CBPeripheral, didWriteValueFor characteristic: CBCharacteristic, error: Error?)
    func peripheralIsReady(toSendWriteWithoutResponse peripheral: CBPeripheral)
}

public extension CBPeripheralDelegate {
    func peripheral(_ peripheral: CBPeripheral, didDiscoverServices error: Error?) {}
    func peripheral(_ peripheral: CBPeripheral, didDiscoverCharacteristicsFor service: CBService, error: Error?) {}
    func peripheral(_ peripheral: CBPeripheral, didUpdateValueFor characteristic: CBCharacteristic, error: Error?) {}
    func peripheral(_ peripheral: CBPeripheral, didWriteValueFor characteristic: CBCharacteristic, error: Error?) {}
    func peripheralIsReady(toSendWriteWithoutResponse peripheral: CBPeripheral) {}
}

public protocol CBPeripheralManagerDelegate: AnyObject {
    func peripheralManagerDidUpdateState(_ peripheral: CBPeripheralManager)
    func peripheralManager(_ peripheral: CBPeripheralManager, didAdd service: CBService, error: Error?)
    func peripheralManager(_ peripheral: CBPeripheralManager, central: CBCentral, didSubscribeTo characteristic: CBCharacteristic)
    func peripheralManager(_ peripheral: CBPeripheralManager, central: CBCentral, didUnsubscribeFrom characteristic: CBCharacteristic)
    func peripheralManager(_ peripheral: CBPeripheralManager, didReceiveWrite requests: [CBATTRequest])
    func peripheralManager(_ peripheral: CBPeripheralManager, didReceiveRead request: CBATTRequest)
    func peripheralManagerIsReady(toUpdateSubscribers peripheral: CBPeripheralManager)
}

public extension CBPeripheralManagerDelegate {
    func peripheralManager(_ peripheral: CBPeripheralManager, didAdd service: CBService, error: Error?) {}
    func peripheralManager(_ peripheral: CBPeripheralManager, central: CBCentral, didSubscribeTo characteristic: CBCharacteristic) {}
    func peripheralManager(_ peripheral: CBPeripheralManager, central: CBCentral, didUnsubscribeFrom characteristic: CBCharacteristic) {}
    func peripheralManager(_ peripheral: CBPeripheralManager, didReceiveWrite requests: [CBATTRequest]) {}
    func peripheralManager(_ peripheral: CBPeripheralManager, didReceiveRead request: CBATTRequest) {}
    func peripheralManagerIsReady(toUpdateSubscribers peripheral: CBPeripheralManager) {}
}

open class CBCentralManager: NSObject {
    open var state: CBManagerState { fatalError() }
    open var delegate: CBCentralManagerDelegate? { get { fatalError() } set { fatalError() } }
    open var isScanning: Bool { get { fatalError() } set { fatalError() } }
    public init(delegate: CBCentralManagerDelegate?, queue: DispatchQueue?) {}
    public init(delegate: CBCentralManagerDelegate?, queue: DispatchQueue?, options: [String: Any]?) {}
    open func scanForPeripherals(withServices serviceUUIDs: [CBUUID]?, options: [String: Any]?) {}
    open func stopScan() {}
    open func connect(_ peripheral: CBPeripheral, options: [String: Any]?) {}
    open func cancelPeripheralConnection(_ peripheral: CBPeripheral) {}
    open func retrieveConnectedPeripherals(withServices serviceUUIDs: [CBUUID]) -> [CBPeripheral] { fatalError() }
    open func retrievePeripherals(withIdentifiers identifiers: [UUID]) -> [CBPeripheral] { fatalError() }
}

open class CBPeripheralManager: NSObject {
    open var state: CBManagerState { fatalError() }
    open var delegate: CBPeripheralManagerDelegate? { get { fatalError() } set { fatalError() } }
    open var isAdvertising: Bool { get { fatalError() } set { fatalError() } }
    public init(delegate: CBPeripheralManagerDelegate?, queue: DispatchQueue?) {}
    public init(delegate: CBPeripheralManagerDelegate?, queue: DispatchQueue?, options: [String: Any]?) {}
    open func add(_ service: CBMutableService) {}
    open func remove(_ service: CBMutableService) {}
    open func removeAllServices() {}
    open func startAdvertising(_ advertisementData: [String: Any]?) {}
    open func stopAdvertising() {}
    open func updateValue(_ value: Data, for characteristic: CBMutableCharacteristic, onSubscribedCentrals centrals: [CBCentral]?) -> Bool { false }
    open func respond(to request: CBATTRequest, withResult result: CBATTError) {}
}

public let CBAdvertisementDataLocalNameKey = "kCBAdvDataLocalName"
public let CBAdvertisementDataServiceUUIDsKey = "kCBAdvDataServiceUUIDs"
public let CBAdvertisementDataServiceDataKey = "kCBAdvDataServiceData"
public let CBAdvertisementDataManufacturerDataKey = "kCBAdvDataManufacturerData"
public let CBAdvertisementDataOverflowServiceUUIDsKey = "kCBAdvDataOverflowServiceUUIDs"
public let CBAdvertisementDataTxPowerLevelKey = "kCBAdvDataTxPowerLevel"
public let CBAdvertisementDataIsConnectable = "kCBAdvDataIsConnectable"
public let CBAdvertisementDataSolicitedServiceUUIDsKey = "kCBAdvDataSolicitedServiceUUIDs"
public let CBCentralManagerScanOptionAllowDuplicatesKey = "kCBScanOptionAllowDuplicates"
public let CBCentralManagerOptionShowPowerAlertKey = "kCBMsgArgOptionShowPowerAlert"

public extension Notification.Name {
    static let CBPeripheralManagerDidUpdateState = Notification.Name(rawValue: "CBPeripheralManagerDidUpdateState")
    static let CBCentralManagerDidUpdateState = Notification.Name(rawValue: "CBCentralManagerDidUpdateState")
}
