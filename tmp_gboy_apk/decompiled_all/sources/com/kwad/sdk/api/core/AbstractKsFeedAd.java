package com.kwad.sdk.api.core;

import A5SV6n.A2egSU;
import android.content.Context;
import android.view.View;
import com.kwad.sdk.api.KsFeedAd;
import com.kwad.sdk.api.loader.Wrapper;

@KsAdSdkDynamicApi
@A2egSU
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class AbstractKsFeedAd implements KsFeedAd {
    @Override // com.kwad.sdk.api.KsFeedAd
    @KsAdSdkDynamicApi
    @A2egSU
    public final View getFeedView(Context context) {
        return getFeedView2(Wrapper.wrapContextIfNeed(context));
    }

    @KsAdSdkDynamicApi
    @A2egSU
    public abstract View getFeedView2(Context context);
}
