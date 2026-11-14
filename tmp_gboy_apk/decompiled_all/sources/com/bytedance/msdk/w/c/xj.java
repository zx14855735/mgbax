package com.bytedance.msdk.w.c;

import android.text.TextUtils;
import com.bytedance.msdk.core.tf.hf;
import com.bytedance.msdk.core.tf.tf;
import com.bytedance.msdk.hf.w;
import com.bytedance.msdk.xj.kd.kd;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj {
    public static void xj(hf hfVar, com.bytedance.msdk.w.y.xj.hf hfVar2, List<tf> list) {
        if (hfVar == null || hfVar2 == null || list == null || list.size() == 0) {
            return;
        }
        Iterator<w> it = hfVar2.f().iterator();
        while (it.hasNext()) {
            w next = it.next();
            Iterator<tf> it2 = list.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    com.bytedance.msdk.xj.kd.w.u(MediationConstant.TAG, kd.xj(hfVar) + "已经响应的广告: " + next.cy() + "  没有在severBidding的waterFall列表中，需要被移除掉");
                    hfVar2.f().remove(next);
                    hfVar2.d().add(next);
                    break;
                }
                tf next2 = it2.next();
                if (next == null || next2 == null || !next.cy().equals(next2.yo())) {
                }
            }
        }
        com.bytedance.msdk.xj.kd.w.u(MediationConstant.TAG, kd.xj(hfVar) + "已经响应的广告被serverBidding过滤完还剩: " + hfVar2.f().size());
    }

    public static boolean xj(com.bytedance.msdk.w.y.xj.xj xjVar, List<tf> list, String str) {
        if (list == null || xjVar == null || TextUtils.isEmpty(str) || xjVar.hf() != 1) {
            return false;
        }
        Iterator<tf> it = list.iterator();
        while (it.hasNext()) {
            if (str.equals(it.next().yo())) {
                return false;
            }
        }
        return true;
    }
}
