package com.bytedance.msdk.w.w.hf;

import com.bytedance.msdk.core.tf.tf;
import com.bytedance.msdk.w.w.hf.xj;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class y implements xj {
    @Override // com.bytedance.msdk.w.w.hf.xj
    public void xj(xj.InterfaceC0081xj interfaceC0081xj) {
        List<com.bytedance.msdk.core.kd.hf.c> xj;
        tf f = interfaceC0081xj.xj().f();
        com.bytedance.msdk.api.xj.hf v = interfaceC0081xj.hf().v();
        if (f != null) {
            String yo = f.yo();
            if (f.jk() && com.bytedance.msdk.core.kd.xj.xj.xj().u(v.ra(), yo, v.kd())) {
                com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "--==-- 广告复用，模式：" + com.bytedance.msdk.core.kd.xj.xj.xj().kd(v.ra(), yo, v.kd()));
                int xj2 = com.bytedance.msdk.core.kd.xj.xj.xj().xj(yo, v, true);
                interfaceC0081xj.xj().w(xj2);
                if (xj2 == 3) {
                    interfaceC0081xj.xj().xj(2);
                    if (xj(interfaceC0081xj.hf(), interfaceC0081xj.xj(), v, yo, f, 2)) {
                        return;
                    }
                } else if (xj2 == 2 && (xj = com.bytedance.msdk.core.kd.xj.xj.xj().xj(yo, v, v.kd())) != null && xj.size() > 0) {
                    interfaceC0081xj.xj().hf(xj.get(0).xj.f(v.xj()));
                }
                interfaceC0081xj.xj(this);
            }
        }
        interfaceC0081xj.xj(this);
    }

    private boolean xj(com.bytedance.msdk.w.y.xj.hf hfVar, com.bytedance.msdk.w.y.hf.hf hfVar2, com.bytedance.msdk.api.xj.hf hfVar3, String str, tf tfVar, int i) {
        com.bytedance.msdk.core.kd.xj.xj.xj().xj(hfVar3.ra(), str, tfVar, i);
        List<com.bytedance.msdk.core.kd.hf.c> xj = com.bytedance.msdk.core.kd.xj.xj.xj().xj(str, hfVar3, hfVar3.kd());
        if (xj == null || xj.size() <= 0) {
            return false;
        }
        int f = xj.get(0).xj.f(hfVar3.xj());
        com.bytedance.msdk.kd.y.xj(tfVar, hfVar3, com.bytedance.msdk.core.kd.xj.xj.xj().xj(str), !hfVar.ra(), 1, i, 3, f, (com.bytedance.msdk.api.xj) null, -1L, false, false);
        ArrayList arrayList = new ArrayList();
        for (com.bytedance.msdk.core.kd.hf.c cVar : xj) {
            cVar.xj.d(3);
            cVar.xj.tf(f);
            cVar.xj.w(false);
            cVar.xj.hf(false);
            com.bytedance.msdk.w.f.y.xj(cVar.xj, hfVar3.ra(), str);
            arrayList.add(cVar.xj);
        }
        com.bytedance.msdk.kd.y.xj(xj.get(0).xj, 0, "adn cache命中", 0L, hfVar3, i, arrayList.size(), 2, (String) null, 0L, -1L);
        hfVar2.xj(arrayList, tfVar);
        return true;
    }
}
