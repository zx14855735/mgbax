package com.bytedance.pangle.util;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class u {
    public static <T> int hf(T[] tArr, T t) {
        if (tArr == null) {
            return -1;
        }
        for (int i = 0; i < tArr.length; i++) {
            T t2 = tArr[i];
            if (t2 == t || (t2 != null && t2.equals(t))) {
                return i;
            }
        }
        return -1;
    }

    public static <T> boolean xj(T[] tArr) {
        return tArr == null || tArr.length == 0;
    }

    public static <T> boolean xj(T[] tArr, T t) {
        return hf(tArr, t) != -1;
    }

    public static <T> boolean xj(T[] tArr, T[] tArr2) {
        if (tArr2 == null) {
            return true;
        }
        for (T t : tArr2) {
            if (!xj(tArr, t)) {
                return false;
            }
        }
        return true;
    }
}
