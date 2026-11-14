package com.bytedance.sdk.openadsdk.core.component.splash.w.w;

import com.bytedance.sdk.openadsdk.core.component.splash.w.xj.c;
import com.bytedance.sdk.openadsdk.core.component.splash.w.xj.d;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xj {
    private com.bytedance.sdk.openadsdk.core.component.splash.w.xj.w hf;
    private com.bytedance.sdk.openadsdk.zg.w.hf.hf u;
    private u<d, c> w;
    private com.bytedance.sdk.openadsdk.core.component.splash.presentation.hf xj;

    public xj(com.bytedance.sdk.openadsdk.core.component.splash.w.xj.w wVar, u<d, c> uVar, com.bytedance.sdk.openadsdk.core.component.splash.xj.xj xjVar) {
        if (wVar == null || uVar == null) {
            return;
        }
        this.hf = wVar;
        this.w = uVar;
        com.bytedance.sdk.openadsdk.core.component.splash.presentation.hf hfVar = new com.bytedance.sdk.openadsdk.core.component.splash.presentation.hf(wVar.getContext(), wVar.c(), wVar.y(), this.hf.f(), wVar, uVar, xjVar);
        this.xj = hfVar;
        this.u = hfVar;
    }

    public void hf() {
        com.bytedance.sdk.openadsdk.core.component.splash.presentation.hf hfVar = this.xj;
        if (hfVar != null) {
            hfVar.xj(this.hf, this.w);
        }
    }

    public void xj(int i) {
        com.bytedance.sdk.openadsdk.core.component.splash.presentation.hf hfVar = this.xj;
        if (hfVar != null) {
            hfVar.hf(i);
        }
    }

    public void xj(y yVar) {
        com.bytedance.sdk.openadsdk.core.component.splash.w.xj.w wVar = this.hf;
        if (wVar == null || wVar.u == null || yVar == null) {
            return;
        }
        boolean xj = yVar.xj();
        this.hf.u.xj(xj);
        com.bytedance.sdk.openadsdk.core.component.splash.presentation.hf hfVar = this.xj;
        if (hfVar != null) {
            hfVar.hf(xj);
        }
    }

    public com.bytedance.sdk.openadsdk.zg.w.hf.hf xj() {
        return this.u;
    }
}
