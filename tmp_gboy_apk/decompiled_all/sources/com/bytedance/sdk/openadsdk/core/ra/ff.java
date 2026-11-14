package com.bytedance.sdk.openadsdk.core.ra;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class ff {
    public JSONObject xj;

    public String toString() {
        JSONObject jSONObject = this.xj;
        return jSONObject == null ? "" : jSONObject.toString();
    }

    public String xj() {
        JSONObject jSONObject = this.xj;
        JSONObject optJSONObject = jSONObject == null ? null : jSONObject.optJSONObject("performance_js");
        return optJSONObject != null ? optJSONObject.optString("url") : "";
    }

    public static ff xj(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return xj(new JSONObject(str));
        } catch (JSONException unused) {
            return null;
        }
    }

    public static ff xj(JSONObject jSONObject) {
        ff ffVar = new ff();
        ffVar.xj = jSONObject;
        return ffVar;
    }
}
