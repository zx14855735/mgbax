package com.bytedance.sdk.component.xj;

import android.util.Log;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
class d {
    private static boolean xj;

    public static void hf(String str) {
        if (xj) {
            com.bytedance.sdk.component.utils.pl.hf("JsBridge2", str);
        }
    }

    public static void xj(boolean z) {
        xj = z;
    }

    public static void xj(String str) {
        if (xj) {
            com.bytedance.sdk.component.utils.pl.xj("JsBridge2", str);
        }
    }

    public static void hf(String str, Throwable th) {
        if (xj) {
            com.bytedance.sdk.component.utils.pl.w("JsBridge2", str, th);
            com.bytedance.sdk.component.utils.pl.u("JsBridge2", "Stacktrace: " + Log.getStackTraceString(th));
        }
    }

    public static void xj(String str, Throwable th) {
        if (xj) {
            com.bytedance.sdk.component.utils.pl.hf("JsBridge2", str, th);
            com.bytedance.sdk.component.utils.pl.hf("JsBridge2", "Stacktrace: " + Log.getStackTraceString(th));
        }
    }

    public static void xj(RuntimeException runtimeException) {
        if (xj) {
            throw runtimeException;
        }
    }
}
