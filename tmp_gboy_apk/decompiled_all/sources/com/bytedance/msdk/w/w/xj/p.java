package com.bytedance.msdk.w.w.xj;

import com.bytedance.msdk.w.w.xj.xj;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class p implements xj {
    @Override // com.bytedance.msdk.w.w.xj.xj
    public void hf(xj.InterfaceC0086xj interfaceC0086xj) {
        interfaceC0086xj.xj((String) null);
    }

    @Override // com.bytedance.msdk.w.w.xj.xj
    public void xj(xj.InterfaceC0086xj interfaceC0086xj) {
        com.bytedance.msdk.w.y.xj.hf xj = interfaceC0086xj.xj();
        com.bytedance.msdk.api.xj.hf v = xj.v();
        v.ra();
        if (!v.dq()) {
            interfaceC0086xj.xj(interfaceC0086xj.xj());
            return;
        }
        String str = com.bytedance.msdk.xj.kd.kd.xj(v.ra()) + "V2 公共缓存池广告请求......";
        String str2 = MediationConstant.TAG;
        com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, str);
        String hl = xj.pl() != null ? xj.pl().hl() : null;
        boolean z = !xj.ra();
        if (!com.bytedance.msdk.core.hf.hf().y()) {
            com.bytedance.msdk.w.kd.xj.xj(v, "-2");
            com.bytedance.msdk.api.hf.xj xjVar = new com.bytedance.msdk.api.hf.xj(41007, com.bytedance.msdk.api.xj.xj(41007));
            com.bytedance.msdk.kd.y.xj(v, hl, z, xj.ff().xj, xjVar.xj, (Map<String, Object>) null);
            xj.xj(xjVar);
            return;
        }
        List<com.bytedance.msdk.core.kd.hf.c> xj2 = com.bytedance.msdk.w.kd.xj.xj().xj(v);
        if (xj2 == null || xj2.isEmpty()) {
            com.bytedance.msdk.w.kd.xj.xj(v, "-1");
            com.bytedance.msdk.api.hf.xj xjVar2 = new com.bytedance.msdk.api.hf.xj(41008, com.bytedance.msdk.api.xj.xj(41008));
            com.bytedance.msdk.kd.y.xj(v, hl, z, xj.ff().xj, xjVar2.xj, (Map<String, Object>) null);
            xj.xj(xjVar2);
            return;
        }
        com.bytedance.msdk.kd.y.xj(xj2.get(0).xj, v, xj.pl(), 0L, xj.ff().xj, z, xj2.size(), xj.ff().kd, false);
        com.bytedance.msdk.api.xj.hf hfVar = v;
        int size = xj2.size() - 1;
        String str3 = null;
        while (size >= 0) {
            com.bytedance.msdk.core.kd.hf.c cVar = xj2.get(size);
            com.bytedance.msdk.hf.w wVar = cVar.xj;
            wVar.xj(cVar.y());
            wVar.hf(cVar.u() != null ? cVar.u().xj() : null);
            if (size == 0) {
                str3 = cVar.y();
            }
            String str4 = str3;
            ArrayList arrayList = new ArrayList();
            arrayList.add(wVar);
            com.bytedance.msdk.w.kd.xj.xj(hfVar, cVar.y());
            int i = size;
            com.bytedance.msdk.api.xj.hf hfVar2 = hfVar;
            com.bytedance.msdk.kd.y.xj(com.bytedance.msdk.core.hf.hf().xj(cVar.y(), hfVar.ht(), 102).y(wVar.cy()), hfVar2, com.bytedance.msdk.core.kd.xj.xj.xj().xj(wVar.cy()), true, 1, 0, 3, 3, null, -1L, false, false, cVar.u() != null ? cVar.u().xj() : null);
            xj.xj(arrayList);
            com.bytedance.msdk.kd.y.xj(wVar, 0, "adn cache命中", 0L, hfVar2, 0, arrayList.size(), 2, (String) null, 0L, -1L);
            hfVar = hfVar2;
            size = i - 1;
            str2 = str2;
            str3 = str4;
            xj2 = xj2;
        }
        com.bytedance.msdk.w.kd.xj.xj(hfVar, str3);
        com.bytedance.msdk.xj.kd.w.hf(str2, com.bytedance.msdk.xj.kd.kd.xj(hfVar.ra()) + "V2 resetAdLinkInfo......");
        com.bytedance.msdk.kd.y.xj(hfVar, hl, z, xj.ff().xj, 0, (Map<String, Object>) null);
        xj.u();
    }
}
