package com.bytedance.sdk.openadsdk.core;

import android.text.TextUtils;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class ai {
    public static String c = "main";
    public static String d = "6.6.0.0";
    public static boolean f = false;
    public static boolean hf = false;
    public static int kd = 999;
    public static String u = "7.1.3.2";
    public static int w = 7132;
    public static final int xj = 7132;
    public static boolean y = true;

    public static boolean c() {
        return TextUtils.equals("internal", c);
    }

    public static boolean hf() {
        return false;
    }

    public static String kd() {
        StringBuilder sb = new StringBuilder();
        sb.append(c);
        sb.append(xj() ? "_plugin" : "");
        sb.append(f ? "_open" : "_close");
        return sb.toString();
    }

    public static boolean u() {
        return com.bytedance.sdk.component.pl.hf.hf.jk();
    }

    public static boolean w() {
        return com.bytedance.sdk.openadsdk.x.y.hf();
    }

    public static boolean xj() {
        return true;
    }

    public static String y() {
        return xj("com.byted.pangle", 7132);
    }

    public static String xj(String str, int i) {
        return "";
    }
}
