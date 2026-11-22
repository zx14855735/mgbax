

@main
final class AppDelegate: UIResponder, UIApplicationDelegate {
    func application(_ application: UIApplication, didFinishLaunchingWithOptions launchOptions: [UIApplication.LaunchOptionsKey: Any]?) -> Bool {
        let docs = FileManager.default.urls(for: .documentDirectory, in: .userDomainMask)[0]
        let config = docs.appendingPathComponent("config", isDirectory: true)
        for name in ["saves", "states", "roms", "config/mgba"] {
            try? FileManager.default.createDirectory(at: docs.appendingPathComponent(name, isDirectory: true), withIntermediateDirectories: true)
        }
        setenv("HOME", docs.path, 1)
        setenv("XDG_CONFIG_HOME", config.path, 1)
        // ROOTHUNT2 零注入对照总闸：iOS 无 setprop，须在首个 SIO linkPoll 前显式设。
        // 支持环境变量 MGBAX_RH_OFF（实验注入）或 UserDefaults key "mgbax.link.rh_off"。
        let rhOff = (getenv("MGBAX_RH_OFF").flatMap { String(cString: $0) } == "1")
            || UserDefaults.standard.bool(forKey: "mgbax.link.rh_off")
        mgbaMobileSetRhOff(rhOff)
        // ROOTHUNT2 B7 战斗期块中继灰度门：iOS 无 setprop，须显式设。
        let relay = (getenv("MGBAX_BATTLE_RELAY").flatMap { String(cString: $0) } == "1")
            || UserDefaults.standard.bool(forKey: "mgbax.link.battle_relay")
        mgbaMobileSetBattleRelay(relay)
        // ROOTHUNT2 方案Y：iOS 无 setprop，显式设 var8004 恢复门。
        let btcfg = (getenv("MGBAX_LINK_BTLCFG").flatMap { String(cString: $0) } == "1")
            || UserDefaults.standard.bool(forKey: "mgbax.link.link_btcfg")
        mgbaMobileSetLinkBtcfg(btcfg)
        // ROOTHUNT2 P0/M1：握手态保真 8FFF 旁路门，默认开；显式 env=0 或
        // UserDefaults false 秒回退（与 PC MGBAX_LINK_HSBYPASS 语义一致）。
        let hsBypassEnv = getenv("MGBAX_LINK_HSBYPASS").flatMap { String(cString: $0) }
        let hsBypass = UserDefaults.standard.object(forKey: "mgbax.link.hs_bypass") as? Bool
            ?? (hsBypassEnv.map { $0 != "0" } ?? true)
        mgbaMobileSetHsBypass(hsBypass)
        // ROOTHUNT2 路线A：从机握手保持门（推真 B9A0 + 窗口重装），默认开；
        // 显式 env=0 或 UserDefaults false 秒回退（与 PC MGBAX_HS_HOLD 语义一致）。
        let hsHoldEnv = getenv("MGBAX_HS_HOLD").flatMap { String(cString: $0) }
        let hsHold = UserDefaults.standard.object(forKey: "mgbax.link.hs_hold") as? Bool
            ?? (hsHoldEnv.map { $0 != "0" } ?? true)
        mgbaMobileSetHsHold(hsHold)
        // ROOTHUNT2 路线A：0x2222 启动字 sticky 兜底门，默认开；显式 env=0 或
        // UserDefaults false 秒回退（与 PC MGBAX_2222_STICKY 语义一致）。
        let b2222Env = getenv("MGBAX_2222_STICKY").flatMap { String(cString: $0) }
        let b2222 = UserDefaults.standard.object(forKey: "mgbax.link.block2222_sticky") as? Bool
            ?? (b2222Env.map { $0 != "0" } ?? true)
        mgbaMobileSetBlock2222(b2222)
        // path B：LocalBus 握手字保真门，默认开；显式 env=0 / UserDefaults false 秒回退。
        let busHsEnv = getenv("MGBAX_BUS_HS_PRESERVE").flatMap { String(cString: $0) }
        let busHs = UserDefaults.standard.object(forKey: "mgbax.link.bus_hs_preserve") as? Bool
            ?? (busHsEnv.map { $0 != "0" } ?? true)
        mgbaMobileSetBusHsPreserve(busHs)
        // path B：2P 不被钳成 3 门，默认关；显式 env=1 / UserDefaults true 开启。
        let lb2p = (getenv("MGBAX_LOCALBUS_2P").flatMap { String(cString: $0) } == "1")
            || UserDefaults.standard.bool(forKey: "mgbax.link.localbus_2p")
        mgbaMobileSetLocalBus2p(lb2p)
        // W92 / path B 原生 SIO 字路由门，默认关；显式 env=1 / UserDefaults true 开启。
        // 与 PC MGBAX_PATHB_NATIVE_SIO / Android debug.mgbax.link.pathb_native_sio 同名同值。
        // 门开只改握手字投递路由、禁写真握手字、sidecar 早退；不造 party/信任位/CROSSED。
        // 须在首个 SIO linkPoll 前设；门开≠成功，CROSSED 仍为唯一裁决。
        let pathBNativeSio = (getenv("MGBAX_PATHB_NATIVE_SIO").flatMap { String(cString: $0) } == "1")
            || UserDefaults.standard.bool(forKey: "mgbax.link.pathb_native_sio")
        mgbaMobileSetPathBNativeSio(pathBNativeSio)
        // M1 seed 崩溃修复：state-rearm 守卫门，默认关（关=复现崩溃便于A/B，开=修复）。
        let rearmGuard = (getenv("MGBAX_STATE_REARM_GUARD").flatMap { String(cString: $0) } == "1")
            || UserDefaults.standard.bool(forKey: "mgbax.link.state_rearm_guard")
        mgbaMobileSetStateRearmGuard(rearmGuard)
        // P0：LAG 写时拦截禁用门（与 PC MGBAX_NO_LAG_CLEAR 同名同值）。缺省吞 LAG；
        // 显式 env=1 / UserDefaults true = 关拦截（复现真实 LAG 拆链，A/B 对照）。
        let noLag = (getenv("MGBAX_NO_LAG_CLEAR").flatMap { String(cString: $0) } == "1")
            || UserDefaults.standard.bool(forKey: "mgbax.link.no_lag_clear")
        mgbaMobileSetNoLagClear(!noLag)
        // ROOTHUNT2 灰区全开（§3.5 用户明示「全部解禁」）：一次性打开合法 7 类灰区
        // （C3直写gLinkOpen / seat-assist手建task / rearm / RHSLVINJ写真字 /
        //  RHBRS强写brs / var8004补写 / rem-restore）。默认关；env=1 或 UserDefaults true 开启。
        // 红线（造 party/手写 nr=FALSE 或 lp0→lp1/伪造 CROSSED/造 species）不随此放开。
        let grayAll = (getenv("MGBAX_GRAY_ALL").flatMap { String(cString: $0) } == "1")
            || UserDefaults.standard.bool(forKey: "mgbax.link.gray_all")
        mgbaMobileSetGrayAll(grayAll)
        // C3 大厅态 cb2 战斗启动窗门绕过（独立门，被 GrayAll 蕴含，也可单独开）。
        let grayLobby = (getenv("MGBAX_GRAY_LOBBY_OPEN").flatMap { String(cString: $0) } == "1")
            || UserDefaults.standard.bool(forKey: "mgbax.link.gray_lobby_open")
        mgbaMobileSetGrayLobbyOpen(grayLobby)
        // ISYNC1: 输入同步 TYPE_STATE seed applied 门（三端同名
        // MGBAX_ISYNC_STATE_APPLY，默认关）。iOS 无 setprop，用 env=1 或
        // UserDefaults "mgbax.link.isync_state_apply" true 开启。这是 App 层
        // 诊断/编排门（控制有界重试与里程碑日志），不是 native C 门，故不新增
        // mgbaMobileSet* C setter，CCore.swift stub 无需改动。
        let isyncStateApply = (getenv("MGBAX_ISYNC_STATE_APPLY").flatMap { String(cString: $0) } == "1")
            || UserDefaults.standard.bool(forKey: "mgbax.link.isync_state_apply")
        ISyncGate.stateApply = isyncStateApply
        // GENTRIAD: 代次 hygiene 独立门 MGBAX_ISYNC_SEED_FRAME_BOUNDARY（三端同名
        // 同值、默认关）。env=1 或 UserDefaults "mgbax.link.isync_seed_frame_boundary"
        // 开启；只控制 stale 丢弃日志与 (hash,gen) applied_count，非内存安全守卫。
        let isyncSeedFrameBoundary =
            (getenv("MGBAX_ISYNC_SEED_FRAME_BOUNDARY").flatMap { String(cString: $0) } == "1")
            || UserDefaults.standard.bool(forKey: "mgbax.link.isync_seed_frame_boundary")
        ISyncGate.seedFrameBoundary = isyncSeedFrameBoundary
        return true
    }

    func application(_ application: UIApplication, configurationForConnecting connectingSceneSession: UISceneSession, options: UIScene.ConnectionOptions) -> UISceneConfiguration {
        let config = UISceneConfiguration(name: "Default", sessionRole: connectingSceneSession.role)
        config.delegateClass = SceneDelegate.self
        return config
    }
}

final class SceneDelegate: UIResponder, UIWindowSceneDelegate {
    var window: UIWindow?

    func scene(_ scene: UIScene, willConnectTo session: UISceneSession, options connectionOptions: UIScene.ConnectionOptions) {
        guard let windowScene = scene as? UIWindowScene else { return }
        let window = UIWindow(windowScene: windowScene)
        let controller = EmulatorViewController()
        window.rootViewController = controller
        window.makeKeyAndVisible()
        self.window = window
        controller.loadViewIfNeeded()
        // Launching straight from "用 mGBA 打开" in the Files app.
        if let url = connectionOptions.urlContexts.first?.url {
            controller.openExternal(url)
        }
    }

    func scene(_ scene: UIScene, openURLContexts URLContexts: Set<UIOpenURLContext>) {
        guard let url = URLContexts.first?.url else { return }
        guard let controller = window?.rootViewController as? EmulatorViewController else { return }
        if url.scheme?.lowercased() == "mgba" {
            controller.handleDebugURL(url)
            return
        }
        controller.openExternal(url)
    }
}
