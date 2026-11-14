package com.bytedance.sdk.openadsdk;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import com.bytedance.sdk.openadsdk.api.y;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class TTAppContextHolder {

    @SuppressLint({"StaticFieldLeak"})
    private static volatile Context xj;

    public static class xj {

        @SuppressLint({"StaticFieldLeak"})
        private static volatile Application xj;

        static {
            try {
                Object hf = hf();
                xj = (Application) hf.getClass().getMethod("getApplication", new Class[0]).invoke(hf, new Object[0]);
                y.u("MyApplication", "application get success");
            } catch (Throwable th) {
                y.kd("MyApplication", "application get failed", th);
            }
        }

        private static Object hf() {
            try {
                Method method = Class.forName("android.app.ActivityThread").getMethod("currentActivityThread", new Class[0]);
                method.setAccessible(true);
                return method.invoke(null, new Object[0]);
            } catch (Throwable th) {
                y.kd("MyApplication", "ActivityThread get error, maybe api level <= 4.2.2", th);
                return null;
            }
        }

        public static Application xj() {
            return xj;
        }
    }

    public static Context getContext() {
        if (xj == null) {
            setContext(null);
        }
        return xj;
    }

    public static synchronized void setContext(Context context) {
        synchronized (TTAppContextHolder.class) {
            if (xj == null) {
                if (context != null) {
                    xj = context.getApplicationContext();
                } else if (xj.xj() != null) {
                    try {
                        Application xj2 = xj.xj();
                        xj = xj2;
                        if (xj2 != null) {
                        }
                    } catch (Throwable unused) {
                    }
                }
            }
        }
    }
}
