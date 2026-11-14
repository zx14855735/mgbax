package com.bytedance.sdk.openadsdk.core.component.splash.hf.xj;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.component.splash.w.xj.c;
import com.bytedance.sdk.openadsdk.core.component.splash.w.xj.kd;
import com.bytedance.sdk.openadsdk.core.component.splash.w.xj.y;
import com.bytedance.sdk.openadsdk.core.dk;
import com.bytedance.sdk.openadsdk.core.pz;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class w {
    private c xj = new c();
    private int w = 3;
    private final dk hf = pz.xj();

    public void xj(final kd kdVar, final com.bytedance.sdk.openadsdk.core.component.splash.w.w.hf<y, c> hfVar) {
        if (this.hf == null || kdVar == null) {
            return;
        }
        this.xj.hf(false);
        this.hf.xj(kdVar.u(), kdVar.kd(), this.w, new dk.hf() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.hf.xj.w.1
            @Override // com.bytedance.sdk.openadsdk.core.dk.hf
            public void xj(int i, String str, com.bytedance.sdk.openadsdk.core.ra.hf hfVar2) {
                w.this.xj.hf(i);
                w.this.xj.w(hfVar2 != null ? hfVar2.w() : 0);
                if (TextUtils.isEmpty(str)) {
                    str = "load ad error";
                }
                w.this.xj.xj(str);
                hfVar.xj(w.this.xj);
            }

            @Override // com.bytedance.sdk.openadsdk.core.dk.hf
            public void xj(com.bytedance.sdk.openadsdk.core.ra.xj xjVar, com.bytedance.sdk.openadsdk.core.ra.hf hfVar2) {
                if (xjVar == null || xjVar.hf() == null) {
                    w.this.xj.hf(1);
                    w.this.xj.xj("no ad or material");
                    hfVar.xj(w.this.xj);
                    return;
                }
                y yVar = new y(xjVar, false);
                yVar.hf(hfVar2.d());
                yVar.w(hfVar2.tf());
                yVar.u(hfVar2.p());
                yVar.kd(hfVar2.pl());
                yVar.xj(kdVar.xj());
                yVar.xj(kdVar.w());
                hfVar.hf(yVar);
            }
        });
    }
}
