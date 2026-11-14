package com.baidu.mobads.sdk.api;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public interface SplashInteractionListener extends SplashAdListener {
    void onAdCacheFailed();

    void onAdCacheSuccess();

    void onAdClick();

    void onAdDismissed();

    void onAdExposed();

    void onAdPresent();

    void onAdSkip();

    void onLpClosed();
}
