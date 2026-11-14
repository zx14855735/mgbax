package com.bytedance.sdk.openadsdk.core.component.u;

import com.bytedance.sdk.openadsdk.core.component.w.u;
import com.bytedance.sdk.openadsdk.core.kd.hf;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.zg.w.hf.tf;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class hf extends com.bytedance.sdk.openadsdk.core.kd.hf<List<tf>> {
    public hf(com.bytedance.sdk.openadsdk.core.kd.kd.hf hfVar) {
        super(hfVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.kd.hf
    public /* bridge */ /* synthetic */ void xj(com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar, List list, List<tf> list2) {
        xj2(hfVar, (List<ws>) list, list2);
    }

    @Override // com.bytedance.sdk.openadsdk.core.kd.hf
    public void xj(com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar, List<ws> list, hf.xj<List<tf>> xjVar) {
        ArrayList arrayList = new ArrayList();
        Iterator<ws> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new u(pz.getContext(), it.next(), 6, hfVar));
        }
        if (xjVar != null) {
            xjVar.xj(arrayList);
        }
    }

    /* renamed from: xj, reason: avoid collision after fix types in other method */
    public void xj2(com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar, List<ws> list, List<tf> list2) {
        for (int i = 0; i < list2.size(); i++) {
            ws wsVar = list.get(i);
            tf tfVar = list2.get(i);
            com.bytedance.sdk.openadsdk.core.kd.kd.hf hfVar2 = this.xj;
            if (hfVar2 != null) {
                hfVar2.xj().xj(hfVar, wsVar, tfVar, false);
            }
        }
    }
}
