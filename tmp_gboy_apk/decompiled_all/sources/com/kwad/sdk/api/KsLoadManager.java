package com.kwad.sdk.api;

import A5SV6n.A2egSU;
import android.app.Activity;
import com.kwad.sdk.api.core.KsAdSdkApi;
import java.util.List;

@KsAdSdkApi
@A2egSU
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public interface KsLoadManager {

    @KsAdSdkApi
    @A2egSU
    public interface BannerAdListener {
        @KsAdSdkApi
        @A2egSU
        void onBannerAdLoad(KsBannerAd ksBannerAd);

        @KsAdSdkApi
        @A2egSU
        void onError(int i, String str);
    }

    @KsAdSdkApi
    @A2egSU
    public interface DrawAdListener {
        @KsAdSdkApi
        @A2egSU
        void onDrawAdLoad(List<KsDrawAd> list);

        @KsAdSdkApi
        @A2egSU
        void onError(int i, String str);
    }

    @KsAdSdkApi
    @A2egSU
    public interface FeedAdListener {
        @KsAdSdkApi
        @A2egSU
        void onError(int i, String str);

        @KsAdSdkApi
        @A2egSU
        void onFeedAdLoad(List<KsFeedAd> list);
    }

    @KsAdSdkApi
    @A2egSU
    public interface FullScreenVideoAdListener {
        @KsAdSdkApi
        @A2egSU
        void onError(int i, String str);

        @KsAdSdkApi
        @A2egSU
        void onFullScreenVideoAdLoad(List<KsFullScreenVideoAd> list);

        @KsAdSdkApi
        @A2egSU
        void onFullScreenVideoResult(List<KsFullScreenVideoAd> list);
    }

    @KsAdSdkApi
    @A2egSU
    public interface InterstitialAdListener {
        @KsAdSdkApi
        @A2egSU
        void onError(int i, String str);

        @KsAdSdkApi
        @A2egSU
        void onInterstitialAdLoad(List<KsInterstitialAd> list);

        @KsAdSdkApi
        @A2egSU
        void onRequestResult(int i);
    }

    @KsAdSdkApi
    @A2egSU
    public interface NativeAdListener {
        @KsAdSdkApi
        @A2egSU
        void onError(int i, String str);

        @KsAdSdkApi
        @A2egSU
        void onNativeAdLoad(List<KsNativeAd> list);
    }

    @KsAdSdkApi
    @A2egSU
    public interface RewardVideoAdListener {
        @KsAdSdkApi
        @A2egSU
        void onError(int i, String str);

        @KsAdSdkApi
        @A2egSU
        void onRewardVideoAdLoad(List<KsRewardVideoAd> list);

        @KsAdSdkApi
        @A2egSU
        void onRewardVideoResult(List<KsRewardVideoAd> list);
    }

    @KsAdSdkApi
    @A2egSU
    public interface SplashScreenAdListener {
        @KsAdSdkApi
        @A2egSU
        void onError(int i, String str);

        @KsAdSdkApi
        @A2egSU
        void onRequestResult(int i);

        @KsAdSdkApi
        @A2egSU
        void onSplashScreenAdLoad(KsSplashScreenAd ksSplashScreenAd);
    }

    @KsAdSdkApi
    @A2egSU
    String getBidRequestToken(KsScene ksScene);

    @KsAdSdkApi
    @A2egSU
    String getBidRequestTokenV2(KsScene ksScene);

    @KsAdSdkApi
    @A2egSU
    void loadBannerAd(KsScene ksScene, BannerAdListener bannerAdListener);

    @KsAdSdkApi
    @A2egSU
    void loadConfigFeedAd(KsScene ksScene, FeedAdListener feedAdListener);

    @KsAdSdkApi
    @A2egSU
    void loadDrawAd(KsScene ksScene, DrawAdListener drawAdListener);

    @KsAdSdkApi
    @A2egSU
    @Deprecated
    void loadFeedAd(KsScene ksScene, FeedAdListener feedAdListener);

    @KsAdSdkApi
    @A2egSU
    void loadFullScreenVideoAd(KsScene ksScene, FullScreenVideoAdListener fullScreenVideoAdListener);

    @KsAdSdkApi
    @A2egSU
    void loadInterstitialAd(KsScene ksScene, InterstitialAdListener interstitialAdListener);

    @KsAdSdkApi
    @A2egSU
    void loadNativeAd(KsScene ksScene, NativeAdListener nativeAdListener);

    @KsAdSdkApi
    @A2egSU
    void loadNativeAd(String str, NativeAdListener nativeAdListener);

    @KsAdSdkApi
    @A2egSU
    void loadRewardVideoAd(KsScene ksScene, RewardVideoAdListener rewardVideoAdListener);

    @KsAdSdkApi
    @A2egSU
    void loadSplashScreenAd(KsScene ksScene, SplashScreenAdListener splashScreenAdListener);

    boolean showInstallDialog(Activity activity, KsExitInstallListener ksExitInstallListener);
}
