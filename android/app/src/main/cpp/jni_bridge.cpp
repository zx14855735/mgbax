#include <jni.h>
#include <android/bitmap.h>
#include <android/log.h>

#include <mgba/core/core.h>
#include <mgba/core/interface.h>
#include <mgba/internal/gba/gba.h>
#include <mgba/internal/gba/savedata.h>
#include <mgba/internal/gb/gb.h>
#include <mgba-util/audio-buffer.h>

#include <stddef.h>
#include <stdint.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/stat.h>

#define LOG_TAG "mGBA"
#define LOGE(...) __android_log_print(ANDROID_LOG_ERROR, LOG_TAG, __VA_ARGS__)
#define LOGI(...) __android_log_print(ANDROID_LOG_INFO, LOG_TAG, __VA_ARGS__)

struct Emu {
	struct mCore* core;
	mColor* video;
	unsigned width;
	unsigned height;
	char savePath[1024];
	char statePath[1024];
	int fast;
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
	mCoreConfigDeinit(&emu->core->config);
	emu->core->deinit(emu->core);
	emu->core = NULL;
	free(emu->video);
	emu->video = NULL;
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
	emu->width = width;
	emu->height = height;
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
	// Skip drawing the in-between frames. The displayed frame stays in step
	// with the batch so the picture still moves.
	applyFrameskip(emu->core, count > 1 ? count - 1 : 0);
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
	unsigned y;
	for (y = 0; y < emu->height; ++y) {
		uint32_t* dst = ((uint32_t*) pixels) + y * stride;
		const mColor* src = emu->video + y * emu->width;
		unsigned x;
		for (x = 0; x < emu->width; ++x) {
			dst[x] = ((uint32_t) src[x]) | 0xFF000000u;
		}
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
	bool ok = mCoreSaveState(emu->core, slot, 0);
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
	bool ok = mCoreLoadState(emu->core, slot, 0);
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
