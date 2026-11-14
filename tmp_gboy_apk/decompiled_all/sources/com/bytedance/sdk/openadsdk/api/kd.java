package com.bytedance.sdk.openadsdk.api;

import android.os.Build;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class kd {
    public static boolean xj() {
        if (Build.VERSION.SDK_INT >= 24) {
            return false;
        }
        y.w("csj sdk only support android os >= android 7.0（API-24）");
        return true;
    }
}
