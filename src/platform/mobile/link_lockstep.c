/* Copyright (c) 2013-2024 Jeffrey Pfau
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
#include "link_lockstep.h"

#include <mgba/core/core.h>
#include <mgba/core/lockstep.h>
#include <mgba/internal/gba/gba.h>
#include <mgba/internal/gba/sio/lockstep.h>
#include <mgba/internal/gba/video.h>

#include <errno.h>
#include <pthread.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>

#define LOCKSTEP_MAX_ROOMS 8
#define LOCKSTEP_MAX_PLAYERS 4
/* 一帧内允许的 runLoop 小步上限：防止某核被永久 park 时把线程卡死。 */
#define LOCKSTEP_RUN_GUARD 500000

struct MgbaLockstepRoom {
	int key;
	int players;
	int refs;
	bool used;
	struct GBASIOLockstepCoordinator coord;
};

/* mLockstepUser 必须是首成员：sleep/wake/requestedId 回调靠强转找回 slot。
 * 协调器在持有 coordinator->mutex 时调用 sleep，因此这里只碰 slot 自己的
 * mu，绝不反向获取 coordinator 锁，避免与官方锁序互锁。 */
struct MgbaLockstepSlot {
	struct mLockstepUser user;
	struct MgbaLockstepRoom* room;
	struct GBASIOLockstepDriver driver;
	struct mCore* core;
	int slotId;
	pthread_mutex_t mu;
	pthread_cond_t cv;
	bool pauseRequested;
};

static struct MgbaLockstepRoom g_rooms[LOCKSTEP_MAX_ROOMS];
static pthread_mutex_t g_regMu = PTHREAD_MUTEX_INITIALIZER;

/* 调用方必须持有 g_regMu。 */
static struct MgbaLockstepRoom* _findRoom(int key) {
	for (int i = 0; i < LOCKSTEP_MAX_ROOMS; ++i) {
		if (g_rooms[i].used && g_rooms[i].key == key) {
			return &g_rooms[i];
		}
	}
	return NULL;
}

/* 调用方必须持有 g_regMu。 */
static struct MgbaLockstepRoom* _allocRoom(int key, int players) {
	for (int i = 0; i < LOCKSTEP_MAX_ROOMS; ++i) {
		if (!g_rooms[i].used) {
			memset(&g_rooms[i], 0, sizeof(g_rooms[i]));
			g_rooms[i].key = key;
			g_rooms[i].players = players;
			g_rooms[i].used = true;
			GBASIOLockstepCoordinatorInit(&g_rooms[i].coord);
			return &g_rooms[i];
		}
	}
	return NULL;
}

struct MgbaLockstepRoom* mgbaLockstepHost(int key, int players) {
	if (players < 2) {
		players = 2;
	}
	if (players > LOCKSTEP_MAX_PLAYERS) {
		players = LOCKSTEP_MAX_PLAYERS;
	}
	pthread_mutex_lock(&g_regMu);
	struct MgbaLockstepRoom* room = NULL;
	if (!_findRoom(key)) {
		room = _allocRoom(key, players);
		if (room) {
			room->refs = 1;
		}
	}
	pthread_mutex_unlock(&g_regMu);
	return room;
}

struct MgbaLockstepRoom* mgbaLockstepJoin(int key) {
	pthread_mutex_lock(&g_regMu);
	struct MgbaLockstepRoom* room = _findRoom(key);
	if (room) {
		++room->refs;
	}
	pthread_mutex_unlock(&g_regMu);
	return room;
}

void mgbaLockstepRelease(struct MgbaLockstepRoom* room) {
	if (!room) {
		return;
	}
	pthread_mutex_lock(&g_regMu);
	if (!room->used || room->refs <= 0) {
		pthread_mutex_unlock(&g_regMu);
		return;
	}
	--room->refs;
	if (room->refs == 0) {
		GBASIOLockstepCoordinatorDeinit(&room->coord);
		room->used = false;
	}
	pthread_mutex_unlock(&g_regMu);
}

static void _slotSleep(struct mLockstepUser* u) {
	struct MgbaLockstepSlot* slot = (struct MgbaLockstepSlot*) u;
	pthread_mutex_lock(&slot->mu);
	/* 非阻塞：只请求暂停，不阻塞调用方（协调器可能正持有自己的 mutex）。 */
	slot->pauseRequested = true;
	pthread_mutex_unlock(&slot->mu);
}

static void _slotWake(struct mLockstepUser* u) {
	struct MgbaLockstepSlot* slot = (struct MgbaLockstepSlot*) u;
	pthread_mutex_lock(&slot->mu);
	slot->pauseRequested = false;
	pthread_mutex_unlock(&slot->mu);
	pthread_cond_broadcast(&slot->cv);
}

static int _slotRequestedId(struct mLockstepUser* u) {
	return ((struct MgbaLockstepSlot*) u)->slotId;
}

struct MgbaLockstepSlot* mgbaLockstepAttach(struct MgbaLockstepRoom* room,
                                           struct mCore* core, int slotId) {
	if (!room || !core || slotId < 0 || slotId >= room->players) {
		return NULL;
	}
	struct MgbaLockstepSlot* slot = calloc(1, sizeof(*slot));
	if (!slot) {
		return NULL;
	}
	pthread_mutex_init(&slot->mu, NULL);
	pthread_cond_init(&slot->cv, NULL);
	slot->room = room;
	slot->core = core;
	slot->slotId = slotId;
	slot->user.sleep = _slotSleep;
	slot->user.wake = _slotWake;
	slot->user.requestedId = _slotRequestedId;
	slot->user.playerIdChanged = NULL;

	GBASIOLockstepDriverCreate(&slot->driver, &slot->user);
	GBASIOLockstepCoordinatorAttach(&room->coord, &slot->driver);
	core->setPeripheral(core, mPERIPH_GBA_LINK_PORT, &slot->driver.d);
	return slot;
}

/* 看门狗：置 1 后 runFrame 立即返回，避免测试线程被永久 park。 */
static volatile int g_lockstepAbort = 0;

void mgbaLockstepSetAbort(int abort) {
	g_lockstepAbort = abort;
}

void mgbaLockstepRunFrame(struct MgbaLockstepSlot* slot, struct mCore* core) {
	if (!slot || !core) {
		return;
	}
	struct GBA* gba = (struct GBA*) core->board;
	uint32_t startFc = gba->video.frameCounter;
	int guard = 0;
	while (gba->video.frameCounter == startFc && guard++ < LOCKSTEP_RUN_GUARD) {
		pthread_mutex_lock(&slot->mu);
		int parkedMs = 0;
		while (slot->pauseRequested) {
			if (g_lockstepAbort) {
				pthread_mutex_unlock(&slot->mu);
				return;
			}
			/* 限时等待：既能让看门狗/abort 从 park 里脱身，也能在长时间
			 * park（正常锁步会合）时周期性打印诊断，暴露死锁所在核。 */
			struct timespec ts;
			clock_gettime(CLOCK_REALTIME, &ts);
			ts.tv_nsec += 200000000;   /* 200ms */
			if (ts.tv_nsec >= 1000000000) {
				ts.tv_nsec -= 1000000000;
				++ts.tv_sec;
			}
			int rc = pthread_cond_timedwait(&slot->cv, &slot->mu, &ts);
			if (rc == ETIMEDOUT) {
				parkedMs += 200;
				if (parkedMs >= 2000) {
					fprintf(stderr,
					        "LOCKSTEP: slot %d PARKED >2s (abort=%d, guard=%d)\n",
					        slot->slotId, g_lockstepAbort, guard);
					parkedMs = 0;
				}
			}
		}
		pthread_mutex_unlock(&slot->mu);
		if (g_lockstepAbort) {
			return;
		}
		core->runLoop(core);
	}
}

void mgbaLockstepDetach(struct MgbaLockstepSlot* slot) {
	if (!slot) {
		return;
	}
	/* 先卸驱动：GBASIOSetDriver 会触发 lockstep driver 的 deinit，内部
	 * _removePlayer 把该玩家从协调器表里摘掉。不要先调
	 * GBASIOLockstepCoordinatorDetach，否则 driver->coordinator 变 NULL，
	 * 之后 deinit 会空指针。 */
	if (slot->core) {
		slot->core->setPeripheral(slot->core, mPERIPH_GBA_LINK_PORT, NULL);
	}
	pthread_cond_destroy(&slot->cv);
	pthread_mutex_destroy(&slot->mu);
	free(slot);
}

size_t mgbaLockstepAttached(struct MgbaLockstepRoom* room) {
	return room ? GBASIOLockstepCoordinatorAttached(&room->coord) : 0;
}

int mgbaLockstepSlotId(struct MgbaLockstepSlot* slot) {
	return slot ? slot->slotId : -1;
}

bool mgbaLockstepPaused(struct MgbaLockstepSlot* slot) {
	if (!slot) {
		return false;
	}
	pthread_mutex_lock(&slot->mu);
	bool paused = slot->pauseRequested;
	pthread_mutex_unlock(&slot->mu);
	return paused;
}

void mgbaLockstepUserSleep(struct MgbaLockstepSlot* slot) {
	if (slot) {
		_slotSleep(&slot->user);
	}
}

void mgbaLockstepUserWake(struct MgbaLockstepSlot* slot) {
	if (slot) {
		_slotWake(&slot->user);
	}
}
