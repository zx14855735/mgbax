package com.kwad.sdk.api;

import A5SV6n.A2egSU;
import com.kwad.sdk.api.core.KsAdSdkApi;

@KsAdSdkApi
@A2egSU
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public interface KsAppDownloadListener {
    @KsAdSdkApi
    @A2egSU
    void onDownloadFailed();

    @KsAdSdkApi
    @A2egSU
    void onDownloadFinished();

    @KsAdSdkApi
    @A2egSU
    void onDownloadStarted();

    @KsAdSdkApi
    @A2egSU
    void onIdle();

    @KsAdSdkApi
    @A2egSU
    void onInstalled();

    @KsAdSdkApi
    @A2egSU
    void onProgressUpdate(int i);
}
