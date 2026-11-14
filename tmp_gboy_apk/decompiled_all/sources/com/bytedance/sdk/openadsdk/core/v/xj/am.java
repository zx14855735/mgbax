package com.bytedance.sdk.openadsdk.core.v.xj;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.bytedance.sdk.openadsdk.core.yo.xj;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class am extends com.bytedance.sdk.component.xj.kd<JSONObject, JSONObject> {
    public static void xj(com.bytedance.sdk.component.xj.e eVar) {
        eVar.xj("getDownloadStatus", (com.bytedance.sdk.component.xj.kd<?, ?>) new am());
    }

    @Override // com.bytedance.sdk.component.xj.kd
    public JSONObject xj(JSONObject jSONObject, com.bytedance.sdk.component.xj.y yVar) {
        return xj(jSONObject);
    }

    public static JSONObject xj(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        if (jSONObject == null) {
            xj(jSONObject2, 1, "params is null", 1, 1);
            return jSONObject2;
        }
        try {
            String optString = jSONObject.optString("ad_down_load_id");
            if (TextUtils.isEmpty(optString)) {
                xj(jSONObject2, 1, "ad_down_load_id is null", 1, 1);
                return jSONObject2;
            }
            return xj.C0198xj.xj(optString);
        } catch (Throwable unused) {
            return jSONObject2;
        }
    }

    private static void xj(JSONObject jSONObject, int i, String str, int i2, int i3) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put(PluginConstants.KEY_ERROR_CODE, i);
            jSONObject.put("codeMsg", str);
            jSONObject.put("downloadStatus", i2);
            jSONObject.put("downloadProcessRate", i3);
        } catch (Exception unused) {
        }
    }
}
