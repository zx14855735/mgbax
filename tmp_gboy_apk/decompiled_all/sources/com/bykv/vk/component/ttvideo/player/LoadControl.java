package com.bykv.vk.component.ttvideo.player;

@JNINamespace("PLAYER")
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class LoadControl extends NativeObject {
    @CalledByNative
    public abstract int onCodecStackSelected(int i);

    @CalledByNative
    public abstract int onFilterStackSelected(int i);

    @CalledByNative
    public abstract int onTrackSelected(int i);

    @CalledByNative
    public abstract boolean shouldStartPlayback(long j, float f, boolean z);
}
