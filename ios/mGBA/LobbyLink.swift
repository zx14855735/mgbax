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
    /// 按键上行节拍倍率（= 本机倍速 × 联机倍速），1.0 = 正常。
    ///
    /// 与 `GBoyLink` 的 pumpRate 同一个理由：官方按键是**帧数驱动**（直连每 5
    /// 帧、房间模式每帧，AUDIT A.13 第 15/16 条），50ms 只是 1x 下的等价近似；
    /// 倍速把帧闸改掉之后不缩放就会变成「对端每 N 帧才收到一次键」。
    /// 1x 走常量、不做浮点除法。lock 保护。**未真机验证。**
    private var keyIntervalRate: Double = 1

    // MARK: - Hooks

    /// Path of the ROM that is currently loaded.
    var romPath: () -> String? = { nil }
    /// Local key bitmask, GBA style.
    var localKeys: () -> Int32 = { 0 }
    /// Save-state snapshot for the host to seed the joiner (TYPE_STATE).
    /// 官方 type 6 的**发送**来源：由 sendInitialState() 在四核房间重建完成
    /// 后取一次，发给对端灌进「代表本机这个玩家」的镜像核（B25kr6:144-152）。
    /// Called from the link thread; return nil until a core is loaded.
    var stateSnapshot: () -> Data? = { nil }
    /// Peer's save-state blob; called from the reader thread.
    var onRemoteState: (Data) -> Void = { _ in }
    /// Key mask received from the peer; called from the reader thread.
    var onRemoteKeys: (Int32) -> Void = { _ in }
    /// Key mask plus the 1-based global console slot that produced it.
    /// N-core lockstep uses this to feed the right mirror core instead of
    /// dumping every peer's keys into one fixed slot.
    var onRemoteKeysForSlot: (Int, Int32) -> Void = { _, _ in }
    /// 官方 type 9（倍速）：对端切换了模拟速度（1 = 1x、-1 = 0.5x、2 = 2x、4 = 4x）。
    /// 上层按这个倍率调整帧循环（官方收到后直接写 AaHO0E.AZkASS 并重算帧闸）。
    /// Called from the reader thread.
    var onRemoteSpeed: (Int) -> Void = { _ in }
    /// Slot owned by this device's visible console (1...4). Devices in a
    /// 3/4-player session must use distinct slots so key frames reach the
    /// right mirror console; slot 1 keeps the two-player TYPE_KEYS behaviour.
    var localSlot: Int = 1
    /// Called from background threads; the owner hops to the main queue.
    var onStatus: (String) -> Void = { _ in }
    /// The link is up: `true` when this device is the 1P.
    var onConnected: (Bool, String?) -> Void = { _, _ in }
    /// The relay link closed (peer gone or session closed); the owner stops
    /// its multicore room so the visible core does not keep waiting on a
    /// dead SIO room（Android onDisconnected → stopGBoyLink 同构）.
    /// Called from the link thread; the owner hops to the main queue.
    var onDisconnected: () -> Void = {}
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
    /// 对端 type 9 下发的倍速原值（-1 = 还没收到；1 表示 1x）。
    private(set) var remoteSpeed: Int = -1
    /// 对端在 type 3 里上报的 RTT（官方 A5SV6n.f5293B9tovu），-1 = 未知。
    private(set) var remoteRtt: Int32 = -1
    /// 本次连接是否已经发过 type 6（连接级去重）。每连一条新通道在
    /// `onConnected` 之前清零：一次会话最多发一份初始存档，重连后可以再发一份。
    private var stateSentThisConnection = false
    /// 本连接是否已经因「对端存档载入失败」中止过（一次会话只发一次 type 1 空体）。
    private var aborted = false
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

    /// 官方 type 9（倍速）：只发线上合法值 {1, -1, 2, 4}（见 `GBoySpeed`）。
    /// 对端收到后只缩放它自己的帧闸 —— 两端必须同速，否则 SIO 子状态会拉开。
    func sendSpeed(_ wire: Int32) {
        guard GBoySpeed.wireValues.contains(wire) else { return }
        lock.lock()
        let current = channel
        let dead = closedFlag
        lock.unlock()
        if let current, !dead {
            current.send(LobbyFrames.frame(LobbyFrames.typeSpeed, wire))
        }
    }

    /**
     * 官方 type 6：把本机可见核的即时存档整包推给对端，让对端「代表本机这个
     * 玩家」的镜像核停在同一幕（B25kr6:144-152、AmA8tU:199）。
     *
     * **触发点**：`onConnected` → 设备层 `armCloudMulticore`（重载 ROM）→
     * `rebuildCloudConsoleSet` 成功**或失败**后各调一次。也就是每建立一条云端
     * 通道、四核房间定稿（或放弃建立）的那个瞬间发一次；重连成功后链路恢复、
     * 房间重建，会自然再发一份**当前**快照。
     *
     * **不能**在这里随手取快照就发：`onConnected` 之后可见核会被重载，重载前
     * 取到的是上一局的进度，重载后发出去会把对端镜像核拉到旧状态。
     *
     * `stateSentThisConnection` 做连接级去重：同一条通道上重复调用只发第一份
     * （防止重建路径被触发两次时刷包）；新通道在 `onConnected` 前已清零，所以
     * 「掉线 → 重连」一定会补发一次。
     */
    func sendInitialState() {
        lock.lock()
        let current = channel
        let dead = closedFlag
        let already = stateSentThisConnection
        lock.unlock()
        guard let current, !dead else {
            status("初始状态未发送：联机通道还没就绪")
            return
        }
        guard !already else {
            status("本次连接已发过即时存档，跳过重复发送")
            return
        }
        guard let snapshot = stateSnapshot(), !snapshot.isEmpty else {
            status("初始状态未发送：本机还没有可用的即时存档")
            return
        }
        // 抢占标记：万一两条线程同时走到这里，只让一个真正发出去。
        lock.lock()
        let claimed = !stateSentThisConnection
        stateSentThisConnection = true
        lock.unlock()
        guard claimed else { return }
        current.send(LobbyFrames.stateFrame(snapshot))
        status("已把本机即时存档 \(snapshot.count) 字节发给对端")
    }

    /// 每建立一条新通道、调 onConnected 之前清掉「本次连接已发」标记。
    private func beginConnection() {
        lock.lock()
        stateSentThisConnection = false
        aborted = false
        keyIntervalRate = 1   // 新连接从 1x 起；设备层连上后会按当前倍速再写一次
        lock.unlock()
    }

    /// 按键上行间隔（ms）：1x 严格 50，其余按倍率缩放。rate 已夹到 0.25...4。
    private static func keyInterval(rate: Double) -> Int64 {
        if rate > 0.999 && rate < 1.001 {
            return keyIntervalMs
        }
        return max(1, Int64(Double(keyIntervalMs) / rate))
    }

    /// 本机/联机倍速变化时由设备层（主线程）调用。
    func setKeyIntervalRate(_ rate: Double) {
        let value = (rate.isFinite && rate > 0) ? min(4, max(0.25, rate)) : 1
        lock.lock()
        keyIntervalRate = value
        lock.unlock()
    }

    /**
     * 官方 B25kr6:144-152：对端存档载入失败（`-5` → 会话错误 3、其它非 0 → 1）
     * 时直接 `return i` 结束这条对端会话。iOS 的载入发生在镜像线程的帧边界，
     * 错误码晚一帧才拿到，这里补上等价动作：
     *   - 发一条**空体 type 1**（官方的语义：长度 0 的 1 = 断开/结束）；
     *   - 关掉通道，`serve()` 返回后 onDisconnected 会让上层拆掉四核房间；
     *   - 状态栏写明原因与错误码。
     * 一条连接只发一次（`aborted`），避免镜像线程和重连路径重复触发。
     */
    func abortSession(errorCode: Int) {
        lock.lock()
        let current = channel
        let dead = closedFlag
        let already = aborted
        if !already {
            aborted = true
        }
        lock.unlock()
        guard !already, !dead else { return }
        current?.send(LobbyFrames.frame(LobbyFrames.typeRegister))
        status("对端存档载入失败（错误码 \(errorCode)），联机已结束")
        close()
    }

    func close() {
        lock.lock()
        closedFlag = true
        let current = channel
        channel = nil
        let open = session
        session = nil
        keyIntervalRate = 1   // 上行节拍回 1x，别让下一局带着上一局的倍速起来
        lock.unlock()
        current?.close()
        open?.close()
        onRemoteKeys(0)
        onRemoteSpeed(1)   // 会话结束把倍速还原成 1x（官方断开时速度归 1）
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
        beginConnection()
        onConnected(asHost, nil)
        serve(link)
        onDisconnected()
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
        guard let colon = spec.lastIndex(of: ":"), colon > spec.startIndex,
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
        beginConnection()
        onConnected(asHost, nil)
        serve(link)
        onDisconnected()
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
     *     <- type 0, body: int              (握手期节奏值，AmA8tU:213-221)
     *     -> type 1, body: empty            (acknowledgement)
     *
     * 注意 type 0 在这个阶段是「节奏值」（AmA8tU 把它写进 AZkASS），稳态才是
     * 按键掩码（B25kr6.AYUAbz case 0）。所以握手期的 type 0 不能往镜像核喂键，
     * 由 `handle(_:steady:false)` 单独消化。
     */
    private func handshake(link: LobbyKcpChannel, room: Room) throws {
        /* AUDIT C8：官方服务端从不主动发 type 3（它是「就绪 + 现在去灌各槽
         * 存档」的单向指令，客户端回空体 3 当 ack）。所以这里不能硬等：
         * 超时只说明对端没先发，按「玩家数未知」继续注册即可。
         * 命中时若是空体 ack，intValue 读到 0，同样只当没报告数字。 */
        if let count = try? expect(link: link, type: LobbyFrames.typeReady,
                                   timeoutMs: LobbyLink.stepWaitMs) {
            let reported = LobbyFrames.intValue(of: count)
            if reported > 0 {
                status("中继报告有 \(reported) 个玩家")
            }
        }
        status("已注册到中继，等待对方…")

        link.send(LobbyFrames.frame(LobbyFrames.typeReady))
        // AmA8tU:213-221：发完空的 type 3 等一帧 type 0 再发空 type 1 收尾。
        // 中继要等第二个玩家注册才会推，房主在等人时不能因此超时 → 可选。
        // expect 命中后不会经 handle()，所以这里补一次（只是记账，不喂按键）。
        if let pacing = try? expect(link: link, type: LobbyFrames.typeKeys,
                                    timeoutMs: LobbyLink.peerKeyWaitMs) {
            handle(pacing, steady: false)
        }
        link.send(LobbyFrames.frame(LobbyFrames.typeRegister))
    }

    /// Registers this console at the relay. Sent exactly once per session.
    private func sendRegister(link: LobbyKcpChannel, room: Room) {
        let players = max(1, room.playerCount)
        link.send(LobbyFrames.registerFrame(playerCount: players,
                                            baseStateCount: room.baseStateCount))
    }

    /**
     * Reads frames until one of `type` shows up. 握手期还会收到中继的 type 0
     * （节奏值）与残留 type 3，交给 `handle(_:steady:false)` 消化而不是丢掉。
     */
    private func expect(link: LobbyKcpChannel, type: Int, timeoutMs: Int64) throws -> Data {
        let deadline = Date().addingTimeInterval(Double(timeoutMs) / 1000.0)
        while true {
            if let body = reader.next() {
                if LobbyFrames.type(of: body) == type {
                    return body
                }
                handle(body, steady: false)
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
        var sentKeys = Int32.min
        while !isClosed && !link.isClosed {
            let now = Int64(Date().timeIntervalSince1970 * 1000)
            lock.lock()
            let interval = Self.keyInterval(rate: keyIntervalRate)
            lock.unlock()
            // 官方 type 6 的发送不放这里：它必须等四核房间重建完（对端镜像核
            // 存在、本机可见核已冷启动到帧 0）再发一次，由 sendInitialState()
            // 从设备层触发。这条循环里发会把「上一局推进过的状态」灌进对端。
            if now - lastKey >= interval {
                let keys = localKeys()
                if keys != sentKeys || now - lastKey >= 500 {
                    sentKeys = keys
                    lastKey = now
                    // 官方稳态按键是 type 0（B25kr6.AYUAbz case 0），不再是 9。
                    link.send(LobbyFrames.frame(keyFrameType(), keys))
                }
            }
            // 官方没有任何 fps/pacing 帧：以前每秒一条 `0 + int 60` 在官方眼里
            // 等于「按键掩码 60」，会把对端镜像核的按键黏住（AUDIT C2）。
            guard let message = link.recv(timeoutMs: 50) else {
                continue
            }
            reader.append(message)
            while let body = reader.next() {
                handle(body, steady: true)
            }
        }
    }

    /// Same mirror-console slot map as GBoyLinkSession.java on Android and
    /// GBoyLinkSession.cpp on the PC build. Kept here so a future multi-core
    /// iOS layout assigns key masks to exactly the same global slots.
    static func mirrorSlotFor(localSlot: Int, playerCount: Int, index: Int) -> Int {
        guard (2...4).contains(playerCount), (1...playerCount).contains(localSlot),
              index >= 0, index < playerCount - 1 else { return 0 }
        var seen = 0
        for slot in 1...playerCount where slot != localSlot {
            if seen == index { return slot }
            seen += 1
        }
        return 0
    }

    /// Official protocol tags key frames with the target console slot once
    /// more than two consoles are in play. 官方稳态按键号是 0（`AYUAbz` case 0），
    /// 9 是倍速；11/12/17 是我们自己的「带槽位按键」扩展，避开官方 0/1/2/3/5/6/9。
    private func keyFrameType() -> Int {
        switch localSlot {
        case 2: return LobbyFrames.typeInput2
        case 3: return LobbyFrames.typeInput3
        case 4: return LobbyFrames.typeInput4
        default: return LobbyFrames.typeKeys
        }
    }

    /// Frame type identifies the sender's 1-based global slot, mirroring
    /// `keyFrameType()`: TYPE_KEYS=0, TYPE_INPUT2=11, TYPE_INPUT3=17,
    /// TYPE_INPUT4=12. Keep the legacy single-callback path intact.
    private func deliverKeys(_ slot: Int, _ body: Data) {
        let keys = LobbyFrames.intValue(of: body)
        onRemoteKeys(keys)
        onRemoteKeysForSlot(slot, keys)
    }

    /// Mirrors GBoyLinkSession.defaultSenderSlot(): in the cloud 4-core room
    /// both devices keep localSlot=1, so a bare TYPE_KEYS frame means「对面
    /// 那台设备」and must land on slot 2 — the mirror core that represents
    /// the opponent. Delivering slot 1 would overwrite our own visible
    /// core's keys（Android 实测教训）。
    private var bareKeysSenderSlot: Int {
        localSlot == 1 ? 2 : 1
    }

    /**
     * 一条帧的分发。**`steady` 决定 type 0 的含义**（AUDIT §0.4）：
     * 握手期是节点下发的节奏值（AmA8tU 写进 AZkASS），稳态才是按键掩码
     * （B25kr6.AYUAbz case 0 → `peer.BI9f7h.setKeys`）。握手期把节奏值当按键
     * 喂下去，会让镜像核收到「按键 60」这种垃圾掩码。
     */
    private func handle(_ body: Data, steady: Bool) {
        let type = LobbyFrames.type(of: body)
        if type == LobbyFrames.typeKeys {
            if steady {
                deliverKeys(bareKeysSenderSlot, body)
            } else {
                // 握手期的节奏值：官方 AaHO0E.AZkASS，我们只记录不喂键。
                let pace = LobbyFrames.intValue(of: body)
                status("中继节奏值 \(pace)")
            }
            return
        }
        switch type {
        case LobbyFrames.typeKeysLocal:
            deliverKeys(bareKeysSenderSlot, body)
        case LobbyFrames.typeInput2:
            deliverKeys(2, body)
        case LobbyFrames.typeInput3:
            deliverKeys(3, body)
        case LobbyFrames.typeInput4:
            deliverKeys(4, body)
        case LobbyFrames.typeReady:
            // 官方 3 有双重语义（AUDIT §0.4 / 稳态表）：握手期是「就绪 + RTT
            // （int32）」，稳态是**槽位 3 的按键**（AYUAbz 里 1..4 按槽位分发的
            // 那张表）。官方自己从不发稳态的 1..4，但 Android/PC 接收侧都按表
            // 兼容；我们发槽位 3 按键用的是扩展号 17，这里两种都收。
            if LobbyFrames.payload(of: body).count >= 4 {
                if steady {
                    deliverKeys(3, body)
                } else {
                    let rtt = LobbyFrames.intValue(of: body)
                    if rtt >= 0 {
                        lock.lock()
                        remoteRtt = rtt
                        lock.unlock()
                    }
                }
            }
        case LobbyFrames.typeSpeed:
            // 官方 9：倍速（1 = 1x、-1 = 0.5x、2 = 2x、4 = 4x）。官方收到后
            // 直接写 AaHO0E.AZkASS 并重算帧闸；iOS 交给帧循环按倍率缩放。
            let speed = Int(LobbyFrames.intValue(of: body))
            if speed == 1 || speed == -1 || speed == 2 || speed == 4 {
                lock.lock()
                remoteSpeed = speed
                lock.unlock()
                onRemoteSpeed(speed)
            }
        case LobbyFrames.typeReset, LobbyFrames.typeResetLegacy:
            // 官方 5 = 复位全部核（EmulatorActivity:1333）；13 是自家旧号。
            // 旧实现把 5 当 ready-ack 吞掉，导致官方的重置帧永远不生效。
            onRemoteReset()
        case LobbyFrames.typeState:
            if let state = LobbyFrames.state(of: body), !state.isEmpty {
                onRemoteState(state)
            }
        case LobbyFrames.typeDisconnect:
            /* 官方 10 = 对端通知断开（`AYUAbz` case 10 → UI msg 2，无 payload）。
             * 与 type 1 空体同一条收尾：正常断开，不当作错误。close() 让
             * serve() 退出，随后 onDisconnected 由上层拆四核房间。 */
            status("对方已断开")
            close()
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
        keyIntervalRate = 1   // 上行节拍回 1x
        lock.unlock()
        onRemoteKeys(0)
        onRemoteSpeed(1)   // 同上：链路没了就把倍速还原成 1x
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
