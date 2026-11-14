/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
import Compression
import CryptoKit
import Darwin
import Foundation

/**
 * GBoy / My Boy "联机大厅" Wi-Fi protocol, a Swift port of the Android
 * GBoyLink: plain TCP with big-endian framing, every packet is
 * `[u32 payload length][payload]` and the payload starts with a `u16`
 * message type.
 *
 * 消息号逐条对齐官方客户端（KpHwm4.B25kr6 的 ARc23Z 调用、KpHwm4/AmA8tU.java）：
 *
 *   0 PACING    u16 type + int32 fps；帧率上限，接收方据此限本机帧率。
 *   1 HELLO     u16 type + u32 6；客户端先发，服务端原样回。
 *   2 ROMINFO   u16 type + 32 字节 ASCII MD5 + u16 名字长度 + 名字。
 *   3 READY     u16 type（官方还允许带 int32 rtt，见 B25kr6:131）。
 *   5 READY_ACK u16 type；就绪确认，只有客户端路径发。
 *   6 STATE     u16 type + u32 size + 整份 mGBA 即时存档。
 *   9 KEYS      u16 type + u32 GBA 按键掩码（与 mGBA 同一位序）。
 *  13 RESET     u16 type；自家扩展（官方没有复位消息）。
 *
 * 断线重连另有官方私有包：裸 10 字节 `int32 6 + int16 100 + int32 rtt`
 * （AmA8tU.ARc23Z(Socket):263-272），按帧格式读出来就是「长度 6 + type 100 +
 * 4 字节 rtt」，即 type 100 带 int32 rtt。见 msgReconnect。
 *
 * After the handshake each side sends its key mask about every five frames
 * (~83 ms) and applies the mask it receives, so a GBoy handset drives the
 * remote player here the same way it would drive its own second console.
 *
 * 蓝牙：官方还有一条经典蓝牙 RFCOMM 通道（`KpHwm4/A4TApA`、服务名 `GBoy`、
 * UUID 3a1f7b2e-8d45-4c92-bf60-5e3c21a98d47），字节流上跑的就是上面这套
 * 「4B 大端长度 + u16 type」帧。**iOS 上这条路不存在**：Apple 只对 MFi
 * 配件开放 ExternalAccessory，第三方 App 拿不到 RFCOMM 的
 * `listenUsingRfcommWithServiceRecord` / `createRfcommSocketToServiceRecord`。
 * iOS 能做的等价物是 BLE 自定义 GATT 服务（一条 write/notify 特征对，
 * 把同样的帧切块塞进去），但它需要设备端也实现同一套 GATT 服务，且带宽
 * 与 20 字节 MTU 的分片方式和 RFCOMM 完全不同 —— 目前**未实现**，这里
 * 不留半成品代码。热点/Wi-Fi 直连（本文件的 TCP 路径）是 iOS 的实际通道。
 */
final class GBoyLink {
    static let defaultPort = 6374

    private struct LinkError: Error {
        let message: String
        /// 读超时（SO_RCVTIMEO 到点）而不是对端断开：状态同步这类「对端可能
        /// 不发」的可选步骤要能把它和真正的断线区分开。
        var timeout = false
    }

    // 消息号必须与官方客户端（KpHwm4.B25kr6 的 ARc23Z 调用）以及 PC/Android
    // 两端的 GBoyFrames 完全一致：0 节奏 / 1 握手 / 2 名字 / 3 就绪+RTT /
    // 5 就绪确认 / 6 状态 / 9 按键。自家扩展一律用 11 以上的号。
    private static let msgPacing = 0
    private static let msgHello = 1
    private static let msgRomInfo = 2
    private static let msgReady = 3
    private static let msgReadyAck = 5
    private static let msgState = 6
    private static let msgKeys = 9
    /// 复位是我们自己的扩展（官方没有这条消息），放在 11 以上避免撞号。
    private static let msgReset = 13
    /// 官方断线重连握手（AmA8tU.ARc23Z(Socket):263-272）：type 100 + int32 rtt。
    private static let msgReconnect = 100

    var romPath: () -> String? = { nil }
    var localKeys: () -> Int32 = { 0 }
    /**
     * 取本机可见核的即时存档（mGBA 格式，和 PC 的
     * `mgbaMobileSaveStateToMemory` / Android 的 `MgbaCore.saveStateToMemory`
     * 同一份字节）。GBoy 的 type 6 就是把这个东西整包发给对端，对端灌进
     * 「代表本机这个玩家」的镜像核。
     *
     * 没接线时返回 nil，此时**不再**回落到早先那个「合成一份 900KB 全零
     * GBASTATE」的假实现：那种包在 PC/Android 上会被 loadState 拒绝
     * （格式不同），只会掩盖问题。
     */
    var saveState: () -> [UInt8]? = { nil }
    /// Key mask received from the peer; called from the reader thread.
    var onRemoteKeys: (Int32) -> Void = { _ in }
    /// Slot-tagged variant for the N-core layout. This 2-player protocol has
    /// no per-slot tag, so the peer always maps to global slot 1.
    var onRemoteKeysForSlot: (Int, Int32) -> Void = { _, _ in }
    /// Called from background threads; the owner hops to the main queue.
    var onStatus: (String) -> Void = { _ in }
    /// Peer asked for a console reset; called from the reader thread.
    var onRemoteReset: () -> Void = {}
    /// 收到对端 type 6 的整份存档：交给镜像核（代表对端那个玩家）载入。
    var onRemoteState: ([UInt8]) -> Void = { _ in }
    /// 官方 type 0（节奏）：对端下发的帧率上限。0 或越界值表示「没有上限」，
    /// 由上层按 1000/fps 调整帧循环的目标间隔。Called from the reader thread.
    var onRemotePacing: (Int) -> Void = { _ in }

    private let lock = NSLock()
    private var isClosedFlag = false
    private var currentFd: Int32 = -1
    /// 对端上报的 RTT（官方 type 3 / 重连包里的 int32），-1 = 未知。lock 保护。
    private var lastRttValue: Int32 = -1

    private var closed: Bool {
        lock.lock()
        defer { lock.unlock() }
        return isClosedFlag
    }

    /** Starts hosting on the given port; the peer connects to this device. */
    func host(_ port: Int) {
        run(asHost: true, ip: nil, port: port)
    }

    /** Connects to a GBoy room that is already hosting. */
    func join(_ ip: String, _ port: Int) {
        run(asHost: false, ip: ip, port: port)
    }

    /** Sends the reset notice to the peer (user pressed 复位). */
    func sendReset() {
        lock.lock()
        let fd = currentFd
        let dead = isClosedFlag
        lock.unlock()
        if fd >= 0 && !dead {
            try? Self.sendAll(fd, Self.frame(Self.msgReset))
        }
    }

    /// 对端上报的 RTT（官方 `A5SV6n.f5293B9tovu`），-1 = 还没收到。
    var lastRtt: Int32 {
        lock.lock()
        defer { lock.unlock() }
        return lastRttValue
    }

    /**
     * 官方断线重连握手：裸 10 字节 `int32 6 + int16 100 + int32 rtt`
     * （KpHwm4/AmA8tU.java 的 ARc23Z(Socket)，263-272 行）。这 10 字节本身就是
     * 一条完整帧（长度 6 + type 100 + rtt），所以用 sendAll() 原样写出，不再
     * 经过 send() 补长度头。
     *
     * 只在**已经和对端完成过一次握手**的会话上发：官方用它代替整套 1→2→3→6
     * 重放（存档早已灌进镜像核）。iOS 的 GBoyLink 是一次性会话（断开即结束，
     * 没有 AmA8tU 那个 50 秒自动重连循环），所以这里只提供发送入口，供上层
     * 在自建的重连流程里复用；接收侧已经能识别 type 100（见 expectHello）。
     */
    func sendReconnectHandshake() {
        lock.lock()
        let fd = currentFd
        let dead = isClosedFlag
        let rtt = lastRttValue
        lock.unlock()
        guard fd >= 0, !dead else { return }
        try? Self.sendAll(fd, Self.reconnectFrame(rtt: rtt))
    }

    func close() {
        lock.lock()
        isClosedFlag = true
        let fd = currentFd
        currentFd = -1
        lock.unlock()
        if fd >= 0 {
            shutdown(fd, SHUT_RDWR)
            Darwin.close(fd)
        }
        onRemoteKeys(0)
        onRemotePacing(0)   // 断开就撤销对端的帧率上限（同 drop）
    }

    private func run(asHost: Bool, ip: String?, port: Int) {
        // A fresh session clears any previous close: 断开 followed by a new
        // join must work without recreating this object.
        lock.lock()
        isClosedFlag = false
        let stale = currentFd
        currentFd = -1
        lock.unlock()
        if stale >= 0 {
            shutdown(stale, SHUT_RDWR)
            Darwin.close(stale)
        }
        let thread = Thread { [weak self] in
            guard let self else { return }
            do {
                if asHost {
                    try self.hostLoop(port)
                } else {
                    try self.guestLoop(ip ?? "", port)
                }
            } catch {
                if !self.closed {
                    self.status(Self.message(error))
                }
            }
        }
        thread.name = "gboy-link"
        thread.stackSize = 1 << 20
        thread.start()
    }

    private func hostLoop(_ port: Int) throws {
        status("联机大厅等待连接…\n端口 \(port)，你是 1P")
        let listenFd = try listenSocket(port)
        defer { Darwin.close(listenFd) }
        let accepted = try acceptLoop(listenFd)
        store(fd: accepted)
        Self.tune(accepted)
        status("对方已接入，正在同步…")
        let note = try handshake(accepted, asHost: true)
        try session(accepted, asHost: true, note: note)
    }

    private func guestLoop(_ ip: String, _ port: Int) throws {
        status("正在连接 \(ip):\(port)…")
        let fd = try connectSocket(ip, port)
        store(fd: fd)
        Self.tune(fd)
        status("已连上，正在同步…")
        let note = try handshake(fd, asHost: false)
        try session(fd, asHost: false, note: note)
    }

    private func handshake(_ fd: Int32, asHost: Bool) throws -> String {
        var note = ""
        if !asHost {
            try send(fd, Self.helloFrame())
        }
        let resumed = try expectHello(fd, asHost: asHost)
        /* 官方断线重连（AmA8tU.ARc23Z(Socket):263-272）：对端直接发裸 10 字节
         * `int32 6 + int16 100 + int32 rtt` 就进入按键转发，不再走 2/3/6 ——
         * 存档早在第一次握手时就灌进镜像核了，重放反而会把两边拉回旧进度。 */
        if resumed {
            return Self.appendNote(note, "已恢复联机（重连握手）")
        }

        let info = try romInfo()
        try send(fd, info)
        status("已交换游戏信息…")

        let peer = try nextFrame(fd, want: Self.msgRomInfo)
        if peer.count < 34 {
            throw LinkError(message: "对方不是联机大厅会话")
        }
        let peerHash = String(bytes: peer[2..<34], encoding: .ascii) ?? ""
        let mine = String(bytes: info[2..<34], encoding: .ascii) ?? ""
        if peerHash.lowercased() != mine.lowercased() {
            note = "注意：两边的游戏不一致，联机可能无法正常同步"
        }

        try send(fd, Self.frame(Self.msgReady))
        _ = try nextFrame(fd, want: Self.msgReady)

        /* type 6 双向交换，而且是**照抄官方**的用法：收到的存档要灌进
         * 「代表对端那个玩家」的镜像核，不是收下就扔。以前这里把对端存档
         * 丢掉并写"本机继续用本机进度"，两端的镜像核因此停在不同的一幕。 */
        var exchanged = true
        if asHost {
            if let peer = try readState(fd) {
                onRemoteState(peer)
            } else {
                exchanged = false
            }
            if let mine = try stateFrame() {
                try send(fd, mine)
            }
        } else {
            if let mine = try stateFrame() {
                try send(fd, mine)
            }
            if let peer = try readState(fd) {
                onRemoteState(peer)
            } else {
                exchanged = false
            }
        }
        return Self.appendNote(note, exchanged ? "已交换即时存档" : "对方没有发即时存档")
    }

    private static func appendNote(_ note: String, _ extra: String) -> String {
        note.isEmpty ? extra : note + "\n" + extra
    }

    private func session(_ fd: Int32, asHost: Bool, note: String) throws {
        // The steady state has no handshake deadline: the peer may not even
        // have connected yet, and its key frames arrive at their own cadence.
        Self.clearTimeouts(fd)
        var text = asHost ? "已连接，你是 1P" : "已连接，你是 2P"
        if !note.isEmpty {
            text = note + "\n" + text
        }
        status(text)
        let reader = Thread { [weak self] in
            self?.readLoop(fd)
        }
        reader.name = "gboy-read"
        reader.stackSize = 1 << 20
        reader.start()
        pump(fd)
    }

    private func readLoop(_ fd: Int32) {
        do {
            while !closed {
                let frame = try readFrame(fd)
                let messageType = Self.type(frame)
                if messageType == Self.msgKeys, frame.count >= 6 {
                    let keys = Int32(frame[2]) << 24 | Int32(frame[3]) << 16 | Int32(frame[4]) << 8 | Int32(frame[5])
                    onRemoteKeys(keys)
                    onRemoteKeysForSlot(1, keys)
                } else if messageType == Self.msgReset {
                    onRemoteReset()
                } else if messageType == Self.msgPacing {
                    // 官方 type 0（AzWtSf:174-179 / AmA8tU:213-221）：收到就把
                    // 本机帧率上限设成这个值（AaHO0E.f4302AZkASS）。0 和离谱
                    // 值当「没有上限」，一颗坏包不该把本机帧率钉死。
                    let fps = Self.intValue(frame)
                    if fps > 0, fps <= 240 {
                        onRemotePacing(Int(fps))
                    }
                } else if messageType == Self.msgReady {
                    // 官方 type 3：就绪 + 上报 RTT（B25kr6:131）。
                    let rtt = Self.intValue(frame)
                    if rtt >= 0 {
                        lock.lock()
                        lastRttValue = rtt
                        lock.unlock()
                    }
                } else if messageType == Self.msgReconnect {
                    // 对端重连：只带 rtt，没有别的语义，记下即可。
                    let rtt = Self.intValue(frame)
                    if rtt >= 0 {
                        lock.lock()
                        lastRttValue = rtt
                        lock.unlock()
                    }
                } else if messageType == Self.msgState, frame.count >= 6 {
                    // 会话中途再收到整份存档（官方客户端重连后会补发）：按
                    // type 6 的边界取 body 交给镜像核。
                    let size = Int(frame[2]) << 24 | Int(frame[3]) << 16
                             | Int(frame[4]) << 8 | Int(frame[5])
                    if size > 0, frame.count >= 6 + size {
                        onRemoteState(Array(frame[6..<(6 + size)]))
                    }
                }
            }
        } catch {
            drop(Self.message(error))
        }
    }

    private func pump(_ fd: Int32) {
        while !closed {
            do {
                try send(fd, Self.keysFrame(localKeys()))
            } catch {
                drop(Self.message(error))
                return
            }
            Thread.sleep(forTimeInterval: 0.083)
        }
    }

    private func drop(_ text: String) {
        if closed {
            return
        }
        lock.lock()
        isClosedFlag = true
        let fd = currentFd
        currentFd = -1
        lock.unlock()
        if fd >= 0 {
            shutdown(fd, SHUT_RDWR)
            Darwin.close(fd)
        }
        onRemoteKeys(0)
        // 会话结束：撤销对端的帧率上限（0 = 无上限），否则本机会一直按
        // 对端最后要求的 30fps 慢放。onRemotePacing 的 0 与「没收到」等价。
        onRemotePacing(0)
        status(text)
    }

    private func status(_ text: String) {
        onStatus(text)
    }

    private func store(fd: Int32) {
        lock.lock()
        currentFd = fd
        lock.unlock()
    }

    // ---- wire helpers ----

    private static func tune(_ fd: Int32) {
        var one: Int32 = 1
        setsockopt(fd, IPPROTO_TCP, TCP_NODELAY, &one, socklen_t(MemoryLayout<Int32>.size))
        var tv = timeval(tv_sec: 15, tv_usec: 0)
        setsockopt(fd, SOL_SOCKET, SO_RCVTIMEO, &tv, socklen_t(MemoryLayout<timeval>.size))
        setsockopt(fd, SOL_SOCKET, SO_SNDTIMEO, &tv, socklen_t(MemoryLayout<timeval>.size))
    }

    private static func clearTimeouts(_ fd: Int32) {
        var tv = timeval(tv_sec: 0, tv_usec: 0)
        setsockopt(fd, SOL_SOCKET, SO_RCVTIMEO, &tv, socklen_t(MemoryLayout<timeval>.size))
        setsockopt(fd, SOL_SOCKET, SO_SNDTIMEO, &tv, socklen_t(MemoryLayout<timeval>.size))
    }

    private static func setNonBlocking(_ fd: Int32) {
        let flags = fcntl(fd, F_GETFL, 0)
        if flags >= 0 {
            fcntl(fd, F_SETFL, flags | O_NONBLOCK)
        }
    }

    private static func setBlocking(_ fd: Int32) {
        let flags = fcntl(fd, F_GETFL, 0)
        if flags >= 0 {
            fcntl(fd, F_SETFL, flags & ~O_NONBLOCK)
        }
    }

    private func listenSocket(_ port: Int) throws -> Int32 {
        let fd = socket(AF_INET, SOCK_STREAM, 0)
        guard fd >= 0 else { throw LinkError(message: "联机大厅连接失败") }
        var yes: Int32 = 1
        setsockopt(fd, SOL_SOCKET, SO_REUSEADDR, &yes, socklen_t(MemoryLayout<Int32>.size))
        var addr = sockaddr_in()
        addr.sin_family = sa_family_t(AF_INET)
        addr.sin_port = in_port_t(port).bigEndian
        addr.sin_addr.s_addr = INADDR_ANY
        let bound = withUnsafePointer(to: &addr) { pointer -> Int32 in
            bind(fd, UnsafePointer<sockaddr>(OpaquePointer(pointer)), socklen_t(MemoryLayout<sockaddr_in>.size))
        }
        guard bound == 0, listen(fd, 1) == 0 else {
            Darwin.close(fd)
            throw LinkError(message: "端口 \(port) 被占用")
        }
        Self.setNonBlocking(fd)
        return fd
    }

    /** FD_ZERO/FD_SET macros are not exposed to Swift on Darwin. */
    private static func fdZero(_ set: inout fd_set) {
        withUnsafeMutableBytes(of: &set) { raw in
            let bits = raw.bindMemory(to: Int32.self)
            for index in 0..<bits.count {
                bits[index] = 0
            }
        }
    }

    private static func fdSet(_ fd: Int32, _ set: inout fd_set) {
        withUnsafeMutableBytes(of: &set) { raw in
            let bits = raw.bindMemory(to: Int32.self)
            bits[Int(fd / 32)] |= Int32(1) << (fd % 32)
        }
    }

    /** Accept loop on a non-blocking socket so 关闭 can break it out. */
    private func acceptLoop(_ listenFd: Int32) throws -> Int32 {
        while true {
            if closed {
                throw LinkError(message: "已取消")
            }
            var readSet = fd_set()
            Self.fdZero(&readSet)
            Self.fdSet(listenFd, &readSet)
            var tv = timeval(tv_sec: 0, tv_usec: 250_000)
            let ready = select(listenFd + 1, &readSet, nil, nil, &tv)
            guard ready > 0 else { continue }
            let fd = accept(listenFd, nil, nil)
            if fd >= 0 {
                Self.setBlocking(fd)
                return fd
            }
            if errno != EAGAIN && errno != EWOULDBLOCK {
                throw LinkError(message: "联机大厅连接失败")
            }
        }
    }

    private func connectSocket(_ ip: String, _ port: Int) throws -> Int32 {
        var hints = addrinfo()
        hints.ai_family = AF_INET
        hints.ai_socktype = SOCK_STREAM
        hints.ai_protocol = IPPROTO_TCP
        var info: UnsafeMutablePointer<addrinfo>?
        guard getaddrinfo(ip, String(port), &hints, &info) == 0, let info else {
            throw LinkError(message: "无法解析地址 \(ip)")
        }
        defer { freeaddrinfo(info) }
        let fd = socket(info.pointee.ai_family, info.pointee.ai_socktype, info.pointee.ai_protocol)
        guard fd >= 0 else { throw LinkError(message: "联机大厅连接失败") }
        Self.setNonBlocking(fd)
        let rc = connect(fd, info.pointee.ai_addr, info.pointee.ai_addrlen)
        if rc != 0 {
            guard errno == EINPROGRESS else {
                Darwin.close(fd)
                throw LinkError(message: "无法连接 \(ip)")
            }
            var writeSet = fd_set()
            Self.fdZero(&writeSet)
            Self.fdSet(fd, &writeSet)
            var tv = timeval(tv_sec: 10, tv_usec: 0)
            guard select(fd + 1, nil, &writeSet, nil, &tv) > 0 else {
                Darwin.close(fd)
                throw LinkError(message: "连接超时")
            }
            var err: Int32 = 0
            var length = socklen_t(MemoryLayout<Int32>.size)
            getsockopt(fd, SOL_SOCKET, SO_ERROR, &err, &length)
            guard err == 0 else {
                Darwin.close(fd)
                throw LinkError(message: "无法连接 \(ip)")
            }
        }
        if closed {
            Darwin.close(fd)
            throw LinkError(message: "已取消")
        }
        Self.setBlocking(fd)
        return fd
    }

    /** Thread-safe send: the pump and the UI-triggered reset share the wire. */
    private func send(_ fd: Int32, _ payload: [UInt8]) throws {
        let len = payload.count
        var frame: [UInt8] = [
            UInt8((len >> 24) & 0xFF), UInt8((len >> 16) & 0xFF), UInt8((len >> 8) & 0xFF), UInt8(len & 0xFF)
        ]
        frame += payload
        try Self.sendAll(fd, frame)
    }

    private static func sendAll(_ fd: Int32, _ data: [UInt8]) throws {
        var off = 0
        while off < data.count {
            let n = data.withUnsafeBytes { raw -> Int in
                Darwin.send(fd, raw.baseAddress!.advanced(by: off), data.count - off, 0)
            }
            if n > 0 {
                off += n
                continue
            }
            if n < 0 {
                if errno == EINTR { continue }
                if errno == EAGAIN || errno == EWOULDBLOCK { throw LinkError(message: "发送超时") }
            }
            throw LinkError(message: "对方已断开")
        }
    }

    private static func helloFrame() -> [UInt8] {
        [0, UInt8(msgHello), 0, 0, 0, 6]
    }

    private static func frame(_ messageType: Int) -> [UInt8] {
        [UInt8((messageType >> 8) & 0xFF), UInt8(messageType & 0xFF)]
    }

    private static func keysFrame(_ keys: Int32) -> [UInt8] {
        [0, UInt8(msgKeys),
         UInt8(truncatingIfNeeded: keys >> 24), UInt8(truncatingIfNeeded: keys >> 16),
         UInt8(truncatingIfNeeded: keys >> 8), UInt8(truncatingIfNeeded: keys)]
    }

    /// 官方断线重连包：**完整的 10 字节线格式** `int32 6 + int16 100 + int32 rtt`
    /// （AmA8tU:263-272 是 `ByteBuffer.allocate(10)` 后直接 write，没有单独的长度
    /// 头 —— 因为长度 6 本身就是头）。所以这里直接给 sendAll()，不要再过 send()。
    private static func reconnectFrame(rtt: Int32) -> [UInt8] {
        [0, 0, 0, 6,
         0, UInt8(msgReconnect),
         UInt8(truncatingIfNeeded: rtt >> 24), UInt8(truncatingIfNeeded: rtt >> 16),
         UInt8(truncatingIfNeeded: rtt >> 8), UInt8(truncatingIfNeeded: rtt)]
    }

    /// 帧体里 type 后面那个大端 int32（RTT / fps / 按键掩码都走它）。
    private static func intValue(_ frame: [UInt8]) -> Int32 {
        if frame.count < 6 {
            return -1
        }
        return Int32(bitPattern: UInt32(frame[2]) << 24 | UInt32(frame[3]) << 16
                     | UInt32(frame[4]) << 8 | UInt32(frame[5]))
    }

    /**
     * 读第一帧握手。返回 true 表示对端发的是官方**重连包**（type 100 + rtt）：
     * 这套会话已经握过手，后面的 2/3/6 全部跳过，直接进入按键转发。
     *
     * 接收侧必须把它当握手而不是「未知帧」：type 100 不在正常消息表里，
     * 老代码会在这里抛「对方不是联机大厅会话」并把整条链路判死。
     */
    private func expectHello(_ fd: Int32, asHost: Bool) throws -> Bool {
        while true {
            let frame = try readFrame(fd)
            let messageType = Self.type(frame)
            if messageType == Self.msgReconnect {
                let rtt = Self.intValue(frame)
                if rtt >= 0 {
                    lock.lock()
                    lastRttValue = rtt
                    lock.unlock()
                }
                return true
            }
            if messageType == Self.msgKeys || messageType == Self.msgReset {
                continue
            }
            guard messageType == Self.msgHello else {
                throw LinkError(message: "对方不是联机大厅会话")
            }
            if frame.count < 6 {
                throw LinkError(message: "对方不是联机大厅会话")
            }
            let value = Int(frame[2]) << 24 | Int(frame[3]) << 16 | Int(frame[4]) << 8 | Int(frame[5])
            if value != 6 {
                throw LinkError(message: "联机大厅协议版本不符")
            }
            if asHost {
                try send(fd, Self.helloFrame())
            }
            return false
        }
    }

    /**
     * Reads frames until one of the wanted type shows up. The peer's key pump
     * keeps running while we are still shaking hands, so KEYS/RESET frames can
     * slip in; they are dropped here. 官方节奏包（type 0）与重连包（type 100）
     * 也可能在握手途中到达，一并吞掉。
     */
    private func nextFrame(_ fd: Int32, want: Int) throws -> [UInt8] {
        while true {
            let frame = try readFrame(fd)
            let messageType = Self.type(frame)
            if messageType == want {
                return frame
            }
            if messageType == Self.msgPacing || messageType == Self.msgReconnect {
                continue
            }
            if messageType != Self.msgKeys && messageType != Self.msgReset {
                throw LinkError(message: "对方不是联机大厅会话")
            }
        }
    }

    /**
     * 读一帧 type 6 并取出存档体（body = u16 type + u32 长度 + blob）。
     * 对端没发时返回 nil，不抛错 —— 状态同步是可选步骤。官方的服务端路径
     * （B25kr6.A4TApA）本来就只**读** type 6 不回发，客户端等不到是正常的，
     * 不能因为这条超时就把已经握好的链路判死。
     */
    private func readState(_ fd: Int32) throws -> [UInt8]? {
        while true {
            let frame: [UInt8]
            do {
                frame = try readFrame(fd)
            } catch let error as LinkError where error.timeout {
                return nil
            }
            let messageType = Self.type(frame)
            if messageType == Self.msgState {
                guard frame.count >= 6 else { return nil }
                let size = (Int(frame[2]) << 24) | (Int(frame[3]) << 16)
                         | (Int(frame[4]) << 8) | Int(frame[5])
                guard size > 0, frame.count >= 6 + size else { return nil }
                return Array(frame[6..<(6 + size)])
            }
            if messageType == Self.msgPacing || messageType == Self.msgReconnect {
                continue
            }
            if messageType != Self.msgKeys && messageType != Self.msgReset {
                throw LinkError(message: "对方不是联机大厅会话")
            }
        }
    }

    private static func type(_ frame: [UInt8]) -> Int {
        frame.count < 2 ? -1 : Int(frame[0]) << 8 | Int(frame[1])
    }

    private func readFrame(_ fd: Int32) throws -> [UInt8] {
        let header = try Self.readFully(fd, 4)
        let len = Int(header[0]) << 24 | Int(header[1]) << 16 | Int(header[2]) << 8 | Int(header[3])
        if len < 0 || len > 32 * 1024 * 1024 {
            throw LinkError(message: "数据异常")
        }
        return try Self.readFully(fd, len)
    }

    private static func readFully(_ fd: Int32, _ len: Int) throws -> [UInt8] {
        var data = [UInt8](repeating: 0, count: len)
        var off = 0
        while off < len {
            let n = data.withUnsafeMutableBytes { raw -> Int in
                recv(fd, raw.baseAddress!.advanced(by: off), len - off, 0)
            }
            if n > 0 {
                off += n
                continue
            }
            if n == 0 {
                throw LinkError(message: "对方已断开")
            }
            if errno == EINTR { continue }
            if errno == EAGAIN || errno == EWOULDBLOCK {
                // SO_RCVTIMEO 到点：标成 timeout，让 readState() 这种「对端可能
                // 不发」的可选步骤能降级，而不是把链路判死（tune() 设的 15 秒）。
                throw LinkError(message: "连接超时", timeout: true)
            }
            throw LinkError(message: "连接已断开")
        }
        return data
    }

    // ---- ROM identity + state exchange ----

    /**
     * Builds the ROM_INFO payload: u16 type + 32-char lowercase MD5 of the ROM
     * + u16 name length + file name. GBoy's getRomHash is exactly the MD5 hex
     * of the ROM data.
     */
    private func romInfo() throws -> [UInt8] {
        guard let path = romPath(), FileManager.default.fileExists(atPath: path) else {
            throw LinkError(message: "找不到当前游戏文件")
        }
        guard let handle = FileHandle(forReadingAtPath: path) else {
            throw LinkError(message: "读取游戏失败")
        }
        defer { try? handle.close() }
        var hasher = Insecure.MD5()
        while true {
            do {
                guard let chunk = try handle.read(upToCount: 65536), !chunk.isEmpty else { break }
                hasher.update(data: chunk)
            } catch {
                throw LinkError(message: "读取游戏失败")
            }
        }
        let hex = hasher.finalize().map { String(format: "%02x", $0) }.joined()
        guard let hash = hex.data(using: .ascii) else {
            throw LinkError(message: "读取游戏失败")
        }
        let name = URL(fileURLWithPath: path).lastPathComponent
        guard let nameBytes = name.data(using: .utf8) else {
            throw LinkError(message: "读取游戏失败")
        }
        var frame: [UInt8] = [0, UInt8(Self.msgRomInfo)]
        frame += [UInt8](hash)
        frame += [UInt8((nameBytes.count >> 8) & 0xFF), UInt8(nameBytes.count & 0xFF)]
        frame += [UInt8](nameBytes)
        return frame
    }

    /**
     * type 6：整份即时存档。优先用 {@link saveState} 提供的**真实**存档
     * （mGBA 格式，与 PC/Android 一致）。拿不到就返回 nil，由调用方跳过这一
     * 步 —— 以前这里合成一份 900KB 全零的 GBASTATE 假包，对端要么拒收、要么
     * 把游戏灌成未初始化状态，比不发更糟。
     */
    private func stateFrame() throws -> [UInt8]? {
        guard let raw = saveState(), !raw.isEmpty else { return nil }
        let size = raw.count
        var frame: [UInt8] = [0, UInt8(Self.msgState),
                              UInt8((size >> 24) & 0xFF), UInt8((size >> 16) & 0xFF),
                              UInt8((size >> 8) & 0xFF), UInt8(size & 0xFF)]
        frame += raw
        return frame
    }

    /**
     * zlib-format deflate: Java's Deflater (and GBoy's Inflater) expect the
     * two-byte zlib header and the trailing Adler-32, while the system
     * Compression framework only produces raw deflate streams.
     */
    private static func zlibCompress(_ raw: Data) -> Data {
        var dst = Data(count: raw.count + 128)
        let written = dst.withUnsafeMutableBytes { (dstRaw: UnsafeMutableRawBufferPointer) -> Int in
            raw.withUnsafeBytes { (srcRaw: UnsafeRawBufferPointer) -> Int in
                guard let dstBase = dstRaw.baseAddress, let srcBase = srcRaw.baseAddress, srcRaw.count > 0 else { return 0 }
                return compression_encode_buffer(dstBase.assumingMemoryBound(to: UInt8.self), dstRaw.count,
                                                 srcBase.assumingMemoryBound(to: UInt8.self), srcRaw.count,
                                                 nil, COMPRESSION_ZLIB)
            }
        }
        guard written > 0 else { return raw }
        var out = Data([0x78, 0x9C])
        out.append(dst.prefix(written))
        let sum = adler32(raw)
        out.append(UInt8((sum >> 24) & 0xFF))
        out.append(UInt8((sum >> 16) & 0xFF))
        out.append(UInt8((sum >> 8) & 0xFF))
        out.append(UInt8(sum & 0xFF))
        return out
    }

    private static func adler32(_ data: Data) -> UInt32 {
        var a: UInt32 = 1
        var b: UInt32 = 0
        data.withUnsafeBytes { (raw: UnsafeRawBufferPointer) in
            for index in 0..<raw.count {
                a = (a + UInt32(raw[index])) % 65521
                b = (b + a) % 65521
            }
        }
        return (b << 16) | a
    }

    private static func message(_ error: Error) -> String {
        (error as? LinkError)?.message ?? "联机大厅连接失败"
    }
}
