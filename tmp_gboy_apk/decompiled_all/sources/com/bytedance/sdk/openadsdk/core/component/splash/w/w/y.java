package com.bytedance.sdk.openadsdk.core.component.splash.w.w;

import com.bytedance.sdk.openadsdk.core.component.splash.w.xj.c;
import com.bytedance.sdk.openadsdk.core.component.splash.w.xj.f;
import com.bytedance.sdk.openadsdk.core.ra.hl;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class y {
    private com.bytedance.sdk.openadsdk.core.component.splash.w.xj.hf hf;
    private w<f, c> w;
    private com.bytedance.sdk.openadsdk.core.component.splash.w.hf.xj xj;

    public y(com.bytedance.sdk.openadsdk.core.component.splash.w.xj.hf hfVar, w<f, c> wVar) {
        if (hfVar == null || wVar == null) {
            return;
        }
        this.hf = hfVar;
        this.w = wVar;
        if (hfVar.p() == 1) {
            this.xj = new com.bytedance.sdk.openadsdk.core.component.splash.hf.xj.hf();
        } else {
            this.xj = new com.bytedance.sdk.openadsdk.core.component.splash.hf.xj.u();
        }
    }

    public void hf() {
        com.bytedance.sdk.openadsdk.core.component.splash.w.xj.hf hfVar = this.hf;
        if (hfVar == null || this.w == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.component.splash.w.hf.xj xjVar = this.xj;
        if (xjVar instanceof com.bytedance.sdk.openadsdk.core.component.splash.hf.xj.hf) {
            xjVar.xj(hfVar, new w<f, c>() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.w.w.y.1
                @Override // com.bytedance.sdk.openadsdk.core.component.splash.w.w.w
                public void hf(f fVar) {
                    if (fVar != null) {
                        fVar.kd(true);
                    }
                    y.this.w.hf(fVar);
                    com.bytedance.sdk.openadsdk.core.component.splash.c.xj(y.this.hf.pl());
                }

                @Override // com.bytedance.sdk.openadsdk.core.component.splash.w.w.w
                /* renamed from: xj, reason: merged with bridge method [inline-methods] */
                public void w(f fVar) {
                    if (fVar != null) {
                        fVar.kd(false);
                    }
                    y.this.w.w(fVar);
                }

                @Override // com.bytedance.sdk.openadsdk.core.component.splash.w.w.w
                public void xj(c cVar) {
                    y.this.w.xj(cVar);
                }
            });
        } else {
            xjVar.xj(hfVar, new w<f, c>() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.w.w.y.2
                @Override // com.bytedance.sdk.openadsdk.core.component.splash.w.w.w
                public void hf(f fVar) {
                    if (fVar != null) {
                        fVar.kd(true);
                    }
                    y.this.w.hf(fVar);
                }

                @Override // com.bytedance.sdk.openadsdk.core.component.splash.w.w.w
                /* renamed from: xj, reason: merged with bridge method [inline-methods] */
                public void w(f fVar) {
                    if (fVar != null) {
                        fVar.kd(false);
                    }
                    y.this.w.w(fVar);
                }

                @Override // com.bytedance.sdk.openadsdk.core.component.splash.w.w.w
                public void xj(c cVar) {
                    if (y.this.hf.g() && y.this.hf.hf() != null) {
                        hl.xj(y.this.hf.hf(), 1);
                    }
                    new com.bytedance.sdk.openadsdk.core.component.splash.hf.xj.hf().xj(y.this.hf, y.this.w);
                }
            });
        }
    }

    public boolean xj() {
        return this.xj instanceof com.bytedance.sdk.openadsdk.core.component.splash.hf.xj.u;
    }
}
