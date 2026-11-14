package BPw6Q8;

import android.content.Context;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class A4TApA {
    public static int A2egSU(Context context, int i) {
        return context.getColor(i);
    }

    public static <T> T A4TApA(Context context, Class<T> cls) {
        return (T) context.getSystemService(cls);
    }

    public static String A5SV6n(Context context, Class<?> cls) {
        return context.getSystemServiceName(cls);
    }
}
