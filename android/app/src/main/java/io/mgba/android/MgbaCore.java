package io.mgba.android;

import android.graphics.Bitmap;

import java.io.File;

public final class MgbaCore {
    static {
        System.loadLibrary("mgba_jni");
    }

    private long handle;

    public MgbaCore(File saveDir, File stateDir) {
        handle = nativeCreate(saveDir.getAbsolutePath(), stateDir.getAbsolutePath());
        if (handle == 0) {
            throw new RuntimeException("无法创建模拟器");
        }
    }

    public void destroy() {
        if (handle != 0) {
            nativeDestroy(handle);
            handle = 0;
        }
    }

    public boolean load(String path) {
        return handle != 0 && nativeLoad(handle, path);
    }

    public boolean isLoaded() {
        return handle != 0 && nativeIsLoaded(handle);
    }

    public boolean runFrames(int keys, int count) {
        return handle != 0 && nativeRunFrames(handle, keys, count);
    }

    public void setKeys(int keys) {
        if (handle != 0) {
            nativeSetKeys(handle, keys);
        }
    }

    public void setTurbo(int mask) {
        if (handle != 0) {
            nativeSetTurbo(handle, mask);
        }
    }

    public int readAudio(short[] out) {
        return handle == 0 ? 0 : nativeReadAudio(handle, out);
    }

    public void clearAudio() {
        if (handle != 0) {
            nativeClearAudio(handle);
        }
    }

    public int width() {
        return handle == 0 ? 0 : nativeWidth(handle);
    }

    public int height() {
        return handle == 0 ? 0 : nativeHeight(handle);
    }

    public int sampleRate() {
        return handle == 0 ? 0 : nativeSampleRate(handle);
    }

    public boolean copyVideo(Bitmap bitmap) {
        return handle != 0 && nativeCopyVideo(handle, bitmap);
    }

    public boolean saveState(int slot) {
        return handle != 0 && nativeSaveState(handle, slot);
    }

    public boolean loadState(int slot) {
        return handle != 0 && nativeLoadState(handle, slot);
    }

    public void reset() {
        if (handle != 0) {
            nativeReset(handle);
        }
    }

    public String title() {
        return handle == 0 ? "" : nativeTitle(handle);
    }

    private static native long nativeCreate(String saveDir, String stateDir);

    private static native void nativeDestroy(long handle);

    private static native boolean nativeLoad(long handle, String path);

    private static native boolean nativeIsLoaded(long handle);

    private static native void nativeSetKeys(long handle, int keys);

    private static native void nativeSetTurbo(long handle, int mask);

    private static native boolean nativeRunFrames(long handle, int keys, int count);

    private static native int nativeReadAudio(long handle, short[] out);

    private static native void nativeClearAudio(long handle);

    private static native int nativeWidth(long handle);

    private static native int nativeHeight(long handle);

    private static native int nativeSampleRate(long handle);

    private static native boolean nativeCopyVideo(long handle, Bitmap bitmap);

    private static native boolean nativeSaveState(long handle, int slot);

    private static native boolean nativeLoadState(long handle, int slot);

    private static native void nativeReset(long handle);

    private static native String nativeTitle(long handle);
}
