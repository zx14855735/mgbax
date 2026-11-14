package com.bytedance.sdk.openadsdk.core.component.splash.hf.xj;

import com.bytedance.sdk.component.y.jk;
import com.bytedance.sdk.component.y.zg;
import com.bytedance.sdk.openadsdk.core.a.e;
import com.bytedance.sdk.openadsdk.core.a.yo;
import com.bytedance.sdk.openadsdk.core.component.splash.w.xj.c;
import com.bytedance.sdk.openadsdk.core.component.splash.w.xj.f;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.x.d;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class hf implements com.bytedance.sdk.openadsdk.core.component.splash.w.hf.xj {
    private c xj = new c();

    private void hf(final com.bytedance.sdk.openadsdk.core.component.splash.w.xj.hf hfVar, final com.bytedance.sdk.openadsdk.core.component.splash.w.w.w<f, c> wVar) {
        if (hfVar == null || wVar == null) {
            return;
        }
        this.xj.hf(hfVar.am());
        this.xj.xj(hfVar.hf());
        if (pz.hf().d(hfVar.d()) == 4) {
            f fVar = new f(hfVar.hf(), hfVar.am());
            fVar.xj(false);
            fVar.xj(hfVar.xj());
            fVar.xj(hfVar.w());
            wVar.hf(fVar);
            return;
        }
        com.bytedance.sdk.openadsdk.g.hf kd = hfVar.kd();
        if (kd == null) {
            this.xj.hf(2);
            this.xj.xj("image request fail");
            this.xj.xj(false);
            wVar.xj(this.xj);
            return;
        }
        com.bytedance.sdk.openadsdk.core.c.xj.xj("Splash_FullLink", "加载图片素材 " + hfVar.hf().zf());
        yo.xj(kd, hfVar.y(), hfVar.c(), new yo.xj() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.hf.xj.hf.1
            @Override // com.bytedance.sdk.openadsdk.core.a.yo.xj
            public void xj(com.bytedance.sdk.openadsdk.core.et.xj.hf hfVar2, zg zgVar) {
                f fVar2 = new f(hfVar2, hfVar.hf(), hfVar.am());
                fVar2.xj(false);
                fVar2.xj(hfVar.xj());
                fVar2.kd(hfVar.w());
                if (zgVar != null) {
                    fVar2.xj(zgVar.getHeaders());
                    fVar2.hf(zgVar.isLocal());
                    fVar2.hf(e.xj(zgVar.getHeaders()));
                    if (zgVar.getHttpTime() != null) {
                        fVar2.hf(zgVar.getHttpTime().getFirstFrameTime());
                        fVar2.w(zgVar.getHttpTime().getStartRequestTime());
                        fVar2.u(zgVar.getHttpTime().getEndRequestTime());
                    }
                }
                wVar.hf(fVar2);
            }

            @Override // com.bytedance.sdk.openadsdk.core.a.yo.xj
            public void xj() {
                hf.this.xj.hf(2);
                hf.this.xj.xj("load image fail");
                hf.this.xj.xj(false);
                wVar.xj(hf.this.xj);
            }
        }, d.kd(), 4, new jk() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.hf.xj.hf.2
            @Override // com.bytedance.sdk.component.y.jk
            public void onStep(int i, Object obj) {
                if (i == 3 && hf.this.xj(hfVar)) {
                    f fVar2 = new f(hfVar.hf(), hfVar.am());
                    fVar2.xj(false);
                    fVar2.xj(hfVar.xj());
                    fVar2.xj(hfVar.w());
                    fVar2.u(true);
                    fVar2.hf(false);
                    wVar.w(fVar2);
                }
            }
        }, true);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.w.hf.xj
    public void xj(com.bytedance.sdk.openadsdk.core.component.splash.w.xj.hf hfVar, com.bytedance.sdk.openadsdk.core.component.splash.w.w.w<f, c> wVar) {
        hf(hfVar, wVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean xj(com.bytedance.sdk.openadsdk.core.component.splash.w.xj.hf hfVar) {
        ws hf;
        if (hfVar == null || (hf = hfVar.hf()) == null) {
            return false;
        }
        int cy = hf.cy();
        return cy == 3 || cy == 4;
    }
}
