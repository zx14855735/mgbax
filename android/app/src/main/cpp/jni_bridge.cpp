/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
#include <jni.h>
#include <android/bitmap.h>
#include <android/log.h>

#include <mgba/core/core.h>
#include <mgba/core/interface.h>
#include <mgba/core/serialize.h>
#include <mgba/gb/interface.h>
#include <mgba/internal/gba/gba.h>
#include <mgba/internal/gba/io.h>
#include <mgba/internal/gba/savedata.h>
#include <mgba/internal/gb/gb.h>
#include <mgba/internal/gb/io.h>
#include <mgba-util/audio-buffer.h>

#include "link_net.h"

#include <stddef.h>
#include <stdint.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/stat.h>

#define LOG_TAG "mGBA"
#define LOGE(...) __android_log_print(ANDROID_LOG_ERROR, LOG_TAG, __VA_ARGS__)
#define LOGI(...) __android_log_print(ANDROID_LOG_INFO, LOG_TAG, __VA_ARGS__)

struct Emu;

struct GbaLinkDriver {
	struct GBASIODriver d;
	struct Emu* emu;
};

struct GbLinkDriver {
	struct GBSIODriver d;
	struct Emu* emu;
};

struct Emu {
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
	int fast;
	struct NetLink* link;
	struct GbaLinkDriver gbaLink;
	struct GbLinkDriver gbLink;
	struct mTimingEvent linkEvent;
	bool linkAttached;
	// Touch updates these from the UI thread. The emu thread samples them
	// every frame, and again whenever the game reads KEYINPUT.
	uint32_t heldKeys;
	uint32_t latchedKeys;
	uint32_t frameKeys;
	uint32_t appliedKeys;
	uint32_t turboMask;
	unsigned turboCounter;
	struct mKeyCallback keyCallback;
};

static void attachKeyCallback(struct Emu* emu);
static void detachLink(struct Emu* emu);
static void pollLink(struct Emu* emu);

static void copyPath(char* dst, size_t dstLen, const char* src) {
	if (!src) {
		dst[0] = '\0';
		return;
	}
	snprintf(dst, dstLen, "%s", src);
}

static void destroyCore(struct Emu* emu) {
	if (!emu->core) {
		return;
	}
	detachLink(emu);
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
}

static bool ensureVideo(struct Emu* emu) {
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

static jstring asciiString(JNIEnv* env, const char* text) {
	char clean[32];
	size_t i;
	if (!text) {
		return env->NewStringUTF("");
	}
	for (i = 0; i < sizeof(clean) - 1 && text[i]; ++i) {
		unsigned char c = (unsigned char) text[i];
		clean[i] = (c >= 32 && c < 127) ? (char) c : ' ';
	}
	clean[i] = '\0';
	return env->NewStringUTF(clean);
}

extern "C" JNIEXPORT jlong JNICALL
Java_io_mgba_android_MgbaCore_nativeCreate(JNIEnv* env, jobject, jstring saveDir, jstring stateDir) {
	const char* save = env->GetStringUTFChars(saveDir, NULL);
	const char* state = env->GetStringUTFChars(stateDir, NULL);
	struct Emu* emu = (struct Emu*) calloc(1, sizeof(struct Emu));
	if (emu) {
		copyPath(emu->savePath, sizeof(emu->savePath), save);
		copyPath(emu->statePath, sizeof(emu->statePath), state);
		mkdir(emu->savePath, 0755);
		mkdir(emu->statePath, 0755);
		emu->link = netLinkCreate();
		emu->gbaLink.emu = emu;
		emu->gbLink.emu = emu;
	}
	if (save) {
		env->ReleaseStringUTFChars(saveDir, save);
	}
	if (state) {
		env->ReleaseStringUTFChars(stateDir, state);
	}
	return (jlong) emu;
}

extern "C" JNIEXPORT void JNICALL
Java_io_mgba_android_MgbaCore_nativeDestroy(JNIEnv*, jobject, jlong handle) {
	struct Emu* emu = (struct Emu*) handle;
	if (!emu) {
		return;
	}
	destroyCore(emu);
	netLinkDestroy(emu->link);
	emu->link = NULL;
	free(emu);
}

extern "C" JNIEXPORT jboolean JNICALL
Java_io_mgba_android_MgbaCore_nativeLoad(JNIEnv* env, jobject, jlong handle, jstring path) {
	struct Emu* emu = (struct Emu*) handle;
	if (!emu) {
		return JNI_FALSE;
	}
	const char* filename = env->GetStringUTFChars(path, NULL);
	if (!filename) {
		return JNI_FALSE;
	}

	destroyCore(emu);
	struct mCore* core = mCoreFind(filename);
	if (!core || !core->init(core)) {
		LOGE("Could not identify ROM: %s", filename);
		if (core) {
			free(core);
		}
		env->ReleaseStringUTFChars(path, filename);
		return JNI_FALSE;
	}

	mCoreInitConfig(core, "android");
	mCoreConfigSetOverrideValue(&core->config, "savegamePath", emu->savePath);
	mCoreConfigSetOverrideValue(&core->config, "savestatePath", emu->statePath);
	mCoreConfigSetOverrideIntValue(&core->config, "volume", 0x100);
	mCoreConfigSetOverrideIntValue(&core->config, "frameskip", 0);
	mCoreConfigSetOverrideIntValue(&core->config, "useBios", 1);
	mCoreConfigSetOverrideIntValue(&core->config, "skipBios", 1);
	mCoreConfigSetOverrideIntValue(&core->config, "audioSync", 0);
	mCoreConfigSetOverrideIntValue(&core->config, "videoSync", 0);
	mCoreConfigSetOverrideUIntValue(&core->config, "audioBuffers", 4096);
	emu->core = core;
	mCoreLoadConfig(core);

	if (!mCoreLoadFile(core, filename)) {
		LOGE("mCoreLoadFile failed: %s", filename);
		env->ReleaseStringUTFChars(path, filename);
		destroyCore(emu);
		return JNI_FALSE;
	}
	mCoreAutoloadSave(core);
	core->setAudioBufferSize(core, 4096);
	if (!ensureVideo(emu)) {
		LOGE("No video buffer before reset for %s", filename);
		env->ReleaseStringUTFChars(path, filename);
		destroyCore(emu);
		return JNI_FALSE;
	}
	core->reset(core);
	if (core->platform(core) == mPLATFORM_GBA) {
		struct GBA* gba = (struct GBA*) core->board;
		// 128KiB flash (FLASH1M). Autodetect starts as 64KiB and games that
		// expect the 1Mbit chip ID wait forever.
		GBASavedataForceType(&gba->memory.savedata, GBA_SAVEDATA_FLASH1M);
		LOGI("GBA save type forced to FLASH1M (128KB)");
	}
	if (!ensureVideo(emu)) {
		LOGE("No video buffer for %s", filename);
		env->ReleaseStringUTFChars(path, filename);
		destroyCore(emu);
		return JNI_FALSE;
	}

	attachKeyCallback(emu);
	pollLink(emu);
	LOGI("Loaded %s (%ux%u, %u Hz)", filename, emu->width, emu->height, core->audioSampleRate(core));
	env->ReleaseStringUTFChars(path, filename);
	return JNI_TRUE;
}

static uint32_t loadHeld(struct Emu* emu) {
	return __atomic_load_n(&emu->heldKeys, __ATOMIC_ACQUIRE);
}

static void noteKeys(struct Emu* emu, uint32_t keys) {
	uint32_t prev = __atomic_exchange_n(&emu->heldKeys, keys, __ATOMIC_ACQ_REL);
	uint32_t rising = keys & ~prev;
	if (rising) {
		__atomic_fetch_or(&emu->latchedKeys, rising, __ATOMIC_ACQ_REL);
		LOGI("Held 0x%x", keys);
	} else if (keys != prev) {
		LOGI("Held 0x%x", keys);
	}
}

static uint32_t applyTurbo(struct Emu* emu, uint32_t keys) {
	uint32_t turbo = __atomic_load_n(&emu->turboMask, __ATOMIC_ACQUIRE);
	if (!turbo) {
		return keys;
	}
	// One frame down, one frame up. Story text only advances on a new press.
	if ((emu->turboCounter++ & 1u) == 0u) {
		keys |= turbo;
	} else {
		keys &= ~turbo;
	}
	return keys;
}

// Keys for this frame: anything still held, plus taps that rose and fell
// since the previous sample. Those taps stay down for the whole frame.
static uint32_t beginFrameKeys(struct Emu* emu) {
	uint32_t held = loadHeld(emu);
	uint32_t latch = __atomic_exchange_n(&emu->latchedKeys, 0, __ATOMIC_ACQ_REL);
	emu->frameKeys = applyTurbo(emu, held | latch);
	return emu->frameKeys;
}

// Called when the game actually reads KEYINPUT, which may be mid-frame.
// A tap that arrived after the frame started is still visible here.
static uint16_t readLiveKeys(struct mKeyCallback* callback) {
	struct Emu* emu = (struct Emu*) ((char*) callback - offsetof(struct Emu, keyCallback));
	uint32_t held = loadHeld(emu);
	uint32_t latch = __atomic_exchange_n(&emu->latchedKeys, 0, __ATOMIC_ACQ_REL);
	uint32_t keys = emu->frameKeys | held | latch;
	emu->frameKeys = keys;
	if (latch) {
		LOGI("Latched 0x%x", latch);
	}
	return (uint16_t) keys;
}

static void attachKeyCallback(struct Emu* emu) {
	if (!emu->core || emu->core->platform(emu->core) != mPLATFORM_GBA) {
		return;
	}
	emu->keyCallback.readKeys = readLiveKeys;
	emu->keyCallback.requireOpposingDirections = false;
	struct GBA* gba = (struct GBA*) emu->core->board;
	gba->keyCallback = &emu->keyCallback;
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

static void setFastAudio(struct Emu* emu, int fast) {
	if (!emu->core || emu->fast == fast) {
		return;
	}
	emu->fast = fast;
	if (emu->core->platform(emu->core) != mPLATFORM_GBA) {
		return;
	}
	struct GBA* gba = (struct GBA*) emu->core->board;
	mTimingDeschedule(&gba->timing, &gba->audio.sampleEvent);
	if (!fast) {
		int32_t when = gba->audio.sampleInterval > 0 ? gba->audio.sampleInterval : 1;
		mTimingSchedule(&gba->timing, &gba->audio.sampleEvent, when);
	}
}

static struct mTiming* coreTiming(struct Emu* emu) {
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

static void armLinkEvent(struct Emu* emu) {
	struct mTiming* timing = coreTiming(emu);
	if (!timing) {
		return;
	}
	mTimingDeschedule(timing, &emu->linkEvent);
	mTimingSchedule(timing, &emu->linkEvent, 8192);
}

static uint32_t readLinkOut(struct Emu* emu, uint16_t* modeOut) {
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

static void finishIncoming(struct Emu* emu, uint16_t mode, uint32_t remote, int player) {
	int me = netLinkPlayer(emu->link);
	if (emu->core->platform(emu->core) == mPLATFORM_GBA) {
		struct GBA* gba = (struct GBA*) emu->core->board;
		if (gba->sio.mode == GBA_SIO_MULTI && (mode == GBA_SIO_MULTI || mode == 0)) {
			uint16_t data[4] = { 0xFFFF, 0xFFFF, 0xFFFF, 0xFFFF };
			uint16_t local = gba->memory.io[GBA_REG(SIOMLT_SEND)];
			if (player >= 0 && player < 4) {
				data[player] = (uint16_t) remote;
			}
			if (me >= 0 && me < 4) {
				data[me] = local;
			}
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

static void serviceLink(struct Emu* emu) {
	if (!emu->linkAttached || !emu->link) {
		return;
	}
	int guard = 0;
	uint16_t seq;
	uint16_t mode;
	uint32_t value;
	int player;
	while (guard++ < 8 && netLinkTakeRequest(emu->link, &seq, &mode, &value, &player)) {
		uint16_t localMode = 0;
		uint32_t local = readLinkOut(emu, &localMode);
		netLinkReply(emu->link, seq, localMode, local);
		finishIncoming(emu, mode, value, player);
	}
}

static void linkPollEvent(struct mTiming* timing, void* user, uint32_t cyclesLate) {
	UNUSED(cyclesLate);
	struct Emu* emu = (struct Emu*) user;
	serviceLink(emu);
	if (emu->linkAttached) {
		mTimingSchedule(timing, &emu->linkEvent, 8192);
	}
}

static bool gbaLinkInit(struct GBASIODriver* driver) {
	struct Emu* emu = ((struct GbaLinkDriver*) driver)->emu;
	emu->linkEvent.context = emu;
	emu->linkEvent.callback = linkPollEvent;
	emu->linkEvent.name = "Android Link";
	emu->linkEvent.priority = 0x70;
	armLinkEvent(emu);
	return true;
}

static void gbaLinkDeinit(struct GBASIODriver* driver) {
	struct Emu* emu = ((struct GbaLinkDriver*) driver)->emu;
	struct mTiming* timing = coreTiming(emu);
	if (timing) {
		mTimingDeschedule(timing, &emu->linkEvent);
	}
}

static void gbaLinkReset(struct GBASIODriver* driver) {
	armLinkEvent(((struct GbaLinkDriver*) driver)->emu);
}

static uint32_t gbaLinkId(const struct GBASIODriver*) {
	return 0x4C4B4E41u;
}

static bool gbaLinkLoadState(struct GBASIODriver*, const void*, size_t) {
	return true;
}

static void gbaLinkSaveState(struct GBASIODriver*, void** state, size_t* size) {
	*state = NULL;
	*size = 0;
}

static void gbaLinkSetMode(struct GBASIODriver*, enum GBASIOMode) {
}

static bool gbaLinkHandles(struct GBASIODriver*, enum GBASIOMode mode) {
	return mode == GBA_SIO_MULTI || mode == GBA_SIO_NORMAL_8 || mode == GBA_SIO_NORMAL_32;
}

static int gbaLinkDevices(struct GBASIODriver*) {
	return 2;
}

static int gbaLinkDeviceId(struct GBASIODriver* driver) {
	return netLinkPlayer(((struct GbaLinkDriver*) driver)->emu->link);
}

static uint16_t gbaLinkWriteCnt(struct GBASIODriver* driver, uint16_t value) {
	if (driver->p && driver->p->mode == GBA_SIO_MULTI) {
		return GBASIOMultiplayerFillReady(GBASIOMultiplayerClearError(value));
	}
	if (driver->p && (driver->p->mode == GBA_SIO_NORMAL_8 || driver->p->mode == GBA_SIO_NORMAL_32)) {
		return GBASIONormalFillSi(value);
	}
	return value;
}

static uint16_t gbaLinkWriteRcnt(struct GBASIODriver*, uint16_t value) {
	return value;
}

static bool gbaLinkStart(struct GBASIODriver*) {
	return true;
}

static void gbaLinkFinishMulti(struct GBASIODriver* driver, uint16_t data[4]) {
	struct Emu* emu = ((struct GbaLinkDriver*) driver)->emu;
	struct GBA* gba = (struct GBA*) emu->core->board;
	uint16_t local = gba->memory.io[GBA_REG(SIOMLT_SEND)];
	uint32_t remote = 0xFFFFFFFFu;
	int me = netLinkPlayer(emu->link);
	data[0] = data[1] = data[2] = data[3] = 0xFFFF;
	if (me >= 0 && me < 4) {
		data[me] = local;
	}
	if (netLinkExchange(emu->link, GBA_SIO_MULTI, local, &remote, 800)) {
		int peer = me == 0 ? 1 : 0;
		data[peer] = (uint16_t) remote;
	}
}

static uint8_t gbaLinkFinish8(struct GBASIODriver* driver) {
	struct Emu* emu = ((struct GbaLinkDriver*) driver)->emu;
	struct GBA* gba = (struct GBA*) emu->core->board;
	uint32_t local = gba->memory.io[GBA_REG(SIODATA8)] & 0xFFu;
	uint32_t remote = 0xFFu;
	netLinkExchange(emu->link, GBA_SIO_NORMAL_8, local, &remote, 800);
	return (uint8_t) remote;
}

static uint32_t gbaLinkFinish32(struct GBASIODriver* driver) {
	struct Emu* emu = ((struct GbaLinkDriver*) driver)->emu;
	struct GBA* gba = (struct GBA*) emu->core->board;
	uint32_t local = gba->memory.io[GBA_REG(SIODATA32_LO)] | ((uint32_t) gba->memory.io[GBA_REG(SIODATA32_HI)] << 16);
	uint32_t remote = 0xFFFFFFFFu;
	netLinkExchange(emu->link, GBA_SIO_NORMAL_32, local, &remote, 800);
	return remote;
}

static bool gbLinkInit(struct GBSIODriver* driver) {
	struct Emu* emu = ((struct GbLinkDriver*) driver)->emu;
	emu->linkEvent.context = emu;
	emu->linkEvent.callback = linkPollEvent;
	emu->linkEvent.name = "Android Link";
	emu->linkEvent.priority = 0x70;
	armLinkEvent(emu);
	return true;
}

static void gbLinkDeinit(struct GBSIODriver* driver) {
	struct Emu* emu = ((struct GbLinkDriver*) driver)->emu;
	struct mTiming* timing = coreTiming(emu);
	if (timing) {
		mTimingDeschedule(timing, &emu->linkEvent);
	}
}

static void gbLinkWriteSb(struct GBSIODriver*, uint8_t) {
}

static uint8_t gbLinkWriteSc(struct GBSIODriver* driver, uint8_t value) {
	struct Emu* emu = ((struct GbLinkDriver*) driver)->emu;
	if (GBRegisterSCIsEnable(value) && GBRegisterSCIsShiftClock(value)) {
		uint8_t local = driver->p->p->memory.io[GB_REG_SB];
		uint32_t remote = 0xFFu;
		if (netLinkExchange(emu->link, 0, local, &remote, 800)) {
			driver->p->pendingSB = (uint8_t) remote;
		}
	}
	return value;
}

static void prepareGbaDriver(struct Emu* emu) {
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

static void prepareGbDriver(struct Emu* emu) {
	struct GBSIODriver* d = &emu->gbLink.d;
	memset(d, 0, sizeof(*d));
	emu->gbLink.emu = emu;
	d->init = gbLinkInit;
	d->deinit = gbLinkDeinit;
	d->writeSB = gbLinkWriteSb;
	d->writeSC = gbLinkWriteSc;
}

static void detachLink(struct Emu* emu) {
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

static void attachLink(struct Emu* emu) {
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
		LOGI("Link attached as P%d", netLinkPlayer(emu->link) + 1);
	}
}

static void pollLink(struct Emu* emu) {
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

extern "C" JNIEXPORT void JNICALL
Java_io_mgba_android_MgbaCore_nativeSetKeys(JNIEnv*, jobject, jlong handle, jint keys) {
	struct Emu* emu = (struct Emu*) handle;
	if (!emu) {
		return;
	}
	noteKeys(emu, (uint32_t) keys);
}

extern "C" JNIEXPORT void JNICALL
Java_io_mgba_android_MgbaCore_nativeSetTurbo(JNIEnv*, jobject, jlong handle, jint mask) {
	struct Emu* emu = (struct Emu*) handle;
	if (!emu) {
		return;
	}
	__atomic_store_n(&emu->turboMask, (uint32_t) mask, __ATOMIC_RELEASE);
	if (!mask) {
		emu->turboCounter = 0;
	}
}

extern "C" JNIEXPORT jboolean JNICALL
Java_io_mgba_android_MgbaCore_nativeRunFrames(JNIEnv*, jobject, jlong handle, jint keys, jint count) {
	struct Emu* emu = (struct Emu*) handle;
	if (!emu || !emu->core) {
		return JNI_FALSE;
	}
	if (count < 1) {
		count = 1;
	}
	(void) keys;
	pollLink(emu);
	if (count == 1 && emu->link && netLinkState(emu->link) == 2) {
		netLinkBarrier(emu->link, 400);
	}
	// Skip drawing the in-between frames. The displayed frame stays in step
	// with the batch so the picture still moves.
	applyFrameskip(emu->core, count > 1 ? count - 1 : emu->userSkip);
	setFastAudio(emu, count > 1);
	for (jint i = 0; i < count; ++i) {
		// Sample again every frame so a short tap is not frozen out of a
		// multi-frame fast-forward batch.
		uint32_t nowKeys = beginFrameKeys(emu);
		if (nowKeys != emu->appliedKeys) {
			emu->appliedKeys = nowKeys;
			LOGI("FrameKeys 0x%x", nowKeys);
		}
		emu->core->setKeys(emu->core, nowKeys);
		emu->core->runFrame(emu->core);
	}
	if (count > 1) {
		struct mAudioBuffer* buffer = emu->core->getAudioBuffer(emu->core);
		if (buffer) {
			mAudioBufferClear(buffer);
		}
	}
	ensureVideo(emu);
	return JNI_TRUE;
}

extern "C" JNIEXPORT jint JNICALL
Java_io_mgba_android_MgbaCore_nativeReadAudio(JNIEnv* env, jobject, jlong handle, jshortArray out) {
	struct Emu* emu = (struct Emu*) handle;
	if (!emu || !emu->core || !out) {
		return 0;
	}
	struct mAudioBuffer* buffer = emu->core->getAudioBuffer(emu->core);
	if (!buffer) {
		return 0;
	}
	size_t available = mAudioBufferAvailable(buffer);
	jsize length = env->GetArrayLength(out);
	size_t maxFrames = (size_t) length / 2;
	if (available > maxFrames) {
		available = maxFrames;
	}
	if (available == 0) {
		return 0;
	}
	jshort* samples = env->GetShortArrayElements(out, NULL);
	if (!samples) {
		return 0;
	}
	size_t read = mAudioBufferRead(buffer, (int16_t*) samples, available);
	env->ReleaseShortArrayElements(out, samples, 0);
	return (jint) read;
}

extern "C" JNIEXPORT void JNICALL
Java_io_mgba_android_MgbaCore_nativeClearAudio(JNIEnv*, jobject, jlong handle) {
	struct Emu* emu = (struct Emu*) handle;
	if (!emu || !emu->core) {
		return;
	}
	struct mAudioBuffer* buffer = emu->core->getAudioBuffer(emu->core);
	if (buffer) {
		mAudioBufferClear(buffer);
	}
}

extern "C" JNIEXPORT jint JNICALL
Java_io_mgba_android_MgbaCore_nativeWidth(JNIEnv*, jobject, jlong handle) {
	struct Emu* emu = (struct Emu*) handle;
	return emu ? (jint) emu->width : 0;
}

extern "C" JNIEXPORT jint JNICALL
Java_io_mgba_android_MgbaCore_nativeHeight(JNIEnv*, jobject, jlong handle) {
	struct Emu* emu = (struct Emu*) handle;
	return emu ? (jint) emu->height : 0;
}

extern "C" JNIEXPORT jint JNICALL
Java_io_mgba_android_MgbaCore_nativeSampleRate(JNIEnv*, jobject, jlong handle) {
	struct Emu* emu = (struct Emu*) handle;
	if (!emu || !emu->core) {
		return 0;
	}
	return (jint) emu->core->audioSampleRate(emu->core);
}

extern "C" JNIEXPORT jboolean JNICALL
Java_io_mgba_android_MgbaCore_nativeCopyVideo(JNIEnv* env, jobject, jlong handle, jobject bitmap) {
	struct Emu* emu = (struct Emu*) handle;
	if (!emu || !emu->video || !bitmap) {
		return JNI_FALSE;
	}
	AndroidBitmapInfo info;
	if (AndroidBitmap_getInfo(env, bitmap, &info) != ANDROID_BITMAP_RESULT_SUCCESS) {
		return JNI_FALSE;
	}
	if (info.format != ANDROID_BITMAP_FORMAT_RGBA_8888 || info.width < emu->width || info.height < emu->height) {
		return JNI_FALSE;
	}
	void* pixels = NULL;
	if (AndroidBitmap_lockPixels(env, bitmap, &pixels) != ANDROID_BITMAP_RESULT_SUCCESS || !pixels) {
		return JNI_FALSE;
	}
	unsigned stride = info.stride / 4;
	size_t pixelsN = (size_t) emu->width * emu->height;
	bool blend = emu->interframe && emu->havePrev && emu->prev;
	unsigned y;
	for (y = 0; y < emu->height; ++y) {
		uint32_t* dst = ((uint32_t*) pixels) + y * stride;
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
				memcpy(emu->prev + y * emu->width, ((uint32_t*) pixels) + y * stride, emu->width * sizeof(uint32_t));
			}
			emu->havePrev = true;
		}
	} else {
		emu->havePrev = false;
	}
	AndroidBitmap_unlockPixels(env, bitmap);
	return JNI_TRUE;
}

extern "C" JNIEXPORT jboolean JNICALL
Java_io_mgba_android_MgbaCore_nativeSaveState(JNIEnv*, jobject, jlong handle, jint slot) {
	struct Emu* emu = (struct Emu*) handle;
	if (!emu || !emu->core || slot < 1 || slot > 9) {
		return JNI_FALSE;
	}
	// A state saved while fast-forwarding must still boot with audio and a picture.
	if (emu->fast > 0) {
		setFastAudio(emu, 0);
	}
	applyFrameskip(emu->core, 0);
	bool ok = mCoreSaveState(emu->core, slot, SAVESTATE_SCREENSHOT | SAVESTATE_SAVEDATA | SAVESTATE_RTC | SAVESTATE_METADATA);
	emu->fast = -1;
	LOGI("State slot %d %s", slot, ok ? "saved" : "failed");
	return ok ? JNI_TRUE : JNI_FALSE;
}

extern "C" JNIEXPORT jboolean JNICALL
Java_io_mgba_android_MgbaCore_nativeLoadState(JNIEnv*, jobject, jlong handle, jint slot) {
	struct Emu* emu = (struct Emu*) handle;
	if (!emu || !emu->core || slot < 1 || slot > 9) {
		return JNI_FALSE;
	}
	bool ok = mCoreLoadState(emu->core, slot, SAVESTATE_SCREENSHOT | SAVESTATE_SAVEDATA | SAVESTATE_RTC);
	if (ok) {
		applyFrameskip(emu->core, 0);
		ensureVideo(emu);
		emu->fast = -1;
		attachKeyCallback(emu);
	}
	LOGI("State slot %d %s", slot, ok ? "loaded" : "missing");
	return ok ? JNI_TRUE : JNI_FALSE;
}

extern "C" JNIEXPORT void JNICALL
Java_io_mgba_android_MgbaCore_nativeReset(JNIEnv*, jobject, jlong handle) {
	struct Emu* emu = (struct Emu*) handle;
	if (!emu || !emu->core) {
		return;
	}
	emu->core->reset(emu->core);
	ensureVideo(emu);
	attachKeyCallback(emu);
	pollLink(emu);
}

extern "C" JNIEXPORT jstring JNICALL
Java_io_mgba_android_MgbaCore_nativeTitle(JNIEnv* env, jobject, jlong handle) {
	struct Emu* emu = (struct Emu*) handle;
	if (!emu || !emu->core) {
		return env->NewStringUTF("");
	}
	struct mGameInfo info;
	memset(&info, 0, sizeof(info));
	emu->core->getGameInfo(emu->core, &info);
	info.title[16] = '\0';
	return asciiString(env, info.title);
}

extern "C" JNIEXPORT jboolean JNICALL
Java_io_mgba_android_MgbaCore_nativeIsLoaded(JNIEnv*, jobject, jlong handle) {
	struct Emu* emu = (struct Emu*) handle;
	return (emu && emu->core) ? JNI_TRUE : JNI_FALSE;
}

extern "C" JNIEXPORT void JNICALL
Java_io_mgba_android_MgbaCore_nativeSetInterframe(JNIEnv*, jobject, jlong handle, jboolean enabled) {
	struct Emu* emu = (struct Emu*) handle;
	if (!emu) {
		return;
	}
	emu->interframe = enabled ? 1 : 0;
	if (!emu->interframe) {
		emu->havePrev = false;
	}
}

extern "C" JNIEXPORT void JNICALL
Java_io_mgba_android_MgbaCore_nativeSetFrameskip(JNIEnv*, jobject, jlong handle, jint skip) {
	struct Emu* emu = (struct Emu*) handle;
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

extern "C" JNIEXPORT jstring JNICALL
Java_io_mgba_android_MgbaCore_nativeSaveFile(JNIEnv* env, jobject, jlong handle) {
	struct Emu* emu = (struct Emu*) handle;
	if (!emu || !emu->core || emu->savePath[0] == '\0' || emu->core->dirs.baseName[0] == '\0') {
		return env->NewStringUTF("");
	}
	size_t bytes = strlen(emu->savePath) + strlen(emu->core->dirs.baseName) + 8;
	char* path = (char*) malloc(bytes);
	if (!path) {
		return env->NewStringUTF("");
	}
	snprintf(path, bytes, "%s/%s.sav", emu->savePath, emu->core->dirs.baseName);
	jstring text = env->NewStringUTF(path);
	free(path);
	return text;
}

extern "C" JNIEXPORT void JNICALL
Java_io_mgba_android_MgbaCore_nativePumpLink(JNIEnv*, jobject, jlong handle) {
	struct Emu* emu = (struct Emu*) handle;
	if (!emu) {
		return;
	}
	pollLink(emu);
	serviceLink(emu);
}

extern "C" JNIEXPORT jboolean JNICALL
Java_io_mgba_android_MgbaCore_nativeLinkHost(JNIEnv*, jobject, jlong handle, jint port) {
	struct Emu* emu = (struct Emu*) handle;
	if (!emu || !emu->link) {
		return JNI_FALSE;
	}
	return netLinkHost(emu->link, port) ? JNI_TRUE : JNI_FALSE;
}

extern "C" JNIEXPORT jboolean JNICALL
Java_io_mgba_android_MgbaCore_nativeLinkJoin(JNIEnv* env, jobject, jlong handle, jstring host, jint port) {
	struct Emu* emu = (struct Emu*) handle;
	if (!emu || !emu->link || !host) {
		return JNI_FALSE;
	}
	const char* text = env->GetStringUTFChars(host, NULL);
	bool ok = text && netLinkJoin(emu->link, text, port);
	if (text) {
		env->ReleaseStringUTFChars(host, text);
	}
	return ok ? JNI_TRUE : JNI_FALSE;
}

extern "C" JNIEXPORT void JNICALL
Java_io_mgba_android_MgbaCore_nativeLinkClose(JNIEnv*, jobject, jlong handle) {
	struct Emu* emu = (struct Emu*) handle;
	if (!emu || !emu->link) {
		return;
	}
	netLinkClose(emu->link);
}

extern "C" JNIEXPORT jstring JNICALL
Java_io_mgba_android_MgbaCore_nativeLinkStatus(JNIEnv* env, jobject, jlong handle) {
	struct Emu* emu = (struct Emu*) handle;
	char text[128];
	text[0] = '\0';
	if (emu && emu->link) {
		netLinkStatusText(emu->link, text, sizeof(text));
	}
	return env->NewStringUTF(text);
}
