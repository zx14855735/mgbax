package com.kwad.sdk.api;

import A5SV6n.A2egSU;
import android.app.Activity;
import com.kwad.sdk.api.KsInnerAd;
import com.kwad.sdk.api.core.KsAdSdkApi;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import com.kwad.sdk.api.model.KSAdInfoData;
import com.kwad.sdk.api.model.KsExtraRewardType;
import java.util.List;
import java.util.Map;

@KsAdSdkApi
@A2egSU
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public interface KsRewardVideoAd extends BaseKSAd {

    @KsAdSdkApi
    @A2egSU
    public interface KSAdRewardRetryTaskListener {
        @KsAdSdkApi
        @A2egSU
        void onAdRewardRetryTaskNotify(KSAdInfoData kSAdInfoData);
    }

    @KsAdSdkApi
    @A2egSU
    public interface RewardAdInteractionListener {
        @KsAdSdkApi
        @A2egSU
        void onAdClicked();

        @KsAdSdkApi
        @A2egSU
        void onExtraRewardVerify(@KsExtraRewardType int i);

        @KsAdSdkApi
        @A2egSU
        void onPageDismiss();

        @KsAdSdkApi
        @A2egSU
        void onRewardStepVerify(int i, int i2);

        @KsAdSdkApi
        @A2egSU
        void onRewardVerify();

        @KsAdSdkApi
        @A2egSU
        void onRewardVerify(Map<String, Object> map);

        @KsAdSdkApi
        @A2egSU
        void onVideoPlayEnd();

        @KsAdSdkApi
        @A2egSU
        void onVideoPlayError(int i, int i2);

        @KsAdSdkApi
        @A2egSU
        void onVideoPlayStart();

        @KsAdSdkApi
        @A2egSU
        void onVideoSkipToEnd(long j);
    }

    @KsAdSdkApi
    @A2egSU
    int getECPM();

    @KsAdSdkApi
    @A2egSU
    int getInteractionType();

    @KsAdSdkApi
    @A2egSU
    List<KSAdInfoData> getKSAdInfoDatas();

    @KsAdSdkApi
    @A2egSU
    int getMaterialType();

    @KsAdSdkApi
    @A2egSU
    boolean isAdEnable();

    @KsAdSdkApi
    @A2egSU
    void reportAdExposureFailed(int i, AdExposureFailedReason adExposureFailedReason);

    @KsAdSdkApi
    @A2egSU
    @Deprecated
    void setBidEcpm(int i);

    @KsAdSdkApi
    @A2egSU
    void setBidEcpm(long j, long j2);

    @KsAdSdkApi
    @A2egSU
    void setInnerAdInteractionListener(KsInnerAd.KsInnerAdInteractionListener ksInnerAdInteractionListener);

    @KsAdSdkApi
    @A2egSU
    void setRewardAdInteractionListener(RewardAdInteractionListener rewardAdInteractionListener);

    @KsAdSdkApi
    @A2egSU
    void setRewardAdRetryTaskCallback(KSAdRewardRetryTaskListener kSAdRewardRetryTaskListener);

    @KsAdSdkApi
    @A2egSU
    void showRewardVideoAd(Activity activity, KsVideoPlayConfig ksVideoPlayConfig);
}
