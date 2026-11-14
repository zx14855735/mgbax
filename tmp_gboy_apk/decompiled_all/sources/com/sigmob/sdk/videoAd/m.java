package com.sigmob.sdk.videoAd;

import com.sigmob.windad.WindAdError;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public interface m {
    void onAdClicked(String str);

    void onAdClosed(String str);

    void onAdShow(String str);

    void onAdShowError(WindAdError windAdError, String str);

    void onVideoAdPlayComplete(String str);

    void onVideoAdPlayEnd(String str);
}
