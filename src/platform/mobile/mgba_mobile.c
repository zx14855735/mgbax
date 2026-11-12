/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
#include "mgba_mobile.h"

#include <mgba/core/core.h>
#include <mgba/core/cheats.h>
#include <mgba/core/interface.h>
#include <mgba/core/rewind.h>
#include <mgba/core/serialize.h>
#include <mgba/gb/interface.h>
#include <mgba/gba/interface.h>
#include <mgba/internal/gba/gba.h>
#include <mgba/internal/gba/io.h>
#include <mgba/internal/gba/memory.h>
#include <mgba/internal/gba/savedata.h>
#include <mgba/internal/gb/gb.h>
#include <mgba/internal/gb/io.h>
#include <mgba-util/audio-buffer.h>
#include <mgba-util/audio-resampler.h>
#include <mgba-util/vfs.h>

#include "link_net.h"
#include "link_lockstep.h"
#include <mgba/internal/gba/sio/lockstep.h>

#include <ctype.h>
#include <fcntl.h>
#include <pthread.h>
#include <stdio.h>
#include <time.h>
#include <stdlib.h>
#include <string.h>
#include <sys/stat.h>
#include <math.h>

#ifdef __ANDROID__
#include <android/log.h>
#include <sys/system_properties.h>
#define MOBILE_LOGI(...) __android_log_print(ANDROID_LOG_INFO, "mGBA", __VA_ARGS__)
#define MOBILE_LOGE(...) __android_log_print(ANDROID_LOG_ERROR, "mGBA", __VA_ARGS__)
#else
/* 桌面端（Qt 版）默认静默；排查联机时序时设 MGBAX_SIO_LOG=1 就把同一条轨迹打到
 * stderr，和安卓 logcat 里的 mGBA 标签内容一致。 */
static int mobileLogEnabled(void) {
	static int cached = -1;
	if (cached < 0) {
		const char* env = getenv("MGBAX_SIO_LOG");
		cached = (env && *env && *env != '0') ? 1 : 0;
	}
	return cached;
}
#define MOBILE_LOGI(...) \
	do { \
		if (mobileLogEnabled()) { \
			fprintf(stderr, __VA_ARGS__); \
			fputc('\n', stderr); \
			fflush(stderr); \
		} \
	} while (0)
#define MOBILE_LOGE(...) MOBILE_LOGI(__VA_ARGS__)
#endif

/* 每次传输都打日志会拖慢联机（一秒钟几十条），排查时再打开。 */
#ifndef MGBA_LINK_VERBOSE
#define MGBA_LINK_VERBOSE 0
#endif
#if MGBA_LINK_VERBOSE
#define LINK_VERBOSE(...) MOBILE_LOGI(__VA_ARGS__)
#else
#define LINK_VERBOSE(...) ((void) 0)
#endif

#ifdef _WIN32
#include <direct.h>
#define mobile_mkdir(path) _mkdir(path)
#else
#define mobile_mkdir(path) mkdir((path), 0755)
#endif

struct GbaLinkDriver {
	struct GBASIODriver d;
	struct MgbaMobile* emu;
};

struct GbLinkDriver {
	struct GBSIODriver d;
	struct MgbaMobile* emu;
};

struct MgbaMobile {
	/* Serialises core access between the emulation thread (runFrames) and
	 * link threads calling saveStateToMemory/loadStateFromMemory. A TYPE_STATE
	 * frame arrives on the socket reader thread while the mirror core is
	 * running, so both paths must hold this lock. */
	pthread_mutex_t coreMutex;
	bool coreMutexReady;
	struct mCore* core;
	mColor* video;
	uint32_t* prev;
	bool havePrev;
	int interframe;
	int userSkip;
	unsigned width;
	unsigned height;
	char savePath[1024];
	char statePath[1024];
	/* Suffix of the battery save actually opened (.sav, .srm, .saN). */
	char saveSuffix[8];
	char port[32];
	int fast;
	struct NetLink* link;
	struct GbaLinkDriver gbaLink;
	struct GbLinkDriver gbLink;
	struct mTimingEvent linkEvent;
	bool linkAttached;
	/* 进程内锁步 SIO（mgbaMobileLinkHostLockstep/JoinLockstep 启用）。
	 * 非空时帧循环走 mgbaLockstepRunFrame 的小步 runLoop，并跳过 netLink
	 * 的 poll/service，避免自研 gbaLink 驱动覆盖协调器。 */
	struct MgbaLockstepRoom* lockstepRoom;
	struct MgbaLockstepSlot* lockstepSlot;
	/* busgame 调试脚本：PC busgame-lockstep 判据脚本
	 * （test/gboylink_test.cpp lsInjectKeys）的设备端移植。idx<0 = 关闭。
	 * 每核独立计数；可见核在 beginFrameKeys 里接管按键，镜像核由
	 * GBoyConsoleSet 的镜像线程调 mgbaMobileBusGameTick 取掩码。 */
	int busGameIdx;
	int busGameMenuAt;
	int busGameModeDowns;
	uint32_t busGameFrame;
	int busGameMenuMax;
	/* 一次 MULTI 传输的挂起状态：发起时把本帧数据发出去，传输应当结束的时刻
	 * 再取回对端应答。中途不阻塞模拟线程，否则每次传输都要吃掉半帧到几十
	 * 毫秒，游戏内的联机握手会直接超时。 */
	struct mTimingEvent sioDone;
	/* 从机侧「一轮完成」事件：把从机的模拟时钟钉在与主机同速的节拍上。
	 * 见 sioSlaveDoneEvent 的注释。 */
	struct mTimingEvent sioSlaveDone;
	bool sioSlaveArmed;
	/* 从机一轮的目标周期（模拟周期数）：主机一轮 = 5755(传输) + 12608(Timer3)
	 * + 少量处理 ≈ 18363。实测值由对端的模拟时钟戳校准。 */
	uint32_t sioSlavePeriod;
	/* 对端最近一次推送时的模拟时钟戳，用来算主机一轮的真实周期。 */
	uint32_t sioPeerCycles;
	bool sioPeerCyclesValid;
	bool sioWaiting;
	uint16_t sioSeq;
	int sioRetries;
	uint32_t sioRetryWall;
	/* 从机本轮要回推的字：游戏写 SIOCNT 起轮那一刻扣下来。等到本轮完成
	 * 再读 SIOMLT_SEND，游戏往往已写入下一轮的字 —— 16bit 错一位就会让
	 * gLink 的字节流命令队列（SendBlockRequest / 块校验）整体偏移，现象是
	 * 链路连着、gBlockReceivedStatus 恒 0、对战起不来。 */
	uint16_t sioRoundWord;
	bool sioRoundWordValid;
	bool sioHasRemote;
	uint32_t sioRemote;
	/* 联机传输统计：真机/游戏里排查时对着 logcat 看这几项就够 ——
	 * ok 是已完成次数，peak 是单次最坏耗时（0.1ms），to 是超时次数。 */
	uint32_t sioStartCycle;
	uint32_t sioOk;
	uint32_t sioPeak;
	uint32_t sioTimeouts;
	uint32_t sioLateness;
	uint32_t sioFallback;
	uint32_t sioStarts;
	uint16_t sioIndex;
	uint32_t sioBails;
	uint32_t sioBusyCycle;
	uint32_t sioDbg;
	uint32_t sioPoll;
	uint32_t sioPrevStatus;
	uint32_t sioPrevAdv;
	uint32_t sioPrevHs;
	int32_t  sioPrevLinkState;
	int32_t  sioPrevPc;
	uint32_t sioPrevM0;
	uint32_t sioPrevM1;
	uint32_t sioKick;
	/* 游戏是否已经做过一次主从判定（它的第一笔 MULTI 写入）。在那之前必须
	 * 按「总线上只有自己」呈现 SIOCNT 的 Slave 位，否则两边都认为是从机。 */
	bool sioInitSeen;
	/* 真实速度探针：每 2 秒统计一次模拟帧数，用来发现「模拟时钟被网络等待冻住」。 */
	uint32_t probeWallAt;
	uint32_t probeFrames;
	uint32_t probeCycAt;
	/* 等对端应答的耗时统计（真实毫秒）。 */
	double sioWaitTotal;
	double sioWaitMax;
	uint32_t sioWaitN;
	/* 从机侧：拿到对端的字等了多久（排队时延）。 */
	uint32_t sioAgeTotal;
	uint32_t sioAgeMax;
	uint32_t sioAgeN;
	uint32_t sioPolls;
	uint32_t sioPollStamp;
	double sioSvcTotal;
	double sioSvcMax;
	uint32_t sioSvcN;
	/* 联机排查用的限次计数：轮询事件、请求消费、从机收尾各打前几条。 */
	uint32_t sioEvtDbg;
	uint32_t sioTakeDbg;
	uint32_t sioInDbg;
	uint32_t sioSkipDbg;
	uint32_t sioSlaveDoneDbg;
	/* 从机用：主机请求里的数据先存着，等本机下一次 MULTI 传输开始时再用。
	 * 主机跑在前面时请求会落在从机的空档里，直接丢掉就永远对不上了。 */
	uint32_t sioStash;
	bool sioStashValid;
	bool sioSlavePending;
	/* 「每轮推一次」的发送状态：sioPushIndex 是已经推出去的最新轮次（0 = 还没推），
	 * sioPushValue 只用于排查。 */
	uint32_t sioPushValue;
	uint16_t sioPushIndex;
	bool sioPushed;
	/* 取到的对端轮次和本机期望的不一致（丢了一轮）的次数。 */
	uint32_t sioMisorder;
	/* 联机排查：逐轮打印（有上限，不会刷爆 logcat）。 */
	uint32_t xferDbg;
	uint32_t pushDbg;
	uint32_t toDbg;
	/* 握手窗口定向日志：只打 8FFF/全零/超时轮，跳过几千轮 B9A0 等待。 */
	uint32_t hsDbg;
	uint32_t hsPushDbg;
	uint32_t hsStartDbg;
	/* gen8 联机命令队列探针：看 gLink 的收发队列到底有没有东西，
	 * 用来区分「链路没送到」和「游戏根本没入队」。 */
	uint32_t lkqFrames;
	/* 一次性内存扫描：握手卡住时把「连续两个 0xB9A0」的位置全找出来，
	 * 那就是游戏自己的 link 数据区。之前 PEEK_LINK 是照别的 ROM 定的地址，
	 * 读出来正好落在数据缓冲上（err/ck 读到的是 B9A0 的两个字节），
	 * 所以 hs/pc/adv 一直不可信。扫描只做一次，不常驻。 */
	uint32_t memScan;
	uint32_t heldKeys;
	uint32_t latchedKeys;
	uint32_t frameKeys;
	uint32_t appliedKeys;
	uint32_t turboMask;
	unsigned turboCounter;
	struct mKeyCallback keyCallback;
	struct mAudioResampler audioResampler;
	struct mAudioBuffer audioOut;
	bool audioResamplerInited;
	int audioOutRate;
	/* Linear copy of the core's audio the interpolator runs against. */
	int16_t* audioWindow;
	size_t audioWindowFrames;
	/* Frames per second the front end actually paces at; 0 = not measured
	 * yet, use the console's own frame rate. This is an eased estimate, not
	 * the raw window reading: raw readings scatter by a few percent per
	 * window (sleep quantization, GC) and stepping on them walks the pitch
	 * audibly, worst during fast-forward where the throughput wobbles most. */
	double audioPaceFps;
	/* Consecutive readings far enough from the estimate to be outliers. A
	 * single window can be a stall; the estimate only jumps when two in a
	 * row agree. */
	int audioPaceOutliers;
	/* Throughput the device last demonstrated, in console frames per second
	 * (pace x speed). Lets a speed change re-lock the resampler from the
	 * measured capability instead of guessing the console's nominal rate. */
	double audioPaceThroughput;
	/* Speed the current pace was measured at; set alongside every read. */
	double audioPaceSpeed;
	/*
	 * 不变速 (constant pitch) playback. A fast-forwarded game produces several
	 * times more audio than the device can play at the console's own speed.
	 * Dropping the surplus shreds the music; parking it and replaying made the
	 * tune jump a whole section whenever the park filled. Instead we time-stretch
	 * with WSOLA: the surplus is compressed in time while the pitch is kept, so
	 * fast-forward plays continuous, normal-tempo, normal-pitch music with no
	 * skipped section and no shredding.
	 *
	 * wsolaIn  - parked core audio (the WSOLA input queue)
	 * audioHold - WSOLA output, fed to the resampler at the console rate
	 */
	struct mAudioBuffer audioHold;       /* WSOLA output the resampler reads */
	struct mAudioBuffer wsolaIn;         /* WSOLA input queue (parked core audio) */
	size_t wsolaAnaPos;                  /* analysis cursor, frames from wsolaIn head */
	/* Frames the stretcher had to throw away because the staging buffer could
	 * not take them. Must stay 0: a non-zero value is a hole in the stream. */
	size_t wsolaDropped;
	size_t wsolaN;                       /* frame length, samples per channel */
	size_t wsolaHa;                      /* analysis hop, samples per channel */
	size_t wsolaHs;                      /* synthesis hop, samples per channel */
	double wsolaStretch;                 /* requested stretch (set by UI thread) */
	double wsolaConfigured;              /* stretch the buffers were built for */
	float* wsolaAcc;                     /* OLA signal accumulator, length wsolaN*2 */
	int16_t* wsolaEmit;                  /* emit scratch, length wsolaN*2 */
	int16_t* wsolaPrev;                  /* last ref2 emitted-domain samples (phase ref) */
	int16_t* wsolaWindow;                /* Hann window, length wsolaN*2 */
	int16_t* wsolaScratch;               /* discard scratch for the input queue */
	/*
	 * Native-rate hold (音乐原速): the game's audio is streamed out at its own
	 * tempo and pitch - bit for bit what 1x would emit - and fast-forward is
	 * absorbed as LAG, not as skips. At 4x the console makes four seconds of
	 * music per real second, so only one of those four can be heard; instead
	 * of cutting the track into sections and dropping the gaps (which sounds
	 * like the music stuttering on and off), every frame that cannot be played
	 * in time is simply the oldest unplayed frame, which the ring overwrites.
	 * The output is one continuous, untransposed 1x stream that lags the game;
	 * nothing is ever dropped from what does play, so there is no jump.
	 *
 *   natRing       - the lag ring, holding up to natRingCap frames
 *   natRingCap    - ring capacity in frames (the lag ceiling)
 *   natW / natR   - absolute write / read frame counts
 *   natPrimed     - frames handed out since the hold began
 *   natPrimedTarget - fade-in length, frames (avoids a click at the start
 *                     and after every cut, which re-arms it)
 *   natLagDrops   - frames skipped by cuts (the sections that cannot be
 *                   heard at all)
 *   natCuts       - how many section skips have been executed
 */
	int16_t* natRing;
	size_t natRingCap;                    /* capacity in frames */
	size_t natW;                          /* absolute write frame count */
	size_t natR;                          /* absolute read frame count */
	size_t natPrimed;                     /* frames handed out since hold began */
	size_t natPrimedTarget;               /* fade-in length, frames */
	size_t natLagDrops;                   /* frames skipped by cuts */
	size_t natCuts;                       /* section skips executed */
	double natOutAcc;                     /* fractional output carry */
	double natLastTime;                   /* wall clock of the previous read */
	int audioHoldMode;                   /* MOBILE_AUDIO_HOLD_* (set by UI) */
	bool audioHoldOn;
	bool audioHoldInited;
	/* Set by the UI thread on every toggle; the audio thread clears the staged
	 * audio once before the next WSOLA run so a re-enable never replays stale
	 * samples. Kept as a flag so the UI thread never touches the buffers. */
	bool wsolaClearPending;
	/* 上一次的原始窗口读数（audioPaceHist[0]），HistLen>0 表示有效。
	 * 估算器按「两个连续读数一致才跳」过滤单点调度卡顿：三点中值会把
	 * 一次真实的速度变化也拖到 3~5 个窗口才确认，反而更慢。 */
	double audioPaceHist[3];
	int audioPaceHistLen;
	/* Front-end overrides applied on the next load. */
	int saveType;
	bool patches;
	bool useBios;
	bool skipBios;
	int rtcMode;
	int64_t rtcEpoch;
	int64_t rtcOffset;
	int solarLevel;
	bool cartRumble;
	volatile int rumbleHits;
	/* Solar/RTC/rumble live in the GBA board; they survive resets, so these
	 * sources can stay attached for the lifetime of the core. */
	struct GBALuminanceSource luminance;
	struct mRTCSource rtc;
	struct mRumble rumble;
	/* GB DMG palette override, one 0xRRGGBB entry per gb.pal[0..11] key.
	 * Applied through the core's config on load and live on the running core. */
	int32_t gbPalette[12];
	bool gbPaletteSet;
	bool sgbBorders;
	/* Tilt cartridge (WarioWare Twisted, Kirby Tilt'n'Tumble) driven by the
	 * device's sensors; normalized values scaled to the core's shift range. */
	struct mRotationSource rotation;
	volatile int32_t tiltX;
	volatile int32_t tiltY;
	volatile int32_t gyroZ;
	/* Ring of differential savestates for rewinding. A state is appended
	 * every REWIND_DIVIDER frames while enabled, so entries/2 spans seconds. */
	struct mCoreRewindContext rewind;
	bool rewindInited;
	bool rewindEnabled;
	unsigned rewindCounter;
	/* Per-channel audio gains, replayed on every load (see SetChannelVolumes). */
	int32_t channelGains[6];
	/*
	 * Per-instance state that used to live in function-local `static`s. With
	 * two cores in one process (本机双核心), those statics were shared: the
	 * unstick one-shot latch fired on core A and core B then skipped its own
	 * patch forever, while the streak counter was incremented by both cores.
	 * The desktop test injects a synthetic wall clock here too - a global hook
	 * meant destroying one core could silently change the other core's pacing.
	 */
	double (*audioClock)(void);
	bool unstickDone;
	int unstickStreak;
	int unstickModeCached;   /* -1 = not read yet */
	int rearmEnabled;        /* -1 = not read yet */
	int sioPipelineEnabled;  /* -1 = not read yet */
	unsigned diagTick;
	unsigned traceTick;
};

enum {
	MOBILE_RTC_WALL = 0,
	MOBILE_RTC_FIXED = 1,
	MOBILE_RTC_OFFSET = 2,
};

/* One rewind history entry every REWIND_DIVIDER frames; REWIND_ENTRIES of
 * them span REWIND_ENTRIES / 2 seconds of gameplay (about 60 s). */
enum {
	REWIND_DIVIDER = 30,
	REWIND_ENTRIES = 120,
};

/*
 * The mobile front ends pace emulation at the emulated console's own frame
 * rate (about 59.73 fps for GBA and GB), so games and audio run at hardware
 * speed. The resampler input rate still has to be scaled by the rate the front
 * end is actually managing: that is the console's frame rate when the device
 * keeps up, but a heavy game makes the front end miss its target and the
 * stream would slowly drift away from the audio device's clock. Front ends
 * feed the measured rate back with mgbaMobileSetAudioPaceFps; until they do,
 * the console's own frame rate is assumed, with this nominal rate left as the
 * fallback for consoles the core cannot describe.
 */
#define MOBILE_AUDIO_PACE_FPS 60.0
/* Range of front end paces the feedback is trusted for. */
#define MOBILE_AUDIO_PACE_FPS_MIN 15.0
#define MOBILE_AUDIO_PACE_FPS_MAX 240.0
/* Share of a window reading the applied pace absorbs at once. Falling
 * throughput is absorbed faster than rising: surplus production only fills
 * the buffers, while a shortfall drains them into underruns. */
#define MOBILE_AUDIO_PACE_EMA_UP 0.2
#define MOBILE_AUDIO_PACE_EMA_DOWN 0.4
/* A window reading this far from the applied pace is a stall or a spike (a
 * GC pause, a ROM load), not the pacing rate; two in a row are followed. */
#define MOBILE_AUDIO_PACE_OUTLIER 0.35
/* Per-window decay of the remembered device throughput, so a device that
 * slows down (thermals) is re-learned instead of being remembered forever. */
#define MOBILE_AUDIO_PACE_THROUGHPUT_DECAY 0.9995
/* How much already-resampled audio the reader may hold back between pumps. */
#define MOBILE_AUDIO_OUT_FRAMES 16384
/* WSOLA time-stretch for 不变速 playback. */
#define MOBILE_AUDIO_WSOLA_N 1024           /* frame length, samples per channel */
#define MOBILE_AUDIO_WSOLA_IN_SECONDS 6     /* input queue length, seconds */
#define MOBILE_AUDIO_WSOLA_OUT_SECONDS 2    /* output staging buffer, seconds */
#define MOBILE_AUDIO_WSOLA_SCRATCH 4096
/*
 * Native-rate hold (音乐原速). At 4x the console produces four seconds of music
 * per second of real time while the speaker can emit one, so three of those
 * seconds cannot be heard - the only choice is where the cut lands. Sections
 * play at their own tempo and pitch, then the skipper jumps ahead, preferring
 * to do it inside a gap between notes: GBA scores are short loops with plenty
 * of them, so a cut placed on silence is inaudible. A short cross-fade at the
 * seam covers whatever is left.
 */
#define MOBILE_AUDIO_NATIVE_RING_SECONDS 6.0 /* max music lag behind the game */
/* A cut lands inside the freshest span of this length (searched for the
 * quietest stretch), which also caps how much unplayed audio one cut keeps. */
#define MOBILE_AUDIO_NATIVE_SCAN_SECONDS 1.5
#define MOBILE_AUDIO_NATIVE_QUIET_SECONDS 0.010  /* quiet-window length */
#define MOBILE_AUDIO_NATIVE_RESERVE_SECONDS 0.10 /* unplayed frames kept past a cut */
/* Level the playback buffer is topped up to after every pull. Small enough
 * that one front-end read is never satisfied twice in a row (which is what
 * overfills the non-blocking AudioTrack), large enough to cover the mixer
 * period: roughly 62 ms at the GBA's 65536 Hz. */
#define MOBILE_AUDIO_NATIVE_LEVEL_FRAMES 4096

/* Wall clock for pacing the 音乐原速 hand-out. The native test runs emulation
 * as fast as it can, so no real time passes between its reads and a wall clock
 * would hand out nothing; it installs a synthetic clock through
 * mgbaMobileSetAudioClock() instead. The hook is per MgbaMobile instance:
 * two cores in one process must not share it. */

/* 真实墙钟（毫秒）。不用 audioNow —— 那个可能被原生测试替换成合成时钟，
 * 而联机排查要量的是真实耗时（等对端应答花了多少毫秒）。 */
static uint32_t wallNowMs(void) {
	struct timespec ts;
	if (clock_gettime(CLOCK_MONOTONIC, &ts) == 0) {
		return (uint32_t) (ts.tv_sec * 1000u + ts.tv_nsec / 1000000u);
	}
	return 0;
}

static double audioNow(struct MgbaMobile* emu) {
	if (emu && emu->audioClock) {
		return emu->audioClock();
	}
	/* clock_gettime 在安卓(bionic)与桌面(winpthreads)都有；旧的
	 * timespec_get 分支在 MSYS2 MinGW 头文件里不存在，桌面构建过不去。 */
	struct timespec ts;
	if (clock_gettime(CLOCK_MONOTONIC, &ts) == 0) {
		return (double) ts.tv_sec + (double) ts.tv_nsec / 1e9;
	}
	return 0.0;
}

/* Per-instance synthetic wall clock, used by the desktop audio tests. */
void mgbaMobileSetAudioClock(struct MgbaMobile* emu, double (*clock)(void)) {
	if (emu) {
		emu->audioClock = clock;
	}
}

bool mgbaMobileHasSyntheticAudioClock(const struct MgbaMobile* emu) {
	return emu && emu->audioClock != NULL;
}

/* How fast-forward audio is produced when the front end asks for it: see the
 * MOBILE_AUDIO_HOLD_* enum in mgba_mobile.h. */

static void attachKeyCallback(struct MgbaMobile* emu);
static void detachLink(struct MgbaMobile* emu);
static void pollLink(struct MgbaMobile* emu);
static void applyLinkTerminalBits(struct MgbaMobile* emu);
static double audioNativeFps(const struct MgbaMobile* emu);
static void attachCartHw(struct MgbaMobile* emu);
static void tiltSample(struct mRotationSource* rotation);
static int32_t tiltReadX(struct mRotationSource* rotation);
static int32_t tiltReadY(struct mRotationSource* rotation);
static int32_t tiltReadGyro(struct mRotationSource* rotation);
static void loadCheats(struct MgbaMobile* emu);
static void saveCheats(struct MgbaMobile* emu);

static void copyPath(char* dst, size_t dstLen, const char* src) {
	if (!src) {
		dst[0] = '\0';
		return;
	}
	snprintf(dst, dstLen, "%s", src);
}

static void resetAudioOutput(struct MgbaMobile* emu) {
	if (!emu->audioResamplerInited) {
		return;
	}
	// The source buffer belongs to the core; drop the resampler's bookkeeping
	// so a freshly loaded core starts from a clean state.
	emu->audioResampler.timestamp = 0;
	mAudioBufferClear(&emu->audioOut);
}

static void deinitAudioHold(struct MgbaMobile* emu) {
	if (!emu->audioHoldInited) {
		return;
	}
	mAudioBufferDeinit(&emu->audioHold);
	mAudioBufferDeinit(&emu->wsolaIn);
	free(emu->wsolaAcc);
	free(emu->wsolaEmit);
	free(emu->wsolaPrev);
	free(emu->wsolaWindow);
	free(emu->wsolaScratch);
	free(emu->natRing);
	emu->wsolaAcc = NULL;
	emu->wsolaEmit = NULL;
	emu->wsolaPrev = NULL;
	emu->wsolaWindow = NULL;
	emu->wsolaScratch = NULL;
	emu->natRing = NULL;
	emu->audioHoldInited = false;
}

/*
 * (Re)configures the WSOLA time-stretcher for a given stretch factor. The
 * synthesis hop is held at a fixed 50% window overlap (clean Hann COLA) and the
 * analysis hop is scaled so the ratio analysis/synthesis equals the stretch:
 * dropping s = mult times more audio than real time, compressed into real time,
 * means the music runs at its own tempo with no skipped section.
 */
static void initAudioHold(struct MgbaMobile* emu, unsigned coreRate, double stretch) {
	/* `stretch` is the requested multiplier (emu->wsolaStretch, set by the UI).
	 * Compare against what the buffers were actually built for - not against
	 * wsolaStretch itself, which would always match and never rebuild when the
	 * fast-forward speed changes. Rebuilding only ever happens here, on the
	 * audio thread, so the buffers are never freed under a running
	 * wsolaGenerate. */
	if (emu->audioHoldInited && fabs(stretch - emu->wsolaConfigured) < 0.01) {
		return;
	}
	deinitAudioHold(emu);
	if (!coreRate || stretch < 1.001) {
		return;
	}
	emu->wsolaN = MOBILE_AUDIO_WSOLA_N;
	/* 50% synthesis overlap: the window is the whole frame and the synthesis hop
	 * is half the frame, so a plain Hann window is exactly COLA-flat and - more
	 * importantly - the overlap is low enough that near-identical phase-locked
	 * segments do not over-overlap into a comb-filter / "electric" chorus. The
	 * analysis hop is scaled by the stretch (Ha = N/2 * stretch), so the ratio
	 * analysis/synthesis equals the stretch; for stretch > 2 this necessarily
	 * skips some input uniformly, which is time compression rendered through a
	 * smooth overlap-add (not a decimation) and is inaudible as a jump. */
	emu->wsolaHs = emu->wsolaN / 2;
	emu->wsolaHa = (size_t) (emu->wsolaN / 2.0 * stretch + 0.5);
	if (emu->wsolaHs < 1) {
		emu->wsolaHs = 1;
	}
	if (emu->wsolaHa < 1) {
		emu->wsolaHa = 1;
	}
	emu->wsolaConfigured = stretch;
	emu->wsolaAnaPos = 0;
	emu->wsolaDropped = 0;
	/* Native-rate hold geometry (音乐原速): a lag ring a few seconds deep.
	 * The game's audio is written into the ring at the fast-forward rate and
	 * read out at the console's own rate. The surplus cannot be heard at any
	 * multiplier, so it is dropped in whole sections: the ring fills up to
	 * the lag ceiling, then one cut jumps the read pointer to the quietest
	 * stretch of the freshest audio (a gap between notes) and playback runs
	 * uninterrupted again until the ceiling is reached once more. */
	emu->natRingCap = (size_t) (coreRate * MOBILE_AUDIO_NATIVE_RING_SECONDS + 0.5);
	if (emu->natRingCap < 2048) {
		emu->natRingCap = 2048;
	}
	emu->natW = 0;
	emu->natR = 0;
	emu->natPrimed = 0;
	emu->natPrimedTarget = (size_t) (coreRate * 0.012 + 0.5);  /* 12 ms fade-in */
	if (emu->natPrimedTarget < 16) {
		emu->natPrimedTarget = 16;
	}
	emu->natLagDrops = 0;
	emu->natCuts = 0;
	emu->natOutAcc = 0.0;
	emu->natLastTime = 0.0;
	mAudioBufferInit(&emu->audioHold, (size_t) coreRate * MOBILE_AUDIO_WSOLA_OUT_SECONDS, 2);
	mAudioBufferInit(&emu->wsolaIn, (size_t) coreRate * MOBILE_AUDIO_WSOLA_IN_SECONDS, 2);
	/* Mark inited now so a failed allocation below is cleaned up by
	 * deinitAudioHold() instead of leaking and leaving a half-built state. */
	emu->audioHoldInited = true;
	emu->wsolaAcc = (float*) calloc(emu->wsolaN * 2, sizeof(float));
	emu->wsolaEmit = (int16_t*) calloc(emu->wsolaN * 2, sizeof(int16_t));
	emu->wsolaPrev = (int16_t*) calloc(emu->wsolaN * 2, sizeof(int16_t));
	emu->wsolaWindow = (int16_t*) calloc(emu->wsolaN * 2, sizeof(int16_t));
	emu->wsolaScratch = (int16_t*) calloc(MOBILE_AUDIO_WSOLA_SCRATCH * 2, sizeof(int16_t));
	emu->natRing = (int16_t*) calloc(emu->natRingCap * 2, sizeof(int16_t));
	if (!emu->wsolaAcc || !emu->wsolaEmit || !emu->wsolaPrev || !emu->wsolaWindow || !emu->wsolaScratch || !emu->natRing) {
		/* Out of memory: fall back to the plain (non-stretched) path rather
		 * than dereferencing a NULL accumulator. */
		deinitAudioHold(emu);
		return;
	}
	size_t n2 = emu->wsolaN * 2;
	/* Periodic Hann (denominator n2, not n2-1). At the 50% synthesis overlap
	 * w[j] + w[j + N] == 1 exactly, so the overlap-add is COLA-flat: the seam
	 * gain is a constant 1, no amplitude ripple and - critically - no
	 * comb-filter / "electric" coloration. */
	for (size_t i = 0; i < n2; ++i) {
		double w = 0.5 * (1.0 - cos(2.0 * M_PI * i / n2));
		emu->wsolaWindow[i] = (int16_t) (w * 32767.0);
	}
}

/* Parks everything the core just produced into the WSOLA input queue. */
static void wsolaFeed(struct MgbaMobile* emu, struct mAudioBuffer* source) {
	size_t available;
	size_t capacity = mAudioBufferCapacity(&emu->wsolaIn);
	while ((available = mAudioBufferAvailable(source)) > 0) {
		/* Never read more than the parked queue can take: the samples are
		 * already out of the core's ring by then, so anything mAudioBufferWrite
		 * refuses would be lost mid-stream. Leaving them in the ring keeps the
		 * pressure on the core instead of punching a hole in the music. */
		size_t room = capacity - mAudioBufferAvailable(&emu->wsolaIn);
		size_t chunk = available > MOBILE_AUDIO_WSOLA_SCRATCH ? MOBILE_AUDIO_WSOLA_SCRATCH : available;
		if (chunk > room) {
			chunk = room;
		}
		if (!chunk) {
			break;
		}
		size_t got = mAudioBufferRead(source, emu->wsolaScratch, chunk);
		if (!got) {
			break;
		}
		size_t put = mAudioBufferWrite(&emu->wsolaIn, emu->wsolaScratch, got);
		if (put < got) {
			emu->wsolaDropped += got - put;
		}
	}
}

/*
 * Runs the WSOLA time-stretcher to fill the output buffer with up to `want`
 * frames. For each synthesis step it slides an analysis window through the
 * input, picks the offset whose start best matches the samples already emitted
 * (phase alignment, so the overlap-add stays continuous), windows it with a
 * Hann window and overlap-adds into the accumulator before flushing the final
 * leading samples. Because input is consumed at the analysis hop and output is
 * emitted at the synthesis hop, the ratio of the two is exactly the stretch:
 * no section is ever dropped, so the tune never jumps.
 *
 * The synthesis overlap is fixed at 50% (wsolaHs = wsolaN/2), which is the
 * overlap at which a Hann window is naturally COLA-flat and - critically - the
 * overlap is low enough that near-identical phase-locked segments do not
 * over-overlap into a comb-filter / "electric" coloration. The analysis hop is
 * scaled by the stretch, so for stretch > 2 some input is skipped uniformly;
 * that is time compression, rendered via a smooth overlap-add rather than a
 * decimation, so it is inaudible as a jump.
 */
static size_t wsolaGenerate(struct MgbaMobile* emu, size_t want) {
	if (!emu->audioHoldInited) {
		return 0;
	}
	size_t N = emu->wsolaN;            /* analysis frame length, stereo frames */
	size_t N2 = N * 2;                 /* full frame, interleaved samples     */
	size_t Ha = emu->wsolaHa;          /* analysis hop, frames               */
	size_t Hs = emu->wsolaHs;          /* synthesis hop, frames (N/2)        */
	size_t Hs2 = Hs * 2;               /* = N, the 50% overlap-add stride    */
	size_t W2 = N2;                    /* overlap-add window = whole frame    */
	/* Phase-lock over the synthesis hop: the new frame's first Hs samples must
	 * continue from the Hs samples just emitted, so the seam is continuous. */
	size_t ref = Hs;
	size_t ref2 = Hs2;
	float* acc = emu->wsolaAcc;
	int16_t* win = emu->wsolaWindow;    /* plain Hann window (COLA-flat at 50%) */
	int16_t* prev = emu->wsolaPrev;     /* output-domain phase reference        */
	int16_t* frame = emu->wsolaScratch; /* single-frame scratch (int16) */
	int16_t* emit = emu->wsolaEmit;     /* emit scratch (int16) */
	size_t available = mAudioBufferAvailable(&emu->wsolaIn);
	size_t holdCapacity = mAudioBufferCapacity(&emu->audioHold);
	size_t ap = emu->wsolaAnaPos;
	size_t produced = 0;
	/* Search tolerance is kept small - only a few signal periods - so the phase
	 * match lands on the true continuation rather than jumping to a
	 * wrong-harmonic correlation peak. With a large analysis hop (high stretch)
	 * a wide tolerance lets the cross-correlation lock onto a peak one or more
	 * whole periods away, which halves (or worse) the effective stride and doubles
	 * the perceived pitch. A coarse step keeps the search stable. */
	int tol = (int) (N / 4);
	if (tol > (int) (Ha / 2)) {
		tol = (int) (Ha / 2);
	}

	/* Emit at most what this call was asked for, and never start a frame the
	 * staging buffer cannot hold in full. Over-producing is what broke the
	 * device: the front end asks for a big block (AUDIO_READ_FRAMES = 8192) and
	 * the old `want * 8` bound let one call pour tens of thousands of frames
	 * into a two-second staging buffer. mAudioBufferWrite then accepted short
	 * writes and the remainder was discarded - whole synthesis hops vanished
	 * from the music while the analysis cursor still advanced, so fast-forward
	 * played chopped, gappy audio instead of the stretched track. Backpressure
	 * (stop, leave the input parked) keeps every hop intact. */
	while (produced < want && ap + N <= available) {
		if (holdCapacity - mAudioBufferAvailable(&emu->audioHold) < Hs) {
			break;
		}
		int lo = (int) ap - tol;
		if (lo < 0) {
			lo = 0;
		}
		int hi = (int) ap + tol;
		if ((size_t) (hi + (int) N) > available) {
			hi = (int) available - (int) N;
		}
		if (hi < lo) {
			hi = lo;
		}
		int bestD = (int) ap;
		float best = -1e30f;
		for (int d = lo; d <= hi; d += 8) {
			long long dot = 0, e1 = 0, e2 = 0;
			for (size_t i = 0; i < ref; ++i) {
				int16_t L = mAudioBufferPeek(&emu->wsolaIn, 0, d + i);
				int16_t R = mAudioBufferPeek(&emu->wsolaIn, 1, d + i);
				int16_t pL = prev[i * 2];
				int16_t pR = prev[i * 2 + 1];
				int ma = (int) L + (int) R;
				int mp = (int) pL + (int) pR;
				dot += (long long) ma * mp;
				e1 += (long long) ma * ma;
				e2 += (long long) mp * mp;
			}
			float sc = e2 > 0 ? (float) dot / (sqrtf((float) e1 * e2) + 1) : 0;
			if (sc > best) {
				best = sc;
				bestD = d;
			}
		}
		size_t fp = (size_t) bestD;
		for (size_t i = 0; i < N; ++i) {
			frame[i * 2] = mAudioBufferPeek(&emu->wsolaIn, 0, fp + i);
			frame[i * 2 + 1] = mAudioBufferPeek(&emu->wsolaIn, 1, fp + i);
		}
		/* Overlap-add with the Hann window at the fixed 50% synthesis overlap. A
		 * Hann window sums to a constant there, so the seam gain is flat (no
		 * amplitude modulation / electric ringing) and - because the overlap is
		 * only 50% - near-identical phase-locked segments do not over-overlap into
		 * the comb-filter / "electric" chorus that the old 87.5% overlap had. */
		for (size_t i = 0; i < W2; ++i) {
			acc[i] += (float) frame[i] * (float) win[i] * (1.0f / 32768.0f);
		}
		for (size_t i = 0; i < Hs2; ++i) {
			float v = acc[i];
			int iv = (int) (v + (v >= 0 ? 0.5f : -0.5f));
			if (iv > 32767) {
				iv = 32767;
			} else if (iv < -32768) {
				iv = -32768;
			}
			emit[i] = (int16_t) iv;
		}
		size_t wrote = mAudioBufferWrite(&emu->audioHold, emit, Hs);
		if (wrote < Hs) {
			/* Should not happen (room was checked above), but a short write is
			 * a hole in the stream - record it instead of hiding it. */
			emu->wsolaDropped += Hs - wrote;
		}
		/* Advance the phase reference: keep the last ref2 samples of the
		 * accumulator tail - the windowed overlap region of the frame just emitted
		 * - so the next frame's head is phase-aligned to it. */
		{
			size_t base = W2 - ref2;
			for (size_t i = 0; i < ref2; ++i) {
				float v = acc[base + i];
				int iv = (int) (v + (v >= 0 ? 0.5f : -0.5f));
				if (iv > 32767) iv = 32767;
				else if (iv < -32768) iv = -32768;
				prev[i] = (int16_t) iv;
			}
		}
		memmove(acc, acc + Hs2, (W2 - Hs2) * sizeof(float));
		/* The shift left by Hs2 leaves acc[Hs2 .. W2) holding the bytes that were
		 * already there; clear it so the next overlap-add only mixes in the
		 * *current* frame's tail. Without this the accumulator would sum every
		 * previous tail indefinitely, blowing the signal up into a distorted,
		 * ever-growing waveform - the "electric" / metallic artefact. */
		memset(acc + Hs2, 0, (W2 - Hs2) * sizeof(float));
		produced += Hs;
		ap = fp + Ha;
	}
	emu->wsolaAnaPos = ap;
	if (ap > 0) {
		size_t rem = ap;
		while (rem > 0) {
			size_t c = rem > MOBILE_AUDIO_WSOLA_SCRATCH ? MOBILE_AUDIO_WSOLA_SCRATCH : rem;
			mAudioBufferRead(&emu->wsolaIn, emu->wsolaScratch, c);
			rem -= c;
		}
		emu->wsolaAnaPos = 0;
	}
	return produced;
}

/*
 * 音乐原速 playback.
 *
 * A section is played straight out of the core, at its own tempo and pitch -
 * bit for bit what 1x would emit - and then a whole section is skipped before
 * the next one starts. The skip is unavoidable: at 4x the console hands over
 * four seconds of music per second of real time while the speaker can emit
 * one, so three of those four seconds can never be heard; the only thing a
 * policy can choose is where the loss lands. Dropping it frame-by-frame as it
 * arrives (the first cut at this) re-samples the tune at 1/stretch and plays
 * the fragments back to back - the melody then rushes through at the game's
 * speed, which is exactly the "音乐仍然变快" report this file exists to fix.
 * Instead the surplus accumulates in the ring and leaves in one cut:
 *
 *  - the cut is deferred until the lag ring is full (seconds of uninterrupted
 *    tune before it, not milliseconds);
 *  - it lands on the quietest stretch of the freshest audio - a gap between
 *    notes, since GBA scores are short loops with plenty of them - rather
 *    than in the middle of one;
 *  - the incoming section is faded in over the usual 12 ms, so a cut that
 *    still lands on sound does not click.
 *
 * The long-run content rate is exactly 1/stretch of the score: played = what
 * real time allows, skipped = everything else, with no drift to track.
 */
static void nativeHoldCut(struct MgbaMobile* emu, size_t need, unsigned coreRate) {
	size_t cap = emu->natRingCap;
	size_t quiet = (size_t) (coreRate * MOBILE_AUDIO_NATIVE_QUIET_SECONDS + 0.5);
	size_t scan = (size_t) (coreRate * MOBILE_AUDIO_NATIVE_SCAN_SECONDS + 0.5);
	size_t guard = (size_t) (coreRate * MOBILE_AUDIO_NATIVE_RESERVE_SECONDS + 0.5);
	size_t landMin = emu->natR + need;    /* must free at least the overflow */
	size_t landMax = emu->natW > guard ? emu->natW - guard : emu->natR;
	size_t zoneLo, zoneHi, best, bestEnergy, pos, k;
	if (quiet < 16) {
		quiet = 16;
	}
	if (landMax < landMin) {
		/* Degenerate (need larger than the backlog can spare): fall back to
		 * the plain drop-to-fit so the ring invariant always holds. */
		emu->natLagDrops += need;
		emu->natR = landMin;
		emu->natPrimed = 0;
		++emu->natCuts;
		return;
	}
	/* Prefer the freshest audio: landing near the write head makes this cut
	 * - and therefore the stretch until the next one - as long as possible. */
	zoneLo = landMax > landMin + scan ? landMax - scan : landMin;
	zoneHi = landMax;
	best = zoneLo;
	bestEnergy = (size_t) -1;
	for (pos = zoneLo; pos + quiet <= zoneHi; pos += quiet) {
		size_t energy = 0;
		for (k = 0; k < quiet; ++k) {
			const int16_t* frame = &emu->natRing[((pos + k) % cap) * 2];
			int l = frame[0];
			int r = frame[1];
			energy += (size_t) (l < 0 ? -l : l) + (size_t) (r < 0 ? -r : r);
		}
		if (energy < bestEnergy) {
			bestEnergy = energy;
			best = pos;
		}
	}
	emu->natLagDrops += best - emu->natR;
	emu->natR = best;
	emu->natPrimed = 0;   /* re-arm the fade-in over the seam */
	++emu->natCuts;
}

static size_t nativeHoldGenerate(struct MgbaMobile* emu, struct mAudioBuffer* source, size_t want) {
	unsigned coreRate = emu->core ? emu->core->audioSampleRate(emu->core) : 0;
	size_t cap = emu->natRingCap;
	size_t holdCap = mAudioBufferCapacity(&emu->audioHold);
	size_t holdAvail = mAudioBufferAvailable(&emu->audioHold);
	size_t produced = 0;

	if (!emu->natRing || !cap || !coreRate) {
		return 0;
	}

	/* 1. Pull the core's audio into the lag ring. The game runs `stretch`
	 * times faster than real time, so it produces `stretch` times more audio
	 * than we hand out. While the ring has room the played stream is one
	 * continuous, untransposed 1x section; once it is full, whole sections
	 * are cut away at the quietest spot (nativeHoldCut) instead of shaving
	 * a little off every batch - shaving is what made the tune rush. */
	size_t startR = emu->natR;
	size_t avail = mAudioBufferAvailable(source);
	while (avail) {
		size_t n = avail > MOBILE_AUDIO_WSOLA_SCRATCH ? MOBILE_AUDIO_WSOLA_SCRATCH : avail;
		n = mAudioBufferRead(source, emu->wsolaScratch, n);
		if (!n) {
			break;
		}
		if (emu->natW + n - emu->natR > cap) {
			nativeHoldCut(emu, emu->natW + n - emu->natR - cap, coreRate);
		}
		for (size_t k = 0; k < n; ++k) {
			size_t widx = emu->natW % cap;
			emu->natRing[widx * 2] = emu->wsolaScratch[k * 2];
			emu->natRing[widx * 2 + 1] = emu->wsolaScratch[k * 2 + 1];
			emu->natW++;
		}
		avail -= n;
	}

	/* 2. Hand out exactly what real time has advanced - one frame per core
	 * sample of wall clock, independent of the multiplier and of how fast the
	 * device can actually emulate. This is the only quantity that means the
	 * same thing at every speed, so it is the one that keeps the music at the
	 * console's own tempo. */
	double now = audioNow(emu);
	double dt = now - emu->natLastTime;
	emu->natLastTime = now;
	if (dt > 0.0 && dt < 0.5) {
		emu->natOutAcc += dt * (double) coreRate;
	}
	double acc = emu->natOutAcc;
	size_t budget = (size_t) acc;
	emu->natOutAcc = acc - (double) budget;

	size_t have = emu->natW - emu->natR;   /* unread frames in the ring */
	if (budget > have) {
		budget = have;
	}
	if (budget > (size_t) want) {
		budget = (size_t) want;
	}
	if (budget > holdCap - holdAvail) {
		budget = holdCap - holdAvail;
	}
	/* wsolaScratch holds exactly MOBILE_AUDIO_WSOLA_SCRATCH stereo frames, but
	 * `want` can be 8192 (the device pump reads 8192-frame blocks). Without
	 * this clamp the copy below writes up to 2x past the allocation whenever a
	 * wall-clock jump makes `budget` large - a load-dependent heap overwrite,
	 * which is why the full suite only crashed intermittently under load. */
	if (budget > MOBILE_AUDIO_WSOLA_SCRATCH) {
		budget = MOBILE_AUDIO_WSOLA_SCRATCH;
	}

	/* 3. Copy `budget` frames out of the ring into the playback buffer. The
	 * first few frames are faded in so re-entering the hold does not click
	 * against silence; everything else is the original 1x sample, untouched. */
	for (size_t done = 0; done < budget; ) {
		size_t ridx = emu->natR % cap;
		size_t room = cap - ridx;
		size_t chunk = budget - done;
		if (chunk > room) {
			chunk = room;
		}
		for (size_t k = 0; k < chunk; ++k) {
			int16_t l = emu->natRing[(ridx + k) * 2];
			int16_t r = emu->natRing[(ridx + k) * 2 + 1];
			size_t played = emu->natPrimed + k;
			if (played < emu->natPrimedTarget) {
				int a = (int) ((played * 256) / (emu->natPrimedTarget > 0 ? emu->natPrimedTarget : 1));
				l = (int16_t) (((int) l * a) / 256);
				r = (int16_t) (((int) r * a) / 256);
			}
			emu->wsolaScratch[(done + k) * 2] = l;
			emu->wsolaScratch[(done + k) * 2 + 1] = r;
		}
		size_t wrote = mAudioBufferWrite(&emu->audioHold, emu->wsolaScratch + done * 2, chunk);
		emu->natR += wrote;
		emu->natPrimed += wrote;
		done += wrote;
		if (wrote < chunk) {
			break;   /* playback buffer full; finish next call */
		}
	}
	produced = emu->natR - startR;
	return produced;
}
static void deinitAudioOutput(struct MgbaMobile* emu) {
	deinitAudioHold(emu);
	free(emu->audioWindow);
	emu->audioWindow = NULL;
	emu->audioWindowFrames = 0;
	if (!emu->audioResamplerInited) {
		return;
	}
	mAudioResamplerDeinit(&emu->audioResampler);
	mAudioBufferDeinit(&emu->audioOut);
	emu->audioResamplerInited = false;
	emu->audioOutRate = 0;
}

static void destroyCore(struct MgbaMobile* emu) {
	if (!emu->core) {
		return;
	}
	detachLink(emu);
	resetAudioOutput(emu);
	mCoreConfigDeinit(&emu->core->config);
	emu->core->deinit(emu->core);
	emu->core = NULL;
	free(emu->video);
	emu->video = NULL;
	free(emu->prev);
	emu->prev = NULL;
	emu->havePrev = false;
	emu->width = 0;
	emu->height = 0;
	// A freshly loaded game is assumed to be paced at its own frame rate;
	// front-end readings accumulate from there. This also drops an estimate a
	// stall may have dragged across the load. The throughput memory survives:
	// it describes the device, not the game state.
	emu->audioPaceFps = 0.0;
	emu->audioPaceOutliers = 0;
	emu->audioPaceHistLen = 0;
	emu->audioPaceSpeed = 0.0;
}

static bool ensureVideo(struct MgbaMobile* emu) {
	unsigned width = 0;
	unsigned height = 0;
	emu->core->currentVideoSize(emu->core, &width, &height);
	if (width == 0 || height == 0) {
		emu->core->baseVideoSize(emu->core, &width, &height);
	}
	if (width == 0 || height == 0 || width > 1024 || height > 1024) {
		return false;
	}
	if (emu->video && emu->width == width && emu->height == height) {
		return true;
	}
	mColor* video = (mColor*) calloc((size_t) width * height, sizeof(mColor));
	if (!video) {
		return false;
	}
	free(emu->video);
	emu->video = video;
	free(emu->prev);
	emu->prev = NULL;
	emu->width = width;
	emu->height = height;
	emu->havePrev = false;
	emu->core->setVideoBuffer(emu->core, emu->video, width);
	return true;
}

struct MgbaMobile* mgbaMobileCreate(const char* saveDir, const char* stateDir, const char* port) {
	struct MgbaMobile* emu = (struct MgbaMobile*) calloc(1, sizeof(struct MgbaMobile));
	if (!emu) {
		return NULL;
	}
	/* 递归锁：加锁点既在 C 层的 mgbaMobileRunFrames / SaveStateToMemory /
	 * LoadStateToMemory 内部（这样 iOS 直接调用 C 函数也受保护，它不经过
	 * JNI），也在 JNI 的入口（安卓侧的历史做法）。同一线程沿途二次加锁必须
	 * 不能自死锁，所以这里用 PTHREAD_MUTEX_RECURSIVE。 */
	{
		pthread_mutexattr_t attr;
		pthread_mutexattr_init(&attr);
		pthread_mutexattr_settype(&attr, PTHREAD_MUTEX_RECURSIVE);
		int rc = pthread_mutex_init(&emu->coreMutex, &attr);
		pthread_mutexattr_destroy(&attr);
		if (rc != 0) {
			free(emu);
			return NULL;
		}
	}
	emu->coreMutexReady = true;
	copyPath(emu->savePath, sizeof(emu->savePath), saveDir);
	copyPath(emu->statePath, sizeof(emu->statePath), stateDir);
	copyPath(emu->port, sizeof(emu->port), port && port[0] ? port : "mobile");
	snprintf(emu->saveSuffix, sizeof(emu->saveSuffix), ".sav");
	if (emu->savePath[0]) {
		mobile_mkdir(emu->savePath);
	}
	if (emu->statePath[0]) {
		mobile_mkdir(emu->statePath);
	}
	/* -1 means "not resolved yet": calloc gives 0, which would otherwise look
	 * like a cached "disabled" answer and skip the env/property lookup. */
	emu->unstickModeCached = -1;
	emu->rearmEnabled = -1;
	emu->sioPipelineEnabled = -1;
	emu->busGameIdx = -1;
	emu->link = netLinkCreate();
	emu->gbaLink.emu = emu;
	emu->gbLink.emu = emu;
	// Defaults keep this front end's shipped behaviour: save type forced to
	// FLASH1M, BIOS used but skipped, patches on. The Java settings can change
	// all of these between launches.
	emu->saveType = GBA_SAVEDATA_FLASH1M;
	emu->patches = true;
	emu->useBios = true;
	emu->skipBios = true;
	emu->solarLevel = -1;
	emu->cartRumble = false;
	emu->gbPaletteSet = false;
	emu->sgbBorders = false;
	emu->tiltX = 0;
	emu->tiltY = 0;
	emu->gyroZ = 0;
	for (int gi = 0; gi < 6; ++gi) {
		emu->channelGains[gi] = 256;
	}
	return emu;
}

void mgbaMobileDestroy(struct MgbaMobile* emu) {
	if (!emu) {
		return;
	}
	if (emu->rewindInited) {
		mCoreRewindContextDeinit(&emu->rewind);
		emu->rewindInited = false;
	}
	/* 必须在 destroyCore 之前卸下锁步驱动：driver 内存由 slot 持有，core
	 * 销毁后 gba->sio.driver 会悬空。 */
	if (emu->lockstepSlot) {
		mgbaLockstepDetach(emu->lockstepSlot);
		emu->lockstepSlot = NULL;
	}
	if (emu->lockstepRoom) {
		mgbaLockstepRelease(emu->lockstepRoom);
		emu->lockstepRoom = NULL;
	}
	destroyCore(emu);
	deinitAudioOutput(emu);
	netLinkDestroy(emu->link);
	emu->link = NULL;
	if (emu->coreMutexReady) {
		emu->coreMutexReady = false;
		pthread_mutex_destroy(&emu->coreMutex);
	}
	free(emu);
}

void mgbaMobileLock(struct MgbaMobile* emu) {
	if (emu && emu->coreMutexReady) {
		pthread_mutex_lock(&emu->coreMutex);
	}
}

void mgbaMobileUnlock(struct MgbaMobile* emu) {
	if (emu && emu->coreMutexReady) {
		pthread_mutex_unlock(&emu->coreMutex);
	}
}

void mgbaMobileSetSaveDirs(struct MgbaMobile* emu, const char* saveDir, const char* stateDir) {
	if (!emu) {
		return;
	}
	if (saveDir && saveDir[0]) {
		copyPath(emu->savePath, sizeof(emu->savePath), saveDir);
	}
	if (stateDir && stateDir[0]) {
		copyPath(emu->statePath, sizeof(emu->statePath), stateDir);
	}
}

/*
 * Battery saves kept next to the ROM may carry any of the usual suffixes:
 * mGBA writes <base>.sav, other emulators <base>.srm, and per-player saves
 * use .sa1..sa4. Open an existing one rather than letting the core create
 * an empty .sav beside a real .srm. The VFile stays owned by the core so
 * later saves are written back to the same file.
 */
static bool autoloadExistingSave(struct MgbaMobile* emu, struct mCore* core) {
	char preferred[16] = ".sav";
	const char* suffixes[7];
	size_t count = 0;
	snprintf(emu->saveSuffix, sizeof(emu->saveSuffix), ".sav");
	if (!core || !core->dirs.save || !core->dirs.baseName[0]) {
		return false;
	}
	/* Match mCoreAutoloadSave's per-player suffix first, so a player who
	 * configured savePlayerId keeps using the same file as before. */
	int savePlayerId = 0;
	mCoreConfigGetIntValue(&core->config, "savePlayerId", &savePlayerId);
	if (savePlayerId > 1) {
		snprintf(preferred, sizeof(preferred), ".sa%i", savePlayerId);
	}
	snprintf(emu->saveSuffix, sizeof(emu->saveSuffix), "%s", preferred);
	suffixes[count++] = preferred;
	suffixes[count++] = ".sav";
	suffixes[count++] = ".srm";
	suffixes[count++] = ".sa1";
	suffixes[count++] = ".sa2";
	suffixes[count++] = ".sa3";
	suffixes[count++] = ".sa4";
	for (size_t i = 0; i < count; ++i) {
		struct VFile* vf = mDirectorySetOpenSuffix(&core->dirs, core->dirs.save, suffixes[i], O_RDWR);
		if (!vf) {
			continue;
		}
		core->loadSave(core, vf);
		snprintf(emu->saveSuffix, sizeof(emu->saveSuffix), "%s", suffixes[i]);
		MOBILE_LOGI("Loaded battery save %s%s", core->dirs.baseName, suffixes[i]);
		return true;
	}
	return false;
}

bool mgbaMobileLoad(struct MgbaMobile* emu, const char* filename) {
	if (!emu || !filename) {
		return false;
	}
	destroyCore(emu);
	struct mCore* core = mCoreFind(filename);
	if (!core || !core->init(core)) {
		MOBILE_LOGE("Could not identify ROM: %s", filename);
		if (core) {
			free(core);
		}
		return false;
	}

	mCoreInitConfig(core, emu->port);
	mCoreConfigSetOverrideValue(&core->config, "savegamePath", emu->savePath);
	mCoreConfigSetOverrideValue(&core->config, "savestatePath", emu->statePath);
	mCoreConfigSetOverrideIntValue(&core->config, "volume", 0x100);
	mCoreConfigSetOverrideIntValue(&core->config, "frameskip", 0);
	mCoreConfigSetOverrideIntValue(&core->config, "useBios", emu->useBios ? 1 : 0);
	mCoreConfigSetOverrideIntValue(&core->config, "skipBios", emu->skipBios ? 1 : 0);
	mCoreConfigSetOverrideIntValue(&core->config, "audioSync", 0);
	mCoreConfigSetOverrideIntValue(&core->config, "videoSync", 0);
	mCoreConfigSetOverrideUIntValue(&core->config, "audioBuffers", 16384);
	if (emu->gbPaletteSet) {
		for (int i = 0; i < 12; ++i) {
			char key[16];
			snprintf(key, sizeof(key), "gb.pal[%d]", i);
			mCoreConfigSetOverrideIntValue(&core->config, key, emu->gbPalette[i]);
		}
	}
	mCoreConfigSetOverrideIntValue(&core->config, "sgb.borders", emu->sgbBorders ? 1 : 0);
	emu->core = core;
	mCoreLoadConfig(core);

	if (!mCoreLoadFile(core, filename)) {
		MOBILE_LOGE("mCoreLoadFile failed: %s", filename);
		destroyCore(emu);
		return false;
	}
	// Per-channel gains are front-end state: re-apply them to the fresh core.
	if (emu->core->platform(core) == mPLATFORM_GBA) {
		struct GBA* gba = (struct GBA*) core->board;
		gba->audio.psg.chGain[0] = (int16_t) emu->channelGains[0];
		gba->audio.psg.chGain[1] = (int16_t) emu->channelGains[1];
		gba->audio.psg.chGain[2] = (int16_t) emu->channelGains[2];
		gba->audio.psg.chGain[3] = (int16_t) emu->channelGains[3];
		gba->audio.chGainA = (int16_t) emu->channelGains[4];
		gba->audio.chGainB = (int16_t) emu->channelGains[5];
	} else if (emu->core->platform(core) == mPLATFORM_GB) {
		struct GB* gb = (struct GB*) core->board;
		gb->audio.chGain[0] = (int16_t) emu->channelGains[0];
		gb->audio.chGain[1] = (int16_t) emu->channelGains[1];
		gb->audio.chGain[2] = (int16_t) emu->channelGains[2];
		gb->audio.chGain[3] = (int16_t) emu->channelGains[3];
	}
	if (emu->patches && !mCoreAutoloadPatch(core)) {
		// No patch next to the ROM is the normal case; a bad patch only warns.
		MOBILE_LOGI("No patch applied for %s", filename);
	}
	if (!autoloadExistingSave(emu, core)) {
		/* No save next to the ROM yet: let the core create its own .sav. */
		mCoreAutoloadSave(core);
	}
	core->setAudioBufferSize(core, 16384);
	if (!ensureVideo(emu)) {
		MOBILE_LOGE("No video buffer before reset for %s", filename);
		destroyCore(emu);
		return false;
	}
	core->reset(core);
	if (core->platform(core) == mPLATFORM_GBA) {
		struct GBA* gba = (struct GBA*) core->board;
		int type = emu->saveType;
		if (type < GBA_SAVEDATA_FORCE_NONE || type > GBA_SAVEDATA_SRAM512) {
			type = GBA_SAVEDATA_AUTODETECT;
		}
		if (type != GBA_SAVEDATA_AUTODETECT) {
			GBASavedataForceType(&gba->memory.savedata, type);
			MOBILE_LOGI("GBA save type forced to %d", type);
		}
	}
	if (!ensureVideo(emu)) {
		MOBILE_LOGE("No video buffer for %s", filename);
		destroyCore(emu);
		return false;
	}

	attachKeyCallback(emu);
	attachCartHw(emu);
	// The tilt source is inert (all zeros) until the front end feeds it, so
	// attaching it for every console is harmless for games that never read it.
	emu->rotation.sample = tiltSample;
	emu->rotation.readTiltX = tiltReadX;
	emu->rotation.readTiltY = tiltReadY;
	emu->rotation.readGyroZ = tiltReadGyro;
	emu->core->setPeripheral(emu->core, mPERIPH_ROTATION, &emu->rotation);
	loadCheats(emu);
	pollLink(emu);
	// Rewind history never crosses a ROM boundary: drop the old ring and
	// build a fresh one for this game.
	if (emu->rewindInited) {
		mCoreRewindContextDeinit(&emu->rewind);
		emu->rewindInited = false;
	}
	emu->rewindCounter = 0;
	/* 加载新 ROM 不能让加载前的一个读数与加载后的读数凑成「连续两次」，
	 * 否则换游戏那一瞬间的卡顿会被当成持续变慢。保留已锁定的 pace
	 * 与吞吐记忆，只清掉未确认的反馈历史。 */
	emu->audioPaceHistLen = 0;
	emu->audioPaceOutliers = 0;
	MOBILE_LOGI("Loaded %s (%ux%u, %u Hz)", filename, emu->width, emu->height, core->audioSampleRate(core));
	return true;
}

bool mgbaMobileIsLoaded(const struct MgbaMobile* emu) {
	return emu && emu->core;
}

static uint32_t loadHeld(struct MgbaMobile* emu) {
	return __atomic_load_n(&emu->heldKeys, __ATOMIC_ACQUIRE);
}

static void noteKeys(struct MgbaMobile* emu, uint32_t keys) {
	uint32_t prev = __atomic_exchange_n(&emu->heldKeys, keys, __ATOMIC_ACQ_REL);
	uint32_t rising = keys & ~prev;
	if (rising) {
		__atomic_fetch_or(&emu->latchedKeys, rising, __ATOMIC_ACQ_REL);
		MOBILE_LOGI("Held 0x%x", keys);
	} else if (keys != prev) {
		MOBILE_LOGI("Held 0x%x", keys);
	}
}

static uint32_t applyTurbo(struct MgbaMobile* emu, uint32_t keys) {
	uint32_t turbo = __atomic_load_n(&emu->turboMask, __ATOMIC_ACQUIRE);
	if (!turbo) {
		return keys;
	}
	if ((emu->turboCounter++ & 1u) == 0u) {
		keys |= turbo;
	} else {
		keys &= ~turbo;
	}
	return keys;
}

/* == busgame 调试脚本：PC busgame-lockstep 判据脚本的设备端移植 ==
 * 与 test/gboylink_test.cpp 的 lsInjectKeys 逐行对应（常量、相位、内存判据
 * 全部一致）。差异只有载体：PC 走测试线程逐帧调用，这里可见核挂在
 * beginFrameKeys（帧精确）、镜像核由 GBoyConsoleSet 镜像线程逐帧调
 * mgbaMobileBusGameTick。队伍选择仍由内存写入完成（避开 Enter/NoEntry
 * 震荡），校验/关菜单/开战由游戏自己的代码执行。 */
void mgbaMobileBusGameStart(struct MgbaMobile* emu, int idx, int menuAt, int modeDowns) {
	if (!emu) {
		return;
	}
	emu->busGameIdx = idx;
	emu->busGameMenuAt = menuAt;
	emu->busGameModeDowns = modeDowns;
	emu->busGameFrame = 0;
	emu->busGameMenuMax = 0;
	MOBILE_LOGI("BUSGAME start idx=%d menuAt=%d modeDowns=%d", idx, menuAt, modeDowns);
}

void mgbaMobileBusGameStop(struct MgbaMobile* emu) {
	if (!emu) {
		return;
	}
	emu->busGameIdx = -1;
	MOBILE_LOGI("BUSGAME stop");
}

static uint32_t busGameKeys(struct MgbaMobile* emu) {
	struct mCore* core = emu->core;
	struct GBA* g = (struct GBA*) core->board;
	const int idx = emu->busGameIdx;
	const int menuAt = emu->busGameMenuAt;
	const int modeDowns = emu->busGameModeDowns;
	const uint32_t f = emu->busGameFrame++;
	/* 不要把「st>=4 后停手」加回来：st=4 在联机中心握手（f≈1365）就会出现，
	 * 远早于菜单导航（menuAt=1500）。一旦那时停手，导航到 multi-battle 的
	 * DOWN/A/UP/LEFT/modeDowns 按键全被跳过，游戏永远进不了对战。 */
	const uint32_t A = 1, START = 8, RIGHT = 16, LEFT = 32, UP = 64, DOWN = 128;
	const int boot = 240;
	uint32_t keys = 0;
	if (f >= boot && f < boot + 6) {
		keys = START;
	} else if (f >= boot + 10 && f < boot + 16) {
		keys = START;
	} else if (f >= boot + 20 && f < menuAt) {
		keys = ((f % 45) < 30) ? A : 0u;
	} else if (f >= menuAt && f < menuAt + 8) {
		keys = DOWN;
	} else if (f >= menuAt + 30 && f < menuAt + 40) {
		keys = A;
	} else if (f >= menuAt + 40 && f < menuAt + 60) {
		keys = UP;
	} else if (f >= menuAt + 60 && f < menuAt + 80) {
		keys = LEFT;
	} else if (modeDowns > 0 && f >= menuAt + 80
	           && f < menuAt + 80 + modeDowns * 14) {
		keys = (((f - menuAt - 80) % 14) < 4) ? DOWN : 0u;
	} else if (f >= menuAt + 80 + modeDowns * 14
	           && f < menuAt + 92 + modeDowns * 14) {
		keys = A;
	} else if (f >= menuAt + 240) {
		/* 只有 4 核都确认了「多人模式」(var8004=5, gLinkType=0x2255) 之后才
		 * 开始走位。菜单/握手阶段继续按 A。 */
		int v8 = (int) GBAView16(g->cpu, 0x0202196Cu);
		int lt = (int) GBAView16(g->cpu, 0x02027B82u);
		int fpc = (int) GBAView8(g->cpu, 0x03004A39u);
		if (v8 != 5 || (lt != 0x2255 && lt != 0x2211) || fpc < 4) {
			keys = ((f % 40) < 25) ? A : 0u;
		} else {
			int mb = (int) GBAView8(g->cpu, 0x020219D0u);
			if (mb != 0) {
				keys = ((f % 20) < 8) ? A : 0u;   /* 脉冲产生 JOY_NEW */
			} else {
				int ptype = (int) GBAView8(g->cpu, 0x02032A90u) & 0x0Fu;
				int s0 = (int) GBAView8(g->cpu, 0x02032AD0u);
				int s1 = (int) GBAView8(g->cpu, 0x02032AD1u);
				if (ptype == 4) {
					/* 选怪状态机：内存写完成「选 2 只」
					 * （gSelectedOrderFromParty={1,2}、slotId=6=确认位），
					 * 校验/关菜单/开战仍由游戏自己执行。 */
					int slot = (int8_t) GBAView8(g->cpu, 0x02032A91u);
					if (s0 == 0 || s1 == 0 || slot != 6) {
						int cc = 0;
						if (s0 == 0) { GBAStore8(g->cpu, 0x02032AD0u, (int8_t) 1, &cc); }
						if (s1 == 0) { GBAStore8(g->cpu, 0x02032AD1u, (int8_t) 2, &cc); }
						if (slot != 6) { GBAStore8(g->cpu, 0x02032A91u, (int8_t) 6, &cc); }
					}
					keys = ((f % 12) < 2) ? A : 0u;
				} else {
					/* 队伍菜单未弹出：闭环走位到 4P 座位。 */
					static const int seatX[4] = {3, 10, 3, 10};
					static const int seatY[4] = {4, 4, 6, 6};
					uint32_t sb1 = GBAView32(g->cpu, 0x03004964u);
					int px = -1, py = -1;
					if (sb1 >= 0x02000000u && sb1 < 0x03000000u) {
						px = (int16_t) GBAView16(g->cpu, sb1 + 0u);
						py = (int16_t) GBAView16(g->cpu, sb1 + 2u);
					}
					if (px < 0) {
						keys = ((f % 40) < 25) ? A : 0u;
					} else if (py > seatY[idx]) {
						keys = UP;
					} else if (py < seatY[idx]) {
						keys = DOWN;
					} else if (px > seatX[idx]) {
						keys = LEFT;
					} else if (px < seatX[idx]) {
						keys = RIGHT;
					} else {
						keys = ((f % 40) < 25) ? A : 0u;
					}
				}
			}
		}
	}
	/* 内存驱动的确定性导航：战斗模式菜单（maxCursorPos==4）把光标钳到 2
	 * （多人/4P）。联机服务菜单 4 项不能钳。 */
	if (f >= menuAt) {
		int mx = (int) GBAView8(g->cpu, 0x020296C4u);
		if (mx > emu->busGameMenuMax) {
			emu->busGameMenuMax = mx;
		}
		if (mx == 4) {
			int cur = (int) GBAView8(g->cpu, 0x020296C2u);
			if (cur != 2) {
				int cc = 0;
				GBAStore8(g->cpu, 0x020296C2u, (int8_t) 2, &cc);
			}
		}
	}
	/* 仅 0 号核（主机）补 SD/Ready(bit3)：gen8 用 (SIOCNT & 0xC)==0x8 判主机。 */
	if (idx == 0) {
		g->sio.siocnt |= 0x0008u;
	}
	if ((f % 600) == 0) {
		/* 进对战判据：callback2 @0x020290E8 落 battle_main.o
		 * （BattleMainCB2+1=0x0809AFCD）。0x03002AD4 是 gLinkCallback，
		 * 不是 callback2，别读错（与 PC 判据一致）。 */
		uint32_t cb2 = GBAView32(g->cpu, 0x020290E8u);
		uint32_t sb1 = GBAView32(g->cpu, 0x03004964u);
		int px = -1, py = -1;
		if (sb1 >= 0x02000000u && sb1 < 0x03000000u) {
			px = (int16_t) GBAView16(g->cpu, sb1 + 0u);
			py = (int16_t) GBAView16(g->cpu, sb1 + 2u);
		}
		MOBILE_LOGI("BUSGAME f=%u idx=%d pc=%d st=%d var8004=%d lt=%04X pos=%d,%d mm=%d cb2=%08X%s",
		            f, idx,
		            (int) GBAView8(g->cpu, 0x03004A39u),
		            (int) GBAView8(g->cpu, 0x020219D0u),
		            (int) GBAView16(g->cpu, 0x0202196Cu),
		            (unsigned) GBAView16(g->cpu, 0x02027B82u),
		            px, py, emu->busGameMenuMax, cb2,
		            cb2 == 0x0809AFCDu ? " BATTLE=YES" : "");
	}
	return keys;
}

/* 镜像核路径：GBoyConsoleSet 镜像线程每帧调一次，拿掩码喂 setKeys/runFrames。 */
uint32_t mgbaMobileBusGameTick(struct MgbaMobile* emu) {
	if (!emu || emu->busGameIdx < 0) {
		return 0;
	}
	return busGameKeys(emu);
}

static uint32_t beginFrameKeys(struct MgbaMobile* emu) {
	if (emu->busGameIdx >= 0) {
		/* 脚本接管：按键完全由判据脚本决定（与 PC busgame 一致）。 */
		emu->frameKeys = busGameKeys(emu);
		return emu->frameKeys;
	}
	uint32_t held = loadHeld(emu);
	uint32_t latch = __atomic_exchange_n(&emu->latchedKeys, 0, __ATOMIC_ACQ_REL);
	emu->frameKeys = applyTurbo(emu, held | latch);
	return emu->frameKeys;
}

static uint16_t readLiveKeys(struct mKeyCallback* callback) {
	struct MgbaMobile* emu = (struct MgbaMobile*) ((char*) callback - offsetof(struct MgbaMobile, keyCallback));
	/* The turbo key is driven exclusively by applyTurbo() through turboMask.
	 * If the same key bit leaks in here via held/latched (e.g. a dedicated
	 * 连发 button that also pulses this key, or a held key that raced with
	 * the auto-turbo arming), it would re-set the key on the turbo's OFF
	 * frame and pin it on forever. In a game that runs while B is held that
	 * presents as "running stuck" (跑步卡死). Mask the turbo bit out of
	 * held/latch so only the per-frame turbo decision stands. */
	uint32_t turbo = __atomic_load_n(&emu->turboMask, __ATOMIC_ACQUIRE);
	uint32_t held = loadHeld(emu) & ~turbo;
	uint32_t latch = __atomic_exchange_n(&emu->latchedKeys, 0, __ATOMIC_ACQ_REL) & ~turbo;
	uint32_t keys = emu->frameKeys | held | latch;
	emu->frameKeys = keys;
	if (latch) {
		MOBILE_LOGI("Latched 0x%x", latch);
	}
	return (uint16_t) keys;
}

static void attachKeyCallback(struct MgbaMobile* emu) {
	if (!emu->core || emu->core->platform(emu->core) != mPLATFORM_GBA) {
		return;
	}
	emu->keyCallback.readKeys = readLiveKeys;
	emu->keyCallback.requireOpposingDirections = false;
	struct GBA* gba = (struct GBA*) emu->core->board;
	gba->keyCallback = &emu->keyCallback;
}

// == Cartridge hardware (solar sensor, RTC, rumble) ==

static uint8_t solarReadLuminance(struct GBALuminanceSource* lux) {
	struct MgbaMobile* emu = (struct MgbaMobile*) ((char*) lux - offsetof(struct MgbaMobile, luminance));
	int level = emu->solarLevel;
	if (level < 0) {
		level = 0;
	}
	if (level > 9) {
		level = 9;
	}
	return (uint8_t) GBA_LUX_LEVELS[level];
}

static time_t rtcUnixTime(struct mRTCSource* rtc) {
	struct MgbaMobile* emu = (struct MgbaMobile*) ((char*) rtc - offsetof(struct MgbaMobile, rtc));
	switch (emu->rtcMode) {
	case MOBILE_RTC_FIXED:
		return (time_t) emu->rtcEpoch;
	case MOBILE_RTC_OFFSET:
		return time(0) + (time_t) emu->rtcOffset;
	default:
		return time(0);
	}
}

static void rumbleSet(struct mRumble* rumble, bool enable, uint32_t sinceLast) {
	UNUSED(sinceLast);
	if (!rumble || !enable) {
		return;
	}
	struct MgbaMobile* emu = (struct MgbaMobile*) ((char*) rumble - offsetof(struct MgbaMobile, rumble));
	__atomic_fetch_add(&emu->rumbleHits, 1, __ATOMIC_RELEASE);
}

/* Wires the front end's sensor sources into a loaded GBA board. GBA only. */
static void attachCartHw(struct MgbaMobile* emu) {
	if (!emu->core || emu->core->platform(emu->core) != mPLATFORM_GBA) {
		return;
	}
	struct GBA* gba = (struct GBA*) emu->core->board;
	emu->luminance.readLuminance = solarReadLuminance;
	if (emu->solarLevel >= 0) {
		gba->memory.hw.devices |= HW_LIGHT_SENSOR;
		gba->luminanceSource = &emu->luminance;
	}
	emu->rtc.unixTime = rtcUnixTime;
	gba->rtcSource = &emu->rtc;
	emu->rumble.setRumble = rumbleSet;
	if (emu->cartRumble) {
		gba->memory.hw.devices |= HW_RUMBLE;
		gba->rumble = &emu->rumble;
	}
}

void mgbaMobileSetSaveType(struct MgbaMobile* emu, int type) {
	if (!emu) {
		return;
	}
	emu->saveType = type;
	// Also re-force on the running core so a change takes effect on reset.
	if (emu->core && emu->core->platform(emu->core) == mPLATFORM_GBA && type != GBA_SAVEDATA_AUTODETECT
	    && type >= GBA_SAVEDATA_FORCE_NONE && type <= GBA_SAVEDATA_SRAM512) {
		GBASavedataForceType(&((struct GBA*) emu->core->board)->memory.savedata, type);
	}
}

/* TEMP PROBE: expose the running core so the desktop harness can inspect the
 * GBA board state while a frame has frozen. */
struct mCore* mgbaMobileDebugCore(struct MgbaMobile* emu) {
	return emu ? emu->core : NULL;
}

void mgbaMobileSetPatches(struct MgbaMobile* emu, bool enabled) {
	if (emu) {
		emu->patches = enabled;
	}
}

void mgbaMobileSetBiosOptions(struct MgbaMobile* emu, bool useBios, bool skipIntro) {
	if (!emu) {
		return;
	}
	emu->useBios = useBios;
	emu->skipBios = skipIntro;
}

void mgbaMobileSetRtc(struct MgbaMobile* emu, int mode, int64_t epoch, int64_t offset) {
	if (!emu) {
		return;
	}
	if (mode < MOBILE_RTC_WALL || mode > MOBILE_RTC_OFFSET) {
		mode = MOBILE_RTC_WALL;
	}
	emu->rtcMode = mode;
	emu->rtcEpoch = epoch;
	emu->rtcOffset = offset;
}

void mgbaMobileSetSolar(struct MgbaMobile* emu, int level) {
	if (!emu) {
		return;
	}
	// -1 disables the sensor (checked at the next load); 0-10 is a lux level.
	if (level > 10) {
		level = 10;
	}
	emu->solarLevel = level;
	if (emu->core && emu->core->platform(emu->core) == mPLATFORM_GBA) {
		struct GBA* gba = (struct GBA*) emu->core->board;
		if (level >= 0) {
			gba->memory.hw.devices |= HW_LIGHT_SENSOR;
			gba->luminanceSource = &emu->luminance;
		}
	}
}

int mgbaMobileTakeRumbles(struct MgbaMobile* emu) {
	if (!emu) {
		return 0;
	}
	return __atomic_exchange_n(&emu->rumbleHits, 0, __ATOMIC_ACQ_REL);
}

void mgbaMobileSetCartRumble(struct MgbaMobile* emu, bool enabled) {
	if (!emu) {
		return;
	}
	emu->cartRumble = enabled;
	if (emu->core && emu->core->platform(emu->core) == mPLATFORM_GBA) {
		struct GBA* gba = (struct GBA*) emu->core->board;
		if (enabled) {
			gba->memory.hw.devices |= HW_RUMBLE;
			gba->rumble = &emu->rumble;
		}
	}
}

// == GB palette, SGB border and tilt cartridge ==

void mgbaMobileSetGbPalette(struct MgbaMobile* emu, const int32_t* colors) {
	if (!emu || !colors) {
		return;
	}
	memcpy(emu->gbPalette, colors, sizeof(emu->gbPalette));
	emu->gbPaletteSet = true;
	// Live on a running GB core; the same overrides are replayed on every load.
	if (emu->core && emu->core->platform(emu->core) == mPLATFORM_GB) {
		for (int i = 0; i < 12; ++i) {
			char key[16];
			snprintf(key, sizeof(key), "gb.pal[%d]", i);
			mCoreConfigSetOverrideIntValue(&emu->core->config, key, emu->gbPalette[i]);
		}
		emu->core->reloadConfigOption(emu->core, "gb.pal", NULL);
	}
}

void mgbaMobileSetSgbBorders(struct MgbaMobile* emu, bool enabled) {
	if (!emu) {
		return;
	}
	emu->sgbBorders = enabled;
	if (emu->core && emu->core->platform(emu->core) == mPLATFORM_GB) {
		mCoreConfigSetOverrideIntValue(&emu->core->config, "sgb.borders", enabled ? 1 : 0);
		emu->core->reloadConfigOption(emu->core, "sgb.borders", NULL);
	}
}

/*
 * Per-channel gains for the mobile mixer: gains[0..3] are PSG channels 1-4,
 * gains[4..5] the GBA DMA A/B FIFOs. 0-256 fixed point, 256 = full volume.
 * Applied live on the running core and replayed on every load.
 */
void mgbaMobileSetChannelVolumes(struct MgbaMobile* emu, const int32_t* gains) {
	if (!emu || !gains) {
		return;
	}
	int i;
	for (i = 0; i < 6; ++i) {
		emu->channelGains[i] = gains[i];
	}
	if (emu->core && emu->core->board) {
		if (emu->core->platform(emu->core) == mPLATFORM_GBA) {
			struct GBA* gba = (struct GBA*) emu->core->board;
			gba->audio.psg.chGain[0] = (int16_t) gains[0];
			gba->audio.psg.chGain[1] = (int16_t) gains[1];
			gba->audio.psg.chGain[2] = (int16_t) gains[2];
			gba->audio.psg.chGain[3] = (int16_t) gains[3];
			gba->audio.chGainA = (int16_t) gains[4];
			gba->audio.chGainB = (int16_t) gains[5];
		} else if (emu->core->platform(emu->core) == mPLATFORM_GB) {
			struct GB* gb = (struct GB*) emu->core->board;
			gb->audio.chGain[0] = (int16_t) gains[0];
			gb->audio.chGain[1] = (int16_t) gains[1];
			gb->audio.chGain[2] = (int16_t) gains[2];
			gb->audio.chGain[3] = (int16_t) gains[3];
		}
	}
}

static void tiltSample(struct mRotationSource* rotation) {
	UNUSED(rotation);
}

static int32_t tiltReadX(struct mRotationSource* rotation) {
	struct MgbaMobile* emu = (struct MgbaMobile*) ((char*) rotation - offsetof(struct MgbaMobile, rotation));
	return __atomic_load_n(&emu->tiltX, __ATOMIC_RELAXED);
}

static int32_t tiltReadY(struct mRotationSource* rotation) {
	struct MgbaMobile* emu = (struct MgbaMobile*) ((char*) rotation - offsetof(struct MgbaMobile, rotation));
	return __atomic_load_n(&emu->tiltY, __ATOMIC_RELAXED);
}

static int32_t tiltReadGyro(struct mRotationSource* rotation) {
	struct MgbaMobile* emu = (struct MgbaMobile*) ((char*) rotation - offsetof(struct MgbaMobile, rotation));
	return __atomic_load_n(&emu->gyroZ, __ATOMIC_RELAXED);
}

/*
 * Tilt cartridge input. tiltX/tiltY are normalized to -1..1; the core shifts
 * them (>> 22 for GBA, >> 21 for GB), so the full range spans one complete
 * sensor deflection, matching what the reference front ends feed it.
 */
void mgbaMobileSetRotation(struct MgbaMobile* emu, float tiltX, float tiltY, float gyroZ) {
	if (!emu) {
		return;
	}
	if (tiltX < -1.0f) {
		tiltX = -1.0f;
	}
	if (tiltX > 1.0f) {
		tiltX = 1.0f;
	}
	if (tiltY < -1.0f) {
		tiltY = -1.0f;
	}
	if (tiltY > 1.0f) {
		tiltY = 1.0f;
	}
	__atomic_store_n(&emu->tiltX, (int32_t) (tiltX * 1073741824.0f), __ATOMIC_RELAXED);
	__atomic_store_n(&emu->tiltY, (int32_t) (tiltY * 1073741824.0f), __ATOMIC_RELAXED);
	__atomic_store_n(&emu->gyroZ, (int32_t) (gyroZ * 1073741824.0f), __ATOMIC_RELAXED);
}

// == Cheats ==

static void cheatFilePath(const struct MgbaMobile* emu, char* out, size_t outLen) {
	out[0] = '\0';
	if (!emu || !emu->core || emu->savePath[0] == '\0' || emu->core->dirs.baseName[0] == '\0') {
		return;
	}
	snprintf(out, outLen, "%s/%s.cht", emu->savePath, emu->core->dirs.baseName);
}

static struct mCheatDevice* cheatDevice(struct MgbaMobile* emu) {
	if (!emu || !emu->core || !emu->core->cheatDevice) {
		return NULL;
	}
	return emu->core->cheatDevice(emu->core);
}

static void loadCheats(struct MgbaMobile* emu) {
	struct mCheatDevice* device = cheatDevice(emu);
	char path[1200];
	if (!device) {
		return;
	}
	cheatFilePath(emu, path, sizeof(path));
	struct VFile* vf = VFileOpen(path, O_RDONLY);
	if (!vf) {
		return;
	}
	if (!mCheatParseFile(device, vf)) {
		MOBILE_LOGI("Cheat file present but unreadable: %s", path);
	}
	vf->close(vf);
}

static void saveCheats(struct MgbaMobile* emu) {
	struct mCheatDevice* device = cheatDevice(emu);
	char path[1200];
	if (!device) {
		return;
	}
	cheatFilePath(emu, path, sizeof(path));
	struct VFile* vf = VFileOpen(path, O_WRONLY | O_CREAT | O_TRUNC);
	if (!vf) {
		return;
	}
	mCheatSaveFile(device, vf);
	vf->close(vf);
}

int mgbaMobileCheatCount(const struct MgbaMobile* emu) {
	struct MgbaMobile* mut = (struct MgbaMobile*) emu;
	struct mCheatDevice* device = cheatDevice(mut);
	if (!device) {
		return 0;
	}
	return (int) mCheatSetsSize(&device->cheats);
}

void mgbaMobileCheatName(const struct MgbaMobile* emu, int index, char* out, size_t outLen) {
	struct MgbaMobile* mut = (struct MgbaMobile*) emu;
	struct mCheatDevice* device = cheatDevice(mut);
	const char* name = "";
	if (!out || outLen == 0) {
		return;
	}
	out[0] = '\0';
	if (!device || index < 0 || (size_t) index >= mCheatSetsSize(&device->cheats)) {
		return;
	}
	struct mCheatSet* set = *mCheatSetsGetPointer(&device->cheats, index);
	if (set && set->name) {
		name = set->name;
	}
	snprintf(out, outLen, "%s", name);
}

bool mgbaMobileCheatEnabled(const struct MgbaMobile* emu, int index) {
	struct MgbaMobile* mut = (struct MgbaMobile*) emu;
	struct mCheatDevice* device = cheatDevice(mut);
	if (!device || index < 0 || (size_t) index >= mCheatSetsSize(&device->cheats)) {
		return false;
	}
	return (*mCheatSetsGetPointer(&device->cheats, index))->enabled;
}

void mgbaMobileCheatSetEnabled(struct MgbaMobile* emu, int index, bool enabled) {
	struct mCheatDevice* device = cheatDevice(emu);
	if (!device || index < 0 || (size_t) index >= mCheatSetsSize(&device->cheats)) {
		return;
	}
	struct mCheatSet* set = *mCheatSetsGetPointer(&device->cheats, index);
	set->enabled = enabled;
	mCheatRefresh(device, set);
	saveCheats(emu);
}

bool mgbaMobileCheatAdd(struct MgbaMobile* emu, const char* name, const char* lines, int type) {
	struct mCheatDevice* device = cheatDevice(emu);
	if (!device || !lines) {
		return false;
	}
	struct mCheatSet* set = device->createSet(device, name ? name : "");
	if (!set) {
		return false;
	}
	bool any = false;
	const char* cursor = lines;
	char line[256];
	while (cursor && *cursor) {
		const char* end = strpbrk(cursor, "\r\n");
		size_t len = end ? (size_t) (end - cursor) : strlen(cursor);
		if (len >= sizeof(line)) {
			len = sizeof(line) - 1;
		}
		memcpy(line, cursor, len);
		line[len] = '\0';
		char* trim = line;
		while (*trim == ' ' || *trim == '\t') {
			++trim;
		}
		char* last = trim + strlen(trim);
		while (last > trim && (last[-1] == ' ' || last[-1] == '\t')) {
			--last;
		}
		*last = '\0';
		if (*trim && mCheatAddLine(set, trim, type)) {
			any = true;
		}
		cursor = end ? end + 1 : NULL;
	}
	if (!any) {
		mCheatSetDeinit(set);
		return false;
	}
	set->enabled = true;
	mCheatAddSet(device, set);
	mCheatRefresh(device, set);
	saveCheats(emu);
	return true;
}

bool mgbaMobileCheatRemove(struct MgbaMobile* emu, int index) {
	struct mCheatDevice* device = cheatDevice(emu);
	if (!device || index < 0 || (size_t) index >= mCheatSetsSize(&device->cheats)) {
		return false;
	}
	struct mCheatSet* set = *mCheatSetsGetPointer(&device->cheats, index);
	mCheatRemoveSet(device, set);
	mCheatSetDeinit(set);
	saveCheats(emu);
	return true;
}

static void applyFrameskip(struct mCore* core, int skip) {
	if (skip < 0) {
		skip = 0;
	}
	core->opts.frameskip = skip;
	if (core->platform(core) == mPLATFORM_GBA) {
		struct GBA* gba = (struct GBA*) core->board;
		gba->video.frameskip = skip;
		if (gba->video.frameskipCounter > skip) {
			gba->video.frameskipCounter = skip;
		}
	} else if (core->platform(core) == mPLATFORM_GB) {
		struct GB* gb = (struct GB*) core->board;
		gb->video.frameskip = skip;
		if (gb->video.frameskipCounter > skip) {
			gb->video.frameskipCounter = skip;
		}
	}
}

static void setFastAudio(struct MgbaMobile* emu, int fast) {
	if (!emu || !emu->core || emu->fast == fast) {
		return;
	}
	emu->fast = fast;
	// 倍速也有声音：不再关闭音频采样，保持音频缓冲持续产生�?
	// 变速播放由前端 AudioTrack / AVAudioUnitVarispeed 完成�?
}

static struct mTiming* coreTiming(struct MgbaMobile* emu) {
	if (!emu->core) {
		return NULL;
	}
	if (emu->core->platform(emu->core) == mPLATFORM_GBA) {
		return &((struct GBA*) emu->core->board)->timing;
	}
	if (emu->core->platform(emu->core) == mPLATFORM_GB) {
		return &((struct GB*) emu->core->board)->timing;
	}
	return NULL;
}

static void armLinkEvent(struct MgbaMobile* emu) {
	struct mTiming* timing = coreTiming(emu);
	if (!timing) {
		return;
	}
	mTimingDeschedule(timing, &emu->linkEvent);
	mTimingSchedule(timing, &emu->linkEvent, 8192);
}

static uint32_t readLinkOut(struct MgbaMobile* emu, uint16_t* modeOut) {
	if (!emu->core) {
		return 0xFFFFFFFFu;
	}
	if (emu->core->platform(emu->core) == mPLATFORM_GBA) {
		struct GBA* gba = (struct GBA*) emu->core->board;
		*modeOut = (uint16_t) gba->sio.mode;
		if (gba->sio.mode == GBA_SIO_NORMAL_32) {
			return gba->memory.io[GBA_REG(SIODATA32_LO)] | ((uint32_t) gba->memory.io[GBA_REG(SIODATA32_HI)] << 16);
		}
		if (gba->sio.mode == GBA_SIO_NORMAL_8) {
			return gba->memory.io[GBA_REG(SIODATA8)] & 0xFFu;
		}
		return gba->memory.io[GBA_REG(SIOMLT_SEND)];
	}
	if (emu->core->platform(emu->core) == mPLATFORM_GB) {
		struct GB* gb = (struct GB*) emu->core->board;
		*modeOut = 0;
		return gb->memory.io[GB_REG_SB];
	}
	return 0xFFFFFFFFu;
}

static void finishIncoming(struct MgbaMobile* emu, uint16_t mode, uint32_t remote, int player) {
	int me = netLinkPlayer(emu->link);
	if (emu->core->platform(emu->core) == mPLATFORM_GBA) {
		struct GBA* gba = (struct GBA*) emu->core->board;
		if (emu->sioInDbg < 40) {
			++emu->sioInDbg;
			MOBILE_LOGI("SIO in me=%d pktmode=%u player=%d siomode=%d siocnt=%04X wait=%d remote=%04X",
			            me, mode, player, (int) gba->sio.mode, gba->sio.siocnt, emu->sioWaiting, remote);
		}
		if (gba->sio.mode == GBA_SIO_MULTI && (mode == GBA_SIO_MULTI || mode == 0)) {
			/* 只在游戏确实处于联机等待时才收尾：要么 Busy 立着（游戏自己起了
			 * 一次传输），要么开了 SIO 中断使能（宝可梦的等待写法 0x600F，
			 * Busy 留给硬件置位）。两个都没有说明游戏不在联机，乱填数据发
			 * 中断会把游戏没在等的交换结果塞给它。 */
			bool busy = (gba->sio.siocnt & 0x0080) != 0;
			bool armed = (gba->sio.siocnt & 0x4000) != 0;
			if (emu->sioWaiting || !(busy || armed)) {
				if (emu->sioSkipDbg < 20) {
					++emu->sioSkipDbg;
					MOBILE_LOGI("SIO in skip me=%d busy=%d armed=%d wait=%d siocnt=%04X",
					            me, busy, armed, emu->sioWaiting, gba->sio.siocnt);
				}
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
			LINK_VERBOSE("SIO multi done slave me=%d m0=%04x m1=%04x", me, data[0], data[1]);
			if (emu->sioSlaveDoneDbg < 20) {
				++emu->sioSlaveDoneDbg;
				MOBILE_LOGI("SIO slave done me=%d player=%d m0=%04X m1=%04X siocnt=%04X",
				            me, player, data[0], data[1], gba->sio.siocnt);
			}
			emu->sioFallback++;
			emu->sioHasRemote = true;
			emu->sioRemote = remote;
			GBASIOMultiplayerFinishTransfer(&gba->sio, data, 0);
		} else if (gba->sio.mode == GBA_SIO_NORMAL_8) {
			GBASIONormal8FinishTransfer(&gba->sio, (uint8_t) remote, 0);
		} else if (gba->sio.mode == GBA_SIO_NORMAL_32) {
			GBASIONormal32FinishTransfer(&gba->sio, remote, 0);
		}
		return;
	}
	if (emu->core->platform(emu->core) == mPLATFORM_GB) {
		struct GB* gb = (struct GB*) emu->core->board;
		gb->sio.pendingSB = (uint8_t) remote;
		uint8_t sc = gb->memory.io[GB_REG_SC];
		int speed = GBRegisterSCGetClockSpeed(sc);
		if (speed < 0 || speed > 1) {
			speed = 0;
		}
		gb->sio.period = GBSIOCyclesPerTransfer[speed];
		gb->memory.io[GB_REG_SC] = GBRegisterSCFillEnable(sc);
		gb->sio.remainingBits = 8;
		mTimingDeschedule(&gb->timing, &gb->sio.event);
		int scale = gb->doubleSpeed ? 1 : 2;
		mTimingSchedule(&gb->timing, &gb->sio.event, gb->sio.period * scale);
	}
}

static void completeMultiTransfer(struct MgbaMobile* emu, uint32_t remote, bool haveRemote, uint32_t cyclesLate);
static void completeMultiTransferBus(struct MgbaMobile* emu, const uint32_t vals[4], int players, uint32_t cyclesLate);

/* 联机排查用的游戏内存窥探（只在开着 MGBA_LINK_PEEK 时编译进去）。
 * 地址来自 ROM 工程的 rom.map（pokeemerald 系布局）。 */
#ifndef MGBA_LINK_PEEK
#define MGBA_LINK_PEEK 1
#endif

#if MGBA_LINK_PEEK
/* 联机排查用的游戏内存窥探（只在开着 MGBA_LINK_PEEK 时编译进去）。
 * 地址来自 ROM 工程的 rom.map（pokeemerald 系布局，v1.7 汉化改版）：
 *   gLink                  0x03002AF4  struct Link
 *   gLinkStatus            0x03002A9C  u32（localId | playerCount<<4 | ...）
 *   gShouldAdvanceLinkState 0x03002AD8 u8
 *   gLinkOpen              0x02027B80
 *   gWirelessCommType      0x03002AAD  u8（0=有线，1=无线）
 *   gLinkErrorOccurred     0x03002A30
 *   gReceivedRemoteLinkPlayers 0x03002AC1
 *   gBlockReceivedStatus   0x03002A40
 * struct Link 内部偏移（include/link.h）：sendQueue 在 +0x18，
 * u16 data[8][50] 之后是 pos/count；recvQueue 在 +0x33C，
 * u16 data[4][8][50] 之后是 pos/count。 */
#define PEEK_LINK_STATUS 0x03002A9Cu
#define PEEK_LINK_STATE  0x03002AD8u
#define PEEK_LINK        0x03002AF4u
#define PEEK_LINK_OPEN   0x02027B80u
#define PEEK_LINK_WLESS  0x03002AADu
#define PEEK_LINK_ERROCC 0x03002A30u
#define PEEK_LINK_RECVPL 0x03002AC1u
#define PEEK_LINK_BLOCKS 0x03002A40u
/* struct Link 内部偏移 */
#define PEEK_LK_ISMASTER 0x00
#define PEEK_LK_STATE    0x01
#define PEEK_LK_LOCALID  0x02
#define PEEK_LK_PLAYERS  0x03
#define PEEK_LK_SICTR    0x0D
#define PEEK_LK_HANDSHAKE 0x0E
#define PEEK_LK_FIELD_F  0x0F
#define PEEK_LK_HWERR    0x10
#define PEEK_LK_BADCK    0x11
#define PEEK_LK_QFULL    0x12
#define PEEK_LK_LAG      0x13
#define PEEK_LK_CHECKSUM 0x14
#define PEEK_LK_SENDIX   0x16
#define PEEK_LK_RECVIX   0x17
#define PEEK_LK_SENDQ_POS 0x0338
#define PEEK_LK_SENDQ_CNT 0x0339
#define PEEK_LK_RECVQ_POS 0x0FBC
#define PEEK_LK_RECVQ_CNT 0x0FBD
#endif

static void serviceLink(struct MgbaMobile* emu) {
	if (!emu->linkAttached || !emu->link) {
		return;
	}
	/* 轮询频率探针：serviceLink 由 linkPollEvent 驱动（每 8192 个模拟周期一次），
	 * 理论上每帧 30 多次。联机握手慢的时候要靠它确认「模拟线程有没有在跑」。 */
	++emu->sioPolls;
	if ((emu->sioPolls % 1000) == 0) {
		uint32_t now = wallNowMs();
		if (emu->sioPollStamp) {
			MOBILE_LOGI("POLL me=%d n=%u rate=%u/s svcAvg=%.2fms svcMax=%.2fms",
			            netLinkPlayer(emu->link), emu->sioPolls,
			            (uint32_t) (1000.0 * 1000.0 / (double) (now - emu->sioPollStamp)),
			            emu->sioSvcTotal / (double) emu->sioSvcN, emu->sioSvcMax);
			emu->sioSvcTotal = 0.0;
			emu->sioSvcMax = 0.0;
			emu->sioSvcN = 0;
		}
		emu->sioPollStamp = now;
	}
	uint32_t svcStart = wallNowMs();
	/* 链路状态可能在游戏读 SIOCNT 之后才变化（游戏只在少数几处写 SIOCNT），
	 * 所以每次轮询都把终端位重新对齐一次「链路当前真实的样子」。
	 * 游戏在 HANDSHAKE 态每帧读一次 SIOCNT，下一帧就会用上正确的值。 */
	applyLinkTerminalBits(emu);
	/* 让 IO 线程随时能拿到本机当前要发的字节：对端发请求时它直接回，不必等
	 * 模拟线程排到。 */
	uint16_t localMode = 0;
	uint32_t local = readLinkOut(emu, &localMode);
	netLinkPublish(emu->link, localMode, local);
	/* 持续量链路 RTT（µs）：GBA 联机要求每帧 9 次以上串行中断，
	 * 一轮往返必须压进 1ms，这个数直接决定能不能连上。 */
	netLinkPingTick(emu->link);
	/* MULTI 的发送是「一轮一次、两边各推各的」，不再为每个往返等一条 ACK
	 * （原来每轮要等 ACK，实测 16ms/轮，握手要跑上万轮，游戏最后报「连接
	 * 发生了错误」）。1P 在写 SIOCNT 起传输那一刻推，2P 在收尾之后的下一
	 * 次轮询推 —— 两边的时机差别见下面各自的注释，这是本文件最容易错位
	 * 一格的地方。 */
	if (emu->core && emu->core->platform(emu->core) == mPLATFORM_GBA) {
		struct GBA* gba = (struct GBA*) emu->core->board;
		int player = netLinkPlayer(emu->link);
		/* 从机不自己起传输：真机里 MULTI 的时钟是 1P 产生的，从机只是在自己的
		 * SIO 被时钟扫过时收尾。1P 每轮开始时把本轮的字推过来，收到就把这次
		 * 传输收掉（写 SIOMULTI + 发 SIO 中断），从机自己的游戏才会往下走。
		 *
		 * 收尾动作搬到 sioSlaveDoneEvent 了：由一个**按固定模拟周期触发**的
		 * 事件来收尾，把从机的模拟时钟钉在与主机同速的节拍上（为什么必须同速
		 * 见 sioSlaveDoneEvent 的注释）。这里只负责把事件挂上。
		 *
		 * 千万不要「提前把下一轮推出去」：gen8 的字是在上一轮收尾的 SIO 中断处理
		 * 里写的，提前推要赌中断已经跑完 —— 实测 93 轮赌输 1 轮（推出去 0000、
		 * 游戏随后才写 AABB），对端把旧值记进本轮，checksum 当场 ck=1。 */
		/* 【从机的轮次事件只在「对端真的推了字过来」时才挂】
		 *
		 * 原来这里判的是 gba->sio.mode == GBA_SIO_MULTI —— 但 gen8 的
		 * DisableSerial() 写的是 REG_SIOCNT = SIO_MULTI_MODE(0x2000)，
		 * 而 LinkMain1 一进 START0 就会调它一次，之后 sio.mode 就一直
		 * 停在 MULTI。于是「只要链路挂上」这个条件在**游戏还没进俱乐部、
		 * 主机一个字节都没推**的时候就成立，从机的轮次事件被挂上，
		 * 每 18363 个模拟周期阻塞地等一个永远不会来的字。
		 *
		 * 后果（实测）：模拟线程每推进 1.1ms 的模拟时间就要阻塞 20ms 的
		 * 墙钟时间，帧率从 60fps 掉到 1.4fps —— 从机的游戏直接冻在标题
		 * 画面走不到俱乐部；联机中掉帧又会打破 gen8「每帧至少 9 次串行
		 * 中断」的要求，游戏报「通信错误…链接是坏的还是终端不匹配？」。
		 *
		 * 改成「对端队列里有字才挂」：没联机时主机一个字都不推，从机永远
		 * 不会被挂上，模拟线程保持满速；联机开始后主机每轮推一个字，从机
		 * 照旧一轮一个地取走。
		 *
		 * 总线例外（2026-11-10）：3/4 人的字走 PKT_PUSH / PKT_BUS_ROUND，
		 * 根本不进 peerQ，netLinkPeerPending() 恒为 0 —— 沿用原判据会让
		 * 从机轮次事件永远 arm 不上（主机每轮等满超时窗，从机收不到 SIO
		 * 中断卡在进房前：busgame 实测从机 45s 只跑 302 帧）。总线改看
		 * sioRoundWordValid：游戏自己写过 SIOCNT 起 MULTI 才算一轮，既不
		 * 会在还没进房间时自旋，也不依赖主机先广播（避开第一轮互等）。 */
		bool busMode = netLinkBusActive(emu->link);
		bool roundReady = busMode ? emu->sioRoundWordValid
		                          : netLinkPeerPending(emu->link) > 0;
		if (player != 0 && !emu->sioSlaveArmed && roundReady) {
			struct mTiming* timing = coreTiming(emu);
			if (timing) {
				mTimingSchedule(timing, &emu->sioSlaveDone, emu->sioSlavePeriod);
				emu->sioSlaveArmed = true;
				MOBILE_LOGI("SIO slave arm: idx=%u period=%u",
				            (unsigned) emu->sioIndex, emu->sioSlavePeriod);
			}
		}
	}
	/* 先收主机的传输请求：从机的这一次传输应当由它来收尾。做完再考虑看门狗，
	 * 否则排队中的请求会被看门狗把 Busy 清掉、然后被 busy 守卫丢掉。 */
	int guard = 0;
	int taken = 0;
	uint16_t seq;
	uint16_t mode;
	uint32_t value;
	int player;
	while (guard++ < 8 && netLinkTakeRequest(emu->link, &seq, &mode, &value, &player)) {
		++taken;
		if (emu->sioTakeDbg < 30 && emu->core->platform(emu->core) == mPLATFORM_GBA) {
			++emu->sioTakeDbg;
			struct GBA* g = (struct GBA*) emu->core->board;
			MOBILE_LOGI("SIO take seq=%u mode=%u player=%d siocnt=%04X wait=%d",
			            seq, mode, player, g->sio.siocnt, emu->sioWaiting);
		}
		if (emu->sioWaiting) {
			/* 本机正等自己这次传输的应答，说明双方都在当主机（正常不会发生
			 * ：只有 1P 能发起 MULTI 传输）。丢弃，避免同一次传输被完成两次。 */
			continue;
		}
		LINK_VERBOSE("SIO req seq=%u mode=%u value=%08x player=%d", seq, mode, value, player);
		if (mode == GBA_SIO_MULTI) {
			/* MULTI 不再走请求：两边各自按轮次推送、各自到点收尾，请求一旦
			 * 也拿来收尾就会把同一轮完成两次。 */
			continue;
		}
		finishIncoming(emu, mode, value, player);
	}
	/* 原来的「看门狗」被 sioSlaveDoneEvent 取代了：从机的每一轮都由那个
	 * 定时事件收尾，事件里已经带 2500ms 的超时等待，主机掉线时从机会自己
	 * 超时收尾，不需要额外的看门狗。
	 *
	 * 而且看门狗在这里是**危险**的：它会在 Busy 位还挂着的时候擅自
	 * ++sioIndex 并多推一个字，那一轮就凭空多出来，双方的轮次从此错位，
	 * checksum 必挂。现在从机的轮次只有一个来源（sioSlaveDoneEvent），
	 * 轮次一一对应，不存在这种风险。 */
	/* serviceLink 自身耗时：它跑在模拟线程里，一次 30ms 就足以让对端多等一整
	 * 个轮询周期（这正是「每轮等 31ms」的嫌疑点）。 */
	{
		uint32_t spent = wallNowMs() - svcStart;
		emu->sioSvcTotal += (double) spent;
		emu->sioSvcMax = spent > emu->sioSvcMax ? (double) spent : emu->sioSvcMax;
		++emu->sioSvcN;
	}
}

static void linkPollEvent(struct mTiming* timing, void* user, uint32_t cyclesLate) {
	UNUSED(cyclesLate);
	struct MgbaMobile* emu = (struct MgbaMobile*) user;
	if (emu->sioEvtDbg < 20 && emu->core && emu->core->platform(emu->core) == mPLATFORM_GBA) {
		++emu->sioEvtDbg;
		struct GBA* g = (struct GBA*) emu->core->board;
		MOBILE_LOGI("SIO evt #%u mode=%d siocnt=%04X attached=%d wait=%d",
		            emu->sioEvtDbg, (int) g->sio.mode, g->sio.siocnt, emu->linkAttached, emu->sioWaiting);
	}
	serviceLink(emu);
	if (emu->linkAttached) {
		mTimingSchedule(timing, &emu->linkEvent, 8192);
	}
}

/* 用一次传输的数据填 SIOMULTI0..3 并结束这次传输。 */
/**
 * 有线俱乐部 standby 卡死的运行时适配，与 Qt 版 sio_link.c 对称。
 * 默认关闭：安卓用系统属性 mgbax.link.unstick=1 打开，桌面用
 * MGBAX_LINK_UNSTICK=1。只在精确命中 gen8 的卡死状态时写一次
 * IWRAM 函数指针，把它换成游戏自带的 LinkCB_Standby，保留原来的
 * gLastRecvQueueCount 门控，不改 ROM、不改游戏逻辑。
 */
static int unstickEnabled(struct MgbaMobile* emu) {
	if (emu->unstickModeCached < 0) {
#ifdef __ANDROID__
		char v[PROP_VALUE_MAX] = {0};
		__system_property_get("mgbax.link.unstick", v);
		emu->unstickModeCached = (v[0] == '1') ? 1 : ((v[0] == '2') ? 2 : 0);
#else
		const char* v = getenv("MGBAX_LINK_UNSTICK");
		emu->unstickModeCached = (v && v[0] == '1') ? 1 : ((v && v[0] == '2') ? 2 : 0);
#endif
	}
	return emu->unstickModeCached;
}

/* One decision step, kept as a public per-instance function so the desktop
 * test can prove two cores in one process do not share the one-shot latch.
 * Returns 1 exactly on the call that arms the patch. */
int mgbaMobileUnstickStep(struct MgbaMobile* emu, int mode, bool matched) {
	if (!emu || emu->unstickDone || !mode) {
		return 0;
	}
	if (!matched) {
		emu->unstickStreak = 0;
		return 0;
	}
	if (++emu->unstickStreak >= 3) {
		emu->unstickDone = true;
		return 1;
	}
	return 0;
}

static void maybeUnstickStandby(struct MgbaMobile* emu, struct GBA* gba) {
	int mode = unstickEnabled(emu);
	if (!mode || !gba || !gba->cpu) {
		return;
	}
	uint16_t l0 = GBAView16(gba->cpu, 0x03002AF4u);
	uint16_t rem16 = GBAView16(gba->cpu, 0x03002AC0u);
	uint16_t cbLo = GBAView16(gba->cpu, 0x03002AD4u);
	uint16_t cbHi = GBAView16(gba->cpu, 0x03002AD6u);
	uint32_t cb = (uint32_t) cbLo | ((uint32_t) cbHi << 16);
	uint16_t mu = GBAView16(gba->cpu, 0x0201CFC4u) & 0xFFu;
	uint16_t brs = GBAView16(gba->cpu, 0x03002A40u);
	int state = (l0 >> 8) & 0xFF;
	int rem = (rem16 >> 8) & 0xFF;
	bool matched = (state == 4 && rem == 1 && cb == 0x08151DA9u && mu == 0 && brs == 0);
	if (mgbaMobileUnstickStep(emu, mode, matched)) {
		/* mode 2 直接置 NULL，跳过 standby，让游戏进 CB2_InitBattle；
		 * SendBlock 会自行安装 LinkCB_BlockSend* 回调。 */
		uint32_t target = (mode == 2) ? 0x00000000u : 0x081529BDu;
		gba->memory.iwram[(0x03002AD4u - 0x03000000u) >> 2] = target;
		MOBILE_LOGI("[unstick] mode=%d cb %08X -> %08X (state=%d rem=%d mu=%u)",
		            mode, cb, target, state, rem, mu);
	}
}

/**
 * 联机房间握手「主从选举」补触发（默认开启，系统属性 mgbax.link.rearm=0 关闭）。
 *
 * gen8 的 LinkMain1 只在 gShouldAdvanceLinkState==1 的那一帧做一次主从选举
 * （Task_TriggerHandshake 在 OpenLink 后第 5 帧置 1），且要求那一瞬间
 * gLink.playerCount > 1。网络联机时两端进房间必然差几十帧以上，主机端选举时
 * 对方还没出现，两端就都退化成从机、都只发 0xB9A0，DoHandshake() 永远等不到
 * 0x8FFF，双端永久卡在「等待连接」。这里在「双方已连上(playerCount>=2)、仍在
 * 握手态(state==2)、但还没选出主机(handshakeAsMaster==0)」时代游戏把
 * gShouldAdvanceLinkState 置 1，重新选举一次。只写 IWRAM 的 1 个字节标志。
 */
static void maybeRearmHandshake(struct MgbaMobile* emu, struct GBA* gba) {
	if (emu->rearmEnabled < 0) {
#ifdef __ANDROID__
		char v[PROP_VALUE_MAX] = {0};
		__system_property_get("mgbax.link.rearm", v);
		emu->rearmEnabled = (v[0] == '0') ? 0 : 1;
#else
		const char* v = getenv("MGBAX_LINK_REARM");
		emu->rearmEnabled = (v && v[0] == '0') ? 0 : 1;
#endif
	}
	if (!emu->rearmEnabled || !gba || !gba->cpu) {
		return;
	}
	/* 逐字节读 struct Link（不能从 uint16 右移 24 位取 playerCount，会恒为 0）。 */
	int isMaster = GBAView8(gba->cpu, 0x03002AF4u + 0x00u);
	int state = GBAView8(gba->cpu, 0x03002AF4u + 0x01u);
	int players = GBAView8(gba->cpu, 0x03002AF4u + 0x03u);
	int hs = GBAView8(gba->cpu, 0x03002AF4u + 0x0Eu);       // handshakeAsMaster
	if (state != 2 || players < 2 || hs != 0) {
		return;
	}
	if (isMaster != 8) {
		MOBILE_LOGI("[rearm] waiting: isMaster=%d (need 8) players=%d", isMaster, players);
		return;
	}
	/* gShouldAdvanceLinkState @ 0x03002AD8：只置最低字节的最低位。 */
	uint32_t idx = (0x03002AD8u - 0x03000000u) >> 2;
	gba->memory.iwram[idx] |= 0x00000001u;
	MOBILE_LOGI("[rearm] handshake election retriggered (players=%d)", players);
}

/* 四个槽位已经凑齐之后的公共收尾：耗时统计、诊断日志、写 SIOMULTI0..3、
 * 发 SIO 中断。两人直连和 3/4 人总线都汇到这里，诊断口径保持一致。 */
static void finishMultiTransfer(struct MgbaMobile* emu, uint16_t data[4], uint32_t cyclesLate) {
	struct GBA* gba = (struct GBA*) emu->core->board;
	int me = netLinkPlayer(emu->link);
	/* 单次传输耗时（单位 0.1ms）与统计，联机排查就靠这行。 */
	struct mTiming* timing = coreTiming(emu);
	if (timing) {
		uint32_t spent = mTimingCurrentTime(timing) - emu->sioStartCycle;
		uint32_t tenth = spent / 1677 + ((spent % 1677) ? 1 : 0);
		emu->sioLateness = tenth;
		if (tenth > emu->sioPeak) {
			emu->sioPeak = tenth;
		}
	}
	emu->sioOk++;
	emu->sioBusyCycle = 0;
	emu->sioStashValid = false;
	/* 握手/数据阶段定向日志：B9A0 等待轮安静，其余（8FFF/数据字/空轮/超时）全记，
	 * 两边逐轮对比就能看出错位在哪一轮。 */
	if (((data[0] != 0xB9A0 && data[0] != 0xFFFF) || (data[1] != 0xB9A0 && data[1] != 0xFFFF))
	    && emu->hsDbg < 900) {
		++emu->hsDbg;
		MOBILE_LOGI("HSX #%u me=%d idx=%u m0=%04X m1=%04X have=%d to=%u mis=%u",
		            emu->hsDbg, me, (unsigned) emu->sioIndex, data[0], data[1],
		            emu->sioHasRemote ? 1 : 0, emu->sioTimeouts, emu->sioMisorder);
	}
	if (emu->xferDbg < 900) {
		/* 「对端」在 3/4 人总线里有多个槽位，日志里取第一个非空槽，
		 * 两人直连时它就是唯一的对端。 */
		uint32_t peerWord = 0xDEADu;
		int peerHave = 0;
		for (int i = 0; i < 4; ++i) {
			if (i != me && data[i] != 0xFFFF) {
				peerWord = data[i];
				peerHave = 1;
				break;
			}
		}
		++emu->xferDbg;
		MOBILE_LOGI("XFER #%u me=%d idx=%u own=%04X peer=%04X have=%d to=%u",
		            emu->xferDbg, me, (unsigned) emu->sioIndex,
		            (unsigned) (me >= 0 && me < 4 ? data[me] : 0),
		            (unsigned) peerWord, peerHave,
		            emu->sioTimeouts);
	}
	if ((emu->sioOk & 0x3F) == 0) {
		mLOG(GBA_SIO, INFO, "SIO multi me=%d ok=%u last=%u.%ums peak=%u.%ums retry=%d to=%u fb=%u mis=%u m0=%04X m1=%04X",
		     me, emu->sioOk, emu->sioLateness / 10, emu->sioLateness % 10,
		     emu->sioPeak / 10, emu->sioPeak % 10, emu->sioRetries, emu->sioTimeouts, emu->sioFallback, emu->sioMisorder, data[0], data[1]);
		MOBILE_LOGI("SIO multi me=%d ok=%u last=%u.%ums peak=%u.%ums retry=%d to=%u fb=%u mis=%u m0=%04X m1=%04X",
		     me, emu->sioOk, emu->sioLateness / 10, emu->sioLateness % 10,
		     emu->sioPeak / 10, emu->sioPeak % 10, emu->sioRetries, emu->sioTimeouts, emu->sioFallback, emu->sioMisorder, data[0], data[1]);
		/* 联机协议层诊断：链路「连着」不等于数据在走。gen8 的 LINKUP 结果、
		 * 远端玩家标志、块接收状态、收发命令索引都在内存里，一次打全，
		 * 就能区分「命令没到」和「到了但校验不过」。 */
		MOBILE_LOGI("GLINK res=%u rem=%u bad=%u qf=%u lid=%u pc=%u sc=%u rc=%u brs=%04X st=%04X",
		            (unsigned) GBAView16(gba->cpu, 0x0202197Cu),
		            (unsigned) GBAView8(gba->cpu, 0x03002AC1u),
		            (unsigned) GBAView8(gba->cpu, 0x03002B05u),
		            (unsigned) GBAView8(gba->cpu, 0x03002B06u),
		            (unsigned) GBAView8(gba->cpu, 0x03002AF6u),
		            (unsigned) GBAView8(gba->cpu, 0x03002AF7u),
		            (unsigned) GBAView8(gba->cpu, 0x03002B0Au),
		            (unsigned) GBAView8(gba->cpu, 0x03002B0Bu),
		            (unsigned) GBAView16(gba->cpu, 0x03002A40u),
		            (unsigned) GBAView16(gba->cpu, 0x03002A9Cu));
		maybeUnstickStandby(emu, gba);
		maybeRearmHandshake(emu, gba);
	}
	/* 玩家格坐标（gSaveBlock1Ptr→SaveBlock1.pos）：走位闭环导航的输入，走位
	 * 阶段每 16 轮打一次就够了（9 轮/帧），不打会让按键步数与实际位移脱钩。 */
	if ((emu->sioOk & 0x0F) == 0) {
		uint32_t sb1 = GBAView32(gba->cpu, 0x03004964u);
		if (sb1 >= 0x02000000u && sb1 < 0x03000000u) {
			MOBILE_LOGI("POS x=%d y=%d",
			            (int) (int16_t) GBAView16(gba->cpu, sb1 + 0u),
			            (int) (int16_t) GBAView16(gba->cpu, sb1 + 2u));
		}
	}
	GBASIOMultiplayerFinishTransfer(&gba->sio, data, cyclesLate);
}

/* 两人直连：本机一槽 + 对端一槽，其余保持 0xFFFF（空槽）。 */
static void completeMultiTransfer(struct MgbaMobile* emu, uint32_t remote, bool haveRemote, uint32_t cyclesLate) {
	if (!emu->core || emu->core->platform(emu->core) != mPLATFORM_GBA) {
		return;
	}
	struct GBA* gba = (struct GBA*) emu->core->board;
	int me = netLinkPlayer(emu->link);
	uint16_t data[4] = { 0xFFFF, 0xFFFF, 0xFFFF, 0xFFFF };
	if (me >= 0 && me < 4) {
		data[me] = gba->memory.io[GBA_REG(SIOMLT_SEND)];
	}
	if (haveRemote) {
		data[me == 0 ? 1 : 0] = (uint16_t) remote;
	}
	finishMultiTransfer(emu, data, cyclesLate);
}

/* 3/4 人总线：四个槽位来自主机的汇聚广播，没连上的槽位是 0xFFFF。 */
static void completeMultiTransferBus(struct MgbaMobile* emu, const uint32_t vals[4], int players, uint32_t cyclesLate) {
	if (!emu->core || emu->core->platform(emu->core) != mPLATFORM_GBA) {
		return;
	}
	uint16_t data[4];
	/* 3/4 人总线：四槽来自主机唯一一次聚合广播（vals[4]），所有核（含主机）
	 * 都写入同一份快照，不再用本核当前 SIOMLT_SEND 覆盖自身槽位——那样会让
	 * 三核的 SIOMULTI 互不相同，握手永远对不齐（busgame 实测 f=1191 起分叉）。
	 * vals 里未连上的槽位已是 0xFFFF（主机缺席槽 + 掉线从机）。 */
	for (int i = 0; i < 4; ++i) {
		data[i] = (i < players && vals) ? (uint16_t) vals[i] : 0xFFFF;
	}
	finishMultiTransfer(emu, data, cyclesLate);
}

/**
 * 传输应到期的时刻：对端应答已经在手上就地完成，否则隔一小段模拟时间再看，
 * 绝不把模拟线程挂在这里等网络。对端掉线时按超时收尾，游戏自己会报通信错误
 * 而不是永久卡在 Busy。
 */
/* 从机侧「一轮完成」事件。
 *
 * 【为什么必须把从机的模拟时钟钉在主机的节拍上】
 * gen8 的游戏每个 VBlank 都会走一遍 LinkMain1：
 *     EnqueueSendCmd(sendCmd);   // 入队一条命令
 *     DequeueRecvCmds(recvCmds); // 出队一条命令
 * 两台模拟器各自跑自己的时钟，只要速率不一致，队列就必然失衡：
 *   - 从机跑太快：recvQueue 被抽干（收到的命令全是 0），战斗拿不到对手输入；
 *   - 从机跑太慢：sendQueue 塞满（QUEUE_CAPACITY=50）→ queueFull → 通信错误。
 * 而从机在等网络的空档里 CPU 是空转的（模拟时钟照跑），一个 6ms 的往返就能
 * 跑掉十万个周期，是主机一轮（18363）的十几倍 —— 不钉住必然失控。
 *
 * 【钉住的办法】
 * 这一轮**正好**在「上一次完成 + K」个模拟周期后完成，K = 主机一轮的周期。
 * 事件触发时如果对端的字还没到，就在这里阻塞等（真实时间）。阻塞期间模拟
 * 时钟是冻结的，所以这一轮的完成时刻恒等于事件被安排的那一刻，从机的时钟
 * 速率就与主机严格一致。
 *
 * K 的取值：主机一轮 = 传输 5755 + Timer3 12608 + 少量处理 ≈ 18363。实测值
 * 用对端推送时带的模拟时钟戳校准（主机每轮开始推送时会带上自己那一刻的
 * mTiming 周期数，相邻两轮的差就是主机一轮的真实周期）。
 *
 * 【轮次号的归属】
 * K 的校准和轮次的匹配必须用同一个轮次号，而轮次号只能由主机决定 —— 两端
 * 各自递增必然发散（从机 206 / 主机 95），严格匹配会把主机的每一条推送都
 * 当成过期丢掉，从机永远收不到。因此从机这一侧：
 *   - 取字用宽松入口（netLinkTakePeerWordAny），不做过期丢弃；
 *   - 直接采用主机给的轮次号当作自己的 sioIndex；
 *   - 回推时也用这个号，主机那边严格匹配就一定对得上。
 */
static int sioWaitMs(struct MgbaMobile* emu);
static int sioPeerWaitMs(struct MgbaMobile* emu);
static int sioPipelineWaitMs(struct MgbaMobile* emu, int want);

static void sioSlaveDoneEvent(struct mTiming* timing, void* user, uint32_t cyclesLate) {
	struct MgbaMobile* emu = (struct MgbaMobile*) user;
	emu->sioSlaveArmed = false;
	if (!emu->link || !emu->linkAttached || !emu->core) {
		return;
	}
	if (emu->core->platform(emu->core) != mPLATFORM_GBA) {
		return;
	}
	struct GBA* gba = (struct GBA*) emu->core->board;
	if (gba->sio.mode != GBA_SIO_MULTI) {
		/* 游戏还没进多人传输（或者已经退出）：不收尾，等下一次轮询再挂。 */
		return;
	}
	/* 【主从角色看游戏，不看链路层的 player 号】
	 *
	 * 原来这里用 netLinkPlayer()==0 判「我是主机，不用管」。可走云端房间时
	 * 两端的链路层都是 TCP 主机（播放器号都停在初值 0），于是**两边都走这个
	 * 分支直接 return**：谁都不执行从机收尾、谁都不回推字。现场证据就是
	 * 两端日志同时报 me=0，主机侧 `done want=1 have=0 retries=27` 永远等不到
	 * 回字，`m1=0000`、`pc=0` 一路到底。
	 *
	 * gen8 自己会选举主从：gLink(+0)=isMaster 为 8 表示主机，(+2)=localId。
	 * 这里只认 gLink.isMaster：不是主机就必须走从机路径。 */
	int me = netLinkPlayer(emu->link);
	int gameMaster = GBAView8(gba->cpu, 0x03002AF4u + 0x00u);
	if (gameMaster == 8) {
		/* 游戏认定自己是主机：轮次由它驱动，这里不管。 */
		return;
	}
	/* 3/4 人总线：从机先把自己的字推给主机（主机要收齐才广播），再等广播。
	 * 两人走下面原来的「取对端字 → 收尾 → 回推」路径。 */
	{
		int busPlayers = netLinkBusPlayers(emu->link);
		if (netLinkBusActive(emu->link) && busPlayers >= 2) {
			uint16_t own = emu->sioRoundWordValid ? emu->sioRoundWord
			                                      : gba->memory.io[GBA_REG(SIOMLT_SEND)];
			emu->sioRoundWordValid = false;
			uint32_t busVals[4];
			uint16_t used = emu->sioIndex;
			int busGot = netLinkBusRound(emu->link, emu->sioIndex, own, busVals, busPlayers,
			                             sioPipelineWaitMs(emu, -1), &used);
			if (busGot < 0) {
				/* 主机还没广播（还在等别的从机）：快速重挂，绝不拿空槽收尾
				 * —— 一次空槽就会让游戏的 DoHandshake 把 playerCount 清 0。 */
				++emu->sioTimeouts;
				if (emu->toDbg < 30) {
					++emu->toDbg;
					MOBILE_LOGI("BUS slave wait-me me=%d last=%u", me, (unsigned) emu->sioIndex);
				}
				if (timing) {
					mTimingSchedule(timing, &emu->sioSlaveDone, 2048);
					emu->sioSlaveArmed = true;
				}
				return;
			}
			/* 轮次节奏跟随主机：与两人路径用 PUSH.cycles 做的事一样。 */
			{
				uint32_t peerCycles = netLinkBusRoundCycles(emu->link);
				if (peerCycles != 0) {
					if (emu->sioPeerCyclesValid) {
						uint32_t delta = peerCycles - emu->sioPeerCycles;
						if (delta > 4000 && delta < 400000) {
							emu->sioSlavePeriod = delta;
						}
					}
					emu->sioPeerCycles = peerCycles;
					emu->sioPeerCyclesValid = true;
				}
			}
			if (used != emu->sioIndex) {
				++emu->sioMisorder;
				if (emu->sioMisorder < 8) {
					MOBILE_LOGI("BUS slave 跟随主机轮次 me=%d was=%u now=%u n=%u",
					            me, (unsigned) emu->sioIndex, (unsigned) used, emu->sioMisorder);
				}
			}
			emu->sioIndex = used;
			emu->sioHasRemote = true;
			emu->sioRemote = busVals[0];
			completeMultiTransferBus(emu, busVals, busPlayers, cyclesLate);
			emu->sioPushValue = own;
			emu->sioPushIndex = emu->sioIndex;
			emu->sioPushed = true;
			if (timing) {
				mTimingSchedule(timing, &emu->sioSlaveDone, emu->sioSlavePeriod);
				emu->sioSlaveArmed = true;
			}
			return;
		}
	}

	uint16_t got = 0;
	uint32_t remote = 0;
	uint32_t peerCycles = 0;
	/* 【轮次号必须由主机单方面决定 —— 从机只跟随】
	 *
	 * 两端的计数器如果各自独立递增，必然发散：从机每轮超时也会推进自己的
	 * 计数器，于是从机的轮次跑到 206 时主机才 95。netLinkTakePeerWord 的
	 * 「(int16_t)(w.index - want) < 0 → 过期丢弃」会把主机的每一条推送都
	 * 判成过期 → 从机永远收不到 → 每轮空等 2500ms → 模拟帧率掉到
	 * 0.03fps → 游戏的 Task_TriggerHandshake 跑不到第 5 个 tick → 链路
	 * 状态卡在 START1 → 双方永远进不了 HANDSHAKE，握手永远完不成。
	 *
	 * 这里放宽成「取队列里最早的一条未消费过的」，并**直接采用主机给的
	 * 轮次号**：主机是链路的时钟源，它的 index 就是全局轮次号。从机回推时
	 * 也用这个号，于是主机那边严格匹配（want == 实收）一次都不会错位。
	 *
	 * 等待窗口分两种：
	 *   - 还没跟主机同步上（一个主机字都没收到过）：窗口短（20ms）。这时
	 *     主机多半还没进俱乐部，主机字会随时到，短窗口保证从机不会被
	 *     一次 2.5 秒的空等冻住（那会把模拟帧率压到 0.03fps，游戏连
	 *     「请稍候」画面都走不到）。
	 *   - 已经同步上了：窗口放宽到 300ms，吸收对端的偶发卡顿。
	 */
	/* 【绝不在这里长时间阻塞模拟线程】
	 *
	 * 原来这里是「阻塞 20ms（还没跟主机同步）/ 300ms（已同步）等主机的字」。
	 * 这一等就把模拟线程冻住了：每 18363 个模拟周期阻塞一次，模拟时间只
	 * 推进 1.1ms 而墙钟走了 20ms，帧率从 60fps 掉到 1.4fps。主机还没进俱乐
	 * 部时从机的游戏干脆冻在标题画面；联机中掉帧则直接打破 gen8「每帧至少
	 * 9 次串行中断」的要求，游戏报「通信错误」。
	 *
	 * 现在改成**非阻塞取字 + 短周期重试**：取不到就 2048 个模拟周期后再试，
	 * 一次也不阻塞。主机每轮推一个字、从机照单全收（队列是 FIFO，轮次天然
	 * 一一对应），从机的时钟不再被墙钟拖住。
	 *
	 * 【跨网例外：从机的游戏有传输在飞时必须阻塞等】
	 * 走服务器隧道时主控每轮要等一个网络往返（实测 142ms 均值、250ms 尖峰），
	 * 主控的模拟时钟在等待里冻结，它的游戏一帧要走 9×160ms 真实时间；而从机
	 * 的游戏照常 60fps 跑——从机一帧只摊到 ~0.1 次 SIO 中断，gen8 的
	 * LinkVSync 数出「每帧不足 9 次」就置 gLink.lag = LAG_MASTER，游戏当场报
	 * 「连接发生了错误」。真机语义是：从机的传输挂着，线路就一直等主机的时
	 * 钟沿。所以这里在**主控的轮次还在密集到达（交换正在进行）**时改为阻塞
	 * 等（窗口自适应 RTT）：从机的一帧因此包含主控一帧的全部轮次，LAG 消
	 * 除，两边的游戏速率重新锁死。交换停了（对端 500ms 没推字）就回到自旋，
	 * 模拟帧率不受影响。 */
	/* 【跨网时从机必须阻塞等；判据不能是本机推字时间】
	 *
	 * 这里原来用「本机 500ms 内推过字」当作「交换正在进行」的判据。可这个
	 * 判据在**第一轮**必然为假：从机还没完成过任何一轮，自然没推过字 →
	 * 走下面的自旋分支 → 每次自旋把模拟时钟推进 2048 cycles（≈0.12ms），
	 * 而墙钟只过去几微秒，等于模拟时间以约 300 倍真实速度狂奔。主机那一个
	 * 字还在路上（一个 RTT），从机这边已经空转出几百上千个游戏帧，gen8 的
	 * LinkVSync 数出「这些帧一次 SIO 中断都没有」→ gLink.lag = LAG_MASTER
	 * → 当场「通信错误……请检查所有的连接」，link 任务直接停掉，之后从机
	 * 再也不写 SIOMLT_SEND，主机收到的全是 0x0000（RECEIVED_NOTHING）。
	 * 实测从机自旋计数 to=1721192，与这个推断完全吻合。
	 *
	 * 而这个事件只有在 netLinkPeerPending() > 0（主机确实推过字）时才会被
	 * 挂上，也就是说「进到这里」本身就证明交换正在进行。所以只要链路还连
	 * 着，就按 RTT 自适应窗口阻塞等——模拟时钟冻结，游戏看不见这段墙钟
	 * 时间，从机的每帧轮次数与主机严格一致，LAG 不会触发。
	 * 真正没联机时事件根本不会被挂上，帧率不受影响。 */
	int slaveWaitMs = sioPipelineWaitMs(emu, -1);
	bool have = netLinkTakePeerWordAny(emu->link, emu->sioIndex, slaveWaitMs, &remote, &got, &peerCycles);
	if (!have) {
		/* 【从机没有对端数据时绝不收尾】
		 *
		 * 真机上 MULTI 的时钟由主机产生：从机在主机没有用时钟扫过它之前，
		 * 这一次传输根本不会结束（Busy 位一直挂着），游戏就那么等着。
		 * 我们这里如果「超时也收尾」，等于凭空多完成了一轮：
		 *   - 给游戏喂了一个空槽（对端 = 0），DoHandshake 看到 slot0 不是
		 *     握手值就把 playerCount 清成 0，握手状态被搅乱；
		 *   - 而且两端的传输次数不再一一对应，主机的轮次号和从机的对不上，
		 *     后面每一轮都错一格。
		 * 所以这里只做一件事：把事件快速重挂一次，等主机的下一个字。 */
		++emu->sioTimeouts;
		if (emu->toDbg < 30) {
			++emu->toDbg;
			MOBILE_LOGI("SIO slave wait-me me=%d last=%u synced=%d",
			            me, (unsigned) emu->sioIndex, emu->sioPeerCyclesValid ? 1 : 0);
		}
		if (timing) {
			/* 重试周期取 2048（≈0.12ms 模拟时间）：主机推字之后从机几乎
			 * 立刻就能取到，回推的延迟远小于一轮（18363 cycles）。 */
			mTimingSchedule(timing, &emu->sioSlaveDone, 2048);
			emu->sioSlaveArmed = true;
		}
		return;
	}
	if (peerCycles != 0) {
		/* 【从机的轮次节奏必须跟着主机走】
		 *
		 * gen8 link.c 的 LinkVSync 要求主机每帧至少 9 次 SIO 中断（不足就
		 * gLink.lag = LAG_MASTER），一帧 = 280896 cycles。主机一轮的真实
		 * 周期可以从它推送时带的模拟时钟戳算出来（相邻两轮的差）：战斗阶段
		 * 是 Timer3(197*64=12608) + 传输(5755) = 18363，握手阶段主机每帧
		 * 只有 1 轮，差就是 280896。
		 *
		 * 从机按同样的周期排自己的轮次事件，两边每帧的轮次数才会一致：
		 * 从机多一轮就把 recvQueue 塞爆（queueFull → 通信错误），少一轮
		 * 就把 recvQueue 抽干（receivedNothing → 游戏直接断开）。
		 * 这里直接跟随（不做平滑）：主机的节奏本身就是规律的，平滑反而会
		 * 把「一帧 8 轮紧跟 + 1 轮空档」这种突发节奏抹成平均值，从机的帧
		 * 里轮次数就会忽多忽少。 */
		if (emu->sioPeerCyclesValid) {
			uint32_t delta = peerCycles - emu->sioPeerCycles;
			if (delta > 4000 && delta < 400000) {
				emu->sioSlavePeriod = delta;
			}
		}
		emu->sioPeerCycles = peerCycles;
		emu->sioPeerCyclesValid = true;
	}
	uint16_t own = emu->sioRoundWordValid ? emu->sioRoundWord
	                                      : gba->memory.io[GBA_REG(SIOMLT_SEND)];
	emu->sioRoundWordValid = false;
	if (got != emu->sioIndex) {
		/* 轮次跳跃：主机那边跳过了几轮（或者从机刚接上）。不影响正确性
		 * —— 从机跟随主机的号，双方仍然一一对应。 */
		++emu->sioMisorder;
		if (emu->sioMisorder < 8) {
			MOBILE_LOGI("SIO slave 跟随主机轮次 me=%d was=%u now=%u n=%u",
			            me, (unsigned) emu->sioIndex, (unsigned) got, emu->sioMisorder);
		}
	}
	emu->sioIndex = got;
	emu->sioHasRemote = true;
	emu->sioRemote = remote;
	completeMultiTransfer(emu, remote, true, cyclesLate);
	/* 把本轮的字回推给主机：就是本轮收尾时游戏自己用的那一个
	 * （SIOMLT_SEND），收发天然一致。轮次号沿用主机的，主机那边严格
	 * 匹配就一定对得上。 */
	struct mTiming* timing2 = coreTiming(emu);
	uint32_t stamp = timing2 ? mTimingCurrentTime(timing2) : 0;
	netLinkPush(emu->link, GBA_SIO_MULTI, own, emu->sioIndex, stamp);
	emu->sioPushValue = own;
	emu->sioPushIndex = emu->sioIndex;
	emu->sioPushed = true;
	if (own != 0xB9A0 && emu->hsPushDbg < 70) {
		++emu->hsPushDbg;
		MOBILE_LOGI("HSP #%u me=%d idx=%u val=%04X reply=1",
		            emu->hsPushDbg, me, (unsigned) emu->sioIndex, own);
	}
	/* 挂上下一轮：正好在 K 个模拟周期之后。 */
	if (timing) {
		mTimingSchedule(timing, &emu->sioSlaveDone, emu->sioSlavePeriod);
		emu->sioSlaveArmed = true;
	}
}


/* 跨网等待窗：局域网 RTT 1-3ms，800ms 绰绰有余；走服务器隧道 RTT 上百毫秒
 * 还会抖（手机网络尖峰能到秒级），固定 800ms 必然误超时——超时一次就用空槽
 * 收尾，游戏立刻报「连接发生了错误」。等待窗跟随实测 RTT（20 倍余量），
 * 下限仍是局域网的 800ms，上限 20s 防死等。等待期间模拟时钟冻结，游戏自己
 * 不会超时，只是这一轮变慢。 */
static int sioWaitMs(struct MgbaMobile* emu);

/* 本轮到底允不允许阻塞模拟线程。
 *
 * 隧道连着（state==2）不等于对端在跑联机：当对端还停在开机/标题画面时它
 * 一个字都不推，这边若照旧按 sioWaitMs 死等，模拟线程就被按在超时窗里，
 * 整帧不动——实测整屏 4 秒逐字节一致、按键完全不响应，驱动层只能看着它
 * 「假死」。所以只有「对端确实在这条链路上交换字」时才阻塞：
 *   1) 队列里已有对端字 → 阻塞（实际只是取队列，几乎不耗时）；
 *   2) 对端 800ms 内推过字 → 阻塞，但只给半个秒窗（这一轮只是晚到）；
 *   3) 对端完全没动静 → 立刻用空槽收尾，模拟线程照常跑。
 * 第 3 条是这次假死的解药；它不会污染握手以外的轮次，因为握手期对端一定
 * 在推字，条件 1/2 必然命中。 */
static int sioPeerWaitMs(struct MgbaMobile* emu) {
	if (!emu->link || netLinkState(emu->link) != 2) {
		return 0;
	}
	if (netLinkBusActive(emu->link)) {
		/* 星型总线只跑局域网/本机环回。两人跨公网隧道的 300~1200ms 下限会
		 * 把每轮锁步钉在半秒以上：轮次一旦错配，主机等从机字、从机等广播，
		 * 两边都等满窗。给 3 倍实测 RTT，下限 2ms（本机环回 RTT≈0.1ms，
		 * 原 12ms 下限让每个落后轮次都付满 12ms，9 轮/帧把帧率压到约 5fps）；
		 * 字到达时 cond_broadcast 仍会立刻唤醒，LAN（RTT≥3ms×3≈9~12ms）
		 * 行为不变。 */
		uint32_t ms = (netLinkRttUs(emu->link) / 1000u) * 3u;
		if (ms < 2u) {
			ms = 2u;
		}
		if (ms > 120u) {
			ms = 120u;
		}
		return (int) ms;
	}
	if (netLinkPeerPending(emu->link) > 0) {
		/* 队列里有字：阻塞是安全的，但窗口没必要开到 RTT×20（实测会到 3s，
		 * 一轮 3s × 9 轮/帧 = 27s 一帧，画面看起来就是彻底冻结）。1200ms 已经
		 * 覆盖实测 150ms 均值 / 441ms 尖峰的隧道 RTT。 */
		return 1200;
	}
	if (netLinkPushAgeMs(emu->link) < 800) {
		return 900;                 /* 对端仍在活跃交换，这一轮只是晚到 */
	}
	/* 与 Qt 侧同一条修正：链路刚建立时两端都还没推过字，pushSeenAt=0
	 * 会让上面两条全部落空，于是最需要等一个公网 RTT 的第一轮反而零等待，
	 * 主机按空槽收尾 → 从机回字迟到后无人认领 → 握手停在 START0/START1。
	 * 前 8 轮、头 3 次重试给 900ms 预算；之后恢复 0，避免对端根本没进
	 * 联机时把模拟线程按死（11-08 的假死）。 */
	if (emu->sioWaiting && emu->sioIndex <= 8 && emu->sioRetries < 3) {
		return 900;
	}
	/* 与 Qt 侧同一条修正：隧道抖动会让「对端 800ms 内推过字」间歇失效，
	 * 零等待 + 100 cycles 重试间隔会在极短时间内耗尽 40 次重试并按空槽
	 * 收尾，破坏玩家数据块校验（隧道轮 brs 全 0 / cnt 恒 0）。游戏确实
	 * 发起了本轮 MULTI 且链路还连着时，给一个跟随实测 RTT 的最小预算。 */
	if (emu->sioWaiting) {
		uint32_t ms = (netLinkRttUs(emu->link) / 1000u) * 3u;
		if (ms < 300u) {
			ms = 300u;
		}
		if (ms > 1200u) {
			ms = 1200u;
		}
		return (int) ms;
	}
	return 0;                       /* 对端没在交换：立刻收尾，别冻住模拟线程 */
}

static int sioWaitMs(struct MgbaMobile* emu) {
	uint32_t rttUs = emu->link ? netLinkRttUs(emu->link) : 0;
	uint32_t ms = (rttUs / 1000u) * 20u;
	if (ms < 800) {
		ms = 800;
	}
	if (ms > 20000) {
		ms = 20000;
	}
	return (int) ms;
}

/* 与 Qt 侧同一条按帧流水线：系统属性 mgbax.sio.pipeline=1 开启。
 * 队列里有对端字就零等待消费，队列空才给一次整批预算；字严格按轮次配对。 */
static bool sioPipelineMode(struct MgbaMobile* emu) {
	if (emu->sioPipelineEnabled < 0) {
#ifdef __ANDROID__
		char v[PROP_VALUE_MAX] = {0};
		__system_property_get("mgbax.sio.pipeline", v);
		emu->sioPipelineEnabled = (v[0] == '1') ? 1 : 0;
#else
		/* Desktop and the local test build share the Qt-side switch name. */
		const char* v = getenv("MGBAX_SIO_PIPELINE");
		emu->sioPipelineEnabled = (v && v[0] == '1') ? 1 : 0;
#endif
	}
	return emu->sioPipelineEnabled != 0;
}

static int sioPipelineWaitMs(struct MgbaMobile* emu, int want) {
	/* 总线不受两人按帧流水线开关影响，始终用局域网短窗。 */
	if (emu->link && netLinkBusActive(emu->link)) {
		return sioPeerWaitMs(emu);
	}
	if (!sioPipelineMode(emu)) {
		return sioPeerWaitMs(emu);
	}
	if (!emu->link || netLinkState(emu->link) != 2) {
		return 0;
	}
	if (netLinkPeerPending(emu->link) > 0) {
		/* 队列非空不等于**本轮**的字已经到：队首常常是后续轮次。只有队首
		 * 正是本轮才零等待，否则照样按 RTT 给等待窗（取字函数自己按轮次
		 * 严格匹配，不再把后续轮次的字喂给这一轮）。 */
		if (want < 0) {
			return 0;
		}
		int qCount = 0;
		unsigned qHead = 0;
		netLinkPeerHeadInfo(emu->link, &qCount, &qHead);
		if (qCount > 0 && (int) qHead == want) {
			return 0;
		}
	}
	uint32_t ms = (netLinkRttUs(emu->link) / 1000u) * 3u;
	if (ms < 500u) {
		ms = 500u;
	}
	if (ms > 4000u) {
		ms = 4000u;
	}
	return (int) ms;
}

static void sioDoneEvent(struct mTiming* timing, void* user, uint32_t cyclesLate) {
	struct MgbaMobile* emu = (struct MgbaMobile*) user;
	if (!emu->sioWaiting) {
		return;
	}
	uint32_t remote = 0;
	uint16_t got = 0;
	/* 3/4 人总线：主机在这一刻收齐所有从机本轮的字，再一次性广播给它们。
	 *
	 * 判据必须是「链路处于总线模式」，不能只看人数：总线里只有一个从机
	 * 连上来时 netLinkBusPlayers() 正好是 2，按人数判会掉进下面的两人直连
	 * 分支，而总线的字根本不进 peerQ，结果永远是「对端没回字」。 */
	{
		int busPlayers = netLinkBusPlayers(emu->link);
		if (netLinkBusActive(emu->link) && busPlayers >= 1
		    && emu->core && emu->core->platform(emu->core) == mPLATFORM_GBA) {
			if (busPlayers < 2) {
				busPlayers = 2;   /* 还没从机连上：按「只有自己」收尾 */
			}
			struct GBA* gbaBus = (struct GBA*) emu->core->board;
			uint32_t busVals[4];
			uint16_t used = emu->sioIndex;
			uint32_t own = gbaBus->memory.io[GBA_REG(SIOMLT_SEND)];
			int busGot = netLinkBusRound(emu->link, emu->sioIndex, own, busVals, busPlayers,
			                             sioPipelineWaitMs(emu, (int) emu->sioIndex), &used);
			if (busGot <= 0 && emu->sioRetries < 3 && netLinkState(emu->link) == 2) {
				/* 有从机连着却一个都没收到：它们是慢了一拍，不是没有。
				 * 重试几次再按空槽收尾，否则一次迟到就会把这一轮的握手数据
				 * 变成 0xFFFF，游戏当场报 checksum 错。 */
				++emu->sioRetries;
				struct mTiming* t2 = coreTiming(emu);
				if (t2) {
					mTimingSchedule(t2, &emu->sioDone, 100);
					return;   /* sioWaiting 保持 true */
				}
			}
			emu->sioRetries = 0;
			emu->sioWaiting = false;
			emu->sioHasRemote = busGot > 0;
			emu->sioRemote = busVals[0];
			if (busGot <= 0 && emu->toDbg < 40) {
				++emu->toDbg;
				MOBILE_LOGI("BUS host round me=%d idx=%u got=%d n=%d",
				            netLinkPlayer(emu->link), (unsigned) emu->sioIndex, busGot, busPlayers);
			}
			completeMultiTransferBus(emu, busVals, busPlayers, cyclesLate);
			return;
		}
	}
	/* 真的阻塞等待：睡的是真实时间，模拟时钟冻在这里，所以一帧内的传输次数
	 * 还是真机的量级。游戏的 LAG 判定就是数“每帧有几个 SIO 中断”（1P 那边
	 * 少于 9 个就报 LAG_MASTER），一用模拟时间空转去等一个 16ms 的往返，
	 * 一帧就只剩下一次传输，必然被判掉线。 */
	double t0 = (double) wallNowMs();
	bool haveRemote = emu->link && netLinkTakePeerWord(emu->link, emu->sioIndex, sioPipelineWaitMs(emu, (int) emu->sioIndex), &remote, &got, NULL);
	double waited = (double) wallNowMs() - t0;
	if (waited > 3.0) {
		/* 超过 3ms 就说明这一轮不是「网络瞬时往返」，而是对端真的慢了。
		 * 这个数直接决定模拟时钟被冻住多久（也就决定模拟帧率掉多少）。 */
		emu->sioWaitMax = waited > emu->sioWaitMax ? waited : emu->sioWaitMax;
		emu->sioWaitTotal += waited;
		++emu->sioWaitN;
		if (emu->sioWaitN % 64 == 0) {
			MOBILE_LOGI("WAIT me=%d n=%u avg=%.1fms max=%.1fms",
			            netLinkPlayer(emu->link), emu->sioWaitN,
			            emu->sioWaitTotal / (double) emu->sioWaitN, emu->sioWaitMax);
		}
	}
	if (!haveRemote && emu->link && netLinkState(emu->link) == 2) {
		/* 真的等到超时才记一次：这是「客机没回字」的唯一现场证据。 */
		MOBILE_LOGI("SIO peer-timeout idx=%u me=%d to=%u",
		            (unsigned) emu->sioIndex, netLinkPlayer(emu->link), emu->sioTimeouts + 1);
	}
	if (haveRemote) {
		if (got != emu->sioIndex) {
			++emu->sioMisorder;
			if (emu->sioMisorder < 8) {
				MOBILE_LOGI("SIO 轮次错位 me=%d want=%u got=%u n=%u",
				            0, (unsigned) emu->sioIndex, (unsigned) got, emu->sioMisorder);
			}
		}
		emu->sioWaiting = false;
		emu->sioHasRemote = true;
		emu->sioRemote = remote;
		completeMultiTransfer(emu, remote, true, cyclesLate);
		return;
	}
	LINK_VERBOSE("SIO multi timeout seq=%u", emu->sioSeq);
	emu->sioTimeouts++;
	/* 对端还在线就继续等，别急着用空槽收尾：跨网时对端的字只是迟到（RTT
	 * 尖峰、手机切基站），不是没有。等待继续冻结模拟时钟，游戏看不见这段
	 * 时间；真机语义也一样——从机不回字，线路就不动。真正断线（state≠2）
	 * 或重试次数耗尽才按「这一轮没有对端数据」收尾。 */
	/* 墙钟上限看的是**这一轮**累计等了多久：等待窗现在能到 4s，光靠 40 次
	 * 重试计数会变成 160s 的死等，一个僵死的对端就能把整帧按住不放。 */
	if (emu->sioRetries == 0) {
		emu->sioRetryWall = wallNowMs();
	}
	if (emu->link && netLinkState(emu->link) == 2 && emu->sioRetries < 40 &&
	    (uint32_t) (wallNowMs() - emu->sioRetryWall) < 20000u) {
		++emu->sioRetries;
		struct mTiming* t2 = coreTiming(emu);
		if (t2) {
			mTimingSchedule(t2, &emu->sioDone, 100);
			return;
		}
	}
	if (emu->toDbg < 40) {
		++emu->toDbg;
		MOBILE_LOGI("TO #%u seq=%u me=%d stashed=%d",
		            emu->toDbg, emu->sioSeq, netLinkPlayer(emu->link), emu->sioHasRemote ? 1 : 0);
	}
	emu->sioWaiting = false;
	/* 超时绝不能用上一轮的旧值收尾 —— 那正是「握手能过、checksum 必挂」的来源：
	 * 游戏会把上一轮的数据当成这一轮，双方向量从此错位，而且错得很隐蔽。
	 * 按「这一轮没有对端数据」收尾（对端槽位是 0xFFFF），游戏自己会把它当成
	 * 空槽/通信错误处理，要么重试要么干净地断开。 */
	completeMultiTransfer(emu, 0, false, cyclesLate);
}

static bool gbaLinkInit(struct GBASIODriver* driver) {
	struct MgbaMobile* emu = ((struct GbaLinkDriver*) driver)->emu;
	emu->linkEvent.context = emu;
	emu->linkEvent.callback = linkPollEvent;
	emu->linkEvent.name = "Mobile Link";
	emu->linkEvent.priority = 0x70;
	emu->sioDone.context = emu;
	emu->sioDone.callback = sioDoneEvent;
	emu->sioDone.name = "Mobile SIO Done";
	emu->sioDone.priority = 0x7F;
	emu->sioSlaveDone.context = emu;
	emu->sioSlaveDone.callback = sioSlaveDoneEvent;
	emu->sioSlaveDone.name = "Mobile SIO Slave Done";
	emu->sioSlaveDone.priority = 0x7E;
	emu->sioSlavePeriod = 18363;
	emu->sioSlaveArmed = false;
	emu->sioPeerCyclesValid = false;
	armLinkEvent(emu);
	return true;
}

static void gbaLinkDeinit(struct GBASIODriver* driver) {
	struct MgbaMobile* emu = ((struct GbaLinkDriver*) driver)->emu;
	struct mTiming* timing = coreTiming(emu);
	emu->sioWaiting = false;
	emu->sioSlaveArmed = false;
	emu->sioPeerCyclesValid = false;
	if (timing) {
		mTimingDeschedule(timing, &emu->linkEvent);
		mTimingDeschedule(timing, &emu->sioDone);
		mTimingDeschedule(timing, &emu->sioSlaveDone);
	}
}

static void gbaLinkReset(struct GBASIODriver* driver) {
	struct MgbaMobile* emu = ((struct GbaLinkDriver*) driver)->emu;
	emu->sioWaiting = false;
	/* 复位后游戏会重新做一次主从判定，所以「只有自己」的呈现窗口要重新打开。 */
	emu->sioInitSeen = false;
	armLinkEvent(emu);
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
	struct MgbaMobile* emu = ((struct GbaLinkDriver*) driver)->emu;
	if (emu && emu->sioDbg < 60) {
		++emu->sioDbg;
		MOBILE_LOGI("SIO mode -> %d", (int) mode);
	}
	LINK_VERBOSE("SIO mode -> %d", (int) mode);
}

static bool gbaLinkHandles(struct GBASIODriver* driver, enum GBASIOMode mode) {
	UNUSED(driver);
	return mode == GBA_SIO_MULTI || mode == GBA_SIO_NORMAL_8 || mode == GBA_SIO_NORMAL_32;
}

static int gbaLinkDevices(struct GBASIODriver* driver) {
	struct MgbaMobile* emu = ((struct GbaLinkDriver*) driver)->emu;
	/* 与 gbp.c 的语义一致：连着的“对端”数量（不含自己）。两边 2 人联机
	 * 时这里是 1，内核才会用 2P 的传输周期；填 2 会按 3P 算，每次传输
	 * 比真机慢 50%，游戏的超时窗口就对不上了。
	 *
	 * 3/4 人总线按实际人数上报（players-1），内核才会用 3P/4P 的周期 ——
	 * 一直返回 1 会让每一轮都比真机短，游戏数出的每帧轮次数对不上。 */
	if (emu && netLinkBusActive(emu->link)) {
		int players = netLinkBusPlayers(emu->link);
		if (players > 2) {
			return players - 1;
		}
	}
	return 1;
}

static int gbaLinkDeviceId(struct GBASIODriver* driver) {
	return netLinkPlayer(((struct GbaLinkDriver*) driver)->emu->link);
}

static bool beginMultiTransfer(struct MgbaMobile* emu, struct GBASIODriver* driver, const char* who) {
	if (!emu->link || !emu->linkAttached || !emu->core || !driver->p || driver->p->mode != GBA_SIO_MULTI) {
		return false;
	}
	if (emu->core->platform(emu->core) != mPLATFORM_GBA) {
		return false;
	}
	struct GBA* gba = (struct GBA*) emu->core->board;
	uint16_t local = gba->memory.io[GBA_REG(SIOMLT_SEND)];
	++emu->sioIndex;
	emu->sioWaiting = true;
	emu->sioRetries = 0;
	struct mTiming* timing = coreTiming(emu);
	if (!timing) {
		return false;
	}
	emu->sioStartCycle = mTimingCurrentTime(timing);
	/* 1P 是产生时钟的一方，它在写 SIOCNT 起传输这一刻，本轮要发的字早就由游戏
	 * 写进 SIOMLT_SEND 了（gen8 的 DoSend 在中断处理里写、StartTransfer 之后
	 * 才写 SIOCNT），所以这里推出去的就是本轮的真值 —— 而且只推这一次。
	 * 一轮推两次（例如再让轮询去补推一个 SIOIndex+1）就会把「下一轮的槽位」提前
	 * 填上这一轮的旧值，对端按轮次取的时候正好错位一格。 */
	if (!emu->sioPushed || emu->sioPushIndex != emu->sioIndex) {
		netLinkPush(emu->link, GBA_SIO_MULTI, local, emu->sioIndex, emu->sioStartCycle);
		emu->sioPushValue = local;
		emu->sioPushIndex = emu->sioIndex;
		emu->sioPushed = true;
	}
	mTimingDeschedule(timing, &emu->sioDone);
	/* 传输周期必须按真机的 115200 算（5755 cycles），不能沿用内核把波特率
	 * 位清零之后的旧值 —— 那是 63427 cycles，会让主机每帧只有 3.7 轮，
	 * 达不到 gen8 link.c 要求的 9 轮/帧，直接被判 LAG_MASTER。 */
	uint16_t siocnt = (uint16_t) ((driver->p->siocnt & ~0x0003u) | 0x0003u);
	mTimingSchedule(timing, &emu->sioDone, GBASIOTransferCycles(GBA_SIO_MULTI, siocnt, gbaLinkDevices(driver)));
	if (emu->sioKick < 200) {
		++emu->sioKick;
		MOBILE_LOGI("SIO begin (%s) idx=%u local=%04X", who, emu->sioIndex, local);
	}
	return true;
}

static uint16_t gbaLinkWriteCnt(struct GBASIODriver* driver, uint16_t value) {
	struct MgbaMobile* emu = ((struct GbaLinkDriver*) driver)->emu;
	if (emu->sioDbg < 60) {
		++emu->sioDbg;
		MOBILE_LOGI("SIO CNT <- %04X (mode %d, id %d)", value,
		            driver->p ? (int) driver->p->mode : -1,
		            netLinkPlayer(emu->link));
	}
	if (driver->p && driver->p->mode == GBA_SIO_MULTI) {
		/* 内核只在 1P（id==0）写 start 位时调 _startTransfer，2P..4P 那一路
		 * 在 sio.c 里是 TODO。真实硬件里从机不产生时钟，它的数据是在主机
		 * 的时钟里被同时采样的，所以从机只需要：Busy 立起来之后等主机的
		 * 那一次传输请求，请求一到就连同对端数据一起收尾。这里记下 Busy
		 * 起始时刻，供看门狗兜底（主机迟迟不发请求时至少别把游戏挂死）。 */
		/*
		 * 内核只把 SIOCNT 里 bit7（Busy）的上升沿当成“开始传输”。可 Pokemon
		 * 系的联机代码发起一次多机传输时写的是 0x600F：IRQ 位（bit14）置起、
		 * baud=3，Busy 留给硬件去置。这种写法在内核那一支根本不会调
		 * _startTransfer，Busy 也就永远不落，游戏只能一路空转到通信超时。
		 * 这里把 bit14 的上升沿与 bit7 的上升沿都当成一次传输请求。
		 */
		bool wasBusy = (driver->p->siocnt & 0x0080) != 0;
		bool nowBusy = (value & 0x0080) != 0;
		bool irq = (value & 0x4000) != 0;
		/* 内核只把 busy(bit7) 的上升沿当成“开始传输”。可 Pokemon 系联机代码
		 * 发起一次 MULTI 传输时写的是 0x600F：IRQ(bit14) 置起、Busy 不置，内核
		 * 那一支（1P 才走、2P 是 TODO）根本不会起传输，Busy 也永远不落，游戏
		 * 只能一路空转到通信超时。这里把“busy 上升沿”和“IRQ 置位且当前没有挂起
		 * 的传输”都当成一次发起请求。关键点：0x600F 每次都这么写，bit14 在第一次
		 * 之后再没有上升沿，所以必须靠“IRQ 置位 + !sioWaiting”来持续触发，否则
		 * 除第一次外所有传输都起不来。!sioWaiting 守卫保证同一次传输不会被发起两次。 */
		bool wantStart = nowBusy || (irq && !emu->sioWaiting);
		if (emu->sioDbg < 400) {
			++emu->sioDbg;
			MOBILE_LOGI("SIO CNT mode=MULTI val=%04X busy=%d irq=%d attached=%d waiting=%d",
			            value, nowBusy, irq, emu->linkAttached, emu->sioWaiting);
		}
		if (wantStart) {
			struct mTiming* timing = coreTiming(emu);
			if (timing) {
				emu->sioBusyCycle = mTimingCurrentTime(timing);
			}
			if (emu->sioKick < 400) {
				++emu->sioKick;
				MOBILE_LOGI("SIO kick busy=%d irq=%d attached=%d waiting=%d id=%d",
				            nowBusy, irq, emu->linkAttached, emu->sioWaiting,
				            netLinkPlayer(emu->link));
			}
			if (!emu->sioWaiting && netLinkPlayer(emu->link) == 0) {
				/* 只有 1P 真的发起传输；从机的传输由 1P 的那一次驱动，
				 * 见 serviceLink。 */
				beginMultiTransfer(emu, driver, nowBusy ? "busy" : "irq");
			}
			else if (!emu->sioWaiting && netLinkPlayer(emu->link) != 0 &&
			         emu->core && emu->core->platform(emu->core) == mPLATFORM_GBA) {
				struct GBA* g = (struct GBA*) emu->core->board;
				emu->sioRoundWord = g->memory.io[GBA_REG(SIOMLT_SEND)];
				emu->sioRoundWordValid = true;
			}
		}
		uint16_t out = GBASIOMultiplayerFillReady(GBASIOMultiplayerClearError(value));
		/* 【波特率修复 —— 直接决定能不能连上】
		 *
		 * 内核 GBASIOWriteSIOCNT 的 MULTI 分支第一句就是
		 *     value &= 0xFF83;
		 * 0xFF83 把 bit0/bit1（波特率）清掉了，而后面 `value |= sio->siocnt &
		 * 0x00FC` 只把 bit2..7 粘回来，**波特率永远补不回来**。于是
		 * GBASIOMultiplayerGetBaud(siocnt) 恒为 0，传输周期取
		 * GBASIOCyclesPerTransfer[0][connected]：
		 *     baud0 = 63427 cycles（真机 115200 只要 5755）
		 *
		 * 这一条对游戏是致命的。gen8 link.c 的 LinkVSync 要求主机每帧
		 * 至少 9 次 SIO 中断，否则直接 gLink.lag = LAG_MASTER（游戏报
		 * 「通信错误…链接是坏的还是终端不匹配？」）。主机一轮的周期 =
		 * 传输周期 + Timer3(197*64=12608)：
		 *     baud=0 : 63427+12608 = 76035 → 每帧 280896/76035 = 3.7 轮 ❌
		 *     baud=3 :  5755+12608 = 18363 → 每帧 280896/18363 = 15.3 轮 ✅
		 * 也就是说，仅仅因为内核漏掉了波特率位，主机就永远达不到游戏要的
		 * 9 轮/帧，握手之后的每一条链路都会以「通信错误」收场。
		 *
		 * 修法：驱动把波特率位补回 115200（游戏自己写的 EnableSerial()
		 * 就是 0x6003 = MULTI|115200|IRQ，本来就是 3），内核丢的信息由我们
		 * 还原，行为与真机一致。 */
		out = (uint16_t) ((out & ~0x0003u) | 0x0003u);
		/* 【终端位：Slave(bit2)/Ready(bit3)/Id(bit4-5)】
		 *
		 * gen8 link.c 的 CheckMasterOrSlave()：
		 *   terminals = *(vu32*)REG_ADDR_SIOCNT & (SIO_MULTI_SD|SIO_MULTI_SI);
		 *   isMaster = (terminals == SIO_MULTI_SD && gLink.localId == 0);
		 * 其中 SIO_MULTI_SD=0x0008(Ready)、SIO_MULTI_SI=0x0004(Slave)。
		 * 也就是 **「Slave=0 且 Ready=1 且 localId=0」才是主机**，
		 * 从机是 Slave=1。和真机一致：主机产生时钟，自己的 SI 端不是从端。
		 *
		 * 内核 GBASIOWriteSIOCNT 的 MULTI 分支：
		 *   value &= 0xFF83;
		 *   value = SetSlave(value, id || !connected);
		 *   value = SetId(value, id);
		 *   value |= sio->siocnt & 0x00FC;      <-- 把旧 bit2..7 粘回来
		 * 那个 |= 让 Slave/Ready 位变成「粘」的：写过一次就再也清不掉。
		 * 所以终端位必须由驱动每次显式改写，不能依赖内核。
		 *
		 * 之前这里还留着一个「只有自己(alone)窗口」的补丁：挂载后的第一笔
		 * MULTI 写入按 Slave=1 呈现，之后才切回按 player 强制。那是错的 ——
		 * 它把主机在俱乐部握手时唯一一次决定主从的写入也变成了 Slave=1，
		 * 于是两端都判成从机、双方都发 0xB9A0，永远等不到主机的 0x8FFF，
		 * 表现就是「大厅连上了、游戏里却卡在请稍候」。
		 *
		 * 现在改成**由链路真实状态决定**：
		 *   传输层还没连上 → 总线上只有自己 → Slave=1（游戏据此知道还没伙伴）
		 *   连上了且本机是 0 号 → Slave=0（主机）
		 *   连上了且本机是 1 号 → Slave=1（从机）
		 * 游戏在 HANDSHAKE 态每一帧都会重新读 SIOCNT，所以只要值是对的，
		 * 什么时候连上的都能纠正过来（见 serviceLink 里的主动改写）。 */
		if (emu->linkAttached && emu->link) {
			int me = netLinkPlayer(emu->link);
			bool up = netLinkState(emu->link) == 2;   /* LINK_CONNECTED */
			bool slave = !up || me != 0;
			out = GBASIOMultiplayerSetSlave(out, slave);
			out = GBASIOMultiplayerSetId(out, up ? me : 0);
			if (emu->sioDbg < 400) {
				++emu->sioDbg;
				MOBILE_LOGI("SIO term: up=%d me=%d slave=%d out=%04X", up ? 1 : 0, me,
				            slave ? 1 : 0, out);
			}
		}
		if (emu->sioDbg < 400) {
			++emu->sioDbg;
			MOBILE_LOGI("SIO CNT out=%04X (slave=%d ready=%d id=%d)", out,
			            (out & 0x0004) ? 1 : 0, (out & 0x0008) ? 1 : 0,
			            netLinkPlayer(emu->link));
		}
		return out;
	}
	if (driver->p && (driver->p->mode == GBA_SIO_NORMAL_8 || driver->p->mode == GBA_SIO_NORMAL_32)) {
		return GBASIONormalFillSi(value);
	}
	return value;
}

static uint16_t gbaLinkWriteRcnt(struct GBASIODriver* driver, uint16_t value) {
	struct MgbaMobile* emu = ((struct GbaLinkDriver*) driver)->emu;
	if (emu->sioDbg < 60) {
		++emu->sioDbg;
		MOBILE_LOGI("SIO RCNT <- %04X (mode %d)", value,
		            driver->p ? (int) driver->p->mode : -1);
	}
	return value;
}

static bool gbaLinkStart(struct GBASIODriver* driver) {
	struct MgbaMobile* emu = ((struct GbaLinkDriver*) driver)->emu;
	if (emu->hsStartDbg < 24) {
		/* 数据阶段的 SIO_START 就是 Timer3 驱动链的心跳，跟着 HSX 一起看。 */
		++emu->hsStartDbg;
		MOBILE_LOGI("HSS me=%d start (mode %d) waiting=%d idx=%u",
		            netLinkPlayer(emu->link), driver->p ? (int) driver->p->mode : -1,
		            emu->sioWaiting, (unsigned) emu->sioIndex);
	}
	if (!emu->link || !emu->core || !driver->p || driver->p->mode != GBA_SIO_MULTI) {
		return true;
	}
	if (emu->core->platform(emu->core) != mPLATFORM_GBA) {
		return true;
	}
	if (emu->sioWaiting) {
		/* 宝可梦发起一次传输会连写两笔 SIOCNT：先 0x600F（IRQ 触发，writeCnt
		 * 已经 begin 并发出 REQ），再置 Busy 走到这里。第二次 begin 会顶掉
		 * 应答序号、让对端多收一次请求，直接沿用第一次的即可。 */
		return false;
	}
	if (netLinkPlayer(emu->link) != 0) {
		/* 从机置 Busy 也不发起：它的传输由 1P 的那一次驱动。 */
		return true;
	}
	if (!beginMultiTransfer(emu, driver, "master")) {
		return true;
	}
	/* 完成由本驱动负责（网络应答到达时写 SIOMULTI 并发 SIO 中断）。 */
	return false;
}

/* 只在没连上对端（走内核默认调度）时被调用：用最近一次对端数据收尾即可，
 * 传输本身不能在这里等网络。 */
static void gbaLinkFinishMulti(struct GBASIODriver* driver, uint16_t data[4]) {
	struct MgbaMobile* emu = ((struct GbaLinkDriver*) driver)->emu;
	struct GBA* gba = (struct GBA*) emu->core->board;
	int me = netLinkPlayer(emu->link);
	data[0] = data[1] = data[2] = data[3] = 0xFFFF;
	if (me >= 0 && me < 4) {
		data[me] = gba->memory.io[GBA_REG(SIOMLT_SEND)];
	}
	if (emu->sioHasRemote) {
		data[me == 0 ? 1 : 0] = (uint16_t) emu->sioRemote;
	}
}

static uint8_t gbaLinkFinish8(struct GBASIODriver* driver) {
	struct MgbaMobile* emu = ((struct GbaLinkDriver*) driver)->emu;
	struct GBA* gba = (struct GBA*) emu->core->board;
	uint32_t local = gba->memory.io[GBA_REG(SIODATA8)] & 0xFFu;
	uint32_t remote = 0xFFu;
	/* 不能重试：重发 REQ 会让对端的请求队列多出一轮、双方向量错位。等待窗
	 * 自适应 RTT（见 sioWaitMs），跨网尖峰时宁可慢不可错。 */
	netLinkExchange(emu->link, GBA_SIO_NORMAL_8, local, &remote, sioWaitMs(emu));
	return (uint8_t) remote;
}

static uint32_t gbaLinkFinish32(struct GBASIODriver* driver) {
	struct MgbaMobile* emu = ((struct GbaLinkDriver*) driver)->emu;
	struct GBA* gba = (struct GBA*) emu->core->board;
	uint32_t local = gba->memory.io[GBA_REG(SIODATA32_LO)] | ((uint32_t) gba->memory.io[GBA_REG(SIODATA32_HI)] << 16);
	uint32_t remote = 0xFFFFFFFFu;
	netLinkExchange(emu->link, GBA_SIO_NORMAL_32, local, &remote, sioWaitMs(emu));
	return remote;
}

static bool gbLinkInit(struct GBSIODriver* driver) {
	struct MgbaMobile* emu = ((struct GbLinkDriver*) driver)->emu;
	emu->linkEvent.context = emu;
	emu->linkEvent.callback = linkPollEvent;
	emu->linkEvent.name = "Mobile Link";
	emu->linkEvent.priority = 0x70;
	armLinkEvent(emu);
	return true;
}

static void gbLinkDeinit(struct GBSIODriver* driver) {
	struct MgbaMobile* emu = ((struct GbLinkDriver*) driver)->emu;
	struct mTiming* timing = coreTiming(emu);
	if (timing) {
		mTimingDeschedule(timing, &emu->linkEvent);
	}
}

static void gbLinkWriteSb(struct GBSIODriver* driver, uint8_t value) {
	UNUSED(driver);
	UNUSED(value);
}

static uint8_t gbLinkWriteSc(struct GBSIODriver* driver, uint8_t value) {
	struct MgbaMobile* emu = ((struct GbLinkDriver*) driver)->emu;
		if (GBRegisterSCIsEnable(value) && GBRegisterSCIsShiftClock(value)) {
			uint8_t local = driver->p->p->memory.io[GB_REG_SB];
			uint32_t remote = 0xFFu;
			if (netLinkExchange(emu->link, 0, local, &remote, sioWaitMs(emu))) {
				driver->p->pendingSB = (uint8_t) remote;
			}
		}
	return value;
}

static void prepareGbaDriver(struct MgbaMobile* emu) {
	struct GBASIODriver* d = &emu->gbaLink.d;
	memset(d, 0, sizeof(*d));
	emu->gbaLink.emu = emu;
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

static void prepareGbDriver(struct MgbaMobile* emu) {
	struct GBSIODriver* d = &emu->gbLink.d;
	memset(d, 0, sizeof(*d));
	emu->gbLink.emu = emu;
	d->init = gbLinkInit;
	d->deinit = gbLinkDeinit;
	d->writeSB = gbLinkWriteSb;
	d->writeSC = gbLinkWriteSc;
}

static void detachLink(struct MgbaMobile* emu) {
	if (!emu->linkAttached || !emu->core) {
		emu->linkAttached = false;
		return;
	}
	if (emu->core->platform(emu->core) == mPLATFORM_GBA) {
		GBASIOSetDriver(&((struct GBA*) emu->core->board)->sio, NULL);
	} else if (emu->core->platform(emu->core) == mPLATFORM_GB) {
		GBSIOSetDriver(&((struct GB*) emu->core->board)->sio, NULL);
	}
	emu->linkAttached = false;
	emu->sioInitSeen = false;
}

/* 把 SIOCNT 的终端位（Slave/Ready/Id）改写成「链路当前真实的样子」。
 *
 * 游戏在 HANDSHAKE 态每帧都会读一次 SIOCNT 来定主从
 * （CheckMasterOrSlave），但它只在少数几处写 SIOCNT —— 也就是说，
 * 「链路什么时候连上的」和「游戏什么时候读 SIOCNT」两者不一定碰上。
 * 所以除了每次写入时由 gbaLinkWriteCnt 改写之外，还要在链路状态变化的
 * 时刻主动把寄存器改对，否则游戏会一直读到内核留下的旧值。
 *
 * 绝不碰 0x2000（MULTI 模式位）：内核只有在模式位变化时才切模式，提前置上
 * 会让内核以为模式没变，游戏的第一次 0x2000 写入就切不到 MULTI 上去。
 */
static void applyLinkTerminalBits(struct MgbaMobile* emu) {
	if (!emu->core || emu->core->platform(emu->core) != mPLATFORM_GBA) {
		return;
	}
	struct GBA* gba = (struct GBA*) emu->core->board;
	int me = netLinkPlayer(emu->link);
	bool up = emu->link && netLinkState(emu->link) == 2;
	uint16_t siocnt = gba->sio.siocnt;
	uint16_t want = siocnt;
	want = GBASIOMultiplayerSetSlave(want, !up || me != 0);
	want = GBASIOMultiplayerSetId(want, up ? me : 0);
	want = GBASIOMultiplayerFillReady(GBASIOMultiplayerClearError(want));
	want = (uint16_t) ((want & ~0x0003u) | 0x0003u);   /* 波特率补回 115200 */
	if (want != siocnt) {
		MOBILE_LOGI("SIOCNT term patch: up=%d me=%d %04X -> %04X",
		            up ? 1 : 0, me, siocnt, want);
		gba->sio.siocnt = want;
	}
}

static void attachLink(struct MgbaMobile* emu) {
	if (!emu->core || emu->linkAttached || netLinkState(emu->link) != 2) {
		return;
	}
	if (emu->core->platform(emu->core) == mPLATFORM_GBA) {
		struct GBA* gba = (struct GBA*) emu->core->board;
		int me = netLinkPlayer(emu->link);
		prepareGbaDriver(emu);
		GBASIOSetDriver(&gba->sio, &emu->gbaLink.d);
		/* 游戏可能在挂载之前就已进入 HANDSHAKE，CheckMasterOrSlave 读到的还是
		 * 「无驱动」时代的 SIOCNT（Slave=1）。挂载这一刻把终端位改写成联机
		 * 线会话的真值，游戏下一帧重新判定主从。
		 * 注意这里绝不能带上 0x2000（MULTI 模式位）：内核只有在模式位变化时
		 * 才切模式，提前置上会让内核以为模式没变，游戏的第一次 0x2000 写入
		 * 就切不到 MULTI 模式上去。 */
		applyLinkTerminalBits(emu);
		MOBILE_LOGI("SIOCNT patched at attach: id=%d %04X",
		            me, gba->sio.siocnt);
		emu->linkAttached = true;
	} else if (emu->core->platform(emu->core) == mPLATFORM_GB) {
		prepareGbDriver(emu);
		GBSIOSetDriver(&((struct GB*) emu->core->board)->sio, &emu->gbLink.d);
		emu->linkAttached = true;
	}
	if (emu->linkAttached) {
		emu->sioOk = 0;
		emu->sioPeak = 0;
		emu->sioTimeouts = 0;
		emu->sioFallback = 0;
		emu->sioWaiting = false;
		emu->sioBusyCycle = 0;
		emu->sioIndex = 0;
		emu->sioPushed = false;
		emu->sioPushValue = 0;
		emu->sioPushIndex = 0;
		emu->sioMisorder = 0;
		emu->sioHasRemote = false;
		emu->sioInitSeen = false;
		emu->sioEvtDbg = 0;
		emu->sioTakeDbg = 0;
		emu->sioInDbg = 0;
		emu->sioSkipDbg = 0;
		emu->sioSlaveDoneDbg = 0;
		emu->hsDbg = 0;
		emu->hsPushDbg = 0;
		emu->hsStartDbg = 0;
		emu->lkqFrames = 0;
		MOBILE_LOGI("Link attached as P%d", netLinkPlayer(emu->link) + 1);
	}
}

static void pollLink(struct MgbaMobile* emu) {
	if (!emu->link) {
		return;
	}
	bool up = netLinkState(emu->link) == 2;
	/* 复位（core.reset）会把 GBA 结构里的 sio.driver 清空，但 linkAttached 还
	 * 留着 true —— 不补这个检查的话，复位后永远不会重新挂载驱动，游戏在
	 * 联机等待画面卡死（SIO poll 永远 drv=0）。 */
	bool drvOk = false;
	if (up && emu->core) {
		if (emu->core->platform(emu->core) == mPLATFORM_GBA) {
			drvOk = ((struct GBA*) emu->core->board)->sio.driver == &emu->gbaLink.d;
		} else if (emu->core->platform(emu->core) == mPLATFORM_GB) {
			drvOk = ((struct GB*) emu->core->board)->sio.driver == &emu->gbLink.d;
		}
	}
	if (up && (!emu->linkAttached || !drvOk)) {
		emu->linkAttached = false;
		attachLink(emu);
	} else if (!up && emu->linkAttached) {
		detachLink(emu);
	}
}

void mgbaMobileSetKeys(struct MgbaMobile* emu, uint32_t keys) {
	if (!emu) {
		return;
	}
	noteKeys(emu, keys);
}

void mgbaMobileSetTurbo(struct MgbaMobile* emu, uint32_t mask) {
	if (!emu) {
		return;
	}
	__atomic_store_n(&emu->turboMask, mask, __ATOMIC_RELEASE);
	if (!mask) {
		emu->turboCounter = 0;
	}
}

uint16_t mgbaMobileLastKeys(struct MgbaMobile* emu) {
	if (!emu || !emu->core || emu->core->platform(emu->core) != mPLATFORM_GBA) {
		return 0;
	}
	struct GBA* gba = (struct GBA*) emu->core->board;
	/* Reading the console's key register is exactly what the game does, and
	 * it is what pulls the live key state through the key callback. The
	 * result is the console's active-low convention: a set bit means the key
	 * is released, a clear bit means it is pressed. */
	return GBAIORead(gba, GBA_REG_KEYINPUT);
}

/* RunFrames 的实现体。调用方必须已持有核心锁（见下面的公开包装）。 */
static bool mobileRunFramesLocked(struct MgbaMobile* emu, int count) {
	if (!emu || !emu->core) {
		return false;
	}
	if (count < 1) {
		count = 1;
	}
	if (!emu->lockstepSlot) {
		pollLink(emu);
	}
	/* 真实速度探针：模拟帧率是判断「游戏是不是被网络等待拖死」的第一指标。
	 * 联机时模拟时钟会在等对端应答的那段时间里冻住，所以模拟帧率远低于
	 * 真实帧率就说明有阻塞。每 60 个模拟帧打一行，带上真实耗时。 */
	{
		uint32_t now = wallNowMs();
		struct mTiming* tm = coreTiming(emu);
		uint32_t cyc = tm ? mTimingCurrentTime(tm) : 0;
		if (emu->probeWallAt == 0) {
			emu->probeWallAt = now;
			emu->probeCycAt = cyc;
			emu->probeFrames = 0;
		}
		emu->probeFrames += (uint32_t) count;
		uint32_t wall = now - emu->probeWallAt;
		if (wall >= 2000) {
			/* 模拟帧率（按模拟时钟算）才是关键：联机时模拟时钟会在等对端应答
			 * 的那段时间里冻住，模拟帧率一低就说明游戏被网络等待拖死了。
			 * calls/s 是真实帧率，用来对照：两者一比就知道时间花在哪儿。 */
			double emuFrames = (double) (cyc - emu->probeCycAt) / 280896.0;
			MOBILE_LOGI("FRM me=%d emuFps=%.2f callsFps=%.1f frames=%u wall=%ums",
			            netLinkPlayer(emu->link), emuFrames * 1000.0 / (double) wall,
			            (double) emu->probeFrames * 1000.0 / (double) wall,
			            emu->probeFrames, wall);
			emu->probeWallAt = now;
			emu->probeCycAt = cyc;
			emu->probeFrames = 0;
		}
	}
	if (emu->core->platform(emu->core) == mPLATFORM_GBA) {
		struct GBA* g = (struct GBA*) emu->core->board;
		uint32_t stNow = (uint32_t) GBAView32(g->cpu, PEEK_LINK_STATUS);
		/* 错误位一旦置起立即报警（每帧），不依赖降采样，避免漏掉瞬时错误。 */
		if (stNow & 0x0007F000u) {
			MOBILE_LOGI("LINK_ERR st=%08X qFull=%d hw=%d ck=%d lagM=%d lagS=%d siocnt=%04X waiting=%d me=%d",
			            stNow,
			            (int) GBAView8(g->cpu, PEEK_LINK + 0x12),
			            (int)((stNow >> 12) & 1), (int)((stNow >> 13) & 1),
			            (int)((stNow >> 16) & 1), (int)((stNow >> 18) & 1),
			            g->sio.siocnt, emu->sioWaiting, netLinkPlayer(emu->link));
		}
		/* 握手卡住时扫一次内存，定位游戏真实的 link 数据区（只做一次）。 */
		if (!emu->memScan && emu->sioOk > 150 && g->sio.mode == GBA_SIO_MULTI) {
			emu->memScan = 1;
			int found = 0;
			static const uint32_t SPANS[2][2] = {
				{ 0x02000000u, 0x02040000u },  /* EWRAM 256K */
				{ 0x03000000u, 0x03008000u }   /* IWRAM 32K  */
			};
			for (int s = 0; s < 2 && found < 8; ++s) {
				for (uint32_t a = SPANS[s][0]; a + 4 < SPANS[s][1] && found < 8; a += 2) {
					if ((uint16_t) GBAView16(g->cpu, a) != 0xB9A0u) {
						continue;
					}
					if ((uint16_t) GBAView16(g->cpu, a + 2) != 0xB9A0u) {
						continue;
					}
					++found;
					char buf[320];
					int n = snprintf(buf, sizeof(buf), "MEMF %08X:", a);
					for (int k = -12; k < 28; k += 2) {
						n += snprintf(buf + n, sizeof(buf) - n, " %04X",
						              (unsigned)(uint16_t) GBAView16(g->cpu, a + k));
					}
					MOBILE_LOGI("%s", buf);
				}
			}
			MOBILE_LOGI("MEMS found=%d IME=%d IE=%04X IF=%04X siocnt=%04X mode=%d me=%d ok=%u",
			            found, (int) g->memory.io[GBA_REG(IME)],
			            (unsigned) g->memory.io[GBA_REG(IE)],
			            (unsigned) g->memory.io[GBA_REG(IF)],
			            g->sio.siocnt, (int) g->sio.mode,
			            netLinkPlayer(emu->link), emu->sioOk);
		}
		/* 逐帧盯着握手推进的几个关键量，只在变化时打点：
		 * adv = gShouldAdvanceLinkState（游戏推进联机的旗标，LinkMain1 每帧会清零）
		 * hs  = gLink.handshakeAsMaster（为真时主机才会把 0x8FFF 写进 SIOMULTI0）
		 * st  = gLink.state / pc = gLink.playerCount
		 * m0/m1 = SIOMULTI0/1（主/从各自的握手字）
		 * 这几个量在一帧内就会被吃掉，靠降采样必然漏掉，所以必须逐帧比变化。 */
		{
			int adv = (int) GBAView8(g->cpu, PEEK_LINK_STATE);
			int hs  = (int) GBAView8(g->cpu, PEEK_LINK + PEEK_LK_HANDSHAKE);
			int st  = (int) GBAView8(g->cpu, PEEK_LINK + PEEK_LK_STATE);
			int pc  = (int) GBAView8(g->cpu, PEEK_LINK + PEEK_LK_PLAYERS);
			int sic = (int) (int8_t) GBAView8(g->cpu, PEEK_LINK + PEEK_LK_SICTR);
			int lag = (int) GBAView8(g->cpu, PEEK_LINK + PEEK_LK_LAG);
			int bck = (int) GBAView8(g->cpu, PEEK_LINK + PEEK_LK_BADCK);
			uint32_t m0 = GBAIORead(g, GBA_REG_SIOMULTI0);
			uint32_t m1 = GBAIORead(g, GBA_REG_SIOMULTI1);
			if ((uint32_t) adv != emu->sioPrevAdv) {
				MOBILE_LOGI("ADV %u->%d st=%d pc=%d hs=%d m0=%04X m1=%04X me=%d",
				            emu->sioPrevAdv, adv, st, pc, hs, m0, m1, netLinkPlayer(emu->link));
				emu->sioPrevAdv = (uint32_t) adv;
			}
			if ((uint32_t) hs != emu->sioPrevHs) {
				MOBILE_LOGI("HS %u->%d st=%d pc=%d adv=%d m0=%04X m1=%04X me=%d",
				            emu->sioPrevHs, hs, st, pc, adv, m0, m1, netLinkPlayer(emu->link));
				emu->sioPrevHs = (uint32_t) hs;
			}
			if (st != emu->sioPrevLinkState || pc != emu->sioPrevPc) {
				MOBILE_LOGI("ST %d->%d pc %d->%d adv=%d hs=%d sic=%d lag=%d bck=%d m0=%04X m1=%04X me=%d",
				            emu->sioPrevLinkState, st, emu->sioPrevPc, pc, adv, hs, sic, lag, bck, m0, m1,
				            netLinkPlayer(emu->link));
				emu->sioPrevLinkState = st;
				emu->sioPrevPc = pc;
			}
			if (m0 != emu->sioPrevM0 || m1 != emu->sioPrevM1) {
				MOBILE_LOGI("MLT m0=%04X m1=%04X st=%d pc=%d hs=%d adv=%d me=%d",
				            m0, m1, st, pc, hs, adv, netLinkPlayer(emu->link));
				emu->sioPrevM0 = m0;
				emu->sioPrevM1 = m1;
			}
		}
		if ((++emu->sioPoll % 60) == 0) {
		MOBILE_LOGI("SIO poll mode=%d siocnt=%04X rcnt=%04X drv=%d wait=%d",
		            (int) g->sio.mode, g->sio.siocnt, g->sio.rcnt,
		            g->sio.driver != NULL, emu->sioWaiting);
#if MGBA_LINK_PEEK
		MOBILE_LOGI("PEEK st=%08X adv=%d open=%d wless=%d err=%d rcvpl=%d blk=%02X "
		            "link[m=%d st=%d id=%d pc=%d sic=%d hs=%d fF=%d hw=%d ck=%d lag=%d "
		            "sum=%04X sidx=%d ridx=%d sq=%u/%u rq=%u/%u]",
		            stNow,
		            (int) GBAView8(g->cpu, PEEK_LINK_STATE),
		            (int) GBAView8(g->cpu, PEEK_LINK_OPEN),
		            (int) GBAView8(g->cpu, PEEK_LINK_WLESS),
		            (int) GBAView8(g->cpu, PEEK_LINK_ERROCC),
		            (int) GBAView8(g->cpu, PEEK_LINK_RECVPL),
		            (unsigned) GBAView8(g->cpu, PEEK_LINK_BLOCKS),
		            (int) GBAView8(g->cpu, PEEK_LINK + PEEK_LK_ISMASTER),
		            (int) GBAView8(g->cpu, PEEK_LINK + PEEK_LK_STATE),
		            (int) GBAView8(g->cpu, PEEK_LINK + PEEK_LK_LOCALID),
		            (int) GBAView8(g->cpu, PEEK_LINK + PEEK_LK_PLAYERS),
		            (int) (int8_t) GBAView8(g->cpu, PEEK_LINK + PEEK_LK_SICTR),
		            (int) GBAView8(g->cpu, PEEK_LINK + PEEK_LK_HANDSHAKE),
		            (int) GBAView8(g->cpu, PEEK_LINK + PEEK_LK_FIELD_F),
		            (int) GBAView8(g->cpu, PEEK_LINK + PEEK_LK_HWERR),
		            (int) GBAView8(g->cpu, PEEK_LINK + PEEK_LK_BADCK),
		            (int) GBAView8(g->cpu, PEEK_LINK + PEEK_LK_LAG),
		            (unsigned) GBAView16(g->cpu, PEEK_LINK + PEEK_LK_CHECKSUM),
		            (int) GBAView8(g->cpu, PEEK_LINK + PEEK_LK_SENDIX),
		            (int) GBAView8(g->cpu, PEEK_LINK + PEEK_LK_RECVIX),
		            (unsigned) GBAView8(g->cpu, PEEK_LINK + PEEK_LK_SENDQ_POS),
		            (unsigned) GBAView8(g->cpu, PEEK_LINK + PEEK_LK_SENDQ_CNT),
		            (unsigned) GBAView8(g->cpu, PEEK_LINK + PEEK_LK_RECVQ_POS),
		            (unsigned) GBAView8(g->cpu, PEEK_LINK + PEEK_LK_RECVQ_CNT));
#endif
		}
		/* 命令队列探针：每 30 帧打一行，看游戏自己有没有在入队/出队。
		 * sendQ 一直 0 => 应用层没东西要发（不是链路没送到）；
		 * recvQ 一直 0 => 收到的字没被组装成命令（多半是轮次/槽位错位）。 */
		if (emu->linkAttached && emu->lkqFrames < 6000 && (++emu->lkqFrames % 30) == 0) {
			uint16_t lkck = (uint16_t) GBAView16(g->cpu, PEEK_LINK + 0x14);
			MOBILE_LOGI("LKQ f=%u me=%d st=%08X st2=%08X gst=%d ck=%04X sci=%u rci=%u sq=%u/%u rq=%u/%u ok=%u idx=%u",
			            emu->lkqFrames, netLinkPlayer(emu->link), stNow,
			            (uint32_t) GBAView32(g->cpu, PEEK_LINK_STATUS + 0x0C),
			            (int) GBAView8(g->cpu, PEEK_LINK + 0x01), lkck,
			            (unsigned) GBAView8(g->cpu, PEEK_LINK + 0x16),
			            (unsigned) GBAView8(g->cpu, PEEK_LINK + 0x17),
			            (unsigned) GBAView8(g->cpu, PEEK_LINK + PEEK_LK_SENDQ_POS),
			            (unsigned) GBAView8(g->cpu, PEEK_LINK + PEEK_LK_SENDQ_CNT),
			            (unsigned) GBAView8(g->cpu, PEEK_LINK + PEEK_LK_RECVQ_POS),
			            (unsigned) GBAView8(g->cpu, PEEK_LINK + PEEK_LK_RECVQ_CNT),
			            emu->sioOk, (unsigned) emu->sioIndex);
		}
		/* 检测到 gLinkStatus 由非零掉到 0（CloseLink 复位）：把复位前那帧的状态
		 * 和当时的 SIO 现场打出来，定位到底是哪条路径触发了断链。 */
		if (emu->sioPrevStatus != 0 && stNow == 0) {
			MOBILE_LOGI("LINK_RESET prev=%08X qFull=%d siocnt=%04X waiting=%d me=%d",
			            emu->sioPrevStatus,
			            (int) GBAView8(g->cpu, PEEK_LINK + 0x12),
			            g->sio.siocnt, emu->sioWaiting, netLinkPlayer(emu->link));
		}
		emu->sioPrevStatus = stNow;
	}
	/* 帧屏障只在没挂 SIO 驱动时做（镜像模式用它对齐两边帧钟）。联机线会话里
	 * 这 400ms 的互相等是毒药：主机卡在 SIO 轮的 takePeerWord 里等从机推送，
	 * 从机卡在 barrier 里等主机下一条 TICK，两边恰好互相耗尽 400ms —— 数据
	 * 阶段跑到几十轮后必有一轮 takePeerWord 超时，游戏立刻报「连接发生了
	 * 错误」。轮本身的阻塞（等对端推送）已经是背压，帧对齐交给两边的 60fps
	 * 节拍就够了。 */
	if (count == 1 && emu->link && netLinkState(emu->link) == 2 && !emu->linkAttached) {
		netLinkBarrier(emu->link, 400);
	}
	applyFrameskip(emu->core, count > 1 ? count - 1 : emu->userSkip);
	setFastAudio(emu, count > 1);
	int i;
	for (i = 0; i < count; ++i) {
		uint32_t nowKeys = beginFrameKeys(emu);
		if (nowKeys != emu->appliedKeys) {
			emu->appliedKeys = nowKeys;
			MOBILE_LOGI("FrameKeys 0x%x", nowKeys);
		}
		emu->core->setKeys(emu->core, nowKeys);
		if (emu->lockstepSlot) {
			/* 协调器靠 sleep/wake 在 SIO 传输轮次会合，必须小步推进；
			 * runFrame 会在帧内忙等并破坏锁步。 */
			mgbaLockstepRunFrame(emu->lockstepSlot, emu->core);
		} else {
			emu->core->runFrame(emu->core);
		}
		if (emu->rewindEnabled && ++emu->rewindCounter >= REWIND_DIVIDER) {
			emu->rewindCounter = 0;
			if (!emu->rewindInited) {
				mCoreRewindContextInit(&emu->rewind, REWIND_ENTRIES, false);
				emu->rewindInited = true;
			}
			mCoreRewindAppend(&emu->rewind, emu->core);
		}
	}
	ensureVideo(emu);
	return true;
}

/* 核心锁下沉到这一层：iOS 直接调用这个函数（不经过 JNI 的 nativeRunFrames），
 * 而状态帧是在 socket 读线程上被注入的 —— 不加锁就是「一边 runFrame 一边
 * 换核心状态」的竞态。安卓侧的 JNI 入口也加了锁，核心锁是递归的，同线程
 * 重入安全。 */
bool mgbaMobileRunFrames(struct MgbaMobile* emu, int count) {
	if (!emu || !emu->core) {
		return false;
	}
	mgbaMobileLock(emu);
	bool ok = mobileRunFramesLocked(emu, count);
	mgbaMobileUnlock(emu);
	return ok;
}

int mgbaMobileReadAudio(struct MgbaMobile* emu, int16_t* out, int maxFrames) {
	if (!emu || !emu->core || !out || maxFrames <= 0) {
		return 0;
	}
	struct mAudioBuffer* buffer = emu->core->getAudioBuffer(emu->core);
	if (!buffer) {
		return 0;
	}
	size_t available = mAudioBufferAvailable(buffer);
	if (available > (size_t) maxFrames) {
		available = (size_t) maxFrames;
	}
	if (available == 0) {
		return 0;
	}
	return (int) mAudioBufferRead(buffer, out, available);
}

void mgbaMobileClearAudio(struct MgbaMobile* emu) {
	if (!emu || !emu->core) {
		return;
	}
	struct mAudioBuffer* buffer = emu->core->getAudioBuffer(emu->core);
	if (buffer) {
		mAudioBufferClear(buffer);
	}
	if (emu->audioHoldInited) {
		mAudioBufferClear(&emu->audioHold);
	}
	/* The WSOLA input queue and the native-hold cursors are owned by the audio
	 * thread. Publish a pending clear instead of touching them here: the next
	 * mgbaMobileReadAudioOut() runs the full reset (wsolaIn, wsolaAnaPos,
	 * natR/natW, primed/outAcc/lastTime), so a re-enable after ClearAudio can
	 * no longer replay stale samples against a reset analysis cursor. */
	emu->wsolaClearPending = true;
	resetAudioOutput(emu);
}

/*
 * Installs the quality resampler that converts the core's native sample rate to
 * the device's output rate. Call with the rate the front end's audio device
 * runs at; pass 0 to disable conversion again.
 */
bool mgbaMobileSetAudioOutput(struct MgbaMobile* emu, int outRate) {
	if (!emu) {
		return false;
	}
	if (outRate <= 0) {
		deinitAudioOutput(emu);
		return false;
	}
	if (emu->audioResamplerInited) {
		if (emu->audioOutRate == outRate) {
			return true;
		}
		deinitAudioOutput(emu);
	}
	mAudioBufferInit(&emu->audioOut, MOBILE_AUDIO_OUT_FRAMES, 2);
	mAudioResamplerInit(&emu->audioResampler, mINTERPOLATOR_SINC);
	mAudioResamplerSetDestination(&emu->audioResampler, &emu->audioOut, outRate);
	emu->audioResamplerInited = true;
	emu->audioOutRate = outRate;
	MOBILE_LOGI("Audio output resampler at %d Hz", outRate);
	return true;
}

/*
 * Turns 不变速 (constant pitch) playback on or off. While it is on the
 * fast-forwarded game's surplus audio is parked in a buffer and replayed at
 * the console's own rate instead of being shredded by the core's ring, so the
 * music keeps its speed and pitch and only jumps when the park fills. The
 * front end is expected to pass speed 1 to mgbaMobileReadAudioOut while this
 * is on - the resampler rate is what sets the pitch, and this only decides
 * where the surplus goes.
 */
void mgbaMobileSetAudioConstantPitch(struct MgbaMobile* emu, bool on, double stretch) {
	if (!emu) {
		return;
	}
	/*
	 * Called from the UI thread (the speed-menu checkbox) while
	 * mgbaMobileReadAudioOut runs on the emulation/audio thread. The WSOLA
	 * buffers are owned exclusively by the audio thread: initAudioHold (called
	 * from readAudioOut) allocates/rebuilds them and only teardown frees them.
	 * Touching them here - as an earlier version did with mAudioBufferClear and
	 * deinitAudioHold - races wsolaGenerate and crashes (use-after-free). So
	 * only publish the request; the audio thread acts on it on its next read.
	 *
	 * The front end republishes this on every emulated slice (~60 times a
	 * second) while the mode is on, so an unchanged request must be a no-op:
	 * arming the pending clear every time made the next read throw away the
	 * parked input and the analysis cursor, and zeroing the resampler timestamp
	 * every time restarted its fractional phase - together that turned the
	 * stretched music into chopped, ringing scraps.
	 */
	bool changed = on != emu->audioHoldOn || fabs(stretch - emu->wsolaStretch) > 0.01;
	emu->wsolaStretch = stretch;
	emu->audioHoldOn = on;
	if (!changed) {
		return;
	}
	emu->wsolaClearPending = true;
	if (emu->audioResamplerInited) {
		emu->audioResampler.timestamp = 0;
	}
}

size_t mgbaMobileWsolaDropped(const struct MgbaMobile* emu) {
	return emu ? emu->wsolaDropped : 0;
}

size_t mgbaMobileNativeHoldCuts(const struct MgbaMobile* emu) {
	return emu ? emu->natCuts : 0;
}

/*
 * Picks how fast-forward audio is produced (see MOBILE_AUDIO_HOLD_*). Like the
 * enable/stretch pair above this only publishes the request: the staging
 * buffers belong to the audio thread, so the UI thread must not touch them.
 */
void mgbaMobileSetAudioHoldMode(struct MgbaMobile* emu, int mode) {
	if (!emu) {
		return;
	}
	if (mode != MOBILE_AUDIO_HOLD_NATIVE) {
		mode = MOBILE_AUDIO_HOLD_PITCH;
	}
	if (emu->audioHoldMode == mode) {
		return;
	}
	emu->audioHoldMode = mode;
	emu->wsolaClearPending = true;
	if (emu->audioResamplerInited) {
		emu->audioResampler.timestamp = 0;
	}
}

/*
 * Feeds back how many frames per second the front end is actually managing to
 * pace emulation at. The resampler scales its input rate by the emulated
 * console's frame rate over this pace, so a game the device cannot run at full
 * speed still produces audio the playback buffer can consume without
 * underruns. Call about once a second with a measured value.
 *
 * A single measured window is not trustworthy material for the pitch: it can
 * be dragged down by a ROM load, a system pause or a GC run inside the window,
 * and even an ordinary window scatters by a few percent from sleep
 * quantization alone. The applied pace is therefore an eased estimate: it
 * absorbs a share of each reading instead of stepping to it, so the pitch
 * glides instead of jumping once per window (which during fast-forward, where
 * the throughput wobbles hardest, was heard as the music randomly detuning).
 * Readings far outside the estimate are treated as stalls and need a
 * confirming window before the estimate follows them at all.
 */
/* 两点确认：只保留上一次读数，不再用三点中值（见 mgbaMobileSetAudioPaceFps）。 */

void mgbaMobileSetAudioPaceFps(struct MgbaMobile* emu, double fps) {
	if (!emu || !(fps > 0.0)) {
		return;
	}
	if (fps < MOBILE_AUDIO_PACE_FPS_MIN) {
		fps = MOBILE_AUDIO_PACE_FPS_MIN;
	} else if (fps > MOBILE_AUDIO_PACE_FPS_MAX) {
		fps = MOBILE_AUDIO_PACE_FPS_MAX;
	}
	/* 回到「两个连续读数一致才跳」的设计意图（见 struct 注释）。
	 * 旧实现用 median3 三点中值，确认一次变化要 3~5 个窗口；更糟的是
	 * audioPaceFps==0（未测量）时首个读数直接锁定，一次调度卡顿就把
	 * 音乐拖成半速。现在 audioPaceHist[0] 只存上一次读数，
	 * audioPaceHistLen>0 表示它有效。未锁定时以控制台标称帧率作基准，
	 * 首个离群读数只记一次、不改 pace —— 0 仍表示「未测量」，
	 * readAudioOut 继续按标称输出，AudioPaceSeeded 的语义不变。 */
	double baseline = emu->audioPaceFps > 0.0
			? emu->audioPaceFps : audioNativeFps(emu);
	bool havePrevious = emu->audioPaceHistLen > 0;
	double previous = emu->audioPaceHist[0];
	emu->audioPaceHist[0] = fps;
	emu->audioPaceHistLen = 1;

	double delta = fabs(fps - baseline);
	if (delta > baseline * MOBILE_AUDIO_PACE_OUTLIER) {
		/* 离群：上一次读数与本次一致（同方向）才确认；单次只是卡顿。 */
		bool agreed = havePrevious
				&& fabs(previous - fps) <= fps * MOBILE_AUDIO_PACE_OUTLIER;
		if (!agreed && ++emu->audioPaceOutliers < 2) {
			return;
		}
		emu->audioPaceFps = fps;
		emu->audioPaceOutliers = 0;
		emu->audioPaceThroughput = fmax(emu->audioPaceThroughput * MOBILE_AUDIO_PACE_THROUGHPUT_DECAY,
						emu->audioPaceFps * emu->audioPaceSpeed);
		return;
	}
	emu->audioPaceOutliers = 0;
	if (emu->audioPaceFps <= 0.0) {
		/* deadband 内的首个正常读数：直接锁定，不必等两次。 */
		emu->audioPaceFps = fps;
	} else {
		double share = fps < emu->audioPaceFps
				? MOBILE_AUDIO_PACE_EMA_DOWN : MOBILE_AUDIO_PACE_EMA_UP;
		emu->audioPaceFps += (fps - emu->audioPaceFps) * share;
	}
	emu->audioPaceThroughput = fmax(emu->audioPaceThroughput * MOBILE_AUDIO_PACE_THROUGHPUT_DECAY,
					emu->audioPaceFps * emu->audioPaceSpeed);
}

/*
 * Clears the pace estimate so the resampler re-locks after a deliberate speed
 * change. The device-throughput memory survives the reset: readAudioOut seeds
 * from it until the first fresh reading locks the estimate again.
 */
void mgbaMobileResetAudioPace(struct MgbaMobile* emu) {
	if (!emu) {
		return;
	}
	emu->audioPaceFps = 0.0;
	emu->audioPaceOutliers = 0;
	emu->audioPaceHistLen = 0;
}

/*
 * Whether the resampler's input rate can be trusted for the speed currently
 * being read: either a locked estimate or a remembered device throughput to
 * seed from. Front ends defer starting playback while this is false - the
 * first fast-forward on a device has no measurement to go on, and filling the
 * playback queue at the console's nominal rate would drain it into gaps and
 * play wrong-pitch audio; waiting out the first feedback window and then
 * starting at the locked rate turns that into a beat of silence instead.
 */
bool mgbaMobileAudioPaceSeeded(const struct MgbaMobile* emu) {
	return emu && (emu->audioPaceFps > 0.0 || emu->audioPaceThroughput > 0.0);
}

struct MgbaMobileAudioWindow {
	int16_t* samples;
	size_t frames;
	unsigned channels;
	unsigned channel;
};

static int16_t _audioWindowSampleAt(int index, const void* context) {
	const struct MgbaMobileAudioWindow* window = context;
	if (index < 0 || (size_t) index >= window->frames) {
		return 0;
	}
	return window->samples[(size_t) index * window->channels + window->channel];
}

static bool ensureAudioWindow(struct MgbaMobile* emu, size_t frames) {
	if (!frames) {
		return false;
	}
	if (emu->audioWindow && emu->audioWindowFrames >= frames) {
		return true;
	}
	// Storage for stereo int16 frames; mobile cores never use more channels.
	int16_t* window = (int16_t*) realloc(emu->audioWindow, frames * 2 * sizeof(int16_t));
	if (!window) {
		return false;
	}
	emu->audioWindow = window;
	emu->audioWindowFrames = frames;
	return true;
}

/*
 * mAudioResamplerProcess with the interpolator running against a linear copy
 * of the source. The stock implementation peeks every tap straight out of the
 * source's ring buffer, which costs one wrap-handling dump per tap and made
 * SINC resampling too slow to keep up on phones. Here the ring buffer is only
 * touched twice per pump - one bulk dump and one seek - while the timestep
 * accumulation, the stop conditions and the amount of source consumed stay
 * identical to the stock resampler.
 */
static void processAudioResampler(struct MgbaMobile* emu) {
	struct mAudioResampler* resampler = &emu->audioResampler;
	struct mAudioBuffer* source = resampler->source;
	struct mAudioBuffer* destination = resampler->destination;
	unsigned channels = source->channels;
	size_t available = mAudioBufferAvailable(source);
	if (!channels || channels > 2 || !ensureAudioWindow(emu, available)) {
		// Unexpected format or out of memory: take the slow but correct path.
		mAudioResamplerProcess(resampler);
		return;
	}
	size_t dumped = mAudioBufferDump(source, emu->audioWindow, available, 0);
	struct MgbaMobileAudioWindow window = {
		.samples = emu->audioWindow,
		.frames = dumped,
		.channels = channels,
	};
	struct mInterpolationData data = {
		.at = _audioWindowSampleAt,
		.context = &window,
	};
	struct mInterpolator* interp = &resampler->interp;
	double timestep = resampler->sourceRate / resampler->destRate;
	double timestamp = resampler->timestamp;
	int16_t samples[2] = { 0 };
	while (timestamp + resampler->highWaterMark < (double) dumped && !mAudioBufferFull(destination)) {
		unsigned channel;
		for (channel = 0; channel < channels; ++channel) {
			window.channel = channel;
			samples[channel] = interp->interpolate(interp, &data, timestamp, timestep);
		}
		if (!mAudioBufferWrite(destination, samples, 1)) {
			break;
		}
		timestamp += timestep;
	}
	if (resampler->consume && timestamp > resampler->lowWaterMark) {
		size_t drop = timestamp - resampler->lowWaterMark;
		drop = mAudioBufferRead(source, NULL, drop);
		timestamp -= drop;
	}
	resampler->timestamp = timestamp;
}

/* Frame rate of the emulated console, or the nominal fallback when unknown. */
static double audioNativeFps(const struct MgbaMobile* emu) {
	if (!emu || !emu->core) {
		return MOBILE_AUDIO_PACE_FPS;
	}
	uint32_t frequency = emu->core->frequency(emu->core);
	uint32_t frameCycles = emu->core->frameCycles(emu->core);
	if (!frequency || !frameCycles) {
		return MOBILE_AUDIO_PACE_FPS;
	}
	return (double) frequency / (double) frameCycles;
}

/*
 * Reads audio converted to the output rate set by mgbaMobileSetAudioOutput.
 *
 * speed is how many emulated frames the front end runs per paced frame (the
 * fast-forward factor) and drift is a small ratio adjustment (about +/-0.02)
 * the front end derives from its playback buffer level: positive drift makes
 * the resampler consume the core stream slightly faster, which drains the
 * output buffer, negative drift refills it. This is the standard dynamic rate
 * control used by mGBA's other front ends, and it keeps the audio clock locked
 * to the audio device without ever dropping samples.
 *
 * Falls back to raw core-rate audio when no output rate was configured.
 */
int mgbaMobileReadAudioOut(struct MgbaMobile* emu, int16_t* out, int maxFrames, double speed, float drift) {
	if (!emu || !emu->core || !out || maxFrames <= 0) {
		return 0;
	}
	if (!emu->audioResamplerInited) {
		return mgbaMobileReadAudio(emu, out, maxFrames);
	}
	struct mAudioBuffer* source = emu->core->getAudioBuffer(emu->core);
	unsigned coreRate = emu->core->audioSampleRate(emu->core);
	if (!source || !coreRate) {
		return 0;
	}
	if (speed < 0.05) {
		speed = 0.05;
	} else if (speed > 64) {
		speed = 64;
	}
	if (drift > 0.05f) {
		drift = 0.05f;
	} else if (drift < -0.05f) {
		drift = -0.05f;
	}
	double pace;
	if (emu->audioPaceFps > 0.0) {
		pace = emu->audioPaceFps;
	} else if (emu->audioPaceThroughput > 0.0) {
		// A speed change just cleared the estimate: seed from the throughput
		// the device last demonstrated (measured at the previous speed), not
		// from the console's nominal rate. Overestimating starves the stream
		// into gaps; underestimating only sheds samples at the core's ring.
		//
		// 不变速 is the exception: it reads the stretched output at the
		// console's own rate no matter how fast the game runs, so a throughput
		// remembered from 4x/16x tape playback would seed the resampler four to
		// sixteen times too fast - it would eat the staging buffer instantly
		// and the music would come out as short, pitched-up scraps for the
		// first second after the toggle, until a fresh reading locked it.
		pace = emu->audioHoldOn ? audioNativeFps(emu) : emu->audioPaceThroughput / speed;
		double nominal = audioNativeFps(emu);
		if (pace > nominal) {
			pace = nominal;
		}
		if (pace < MOBILE_AUDIO_PACE_FPS_MIN) {
			pace = MOBILE_AUDIO_PACE_FPS_MIN;
		}
	} else {
		pace = audioNativeFps(emu);
	}
	emu->audioPaceSpeed = speed;
	double fpsRatio = mCoreCalculateFramerateRatio(emu->core, pace);
	if (fpsRatio <= 0.1 || fpsRatio > 20.0) {
		// Unknown frame timing (should not happen): assume the front end paces
		// audio at the console's own frame rate.
		fpsRatio = 1.0;
	}
	/* In 音乐原速 the staged audio is already at the console's own rate: the
	 * stretching happened upstream, and the source no longer tracks how fast
	 * the game is running. So it is consumed one for one, whatever the
	 * multiplier or the front end's frame rate. Dividing by fpsRatio here (as
	 * the pass-through path must, because there the source really does run
	 * faster than real time) is what made 16x come out at a quarter speed on a
	 * device that cannot reach 16x: the ratio said 4x, so the music was
	 * stretched 4x longer. */
	size_t held = 0;
	if (emu->audioHoldOn) {
		// Fast-forward audio, produced on the emulation/audio thread, which owns
		// every staging buffer; the UI only ever sets audioHoldOn /
		// wsolaStretch / audioHoldMode / wsolaClearPending (see
		// mgbaMobileSetAudioConstantPitch).
		initAudioHold(emu, coreRate, emu->wsolaStretch);
		if (emu->audioHoldInited) {
			if (emu->wsolaClearPending) {
				// A toggle happened since last time: drop anything staged under
				// the previous speed/mode so a re-enable never replays it.
			mAudioBufferClear(&emu->audioHold);
			mAudioBufferClear(&emu->wsolaIn);
			emu->wsolaAnaPos = 0;
			emu->natW = emu->natR;          /* discard whatever is staged */
			emu->natPrimed = 0;
			emu->natOutAcc = 0.0;
			emu->natLastTime = 0.0;
			emu->natLagDrops = 0;
			emu->wsolaClearPending = false;
			}
			if (emu->audioHoldMode == MOBILE_AUDIO_HOLD_NATIVE) {
				held = nativeHoldGenerate(emu, source, (size_t) maxFrames);
			} else {
				wsolaFeed(emu, source);
				held = wsolaGenerate(emu, (size_t) maxFrames);
			}
			source = &emu->audioHold;
		}
	}

	/* DIAGNOSTIC (remove after fix): while fast-forwarding, report whether the
	 * 1x hold is actually engaged. holdOn=0 means the enable call never reached
	 * here (engagement bug); holdInited=0 means the hold failed to allocate and
	 * the pass-through fast path runs instead. */
	if (speed > 1.01) {
		if ((emu->diagTick++ % 60) == 1) {
			MOBILE_LOGI("audio diag: speed %.1f holdOn %d holdInited %d mode %s natRing %p",
					speed, emu->audioHoldOn, emu->audioHoldInited,
					emu->audioHoldMode == MOBILE_AUDIO_HOLD_NATIVE ? "native" : "pitch",
					(void*) emu->natRing);
		}
	}

	double inRate;
	if (emu->audioHoldOn) {
		inRate = (double) coreRate * (1.0 + drift);
	} else {
		inRate = (double) coreRate * speed / fpsRatio * (1.0 + drift);
	}
	if (emu->audioHoldOn) {
		/* One line per second is enough to tell, from a device logcat, whether
		 * the stretcher is running, at what ratio, and whether it is keeping
		 * up: hold/in back up permanently means it is not draining, held = 0
		 * means it produced nothing for this read. */
		if ((emu->traceTick++ % 60) == 1) {
			MOBILE_LOGI("audio ff: mode %s stretch %.2f speed %.2f inRate %.0f coreRate %u held %zu hold %zu in %zu lagDrops %zu cuts %zu",
					emu->audioHoldMode == MOBILE_AUDIO_HOLD_NATIVE ? "native" : "pitch",
					emu->wsolaStretch, speed, inRate, coreRate, held,
					mAudioBufferAvailable(&emu->audioHold), mAudioBufferAvailable(&emu->wsolaIn),
					emu->natLagDrops, emu->natCuts);
		}
	}
	size_t got = mAudioBufferRead(&emu->audioOut, out, (size_t) maxFrames);
	mAudioResamplerSetSource(&emu->audioResampler, source, inRate, true);
	processAudioResampler(emu);
	if (got < (size_t) maxFrames) {
		got += mAudioBufferRead(&emu->audioOut, out + got * 2, (size_t) maxFrames - got);
	}
	return (int) got;
}

int mgbaMobileWidth(const struct MgbaMobile* emu) {
	return emu ? (int) emu->width : 0;
}

int mgbaMobileHeight(const struct MgbaMobile* emu) {
	return emu ? (int) emu->height : 0;
}

int mgbaMobileSampleRate(const struct MgbaMobile* emu) {
	if (!emu || !emu->core) {
		return 0;
	}
	return (int) emu->core->audioSampleRate(emu->core);
}

/*
 * Length of one emulated frame in nanoseconds. Front ends pace their frame
 * slices with this so the game and its audio run at the console's own speed
 * (about 59.73 fps for GBA and GB) instead of a rounded 60, which would play
 * everything slightly fast and sharp. 0 when no console is loaded or its frame
 * timing is unknown.
 */
int64_t mgbaMobileFrameNanos(const struct MgbaMobile* emu) {
	if (!emu || !emu->core) {
		return 0;
	}
	uint32_t frequency = emu->core->frequency(emu->core);
	uint32_t frameCycles = emu->core->frameCycles(emu->core);
	if (!frequency || !frameCycles) {
		return 0;
	}
	return ((int64_t) frameCycles * 1000000000 + frequency / 2) / frequency;
}

bool mgbaMobileCopyVideo(struct MgbaMobile* emu, uint32_t* pixels, int stride) {
	if (!emu || !emu->video || !pixels || stride < (int) emu->width || emu->width == 0 || emu->height == 0) {
		return false;
	}
	size_t pixelsN = (size_t) emu->width * emu->height;
	bool blend = emu->interframe && emu->havePrev && emu->prev;
	unsigned y;
	for (y = 0; y < emu->height; ++y) {
		uint32_t* dst = pixels + y * stride;
		const mColor* src = emu->video + y * emu->width;
		uint32_t* old = blend ? emu->prev + y * emu->width : NULL;
		unsigned x;
		for (x = 0; x < emu->width; ++x) {
			uint32_t cur = ((uint32_t) src[x]) | 0xFF000000u;
			if (old) {
				uint32_t prev = old[x];
				uint32_t r = ((cur & 0xFFu) + (prev & 0xFFu)) >> 1;
				uint32_t g = (((cur >> 8) & 0xFFu) + ((prev >> 8) & 0xFFu)) >> 1;
				uint32_t b = (((cur >> 16) & 0xFFu) + ((prev >> 16) & 0xFFu)) >> 1;
				cur = 0xFF000000u | (b << 16) | (g << 8) | r;
			}
			dst[x] = cur;
		}
	}
	if (emu->interframe) {
		if (!emu->prev) {
			emu->prev = (uint32_t*) calloc(pixelsN, sizeof(uint32_t));
		}
		if (emu->prev) {
			for (y = 0; y < emu->height; ++y) {
				memcpy(emu->prev + y * emu->width, pixels + y * stride, emu->width * sizeof(uint32_t));
			}
			emu->havePrev = true;
		}
	} else {
		emu->havePrev = false;
	}
	return true;
}

bool mgbaMobileSaveState(struct MgbaMobile* emu, int slot) {
	// Slot 0 is reserved for the front end's automatic save-on-exit.
	if (!emu || !emu->core || slot < 0 || slot > 9) {
		return false;
	}
	if (emu->fast > 0) {
		setFastAudio(emu, 0);
	}
	applyFrameskip(emu->core, 0);
	bool ok = mCoreSaveState(emu->core, slot, SAVESTATE_SCREENSHOT | SAVESTATE_SAVEDATA | SAVESTATE_RTC | SAVESTATE_METADATA);
	emu->fast = -1;
	MOBILE_LOGI("State slot %d %s", slot, ok ? "saved" : "failed");
	return ok;
}

bool mgbaMobileLoadState(struct MgbaMobile* emu, int slot) {
	if (!emu || !emu->core || slot < 0 || slot > 9) {
		return false;
	}
	bool ok = mCoreLoadState(emu->core, slot, SAVESTATE_SCREENSHOT | SAVESTATE_SAVEDATA | SAVESTATE_RTC);
	if (ok) {
		applyFrameskip(emu->core, 0);
		ensureVideo(emu);
		emu->fast = -1;
		attachKeyCallback(emu);
	}
	MOBILE_LOGI("State slot %d %s", slot, ok ? "loaded" : "missing");
	return ok;
}

/* 快照的实现体。调用方必须已持有核心锁。 */
static bool mobileSaveStateLocked(struct MgbaMobile* emu, void** out, size_t* outSize) {
	if (!emu || !emu->core || !out || !outSize) {
		return false;
	}
	*out = NULL;
	*outSize = 0;
	struct VFile* vf = VFileMemChunk(NULL, 0);
	if (!vf) {
		return false;
	}
	if (emu->fast > 0) {
		setFastAudio(emu, 0);
	}
	applyFrameskip(emu->core, 0);
	bool ok = mCoreSaveStateNamed(emu->core, vf,
	                              SAVESTATE_SAVEDATA | SAVESTATE_RTC | SAVESTATE_METADATA);
	emu->fast = -1;
	if (ok) {
		ssize_t size = vf->size(vf);
		if (size > 0) {
			void* buffer = malloc((size_t) size);
			if (!buffer) {
				ok = false;
			} else if (vf->seek(vf, 0, SEEK_SET) != 0
			           || vf->read(vf, buffer, (size_t) size) != size) {
				free(buffer);
				ok = false;
			} else {
				*out = buffer;
				*outSize = (size_t) size;
			}
		} else {
			ok = false;
		}
	}
	vf->close(vf);
	return ok;
}

bool mgbaMobileSaveStateToMemory(struct MgbaMobile* emu, void** out, size_t* outSize) {
	if (!emu || !emu->core || !out || !outSize) {
		return false;
	}
	/* 与 RunFrames 同一把核心锁：iOS 直接调 C 函数，不经 JNI。 */
	mgbaMobileLock(emu);
	bool ok = mobileSaveStateLocked(emu, out, outSize);
	mgbaMobileUnlock(emu);
	return ok;
}

/* 状态注入的实现体。调用方必须已持有核心锁。 */
static bool mobileLoadStateLocked(struct MgbaMobile* emu, const void* data, size_t size) {
	if (!emu || !emu->core || !data || size == 0) {
		return false;
	}
	struct VFile* vf = VFileFromConstMemory(data, size);
	if (!vf) {
		return false;
	}
	bool ok = mCoreLoadStateNamed(emu->core, vf, SAVESTATE_SAVEDATA | SAVESTATE_RTC);
	vf->close(vf);
	if (ok) {
		applyFrameskip(emu->core, 0);
		ensureVideo(emu);
		emu->fast = -1;
		attachKeyCallback(emu);
	}
	return ok;
}

bool mgbaMobileLoadStateFromMemory(struct MgbaMobile* emu, const void* data, size_t size) {
	if (!emu || !emu->core || !data || size == 0) {
		return false;
	}
	/* 这条路径的危险性最高：状态帧在 socket 读线程上到达，镜像核正在另一条
	 * 线程上 runFrame。没有这把锁就是「运行中换掉整个核心状态」。 */
	mgbaMobileLock(emu);
	bool ok = mobileLoadStateLocked(emu, data, size);
	mgbaMobileUnlock(emu);
	return ok;
}

void mgbaMobileFreeState(void* state) {
	free(state);
}

void mgbaMobileSetRewind(struct MgbaMobile* emu, bool enabled) {
	if (!emu) {
		return;
	}
	emu->rewindEnabled = enabled;
	if (!enabled) {
		emu->rewindCounter = 0;
	}
}

/*
 * Rewinds by about the given number of seconds of gameplay. The history is a
 * ring of differential states appended every REWIND_DIVIDER frames, so a
 * request goes back that many entries (clamped to what has been recorded).
 * Video buffers refresh on the next copyVideo call; the caller clears audio.
 */
bool mgbaMobileRewind(struct MgbaMobile* emu, int seconds) {
	if (!emu || !emu->core || !emu->rewindInited || seconds < 1) {
		return false;
	}
	unsigned count = (unsigned) seconds * 60 / REWIND_DIVIDER;
	if (count < 1) {
		count = 1;
	}
	bool ok = mCoreRewindRestore(&emu->rewind, emu->core, count);
	if (ok) {
		applyFrameskip(emu->core, 0);
		ensureVideo(emu);
		emu->fast = -1;
		attachKeyCallback(emu);
	}
	MOBILE_LOGI("Rewind %ds %s", seconds, ok ? "ok" : "empty");
	return ok;
}

void mgbaMobileReset(struct MgbaMobile* emu) {
	if (!emu || !emu->core) {
		return;
	}
	emu->core->reset(emu->core);
	ensureVideo(emu);
	attachKeyCallback(emu);
	pollLink(emu);
	MOBILE_LOGI("Core reset");
}

void mgbaMobileTitle(const struct MgbaMobile* emu, char* out, size_t outLen) {
	size_t i;
	if (!out || outLen == 0) {
		return;
	}
	out[0] = '\0';
	if (!emu || !emu->core) {
		return;
	}
	struct mGameInfo info;
	memset(&info, 0, sizeof(info));
	emu->core->getGameInfo(emu->core, &info);
	info.title[16] = '\0';
	for (i = 0; i + 1 < outLen && info.title[i]; ++i) {
		unsigned char c = (unsigned char) info.title[i];
		out[i] = (c >= 32 && c < 127) ? (char) c : ' ';
	}
	out[i] = '\0';
}

uint32_t mgbaMobileBusRead(const struct MgbaMobile* emu, int width, uint32_t address) {
	struct mCore* core;
	if (!emu || !emu->core || width <= 0) {
		return 0;
	}
	core = emu->core;
	switch (width) {
	case 16:
		return core->busRead16(core, address);
	case 32:
		return core->busRead32(core, address);
	default:
		return core->busRead8(core, address);
	}
}

bool mgbaMobileBusWrite(struct MgbaMobile* emu, int width, uint32_t address, uint32_t value) {
	struct mCore* core;
	if (!emu || !emu->core) {
		return false;
	}
	core = emu->core;
	switch (width) {
	case 16:
		core->busWrite16(core, address, (uint16_t) value);
		break;
	case 32:
		core->busWrite32(core, address, value);
		break;
	default:
		core->busWrite8(core, address, (uint8_t) value);
		break;
	}
	return true;
}

int mgbaMobileBusReadBlock(const struct MgbaMobile* emu, uint32_t address, int size, uint8_t* out) {
	struct mCore* core;
	int i;
	if (!emu || !emu->core || !out || size <= 0) {
		return 0;
	}
	if (size > 0x100000) {
		size = 0x100000;
	}
	core = emu->core;
	for (i = 0; i < size; ++i) {
		out[i] = (uint8_t) core->busRead8(core, address + i);
	}
	return size;
}

void mgbaMobileSetInterframe(struct MgbaMobile* emu, bool enabled) {
	if (!emu) {
		return;
	}
	emu->interframe = enabled ? 1 : 0;
	if (!emu->interframe) {
		emu->havePrev = false;
	}
}

void mgbaMobileSetFrameskip(struct MgbaMobile* emu, int skip) {
	if (!emu) {
		return;
	}
	if (skip < 0) {
		skip = 0;
	}
	if (skip > 9) {
		skip = 9;
	}
	emu->userSkip = skip;
}

void mgbaMobileSaveFile(const struct MgbaMobile* emu, char* out, size_t outLen) {
	if (!out || outLen == 0) {
		return;
	}
	out[0] = '\0';
	if (!emu || !emu->core || emu->savePath[0] == '\0' || emu->core->dirs.baseName[0] == '\0') {
		return;
	}
	snprintf(out, outLen, "%s/%s%s", emu->savePath, emu->core->dirs.baseName, emu->saveSuffix);
}

void mgbaMobilePumpLink(struct MgbaMobile* emu) {
	if (!emu || emu->lockstepSlot) {
		/* 锁步模式下 SIO 由协调器驱动，netLink 的 poll/service 会挂上自研
		 * gbaLink 驱动并把终端位改坏，必须完全旁路。 */
		return;
	}
	pollLink(emu);
	serviceLink(emu);
}

/* players：本局人数。2 走原来的两人直连；3/4 走星型总线（主机 accept 多个
 * 从机并汇聚每一轮的字）。 */
bool mgbaMobileLinkHost(struct MgbaMobile* emu, int port, int players) {
	if (!emu || !emu->link) {
		return false;
	}
	if (players < 2) {
		players = 2;
	}
	return netLinkBusHost(emu->link, port, players);
}

/* players 必须和主机一致：两边用不同的包格式连上去，TCP 层能连上但一个包
 * 都解不出来（总线用定长 BusPacket，两人直连用 struct Packet）。 */
bool mgbaMobileLinkJoin(struct MgbaMobile* emu, const char* host, int port, int players) {
	if (!emu || !emu->link || !host) {
		return false;
	}
	if (players > 2) {
		return netLinkBusJoin(emu->link, host, port);
	}
	return netLinkJoin(emu->link, host, port);
}

bool mgbaMobileLinkHostLocal(struct MgbaMobile* emu, int key, int players) {
	if (!emu || !emu->link) {
		return false;
	}
	if (players < 3) {
		players = 3;
	}
	return netLinkBusHostLocal(emu->link, key, players);
}

bool mgbaMobileLinkJoinLocal(struct MgbaMobile* emu, int key) {
	if (!emu || !emu->link) {
		return false;
	}
	return netLinkBusJoinLocal(emu->link, key);
}

bool mgbaMobileLinkJoinLocalSlot(struct MgbaMobile* emu, int key, int slot) {
	if (!emu || !emu->link) {
		return false;
	}
	return netLinkBusJoinLocalSlot(emu->link, key, slot);
}

bool mgbaMobileLinkHostLockstep(struct MgbaMobile* emu, int key, int players, int slot) {
	if (!emu || !emu->core || emu->lockstepSlot) {
		return false;
	}
	struct MgbaLockstepRoom* room = mgbaLockstepHost(key, players);
	if (!room) {
		return false;
	}
	struct MgbaLockstepSlot* ls = mgbaLockstepAttach(room, emu->core, slot);
	if (!ls) {
		mgbaLockstepRelease(room);
		return false;
	}
	emu->lockstepRoom = room;
	emu->lockstepSlot = ls;
	/* 自研 gbaLink 驱动与协调器互斥：linkAttached=false 让 attachLink 不再
	 * 尝试挂它；帧循环也会据此跳过 netLink 的 poll/service。 */
	emu->linkAttached = false;
	MOBILE_LOGI("Link LOCKSTEP host key=%d players=%d slot=%d", key, players, slot);
	return true;
}

bool mgbaMobileLinkJoinLockstep(struct MgbaMobile* emu, int key, int slot) {
	if (!emu || !emu->core || emu->lockstepSlot) {
		return false;
	}
	struct MgbaLockstepRoom* room = mgbaLockstepJoin(key);
	if (!room) {
		return false;
	}
	struct MgbaLockstepSlot* ls = mgbaLockstepAttach(room, emu->core, slot);
	if (!ls) {
		mgbaLockstepRelease(room);
		return false;
	}
	emu->lockstepRoom = room;
	emu->lockstepSlot = ls;
	emu->linkAttached = false;
	MOBILE_LOGI("Link LOCKSTEP join key=%d slot=%d", key, slot);
	return true;
}

bool mgbaMobileLinkIsLockstep(const struct MgbaMobile* emu) {
	return emu && emu->lockstepSlot != NULL;
}

void mgbaMobilePoke16(struct MgbaMobile* emu, uint32_t addr, uint16_t value) {
	if (!emu || !emu->core) {
		return;
	}
	struct GBA* gba = (struct GBA*) emu->core->board;
	int cc = 0;
	GBAStore16(gba->cpu, addr, (int16_t) value, &cc);
}

uint16_t mgbaMobilePeek16(struct MgbaMobile* emu, uint32_t addr) {
	if (!emu || !emu->core) {
		return 0;
	}
	struct GBA* gba = (struct GBA*) emu->core->board;
	return GBAView16(gba->cpu, addr);
}

	uint32_t mgbaMobileFrameCounter(const struct MgbaMobile* emu) {
	if (!emu || !emu->core) {
		return 0;
	}
	struct GBA* gba = (struct GBA*) emu->core->board;
	return gba->video.frameCounter;
}

/* 诊断：返回本核 CPU 当前 PC（gba->cpu->gprs[15]）。仅测试用，用来确认
 * 冻结是否真的把 CPU 拽到了 IWRAM 循环里。 */
uint32_t mgbaMobileCpuPc(struct MgbaMobile* emu) {
	if (!emu || !emu->core) {
		return 0;
	}
	struct GBA* gba = (struct GBA*) emu->core->board;
	return (uint32_t) gba->cpu->gprs[15];
}

/* 测试钩子：开启后锁步多玩家传输直接注入 0x1000+playerId 作为发送字，
 * 绕开真实游戏对 SIOMLT_SEND 的改写，得到确定性传输用于验证收集/广播。
 * 仅测试使用，必须在跑锁步集成测试前打开、跑完关闭。 */
void mgbaMobileSioSetInject(bool inject) {
	GBASIOLockstepSetTestInject(inject);
}

void mgbaMobileLinkClose(struct MgbaMobile* emu) {
	if (!emu) {
		return;
	}
	if (emu->lockstepSlot) {
		MOBILE_LOGI("Link LOCKSTEP close");
		mgbaLockstepDetach(emu->lockstepSlot);
		emu->lockstepSlot = NULL;
		if (emu->lockstepRoom) {
			mgbaLockstepRelease(emu->lockstepRoom);
			emu->lockstepRoom = NULL;
		}
		return;
	}
	if (!emu->link) {
		return;
	}
	MOBILE_LOGI("Link close requested by app (state=%d)", netLinkState(emu->link));
	netLinkClose(emu->link);
}

void mgbaMobileLinkStatus(const struct MgbaMobile* emu, char* out, size_t outLen) {
	if (!out || outLen == 0) {
		return;
	}
	out[0] = '\0';
	if (!emu) {
		return;
	}
	if (emu->lockstepSlot) {
		/* 上层（GBoyConsoleSet.connectedStatus）用首字符 '2' 判定已连接。
		 * 锁步模式不走 netLink，这里给出等价状态，Java 侧无需分支。 */
		snprintf(out, outLen, "2 lockstep slot=%d attached=%zu",
		         mgbaLockstepSlotId(emu->lockstepSlot),
		         mgbaLockstepAttached(emu->lockstepRoom));
		return;
	}
	if (emu->link) {
		netLinkStatusText(emu->link, out, outLen);
	}
}

int mgbaMobileResample(const int16_t* in, int inFrames, int inRate, int outRate, int16_t* out, int maxOutFrames, double* pos) {
	double cursor;
	double step;
	int outFrames = 0;
	if (!in || !out || !pos || inFrames <= 0 || inRate <= 0 || outRate <= 0 || maxOutFrames <= 0) {
		return 0;
	}
	cursor = *pos;
	step = (double) inRate / (double) outRate;
	while (cursor < inFrames && outFrames < maxOutFrames) {
		int i0 = (int) cursor;
		int i1;
		double frac;
		int l0;
		int r0;
		int l1;
		int r1;
		if (i0 < 0) {
			i0 = 0;
		}
		i1 = i0 + 1;
		if (i1 > inFrames - 1) {
			i1 = inFrames - 1;
		}
		frac = cursor - i0;
		l0 = in[i0 * 2];
		r0 = in[i0 * 2 + 1];
		l1 = in[i1 * 2];
		r1 = in[i1 * 2 + 1];
		out[outFrames * 2] = (int16_t) (l0 + (l1 - l0) * frac);
		out[outFrames * 2 + 1] = (int16_t) (r0 + (r1 - r0) * frac);
		outFrames++;
		cursor += step;
	}
	cursor -= inFrames;
	if (cursor < 0) {
		cursor = 0;
	}
	*pos = cursor;
	return outFrames;
}

void mgbaMobileBiosFileName(const char* name, long size, char* out, size_t outLen) {
	char lower[256];
	size_t i;
	const char* picked = "gb_bios.bin";
	if (!out || outLen == 0) {
		return;
	}
	lower[0] = '\0';
	if (name) {
		for (i = 0; i + 1 < sizeof(lower) && name[i]; ++i) {
			lower[i] = (char) tolower((unsigned char) name[i]);
		}
		lower[i] = '\0';
	}
	if (strstr(lower, "gba") || size == 16384) {
		picked = "gba_bios.bin";
	} else if (strstr(lower, "gbc") || strstr(lower, "cgb") || size == 2304) {
		picked = "gbc_bios.bin";
	} else if (strstr(lower, "sgb")) {
		picked = "sgb_bios.bin";
	}
	snprintf(out, outLen, "%s", picked);
}
