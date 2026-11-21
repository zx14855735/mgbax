// mGBA C 桥接层（src/platform/mobile/{mgba_mobile,remote_link,link_lockstep}.h）
// 的 Swift 等价声明。
//
// 与其它 stub 不同，这里的签名是**逐个对照真实头文件抄写的**，所以这部分
// 检查是真实的（参数个数、类型、可选性 모두 与 Clang importer 的结果一致）。
// 不透明结构体指针用 OpaquePointer 表达，与 Clang 对 `struct X*`（未定义体）
// 的导入结果一致。

// MARK: - mgba_mobile.h

public struct BusGameNavState {
    public var idx: Int32
    public var menuAt: Int32
    public var modeDowns: Int32
    public var menuMax: Int32
    public var frame: UInt32
    public var battleHits: UInt32
    public var navOnly: Bool
    public var released: Bool
    public var lastSig: Int32
    public var pulseRemain: Int32
    public var pulseOff: Int32
    public var pulseArm: Int32
    public init() {
        idx = 0; menuAt = 0; modeDowns = 0; menuMax = 0; frame = 0; battleHits = 0
        navOnly = false; released = false; lastSig = 0
        pulseRemain = 0; pulseOff = 0; pulseArm = 0
    }
}

public let MOBILE_AUDIO_HOLD_PITCH: Int32 = 0
public let MOBILE_AUDIO_HOLD_NATIVE: Int32 = 1

public func mgbaMobileBusGameNavInit(_ st: UnsafeMutablePointer<BusGameNavState>!, _ idx: Int32, _ menuAt: Int32, _ modeDowns: Int32) {}
public func mgbaMobileBusGameNavKeys(_ st: UnsafeMutablePointer<BusGameNavState>!, _ g: OpaquePointer!) -> UInt32 { 0 }
public func mgbaMobileBusGameInBattle(_ g: OpaquePointer!) -> Bool { false }
public func mgbaMobileBusGamePeek32(_ g: OpaquePointer!, _ addr: UInt32) -> UInt32 { 0 }
public func mgbaMobileBusGamePeek8(_ g: OpaquePointer!, _ addr: UInt32) -> UInt8 { 0 }

public func mgbaMobileCreate(_ saveDir: UnsafePointer<CChar>!, _ stateDir: UnsafePointer<CChar>!, _ port: UnsafePointer<CChar>!) -> OpaquePointer? { nil }
public func mgbaMobileDestroy(_ emu: OpaquePointer?) {}
public func mgbaMobileLock(_ emu: OpaquePointer?) {}
public func mgbaMobileUnlock(_ emu: OpaquePointer?) {}
public func mgbaMobileLoad(_ emu: OpaquePointer?, _ path: UnsafePointer<CChar>!) -> Bool { false }
public func mgbaMobileSetSaveDirs(_ emu: OpaquePointer?, _ saveDir: UnsafePointer<CChar>!, _ stateDir: UnsafePointer<CChar>!) {}
public func mgbaMobileIsLoaded(_ emu: OpaquePointer?) -> Bool { false }
public func mgbaMobileSetKeys(_ emu: OpaquePointer?, _ keys: UInt32) {}
public func mgbaMobileSetTurbo(_ emu: OpaquePointer?, _ mask: UInt32) {}
public func mgbaMobileLastKeys(_ emu: OpaquePointer?) -> UInt16 { 0 }
public func mgbaMobileRunFrames(_ emu: OpaquePointer?, _ count: Int32) -> Bool { false }
public func mgbaMobileReadAudio(_ emu: OpaquePointer?, _ out: UnsafeMutablePointer<Int16>!, _ maxFrames: Int32) -> Int32 { 0 }
public func mgbaMobileSetAudioOutput(_ emu: OpaquePointer?, _ outRate: Int32) -> Bool { false }
public func mgbaMobileReadAudioOut(_ emu: OpaquePointer?, _ out: UnsafeMutablePointer<Int16>!, _ maxFrames: Int32, _ speed: Double, _ drift: Float) -> Int32 { 0 }
public func mgbaMobileSetAudioConstantPitch(_ emu: OpaquePointer?, _ on: Bool, _ stretch: Double) {}
public func mgbaMobileSetAudioHoldMode(_ emu: OpaquePointer?, _ mode: Int32) {}
public func mgbaMobileWsolaDropped(_ emu: OpaquePointer?) -> Int { 0 }
public func mgbaMobileNativeHoldCuts(_ emu: OpaquePointer?) -> Int { 0 }
public func mgbaMobileSetAudioPaceFps(_ emu: OpaquePointer?, _ fps: Double) {}
public func mgbaMobileResetAudioPace(_ emu: OpaquePointer?) {}
public func mgbaMobileAudioPaceSeeded(_ emu: OpaquePointer?) -> Bool { false }
public func mgbaMobileClearAudio(_ emu: OpaquePointer?) {}
public func mgbaMobileWidth(_ emu: OpaquePointer?) -> Int32 { 0 }
public func mgbaMobileHeight(_ emu: OpaquePointer?) -> Int32 { 0 }
public func mgbaMobileSampleRate(_ emu: OpaquePointer?) -> Int32 { 0 }
public func mgbaMobileFrameNanos(_ emu: OpaquePointer?) -> Int64 { 0 }
public func mgbaMobileCopyVideo(_ emu: OpaquePointer?, _ pixels: UnsafeMutablePointer<UInt32>!, _ stride: Int32) -> Bool { false }
public func mgbaMobileSaveState(_ emu: OpaquePointer?, _ slot: Int32) -> Bool { false }
public func mgbaMobileLoadState(_ emu: OpaquePointer?, _ slot: Int32) -> Bool { false }
public func mgbaMobileSaveStateToMemory(_ emu: OpaquePointer?, _ out: UnsafeMutablePointer<UnsafeMutableRawPointer?>!, _ outSize: UnsafeMutablePointer<Int>!) -> Bool { false }
public func mgbaMobileLoadStateFromMemory(_ emu: OpaquePointer?, _ data: UnsafeRawPointer!, _ size: Int) -> Bool { false }
public func mgbaMobileLoadStateFromMemoryEx(_ emu: OpaquePointer?, _ data: UnsafeRawPointer!, _ size: Int) -> Int32 { 0 }
public func mgbaMobileStateSize(_ emu: OpaquePointer?) -> Int { 0 }
public func mgbaMobileFreeState(_ state: UnsafeMutableRawPointer?) {}
public func mgbaMobileSetRewind(_ emu: OpaquePointer?, _ enabled: Bool) {}
public func mgbaMobileRewind(_ emu: OpaquePointer?, _ seconds: Int32) -> Bool { false }
public func mgbaMobileListVideoLayers(_ emu: OpaquePointer?, _ info: UnsafeMutablePointer<UnsafePointer<mCoreChannelInfo>?>!) -> Int { 0 }
public func mgbaMobileSetVideoLayer(_ emu: OpaquePointer?, _ id: Int, _ enable: Bool) {}
public func mgbaMobileRewindFrames(_ emu: OpaquePointer?, _ frames: Int32) -> Bool { false }
public func mgbaMobileSetMemoryWatch(_ emu: OpaquePointer?, _ addr: UInt32, _ len: UInt32,
                                     _ cb: (@convention(c) (UInt32, UInt32, UnsafeMutableRawPointer?) -> Void)?,
                                     _ ctx: UnsafeMutableRawPointer?) -> Bool { false }
public func mgbaMobileReset(_ emu: OpaquePointer?) {}
public func mgbaMobileTitle(_ emu: OpaquePointer?, _ out: UnsafeMutablePointer<CChar>!, _ outLen: Int) {}
public func mgbaMobileSetInterframe(_ emu: OpaquePointer?, _ enabled: Bool) {}
public func mgbaMobileSetFrameskip(_ emu: OpaquePointer?, _ skip: Int32) {}
public func mgbaMobileSaveFile(_ emu: OpaquePointer?, _ out: UnsafeMutablePointer<CChar>!, _ outLen: Int) {}
public func mgbaMobilePumpLink(_ emu: OpaquePointer?) {}
public func mgbaMobileLinkHost(_ emu: OpaquePointer?, _ port: Int32, _ players: Int32) -> Bool { false }
public func mgbaMobileLinkJoin(_ emu: OpaquePointer?, _ host: UnsafePointer<CChar>!, _ port: Int32, _ players: Int32) -> Bool { false }
public func mgbaMobileLinkHostLocal(_ emu: OpaquePointer?, _ key: Int32, _ players: Int32) -> Bool { false }
public func mgbaMobileLinkJoinLocal(_ emu: OpaquePointer?, _ key: Int32) -> Bool { false }
public func mgbaMobileLinkJoinLocalSlot(_ emu: OpaquePointer?, _ key: Int32, _ slot: Int32) -> Bool { false }
public func mgbaMobileLinkHostLockstep(_ emu: OpaquePointer?, _ key: Int32, _ players: Int32, _ slot: Int32) -> Bool { false }
public func mgbaMobileLinkJoinLockstep(_ emu: OpaquePointer?, _ key: Int32, _ slot: Int32) -> Bool { false }
public func mgbaMobileLinkIsLockstep(_ emu: OpaquePointer?) -> Bool { false }
public func mgbaMobilePoke16(_ emu: OpaquePointer?, _ addr: UInt32, _ value: UInt16) {}
public func mgbaMobilePeek16(_ emu: OpaquePointer?, _ addr: UInt32) -> UInt16 { 0 }
public func mgbaMobileFrameCounter(_ emu: OpaquePointer?) -> UInt32 { 0 }
public func mgbaMobileBusGameStart(_ emu: OpaquePointer?, _ idx: Int32, _ menuAt: Int32, _ modeDowns: Int32) {}
public func mgbaMobileBusGameStop(_ emu: OpaquePointer?) {}
public func mgbaMobileBusGameTick(_ emu: OpaquePointer?) -> UInt32 { 0 }
public func mgbaMobileSioSetInject(_ inject: Bool) {}
// ROOTHUNT2 零注入对照总闸：src/platform/mobile/mgba_mobile.h `void mgbaMobileSetRhOff(bool enabled)`
// Clang importer 导入为 mgbaMobileSetRhOff(_ enabled: Bool)（Bool = C bool）。
public func mgbaMobileSetRhOff(_ enabled: Bool) {}
// ROOTHUNT2 B7 / 方案Y：三端对称控制面 stub
public func mgbaMobileSetBattleRelay(_ enabled: Bool) {}
public func mgbaMobileSetLinkBtcfg(_ enabled: Bool) {}
// ROOTHUNT2 P0/M1：握手态保真 8FFF 旁路门 setter（mgba_mobile.h）
public func mgbaMobileSetHsBypass(_ enabled: Bool) {}
// ROOTHUNT2 路线A：从机握手保持门 setter（mgba_mobile.h）
public func mgbaMobileSetHsHold(_ enabled: Bool) {}
// ROOTHUNT2 路线A：0x2222 启动字 sticky 兜底门 setter（mgba_mobile.h）
public func mgbaMobileSetBlock2222(_ enabled: Bool) {}
// path B：LocalBus 握手字保真 / 2P 钳位门 setter（mgba_mobile.h）
public func mgbaMobileSetBusHsPreserve(_ enabled: Bool) {}
public func mgbaMobileSetLocalBus2p(_ enabled: Bool) {}
// W92 / path B 原生 SIO 字路由门 setter（mgba_mobile.h；三端同名同值默认关）
public func mgbaMobileSetPathBNativeSio(_ enabled: Bool) {}
// M1 seed 崩溃修复：state-rearm 守卫门 setter（mgba_mobile.h）
public func mgbaMobileSetStateRearmGuard(_ enabled: Bool) {}
// P0：LAG 写时拦截禁用门 setter（mgba_mobile.h；true=开拦截吞 LAG）
public func mgbaMobileSetNoLagClear(_ enabled: Bool) {}
// 灰区全开（用户明示解禁）：mgba_mobile.h 声明的 gray_all/gray_lobby_open setter，
// AppDelegate:50/54 调用；typecheck stub 必须补齐，否则全仓 typecheck 报未定义符号。
public func mgbaMobileSetGrayAll(_ enabled: Bool) {}
public func mgbaMobileSetGrayLobbyOpen(_ enabled: Bool) {}
public func mgbaMobileCpuPc(_ emu: OpaquePointer?) -> UInt32 { 0 }
public func mgbaMobileLinkClose(_ emu: OpaquePointer?) {}
public func mgbaMobileLinkStatus(_ emu: OpaquePointer?, _ out: UnsafeMutablePointer<CChar>!, _ outLen: Int) {}
public func mgbaMobileSetSaveType(_ emu: OpaquePointer?, _ type: Int32) {}
public func mgbaMobileDebugCore(_ emu: OpaquePointer?) -> OpaquePointer? { nil }
public func mgbaMobileSetPatches(_ emu: OpaquePointer?, _ enabled: Bool) {}
public func mgbaMobileSetBiosOptions(_ emu: OpaquePointer?, _ useBios: Bool, _ skipIntro: Bool) {}
public func mgbaMobileSetRtc(_ emu: OpaquePointer?, _ mode: Int32, _ epoch: Int64, _ offset: Int64) {}
public func mgbaMobileSetSolar(_ emu: OpaquePointer?, _ level: Int32) {}
public func mgbaMobileSetCartRumble(_ emu: OpaquePointer?, _ enabled: Bool) {}
public func mgbaMobileTakeRumbles(_ emu: OpaquePointer?) -> Int32 { 0 }
public func mgbaMobileSetGbPalette(_ emu: OpaquePointer?, _ colors: UnsafePointer<Int32>!) {}
public func mgbaMobileSetSgbBorders(_ emu: OpaquePointer?, _ enabled: Bool) {}
public func mgbaMobileSetChannelVolumes(_ emu: OpaquePointer?, _ gains: UnsafePointer<Int32>!) {}
public func mgbaMobileSetRotation(_ emu: OpaquePointer?, _ tiltX: Float, _ tiltY: Float, _ gyroZ: Float) {}
public func mgbaMobileCheatCount(_ emu: OpaquePointer?) -> Int32 { 0 }
public func mgbaMobileCheatName(_ emu: OpaquePointer?, _ index: Int32, _ out: UnsafeMutablePointer<CChar>!, _ outLen: Int) {}
public func mgbaMobileCheatEnabled(_ emu: OpaquePointer?, _ index: Int32) -> Bool { false }
public func mgbaMobileCheatSetEnabled(_ emu: OpaquePointer?, _ index: Int32, _ enabled: Bool) {}
public func mgbaMobileCheatAdd(_ emu: OpaquePointer?, _ name: UnsafePointer<CChar>!, _ lines: UnsafePointer<CChar>!, _ type: Int32) -> Bool { false }
public func mgbaMobileCheatRemove(_ emu: OpaquePointer?, _ index: Int32) -> Bool { false }
public func mgbaMobileBusRead(_ emu: OpaquePointer?, _ width: Int32, _ address: UInt32) -> UInt32 { 0 }
public func mgbaMobileBusWrite(_ emu: OpaquePointer?, _ width: Int32, _ address: UInt32, _ value: UInt32) -> Bool { false }
public func mgbaMobileBusReadBlock(_ emu: OpaquePointer?, _ address: UInt32, _ size: Int32, _ out: UnsafeMutablePointer<UInt8>!) -> Int32 { 0 }
public func mgbaMobileResample(_ `in`: UnsafePointer<Int16>!, _ inFrames: Int32, _ inRate: Int32, _ outRate: Int32,
                               _ out: UnsafeMutablePointer<Int16>!, _ maxOutFrames: Int32,
                               _ pos: UnsafeMutablePointer<Double>!) -> Int32 { 0 }
public func mgbaMobileSetAudioClock(_ emu: OpaquePointer?, _ clock: (@convention(c) () -> Double)?) {}
public func mgbaMobileHasSyntheticAudioClock(_ emu: OpaquePointer?) -> Bool { false }
public func mgbaMobileUnstickStep(_ emu: OpaquePointer?, _ mode: Int32, _ matched: Bool) -> Int32 { 0 }
public func mgbaMobileBiosFileName(_ name: UnsafePointer<CChar>!, _ size: Int, _ out: UnsafeMutablePointer<CChar>!, _ outLen: Int) {}

// mCoreChannelInfo：mgba_mobile.h 直接 include 了 <mgba/core/interface.h>，
// 四个字段按核心头声明（id / internalName / visibleName / visibleType）。
public struct mCoreChannelInfo {
    public var id: Int
    public var internalName: UnsafePointer<CChar>?
    public var visibleName: UnsafePointer<CChar>?
    public var visibleType: UnsafePointer<CChar>?
    public init() { id = 0; internalName = nil; visibleName = nil; visibleType = nil }
}

// MARK: - remote_link.h

public let MGBA_LINK_PORT: Int32 = 18765
public let MGBA_RELAY_PORT: Int32 = 8766

public struct MobileRelayHooks {
    public var user: UnsafeMutableRawPointer?
    public var onStatus: (@convention(c) (UnsafeMutableRawPointer?, UnsafePointer<CChar>?) -> Void)?
    public var onRoom: (@convention(c) (UnsafeMutableRawPointer?, UnsafePointer<CChar>?, UnsafePointer<CChar>?) -> Void)?
    public var hostLink: (@convention(c) (UnsafeMutableRawPointer?, Int32) -> Bool)?
    public var joinLink: (@convention(c) (UnsafeMutableRawPointer?, UnsafePointer<CChar>?, Int32) -> Bool)?
    public var closeLink: (@convention(c) (UnsafeMutableRawPointer?) -> Void)?
    public init() {
        user = nil; onStatus = nil; onRoom = nil
        hostLink = nil; joinLink = nil; closeLink = nil
    }
}

public func mobileRelayCreate(_ hooks: MobileRelayHooks) -> OpaquePointer? { nil }
public func mobileRelayDestroy(_ relay: OpaquePointer?) {}
public func mobileRelayCreateRoom(_ relay: OpaquePointer?, _ relayField: UnsafePointer<CChar>!, _ localIp: UnsafePointer<CChar>!) {}
public func mobileRelayJoinRoom(_ relay: OpaquePointer?, _ relayField: UnsafePointer<CChar>!, _ code: UnsafePointer<CChar>!) {}
public func mobileRelayClose(_ relay: OpaquePointer?) {}

// MARK: - link_lockstep.h

public func mgbaLockstepHost(_ key: Int32, _ players: Int32) -> OpaquePointer? { nil }
public func mgbaLockstepJoin(_ key: Int32) -> OpaquePointer? { nil }
public func mgbaLockstepAttach(_ room: OpaquePointer?, _ core: OpaquePointer?, _ slot: Int32) -> OpaquePointer? { nil }
public func mgbaLockstepRunFrame(_ slot: OpaquePointer?, _ core: OpaquePointer?) {}
public func mgbaLockstepDetach(_ slot: OpaquePointer?) {}
public func mgbaLockstepRelease(_ room: OpaquePointer?) {}
public func mgbaLockstepAttached(_ room: OpaquePointer?) -> Int { 0 }
public func mgbaLockstepSlotId(_ slot: OpaquePointer?) -> Int32 { 0 }
public func mgbaLockstepPaused(_ slot: OpaquePointer?) -> Bool { false }
public func mgbaLockstepUserSleep(_ slot: OpaquePointer?) {}
public func mgbaLockstepUserWake(_ slot: OpaquePointer?) {}
public func mgbaLockstepSetAbort(_ abort: Int32) {}
