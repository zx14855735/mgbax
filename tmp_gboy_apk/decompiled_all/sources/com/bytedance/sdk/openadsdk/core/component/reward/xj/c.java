package com.bytedance.sdk.openadsdk.core.component.reward.xj;

import com.bytedance.sdk.openadsdk.core.a.ht;
import com.bytedance.sdk.openadsdk.core.kd.hf;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.core.ra.j;
import com.bytedance.sdk.openadsdk.core.ra.vm;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class c extends y<com.bytedance.sdk.openadsdk.core.component.reward.w> {
    public c(com.bytedance.sdk.openadsdk.core.kd.kd.hf hfVar) {
        super(hfVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.xj.y
    public /* synthetic */ void hf(com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar, List list, com.bytedance.sdk.openadsdk.core.component.reward.w wVar) {
        xj(hfVar, (List<ws>) list, wVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.xj.y
    public boolean xj() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.kd.hf
    public void xj(com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar, List<ws> list, hf.xj<com.bytedance.sdk.openadsdk.core.component.reward.w> xjVar) {
        com.bytedance.sdk.openadsdk.core.component.reward.w wVar = new com.bytedance.sdk.openadsdk.core.component.reward.w(pz.getContext(), list.get(0), hfVar);
        if (xjVar != null) {
            xjVar.xj(wVar);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.xj.y
    public boolean xj(com.bytedance.sdk.openadsdk.core.ra.xj xjVar) {
        List<ws> hf;
        if (xjVar != null && (hf = xjVar.hf()) != null) {
            ws wsVar = hf.get(0);
            if (j.hf(xj(), wsVar, false) && j.u(wsVar) != 0) {
                return true;
            }
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.xj.y
    public void xj(com.bytedance.sdk.openadsdk.core.component.reward.w wVar) {
        wVar.w(1);
    }

    public void xj(com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar, List<ws> list, com.bytedance.sdk.openadsdk.core.component.reward.w wVar) {
        ws wsVar = list.get(0);
        if (wsVar.o() <= 0) {
            wVar.xj(System.currentTimeMillis() + 10500000);
        } else {
            wVar.xj(wsVar.o() * 1000);
        }
        if (com.bytedance.sdk.openadsdk.core.video.w.xj.xj(wsVar) || ht.w(wsVar) || vm.xj(wsVar) || !wsVar.ha()) {
            return;
        }
        wVar.y();
    }
}
