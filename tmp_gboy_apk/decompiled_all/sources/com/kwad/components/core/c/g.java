package com.kwad.components.core.c;

import ADYaiT.CtFAbx;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class g {
    private static volatile g Ol;
    private ConcurrentHashMap<String, WeakReference<Object>> Ok = new ConcurrentHashMap<>();

    private static String az(AdTemplate adTemplate) {
        return com.kwad.sdk.core.response.b.e.ek(adTemplate) + "-" + com.kwad.sdk.core.response.b.e.eB(adTemplate);
    }

    private static String b(i iVar) {
        return CtFAbx.AlLFFp(iVar.ot(), "-", iVar.oH());
    }

    public static g oz() {
        if (Ol == null) {
            synchronized (g.class) {
                try {
                    if (Ol == null) {
                        Ol = new g();
                    }
                } finally {
                }
            }
        }
        return Ol;
    }

    public final boolean a(i iVar) {
        String b = b(iVar);
        A2egSU.B7CMnp("contains key: ", b, "AdMemCachePool");
        boolean z = false;
        if (!this.Ok.containsKey(b)) {
            return false;
        }
        WeakReference<Object> weakReference = this.Ok.get(b);
        if (weakReference != null && weakReference.get() != null) {
            z = true;
        }
        if (z) {
            com.kwad.sdk.core.d.c.d("AdMemCachePool", "contains ad: " + weakReference.get());
        }
        return z;
    }

    public final void add(Object obj) {
        if (obj instanceof com.kwad.components.core.internal.api.a) {
            this.Ok.put(az(((com.kwad.components.core.internal.api.a) obj).getAdTemplate()), new WeakReference<>(obj));
        }
    }

    public final void ay(AdTemplate adTemplate) {
        this.Ok.remove(az(adTemplate));
    }
}
