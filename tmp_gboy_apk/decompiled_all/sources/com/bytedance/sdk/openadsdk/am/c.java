package com.bytedance.sdk.openadsdk.am;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class c {
    private static xj xj;

    public interface xj {
        void xj(String str, String str2, Throwable th);
    }

    public static void xj(xj xjVar) {
        xj = xjVar;
    }

    public static boolean xj() {
        return xj != null;
    }

    public static void xj(String str, String str2, Throwable th) {
        if (xj == null) {
            return;
        }
        if (th == null) {
            th = new Throwable();
        }
        xj.xj(str, str2, th);
    }
}
