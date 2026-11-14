package com.bytedance.sdk.openadsdk.mediation.ad;

import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public interface IMediationAdSlot {
    Map<String, Object> getExtraObject();

    IMediationNativeToBannerListener getMediationNativeToBannerListener();

    IMediationSplashRequestInfo getMediationSplashRequestInfo();

    int getRewardAmount();

    String getRewardName();

    String getScenarioId();

    float getShakeViewHeight();

    float getShakeViewWidth();

    float getVolume();

    String getWxAppId();

    boolean isAllowShowCloseBtn();

    boolean isBidNotify();

    boolean isMuted();

    boolean isSplashPreLoad();

    boolean isSplashShakeButton();

    boolean isUseSurfaceView();
}
