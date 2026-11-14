package com.bytedance.sdk.openadsdk.core.component.reward.xj;

import com.bytedance.sdk.openadsdk.zg.w.hf.p;
import com.bytedance.sdk.openadsdk.zg.w.hf.qt;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class u {
    private com.bytedance.sdk.openadsdk.jk.xj.hf.xj.u hf;
    private com.bytedance.sdk.openadsdk.jk.xj.hf.xj.c xj;

    public u(com.bytedance.sdk.openadsdk.jk.xj.hf.xj.c cVar) {
        this.xj = cVar;
    }

    public void hf(Object obj) {
        com.bytedance.sdk.openadsdk.jk.xj.hf.xj.c cVar = this.xj;
        if (cVar != null && (obj instanceof qt)) {
            cVar.xj();
            this.xj.hf((qt) obj);
        }
        com.bytedance.sdk.openadsdk.jk.xj.hf.xj.u uVar = this.hf;
        if (uVar == null || !(obj instanceof p)) {
            return;
        }
        uVar.xj();
        this.hf.hf((p) obj);
    }

    public void xj(int i, String str) {
        com.bytedance.sdk.openadsdk.jk.xj.hf.xj.c cVar = this.xj;
        if (cVar != null) {
            cVar.xj(i, str);
        }
        com.bytedance.sdk.openadsdk.jk.xj.hf.xj.u uVar = this.hf;
        if (uVar != null) {
            uVar.xj(i, str);
        }
    }

    public u(com.bytedance.sdk.openadsdk.jk.xj.hf.xj.u uVar) {
        this.hf = uVar;
    }

    public void xj(Object obj) {
        com.bytedance.sdk.openadsdk.jk.xj.hf.xj.c cVar = this.xj;
        if (cVar != null && (obj instanceof qt)) {
            cVar.xj((qt) obj);
        }
        com.bytedance.sdk.openadsdk.jk.xj.hf.xj.u uVar = this.hf;
        if (uVar == null || !(obj instanceof p)) {
            return;
        }
        uVar.xj((p) obj);
    }

    public long xj() {
        Object obj = this.xj;
        if (obj != null) {
            return obj instanceof com.bytedance.sdk.openadsdk.core.xj.hf ? ((com.bytedance.sdk.openadsdk.core.xj.hf) obj).hf() : System.currentTimeMillis();
        }
        Object obj2 = this.hf;
        if (obj2 != null) {
            return obj2 instanceof com.bytedance.sdk.openadsdk.core.xj.hf ? ((com.bytedance.sdk.openadsdk.core.xj.hf) obj2).hf() : System.currentTimeMillis();
        }
        return 0L;
    }
}
