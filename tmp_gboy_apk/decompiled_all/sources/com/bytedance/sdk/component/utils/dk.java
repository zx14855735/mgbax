package com.bytedance.sdk.component.utils;

import android.os.Build;
import android.text.TextUtils;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class dk {
    private static volatile String xj;

    public static String xj() {
        if (!TextUtils.isEmpty(xj)) {
            return xj;
        }
        String str = Build.MODEL;
        xj = str;
        return str;
    }
}
