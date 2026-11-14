package com.kwad.sdk.api.core;

import A5SV6n.A2egSU;
import android.content.Context;
import android.view.View;
import com.kwad.sdk.api.KsDrawAd;
import com.kwad.sdk.api.loader.Wrapper;

@KsAdSdkDynamicApi
@A2egSU
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class AbstractKsDrawAd implements KsDrawAd {
    @Override // com.kwad.sdk.api.KsDrawAd
    @KsAdSdkDynamicApi
    @A2egSU
    public final View getDrawView(Context context) {
        return getDrawView2(Wrapper.wrapContextIfNeed(context));
    }

    @KsAdSdkDynamicApi
    @A2egSU
    public abstract View getDrawView2(Context context);
}
