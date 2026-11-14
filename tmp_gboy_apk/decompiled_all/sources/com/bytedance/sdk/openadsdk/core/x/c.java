package com.bytedance.sdk.openadsdk.core.x;

import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class c {
    private JSONObject xj;

    public c(JSONObject jSONObject) {
        this.xj = jSONObject;
    }

    public String toString() {
        JSONObject jSONObject = this.xj;
        return jSONObject != null ? jSONObject.toString() : "pitaya error is null";
    }

    public int xj() {
        JSONObject jSONObject = this.xj;
        if (jSONObject != null) {
            return jSONObject.optInt(PluginConstants.KEY_ERROR_CODE, -1);
        }
        return -1;
    }
}
