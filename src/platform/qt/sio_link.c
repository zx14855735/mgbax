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
static void sioLogFile(const char* fmt, ...) {
	static int enabled = -1;
	if (enabled < 0) {
		enabled = getenv("MGBAX_SIO_LOG") ? 1 : 0;
	}
	if (!enabled) {
		return;
	}
	const char* tmp = getenv("TEMP");
	if (!tmp) {
		tmp = getenv("TMP");
	}
	if (!tmp) {
		tmp = ".";
	}
	char path[512];
	snprintf(path, sizeof(path), "%s%cmgba_sio.log", tmp, '/');
	FILE* f = fopen(path, "a");
	if (!f) {
		return;
	}
	va_list args;
	va_start(args, fmt);
	vfprintf(f, fmt, args);
	va_end(args);
	fputc('\n', f);
	fclose(f);
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
	bool sioHasRemote;
	uint32_t sioRemote;
	uint32_t sioOk;
	uint32_t sioTimeouts;
	uint32_t sioFallback;
	uint32_t sioStartCycle;
	uint32_t sioPeak;
	uint32_t sioLateness;
	uint16_t sioIndex;
	bool sioInitSeen;
	bool sioStashValid;
	uint32_t sioStash;
	uint32_t sioPushValue;
	uint16_t sioPushIndex;
	bool sioPushed;
	uint32_t sioMisorder;
	uint32_t sioBusyCycle;
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
	SIO_LOG("[diag] mu=%u brs=%04X/%04X rem=%u cb=%08X st=%08X"
	        " lstate=%u pc=%u intr=%u ridx=%u sidx=%u lag=%u rn=%u qf=%u",
	        state, brs01, brs23, rem, cb, status,
	        (l0 >> 8) & 0xFF, (l1 >> 8) & 0xFF, (l2 >> 8) & 0xFF,
	        l4 & 0xFF, (l4 >> 8) & 0xFF, (l3 >> 8) & 0xFF, l2 & 0xFF, l3 & 0xFF);
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

/* Fill SIOMULTI0..3 with one transfer's data and finish it. */
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
		SIO_LOG("SIO multi me=%d ok=%u last=%u.%ums peak=%u.%ums to=%u fb=%u m0=%04X m1=%04X",
		     me, sio->sioOk, sio->sioLateness / 10, sio->sioLateness % 10,
		     sio->sioPeak / 10, sio->sioPeak % 10, sio->sioTimeouts, sio->sioFallback, data[0], data[1]);
		logLinkDiag(gba);
		maybeUnstickStandby(gba);
	}
	GBASIOMultiplayerFinishTransfer(&gba->sio, data, cyclesLate);
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
		if (player != 0 && !sio->sioSlaveArmed && netLinkPeerPending(sio->link) > 0) {
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
	if (sio->linkAttached) {
		mTimingSchedule(timing, &sio->linkEvent, 8192);
	}
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
	int me = netLinkPlayer(sio->link);
	if (me == 0) {
		return;
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
	int waitMs = 0;
	if (sio->link && netLinkState(sio->link) == 2 &&
	    netLinkPushAgeMs(sio->link) < 500) {
		waitMs = sioWaitMs(sio);
	}
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
	uint16_t own = gba->memory.io[GBA_REG(SIOMLT_SEND)];
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

static void sioDoneEvent(struct mTiming* timing, void* user, uint32_t cyclesLate) {
	UNUSED(timing);
	struct SioLink* sio = (struct SioLink*) user;
	if (!sio->sioWaiting) {
		return;
	}
	uint32_t remote = 0;
	uint16_t got = 0;
	bool haveRemote = sio->link && netLinkTakePeerWord(sio->link, sio->sioIndex, sioWaitMs(sio), &remote, &got, NULL);
	SIO_LOG("done want=%u have=%d got=%u retries=%u rtt=%u pending=%d",
	        (unsigned) sio->sioIndex, haveRemote ? 1 : 0, (unsigned) got,
	        (unsigned) sio->sioRetries, netLinkRttUs(sio->link), netLinkPeerPending(sio->link));
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
	 * 或重试次数耗尽才按「这一轮没有对端数据」收尾。 */
	if (sio->link && netLinkState(sio->link) == 2 && sio->sioRetries < 40) {
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
	UNUSED(driver);
	/* Same semantics as gbp.c: the number of connected peers, not counting
	 * ourselves. Two-player link = 1; the core then uses 2P transfer periods
	 * (filling 2 would compute 3P periods, 50% slower than real hardware and
	 * outside the game's timeout windows). */
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
	if (!sio || !sio->link) {
		return false;
	}
	return netLinkHost(sio->link, port);
}

bool sioLinkJoin(struct SioLink* sio, const char* host, int port) {
	if (!sio || !sio->link || !host) {
		return false;
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
	pollLink(sio);
	serviceLink(sio);
}
