package com.bytedance.msdk.core.w;

import android.text.TextUtils;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class hf {
    private int c;
    private JSONObject hf;
    private String kd;
    private String u;
    private int w;
    public List<Integer> xj;
    private String y;

    public hf(JSONObject jSONObject) {
        JSONArray optJSONArray = jSONObject.optJSONArray("behavior_state");
        if (optJSONArray != null) {
            this.xj = new LinkedList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                try {
                    this.xj.add(Integer.valueOf(optJSONArray.getInt(i)));
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("rule_excs");
        if (optJSONObject != null) {
            this.c = optJSONObject.optInt("condition");
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("perform");
            this.hf = optJSONObject2;
            if (optJSONObject2 != null) {
                this.w = optJSONObject2.optInt("condition");
                this.u = this.hf.optString("opt");
                this.kd = this.hf.optString("rule_id");
                this.y = this.hf.optString("rule_timestamp");
            }
        }
    }

    public boolean c() {
        return "1".equals(this.u) || "2".equals(this.u) || "3".equals(this.u) || "4".equals(this.u) || "5".equals(this.u);
    }

    public int hf() {
        return this.c;
    }

    public JSONObject kd() {
        return this.hf;
    }

    public String u() {
        return this.y;
    }

    public String w() {
        return this.kd;
    }

    public int xj() {
        return this.w;
    }

    public String y() {
        return this.u;
    }

    public double hf(String str, String str2) {
        JSONObject jSONObject;
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        JSONObject optJSONObject3;
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str) || (jSONObject = this.hf) == null || (optJSONObject = jSONObject.optJSONObject("prime_rits")) == null || (optJSONObject2 = optJSONObject.optJSONObject(str2)) == null || (optJSONObject3 = optJSONObject2.optJSONObject("srr")) == null) {
            return 0.0d;
        }
        return optJSONObject3.optDouble(str, 0.0d);
    }

    public boolean xj(int i) {
        List<Integer> list = this.xj;
        if (list != null) {
            return list.contains(Integer.valueOf(i));
        }
        return false;
    }

    public boolean xj(String str) {
        JSONObject optJSONObject;
        JSONObject optJSONObject2 = this.hf.optJSONObject("prime_rits");
        if (optJSONObject2 == null || (optJSONObject = optJSONObject2.optJSONObject(str)) == null) {
            return false;
        }
        return (optJSONObject.optJSONObject("ssr") == null && optJSONObject.optJSONObject("srr") == null) ? false : true;
    }

    public double xj(String str, String str2) {
        JSONObject jSONObject;
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        JSONObject optJSONObject3;
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str) || (jSONObject = this.hf) == null || (optJSONObject = jSONObject.optJSONObject("prime_rits")) == null || (optJSONObject2 = optJSONObject.optJSONObject(str2)) == null || (optJSONObject3 = optJSONObject2.optJSONObject("ssr")) == null) {
            return 0.0d;
        }
        return optJSONObject3.optDouble(str, 0.0d);
    }
}
