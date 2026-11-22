/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */




/**
 * GBoy / My Boy "联机大厅" Wi-Fi protocol, a Swift port of the Android
 * GBoyLink: plain TCP with big-endian framing, every packet is
 * `[u32 payload length][payload]` and the payload starts with a `u16`
 * message type.
 *
 * 消息号按官方**字节码**核对（tmp_gboy_apk/NETPLAY_AUDIT.md §0 与 A.14；
 * .workbuddy/gboy/dd/p1/p2.txt）：
 *
 *   0 KEYS      u16 type + u32 GBA 按键掩码（稳态每帧/每对端一条）。
 *   1 HELLO     u16 type + u32 6；客户端先发，服务端原样回。
 *   2 ROMINFO   u16 type + 32 字节 ASCII MD5 + u16 名字长度 + 名字。
 *   3 READY     u16 type（官方还允许带 int32 rtt，见 B25kr6:131）。
 *   5 RESET     u16 type + int32 0；复位全部核。
 *   6 STATE     u16 type + u32 size + 整份 mGBA 即时存档。
 *   9 SPEED     u16 type + int32 倍率（1 = 1x、-1 = 0.5x、2 = 2x、4 = 4x）。
 *  10 DISCONNECT u16 type；对端通知断开（AYUAbz case 10 → UI msg 2）。
 *  13 RESET_OLD u16 type；自家旧版复位号，收到同样执行复位（只发 5）。
 * 100 RECONNECT u16 type + int32 rtt（裸 10 字节，AmA8tU.ARc23Z(Socket)）。
 *
 * **曾经的错表**（0 = 帧率 / 9 = 按键 / 5 = ready-ack）已在本次修正：
 * `B25kr6.AYUAbz` 的 switch 里 case 0 → `peer.BI9f7h.setKeys(getInt())`
 * （p2.txt:379f24-379f36），模拟线程 `D8MqeW.run` 每帧把按键打成
 * `ARc23Z(0,4).putInt(keys)`（p1.txt:34821a / 348364）；case 9 → 写
 * `AaHO0E.AZkASS` 倍速并重算帧闸；case 5 → 可见核 + 全部镜像核 reset(false)。
 * 官方没有 fps/pacing 帧，也没有 ready-ack。
 *
 * 断线重连另有官方私有包：裸 10 字节 `int32 6 + int16 100 + int32 rtt`
 * （AmA8tU.ARc23Z(Socket):263-272），按帧格式读出来就是「长度 6 + type 100 +
 * 4 字节 rtt」，即 type 100 带 int32 rtt。见 msgReconnect。
 *
 * After the handshake each side sends its key mask about every five frames
 * (~83 ms) and applies the mask it receives, so a GBoy handset drives the
 * remote player here the same way it would drive its own second console.
 *
 * 掉线与重连（照抄官方）：建房侧的监听口不随会话结束而关闭（A2egSU 是「每
 * socket 一个服务线程」），对端掉线后回到 accept 等它回来；入房侧按 AmA8tU 的
 * 节奏每 2 秒重试、总窗口 50 秒，连上先发裸 10 字节 type 100 再进读循环。
 * 每一代会话带 `(fd, generation)`，旧读/写线程晚到时不会误关新连接的 socket。
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

    // 消息号必须与官方客户端（KpHwm4.B25kr6 / AYUAbz 字节码）以及 PC/Android
    // 两端的 GBoyFrames 完全一致：0 按键 / 1 握手 / 2 名字 / 3 就绪+RTT /
    // 5 复位 / 6 状态 / 9 倍速。自家扩展一律用 11 以上的号。
    private static let msgKeys = 0
    private static let msgHello = 1
    private static let msgRomInfo = 2
    private static let msgReady = 3
    /// 官方 5：复位全部核（EmulatorActivity:1333 发 int 0；AYUAbz case 5）。
    private static let msgReset = 5
    private static let msgState = 6
    /// 官方 9：模拟倍速（B25kr6.AZOQYO，调用者是倍速菜单）。
    private static let msgSpeed = 9
    /// 官方 10：断开通知（AYUAbz case 10 → UI msg 2）。无 payload。
    private static let msgDisconnect = 10
    /// 自家旧版复位号，保留兼容（只收不发）。
    private static let msgResetLegacy = 13
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
    /// 官方 type 9（倍速）：对端切换了模拟速度（1 = 1x、-1 = 0.5x、2 = 2x、4 = 4x）。
    /// 上层按倍率缩放帧循环（官方收到后写 AaHO0E.AZkASS 并重算帧闸）。
    /// Called from the reader thread.
    var onRemoteSpeed: (Int) -> Void = { _ in }

    private let lock = NSLock()
    /// 用户主动断开（只有 close() 会置位）。只有它能让 host 的 accept 循环退出：
    /// 对端掉线后监听口要继续听，等对方按官方时序重连回来。
    private var userClosedFlag = false
    /// 本代会话已经结束（对端掉线 / 读写出错）。每次 store() 开新会话时清掉。
    private var sessionClosedFlag = false
    private var currentFd: Int32 = -1
    /// 建房时正在监听的 socket（-1 = 没在监听）。run()/close() 要能把它收掉，
    /// 否则用户「再点一次创建」会撞上上一轮遗留的监听口（端口被占用）。
    private var currentListenFd: Int32 = -1
    /// 会话代号：每 store() 一次 +1。
    /// fd 是 Int32 且 close 之后会被内核复用，光比数值无法判断「这条 fd 还是不是
    /// 我这代会话的」（旧读线程醒来时可能已经撞上新会话复用的同一个 fd）。Android
    /// 那边直接用 socket 对象身份做同一件事，Swift 只有裸 fd，所以加代号。
    private var currentGeneration = 0
    /// 对端上报的 RTT（官方 type 3 / 重连包里的 int32），-1 = 未知。lock 保护。
    private var lastRttValue: Int32 = -1
    /// 按键上行节拍倍率（= 本机倍速 × 联机倍速），1.0 = 正常。
    ///
    /// 官方是按**帧数**发按键的（直连 `D8MqeW.run` 每 5 帧一条、房间模式每帧
    /// 一条，AUDIT A.13 第 15/16 条）。帧闸被本机倍速或 type 9 改变后，固定
    /// 83ms 就不再等于 5 帧（4x 时对端要等 4 帧才收到一次键）。这里用墙钟
    /// 等价近似：`interval = 83ms / rate`。1x 走常量、不做除法，节拍与历史
    /// 行为逐位相同。**未真机验证。**
    private var pumpRate: Double = 1

    /// 一条已建立的连接。读线程、写线程和 drop() 都带上它做代次校验。
    private struct Session {
        let fd: Int32
        let generation: Int
    }

    /// 线程该不该退：这条会话还是不是「当前会话」。用户断开、对端掉线、
    /// 或者已经开了新会话（代号变了），三者都会让它变 false。
    ///
    /// 不用「全局 closed 标志」的原因：run() 重新 join 时会清掉标志，旧线程
    /// 可能还睡在 83ms 的发送间隔里，醒来后去写一个**已被内核复用**的 fd 号，
    /// 把旧按键混进新连接（两个线程交错 send 还会撕开帧）。代次校验能保证
    /// 旧线程在新会话建立后一个字节都不写。
    private func isCurrent(_ session: Session) -> Bool {
        lock.lock()
        defer { lock.unlock() }
        return currentFd == session.fd && currentGeneration == session.generation
    }

    /// 用户是否按了「断开」。accept / connect 循环只认这个。
    private var userClosed: Bool {
        lock.lock()
        defer { lock.unlock() }
        return userClosedFlag
    }

    /// 这条监听 fd 是否仍归本线程所有（run()/close() 会把它收走）。
    private func listenCurrent(_ fd: Int32) -> Bool {
        lock.lock()
        defer { lock.unlock() }
        return currentListenFd == fd
    }

    /** Starts hosting on the given port; the peer connects to this device. */
    func host(_ port: Int) {
        run(asHost: true, ip: nil, port: port)
    }

    /** Connects to a GBoy room that is already hosting. */
    func join(_ ip: String, _ port: Int) {
        run(asHost: false, ip: ip, port: port)
    }

    /**
     * Sends the reset notice to the peer (user pressed 复位).
     *
     * 官方 5 的 payload 是 `int32 0`（`ARc23Z((short)5, 4).putInt(0)`），
     * 接收侧 `AYUAbz` 的循环入口要求 `remaining >= 6` 才分发，所以**空体
     * type 5 会被官方直接忽略**。这里必须带 4 字节。
     */
    func sendReset() {
        lock.lock()
        let fd = currentFd
        let dead = userClosedFlag || sessionClosedFlag
        lock.unlock()
        if fd >= 0 && !dead {
            // send() 负责补 4 字节大端长度头；intFrame 只有 type + int32。
            try? send(fd, Self.intFrame(Self.msgReset, 0))
        }
    }

    /**
     * 官方 type 9（倍速）：把本机选的倍速告诉对端（`B25kr6.AZOQYO:253-258`
     * 是 `ARc23Z(9, 4).putInt(i)`）。对端收到后只改它自己的帧闸，不动游戏逻辑。
     * 只发线上合法值 {1, -1, 2, 4}（见 GBoySpeed）。
     */
    func sendSpeed(_ wire: Int32) {
        guard GBoySpeed.wireValues.contains(wire) else { return }
        lock.lock()
        let fd = currentFd
        let dead = userClosedFlag || sessionClosedFlag
        lock.unlock()
        guard fd >= 0, !dead else { return }
        try? send(fd, Self.intFrame(Self.msgSpeed, wire))
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
     * 重放（存档早已灌进镜像核）。guestLoop 的重连循环走的就是这条；接收侧
     * 把 type 100 当握手（见 expectHello），不回任何包（与 Android
     * GBoySocketLink.pumpInput 一致：只有首次 TYPE_REGISTER 才回声）。
     */
    func sendReconnectHandshake() {
        lock.lock()
        let fd = currentFd
        let dead = userClosedFlag || sessionClosedFlag
        let rtt = lastRttValue
        lock.unlock()
        guard fd >= 0, !dead else { return }
        try? Self.sendAll(fd, Self.reconnectFrame(rtt: rtt))
    }

    /// 重连包的实际发送点：绑定到某代会话，写失败要抛出去让 guestLoop 重试。
    private func sendReconnect(_ session: Session) throws {
        try Self.sendAll(session.fd, Self.reconnectFrame(rtt: lastRtt))
    }

    func close() {
        lock.lock()
        // 用户主动断开：连监听口一起收（host/guest 循环都以 userClosedFlag 为准）。
        userClosedFlag = true
        sessionClosedFlag = true
        let fd = currentFd
        currentFd = -1
        let listenFd = currentListenFd
        currentListenFd = -1
        // 代号 +1 让所有在飞的读/写线程立刻变成「上一代」，它们晚到的 drop()
        // 不会再碰到后续会话的 socket。
        currentGeneration += 1
        pumpRate = 1   // 上行节拍回 1x
        lock.unlock()
        if fd >= 0 {
            shutdown(fd, SHUT_RDWR)
            Darwin.close(fd)
        }
        if listenFd >= 0 {
            shutdown(listenFd, SHUT_RDWR)
            Darwin.close(listenFd)
        }
        onRemoteKeys(0)
        onRemoteSpeed(1)   // 断开就把倍速还原成 1x（官方断开时速度归 1）
    }

    private func run(asHost: Bool, ip: String?, port: Int) {
        // A fresh session clears any previous close: 断开 followed by a new
        // join must work without recreating this object.
        lock.lock()
        userClosedFlag = false
        sessionClosedFlag = false
        let stale = currentFd
        currentFd = -1
        let staleListen = currentListenFd
        currentListenFd = -1
        currentGeneration += 1
        pumpRate = 1   // 新会话从 1x 起；设备层连上后会按当前倍速再写一次
        lock.unlock()
        if stale >= 0 {
            shutdown(stale, SHUT_RDWR)
            Darwin.close(stale)
        }
        if staleListen >= 0 {
            shutdown(staleListen, SHUT_RDWR)
            Darwin.close(staleListen)
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
                if !self.userClosed {
                    self.status(Self.message(error))
                }
            }
        }
        thread.name = "gboy-link"
        thread.stackSize = 1 << 20
        thread.start()
    }

    /**
     * 建房：监听口在整个生命周期里不关，accept 循环每接一个对端跑一轮会话。
     * 官方 A2egSU 就是「每 socket 一个服务线程」，监听对象一直活着；Android
     * 侧也按这个语义补了 accept 循环。对端掉线 → 回到 accept 等它重连（对方
     * 会先发 type 100）。只有用户按「断开」才退出。
     */
    private func hostLoop(_ port: Int) throws {
        status("联机大厅等待连接…\n端口 \(port)，你是 1P")
        let listenFd = try listenSocket(port)
        lock.lock()
        currentListenFd = listenFd
        lock.unlock()
        // 监听口的关闭也必须做「所有权」判断：run()/close() 可能已经把它收走
        // 并让内核把这个 fd 号复用给新连接的 socket，这里再 close 一次就会关掉
        // 别人的连接。
        defer {
            lock.lock()
            let mine = currentListenFd == listenFd
            if mine { currentListenFd = -1 }
            lock.unlock()
            if mine {
                shutdown(listenFd, SHUT_RDWR)
                Darwin.close(listenFd)
            }
        }
        while !userClosed {
            let accepted: Int32
            do {
                accepted = try acceptLoop(listenFd)
            } catch {
                // 监听口已被 run()/close() 收走（用户重开或断开）：安静退出。
                if !listenCurrent(listenFd) { return }
                throw error
            }
            // accept 与「用户按断开」可能赛跑：这时刚接到的连接要立刻扔掉，
            // 否则 store() 会把它重新变成一条活会话。
            if userClosed {
                shutdown(accepted, SHUT_RDWR)
                Darwin.close(accepted)
                return
            }
            let session = store(fd: accepted)
            Self.tune(accepted)
            status("对方已接入，正在同步…")
            do {
                let note = try handshake(session, asHost: true)
                try self.session(session, asHost: true, note: note)
            } catch {
                // 握手失败或会话中途出错：关掉这一条连接，回到 accept 等对方
                // 重新来过（重连包同样会落进 expectHello 的 resumed 分支）。
                drop(session, Self.message(error))
            }
            if userClosed { return }
            status("对方已断开，等待重新连接…\n端口 \(port)")
        }
    }

    /**
     * 入房：第一次走完整握手（1→2→3→6）；**首次连不上就立刻报错**，之后掉线
     * 才按官方 AmA8tU 的节奏重连：每 2 秒一次、总窗口 50 秒
     * （AmA8tU 的 `System.currentTimeMillis() - BChYOn >= 50000` 判断），
     * 连上先发裸 10 字节 type 100 再进读循环。
     *
     * 首次与之后的分界就是官方那个 `f4332B9tovu`（握手成功才置 true）：
     * AmA8tU.java:95-98 的 `catch (IOException e) { if (!B9tovu) throw e; }`
     * —— 房主还没开房时应当立刻告诉用户，只有打到一半掉线才值得静默重试。
     */
    private func guestLoop(_ ip: String, _ port: Int) throws {
        var resume = false                  // 已经完成过一次握手（= f4332B9tovu）
        var reconnectUntil: Date?           // 重连窗口截止
        while !userClosed {
            var active: Session?
            do {
                status(resume ? "正在重连 \(ip):\(port)…" : "正在连接 \(ip):\(port)…")
                let fd = try connectSocket(ip, port)
                let session = store(fd: fd)
                active = session
                Self.tune(fd)
                let note: String
                if resume {
                    try sendReconnect(session)
                    note = "已恢复联机（重连握手）"
                } else {
                    status("已连上，正在同步…")
                    note = try handshake(session, asHost: false)
                }
                resume = true
                reconnectUntil = nil
                try self.session(session, asHost: false, note: note)
            } catch {
                // 握手/重连包写失败：把这条连接关掉再去重试，别让 fd 泄漏。
                if let session = active {
                    drop(session, Self.message(error))
                }
                if userClosed { throw error }
                // 官方 AmA8tU:95-98：从未握手成功过就直接抛，不进 50 秒窗口。
                if !resume { throw error }
                if let until = reconnectUntil, Date() >= until {
                    throw LinkError(message: "对方已断开（50 秒内没能重连）")
                }
                if reconnectUntil == nil {
                    reconnectUntil = Date().addingTimeInterval(50)
                }
            }
            if userClosed { return }
            if reconnectUntil == nil {
                reconnectUntil = Date().addingTimeInterval(50)
            }
            status("对方已断开，2 秒后重连…")
            Thread.sleep(forTimeInterval: 2)
        }
    }

    private func handshake(_ session: Session, asHost: Bool) throws -> String {
        let fd = session.fd
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
        /* 官方服务端（B25kr6.A4TApA）只读我们的 type 3、**从不回发**（AUDIT C8），
         * 所以这一步是可选的：等不到 ack 就继续握手，不能把已握好的链路判死。
         * 期间到达的 type 6 说明对端直接进了存档交换 —— 回推给 readState()。
         *
         * 用 select() 等 2 秒而不是改 SO_RCVTIMEO：读超时会吃掉半帧头把后续
         * 字节错位成帧头（见 tune() 里 keepalive 那段说明），而这里对端可能
         * 一个字节都不发，不能为了一次可选等待冒这个险。 */
        let readyDeadline = Date().addingTimeInterval(2)
        while Self.waitReadable(fd, until: readyDeadline) {
            let frame = try readFrame(fd)
            let messageType = Self.type(frame)
            if messageType == Self.msgReady {
                let rtt = Self.intValue(frame)
                if rtt >= 0 {
                    lock.lock()
                    lastRttValue = rtt
                    lock.unlock()
                }
                break
            }
            if messageType == Self.msgState {
                pushedBackFrame = frame
                break
            }
            if messageType == Self.msgKeys || messageType == Self.msgSpeed
                || messageType == Self.msgReset || messageType == Self.msgResetLegacy
                || messageType == Self.msgReconnect {
                continue
            }
            throw LinkError(message: "对方不是联机大厅会话")
        }

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

    private func session(_ session: Session, asHost: Bool, note: String) throws {
        // The steady state has no handshake deadline: the peer may not even
        // have connected yet, and its key frames arrive at their own cadence.
        Self.clearTimeouts(session.fd)
        var text = asHost ? "已连接，你是 1P" : "已连接，你是 2P"
        if !note.isEmpty {
            text = note + "\n" + text
        }
        status(text)
        let reader = Thread { [weak self] in
            self?.readLoop(session)
        }
        reader.name = "gboy-read"
        reader.stackSize = 1 << 20
        reader.start()
        pump(session)
    }

    private func readLoop(_ session: Session) {
        let fd = session.fd
        do {
            while isCurrent(session) {
                let frame = try readFrame(fd)
                let messageType = Self.type(frame)
                if messageType == Self.msgKeys, frame.count >= 6 {
                    // 官方 0 = 按键掩码（AYUAbz case 0 → peer.BI9f7h.setKeys）。
                    let keys = Self.intValue(frame)
                    onRemoteKeys(keys)
                    onRemoteKeysForSlot(1, keys)
                } else if messageType == Self.msgReset || messageType == Self.msgResetLegacy {
                    // 官方 5 = 复位全部核（EmulatorActivity:1333 / AYUAbz case 5）；
                    // 13 是自家旧版号，一并接受。
                    onRemoteReset()
                } else if messageType == Self.msgDisconnect {
                    // 官方 10 = 对端通知断开（AYUAbz case 10 → UI msg 2，无 payload）。
                    // 与读到 EOF 走同一条收尾：关会话、报状态，不当作错误弹窗。
                    drop(session, "对方已断开（type 10）")
                    return
                } else if messageType == Self.msgSpeed {
                    // 官方 9 = 倍速（AYUAbz case 9 → AaHO0E.AZkASS + 重算帧闸）。
                    let speed = Int(Self.intValue(frame))
                    if speed == 1 || speed == -1 || speed == 2 || speed == 4 {
                        onRemoteSpeed(speed)
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
            drop(session, Self.message(error))
        }
    }

    private func pump(_ session: Session) {
        let fd = session.fd
        while isCurrent(session) {
            do {
                try send(fd, Self.keysFrame(localKeys()))
            } catch {
                drop(session, Self.message(error))
                return
            }
            Thread.sleep(forTimeInterval: Self.pumpInterval(rate: currentPumpRate))
        }
    }

    /// 按键上行间隔：1x 严格 0.083（不参与浮点除法），其余按倍率缩放。
    /// rate 已在 `setPumpRate` 里夹到 0.25...4。
    private static func pumpInterval(rate: Double) -> TimeInterval {
        if rate > 0.999 && rate < 1.001 {
            return 0.083
        }
        return 0.083 / rate
    }

    private var currentPumpRate: Double {
        lock.lock()
        defer { lock.unlock() }
        return pumpRate
    }

    /// 本机/联机倍速变化时由设备层（主线程）调用；夹在 0.25...4，
    /// 免得自定义 16x 把上行的线流量放大 16 倍。
    func setPumpRate(_ rate: Double) {
        let value = (rate.isFinite && rate > 0) ? min(4, max(0.25, rate)) : 1
        lock.lock()
        pumpRate = value
        lock.unlock()
    }

    /**
     * 本代会话结束。**只关自己那条 fd**：旧读线程可能在新会话已经建立之后
     * 才被唤醒/报错，那时 currentFd 已经换人（或代号不同），这里必须直接
     * 返回，否则会把对面正在用的新连接关掉。
     */
    private func drop(_ session: Session, _ text: String) {
        lock.lock()
        let mine = currentFd == session.fd && currentGeneration == session.generation
        if !mine {
            lock.unlock()
            return
        }
        sessionClosedFlag = true
        currentFd = -1
        // 会话结束：上行节拍回 1x，别让下一局带着上一局的 4x 起来。
        pumpRate = 1
        lock.unlock()
        // 先 shutdown 再 close：与官方 socket.close() 同义，顺便唤醒可能还堵在
        // recv 上的另一个线程。
        shutdown(session.fd, SHUT_RDWR)
        Darwin.close(session.fd)
        onRemoteKeys(0)
        // 会话结束：把倍速还原成 1x（官方断开时速度归 1），否则对端切过 2x/4x
        // 之后本机会一直按那个倍率跑。
        onRemoteSpeed(1)
        status(text)
    }

    private func status(_ text: String) {
        onStatus(text)
    }

    /// 登记一条新连接，返回它所属的会话。清掉上一代会话的「已死」标记，并把
    /// 代号 +1 —— 等价于 Android 的 reader.reset()：旧流的残余不会落进新会话。
    /// （本文件没有跨帧累积的读缓冲：readFrame 每次按 4 字节长度 + 整帧读满，
    /// 半帧只会留在旧 fd 的内核缓冲里，随 fd 关闭一起丢弃。）
    @discardableResult
    private func store(fd: Int32) -> Session {
        lock.lock()
        currentFd = fd
        currentGeneration += 1
        sessionClosedFlag = false
        // 新会话：上一代握手没消费掉的回推帧不能漏进来（它属于旧连接）。
        pushedBackFrame = nil
        let session = Session(fd: fd, generation: currentGeneration)
        lock.unlock()
        return session
    }

    // ---- wire helpers ----

    private static func tune(_ fd: Int32) {
        var one: Int32 = 1
        setsockopt(fd, IPPROTO_TCP, TCP_NODELAY, &one, socklen_t(MemoryLayout<Int32>.size))
        var tv = timeval(tv_sec: 15, tv_usec: 0)
        setsockopt(fd, SOL_SOCKET, SO_RCVTIMEO, &tv, socklen_t(MemoryLayout<timeval>.size))
        setsockopt(fd, SOL_SOCKET, SO_SNDTIMEO, &tv, socklen_t(MemoryLayout<timeval>.size))
        /* 对端「不可达」检测（两端都要有：房主不判死，半开 socket 会一直占着
         * 会话，对端的重连只能躺在 backlog 里）。
         *
         * 官方 BTvldC.ADYaiT 用「8 次静默读超时」判死；iOS 不照抄这个计数：
         * 读超时发生时 readFully 已经吃掉半帧头，继续读会把后续字节错位成帧头。
         * 改用内核 keepalive —— 只有在整条连接判死时才返回错误，不会破坏帧边界。
         *
         * 参数取 2s 起探 / 1s 间隔 / 3 次 ≈ 5 秒判死，对齐 Android 的
         * 500ms×8=4s 量级（而不是 macOS 默认的 2 小时）。正常对局里按键帧每
         * 83ms 双向流动，keepalive 探针根本不会触发，所以激进设置在健康链路上
         * 零开销；对端只是应用卡住时内核依然会 ACK，也不会误判。 */
        setsockopt(fd, SOL_SOCKET, SO_KEEPALIVE, &one, socklen_t(MemoryLayout<Int32>.size))
        var idle: Int32 = 2
        setsockopt(fd, IPPROTO_TCP, TCP_KEEPALIVE, &idle, socklen_t(MemoryLayout<Int32>.size))
        var count: Int32 = 3
        setsockopt(fd, IPPROTO_TCP, TCP_KEEPCNT, &count, socklen_t(MemoryLayout<Int32>.size))
        var interval: Int32 = 1
        setsockopt(fd, IPPROTO_TCP, TCP_KEEPINTVL, &interval, socklen_t(MemoryLayout<Int32>.size))
    }

    /// 等 `fd` 可读（不消费任何字节），最多到 `deadline`。`true` = 有数据可读。
    /// 给「可选的握手步骤」加一个短窗口，同时不碰 SO_RCVTIMEO（读超时会吃掉
    /// 半帧头，把后续字节错位成帧头）。
    private static func waitReadable(_ fd: Int32, until deadline: Date) -> Bool {
        let remaining = deadline.timeIntervalSinceNow
        if remaining <= 0 {
            return false
        }
        var set = fd_set()
        fdZero(&set)
        fdSet(fd, &set)
        var tv = timeval(tv_sec: Int(remaining),
                         tv_usec: Int32((remaining - Double(Int(remaining))) * 1_000_000))
        return select(fd + 1, &set, nil, nil, &tv) > 0
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
        // backlog 放到 4（官方 ServerSocket 实际是 50）：房主同一时刻只跑一条
        // 会话，但对端判死重连时可能先连上几条短命连接，队列大一点能让它重连
        // 到的那一条排在队里等 accept，而不是 SYN 被丢、connect 一直等到超时。
        guard bound == 0, listen(fd, 4) == 0 else {
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

    /**
     * Accept loop on a non-blocking socket so 关闭 can break it out.
     * 只认「用户主动断开」：对端掉线后本循环要能继续等它按官方时序重连回来。
     */
    private func acceptLoop(_ listenFd: Int32) throws -> Int32 {
        while true {
            if userClosed {
                throw LinkError(message: "已取消")
            }
            var readSet = fd_set()
            Self.fdZero(&readSet)
            Self.fdSet(listenFd, &readSet)
            var tv = timeval(tv_sec: 0, tv_usec: 250_000)
            let ready = select(listenFd + 1, &readSet, nil, nil, &tv)
            if ready < 0 {
                if errno == EINTR { continue }
                // 监听口被 run()/close() 关掉后这里会是 EBADF：交给调用方按
                // 「所有权已失去」安静退出，别让 select 在死 fd 上空转。
                throw LinkError(message: "联机大厅连接失败")
            }
            if ready == 0 { continue }
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
        if userClosed {
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

    /// type + 一个大端 int32（复位 5、按键 0、倍速 9 都是这个形状，
    /// 官方接收侧要求 `remaining >= 6`，空体会被直接丢掉）。
    private static func intFrame(_ messageType: Int, _ value: Int32) -> [UInt8] {
        [UInt8((messageType >> 8) & 0xFF), UInt8(messageType & 0xFF),
         UInt8(truncatingIfNeeded: value >> 24), UInt8(truncatingIfNeeded: value >> 16),
         UInt8(truncatingIfNeeded: value >> 8), UInt8(truncatingIfNeeded: value)]
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
            if messageType == Self.msgKeys || messageType == Self.msgReset
                || messageType == Self.msgResetLegacy || messageType == Self.msgSpeed {
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
     * slip in; they are dropped here. 官方重连包（type 100）、复位（5/13）与
     * 倍速（9）也可能在握手途中到达，一并吞掉。
     */
    private func nextFrame(_ fd: Int32, want: Int) throws -> [UInt8] {
        while true {
            let frame = try readFrame(fd)
            let messageType = Self.type(frame)
            if messageType == want {
                return frame
            }
            if messageType == Self.msgReconnect || messageType == Self.msgSpeed
                || messageType == Self.msgReady {
                // 迟到的 type 3 ack（C8：可选 ack 只等 2 秒）与重连/倍速一样
                // 属于「握手噪声」，吞掉继续等目标帧。
                continue
            }
            if messageType != Self.msgKeys && messageType != Self.msgReset
                && messageType != Self.msgResetLegacy {
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
            if messageType == Self.msgReconnect || messageType == Self.msgSpeed
                || messageType == Self.msgReady {
                // 迟到的 type 3 ack（C8：可选 ack 只等 2 秒）与重连/倍速一样
                // 属于「握手噪声」，吞掉继续等目标帧。
                continue
            }
            if messageType != Self.msgKeys && messageType != Self.msgReset
                && messageType != Self.msgResetLegacy {
                throw LinkError(message: "对方不是联机大厅会话")
            }
        }
    }

    private static func type(_ frame: [UInt8]) -> Int {
        frame.count < 2 ? -1 : Int(frame[0]) << 8 | Int(frame[1])
    }

    /**
     * 一帧回推缓冲（握手期专用）。
     *
     * 「等 type 3 的 ack」是可选的（AUDIT C8）：官方服务端只读我们的 3，从不
     * 回发。等待期间若对端直接开始发 type 6，这帧不能丢 —— 放回这里，后面的
     * `readState()` 会原样读到它，否则对端存档会被握手吞掉。
     * 只在 session() 之前（握手线程、单线程）读写，不需要加锁。
     */
    private var pushedBackFrame: [UInt8]?

    private func readFrame(_ fd: Int32) throws -> [UInt8] {
        if let frame = pushedBackFrame {
            pushedBackFrame = nil
            return frame
        }
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

    /* 这里曾有 zlibCompress()/adler32()：给 type 6 的存档做 zlib 压缩（手动补
     * 两字节 zlib 头 + Adler-32），因为早期 stateFrame() 发的是压缩包。现在
     * type 6 直接发 mGBA 的原始即时存档（官方 AZkASS:194 也是 int32 长度 +
     * 原样 blob，不压缩），这两个函数已无调用方，删除以免有人误接回去。
     * 注意：Zip.swift 里的 inflate 仍用 COMPRESSION_ZLIB，那一处是按 CRC 试
     * 「带/不带 zlib 头」两种解码，各平台的实测口径不同，与联机协议无关。 */

    private static func message(_ error: Error) -> String {
        (error as? LinkError)?.message ?? "联机大厅连接失败"
    }
}
