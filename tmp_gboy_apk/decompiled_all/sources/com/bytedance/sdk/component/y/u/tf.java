package com.bytedance.sdk.component.y.u;

import android.graphics.Bitmap;
import com.bytedance.sdk.component.y.x;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class tf extends xj {
    private Bitmap hf(com.bytedance.sdk.component.y.w.w wVar) {
        Collection<x> xj = wVar.pl().xj();
        Bitmap bitmap = null;
        if (xj == null) {
            return null;
        }
        Iterator<x> it = xj.iterator();
        while (it.hasNext() && (bitmap = it.next().xj((x) wVar.getMemoryCacheKey())) == null) {
        }
        return bitmap;
    }

    private Bitmap w(com.bytedance.sdk.component.y.w.w wVar) {
        return wVar.pl().xj(wVar.g()).xj((x) wVar.getMemoryCacheKey());
    }

    @Override // com.bytedance.sdk.component.y.u.d
    public void xj(com.bytedance.sdk.component.y.w.w wVar) {
        int kd = wVar.kd();
        Bitmap hf = (kd == 2 || kd == 1) ? (wVar.am() || wVar.g().isQueryAll()) ? hf(wVar) : w(wVar) : null;
        if (hf != null) {
            wVar.xj(new g(hf, null, null, false));
        } else if (wVar.g().isRawMemoryCache()) {
            wVar.xj(new pl());
        } else {
            wVar.xj(new y());
        }
    }

    @Override // com.bytedance.sdk.component.y.u.d
    public String xj() {
        return "memory_cache";
    }
}
