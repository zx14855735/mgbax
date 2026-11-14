package com.fl.saas.base.inner.reward;

import com.fl.saas.api.mixNative.NativeAd;
import com.fl.saas.common.saas.bean.AdSource;
import com.fl.saas.config.exception.YdError;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public interface InnerRewardVideoListener {
    AdSource getRewardVideoAdSource();

    NativeAd getRewardVideoNativeAd();

    void onClick();

    void onClose();

    void onError(YdError ydError);

    void onReward();

    void onShow();

    void onVideoComplete();
}
