package com.fl.saas.s2s.sdk.ad.video.reward;

import com.fl.saas.config.exception.YdError;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public interface OnS2SRewardVideoADListener {
    void onClick(String str);

    void onClose();

    void onComplete(double d);

    void onError(YdError ydError);

    void onLoad(S2SRewardVideoADManager s2SRewardVideoADManager);

    void onReward(double d);

    void onRewardVideoAdFailed(YdError ydError);
}
