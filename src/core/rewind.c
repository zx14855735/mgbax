/* Copyright (c) 2013-2016 Jeffrey Pfau
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
#include <mgba/core/rewind.h>

#include <mgba/core/core.h>
#include <mgba/core/serialize.h>
#include <mgba-util/patch/fast.h>
#include <mgba-util/vfs.h>

DEFINE_VECTOR(mCoreRewindPatches, struct PatchFast);

/* ===== 档1 A 回滚 diag 保真钩子（默认 NULL=零回归）=====
 * 由 SIO driver 注册；rewind 只负责在正确的时机回调，不认识 diag 地址/游戏态。
 * preserve 在 mCoreSaveStateNamed 之后、线程早退之前（否则 onThread 跳过）；
 * verify 在 mCoreRewindRestore 的 mCoreLoadStateNamed 之后，只 PEEK 不写 live。 */
void gnpRewindSetDiagPreserve(void (*cb)(void*, void*), void* ud);
void gnpRewindSetDiagVerify(void (*cb)(void*, void*), void* ud);

static void (*s_gnpDiagPreserve)(void*, void*) = NULL;
static void* s_gnpDiagPreserveUd = NULL;
static void (*s_gnpDiagVerify)(void*, void*) = NULL;
static void* s_gnpDiagVerifyUd = NULL;

void gnpRewindSetDiagPreserve(void (*cb)(void*, void*), void* ud) {
	s_gnpDiagPreserve = cb;
	s_gnpDiagPreserveUd = ud;
}

void gnpRewindSetDiagVerify(void (*cb)(void*, void*), void* ud) {
	s_gnpDiagVerify = cb;
	s_gnpDiagVerifyUd = ud;
}

static void _rewindDiff(struct mCoreRewindContext* context);

#ifndef DISABLE_THREADING
THREAD_ENTRY _rewindThread(void* context);
#endif

void mCoreRewindContextInit(struct mCoreRewindContext* context, size_t entries, bool onThread) {
	if (context->currentState) {
		return;
	}
	mCoreRewindPatchesInit(&context->patchMemory, entries);
	size_t e;
	for (e = 0; e < entries; ++e) {
		initPatchFast(mCoreRewindPatchesAppend(&context->patchMemory));
	}
	context->previousState = VFileMemChunk(0, 0);
	context->currentState = VFileMemChunk(0, 0);
	context->size = 0;
	context->rewindFrameCounter = 0;
#ifndef DISABLE_THREADING
	context->onThread = onThread;
	context->ready = false;
	if (onThread) {
		MutexInit(&context->mutex);
		ConditionInit(&context->cond);
		ThreadCreate(&context->thread, _rewindThread, context);
	}
#else
	UNUSED(onThread);
#endif
}

void mCoreRewindContextDeinit(struct mCoreRewindContext* context) {
	if (!context->currentState) {
		return;
	}
#ifndef DISABLE_THREADING
	if (context->onThread) {
		MutexLock(&context->mutex);
		context->onThread = false;
		MutexUnlock(&context->mutex);
		ConditionWake(&context->cond);
		ThreadJoin(&context->thread);
		MutexDeinit(&context->mutex);
		ConditionDeinit(&context->cond);
	}
#endif
	context->previousState->close(context->previousState);
	context->currentState->close(context->currentState);
	context->previousState = NULL;
	context->currentState = NULL;
	size_t s;
	for (s = 0; s < mCoreRewindPatchesSize(&context->patchMemory); ++s) {
		deinitPatchFast(mCoreRewindPatchesGetPointer(&context->patchMemory, s));
	}
	mCoreRewindPatchesDeinit(&context->patchMemory);
}

void mCoreRewindAppend(struct mCoreRewindContext* context, struct mCore* core) {
#ifndef DISABLE_THREADING
	if (context->onThread) {
		MutexLock(&context->mutex);
	}
#endif
	struct VFile* nextState = context->previousState;
	mCoreSaveStateNamed(core, nextState, SAVESTATE_SAVEDATA | SAVESTATE_RTC);
	/* 【插入点】必须紧贴 mCoreSaveStateNamed 之后、线程早退之前：
	 * onThread=true 时下面 return，放在其后会被整段跳过。 */
	if (s_gnpDiagPreserve) {
		s_gnpDiagPreserve((void*) nextState, s_gnpDiagPreserveUd);
	}
	context->previousState = context->currentState;
	context->currentState = nextState;
#ifndef DISABLE_THREADING
	if (context->onThread) {
		context->ready = true;
		ConditionWake(&context->cond);
		MutexUnlock(&context->mutex);
		return;
	}
#endif
	_rewindDiff(context);
}

void _rewindDiff(struct mCoreRewindContext* context) {
	size_t size = context->previousState->size(context->previousState);
	if (!size) {
		// We are appending the first state
		return;
	}

	++context->current;
	if (context->size < mCoreRewindPatchesSize(&context->patchMemory)) {
		++context->size;
	}
	if (context->current >= mCoreRewindPatchesSize(&context->patchMemory)) {
		context->current = 0;
	}
	struct PatchFast* patch = mCoreRewindPatchesGetPointer(&context->patchMemory, context->current);
	size_t size2 = context->currentState->size(context->currentState);
	if (size2 > size) {
		context->previousState->truncate(context->previousState, size2);
		size = size2;
	} else if (size > size2) {
		context->currentState->truncate(context->currentState, size);
	}
	void* current = context->previousState->map(context->previousState, size, MAP_READ);
	void* next = context->currentState->map(context->currentState, size, MAP_READ);
	diffPatchFast(patch, current, next, size);
	context->previousState->unmap(context->previousState, current, size);
	context->currentState->unmap(context->currentState, next, size);
}

bool mCoreRewindRestore(struct mCoreRewindContext* context, struct mCore* core, unsigned count) {
#ifndef DISABLE_THREADING
	if (context->onThread) {
		MutexLock(&context->mutex);
	}
#endif
	if (!context->size) {
#ifndef DISABLE_THREADING
		if (context->onThread) {
			MutexUnlock(&context->mutex);
		}
#endif
		return false;
	}

	for (; count && context->size; --count, --context->size) {
		if (context->current == 0) {
			context->current = mCoreRewindPatchesSize(&context->patchMemory);
		}
		--context->current;

		if (context->size > 1) {
			struct PatchFast* patch = mCoreRewindPatchesGetPointer(&context->patchMemory, context->current);
			size_t size2 = context->previousState->size(context->previousState);
			size_t size = context->currentState->size(context->currentState);
			if (size2 < size) {
				size = size2;
			}
			void* current = context->currentState->map(context->currentState, size, MAP_READ);
			void* previous = context->previousState->map(context->previousState, size, MAP_WRITE);
			patch->d.applyPatch(&patch->d, previous, size, current, size);
			context->currentState->unmap(context->currentState, current, size);
			context->previousState->unmap(context->previousState, previous, size);
		}
		struct VFile* nextState = context->previousState;
		context->previousState = context->currentState;
		context->currentState = nextState;
	}

	mCoreLoadStateNamed(core, context->currentState, SAVESTATE_SAVEDATA | SAVESTATE_RTC);
	/* restore 后只复核、零写 live（回滚层绝不伪造 diag/信任位）。 */
	if (s_gnpDiagVerify) {
		s_gnpDiagVerify((void*) context->currentState, s_gnpDiagVerifyUd);
	}


#ifndef DISABLE_THREADING
	if (context->onThread) {
		MutexUnlock(&context->mutex);
	}
#endif
	return true;
}

#ifndef DISABLE_THREADING
THREAD_ENTRY _rewindThread(void* context) {
	struct mCoreRewindContext* rewindContext = context;
	ThreadSetName("Rewind Diffing");
	MutexLock(&rewindContext->mutex);
	while (rewindContext->onThread) {
		while (!rewindContext->ready && rewindContext->onThread) {
			ConditionWait(&rewindContext->cond, &rewindContext->mutex);
		}
		if (rewindContext->ready) {
			_rewindDiff(rewindContext);
		}
		rewindContext->ready = false;
	}
	MutexUnlock(&rewindContext->mutex);
	THREAD_EXIT(0);
}
#endif

