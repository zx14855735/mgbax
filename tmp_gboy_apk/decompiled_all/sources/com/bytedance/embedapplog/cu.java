package com.bytedance.embedapplog;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class cu {
    public static boolean hf;
    public static boolean xj;

    public static void hf(String str) {
        hf(str, null);
    }

    public static void u(String str, Throwable th) {
        com.bytedance.sdk.component.utils.pl.xj("TeaLog", str, th);
    }

    public static void w(String str, Throwable th) {
        com.bytedance.sdk.component.utils.pl.w("TeaLog", str, th);
    }

    public static void xj(String str) {
    }

    public static void hf(String str, Throwable th) {
        com.bytedance.sdk.component.utils.pl.hf("TeaLog", str, th);
    }

    public static void xj(String str, Throwable th) {
    }

    public static void hf(Throwable th) {
        if (th != null) {
            com.bytedance.sdk.component.utils.pl.xj("TeaLog", th.getMessage());
        }
    }

    public static void xj(Throwable th) {
        com.bytedance.sdk.component.utils.pl.w("TeaLog", "", th);
    }
}
