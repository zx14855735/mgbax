package com.bytedance.msdk.core.qt;

import android.text.TextUtils;
import com.bytedance.msdk.core.tf.hf;
import com.bytedance.msdk.core.tf.tf;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj {
    public static hf xj(hf hfVar, String str) {
        if (hfVar == null || TextUtils.isEmpty(str) || hfVar.yy() == null || hfVar.yy().size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<tf> it = hfVar.yy().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            tf next = it.next();
            if (str.equals(next.yo())) {
                arrayList.add(next.kd());
                break;
            }
        }
        if (arrayList.size() == 0) {
            return null;
        }
        tf tfVar = (tf) arrayList.get(0);
        if (tfVar != null && tfVar.z() && !MediationConstant.ADN_PANGLE.equals(tfVar.qt())) {
            Iterator<tf> it2 = hfVar.yy().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                tf next2 = it2.next();
                if (next2.z() && MediationConstant.ADN_PANGLE.equals(next2.qt())) {
                    arrayList.add(next2.kd());
                    break;
                }
            }
        }
        hf zg = hfVar.zg();
        if (zg.pl()) {
            zg.hf(arrayList);
        } else {
            zg.xj(arrayList);
        }
        tf tfVar2 = (tf) arrayList.get(0);
        tfVar2.kd(0);
        if (tfVar2.v() == 0) {
            zg.u(tfVar2.ra());
        }
        if (tfVar2.v() == 2) {
            zg.xj(true);
        }
        if (tfVar2.v() == 1 || tfVar2.v() == 3) {
            zg.hf(true);
        }
        zg.g(0);
        return zg;
    }

    public static String xj(String str) {
        try {
            if (!TextUtils.isEmpty(str) && str.startsWith("gm_test_slot_")) {
                return str.substring(13);
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }
}
