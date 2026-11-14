package com.octopus.ad.utils;

import KpHwm4.ADYaiT;
import android.content.Context;
import android.text.TextUtils;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class OctUtil implements InvocationHandler {

    /* renamed from: a, reason: collision with root package name */
    private static OctUtil f12659a;

    public interface C {
        String e(String str);
    }

    public interface E {
        void e(Throwable th);
    }

    static {
        try {
            System.loadLibrary("octopus");
        } catch (Throwable th) {
            com.octopus.ad.utils.b.f.a("OctopusAd", "A Throwable Caught", th);
        }
    }

    private OctUtil() {
    }

    public static OctUtil a() {
        if (f12659a == null) {
            f12659a = new OctUtil();
        }
        return f12659a;
    }

    private static void crashCallback(String str) {
        com.octopus.ad.utils.b.f.c("OctopusAd", "crashCallback: " + str);
        if (ADYaiT.f4280ADYaiT == null) {
            ADYaiT.f4280ADYaiT = new ADYaiT();
        }
        ADYaiT.f4280ADYaiT.A4TApA();
    }

    public native void call(C c, int i);

    public native int changeConfig();

    public native void error(E e);

    public native String getBootMark();

    public native String getInfo(Context context, int i);

    public native String getUpdateMark();

    public native void init(Context context);

    @Override // java.lang.reflect.InvocationHandler
    public native Object invoke(Object obj, Method method, Object[] objArr);

    public native void resumeConfig();

    public native void setInfo(String str);

    public native void startReport(Context context, String str, String str2, boolean z, C c);

    public void a(Context context, String str, String str2, boolean z, C c) {
        if (context == null || TextUtils.isEmpty(str)) {
            if (c != null) {
                c.e("-1");
                return;
            }
            return;
        }
        try {
            startReport(context, str, str2, z, c);
        } catch (Throwable th) {
            com.octopus.ad.utils.b.f.a("OctopusAd", "A Throwable Caught", th);
            if (c != null) {
                c.e("-2," + th);
            }
        }
    }
}
