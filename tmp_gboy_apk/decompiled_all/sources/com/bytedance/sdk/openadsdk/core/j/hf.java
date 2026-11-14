package com.bytedance.sdk.openadsdk.core.j;

import com.bytedance.sdk.component.utils.pl;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class hf {
    private String hf;
    private JSONObject u;
    private boolean xj;
    private long w = 0;
    private boolean kd = u.hf;

    public static hf xj(JSONObject jSONObject) {
        hf hfVar = new hf();
        if (jSONObject != null) {
            hfVar.xj(jSONObject.optString("ec_mall_back_url"));
            hfVar.xj = jSONObject.optBoolean("sub_process", false);
            hfVar.w = jSONObject.optLong("init_delay", u.xj);
            hfVar.u = jSONObject.optJSONObject("live_tob_init_extra");
            hfVar.xj(jSONObject.optString("ec_mall_back_url"));
            hfVar.kd = jSONObject.optBoolean("init_after_click", u.hf);
        }
        return hfVar;
    }

    public long hf() {
        return this.w;
    }

    public boolean kd() {
        return this.kd;
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ec_mall_back_url", this.hf);
            jSONObject.put("sub_process", this.xj);
            jSONObject.put("init_delay", this.w);
            jSONObject.put("live_tob_init_extra", this.u);
            jSONObject.put("init_after_click", this.kd);
        } catch (Exception e) {
            pl.hf("AppLiveConfig", e);
        }
        return jSONObject.toString();
    }

    public String u() {
        return this.hf;
    }

    public JSONObject w() {
        return this.u;
    }

    public boolean xj() {
        return this.xj;
    }

    public void xj(String str) {
        this.hf = str;
    }
}
