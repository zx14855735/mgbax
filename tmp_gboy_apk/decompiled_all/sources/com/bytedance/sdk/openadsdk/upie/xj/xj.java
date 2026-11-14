package com.bytedance.sdk.openadsdk.upie.xj;

import android.text.TextUtils;
import com.bytedance.adsdk.hf.p;
import com.bytedance.sdk.component.utils.pl;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xj {
    public static String xj(String str, JSONObject jSONObject) {
        com.bytedance.adsdk.hf.hf.xj xj;
        if (!TextUtils.isEmpty(str) && jSONObject != null) {
            try {
                if (str.startsWith("${") && str.endsWith("}") && (xj = com.bytedance.adsdk.hf.hf.xj.xj(str.substring(2, str.length() - 1))) != null) {
                    Object xj2 = xj.xj(jSONObject);
                    return xj2 instanceof String ? (String) xj2 : xj2 instanceof com.bytedance.adsdk.hf.hf.xj.xj ? String.valueOf(p.xj((com.bytedance.adsdk.hf.hf.xj.xj) xj2)) : String.valueOf(xj2);
                }
                return str;
            } catch (Throwable th) {
                pl.xj(th);
            }
        }
        return str;
    }
}
