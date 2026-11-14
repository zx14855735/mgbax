package com.kwad.components.ad.reward;

import com.kwad.components.ad.splashscreen.monitor.SplashMonitorInfo;
import com.tencent.mm.opensdk.utils.Log;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract /* synthetic */ class A2egSU {
    public static SplashMonitorInfo A2egSU(int i) {
        return new SplashMonitorInfo().setStatus(i);
    }

    public static void A4TApA(int i, String str, String str2) {
        com.kwad.sdk.core.d.c.d(str2, str + i);
    }

    public static void A5SV6n(Exception exc, StringBuilder sb, String str) {
        sb.append(exc.getMessage());
        Log.e(str, sb.toString());
    }

    public static void ADYaiT(String str, int i, StringBuilder sb) {
        sb.append(Integer.toHexString(i));
        com.kwad.sdk.core.d.c.d(str, sb.toString());
    }

    public static void AMqCpz(String str, JSONObject jSONObject, String str2, com.sigmob.sdk.mraid2.d dVar) {
        dVar.a(str + jSONObject + str2);
    }
}
