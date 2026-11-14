package com.bytedance.sdk.gromore.xj.xj.c.hf;

import android.content.Context;
import com.bytedance.msdk.w.u.c;
import com.bytedance.sdk.gromore.xj.xj.kd;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class w implements kd {
    private com.bytedance.sdk.openadsdk.mediation.hf.hf.xj hf;
    private com.bytedance.sdk.openadsdk.jk.xj.hf.xj.hf w;
    private c xj;

    public w(Context context, com.bytedance.sdk.openadsdk.mediation.hf.hf.xj xjVar, com.bytedance.sdk.openadsdk.jk.xj.hf.xj.hf hfVar) {
        this.hf = xjVar;
        if (xjVar != null) {
            this.xj = new c(context);
            this.w = hfVar;
        }
    }

    @Override // com.bytedance.sdk.gromore.xj.xj.kd
    public void xj() {
        this.xj.xj(new com.bytedance.msdk.api.xj.hf(9, this.hf.z()), new com.bytedance.msdk.api.u.xj.w.hf() { // from class: com.bytedance.sdk.gromore.xj.xj.c.hf.w.1
            @Override // com.bytedance.msdk.api.u.xj.w.hf
            public void xj(List<com.bytedance.msdk.hf.w> list) {
                if (list == null) {
                    xj(new com.bytedance.msdk.api.xj(MediationConstant.ErrorCode.ADN_AD_LOAD_FAIL, "list is null"));
                    return;
                }
                if (w.this.w != null) {
                    ArrayList arrayList = new ArrayList();
                    Iterator<com.bytedance.msdk.hf.w> it = list.iterator();
                    while (it.hasNext()) {
                        arrayList.add(new xj(w.this.xj, it.next(), w.this.xj.jk()));
                    }
                    w.this.w.xj(arrayList);
                }
            }

            @Override // com.bytedance.msdk.api.u.xj.w.hf
            public void xj(com.bytedance.msdk.api.xj xjVar) {
                if (xjVar == null || w.this.w == null) {
                    return;
                }
                w.this.w.xj(xjVar.xj, xjVar.hf);
            }
        });
    }
}
