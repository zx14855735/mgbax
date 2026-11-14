package com.octopus.ad.b.e;

import android.content.Context;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static Method f12363a;

    public static final boolean a() {
        Context context = null;
        try {
            if (f12363a == null) {
                Method method = Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]);
                f12363a = method;
                method.setAccessible(true);
            }
            context = (Context) f12363a.invoke(null, new Object[0]);
        } catch (Exception unused) {
        }
        if (context == null) {
            return false;
        }
        return d.a().a(context, false);
    }

    public static String a(Context context) {
        d a2 = d.a();
        return a2.a(context.getApplicationContext(), a2.b);
    }
}
