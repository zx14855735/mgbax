package com.sigmob.sdk.videoAd;

import com.sigmob.windad.WindAdError;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public interface k {
    void onAdLoadError(WindAdError windAdError, String str);

    void onAdLoadSuccess(String str);

    void onAdPreLoadFail(WindAdError windAdError, String str);

    void onAdPreLoadSuccess(String str);
}
