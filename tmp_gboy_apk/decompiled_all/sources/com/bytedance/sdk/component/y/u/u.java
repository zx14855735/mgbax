package com.bytedance.sdk.component.y.u;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class u extends xj {
    @Override // com.bytedance.sdk.component.y.u.d
    public void xj(com.bytedance.sdk.component.y.w.w wVar) {
        com.bytedance.sdk.component.y.hf g = wVar.g();
        if (g != null) {
            if (g.isMemoryCache()) {
                wVar.xj(new tf());
                return;
            } else if (g.isDiskCache()) {
                wVar.xj(new y());
                return;
            }
        }
        wVar.xj(new p());
    }

    @Override // com.bytedance.sdk.component.y.u.d
    public String xj() {
        return "cache_policy";
    }
}
