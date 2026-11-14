package com.kwad.sdk.api.manager;

import A5SV6n.A2egSU;
import com.kwad.sdk.api.core.KsAdSdkApi;
import com.kwad.sdk.api.loader.Loader;
import com.kwad.sdk.api.model.KSAdInfoData;
import com.kwad.sdk.api.model.KSAdRewardRetryTaskResult;
import java.util.List;

@KsAdSdkApi
@A2egSU
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public interface RewardRetryTaskManager {

    @KsAdSdkApi
    @A2egSU
    public static class Builder {
        @KsAdSdkApi
        @A2egSU
        public static RewardRetryTaskManager build() {
            return (RewardRetryTaskManager) Loader.get().newInstance(RewardRetryTaskManager.class);
        }
    }

    @KsAdSdkApi
    @A2egSU
    public interface RetryRewardConvertResultListener {
        @KsAdSdkApi
        @A2egSU
        void onError(int i, String str);

        @KsAdSdkApi
        @A2egSU
        void onSuccess();
    }

    @KsAdSdkApi
    @A2egSU
    public interface RetryRewardResultListener {
        @KsAdSdkApi
        @A2egSU
        void onError(int i, String str);

        @KsAdSdkApi
        @A2egSU
        void onSuccess(List<KSAdRewardRetryTaskResult> list);
    }

    @KsAdSdkApi
    @A2egSU
    void rewardAdRetryTaskUpdate(KSAdInfoData kSAdInfoData, RetryRewardConvertResultListener retryRewardConvertResultListener);

    @KsAdSdkApi
    @A2egSU
    void setRetryRewardResultListener(List<KSAdInfoData> list, RetryRewardResultListener retryRewardResultListener);
}
