package com.kwad.components.ad.splashscreen.c;

import android.os.Bundle;
import android.view.ViewGroup;
import com.kwad.components.core.c.f;
import com.kwad.components.core.proxy.h;
import com.kwad.sdk.api.KsSplashScreenAd;
import com.kwad.sdk.core.response.b.c;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class b extends h {
    private KsSplashScreenAd.SplashScreenAdInteractionListener FB;
    private com.kwad.sdk.core.j.b dn;
    private AdResultData mAdResultData;
    private AdTemplate mAdTemplate;

    private void a(com.kwad.sdk.core.j.b bVar) {
        this.dn = bVar;
    }

    public static b b(AdResultData adResultData, com.kwad.sdk.core.j.b bVar, KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener) {
        Bundle bundle = new Bundle();
        bundle.putInt("ad_result_cache_idx", f.oy().l(adResultData));
        b bVar2 = new b();
        bVar2.setArguments(bundle);
        bVar2.a(bVar);
        bVar2.setSplashScreenAdListener(splashScreenAdInteractionListener);
        return bVar2;
    }

    private void initData() {
        int i = getArguments().getInt("ad_result_cache_idx");
        if (i > 0) {
            AdResultData d = f.oy().d(i, true);
            this.mAdResultData = d;
            this.mAdTemplate = c.r(d);
        }
    }

    private void setSplashScreenAdListener(KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener) {
        this.FB = splashScreenAdInteractionListener;
    }

    @Override // com.kwad.components.core.proxy.h
    public final ViewGroup nu() {
        initData();
        if (this.mAdTemplate != null) {
            return com.kwad.components.ad.splashscreen.c.a(this.mContext, this.mAdResultData, false, this.dn, this.FB);
        }
        com.kwad.components.ad.splashscreen.monitor.b.mk();
        com.kwad.components.ad.splashscreen.monitor.b.a((AdTemplate) null, "adTemplate null", false);
        KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.FB;
        if (splashScreenAdInteractionListener != null) {
            splashScreenAdInteractionListener.onAdShowError(0, "data parse error");
        }
        return null;
    }
}
