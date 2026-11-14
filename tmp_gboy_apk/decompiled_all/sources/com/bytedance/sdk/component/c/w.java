package com.bytedance.sdk.component.c;

import android.content.Context;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class w {
    private static volatile Context xj;

    public static Context getContext() {
        return xj;
    }

    public static void xj(Context context) {
        if (xj == null && context != null) {
            xj = context.getApplicationContext();
        }
    }
}
