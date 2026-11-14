package com.baidu.mobads.sdk.api;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public interface ScreenVideoAdListener {
    void onAdClick();

    void onAdClose(float f);

    void onAdFailed(String str);

    void onAdLoaded();

    void onAdShow();

    void onAdSkip(float f);

    void onVideoDownloadFailed();

    void onVideoDownloadSuccess();

    void playCompletion();
}
