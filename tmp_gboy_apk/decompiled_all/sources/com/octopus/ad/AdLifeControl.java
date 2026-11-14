package com.octopus.ad;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public interface AdLifeControl {
    void cancel();

    void destroy();

    void onCreateLifeCycle();

    void onDestroyLifeCycle();

    void onPauseLifeCycle();

    void onRestartLifeCycle();

    void onResumeLifeCycle();

    void onStartLifeCycle();

    void onStopLifeCycle();
}
