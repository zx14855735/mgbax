package com.bytedance.sdk.component.utils;

import android.content.Context;
import android.text.TextUtils;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class am {
    public static String c(Context context) {
        int w = w(context);
        return w != 2 ? w != 3 ? w != 4 ? w != 5 ? w != 6 ? "mobile" : "5g" : "4g" : "wifi" : "3g" : "2g";
    }

    public static int hf(Context context) {
        int w = w(context);
        if (w == 1) {
            return 0;
        }
        if (w == 4) {
            return 1;
        }
        if (w == 5) {
            return 4;
        }
        if (w != 6) {
            return w;
        }
        return 6;
    }

    public static boolean kd(Context context) {
        return w(context) == 5;
    }

    public static boolean u(Context context) {
        return w(context) == 4;
    }

    public static int w(Context context) {
        return et.xj(context, 60000L);
    }

    public static void xj(qt qtVar) {
        et.xj(qtVar);
    }

    public static boolean y(Context context) {
        return w(context) == 6;
    }

    public static boolean xj(Context context) {
        return w(context) != 0;
    }

    public static boolean xj(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("http://") || str.startsWith("https://");
    }
}
