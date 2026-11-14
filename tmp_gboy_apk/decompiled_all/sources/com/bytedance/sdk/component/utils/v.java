package com.bytedance.sdk.component.utils;

import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class v {
    private static Method hf;
    private static Object xj;

    static {
        try {
            Method declaredMethod = Class.class.getDeclaredMethod("forName", String.class);
            Method declaredMethod2 = Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Class[].class);
            Class cls = (Class) declaredMethod.invoke(null, "dalvik.system.VMRuntime");
            Method method = (Method) declaredMethod2.invoke(cls, "getRuntime", null);
            hf = (Method) declaredMethod2.invoke(cls, "setHiddenApiExemptions", new Class[]{String[].class});
            xj = method.invoke(null, new Object[0]);
        } catch (Throwable th) {
            pl.hf("Reflection", "reflect bootstrap failed:", th);
        }
    }

    public static boolean xj(String... strArr) {
        Method method;
        Object obj = xj;
        if (obj != null && (method = hf) != null) {
            try {
                method.invoke(obj, strArr);
                return true;
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public static boolean xj() {
        return xj("L");
    }
}
