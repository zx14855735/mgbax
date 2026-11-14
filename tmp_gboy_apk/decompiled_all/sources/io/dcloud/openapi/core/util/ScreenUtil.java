package io.dcloud.openapi.core.util;

import android.content.Context;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class ScreenUtil {
    public static int dh(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    public static int dw(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }
}
