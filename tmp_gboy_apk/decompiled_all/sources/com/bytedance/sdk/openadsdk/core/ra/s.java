package com.bytedance.sdk.openadsdk.core.ra;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class s {
    private int hf;
    private int kd;
    private int u;
    private long w;
    private int xj;

    public static s xj(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        s sVar = new s();
        sVar.xj = jSONObject.optInt("auth_type");
        sVar.hf = jSONObject.optInt("auth_time");
        sVar.w = jSONObject.optLong("auth_out_time");
        sVar.u = jSONObject.optInt("video_open_deeplink");
        sVar.kd = jSONObject.optInt("reject_in");
        return sVar;
    }

    public int hf() {
        return this.xj;
    }

    public long kd() {
        return this.w;
    }

    public int u() {
        return this.u;
    }

    public int w() {
        return this.hf;
    }

    public int y() {
        return this.kd;
    }

    public JSONObject xj() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("auth_type", this.xj);
            jSONObject.put("auth_time", this.hf);
            jSONObject.put("auth_out_time", this.w);
            jSONObject.put("video_open_deeplink", this.u);
            jSONObject.put("reject_in", this.kd);
            return jSONObject;
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
            return jSONObject;
        }
    }
}
