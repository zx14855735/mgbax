package com.kwad.sdk.utils;

import android.content.Context;
import android.content.res.Resources;
import com.kwad.sdk.service.ServiceProvider;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class ba {
    public static int az(Context context, String str) {
        Resources dz = dz(context);
        if (dz == null) {
            dz = context.getResources();
        }
        return dz.getIdentifier(str, "drawable", context.getPackageName());
    }

    public static Resources dz(Context context) {
        if (context == null) {
            return null;
        }
        return ServiceProvider.Re().getResources();
    }

    public static int getAppIconId(Context context) {
        int i;
        try {
            i = y.getPackageInfo(context.getApplicationContext(), context.getPackageName(), 64).applicationInfo.icon;
        } catch (Throwable unused) {
            i = 0;
        }
        return i <= 0 ? az(context, "ksad_notification_small_icon") : i;
    }

    public static int getId(Context context, String str) {
        return getIdentifier(context, str, com.sigmob.sdk.downloader.core.breakpoint.f.f13353a);
    }

    private static int getIdentifier(Context context, String str, String str2) {
        return context.getResources().getIdentifier(str, str2, getPackageName(context));
    }

    private static String getPackageName(Context context) {
        return ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).CT() ? "com.kwad.sdk" : context.getPackageName();
    }
}
