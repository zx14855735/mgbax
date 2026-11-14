package com.octopus.ad;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public interface SplashAdListener {
    void onAdCacheLoaded(boolean z);

    void onAdClicked();

    void onAdClosed();

    void onAdFailedToLoad(int i);

    void onAdLoaded();

    void onAdShown();

    void onAdTick(long j);
}
