package com.bytedance.sdk.openadsdk.res;

import android.graphics.drawable.Drawable;
import android.widget.ProgressBar;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class y {
    public static void xj(ProgressBar progressBar, Drawable drawable) {
        xj(progressBar, "mIndeterminateOnly", Boolean.FALSE);
        progressBar.setIndeterminate(false);
        progressBar.setProgressDrawable(drawable);
        progressBar.setIndeterminateDrawable(null);
    }

    private static void xj(Object obj, String str, Object obj2) {
        try {
            Field xj = xj(obj, str);
            if (xj != null) {
                xj(xj);
                xj.set(obj, obj2);
                return;
            }
            throw new IllegalArgumentException("Could not find field [" + str + "] on target [" + obj + "]");
        } catch (Throwable unused) {
        }
    }

    private static Field xj(Object obj, String str) {
        return xj((Class) obj.getClass(), str);
    }

    private static Field xj(Class cls, String str) {
        while (cls != Object.class) {
            try {
                return cls.getDeclaredField(str);
            } catch (NoSuchFieldException unused) {
                cls = cls.getSuperclass();
            }
        }
        return null;
    }

    private static void xj(Field field) {
        if (Modifier.isPublic(field.getModifiers()) && Modifier.isPublic(field.getDeclaringClass().getModifiers())) {
            return;
        }
        field.setAccessible(true);
    }
}
