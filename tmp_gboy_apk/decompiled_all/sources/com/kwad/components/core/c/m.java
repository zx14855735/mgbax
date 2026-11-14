package com.kwad.components.core.c;

import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.utils.bg;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class m implements c {
    public static AdResultData e(com.kwad.components.core.request.model.a aVar) {
        a om = a.om();
        if (om == null) {
            return null;
        }
        int adNum = aVar.getAdNum();
        List<i> a2 = om.a(String.valueOf(aVar.getPosId()), System.currentTimeMillis() / 1000, e.x(aVar.getPosId()).ov());
        if (com.kwad.sdk.core.config.e.HL()) {
            l(a2);
        }
        if (a2 == null || a2.size() <= 0) {
            return null;
        }
        Collections.sort(a2);
        return i.k(a2.subList(0, Math.min(a2.size(), adNum)));
    }

    private static void l(List<i> list) {
        if (list == null) {
            return;
        }
        Iterator<i> it = list.iterator();
        while (it.hasNext()) {
            i next = it.next();
            if (g.oz().a(next)) {
                com.kwad.sdk.core.d.c.d("StrategyLocalCacheFirst", "filterByMemCached contain: " + next.oH());
                it.remove();
            }
        }
    }

    @Override // com.kwad.components.core.c.c
    public final void d(final com.kwad.components.core.request.model.a aVar) {
        GlobalThreadPools.Ll().submit(new bg() { // from class: com.kwad.components.core.c.m.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                AdResultData e = m.e(aVar);
                if (e != null && !e.isAdResultDataEmpty()) {
                    com.kwad.components.core.request.model.a.a(aVar, e, true);
                } else {
                    com.kwad.components.core.request.model.a aVar2 = aVar;
                    o.a(aVar2, new k(aVar2));
                }
            }
        });
    }

    @Override // com.kwad.components.core.c.c
    public final String getName() {
        return "StrategyLocalCacheFirst";
    }
}
