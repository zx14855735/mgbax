package com.bytedance.sdk.gromore.xj.xj.c.w;

import android.content.Context;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class w implements com.bytedance.sdk.gromore.xj.xj.kd {
    private com.bytedance.sdk.openadsdk.mediation.hf.hf.xj hf;
    private xj u;
    private com.bytedance.sdk.openadsdk.jk.xj.hf.xj.u w;
    private com.bytedance.msdk.w.u.f xj;

    public w(Context context, com.bytedance.sdk.openadsdk.mediation.hf.hf.xj xjVar, com.bytedance.sdk.openadsdk.jk.xj.hf.xj.u uVar) {
        this.hf = xjVar;
        if (xjVar != null) {
            this.xj = new com.bytedance.msdk.w.u.f(context);
            this.w = uVar;
        }
    }

    @Override // com.bytedance.sdk.gromore.xj.xj.kd
    public void xj() {
        this.xj.xj(new com.bytedance.msdk.api.xj.hf(8, this.hf.z()), new com.bytedance.msdk.api.u.xj.u.hf() { // from class: com.bytedance.sdk.gromore.xj.xj.c.w.w.1
            @Override // com.bytedance.msdk.api.u.xj.u.hf
            public void hf() {
                if (w.this.w != null) {
                    w.this.w.xj();
                    if (w.this.u == null) {
                        w wVar = w.this;
                        wVar.u = new xj(wVar.xj);
                    }
                    w.this.w.hf(w.this.u);
                }
            }

            @Override // com.bytedance.msdk.api.u.xj.u.hf
            public void xj(com.bytedance.msdk.api.xj xjVar) {
                if (xjVar == null || w.this.w == null) {
                    return;
                }
                w.this.w.xj(xjVar.xj, xjVar.hf);
            }

            @Override // com.bytedance.msdk.api.u.xj.u.hf
            public void xj() {
                if (w.this.w != null) {
                    if (w.this.u == null) {
                        w wVar = w.this;
                        wVar.u = new xj(wVar.xj);
                    }
                    w.this.w.xj(w.this.u);
                }
            }
        });
    }
}
