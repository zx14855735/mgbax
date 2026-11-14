package com.bytedance.adsdk.ugeno.y;

import com.bytedance.sdk.component.utils.pl;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class w {
    public static float xj(String str, float f) {
        try {
            return Float.parseFloat(str);
        } catch (NumberFormatException e) {
            pl.xj(e);
            return f;
        }
    }

    public static int xj(String str, int i) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            pl.xj(e);
            return i;
        }
    }

    public static long xj(String str, long j) {
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException e) {
            pl.xj(e);
            return j;
        }
    }

    public static double xj(String str, double d) {
        try {
            return Double.parseDouble(str);
        } catch (NumberFormatException e) {
            pl.xj(e);
            return d;
        }
    }

    public static boolean xj(String str, boolean z) {
        try {
            return Boolean.parseBoolean(str);
        } catch (NumberFormatException e) {
            pl.xj(e);
            return z;
        }
    }
}
