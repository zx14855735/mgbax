package com.bytedance.msdk.w.w.xj;

import android.util.Pair;
import com.bytedance.msdk.w.w.xj.xj;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class y implements xj {
    @Override // com.bytedance.msdk.w.w.xj.xj
    public void hf(xj.InterfaceC0086xj interfaceC0086xj) {
        interfaceC0086xj.xj((String) null);
    }

    @Override // com.bytedance.msdk.w.w.xj.xj
    public void xj(xj.InterfaceC0086xj interfaceC0086xj) {
        com.bytedance.msdk.w.y.xj.hf xj = interfaceC0086xj.xj();
        String ra = xj.v().ra();
        com.bytedance.msdk.core.tf.hf pl2 = xj.pl();
        if (pl2 != null && pl2.p()) {
            if (!com.bytedance.msdk.core.f.g.xj().f(String.valueOf(ra))) {
                com.bytedance.msdk.xj.kd.w.hf("TMe", "广告位 请求触发次数拦截............");
                Pair<String, String> y = com.bytedance.msdk.core.f.g.xj().y(ra);
                com.bytedance.msdk.api.hf.hf hfVar = new com.bytedance.msdk.api.hf.hf(840041, com.bytedance.msdk.api.xj.xj(840041), y != null ? (String) y.second : "", y != null ? (String) y.first : "");
                xj(xj, hfVar.xj);
                xj.xj(hfVar);
                return;
            }
            if (!com.bytedance.msdk.core.f.g.xj().w(String.valueOf(ra)) && !xj.ra()) {
                com.bytedance.msdk.xj.kd.w.hf("TMe", "广告位 请求触发时间间隔拦截............");
                com.bytedance.msdk.core.f.d kd = com.bytedance.msdk.core.f.g.xj().kd(String.valueOf(ra));
                String xj2 = com.bytedance.msdk.api.xj.xj(840042);
                StringBuilder sb = new StringBuilder();
                sb.append(com.bytedance.msdk.core.f.g.xj().xj(ra));
                com.bytedance.msdk.api.hf.w wVar = new com.bytedance.msdk.api.hf.w(840042, xj2, sb.toString(), kd != null ? kd.tf() : "");
                xj(xj, wVar.xj);
                xj.xj(wVar);
                return;
            }
        }
        interfaceC0086xj.xj(interfaceC0086xj.xj());
    }

    private void xj(com.bytedance.msdk.w.y.xj.hf hfVar, int i) {
        com.bytedance.msdk.kd.y.xj(hfVar.v(), (String) null, !hfVar.ra(), hfVar.ff().xj, i, (Map<String, Object>) null);
    }
}
