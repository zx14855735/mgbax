package com.kwad.sdk.api.core;

import A5SV6n.A2egSU;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsNativeAd;
import com.kwad.sdk.api.loader.Wrapper;

@KsAdSdkDynamicApi
@A2egSU
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class AbstractKsNativeAd implements KsNativeAd {
    @KsAdSdkDynamicApi
    @A2egSU
    public abstract Bitmap getSdkLogo();

    @Override // com.kwad.sdk.api.KsNativeAd
    @KsAdSdkDynamicApi
    @A2egSU
    public final View getVideoView(Context context, boolean z) {
        return getVideoView2(Wrapper.wrapContextIfNeed(context), z);
    }

    @KsAdSdkDynamicApi
    @A2egSU
    public abstract View getVideoView2(Context context, KsAdVideoPlayConfig ksAdVideoPlayConfig);

    @KsAdSdkDynamicApi
    @A2egSU
    public abstract View getVideoView2(Context context, boolean z);

    @Override // com.kwad.sdk.api.KsNativeAd
    @KsAdSdkDynamicApi
    @A2egSU
    public final View getVideoView(Context context, KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        return getVideoView2(Wrapper.wrapContextIfNeed(context), ksAdVideoPlayConfig);
    }
}
