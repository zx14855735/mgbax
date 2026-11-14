package com.bytedance.sdk.openadsdk.core.ht;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.pz;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class kd {
    public static boolean xj(String str, double d) {
        JSONObject gy = pz.hf().gy();
        if (gy != null && !TextUtils.isEmpty(str)) {
            try {
                double optDouble = gy.optDouble(str, d);
                if (optDouble >= 1.0d || optDouble < 0.0d || com.bytedance.sdk.openadsdk.core.am.w.xj.contains(str)) {
                    return true;
                }
                return com.bytedance.sdk.openadsdk.core.y.hf.xj((float) optDouble, false);
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.pl.w("sample throwable:" + th.getMessage());
            }
        }
        return true;
    }
}
