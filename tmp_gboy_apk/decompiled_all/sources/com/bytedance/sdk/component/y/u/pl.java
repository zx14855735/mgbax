package com.bytedance.sdk.component.y.u;

import com.bytedance.sdk.component.y.ai;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class pl extends xj {
    @Override // com.bytedance.sdk.component.y.u.d
    public void xj(com.bytedance.sdk.component.y.w.w wVar) {
        byte[] xj = wVar.pl().hf(wVar.g()).xj((ai) wVar.getRawCacheKey());
        if (xj == null) {
            wVar.xj(new y());
        } else {
            wVar.xj(new hf(xj, null));
        }
    }

    @Override // com.bytedance.sdk.component.y.u.d
    public String xj() {
        return "raw_cache";
    }
}
