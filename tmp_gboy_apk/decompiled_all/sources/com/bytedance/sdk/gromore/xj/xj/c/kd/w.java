package com.bytedance.sdk.gromore.xj.xj.c.kd;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.msdk.w.u.pl;
import com.bytedance.sdk.gromore.xj.xj.kd;
import com.bytedance.sdk.openadsdk.jk.xj.hf.xj.c;
import java.util.HashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class w implements kd {
    private com.bytedance.sdk.openadsdk.mediation.hf.hf.xj hf;
    private xj u;
    private c w;
    private pl xj;

    public w(Context context, com.bytedance.sdk.openadsdk.mediation.hf.hf.xj xjVar, c cVar) {
        this.hf = xjVar;
        if (xjVar != null) {
            this.xj = new pl(context);
            this.w = cVar;
        }
    }

    @Override // com.bytedance.sdk.gromore.xj.xj.kd
    public void xj() {
        HashMap hashMap = new HashMap();
        String g = this.hf.g();
        if (!TextUtils.isEmpty(g)) {
            hashMap.put("gdt", g);
        }
        this.xj.xj(new com.bytedance.msdk.api.xj.hf(7, this.hf.z()), new com.bytedance.msdk.api.u.xj.f.hf() { // from class: com.bytedance.sdk.gromore.xj.xj.c.kd.w.1
            @Override // com.bytedance.msdk.api.u.xj.f.hf
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

            @Override // com.bytedance.msdk.api.u.xj.f.hf
            public void xj(com.bytedance.msdk.api.xj xjVar) {
                if (xjVar == null || w.this.w == null) {
                    return;
                }
                w.this.w.xj(xjVar.xj, xjVar.hf);
            }

            @Override // com.bytedance.msdk.api.u.xj.f.hf
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
