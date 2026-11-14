package com.qq.e.comm.managers.plugin;

import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class a {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static Method f12951A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public static boolean f12952A4TApA;

    public static void a(Throwable th, String str) {
        try {
            Exception exc = new Exception("插件错误：" + str, th);
            if (f12952A4TApA) {
                return;
            }
            if (f12951A2egSU == null) {
                Method declaredMethod = Class.forName("com.tencent.bugly.crashreport.CrashReport").getDeclaredMethod("postCatchedException", Throwable.class);
                f12951A2egSU = declaredMethod;
                declaredMethod.setAccessible(true);
            }
            f12951A2egSU.invoke(null, exc);
        } catch (Throwable unused) {
            f12952A4TApA = true;
        }
    }
}
