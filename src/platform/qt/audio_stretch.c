/* Copyright (c) 2013-2021 Jeffrey Pfau
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
/**
 * Fast-forward audio stretcher, extracted from the Android mobile layer
 * (mgba_mobile.c 音乐原速 engine) for the Qt port. The reasoning lives in
 * that file's comments; this port keeps the algorithms bit-for-bit:
 *
 *  - WSOLA time-stretch: synthesis hop fixed at 50% window overlap (clean
 *    Hann COLA, no comb-filter coloration), analysis hop scaled by the
 *    stretch, phase-locked to the last emitted samples with a small
 *    correlation search.
 *  - Native hold (音乐原速): sections play straight out of the core at 1x and
 *    the surplus accumulates in a lag ring; when the ring fills, one cut
 *    jumps the read pointer to the quietest stretch of the freshest audio
 *    (a gap between notes) and playback runs uninterrupted again.
 */
#include "audio_stretch.h"

#include <math.h>
#include <stdlib.h>
#include <string.h>

#ifdef _WIN32
#include <winsock2.h>
#include <ws2tcpip.h>
#else
#include <time.h>
#endif

#define STRETCH_WSOLA_N 1024           /* frame length, samples per channel */
#define STRETCH_WSOLA_IN_SECONDS 6     /* input queue length, seconds */
#define STRETCH_WSOLA_OUT_SECONDS 2    /* output staging buffer, seconds */
#define STRETCH_WSOLA_SCRATCH 4096

#define STRETCH_NATIVE_RING_SECONDS 6.0  /* max music lag behind the game */
#define STRETCH_NATIVE_SCAN_SECONDS 1.5
#define STRETCH_NATIVE_QUIET_SECONDS 0.010 /* quiet-window length */
#define STRETCH_NATIVE_RESERVE_SECONDS 0.10 /* unplayed frames kept past a cut */

static double stretchNow(void) {
#ifdef _WIN32
	return GetTickCount64() / 1000.0;
#else
	struct timespec ts;
	clock_gettime(CLOCK_MONOTONIC, &ts);
	return ts.tv_sec + ts.tv_nsec / 1e9;
#endif
}

void audioStretchInit(struct AudioStretch* s) {
	memset(s, 0, sizeof(*s));
	s->mode = AUDIO_STRETCH_PITCH;
}

static void deinitHold(struct AudioStretch* s) {
	if (!s->inited) {
		return;
	}
	mAudioBufferDeinit(&s->audioHold);
	mAudioBufferDeinit(&s->wsolaIn);
	free(s->wsolaAcc);
	free(s->wsolaEmit);
	free(s->wsolaPrev);
	free(s->wsolaWindow);
	free(s->wsolaScratch);
	free(s->natRing);
	s->wsolaAcc = NULL;
	s->wsolaEmit = NULL;
	s->wsolaPrev = NULL;
	s->wsolaWindow = NULL;
	s->wsolaScratch = NULL;
	s->natRing = NULL;
	s->inited = false;
}

void audioStretchDeinit(struct AudioStretch* s) {
	deinitHold(s);
}

void audioStretchSetMode(struct AudioStretch* s, int mode) {
	if (mode < AUDIO_STRETCH_OFF || mode > AUDIO_STRETCH_NATIVE) {
		mode = AUDIO_STRETCH_PITCH;
	}
	if (s->mode != mode) {
		s->mode = mode;
		s->clearPending = true;
	}
}

int audioStretchMode(const struct AudioStretch* s) {
	return s->mode;
}

void audioStretchReset(struct AudioStretch* s) {
	s->clearPending = true;
}

/*
 * (Re)configures the WSOLA time-stretcher for a given stretch factor. The
 * synthesis hop is held at a fixed 50% window overlap (clean Hann COLA) and
 * the analysis hop is scaled so the ratio analysis/synthesis equals the
 * stretch.
 */
static void initHold(struct AudioStretch* s, unsigned coreRate, double stretch) {
	/* Compare against what the buffers were actually built for - not against
	 * stretch itself, which would always match and never rebuild when the
	 * fast-forward speed changes. Rebuilding only ever happens here, on the
	 * audio thread, so the buffers are never freed under a running generate. */
	if (s->inited && fabs(stretch - s->configured) < 0.01 && s->coreRate == coreRate) {
		return;
	}
	deinitHold(s);
	if (!coreRate || stretch < 1.001) {
		return;
	}
	s->wsolaN = STRETCH_WSOLA_N;
	s->wsolaHs = s->wsolaN / 2;
	s->wsolaHa = (size_t) (s->wsolaN / 2.0 * stretch + 0.5);
	if (s->wsolaHs < 1) {
		s->wsolaHs = 1;
	}
	if (s->wsolaHa < 1) {
		s->wsolaHa = 1;
	}
	s->configured = stretch;
	s->coreRate = coreRate;
	s->wsolaAnaPos = 0;
	s->wsolaDropped = 0;
	s->natRingCap = (size_t) (coreRate * STRETCH_NATIVE_RING_SECONDS + 0.5);
	if (s->natRingCap < 2048) {
		s->natRingCap = 2048;
	}
	s->natW = 0;
	s->natR = 0;
	s->natPrimed = 0;
	s->natPrimedTarget = (size_t) (coreRate * 0.012 + 0.5); /* 12 ms fade-in */
	if (s->natPrimedTarget < 16) {
		s->natPrimedTarget = 16;
	}
	s->natLagDrops = 0;
	s->natCuts = 0;
	s->natOutAcc = 0.0;
	s->natLastTime = 0.0;
	mAudioBufferInit(&s->audioHold, (size_t) coreRate * STRETCH_WSOLA_OUT_SECONDS, 2);
	mAudioBufferInit(&s->wsolaIn, (size_t) coreRate * STRETCH_WSOLA_IN_SECONDS, 2);
	s->inited = true;
	s->wsolaAcc = (float*) calloc(s->wsolaN * 2, sizeof(float));
	s->wsolaEmit = (int16_t*) calloc(s->wsolaN * 2, sizeof(int16_t));
	s->wsolaPrev = (int16_t*) calloc(s->wsolaN * 2, sizeof(int16_t));
	s->wsolaWindow = (int16_t*) calloc(s->wsolaN * 2, sizeof(int16_t));
	s->wsolaScratch = (int16_t*) calloc(STRETCH_WSOLA_SCRATCH * 2, sizeof(int16_t));
	s->natRing = (int16_t*) calloc(s->natRingCap * 2, sizeof(int16_t));
	if (!s->wsolaAcc || !s->wsolaEmit || !s->wsolaPrev || !s->wsolaWindow || !s->wsolaScratch || !s->natRing) {
		/* Out of memory: fall back to the plain (non-stretched) path rather
		 * than dereferencing a NULL accumulator. */
		deinitHold(s);
		return;
	}
	size_t n2 = s->wsolaN * 2;
	/* Periodic Hann (denominator n2, not n2-1). At the 50% synthesis overlap
	 * w[j] + w[j + N] == 1 exactly, so the overlap-add is COLA-flat. */
	for (size_t i = 0; i < n2; ++i) {
		double w = 0.5 * (1.0 - cos(2.0 * 3.14159265358979323846 * i / n2));
		s->wsolaWindow[i] = (int16_t) (w * 32767.0);
	}
}

/* Parks everything the core just produced into the WSOLA input queue. */
static void wsolaFeed(struct AudioStretch* s, struct mAudioBuffer* source) {
	size_t available;
	size_t capacity = mAudioBufferCapacity(&s->wsolaIn);
	while ((available = mAudioBufferAvailable(source)) > 0) {
		/* Never read more than the parked queue can take: the samples are
		 * already out of the core's ring by then, so anything the write
		 * refuses would be lost mid-stream. Leaving them in the ring keeps
		 * the pressure on the core instead of punching a hole in the music. */
		size_t room = capacity - mAudioBufferAvailable(&s->wsolaIn);
		size_t chunk = available > STRETCH_WSOLA_SCRATCH ? STRETCH_WSOLA_SCRATCH : available;
		if (chunk > room) {
			chunk = room;
		}
		if (!chunk) {
			break;
		}
		size_t got = mAudioBufferRead(source, s->wsolaScratch, chunk);
		if (!got) {
			break;
		}
		size_t put = mAudioBufferWrite(&s->wsolaIn, s->wsolaScratch, got);
		if (put < got) {
			s->wsolaDropped += got - put;
		}
	}
}

/*
 * Runs the WSOLA time-stretcher to fill the output buffer with up to `want`
 * frames. For each synthesis step it slides an analysis window through the
 * input, picks the offset whose start best matches the samples already
 * emitted (phase alignment), windows it with Hann and overlap-adds into the
 * accumulator before flushing the leading samples. Input is consumed at the
 * analysis hop and output emitted at the synthesis hop, so the ratio of the
 * two is exactly the stretch: no section is ever dropped, so the tune never
 * jumps. Backpressure (stop, leave the input parked) keeps every hop intact.
 */
/* Normalised cross-correlation between the reference tail `prev` (the samples
 * just emitted) and the input window starting at analysis offset `d`. Returns a
 * value in [-1, 1]; the caller keeps the highest. Pulled out as a helper so the
 * two-stage phase search can run the same inner loop twice (coarse then fine)
 * without duplicating it. */
static float wsolaCorrelate(struct mAudioBuffer* in, const int16_t* prev, int d, size_t ref) {
	long long dot = 0, e1 = 0, e2 = 0;
	for (size_t i = 0; i < ref; ++i) {
		int16_t L = mAudioBufferPeek(in, 0, d + i);
		int16_t R = mAudioBufferPeek(in, 1, d + i);
		int ma = (int) L + (int) R;
		int mp = (int) prev[i * 2] + (int) prev[i * 2 + 1];
		dot += (long long) ma * mp;
		e1 += (long long) ma * ma;
		e2 += (long long) mp * mp;
	}
	return e2 > 0 ? (float) dot / (sqrtf((float) e1 * e2) + 1) : 0;
}

static size_t wsolaGenerate(struct AudioStretch* s, size_t want) {
	if (!s->inited) {
		return 0;
	}
	size_t N = s->wsolaN;
	size_t N2 = N * 2;
	size_t Ha = s->wsolaHa;
	size_t Hs = s->wsolaHs;
	size_t Hs2 = Hs * 2;
	size_t W2 = N2;
	size_t ref = Hs;
	size_t ref2 = Hs2;
	float* acc = s->wsolaAcc;
	int16_t* win = s->wsolaWindow;
	int16_t* prev = s->wsolaPrev;
	int16_t* frame = s->wsolaScratch;
	int16_t* emit = s->wsolaEmit;
	size_t available = mAudioBufferAvailable(&s->wsolaIn);
	size_t holdCapacity = mAudioBufferCapacity(&s->audioHold);
	size_t ap = s->wsolaAnaPos;
	size_t produced = 0;
	/* Search tolerance is kept small - only a few signal periods - so the
	 * phase match lands on the true continuation rather than jumping to a
	 * wrong-harmonic correlation peak. A coarse step keeps the search stable. */
	int tol = (int) (N / 4);
	if (tol > (int) (Ha / 2)) {
		tol = (int) (Ha / 2);
	}

	/* Emit until at least `want` frames have been produced. Emitting whole
	 * synthesis hops means the last hop usually overshoots `want` by up to
	 * Hs-1 frames; that overshoot is bounded (the caller carries the surplus
	 * back as negative debt) and is what guarantees the device is never
	 * under-fed. The previous guard `produced + Hs <= want` stopped one hop
	 * early, leaving the staging buffer starved between callbacks - which the
	 * resampler answers with silence and the ear hears as a choppy "electric"
	 * artefact. */
	while (produced < want && ap + N <= available) {
		if (holdCapacity - mAudioBufferAvailable(&s->audioHold) < Hs) {
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
	/* Two-stage phase search. A coarse sweep (step 4) finds the approximate
	 * continuation, then a single-sample refinement around the winner locks the
	 * overlap-add phase precisely. A coarse step alone (the old code used 8)
	 * quantised the analysis position to a multiple of several samples, landing
	 * up to half a period off for any tone whose period is under ~2x that step.
	 * The two misaligned frames then cancel in the 50% overlap-add cross-fade,
	 * hollowing out the upper mid / high range - the music loses its brightness
	 * and sounds low and dead (闷). The fine pass restores it at a fraction of a
	 * full single-sample sweep's cost. */
	int coarseStep = 4;
	int bestD = (int) ap;
	float best = -1e30f;
	for (int d = lo; d <= hi; d += coarseStep) {
		float sc = wsolaCorrelate(&s->wsolaIn, prev, d, ref);
		if (sc > best) {
			best = sc;
			bestD = d;
		}
	}
	int flo = bestD - 2 * coarseStep;
	if (flo < lo) {
		flo = lo;
	}
	int fhi = bestD + 2 * coarseStep;
	if (fhi > hi) {
		fhi = hi;
	}
	best = -1e30f;
	int fineBest = bestD;
	for (int d = flo; d <= fhi; ++d) {
		float sc = wsolaCorrelate(&s->wsolaIn, prev, d, ref);
		if (sc > best) {
			best = sc;
			fineBest = d;
		}
	}
	bestD = fineBest;
		size_t fp = (size_t) bestD;
		for (size_t i = 0; i < N; ++i) {
			frame[i * 2] = mAudioBufferPeek(&s->wsolaIn, 0, fp + i);
			frame[i * 2 + 1] = mAudioBufferPeek(&s->wsolaIn, 1, fp + i);
		}
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
		size_t wrote = mAudioBufferWrite(&s->audioHold, emit, Hs);
		if (wrote < Hs) {
			s->wsolaDropped += Hs - wrote;
		}
		{
			size_t base = W2 - ref2;
			for (size_t i = 0; i < ref2; ++i) {
				float v = acc[base + i];
				int iv = (int) (v + (v >= 0 ? 0.5f : -0.5f));
				if (iv > 32767) {
					iv = 32767;
				} else if (iv < -32768) {
					iv = -32768;
				}
				prev[i] = (int16_t) iv;
			}
		}
		memmove(acc, acc + Hs2, (W2 - Hs2) * sizeof(float));
		memset(acc + Hs2, 0, (W2 - Hs2) * sizeof(float));
		produced += Hs;
		ap = fp + Ha;
	}
	s->wsolaAnaPos = ap;
	if (ap > 0) {
		size_t rem = ap;
		while (rem > 0) {
			size_t c = rem > STRETCH_WSOLA_SCRATCH ? STRETCH_WSOLA_SCRATCH : rem;
			mAudioBufferRead(&s->wsolaIn, s->wsolaScratch, c);
			rem -= c;
		}
		s->wsolaAnaPos = 0;
	}
	return produced;
}

/*
 * 音乐原速 playback: a section plays straight out of the core at its own
 * tempo and pitch, then a whole surplus section is skipped - deferred until
 * the lag ring is full, landed on the quietest stretch of the freshest audio
 * (a gap between notes), with the incoming section faded in over 12 ms so a
 * cut that still lands on sound does not click.
 */
static void nativeHoldCut(struct AudioStretch* s, size_t need, unsigned coreRate) {
	size_t cap = s->natRingCap;
	size_t quiet = (size_t) (coreRate * STRETCH_NATIVE_QUIET_SECONDS + 0.5);
	size_t scan = (size_t) (coreRate * STRETCH_NATIVE_SCAN_SECONDS + 0.5);
	size_t guard = (size_t) (coreRate * STRETCH_NATIVE_RESERVE_SECONDS + 0.5);
	size_t landMin = s->natR + need;
	size_t landMax = s->natW > guard ? s->natW - guard : s->natR;
	size_t zoneLo, zoneHi, best, bestEnergy, pos, k;
	if (quiet < 16) {
		quiet = 16;
	}
	if (landMax < landMin) {
		/* Degenerate (need larger than the backlog can spare): drop the whole
		 * pending backlog so the ring invariant (natR <= natW) always holds.
		 * The previous code advanced natR to landMin == natR + need, which can
		 * exceed natW and make `have = natW - natR` underflow to a huge number;
		 * the playback head then drifts into unwritten ring space and the
		 * fast-forward audio stays dead/garbled. Dropping to natW is the safe
		 * fallback. */
		s->natLagDrops += need;
		s->natR = s->natW;
		s->natPrimed = 0;
		++s->natCuts;
		return;
	}
	/* Prefer the freshest audio: landing near the write head makes this cut -
	 * and therefore the stretch until the next one - as long as possible. */
	zoneLo = landMax > landMin + scan ? landMax - scan : landMin;
	zoneHi = landMax;
	best = zoneLo;
	bestEnergy = (size_t) -1;
	for (pos = zoneLo; pos + quiet <= zoneHi; pos += quiet) {
		size_t energy = 0;
		for (k = 0; k < quiet; ++k) {
			const int16_t* frame = &s->natRing[((pos + k) % cap) * 2];
			int l = frame[0];
			int r = frame[1];
			energy += (size_t) (l < 0 ? -l : l) + (size_t) (r < 0 ? -r : r);
		}
		if (energy < bestEnergy) {
			bestEnergy = energy;
			best = pos;
		}
	}
	s->natLagDrops += best - s->natR;
	s->natR = best;
	s->natPrimed = 0; /* re-arm the fade-in over the seam */
	++s->natCuts;
}

static size_t nativeHoldGenerate(struct AudioStretch* s, struct mAudioBuffer* source, size_t want, unsigned coreRate, double rate) {
	size_t cap = s->natRingCap;
	size_t holdCap = mAudioBufferCapacity(&s->audioHold);
	size_t holdAvail = mAudioBufferAvailable(&s->audioHold);
	size_t produced = 0;

	if (!s->natRing || !cap || !coreRate) {
		return 0;
	}

	/* 1. Pull the core's audio into the lag ring. While the ring has room the
	 * played stream is one continuous, untransposed 1x section; once it is
	 * full, whole sections are cut away at the quietest spot. */
	size_t startR = s->natR;
	size_t avail = mAudioBufferAvailable(source);
	while (avail) {
		size_t n = avail > STRETCH_WSOLA_SCRATCH ? STRETCH_WSOLA_SCRATCH : avail;
		n = mAudioBufferRead(source, s->wsolaScratch, n);
		if (!n) {
			break;
		}
		if (s->natW + n - s->natR > cap) {
			nativeHoldCut(s, s->natW + n - s->natR - cap, coreRate);
		}
		for (size_t k = 0; k < n; ++k) {
			size_t widx = s->natW % cap;
			s->natRing[widx * 2] = s->wsolaScratch[k * 2];
			s->natRing[widx * 2 + 1] = s->wsolaScratch[k * 2 + 1];
			s->natW++;
		}
		avail -= n;
	}

	/* 2. Hand out exactly what real time has advanced - one frame per core
	 * sample of wall clock, independent of the multiplier. This is the only
	 * quantity that means the same thing at every speed. */
	double now = stretchNow();
	double dt = now - s->natLastTime;
	s->natLastTime = now;
	if (dt > 0.0 && dt < 0.5) {
		s->natOutAcc += dt * (double) coreRate * rate;
	}
	double acc = s->natOutAcc;
	size_t owed = (size_t) acc;
	s->natOutAcc = acc - (double) owed;
	/* A long stall must not turn into a backlog of stale music. */
	double maxOwed = (double) coreRate * 0.25;
	if (s->natOutAcc > maxOwed) {
		s->natOutAcc = maxOwed;
	}

	size_t have = s->natW - s->natR;
	size_t budget = owed;
	if (budget > have) {
		budget = have;
	}
	if (budget > (size_t) want) {
		budget = (size_t) want;
	}
	if (budget > holdCap - holdAvail) {
		budget = holdCap - holdAvail;
	}

	/* 3. Copy `budget` frames out of the ring into the playback buffer, with
	 * the first few faded in so re-entering the hold does not click. */
	for (size_t done = 0; done < budget; ) {
		size_t ridx = s->natR % cap;
		size_t room = cap - ridx;
		size_t chunk = budget - done;
		if (chunk > room) {
			chunk = room;
		}
		/* The scratch buffer only holds so many frames: writing past it would
		 * run off the end of the allocation (a crash that looks like the
		 * emulator freezing). */
		size_t scratchRoom = STRETCH_WSOLA_SCRATCH - done;
		if (chunk > scratchRoom) {
			chunk = scratchRoom;
		}
		if (!chunk) {
			break;
		}
		for (size_t k = 0; k < chunk; ++k) {
			int16_t l = s->natRing[(ridx + k) * 2];
			int16_t r = s->natRing[(ridx + k) * 2 + 1];
			size_t played = s->natPrimed + k;
			if (played < s->natPrimedTarget) {
				int a = (int) ((played * 256) / (s->natPrimedTarget > 0 ? s->natPrimedTarget : 1));
				l = (int16_t) (((int) l * a) / 256);
				r = (int16_t) (((int) r * a) / 256);
			}
			s->wsolaScratch[(done + k) * 2] = l;
			s->wsolaScratch[(done + k) * 2 + 1] = r;
		}
		size_t wrote = mAudioBufferWrite(&s->audioHold, s->wsolaScratch + done * 2, chunk);
		s->natR += wrote;
		s->natPrimed += wrote;
		done += wrote;
		if (wrote < chunk) {
			break; /* playback buffer full; finish next call */
		}
	}
	produced = s->natR - startR;
	/* Whatever the staging buffer could not take stays owed: dropping it here
	 * would make the music drift slower than real time, call after call. */
	s->natOutAcc += (double) (owed - produced);
	return produced;
}

struct mAudioBuffer* audioStretchProcess(struct AudioStretch* s, struct mAudioBuffer* source,
                                         unsigned coreRate, bool holdOn, double stretch, double rate, size_t want) {
	if (!holdOn || !coreRate || stretch < 1.001) {
		/* Disengaged (or too slow to matter): anything staged under the last
		 * engagement must not replay on the next one. The clear itself is
		 * deferred to the audio thread entry below, which is the only place
		 * the buffers may be touched. */
		if (s->inited) {
			s->clearPending = true;
		}
		return source;
	}
	if (rate < 0.05) {
		rate = 1.0;
	}
	initHold(s, coreRate, stretch);
	if (!s->inited) {
		return source;
	}
	if (s->clearPending) {
		/* A toggle happened since last time: drop anything staged under the
		 * previous speed/mode so a re-enable never replays it. */
		mAudioBufferClear(&s->audioHold);
		mAudioBufferClear(&s->wsolaIn);
		s->wsolaAnaPos = 0;
		s->natW = s->natR;
		s->natPrimed = 0;
		s->natOutAcc = 0.0;
		s->natLastTime = 0.0;
		s->wsolaOutAcc = 0.0;
		s->wsolaLastTime = 0.0;
		s->clearPending = false;
	}
	if (s->mode == AUDIO_STRETCH_NATIVE) {
		nativeHoldGenerate(s, source, want, coreRate, rate);
	} else {
		wsolaFeed(s, source);
		/* Pace the synthesis to real time: the stretcher must hand out
		 * exactly one frame per core sample of wall clock, no matter how fast
		 * the game runs. Over-producing would fill the staging buffer, stall
		 * the synthesis, and the core's own audio ring would then overflow and
		 * drop samples - the gappy "electric" artefact this feature exists to
		 * remove. Whole synthesis hops (Hs frames) are emitted, so the
		 * remainder stays owed and is carried into the next call. The tempo
		 * the music ends up playing at scales the whole budget. */
		double now = stretchNow();
		double dt = now - s->wsolaLastTime;
		s->wsolaLastTime = now;
		if (dt > 0.0 && dt < 0.5) {
			s->wsolaOutAcc += dt * (double) coreRate * rate;
		}
		/* A long stall (window dragged, game paused) must not turn into a
		 * backlog of stale music: cap what the engine may owe. */
		double maxOwed = (double) coreRate * 0.25;
		if (s->wsolaOutAcc > maxOwed) {
			s->wsolaOutAcc = maxOwed;
		}
		double debt = s->wsolaOutAcc;
		if (debt < 0.0) {
			debt = 0.0;
		}
		size_t budget = (size_t) debt;
		/* Keep a low-water reserve in the staging buffer so the device's smooth,
		 * steady pull never finds it empty between whole-hop emissions. The
		 * top-up only fires when we dip below the mark, so the long-run
		 * emission rate stays exactly the wall-clock rate (tempo unchanged). */
		size_t holdAvail = mAudioBufferAvailable(&s->audioHold);
		size_t lowWater = (size_t) (coreRate * 0.10 + 0.5); /* ~100 ms slack */
		size_t topUp = holdAvail < lowWater ? lowWater - holdAvail : 0;
		size_t emitBudget = budget + topUp;
		size_t made = wsolaGenerate(s, emitBudget);
		s->wsolaOutAcc -= (double) made;
		/* A whole-hop emission overshoots `budget` by up to Hs-1 frames. Carry
		 * that surplus back as a small negative credit instead of clamping to 0,
		 * otherwise it accumulates in the staging buffer and grows latency
		 * without bound. The credit is capped at one hop so it cannot starve
		 * the engine either. */
		if (s->wsolaOutAcc < -(double) s->wsolaHs) {
			s->wsolaOutAcc = -(double) s->wsolaHs;
		}
	}
	return &s->audioHold;
}

size_t audioStretchDropped(const struct AudioStretch* s) {
	return s->wsolaDropped + s->natLagDrops;
}

size_t audioStretchCuts(const struct AudioStretch* s) {
	return s->natCuts;
}
