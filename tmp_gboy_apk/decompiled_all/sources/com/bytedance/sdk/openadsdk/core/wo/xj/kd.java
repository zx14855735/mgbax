package com.bytedance.sdk.openadsdk.core.wo.xj;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.TTAdConstant;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class kd {
    private static Boolean xj;

    private static boolean xj() {
        if (xj == null) {
            try {
                TTAdConstant.RitScenes ritScenes = TTAdConstant.RitScenes.CUSTOMIZE_SCENES;
                xj = Boolean.TRUE;
            } catch (Throwable unused) {
                xj = Boolean.FALSE;
            }
        }
        return xj.booleanValue();
    }

    public static String xj(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof String) {
            String str = (String) obj;
            return "game_more_kllkrtunities".equalsIgnoreCase(str) ? xj(str) : str;
        }
        if (xj()) {
            try {
                if (obj instanceof TTAdConstant.RitScenes) {
                    return ((TTAdConstant.RitScenes) obj).getScenesName();
                }
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    private static String xj(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (str.contains("KLLK")) {
            return str.replace("KLLK", "OPPO");
        }
        return str.contains("kllk") ? str.replace("kllk", "oppo") : "";
    }
}
