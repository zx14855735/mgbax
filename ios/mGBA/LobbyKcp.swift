/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
import Darwin
import Foundation

/**
 * KCP over UDP - the transport the cloud lobby relay uses.
 *
 * A Swift port of the Android `KcpChannel`. The parameters and the byte order
 * come from the lobby server's official client:
 *
 *   - KCP header in **big endian**: conv, cmd, frg, wnd, ts, sn, una, len
 *   - MTU 512, so MSS 488
 *   - update interval 30 ms
 *   - send and receive window 128
 *   - the conversation id is a random positive int
 *
 * On top of that sits the lobby handshake: the client sends "HS", the node
 * answers "HK", both retry three times with three seconds in between. A one
 * second PING/PONG heartbeat keeps the session alive and "DISC" closes it.
 *
 * A TCP transport is provided as well: when the relay is reached through a
 * tunnel (ssh -R / bore) each payload is framed with a big endian u32 length
 * so the stream stays message aligned.
 */
final class LobbyKcpChannel {
    struct Failure: Error {
        let message: String
    }

    static let handshakeRequest = Data([0x48, 0x53])    // "HS"
    static let handshakeReply = Data([0x48, 0x4B])      // "HK"
    static let ping = Data([0x50, 0x49, 0x4E, 0x47])   // "PING"
    static let pong = Data([0x50, 0x4F, 0x4E, 0x47])   // "PONG"
    static let goodbye = Data([0x44, 0x49, 0x53, 0x43]) // "DISC"

    private static let overhead = 24
    private static let cmdPush: UInt8 = 81
    private static let cmdAck: UInt8 = 82

    /// Official lobby parameters.
    private static let mtu = 512
    private static let intervalMs: Int64 = 30
    private static let windowSize = 128
    private static let handshakeTries = 3
    private static let handshakeWaitMs: Int64 = 3000

    private let kcp: Kcp?
    private let socketFd: Int32
    private let peer: sockaddr_in
    private let tcpSocket: Int32
    private let inbox = Inbox()
    private let lock = NSLock()
    private var runningFlag = true
    private var handshakeFlag = false
    private var deadFlag = false

    /// True once the channel was closed (the relay loop must stop).
    var isClosed: Bool {
        lock.lock()
        defer { lock.unlock() }
        return !runningFlag
    }

    var handshakeDone: Bool {
        lock.lock()
        defer { lock.unlock() }
        return handshakeFlag
    }

    var dead: Bool {
        lock.lock()
        defer { lock.unlock() }
        return deadFlag
    }

    private var running: Bool {
        lock.lock()
        defer { lock.unlock() }
        return runningFlag
    }

    // MARK: - Construction

    private init(host: String, port: UInt16, conv: Int32) throws {
        let address = try LobbyKcpChannel.resolve(host: host, port: port)
        let fd = socket(AF_INET, SOCK_DGRAM, IPPROTO_UDP)
        guard fd >= 0 else {
            throw Failure(message: "无法创建 UDP 套接字")
        }
        var timeout = timeval(tv_sec: 0, tv_usec: 5000)
        setsockopt(fd, SOL_SOCKET, SO_RCVTIMEO, &timeout, socklen_t(MemoryLayout<timeval>.size))
        socketFd = fd
        peer = address
        tcpSocket = -1
        kcp = Kcp(conv: conv, mtu: LobbyKcpChannel.mtu, intervalMs: LobbyKcpChannel.intervalMs)
        DispatchQueue.global(qos: .utility).async { [weak self] in
            self?.loop()
        }
    }

    private init(host: String, port: UInt16) throws {
        let address = try LobbyKcpChannel.resolve(host: host, port: port)
        let fd = socket(AF_INET, SOCK_STREAM, IPPROTO_TCP)
        guard fd >= 0 else {
            throw Failure(message: "无法创建 TCP 套接字")
        }
        var one: Int32 = 1
        setsockopt(fd, Int32(IPPROTO_TCP), TCP_NODELAY, &one, socklen_t(MemoryLayout<Int32>.size))
        let connected = withUnsafePointer(to: address) { ptr in
            ptr.withMemoryRebound(to: sockaddr.self, capacity: 1) { sa in
                Darwin.connect(fd, sa, socklen_t(MemoryLayout<sockaddr_in>.size))
            }
        }
        guard connected == 0 else {
            Darwin.close(fd)
            throw Failure(message: "无法连接中继 \(host):\(port)")
        }
        socketFd = -1
        tcpSocket = fd
        peer = address
        kcp = nil
        DispatchQueue.global(qos: .utility).async { [weak self] in
            self?.streamLoop()
        }
    }

    /// Opens a session with an explicit conversation id and completes HS/HK.
    static func connect(host: String, port: UInt16, conv: Int32) throws -> LobbyKcpChannel {
        let channel = try LobbyKcpChannel(host: host, port: port, conv: conv)
        try channel.runHandshake()
        return channel
    }

    /// Opens a session *without* the handshake, so the caller can retry on the
    /// very same conversation id and UDP port.
    ///
    /// The relay keeps a tiny, slowly recycled session table. Every retry that
    /// builds a brand new session fills that table with half open leftovers,
    /// and once it is full the relay silently drops the newcomer - the room
    /// then looks permanently dead. Retrying on one session avoids that.
    static func open(host: String, port: UInt16, conv: Int32) throws -> LobbyKcpChannel {
        return try LobbyKcpChannel(host: host, port: port, conv: conv)
    }

    /// Re-sends `HS` on the current session and waits for `HK`. Returns false
    /// when the relay stayed silent for the whole timeout.
    func retryHandshake(timeoutMs: Int) -> Bool {
        let deadline = Date().addingTimeInterval(Double(max(timeoutMs, 0)) / 1000.0)
        while Date() < deadline {
            send(LobbyKcpChannel.handshakeRequest)
            let stepEnd = min(deadline, Date().addingTimeInterval(2.0))
            while Date() < stepEnd {
                if handshakeDone {
                    return true
                }
                if dead {
                    return false
                }
                Thread.sleep(forTimeInterval: 0.05)
            }
        }
        return handshakeDone
    }

    /// Opens a session with a random conversation id and completes HS/HK.
    static func connect(host: String, port: UInt16) throws -> LobbyKcpChannel {
        let conv = Int32(arc4random_uniform(0x7FFFFFFF)) + 1
        return try connect(host: host, port: port, conv: conv)
    }

    /// Opens a TCP session (relay reached through a TCP tunnel) and does HS/HK.
    static func connectTCP(host: String, port: UInt16) throws -> LobbyKcpChannel {
        let channel = try LobbyKcpChannel(host: host, port: port)
        try channel.runHandshake()
        return channel
    }

    private func runHandshake() throws {
        var ok = false
        for _ in 0..<LobbyKcpChannel.handshakeTries where !ok {
            send(LobbyKcpChannel.handshakeRequest)
            let deadline = Date().addingTimeInterval(Double(LobbyKcpChannel.handshakeWaitMs) / 1000.0)
            while Date() < deadline {
                if handshakeDone {
                    ok = true
                    break
                }
                if dead {
                    throw Failure(message: "中继连接中断")
                }
                Thread.sleep(forTimeInterval: 0.05)
            }
        }
        if !ok {
            close()
            throw Failure(message: "中继握手超时（服务器未回应）")
        }
    }

    // MARK: - Sending and receiving

    /// Queues a payload; the pump thread transmits it.
    func send(_ payload: Data) {
        rawSend([UInt8](payload))
    }

    /// Transport agnostic send: UDP goes through KCP, TCP writes a framed blob.
    private func rawSend(_ payload: [UInt8]) {
        if let kcp {
            kcp.send(payload)
            return
        }
        guard tcpSocket >= 0 else {
            return
        }
        var head = [UInt8](repeating: 0, count: 4)
        LobbyFrames.putInt(&head, 0, Int32(payload.count))
        let blob = head + payload
        blob.withUnsafeBytes { raw in
            var sent = 0
            while sent < blob.count {
                let n = write(tcpSocket, raw.baseAddress!.advanced(by: sent), blob.count - sent)
                if n <= 0 {
                    markDead()
                    return
                }
                sent += n
            }
        }
    }

    /// Next payload from the peer, or nil after `timeoutMs`.
    func recv(timeoutMs: Int) -> Data? {
        guard let payload = inbox.poll(timeoutMs: timeoutMs) else {
            return nil
        }
        return Data(payload)
    }

    func close() {
        lock.lock()
        if !runningFlag {
            lock.unlock()
            return
        }
        runningFlag = false
        lock.unlock()
        if let kcp {
            kcp.send([UInt8](LobbyKcpChannel.goodbye))
            flush()
        }
        if socketFd >= 0 {
            Darwin.close(socketFd)
        }
        if tcpSocket >= 0 {
            shutdown(tcpSocket, SHUT_RDWR)
            Darwin.close(tcpSocket)
        }
        inbox.wake()
    }

    private func markDead() {
        lock.lock()
        deadFlag = true
        runningFlag = false
        lock.unlock()
        inbox.wake()
    }

    // MARK: - UDP pump

    private func flush() {
        guard let kcp else {
            return
        }
        for datagram in kcp.update(now: Int64(Date().timeIntervalSince1970 * 1000)) {
            var address = peer
            datagram.withUnsafeBytes { raw in
                withUnsafePointer(to: &address) { ptr in
                    ptr.withMemoryRebound(to: sockaddr.self, capacity: 1) { sa in
                        sendto(socketFd, raw.baseAddress, datagram.count, 0, sa,
                               socklen_t(MemoryLayout<sockaddr_in>.size))
                    }
                }
            }
        }
    }

    private func loop() {
        guard let kcp else {
            return
        }
        var lastPing: Int64 = 0
        while running {
            var buffer = [UInt8](repeating: 0, count: 2048)
            let received = buffer.withUnsafeMutableBytes { raw -> Int in
                var from = sockaddr_storage()
                var length = socklen_t(MemoryLayout<sockaddr_storage>.size)
                return withUnsafeMutablePointer(to: &from) { fromPtr in
                    fromPtr.withMemoryRebound(to: sockaddr.self, capacity: 1) { sa in
                        recvfrom(socketFd, raw.baseAddress, raw.count, 0, sa, &length)
                    }
                }
            }
            if received > 0 {
                kcp.input([UInt8](buffer[0..<received]))
            }
            while let message = kcp.recv() {
                deliver(message)
            }
            let now = Int64(Date().timeIntervalSince1970 * 1000)
            if handshakeDone && now - lastPing >= 1000 {
                lastPing = now
                kcp.send([UInt8](LobbyKcpChannel.ping))
            }
            flush()
            Thread.sleep(forTimeInterval: 0.004)
        }
    }

    // MARK: - TCP pump

    private func streamLoop() {
        var head = [UInt8](repeating: 0, count: 4)
        while running {
            guard readFully(&head, count: 4) else {
                break
            }
            let length = Int(LobbyFrames.getInt(head, 0))
            if length <= 0 || length > 65535 {
                break
            }
            var body = [UInt8](repeating: 0, count: length)
            guard readFully(&body, count: length) else {
                break
            }
            deliver(body)
        }
        markDead()
    }

    private func readFully(_ buffer: inout [UInt8], count: Int) -> Bool {
        var done = 0
        while done < count {
            let n = buffer.withUnsafeMutableBytes { raw in
                read(tcpSocket, raw.baseAddress!.advanced(by: done), count - done)
            }
            if n <= 0 {
                return false
            }
            done += n
        }
        return true
    }

    private func deliver(_ message: [UInt8]) {
        if message == [UInt8](LobbyKcpChannel.handshakeReply) {
            lock.lock()
            handshakeFlag = true
            lock.unlock()
            return
        }
        if message == [UInt8](LobbyKcpChannel.ping) {
            rawSend([UInt8](LobbyKcpChannel.pong))
            return
        }
        if message == [UInt8](LobbyKcpChannel.pong) {
            return
        }
        inbox.add(message)
    }

    // MARK: - Address helpers

    private static func resolve(host: String, port: UInt16) throws -> sockaddr_in {
        var hints = addrinfo()
        hints.ai_family = AF_INET
        hints.ai_socktype = SOCK_DGRAM
        hints.ai_protocol = IPPROTO_UDP
        hints.ai_flags = AI_NUMERICSERV
        var info: UnsafeMutablePointer<addrinfo>?
        let status = getaddrinfo(host, String(port), &hints, &info)
        guard status == 0, let first = info else {
            throw Failure(message: "无法解析中继地址 \(host)")
        }
        defer { freeaddrinfo(info) }
        var address = sockaddr_in()
        withUnsafePointer(to: first.pointee.ai_addr.pointee) { ptr in
            ptr.withMemoryRebound(to: sockaddr_in.self, capacity: 1) { address = $0.pointee }
        }
        address.sin_port = port.bigEndian
        return address
    }

    // MARK: - Inbox

    private final class Inbox {
        private let condition = NSCondition()
        private var items: [[UInt8]] = []

        func add(_ item: [UInt8]) {
            condition.lock()
            items.append(item)
            condition.signal()
            condition.unlock()
        }

        func poll(timeoutMs: Int) -> [UInt8]? {
            condition.lock()
            defer { condition.unlock() }
            if items.isEmpty {
                _ = condition.wait(until: Date().addingTimeInterval(Double(max(timeoutMs, 0)) / 1000.0))
            }
            guard !items.isEmpty else {
                return nil
            }
            return items.removeFirst()
        }

        func wake() {
            condition.lock()
            condition.broadcast()
            condition.unlock()
        }
    }

    // MARK: - KCP core

    /// Big endian KCP, a straight port of the reference algorithm: framing,
    /// ACK tracking, RTO retransmit, in-order receive with fragment
    /// reassembly.
    private final class Kcp {
        private struct Segment {
            var conv: Int32 = 0
            var cmd: UInt8 = 0
            var frg: Int32 = 0
            var wnd: Int32 = 0
            var ts: Int32 = 0
            var sn: Int32 = 0
            var una: Int32 = 0
            var data: [UInt8] = []
            var resendTs: Int64 = 0
            var rto: Int64 = 200
            var xmit: Int32 = 0

            func encode() -> [UInt8] {
                var out = [UInt8](repeating: 0, count: LobbyKcpChannel.overhead + data.count)
                LobbyFrames.putInt(&out, 0, conv)
                out[4] = cmd
                out[5] = UInt8(frg & 0xFF)
                LobbyFrames.putShort(&out, 6, Int(wnd))
                LobbyFrames.putInt(&out, 8, ts)
                LobbyFrames.putInt(&out, 12, sn)
                LobbyFrames.putInt(&out, 16, una)
                LobbyFrames.putInt(&out, 20, Int32(data.count))
                for (index, byte) in data.enumerated() {
                    out[LobbyKcpChannel.overhead + index] = byte
                }
                return out
            }
        }

        private let conv: Int32
        private let mss: Int
        private let intervalMs: Int64
        private let lock = NSRecursiveLock()

        private var sndQueue: [[UInt8]] = []
        private var sndBuf: [Segment] = []
        private var rcvBuf: [Int32: Segment] = [:]
        private var rcvQueue: [[UInt8]] = []
        private var acks: [(Int32, Int32)] = []
        private var sndNxt: Int32 = 0
        private var rcvNxt: Int32 = 0
        private var sndUna: Int32 = 0
        private var rmtWnd: Int32 = Int32(LobbyKcpChannel.windowSize)
        private var rto: Int64 = 200
        private var nextUpdate: Int64 = 0
        private let deadLink = 64
        private var frgRemaining: Int32 = 0
        private var parts: [[UInt8]] = []

        init(conv: Int32, mtu: Int, intervalMs: Int64) {
            self.conv = conv
            mss = mtu - LobbyKcpChannel.overhead
            self.intervalMs = intervalMs
        }

        private func window() -> Int32 {
            let free = LobbyKcpChannel.windowSize - rcvQueue.count - rcvBuf.count
            return free < 0 ? 0 : Int32(free)
        }

        func input(_ data: [UInt8]) {
            lock.lock()
            defer { lock.unlock() }
            if data.count < LobbyKcpChannel.overhead {
                return
            }
            let conv = LobbyFrames.getInt(data, 0)
            if conv != self.conv {
                return
            }
            let cmd = data[4]
            let frg = Int32(data[5])
            let wnd = Int32(LobbyFrames.getShort(data, 6))
            let ts = LobbyFrames.getInt(data, 8)
            let sn = LobbyFrames.getInt(data, 12)
            let una = LobbyFrames.getInt(data, 16)
            let len = Int(LobbyFrames.getInt(data, 20))
            if len < 0 || len > data.count - LobbyKcpChannel.overhead {
                return
            }
            let payload = Array(data[LobbyKcpChannel.overhead..<(LobbyKcpChannel.overhead + len)])
            rmtWnd = wnd
            ackUpTo(una - 1, exactTs: -1)
            if cmd == LobbyKcpChannel.cmdAck {
                ackUpTo(sn, exactTs: ts)
            } else if cmd == LobbyKcpChannel.cmdPush {
                acks.append((sn, ts))
                recvPush(sn: sn, frg: frg, payload: payload)
            }
        }

        /// Drops everything the peer has acknowledged.
        private func ackUpTo(_ uptoSn: Int32, exactTs: Int32) {
            if exactTs >= 0 {
                for index in stride(from: sndBuf.count - 1, through: 0, by: -1) {
                    let segment = sndBuf[index]
                    if segment.sn == uptoSn && segment.ts == exactTs {
                        sndBuf.remove(at: index)
                    }
                }
            }
            for index in stride(from: sndBuf.count - 1, through: 0, by: -1) {
                if sndBuf[index].sn <= uptoSn {
                    sndBuf.remove(at: index)
                }
            }
            sndUna = sndBuf.isEmpty ? sndNxt : sndBuf[0].sn
        }

        private func recvPush(sn: Int32, frg: Int32, payload: [UInt8]) {
            if sn < rcvNxt {
                return
            }
            if sn == rcvNxt {
                deliver(sn: sn, frg: frg, payload: payload)
                while let segment = rcvBuf.removeValue(forKey: rcvNxt) {
                    deliver(sn: segment.sn, frg: segment.frg, payload: segment.data)
                }
            } else {
                var segment = Segment()
                segment.sn = sn
                segment.frg = frg
                segment.data = payload
                rcvBuf[sn] = segment
            }
        }

        private func deliver(sn: Int32, frg: Int32, payload: [UInt8]) {
            if frgRemaining == 0 && frg == 0 {
                rcvQueue.append(payload)
                rcvNxt = sn + 1
                return
            }
            if frgRemaining == 0 {
                parts = [payload]
                frgRemaining = frg
            } else {
                parts.append(payload)
                frgRemaining -= 1
            }
            if frgRemaining == 0 && !parts.isEmpty {
                rcvQueue.append(parts.flatMap { $0 })
                parts = []
            }
            rcvNxt = sn + 1
        }

        func send(_ data: [UInt8]) {
            lock.lock()
            defer { lock.unlock() }
            if data.count <= mss {
                sndQueue.append(data)
                return
            }
            let chunks = (data.count + mss - 1) / mss
            for index in 0..<chunks {
                let end = min(data.count, (index + 1) * mss)
                sndQueue.append(Array(data[(index * mss)..<end]))
            }
        }

        func recv() -> [UInt8]? {
            lock.lock()
            defer { lock.unlock() }
            guard !rcvQueue.isEmpty else {
                return nil
            }
            return rcvQueue.removeFirst()
        }

        func update(now: Int64) -> [[UInt8]] {
            lock.lock()
            defer { lock.unlock() }
            var out: [[UInt8]] = []
            if now < nextUpdate {
                return out
            }
            nextUpdate = now + intervalMs
            for (sn, ts) in acks {
                var segment = Segment()
                segment.conv = conv
                segment.cmd = LobbyKcpChannel.cmdAck
                segment.sn = sn
                segment.ts = ts
                segment.wnd = window()
                segment.una = rcvNxt
                out.append(segment.encode())
            }
            acks.removeAll()
            while !sndQueue.isEmpty && sndBuf.count < LobbyKcpChannel.windowSize {
                let data = sndQueue.removeFirst()
                var segment = Segment()
                segment.conv = conv
                segment.cmd = LobbyKcpChannel.cmdPush
                segment.frg = 0
                if data.count == mss && !sndQueue.isEmpty {
                    segment.frg = Int32(min(sndQueue.count, 255))
                }
                segment.wnd = window()
                segment.ts = Int32(truncatingIfNeeded: now)
                segment.sn = sndNxt
                segment.una = rcvNxt
                segment.data = data
                segment.resendTs = now
                segment.rto = rto
                sndBuf.append(segment)
                sndNxt += 1
            }
            var lost = 0
            for index in 0..<sndBuf.count {
                var need: Bool
                if sndBuf[index].xmit == 0 {
                    need = true
                } else if now >= sndBuf[index].resendTs {
                    need = true
                    sndBuf[index].rto = min(sndBuf[index].rto * 2, 5000)
                    sndBuf[index].resendTs = now + sndBuf[index].rto
                } else {
                    need = false
                }
                if need {
                    sndBuf[index].xmit += 1
                    sndBuf[index].wnd = window()
                    sndBuf[index].ts = Int32(truncatingIfNeeded: now)
                    sndBuf[index].una = rcvNxt
                    out.append(sndBuf[index].encode())
                    if sndBuf[index].xmit >= deadLink {
                        lost += 1
                    }
                }
            }
            return out
        }
    }
}
