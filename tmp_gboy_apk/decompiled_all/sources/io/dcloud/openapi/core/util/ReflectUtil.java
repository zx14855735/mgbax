package io.dcloud.openapi.core.util;

import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aauaaaaa.aaaaaaau;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class ReflectUtil {
    public static Object invokeField(String str, String str2) {
        try {
            Class<?> cls = Class.forName(str);
            Field declaredField = cls.getDeclaredField(str2);
            declaredField.setAccessible(true);
            return declaredField.get(cls);
        } catch (Exception unused) {
            return null;
        }
    }

    public static Object invokeMethod(Object obj, String str, Class<?>[] clsArr, Object... objArr) {
        if (obj == null) {
            return null;
        }
        try {
            Method method = obj.getClass().getMethod(str, clsArr);
            method.setAccessible(true);
            if (objArr == null || objArr.length == 0) {
                objArr = null;
            }
            return method.invoke(obj, objArr);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Object newInstance(String str, Class[] clsArr, Object[] objArr) {
        try {
            return Class.forName(str).getConstructor(clsArr).newInstance(objArr);
        } catch (Throwable th) {
            aaaaaaau.aaaaaaaa("platform", th.toString());
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0028  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.Object invokeMethod(java.lang.String r2, java.lang.String r3, java.lang.Object r4, java.lang.Class[] r5, java.lang.Object[] r6) {
        /*
            r0 = 0
            java.lang.Class r2 = java.lang.Class.forName(r2)     // Catch: java.lang.Exception -> L14 java.lang.NoSuchMethodException -> L20 java.lang.ClassNotFoundException -> L23
            java.lang.reflect.Method r2 = r2.getMethod(r3, r5)     // Catch: java.lang.Exception -> L14 java.lang.NoSuchMethodException -> L20 java.lang.ClassNotFoundException -> L23
            if (r2 == 0) goto L16
            r5 = 1
            r2.setAccessible(r5)     // Catch: java.lang.Exception -> L14 java.lang.NoSuchMethodException -> L20 java.lang.ClassNotFoundException -> L23
            java.lang.Object r2 = r2.invoke(r4, r6)     // Catch: java.lang.Exception -> L14 java.lang.NoSuchMethodException -> L20 java.lang.ClassNotFoundException -> L23
            goto L26
        L14:
            r2 = move-exception
            goto L18
        L16:
            r2 = r0
            goto L26
        L18:
            java.lang.String r2 = r2.getMessage()
        L1c:
            r1 = r0
            r0 = r2
            r2 = r1
            goto L26
        L20:
            java.lang.String r2 = "NoSuchMethodException"
            goto L1c
        L23:
            java.lang.String r2 = "ClassNotFoundException"
            goto L1c
        L26:
            if (r0 == 0) goto L2d
            java.lang.String r4 = "getJsContent"
            r4.equals(r3)
        L2d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: io.dcloud.openapi.core.util.ReflectUtil.invokeMethod(java.lang.String, java.lang.String, java.lang.Object, java.lang.Class[], java.lang.Object[]):java.lang.Object");
    }

    public static Object invokeMethod(String str, String str2, Object obj) {
        return invokeMethod(str, str2, obj, new Class[0], new Object[0]);
    }
}
