/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
#include "mgba_mobile.h"

#include <mgba/core/core.h>
#include <mgba/core/cheats.h>
#include <mgba/core/interface.h>
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

#ifdef __ANDROID__
#include <android/log.h>
#define MOBILE_LOGI(...) __android_log_print(ANDROID_LOG_INFO, "mGBA", __VA_ARGS__)
#define MOBILE_LOGE(...) __android_log_print(ANDROID_LOG_ERROR, "mGBA", __VA_ARGS__)
#else
#define MOBILE_LOGI(...) ((void) 0)
#define MOBILE_LOGE(...) ((void) 0)
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
	 * yet, use the console's own frame rate. */
	double audioPaceFps;
	/* A reading that left the deadband, waiting for the next window to
	 * confirm it before the resampler follows. 0 = nothing pending. */
	double audioPacePending;
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
};

enum {
	MOBILE_RTC_WALL = 0,
	MOBILE_RTC_FIXED = 1,
	MOBILE_RTC_OFFSET = 2,
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
/* Readings this close to the current pace are measurement noise; following
 * them would modulate the pitch once per window. */
#define MOBILE_AUDIO_PACE_DEADBAND 0.005
/* Two window readings this close to each other are the same change. */
#define MOBILE_AUDIO_PACE_AGREE 0.03
/* How much already-resampled audio the reader may hold back between pumps. */
#define MOBILE_AUDIO_OUT_FRAMES 16384

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

static void deinitAudioOutput(struct MgbaMobile* emu) {
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
	// front-end readings accumulate from there. This also drops a reading a
	// stall may have left pending across the load.
	emu->audioPaceFps = 0.0;
	emu->audioPacePending = 0.0;
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
	return emu;
}

void mgbaMobileDestroy(struct MgbaMobile* emu) {
	if (!emu) {
		return;
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
	uint32_t held = loadHeld(emu);
	uint32_t latch = __atomic_exchange_n(&emu->latchedKeys, 0, __ATOMIC_ACQ_REL);
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

static void serviceLink(struct MgbaMobile* emu) {
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
	struct MgbaMobile* emu = (struct MgbaMobile*) user;
	serviceLink(emu);
	if (emu->linkAttached) {
		mTimingSchedule(timing, &emu->linkEvent, 8192);
	}
}

static bool gbaLinkInit(struct GBASIODriver* driver) {
	struct MgbaMobile* emu = ((struct GbaLinkDriver*) driver)->emu;
	emu->linkEvent.context = emu;
	emu->linkEvent.callback = linkPollEvent;
	emu->linkEvent.name = "Mobile Link";
	emu->linkEvent.priority = 0x70;
	armLinkEvent(emu);
	return true;
}

static void gbaLinkDeinit(struct GBASIODriver* driver) {
	struct MgbaMobile* emu = ((struct GbaLinkDriver*) driver)->emu;
	struct mTiming* timing = coreTiming(emu);
	if (timing) {
		mTimingDeschedule(timing, &emu->linkEvent);
	}
}

static void gbaLinkReset(struct GBASIODriver* driver) {
	armLinkEvent(((struct GbaLinkDriver*) driver)->emu);
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

static uint16_t gbaLinkWriteRcnt(struct GBASIODriver* driver, uint16_t value) {
	UNUSED(driver);
	return value;
}

static bool gbaLinkStart(struct GBASIODriver* driver) {
	UNUSED(driver);
	return true;
}

static void gbaLinkFinishMulti(struct GBASIODriver* driver, uint16_t data[4]) {
	struct MgbaMobile* emu = ((struct GbaLinkDriver*) driver)->emu;
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

bool mgbaMobileRunFrames(struct MgbaMobile* emu, int count) {
	if (!emu || !emu->core) {
		return false;
	}
	if (count < 1) {
		count = 1;
	}
	pollLink(emu);
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
 * Feeds back how many frames per second the front end is actually managing to
 * pace emulation at. The resampler scales its input rate by the emulated
 * console's frame rate over this pace, so a game the device cannot run at full
 * speed still produces audio the playback buffer can consume without
 * underruns. Call about once a second with a measured value.
 *
 * A single measured window is not trustworthy material for the pitch: it can
 * be dragged down by a ROM load, a system pause or a GC run inside the window.
 * Readings within MOBILE_AUDIO_PACE_DEADBAND of the current pace are treated
 * as noise and left to the playback buffer's drift control; anything larger
 * only moves the stream once the next window agrees within
 * MOBILE_AUDIO_PACE_AGREE, so single stalls cannot detune the music while a
 * device that is consistently slow is still followed.
 */
void mgbaMobileSetAudioPaceFps(struct MgbaMobile* emu, double fps) {
	if (!emu || !(fps > 0.0)) {
		return;
	}
	if (fps < MOBILE_AUDIO_PACE_FPS_MIN) {
		fps = MOBILE_AUDIO_PACE_FPS_MIN;
	} else if (fps > MOBILE_AUDIO_PACE_FPS_MAX) {
		fps = MOBILE_AUDIO_PACE_FPS_MAX;
	}
	double old = emu->audioPaceFps > 0.0 ? emu->audioPaceFps : audioNativeFps(emu);
	double delta = fps > old ? fps - old : old - fps;
	if (delta <= old * MOBILE_AUDIO_PACE_DEADBAND) {
		// Close enough that the queue's drift control covers it; following
		// every reading would wobble the pitch once a window.
		emu->audioPacePending = 0.0;
		return;
	}
	if (emu->audioPacePending > 0.0) {
		double gap = fps > emu->audioPacePending ? fps - emu->audioPacePending : emu->audioPacePending - fps;
		if (gap <= emu->audioPacePending * MOBILE_AUDIO_PACE_AGREE) {
			// Two consistent readings in a row: this is a real change.
			if (fps != emu->audioPaceFps) {
				MOBILE_LOGI("Audio pace %.2f fps", fps);
			}
			emu->audioPaceFps = fps;
			emu->audioPacePending = 0.0;
			return;
		}
	}
	// One window can be a stall, not the pacing rate: wait for the next
	// window to agree before moving the stream.
	emu->audioPacePending = fps;
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
	double pace = emu->audioPaceFps > 0.0 ? emu->audioPaceFps : audioNativeFps(emu);
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

void mgbaMobileReset(struct MgbaMobile* emu) {
	if (!emu || !emu->core) {
		return;
	}
	emu->core->reset(emu->core);
	ensureVideo(emu);
	attachKeyCallback(emu);
	pollLink(emu);
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
