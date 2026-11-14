package com.bytedance.sdk.component.utils;

import android.text.TextUtils;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class io {
    public static Method xj(String str, String str2, Class<?>... clsArr) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                Class<?> xj = xj(str);
                if (xj != null) {
                    return xj.getMethod(str2, clsArr);
                }
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public static Class<?> xj(String str) {
        try {
            try {
                try {
                    return Class.forName(str, true, xj());
                } catch (ClassNotFoundException unused) {
                    return Class.forName(str);
                }
            } catch (ClassNotFoundException unused2) {
                return null;
            }
        } catch (ClassNotFoundException unused3) {
            return Class.forName(str, true, io.class.getClassLoader());
        }
    }

    private static ClassLoader xj() {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        return contextClassLoader == null ? io.class.getClassLoader() : contextClassLoader;
    }
}
