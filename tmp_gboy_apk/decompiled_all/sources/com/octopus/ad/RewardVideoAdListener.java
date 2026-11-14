package com.octopus.ad;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public interface RewardVideoAdListener {
    void onRewardVideoAdClicked();

    void onRewardVideoAdClosed();

    void onRewardVideoAdComplete();

    void onRewardVideoAdFailedToLoad(int i);

    void onRewardVideoAdLoaded();

    void onRewardVideoAdShown();

    void onRewardVideoCached(boolean z);

    void onRewarded(RewardItem rewardItem);
}
