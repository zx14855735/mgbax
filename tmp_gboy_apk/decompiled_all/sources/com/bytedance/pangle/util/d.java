package com.bytedance.pangle.util;

import android.os.Build;
import android.text.TextUtils;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class d {
    public static boolean am() {
        return Build.VERSION.SDK_INT >= 26;
    }

    public static boolean c() {
        return Build.VERSION.SDK_INT <= 25;
    }

    public static boolean d() {
        int i = Build.VERSION.SDK_INT;
        return i >= 29 && i <= 30;
    }

    public static boolean e() {
        return Build.VERSION.SDK_INT == 29;
    }

    public static boolean f() {
        int i = Build.VERSION.SDK_INT;
        return i >= 26 && i <= 28;
    }

    public static boolean g() {
        int i = Build.VERSION.SDK_INT;
        return i >= 24 && i <= 28;
    }

    public static boolean hf() {
        return Build.VERSION.SDK_INT > 22;
    }

    public static boolean jk() {
        return TextUtils.equals(Build.BRAND.toLowerCase(), "huawei");
    }

    public static boolean kd() {
        return Build.VERSION.SDK_INT <= 23;
    }

    public static boolean p() {
        return Build.VERSION.SDK_INT > 23;
    }

    public static boolean pl() {
        int i = Build.VERSION.SDK_INT;
        return i >= 24 && i <= 25;
    }

    public static boolean pz() {
        return TextUtils.equals(Build.BRAND.toLowerCase(), "samsung");
    }

    public static boolean qt() {
        int i;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 28) {
            return true;
        }
        if (i2 != 27) {
            return false;
        }
        i = Build.VERSION.PREVIEW_SDK_INT;
        return i > 0;
    }

    public static boolean tf() {
        return Build.VERSION.SDK_INT >= 23;
    }

    public static boolean u() {
        return Build.VERSION.SDK_INT <= 28;
    }

    public static boolean v() {
        int i;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 31) {
            return true;
        }
        if (i2 != 30) {
            return false;
        }
        i = Build.VERSION.PREVIEW_SDK_INT;
        return i > 0;
    }

    public static boolean w() {
        return false;
    }

    public static boolean xj() {
        return true;
    }

    public static boolean y() {
        return Build.VERSION.SDK_INT < 23;
    }

    public static boolean yo() {
        int i;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 30) {
            return true;
        }
        if (i2 != 29) {
            return false;
        }
        i = Build.VERSION.PREVIEW_SDK_INT;
        return i > 0;
    }

    public static boolean zg() {
        int i;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 29) {
            return true;
        }
        if (i2 != 28) {
            return false;
        }
        i = Build.VERSION.PREVIEW_SDK_INT;
        return i > 0;
    }
}
