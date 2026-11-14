package com.bytedance.msdk.f;

import android.text.TextUtils;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class et {
    public static void xj(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            xj(str2);
        }
    }

    private static void xj(String str) {
        throw new IllegalArgumentException(str);
    }
}
