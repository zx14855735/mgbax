package com.octopus.ad.internal.video;

import com.octopus.ad.utils.b.f;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public abstract class VideoStateListener {
    public void onVideoCompleted() {
        f.b("VideoStateListener", "onVideoCompleted");
    }

    public void onVideoError(int i, int i2) {
        f.b("VideoStateListener", "onVideoError");
    }

    public void onVideoPause() {
        f.b("VideoStateListener", "onVideoPause");
    }

    public void onVideoReady() {
        f.b("VideoStateListener", "onVideoReady");
    }

    public void onVideoResume() {
        f.b("VideoStateListener", "onVideoResume");
    }

    public void onVideoStart() {
        f.b("VideoStateListener", "onVideoStart");
    }
}
