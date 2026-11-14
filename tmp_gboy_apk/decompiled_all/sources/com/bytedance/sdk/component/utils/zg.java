package com.bytedance.sdk.component.utils;

import android.text.TextUtils;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class zg {
    private static void hf(String str) {
        throw new IllegalArgumentException(str);
    }

    public static void xj(Object obj, String str) {
        if (obj == null) {
            hf(str);
        }
    }

    public static void xj(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            hf(str2);
        }
    }

    public static void xj(boolean z, String str) {
        if (z) {
            return;
        }
        hf(str);
    }

    public static void xj(String str) {
        hf(str);
    }
}
