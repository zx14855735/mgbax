package com.bytedance.sdk.gromore.xj.xj.c.y;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.msdk.api.u.p;
import com.bytedance.msdk.w.u.g;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class w implements com.bytedance.sdk.gromore.xj.xj.y.w {
    private com.bytedance.sdk.openadsdk.mediation.hf.hf.xj hf;
    private boolean u;
    private com.bytedance.sdk.openadsdk.jk.xj.hf.xj.xj w;
    private g xj;

    public w(Context context, com.bytedance.sdk.openadsdk.mediation.hf.hf.xj xjVar, com.bytedance.sdk.openadsdk.jk.xj.hf.xj.xj xjVar2, boolean z) {
        this.hf = xjVar;
        this.u = z;
        com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "CSJMSplashLoader 构造函数创建 mAdSlotValueSet = " + this.hf + " mAdSlotValueSet.getCodeId() = " + this.hf.u());
        if (this.hf != null) {
            this.xj = new g(context);
            this.w = xjVar2;
        }
    }

    @Override // com.bytedance.sdk.gromore.xj.xj.kd
    public void xj() {
        xj(-1);
    }

    @Override // com.bytedance.sdk.gromore.xj.xj.y.w
    public void xj(int i) {
        final com.bytedance.sdk.openadsdk.mediation.ad.xj.hf.xj.w g;
        com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "CSJMSplashLoader load timeout = ".concat(String.valueOf(i)));
        com.bytedance.msdk.core.p.xj.xj().hf();
        com.bytedance.msdk.api.xj.hf hfVar = new com.bytedance.msdk.api.xj.hf(3, this.hf.z());
        hfVar.xj(this.u);
        if (i != -1) {
            hfVar.f(i);
        }
        com.bytedance.sdk.openadsdk.mediation.hf.hf.hf ai = this.hf.ai();
        this.xj.xj(hfVar, (ai == null || (g = ai.g()) == null || TextUtils.isEmpty(g.xj()) || TextUtils.isEmpty(g.w()) || TextUtils.isEmpty(g.hf())) ? null : new p() { // from class: com.bytedance.sdk.gromore.xj.xj.c.y.w.1
            @Override // com.bytedance.msdk.api.u.p
            public String hf() {
                return g.hf();
            }

            @Override // com.bytedance.msdk.api.u.p
            public String u() {
                return g.u();
            }

            @Override // com.bytedance.msdk.api.u.p
            public String w() {
                return g.w();
            }

            @Override // com.bytedance.msdk.api.u.p
            public int xj() {
                String xj = g.xj();
                xj.getClass();
                switch (xj) {
                    case "klevin":
                        return 9;
                    case "pangle":
                        return 1;
                    case "sigmob":
                        return 8;
                    case "xiaomi":
                        return 10;
                    case "ks":
                        return 7;
                    case "gdt":
                        return 3;
                    case "baidu":
                        return 6;
                    case "mintegral":
                        return 4;
                    default:
                        return super.xj();
                }
            }
        }, new com.bytedance.msdk.api.u.xj.d.w() { // from class: com.bytedance.sdk.gromore.xj.xj.c.y.w.2
            @Override // com.bytedance.msdk.api.u.xj.d.w
            public void xj(com.bytedance.msdk.api.xj xjVar) {
                com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "CSJMSplashLoader onSplashAdLoadFail");
                if (xjVar == null || w.this.w == null) {
                    return;
                }
                com.bytedance.sdk.gromore.xj.xj.xj xjVar2 = new com.bytedance.sdk.gromore.xj.xj.xj(xjVar.xj, xjVar.hf);
                w.this.w.xj(xjVar2);
                w.this.w.xj(null, xjVar2);
            }

            @Override // com.bytedance.msdk.api.u.xj.d.w
            public void xj() {
                com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "CSJMSplashLoader onSplashAdLoadSuccess");
                if (w.this.w != null) {
                    xj xjVar = new xj(w.this.xj, w.this.w);
                    w.this.w.xj(xjVar);
                    w.this.w.hf(xjVar);
                }
            }
        });
    }
}
