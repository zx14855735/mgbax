package com.bytedance.msdk.core.tf;

import com.bytedance.sdk.component.utils.pl;
import com.sigmob.sdk.base.mta.PointParamKey;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class u {
    private JSONObject c;
    private double hf;
    private int kd;
    private String u;
    private int w;
    private double xj;
    private String y;

    private u(double d, double d2, int i, String str, int i2, String str2, JSONObject jSONObject) {
        this.xj = d;
        this.hf = d2;
        this.w = i;
        this.u = str;
        this.kd = i2;
        this.y = str2;
        this.c = jSONObject;
    }

    public static void xj(JSONObject jSONObject, Map<String, u> map) {
        JSONArray optJSONArray;
        String optString;
        if (jSONObject == null || (optJSONArray = jSONObject.optJSONArray("prime_rits")) == null) {
            return;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            try {
                optString = optJSONArray.optString(i);
            } catch (Exception e) {
                e = e;
            }
            try {
                map.put(optString, new u(jSONObject.optDouble("upper", 0.0d), jSONObject.optDouble("lower", 0.0d), jSONObject.optInt(PointParamKey.TYPE), optString, jSONObject.optInt("js_mode"), jSONObject.optString("rule_id"), jSONObject.optJSONObject("refresh_time")));
            } catch (Exception e2) {
                e = e2;
                pl.xj(e);
            }
        }
    }

    public int getType() {
        return this.w;
    }

    public double hf() {
        return this.hf;
    }

    public boolean kd() {
        return this.xj <= 0.0d && this.hf <= 0.0d;
    }

    public String u() {
        return this.y;
    }

    public int w() {
        return this.kd;
    }

    public double xj() {
        return this.xj;
    }

    public int xj(String str) {
        JSONObject jSONObject = this.c;
        if (jSONObject != null) {
            return jSONObject.optInt(str);
        }
        return 0;
    }
}
