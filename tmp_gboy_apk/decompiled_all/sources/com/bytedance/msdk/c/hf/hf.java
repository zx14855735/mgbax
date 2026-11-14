package com.bytedance.msdk.c.hf;

import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class hf {
    private static volatile hf xj;

    private hf() {
    }

    public static hf xj() {
        if (xj == null) {
            synchronized (hf.class) {
                try {
                    if (xj == null) {
                        xj = new hf();
                    }
                } finally {
                }
            }
        }
        return xj;
    }

    public void xj(JSONArray jSONArray) {
        if (jSONArray == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.api.plugin.hf.hf(com.bytedance.msdk.core.hf.getContext(), "tt_sdk_test_tool_data_" + com.bytedance.msdk.core.xj.p().pl(), 0).edit().putString("rit_conf", jSONArray.toString()).apply();
    }

    public void xj(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.api.plugin.hf.hf(com.bytedance.msdk.core.hf.getContext(), "tt_sdk_test_tool_data_" + com.bytedance.msdk.core.xj.p().pl(), 0).edit().putString("adn_init_conf", jSONObject.toString()).apply();
    }
}
