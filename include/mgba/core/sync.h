/* Copyright (c) 2013-2016 Jeffrey Pfau
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
#ifndef M_CORE_SYNC_H
#define M_CORE_SYNC_H

#include <mgba-util/common.h>

CXX_GUARD_START

#include <mgba-util/threading.h>

struct mCoreSync {
	int videoFramePending;
	bool videoFrameWait;
	Mutex videoFrameMutex;
	Condition videoFrameAvailableCond;
	Condition videoFrameRequiredCond;

	bool audioWait;
	Condition audioRequiredCond;
	Mutex audioBufferMutex;
	size_t audioHighWater;

	float fpsTarget;

	/* 倍速声音不变 (fast-forward music hold): mirrored from CoreController so
	 * the SDL audio callback - which has no CoreController pointer - can apply
	 * the WSOLA / native stretch. Mode 0 = off (pitch follows the game), 1 =
	 * WSOLA time-stretch, 2 = native "skip a section". */
	int audioHoldMode;
	double audioHoldRatio;
	double audioHoldRate;
};

struct mCoreOptions;
void mCoreSyncLoadCoreOpts(struct mCoreSync* sync, const struct mCoreOptions* opts);

void mCoreSyncPostFrame(struct mCoreSync* sync);
void mCoreSyncForceFrame(struct mCoreSync* sync);
bool mCoreSyncWaitFrameStart(struct mCoreSync* sync);
void mCoreSyncWaitFrameEnd(struct mCoreSync* sync);
void mCoreSyncSetVideoSync(struct mCoreSync* sync, bool wait);

struct mAudioBuffer;
bool mCoreSyncProduceAudio(struct mCoreSync* sync, const struct mAudioBuffer*);
void mCoreSyncLockAudio(struct mCoreSync* sync);
void mCoreSyncUnlockAudio(struct mCoreSync* sync);
void mCoreSyncConsumeAudio(struct mCoreSync* sync);

CXX_GUARD_END

#endif
