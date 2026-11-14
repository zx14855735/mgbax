package com.bytedance.msdk.xj.kd;

import android.content.Context;
import android.util.DisplayMetrics;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class c {
    private static int hf = -1;
    private static int kd = -1;
    private static int u = -1;
    private static float w = -1.0f;
    private static float xj = -1.0f;

    static {
        xj(com.bytedance.msdk.core.hf.getContext());
        eunWO();
    }

    private static /* synthetic */ void eunWO() {
        char[] charArray = "©¥§ä\u00ad«§¯ä¨¥³ä¹¢¯¦¦ä\u0080¤£\u0088¸£®\u00ad¯".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 202);
        }
        String str = new String(charArray);
        char[] charArray2 = "©¦£¤£¾".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 202);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static int hf(Context context) {
        xj(context);
        return u;
    }

    public static int kd(Context context) {
        xj(context);
        return hf;
    }

    public static float u(Context context) {
        xj(context);
        return xj;
    }

    public static int w(Context context) {
        xj(context);
        return kd;
    }

    public static void xj(Context context) {
        Context context2 = context == null ? com.bytedance.msdk.core.hf.getContext() : context;
        if (context2 == null) {
            return;
        }
        DisplayMetrics displayMetrics = context2.getResources().getDisplayMetrics();
        xj = displayMetrics.density;
        hf = displayMetrics.densityDpi;
        w = displayMetrics.scaledDensity;
        u = displayMetrics.widthPixels;
        kd = displayMetrics.heightPixels;
        if (context == null || context.getResources() == null || context.getResources().getConfiguration() == null) {
            return;
        }
        if (context.getResources().getConfiguration().orientation == 1) {
            int i = u;
            int i2 = kd;
            if (i > i2) {
                u = i2;
                kd = i;
                return;
            }
            return;
        }
        int i3 = u;
        int i4 = kd;
        if (i3 < i4) {
            u = i4;
            kd = i3;
        }
    }

    public static int hf(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int xj(Context context, float f) {
        xj(context);
        float u2 = u(context);
        if (u2 <= 0.0f) {
            u2 = 1.0f;
        }
        return (int) ((f / u2) + 0.5f);
    }
}
