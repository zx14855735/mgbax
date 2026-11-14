package com.bytedance.sdk.gromore.xj.xj.c.u;

import android.content.Context;
import com.bytedance.msdk.w.u.d;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class kd implements com.bytedance.sdk.gromore.xj.xj.kd {
    private com.bytedance.sdk.openadsdk.jk.xj.hf.xj.y hf;
    private boolean u;
    private d w;
    private com.bytedance.sdk.openadsdk.mediation.hf.hf.xj xj;

    public kd(Context context, com.bytedance.sdk.openadsdk.mediation.hf.hf.xj xjVar, com.bytedance.sdk.openadsdk.jk.xj.hf.xj.y yVar, boolean z) {
        this.xj = xjVar;
        this.u = z;
        if (xjVar != null) {
            this.w = new d(context);
            this.hf = yVar;
        }
    }

    @Override // com.bytedance.sdk.gromore.xj.xj.kd
    public void xj() {
        com.bytedance.msdk.api.xj.hf hfVar = new com.bytedance.msdk.api.xj.hf(5, this.xj.z());
        hfVar.xj(this.u);
        this.w.xj(hfVar, new com.bytedance.msdk.api.u.xj.c.u() { // from class: com.bytedance.sdk.gromore.xj.xj.c.u.kd.1
            @Override // com.bytedance.msdk.api.u.xj.c.u
            public void xj(List<com.bytedance.msdk.hf.w> list) {
                com.bytedance.sdk.openadsdk.mediation.hf.hf.hf ai;
                if (list == null) {
                    xj(new com.bytedance.msdk.api.xj(MediationConstant.ErrorCode.ADN_AD_LOAD_FAIL, "list is null"));
                    return;
                }
                if (kd.this.hf != null) {
                    com.bytedance.sdk.openadsdk.mediation.ad.xj.hf.xj.hf tf = (kd.this.xj == null || (ai = kd.this.xj.ai()) == null) ? null : ai.tf();
                    LinkedList linkedList = new LinkedList();
                    Iterator<com.bytedance.msdk.hf.w> it = list.iterator();
                    while (it.hasNext()) {
                        linkedList.add(new u(kd.this.w, it.next(), kd.this.w.jk(), tf));
                    }
                    kd.this.hf.xj(linkedList);
                }
            }

            @Override // com.bytedance.msdk.api.u.xj.c.u
            public void xj(com.bytedance.msdk.api.xj xjVar) {
                if (xjVar == null || kd.this.hf == null) {
                    return;
                }
                kd.this.hf.xj(xjVar.xj, xjVar.hf);
            }
        });
    }
}
