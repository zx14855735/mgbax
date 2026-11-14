package com.bytedance.msdk.xj.kd;

import com.bytedance.msdk.f.pl;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class w {
    private static boolean hf = false;
    private static int w = 4;
    static boolean xj = true;

    public static boolean hf() {
        return pl.xj || hf;
    }

    public static void u(String str, String str2) {
        if (hf() && str2 != null && w <= 6) {
            com.bytedance.sdk.component.utils.pl.u(str, str2);
        }
    }

    public static void w(String str, String str2) {
        if (hf() && str2 != null && w <= 5) {
            com.bytedance.sdk.component.utils.pl.hf(str, str2);
        }
    }

    public static void xj(int i) {
        w = i;
    }

    public static void hf(String str) {
        if (hf()) {
            hf("Logger", str);
        }
    }

    public static void xj() {
        hf = true;
        xj(3);
    }

    public static void hf(String str, String str2) {
        if (hf() && str2 != null && w <= 4) {
            com.bytedance.sdk.component.utils.pl.xj(str, str2);
        }
    }

    public static void w(String str) {
        if (hf()) {
            u("Logger", str);
        }
    }

    public static void xj(String str) {
        if (hf()) {
            xj("Logger", str);
        }
    }

    public static void xj(String str, String str2) {
        hf();
    }

    public static void hf(String str, String str2, Throwable th) {
        if (hf()) {
            if (!(str2 == null && th == null) && w <= 6) {
                com.bytedance.sdk.component.utils.pl.w(str, str2, th);
            }
        }
    }

    public static void xj(String str, String str2, Throwable th) {
        hf();
    }
}
