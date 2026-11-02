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
 *   1 HELLO   u16 type + u32 6; the client sends it first, the server echoes.
 *   2 ROMINFO u16 type + 32-byte ASCII MD5 of the ROM + u16 name length + name.
 *   3 READY   u16 type only, sent once the local console is loaded.
 *   4 KEYS    u16 type + u32 GBA key mask (same bit layout mGBA uses).
 *   5 RESET   u16 type only.
 *   6 STATE   u16 type + u32 size + zlib-compressed GBASTATE v4 image.
 *
 * After the handshake each side sends its key mask about every five frames
 * (~83 ms) and applies the mask it receives, so a GBoy handset drives the
 * remote player here the same way it would drive its own second console.
 */
final class GBoyLink {
    static let defaultPort = 6374

    private struct LinkError: Error {
        let message: String
    }

    private static let msgHello = 1
    private static let msgRomInfo = 2
    private static let msgReady = 3
    private static let msgKeys = 4
    private static let msgReset = 5
    private static let msgState = 6

    /// Zero-filled body appended to the synthesized state image, in bytes.
    private static let statePad = 900 * 1024

    var romPath: () -> String? = { nil }
    var localKeys: () -> Int32 = { 0 }
    /// Key mask received from the peer; called from the reader thread.
    var onRemoteKeys: (Int32) -> Void = { _ in }
    /// Called from background threads; the owner hops to the main queue.
    var onStatus: (String) -> Void = { _ in }
    /// Peer asked for a console reset; called from the reader thread.
    var onRemoteReset: () -> Void = {}

    private let lock = NSLock()
    private var isClosedFlag = false
    private var currentFd: Int32 = -1

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
        try expectHello(fd, asHost: asHost)

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

        if asHost {
            _ = try nextFrame(fd, want: Self.msgState)
            note = Self.appendNote(note, "已收到对方即时存档（本机继续用本机进度）")
            try send(fd, try stateFrame())
        } else {
            try send(fd, try stateFrame())
            _ = try nextFrame(fd, want: Self.msgState)
            note = Self.appendNote(note, "已收到对方即时存档（本机继续用本机进度）")
        }
        return note
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
                } else if messageType == Self.msgReset {
                    onRemoteReset()
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
            fdZero(&readSet)
            fdSet(listenFd, &readSet)
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
            fdZero(&writeSet)
            fdSet(fd, &writeSet)
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

    private func expectHello(_ fd: Int32, asHost: Bool) throws {
        let frame = try nextFrame(fd, want: Self.msgHello)
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
    }

    /**
     * Reads frames until one of the wanted type shows up. The peer's key pump
     * keeps running while we are still shaking hands, so KEYS/RESET frames can
     * slip in; they are dropped here.
     */
    private func nextFrame(_ fd: Int32, want: Int) throws -> [UInt8] {
        while true {
            let frame = try readFrame(fd)
            let messageType = Self.type(frame)
            if messageType == want {
                return frame
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
                throw LinkError(message: "连接超时")
            }
            throw LinkError(message: "连接已断开")
        }
        return data
    }

    // ---- ROM identity + state synthesis ----

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
     * Synthesizes a GBASTATE v4 image the peer will accept: the header GBoy
     * validates (magic, version 4, the 16 ROM identity bytes from offset 0xA0,
     * BIOS flag zero) followed by a zero-filled body, zlib compressed the way
     * GBoy's loadStateFromMemory expects. The peer's link console loads it and
     * that game then simply starts from a fresh boot.
     */
    private func stateFrame() throws -> [UInt8] {
        var raw = [UInt8](repeating: 0, count: 32 + Self.statePad)
        let magic = Array("GBASTATE".utf8)
        for (index, byte) in magic.enumerated() {
            raw[index] = byte
        }
        raw[11] = 4
        if let path = romPath(), FileManager.default.fileExists(atPath: path),
           let handle = FileHandle(forReadingAtPath: path) {
            defer { try? handle.close() }
            if (try? handle.seek(toOffset: 0xA0)) != nil,
               let head = try? handle.read(upToCount: 16), head.count == 16 {
                for (index, byte) in head.enumerated() {
                    raw[12 + index] = byte
                }
            }
        }
        let compressed = Self.zlibCompress(Data(raw))
        let size = compressed.count
        var frame: [UInt8] = [0, UInt8(Self.msgState),
                              UInt8((size >> 24) & 0xFF), UInt8((size >> 16) & 0xFF),
                              UInt8((size >> 8) & 0xFF), UInt8(size & 0xFF)]
        frame += [UInt8](compressed)
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
