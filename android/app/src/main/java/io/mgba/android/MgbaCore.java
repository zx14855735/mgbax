/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
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

    /**
     * Configures the native audio resampler for the given output rate.
     * Returns false when the core cannot be converted to that rate.
     */
    public boolean setAudioOutput(int outRate) {
        return handle != 0 && nativeSetAudioOutput(handle, outRate);
    }

    /**
     * Reads audio already converted to the configured output rate.
     *
     * @param speed emulated frames per paced frame, i.e. the fast-forward factor
     * @param drift small ratio adjustment (about +/-0.02) for playback buffer level control
     * @return number of stereo frames written into {@code out}
     */
    public int readAudioOut(short[] out, int speed, float drift) {
        return handle == 0 ? 0 : nativeReadAudioOut(handle, out, speed, drift);
    }

    /**
     * Reports how many frames per second the emulation loop is really managing
     * so the resampler can follow the device instead of a nominal 60. Call
     * about once a second with a measured average.
     */
    public void setAudioPaceFps(float fps) {
        if (handle != 0) {
            nativeSetAudioPaceFps(handle, fps);
        }
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

    /**
     * Nanoseconds per emulated frame at the console's own rate (about 59.73 Hz
     * for GBA and GB), or 0 when no core is loaded. The emulation loop paces
     * with this so game speed and audio pitch match hardware instead of a
     * rounded 60 fps.
     */
    public long frameNanos() {
        return handle == 0 ? 0 : nativeFrameNanos(handle);
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

    public void setInterframe(boolean enabled) {
        if (handle != 0) {
            nativeSetInterframe(handle, enabled);
        }
    }

    public void setFrameskip(int skip) {
        if (handle != 0) {
            nativeSetFrameskip(handle, skip);
        }
    }

    public String saveFile() {
        return handle == 0 ? "" : nativeSaveFile(handle);
    }

    public void pumpLink() {
        if (handle != 0) {
            nativePumpLink(handle);
        }
    }

    public boolean linkHost(int port) {
        return handle != 0 && nativeLinkHost(handle, port);
    }

    public boolean linkJoin(String host, int port) {
        return handle != 0 && host != null && nativeLinkJoin(handle, host, port);
    }

    public void linkClose() {
        if (handle != 0) {
            nativeLinkClose(handle);
        }
    }

    public String linkStatus() {
        return handle == 0 ? "" : nativeLinkStatus(handle);
    }

    private static native long nativeCreate(String saveDir, String stateDir);

    private static native void nativeDestroy(long handle);

    private static native boolean nativeLoad(long handle, String path);

    private static native boolean nativeIsLoaded(long handle);

    private static native void nativeSetKeys(long handle, int keys);

    private static native void nativeSetTurbo(long handle, int mask);

    private static native boolean nativeRunFrames(long handle, int keys, int count);

    private static native int nativeReadAudioOut(long handle, short[] out, int speed, float drift);
    private static native void nativeSetAudioPaceFps(long handle, float fps);

    private static native boolean nativeSetAudioOutput(long handle, int outRate);

    private static native void nativeClearAudio(long handle);

    private static native int nativeWidth(long handle);

    private static native int nativeHeight(long handle);

    private static native int nativeSampleRate(long handle);

    private static native long nativeFrameNanos(long handle);

    private static native boolean nativeCopyVideo(long handle, Bitmap bitmap);

    private static native boolean nativeSaveState(long handle, int slot);

    private static native boolean nativeLoadState(long handle, int slot);

    private static native void nativeReset(long handle);

    private static native String nativeTitle(long handle);

    private static native void nativeSetInterframe(long handle, boolean enabled);

    private static native void nativeSetFrameskip(long handle, int skip);

    private static native String nativeSaveFile(long handle);

    private static native void nativePumpLink(long handle);

    private static native boolean nativeLinkHost(long handle, int port);

    private static native boolean nativeLinkJoin(long handle, String host, int port);

    private static native void nativeLinkClose(long handle);

    private static native String nativeLinkStatus(long handle);
}
