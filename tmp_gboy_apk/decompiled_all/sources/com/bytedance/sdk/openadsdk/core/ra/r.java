package com.bytedance.sdk.openadsdk.core.ra;

import com.sigmob.sdk.base.mta.PointParamKey;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class r {
    private JSONArray c;
    private hf d;
    private int f;
    private boolean hf;
    private String kd;
    private xj tf;
    private String u;
    private boolean w;
    private String xj;
    private String y;

    public static r xj(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        r rVar = new r();
        rVar.xj = jSONObject.optString("promotion_id");
        rVar.hf = jSONObject.optBoolean("is_silent_auth", false);
        rVar.w = jSONObject.optBoolean("enable_playable_auth", false);
        rVar.u = jSONObject.optString("aweme_agreements");
        rVar.kd = jSONObject.optString("aweme_privacy");
        rVar.y = jSONObject.optString("live_csj_libra_param");
        rVar.c = jSONObject.optJSONArray("tasks");
        rVar.f = jSONObject.optInt("live_playable");
        rVar.tf = xj.xj(jSONObject.optJSONObject("product"));
        rVar.d = hf.xj(jSONObject.optJSONObject("coupon"));
        return rVar;
    }

    public String c() {
        return this.y;
    }

    public boolean d() {
        return this.f == 2 && this.w;
    }

    public JSONArray f() {
        return this.c;
    }

    public String hf() {
        return this.xj;
    }

    public String kd() {
        return this.u;
    }

    public xj p() {
        return this.tf;
    }

    public hf tf() {
        return this.d;
    }

    public boolean u() {
        return this.w;
    }

    public boolean w() {
        return this.hf;
    }

    public String y() {
        return this.kd;
    }

    public static class hf {
        int hf;
        int xj;

        public static hf xj(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            hf hfVar = new hf();
            hfVar.xj = jSONObject.optInt("amount");
            hfVar.hf = jSONObject.optInt("threshold");
            return hfVar;
        }

        public int hf() {
            return this.hf;
        }

        public JSONObject w() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("amount", this.xj);
                jSONObject.put("threshold", this.hf);
            } catch (JSONException unused) {
            }
            return jSONObject;
        }

        public int xj() {
            return this.xj;
        }
    }

    public static class xj {
        String hf;
        double u;
        double w;
        String xj;

        public static xj xj(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            xj xjVar = new xj();
            xjVar.xj = jSONObject.optString("title");
            xjVar.hf = jSONObject.optString("image");
            xjVar.u = jSONObject.optDouble("price");
            xjVar.w = jSONObject.optDouble(PointParamKey.ORIGIN_PRICE);
            return xjVar;
        }

        public String hf() {
            return this.hf;
        }

        public JSONObject kd() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("title", this.xj);
                jSONObject.put("image", this.hf);
                jSONObject.put("price", this.u);
                jSONObject.put(PointParamKey.ORIGIN_PRICE, this.w);
            } catch (JSONException unused) {
            }
            return jSONObject;
        }

        public double u() {
            return this.u;
        }

        public double w() {
            return this.w;
        }

        public String xj() {
            return this.xj;
        }
    }

    public JSONObject xj() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("promotion_id", this.xj);
            jSONObject.put("is_silent_auth", this.hf);
            jSONObject.put("enable_playable_auth", this.w);
            jSONObject.put("aweme_agreements", this.u);
            jSONObject.put("aweme_privacy", this.kd);
            jSONObject.put("live_csj_libra_param", this.y);
            jSONObject.put("tasks", this.c);
            jSONObject.put("live_playable", this.f);
            xj xjVar = this.tf;
            if (xjVar != null) {
                jSONObject.put("product", xjVar.kd());
            }
            hf hfVar = this.d;
            if (hfVar != null) {
                jSONObject.put("coupon", hfVar.w());
                return jSONObject;
            }
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
        }
        return jSONObject;
    }
}
