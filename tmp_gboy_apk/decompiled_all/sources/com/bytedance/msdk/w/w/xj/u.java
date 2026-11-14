package com.bytedance.msdk.w.w.xj;

import com.bytedance.msdk.w.w.xj.xj;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class u implements xj {
    @Override // com.bytedance.msdk.w.w.xj.xj
    public void hf(xj.InterfaceC0086xj interfaceC0086xj) {
        interfaceC0086xj.xj((String) null);
    }

    @Override // com.bytedance.msdk.w.w.xj.xj
    public void xj(xj.InterfaceC0086xj interfaceC0086xj) {
        com.bytedance.msdk.w.y.xj.hf xj = interfaceC0086xj.xj();
        xj.g().xj(0);
        int w = xj.v().w();
        List<com.bytedance.msdk.core.tf.tf> list = xj.pl().io().get(0);
        JSONObject jSONObject = new JSONObject();
        String xj2 = com.bytedance.msdk.core.g.xj.xj().xj(xj.pz(), xj.getContext(), xj.v(), list, xj.pl(), w, !xj.ra(), jSONObject);
        com.bytedance.msdk.kd.y.xj(xj.v(), jSONObject);
        xj.xj(xj2);
    }
}
