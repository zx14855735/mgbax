package com.baidu.mobads.sdk.api;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public interface CPUDramaListener {
    void onADExposed(CPUAdType cPUAdType);

    void onADExposureFailed(CPUAdType cPUAdType);

    void onAdClick(CPUAdType cPUAdType);

    void onContentFailed(int i, String str);

    void onContentLoaded();

    void onVideoCollect(CPUDramaResponse cPUDramaResponse);

    void onVideoPlay(CPUDramaResponse cPUDramaResponse);
}
