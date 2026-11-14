package com.kwad.sdk.api;

import android.app.Activity;
import com.kwad.sdk.api.KsLoadManager;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class b implements KsLoadManager {
    @Override // com.kwad.sdk.api.KsLoadManager
    public final String getBidRequestToken(KsScene ksScene) {
        return "";
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public final String getBidRequestTokenV2(KsScene ksScene) {
        return "";
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public final void loadBannerAd(KsScene ksScene, KsLoadManager.BannerAdListener bannerAdListener) {
        bannerAdListener.onError(0, "SDK not init success");
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public final void loadConfigFeedAd(KsScene ksScene, KsLoadManager.FeedAdListener feedAdListener) {
        feedAdListener.onError(0, "SDK not init success");
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public final void loadDrawAd(KsScene ksScene, KsLoadManager.DrawAdListener drawAdListener) {
        drawAdListener.onError(0, "SDK not init success");
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public final void loadFeedAd(KsScene ksScene, KsLoadManager.FeedAdListener feedAdListener) {
        feedAdListener.onError(0, "SDK not init success");
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public final void loadFullScreenVideoAd(KsScene ksScene, KsLoadManager.FullScreenVideoAdListener fullScreenVideoAdListener) {
        fullScreenVideoAdListener.onError(0, "SDK not init success");
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public final void loadInterstitialAd(KsScene ksScene, KsLoadManager.InterstitialAdListener interstitialAdListener) {
        interstitialAdListener.onError(0, "SDK not init success");
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public final void loadNativeAd(KsScene ksScene, KsLoadManager.NativeAdListener nativeAdListener) {
        nativeAdListener.onError(0, "SDK not init success");
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public final void loadRewardVideoAd(KsScene ksScene, KsLoadManager.RewardVideoAdListener rewardVideoAdListener) {
        rewardVideoAdListener.onError(0, "SDK not init success");
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public final void loadSplashScreenAd(KsScene ksScene, KsLoadManager.SplashScreenAdListener splashScreenAdListener) {
        splashScreenAdListener.onError(0, "SDK not init success");
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public final boolean showInstallDialog(Activity activity, KsExitInstallListener ksExitInstallListener) {
        return false;
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public final void loadNativeAd(String str, KsLoadManager.NativeAdListener nativeAdListener) {
        nativeAdListener.onError(0, "SDK not init success");
    }
}
