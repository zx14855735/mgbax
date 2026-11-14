import Foundation

/**
 * 进程内 N 核锁步控制台集合 —— iOS 版 GBoyConsoleSet(useLockstep=true)。
 *
 * 与 Android / PC 走完全相同的 C API：mgbaMobileLinkHostLockstep /
 * LinkJoinLockstep 把「可见核 + players-1 个镜像核」挂进同一个
 * GBASIOLockstepCoordinator 房间；SIO 只在进程内会合，网络依旧只传按键。
 * 槽位分配逐行对齐 GBoyConsoleSet.java：host 恒 0，可见核占 localSlot-1，
 * 其余按空闲槽位填充。
 *
 * 非 lockstep 模式仍走 iOS 原有的单核跨设备联机（mgbaMobileLinkHost/Join），
 * 本类只在显式勾选「本机多核锁步」或云端对战武装时创建；2/3/4 人均支持
 * （与 Android 2026-11-13 修复后的行为一致）。云端 2P（官方镜像布局）由
 * EmulatorViewController 在 onConnected 后重载 ROM 并以 players=4、
 * localSlot=1 重建本类（每端 1 可见核 + 3 镜像核：大竞技场要求 4 名玩家，
 * slot 2 = 对手真人按键、slot 3/4 = NPC 陪位），两端同构——网络只传按键，
 * 对端按键落 slot 2 镜像核。
 *
 * 镜像线程自由推进（不按帧放行、不 sleep）：native 协调器在 SIO 传输轮次
 * 上会合各核，跑太快的核会被 park 住等最慢者，这正是锁步语义。
 *
 * 已知限制：Windows 上只做过 swiftc -parse；Xcode 类型检查由 GitHub
 * Actions macOS runner（mgbax 仓 ios-build）承担，真机 60fps 与进对战
 * 待真机验证。远端按键由 LobbyLink/GBoyLink 的 onRemoteKeysForSlot
 * 按帧类型解析成全局槽位后调用 setRemoteKeys(slot:mask:)。
 */
final class GBoyConsoleSet {
    private let romPath: String
    private let saveDir: String
    private let stateDir: String
    private let players: Int
    private let localSlot: Int
    private let roomKey: Int32

    /// index 0 = 可见核（外部持有，本类不销毁），1..players-1 = 镜像核
    private var cores: [OpaquePointer?] = []
    private var slotOfCore: [Int] = []
    private var mirrorThreads: [Thread] = []
    private var finished: [DispatchSemaphore] = []
    private var remoteKeys: [UInt32]
    /// 待灌进镜像核 1（= 槽位 2，对端那个玩家）的整份存档。由网络线程入队，
    /// 镜像线程在帧边界取走 —— 在别的线程直接 loadState 会与 runFrames 抢核。
    private var pendingRemoteState: [UInt8]?
    private var visibleCore: OpaquePointer?
    private var running = false
    private let lock = NSLock()
    /// 镜像帧钟：targetFrame=可见核已发布帧位，mirrorFrames=各镜像已跑帧。
    private let frameCond = NSCondition()
    private var targetFrame: Int = -1
    private var frameEpoch: Int = -1
    private var mirrorFrames: [Int] = []

    // MARK: - 初始存档缓存（与 Android d09514f9b 同构）

    /// 整轮联机只取一次初始存档：两次 start() 之间游戏可能保存并写回电池
    /// 存档，重读会得到不同进度（Android 实测 mirror1 与 mirror2/3 分叉，
    /// idx=1 卡在保存菜单、SIO 不启动、pc 恒 0）。缓存后每次 start() 都
    /// 无条件回写主存档 + ROM 旁路存档，可见核 reload 与镜像核冷启动读到
    /// 的字节完全相同。
    private static let snapshotLock = NSLock()
    private static var sInitialSnapshot: Data?

    /// 新一轮 ROM 加载时清掉上一轮的快照缓存（云端重挂路径已在重载前把
    /// 缓存写回 canonical 路径，这里的清空让它重新读到的就是同一份字节）。
    static func resetInitialSaveSnapshot() {
        snapshotLock.lock()
        sInitialSnapshot = nil
        snapshotLock.unlock()
    }

    /// 可见核重载 ROM 前把缓存的初始存档写回 saveDir，抹掉游戏期间写回的
    /// 进度。云重挂的 reload 与重建房间之间若不回写，可见核会读到新进度、
    /// 镜像核读缓存，四核相位立刻分叉。
    static func restoreInitialSaveSnapshot(romPath: String, saveDir: String) {
        snapshotLock.lock()
        let snap = sInitialSnapshot
        snapshotLock.unlock()
        guard let snap, !romPath.isEmpty, !saveDir.isEmpty else { return }
        let base = URL(fileURLWithPath: romPath).deletingPathExtension().lastPathComponent
        let target = URL(fileURLWithPath: saveDir, isDirectory: true)
            .appendingPathComponent(base + ".sav")
        do {
            try snap.write(to: target)
        } catch {
            NSLog("GBOY_RT restore save snapshot failed: %@", target.path)
        }
    }

    init?(romPath: String, saveDir: String, stateDir: String,
          players: Int, localSlot: Int, roomKey: Int32 = 0x4C53) {
        guard (2...4).contains(players), (1...players).contains(localSlot),
              !romPath.isEmpty, !saveDir.isEmpty, !stateDir.isEmpty else { return nil }
        self.romPath = romPath
        self.saveDir = saveDir
        self.stateDir = stateDir
        self.players = players
        self.localSlot = localSlot
        self.roomKey = roomKey
        self.remoteKeys = [UInt32](repeating: 0, count: players)
    }

    /// 启动 N 核锁步房间。成功返回 nil，失败返回可展示的错误信息。
    /// visible 必须已加载 ROM；本类不会销毁它，只在 stop() 时卸下它的链路。
    func start(visible: OpaquePointer) -> String? {
        lock.lock()
        let already = running
        lock.unlock()
        if already { return "多核心会话已在运行" }

        visibleCore = visible
        let count = players - 1
        cores = [visible] + [OpaquePointer?](repeating: nil, count: count)
        let romName = URL(fileURLWithPath: romPath).deletingPathExtension().lastPathComponent
        let fm = FileManager.default

        // 初始存档快照（缓存一次、整轮复用）：主存档路径以可见核当前配置
        // 为准（mgbaMobileSaveFile），缺席时回落 saveDir。读到后回写主存档
        // 与 ROM 旁路 canonical 路径，保证 reload 与镜像冷启动同一份字节。
        var primarySave: String?
        var saveBuf = [CChar](repeating: 0, count: 1200)
        mgbaMobileSaveFile(visible, &saveBuf, 1200)
        let nativeSave = String(cString: saveBuf)
        if !nativeSave.isEmpty, fm.fileExists(atPath: nativeSave) {
            primarySave = nativeSave
        }
        if primarySave == nil {
            let fallback = (saveDir as NSString).appendingPathComponent(romName + ".sav")
            if fm.fileExists(atPath: fallback) {
                primarySave = fallback
            }
        }
        GBoyConsoleSet.snapshotLock.lock()
        if GBoyConsoleSet.sInitialSnapshot == nil, let source = primarySave {
            GBoyConsoleSet.sInitialSnapshot = try? Data(contentsOf: URL(fileURLWithPath: source))
        }
        let saveSnapshot = GBoyConsoleSet.sInitialSnapshot
        GBoyConsoleSet.snapshotLock.unlock()
        if let snapshot = saveSnapshot {
            if let target = primarySave {
                try? snapshot.write(to: URL(fileURLWithPath: target))
            }
            let canonical = URL(fileURLWithPath: romPath).deletingLastPathComponent()
                .appendingPathComponent(romName + ".sav")
            if canonical.path != primarySave {
                try? snapshot.write(to: canonical)
            }
        }
        NSLog("GBOY_RT save snapshot path=%@ bytes=%ld cached=yes",
              primarySave ?? "null", saveSnapshot.map { $0.count } ?? -1)

        // 镜像核从可见核存档的快照启动，保证 4 核初始状态一致（同 Android
        // GBoyConsoleSet.copyPrimarySave）。
        for i in 1...count {
            let mirrorSave = (saveDir as NSString).appendingPathComponent("mirror\(i)")
            let mirrorState = (stateDir as NSString).appendingPathComponent("mirror\(i)")
            do {
                try fm.createDirectory(atPath: mirrorSave, withIntermediateDirectories: true)
                try fm.createDirectory(atPath: mirrorState, withIntermediateDirectories: true)
            } catch {
                cleanupCores()
                return "无法创建镜像存档目录 \(i): \(error.localizedDescription)"
            }
            let target = (mirrorSave as NSString).appendingPathComponent(romName + ".sav")
            if let snapshot = saveSnapshot {
                try? fm.removeItem(atPath: target)
                try? snapshot.write(to: URL(fileURLWithPath: target))
            }
            guard let core = mgbaMobileCreate(mirrorSave, mirrorState, "iosmirror\(i)") else {
                cleanupCores()
                return "镜像核心 \(i + 1) 创建失败"
            }
            guard mgbaMobileLoad(core, romPath) else {
                mgbaMobileDestroy(core)
                cleanupCores()
                return "镜像核心 \(i + 1) 加载 ROM 失败"
            }
            // BIOS 阶段先不挂锁步驱动：开机 SIO 探测会误判成多启动而卡住。
            for _ in 0..<60 { _ = mgbaMobileRunFrames(core, 1) }
            cores[i] = core
        }

        // host 恒占槽位 0；localSlot > 1 时让第一个镜像核当 host，可见核
        // join 到 localSlot-1，其余镜像核按空闲槽位填。与 Android 一致。
        var taken = [Bool](repeating: false, count: players)
        slotOfCore = [Int](repeating: 0, count: players)
        let hostIdx = localSlot > 1 ? 1 : 0
        slotOfCore[hostIdx] = 0
        taken[0] = true
        if hostIdx != 0 {
            slotOfCore[0] = localSlot - 1
            taken[localSlot - 1] = true
        }
        var next = 1
        for k in 0..<players {
            if k == hostIdx || (k == 0 && hostIdx != 0) { continue }
            while next < players && taken[next] { next += 1 }
            slotOfCore[k] = next
            taken[next] = true
        }

        guard let host = cores[hostIdx],
              mgbaMobileLinkHostLockstep(host, roomKey, Int32(players), 0) else {
            cleanupCores()
            return "进程内锁步房间创建失败: key=\(roomKey)"
        }
        for k in 0..<players where k != hostIdx {
            guard let core = cores[k],
                  mgbaMobileLinkJoinLockstep(core, roomKey, Int32(slotOfCore[k])) else {
                cleanupCores()
                return "镜像核心无法接入锁步房间 slot=\(slotOfCore[k])"
            }
        }

        lock.lock()
        running = true
        lock.unlock()
        // 镜像帧钟：可见核每帧 beginFrame 推高 targetFrame（天花板），镜像
        // 追平即等、来了就一口气追平。没有它镜像会在无 SIO 轮的菜单期以
        // CPU 全速冲到比可见核多几万帧——四核游戏时钟错位，联机握手永远
        // 凑不齐 4 家（Android 侧同坑实测 pc=3 卡死）。
        frameCond.lock()
        // 按 players 建数组：镜像线程沿用 cores 的下标（1..players-1），
        // 按 count 建会让 idx=3 越界 abort（实测 CI 崩在这）。
        mirrorFrames = [Int](repeating: -1, count: players)
        targetFrame = -1
        frameEpoch = -1
        frameCond.unlock()
        for i in 1...count {
            let sem = DispatchSemaphore(value: 0)
            finished.append(sem)
            let index = i
            let thread = Thread { [weak self] in
                defer { sem.signal() }
                while let self = self, self.isRunning {
                    // 等天花板：追平即等（250ms 超时兜底，isRunning 翻转可退）。
                    self.frameCond.lock()
                    while self.isRunning && self.mirrorFrames[index] >= self.targetFrame {
                        self.frameCond.wait(until: Date().addingTimeInterval(0.25))
                    }
                    let ceiling = self.targetFrame
                    self.frameCond.unlock()
                    guard self.isRunning else { break }
                    guard let core = self.cores[index] else { break }
                    /* 对端存档：只喂镜像核 1（= 全局槽位 2，代表对端玩家），
                     * 而且只在帧边界载入。与 Android GBoyConsoleSet.applyRemoteState
                     * / PC GBoyMirror.applyRemoteState 同一条规则：绝不喂可见核
                     * （那是本机玩家自己的进度），也绝不喂 slot 3/4 的 NPC 陪位。 */
                    if index == 1 {
                        self.lock.lock()
                        let pending = self.pendingRemoteState
                        self.pendingRemoteState = nil
                        self.lock.unlock()
                        if let state = pending, !state.isEmpty {
                            let ok = state.withUnsafeBytes { raw in
                                mgbaMobileLoadStateFromMemory(core, raw.baseAddress, raw.count)
                            }
                            // %ld 而不是 %d：NSLog 的 Int 参数是 64 位，%d 只取低
                            // 32 位，字节数一过 2GB 就打印错值（varargs 未定义）。
                            NSLog("GBOY_RT peer state applied bytes=%ld ok=%ld",
                                  state.count, ok ? 1 : 0)
                        }
                    }
                    var done = self.mirrorFrames[index]
                    while self.isRunning && done < ceiling {
                        let slot = self.slotOfCore[index]
                        self.lock.lock()
                        let keys = self.remoteKeys[slot]
                        self.lock.unlock()
                        mgbaMobileSetKeys(core, keys)
                        _ = mgbaMobileRunFrames(core, 1)
                        done += 1
                        if done == 600 {
                            // 运行时验证标记：镜像核稳定推进 600 帧（CI 检查点）。
                            NSLog("GBOY_RT mirror idx=%d frames=600 ok", index)
                        }
                        self.frameCond.lock()
                        self.mirrorFrames[index] = done
                        self.frameCond.unlock()
                    }
                }
            }
            thread.name = "mGBA-ios-console-\(i + 1)"
            thread.stackSize = 1 << 20
            mirrorThreads.append(thread)
            thread.start()
        }
        return nil
    }

    /// 可见核每帧调用：推高镜像帧钟天花板（frame 作全局帧号，首次调用定纪元）。
    func beginFrame(_ frame: Int) {
        lock.lock()
        let wasRunning = running
        lock.unlock()
        guard wasRunning else { return }
        frameCond.lock()
        if frameEpoch < 0 {
            frameEpoch = frame
        }
        let rel = max(0, frame - frameEpoch)
        if rel > targetFrame {
            targetFrame = rel
            frameCond.broadcast()
        }
        frameCond.unlock()
    }

    /// 镜像帧钟是否已在推进（可见核循环据此决定是否发布 beginFrame）。
    var isReady: Bool {
        lock.lock()
        defer { lock.unlock() }
        return running
    }

    /// 把某个全局槽位的远端按键掩码喂给对应的镜像核（网络只传按键）。
    func setRemoteKeys(slot: Int, mask: UInt32) {
        guard (0..<players).contains(slot) else { return }
        lock.lock()
        remoteKeys[slot] = mask
        lock.unlock()
    }

    /// 收到对端 type 6 的整份存档：入队，由镜像线程在帧边界载入。
    /// 只作用于镜像核 1（槽位 2 = 对端玩家）；可见核与 NPC 陪位都不碰。
    /// 与 Android `GBoyConsoleSet.applyRemoteState` 同一规则。
    @discardableResult
    func applyRemoteState(_ state: [UInt8]) -> Bool {
        guard !state.isEmpty, cores.count > 1 else { return false }
        lock.lock()
        pendingRemoteState = state
        lock.unlock()
        return true
    }

    /// 可见核的即时存档快照（TYPE_STATE 来源，与 Android snapshotState()
    /// 同义）。C 侧 helper 自带 per-instance 核锁，跨线程安全。
    func snapshotState() -> Data? {
        lock.lock()
        let core = visibleCore
        lock.unlock()
        guard let core else { return nil }
        var blob: UnsafeMutableRawPointer?
        var size = 0
        guard mgbaMobileSaveStateToMemory(core, &blob, &size),
              let ptr = blob, size > 0 else { return nil }
        let data = Data(bytes: UnsafeRawPointer(ptr), count: size)
        mgbaMobileFreeState(ptr)
        return data
    }

    /// 说明：这里**故意只提供**上面那个入队版本。以前还有一个
    /// `applyRemoteState(_ state: Data)`，在调用线程上把存档直接灌进
    /// 1..<cores.count 的**全部**镜像核：既和正在跑帧的镜像线程抢核，
    /// 又把 slot 3/4 的 NPC 陪位进度覆盖成对端的（GBoy 的 type 6 只灌
    /// 「代表该玩家」的那一颗，见 NETPLAY_SPEC.md 第 6 节第 7 行）。
    /// 已删除，避免再被误用；需要整份状态请走 `applyRemoteState([UInt8])`。

    func stop() {
        lock.lock()
        let wasRunning = running
        running = false
        lock.unlock()
        guard wasRunning else { return }

        // 唤醒帧钟等待者（镜像线程在等天花板时能感知 isRunning 翻转退出）。
        frameCond.lock()
        frameCond.broadcast()
        frameCond.unlock()
        // 唤醒仍 park 在等 SIO 事件的核，避免 stop() 卡死在线程收尾上。
        mgbaLockstepSetAbort(1)
        for sem in finished {
            _ = sem.wait(timeout: .now() + 3)
        }
        mgbaLockstepSetAbort(0)
        mirrorThreads.removeAll()
        finished.removeAll()
        for i in 1..<cores.count {
            if let core = cores[i] {
                mgbaMobileLinkClose(core)
                mgbaMobileDestroy(core)
            }
        }
        if let visible = visibleCore {
            mgbaMobileLinkClose(visible)   // 只卸链路，可见核仍归调用方所有
        }
        cores.removeAll()
        slotOfCore.removeAll()
        visibleCore = nil
    }

    private var isRunning: Bool {
        lock.lock()
        defer { lock.unlock() }
        return running
    }

    private func cleanupCores() {
        for i in 1..<cores.count {
            if let core = cores[i] {
                mgbaMobileLinkClose(core)
                mgbaMobileDestroy(core)
            }
        }
        if let visible = visibleCore {
            mgbaMobileLinkClose(visible)
        }
        cores.removeAll()
        slotOfCore.removeAll()
        visibleCore = nil
    }
}
