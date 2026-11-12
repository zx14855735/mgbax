/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
#include <jni.h>
#include <android/bitmap.h>

#include "mgba_mobile.h"

#include <stdlib.h>
#include <string.h>

static jstring fromUtf(JNIEnv* env, const char* text) {
	return env->NewStringUTF(text ? text : "");
}

extern "C" JNIEXPORT jlong JNICALL
Java_io_mgba_android_MgbaCore_nativeCreate(JNIEnv* env, jobject, jstring saveDir, jstring stateDir) {
	const char* save = env->GetStringUTFChars(saveDir, NULL);
	const char* state = env->GetStringUTFChars(stateDir, NULL);
	struct MgbaMobile* emu = mgbaMobileCreate(save, state, "android");
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
	mgbaMobileDestroy((struct MgbaMobile*) handle);
}

extern "C" JNIEXPORT jboolean JNICALL
Java_io_mgba_android_MgbaCore_nativeLoad(JNIEnv* env, jobject, jlong handle, jstring path) {
	struct MgbaMobile* emu = (struct MgbaMobile*) handle;
	const char* filename = path ? env->GetStringUTFChars(path, NULL) : NULL;
	bool ok = filename && mgbaMobileLoad(emu, filename);
	if (filename) {
		env->ReleaseStringUTFChars(path, filename);
	}
	return ok ? JNI_TRUE : JNI_FALSE;
}

extern "C" JNIEXPORT void JNICALL
Java_io_mgba_android_MgbaCore_nativeSetSaveDirs(JNIEnv* env, jobject, jlong handle, jstring saveDir, jstring stateDir) {
	struct MgbaMobile* emu = (struct MgbaMobile*) handle;
	const char* save = saveDir ? env->GetStringUTFChars(saveDir, NULL) : NULL;
	const char* state = stateDir ? env->GetStringUTFChars(stateDir, NULL) : NULL;
	mgbaMobileSetSaveDirs(emu, save, state);
	if (save) {
		env->ReleaseStringUTFChars(saveDir, save);
	}
	if (state) {
		env->ReleaseStringUTFChars(stateDir, state);
	}
}

extern "C" JNIEXPORT void JNICALL
Java_io_mgba_android_MgbaCore_nativeSetKeys(JNIEnv*, jobject, jlong handle, jint keys) {
	mgbaMobileSetKeys((struct MgbaMobile*) handle, (uint32_t) keys);
}

extern "C" JNIEXPORT void JNICALL
Java_io_mgba_android_MgbaCore_nativeSetTurbo(JNIEnv*, jobject, jlong handle, jint mask) {
	mgbaMobileSetTurbo((struct MgbaMobile*) handle, (uint32_t) mask);
}

extern "C" JNIEXPORT void JNICALL
Java_io_mgba_android_MgbaCore_nativeSetRewind(JNIEnv*, jobject, jlong handle, jboolean enabled) {
	mgbaMobileSetRewind((struct MgbaMobile*) handle, enabled == JNI_TRUE);
}

extern "C" JNIEXPORT void JNICALL
Java_io_mgba_android_MgbaCore_nativeBusGameStart(JNIEnv*, jobject, jlong handle,
                                                 jint idx, jint menuAt, jint modeDowns) {
	mgbaMobileBusGameStart((struct MgbaMobile*) handle, idx, menuAt, modeDowns);
}

extern "C" JNIEXPORT void JNICALL
Java_io_mgba_android_MgbaCore_nativeBusGameStop(JNIEnv*, jobject, jlong handle) {
	mgbaMobileBusGameStop((struct MgbaMobile*) handle);
}

extern "C" JNIEXPORT jint JNICALL
Java_io_mgba_android_MgbaCore_nativeBusGameTick(JNIEnv*, jobject, jlong handle) {
	return (jint) mgbaMobileBusGameTick((struct MgbaMobile*) handle);
}

extern "C" JNIEXPORT void JNICALL
Java_io_mgba_android_MgbaCore_nativeSetChannelVolumes(JNIEnv* env, jobject, jlong handle, jintArray gains) {
	if (!gains) {
		return;
	}
	jsize length = env->GetArrayLength(gains);
	if (length < 6) {
		return;
	}
	jint* values = env->GetIntArrayElements(gains, NULL);
	if (values) {
		mgbaMobileSetChannelVolumes((struct MgbaMobile*) handle, (const int32_t*) values);
		env->ReleaseIntArrayElements(gains, values, 0);
	}
}

extern "C" JNIEXPORT jboolean JNICALL
Java_io_mgba_android_MgbaCore_nativeRewind(JNIEnv*, jobject, jlong handle, jint seconds) {
	return mgbaMobileRewind((struct MgbaMobile*) handle, seconds) ? JNI_TRUE : JNI_FALSE;
}

extern "C" JNIEXPORT jboolean JNICALL
Java_io_mgba_android_MgbaCore_nativeRunFrames(JNIEnv*, jobject, jlong handle, jint, jint count) {
	/* 核心锁现在已经下沉到 C 层（mgbaMobileRunFrames 内部），iOS 直接调用
	 * 那个函数同样受保护 —— 它不经过这里。这层加锁保留是为了让 JNI 侧的行
	 * 为与历史版本一致；锁是递归的，重复加锁不会自死锁。 */
	struct MgbaMobile* emu = (struct MgbaMobile*) handle;
	mgbaMobileLock(emu);
	bool ok = mgbaMobileRunFrames(emu, count);
	mgbaMobileUnlock(emu);
	return ok ? JNI_TRUE : JNI_FALSE;
}

extern "C" JNIEXPORT jboolean JNICALL
Java_io_mgba_android_MgbaCore_nativeSetAudioOutput(JNIEnv*, jobject, jlong handle, jint outRate) {
	return mgbaMobileSetAudioOutput((struct MgbaMobile*) handle, outRate) ? JNI_TRUE : JNI_FALSE;
}

extern "C" JNIEXPORT jint JNICALL
Java_io_mgba_android_MgbaCore_nativeReadAudioOut(JNIEnv* env, jobject, jlong handle, jshortArray out, jdouble speed, jfloat drift) {
	if (!out) {
		return 0;
	}
	jsize length = env->GetArrayLength(out);
	jshort* samples = env->GetShortArrayElements(out, NULL);
	int frames = 0;
	if (samples) {
		frames = mgbaMobileReadAudioOut((struct MgbaMobile*) handle, (int16_t*) samples, (int) (length / 2), (double) speed, (float) drift);
		env->ReleaseShortArrayElements(out, samples, 0);
	}
	return frames;
}

extern "C" JNIEXPORT void JNICALL
Java_io_mgba_android_MgbaCore_nativeSetAudioPaceFps(JNIEnv*, jobject, jlong handle, jfloat fps) {
	mgbaMobileSetAudioPaceFps((struct MgbaMobile*) handle, (double) fps);
}

extern "C" JNIEXPORT void JNICALL
Java_io_mgba_android_MgbaCore_nativeResetAudioPace(JNIEnv*, jobject, jlong handle) {
	mgbaMobileResetAudioPace((struct MgbaMobile*) handle);
}

extern "C" JNIEXPORT jboolean JNICALL
Java_io_mgba_android_MgbaCore_nativeIsAudioPaceSeeded(JNIEnv*, jobject, jlong handle) {
	return mgbaMobileAudioPaceSeeded((struct MgbaMobile*) handle) ? JNI_TRUE : JNI_FALSE;
}

extern "C" JNIEXPORT void JNICALL
Java_io_mgba_android_MgbaCore_nativeSetAudioConstantPitch(JNIEnv*, jobject, jlong handle, jboolean on, jfloat stretch) {
	mgbaMobileSetAudioConstantPitch((struct MgbaMobile*) handle, on == JNI_TRUE, (double) stretch);
}

extern "C" JNIEXPORT void JNICALL
Java_io_mgba_android_MgbaCore_nativeSetAudioHoldMode(JNIEnv*, jobject, jlong handle, jint mode) {
	mgbaMobileSetAudioHoldMode((struct MgbaMobile*) handle, (int) mode);
}

extern "C" JNIEXPORT void JNICALL
Java_io_mgba_android_MgbaCore_nativeClearAudio(JNIEnv*, jobject, jlong handle) {
	mgbaMobileClearAudio((struct MgbaMobile*) handle);
}

extern "C" JNIEXPORT jint JNICALL
Java_io_mgba_android_MgbaCore_nativeWidth(JNIEnv*, jobject, jlong handle) {
	return mgbaMobileWidth((struct MgbaMobile*) handle);
}

extern "C" JNIEXPORT jint JNICALL
Java_io_mgba_android_MgbaCore_nativeHeight(JNIEnv*, jobject, jlong handle) {
	return mgbaMobileHeight((struct MgbaMobile*) handle);
}

extern "C" JNIEXPORT jint JNICALL
Java_io_mgba_android_MgbaCore_nativeSampleRate(JNIEnv*, jobject, jlong handle) {
	return mgbaMobileSampleRate((struct MgbaMobile*) handle);
}

extern "C" JNIEXPORT jlong JNICALL
Java_io_mgba_android_MgbaCore_nativeFrameNanos(JNIEnv*, jobject, jlong handle) {
	return (jlong) mgbaMobileFrameNanos((const struct MgbaMobile*) handle);
}

extern "C" JNIEXPORT jboolean JNICALL
Java_io_mgba_android_MgbaCore_nativeCopyVideo(JNIEnv* env, jobject, jlong handle, jobject bitmap) {
	struct MgbaMobile* emu = (struct MgbaMobile*) handle;
	AndroidBitmapInfo info;
	void* pixels = NULL;
	int width;
	int height;
	if (!emu || !bitmap) {
		return JNI_FALSE;
	}
	width = mgbaMobileWidth(emu);
	height = mgbaMobileHeight(emu);
	if (AndroidBitmap_getInfo(env, bitmap, &info) != ANDROID_BITMAP_RESULT_SUCCESS) {
		return JNI_FALSE;
	}
	if (info.format != ANDROID_BITMAP_FORMAT_RGBA_8888 || (int) info.width < width || (int) info.height < height) {
		return JNI_FALSE;
	}
	if (AndroidBitmap_lockPixels(env, bitmap, &pixels) != ANDROID_BITMAP_RESULT_SUCCESS || !pixels) {
		return JNI_FALSE;
	}
	bool ok = mgbaMobileCopyVideo(emu, (uint32_t*) pixels, (int) (info.stride / 4));
	AndroidBitmap_unlockPixels(env, bitmap);
	return ok ? JNI_TRUE : JNI_FALSE;
}

extern "C" JNIEXPORT jboolean JNICALL
Java_io_mgba_android_MgbaCore_nativeSaveState(JNIEnv*, jobject, jlong handle, jint slot) {
	return mgbaMobileSaveState((struct MgbaMobile*) handle, slot) ? JNI_TRUE : JNI_FALSE;
}

extern "C" JNIEXPORT jboolean JNICALL
Java_io_mgba_android_MgbaCore_nativeLoadState(JNIEnv*, jobject, jlong handle, jint slot) {
	return mgbaMobileLoadState((struct MgbaMobile*) handle, slot) ? JNI_TRUE : JNI_FALSE;
}

extern "C" JNIEXPORT jbyteArray JNICALL
Java_io_mgba_android_MgbaCore_nativeSaveStateToMemory(JNIEnv* env, jobject, jlong handle) {
	void* data = NULL;
	size_t size = 0;
	struct MgbaMobile* emu = (struct MgbaMobile*) handle;
	mgbaMobileLock(emu);
	bool ok = mgbaMobileSaveStateToMemory(emu, &data, &size);
	mgbaMobileUnlock(emu);
	if (!ok || !data || size == 0 || size > 0x7FFFFFFFu) {
		mgbaMobileFreeState(data);
		return NULL;
	}
	jbyteArray out = env->NewByteArray((jsize) size);
	if (out) {
		env->SetByteArrayRegion(out, 0, (jsize) size, (const jbyte*) data);
	}
	mgbaMobileFreeState(data);
	return out;
}

extern "C" JNIEXPORT jboolean JNICALL
Java_io_mgba_android_MgbaCore_nativeLoadStateFromMemory(JNIEnv* env, jobject, jlong handle, jbyteArray state) {
	if (!state) {
		return JNI_FALSE;
	}
	jsize size = env->GetArrayLength(state);
	if (size <= 0) {
		return JNI_FALSE;
	}
	jbyte* bytes = env->GetByteArrayElements(state, NULL);
	if (!bytes) {
		return JNI_FALSE;
	}
	struct MgbaMobile* emu = (struct MgbaMobile*) handle;
	mgbaMobileLock(emu);
	bool ok = mgbaMobileLoadStateFromMemory(emu, bytes, (size_t) size);
	mgbaMobileUnlock(emu);
	env->ReleaseByteArrayElements(state, bytes, JNI_ABORT);
	return ok ? JNI_TRUE : JNI_FALSE;
}

extern "C" JNIEXPORT void JNICALL
Java_io_mgba_android_MgbaCore_nativeReset(JNIEnv*, jobject, jlong handle) {
	mgbaMobileReset((struct MgbaMobile*) handle);
}

extern "C" JNIEXPORT jstring JNICALL
Java_io_mgba_android_MgbaCore_nativeTitle(JNIEnv* env, jobject, jlong handle) {
	char text[32];
	mgbaMobileTitle((struct MgbaMobile*) handle, text, sizeof(text));
	return fromUtf(env, text);
}

extern "C" JNIEXPORT jboolean JNICALL
Java_io_mgba_android_MgbaCore_nativeIsLoaded(JNIEnv*, jobject, jlong handle) {
	return mgbaMobileIsLoaded((struct MgbaMobile*) handle) ? JNI_TRUE : JNI_FALSE;
}

extern "C" JNIEXPORT void JNICALL
Java_io_mgba_android_MgbaCore_nativeSetInterframe(JNIEnv*, jobject, jlong handle, jboolean enabled) {
	mgbaMobileSetInterframe((struct MgbaMobile*) handle, enabled == JNI_TRUE);
}

extern "C" JNIEXPORT void JNICALL
Java_io_mgba_android_MgbaCore_nativeSetFrameskip(JNIEnv*, jobject, jlong handle, jint skip) {
	mgbaMobileSetFrameskip((struct MgbaMobile*) handle, skip);
}

extern "C" JNIEXPORT jstring JNICALL
Java_io_mgba_android_MgbaCore_nativeSaveFile(JNIEnv* env, jobject, jlong handle) {
	char text[1200];
	mgbaMobileSaveFile((struct MgbaMobile*) handle, text, sizeof(text));
	return fromUtf(env, text);
}

extern "C" JNIEXPORT void JNICALL
Java_io_mgba_android_MgbaCore_nativePumpLink(JNIEnv*, jobject, jlong handle) {
	mgbaMobilePumpLink((struct MgbaMobile*) handle);
}

extern "C" JNIEXPORT jboolean JNICALL
Java_io_mgba_android_MgbaCore_nativeLinkHost(JNIEnv*, jobject, jlong handle, jint port) {
	return mgbaMobileLinkHost((struct MgbaMobile*) handle, port, 2) ? JNI_TRUE : JNI_FALSE;
}

extern "C" JNIEXPORT jboolean JNICALL
Java_io_mgba_android_MgbaCore_nativeLinkHostPlayers(JNIEnv*, jobject, jlong handle, jint port, jint players) {
	return mgbaMobileLinkHost((struct MgbaMobile*) handle, port, players) ? JNI_TRUE : JNI_FALSE;
}

extern "C" JNIEXPORT jboolean JNICALL
Java_io_mgba_android_MgbaCore_nativeLinkJoin(JNIEnv* env, jobject, jlong handle, jstring host, jint port) {
	const char* text = host ? env->GetStringUTFChars(host, NULL) : NULL;
	bool ok = text && mgbaMobileLinkJoin((struct MgbaMobile*) handle, text, port, 2);
	if (text) {
		env->ReleaseStringUTFChars(host, text);
	}
	return ok ? JNI_TRUE : JNI_FALSE;
}

extern "C" JNIEXPORT jboolean JNICALL
Java_io_mgba_android_MgbaCore_nativeLinkHostLocal(JNIEnv*, jobject, jlong handle, jint key, jint players) {
	return mgbaMobileLinkHostLocal((struct MgbaMobile*) handle, key, players) ? JNI_TRUE : JNI_FALSE;
}

extern "C" JNIEXPORT jboolean JNICALL
Java_io_mgba_android_MgbaCore_nativeLinkJoinLocal(JNIEnv*, jobject, jlong handle, jint key) {
	return mgbaMobileLinkJoinLocal((struct MgbaMobile*) handle, key) ? JNI_TRUE : JNI_FALSE;
}

extern "C" JNIEXPORT jboolean JNICALL
Java_io_mgba_android_MgbaCore_nativeLinkJoinLocalSlot(JNIEnv*, jobject, jlong handle, jint key, jint slot) {
	return mgbaMobileLinkJoinLocalSlot((struct MgbaMobile*) handle, key, slot) ? JNI_TRUE : JNI_FALSE;
}

/* 进程内锁步 SIO：显式启用才生效，默认仍走共享内存总线/环回直连。 */
extern "C" JNIEXPORT jboolean JNICALL
Java_io_mgba_android_MgbaCore_nativeLinkHostLockstep(JNIEnv*, jobject, jlong handle,
                                                     jint key, jint players, jint slot) {
	return mgbaMobileLinkHostLockstep((struct MgbaMobile*) handle, key, players, slot)
		? JNI_TRUE : JNI_FALSE;
}

extern "C" JNIEXPORT jboolean JNICALL
Java_io_mgba_android_MgbaCore_nativeLinkJoinLockstep(JNIEnv*, jobject, jlong handle,
                                                     jint key, jint slot) {
	return mgbaMobileLinkJoinLockstep((struct MgbaMobile*) handle, key, slot)
		? JNI_TRUE : JNI_FALSE;
}

extern "C" JNIEXPORT jboolean JNICALL
Java_io_mgba_android_MgbaCore_nativeLinkJoinPlayers(JNIEnv* env, jobject, jlong handle, jstring host, jint port, jint players) {
	const char* text = host ? env->GetStringUTFChars(host, NULL) : NULL;
	bool ok = text && mgbaMobileLinkJoin((struct MgbaMobile*) handle, text, port, players);
	if (text) {
		env->ReleaseStringUTFChars(host, text);
	}
	return ok ? JNI_TRUE : JNI_FALSE;
}

extern "C" JNIEXPORT void JNICALL
Java_io_mgba_android_MgbaCore_nativeLinkClose(JNIEnv*, jobject, jlong handle) {
	mgbaMobileLinkClose((struct MgbaMobile*) handle);
}

extern "C" JNIEXPORT jstring JNICALL
Java_io_mgba_android_MgbaCore_nativeLinkStatus(JNIEnv* env, jobject, jlong handle) {
	char text[128];
	mgbaMobileLinkStatus((struct MgbaMobile*) handle, text, sizeof(text));
	return fromUtf(env, text);
}

extern "C" JNIEXPORT void JNICALL
Java_io_mgba_android_MgbaCore_nativeSetSaveType(JNIEnv*, jobject, jlong handle, jint type) {
	mgbaMobileSetSaveType((struct MgbaMobile*) handle, type);
}

extern "C" JNIEXPORT void JNICALL
Java_io_mgba_android_MgbaCore_nativeSetPatches(JNIEnv*, jobject, jlong handle, jboolean enabled) {
	mgbaMobileSetPatches((struct MgbaMobile*) handle, enabled == JNI_TRUE);
}

extern "C" JNIEXPORT void JNICALL
Java_io_mgba_android_MgbaCore_nativeSetBiosOptions(JNIEnv*, jobject, jlong handle, jboolean useBios, jboolean skipIntro) {
	mgbaMobileSetBiosOptions((struct MgbaMobile*) handle, useBios == JNI_TRUE, skipIntro == JNI_TRUE);
}

extern "C" JNIEXPORT void JNICALL
Java_io_mgba_android_MgbaCore_nativeSetRtc(JNIEnv*, jobject, jlong handle, jint mode, jlong epoch, jlong offset) {
	mgbaMobileSetRtc((struct MgbaMobile*) handle, mode, (int64_t) epoch, (int64_t) offset);
}

extern "C" JNIEXPORT void JNICALL
Java_io_mgba_android_MgbaCore_nativeSetSolar(JNIEnv*, jobject, jlong handle, jint level) {
	mgbaMobileSetSolar((struct MgbaMobile*) handle, level);
}

extern "C" JNIEXPORT void JNICALL
Java_io_mgba_android_MgbaCore_nativeSetCartRumble(JNIEnv*, jobject, jlong handle, jboolean enabled) {
	mgbaMobileSetCartRumble((struct MgbaMobile*) handle, enabled == JNI_TRUE);
}

extern "C" JNIEXPORT jint JNICALL
Java_io_mgba_android_MgbaCore_nativeTakeRumbles(JNIEnv*, jobject, jlong handle) {
	return mgbaMobileTakeRumbles((struct MgbaMobile*) handle);
}

extern "C" JNIEXPORT void JNICALL
Java_io_mgba_android_MgbaCore_nativeSetGbPalette(JNIEnv* env, jobject, jlong handle, jintArray colors) {
	if (!colors) {
		return;
	}
	jsize length = env->GetArrayLength(colors);
	if (length < 12) {
		return;
	}
	jint* values = env->GetIntArrayElements(colors, NULL);
	if (values) {
		mgbaMobileSetGbPalette((struct MgbaMobile*) handle, (const int32_t*) values);
		env->ReleaseIntArrayElements(colors, values, 0);
	}
}

extern "C" JNIEXPORT void JNICALL
Java_io_mgba_android_MgbaCore_nativeSetSgbBorders(JNIEnv*, jobject, jlong handle, jboolean enabled) {
	mgbaMobileSetSgbBorders((struct MgbaMobile*) handle, enabled == JNI_TRUE);
}

extern "C" JNIEXPORT void JNICALL
Java_io_mgba_android_MgbaCore_nativeSetRotation(JNIEnv*, jobject, jlong handle, jfloat tiltX, jfloat tiltY, jfloat gyroZ) {
	mgbaMobileSetRotation((struct MgbaMobile*) handle, tiltX, tiltY, gyroZ);
}

extern "C" JNIEXPORT jint JNICALL
Java_io_mgba_android_MgbaCore_nativeCheatCount(JNIEnv*, jobject, jlong handle) {
	return mgbaMobileCheatCount((struct MgbaMobile*) handle);
}

extern "C" JNIEXPORT jstring JNICALL
Java_io_mgba_android_MgbaCore_nativeCheatName(JNIEnv* env, jobject, jlong handle, jint index) {
	char text[256];
	mgbaMobileCheatName((struct MgbaMobile*) handle, index, text, sizeof(text));
	return fromUtf(env, text);
}

extern "C" JNIEXPORT jboolean JNICALL
Java_io_mgba_android_MgbaCore_nativeCheatEnabled(JNIEnv*, jobject, jlong handle, jint index) {
	return mgbaMobileCheatEnabled((struct MgbaMobile*) handle, index) ? JNI_TRUE : JNI_FALSE;
}

extern "C" JNIEXPORT void JNICALL
Java_io_mgba_android_MgbaCore_nativeCheatSetEnabled(JNIEnv*, jobject, jlong handle, jint index, jboolean enabled) {
	mgbaMobileCheatSetEnabled((struct MgbaMobile*) handle, index, enabled == JNI_TRUE);
}

extern "C" JNIEXPORT jboolean JNICALL
Java_io_mgba_android_MgbaCore_nativeCheatAdd(JNIEnv* env, jobject, jlong handle, jstring name, jstring lines, jint type) {
	const char* nameText = name ? env->GetStringUTFChars(name, NULL) : NULL;
	const char* lineText = env->GetStringUTFChars(lines, NULL);
	bool ok = lineText && mgbaMobileCheatAdd((struct MgbaMobile*) handle, nameText, lineText, type);
	if (nameText) {
		env->ReleaseStringUTFChars(name, nameText);
	}
	if (lineText) {
		env->ReleaseStringUTFChars(lines, lineText);
	}
	return ok ? JNI_TRUE : JNI_FALSE;
}

extern "C" JNIEXPORT jboolean JNICALL
Java_io_mgba_android_MgbaCore_nativeCheatRemove(JNIEnv*, jobject, jlong handle, jint index) {
	return mgbaMobileCheatRemove((struct MgbaMobile*) handle, index) ? JNI_TRUE : JNI_FALSE;
}

extern "C" JNIEXPORT jint JNICALL
Java_io_mgba_android_MgbaCore_nativeBusRead(JNIEnv*, jobject, jlong handle, jint width, jint address) {
	return (jint) mgbaMobileBusRead((struct MgbaMobile*) handle, width, (uint32_t) address);
}

extern "C" JNIEXPORT jboolean JNICALL
Java_io_mgba_android_MgbaCore_nativeBusWrite(JNIEnv*, jobject, jlong handle, jint width, jint address, jint value) {
	return mgbaMobileBusWrite((struct MgbaMobile*) handle, width, (uint32_t) address, (uint32_t) value)
			? JNI_TRUE : JNI_FALSE;
}

extern "C" JNIEXPORT jbyteArray JNICALL
Java_io_mgba_android_MgbaCore_nativeBusReadBlock(JNIEnv* env, jobject, jlong handle, jint address, jint size) {
	if (size <= 0 || size > 0x100000) {
		return NULL;
	}
	jbyteArray result = env->NewByteArray(size);
	if (!result) {
		return NULL;
	}
	uint8_t* buffer = (uint8_t*) malloc((size_t) size);
	if (!buffer) {
		return NULL;
	}
	int copied = mgbaMobileBusReadBlock((struct MgbaMobile*) handle, (uint32_t) address, size, buffer);
	if (copied > 0) {
		env->SetByteArrayRegion(result, 0, copied, (jbyte*) buffer);
	}
	free(buffer);
	return result;
}
