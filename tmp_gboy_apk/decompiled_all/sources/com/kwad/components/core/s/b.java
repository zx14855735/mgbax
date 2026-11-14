package com.kwad.components.core.s;

import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.bg;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class b {
    private static volatile b act;

    private b() {
    }

    public static b ut() {
        if (act == null) {
            synchronized (b.class) {
                try {
                    if (act == null) {
                        act = new b();
                    }
                } finally {
                }
            }
        }
        return act;
    }

    public final boolean a(final AdTemplate adTemplate, JSONObject jSONObject, com.kwad.sdk.core.adlog.c.b bVar) {
        if (((DevelopMangerComponents) com.kwad.sdk.components.d.f(DevelopMangerComponents.class)) != null) {
            com.kwad.sdk.core.d.c.d("AdEventHelper", "processAdImpress notImpression: false");
        }
        if (bVar != null) {
            bVar.b(adTemplate, null, null, null);
        }
        boolean b = com.kwad.sdk.core.adlog.c.b(adTemplate, jSONObject, bVar);
        try {
            SceneImpl sceneImpl = adTemplate.mAdScene;
            boolean z = false;
            if (sceneImpl != null && sceneImpl.adStyle == 10000) {
                z = true;
            }
            int i = adTemplate.adStyle;
            if (i == 3 || i == 2 || i == 13 || z) {
                com.kwad.sdk.core.response.b.e.er(adTemplate);
                if (b && com.kwad.sdk.components.d.f(com.kwad.components.core.offline.a.d.a.class) != null) {
                    com.kwad.sdk.components.d.f(com.kwad.components.core.offline.a.d.a.class);
                }
            }
        } catch (Throwable unused) {
        }
        com.kwad.sdk.utils.h.execute(new bg() { // from class: com.kwad.components.core.s.b.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                com.kwad.components.core.c.a om = com.kwad.components.core.c.a.om();
                if (om != null) {
                    om.w(com.kwad.sdk.core.response.b.e.eB(adTemplate));
                }
            }
        });
        com.kwad.components.core.c.g.oz().ay(adTemplate);
        return b;
    }
}
