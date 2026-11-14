package com.bytedance.msdk.core;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class hf {
    private static volatile com.bytedance.msdk.core.am.w hf;
    private static volatile com.bytedance.msdk.kd.hf.xj<com.bytedance.msdk.kd.xj> w;

    @SuppressLint({"StaticFieldLeak"})
    private static volatile Context xj;

    public static class xj {

        @SuppressLint({"StaticFieldLeak"})
        private static volatile Application xj;

        static {
            try {
                Object hf = hf();
                xj = (Application) hf.getClass().getMethod("getApplication", new Class[0]).invoke(hf, new Object[0]);
                com.bytedance.msdk.xj.kd.w.u("MyApplication", "application get success");
            } catch (Throwable th) {
                com.bytedance.msdk.xj.kd.w.hf("MyApplication", "application get failed", th);
            }
        }

        private static Object hf() {
            try {
                Method method = Class.forName("android.app.ActivityThread").getMethod("currentActivityThread", new Class[0]);
                method.setAccessible(true);
                return method.invoke(null, new Object[0]);
            } catch (Throwable th) {
                com.bytedance.msdk.xj.kd.w.hf("MyApplication", "ActivityThread get error, maybe api level <= 4.2.2", th);
                return null;
            }
        }

        public static Application xj() {
            return xj;
        }
    }

    public static Context getContext() {
        if (xj == null) {
            xj(null);
        }
        return xj;
    }

    public static com.bytedance.msdk.core.am.w hf() {
        if (hf == null) {
            synchronized (com.bytedance.msdk.core.am.w.class) {
                try {
                    if (hf == null) {
                        hf = new com.bytedance.msdk.core.am.w();
                    }
                } finally {
                }
            }
        }
        return hf;
    }

    public static com.bytedance.msdk.kd.hf.xj<com.bytedance.msdk.kd.xj> xj() {
        if (w == null) {
            synchronized (hf.class) {
                try {
                    if (w == null) {
                        w = new com.bytedance.msdk.kd.hf.hf();
                    }
                } finally {
                }
            }
        }
        return w;
    }

    public static synchronized void xj(Context context) {
        synchronized (hf.class) {
            if (xj == null) {
                synchronized (hf.class) {
                    if (xj.xj() != null) {
                        try {
                            Application xj2 = xj.xj();
                            xj = xj2;
                            if (xj2 != null) {
                                return;
                            }
                        } catch (Throwable unused) {
                        }
                    }
                    if (context != null) {
                        xj = context.getApplicationContext();
                    }
                }
            }
        }
    }
}
