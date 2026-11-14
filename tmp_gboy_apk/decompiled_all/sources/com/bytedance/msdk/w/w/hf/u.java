package com.bytedance.msdk.w.w.hf;

import android.util.Pair;
import com.bytedance.msdk.core.f.am;
import com.bytedance.msdk.core.f.d;
import com.bytedance.msdk.core.f.p;
import com.bytedance.msdk.core.f.pl;
import com.bytedance.msdk.core.tf.tf;
import com.bytedance.msdk.w.w.hf.xj;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class u implements xj {
    @Override // com.bytedance.msdk.w.w.hf.xj
    public void xj(xj.InterfaceC0081xj interfaceC0081xj) {
        com.bytedance.msdk.api.xj xjVar;
        com.bytedance.msdk.w.y.hf.hf xj = interfaceC0081xj.xj();
        com.bytedance.msdk.w.y.xj.hf hf = interfaceC0081xj.hf();
        tf f = xj.f();
        String ra = hf.v().ra();
        if (f != null) {
            if (f.u() && !p.xj().w(ra, f.yo())) {
                com.bytedance.msdk.xj.kd.w.hf("TMe", "adn 请求触发次数拦截............");
                Pair<String, String> xj2 = p.xj().xj(ra, f.yo());
                com.bytedance.msdk.api.xj hfVar = xj2 != null ? new com.bytedance.msdk.api.hf.hf(41041, com.bytedance.msdk.api.xj.xj(41041), (String) xj2.second, (String) xj2.first) : new com.bytedance.msdk.api.xj(41041, com.bytedance.msdk.api.xj.xj(41041));
                com.bytedance.msdk.kd.y.xj(f, hf.v(), com.bytedance.msdk.core.kd.xj.xj.xj().xj(f.yo()), xj.kd(), 2, xj.w(), xj.c(), xj.y(), hfVar, -1L, hf.ff().kd, false);
                com.bytedance.msdk.kd.y.xj(hfVar, hf.v(), f, xj.w(), xj.c(), xj.y(), com.bytedance.msdk.core.kd.xj.xj.xj().xj(f.yo()), 0L, (String) null, (String) null, (String) null, 0L);
                xj.xj(hfVar, f);
                return;
            }
            if (f.u() && !pl.xj().w(ra, f.yo())) {
                com.bytedance.msdk.xj.kd.w.hf("TMe", "adn 请求触发时间间隔拦截............");
                d u = pl.xj().u(ra, f.yo());
                if (u != null) {
                    String xj3 = com.bytedance.msdk.api.xj.xj(41042);
                    StringBuilder sb = new StringBuilder();
                    sb.append(pl.xj().xj(ra, f.yo()));
                    xjVar = new com.bytedance.msdk.api.hf.w(41042, xj3, sb.toString(), u.tf());
                } else {
                    xjVar = new com.bytedance.msdk.api.xj(41042, com.bytedance.msdk.api.xj.xj(41042));
                }
                com.bytedance.msdk.api.xj xjVar2 = xjVar;
                com.bytedance.msdk.kd.y.xj(f, hf.v(), com.bytedance.msdk.core.kd.xj.xj.xj().xj(f.yo()), xj.kd(), 2, xj.w(), xj.c(), xj.y(), xjVar2, -1L, hf.ff().kd, false);
                com.bytedance.msdk.kd.y.xj(xjVar2, hf.v(), f, xj.w(), xj.c(), xj.y(), com.bytedance.msdk.core.kd.xj.xj.xj().xj(f.yo()), 0L, (String) null, (String) null, (String) null, 0L);
                xj.xj(xjVar2, f);
                return;
            }
            if (am.xj().xj(ra, f.e())) {
                com.bytedance.msdk.api.xj xj4 = am.xj().xj(ra, f.qt(), f.yo());
                if (xj4 != null) {
                    com.bytedance.msdk.xj.kd.w.hf("TMe", "adn 请求触发了rit级别的错误码拦截............");
                    com.bytedance.msdk.kd.y.xj(f, hf.v(), com.bytedance.msdk.core.kd.xj.xj.xj().xj(f.yo()), xj.kd(), 2, xj.w(), xj.c(), xj.y(), xj4, -1L, hf.ff().kd, false);
                    com.bytedance.msdk.kd.y.xj(xj4, hf.v(), f, xj.w(), xj.c(), xj.y(), com.bytedance.msdk.core.kd.xj.xj.xj().xj(f.yo()), 0L, (String) null, (String) null, (String) null, 0L);
                    xj.xj(xj4, f);
                    return;
                }
            } else {
                com.bytedance.msdk.api.xj xj5 = com.bytedance.msdk.core.f.w.xj().xj(f.qt(), f.yo());
                if (xj5 != null) {
                    com.bytedance.msdk.xj.kd.w.hf("TMe", "adn 请求触发了错误码拦截............");
                    com.bytedance.msdk.kd.y.xj(f, hf.v(), com.bytedance.msdk.core.kd.xj.xj.xj().xj(f.yo()), xj.kd(), 2, xj.w(), xj.c(), xj.y(), xj5, -1L, hf.ff().kd, false);
                    com.bytedance.msdk.kd.y.xj(xj5, hf.v(), f, xj.w(), xj.c(), xj.y(), com.bytedance.msdk.core.kd.xj.xj.xj().xj(f.yo()), 0L, (String) null, (String) null, (String) null, 0L);
                    xj.xj(xj5, f);
                    return;
                }
            }
        }
        interfaceC0081xj.xj(this);
    }
}
