package com.bytedance.adsdk.ugeno.y;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class u {
    private static Resources hf;

    @SuppressLint({"StaticFieldLeak"})
    private static Context w;
    private static String xj;

    public static int hf(Context context, String str) {
        return xj(context, str, "drawable");
    }

    public static int w(Context context, String str) {
        return xj(context, str, com.sigmob.sdk.downloader.core.breakpoint.f.f13353a);
    }

    private static String xj(Context context) {
        if (xj == null) {
            xj = context.getPackageName();
        }
        return xj;
    }

    private static int xj(Context context, String str, String str2) {
        if (hf == null) {
            hf = context.getResources();
        }
        return hf.getIdentifier(str, str2, xj(context));
    }

    public static int xj(Context context, String str) {
        return xj(context, str, "raw");
    }
}
