package com.bytedance.sdk.component.adexpress.u;

import android.content.Context;
import android.os.Build;
import android.os.LocaleList;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.bytedance.sdk.component.utils.jk;
import java.util.Locale;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class f {
    private static boolean xj;

    public static int hf(Context context, float f) {
        if (context == null) {
            context = com.bytedance.sdk.component.adexpress.xj.xj.xj.xj().w().getContext();
        }
        float kd = kd(context);
        if (kd <= 0.0f) {
            kd = 1.0f;
        }
        return (int) ((f / kd) + 0.5f);
    }

    private static float kd(Context context) {
        try {
            if (xj) {
                context.getClassLoader().loadClass("android.util.DisplayMetrics").getDeclaredMethod("getDeviceDensity", new Class[0]).setAccessible(true);
                return ((Integer) r1.invoke(r0, new Object[0])).intValue() / 160.0f;
            }
        } catch (Exception unused) {
        }
        return context.getResources().getDisplayMetrics().density;
    }

    public static String u(Context context) {
        String str;
        Locale locale;
        LocaleList locales;
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                locales = jk.xj(context).getConfiguration().getLocales();
                locale = locales.get(0);
            } else {
                locale = Locale.getDefault();
            }
            str = locale.getLanguage();
            try {
                if (locale.getCountry().equals("TW")) {
                    str = "zhHant";
                }
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            str = "";
        }
        return xj(str);
    }

    public static float w(Context context, float f) {
        if (context == null) {
            context = com.bytedance.sdk.component.adexpress.xj.xj.xj.xj().w().getContext();
        }
        return f * kd(context);
    }

    public static int xj(float f, float f2, float f3, float f4) {
        return (((int) ((f * 255.0f) + 0.5f)) << 24) | (((int) ((f2 * 255.0f) + 0.5f)) << 16) | (((int) ((f3 * 255.0f) + 0.5f)) << 8) | ((int) ((f4 * 255.0f) + 0.5f));
    }

    public static float xj(Context context, float f) {
        if (context == null) {
            context = com.bytedance.sdk.component.adexpress.xj.xj.xj.xj().w().getContext();
        }
        return (f * kd(context)) + 0.5f;
    }

    public static int hf(Context context) {
        if (context == null) {
            context = com.bytedance.sdk.component.adexpress.xj.xj.xj.xj().w().getContext();
        }
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    public static int w(Context context) {
        if (context == null) {
            context = com.bytedance.sdk.component.adexpress.xj.xj.xj.xj().w().getContext();
        }
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getRealMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    public static int xj(Context context) {
        if (context == null) {
            context = com.bytedance.sdk.component.adexpress.xj.xj.xj.xj().w().getContext();
        }
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    private static String xj(String str) {
        str.getClass();
        switch (str) {
            case "ar":
                return "aa";
            case "ja":
                return "japan";
            case "ko":
                return "korea";
            case "ms":
                return "my";
            case "zh":
                return "cn";
            default:
                return str;
        }
    }
}
