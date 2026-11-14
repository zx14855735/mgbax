package com.kwad.sdk.api;

import A5SV6n.A2egSU;
import android.content.Context;
import android.view.View;
import com.kwad.sdk.api.core.KsAdSdkApi;
import com.kwad.sdk.api.model.AdExposureFailedReason;

@KsAdSdkApi
@A2egSU
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public interface KsDrawAd extends BaseKSAd {

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
        void onVideoPlayEnd();

        @KsAdSdkApi
        @A2egSU
        void onVideoPlayError();

        @KsAdSdkApi
        @A2egSU
        void onVideoPlayPause();

        @KsAdSdkApi
        @A2egSU
        void onVideoPlayResume();

        @KsAdSdkApi
        @A2egSU
        void onVideoPlayStart();
    }

    @KsAdSdkApi
    @A2egSU
    void controlPlayerStatus();

    @KsAdSdkApi
    @A2egSU
    View getDrawView(Context context);

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
    void pause();

    @KsAdSdkApi
    @A2egSU
    void play();

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
    void setVideoSoundEnable(boolean z);
}
