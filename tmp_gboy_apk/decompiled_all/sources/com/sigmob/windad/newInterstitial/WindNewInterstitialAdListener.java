package com.sigmob.windad.newInterstitial;

import com.sigmob.windad.WindAdError;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public interface WindNewInterstitialAdListener {
    void onInterstitialAdClicked(String str);

    void onInterstitialAdClosed(String str);

    void onInterstitialAdLoadError(WindAdError windAdError, String str);

    void onInterstitialAdLoadSuccess(String str);

    void onInterstitialAdPreLoadFail(String str);

    void onInterstitialAdPreLoadSuccess(String str);

    void onInterstitialAdShow(String str);

    void onInterstitialAdShowError(WindAdError windAdError, String str);
}
