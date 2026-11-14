package com.bytedance.msdk.f;

import android.text.TextUtils;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class z {
    public static void xj(com.bytedance.msdk.hf.w wVar, com.bytedance.msdk.core.tf.tf tfVar, com.bytedance.msdk.api.xj.hf hfVar, boolean z) {
        if (wVar == null || !wVar.vi()) {
            return;
        }
        if (tfVar == null) {
            wVar.xj(0.0d);
        }
        String aq = wVar.aq();
        Map<String, String> q = tfVar.q();
        if (TextUtils.isEmpty(aq)) {
            if (z) {
                com.bytedance.msdk.kd.y.xj(tfVar, hfVar, wVar, 40061, com.bytedance.msdk.api.xj.xj(40061));
            }
            wVar.g(com.bytedance.msdk.api.xj.xj(40061));
            wVar.xj(0.0d);
            return;
        }
        if (q == null) {
            if (z) {
                com.bytedance.msdk.kd.y.xj(tfVar, hfVar, wVar, 40062, com.bytedance.msdk.api.xj.xj(40062));
            }
            wVar.g(com.bytedance.msdk.api.xj.xj(40062));
            wVar.xj(0.0d);
            return;
        }
        String str = q.get(aq);
        if (TextUtils.isEmpty(str)) {
            if (z) {
                com.bytedance.msdk.kd.y.xj(tfVar, hfVar, wVar, 40062, com.bytedance.msdk.api.xj.xj(40062));
            }
            wVar.xj(0.0d);
        } else {
            try {
                wVar.xj(Double.valueOf(str).doubleValue());
            } catch (Exception unused) {
                wVar.xj(0.0d);
            }
        }
    }
}
