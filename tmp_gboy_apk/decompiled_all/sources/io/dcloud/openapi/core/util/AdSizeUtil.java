package io.dcloud.openapi.core.util;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.TypedValue;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class AdSizeUtil {
    private static float aaaaaaaa(Context context, int i) {
        return i / context.getResources().getDisplayMetrics().density;
    }

    public static float convertHeight(int i, Context context, boolean z) {
        if (i > 0) {
            return z ? aaaaaaaa(context, i) : i;
        }
        return 0.0f;
    }

    public static float convertSize(int i, Context context, boolean z, boolean z2) {
        if (i > 0) {
            return z ? aaaaaaaa(context, i) : i;
        }
        if (!z2) {
            return 0.0f;
        }
        int i2 = context.getResources().getDisplayMetrics().widthPixels;
        return z ? aaaaaaaa(context, i2) : i2;
    }

    public static int pxFromDp(float f, DisplayMetrics displayMetrics) {
        return Math.round(TypedValue.applyDimension(1, f, displayMetrics));
    }
}
