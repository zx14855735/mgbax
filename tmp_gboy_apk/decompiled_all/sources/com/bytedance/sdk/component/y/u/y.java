package com.bytedance.sdk.component.y.u;

import java.util.Collection;
import java.util.Iterator;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class y extends xj {
    private byte[] hf(com.bytedance.sdk.component.y.w.w wVar, String str) {
        com.bytedance.sdk.component.y.u w = wVar.pl().w(wVar.g());
        if (w == null) {
            return null;
        }
        return w.xj((com.bytedance.sdk.component.y.u) str);
    }

    @Override // com.bytedance.sdk.component.y.u.d
    public void xj(com.bytedance.sdk.component.y.w.w wVar) {
        String rawCacheKey = wVar.getRawCacheKey();
        com.bytedance.sdk.component.y.hf g = wVar.g();
        byte[] xj = (wVar.am() || g.isQueryAll()) ? xj(wVar, rawCacheKey) : hf(wVar, rawCacheKey);
        if (xj == null) {
            wVar.xj(new p());
            return;
        }
        wVar.xj(new hf(xj, null));
        if (g.isRawMemoryCache()) {
            wVar.pl().hf(g).xj(rawCacheKey, xj);
        }
    }

    private byte[] xj(com.bytedance.sdk.component.y.w.w wVar, String str) {
        wVar.pl().w(wVar.g());
        Collection<com.bytedance.sdk.component.y.u> w = wVar.pl().w();
        if (w == null) {
            return null;
        }
        Iterator<com.bytedance.sdk.component.y.u> it = w.iterator();
        while (it.hasNext()) {
            byte[] xj = it.next().xj((com.bytedance.sdk.component.y.u) str);
            if (xj != null) {
                return xj;
            }
        }
        return null;
    }

    @Override // com.bytedance.sdk.component.y.u.d
    public String xj() {
        return "disk_cache";
    }
}
