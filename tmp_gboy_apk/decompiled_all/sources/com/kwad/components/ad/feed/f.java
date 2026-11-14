package com.kwad.components.ad.feed;

import ADYaiT.CtFAbx;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class f {
    public static String l(AdTemplate adTemplate) {
        String av = com.kwad.sdk.core.response.b.a.av(com.kwad.sdk.core.response.b.e.er(adTemplate));
        if (com.kwad.components.core.c.b.op()) {
            return CtFAbx.AcNBzu(adTemplate.fromCache ? "【cache】" : "", av);
        }
        return av;
    }
}
