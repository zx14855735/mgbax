package com.bytedance.msdk.w.f;

import android.os.SystemClock;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj {
    public static void xj(com.bytedance.msdk.w.y.xj.hf hfVar, List<com.bytedance.msdk.hf.w> list, boolean z) {
        if (hfVar == null) {
            return;
        }
        com.bytedance.msdk.hf.w xj = xj(list);
        if (hfVar.l()) {
            return;
        }
        hfVar.w(SystemClock.elapsedRealtime());
        com.bytedance.msdk.kd.y.xj(xj, hfVar.v(), hfVar.pl(), hfVar.en() - hfVar.j(), hfVar.ff().xj, !hfVar.ra(), list != null ? list.size() : 0, hfVar.ff().kd, z);
        hfVar.u(true);
    }

    private static com.bytedance.msdk.hf.w xj(List<com.bytedance.msdk.hf.w> list) {
        com.bytedance.msdk.hf.w wVar = null;
        if (list != null && list.size() != 0) {
            for (com.bytedance.msdk.hf.w wVar2 : list) {
                if (wVar == null || wVar2.dq() < wVar.dq()) {
                    wVar = wVar2;
                }
            }
        }
        return wVar;
    }
}
