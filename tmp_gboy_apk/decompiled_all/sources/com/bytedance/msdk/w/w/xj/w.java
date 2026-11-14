package com.bytedance.msdk.w.w.xj;

import com.bytedance.msdk.w.w.xj.xj;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class w implements xj {
    @Override // com.bytedance.msdk.w.w.xj.xj
    public void hf(xj.InterfaceC0086xj interfaceC0086xj) {
        interfaceC0086xj.xj((String) null);
    }

    @Override // com.bytedance.msdk.w.w.xj.xj
    public void xj(xj.InterfaceC0086xj interfaceC0086xj) {
        com.bytedance.msdk.w.y.xj.hf xj = interfaceC0086xj.xj();
        com.bytedance.msdk.api.xj.hf v = xj.v();
        com.bytedance.msdk.core.tf.hf pl2 = xj.pl();
        com.bytedance.msdk.core.tf.hf xj2 = com.bytedance.msdk.core.w.w.xj(v, pl2);
        if (xj2 != null) {
            if (v.w() == 2 || v.w() == 4 || v.w() == 5) {
                com.bytedance.msdk.core.kd.hf.u.xj().xj(v.ra(), v);
            }
            pl2 = xj2;
        }
        if (pl2.yy() == null || pl2.yy().size() == 0) {
            com.bytedance.msdk.kd.y.xj(v, xj.pl() != null ? xj.pl().hl() : null, !xj.ra(), xj.ff().xj, 810085, (Map<String, Object>) null);
            xj.xj(new com.bytedance.msdk.api.xj(810085, com.bytedance.msdk.api.xj.xj(810085)));
        } else {
            xj.xj(pl2);
            interfaceC0086xj.xj(interfaceC0086xj.xj());
        }
    }
}
