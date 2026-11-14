package com.bytedance.sdk.openadsdk.core.live.kd;

import android.text.TextUtils;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class w {
    private static boolean hf(String str) {
        JSONObject optJSONObject;
        if (TextUtils.isEmpty(str) || (optJSONObject = new JSONObject(str).optJSONObject("enter_request")) == null) {
            return false;
        }
        int optInt = optJSONObject.optInt("activity_type");
        JSONArray optJSONArray = optJSONObject.optJSONArray("incr_coupon");
        if (optInt == 1 && optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject2 = optJSONArray.optJSONObject(i);
                if (optJSONObject2.optInt("interaction_type") == 1 && optJSONObject2.optInt("task_time") > 0 && optJSONObject2.optLong("value") > 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int xj(Map<String, Object> map) {
        try {
            return ((Integer) map.get("live_saas_param_interaction_type")).intValue();
        } catch (Exception unused) {
            return 0;
        }
    }

    public static boolean xj(String str) {
        try {
            if (TextUtils.isEmpty(str) || new JSONObject(str).optJSONObject("enter_request") == null) {
                return false;
            }
            return !hf(str);
        } catch (Exception unused) {
            return false;
        }
    }
}
