package com.fl.saas.base.custom.rewardvideo;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public interface CustomRewardVideoEventListener {
    void onReward();

    void onRewardedVideoAdClosed();

    void onRewardedVideoAdPlayClicked();

    void onRewardedVideoAdPlayEnd();

    void onRewardedVideoAdPlayFailed(String str, String str2);

    void onRewardedVideoAdPlayStart();
}
