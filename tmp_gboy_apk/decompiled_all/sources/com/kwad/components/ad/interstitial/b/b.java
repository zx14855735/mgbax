package com.kwad.components.ad.interstitial.b;

import com.kwad.sdk.core.response.model.AdInfo;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class b {
    public static int b(AdInfo adInfo) {
        int intValue = a.lP.getValue().intValue();
        if (com.kwad.sdk.core.response.b.a.bd(adInfo)) {
            int M = com.kwad.sdk.core.response.b.a.M(adInfo);
            return intValue == 0 ? M : Math.min(intValue, M);
        }
        if (intValue > 60 || intValue <= 0) {
            return 60;
        }
        return intValue;
    }

    public static boolean dI() {
        return a.lR.getValue().booleanValue();
    }

    public static boolean dJ() {
        return a.lL.getValue().intValue() == 1;
    }

    public static int dK() {
        return a.lM.getValue().intValue();
    }

    public static boolean dL() {
        return a.lN.getValue().intValue() == 1;
    }

    public static boolean dM() {
        return a.lO.getValue().intValue() == 1;
    }

    public static boolean dN() {
        return a.lQ.getValue().intValue() == 1;
    }

    public static boolean dO() {
        return a.lS.getValue().intValue() == 1;
    }
}
