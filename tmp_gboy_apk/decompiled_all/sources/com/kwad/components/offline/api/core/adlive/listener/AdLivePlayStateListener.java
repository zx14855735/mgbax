package com.kwad.components.offline.api.core.adlive.listener;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public interface AdLivePlayStateListener {
    void onLiveAudioEnableChange(boolean z);

    void onLivePlayCompleted();

    void onLivePlayEnd();

    void onLivePlayPause();

    void onLivePlayProgress(long j);

    void onLivePlayResume();

    void onLivePlayStart();

    void onLivePrepared();
}
