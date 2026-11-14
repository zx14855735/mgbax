package com.bytedance.msdk.f.hf;

import com.bytedance.msdk.core.kd.hf.c;
import com.bytedance.msdk.core.tf.hf;
import com.bytedance.msdk.core.tf.tf;
import com.bytedance.msdk.kd.y;
import com.bytedance.msdk.xj.kd.kd;
import com.bytedance.msdk.xj.kd.w;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj {
    public static boolean hf(hf hfVar) {
        if (hfVar == null) {
            return false;
        }
        int a2 = hfVar.a();
        Map<String, Integer> tu = com.bytedance.msdk.core.hf.hf().tu();
        if (tu == null) {
            return false;
        }
        Integer num = tu.get(String.valueOf(a2));
        if (num != null) {
            return num.intValue() == 1;
        }
        Integer num2 = tu.get("-1");
        return num2 != null && num2.intValue() == 1;
    }

    public static boolean xj(hf hfVar) {
        if (hfVar == null) {
            return false;
        }
        int a2 = hfVar.a();
        Map<String, Integer> aq = com.bytedance.msdk.core.hf.hf().aq();
        if (aq == null) {
            return false;
        }
        Integer num = aq.get(String.valueOf(a2));
        if (num != null) {
            return num.intValue() == 1;
        }
        Integer num2 = aq.get("-1");
        return num2 != null && num2.intValue() == 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x012a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x004f A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean xj(com.bytedance.msdk.w.y.xj.hf r10, java.util.List<java.lang.Integer> r11, java.util.Map<java.lang.Integer, java.util.List<com.bytedance.msdk.core.tf.tf>> r12) {
        /*
            Method dump skipped, instructions count: 381
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.f.hf.xj.xj(com.bytedance.msdk.w.y.xj.hf, java.util.List, java.util.Map):boolean");
    }

    public static void xj(com.bytedance.msdk.w.y.xj.hf hfVar, tf tfVar, int i) {
        if (hfVar == null || hfVar.v() == null || tfVar == null) {
            return;
        }
        com.bytedance.msdk.api.xj.hf v = hfVar.v();
        String ra = v.ra();
        w.hf(MediationConstant.TAG, kd.xj(ra) + "----------总超时后尝试从复用池中查找广告：id:" + tfVar.yo() + "   loadSort:" + tfVar.dk() + "  showSort:" + tfVar.et() + "   adnName:" + tfVar.qt());
        String yo = tfVar.yo();
        if (tfVar.jk() && com.bytedance.msdk.core.kd.xj.xj.xj().u(ra, yo, v.kd()) && com.bytedance.msdk.core.kd.xj.xj.xj().xj(yo, v, true) == 3) {
            w.hf(MediationConstant.TAG, kd.xj(ra) + "----------可复用：id:" + tfVar.yo() + "   loadSort:" + tfVar.dk() + "  showSort:" + tfVar.et() + "   adnName:" + tfVar.qt());
            com.bytedance.msdk.core.kd.xj.xj.xj().xj(ra, yo, tfVar, i);
            List<c> xj = com.bytedance.msdk.core.kd.xj.xj.xj().xj(yo, v, v.kd());
            if (xj == null || xj.size() <= 0) {
                return;
            }
            int f = xj.get(0).xj.f(v.xj());
            y.xj(tfVar, v, com.bytedance.msdk.core.kd.xj.xj.xj().xj(yo), !hfVar.ra(), 4, i, 3, f, (com.bytedance.msdk.api.xj) null, -1L, hfVar.hf(), true);
            ArrayList arrayList = new ArrayList();
            for (c cVar : xj) {
                cVar.xj.d(3);
                cVar.xj.tf(f);
                cVar.xj.w(hfVar.hf());
                cVar.xj.hf(true);
                xj(ra, cVar.xj, yo);
                arrayList.add(cVar.xj);
            }
            y.xj(xj.get(0).xj, 0, "adn cache命中", 0L, v, i, arrayList.size(), 4, (String) null, 0L, -1L);
            com.bytedance.msdk.w.f.xj.xj(hfVar, arrayList, true);
            com.bytedance.msdk.hf.w wVar = (com.bytedance.msdk.hf.w) arrayList.get(0);
            if (wVar.no()) {
                hfVar.xj(arrayList);
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    com.bytedance.msdk.hf.w wVar2 = (com.bytedance.msdk.hf.w) it.next();
                    w.xj(MediationConstant.TAG, kd.xj(ra) + "复用池回溯成功...........回溯到了P层广告_当前P层广告缓存池数量：" + hfVar.c().size() + ",slotId：" + wVar2.cy() + ",广告类型：" + wVar2.lw() + ",loadSort=" + wVar2.zd() + ",showSort=" + wVar2.kc() + ",CPM=" + wVar2.da());
                }
                return;
            }
            if (wVar.cu()) {
                hfVar.xj(arrayList);
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    com.bytedance.msdk.hf.w wVar3 = (com.bytedance.msdk.hf.w) it2.next();
                    w.xj(MediationConstant.TAG, kd.xj(ra) + "复用池回溯成功...........回溯到了普通层广告_当前普通广告缓存池数量：" + hfVar.f().size() + ",slotId：" + wVar3.cy() + ",广告类型：" + wVar3.lw() + ",loadSort=" + wVar3.zd() + ",showSort=" + wVar3.kc() + ",CPM=" + wVar3.da());
                }
            }
        }
    }

    private static void xj(String str, com.bytedance.msdk.hf.w wVar, String str2) {
        tf kd = com.bytedance.msdk.core.kd.xj.xj.xj().kd(str, str2);
        if (wVar == null || kd == null) {
            return;
        }
        wVar.e(kd.dk());
        wVar.zg(kd.et());
        wVar.qt(kd.am());
        wVar.qt(kd.v());
        wVar.xj(kd.ra());
        wVar.kd(kd.y());
    }
}
