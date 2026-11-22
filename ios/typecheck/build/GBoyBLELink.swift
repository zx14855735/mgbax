/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */



/**
 * iOS 的「蓝牙联机」：用 CoreBluetooth(BLE) 的 GATT 当字节管道，
 * 承载与 TCP 路径**完全相同**的 GBoy 线格式（4 字节大端长度 + payload，
 * type 0/1/2/3/5/6/9/10/100 的语义一字不改）。
 *
 * 为什么是 BLE 而不是 RFCOMM：iOS 没有经典蓝牙串口 API（ExternalAccessory
 * 只对 MFi 外设开放）。GATT 的 notify/write 就是 RFCOMM 的等价物：
 *   - 房主 = CBPeripheralManager，开一条 notify 特征（房主→客户端）
 *     和一条 write 特征（客户端→房主）；
 *   - 加入 = CBCentralManager 扫服务、连上、订阅 notify、往 write 特征写。
 * BLE 单包载荷有限，所以按 180 字节切片；切片本身不再加头，
 * 接收侧把字节流按 GBoy 的 4 字节长度头重组即可（与 TCP 收包一致）。
 */
final class GBoyBLELink: NSObject {
    static let serviceUUID = CBUUID(string: "3A1F7B2E-4C55-4C7E-9E1D-2B7C1A9F0001")
    static let notifyUUID = CBUUID(string: "3A1F7B2E-4C55-4C7E-9E1D-2B7C1A9F0002")
    static let writeUUID = CBUUID(string: "3A1F7B2E-4C55-4C7E-9E1D-2B7C1A9F0003")
    private static let chunk = 180

    /// 官方消息号（与 GBoyLink 同一张表，禁止在这里另立编号）。
    private static let msgHello = 1
    private static let msgReady = 3
    private static let msgKeys = 0
    private static let msgReset = 5
    private static let msgState = 6
    private static let msgSpeed = 9
    private static let msgDisconnect = 10
    private static let msgRomInfo = 2

    var onStatus: ((String) -> Void)?
    var onConnected: ((Bool) -> Void)?
    var onDisconnected: (() -> Void)?
    var onRemoteKeys: ((Int32) -> Void)?
    var onRemoteReset: (() -> Void)?
    var onRemoteSpeed: ((Int32) -> Void)?
    var onRemoteState: (([UInt8]) -> Void)?
    var localKeys: (() -> Int32)?
    var localRomName: (() -> String)?
    var stateSnapshot: (() -> [UInt8]?)?

    private(set) var isHost = false
    private var running = false
    private var peripheralManager: CBPeripheralManager?
    private var centralManager: CBCentralManager?
    private var peer: CBPeripheral?
    private var notifyChar: CBMutableCharacteristic?
    private var writeChar: CBMutableCharacteristic?
    private var peerWriteChar: CBCharacteristic?
    private var subscribed: [CBCentral] = []
    private var outbox: [Data] = []
    private var inbound = Data()
    private var keyTimer: Timer?
    private var handshakeDone = false
    private var lastSentKeys: Int32 = -1
    private var linkTitle = ""

    // MARK: - Public

    func host(name: String) {
        stop()
        isHost = true
        running = true
        linkTitle = name
        inbound.removeAll()
        outbox.removeAll()
        handshakeDone = false
        lastSentKeys = -1
        peripheralManager = CBPeripheralManager(delegate: self, queue: .main)
        onStatus?("蓝牙：等待对方加入…")
    }

    func join(name: String) {
        stop()
        isHost = false
        running = true
        linkTitle = name
        inbound.removeAll()
        outbox.removeAll()
        handshakeDone = false
        lastSentKeys = -1
        centralManager = CBCentralManager(delegate: self, queue: .main)
        onStatus?("蓝牙：正在搜索房主…")
    }

    func stop() {
        running = false
        handshakeDone = false
        keyTimer?.invalidate()
        keyTimer = nil
        if let centralManager {
            centralManager.stopScan()
            if let peer {
                centralManager.cancelPeripheralConnection(peer)
            }
        }
        if let peripheralManager {
            peripheralManager.stopAdvertising()
            peripheralManager.removeAllServices()
        }
        centralManager = nil
        peripheralManager = nil
        peer = nil
        peerWriteChar = nil
        notifyChar = nil
        writeChar = nil
        subscribed.removeAll()
        outbox.removeAll()
        inbound.removeAll()
    }

    func sendKeys(_ keys: Int32) {
        guard handshakeDone else { return }
        if keys == lastSentKeys { return }
        lastSentKeys = keys
        enqueue(Self.intFrame(Self.msgKeys, keys))
    }

    func sendReset() {
        enqueue(Self.intFrame(Self.msgReset, 0))
    }

    /// 官方 type 9：0.5x/1x/2x/4x 的线值仍是 -1/1/2/4。
    func sendSpeed(_ wire: Int32) {
        enqueue(Self.intFrame(Self.msgSpeed, wire))
    }

    func sendDisconnect() {
        enqueue(Self.frame(Self.msgDisconnect))
    }

    // MARK: - Framing

    private static func frame(_ type: Int) -> [UInt8] {
        [UInt8((type >> 8) & 0xFF), UInt8(type & 0xFF)]
    }

    private static func intFrame(_ type: Int, _ value: Int32) -> [UInt8] {
        [UInt8((type >> 8) & 0xFF), UInt8(type & 0xFF),
         UInt8(truncatingIfNeeded: value >> 24), UInt8(truncatingIfNeeded: value >> 16),
         UInt8(truncatingIfNeeded: value >> 8), UInt8(truncatingIfNeeded: value)]
    }

    private static func value(_ frame: [UInt8]) -> Int32 {
        guard frame.count >= 6 else { return -1 }
        return Int32(bitPattern: UInt32(frame[2]) << 24 | UInt32(frame[3]) << 16
                     | UInt32(frame[4]) << 8 | UInt32(frame[5]))
    }

    /// 与 TCP 的 `send()` 同形：4 字节大端长度 + payload。
    private func enqueue(_ payload: [UInt8]) {
        guard running, !payload.isEmpty else { return }
        var data = Data()
        let length = payload.count
        data.append(UInt8((length >> 24) & 0xFF))
        data.append(UInt8((length >> 16) & 0xFF))
        data.append(UInt8((length >> 8) & 0xFF))
        data.append(UInt8(length & 0xFF))
        data.append(contentsOf: payload)
        outbox.append(data)
        flush()
    }

    private func flush() {
        guard running else { return }
        while let first = outbox.first {
            let slice = first.prefix(Self.chunk)
            let sent: Bool
            if isHost {
                guard let notifyChar else { return }
                sent = peripheralManager?.updateValue(Data(slice),
                                                      for: notifyChar,
                                                      onSubscribedCentrals: nil) ?? false
            } else if let current = peer, let characteristic = peerWriteChar {
                // 无响应写没有回执，靠 canSendWriteWithoutResponse 做流控。
                guard current.canSendWriteWithoutResponse else { return }
                current.writeValue(Data(slice), for: characteristic, type: .withoutResponse)
                sent = true
            } else {
                sent = false
            }
            if !sent {
                // 队列满（notify 返回 false / 还没连上）：留着等回调再冲。
                return
            }
            if first.count <= Self.chunk {
                outbox.removeFirst()
            } else {
                outbox[0] = Data(first.dropFirst(Self.chunk))
            }
        }
    }

    /// 把收到的字节流按 GBoy 的 4 字节长度头切帧。
    private func ingest(_ data: Data) {
        inbound.append(data)
        while inbound.count >= 4 {
            let header = [UInt8](inbound.prefix(4))
            let length = Int(header[0]) << 24 | Int(header[1]) << 16
                | Int(header[2]) << 8 | Int(header[3])
            guard length > 0, length <= 4 * 1024 * 1024 else {
                inbound.removeAll()
                return
            }
            guard inbound.count >= 4 + length else { return }
            let frame = [UInt8](inbound[4..<(4 + length)])
            inbound.removeFirst(4 + length)
            handle(frame)
        }
    }

    private func handle(_ frame: [UInt8]) {
        guard frame.count >= 2 else { return }
        let type = Int(frame[0]) << 8 | Int(frame[1])
        switch type {
        case Self.msgHello:
            if isHost {
                finishHandshake()
            } else {
                enqueue(Self.helloFrame())
                sendRomInfo()
                finishHandshake()
            }
        case Self.msgRomInfo:
            break
        case Self.msgReady:
            break
        case Self.msgKeys:
            if frame.count >= 6 {
                onRemoteKeys?(Self.value(frame))
            }
        case Self.msgReset:
            onRemoteReset?()
        case Self.msgSpeed:
            let wire = Self.value(frame)
            if wire == 1 || wire == -1 || wire == 2 || wire == 4 {
                onRemoteSpeed?(wire)
            }
        case Self.msgDisconnect:
            onStatus?("对方已断开（蓝牙）")
            stop()
            onDisconnected?()
        case Self.msgState:
            if frame.count >= 6 {
                let size = Int(frame[2]) << 24 | Int(frame[3]) << 16
                    | Int(frame[4]) << 8 | Int(frame[5])
                if size > 0, frame.count >= 6 + size {
                    onRemoteState?(Array(frame[6..<(6 + size)]))
                }
            }
        default:
            break
        }
    }

    private static func helloFrame() -> [UInt8] {
        [0, UInt8(msgHello), 0, 0, 0, 6]
    }

    private func sendRomInfo() {
        var name = [UInt8](repeating: 0, count: 32)
        let text = Array((localRomName?() ?? "mGBAx").utf8.prefix(31))
        for (index, byte) in text.enumerated() {
            name[index] = byte
        }
        var payload: [UInt8] = [0, UInt8(Self.msgRomInfo)]
        payload.append(contentsOf: name)
        enqueue(payload)
    }

    /// 握手收尾：置 ready、双向交换一次 type 6（与 TCP 路径同顺序：客户端先发）。
    private func finishHandshake() {
        guard !handshakeDone else { return }
        handshakeDone = true
        enqueue(Self.intFrame(Self.msgReady, 0))
        if !isHost, let snapshot = stateSnapshot?(), !snapshot.isEmpty {
            var payload: [UInt8] = [0, UInt8(Self.msgState)]
            let size = snapshot.count
            payload.append(UInt8((size >> 24) & 0xFF))
            payload.append(UInt8((size >> 16) & 0xFF))
            payload.append(UInt8((size >> 8) & 0xFF))
            payload.append(UInt8(size & 0xFF))
            payload.append(contentsOf: snapshot)
            enqueue(payload)
        }
        startKeyPump()
        onConnected?(isHost)
        onStatus?(isHost ? "蓝牙已连接，你是 1P" : "蓝牙已连接，你是 2P")
    }

    private func startKeyPump() {
        keyTimer?.invalidate()
        let timer = Timer(timeInterval: 1.0 / 30.0, repeats: true) { [weak self] _ in
            guard let self, self.handshakeDone else { return }
            self.sendKeys(self.localKeys?() ?? 0)
        }
        RunLoop.main.add(timer, forMode: .common)
        keyTimer = timer
    }
}

// MARK: - Host side

extension GBoyBLELink: CBPeripheralManagerDelegate {
    func peripheralManagerDidUpdateState(_ peripheral: CBPeripheralManager) {
        guard running, isHost else { return }
        guard peripheral.state == .poweredOn else {
            onStatus?("蓝牙不可用（\(peripheral.state.rawValue)）")
            return
        }
        let notify = CBMutableCharacteristic(type: Self.notifyUUID,
                                             properties: [.notify],
                                             value: nil,
                                             permissions: [])
        let write = CBMutableCharacteristic(type: Self.writeUUID,
                                            properties: [.write, .writeWithoutResponse],
                                            value: nil,
                                            permissions: [.writeable])
        notifyChar = notify
        writeChar = write
        let service = CBMutableService(type: Self.serviceUUID, primary: true)
        service.characteristics = [notify, write]
        peripheral.add(service)
    }

    func peripheralManager(_ peripheral: CBPeripheralManager, didAdd service: CBService, error: Error?) {
        guard running, isHost, error == nil else { return }
        peripheral.startAdvertising([
            CBAdvertisementDataServiceUUIDsKey: [Self.serviceUUID],
            CBAdvertisementDataLocalNameKey: "mGBAx-\(linkTitle)"
        ])
    }

    func peripheralManager(_ peripheral: CBPeripheralManager, central: CBCentral,
                           didSubscribeTo characteristic: CBCharacteristic) {
        guard characteristic.uuid == Self.notifyUUID else { return }
        if !subscribed.contains(where: { $0.identifier == central.identifier }) {
            subscribed.append(central)
        }
        // 房主先发 hello，客户端收到后回 hello（与 TCP 的 expectHello 同序）。
        enqueue(Self.helloFrame())
    }

    func peripheralManager(_ peripheral: CBPeripheralManager,
                           didReceiveWrite requests: [CBATTRequest]) {
        for request in requests {
            if let data = request.value, request.characteristic.uuid == Self.writeUUID {
                ingest(data)
            }
            peripheral.respond(to: request, withResult: .success)
        }
        flush()
    }

    func peripheralManagerIsReady(toUpdateSubscribers peripheral: CBPeripheralManager) {
        flush()
    }
}

// MARK: - Client side

extension GBoyBLELink: CBCentralManagerDelegate, CBPeripheralDelegate {
    func centralManagerDidUpdateState(_ central: CBCentralManager) {
        guard running, !isHost else { return }
        guard central.state == .poweredOn else {
            onStatus?("蓝牙不可用（\(central.state.rawValue)）")
            return
        }
        central.scanForPeripherals(withServices: [Self.serviceUUID], options: nil)
    }

    func centralManager(_ central: CBCentralManager, didDiscover peripheral: CBPeripheral,
                        advertisementData: [String: Any], rssi RSSI: NSNumber) {
        guard running, !isHost, peer == nil else { return }
        central.stopScan()
        peer = peripheral
        peripheral.delegate = self
        central.connect(peripheral, options: nil)
        onStatus?("蓝牙：正在连接…")
    }

    func centralManager(_ central: CBCentralManager, didConnect peripheral: CBPeripheral) {
        peripheral.discoverServices([Self.serviceUUID])
    }

    func centralManager(_ central: CBCentralManager, didFailToConnect peripheral: CBPeripheral,
                        error: Error?) {
        onStatus?("蓝牙连接失败")
        stop()
        onDisconnected?()
    }

    func centralManager(_ central: CBCentralManager, didDisconnectPeripheral peripheral: CBPeripheral,
                        error: Error?) {
        guard running, !isHost else { return }
        onStatus?("蓝牙已断开")
        stop()
        onDisconnected?()
    }

    func peripheral(_ peripheral: CBPeripheral, didDiscoverServices error: Error?) {
        for service in peripheral.services ?? [] where service.uuid == Self.serviceUUID {
            peripheral.discoverCharacteristics([Self.notifyUUID, Self.writeUUID], for: service)
        }
    }

    func peripheral(_ peripheral: CBPeripheral,
                    didDiscoverCharacteristicsFor service: CBService, error: Error?) {
        for characteristic in service.characteristics ?? [] {
            if characteristic.uuid == Self.notifyUUID {
                peripheral.setNotifyValue(true, for: characteristic)
            } else if characteristic.uuid == Self.writeUUID {
                peerWriteChar = characteristic
            }
        }
    }

    func peripheral(_ peripheral: CBPeripheral, didUpdateValueFor characteristic: CBCharacteristic,
                    error: Error?) {
        guard characteristic.uuid == Self.notifyUUID, let data = characteristic.value else { return }
        ingest(data)
        flush()
    }

    func peripheralIsReady(toSendWriteWithoutResponse peripheral: CBPeripheral) {
        flush()
    }
}
