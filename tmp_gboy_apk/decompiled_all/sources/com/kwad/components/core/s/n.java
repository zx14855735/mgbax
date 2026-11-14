package com.kwad.components.core.s;

import android.content.Context;
import com.kwad.components.core.e.d.a;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class n {
    public static boolean d(AdTemplate adTemplate, boolean z) {
        if (!z && com.kwad.sdk.core.response.b.b.dH(com.kwad.sdk.core.response.b.e.er(adTemplate))) {
            return com.kwad.sdk.core.config.e.HS();
        }
        return false;
    }

    public static void i(Context context, AdTemplate adTemplate) {
        com.kwad.components.core.e.d.a.a(new a.C0291a(context).aq(true).aE(adTemplate));
    }
}
