package com.bytedance.sdk.component.f.hf.w;

import android.text.TextUtils;
import com.bytedance.sdk.component.f.xj.kd;
import com.bytedance.sdk.component.f.xj.u;
import com.bytedance.sdk.component.utils.pl;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class w {
    private static String hf(String str) {
        u u;
        kd w = w(str);
        if (w == null || (u = w.u()) == null) {
            return null;
        }
        return u.hf();
    }

    public static void u(String str, kd kdVar) {
        if (kdVar == null) {
            return;
        }
        xj(null, str, kdVar.kd(), 100);
    }

    private static kd w(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return com.bytedance.sdk.component.f.hf.xj.kd(str);
    }

    private static boolean xj(String str) {
        u u;
        kd w = w(str);
        if (w == null || (u = w.u()) == null) {
            return false;
        }
        return u.xj();
    }

    public static void w(String str, kd kdVar) {
        if (kdVar == null) {
            return;
        }
        xj(null, str, kdVar.kd(), 6);
    }

    public static void hf(String str, kd kdVar) {
        if (kdVar == null) {
            return;
        }
        xj(null, str, kdVar.kd(), 5);
    }

    public static void w(String str, String str2, kd kdVar) {
        if (kdVar == null) {
            return;
        }
        xj(str, str2, kdVar.kd(), 6);
    }

    public static void xj(String str, kd kdVar) {
        if (kdVar == null) {
            return;
        }
        xj(null, str, kdVar.kd(), 4);
    }

    public static void hf(String str, String str2, kd kdVar) {
        if (kdVar == null) {
            return;
        }
        xj(str, str2, kdVar.kd(), 5);
    }

    public static void xj(String str, String str2, kd kdVar) {
        if (kdVar == null) {
            return;
        }
        xj(str, str2, kdVar.kd(), 4);
    }

    public static void xj(String str, String str2, String str3) {
        xj(str, str2, str3, 4);
    }

    private static void xj(String str, String str2, String str3, int i) {
        try {
            if (xj(str3) || i == 100) {
                String hf = hf(str3);
                if (hf == null) {
                    hf = "";
                }
                String concat = hf.concat("log");
                if (!TextUtils.isEmpty(str)) {
                    concat = concat + str;
                }
                if (i == 4) {
                    pl.xj(concat, str2);
                    return;
                }
                if (i == 5) {
                    pl.hf(concat, str2);
                } else if (i == 6 || i == 100) {
                    pl.u(concat, str2);
                }
            }
        } catch (Exception e) {
            pl.xj(e);
        }
    }
}
