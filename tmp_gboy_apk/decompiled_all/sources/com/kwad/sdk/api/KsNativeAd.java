package com.kwad.sdk.api;

import A5SV6n.A2egSU;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;
import com.kwad.sdk.api.core.KsAdSdkApi;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import com.kwad.sdk.api.model.KsLiveInfo;
import java.util.List;
import java.util.Map;

@KsAdSdkApi
@A2egSU
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public interface KsNativeAd extends BaseKSAd {

    @KsAdSdkApi
    @A2egSU
    public interface AdInteractionListener {
        boolean handleDownloadDialog(DialogInterface.OnClickListener onClickListener);

        @KsAdSdkApi
        @A2egSU
        void onAdClicked(View view, KsNativeAd ksNativeAd);

        @KsAdSdkApi
        @A2egSU
        void onAdShow(KsNativeAd ksNativeAd);

        @KsAdSdkApi
        @A2egSU
        void onDownloadTipsDialogDismiss();

        @KsAdSdkApi
        @A2egSU
        void onDownloadTipsDialogShow();
    }

    @KsAdSdkApi
    @A2egSU
    public interface VideoPlayListener {
        @KsAdSdkApi
        @A2egSU
        void onVideoPlayComplete();

        @KsAdSdkApi
        @A2egSU
        void onVideoPlayError(int i, int i2);

        @KsAdSdkApi
        @A2egSU
        void onVideoPlayPause();

        @KsAdSdkApi
        @A2egSU
        void onVideoPlayReady();

        @KsAdSdkApi
        @A2egSU
        void onVideoPlayResume();

        @KsAdSdkApi
        @A2egSU
        void onVideoPlayStart();
    }

    @KsAdSdkApi
    @A2egSU
    boolean enableRotate();

    @KsAdSdkApi
    @A2egSU
    String getActionDescription();

    @KsAdSdkApi
    @A2egSU
    String getAdDescription();

    @KsAdSdkApi
    @A2egSU
    String getAdSource();

    @KsAdSdkApi
    @A2egSU
    String getAdSourceLogoUrl(int i);

    @KsAdSdkApi
    @A2egSU
    String getAppDownloadCountDes();

    @KsAdSdkApi
    @A2egSU
    String getAppIconUrl();

    @KsAdSdkApi
    @A2egSU
    String getAppName();

    @KsAdSdkApi
    @A2egSU
    String getAppPackageName();

    @KsAdSdkApi
    @A2egSU
    long getAppPackageSize();

    @KsAdSdkApi
    @A2egSU
    String getAppPrivacyUrl();

    @KsAdSdkApi
    @A2egSU
    float getAppScore();

    @KsAdSdkApi
    @A2egSU
    String getAppVersion();

    @KsAdSdkApi
    @A2egSU
    String getCorporationName();

    @KsAdSdkApi
    @A2egSU
    int getECPM();

    @KsAdSdkApi
    @A2egSU
    List<KsImage> getImageList();

    @KsAdSdkApi
    @A2egSU
    int getInteractionType();

    @KsAdSdkApi
    @A2egSU
    String getIntroductionInfo();

    @KsAdSdkApi
    @A2egSU
    String getIntroductionInfoUrl();

    @KsAdSdkApi
    @A2egSU
    KsLiveInfo getLiveInfo();

    @KsAdSdkApi
    @A2egSU
    int getMaterialType();

    @KsAdSdkApi
    @A2egSU
    String getPermissionInfo();

    @KsAdSdkApi
    @A2egSU
    String getPermissionInfoUrl();

    @KsAdSdkApi
    @A2egSU
    String getProductName();

    @KsAdSdkApi
    @A2egSU
    View getRotateView(Context context);

    @KsAdSdkApi
    @A2egSU
    KsImage getVideoCoverImage();

    @KsAdSdkApi
    @A2egSU
    int getVideoDuration();

    @KsAdSdkApi
    @A2egSU
    int getVideoHeight();

    @KsAdSdkApi
    @A2egSU
    String getVideoUrl();

    @KsAdSdkApi
    @A2egSU
    View getVideoView(Context context, KsAdVideoPlayConfig ksAdVideoPlayConfig);

    @KsAdSdkApi
    @A2egSU
    @Deprecated
    View getVideoView(Context context, boolean z);

    @KsAdSdkApi
    @A2egSU
    int getVideoWidth();

    void pauseVideo();

    @KsAdSdkApi
    @A2egSU
    @Deprecated
    void registerViewForInteraction(Activity activity, ViewGroup viewGroup, List<View> list, AdInteractionListener adInteractionListener);

    @KsAdSdkApi
    @A2egSU
    void registerViewForInteraction(Activity activity, ViewGroup viewGroup, Map<View, Integer> map, AdInteractionListener adInteractionListener);

    @KsAdSdkApi
    @A2egSU
    @Deprecated
    void registerViewForInteraction(ViewGroup viewGroup, List<View> list, AdInteractionListener adInteractionListener);

    @KsAdSdkApi
    @A2egSU
    void reportAdExposureFailed(int i, AdExposureFailedReason adExposureFailedReason);

    @KsAdSdkApi
    @A2egSU
    void reportAdVideoPlayEnd();

    @KsAdSdkApi
    @A2egSU
    void reportAdVideoPlayStart();

    @KsAdSdkApi
    @A2egSU
    @Deprecated
    void setBidEcpm(int i);

    @KsAdSdkApi
    @A2egSU
    void setBidEcpm(long j, long j2);

    @KsAdSdkApi
    @A2egSU
    void setDownloadListener(KsAppDownloadListener ksAppDownloadListener);

    @KsAdSdkApi
    @A2egSU
    void setVideoPlayListener(VideoPlayListener videoPlayListener);

    void startVideo();

    void stopVideo();
}
