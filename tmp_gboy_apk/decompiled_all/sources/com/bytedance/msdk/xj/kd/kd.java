package com.bytedance.msdk.xj.kd;

import ADYaiT.CtFAbx;
import android.text.TextUtils;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class kd {
    public static String hf(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return xj();
        }
        if (TextUtils.isEmpty(str2)) {
            return xj(str);
        }
        return "TTMediationSDK_" + str + "_" + str2 + "_";
    }

    public static String xj() {
        return "TTMediationSDK_";
    }

    public static String xj(String str) {
        return TextUtils.isEmpty(str) ? xj() : CtFAbx.BI9f7h("TTMediationSDK_", str, "_");
    }

    public static String xj(com.bytedance.msdk.core.tf.hf hfVar) {
        if (hfVar != null && !TextUtils.isEmpty(hfVar.ff())) {
            return "TTMediationSDK_" + hfVar.ff() + "_";
        }
        return xj();
    }

    public static String xj(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return xj();
        }
        if (TextUtils.isEmpty(str2)) {
            return xj(str);
        }
        return "TTMediationSDK_" + str + "_" + str2 + "_";
    }
}
