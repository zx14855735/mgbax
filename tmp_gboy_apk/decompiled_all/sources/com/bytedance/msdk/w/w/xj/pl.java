package com.bytedance.msdk.w.w.xj;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.android.live.base.api.push.model.PushUIConfig;
import com.bytedance.msdk.w.w.xj.xj;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class pl implements xj {
    private final long xj = 500;

    @Override // com.bytedance.msdk.w.w.xj.xj
    public void hf(xj.InterfaceC0086xj interfaceC0086xj) {
        interfaceC0086xj.xj((String) null);
    }

    @Override // com.bytedance.msdk.w.w.xj.xj
    public void xj(xj.InterfaceC0086xj interfaceC0086xj) {
        com.bytedance.msdk.w.y.xj.hf xj = interfaceC0086xj.xj();
        if (xj.pl() == null && xj.v().ht() == 3 && !com.bytedance.msdk.core.hf.hf().ai() && xj.z() != null) {
            com.bytedance.msdk.xj.kd.w.u(MediationConstant.TAG, "执行开启开屏兜底...............");
            xj(interfaceC0086xj, xj, xj.v(), xj.z());
        } else {
            interfaceC0086xj.xj(xj);
        }
    }

    public void xj(final xj.InterfaceC0086xj interfaceC0086xj, final com.bytedance.msdk.w.y.xj.hf hfVar, com.bytedance.msdk.api.xj.hf hfVar2, com.bytedance.msdk.api.u.p pVar) {
        if (pVar != null && hfVar2 != null) {
            com.bytedance.msdk.xj.kd.w.u(MediationConstant.TAG, com.bytedance.msdk.xj.kd.kd.xj(hfVar2.ra()) + "settings config.......AdUnitId = " + hfVar2.ra() + "  开屏广告走了开发者自定义兜底方案   adnName:" + com.bytedance.msdk.hf.xj.xj(pVar.xj()));
        }
        com.bytedance.msdk.kd.y.hf(hfVar2, -4);
        com.bytedance.msdk.xj.kd.w.u(MediationConstant.TAG, "开屏广告走了开发者自定义开屏兜底，数据为: getAdNetworkFlatFromId = " + pVar.xj() + " getAppId = " + pVar.w() + " getAppKey = " + pVar.u() + " getAdNetworkSlotId = " + pVar.hf());
        if (!TextUtils.isEmpty(pVar.hf()) && (!TextUtils.isEmpty(pVar.w()) || !TextUtils.isEmpty(pVar.u()))) {
            int xj = pVar.xj();
            final String xj2 = com.bytedance.msdk.hf.xj.xj(xj);
            final String hf = pVar.hf();
            if (TextUtils.isEmpty(xj2)) {
                xj(hfVar, 840027);
                hfVar.xj(new com.bytedance.msdk.api.xj(840027, com.bytedance.msdk.api.xj.xj(840027)));
                return;
            }
            if (xj == 3) {
                new com.bytedance.msdk.y.xj.xj(pVar).xj(pVar);
                Looper hf2 = com.bytedance.msdk.xj.kd.y.hf();
                if (hf2 != null) {
                    new Handler(hf2).postDelayed(new Runnable() { // from class: com.bytedance.msdk.w.w.xj.pl.1
                        @Override // java.lang.Runnable
                        public void run() {
                            pl.this.xj(interfaceC0086xj, hfVar, xj2, hf);
                        }
                    }, 500L);
                    return;
                }
                return;
            }
            if (xj == 7 || xj == 6 || xj == 4 || xj == 8) {
                new com.bytedance.msdk.y.xj.xj(pVar).xj(pVar);
                xj(interfaceC0086xj, hfVar, xj2, hf);
                return;
            } else if (xj != 1 && xj != 9) {
                xj(hfVar, 840027);
                hfVar.xj(new com.bytedance.msdk.api.xj(840027, com.bytedance.msdk.api.xj.xj(840027)));
                return;
            } else {
                new com.bytedance.msdk.y.xj.xj(pVar).xj(pVar, new com.bytedance.msdk.xj.xj.w() { // from class: com.bytedance.msdk.w.w.xj.pl.2
                    @Override // com.bytedance.msdk.xj.xj.w
                    public void xj() {
                        pl.this.xj(interfaceC0086xj, hfVar, xj2, hf);
                    }

                    @Override // com.bytedance.msdk.xj.xj.w
                    public void xj(com.bytedance.msdk.api.xj xjVar) {
                        pl.this.xj(hfVar, 840027);
                        hfVar.xj(new com.bytedance.msdk.api.xj(840027, com.bytedance.msdk.api.xj.xj(840027)));
                    }
                });
                return;
            }
        }
        xj(hfVar, 840027);
        hfVar.xj(new com.bytedance.msdk.api.xj(840027, com.bytedance.msdk.api.xj.xj(840027)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(com.bytedance.msdk.w.y.xj.hf hfVar, int i) {
        com.bytedance.msdk.kd.y.xj(hfVar.v(), (String) null, !hfVar.ra(), hfVar.ff().xj, i, (Map<String, Object>) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(xj.InterfaceC0086xj interfaceC0086xj, com.bytedance.msdk.w.y.xj.hf hfVar, String str, String str2) {
        hfVar.xj(xj(hfVar.v().ra(), str, str2));
        interfaceC0086xj.xj(hfVar);
    }

    private com.bytedance.msdk.core.tf.hf xj(String str, String str2, String str3) {
        com.bytedance.msdk.core.tf.tf xj = com.bytedance.msdk.core.c.w.xj(str3, str2, -4, -4);
        if (xj == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(xj);
        com.bytedance.msdk.core.tf.hf hfVar = new com.bytedance.msdk.core.tf.hf();
        hfVar.u(str);
        hfVar.qt(3);
        hfVar.u(400L);
        hfVar.kd(2000L);
        hfVar.y(PushUIConfig.dismissTime);
        hfVar.c(3000L);
        hfVar.xj(arrayList);
        return hfVar;
    }
}
