package com.bytedance.sdk.openadsdk.core.ra;

import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class pz {
    int xj = 1;
    int hf = 1;

    public void hf(int i) {
        this.hf = i;
    }

    public JSONObject w() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ah", this.xj);
            jSONObject.put("am", this.hf);
            return jSONObject;
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.pl.w(e.toString());
            return jSONObject;
        }
    }

    public void xj(int i) {
        this.xj = i;
    }

    public boolean hf() {
        return this.hf == 1;
    }

    public boolean xj() {
        return this.xj == 1;
    }
}
