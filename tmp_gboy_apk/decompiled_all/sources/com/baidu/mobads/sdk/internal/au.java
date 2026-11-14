package com.baidu.mobads.sdk.internal;

import android.content.Context;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class au {
    private static volatile Map<String, au> c = new HashMap();

    /* renamed from: a, reason: collision with root package name */
    private Class<?> f9746a;
    private Method[] b;

    static {
        jQJo();
    }

    private au(Context context, String str) {
        this.b = null;
        try {
            Class<?> cls = Class.forName(str, true, bu.a(context));
            this.f9746a = cls;
            this.b = cls.getMethods();
        } catch (Throwable th) {
            bv.a().a(th);
        }
    }

    public static au a(Context context, String str) {
        if (!c.containsKey(str) || c.get(str).f9746a == null) {
            synchronized (au.class) {
                try {
                    if (c.containsKey(str)) {
                        if (c.get(str).f9746a == null) {
                        }
                    }
                    c.put(str, new au(context, str));
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return c.get(str);
    }

    private static /* synthetic */ void jQJo() {
        char[] charArray = "ÂÎÌ\u008fÆÀÌÄ\u008fÃÎØ\u008fÒÉÄÍÍ\u008fëÏÈãÓÈÅÆÄ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 161);
        }
        String str = new String(charArray);
        char[] charArray2 = "ÂÍÈÏÈÕ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 161);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public Object b(Object obj, String str, Object... objArr) {
        try {
            Method a2 = a(str);
            if (a2 == null) {
                return null;
            }
            if (objArr != null && objArr.length != 0) {
                return a2.invoke(obj, objArr);
            }
            return a2.invoke(obj, new Object[0]);
        } catch (Throwable th) {
            bv.a().a(th);
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001e A[Catch: all -> 0x0011, TRY_LEAVE, TryCatch #0 {all -> 0x0011, blocks: (B:2:0x0000, B:5:0x0008, B:8:0x000c, B:9:0x001a, B:11:0x001e, B:16:0x0013), top: B:1:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String c(java.lang.Object r2, java.lang.String r3, java.lang.Object... r4) {
        /*
            r1 = this;
            java.lang.reflect.Method r3 = r1.a(r3)     // Catch: java.lang.Throwable -> L11
            if (r3 == 0) goto L28
            if (r4 == 0) goto L13
            int r0 = r4.length     // Catch: java.lang.Throwable -> L11
            if (r0 != 0) goto Lc
            goto L13
        Lc:
            java.lang.Object r2 = r3.invoke(r2, r4)     // Catch: java.lang.Throwable -> L11
            goto L1a
        L11:
            r2 = move-exception
            goto L21
        L13:
            r4 = 0
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch: java.lang.Throwable -> L11
            java.lang.Object r2 = r3.invoke(r2, r4)     // Catch: java.lang.Throwable -> L11
        L1a:
            boolean r3 = r2 instanceof java.lang.String     // Catch: java.lang.Throwable -> L11
            if (r3 == 0) goto L28
            java.lang.String r2 = (java.lang.String) r2     // Catch: java.lang.Throwable -> L11
            return r2
        L21:
            com.baidu.mobads.sdk.internal.bv r3 = com.baidu.mobads.sdk.internal.bv.a()
            r3.a(r2)
        L28:
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.sdk.internal.au.c(java.lang.Object, java.lang.String, java.lang.Object[]):java.lang.String");
    }

    public Object a(Class<?>[] clsArr, Object... objArr) {
        Constructor<?> constructor;
        if (objArr != null) {
            try {
                if (objArr.length != 0) {
                    constructor = this.f9746a.getConstructor(clsArr);
                    return constructor.newInstance(objArr);
                }
            } catch (Throwable th) {
                bv.a().a(th);
                return null;
            }
        }
        constructor = this.f9746a.getConstructor(new Class[0]);
        return constructor.newInstance(objArr);
    }

    public void a(Object obj, String str, Object... objArr) {
        try {
            Method a2 = a(str);
            if (a2 != null) {
                if (objArr != null && objArr.length != 0) {
                    a2.invoke(obj, objArr);
                    return;
                }
                a2.invoke(obj, new Object[0]);
            }
        } catch (Throwable th) {
            bv.a().a(th);
        }
    }

    private Method a(String str) {
        Method[] methodArr = this.b;
        if (methodArr == null) {
            return null;
        }
        for (Method method : methodArr) {
            if (method.getName().equals(str)) {
                method.setAccessible(true);
                return method;
            }
        }
        return null;
    }
}
