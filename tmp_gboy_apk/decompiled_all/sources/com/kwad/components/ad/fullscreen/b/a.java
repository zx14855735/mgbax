package com.kwad.components.ad.fullscreen.b;

import android.content.Context;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class a {
    public static void H(Context context) {
        b I = I(context);
        long currentTimeMillis = System.currentTimeMillis();
        if (I == null) {
            I = new b(currentTimeMillis, 1);
        } else if (I.j(currentTimeMillis)) {
            I.jD++;
        } else {
            I.jC = currentTimeMillis;
            I.jD = 1;
        }
        a(context, I);
    }

    private static b I(Context context) {
        if (context == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(context.getSharedPreferences("ksadsdk_fullscreen_local_ad_count", 0).getString("key_local_info", null));
            b bVar = new b();
            bVar.parseJson(jSONObject);
            return bVar;
        } catch (Exception e) {
            c.printStackTraceOnly(e);
            return null;
        }
    }

    private static void a(Context context, b bVar) {
        if (context == null || bVar == null) {
            c.d("FullScreenLocalHelper", "saveFullScreenLocalInfo illegal arguments.");
        } else {
            context.getSharedPreferences("ksadsdk_fullscreen_local_ad_count", 0).edit().putString("key_local_info", bVar.toJson().toString()).apply();
        }
    }

    public static boolean b(Context context, AdTemplate adTemplate) {
        b I = I(context);
        return (I == null || !I.F(com.kwad.components.ad.fullscreen.a.b.cZ())) && com.kwad.sdk.core.response.b.b.dD(adTemplate);
    }
}
