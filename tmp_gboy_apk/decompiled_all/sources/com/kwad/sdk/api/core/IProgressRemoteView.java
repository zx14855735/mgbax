package com.kwad.sdk.api.core;

import A5SV6n.A2egSU;
import android.graphics.Bitmap;
import android.widget.RemoteViews;

@KsAdSdkDynamicApi
@A2egSU
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public interface IProgressRemoteView {
    @KsAdSdkDynamicApi
    @A2egSU
    RemoteViews build();

    @KsAdSdkDynamicApi
    @A2egSU
    void setControlBtnPaused(boolean z);

    @KsAdSdkDynamicApi
    @A2egSU
    void setIcon(int i);

    @KsAdSdkDynamicApi
    @A2egSU
    void setIcon(Bitmap bitmap);

    @KsAdSdkDynamicApi
    @A2egSU
    void setName(String str);

    @KsAdSdkDynamicApi
    @A2egSU
    void setPercentNum(String str);

    @KsAdSdkDynamicApi
    @A2egSU
    void setProgress(int i, int i2, boolean z);

    @KsAdSdkDynamicApi
    @A2egSU
    void setSize(String str);

    @KsAdSdkDynamicApi
    @A2egSU
    void setStatus(String str);
}
