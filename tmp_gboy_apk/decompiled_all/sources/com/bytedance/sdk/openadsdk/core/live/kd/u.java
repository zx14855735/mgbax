package com.bytedance.sdk.openadsdk.core.live.kd;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class u {
    public static boolean xj(String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                if (jSONObject != null) {
                    String optString = jSONObject.optString("name", null);
                    if (TextUtils.equals(optString, "ec_reward_gold") || TextUtils.equals(optString, "reward_gold") || TextUtils.equals(optString, "auth_reward_gold")) {
                        return false;
                    }
                }
            }
            return true;
        } catch (Throwable unused) {
            return true;
        }
    }

    public static boolean xj(ws wsVar) {
        JSONObject kd;
        com.bytedance.sdk.openadsdk.core.ugeno.d.xj ai = wsVar.ai();
        return (ai == null || (kd = ai.kd()) == null || kd.optBoolean("landing_type", false)) ? false : true;
    }
}
