package com.kwad.components.ad.interstitial;

import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.core.response.model.AdResultData;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class e {
    public static KsInterstitialAd f(AdResultData adResultData) {
        int eJ = com.kwad.sdk.core.response.b.e.eJ(com.kwad.sdk.core.response.b.c.r(adResultData));
        return eJ != 1 ? eJ != 2 ? new b(adResultData) : new com.kwad.components.ad.interstitial.e.a(false, adResultData) : new com.kwad.components.ad.interstitial.e.a(true, adResultData);
    }
}
