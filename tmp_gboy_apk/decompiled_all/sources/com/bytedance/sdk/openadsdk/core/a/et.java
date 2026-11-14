package com.bytedance.sdk.openadsdk.core.a;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class et {
    private static Method hf;
    private static Method w;
    private static Method xj;

    static {
        try {
            xj = Class.class.getDeclaredMethod("forName", String.class);
            hf = Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Class[].class);
            w = Class.class.getDeclaredMethod("getDeclaredField", String.class);
        } catch (NoSuchMethodException | NullPointerException unused) {
        }
    }

    public static Object xj(Object obj, String str, String str2, Object obj2) {
        Field xj2;
        try {
            xj2 = xj(str, str2);
        } catch (IllegalAccessException unused) {
        }
        if (xj2 == null) {
            return obj2;
        }
        xj2.setAccessible(true);
        return xj2.get(obj);
    }

    public static Field xj(String str, String str2) {
        if (!xj()) {
            return null;
        }
        try {
            Field field = (Field) w.invoke((Class) xj.invoke(null, str), str2);
            try {
                field.setAccessible(true);
                return field;
            } catch (Throwable unused) {
                return field;
            }
        } catch (Throwable unused2) {
            return null;
        }
    }

    private static boolean xj() {
        return (xj == null || hf == null || w == null) ? false : true;
    }
}
