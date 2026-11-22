/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
#ifndef MGBA_MOBILE_H
#define MGBA_MOBILE_H

#include <stdbool.h>
#include <stddef.h>
#include <stdint.h>

/* mCoreChannelInfo 以核心头为准（id / internalName / visibleName /
 * visibleType 四个字段）。这里真 include 而不是前向声明，避免前端各自
 * 手抄一份同布局结构体、core 改字段时静默错位。 */
#include <mgba/core/interface.h>

/* 【RACE_STRESS 压测造窗门 — 三端同名同值，默认关】
 * 合法的时序压测工具：只在 native load 调用前注入可控 sleep，拉宽
 * apply(主线程 load) vs destroy(模拟线程 free) 的 TOCTOU 易损段，用于复现/
 * 对照 CRASH5 竞态窗口。只加时序延时，不改 party/RAM/握手字/信任位/CROSSED/
 * species，不补灌 —— 与「改游戏态」的灰区有本质区别。
 * 压测轮产物/日志/CROSSED 必须标注「应力诱导、非自然时序、CROSSED 可信度
 * 存疑、非纯零注入」，绝不进裁决轮。
 *   Android : 读 prop  debug.mgbax.link.race_stress（driver 下发，值按 ms 解释）
 *   iOS     : 共享本 C 自动对称（门默认关，延时仅观测）
 *   PC / Qt : 读 env   MGBAX_RACE_STRESS（no-op readback，不注入延时）
 * 与根治门 MGBAX_ISYNC_SEED_FRAME_BOUNDARY 正交独立。 */
#ifndef MGBAX_RACE_STRESS
#define MGBAX_RACE_STRESS 0
#endif
/* 符号自检：门值只能是 0/1，防三端口径漂移；编译期拦截误配。 */
#if MGBAX_RACE_STRESS != 0 && MGBAX_RACE_STRESS != 1
#error "MGBAX_RACE_STRESS must be 0 or 1"
#endif
#define MGBAX_RACE_STRESS_ENV    "MGBAX_RACE_STRESS"
#define MGBAX_RACE_STRESS_PROP   "debug.mgbax.link.race_stress"
#define MGBAX_RACE_STRESS_MAX_MS 500u   /* clamp 防误设卡死；仅压测构建生效 */

/* 【W92 / path B 原生 SIO 字路由门 — 三端同名同值，默认关】
 * 只改「握手字/块字怎么经进程内 LocalBus 到 tempRecvBuffer」，不改字节来源：
 * 门开时握手期放行游戏真 SIOMLT_SEND 字、禁 RHSLVINJ/BUS_HS_PRESERVE 写真
 * 握手字、sidecar 早退（gEnemyParty 由游戏自己 SIO 组装）。不写 gLinkOpen/
 * 游戏 state/party/brs/信任位。默认关时所有改动早退，零回归。
 *   PC / Qt : env   MGBAX_PATHB_NATIVE_SIO（=1 开启）
 *   Android : prop  debug.mgbax.link.pathb_native_sio（=1 开启）
 *   iOS     : mgbaMobileSetPathBNativeSio / UserDefaults + env（同名同值）
 * 门开≠成功；零注入 CROSSED（APP 0006 ↔ PC 00D5）仍是唯一裁决。 */
#ifndef MGBAX_PATHB_NATIVE_SIO
#define MGBAX_PATHB_NATIVE_SIO 0
#endif
#if MGBAX_PATHB_NATIVE_SIO != 0 && MGBAX_PATHB_NATIVE_SIO != 1
#error "MGBAX_PATHB_NATIVE_SIO must be 0 or 1"
#endif
#define MGBAX_PATHB_NATIVE_SIO_ENV  "MGBAX_PATHB_NATIVE_SIO"
#define MGBAX_PATHB_NATIVE_SIO_PROP "debug.mgbax.link.pathb_native_sio"

#ifdef __cplusplus
extern "C" {
#endif

struct MgbaMobile;
struct GBA;

/**
 * 与载体无关的 busgame 导航状态。Android 的 MgbaMobile 四核和 PC Qt 的
 * CoreController 可见核都调用 mgbaMobileBusGameNavKeys()，共用同一套地址、
 * 相位与判据，避免两端各维护一份逻辑而漂移。
 */
struct BusGameNavState {
	int idx;            /* 本机核在 4P 房间里的编号 0..3（决定座位） */
	int menuAt;         /* 联机菜单出现的帧号；负数 = 只跑导航 */
	int modeDowns;      /* 选模式时补几个 DOWN */
	int menuMax;        /* 见过的 maxCursorPos 峰值 */
	uint32_t frame;     /* 导航帧号 */
	uint32_t battleHits;/* callback2 连续落在战斗区的帧数 */
	bool navOnly;
	bool released;      /* 已进对战区：应把按键控制权交还网络/真人 */
	/* 纯状态驱动导航的防抖闸门：屏幕签名(lastSig)每次变化都重置脉冲，
	 * 四核同屏时相位一致，杜绝「帧号盲推」导致的四人子状态分裂。 */
	int lastSig;        /* 上一帧的屏幕签名（scr/cur/maxCur/ptype/lt 组合） */
	int pulseRemain;    /* A/START 脉冲剩余按住帧数 */
	int pulseOff;       /* A/START 脉冲剩余松开帧数 */
	int pulseArm;       /* 1=允许发起下一次脉冲 */
};

/** 初始化一份导航状态；menuAt<0 会转成 nav-only 并把 menuAt 归零。 */
void mgbaMobileBusGameNavInit(struct BusGameNavState* st, int idx, int menuAt, int modeDowns);

/**
 * 逐帧求按键掩码，并按需写游戏内存（选怪、菜单光标钳位、主机 SD 位）。
 * 直接操作传入的 struct GBA*，因此既能挂在 MgbaMobile 的帧回调上，也能
 * 挂在 Qt CoreController 的 board 上。callback2 连续 120 帧落在
 * battle_main.o 区间时把 released 置位，调用方据此关闭脚本、交还按键。
 */
uint32_t mgbaMobileBusGameNavKeys(struct BusGameNavState* st, struct GBA* g);

/** callback2 是否落在 battle_main.o（真·进对战判据，按区间不按精确值）。 */
bool mgbaMobileBusGameInBattle(struct GBA* g);

/* Qt 侧的诊断读数：这样 C++ 编译单元不必 include GBA 内部结构也能打日志。 */
uint32_t mgbaMobileBusGamePeek32(struct GBA* g, uint32_t addr);
uint8_t mgbaMobileBusGamePeek8(struct GBA* g, uint32_t addr);

struct MgbaMobile* mgbaMobileCreate(const char* saveDir, const char* stateDir, const char* port);
void mgbaMobileDestroy(struct MgbaMobile* emu);
/* Core serialisation for the JNI boundary: runFrames and the two in-memory
 * state calls must not touch the same mCore from different threads. */
void mgbaMobileLock(struct MgbaMobile* emu);
void mgbaMobileUnlock(struct MgbaMobile* emu);
bool mgbaMobileLoad(struct MgbaMobile* emu, const char* path);
/* Overrides the battery-save / save-state folders before the next load.
 * Passing the ROM's own folder keeps saves beside the game. */
void mgbaMobileSetSaveDirs(struct MgbaMobile* emu, const char* saveDir, const char* stateDir);
bool mgbaMobileIsLoaded(const struct MgbaMobile* emu);
void mgbaMobileSetKeys(struct MgbaMobile* emu, uint32_t keys);
void mgbaMobileSetTurbo(struct MgbaMobile* emu, uint32_t mask);
/*
 * The key state the game was last given, in the console's own active-low
 * convention: a set bit means the key is released, a clear bit means it is
 * pressed. This is what the game actually reads, which is not always the
 * mask the front end asked for - a turbo key is pulsed by the core itself,
 * one frame on and one frame off.
 */
uint16_t mgbaMobileLastKeys(struct MgbaMobile* emu);
bool mgbaMobileRunFrames(struct MgbaMobile* emu, int count);
int mgbaMobileReadAudio(struct MgbaMobile* emu, int16_t* out, int maxFrames);
/* Quality resampler to the audio device's rate; 0 disables it. */
bool mgbaMobileSetAudioOutput(struct MgbaMobile* emu, int outRate);
/*
 * Resampled read at the configured output rate. speed is the fast-forward (or
 * slow-motion) factor, 0.05..64, and drift a small ratio adjustment (about
 * +/-0.02) used to keep the front end's playback buffer at its target level.
 */
int mgbaMobileReadAudioOut(struct MgbaMobile* emu, int16_t* out, int maxFrames, double speed, float drift);
/*
 * Turns 不变速 (constant pitch) playback on or off: with it on, the surplus
 * audio a fast-forwarded game produces is parked and replayed at the console's
 * own rate instead of being shredded by the core's ring. The surplus is time-
 * stretched with WSOLA so the music keeps its own speed and pitch with no
 * skipped section. Pass speed 1 to mgbaMobileReadAudioOut while it is on;
 * stretch is the fast-forward multiplier.
 */
void mgbaMobileSetAudioConstantPitch(struct MgbaMobile* emu, bool on, double stretch);
/* 0 = keep pitch, tune runs at the fast-forward rate; 1 = keep tempo and pitch
 * by skipping sections. See MOBILE_AUDIO_HOLD_* in mgba_mobile.c. */
/* How fast-forward audio is produced when the front end asks for it: the mode
 * argument of mgbaMobileSetAudioHoldMode(). */
enum {
	/* Keep the tune at its own pitch but let it run at the fast-forward rate:
	 * nothing is dropped, the whole score plays, just faster. */
	MOBILE_AUDIO_HOLD_PITCH = 0,
	/* Keep the tune at its own tempo *and* pitch - exactly as at 1x - by
	 * skipping sections in between, cut on gaps between notes. */
	MOBILE_AUDIO_HOLD_NATIVE = 1,
};

void mgbaMobileSetAudioHoldMode(struct MgbaMobile* emu, int mode);
/*
 * Frames the time-stretcher had to discard because its staging buffer could not
 * take them. Should always be 0; a non-zero value means a hole in the music
 * (the tests use it to prove the stretcher never eats input it cannot emit).
 */
size_t mgbaMobileWsolaDropped(const struct MgbaMobile* emu);
/*
 * Section skips executed by the 音乐原速 native hold (see mobile_test.c).
 * Grows by a couple per second of fast-forward at 4x - hundreds per second
 * would mean the surplus is being shaved frame-by-frame again, which plays
 * the tune at the fast-forward rate.
 */
size_t mgbaMobileNativeHoldCuts(const struct MgbaMobile* emu);
/*
 * Frames per second the front end is actually pacing emulation at (measured,
 * not nominal). Call about once a second; the resampler follows it so audio
 * stays locked to the playback device even when the front end cannot hold its
 * target rate. Values outside 15-240 are clamped. A reading close to the
 * current pace is treated as noise and ignored (the playback queue's drift
 * control absorbs it), and a larger change is only followed once a second,
 * agreeing window confirms it, so a single stall - a ROM load, a system
 * pause - cannot detune the music. After loading a game the console's own
 * frame rate is assumed until readings accumulate again.
 */
void mgbaMobileSetAudioPaceFps(struct MgbaMobile* emu, double fps);
void mgbaMobileResetAudioPace(struct MgbaMobile* emu);

/* S2 TYPE_PARTY：宿端门注入 + 唯一写口（只写 IWRAM 邮槽字节，游戏态零写；writer=ROM）。 */
void mgbaMobileGnpSetNetParty(bool enabled);
int mgbaMobileGnpNetPartyMailboxWrite(struct MgbaMobile* emu, const uint8_t* mb, size_t len);
/*
 * Whether the resampler's input rate can be trusted at the speed being read:
 * a locked estimate or a remembered device throughput to seed from. Front
 * ends defer starting playback while this is false (the first fast-forward on
 * a device) and wait out the first feedback window instead.
 */
bool mgbaMobileAudioPaceSeeded(const struct MgbaMobile* emu);
void mgbaMobileClearAudio(struct MgbaMobile* emu);
int mgbaMobileWidth(const struct MgbaMobile* emu);
int mgbaMobileHeight(const struct MgbaMobile* emu);
int mgbaMobileSampleRate(const struct MgbaMobile* emu);
/*
 * Length of one emulated frame in nanoseconds (using the console's own frame
 * rate); 0 when no console is loaded. Front ends pace with this so game speed
 * and audio pitch match hardware instead of a rounded 60 fps.
 */
int64_t mgbaMobileFrameNanos(const struct MgbaMobile* emu);
bool mgbaMobileCopyVideo(struct MgbaMobile* emu, uint32_t* pixels, int stride);
bool mgbaMobileSaveState(struct MgbaMobile* emu, int slot);
bool mgbaMobileLoadState(struct MgbaMobile* emu, int slot);
/*
 * In-memory save state, the equivalent of the official client's
 * Console.saveStateToMemory()/loadStateFromMemory() used by TYPE_STATE frames.
 * On success *out points to a malloc'd blob that the caller releases with
 * mgbaMobileFreeState(). Screenshot data is omitted: the state travels over
 * the link and the receiving core does not need it.
 */
bool mgbaMobileSaveStateToMemory(struct MgbaMobile* emu, void** out, size_t* outSize);
bool mgbaMobileLoadStateFromMemory(struct MgbaMobile* emu, const void* data, size_t size);
/**
 * Official GBoy type-6 error contract (KpHwm4.B25kr6:156-157):
 * {@code 0} = loaded, {@code -5} = state size mismatch (the blob is shorter
 * than this core's state), {@code 1} = any other load failure. Used by the
 * mirror console so a bogus peer state is reported instead of silently
 * dropped.
 */
int mgbaMobileLoadStateFromMemoryEx(struct MgbaMobile* emu, const void* data, size_t size);
/** Size in bytes of one savestate of the loaded core (0 when no core). */
size_t mgbaMobileStateSize(const struct MgbaMobile* emu);
void mgbaMobileFreeState(void* state);
/* Rewind history: append a differential state every ~half second while
 * enabled; rewind by about the given number of seconds of gameplay. */
void mgbaMobileSetRewind(struct MgbaMobile* emu, bool enabled);
bool mgbaMobileRewind(struct MgbaMobile* emu, int seconds);
/* 视频层枚举 / 开关（BG0-3、OBJ、backdrop）：UI 用来生成勾选列表。
 * 复用 mCore 的 listVideoLayers / enableVideoLayer，不另造结构。 */
size_t mgbaMobileListVideoLayers(const struct MgbaMobile* emu, const struct mCoreChannelInfo** info);
void mgbaMobileSetVideoLayer(struct MgbaMobile* emu, size_t id, bool enable);
/* 精确逐帧倒带：回退 frames 帧。内部按 REWIND_DIVIDER 粒度的快照回滚，
 * 不足一个快照时回滚后再补跑到目标帧（帧号正好少 frames）。
 * 需要先 mgbaMobileSetRewind(emu, true) 且历史里已有快照。 */
bool mgbaMobileRewindFrames(struct MgbaMobile* emu, int frames);
/* 内存监视：每帧检查 [addr, addr+len) 的字节（len 上限 64），值发生变化时
 * 回调 cb(addr, len, ctx)。写同值不会被发现（这是轮询式监视的固有限制，
 * 与 BusRead 轮询相比至少能捕获写事件造成的值变化）。cb 传 NULL 关闭监视。 */
bool mgbaMobileSetMemoryWatch(struct MgbaMobile* emu, uint32_t addr, uint32_t len,
                              void (*cb)(uint32_t, uint32_t, void*), void* ctx);
void mgbaMobileReset(struct MgbaMobile* emu);
void mgbaMobileTitle(const struct MgbaMobile* emu, char* out, size_t outLen);
void mgbaMobileSetInterframe(struct MgbaMobile* emu, bool enabled);
void mgbaMobileSetFrameskip(struct MgbaMobile* emu, int skip);
void mgbaMobileSaveFile(const struct MgbaMobile* emu, char* out, size_t outLen);
void mgbaMobilePumpLink(struct MgbaMobile* emu);
bool mgbaMobileLinkHost(struct MgbaMobile* emu, int port, int players);
bool mgbaMobileLinkJoin(struct MgbaMobile* emu, const char* host, int port, int players);

/* 进程内总线：同一进程里 N 个核心经共享内存回合屏障互联，不开 socket、不起
 * IO 线程。key 区分同一进程内的不同会话，主机必须先于从机建立。3/4 人本机
 * 多核用它，跨设备仍走 mgbaMobileLinkHost/Join。 */
bool mgbaMobileLinkHostLocal(struct MgbaMobile* emu, int key, int players);
bool mgbaMobileLinkJoinLocal(struct MgbaMobile* emu, int key);
/* 占用指定链路槽位（0 归主机）。本机可见核要占全局会话里它自己的槽位。 */
bool mgbaMobileLinkJoinLocalSlot(struct MgbaMobile* emu, int key, int slot);

/* 进程内锁步 SIO（默认关闭，显式调用才启用）。与上面的共享内存轮次总线
 * 不同，它直接挂 mGBA 官方 GBASIOLockstepCoordinator，在 SIO 传输轮次粒度
 * 会合，没有墙钟超时、没有轮次索引配对、不开 socket。
 * 启用后该核的帧循环自动切到小步 runLoop（见 mgbaLockstepRunFrame）。
 * PC 侧已用同一协调器让 4 核 gen8 multi-battle 进对战并稳定维持。 */
bool mgbaMobileLinkHostLockstep(struct MgbaMobile* emu, int key, int players, int slot);
bool mgbaMobileLinkJoinLockstep(struct MgbaMobile* emu, int key, int slot);
bool mgbaMobileLinkIsLockstep(const struct MgbaMobile* emu);

/* 测试/调试用：直接读写本核 GBA 内存（I/O 寄存器同理）。仅锁步集成测试与诊断
 * 使用，不在产品热路径上。 */
void mgbaMobilePoke16(struct MgbaMobile* emu, uint32_t addr, uint16_t value);
uint16_t mgbaMobilePeek16(struct MgbaMobile* emu, uint32_t addr);
/* 当前已渲染帧号（gba->video.frameCounter），用于验证锁步帧循环推进。 */
uint32_t mgbaMobileFrameCounter(const struct MgbaMobile* emu);

/* 联机快帧门（mobileFastFrame）的只读计数，仅供测试与诊断：
 *   latched - 会话判据是否命中过（0/1）
 *   n       - 走快帧分支的轮次数
 *   reuse   - 其中「没取到新字、复用上一轮对端字」的次数
 *   miss    - 当前连续没取到新字的轮数（≥240 会解除锁存）
 *   ok      - 已完成的真实 MULTI 轮次（快帧门门槛读的就是它：默认 256，
 *             MGBAX_FAST_MIN_OK / mgbax.sio.fast_min_ok 可下调，见 mobileFastFrame）
 *   valid   - 是否有一份「可复用的上一轮对端字」（断线时必须归零）
 * 后两项只给负向用例断言用，产品代码不读。任何指针传 NULL 表示不取该项。
 * 本函数只读，不改任何联机状态。 */
void mgbaMobileSioFastStats(struct MgbaMobile* emu, int* latched, unsigned* n,
                            unsigned* reuse, unsigned* miss, unsigned* ok, int* valid);

/* busgame 调试脚本：PC busgame-lockstep 判据脚本（test/gboylink_test.cpp
 * lsInjectKeys）的设备端移植。Start 后可见核由 beginFrameKeys 接管按键；
 * 镜像核由镜像线程逐帧调 BusGameTick 取掩码。idx 为核的脚本序号
 * （0=主机），与 PC 的 seatX/seatY 座位表对应。仅调试广播使用。 */
void mgbaMobileBusGameStart(struct MgbaMobile* emu, int idx, int menuAt, int modeDowns);
void mgbaMobileBusGameStop(struct MgbaMobile* emu);
uint32_t mgbaMobileBusGameTick(struct MgbaMobile* emu);
/* 镜像核现场快照（只读）：path B 的握手发生在四核之间，可见核的 [diag]
 * 看不到镜像核。mask 由 GBoyMirror 线程按帧号节流调用。 */
void mgbaMobileMirrorDiag(struct MgbaMobile* emu, int idx, int slot);

/* 测试钩子：开启后锁步多玩家传输直接注入 0x1000+playerId 作为发送字，绕开
 * 真实游戏对 SIOMLT_SEND 的改写，得到确定性传输用于验证收集/广播。仅测试使用，
 * 必须在跑锁步集成测试前打开、跑完关闭。 */
void mgbaMobileSioSetInject(bool inject);

/* ROOTHUNT2 零注入对照总闸：iOS Swift / Android JNI 显式设置（须在首个 linkPoll 前）。
 * true=关闭所有 ROOTHUNT2 数据/重绘/单端强推补丁，保留握手补丁。 */
void mgbaMobileSetRhOff(bool enabled);

/* ROOTHUNT2 B7 战斗期命令块中继灰度门 setter（iOS Swift 须在首个 linkPoll 前调）。
 * true=开启 MGBAX_BATTLE_RELAY 行为；与 RH_OFF 正交。 */
void mgbaMobileSetBattleRelay(bool enabled);

/* ROOTHUNT2 方案Y：iOS Swift 设 var8004 恢复门（须在首个 linkPoll 前调）。 */
void mgbaMobileSetLinkBtcfg(bool enabled);
/* ROOTHUNT2 P0/M1：握手态保真 8FFF 旁路门（默认开，false 秒回退）。 */
void mgbaMobileSetHsBypass(bool enabled);
/* ROOTHUNT2 路线A：从机握手保持门（推真 B9A0 + 窗口重装，默认开，false 秒回退）。 */
void mgbaMobileSetHsHold(bool enabled);
/* ROOTHUNT2 路线A：0x2222 启动字 sticky 兜底门（真队列帧字逐拍推，默认开，false 秒回退）。 */
void mgbaMobileSetBlock2222(bool enabled);
/* path B：LocalBus 握手字保真门（bus abort 时回填真 8FFF 到主机自槽，默认开，false 秒回退）。 */
void mgbaMobileSetBusHsPreserve(bool enabled);
/* path B：2P 不被钳成 3 门（默认关，true 开启可逆 A/B）。 */
void mgbaMobileSetLocalBus2p(bool enabled);
/* W92 / path B 原生 SIO 字路由门（默认关，true 开启；iOS 须在首个 linkPoll 前调）。
 * 与 PC env MGBAX_PATHB_NATIVE_SIO / Android debug.mgbax.link.pathb_native_sio 同名同值。 */
void mgbaMobileSetPathBNativeSio(bool enabled);
/* M1 seed 崩溃修复：state-rearm 守卫门（默认关，true=修复；只在 armLinkEvent
 * 调用点加 linkAttached&&callback 守卫，不下沉 armLinkEvent 本体）。 */
void mgbaMobileSetStateRearmGuard(bool enabled);
/* P0：LAG 写时拦截禁用门（与 PC MGBAX_NO_LAG_CLEAR 同名同值；true=开拦截吞 LAG）。 */
void mgbaMobileSetNoLagClear(bool enabled);
/* ROOTHUNT2 灰区全开（§3.5）：一次性打开合法 7 类灰区（C3/seat-assist/rearm/
 * RHSLVINJ/RHBRS/var8004/rem-restore）。默认 false；红线 RL1–RL5 不随此开关放开。
 * iOS 无 setprop，须在首个 SIO linkPoll 前调用；
 * Android 读 debug.mgbax.link.gray_all（debug 前缀，stock A14 可 setprop）。 */
void mgbaMobileSetGrayAll(bool enabled);
/* C3 大厅态 cb2 窗门绕过（独立门，被 GrayAll 蕴含）。默认 false。 */
void mgbaMobileSetGrayLobbyOpen(bool enabled);

/* 诊断：返回本核 CPU 当前 PC（gba->cpu->gprs[15]）。 */
uint32_t mgbaMobileCpuPc(struct MgbaMobile* emu);

void mgbaMobileLinkClose(struct MgbaMobile* emu);
void mgbaMobileLinkStatus(const struct MgbaMobile* emu, char* out, size_t outLen);

/*
 * Battery save type forced on the next GBA load. -1 lets the core autodetect;
 * other values follow enum GBASavedataType (0 none, 1 SRAM, 2 FLASH512,
 * 3 FLASH1M, 4 EEPROM, 5 EEPROM512, 6 SRAM512).
 */
void mgbaMobileSetSaveType(struct MgbaMobile* emu, int type);
/* TEMP PROBE */
struct mCore* mgbaMobileDebugCore(struct MgbaMobile* emu);
/* Auto-apply IPS/UPS/BPS patches found next to the ROM (default on). */
void mgbaMobileSetPatches(struct MgbaMobile* emu, bool enabled);
/* useBios/skipBios applied on the next load. */
void mgbaMobileSetBiosOptions(struct MgbaMobile* emu, bool useBios, bool skipIntro);

/*
 * Game clock reported to RTC cartridges. mode 0 = wall clock, 1 = fixed epoch
 * (unix seconds), 2 = wall clock shifted by offset seconds.
 */
void mgbaMobileSetRtc(struct MgbaMobile* emu, int mode, int64_t epoch, int64_t offset);

/*
 * Boktai solar sensor: level 0-10 maps to the core's lux table. Also enables
 * the light-sensor cartridge device so non-Boktai games that read it work.
 */
void mgbaMobileSetSolar(struct MgbaMobile* emu, int level);
/* Rumble cartridge (e.g. Mario Golf) enable; hits are polled by the front end. */
void mgbaMobileSetCartRumble(struct MgbaMobile* emu, bool enabled);
/* Number of rumble pulses since the last call; each pulse clears on read. */
int mgbaMobileTakeRumbles(struct MgbaMobile* emu);

/*
 * GB DMG palette override: twelve 0xRRGGBB entries for gb.pal[0..11] (four
 * colors each for BG, OBJ0 and OBJ1). Applied live on a running GB core and
 * replayed on every load.
 */
void mgbaMobileSetGbPalette(struct MgbaMobile* emu, const int32_t* colors);
/* Super Game Boy border art on SGB-capable games (sgb.borders); applied live. */
void mgbaMobileSetSgbBorders(struct MgbaMobile* emu, bool enabled);
/*
 * Per-channel audio gains, 0-256 fixed point (256 = full volume): PSG
 * channels 1-4 then the GBA DMA A/B FIFOs. Applied live on the running core
 * and on every reload.
 */
void mgbaMobileSetChannelVolumes(struct MgbaMobile* emu, const int32_t* gains);
/*
 * Tilt cartridge input (WarioWare Twisted, Kirby Tilt'n'Tumble). tiltX/tiltY
 * are normalized to -1..1; gyroZ follows the same scale.
 */
void mgbaMobileSetRotation(struct MgbaMobile* emu, float tiltX, float tiltY, float gyroZ);

/* Cheats. Codes are added as one named set of newline-separated raw lines;
 * format follows the GBA cheat type codes (0 autodetect, 1 CodeBreaker,
 * 2 GameShark, 3 Pro Action Replay, 4 VBA). Sets persist to <save>/<base>.cht
 * and are reloaded with the ROM.
 */
int mgbaMobileCheatCount(const struct MgbaMobile* emu);
void mgbaMobileCheatName(const struct MgbaMobile* emu, int index, char* out, size_t outLen);
bool mgbaMobileCheatEnabled(const struct MgbaMobile* emu, int index);
void mgbaMobileCheatSetEnabled(struct MgbaMobile* emu, int index, bool enabled);
bool mgbaMobileCheatAdd(struct MgbaMobile* emu, const char* name, const char* lines, int type);
bool mgbaMobileCheatRemove(struct MgbaMobile* emu, int index);

/*
 * Debug memory access for the memory viewer, cheat search and the PPU
 * viewers (they read PAL/VRAM/OAM straight off the bus). width is 8, 16 or
 * 32 bits. Reads run against the live core, the same way a debugger does;
 * callers that need stable values pause the game first.
 */
uint32_t mgbaMobileBusRead(const struct MgbaMobile* emu, int width, uint32_t address);
bool mgbaMobileBusWrite(struct MgbaMobile* emu, int width, uint32_t address, uint32_t value);
/* Byte-wise bulk read of up to size bytes starting at address; returns the
 * number of bytes written into out (capped at 1 MiB per call). */
int mgbaMobileBusReadBlock(const struct MgbaMobile* emu, uint32_t address, int size, uint8_t* out);

/* Linear resample used by the iOS audio path. pos is carried between calls. */
int mgbaMobileResample(const int16_t* in, int inFrames, int inRate, int outRate, int16_t* out, int maxOutFrames, double* pos);

/*
 * Desktop test hooks. Both are per-instance on purpose: two cores in one
 * process (本机双核心) must not share the synthetic audio clock or the link
 * unstick one-shot latch. mgbaMobileUnstickStep() returns 1 exactly on the
 * call that arms the patch; matched=false resets that core's streak.
 */
void mgbaMobileSetAudioClock(struct MgbaMobile* emu, double (*clock)(void));
bool mgbaMobileHasSyntheticAudioClock(const struct MgbaMobile* emu);
int mgbaMobileUnstickStep(struct MgbaMobile* emu, int mode, bool matched);

/* Same BIOS filename rules as the Android importer. */
void mgbaMobileBiosFileName(const char* name, long size, char* out, size_t outLen);

#ifdef __cplusplus
}
#endif

#endif
