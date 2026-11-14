package com.bytedance.msdk.core.hf;

import android.text.TextUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class u {
    private final String hf;
    private String[] kd;
    private final String u;
    private final String xj;
    private final Map<String, Float> w = new ConcurrentHashMap();
    private final Map<String, kd> y = new ConcurrentHashMap();

    public u(String str, String str2, JSONObject jSONObject) {
        this.xj = str;
        this.hf = str2;
        this.u = jSONObject.optString("symbol");
        JSONArray optJSONArray = jSONObject.optJSONArray("score_fit_type");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            this.kd = new String[optJSONArray.length()];
            for (int i = 0; i < optJSONArray.length(); i++) {
                String optString = optJSONArray.optString(i);
                if (!TextUtils.isEmpty(optString)) {
                    this.kd[i] = optString;
                    JSONObject optJSONObject = jSONObject.optJSONObject(optString);
                    if (optJSONObject != null && optJSONObject.length() > 0) {
                        JSONArray optJSONArray2 = optJSONObject.optJSONArray("range");
                        JSONArray optJSONArray3 = optJSONObject.optJSONArray("value");
                        if (optJSONArray2 != null && optJSONArray2.length() > 0 && optJSONArray3 != null && optJSONArray3.length() > 0) {
                            this.y.put(optString, new kd(optString, optJSONArray2, optJSONArray3));
                        }
                    }
                }
            }
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("rule_exc_mode");
        if (optJSONObject2 == null || optJSONObject2.length() <= 0) {
            return;
        }
        Iterator<String> keys = optJSONObject2.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            this.w.put(next, Float.valueOf((float) optJSONObject2.optDouble(next, 0.0d)));
        }
    }

    public Map<String, Float> hf() {
        return this.w;
    }

    public Map<String, kd> kd() {
        return this.y;
    }

    public String u() {
        return this.u;
    }

    public String[] w() {
        return this.kd;
    }

    public String xj() {
        return this.xj;
    }
}
