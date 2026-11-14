package com.bytedance.msdk.f;

import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class c {
    public static JSONObject xj() {
        Map<String, com.bytedance.msdk.xj.xj.u> hf = com.bytedance.msdk.y.hf.hf.xj().hf();
        if (hf == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, com.bytedance.msdk.xj.xj.u> entry : hf.entrySet()) {
            if (entry.getKey() != null) {
                String[] split = entry.getKey().split("\\.");
                if (split.length >= 5) {
                    try {
                        jSONObject.put(split[4] + "Adapter", entry.getValue().xj());
                    } catch (JSONException e) {
                        com.bytedance.sdk.component.utils.pl.xj(e);
                    }
                }
            }
        }
        return jSONObject;
    }
}
