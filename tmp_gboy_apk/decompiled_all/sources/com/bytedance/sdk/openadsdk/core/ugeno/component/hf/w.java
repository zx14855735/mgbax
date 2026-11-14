package com.bytedance.sdk.openadsdk.core.ugeno.component.hf;

import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class w {
    private int hf;
    private JSONObject xj;

    public w() {
    }

    public int hf() {
        return this.hf;
    }

    public JSONObject xj() {
        return this.xj;
    }

    public w(JSONObject jSONObject, int i) {
        this.xj = jSONObject;
        this.hf = i;
    }

    public void xj(JSONObject jSONObject) {
        this.xj = jSONObject;
    }

    public void xj(int i) {
        this.hf = i;
    }
}
