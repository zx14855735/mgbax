package com.bykv.vk.component.ttvideo.player;

@JNINamespace("PLAYER")
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class NativeObject {
    protected long mNativeObj = 0;

    @CalledByNative
    private long getNativeObj() {
        return this.mNativeObj;
    }

    private native void nativeRelease(long j);

    public void finalize() {
    }

    public synchronized void release() {
        long j = this.mNativeObj;
        if (j != 0) {
            nativeRelease(j);
            this.mNativeObj = 0L;
        }
    }

    public void setNativeObj(long j) {
        this.mNativeObj = j;
    }
}
