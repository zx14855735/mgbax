package com.kwad.sdk.core.video.videoview;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public interface c {
    boolean LW();

    int getBufferPercentage();

    long getCurrentPosition();

    long getDuration();

    int getMediaPlayerType();

    boolean isIdle();

    boolean isPaused();

    void pause();

    void release();

    void restart();

    void setKsPlayLogParam(com.kwad.sdk.contentalliance.a.a.a aVar);

    void start();
}
