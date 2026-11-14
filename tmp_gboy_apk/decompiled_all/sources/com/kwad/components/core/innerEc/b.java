package com.kwad.components.core.innerEc;

import com.kwad.sdk.core.request.model.g;
import com.kwad.sdk.h;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class b extends com.kwad.sdk.core.network.d {
    public b(String str, String str2) {
        g KH = g.KH();
        KH.eL(str);
        KH.eN(str2);
        putBody("userInfo", KH);
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final String getUrl() {
        return h.CG();
    }
}
