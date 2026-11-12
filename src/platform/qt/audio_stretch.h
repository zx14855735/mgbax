/* Copyright (c) 2013-2021 Jeffrey Pfau
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
#ifndef MGBA_QT_AUDIO_STRETCH_H
#define MGBA_QT_AUDIO_STRETCH_H

#include <mgba-util/audio-buffer.h>

#include <stdbool.h>
#include <stddef.h>

#ifdef __cplusplus
extern "C" {
#endif

/**
 * Fast-forward audio stretcher, extracted from the Android mobile layer
 * (mgba_mobile.c's WSOLA + native hold engine, 音乐原速). While engaged, the
 * surplus audio a fast-forwarded game produces is staged and replayed at the
 * console's own rate instead of being shredded by the core's ring:
 *
 *   - mode 1 (PITCH): WSOLA time-stretch - the whole tune plays at its own
 *     pitch and tempo scaled by no skipped section... precisely: the tune is
 *     time-compressed into real time with no pitch shift and no jumps.
 *   - mode 2 (NATIVE): sections play bit-for-bit at 1x and whole surplus
 *     sections are skipped, cut on quiet gaps between notes.
 */
enum AudioStretchMode {
	AUDIO_STRETCH_OFF = 0,
	AUDIO_STRETCH_PITCH = 1,
	AUDIO_STRETCH_NATIVE = 2,
};

struct AudioStretch {
	bool inited;
	int mode;
	double configured;
	double stretch;
	bool clearPending;
	unsigned coreRate;

	size_t wsolaN;
	size_t wsolaHs;
	size_t wsolaHa;
	size_t wsolaAnaPos;
	size_t wsolaDropped;
	// Real-time pacing for the WSOLA synthesis: frames of output the engine
	// still owes the player, and the wall clock the debt is measured against.
	double wsolaOutAcc;
	double wsolaLastTime;
	float* wsolaAcc;
	int16_t* wsolaEmit;
	int16_t* wsolaPrev;
	int16_t* wsolaWindow;
	int16_t* wsolaScratch;
	struct mAudioBuffer audioHold;
	struct mAudioBuffer wsolaIn;

	int16_t* natRing;
	size_t natRingCap;
	size_t natW;
	size_t natR;
	size_t natPrimed;
	size_t natPrimedTarget;
	size_t natLagDrops;
	size_t natCuts;
	double natOutAcc;
	double natLastTime;
};

void audioStretchInit(struct AudioStretch* s);
void audioStretchDeinit(struct AudioStretch* s);

/** Change the production mode; stages a buffer clear on the next process. */
void audioStretchSetMode(struct AudioStretch* s, int mode);
int audioStretchMode(const struct AudioStretch* s);

/** Drop everything staged (game load / re-enable). */
void audioStretchReset(struct AudioStretch* s);

/**
 * Feeds the core's audio buffer into the stretcher when engaged and returns
 * the buffer the resampler should read from: `source` itself when disengaged,
 * the staged `audioHold` buffer when engaged (consume it one-for-one at the
 * console's own rate). `want` is the resampler's immediate appetite in frames;
 * `stretch` is the fast-forward multiplier, and `rate` is how fast the music
 * itself should play (1 = its own tempo).
 */
struct mAudioBuffer* audioStretchProcess(struct AudioStretch* s, struct mAudioBuffer* source,
                                         unsigned coreRate, bool holdOn, double stretch, double rate, size_t want);

/** Diagnostics: frames the stretcher had to discard (0 is healthy). */
size_t audioStretchDropped(const struct AudioStretch* s);
size_t audioStretchCuts(const struct AudioStretch* s);

#ifdef __cplusplus
}
#endif

#endif
