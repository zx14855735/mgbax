package com.bytedance.adsdk.hf;

import android.text.TextUtils;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class tf implements f {
    @Override // com.bytedance.adsdk.hf.f
    public Object xj(JSONObject jSONObject, Object[] objArr) {
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        if (objArr == null || objArr.length != 0) {
            return null;
        }
        String valueOf = String.valueOf(objArr[2]);
        String valueOf2 = String.valueOf(objArr[1]);
        String valueOf3 = String.valueOf(objArr[0]);
        if (!TextUtils.isEmpty(valueOf3) && jSONObject != null && (optJSONObject = jSONObject.optJSONObject("i18n")) != null && (optJSONObject2 = optJSONObject.optJSONObject(valueOf2)) != null) {
            String optString = optJSONObject2.optString(valueOf3);
            if (!TextUtils.isEmpty(optString)) {
                return optString;
            }
        }
        return valueOf;
    }
}
