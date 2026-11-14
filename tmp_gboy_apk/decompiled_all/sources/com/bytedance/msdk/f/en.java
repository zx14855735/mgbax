package com.bytedance.msdk.f;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class en {
    private static String xj;

    public static String hf() {
        if (TextUtils.isEmpty(xj)) {
            xj = new String(Base64.decode("ZGV2aWNlX2lk", 0));
        }
        return xj;
    }

    public static boolean xj() {
        return com.bytedance.msdk.xj.kd.w.hf() && com.bytedance.msdk.core.xj.p().jk() && com.bytedance.msdk.core.xj.p().pz();
    }

    public static String xj(String str) {
        try {
            if (!xj()) {
                return str;
            }
            String v = com.bytedance.msdk.core.xj.p().v();
            if (TextUtils.isEmpty(v)) {
                return str;
            }
            com.bytedance.msdk.xj.kd.w.xj("TestHelperUtils", "AnyDoorId=" + v);
            return Uri.parse(str).buildUpon().appendQueryParameter(hf(), v).appendQueryParameter("aid", "5001121").toString();
        } catch (Throwable unused) {
            return str;
        }
    }
}
