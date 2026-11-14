package com.kwad.components.core.s;

import android.app.Activity;
import android.os.Build;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class q {
    public static boolean e(Activity activity) {
        int g = com.kwad.sdk.c.a.a.g(activity);
        if (isInMultiWindowMode(activity) && com.kwad.sdk.c.a.a.br(activity) - g < com.kwad.sdk.c.a.a.a(activity, 100.0f)) {
            g = com.kwad.sdk.c.a.a.k(activity);
        }
        return ((float) g) / ((float) com.kwad.sdk.c.a.a.h(activity)) < 1.2f;
    }

    public static boolean isInMultiWindowMode(Activity activity) {
        boolean isInMultiWindowMode;
        if (activity == null || Build.VERSION.SDK_INT < 24) {
            return false;
        }
        try {
            isInMultiWindowMode = activity.isInMultiWindowMode();
            return isInMultiWindowMode;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }
}
