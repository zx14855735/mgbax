package com.bytedance.sdk.gromore.xj.xj.c.w;

import android.content.Context;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class c implements com.bytedance.sdk.gromore.xj.xj.kd {
    private com.bytedance.sdk.openadsdk.mediation.hf.hf.xj hf;
    private kd u;
    private com.bytedance.sdk.openadsdk.jk.xj.hf.xj.u w;
    private com.bytedance.msdk.w.u.xj xj;

    public c(Context context, com.bytedance.sdk.openadsdk.mediation.hf.hf.xj xjVar, com.bytedance.sdk.openadsdk.jk.xj.hf.xj.u uVar) {
        this.hf = xjVar;
        if (xjVar != null) {
            this.xj = new com.bytedance.msdk.w.u.xj(context);
            this.w = uVar;
        }
    }

    @Override // com.bytedance.sdk.gromore.xj.xj.kd
    public void xj() {
        this.xj.xj(new com.bytedance.msdk.api.xj.hf(10, this.hf.z()), new com.bytedance.msdk.api.u.xj.y.hf() { // from class: com.bytedance.sdk.gromore.xj.xj.c.w.c.1
            @Override // com.bytedance.msdk.api.u.xj.y.hf
            public void hf() {
                if (c.this.w != null) {
                    c.this.w.xj();
                    if (c.this.u == null) {
                        c cVar = c.this;
                        cVar.u = new kd(cVar.xj);
                    }
                    c.this.w.hf(c.this.u);
                }
            }

            @Override // com.bytedance.msdk.api.u.xj.y.hf
            public void xj(com.bytedance.msdk.api.xj xjVar) {
                if (xjVar == null || c.this.w == null) {
                    return;
                }
                c.this.w.xj(xjVar.xj, xjVar.hf);
            }

            @Override // com.bytedance.msdk.api.u.xj.y.hf
            public void xj() {
                if (c.this.w != null) {
                    if (c.this.u == null) {
                        c cVar = c.this;
                        cVar.u = new kd(cVar.xj);
                    }
                    c.this.w.xj(c.this.u);
                }
            }
        });
    }
}
