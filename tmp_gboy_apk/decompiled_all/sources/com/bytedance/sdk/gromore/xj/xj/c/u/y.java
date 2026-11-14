package com.bytedance.sdk.gromore.xj.xj.c.u;

import android.content.Context;
import com.bytedance.msdk.w.u.d;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class y implements com.bytedance.sdk.gromore.xj.xj.kd {
    private com.bytedance.sdk.openadsdk.mediation.hf.hf.xj hf;
    private boolean u;
    private com.bytedance.sdk.openadsdk.jk.xj.hf.xj.w w;
    private d xj;

    public y(Context context, com.bytedance.sdk.openadsdk.mediation.hf.hf.xj xjVar, com.bytedance.sdk.openadsdk.jk.xj.hf.xj.w wVar, boolean z) {
        this.hf = xjVar;
        this.u = z;
        if (xjVar != null) {
            this.xj = new d(context);
            this.w = wVar;
        }
    }

    @Override // com.bytedance.sdk.gromore.xj.xj.kd
    public void xj() {
        com.bytedance.msdk.api.xj.hf hfVar = new com.bytedance.msdk.api.xj.hf(5, this.hf.z());
        hfVar.xj(this.u);
        this.xj.xj(hfVar, new com.bytedance.msdk.api.u.xj.c.u() { // from class: com.bytedance.sdk.gromore.xj.xj.c.u.y.1
            @Override // com.bytedance.msdk.api.u.xj.c.u
            public void xj(List<com.bytedance.msdk.hf.w> list) {
                if (list == null) {
                    xj(new com.bytedance.msdk.api.xj(MediationConstant.ErrorCode.ADN_AD_LOAD_FAIL, "list is null"));
                    return;
                }
                if (y.this.w != null) {
                    LinkedList linkedList = new LinkedList();
                    Iterator<com.bytedance.msdk.hf.w> it = list.iterator();
                    while (it.hasNext()) {
                        linkedList.add(new hf(y.this.xj, it.next(), y.this.xj.jk()));
                    }
                    y.this.w.xj(linkedList);
                }
            }

            @Override // com.bytedance.msdk.api.u.xj.c.u
            public void xj(com.bytedance.msdk.api.xj xjVar) {
                if (xjVar == null || y.this.w == null) {
                    return;
                }
                y.this.w.xj(xjVar.xj, xjVar.hf);
            }
        });
    }
}
