/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
import CryptoKit
import Foundation

/**
 * Cloud lobby room link.
 *
 * A Swift port of the Android `GBoyCloudLink`. The room itself is matched over
 * HTTPS + WebSocket (`LobbySignaling`); the game bytes then travel through the
 * room's relay node using KCP over UDP (`LobbyKcpChannel`) carrying the lobby
 * frames of `LobbyFrames`.
 *
 * The exchange follows the official client exactly:
 *
 *   1. `send_message` with `uuid = "GAME_CODE,ROM_MD5"` - until the server
 *      sees this the websocket session is not bound to a game and the room
 *      server ignores the session.
 *   2. `create_game_room` twice: the first call creates the room and answers
 *      with the room id only, the second one answers with the room that
 *      already exists *together with the relay node*. Room id and node must
 *      be read from that second answer - mixing them silently connects to the
 *      relay of a different room.
 *   3. `join_room` + `ready`, then `update_room_settings` to put the room
 *      into multiplayer mode.
 *   4. over KCP: `HS` / `HK`, then the registration frame (type 1, ten byte
 *      body), the relay answers with type 3 and the player count, we answer
 *      with an empty type 3, the relay sends type 0 and we acknowledge with
 *      an empty type 1.
 */
final class LobbyLink {
    struct Failure: Error {
        let message: String
    }

    private static let stepWaitMs: Int64 = 20000
    private static let roomWaitMs: Int64 = 15000
    /// Public relay slots are recycled slowly; keep retrying for a while.
    private static let relayWaitMs: Double = 300000
    /// How long to wait for the peer's first key state before starting anyway.
    private static let peerKeyWaitMs: Int64 = 4000
    private static let keyIntervalMs: Int64 = 50

    // MARK: - Hooks

    /// Path of the ROM that is currently loaded.
    var romPath: () -> String? = { nil }
    /// Local key bitmask, GBA style.
    var localKeys: () -> Int32 = { 0 }
    /// Key mask received from the peer; called from the reader thread.
    var onRemoteKeys: (Int32) -> Void = { _ in }
    /// Called from background threads; the owner hops to the main queue.
    var onStatus: (String) -> Void = { _ in }
    /// The link is up: `true` when this device is the 1P.
    var onConnected: (Bool, String?) -> Void = { _, _ in }
    /// Peer asked for a console reset; called from the reader thread.
    var onRemoteReset: () -> Void = {}

    // MARK: - State

    private let lock = NSLock()
    private var closedFlag = false
    private var channel: LobbyKcpChannel?
    private var session: LobbySignaling.Session?
    private let reader = LobbyFrames.Reader()
    /// Last key state received from the peer; only transitions are logged.
    private var lastRxKeys = Int32.min
    /// 会话信息：「重新连接中继」复用它，不重建房间。
    private var authToken: String?
    private var currentRoom: Room?
    private var hostRole = false

    private var isClosed: Bool {
        lock.lock()
        defer { lock.unlock() }
        return closedFlag
    }

    /// 引用类型：房主广告线程与主流程共享同一个房间对象，
    /// 节点被服务器换掉时两边都能看到最新值。
    private final class Room {
        var roomId: String?
        var nodeAddress: String?
        var nodePort: UInt16 = 0
        var playerCount: Int32 = 2
        var baseStateCount: Int32 = 0
    }

    // MARK: - Lifecycle

    /// `roomId` empty or nil creates a room, otherwise joins it. A token that
    /// was obtained earlier (a fresh registration) skips the login step.
    func start(user: String, password: String, roomId: String?, token: String? = nil) {
        lock.lock()
        closedFlag = false
        lock.unlock()
        DispatchQueue.global(qos: .userInitiated).async { [weak self] in
            guard let self else {
                return
            }
            do {
                try self.run(user: user, password: password, roomId: roomId, token: token)
            } catch {
                if !self.isClosed {
                    self.fail(LobbyLink.message(error))
                }
            }
        }
    }

    /// Asks the peer to reset its game.
    func sendReset() {
        lock.lock()
        let current = channel
        let dead = closedFlag
        lock.unlock()
        if let current, !dead {
            current.send(LobbyFrames.frame(LobbyFrames.typeReset, 0))
        }
    }

    func close() {
        lock.lock()
        closedFlag = true
        let current = channel
        channel = nil
        let open = session
        session = nil
        lock.unlock()
        current?.close()
        open?.close()
        onRemoteKeys(0)
    }

    // MARK: - Session

    /**
     * When the room id begins with `NODE:` (1P) or `NODE2:` (2P) the rest is
     * read as `address:port` of a relay and the whole signalling stage is
     * skipped. `DBG:`/`DBGJ:` are the older spellings.
     */
    private func run(user: String, password: String, roomId: String?, token existing: String? = nil) throws {
        if let roomId, let spec = LobbyLink.manualSpec(roomId) {
            try runManual(spec.node, asHost: spec.asHost, conv: spec.conv)
            return
        }
        let trimmed = roomId?.trimmingCharacters(in: .whitespacesAndNewlines) ?? ""
        let asHost = trimmed.isEmpty
        let token: String
        if let existing {
            token = existing
        } else {
            status("正在登录联机大厅…")
            token = try LobbySignaling.loginSync(user: user, password: password)
        }

        status("正在连接房间服务器…")
        let sig = try LobbySignaling.Session.connectSync()
        lock.lock()
        session = sig
        lock.unlock()
        if sig.insecureTLS {
            // The room port serves an expired cert for another domain; the
            // protocol only works if the chain is ignored. Users should know.
            status("注意：联机大厅端口证书已过期，已降级连接")
        }
        if isClosed {
            sig.close()
            return
        }

        // The server binds the websocket session to a game identity only after
        // an explicit send_message carrying "GAME_CODE,ROM_MD5"; without it the
        // room server ignores everything that follows.
        let uuid = gameUuid()
        status("正在上传游戏身份…")
        send(sig, LobbyLink.sendMessage(token: token, uuid: uuid, text: "go"), waitMs: 1200)

        let room = Room()
        if asHost {
            // Order matters and was verified against the live server: the relay
            // node is NOT part of the first create_game_room answer. It only
            // shows up once the room has been joined, marked ready and switched
            // to multiplayer by update_room_settings - from then on every
            // create_game_room call replies with "您已有房间" plus node_address.
            try hostCreateRoom(sig: sig, token: token, uuid: uuid, room: room)
            // The lobby only tells the creator where the relay lives, so we
            // advertise it to the room for as long as the link is up. The
            // joiner reads it automatically and fills the relay in itself - no
            // manual NODE2: entry needed.
            startNodeAdvertiser(sig: sig, token: token, uuid: uuid, room: room)
        } else {
            status("正在加入房间 \(trimmed)…")
            send(sig, LobbyLink.action("join_room", token: token, roomId: trimmed), waitMs: 1800)
            send(sig, LobbyLink.action("ready", token: token), waitMs: 1200)
            // The room server normally only tells the creator where the relay
            // lives, so the host advertises it over the broadcast channel
            // instead. Watch for that for a generous window - the host keeps
            // re-sending it.
            room.roomId = trimmed
            try waitForRoom(sig: sig, room: room, roomId: trimmed, timeoutMs: 20000)
            if room.nodeAddress == nil || room.nodePort == 0 {
                throw Failure(message: "未能自动获取对方的中继地址。"
                    + "请让房主把界面上的「中继 地址:端口」发给你，"
                    + "再用 NODE2:地址:端口 进入（房号框填 NODE2:地址:端口）")
            }
        }

        lock.lock()
        authToken = token
        currentRoom = room
        hostRole = asHost
        lock.unlock()
        try connectRelay(sig: sig, token: token, room: room, asHost: asHost)
    }

    /// 连上中继并进入对战循环。房间与信令已经就绪，这里只负责数据通道，
    /// 「重新连接中继」按钮也复用同一段逻辑。
    private func connectRelay(sig: LobbySignaling.Session, token: String, room: Room,
                              asHost: Bool) throws {
        status((asHost ? "房间已创建，房号 " : "已加入房间 ")
            + (room.roomId ?? "")
            + "\n中继 \(room.nodeAddress ?? ""):\(room.nodePort)"
            + "\n正在连接中继节点，等待对方加入…")
        // 先问一次当前节点：公共节点会被服务器回收，房间还在但节点可能已经换了
        if let fresh = currentNode(sig: sig, token: token, room: room, creator: asHost) {
            let parts = fresh.split(separator: ":")
            if parts.count >= 2, let port = UInt16(parts[parts.count - 1]) {
                room.nodeAddress = String(parts[0..<(parts.count - 1)].joined(separator: ":"))
                room.nodePort = port
            }
        }
        let link = try startRelayLink(host: room.nodeAddress ?? "", port: room.nodePort, room: room) {
            self.currentNode(sig: sig, token: token, room: room, creator: asHost)
        }
        if isClosed {
            link.close()
            return
        }
        let text = asHost ? "云端联机已连接，你是 1P" : "云端联机已连接，你是 2P"
        status("房号 \(room.roomId ?? "")\n中继 \(room.nodeAddress ?? ""):\(room.nodePort)\n\(text)")
        onConnected(asHost, nil)
        serve(link)
    }

    /// 问服务器（房主）或房主广播（加入方）当前的中继节点，返回 "地址:端口" 或 nil。
    private func currentNode(sig: LobbySignaling.Session, token: String, room: Room,
                             creator: Bool) -> String? {
        var probe = Room()
        if creator {
            send(sig, LobbyLink.createRoom(token: token, name: gameName()), waitMs: 2000)
            try? waitForRoom(sig: sig, room: probe, roomId: room.roomId, timeoutMs: 8000)
        } else {
            try? waitForRoom(sig: sig, room: probe, roomId: room.roomId, timeoutMs: 4000)
        }
        guard let address = probe.nodeAddress, probe.nodePort > 0 else {
            return nil
        }
        return "\(address):\(probe.nodePort)"
    }

    /// 重新连接中继：不重建房间，直接重新解析节点并重连数据通道。
    /// 房间还在、但节点被回收或对端掉线时用得上。
    func reconnectRelay() {
        lock.lock()
        let sig = session
        let token = authToken
        let room = currentRoom
        let asHost = hostRole
        lock.unlock()
        guard let signal = sig, let auth = token, let current = room else {
            status("还没有房间，请先点「云端创建」或「云端加入」")
            return
        }
        // 关掉旧通道，让旧的 serve 循环退出
        lock.lock()
        let old = channel
        channel = nil
        lock.unlock()
        old?.close()
        status("正在重新连接中继…")
        DispatchQueue.global(qos: .userInitiated).async { [weak self] in
            guard let self else {
                return
            }
            do {
                try self.connectRelay(sig: signal, token: auth, room: current, asHost: asHost)
            } catch {
                if !self.isClosed {
                    self.fail(LobbyLink.message(error))
                }
            }
        }
    }

    /// Creates a room and resolves the relay node.
    ///
    /// The room has to be dissolved first: the server binds a room to the
    /// account and the relay node of an old room is a port in the public node
    /// pool that has already been recycled - connecting to it only ever times
    /// out. `leave_room` only works once the session has actually joined the
    /// room (otherwise the server answers "您不在任何游戏房间中"), so the order
    /// is:
    ///
    ///   create_game_room (learn the old room id) -> join_room -> leave_room
    ///   -> create_game_room (brand new room and node) -> join/ready/settings
    ///   -> create_game_room (this time the relay node comes back with it)
    private func hostCreateRoom(sig: LobbySignaling.Session, token: String, uuid: String,
                                room: Room) throws {
        // 1) 先问一次当前房间（旧房间也要一并解散）
        send(sig, LobbyLink.createRoom(token: token, name: gameName()), waitMs: 2500)
        try waitForRoomId(sig: sig, room: room, timeoutMs: 5000)
        if let roomId = room.roomId, !roomId.isEmpty {
            send(sig, LobbyLink.action("join_room", token: token, roomId: roomId), waitMs: 1500)
            send(sig, LobbyLink.action("leave_room", token: token), waitMs: 1500)
            // 房主离开时服务器会解散房间，等它把旧节点释放掉
            Thread.sleep(forTimeInterval: 0.8)
        }
        // 2) 建一个全新的房间
        var fresh = Room()
        send(sig, LobbyLink.createRoom(token: token, name: gameName()), waitMs: 2500)
        try waitForRoomId(sig: sig, room: fresh, timeoutMs: 6000)
        guard let roomId = fresh.roomId, !roomId.isEmpty else {
            throw Failure(message: "服务器没有创建房间")
        }
        room.roomId = roomId
        room.nodeAddress = nil
        room.nodePort = 0
        // 3) 进房 + ready + 切成多人房间
        send(sig, LobbyLink.action("join_room", token: token, roomId: roomId), waitMs: 1500)
        send(sig, LobbyLink.action("ready", token: token), waitMs: 1200)
        send(sig, LobbyLink.settings(token: token, roomId: roomId), waitMs: 1500)
        // 4) 再问一次：这时服务器会连同中继节点一起返回
        send(sig, LobbyLink.createRoom(token: token, name: gameName()), waitMs: 2500)
        try waitForRoom(sig: sig, room: room, roomId: nil, timeoutMs: LobbyLink.roomWaitMs)
        guard room.nodeAddress != nil, room.nodePort > 0 else {
            throw Failure(message: "服务器没有返回中继节点")
        }
    }

    /**
     * 联机自检：在本机验证"登录 → 建房拿中继节点 → UDP/KCP 握手"全链路是否可达。
     * 与真实联机走完全相同的信令路径，但连上中继完成握手即结束（不进入对战循环），
     * 只用来判断"这台设备的网络能否云端联机"。
     */
    func selfTest(user: String, password: String) {
        DispatchQueue.global(qos: .userInitiated).async { [weak self] in
            guard let self else {
                return
            }
            var sig: LobbySignaling.Session?
            var link: LobbyKcpChannel?
            do {
                self.status("自检：登录联机大厅…")
                let token = try LobbySignaling.loginSync(user: user, password: password)
                self.status("自检：连接房间服务器…")
                let session = try LobbySignaling.Session.connectSync()
                sig = session
                if session.insecureTLS {
                    self.status("自检：联机大厅端口证书已过期，已降级连接")
                }
                let uuid = self.gameUuid()
                self.send(session, LobbyLink.sendMessage(token: token, uuid: uuid, text: "go"),
                          waitMs: 1200)
                self.status("自检：创建房间…")
                var room = Room()
                try self.hostCreateRoom(sig: session, token: token, uuid: uuid, room: room)
                // 让对方也能自动拿到中继节点（和真实对战完全一样的广播）
                startNodeAdvertiser(sig: session, token: token, uuid: uuid, room: room)
                self.status("✅ 信令自检通过\n房号 \(room.roomId ?? "")"
                    + "\n中继 \(room.nodeAddress ?? ""):\(room.nodePort)"
                    + "\n正在等对方进入这个房间（公共节点要两端都接入才会应答）…")
                // 复用游戏用的 KCP over UDP 传输做真实握手。
                // 注意：只有自己一个人在房间里时，公共节点是不会应答的，
                // 所以这里一直等，等对方进来后自然会连上。
                guard let address = room.nodeAddress, room.nodePort > 0 else {
                    throw Failure(message: "服务器没有返回中继节点")
                }
                link = try startRelayLink(host: address, port: room.nodePort, room: room, query: nil)
                self.status("✅ 联机自检通过：\n房号 \(room.roomId ?? "")"
                    + "\n中继 \(address):\(room.nodePort)"
                    + "\n信令与中继 UDP/KCP 均可达，本机可以云端联机对战。")
            } catch {
                if !self.isClosed {
                    self.status("❌ 联机自检失败：" + LobbyLink.message(error)
                        + "\n常见原因：网络不通 / VPN 或加速器拦截 UDP / 账号问题。\n提示：公共节点要等对方也进入房间才会应答。")
                }
            }
            link?.close()
            sig?.close()
        }
    }

    /// Skips signalling and connects straight to a hand-supplied relay.
    private func runManual(_ nodeSpec: String, asHost: Bool, conv: Int32?) throws {
        var spec = nodeSpec
        var useConv = conv
        // "tcp:" switches to the framed TCP transport, which is what a TCP
        // tunnel (ssh -R / bore / ngrok) can carry; UDP tunnels are rare.
        let tcp = spec.lowercased().hasPrefix("tcp:")
        if tcp {
            spec = String(spec.dropFirst(4))
        }
        guard let colon = spec.lastIndex(of: ":"), colon > 0,
              let port = UInt16(spec[spec.index(after: colon)...]) else {
            throw Failure(message: "中继地址格式应为 地址:端口")
        }
        var host = String(spec[..<colon])
        if host.lowercased().hasPrefix("tcp:") {
            host = String(host.dropFirst(4))
        }
        status("手动中继：直连 \(host):\(port)\(tcp ? "（TCP）" : "")"
            + (useConv == nil ? "" : " conv=\(useConv!)")
            + (asHost ? "（1P）" : "（2P）"))
        var room = Room()
        room.nodeAddress = host
        room.nodePort = port
        room.playerCount = 2
        let link: LobbyKcpChannel
        if tcp {
            // A tunnel endpoint is a plain TCP listener: no session table, no
            // silent drops, so the retry dance is unnecessary there.
            link = try LobbyKcpChannel.connectTCP(host: host, port: port)
            lock.lock()
            channel = link
            lock.unlock()
            if isClosed {
                link.close()
                return
            }
            sendRegister(link: link, room: room)
            try handshake(link: link, room: room)
        } else if let useConv {
            link = try LobbyKcpChannel.connect(host: host, port: port, conv: useConv)
            lock.lock()
            channel = link
            lock.unlock()
            if isClosed {
                link.close()
                return
            }
            sendRegister(link: link, room: room)
            try handshake(link: link, room: room)
        } else {
            link = try startRelayLink(host: host, port: port, room: room, query: nil)
            if isClosed {
                link.close()
                return
            }
        }
        status("云端联机已连接，你是 \(asHost ? "1P" : "2P")（手动中继）")
        onConnected(asHost, nil)
        serve(link)
    }

    /**
     * Connects to the public relay and completes the lobby handshake.
     *
     * - The very same session (one conversation id, one UDP port) is reused for
     *   every retry. The node keeps a tiny, slowly recycled session table, so
     *   a retry that builds a brand new session fills that table with half open
     *   leftovers and the node then silently drops the newcomer.
     * - Public nodes usually answer only once the second player has joined, so
     *   the retries run for several minutes and the status tells the user that
     *   we are waiting for the opponent.
     * - A node can be recycled by the server at any time, so every 30 seconds
     *   we ask for the current node and switch over when it changed.
     */
    private func startRelayLink(host: String, port: UInt16, room: Room,
                                query: (() -> String?)?) throws -> LobbyKcpChannel {
        var failure: String?
        let deadline = Date().addingTimeInterval(Double(LobbyLink.relayWaitMs) / 1000.0)
        let started = Date()
        var nextQuery = Date()
        var lastNotice = Date.distantPast
        var currentHost = host
        var currentPort = port
        var link: LobbyKcpChannel?
        var registered = false
        while !isClosed && Date() < deadline {
            do {
                if link == nil {
                    let conv = Int32(arc4random_uniform(0x7FFFFFFF)) + 1
                    let opened = try LobbyKcpChannel.open(host: currentHost, port: currentPort, conv: conv)
                    link = opened
                    lock.lock()
                    channel = opened
                    lock.unlock()
                    registered = false
                }
                if let current = link, current.retryHandshake(timeoutMs: 3000) {
                    if !registered {
                        sendRegister(link: current, room: room)
                        registered = true
                    }
                    do {
                        try handshake(link: current, room: room)
                        return current
                    } catch {
                        // 已经连上中继，但对方还没注册：保留同一个会话继续等
                        failure = LobbyLink.message(error)
                        Thread.sleep(forTimeInterval: 1.0)
                        continue
                    }
                }
                // 节点可能被回收了，重新问一次
                if let query, Date() >= nextQuery {
                    nextQuery = Date().addingTimeInterval(30)
                    if let fresh = query() {
                        let parts = fresh.split(separator: ":")
                        if parts.count >= 2, let freshPort = UInt16(parts[parts.count - 1]) {
                            let freshHost = String(parts[0..<(parts.count - 1)].joined(separator: ":"))
                            if freshHost != currentHost || freshPort != currentPort {
                                status("中继节点已更新为 \(fresh)，正在切换…")
                                link?.close()
                                link = nil
                                lock.lock()
                                channel = nil
                                lock.unlock()
                                currentHost = freshHost
                                currentPort = freshPort
                                room.nodeAddress = freshHost
                                room.nodePort = freshPort
                                continue
                            }
                        }
                    }
                }
                if Date().timeIntervalSince(lastNotice) >= 5 {
                    lastNotice = Date()
                    let waited = Int(Date().timeIntervalSince(started))
                    status("房号 \(room.roomId ?? "")"
                        + "\n中继还没有回应（已等待 \(waited) 秒）\n"
                        + "公共节点要等对方也进入房间才会应答，请把房号发给对方\n"
                        + "若始终无回应，可能是网络拦截了 UDP（试试关闭 VPN/加速器）")
                }
                Thread.sleep(forTimeInterval: 1.0)
            } catch {
                failure = LobbyLink.message(error)
                link?.close()
                link = nil
                lock.lock()
                channel = nil
                lock.unlock()
            }
        }
        // A local VPN/accelerator rewrites all UDP into its tunnel and the relay
        // handshake then never comes back, which looks like a dead server.
        let detail = failure ?? "中继连接被取消"
        throw Failure(message: detail + "（开着 VPN/加速器时请先关闭）")
    }

    // MARK: - Official wire handshake

    /**
     * The cloud handshake of the official client:
     *
     *     -> type 1, body: int playerCount, short 0, int baseStateCount
     *     <- type 3, body: int playerCount
     *     -> type 3, body: empty            (the base states are loaded now)
     *     <- type 0, body: int              (first key state of the peer)
     *     -> type 1, body: empty            (acknowledgement)
     */
    private func handshake(link: LobbyKcpChannel, room: Room) throws {
        let count = try expect(link: link, type: LobbyFrames.typeReady, timeoutMs: LobbyLink.stepWaitMs)
        let reported = LobbyFrames.intValue(of: count)
        if reported > 0 {
            status("中继报告有 \(reported) 个玩家")
        }
        status("已注册到中继，等待对方…")

        link.send(LobbyFrames.frame(LobbyFrames.typeReady))
        // The node only pushes the peer's first key state once a second player
        // has registered, so blocking on it would make the host time out while
        // it is simply waiting for an opponent. Treat it as optional.
        _ = try? expect(link: link, type: LobbyFrames.typeKeys, timeoutMs: LobbyLink.peerKeyWaitMs)
        link.send(LobbyFrames.frame(LobbyFrames.typeRegister))
    }

    /// Registers this console at the relay. Sent exactly once per session.
    private func sendRegister(link: LobbyKcpChannel, room: Room) {
        let players = max(1, room.playerCount)
        link.send(LobbyFrames.registerFrame(playerCount: players,
                                            baseStateCount: room.baseStateCount))
    }

    /**
     * Reads frames until one of `type` shows up. The room server sends the key
     * state (type 0) before the handshake is finished, so unrelated frames are
     * remembered instead of being dropped.
     */
    private func expect(link: LobbyKcpChannel, type: Int, timeoutMs: Int64) throws -> Data {
        let deadline = Date().addingTimeInterval(Double(timeoutMs) / 1000.0)
        while true {
            if let body = reader.next() {
                if LobbyFrames.type(of: body) == type {
                    return body
                }
                handle(body)
                continue
            }
            let remaining = max(50, Int(deadline.timeIntervalSinceNow * 1000))
            guard let message = link.recv(timeoutMs: remaining) else {
                if Date() >= deadline {
                    throw Failure(message: "等待中继回应超时")
                }
                continue
            }
            reader.append(message)
        }
    }

    // MARK: - Game loop

    private func serve(_ link: LobbyKcpChannel) {
        var lastKey: Int64 = 0
        var lastFps: Int64 = 0
        var sentKeys = Int32.min
        while !isClosed && !link.isClosed {
            let now = Int64(Date().timeIntervalSince1970 * 1000)
            if now - lastKey >= LobbyLink.keyIntervalMs {
                let keys = localKeys()
                if keys != sentKeys || now - lastKey >= 500 {
                    sentKeys = keys
                    lastKey = now
                    link.send(LobbyFrames.frame(LobbyFrames.typeKeys, keys))
                }
            }
            if now - lastFps >= 1000 {
                lastFps = now
                link.send(LobbyFrames.frame(LobbyFrames.typeFps, 60))
            }
            guard let message = link.recv(timeoutMs: 50) else {
                continue
            }
            reader.append(message)
            while let body = reader.next() {
                handle(body)
            }
        }
    }

    private func handle(_ body: Data) {
        switch LobbyFrames.type(of: body) {
        case LobbyFrames.typeKeys, LobbyFrames.typeKeysLocal:
            onRemoteKeys(LobbyFrames.intValue(of: body))
        case LobbyFrames.typeReset:
            onRemoteReset()
        default:
            break
        }
    }

    // MARK: - Signalling helpers

    /// Sends a signalling frame and gives the server time to answer.
    private func send(_ sig: LobbySignaling.Session, _ text: String, waitMs: Int64) {
        sig.send(text) { _ in }
        Thread.sleep(forTimeInterval: Double(waitMs) / 1000.0)
    }

    /**
     * Scans the signalling stream for the room description. The node endpoint
     * shows up in the `create_game_room` answer, the player count in the
     * `player_joined` pushes.
     */
    private func waitForRoom(sig: LobbySignaling.Session, room: Room, roomId: String?,
                             timeoutMs: Int64) throws {
        let deadline = Date().addingTimeInterval(Double(timeoutMs) / 1000.0)
        while Date() < deadline && !isClosed {
            guard let text = sig.recv(timeoutMs: 1200) else {
                continue
            }
            guard let object = LobbySignaling.lastJSONObject(from: text) else {
                continue
            }
            let type = object["type"] as? String ?? ""
            if type == "create_game_room" {
                if let incoming = object["room_id"] as? String, !incoming.isEmpty {
                    room.roomId = incoming
                }
                if let address = object["node_address"] as? String, !address.isEmpty,
                   let port = object["node_port"] as? Int, port > 0 {
                    room.nodeAddress = address
                    room.nodePort = UInt16(port)
                }
                if let base = object["base_list"] as? [Any] {
                    room.baseStateCount = Int32(base.count)
                }
            } else if type == "player_joined" {
                if let users = object["users"] as? [[String: Any]] {
                    var ready = 0
                    for user in users {
                        let name = user["username"] as? String ?? ""
                        if name.isEmpty {
                            continue
                        }
                        if let started = user["started"] as? Int, started != 0 {
                            ready += 1
                        }
                    }
                    if ready > 0 {
                        room.playerCount = Int32(ready)
                    }
                }
            } else if type == "room_started" || type == "game_started" {
                if let address = object["node_address"] as? String, !address.isEmpty,
                   let port = object["node_port"] as? Int, port > 0 {
                    room.nodeAddress = address
                    room.nodePort = UInt16(port)
                }
            } else if type == "send_message" {
                // The host advertises its relay endpoint through the broadcast
                // channel as {"gboy_node":"address:port","room":"<roomId>"}. Pull
                // it out so the joiner can connect without manual NODE2: entry.
                if let message = object["message"] as? String, message.contains("gboy_node") {
                    if let marker = LobbySignaling.lastJSONObject(from: message),
                       let node = marker["gboy_node"] as? String, node.contains(":") {
                        let tagged = marker["room"] as? String ?? ""
                        if tagged.isEmpty || roomId == nil || tagged == roomId {
                            let parts = node.split(separator: ":")
                            if parts.count >= 2, let port = UInt16(parts[parts.count - 1]), port > 0 {
                                room.nodeAddress = String(parts[0..<(parts.count - 1)].joined(separator: ":"))
                                room.nodePort = port
                            }
                        }
                    }
                }
            }
            if room.nodeAddress != nil && room.nodePort > 0 {
                return
            }
        }
    }

    /**
     * Keeps the host's signalling socket alive and re-broadcasts the relay
     * endpoint to the room so a joining player can fill it in automatically.
     *
     * The same thread also drains the websocket (answering server pings),
     * which is required because the host keeps its signalling session open for
     * the whole match and the server would otherwise time it out.
     */
    private func startNodeAdvertiser(sig: LobbySignaling.Session, token: String, uuid: String,
                                     room: Room) {
        DispatchQueue.global(qos: .utility).async { [weak self] in
            guard let self else {
                return
            }
            var last: Int64 = 0
            while !self.isClosed {
                // Keep the websocket alive; recv() also drains server pings.
                _ = sig.recv(timeoutMs: 1500)
                let now = Int64(Date().timeIntervalSince1970 * 1000)
                if now - last >= 2000 {
                    last = now
                    // 节点可能被服务器回收并更换，所以每次都读房间里的最新节点
                    guard let address = room.nodeAddress, room.nodePort > 0 else {
                        continue
                    }
                    let node = "\(address):\(room.nodePort)"
                    var marker: [String: Any] = ["gboy_node": node]
                    if let roomId = room.roomId, !roomId.isEmpty {
                        marker["room"] = roomId
                    }
                    guard let markerText = LobbyLink.jsonText(marker) else {
                        continue
                    }
                    sig.send(LobbyLink.sendMessage(token: token, uuid: uuid, text: markerText)) { _ in }
                }
            }
        }
    }

    /// Reads until the room id is known (the relay node normally is not part of
    /// that first answer). Used before join_room, which needs the id.
    private func waitForRoomId(sig: LobbySignaling.Session, room: Room,
                               timeoutMs: Int64) throws {
        let deadline = Date().addingTimeInterval(Double(timeoutMs) / 1000.0)
        while Date() < deadline && !isClosed {
            guard let text = sig.recv(timeoutMs: 1200) else {
                continue
            }
            guard let object = LobbySignaling.lastJSONObject(from: text) else {
                continue
            }
            if object["type"] as? String == "create_game_room" {
                if let incoming = object["room_id"] as? String, !incoming.isEmpty {
                    room.roomId = incoming
                }
                if let address = object["node_address"] as? String, !address.isEmpty,
                   let port = object["node_port"] as? Int, port > 0 {
                    room.nodeAddress = address
                    room.nodePort = UInt16(port)
                }
            }
            if let roomId = room.roomId, !roomId.isEmpty {
                return
            }
        }
    }

    // MARK: - JSON helpers

    static func jsonText(_ fields: [String: Any]) -> String? {
        guard let data = try? JSONSerialization.data(withJSONObject: fields),
              let text = String(data: data, encoding: .utf8) else {
            return nil
        }
        return text
    }

    static func action(_ action: String, token: String, roomId: String? = nil) -> String {
        var fields: [String: Any] = ["action": action, "token": token]
        if let roomId, !roomId.isEmpty {
            fields["room_id"] = roomId
        }
        return jsonText(fields) ?? "{}"
    }

    /**
     * The room settings the official client pushes when a room turns into a
     * multiplayer room: multiplayer mode on, UDP transport, key synchronisation
     * and a sane game speed.
     */
    static func settings(token: String, roomId: String) -> String {
        let fields: [String: Any] = [
            "action": "update_room_settings",
            "token": token,
            "room_id": roomId,
            "multi_game": 1,
            "is_udp": 1,
            "sync_modes": 1,
            "game_speed": 100,
            "network_buffer": 100
        ]
        return jsonText(fields) ?? "{}"
    }

    static func sendMessage(token: String, uuid: String, text: String) -> String {
        let fields: [String: Any] = [
            "action": "send_message",
            "token": token,
            "message": text,
            "uuid": uuid
        ]
        return jsonText(fields) ?? "{}"
    }

    /**
     * create_game_room without `game_name` is dropped in silence by the room
     * server (no error frame comes back), which looks exactly like a dead
     * socket. Name the room after the loaded ROM.
     */
    static func createRoom(token: String, name: String) -> String {
        let fields: [String: Any] = [
            "action": "create_game_room",
            "token": token,
            "room_name": name
        ]
        return jsonText(fields) ?? "{}"
    }

    // MARK: - Game identity

    private func gameName() -> String {
        guard let path = romPath(), !path.isEmpty else {
            return "mGBA"
        }
        var name = (path as NSString).lastPathComponent
        if let dot = name.firstIndex(of: "."), dot != name.startIndex {
            name = String(name[name.startIndex..<dot])
        }
        return name.isEmpty ? "mGBA" : name
    }

    /**
     * The game identity the room server expects: the four character game code
     * of the ROM header followed by the MD5 of the ROM, e.g.
     * `BPEE,55c9004420cd750f03192bc20569e1ab`.
     */
    private func gameUuid() -> String {
        guard let path = romPath(), !path.isEmpty,
              let data = try? Data(contentsOf: URL(fileURLWithPath: path)), !data.isEmpty else {
            return "BPEE,"
        }
        let digest = Insecure.MD5.hash(data: data)
        let hex = digest.map { String(format: "%02x", $0) }.joined()
        var code = ""
        if data.count >= 0xB0 {
            for index in 0xAC..<0xB0 {
                let byte = data[index]
                if byte >= 0x20 && byte < 0x7F {
                    code.append(Character(UnicodeScalar(byte)))
                } else {
                    code.append("0")
                }
            }
        }
        let prefix = code.count == 4 ? code : "BPEE"
        return prefix + "," + hex
    }

    // MARK: - Status

    private func fail(_ text: String) {
        lock.lock()
        closedFlag = true
        lock.unlock()
        onRemoteKeys(0)
        status(text)
    }

    private func status(_ text: String) {
        onStatus(text)
    }

    private static func message(_ error: Error) -> String {
        let text: String
        if let failure = error as? Failure {
            text = failure.message
        } else if let failure = error as? LobbySignaling.Failure {
            text = failure.message
        } else {
            text = error.localizedDescription
        }
        if text.isEmpty {
            return "云端联机失败"
        }
        return LobbySignaling.lobby(text) ?? text
    }

    // MARK: - Manual relay parsing

    private struct ManualSpec {
        let node: String
        let asHost: Bool
        let conv: Int32?
    }

    /// Parses `NODE:`/`NODE2:`/`DBG:`/`DBGJ:` prefixes, the optional trailing
    /// `#conv` and the `tcp:` marker.
    private static func manualSpec(_ roomId: String) -> ManualSpec? {
        var text = roomId
        var asHost = false
        var conv: Int32?
        if let hash = text.firstIndex(of: "#"), hash != text.startIndex {
            let tail = String(text[text.index(after: hash)...]).trimmingCharacters(in: .whitespaces)
            text = String(text[..<hash])
            if let value = Int32(tail) {
                conv = value
            }
        }
        for (prefix, host) in [("NODE2:", false), ("DBGJ:", false), ("NODE:", true), ("DBG:", true)] {
            if text.uppercased().hasPrefix(prefix) {
                asHost = host
                text = String(text.dropFirst(prefix.count))
                return ManualSpec(node: text, asHost: asHost, conv: conv)
            }
        }
        return nil
    }
}
