/* Copyright (c) 2013-2021 Jeffrey Pfau
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
/**
 * LAN SIO link cable, a C port of the mobile-layer GbaLinkDriver
 * (src/platform/mobile/mgba_mobile.c lines ~1700-2830) for the Qt port.
 * The comments there carry the full reasoning; this port keeps the logic
 * byte-for-byte and drops the logcat debug counters.
 */
#include "sio_link.h"

#include <mgba/core/core.h>
#include <mgba/gba/interface.h>
#include <mgba/internal/gba/gba.h>
#include <mgba/internal/gba/sio.h>
#include <mgba/internal/gba/io.h>
#include <mgba/internal/gba/memory.h>
#include <mgba-util/common.h>

#include <stdarg.h>
#include <stdlib.h>
#include <string.h>
#include <stdio.h>
#include <time.h>

#include "platform/mobile/link_net.h"

#ifdef _WIN32
#include <winsock2.h>
#endif

/**
 * 桌面版是 GUI 子系统程序，mGBA 的日志走 Qt 日志窗口、stderr 抓不到，
 * 实机排查联机时序时需要能落到文件：MGBAX_SIO_LOG=1 时同一条轨迹追加到
 * %TEMP%/mgba_sio.log（每次打开-关闭，避免崩溃丢尾）。
 */
/* 曾经每条日志都 fopen/fclose：主机每帧上千次传输、每次都要写一条，
 * Windows 上配上杀软实时扫描直接把帧率压到 0.7fps，反过来饿死从机。
 * 现在只开一次、攒够一批再 flush；崩溃最多丢 32 行，换回满帧。 */
static void sioLogFile(const char* fmt, ...) {
	static int enabled = -1;
	static FILE* f = NULL;
	static int pending = 0;
	if (enabled < 0) {
		enabled = getenv("MGBAX_SIO_LOG") ? 1 : 0;
	}
	if (!enabled) {
		return;
	}
	if (!f) {
		const char* tmp = getenv("TEMP");
		if (!tmp) {
			tmp = getenv("TMP");
		}
		if (!tmp) {
			tmp = ".";
		}
		char path[512];
		snprintf(path, sizeof(path), "%s%cmgba_sio.log", tmp, '/');
		f = fopen(path, "a");
		if (!f) {
			enabled = 0;
			return;
		}
	}
	va_list args;
	va_start(args, fmt);
	vfprintf(f, fmt, args);
	va_end(args);
	fputc('\n', f);
	if (++pending >= 32) {
		fflush(f);
		pending = 0;
	}
}

#define SIO_LOG(...) do { mLOG(GBA_SIO, INFO, __VA_ARGS__); sioLogFile(__VA_ARGS__); } while (0)

static void applyLinkTerminalBits(struct SioLink* sio);
static void serviceLink(struct SioLink* sio);
static int gbaLinkDevices(struct GBASIODriver* driver);

struct GbaLinkDriver {
	struct GBASIODriver d;
	struct SioLink* sio;
};

struct SioLink {
	struct NetLink* link;
	struct mCore* core;
	struct GbaLinkDriver gbaLink;
	bool linkAttached;

	/* One MULTI transfer in flight: push this round's word at start, fetch
	 * the peer's reply when the transfer should be over - never blocking the
	 * emulation thread mid-frame. */
	struct mTimingEvent sioDone;
	/* Slave-side "round complete" event: pins the slave's emulated clock to
	 * the host's cadence (see sioSlaveDoneEvent below). */
	struct mTimingEvent sioSlaveDone;
	struct mTimingEvent linkEvent;
	bool sioSlaveArmed;
	uint32_t sioSlavePeriod;
	uint32_t sioPeerCycles;
	bool sioPeerCyclesValid;
	bool sioWaiting;
	int sioRetries;
	uint32_t sioRetryWall;
	bool sioHasRemote;
	uint32_t sioRemote;
	uint32_t sioOk;
	uint32_t sioTimeouts;
	uint32_t sioFallback;
	uint32_t sioStartCycle;
	uint32_t sioPeak;
	uint32_t sioLateness;
	/* 每轮在 takePeerWord 上阻塞了多久（墙钟 ms）。联机帧率的唯一大头就是
	 * 它 —— 一帧 9 轮，每轮阻塞多少就乘以 9。有这组数才能判断到底是对端
	 * 模拟太慢、还是网络太远，而不是凭感觉调参数。 */
	uint32_t sioWaitSumMs;
	uint32_t sioWaitMaxMs;
	uint32_t sioWaitN;
	uint16_t sioIndex;
	bool sioInitSeen;
	bool sioStashValid;
	uint32_t sioStash;
	/* 从机本轮要回推的字：在游戏写 SIOCNT 起轮的**那一刻**扣下来。
	 * 若等到本轮完成（收完主机字）再去读 SIOMLT_SEND，游戏很可能已经把
	 * 下一轮的字写进去了 —— 一个 16bit 的错位就足以让 gLink 的字节流
	 * 命令队列（SendBlockRequest / 块校验）整体偏移，表现为链路连着、
	 * 但 gBlockReceivedStatus 永远是 0、对战起不来。 */
	uint16_t sioRoundWord;
	bool sioRoundWordValid;
	uint32_t sioPushValue;
	uint16_t sioPushIndex;
	bool sioPushed;
	uint32_t sioMisorder;
	uint32_t sioBusyCycle;
	/* 快速帧锁存：会话建立（cnt>=2）过一次就一直走零等待路径，直到链路
	 * 断开或连续多轮拿不到任何新字。02:03 实测不锁存时 cnt 抖动会让
	 * 判定时开时关，64 次传输里只有 22 次走快速路径（fb=22 / n=42），
	 * 其余 42 次仍按 23~32ms/轮 阻塞，帧率被反复拖回去。 */
	bool sioFastLatched;
	uint32_t sioFastMiss;
};

static uint32_t wallNowMs(void) {
#ifdef _WIN32
	return (uint32_t) (GetTickCount64() & 0xFFFFFFFFu);
#else
	struct timespec ts;
	clock_gettime(CLOCK_MONOTONIC, &ts);
	return (uint32_t) (ts.tv_sec * 1000 + ts.tv_nsec / 1000000);
#endif
}

static struct mTiming* coreTiming(struct SioLink* sio) {
	if (!sio->core) {
		return NULL;
	}
	if (sio->core->platform(sio->core) == mPLATFORM_GBA) {
		return &((struct GBA*) sio->core->board)->timing;
	}
	return NULL;
}

static void armLinkEvent(struct SioLink* sio) {
	struct mTiming* timing = coreTiming(sio);
	if (!timing) {
		return;
	}
	mTimingDeschedule(timing, &sio->linkEvent);
	mTimingSchedule(timing, &sio->linkEvent, 8192);
}

static uint32_t readLinkOut(struct SioLink* sio, uint16_t* modeOut) {
	if (!sio->core) {
		return 0xFFFFFFFFu;
	}
	if (sio->core->platform(sio->core) == mPLATFORM_GBA) {
		struct GBA* gba = (struct GBA*) sio->core->board;
		*modeOut = (uint16_t) gba->sio.mode;
		if (gba->sio.mode == GBA_SIO_NORMAL_32) {
			return gba->memory.io[GBA_REG(SIODATA32_LO)] | ((uint32_t) gba->memory.io[GBA_REG(SIODATA32_HI)] << 16);
		}
		if (gba->sio.mode == GBA_SIO_NORMAL_8) {
			return gba->memory.io[GBA_REG(SIODATA8)] & 0xFFu;
		}
		return gba->memory.io[GBA_REG(SIOMLT_SEND)];
	}
	return 0xFFFFFFFFu;
}

static void completeMultiTransfer(struct SioLink* sio, uint32_t remote, bool haveRemote, uint32_t cyclesLate);
static void completeMultiTransferBus(struct SioLink* sio, const uint32_t vals[4], int players, uint32_t cyclesLate);

static void finishIncoming(struct SioLink* sio, uint16_t mode, uint32_t remote, int player) {
	if (!sio->core || sio->core->platform(sio->core) != mPLATFORM_GBA) {
		return;
	}
	struct GBA* gba = (struct GBA*) sio->core->board;
	int me = netLinkPlayer(sio->link);
	if (gba->sio.mode == GBA_SIO_MULTI && (mode == GBA_SIO_MULTI || mode == 0)) {
		/* Only finish while the game is actually waiting for a transfer: Busy
		 * up (game started one) or SIO IRQ enabled (Pokemon's 0x600F wait,
		 * hardware would raise Busy). Otherwise the game is not linking and
		 * injecting a result confuses it. */
		bool busy = (gba->sio.siocnt & 0x0080) != 0;
		bool armed = (gba->sio.siocnt & 0x4000) != 0;
		if (sio->sioWaiting || !(busy || armed)) {
			return;
		}
		uint16_t data[4] = { 0xFFFF, 0xFFFF, 0xFFFF, 0xFFFF };
		uint16_t local = gba->memory.io[GBA_REG(SIOMLT_SEND)];
		if (player >= 0 && player < 4) {
			data[player] = (uint16_t) remote;
		}
		if (me >= 0 && me < 4) {
			data[me] = local;
		}
		sio->sioFallback++;
		sio->sioHasRemote = true;
		sio->sioRemote = remote;
		GBASIOMultiplayerFinishTransfer(&gba->sio, data, 0);
	} else if (gba->sio.mode == GBA_SIO_NORMAL_8) {
		GBASIONormal8FinishTransfer(&gba->sio, (uint8_t) remote, 0);
	} else if (gba->sio.mode == GBA_SIO_NORMAL_32) {
		GBASIONormal32FinishTransfer(&gba->sio, remote, 0);
	}
}

/**
 * 只读诊断：把 gen8 ROM 的联机对战状态变量打进 SIO 日志，用来判断游戏
 * 到底停在 CB2_HandleStartBattle 的哪个 case。地址取自 /d/gen8/rom.map，
 * 只对这个 ROM 有效；默认完全关闭，MGBAX_LINK_DIAG=1 才启用。
 * 用 GBAView16 而不是 GBALoad16，避免给模拟时钟引入额外周期。
 */
static void logLinkDiag(struct GBA* gba) {
	static int enabled = -1;
	if (enabled < 0) {
		enabled = getenv("MGBAX_LINK_DIAG") ? 1 : 0;
	}
	if (!enabled || !gba || !gba->cpu) {
		return;
	}
	uint16_t state = GBAView16(gba->cpu, 0x0201CFC4u) & 0xFFu; // gBattleCommunication[MULTIUSE_STATE]
	uint16_t brs01 = GBAView16(gba->cpu, 0x03002A40u);          // gBlockReceivedStatus[0..1]
	uint16_t brs23 = GBAView16(gba->cpu, 0x03002A42u);          // gBlockReceivedStatus[2..3]
	uint16_t rem = GBAView16(gba->cpu, 0x03002AC0u) >> 8;       // gReceivedRemoteLinkPlayers
	uint32_t cb = (uint32_t) GBAView16(gba->cpu, 0x03002AD4u)
	              | ((uint32_t) GBAView16(gba->cpu, 0x03002AD6u) << 16); // gLinkCallback
	uint32_t status = (uint32_t) GBAView16(gba->cpu, 0x03002A9Cu)
	                  | ((uint32_t) GBAView16(gba->cpu, 0x03002A9Eu) << 16); // gLinkStatus
	/* gLink @ 0x03002AF4：state +1、playerCount +3、receivedNothing +0xC、
	 * serialIntrCounter +0xD、lag +0x13、sendCmdIndex +0x16、recvCmdIndex +0x17。 */
	uint16_t l0 = GBAView16(gba->cpu, 0x03002AF4u);
	uint16_t l1 = GBAView16(gba->cpu, 0x03002AF6u);
	uint16_t l2 = GBAView16(gba->cpu, 0x03002B00u);
	uint16_t l3 = GBAView16(gba->cpu, 0x03002B06u);
	uint16_t l4 = GBAView16(gba->cpu, 0x03002B0Au);
	/* LINKUP 结果码（/d/gen8/rom.map）：gSpecialVar_Result=0x0202197C，
	 * gLinkType=0x02027B82，gWirelessCommType=0x03002AAD。
	 * 常量见 include/constants/cable_club.h：0=进行中 1=成功
	 * 3=两端选择不同 4=人数不对 7/9=有玩家未准备好 6=连接错误。
	 * 打出来才能区分「按 A 时机不对」和「两端选了不同项目」。 */
	uint16_t linkup = GBAView16(gba->cpu, 0x0202197Cu);
	uint16_t ltype = GBAView16(gba->cpu, 0x02027B82u);
	uint8_t wireless = GBAView8(gba->cpu, 0x03002AADu);
	/* 联机菜单判定（完全基于游戏内存，不依赖 GL 窗口抓图）。
	 * struct Menu @0x020296C0（menu.c 的 sMenu，符号大小 12）：
	 *   +2 cursorPos、+3 minCursorPos、+4 maxCursorPos、+5 windowId。
	 * Menu_GetCursorPos 的反汇编就是 ldrb r0,[0x020296C0,#2]，已核对。
	 * gTasks @0x02033CDC，sizeof(struct Task)=0x28（func4 + 4 个 u8 +
	 * s16 data[16]）；Task_HandleMultichoiceInput @0x081BB614（Thumb 指针
	 * 带 bit0），其 data[7]=tMultichoiceId、data[6]=tWindowId。
	 * 常量 /d/gen8/include/constants/script_menu.h：74/76/77/78/79 是
	 * 有线/无线俱乐部服务菜单，18 是「单打/双打/多人」模式菜单。
	 * 有了这些字段，脚本能确定地判断 PC 是否停在菜单、光标在第几项、
	 * 有没有把 DOWN 吃掉，而不是靠抓不到的 PrintWindow 画面猜。 */
	uint8_t mCursor = GBAView8(gba->cpu, 0x020296C2u);
	uint8_t mMin = GBAView8(gba->cpu, 0x020296C3u);
	uint8_t mMax = GBAView8(gba->cpu, 0x020296C4u);
	uint8_t mWin = GBAView8(gba->cpu, 0x020296C5u);
	int mTask = -1;
	int mChoice = -1;
	for (int i = 0; i < 16; ++i) {
		uint32_t slot = 0x02033CDCu + (uint32_t) i * 0x28u;
		uint32_t fn = (uint32_t) GBAView16(gba->cpu, slot)
		              | ((uint32_t) GBAView16(gba->cpu, slot + 2u) << 16);
		if (!GBAView8(gba->cpu, slot + 4u)) {
			continue;
		}
		if ((fn & ~1u) == 0x081BB614u) {
			mTask = i;
			mChoice = (int16_t) GBAView16(gba->cpu, slot + 8u + 14u);
			break;
		}
	}
	/* 玩家格坐标：gSaveBlock1Ptr @0x03004964 → struct SaveBlock1 { Coords16 pos; }，
	 * pos.x 在 +0、pos.y 在 +2。走位改成闭环导航全靠它 —— 盲按方向键在锁步
	 * 低帧率下频繁丢输入，扫十几次也踩不到座位。 */
	uint32_t sb1 = GBAView32(gba->cpu, 0x03004964u);
	int16_t px = 0, py = 0;
	if (sb1 >= 0x02000000u && sb1 < 0x03000000u) {
		px = (int16_t) GBAView16(gba->cpu, sb1 + 0u);
		py = (int16_t) GBAView16(gba->cpu, sb1 + 2u);
	}
	SIO_LOG("[diag] mu=%u brs=%04X/%04X rem=%u cb=%08X st=%08X"
	        " lstate=%u pc=%u intr=%u ridx=%u sidx=%u lag=%u rn=%u qf=%u"
	        " linkup=%u ltype=%u wl=%u px=%d py=%d"
	        " menu=c%u/%u/%u/w%u mt=%d mid=%d",
	        state, brs01, brs23, rem, cb, status,
	        (l0 >> 8) & 0xFF, (l1 >> 8) & 0xFF, (l2 >> 8) & 0xFF,
	        l4 & 0xFF, (l4 >> 8) & 0xFF, (l3 >> 8) & 0xFF, l2 & 0xFF, l3 & 0xFF,
	        (unsigned) linkup, (unsigned) ltype, (unsigned) wireless,
	        (int) px, (int) py,
	        (unsigned) mCursor, (unsigned) mMin, (unsigned) mMax, (unsigned) mWin,
	        mTask, mChoice);
	/* 联机房间按键码握手（overworld.c / link.c）：
	 * sPlayerTradingStates[4] 每一端都保存所有玩家状态，0x82=UNK_2 表示已准备好，
	 * sub_8087214() 要求所有玩家都是 0x82 才会切到 Task_StartWiredCableClubBattle。 */
	uint16_t ts01 = GBAView16(gba->cpu, 0x03004A10u);
	uint16_t ts23 = GBAView16(gba->cpu, 0x03004A12u);
	uint32_t intercept = (uint32_t) GBAView16(gba->cpu, 0x03004A14u)
	                     | ((uint32_t) GBAView16(gba->cpu, 0x03004A16u) << 16);
	uint16_t hk = GBAView16(gba->cpu, 0x03004A2Cu);   // gHeldKeyCodeToSend
	uint16_t lidcnt = GBAView16(gba->cpu, 0x03004A38u); // localId, fieldLinkPlayerCount
	uint16_t sendCmd = GBAView16(gba->cpu, 0x03002AB0u);
	uint16_t sendKey = GBAView16(gba->cpu, 0x03002AB2u);
	uint16_t transferring = GBAView16(gba->cpu, 0x03004974u);
	uint32_t cb2 = (uint32_t) GBAView16(gba->cpu, 0x020290E8u)
	               | ((uint32_t) GBAView16(gba->cpu, 0x020290EAu) << 16);
	uint16_t pk0 = GBAView16(gba->cpu, 0x030029E2u);
	uint16_t pk1 = GBAView16(gba->cpu, 0x030029E4u);
	uint16_t rc0 = GBAView16(gba->cpu, 0x03002A4Au);
	uint16_t rc0k = GBAView16(gba->cpu, 0x03002A4Cu);
	uint16_t rc1 = GBAView16(gba->cpu, 0x03002A5Au);
	uint16_t rc1k = GBAView16(gba->cpu, 0x03002A5Cu);
	SIO_LOG("[room] ts=%02X/%02X/%02X/%02X ic=%08X hk=%04X lid=%u cnt=%u"
	        " send=%04X/%04X tr=%04X cb2=%08X pk=%04X/%04X rc=%04X:%04X,%04X:%04X",
	        ts01 & 0xFF, ts01 >> 8, ts23 & 0xFF, ts23 >> 8,
	        intercept, hk, lidcnt & 0xFF, lidcnt >> 8,
	        sendCmd, sendKey, transferring, cb2, pk0, pk1, rc0, rc0k, rc1, rc1k);
}

/**
 * 有线俱乐部 standby 卡死的运行时适配（默认关闭，MGBAX_LINK_UNSTICK=1 启用）。
 *
 * gen8 的 SetLinkStandbyCallback() 只在 gLinkCallback == NULL 时才安装
 * LinkCB_Standby；网络链路上这个回调常驻 LinkCB_SendHeldKeys，于是
 * IsLinkTaskFinished() 永远为 false，游戏停在「等待连接」不进 CB2_InitBattle。
 * 这里在精确命中该卡死状态时代游戏把回调换成它自己的 LinkCB_Standby，
 * 保留游戏的 gLastRecvQueueCount 门控，让双端 standby 握手按原时序跑完。
 * 不改 ROM、不改游戏逻辑、只写一次 IWRAM 的 4 字节函数指针。
 */
static int unstickEnabled(void) {
	static int enabled = -1;
	if (enabled < 0) {
		const char* v = getenv("MGBAX_LINK_UNSTICK");
		enabled = (v && v[0] == '1') ? 1 : ((v && v[0] == '2') ? 2 : 0);
	}
	return enabled;
}

static void maybeUnstickStandby(struct GBA* gba) {
	static int done = 0;
	static int streak = 0;
	int mode = unstickEnabled();
	if (done || !mode || !gba || !gba->cpu) {
		return;
	}
	uint16_t l0 = GBAView16(gba->cpu, 0x03002AF4u);          // isMaster, state
	uint16_t rem16 = GBAView16(gba->cpu, 0x03002AC0u);       // rem at +1
	uint16_t cbLo = GBAView16(gba->cpu, 0x03002AD4u);
	uint16_t cbHi = GBAView16(gba->cpu, 0x03002AD6u);
	uint32_t cb = (uint32_t) cbLo | ((uint32_t) cbHi << 16);
	uint16_t mu = GBAView16(gba->cpu, 0x0201CFC4u) & 0xFFu;
	uint16_t brs = GBAView16(gba->cpu, 0x03002A40u);
	int state = (l0 >> 8) & 0xFF;
	int rem = (rem16 >> 8) & 0xFF;
	if (state == 4 && rem == 1 && cb == 0x08151DA9u && mu == 0 && brs == 0) {
		if (++streak >= 3) {
			/* mode 1: 换成游戏自带的 LinkCB_Standby，走完双端 standby 握手；
			 * mode 2: 直接置 NULL，让 IsLinkTaskFinished() 立即成立 ——
			 * SendBlock 会自己装 LinkCB_BlockSend*，战斗流程不依赖 standby。 */
			uint32_t target = (mode == 2) ? 0x00000000u : 0x081529BDu;
			gba->memory.iwram[(0x03002AD4u - 0x03000000u) >> 2] = target;
			done = 1;
			SIO_LOG("[unstick] mode=%d cb %08X -> %08X (state=%d rem=%d mu=%u)",
			        mode, cb, target, state, rem, mu);
		}
	} else {
		streak = 0;
	}
}

/**
 * 联机房间握手「主从选举」补触发（默认开启，MGBAX_LINK_REARM=0 关闭）。
 *
 * gen8 的 LinkMain1 只在 gShouldAdvanceLinkState==1 的那一帧做一次主从选举
 * （Task_TriggerHandshake 在 OpenLink 后第 5 帧把它置 1），并且要求那一瞬间
 * gLink.playerCount > 1。局域网/网络联机时两端进房间必然相差几十帧以上，
 * 主机端选举时对方还没出现，于是两端都退化成从机、都只发从机握手字 0xB9A0，
 * DoHandshake() 永远等不到 0x8FFF，双端永久卡在「等待连接」画面。
 * 这里在「双方已连上(playerCount>=2)、仍在握手态(state==2)、但还没选出主机
 * (handshakeAsMaster==0)」时，代游戏把 gShouldAdvanceLinkState 置 1，
 * 让它重新做一次选举。只对 localId==0 的主机位有效（从机侧游戏自己会忽略），
 * 不改 ROM、只写 IWRAM 的 1 个字节标志。
 */
static void maybeRearmHandshake(struct GBA* gba) {
	static int enabled = -1;
	if (enabled < 0) {
		const char* v = getenv("MGBAX_LINK_REARM");
		enabled = (v && v[0] == '0') ? 0 : 1;
	}
	if (!enabled || !gba || !gba->cpu) {
		return;
	}
	/* 逐字节读 struct Link：+0 isMaster、+1 state、+3 playerCount、+0x0E
	 * handshakeAsMaster。（注意不能从 uint16 里右移 24 位取 playerCount，
	 * 那样恒为 0。） */
	int isMaster = GBAView8(gba->cpu, 0x03002AF4u + 0x00u);
	int state = GBAView8(gba->cpu, 0x03002AF4u + 0x01u);
	int players = GBAView8(gba->cpu, 0x03002AF4u + 0x03u);
	int hs = GBAView8(gba->cpu, 0x03002AF4u + 0x0Eu);       // handshakeAsMaster
	if (state != 2 || players < 2 || hs != 0) {
		return;
	}
	if (isMaster != 8) {
		SIO_LOG("[rearm] waiting: isMaster=%d (need 8) players=%d", isMaster, players);
		return;
	}
	/* gShouldAdvanceLinkState @ 0x03002AD8：只置最低字节的最低位，
	 * 同字其余字节原样保留。 */
	uint32_t idx = (0x03002AD8u - 0x03000000u) >> 2;
	gba->memory.iwram[idx] |= 0x00000001u;
	SIO_LOG("[rearm] handshake election retriggered (players=%d)", players);
}

/* 四槽凑齐之后的公共收尾：耗时统计、诊断日志、写 SIOMULTI、发 SIO 中断。
 * 两人直连和 3/4 人总线都汇到这里，诊断口径保持一致。 */
static void finishMultiTransfer(struct SioLink* sio, uint16_t data[4], uint32_t cyclesLate) {
	struct GBA* gba = (struct GBA*) sio->core->board;
	int me = netLinkPlayer(sio->link);
	struct mTiming* timing = coreTiming(sio);
	if (timing) {
		uint32_t spent = mTimingCurrentTime(timing) - sio->sioStartCycle;
		uint32_t tenth = spent / 1677 + ((spent % 1677) ? 1 : 0);
		sio->sioLateness = tenth;
		if (tenth > sio->sioPeak) {
			sio->sioPeak = tenth;
		}
	}
	sio->sioOk++;
	sio->sioBusyCycle = 0;
	sio->sioStashValid = false;
	if ((sio->sioOk & 0x3F) == 0) {
		uint32_t wAvg = sio->sioWaitN ? sio->sioWaitSumMs / sio->sioWaitN : 0;
		SIO_LOG("SIO multi me=%d ok=%u last=%u.%ums peak=%u.%ums to=%u fb=%u mis=%u m0=%04X m1=%04X wait=%u/%ums n=%u",
		     me, sio->sioOk, sio->sioLateness / 10, sio->sioLateness % 10,
		     sio->sioPeak / 10, sio->sioPeak % 10, sio->sioTimeouts, sio->sioFallback, sio->sioMisorder, data[0], data[1],
		     wAvg, sio->sioWaitMaxMs, sio->sioWaitN);
		sio->sioWaitSumMs = 0;
		sio->sioWaitMaxMs = 0;
		sio->sioWaitN = 0;
		logLinkDiag(gba);
		maybeUnstickStandby(gba);
		maybeRearmHandshake(gba);
	}
	GBASIOMultiplayerFinishTransfer(&gba->sio, data, cyclesLate);
}

/* 两人直连：本机一槽 + 对端一槽，其余保持 0xFFFF（空槽）。 */
static void completeMultiTransfer(struct SioLink* sio, uint32_t remote, bool haveRemote, uint32_t cyclesLate) {
	if (!sio->core || sio->core->platform(sio->core) != mPLATFORM_GBA) {
		return;
	}
	struct GBA* gba = (struct GBA*) sio->core->board;
	int me = netLinkPlayer(sio->link);
	uint16_t data[4] = { 0xFFFF, 0xFFFF, 0xFFFF, 0xFFFF };
	if (me >= 0 && me < 4) {
		data[me] = gba->memory.io[GBA_REG(SIOMLT_SEND)];
	}
	if (haveRemote) {
		data[me == 0 ? 1 : 0] = (uint16_t) remote;
	}
	finishMultiTransfer(sio, data, cyclesLate);
}

/* 3/4 人总线：四个槽位来自主机的汇聚广播，没连上的槽位是 0xFFFF。
 * 槽位装配规则在 link_net 的 netLinkBusSlots（纯函数，已有单测）。 */
static void completeMultiTransferBus(struct SioLink* sio, const uint32_t vals[4], int players, uint32_t cyclesLate) {
	if (!sio->core || sio->core->platform(sio->core) != mPLATFORM_GBA) {
		return;
	}
	int me = netLinkPlayer(sio->link);
	uint16_t data[4];
	/* 3/4 人总线：四槽来自主机唯一一次聚合广播（vals[4]），所有核（含主机）
	 * 都写入同一份快照，不再用本核当前 SIOMLT_SEND 覆盖自身槽位——那样会让
	 * 三核的 SIOMULTI 互不相同，握手永远对不齐（busgame 实测 f=1191 起分叉）。
	 * vals 里未连上的槽位已是 0xFFFF（主机缺席槽 + 掉线从机）。 */
	for (int i = 0; i < 4; ++i) {
		data[i] = (i < players && vals) ? (uint16_t) vals[i] : 0xFFFF;
	}
	/* 逐轮取证（前 80 轮 + 每 500 轮一条）：三核同一轮写入的四个槽应该
	 * 完全一致（现在 data 就是 vals 的逐字拷贝，用来确认三核收到同一份）。 */
	static uint32_t s_busLogN;
	uint32_t n = ++s_busLogN;
	if (n <= 80 || (n % 500) == 0) {
		fprintf(stderr, "BUSBUS n=%u me=%d players=%d idx=%u vals=%04X,%04X,%04X,%04X -> %04X,%04X,%04X,%04X\n",
		        (unsigned) n, me, players, (unsigned) sio->sioIndex,
		        (unsigned) vals[0], (unsigned) vals[1], (unsigned) vals[2], (unsigned) vals[3],
		        data[0], data[1], data[2], data[3]);
	}
	/* 握手取证：MASTER_HANDSHAKE=0x8FFF / SLAVE_HANDSHAKE=0xB9A0（gen8/link.h）。
	 * DoHandshake 要求四槽 = 8FFF,SLAVE,SLAVE,FFFF 且连续两轮稳定才 LINKUP。
	 * 只要本核这一轮出现了握手字（8FFF 或 B9A0），就把「投递给游戏的 data」
	 * 打出来，看是投递 bug 还是从机 2 还没跟上。BUSGAME_HSL=1 时开。 */
	static uint32_t s_hslN;
	if (getenv("BUSGAME_HSL")
	    && ((data[0] == 0x8FFFu) || (data[1] == 0xB9A0u) || (data[2] == 0xB9A0u)
	        || (vals[0] == 0x8FFFu) || (vals[1] == 0xB9A0u) || (vals[2] == 0xB9A0u))) {
		if (++s_hslN <= 120) {
			fprintf(stderr, "HSL n=%u me=%d players=%d data=%04X,%04X,%04X,%04X vals=%04X,%04X,%04X,%04X\n",
			        (unsigned) s_hslN, me, players,
			        data[0], data[1], data[2], data[3],
			        (unsigned) vals[0], (unsigned) vals[1], (unsigned) vals[2], (unsigned) vals[3]);
		}
	}
	finishMultiTransfer(sio, data, cyclesLate);
}

static void serviceLink(struct SioLink* sio) {
	if (!sio->linkAttached || !sio->link) {
		return;
	}
	/* Re-align the terminal bits every round: the link state may have changed
	 * after the game last read (or wrote) SIOCNT, and the game re-checks it
	 * every frame in HANDSHAKE. */
	applyLinkTerminalBits(sio);
	/* Let the IO thread always see the byte we would send now, so a peer
	 * request can be answered without waiting for the emulated thread. */
	uint16_t localMode = 0;
	uint32_t local = readLinkOut(sio, &localMode);
	netLinkPublish(sio->link, localMode, local);
	netLinkPingTick(sio->link);
	if (sio->core && sio->core->platform(sio->core) == mPLATFORM_GBA) {
		int player = netLinkPlayer(sio->link);
		/* The slave never starts a transfer itself: the 1P clock drives the
		 * round, the slave finishes when the host's word arrives. The finish
		 * itself moved to sioSlaveDoneEvent, which pins the slave's clock to
		 * the host's cadence; here we only arm it - and only once the host
		 * actually pushed a word, otherwise the event would spin waiting for
		 * a word that never comes (before the game even reaches the room). */
		/* 3/4 人总线的字走 PKT_PUSH / PKT_BUS_ROUND，不进 peerQ：
		 * netLinkPeerPending() 在总线模式恒为 0，沿用两人判据会让从机
		 * 轮次事件永远 arm 不上（主机每轮等满超时窗，从机收不到 SIO
		 * 中断卡在进房前）。总线改看「游戏自己写过 SIOCNT 起 MULTI」，
		 * 既不自旋，也不依赖主机先广播，避免第一轮互等。 */
		bool busMode = netLinkBusActive(sio->link);
		bool roundReady = busMode ? sio->sioRoundWordValid
		                          : netLinkPeerPending(sio->link) > 0;
		if (player != 0 && !sio->sioSlaveArmed && roundReady) {
			struct mTiming* timing = coreTiming(sio);
			if (timing) {
				if (mTimingIsScheduled(timing, &sio->sioSlaveDone)) {
					SIO_LOG("slave DOUBLE-SCHEDULE caught (armed=%d)", sio->sioSlaveArmed);
				}
				mTimingSchedule(timing, &sio->sioSlaveDone, sio->sioSlavePeriod);
				sio->sioSlaveArmed = true;
			}
		}
	}
	/* Drain the host's transfer requests first (a queued request must finish
	 * before the watchdog could clear Busy). */
	int guard = 0;
	uint16_t seq;
	uint16_t mode;
	uint32_t value;
	int player;
	while (guard++ < 8 && netLinkTakeRequest(sio->link, &seq, &mode, &value, &player)) {
		if (sio->sioWaiting) {
			/* Waiting for our own transfer's reply: both sides would be master
			 * (never happens - only 1P starts MULTI). Drop to avoid finishing
			 * the same transfer twice. */
			continue;
		}
		if (mode == GBA_SIO_MULTI) {
			/* MULTI no longer travels as a request: both sides push per round
			 * and finish on their own cadence. */
			continue;
		}
		finishIncoming(sio, mode, value, player);
	}
}

static void linkPollEvent(struct mTiming* timing, void* user, uint32_t cyclesLate) {
	UNUSED(cyclesLate);
	struct SioLink* sio = (struct SioLink*) user;
	serviceLink(sio);
	/* [diag]/[room] 统一由 sioLinkPump 输出（Qt 帧循环无条件调用，链路没连上
	 * 时也有）。这里只负责续期：链路可能在游戏已进入菜单之后才连上，停在
	 * 这里就再也不会 attachLink。 */
	mTimingSchedule(timing, &sio->linkEvent, 8192);
}

/**
 * Slave-side "round complete" event.
 *
 * Why the slave's emulated clock must be pinned to the host's cadence: the
 * game's link code enqueues one command and dequeues one command per VBlank.
 * If the two emulators advance their clocks at different rates, one queue
 * overflows (queueFull -> communication error) while the other drains empty.
 * The round therefore completes exactly "last completion + K" emulated
 * cycles later, K = one host round (transfer 5755 + Timer3 12608 ~ 18363);
 * when the peer's word has not arrived yet the event takes it with a short
 * bounded real-time wait (the emulated clock is frozen while blocked, so the
 * rate stays locked).
 *
 * The round number belongs to the host alone: both sides counting on their
 * own diverge immediately, so the slave takes the word with the "loose"
 * entry (netLinkTakePeerWordAny), adopts the host's index and pushes its own
 * word back tagged with it - the host's strict match then never misses.
 */
static int sioWaitMs(struct SioLink* sio);
static int sioPeerWaitMs(struct SioLink* sio);
static int sioPipelineWaitMs(struct SioLink* sio, int want);

static void sioSlaveDoneEvent(struct mTiming* timing, void* user, uint32_t cyclesLate) {
	struct SioLink* sio = (struct SioLink*) user;
	sio->sioSlaveArmed = false;
	if (!sio->link || !sio->linkAttached || !sio->core) {
		return;
	}
	if (sio->core->platform(sio->core) != mPLATFORM_GBA) {
		return;
	}
	struct GBA* gba = (struct GBA*) sio->core->board;
	if (gba->sio.mode != GBA_SIO_MULTI) {
		return;
	}
	/* 角色看游戏（gLink.isMaster==8 = 主机），不看链路层的 player 号：
	 * 走云端房间时两端链路层都是 TCP 主机、player 号都停在 0，用它判会让
	 * **两端都走这个分支直接 return**，谁都不当从机、谁都不回推字
	 *（现场：两端日志同时报 me=0，主机侧 done want=1 have=0 永远等不到）。 */
	if (GBAView8(gba->cpu, 0x03002AF4u + 0x00u) == 8) {
		return;
	}
	/* bus 模式下的启动期保护：游戏还没进入联机代码（gLinkCallback == 0）时，
	 * boot/BIOS 的 MULTI 探测不该被总线参与。否则三核在启动期就互相喂字，
	 * boot 卡在 `MULTI m=494E im=0 pc=0` 再也进不去（实测 3 人 cb2=0）。
	 * 2 人直连路径不走这里，行为不变。 */
	if (netLinkBusActive(sio->link)
	    && GBAView16(gba->cpu, 0x03002AD4u) == 0
	    && GBAView16(gba->cpu, 0x03002AD6u) == 0) {
		/* 同主机侧：boot 期不参与总线，用空槽收尾让启动继续。 */
		static unsigned gateN;
		if (++gateN <= 5 || (gateN % 3000) == 0) {
			fprintf(stderr, "GATESLAVE n=%u me=%d mode=%d idx=%u\n",
			        gateN, netLinkPlayer(sio->link), (int) gba->sio.mode,
			        (unsigned) sio->sioIndex);
		}
		sio->sioWaiting = false;
		sio->sioRetries = 0;
		uint32_t emptyVals[4] = { 0xFFFFu, 0xFFFFu, 0xFFFFu, 0xFFFFu };
		int bp = netLinkBusPlayers(sio->link);
		if (bp < 2) {
			bp = 2;
		}
		completeMultiTransferBus(sio, emptyVals, bp, cyclesLate);
		return;
	}
	/* 3/4 人总线：从机先把自己的字推给主机（主机要收齐才广播），再等广播。
	 * 两人走下面原来的「取对端字 → 收尾 → 回推」路径。 */
	{
		int busPlayers = netLinkBusPlayers(sio->link);
		if (netLinkBusActive(sio->link) && busPlayers >= 2) {
			uint16_t own = sio->sioRoundWordValid ? sio->sioRoundWord
			                                      : gba->memory.io[GBA_REG(SIOMLT_SEND)];
			sio->sioRoundWordValid = false;
			uint32_t busVals[4];
			uint16_t used = sio->sioIndex;
			int busGot = netLinkBusRound(sio->link, sio->sioIndex, own, busVals, busPlayers,
			                             sioPipelineWaitMs(sio, -1), &used);
			if (busGot < 0) {
				/* 主机还没广播（还在等别的从机）：快速重挂，绝不拿空槽收尾
				 * —— 一次空槽就会让游戏的 DoHandshake 把 playerCount 清 0。 */
				++sio->sioTimeouts;
				if (timing) {
					mTimingSchedule(timing, &sio->sioSlaveDone, 2048);
					sio->sioSlaveArmed = true;
				}
				return;
			}
			{
				uint32_t peerCycles = netLinkBusRoundCycles(sio->link);
				if (peerCycles != 0) {
					if (sio->sioPeerCyclesValid) {
						uint32_t delta = peerCycles - sio->sioPeerCycles;
						if (delta > 4000 && delta < 400000) {
							sio->sioSlavePeriod = delta;
						}
					}
					sio->sioPeerCycles = peerCycles;
					sio->sioPeerCyclesValid = true;
				}
			}
			if (used != sio->sioIndex) {
				++sio->sioMisorder;
			}
			sio->sioIndex = used;
			sio->sioHasRemote = true;
			sio->sioRemote = busVals[0];
			completeMultiTransferBus(sio, busVals, busPlayers, cyclesLate);
			sio->sioPushValue = own;
			sio->sioPushIndex = sio->sioIndex;
			sio->sioPushed = true;
			if (timing) {
				mTimingSchedule(timing, &sio->sioSlaveDone, sio->sioSlavePeriod);
				sio->sioSlaveArmed = true;
			}
			return;
		}
	}
	uint16_t got = 0;
	uint32_t remote = 0;
	uint32_t peerCycles = 0;
	/* Take the earliest unconsumed word (loose entry). Across a tunnel the
	 * master's next push is a round trip away; while a battle/trade exchange
	 * is actively flowing (the master's pushes arriving every couple hundred
	 * ms), BLOCK the emulated clock for the wait - otherwise the slave's game
	 * VBlanks hundreds of times per master round, the per-frame round counts
	 * collapse below the game's 9-per-frame requirement and the game reports
	 * a connection error at the start of every battle/trade. Outside an
	 * active exchange keep the historical non-blocking spin so an idle link
	 * never drags the game's frame rate down. */
	int waitMs = sioPipelineWaitMs(sio, -1);
	bool have = netLinkTakePeerWordAny(sio->link, sio->sioIndex, waitMs, &remote, &got, &peerCycles);
	if (!have) {
		/* A slave never finishes without peer data: on real hardware the
		 * round simply does not end until the host's clock touches it.
		 * Finishing early would feed the game an empty slot and desync both
		 * round counters. */
		++sio->sioTimeouts;
		if ((sio->sioTimeouts & 0xFF) == 0) {
			int qCount = 0;
			unsigned qHead = 0;
			netLinkPeerHeadInfo(sio->link, &qCount, &qHead);
			SIO_LOG("slave miss t=%u link=%p idx=%u q=%d head=%u state=%d mode=%d",
			        (unsigned) mTimingCurrentTime(timing), (void*) sio->link,
			        (unsigned) sio->sioIndex, qCount, qHead,
			        netLinkState(sio->link), (int) gba->sio.mode);
		}
		if (timing) {
			mTimingSchedule(timing, &sio->sioSlaveDone, 2048);
			sio->sioSlaveArmed = true;
		}
		return;
	}
	if (peerCycles != 0) {
		/* Track the host's true round period from its timestamps; the slave
		 * schedules its rounds at the same period so per-frame round counts
		 * match. */
		if (sio->sioPeerCyclesValid) {
			uint32_t delta = peerCycles - sio->sioPeerCycles;
			if (delta > 4000 && delta < 400000) {
				sio->sioSlavePeriod = delta;
			}
		}
		sio->sioPeerCycles = peerCycles;
		sio->sioPeerCyclesValid = true;
	}
	uint16_t own = sio->sioRoundWordValid ? sio->sioRoundWord
	                                      : gba->memory.io[GBA_REG(SIOMLT_SEND)];
	sio->sioRoundWordValid = false;
	if (got != sio->sioIndex) {
		/* Round jump (host skipped rounds, or the slave just joined): adopt
		 * the host's number, the pairing stays one-to-one. */
		++sio->sioMisorder;
	}
	sio->sioIndex = got;
	sio->sioHasRemote = true;
	sio->sioRemote = remote;
	completeMultiTransfer(sio, remote, true, cyclesLate);
	/* Push this round's own word back, tagged with the host's round number:
	 * the host's strict (want == got) matching then always lines up. */
	struct mTiming* timing2 = coreTiming(sio);
	uint32_t stamp = timing2 ? mTimingCurrentTime(timing2) : 0;
	netLinkPush(sio->link, GBA_SIO_MULTI, own, sio->sioIndex, stamp);
	sio->sioPushValue = own;
	sio->sioPushIndex = sio->sioIndex;
	sio->sioPushed = true;
	/* Arm the next round: exactly K emulated cycles later. */
	if (timing) {
		mTimingSchedule(timing, &sio->sioSlaveDone, sio->sioSlavePeriod);
		sio->sioSlaveArmed = true;
	}
}

/**
 * Master-side "transfer due" event: the peer's reply is fetched with a
 * bounded real-time wait (the emulated clock freezes while waiting, so a
 * frame still hosts real-machine-scale transfer counts). A timeout finishes
 * with empty slots - never with a stale value from the previous round, which
 * is exactly what corrupted checksums in earlier attempts.
 */
/* 跨网等待窗：局域网 RTT 1-3ms，800ms 绰绰有余；走服务器隧道 RTT 上百毫秒
 * 还会抖（手机网络尖峰能到秒级），固定 800ms 必然误超时——超时一次就用空槽
 * 收尾，游戏立刻报「连接发生了错误」。等待窗跟随实测 RTT（20 倍余量），
 * 下限仍是局域网的 800ms，上限 20s 防死等。等待期间模拟时钟冻结，游戏自己
 * 不会超时，只是这一轮变慢。 */
/* 本轮到底允不允许阻塞模拟线程（与安卓侧 sioPeerWaitMs 同一条判据）。
 *
 * 隧道连着（state==2）不等于对端在跑联机：对端停在开机/标题画面时一个字都
 * 不推，这边若照 sioWaitMs（RTT×20，实测能到 3s）死等，模拟线程就被按在
 * 超时窗里，整帧不动——安卓侧就是这么假死掉的，PC 侧在握手期同样会 0.7fps。
 *   - 队列里有对端字   → 最多 400ms（实际就是取队列）
 *   - 对端 800ms 内推过 → 最多 400ms（覆盖 150ms 级 RTT 的晚到）
 *   - 对端完全没动静   → 0，立刻用空槽收尾
 */
static int sioPeerWaitMs(struct SioLink* sio) {
	if (!sio->link || netLinkState(sio->link) != 2) {
		return 0;
	}
	if (netLinkBusActive(sio->link)) {
		/* 星型总线只跑局域网/本机环回。两人跨公网隧道的 300~1200ms 下限会
		 * 把每轮锁步钉在半秒以上：轮次一旦错配，主机等从机字、从机等广播，
		 * 两边都等满窗 —— busgame 实测从机 45s 只推进 312 帧（6.9fps）、
		 * cnt 恒 0。给 3 倍实测 RTT，下限 2ms（本机环回 RTT≈0.1ms，原 12ms
		 * 下限让每个落后轮次都付满 12ms，9 轮/帧把帧率压到约 5fps、永远到
		 * 不了游戏侧 MULTI）、上限 120ms；字到达时 cond_broadcast 仍会立刻
		 * 唤醒，所以本机环回几乎零等待，LAN（RTT≥3ms×3≈9~12ms）行为不变。 */
		uint32_t ms = (netLinkRttUs(sio->link) / 1000u) * 3u;
		if (ms < 2u) {
			ms = 2u;
		}
		if (ms > 120u) {
			ms = 120u;
		}
		return (int) ms;
	}
	if (netLinkPeerPending(sio->link) > 0) {
		return 1200;
	}
	if (netLinkPushAgeMs(sio->link) < 800) {
		return 900;
	}
	/* 链路刚建立的前几轮，对端一个字都还没推过：pushSeenAt=0 →
	 * netLinkPushAgeMs 返回极大值，上面两条都不命中，这里就会返回 0。
	 * 可这恰恰是最需要等一个 RTT 的时刻——主机已经把本轮字推出去了，
	 * 从机的回字还在隧道上（实测 RTT 231ms）。零等待配上 100 cycles
	 * 的重试间隔，27 次重试在不到 1ms 内耗尽，主机按空槽收尾；等从机
	 * 字到达时已经没人取了。现场证据：PC 只收到 PUSH #1、安卓只有
	 * HSP #1，两端 ST 在 0/1 之间反复，done want=1 retries=27。
	 * 给前 8 轮、且只在头 3 次重试里开 900ms 预算（避免 40×900ms 的
	 * 新假死）；之后仍无对端字说明它根本没进联机，恢复 0。 */
	if (sio->sioWaiting && sio->sioIndex <= 8 && sio->sioRetries < 3) {
		return 900;
	}
	/* 隧道往返 82~231ms 且抖动明显，对端 PUSH 的到达间隔会间歇超过 800ms。
	 * 此时若返回 0，40 次重试（间隔仅 100 cycles）会在极短时间内耗尽并按
	 * 空槽收尾，把玩家数据块的校验搅坏 —— 隧道轮实测 brs=0000/0000、
	 * cnt 恒 0、LINKUP 停在「等待连接…」，而直连 12ms 轮能跑 4416 轮零超时。
	 * 只要游戏确实发起了本轮 MULTI 传输（sioWaiting）且链路还连着，就给
	 * 一个跟随实测 RTT 的最小预算（300~1200ms）。链路断开或游戏没在传
	 * MULTI 时仍是 0，不会重现 11-08 那种整帧假死。 */
	if (sio->sioWaiting) {
		uint32_t ms = (netLinkRttUs(sio->link) / 1000u) * 3u;
		if (ms < 300u) {
			ms = 300u;
		}
		if (ms > 1200u) {
			ms = 1200u;
		}
		return (int) ms;
	}
	return 0;
}

static int sioWaitMs(struct SioLink* sio) {
	uint32_t rttUs = sio->link ? netLinkRttUs(sio->link) : 0;
	uint32_t ms = (rttUs / 1000u) * 20u;
	if (ms < 800) {
		ms = 800;
	}
	if (ms > 20000) {
		ms = 20000;
	}
	return (int) ms;
}

/* 按帧流水线（默认关闭）：队列里已有对端字就零等待消费，一帧 9 轮只付
 * 一次网络往返；队列空时才给一次整批预算（跟随实测 RTT）。字仍按轮次
 * 严格配对，不用陈旧字补槽，LINKUP 的块校验不受影响。 */
static bool sioPipelineMode(void) {
	static int enabled = -1;
	if (enabled < 0) {
		enabled = getenv("MGBAX_SIO_PIPELINE") ? 1 : 0;
	}
	return enabled != 0;
}

static int sioPipelineWaitMs(struct SioLink* sio, int want) {
	/* 总线不受两人按帧流水线开关影响，始终用局域网短窗。 */
	if (sio->link && netLinkBusActive(sio->link)) {
		return sioPeerWaitMs(sio);
	}
	if (!sioPipelineMode()) {
		return sioPeerWaitMs(sio);
	}
	if (!sio->link || netLinkState(sio->link) != 2) {
		return 0;
	}
	if (netLinkPeerPending(sio->link) > 0) {
		/* 队列非空不等于**本轮**的字已经到：按帧流水线一帧批量到达时队首
		 * 常常是后续轮次。只有队首正是本轮才零等待消费，否则照样得等
		 * 本轮的字（交给 takePeerWord 自己判，等待窗按 RTT 给）。 */
		if (want < 0) {
			return 0;
		}
		int qCount = 0;
		unsigned qHead = 0;
		netLinkPeerHeadInfo(sio->link, &qCount, &qHead);
		if (qCount > 0 && (int) qHead == want) {
			return 0;
		}
	}
	uint32_t ms = (netLinkRttUs(sio->link) / 1000u) * 3u;
	if (ms < 500u) {
		ms = 500u;
	}
	if (ms > 4000u) {
		ms = 4000u;
	}
	return (int) ms;
}

/* 联机帧率：握手/卡片交换完成后不再按墙钟等对端字。
 *
 * 实测 3.7fps 的成因不是网络：P2P 直连 RTT 只有 6~13ms，但每帧 9 轮
 * MULTI 传输，每轮 sioDoneEvent 都在 takePeerWord 上冻结模拟时钟
 * （SIO_LOG 统计 wait=24~32ms/轮 n=64），9×28ms≈250ms，正好一帧 270ms。
 * 两端都在等对方推进下一帧，形成一个互相拖住的锁步环。
 *
 * 这里在链路健康时改成「零等待取本轮字，取不到就复用上一轮对端字」：
 * 模拟时钟不再被墙钟按停，每帧仍然是 9 次 SIO 中断（游戏 LAG 判定按
 * 模拟帧计数，不按墙钟），帧率回到接近单机；复用字只影响对端按键的
 * 新鲜度，比空槽 0xFFFF 安全得多（空槽会直接触发通信错误）。
 *   - 前 256 轮（LINKUP / 训练家卡片块交换）保持严格等待，避免块校验坏掉
 *   - 会话判据用 gLink.state + playerCount + 玩家数三者同时满足，不看 RTT
 *   - MGBAX_SIO_FAST=0 可整体关掉这次优化，便于 A/B 对照
 */
static bool sioFastFrame(struct SioLink* sio) {
	static int disabled = -1;
	if (disabled < 0) {
		const char* v = getenv("MGBAX_SIO_FAST");
		disabled = (v && atoi(v) == 0) ? 1 : 0;
	}
	/* 链路断开或优化被关掉：解除锁存，下次重新等到 cnt>=2 才放开。 */
	if (disabled || !sio->link || netLinkState(sio->link) != 2) {
		sio->sioFastLatched = false;
		sio->sioFastMiss = 0;
		return false;
	}
	if (sio->sioFastLatched) {
		return true;
	}
	if (sio->sioOk < 256) {
		return false;
	}
	/* 只在 LINKUP 真正完成后放开帧率：握手与训练家卡片块交换期间每一轮
	 * 都必须是真实对端字，复用上一轮字会破坏块校验（历史结论：空槽/陈旧
	 * 字会把 cnt 打回 0，停在「等待连接」）。fieldLinkPlayerCount 取自
	 * 0x03004A38 高字节，与 [room] 诊断里的 cnt 同源。 */
	if (!sio->core || sio->core->platform(sio->core) != mPLATFORM_GBA) {
		return false;
	}
	struct GBA* gba = (struct GBA*) sio->core->board;
	if (!gba || !gba->cpu) {
		return false;
	}
	/* 只看 cnt 会误判：02:03 轮 [diag] lstate=1 pc=0（gLink 会话根本没
	 * 建立）却出现 [room] cnt=2，那是上一局遗留的内存值，结果快速帧在
	 * 握手/块交换阶段就被触发、复用旧字，末尾 [diag] linkup=6（连接错误）。
	 * gLink.state（0x03002AF5）与 playerCount（0x03002AF7）才是真实判据：
	 * 历史成功轮为 lstate=4 pc=2，未建立时为 lstate=1 pc=0。
	 * 三个条件同时满足才认定会话已建立，避免损坏 LINKUP 块校验。 */
	uint16_t gl0 = GBAView16(gba->cpu, 0x03002AF4u);
	uint16_t gl1 = GBAView16(gba->cpu, 0x03002AF6u);
	if (((gl0 >> 8) & 0xFF) < 2 || ((gl1 >> 8) & 0xFF) < 2) {
		return false;
	}
	if ((GBAView16(gba->cpu, 0x03004A38u) >> 8) < 2) {
		return false;
	}
	/* 会话建立过一次就锁存。02:03 实测 cnt 会抖动，不锁存时同一个 64 次
	 * 传输窗口里只有 22 次走快速路径（fb=22 / n=42），其余 42 次仍按
	 * 23~32ms/轮 阻塞，帧率被反复拖回去。 */
	sio->sioFastLatched = true;
	return true;
}

static void sioDoneEvent(struct mTiming* timing, void* user, uint32_t cyclesLate) {
	UNUSED(timing);
	struct SioLink* sio = (struct SioLink*) user;
	if (!sio->sioWaiting) {
		return;
	}
	/* 3/4 人总线：主机在这一刻收齐所有从机本轮的字，再一次性广播给它们。
	 *
	 * 两处判据都不能省：
	 *   - 必须用 netLinkBusActive()，不能按人数。总线里只有一个从机时
	 *     netLinkBusPlayers() 正好是 2，按人数判会掉进下面的两人直连分支，
	 *     而总线的字根本不进 peerQ，结果永远是「对端没回字」。
	 *   - 必须放在 sioFastFrame / netLinkTakePeerWord 之前：那两个会去空的
	 *     peerQ 上等，白白空耗满整个等待窗。 */
	{
		int busPlayers = netLinkBusPlayers(sio->link);
		if (netLinkBusActive(sio->link) && busPlayers >= 1
		    && sio->core && sio->core->platform(sio->core) == mPLATFORM_GBA) {
			struct GBA* gbaBus = (struct GBA*) sio->core->board;
			/* boot/BIOS 阶段（游戏还没进入联机代码，gLinkCallback==0）不能
			 * 走总线：否则三核在启动期互相喂字，boot 卡在 494E 再也进不去
			 *（实测 3 人 cb2=0；同条件不挂链接则能到菜单）。这里用空槽把
			 * 本轮收尾，让启动代码像「单机无对端」一样继续跑。 */
			if (GBAView16(gbaBus->cpu, 0x03002AD4u) == 0
			    && GBAView16(gbaBus->cpu, 0x03002AD6u) == 0) {
				uint32_t emptyVals[4] = { 0xFFFFu, 0xFFFFu, 0xFFFFu, 0xFFFFu };
				/* 必须清 sioWaiting：gbaLinkStart 见到它就把后续所有 MULTI
				 * 起始直接拒绝（返回 false）。之前这里只 return，导致主机
				 * 整个运行只启动过一次 MULTI（BEGIN n=1），之后再不起传输。 */
				sio->sioWaiting = false;
				sio->sioRetries = 0;
				completeMultiTransferBus(sio, emptyVals, busPlayers, cyclesLate);
				return;
			}
			uint32_t busVals[4];
			uint16_t used = sio->sioIndex;
			uint32_t own = gbaBus->memory.io[GBA_REG(SIOMLT_SEND)];
			int busGot = netLinkBusRound(sio->link, sio->sioIndex, own, busVals, busPlayers,
			                             sioPipelineWaitMs(sio, (int) sio->sioIndex), &used);
			if (busPlayers < 2) {
				busPlayers = 2;   /* 还没从机连上：按「只有自己」收尾 */
			}
			if (busGot <= 0 && sio->sioRetries < 3 && netLinkState(sio->link) == 2) {
				/* 有从机连着却一个都没收到：它们慢了一拍，不是没有。重试几次
				 * 再按空槽收尾，否则一次迟到就把这一轮的握手数据变成 0xFFFF。 */
				++sio->sioRetries;
				struct mTiming* t2 = coreTiming(sio);
				if (t2) {
					mTimingSchedule(t2, &sio->sioDone, 100);
					return;   /* sioWaiting 保持 true */
				}
			}
			sio->sioRetries = 0;
			sio->sioWaiting = false;
			sio->sioHasRemote = busGot > 0;
			sio->sioRemote = busVals[0];
			if (busGot <= 0) {
				SIO_LOG("BUS host round me=%d idx=%u got=%d n=%d",
				        netLinkPlayer(sio->link), (unsigned) sio->sioIndex, busGot, busPlayers);
			}
			completeMultiTransferBus(sio, busVals, busPlayers, cyclesLate);
			return;
		}
	}
	if (sioFastFrame(sio)) {
		uint32_t fastRemote = 0;
		uint16_t fastGot = 0;
		bool haveFast = sio->link &&
		    netLinkTakePeerWord(sio->link, sio->sioIndex, 0, &fastRemote, &fastGot, NULL);
		if (haveFast) {
			sio->sioFastMiss = 0;
		} else {
			++sio->sioFastMiss;
		}
		if (!haveFast && sio->sioHasRemote) {
			fastRemote = sio->sioRemote;
			haveFast = true;
			++sio->sioFallback;
		}
		/* 连续 240 轮（约 27 帧）一个新字都没拿到，说明对端停摆：解除
		 * 锁存，下一轮回到严格等待，不用越来越旧的字一直喂游戏。 */
		if (sio->sioFastMiss >= 240) {
			sio->sioFastLatched = false;
			sio->sioFastMiss = 0;
		}
		sio->sioWaiting = false;
		if (haveFast) {
			sio->sioHasRemote = true;
			sio->sioRemote = fastRemote;
		}
		completeMultiTransfer(sio, fastRemote, haveFast, cyclesLate);
		return;
	}
	uint32_t remote = 0;
	uint16_t got = 0;
	uint32_t waitT0 = wallNowMs();
	bool haveRemote = sio->link && netLinkTakePeerWord(sio->link, sio->sioIndex, sioPipelineWaitMs(sio, (int) sio->sioIndex), &remote, &got, NULL);
	{
		uint32_t dw = (uint32_t) (wallNowMs() - waitT0);
		sio->sioWaitSumMs += dw;
		++sio->sioWaitN;
		if (dw > sio->sioWaitMaxMs) {
			sio->sioWaitMaxMs = dw;
		}
	}
	/* 这里是每轮传输必经点：无条件打印会变成每帧上千行 IO，直接拖垮帧率。
	 * 只在「没拿到对端数据」或显式打开 MGBAX_SIO_TRACE 时才落日志。 */
	if (!haveRemote || getenv("MGBAX_SIO_TRACE")) {
		SIO_LOG("done want=%u have=%d got=%u retries=%u rtt=%u pending=%d",
		        (unsigned) sio->sioIndex, haveRemote ? 1 : 0, (unsigned) got,
		        (unsigned) sio->sioRetries, netLinkRttUs(sio->link), netLinkPeerPending(sio->link));
	}
	if (haveRemote) {
		if (got != sio->sioIndex) {
			++sio->sioMisorder;
		}
		sio->sioWaiting = false;
		sio->sioHasRemote = true;
		sio->sioRemote = remote;
		completeMultiTransfer(sio, remote, true, cyclesLate);
		return;
	}
	sio->sioTimeouts++;
	/* 对端还在线就继续等，别急着用空槽收尾：跨网时对端的字只是迟到（RTT
	 * 尖峰、手机切基站），不是没有。等待继续冻结模拟时钟，游戏看不见这段
	 * 时间；真机语义也一样——从机不回字，线路就不动。真正断线（state≠2）
	 * 或重试次数/墙钟上限耗尽才按「这一轮没有对端数据」收尾。
	 *
	 * 墙钟上限看的是**这一轮**累计等了多久：每轮等待窗现在能到 4s，光靠
	 * 40 次重试计数会变成 160s 的死等，一个僵死的对端就能把整帧按住不放。 */
	if (sio->sioRetries == 0) {
		sio->sioRetryWall = wallNowMs();
	}
	if (sio->link && netLinkState(sio->link) == 2 && sio->sioRetries < 40 &&
	    (uint32_t) (wallNowMs() - sio->sioRetryWall) < 20000u) {
		++sio->sioRetries;
		struct mTiming* t2 = coreTiming(sio);
		if (t2) {
			mTimingSchedule(t2, &sio->sioDone, 100);
			return;
		}
	}
	sio->sioWaiting = false;
	completeMultiTransfer(sio, 0, false, cyclesLate);
}

static bool beginMultiTransfer(struct SioLink* sio, struct GBASIODriver* driver) {
	if (!sio->link || !sio->linkAttached || !sio->core || !driver->p || driver->p->mode != GBA_SIO_MULTI) {
		return false;
	}
	if (sio->core->platform(sio->core) != mPLATFORM_GBA) {
		return false;
	}
	struct GBA* gba = (struct GBA*) sio->core->board;
	uint16_t local = gba->memory.io[GBA_REG(SIOMLT_SEND)];
	static unsigned beginN;
	if (++beginN <= 12 || (beginN % 3000) == 0) {
		fprintf(stderr, "BEGIN n=%u me=%d mode=%d idx=%u cb=%04X%04X\n",
		        beginN, netLinkPlayer(sio->link), (int) driver->p->mode,
		        (unsigned) sio->sioIndex,
		        GBAView16(gba->cpu, 0x03002AD6u), GBAView16(gba->cpu, 0x03002AD4u));
	}
	++sio->sioIndex;
	sio->sioWaiting = true;
	sio->sioRetries = 0;
	struct mTiming* timing = coreTiming(sio);
	if (!timing) {
		return false;
	}
	sio->sioStartCycle = mTimingCurrentTime(timing);
	/* 1P generates the clock, and by the time it writes SIOCNT the game has
	 * already written this round's word into SIOMLT_SEND - so push it once,
	 * here. Pushing again for the same round would fill the next round's slot
	 * with a stale value and desync the pairing by one. */
	if (!sio->sioPushed || sio->sioPushIndex != sio->sioIndex) {
		netLinkPush(sio->link, GBA_SIO_MULTI, local, sio->sioIndex, sio->sioStartCycle);
		sio->sioPushValue = local;
		sio->sioPushIndex = sio->sioIndex;
		sio->sioPushed = true;
	}
	mTimingDeschedule(timing, &sio->sioDone);
	/* The transfer period must be computed at 115200 baud (5755 cycles): the
	 * core's SIOCNT write clears the baud bits (63427 cycles at baud 0),
	 * which starves the game's 9-rounds-per-frame requirement and makes it
	 * report a communication error. */
	uint16_t siocnt = (uint16_t) ((driver->p->siocnt & ~0x0003u) | 0x0003u);
	mTimingSchedule(timing, &sio->sioDone, GBASIOTransferCycles(GBA_SIO_MULTI, siocnt, gbaLinkDevices(driver)));
	return true;
}

static bool gbaLinkInit(struct GBASIODriver* driver) {
	struct SioLink* sio = ((struct GbaLinkDriver*) driver)->sio;
	sio->linkEvent.context = sio;
	sio->linkEvent.callback = linkPollEvent;
	sio->linkEvent.name = "Qt Link";
	sio->linkEvent.priority = 0x70;
	sio->sioDone.context = sio;
	sio->sioDone.callback = sioDoneEvent;
	sio->sioDone.name = "Qt SIO Done";
	sio->sioDone.priority = 0x7F;
	sio->sioSlaveDone.context = sio;
	sio->sioSlaveDone.callback = sioSlaveDoneEvent;
	sio->sioSlaveDone.name = "Qt SIO Slave Done";
	sio->sioSlaveDone.priority = 0x7E;
	sio->sioSlavePeriod = 18363;
	sio->sioSlaveArmed = false;
	sio->sioPeerCyclesValid = false;
	armLinkEvent(sio);
	return true;
}

static void gbaLinkDeinit(struct GBASIODriver* driver) {
	struct SioLink* sio = ((struct GbaLinkDriver*) driver)->sio;
	struct mTiming* timing = coreTiming(sio);
	sio->sioWaiting = false;
	sio->sioSlaveArmed = false;
	sio->sioPeerCyclesValid = false;
	if (timing) {
		mTimingDeschedule(timing, &sio->linkEvent);
		mTimingDeschedule(timing, &sio->sioDone);
		mTimingDeschedule(timing, &sio->sioSlaveDone);
	}
}

static void gbaLinkReset(struct GBASIODriver* driver) {
	struct SioLink* sio = ((struct GbaLinkDriver*) driver)->sio;
	sio->sioWaiting = false;
	/* After a reset the game re-decides master/slave, so the "alone on the
	 * bus" presentation window reopens. */
	sio->sioInitSeen = false;
	armLinkEvent(sio);
}

static uint32_t gbaLinkId(const struct GBASIODriver* driver) {
	UNUSED(driver);
	return 0x4C4B4E41u;
}

static bool gbaLinkLoadState(struct GBASIODriver* driver, const void* state, size_t size) {
	UNUSED(driver);
	UNUSED(state);
	UNUSED(size);
	return true;
}

static void gbaLinkSaveState(struct GBASIODriver* driver, void** state, size_t* size) {
	UNUSED(driver);
	*state = NULL;
	*size = 0;
}

static void gbaLinkSetMode(struct GBASIODriver* driver, enum GBASIOMode mode) {
	UNUSED(driver);
	UNUSED(mode);
}

static bool gbaLinkHandles(struct GBASIODriver* driver, enum GBASIOMode mode) {
	UNUSED(driver);
	return mode == GBA_SIO_MULTI || mode == GBA_SIO_NORMAL_8 || mode == GBA_SIO_NORMAL_32;
}

static int gbaLinkDevices(struct GBASIODriver* driver) {
	struct SioLink* sio = ((struct GbaLinkDriver*) driver)->sio;
	/* 对端数（不含自己）。两人联机是 1：内核据此用 2P 的传输周期，填 2 会按
	 * 3P 算、比真机慢 50%，超出游戏的超时窗口。
	 *
	 * 3/4 人总线必须按实际人数上报：一直返回 1 会让每一轮都按 2P 的周期算，
	 * 比真机的 3P/4P 周期短，游戏数出来的每帧轮次数就不对了。 */
	if (sio && netLinkBusActive(sio->link)) {
		int players = netLinkBusPlayers(sio->link);
		if (players > 2) {
			return players - 1;
		}
	}
	return 1;
}

static int gbaLinkDeviceId(struct GBASIODriver* driver) {
	return netLinkPlayer(((struct GbaLinkDriver*) driver)->sio->link);
}

static uint16_t gbaLinkWriteCnt(struct GBASIODriver* driver, uint16_t value) {
	struct SioLink* sio = ((struct GbaLinkDriver*) driver)->sio;
	static int wrDbg = 0;
	if (wrDbg < 12) {
		++wrDbg;
		SIO_LOG("writeCnt %04X mode=%d", value, driver->p ? (int) driver->p->mode : -1);
	}
	if (driver->p && driver->p->mode == GBA_SIO_MULTI) {
		/* The core only treats SIOCNT bit7 (Busy) rising as "start transfer",
		 * but Pokemon-family link code starts a MULTI transfer by writing
		 * 0x600F (IRQ set, Busy left to the hardware). Treat an IRQ-bit write
		 * with no transfer pending as a start request too - the !sioWaiting
		 * guard keeps one transfer from being started twice. */
		bool nowBusy = (value & 0x0080) != 0;
		bool irq = (value & 0x4000) != 0;
		bool wantStart = nowBusy || (irq && !sio->sioWaiting);
		if (wantStart) {
			if (!sio->sioWaiting && netLinkPlayer(sio->link) == 0) {
				/* Only 1P actually starts the transfer; the slave's round is
				 * driven by 1P's push (see serviceLink/sioSlaveDoneEvent). */
				beginMultiTransfer(sio, driver);
			}
			else if (!sio->sioWaiting && netLinkPlayer(sio->link) != 0) {
				/* 从机起轮：此刻 SIOMLT_SEND 里就是本轮要发出去的字，扣下来
				 * 独占给本轮（见 sioRoundWord 注释）。 */
				if (sio->core && sio->core->platform(sio->core) == mPLATFORM_GBA) {
					struct GBA* g = (struct GBA*) sio->core->board;
					sio->sioRoundWord = g->memory.io[GBA_REG(SIOMLT_SEND)];
					sio->sioRoundWordValid = true;
				}
			}
		}
		uint16_t out = GBASIOMultiplayerFillReady(GBASIOMultiplayerClearError(value));
		/* Baud fix: the core's GBASIOWriteSIOCNT MULTI branch clears the baud
		 * bits and only glues back bits 2..7, leaving GBASIOMultiplayerGetBaud
		 * at 0 (63427 cycles per transfer instead of 5755 at 115200). The
		 * game's LinkVSync requires 9+ SIO interrupts per frame; at baud 0
		 * the master only manages 3.7 and every link ends in "communication
		 * error". Restore 115200 (the game's own EnableSerial writes 0x6003,
		 * baud 3, anyway). */
		out = (uint16_t) ((out & ~0x0003u) | 0x0003u);
		/* Terminal bits (Slave bit2 / Ready bit3 / Id bits4-5): the core's
		 * `value |= sio->siocnt & 0x00FC` makes them sticky, so the driver
		 * rewrites them from the link's true state every time:
		 *   not connected -> alone on the bus -> Slave=1;
		 *   connected as 0 -> Slave=0 (master);
		 *   connected as 1..3 -> Slave=1. */
		if (sio->linkAttached && sio->link) {
			int me = netLinkPlayer(sio->link);
			bool up = netLinkState(sio->link) == 2;
			bool slave = !up || me != 0;
			out = GBASIOMultiplayerSetSlave(out, slave);
			out = GBASIOMultiplayerSetId(out, up ? me : 0);
		}
		return out;
	}
	if (driver->p && (driver->p->mode == GBA_SIO_NORMAL_8 || driver->p->mode == GBA_SIO_NORMAL_32)) {
		return GBASIONormalFillSi(value);
	}
	return value;
}

static uint16_t gbaLinkWriteRcnt(struct GBASIODriver* driver, uint16_t value) {
	UNUSED(driver);
	return value;
}

static bool gbaLinkStart(struct GBASIODriver* driver) {
	struct SioLink* sio = ((struct GbaLinkDriver*) driver)->sio;
	if (!sio->link || !sio->core || !driver->p || driver->p->mode != GBA_SIO_MULTI) {
		return true;
	}
	if (sio->core->platform(sio->core) != mPLATFORM_GBA) {
		return true;
	}
	if (sio->sioWaiting) {
		/* Pokemon starts a transfer with two SIOCNT writes (0x600F then Busy):
		 * beginMultiTransfer already ran on the first one, re-beginning would
		 * overwrite the reply sequence. */
		return false;
	}
	if (netLinkPlayer(sio->link) != 0) {
		/* The slave does not start on Busy either; its round is driven by 1P. */
		return true;
	}
	if (!beginMultiTransfer(sio, driver)) {
		return true;
	}
	/* Completion belongs to this driver (network reply arrives -> write
	 * SIOMULTI + raise the SIO interrupt). */
	return false;
}

/* Only called without a peer connected (core's default scheduling): finish
 * with the last known peer data; a transfer must never wait on the network
 * here. */
static void gbaLinkFinishMulti(struct GBASIODriver* driver, uint16_t data[4]) {
	struct SioLink* sio = ((struct GbaLinkDriver*) driver)->sio;
	struct GBA* gba = (struct GBA*) sio->core->board;
	int me = netLinkPlayer(sio->link);
	data[0] = data[1] = data[2] = data[3] = 0xFFFF;
	if (me >= 0 && me < 4) {
		data[me] = gba->memory.io[GBA_REG(SIOMLT_SEND)];
	}
	if (sio->sioHasRemote) {
		data[me == 0 ? 1 : 0] = (uint16_t) sio->sioRemote;
	}
}

static uint8_t gbaLinkFinish8(struct GBASIODriver* driver) {
	struct SioLink* sio = ((struct GbaLinkDriver*) driver)->sio;
	struct GBA* gba = (struct GBA*) sio->core->board;
	uint32_t local = gba->memory.io[GBA_REG(SIODATA8)] & 0xFFu;
	uint32_t remote = 0xFFu;
	/* 不能重试：重发 REQ 会让对端的请求队列多出一轮、双方向量错位。等待窗
	 * 自适应 RTT（见 sioWaitMs），跨网尖峰时宁可慢不可错。 */
	netLinkExchange(sio->link, GBA_SIO_NORMAL_8, local, &remote, sioWaitMs(sio));
	return (uint8_t) remote;
}

static uint32_t gbaLinkFinish32(struct GBASIODriver* driver) {
	struct SioLink* sio = ((struct GbaLinkDriver*) driver)->sio;
	struct GBA* gba = (struct GBA*) sio->core->board;
	uint32_t local = gba->memory.io[GBA_REG(SIODATA32_LO)] | ((uint32_t) gba->memory.io[GBA_REG(SIODATA32_HI)] << 16);
	uint32_t remote = 0xFFFFFFFFu;
	netLinkExchange(sio->link, GBA_SIO_NORMAL_32, local, &remote, sioWaitMs(sio));
	return remote;
}

/* Rewrite the SIOCNT terminal bits (Slave/Ready/Id) from the link's real
 * state. The game reads SIOCNT every frame in HANDSHAKE to pick master/slave
 * but writes it only in a few places, so besides the per-write fixup the
 * register must be corrected when the link state changes. Never touch 0x2000
 * (MULTI mode bit): the core switches modes only on mode-bit changes, and
 * setting it early would swallow the game's first MULTI write. */
static void applyLinkTerminalBits(struct SioLink* sio) {
	if (!sio->core || sio->core->platform(sio->core) != mPLATFORM_GBA) {
		return;
	}
	struct GBA* gba = (struct GBA*) sio->core->board;
	int me = netLinkPlayer(sio->link);
	bool up = sio->link && netLinkState(sio->link) == 2;
	uint16_t siocnt = gba->sio.siocnt;
	uint16_t want = siocnt;
	want = GBASIOMultiplayerSetSlave(want, !up || me != 0);
	want = GBASIOMultiplayerSetId(want, up ? me : 0);
	want = GBASIOMultiplayerFillReady(GBASIOMultiplayerClearError(want));
	want = (uint16_t) ((want & ~0x0003u) | 0x0003u); /* restore 115200 baud */
	if (want != siocnt) {
		gba->sio.siocnt = want;
	}
}

static void prepareGbaDriver(struct SioLink* sio) {
	struct GBASIODriver* d = &sio->gbaLink.d;
	memset(d, 0, sizeof(*d));
	sio->gbaLink.sio = sio;
	d->init = gbaLinkInit;
	d->deinit = gbaLinkDeinit;
	d->reset = gbaLinkReset;
	d->driverId = gbaLinkId;
	d->loadState = gbaLinkLoadState;
	d->saveState = gbaLinkSaveState;
	d->setMode = gbaLinkSetMode;
	d->handlesMode = gbaLinkHandles;
	d->connectedDevices = gbaLinkDevices;
	d->deviceId = gbaLinkDeviceId;
	d->writeSIOCNT = gbaLinkWriteCnt;
	d->writeRCNT = gbaLinkWriteRcnt;
	d->start = gbaLinkStart;
	d->finishMultiplayer = gbaLinkFinishMulti;
	d->finishNormal8 = gbaLinkFinish8;
	d->finishNormal32 = gbaLinkFinish32;
}

static void attachLink(struct SioLink* sio) {
	if (!sio->core || sio->linkAttached || netLinkState(sio->link) != 2) {
		return;
	}
	if (sio->core->platform(sio->core) == mPLATFORM_GBA) {
		struct GBA* gba = (struct GBA*) sio->core->board;
		int me = netLinkPlayer(sio->link);
		prepareGbaDriver(sio);
		GBASIOSetDriver(&gba->sio, &sio->gbaLink.d);
		/* The game may already be in HANDSHAKE before the driver was attached
		 * (its CheckMasterOrSlave would read the stale no-driver SIOCNT with
		 * Slave=1); rewrite the terminal bits right here so the game
		 * re-decides next frame. Never include 0x2000 (MULTI mode bit) - see
		 * applyLinkTerminalBits. */
		applyLinkTerminalBits(sio);
		sio->linkAttached = true;
		SIO_LOG("LAN link attached as P%d, SIOCNT %04X", me + 1, gba->sio.siocnt);
	}
	if (sio->linkAttached) {
		sio->sioOk = 0;
		sio->sioPeak = 0;
		sio->sioWaitSumMs = 0;
		sio->sioWaitMaxMs = 0;
		sio->sioWaitN = 0;
		sio->sioTimeouts = 0;
		sio->sioFallback = 0;
		sio->sioWaiting = false;
		sio->sioBusyCycle = 0;
		sio->sioIndex = 0;
		sio->sioPushed = false;
		sio->sioPushValue = 0;
		sio->sioPushIndex = 0;
		sio->sioMisorder = 0;
		sio->sioHasRemote = false;
		sio->sioInitSeen = false;
	}
}

static void detachLink(struct SioLink* sio) {
	if (!sio->linkAttached || !sio->core) {
		sio->linkAttached = false;
		return;
	}
	if (sio->core->platform(sio->core) == mPLATFORM_GBA) {
		GBASIOSetDriver(&((struct GBA*) sio->core->board)->sio, NULL);
	}
	sio->linkAttached = false;
	sio->sioInitSeen = false;
}

static void pollLink(struct SioLink* sio) {
	if (!sio->link) {
		return;
	}
	bool up = netLinkState(sio->link) == 2;
	/* A core reset clears the GBA struct's sio.driver while linkAttached
	 * stays true - without this check the driver would never be re-attached
	 * and the game would hang on the link wait screen forever. */
	bool drvOk = false;
	if (up && sio->core && sio->core->platform(sio->core) == mPLATFORM_GBA) {
		drvOk = ((struct GBA*) sio->core->board)->sio.driver == &sio->gbaLink.d;
	}
	if (up && sio->core && sio->core->platform(sio->core) != mPLATFORM_GBA) {
		/* Game changed to a non-GBA ROM: drop the session. */
		if (sio->linkAttached) {
			detachLink(sio);
		}
		return;
	}
	if (up && (!sio->linkAttached || !drvOk)) {
		sio->linkAttached = false;
		attachLink(sio);
	} else if (!up && sio->linkAttached) {
		detachLink(sio);
	}
}

// ---- public API ----

struct SioLink* sioLinkCreate(void) {
	struct SioLink* sio = (struct SioLink*) calloc(1, sizeof(struct SioLink));
	if (!sio) {
		return NULL;
	}
	sio->link = netLinkCreate();
	if (!sio->link) {
		free(sio);
		return NULL;
	}
	sio->sioSlavePeriod = 18363;
	return sio;
}

void sioLinkDestroy(struct SioLink* sio) {
	if (!sio) {
		return;
	}
	sioLinkClose(sio);
	netLinkDestroy(sio->link);
	free(sio);
}

uint32_t sioLinkRttUs(const struct SioLink* sio) {
	if (!sio) {
		return 0;
	}
	return netLinkRttUs(sio->link);
}

void sioLinkPeerStats(const struct SioLink* sio, uint32_t* stale, uint32_t* drops) {
	if (!sio) {
		if (stale) {
			*stale = 0;
		}
		if (drops) {
			*drops = 0;
		}
		return;
	}
	netLinkPeerStats(sio->link, stale, drops);
}

int sioLinkPeerPending(const struct SioLink* sio) {
	if (!sio) {
		return 0;
	}
	return netLinkPeerPending(sio->link);
}

const void* sioLinkHandle(const struct SioLink* sio) {
	if (!sio) {
		return NULL;
	}
	return sio->link;
}

bool sioLinkHost(struct SioLink* sio, int port) {
	return sioLinkHostPlayers(sio, port, 2);
}

/* players：本局人数。2 走原来的两人直连；3/4 走星型总线（主机 accept 多个
 * 从机、每轮收齐后广播）。旧的两参数入口一律按 2 人处理，行为不变。 */
bool sioLinkHostPlayers(struct SioLink* sio, int port, int players) {
	if (!sio || !sio->link) {
		return false;
	}
	if (players < 2) {
		players = 2;
	}
	return netLinkBusHost(sio->link, port, players);
}

/* 进程内总线版本（同进程 N 核）：仅诊断 / N 核本机回环用，语义同上面。 */
bool sioLinkHostPlayersLocal(struct SioLink* sio, int key, int players) {
	if (!sio || !sio->link) {
		return false;
	}
	if (players < 3) {
		players = 3;
	}
	return netLinkBusHostLocal(sio->link, key, players);
}

bool sioLinkJoinPlayersLocal(struct SioLink* sio, int key) {
	if (!sio || !sio->link) {
		return false;
	}
	return netLinkBusJoinLocal(sio->link, key);
}

bool sioLinkJoinPlayersLocalSlot(struct SioLink* sio, int key, int slot) {
	if (!sio || !sio->link) {
		return false;
	}
	return netLinkBusJoinLocalSlot(sio->link, key, slot);
}

bool sioLinkJoin(struct SioLink* sio, const char* host, int port) {
	return sioLinkJoinPlayers(sio, host, port, 2);
}

/* players 必须和主机一致：总线和两人直连用的是不同的包格式，TCP 层能连上
 * 但一个包都解不出来（总线是定长 BusPacket，两人是 struct Packet）。 */
bool sioLinkJoinPlayers(struct SioLink* sio, const char* host, int port, int players) {
	if (!sio || !sio->link || !host) {
		return false;
	}
	if (players > 2) {
		return netLinkBusJoin(sio->link, host, port);
	}
	return netLinkJoin(sio->link, host, port);
}

void sioLinkClose(struct SioLink* sio) {
	if (!sio || !sio->link) {
		return;
	}
	if (sio->linkAttached && sio->core && sio->core->platform(sio->core) == mPLATFORM_GBA) {
		GBASIOSetDriver(&((struct GBA*) sio->core->board)->sio, NULL);
	}
	sio->linkAttached = false;
	netLinkClose(sio->link);
}

int sioLinkState(const struct SioLink* sio) {
	if (!sio || !sio->link) {
		return 0;
	}
	return netLinkState(sio->link);
}

int sioLinkPlayer(const struct SioLink* sio) {
	if (!sio || !sio->link) {
		return -1;
	}
	return netLinkPlayer(sio->link);
}

/* 本局目标人数（含自己）。总线模式下是房主开房时定的人数，两人直连是 2。
 * 注意这不是「已经接入的人数」—— 总线的槽位是逐个接入的，界面要判断「还差
 * 几个人」得看 netLinkBusPlayers。 */
int sioLinkPlayerCount(const struct SioLink* sio) {
	if (!sio || !sio->link) {
		return 2;
	}
	if (netLinkBusActive(sio->link)) {
		int n = netLinkBusPlayers(sio->link);
		if (n > 2) {
			return n;
		}
	}
	return 2;
}

void sioLinkStatusText(const struct SioLink* sio, char* out, size_t outLen) {
	if (!out || outLen == 0) {
		return;
	}
	out[0] = '\0';
	if (sio && sio->link) {
		netLinkStatusText(sio->link, out, outLen);
	}
}

void sioLinkPump(struct SioLink* sio, struct mCore* core) {
	if (!sio) {
		return;
	}
	sio->core = core;
	/* 环回基线不走 CoreController::finishFrame，在这里补一次；与桌面端
	 * 共用 sioLinkDiagCore 的节流变量，同一帧不会产生重复日志。 */
	sioLinkDiagCore(core);
	pollLink(sio);
	serviceLink(sio);
}

void sioLinkDiagCore(struct mCore* core) {
	/* 与链路对象完全解耦：CoreController::finishFrame 每帧无条件调用。
	 * 联机对象只在隧道配对后才创建，而脚本拿到房号就开始推进菜单，
	 * 那时 m_lanLink 还是 null，挂在 sioLinkPump 里的诊断一行都不会有
	 * （09:58 轮实测 mgba_sio.log 全程 0 字节）。 */
	if (!core || core->platform(core) != mPLATFORM_GBA) {
		return;
	}
	static uint32_t diagMs;
	uint32_t now = wallNowMs();
	if ((uint32_t) (now - diagMs) < 250u) {
		return;
	}
	diagMs = now;
	logLinkDiag((struct GBA*) core->board);
}
