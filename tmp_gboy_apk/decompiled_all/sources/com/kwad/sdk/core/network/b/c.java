package com.kwad.sdk.core.network.b;

import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.h;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class c {
    public static b JO() {
        h hVar = (h) ServiceProvider.get(h.class);
        return (hVar == null || !hVar.Do()) ? new a() : new d();
    }
}
