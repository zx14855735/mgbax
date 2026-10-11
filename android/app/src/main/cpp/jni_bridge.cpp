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
Java_io_mgba_android_MgbaCore_nativeSetKeys(JNIEnv*, jobject, jlong handle, jint keys) {
	mgbaMobileSetKeys((struct MgbaMobile*) handle, (uint32_t) keys);
}

extern "C" JNIEXPORT void JNICALL
Java_io_mgba_android_MgbaCore_nativeSetTurbo(JNIEnv*, jobject, jlong handle, jint mask) {
	mgbaMobileSetTurbo((struct MgbaMobile*) handle, (uint32_t) mask);
}

extern "C" JNIEXPORT jboolean JNICALL
Java_io_mgba_android_MgbaCore_nativeRunFrames(JNIEnv*, jobject, jlong handle, jint, jint count) {
	return mgbaMobileRunFrames((struct MgbaMobile*) handle, count) ? JNI_TRUE : JNI_FALSE;
}

extern "C" JNIEXPORT jint JNICALL
Java_io_mgba_android_MgbaCore_nativeReadAudio(JNIEnv* env, jobject, jlong handle, jshortArray out) {
	if (!out) {
		return 0;
	}
	jsize length = env->GetArrayLength(out);
	jshort* samples = env->GetShortArrayElements(out, NULL);
	int frames = 0;
	if (samples) {
		frames = mgbaMobileReadAudio((struct MgbaMobile*) handle, (int16_t*) samples, (int) (length / 2));
		env->ReleaseShortArrayElements(out, samples, 0);
	}
	return frames;
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
	return mgbaMobileLinkHost((struct MgbaMobile*) handle, port) ? JNI_TRUE : JNI_FALSE;
}

extern "C" JNIEXPORT jboolean JNICALL
Java_io_mgba_android_MgbaCore_nativeLinkJoin(JNIEnv* env, jobject, jlong handle, jstring host, jint port) {
	const char* text = host ? env->GetStringUTFChars(host, NULL) : NULL;
	bool ok = text && mgbaMobileLinkJoin((struct MgbaMobile*) handle, text, port);
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
