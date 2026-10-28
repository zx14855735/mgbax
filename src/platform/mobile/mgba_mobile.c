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
#include <mgba/internal/gba/savedata.h>
#include <mgba/internal/gb/gb.h>
#include <mgba/internal/gb/io.h>
#include <mgba-util/audio-buffer.h>
#include <mgba-util/audio-resampler.h>
#include <mgba-util/vfs.h>

#include "link_net.h"

#include <ctype.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/stat.h>
#include <math.h>

#ifdef __ANDROID__
#include <android/log.h>
#define MOBILE_LOGI(...) __android_log_print(ANDROID_LOG_INFO, "mGBA", __VA_ARGS__)
#define MOBILE_LOGE(...) __android_log_print(ANDROID_LOG_ERROR, "mGBA", __VA_ARGS__)
#else
#define MOBILE_LOGI(...) ((void) 0)
#define MOBILE_LOGE(...) ((void) 0)
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
	char port[32];
	int fast;
	struct NetLink* link;
	struct GbaLinkDriver gbaLink;
	struct GbLinkDriver gbLink;
	struct mTimingEvent linkEvent;
	bool linkAttached;
	/* 一次 MULTI 传输的挂起状态：发起时把本帧数据发出去，传输应当结束的时刻
	 * 再取回对端应答。中途不阻塞模拟线程，否则每次传输都要吃掉半帧到几十
	 * 毫秒，游戏内的联机握手会直接超时。 */
	struct mTimingEvent sioDone;
	bool sioWaiting;
	uint16_t sioSeq;
	int sioRetries;
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
	/* 从机用：下一轮要推的轮号。收尾之后隔一次轮询才推，中间这段时间正好让
	 * 游戏的 SIO 中断处理把本轮真正要发的字写进 SIOMLT_SEND。 */
	uint16_t sioPushPending;
	/* 取到的对端轮次和本机期望的不一致（丢了一轮）的次数。 */
	uint32_t sioMisorder;
	/* 联机排查：逐轮打印（有上限，不会刷爆 logcat）。 */
	uint32_t xferDbg;
	uint32_t pushDbg;
	uint32_t toDbg;
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
	bool audioHoldOn;
	bool audioHoldInited;
	/* Set by the UI thread on every toggle; the audio thread clears the staged
	 * audio once before the next WSOLA run so a re-enable never replays stale
	 * samples. Kept as a flag so the UI thread never touches the buffers. */
	bool wsolaClearPending;
	/* Last three raw window readings; the middle one feeds the estimator. A
	 * free-running front end's window readings scatter with a heavy tail
	 * (scheduler jitter shows up as one window running several percent off),
	 * and a median strips those single-window spikes without adding lag. */
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

static void attachKeyCallback(struct MgbaMobile* emu);
static void detachLink(struct MgbaMobile* emu);
static void pollLink(struct MgbaMobile* emu);
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
	emu->wsolaAcc = NULL;
	emu->wsolaEmit = NULL;
	emu->wsolaPrev = NULL;
	emu->wsolaWindow = NULL;
	emu->wsolaScratch = NULL;
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
	if (!emu->wsolaAcc || !emu->wsolaEmit || !emu->wsolaPrev || !emu->wsolaWindow || !emu->wsolaScratch) {
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
	copyPath(emu->savePath, sizeof(emu->savePath), saveDir);
	copyPath(emu->statePath, sizeof(emu->statePath), stateDir);
	copyPath(emu->port, sizeof(emu->port), port && port[0] ? port : "mobile");
	if (emu->savePath[0]) {
		mobile_mkdir(emu->savePath);
	}
	if (emu->statePath[0]) {
		mobile_mkdir(emu->statePath);
	}
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
	destroyCore(emu);
	deinitAudioOutput(emu);
	netLinkDestroy(emu->link);
	emu->link = NULL;
	free(emu);
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
	mCoreAutoloadSave(core);
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

static uint32_t beginFrameKeys(struct MgbaMobile* emu) {
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

/* 联机排查用的游戏内存窥探（只在开着 MGBA_LINK_PEEK 时编译进去）。
 * 地址来自 ROM 工程的 rom.map（pokeemerald 系布局）。 */
#ifndef MGBA_LINK_PEEK
#define MGBA_LINK_PEEK 1
#endif

#if MGBA_LINK_PEEK
#define PEEK_LINK_STATUS 0x03002A90u
#define PEEK_LINK_STATE  0x03002ACCu
#define PEEK_LINK        0x03002AE8u
#endif

static void serviceLink(struct MgbaMobile* emu) {
	if (!emu->linkAttached || !emu->link) {
		return;
	}
	/* 让 IO 线程随时能拿到本机当前要发的字节：对端发请求时它直接回，不必等
	 * 模拟线程排到。 */
	uint16_t localMode = 0;
	uint32_t local = readLinkOut(emu, &localMode);
	netLinkPublish(emu->link, localMode, local);
	/* MULTI 的发送是「一轮一次、两边各推各的」，不再为每个往返等一条 ACK
	 * （原来每轮要等 ACK，实测 16ms/轮，握手要跑上万轮，游戏最后报「连接
	 * 发生了错误」）。1P 在写 SIOCNT 起传输那一刻推，2P 在收尾之后的下一
	 * 次轮询推 —— 两边的时机差别见下面各自的注释，这是本文件最容易错位
	 * 一格的地方。 */
	if (emu->core && emu->core->platform(emu->core) == mPLATFORM_GBA) {
		struct GBA* gba = (struct GBA*) emu->core->board;
		int player = netLinkPlayer(emu->link);
		if (gba->sio.mode == GBA_SIO_MULTI && player != 0) {
			/* 从机推字的时机是本文件里最容易踩错的一处。
			 *
			 * 真机里从机不产生时钟，它本轮发什么，取决于主的时钟扫过来那一
			 * 瞬间 SIOMLT_SEND 里是什么。而在 gen8 里，SIOMLT_SEND 是在 SIO
			 * 中断处理（DoSend）里写的 —— 也就是说，第 R 轮的字要等第 R-1 轮
			 * 收尾、中断处理跑完之后才存在。
			 *
			 * 所以：收尾的那一次轮询里绝对不能推（那时中断还没跑，SIOMLT_SEND
			 * 还是上一轮的值），必须等下一次轮询再推。这里就是「下一次」：
			 * 收尾时把轮号记进 sioPushPending，下一轮轮询到这儿才真正发出去。
			 * 早一步推旧值，对端就会把上一轮的数据当成这一轮，握手能过、
			 * checksum 必挂。 */
			if (!emu->sioPushed && !emu->sioPushPending) {
				/* 第一次进入 MULTI：第 1 轮的字就是此刻 SIOMLT_SEND 里的值
				 * （游戏初始化时写的 0），和真机一致。 */
				emu->sioPushPending = 1;
			}
			if (emu->sioPushPending) {
				uint16_t round = emu->sioPushPending;
				emu->sioPushPending = 0;
				netLinkPush(emu->link, GBA_SIO_MULTI, local, round);
				if (emu->pushDbg < 80) {
					++emu->pushDbg;
					MOBILE_LOGI("PUSH #%u me=%d idx=%u val=%04X",
					            emu->pushDbg, player, (unsigned) round, (unsigned) local);
				}
				emu->sioPushValue = local;
				emu->sioPushIndex = round;
				emu->sioPushed = true;
			}
		}
		/* 从机不自己起传输：真机里 MULTI 的时钟是 1P 产生的，从机只是在自己的
		 * SIO 被时钟扫过时收尾。1P 每轮开始时把本轮的字推过来，收到就把这次
		 * 传输收掉（写 SIOMULTI + 发 SIO 中断），从机自己的游戏才会往下走。 */
		if (gba->sio.mode == GBA_SIO_MULTI && player != 0 && !emu->sioWaiting) {
			uint16_t want = (uint16_t) (emu->sioIndex + 1);
			uint16_t got = 0;
			uint32_t remote = 0;
			if (netLinkTakePeerWord(emu->link, want, 0, &remote, &got)) {
				if (got != want) {
					/* 中间丢了一轮（对端超时收尾过），轮次已经对不上，但接着跑
					 * 比卡死强：游戏自己会靠 checksum 发现并断开重来。 */
					++emu->sioMisorder;
					if (emu->sioMisorder < 8) {
						MOBILE_LOGI("SIO 轮次错位 me=%d want=%u got=%u n=%u",
						            player, (unsigned) want, (unsigned) got, emu->sioMisorder);
					}
				}
				emu->sioIndex = want;
				emu->sioHasRemote = true;
				emu->sioRemote = remote;
				/* 本轮收尾之后游戏才会写下一轮的字，所以下一轮的推送留到
				 * 下一次轮询，见上面的 PUSH 分支。 */
				emu->sioPushPending = (uint16_t) (emu->sioIndex + 1);
				completeMultiTransfer(emu, remote, true, 0);
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
	/* 看门狗：从机 Busy 立起来后如果主机迟迟不发这一轮的字（主机卡住、或者
	 * 已经掉线），5 帧之后按「没有对端数据」收尾，让游戏自己报通信错误，
	 * 而不是永久卡在 Busy 上。同样不用旧值。 */
	if (!emu->sioWaiting && netLinkPlayer(emu->link) != 0 &&
	    emu->core && emu->core->platform(emu->core) == mPLATFORM_GBA) {
		struct GBA* gba = (struct GBA*) emu->core->board;
		struct mTiming* timing = coreTiming(emu);
		if (gba->sio.mode == GBA_SIO_MULTI && (gba->sio.siocnt & 0x0080) && timing && emu->sioBusyCycle) {
			uint32_t now = mTimingCurrentTime(timing);
			if (now - emu->sioBusyCycle > 5 * 280896) {
				emu->sioBusyCycle = now;
				emu->sioTimeouts++;
				completeMultiTransfer(emu, 0, false, 0);
			}
		}
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
	if (emu->xferDbg < 150) {
		++emu->xferDbg;
		MOBILE_LOGI("XFER #%u me=%d idx=%u own=%04X peer=%04X have=%d to=%u",
		            emu->xferDbg, me, (unsigned) emu->sioIndex,
		            (unsigned) (me >= 0 && me < 4 ? data[me] : 0),
		            (unsigned) (haveRemote ? remote : 0xDEADu), haveRemote ? 1 : 0,
		            emu->sioTimeouts);
	}
	if ((emu->sioOk & 0x3F) == 0) {
		mLOG(GBA_SIO, INFO, "SIO multi me=%d ok=%u last=%u.%ums peak=%u.%ums retry=%d to=%u fb=%u m0=%04X m1=%04X",
		     me, emu->sioOk, emu->sioLateness / 10, emu->sioLateness % 10,
		     emu->sioPeak / 10, emu->sioPeak % 10, emu->sioRetries, emu->sioTimeouts, emu->sioFallback, data[0], data[1]);
		MOBILE_LOGI("SIO multi me=%d ok=%u last=%u.%ums peak=%u.%ums retry=%d to=%u fb=%u m0=%04X m1=%04X",
		     me, emu->sioOk, emu->sioLateness / 10, emu->sioLateness % 10,
		     emu->sioPeak / 10, emu->sioPeak % 10, emu->sioRetries, emu->sioTimeouts, emu->sioFallback, data[0], data[1]);
	}
	GBASIOMultiplayerFinishTransfer(&gba->sio, data, cyclesLate);
}

/**
 * 传输应到期的时刻：对端应答已经在手上就地完成，否则隔一小段模拟时间再看，
 * 绝不把模拟线程挂在这里等网络。对端掉线时按超时收尾，游戏自己会报通信错误
 * 而不是永久卡在 Busy。
 */
static void sioDoneEvent(struct mTiming* timing, void* user, uint32_t cyclesLate) {
	struct MgbaMobile* emu = (struct MgbaMobile*) user;
	if (!emu->sioWaiting) {
		return;
	}
	uint32_t remote = 0;
	uint16_t got = 0;
	/* 真的阻塞等待：睡的是真实时间，模拟时钟冻在这里，所以一帧内的传输次数
	 * 还是真机的量级。游戏的 LAG 判定就是数“每帧有几个 SIO 中断”（1P 那边
	 * 少于 9 个就报 LAG_MASTER），一用模拟时间空转去等一个 16ms 的往返，
	 * 一帧就只剩下一次传输，必然被判掉线。 */
	bool haveRemote = emu->link && netLinkTakePeerWord(emu->link, emu->sioIndex, 400, &remote, &got);
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
	armLinkEvent(emu);
	return true;
}

static void gbaLinkDeinit(struct GBASIODriver* driver) {
	struct MgbaMobile* emu = ((struct GbaLinkDriver*) driver)->emu;
	struct mTiming* timing = coreTiming(emu);
	emu->sioWaiting = false;
	if (timing) {
		mTimingDeschedule(timing, &emu->linkEvent);
		mTimingDeschedule(timing, &emu->sioDone);
	}
}

static void gbaLinkReset(struct GBASIODriver* driver) {
	struct MgbaMobile* emu = ((struct GbaLinkDriver*) driver)->emu;
	emu->sioWaiting = false;
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
	UNUSED(driver);
	/* 与 gbp.c 的语义一致：连着的“对端”数量（不含自己）。两边 2 人联机
	 * 时这里是 1，内核才会用 2P 的传输周期；填 2 会按 3P 算，每次传输
	 * 比真机慢 50%，游戏的超时窗口就对不上了。 */
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
		netLinkPush(emu->link, GBA_SIO_MULTI, local, emu->sioIndex);
		emu->sioPushValue = local;
		emu->sioPushIndex = emu->sioIndex;
		emu->sioPushed = true;
	}
	mTimingDeschedule(timing, &emu->sioDone);
	mTimingSchedule(timing, &emu->sioDone, GBASIOTransferCycles(GBA_SIO_MULTI, driver->p->siocnt, gbaLinkDevices(driver)));
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
		}
		uint16_t out = GBASIOMultiplayerFillReady(GBASIOMultiplayerClearError(value));
		/* 必须按“本机是不是 1P”明确改写 Slave 位（SIOCNT bit2）。
		 *
		 * 内核 GBASIOWriteSIOCNT 里 MULTI 分支是
		 *   value &= 0xFF83;  value = SetSlave(value, id || !connected);
		 *   value = SetId(value, id);  value |= sio->siocnt & 0x00FC;
		 * 最后那个 |= 把旧 siocnt 的 bit2..7 或回来，所以 Slave/Ready 位是
		 * 「粘」的：只要有一次置起来就再也清不掉。没挂联机驱动时 connected=0，
		 * 内核一律置 Slave=1；而宝可梦在进联机设施之前（开机 ResetSerial）
		 * 就已经写过 SIOCNT，Slave 从此永远是 1。
		 *
		 * 而宝可梦正是靠这一位分主从（link.c 的 CheckMasterOrSlave）：
		 *   terminals = *(vu32*)REG_ADDR_SIOCNT & (SIO_MULTI_SD | SIO_MULTI_SI);
		 *   isMaster = (terminals == SIO_MULTI_SD && localId == 0);
		 * SIO_MULTI_SD=0x0008(Ready)、SIO_MULTI_SI=0x0004(Slave)，即
		 * 「Slave=0 且 Ready=1」才是主机。Slave 粘在 1 时两边都认为自己是从机，
		 * 谁也不写 START(0x0080)，谁也收不到中断 —— 两端就一直停
		 * 在「请稍候」，这正是「大厅连上了、游戏里却联不上」的直接原因。 */
		if (emu->linkAttached && emu->link) {
			out = GBASIOMultiplayerSetSlave(out, netLinkPlayer(emu->link) != 0);
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
	if (emu->sioDbg < 60) {
		++emu->sioDbg;
		MOBILE_LOGI("SIO start (mode %d, id %d)", driver->p ? (int) driver->p->mode : -1,
		            netLinkPlayer(emu->link));
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
	netLinkExchange(emu->link, GBA_SIO_NORMAL_8, local, &remote, 800);
	return (uint8_t) remote;
}

static uint32_t gbaLinkFinish32(struct GBASIODriver* driver) {
	struct MgbaMobile* emu = ((struct GbaLinkDriver*) driver)->emu;
	struct GBA* gba = (struct GBA*) emu->core->board;
	uint32_t local = gba->memory.io[GBA_REG(SIODATA32_LO)] | ((uint32_t) gba->memory.io[GBA_REG(SIODATA32_HI)] << 16);
	uint32_t remote = 0xFFFFFFFFu;
	netLinkExchange(emu->link, GBA_SIO_NORMAL_32, local, &remote, 800);
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
		if (netLinkExchange(emu->link, 0, local, &remote, 800)) {
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
}

static void attachLink(struct MgbaMobile* emu) {
	if (!emu->core || emu->linkAttached || netLinkState(emu->link) != 2) {
		return;
	}
	if (emu->core->platform(emu->core) == mPLATFORM_GBA) {
		prepareGbaDriver(emu);
		GBASIOSetDriver(&((struct GBA*) emu->core->board)->sio, &emu->gbaLink.d);
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
		emu->sioPushPending = 0;
		emu->sioMisorder = 0;
		emu->sioHasRemote = false;
		emu->sioEvtDbg = 0;
		emu->sioTakeDbg = 0;
		emu->sioInDbg = 0;
		emu->sioSkipDbg = 0;
		emu->sioSlaveDoneDbg = 0;
		MOBILE_LOGI("Link attached as P%d", netLinkPlayer(emu->link) + 1);
	}
}

static void pollLink(struct MgbaMobile* emu) {
	if (!emu->link) {
		return;
	}
	bool up = netLinkState(emu->link) == 2;
	if (up && !emu->linkAttached) {
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

bool mgbaMobileRunFrames(struct MgbaMobile* emu, int count) {
	if (!emu || !emu->core) {
		return false;
	}
	if (count < 1) {
		count = 1;
	}
	pollLink(emu);
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
		/* 逐帧盯着握手推进的几个关键量，只在变化时打点：
		 * adv = gShouldAdvanceLinkState（游戏推进联机的旗标，LinkMain1 每帧会清零）
		 * hs  = gLink.handshakeAsMaster（为真时主机才会把 0x8FFF 写进 SIOMULTI0）
		 * st  = gLink.state / pc = gLink.playerCount
		 * m0/m1 = SIOMULTI0/1（主/从各自的握手字）
		 * 这几个量在一帧内就会被吃掉，靠降采样必然漏掉，所以必须逐帧比变化。 */
		{
			int adv = (int) GBAView8(g->cpu, PEEK_LINK_STATE);
			int hs  = (int) GBAView8(g->cpu, PEEK_LINK + 0x0E);
			int st  = (int) GBAView8(g->cpu, PEEK_LINK + 0x01);
			int pc  = (int) GBAView8(g->cpu, PEEK_LINK + 0x03);
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
				MOBILE_LOGI("ST %d->%d pc %d->%d adv=%d hs=%d m0=%04X m1=%04X me=%d",
				            emu->sioPrevLinkState, st, emu->sioPrevPc, pc, adv, hs, m0, m1,
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
		MOBILE_LOGI("PEEK st=%08X adv=%d link[m=%d st=%d id=%d pc=%d hs=%d err=%d ck=%d lag=%d sc=%d qf=%d]",
		            stNow,
		            (int) GBAView8(g->cpu, PEEK_LINK_STATE),
		            (int) GBAView8(g->cpu, PEEK_LINK + 0x00),
		            (int) GBAView8(g->cpu, PEEK_LINK + 0x01),
		            (int) GBAView8(g->cpu, PEEK_LINK + 0x02),
		            (int) GBAView8(g->cpu, PEEK_LINK + 0x03),
		            (int) GBAView8(g->cpu, PEEK_LINK + 0x0E),
		            (int) GBAView8(g->cpu, PEEK_LINK + 0x10),
		            (int) GBAView8(g->cpu, PEEK_LINK + 0x11),
		            (int) GBAView8(g->cpu, PEEK_LINK + 0x13),
		            (int) GBAView8(g->cpu, PEEK_LINK + 0x0D),
		            (int) GBAView8(g->cpu, PEEK_LINK + 0x12));
#endif
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
	if (count == 1 && emu->link && netLinkState(emu->link) == 2) {
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
		emu->core->runFrame(emu->core);
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
	 */
	emu->wsolaStretch = stretch;
	emu->wsolaClearPending = true;
	emu->audioHoldOn = on;
	if (emu->audioResamplerInited) {
		emu->audioResampler.timestamp = 0;
	}
}

size_t mgbaMobileWsolaDropped(const struct MgbaMobile* emu) {
	return emu ? emu->wsolaDropped : 0;
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
/* Middle value of three readings. */
static double median3(double x, double y, double z) {
	double t;
	if (x > y) {
		t = x;
		x = y;
		y = t;
	}
	if (y > z) {
		t = y;
		y = z;
		z = t;
	}
	if (x > y) {
		t = x;
		x = y;
		y = t;
	}
	return y;
}

void mgbaMobileSetAudioPaceFps(struct MgbaMobile* emu, double fps) {
	if (!emu || !(fps > 0.0)) {
		return;
	}
	if (fps < MOBILE_AUDIO_PACE_FPS_MIN) {
		fps = MOBILE_AUDIO_PACE_FPS_MIN;
	} else if (fps > MOBILE_AUDIO_PACE_FPS_MAX) {
		fps = MOBILE_AUDIO_PACE_FPS_MAX;
	}
	if (emu->audioPaceHistLen < 3) {
		emu->audioPaceHist[emu->audioPaceHistLen++] = fps;
	} else {
		emu->audioPaceHist[0] = emu->audioPaceHist[1];
		emu->audioPaceHist[1] = emu->audioPaceHist[2];
		emu->audioPaceHist[2] = fps;
	}
	double reading = emu->audioPaceHistLen < 3
			? fps
			: median3(emu->audioPaceHist[0], emu->audioPaceHist[1], emu->audioPaceHist[2]);
	if (emu->audioPaceFps <= 0.0) {
		// First reading after a reset: lock at once so the resampler stops
		// running at the seeded rate.
		emu->audioPaceFps = reading;
		emu->audioPaceOutliers = 0;
		emu->audioPaceThroughput = fmax(emu->audioPaceThroughput * MOBILE_AUDIO_PACE_THROUGHPUT_DECAY,
				emu->audioPaceFps * emu->audioPaceSpeed);
		return;
	}
	double delta = reading > emu->audioPaceFps ? reading - emu->audioPaceFps : emu->audioPaceFps - reading;
	if (delta > emu->audioPaceFps * MOBILE_AUDIO_PACE_OUTLIER) {
		// One window can be a stall, not the pacing rate: wait for the next
		// window to agree before moving the stream.
		if (++emu->audioPaceOutliers >= 2) {
			emu->audioPaceFps = reading;
			emu->audioPaceOutliers = 0;
			emu->audioPaceThroughput = fmax(emu->audioPaceThroughput * MOBILE_AUDIO_PACE_THROUGHPUT_DECAY,
					emu->audioPaceFps * emu->audioPaceSpeed);
		}
		return;
	}
	emu->audioPaceOutliers = 0;
	double share = reading < emu->audioPaceFps ? MOBILE_AUDIO_PACE_EMA_DOWN : MOBILE_AUDIO_PACE_EMA_UP;
	emu->audioPaceFps += (reading - emu->audioPaceFps) * share;
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
	if (emu->audioHoldOn) {
		// Time-stretch the surplus with WSOLA so the music stays continuous and
		// at its own pitch, then resample the stretched output at the console
		// rate. No section is ever dropped, so the tune never jumps.
		//
		// This runs on the emulation/audio thread, which owns every WSOLA
		// buffer; the UI only ever sets audioHoldOn / wsolaStretch /
		// wsolaClearPending (see mgbaMobileSetAudioConstantPitch).
		initAudioHold(emu, coreRate, emu->wsolaStretch);
		if (emu->audioHoldInited) {
			if (emu->wsolaClearPending) {
				// A toggle happened since last time: drop anything staged under
				// the previous speed/mode so a re-enable never replays it.
				mAudioBufferClear(&emu->audioHold);
				mAudioBufferClear(&emu->wsolaIn);
				emu->wsolaAnaPos = 0;
				emu->wsolaClearPending = false;
			}
			wsolaFeed(emu, source);
			wsolaGenerate(emu, (size_t) maxFrames);
			source = &emu->audioHold;
		}
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
		pace = emu->audioPaceThroughput / speed;
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
	double inRate = (double) coreRate * speed / fpsRatio * (1.0 + drift);
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
	snprintf(out, outLen, "%s/%s.sav", emu->savePath, emu->core->dirs.baseName);
}

void mgbaMobilePumpLink(struct MgbaMobile* emu) {
	if (!emu) {
		return;
	}
	pollLink(emu);
	serviceLink(emu);
}

bool mgbaMobileLinkHost(struct MgbaMobile* emu, int port) {
	if (!emu || !emu->link) {
		return false;
	}
	return netLinkHost(emu->link, port);
}

bool mgbaMobileLinkJoin(struct MgbaMobile* emu, const char* host, int port) {
	if (!emu || !emu->link || !host) {
		return false;
	}
	return netLinkJoin(emu->link, host, port);
}

void mgbaMobileLinkClose(struct MgbaMobile* emu) {
	if (!emu || !emu->link) {
		return;
	}
	netLinkClose(emu->link);
}

void mgbaMobileLinkStatus(const struct MgbaMobile* emu, char* out, size_t outLen) {
	if (!out || outLen == 0) {
		return;
	}
	out[0] = '\0';
	if (emu && emu->link) {
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
