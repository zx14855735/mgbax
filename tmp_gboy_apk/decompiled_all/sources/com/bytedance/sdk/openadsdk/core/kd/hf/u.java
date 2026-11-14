package com.bytedance.sdk.openadsdk.core.kd.hf;

import ADYaiT.CtFAbx;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.sigmob.sdk.downloader.core.breakpoint.f;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class u {
    public Map<String, JSONObject> hf;
    public int xj;

    public boolean xj() {
        int i = this.xj;
        return i > 20000 && i < 100000;
    }

    public static u xj(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        int optInt = jSONObject.optInt(PluginConstants.KEY_ERROR_CODE);
        JSONArray optJSONArray = jSONObject.optJSONArray("result");
        HashMap hashMap = new HashMap();
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString(f.f13353a, "");
                    String optString2 = optJSONObject.optString("req_id", "");
                    if (!TextUtils.isEmpty(xj(optString, optString2))) {
                        hashMap.put(xj(optString, optString2), optJSONObject);
                    }
                }
            }
        }
        u uVar = new u();
        uVar.hf = hashMap;
        uVar.xj = optInt;
        return uVar;
    }

    public static String xj(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        return CtFAbx.AlLFFp(str2, "_", str);
    }
}
