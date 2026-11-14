package com.bytedance.sdk.openadsdk.core;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.util.SparseArray;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class pz {
    private static volatile com.bytedance.sdk.openadsdk.core.j.tf hf;
    private static volatile Context u;
    private static final AtomicBoolean w = new AtomicBoolean(false);
    private static volatile dk<com.bytedance.sdk.openadsdk.core.am.xj> xj;

    public static class xj {

        @SuppressLint({"StaticFieldLeak"})
        private static volatile Application xj;

        static {
            try {
                Object hf = hf();
                xj = (Application) hf.getClass().getMethod("getApplication", new Class[0]).invoke(hf, new Object[0]);
                com.bytedance.sdk.component.utils.pl.hf("MyApplication", "application get success");
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.pl.hf("MyApplication", "application get failed", th);
            }
        }

        private static Object hf() {
            try {
                Method method = Class.forName("android.app.ActivityThread").getMethod("currentActivityThread", new Class[0]);
                method.setAccessible(true);
                return method.invoke(null, new Object[0]);
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.pl.hf("MyApplication", "ActivityThread get error, maybe api level <= 4.2.2", th);
                return null;
            }
        }

        public static Application xj() {
            return xj;
        }
    }

    static {
        WWCm();
    }

    private static /* synthetic */ void WWCm() {
        char[] charArray = "öúø»òôøð»÷úì»æýðùù»ßûü×çüñòð".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 149);
        }
        String str = new String(charArray);
        char[] charArray2 = "öùüûüá".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 149);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static Context getContext() {
        if (u == null) {
            u = xj.xj();
        }
        return u;
    }

    public static com.bytedance.sdk.openadsdk.core.j.tf hf() {
        if (hf == null) {
            synchronized (com.bytedance.sdk.openadsdk.core.j.tf.class) {
                try {
                    if (hf == null) {
                        hf = new com.bytedance.sdk.openadsdk.core.j.tf();
                    }
                } finally {
                }
            }
        }
        return hf;
    }

    public static synchronized void xj(Context context) {
        synchronized (pz.class) {
            if (u == null && context != null) {
                u = context.getApplicationContext();
            }
        }
    }

    public static dk<com.bytedance.sdk.openadsdk.core.am.xj> xj() {
        if (xj == null) {
            synchronized (pz.class) {
                try {
                    if (xj == null) {
                        xj = new et(getContext());
                    }
                } finally {
                }
            }
        }
        return xj;
    }

    public static Function<SparseArray<Object>, Object> xj(int i) {
        return en.xj().xj(i);
    }
}
