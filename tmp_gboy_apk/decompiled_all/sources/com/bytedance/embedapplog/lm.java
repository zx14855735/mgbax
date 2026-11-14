package com.bytedance.embedapplog;

import android.os.SystemProperties;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class lm {
    private static volatile Object xj;

    private Object xj() {
        if (xj == null) {
            synchronized (lm.class) {
                try {
                    if (xj == null) {
                        xj = Class.forName("android.os.SystemProperties").newInstance();
                    }
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.pl.xj(th);
                } finally {
                }
            }
        }
        return xj;
    }

    public String xj(String str) {
        try {
            return SystemProperties.get(str);
        } catch (Throwable th) {
            cu.xj(th);
            try {
                Object xj2 = xj();
                return (String) xj2.getClass().getMethod("get", String.class).invoke(xj2, str);
            } catch (Throwable th2) {
                cu.xj(th2);
                return "";
            }
        }
    }
}
