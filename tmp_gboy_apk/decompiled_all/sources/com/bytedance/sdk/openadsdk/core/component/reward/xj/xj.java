package com.bytedance.sdk.openadsdk.core.component.reward.xj;

import com.bytedance.sdk.openadsdk.core.a.ht;
import com.bytedance.sdk.openadsdk.core.kd.hf;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.core.ra.j;
import com.bytedance.sdk.openadsdk.core.ra.vm;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.core.ra.x;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xj extends y<com.bytedance.sdk.openadsdk.core.component.reward.hf> {
    public xj(com.bytedance.sdk.openadsdk.core.kd.kd.hf hfVar) {
        super(hfVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.xj.y
    public /* synthetic */ void hf(com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar, List list, com.bytedance.sdk.openadsdk.core.component.reward.hf hfVar2) {
        xj(hfVar, (List<ws>) list, hfVar2);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.xj.y
    public boolean xj() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.kd.hf
    public void xj(com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar, List<ws> list, hf.xj<com.bytedance.sdk.openadsdk.core.component.reward.hf> xjVar) {
        com.bytedance.sdk.openadsdk.core.component.reward.hf hfVar2 = new com.bytedance.sdk.openadsdk.core.component.reward.hf(pz.getContext(), list.get(0), hfVar);
        if (xjVar != null) {
            xjVar.xj(hfVar2);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.xj.y
    public boolean xj(com.bytedance.sdk.openadsdk.core.ra.xj xjVar) {
        List<ws> hf;
        if (xjVar != null && (hf = xjVar.hf()) != null) {
            ws wsVar = hf.get(0);
            if (x.xj(wsVar)) {
                return wsVar.lq().w() != 1;
            }
            if (j.hf(xj(), wsVar, false) && j.u(wsVar) != 0) {
                return true;
            }
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.xj.y
    public void xj(com.bytedance.sdk.openadsdk.core.component.reward.hf hfVar) {
        hfVar.xj(1);
    }

    public void xj(com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar, List<ws> list, com.bytedance.sdk.openadsdk.core.component.reward.hf hfVar2) {
        ws wsVar = list.get(0);
        if (wsVar.o() <= 0) {
            hfVar2.xj(System.currentTimeMillis() + 10500000);
        } else {
            hfVar2.xj(wsVar.o() * 1000);
        }
        if (com.bytedance.sdk.openadsdk.core.video.w.xj.xj(wsVar) || ht.w(wsVar) || vm.xj(wsVar) || !wsVar.ha()) {
            return;
        }
        hfVar2.y();
    }
}
