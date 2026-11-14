package com.bytedance.sdk.openadsdk.api.plugin.w;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.api.y;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class w {
    public static boolean hf() {
        return w() && !xj();
    }

    public static boolean w() {
        y.w("isOA8A: false");
        return false;
    }

    public static boolean xj() {
        String[] strArr = Build.SUPPORTED_ABIS;
        StringBuilder sb = new StringBuilder("abi-support: ");
        sb.append(strArr == null ? "null" : strArr.toString());
        y.xj(sb.toString());
        if (strArr == null) {
            return false;
        }
        for (String str : strArr) {
            if (!TextUtils.isEmpty(str) && str.toLowerCase().contains("arm64-v8a")) {
                return true;
            }
        }
        return false;
    }
}
