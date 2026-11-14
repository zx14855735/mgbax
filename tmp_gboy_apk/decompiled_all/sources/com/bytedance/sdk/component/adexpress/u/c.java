package com.bytedance.sdk.component.adexpress.u;

import android.text.TextUtils;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class c {
    public static boolean hf(String str) {
        return com.bytedance.sdk.component.adexpress.u.xj() && xj(str);
    }

    public static boolean xj(String str) {
        return TextUtils.equals(str, "fullscreen_interstitial_ad") || TextUtils.equals(str, "rewarded_video");
    }
}
