package com.sigmob.windad.rewardVideo;

import com.sigmob.windad.WindAdError;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public interface WindRewardVideoAdListener {
    void onRewardAdClicked(String str);

    void onRewardAdClosed(String str);

    void onRewardAdLoadError(WindAdError windAdError, String str);

    void onRewardAdLoadSuccess(String str);

    void onRewardAdPlayEnd(String str);

    void onRewardAdPlayError(WindAdError windAdError, String str);

    void onRewardAdPlayStart(String str);

    void onRewardAdPreLoadFail(String str);

    void onRewardAdPreLoadSuccess(String str);

    void onRewardAdRewarded(WindRewardInfo windRewardInfo, String str);
}
