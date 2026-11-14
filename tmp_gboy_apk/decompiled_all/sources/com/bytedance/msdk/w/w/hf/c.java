package com.bytedance.msdk.w.w.hf;

import com.bytedance.msdk.core.tf.tf;
import com.bytedance.msdk.w.f.kd;
import com.bytedance.msdk.w.w.hf.xj;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class c implements xj {
    @Override // com.bytedance.msdk.w.w.hf.xj
    public void xj(xj.InterfaceC0081xj interfaceC0081xj) {
        kd.xj xj;
        com.bytedance.msdk.w.y.xj.hf hf = interfaceC0081xj.hf();
        com.bytedance.msdk.w.y.hf.hf xj2 = interfaceC0081xj.xj();
        if (hf != null && xj2 != null) {
            com.bytedance.msdk.api.xj.hf v = hf.v();
            tf f = xj2.f();
            if (v != null && f != null && (xj = com.bytedance.msdk.w.f.kd.xj(v, f)) != null) {
                com.bytedance.msdk.api.xj xjVar = new com.bytedance.msdk.api.xj(81018, "命中跳过:" + xj.xj);
                com.bytedance.msdk.kd.y.xj(f, v, com.bytedance.msdk.core.kd.xj.xj.xj().xj(f.yo()), xj2.kd(), 2, xj2.w(), xj2.c(), xj2.y(), xjVar, -1L, false, false);
                com.bytedance.msdk.kd.y.xj(xjVar, v, f, xj2.w(), xj2.c(), xj2.y(), com.bytedance.msdk.core.kd.xj.xj.xj().xj(f.yo()), 0L, (String) null, (String) null, (String) null, 0L);
                xj2.xj(xjVar, f);
                return;
            }
        }
        interfaceC0081xj.xj(this);
    }
}
