package com.kwad.sdk.api;

import A5SV6n.A2egSU;
import android.content.Context;
import android.view.View;
import com.kwad.sdk.api.core.KsAdSdkApi;
import com.kwad.sdk.api.model.AdExposureFailedReason;

@KsAdSdkApi
@A2egSU
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public interface KsBannerAd extends BaseKSAd {

    @KsAdSdkApi
    @A2egSU
    public interface BannerAdInteractionListener {
        @KsAdSdkApi
        @A2egSU
        void onAdClicked();

        @KsAdSdkApi
        @A2egSU
        void onAdClose();

        @KsAdSdkApi
        @A2egSU
        void onAdShow();

        @KsAdSdkApi
        @A2egSU
        void onAdShowError(int i, String str);
    }

    @KsAdSdkApi
    @A2egSU
    int getECPM();

    @KsAdSdkApi
    @A2egSU
    int getInteractionType();

    @KsAdSdkApi
    @A2egSU
    int getMaterialType();

    @KsAdSdkApi
    @A2egSU
    View getView(Context context, BannerAdInteractionListener bannerAdInteractionListener, KsAdVideoPlayConfig ksAdVideoPlayConfig);

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
    boolean supportPushAd();
}
