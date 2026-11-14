package com.bytedance.msdk.w.w.xj;

import ADYaiT.CtFAbx;
import com.bytedance.msdk.core.kd.hf.u;
import com.bytedance.msdk.w.w.xj.xj;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class f implements xj {
    private int xj = 0;

    @Override // com.bytedance.msdk.w.w.xj.xj
    public void hf(xj.InterfaceC0086xj interfaceC0086xj) {
        interfaceC0086xj.xj((String) null);
    }

    @Override // com.bytedance.msdk.w.w.xj.xj
    public void xj(xj.InterfaceC0086xj interfaceC0086xj) {
        String ff = interfaceC0086xj.xj().pl().ff();
        com.bytedance.msdk.api.xj.hf v = interfaceC0086xj.xj().v();
        boolean ra = interfaceC0086xj.xj().ra();
        if (com.bytedance.msdk.core.kd.hf.u.xj().w(ff, v.kd())) {
            boolean z = com.bytedance.msdk.core.kd.hf.u.xj().xj(ff) == null;
            if (!ra && !z && xj(ff, v, interfaceC0086xj.xj())) {
                interfaceC0086xj.xj().w(true);
                xj(v, ff, interfaceC0086xj.xj().pl(), interfaceC0086xj.xj());
                return;
            }
            com.bytedance.msdk.core.kd.hf.u.xj().xj(ff, v);
        }
        interfaceC0086xj.xj(interfaceC0086xj.xj());
    }

    private boolean xj(String str, com.bytedance.msdk.api.xj.hf hfVar, com.bytedance.msdk.w.y.xj.hf hfVar2) {
        List<com.bytedance.msdk.core.kd.hf.c> u;
        com.bytedance.msdk.core.tf.hf pl2 = hfVar2.pl();
        if (com.bytedance.msdk.core.kd.hf.u.xj().xj(str, hfVar, pl2 != null ? pl2.hl() : null) && (u = com.bytedance.msdk.core.kd.hf.u.xj().u(str)) != null && u.size() > 0) {
            for (com.bytedance.msdk.core.kd.hf.c cVar : u) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(cVar.xj);
                hfVar2.xj(arrayList);
            }
            if (hfVar2.c().size() > 0 || hfVar2.tf().size() > 0 || hfVar2.f().size() > 0) {
                com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, com.bytedance.msdk.xj.kd.kd.xj(str) + "--==-- hit cache!!! -----");
                return true;
            }
        }
        com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, com.bytedance.msdk.xj.kd.kd.xj(str) + "--==-- not hit cache!!! -----");
        return false;
    }

    private void xj(com.bytedance.msdk.api.xj.hf hfVar, String str, com.bytedance.msdk.core.tf.hf hfVar2, final com.bytedance.msdk.w.y.xj.hf hfVar3) {
        com.bytedance.msdk.api.xj.hf hf = com.bytedance.msdk.core.kd.hf.u.xj().hf(str);
        if (hf != null) {
            hfVar.xj(hf.xj());
            hfVar.hf(hf.w());
        }
        com.bytedance.msdk.core.kd.hf.u.xj().xj(str, hfVar);
        com.bytedance.msdk.kd.y.xj(hfVar3.v(), hfVar2.hl(), !hfVar3.ra(), hfVar3.ff().xj, 0, (Map<String, Object>) null);
        com.bytedance.msdk.hf.w wVar = null;
        com.bytedance.msdk.w.f.xj.xj(hfVar3, null, false);
        com.bytedance.msdk.core.kd.hf.hf w = com.bytedance.msdk.core.kd.hf.u.xj().w(str);
        if (w != null) {
            hfVar3.xj(w.u() != null ? w.u().ff() : null);
            hfVar3.xj(w.w());
        }
        final int hf2 = com.bytedance.msdk.core.kd.hf.u.xj().hf(str, hfVar.kd());
        if (hf2 == 2) {
            this.xj = 1;
            hfVar3.xj(1);
            hfVar3.u();
            return;
        }
        if (hf2 != 3 && hf2 != 4) {
            com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "--==-- 预缓存reqType错误：reqType = ".concat(String.valueOf(hf2)));
            return;
        }
        if (hfVar.f() == 1) {
            com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "--==-- 激励再得情况，不进行预缓存补充，直接对外给出回调");
            this.xj = 2;
            hfVar3.xj(2);
            hfVar3.u();
            return;
        }
        long kd = com.bytedance.msdk.core.kd.hf.u.kd(str);
        long currentTimeMillis = System.currentTimeMillis() - kd;
        if (kd != -1 && currentTimeMillis < hfVar2.kd()) {
            StringBuilder B2KMhB2 = CtFAbx.B2KMhB("--==-- 预缓存补充请求无需发起，时间间隔不够，interval：", currentTimeMillis, ", config interval: ");
            B2KMhB2.append(hfVar2.kd());
            com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, B2KMhB2.toString());
            this.xj = 3;
            hfVar3.xj(3);
            hfVar3.u();
            return;
        }
        List<com.bytedance.msdk.hf.w> jk = hfVar3.jk();
        if (jk != null && jk.size() > 0) {
            wVar = jk.get(0);
        }
        com.bytedance.msdk.hf.w wVar2 = wVar;
        final double xj = xj(str, hfVar.ht());
        if (wVar2 == null || wVar2.no() || wVar2.da() >= xj) {
            com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "--==-- 预缓存补充请求无需发起，已经命中最优");
            this.xj = 4;
            hfVar3.xj(4);
            hfVar3.u();
            return;
        }
        com.bytedance.msdk.core.kd.hf.u.xj().xj(hfVar3.getContext(), str, hf2, hfVar, wVar2, new u.w() { // from class: com.bytedance.msdk.w.w.xj.f.1
            @Override // com.bytedance.msdk.core.kd.hf.u.w
            public void xj(String str2, boolean z, int i, List<com.bytedance.msdk.hf.w> list) {
                f.this.xj(str2, z, i, list, hf2, xj, hfVar3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(String str, boolean z, int i, List<com.bytedance.msdk.hf.w> list, int i2, double d, com.bytedance.msdk.w.y.xj.hf hfVar) {
        if (z) {
            if (i2 == 4) {
                com.bytedance.msdk.hf.w wVar = (list == null || list.size() <= 0) ? null : list.get(0);
                if (wVar != null && wVar.da() >= d) {
                    this.xj = 6;
                } else {
                    this.xj = 7;
                }
            } else if (i2 == 3) {
                this.xj = 5;
            }
        } else if (i == 10003) {
            this.xj = 9;
        } else if (i == 10086) {
            this.xj = 8;
        }
        hfVar.xj(this.xj);
        hfVar.xj(list);
        com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "--==-- 预缓存补充请求结束，对外给出回调");
        hfVar.u();
    }

    private double xj(String str, int i) {
        com.bytedance.msdk.core.tf.hf xj = com.bytedance.msdk.c.xj.w.xj().xj(str, i, 102);
        double d = 0.0d;
        if (xj == null) {
            return 0.0d;
        }
        for (com.bytedance.msdk.core.tf.tf tfVar : xj.yy()) {
            if (tfVar.a() && tfVar.ra() > d) {
                d = tfVar.ra();
            }
        }
        return d;
    }
}
