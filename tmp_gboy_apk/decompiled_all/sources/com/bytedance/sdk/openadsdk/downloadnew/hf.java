package com.bytedance.sdk.openadsdk.downloadnew;

import android.content.Context;
import com.bytedance.sdk.openadsdk.api.y;
import com.sigmob.sdk.downloader.core.breakpoint.f;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class hf {
    public static int hf(Context context, String str) {
        try {
            return context.getResources().getIdentifier(str, "style", context.getPackageName());
        } catch (Exception e) {
            y.xj(e);
            return 0;
        }
    }

    public static int w(Context context, String str) {
        try {
            return context.getResources().getIdentifier(str, f.f13353a, context.getPackageName());
        } catch (Exception e) {
            y.xj(e);
            return 0;
        }
    }

    public static int xj(Context context, String str) {
        try {
            return context.getResources().getIdentifier(str, "drawable", context.getPackageName());
        } catch (Exception e) {
            y.xj(e);
            return 0;
        }
    }

    public static int hf(Context context, String str, String str2) {
        try {
            return context.getResources().getIdentifier(str, "attr", str2);
        } catch (Exception e) {
            y.xj(e);
            return 0;
        }
    }

    public static int xj(Context context, String str, String str2) {
        try {
            return context.getResources().getIdentifier(str, "drawable", str2);
        } catch (Exception e) {
            y.xj(e);
            return 0;
        }
    }
}
