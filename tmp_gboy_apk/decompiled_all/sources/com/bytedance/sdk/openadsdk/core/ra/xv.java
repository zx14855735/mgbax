package com.bytedance.sdk.openadsdk.core.ra;

import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xv {
    private int hf;
    private boolean kd;
    private String u;
    private String w;
    private JSONObject xj;

    public xv(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.xj = jSONObject;
            this.hf = jSONObject.optInt("dialog_type");
            this.w = jSONObject.optString("template_url");
            this.u = jSONObject.optString("template_md5");
        }
        com.bytedance.sdk.openadsdk.core.ugeno.y.xj xjVar = new com.bytedance.sdk.openadsdk.core.ugeno.y.xj();
        xjVar.hf(kd());
        xjVar.w(u());
    }

    public JSONObject hf() {
        return this.xj;
    }

    public String kd() {
        return this.u;
    }

    public String u() {
        return this.w;
    }

    public int w() {
        return this.hf;
    }

    public JSONObject xj() {
        return this.xj;
    }

    public boolean y() {
        return this.kd;
    }

    public void xj(boolean z) {
        this.kd = z;
    }
}
