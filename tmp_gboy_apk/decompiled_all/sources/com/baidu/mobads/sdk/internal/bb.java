package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.WindowManager;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class bb {

    /* renamed from: a, reason: collision with root package name */
    private static DisplayMetrics f9753a;
    private static float b;

    public static Rect a(Context context) {
        DisplayMetrics f = f(context);
        try {
            return f.widthPixels > f.heightPixels ? new Rect(0, 0, f.heightPixels, f.widthPixels) : new Rect(0, 0, f.widthPixels, f.heightPixels);
        } catch (Exception unused) {
            return null;
        }
    }

    public static int b(Context context) {
        return a(context).width();
    }

    public static int c(Context context) {
        return a(context).height();
    }

    public static Rect d(Context context) {
        DisplayMetrics f = f(context);
        return new Rect(0, 0, f.widthPixels, f.heightPixels);
    }

    public static float e(Context context) {
        if (b < 0.01d) {
            b = f(context).density;
        }
        return b;
    }

    public static DisplayMetrics f(Context context) {
        try {
            DisplayMetrics displayMetrics = f9753a;
            if (displayMetrics != null && displayMetrics.widthPixels > 0) {
                return displayMetrics;
            }
            DisplayMetrics displayMetrics2 = new DisplayMetrics();
            if (bn.a(context).a() >= 17) {
                ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRealMetrics(displayMetrics2);
            } else {
                ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics2);
            }
            f9753a = displayMetrics2;
        } catch (Throwable th) {
            f9753a = new DisplayMetrics();
            bv.a().a(th);
        }
        return f9753a;
    }

    public static int g(Context context) {
        Resources resources = context.getResources();
        return resources.getDimensionPixelSize(resources.getIdentifier("status_bar_height", "dimen", "android"));
    }

    public static int b(Context context, int i) {
        try {
            return (int) (i * e(context));
        } catch (Exception unused) {
            return i;
        }
    }

    public static int b(Context context, float f) {
        return (int) ((f / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int a(Context context, int i) {
        try {
            return (int) (i / e(context));
        } catch (Exception unused) {
            return i;
        }
    }

    public static int a(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
