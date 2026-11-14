package com.kwad.sdk.core.a;

import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.components.h;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class d {
    private static g aID;

    public static void a(String str, Map<String, String> map, String str2) {
        qu().a(str, map, str2);
    }

    public static String av(String str) {
        return qu().av(str);
    }

    public static String getResponseData(String str) {
        com.kwad.sdk.components.d.f(DevelopMangerComponents.class);
        return qu().getResponseData(str);
    }

    public static void h(Map<String, String> map) {
        qu().h(map);
    }

    private static g qu() {
        g gVar = aID;
        if (gVar != null) {
            return gVar;
        }
        h hVar = (h) com.kwad.sdk.components.d.f(h.class);
        if (hVar != null) {
            hVar.qu();
            aID = hVar.qu();
        } else {
            aID = new a();
        }
        return aID;
    }
}
