package com.kwad.sdk.api;

import A5SV6n.A2egSU;
import android.content.Context;
import android.view.View;
import com.kwad.sdk.api.core.KsAdSdkApi;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import com.kwad.sdk.api.model.KSAdInfoData;

@KsAdSdkApi
@A2egSU
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public interface KsSplashScreenAd extends BaseKSAd {

    @KsAdSdkApi
    @A2egSU
    public interface SplashScreenAdInteractionListener {
        @KsAdSdkApi
        @A2egSU
        void onAdClicked();

        @KsAdSdkApi
        @A2egSU
        void onAdShowEnd();

        @KsAdSdkApi
        @A2egSU
        void onAdShowError(int i, String str);

        @KsAdSdkApi
        @A2egSU
        void onAdShowStart();

        @KsAdSdkApi
        @A2egSU
        void onDownloadTipsDialogCancel();

        @KsAdSdkApi
        @A2egSU
        void onDownloadTipsDialogDismiss();

        @KsAdSdkApi
        @A2egSU
        void onDownloadTipsDialogShow();

        @KsAdSdkApi
        @A2egSU
        void onSkippedAd();
    }

    @KsAdSdkApi
    @A2egSU
    int getECPM();

    @KsAdSdkApi
    @A2egSU
    int getInteractionType();

    @KsAdSdkApi
    @A2egSU
    KSAdInfoData getKSAdInfoData();

    @KsAdSdkApi
    @A2egSU
    int getMaterialType();

    @KsAdSdkApi
    @A2egSU
    View getView(Context context, SplashScreenAdInteractionListener splashScreenAdInteractionListener);

    @KsAdSdkApi
    @A2egSU
    boolean isAdEnable();

    @KsAdSdkApi
    @A2egSU
    @Deprecated
    boolean isVideo();

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
}
