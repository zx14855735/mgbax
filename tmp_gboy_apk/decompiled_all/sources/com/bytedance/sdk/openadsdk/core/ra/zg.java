package com.bytedance.sdk.openadsdk.core.ra;

import J3FDQU.A2egSU;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class zg {
    private static volatile String xj;
    private String c;
    private boolean d;
    private String f;
    private String hf;
    private JSONObject kd;
    private int u;
    private String w;
    private int y;

    public zg() {
        this.c = "";
        this.f = "";
    }

    private String u(String str) {
        if (this.kd != null && !TextUtils.isEmpty(str) && this.hf != null) {
            String optString = this.kd.optString(str);
            if (!TextUtils.isEmpty(optString)) {
                return A2egSU.B3GDIM(new StringBuilder(), this.hf, this.hf.contains("?") ? "&" : "?", optString);
            }
        }
        return this.hf;
    }

    public static void xj(String str) {
        xj = str;
    }

    public String c() {
        return this.f;
    }

    public String hf() {
        return u(xj);
    }

    public int kd() {
        return this.u;
    }

    public int w() {
        return this.y;
    }

    public String y() {
        return this.c;
    }

    public void hf(String str) {
        this.hf = str;
    }

    public void w(String str) {
        this.w = str;
    }

    public void xj(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("deeplink_url", hf());
            jSONObject2.put("fallback_url", u());
            jSONObject2.put("fallback_type", kd());
            jSONObject2.put("addon_params", this.kd);
            jSONObject2.put("fallback_landing", this.y);
            jSONObject2.put("fallback_landing_ugen_url", this.c);
            jSONObject2.put("fallback_landing_ugen_md5", this.f);
            jSONObject.put("deep_link", jSONObject2);
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
        }
    }

    public zg(JSONObject jSONObject) {
        this.c = "";
        this.f = "";
        if (jSONObject == null) {
            return;
        }
        hf(jSONObject.optString("deeplink_url"));
        w(jSONObject.optString("fallback_url"));
        xj(jSONObject.optInt("fallback_type"));
        this.kd = jSONObject.optJSONObject("addon_params");
        this.y = jSONObject.optInt("fallback_landing");
        this.c = jSONObject.optString("fallback_landing_ugen_url");
        this.f = jSONObject.optString("fallback_landing_ugen_md5");
    }

    public String u() {
        return this.w;
    }

    public boolean xj() {
        return this.d;
    }

    public void xj(boolean z) {
        this.d = z;
    }

    public void xj(int i) {
        this.u = i;
    }

    public void xj(zg zgVar) {
        if (zgVar == null) {
            return;
        }
        if (!TextUtils.isEmpty(zgVar.hf())) {
            hf(zgVar.hf());
        }
        if (!TextUtils.isEmpty(zgVar.u())) {
            w(zgVar.u());
        }
        if (zgVar.kd() != 0) {
            xj(zgVar.kd());
        }
    }
}
