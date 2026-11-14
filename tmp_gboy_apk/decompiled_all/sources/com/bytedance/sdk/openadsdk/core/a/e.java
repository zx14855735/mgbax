package com.bytedance.sdk.openadsdk.core.a;

import android.text.TextUtils;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class e {
    public static String xj(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }
        return map.get(TextUtils.isEmpty(map.get("content-type")) ? "Content-Type" : "content-type");
    }
}
