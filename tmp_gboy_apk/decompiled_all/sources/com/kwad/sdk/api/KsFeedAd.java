package com.kwad.sdk.api;

import A5SV6n.A2egSU;
import android.content.Context;
import android.view.View;
import com.kwad.sdk.api.core.KsAdSdkApi;
import com.kwad.sdk.api.model.AdExposureFailedReason;

@KsAdSdkApi
@A2egSU
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public interface KsFeedAd extends BaseKSAd {

    @KsAdSdkApi
    @A2egSU
    public interface AdInteractionListener {
        @KsAdSdkApi
        @A2egSU
        void onAdClicked();

        @KsAdSdkApi
        @A2egSU
        void onAdShow();

        @KsAdSdkApi
        @A2egSU
        void onDislikeClicked();

        @KsAdSdkApi
        @A2egSU
        void onDownloadTipsDialogDismiss();

        @KsAdSdkApi
        @A2egSU
        void onDownloadTipsDialogShow();
    }

    @KsAdSdkApi
    @A2egSU
    public interface AdRenderListener {
        @KsAdSdkApi
        @A2egSU
        void onAdRenderFailed(int i, String str);

        @KsAdSdkApi
        @A2egSU
        void onAdRenderSuccess(View view);
    }

    @KsAdSdkApi
    @A2egSU
    int getECPM();

    @KsAdSdkApi
    @A2egSU
    View getFeedView(Context context);

    @KsAdSdkApi
    @A2egSU
    int getInteractionType();

    @KsAdSdkApi
    @A2egSU
    int getMaterialType();

    @KsAdSdkApi
    @A2egSU
    void render(AdRenderListener adRenderListener);

    @KsAdSdkApi
    @A2egSU
    void reportAdExposureFailed(int i, AdExposureFailedReason adExposureFailedReason);

    @KsAdSdkApi
    @A2egSU
    void setAdInteractionListener(AdInteractionListener adInteractionListener);

    @KsAdSdkApi
    @A2egSU
    @Deprecated
    void setBidEcpm(int i);

    @KsAdSdkApi
    @A2egSU
    void setBidEcpm(long j, long j2);

    @KsAdSdkApi
    @A2egSU
    void setVideoPlayConfig(KsAdVideoPlayConfig ksAdVideoPlayConfig);

    @KsAdSdkApi
    @A2egSU
    void setVideoSoundEnable(boolean z);
}
