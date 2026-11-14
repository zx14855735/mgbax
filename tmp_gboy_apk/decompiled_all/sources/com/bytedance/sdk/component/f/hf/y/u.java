package com.bytedance.sdk.component.f.hf.y;

import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
class u {
    private String hf;
    private JSONObject kd;
    private int u;
    private boolean w;
    private String xj;
    private int y;

    public u(String str, String str2, boolean z, int i, JSONObject jSONObject, int i2) {
        this.xj = str;
        this.hf = str2;
        this.w = z;
        this.u = i;
        this.kd = jSONObject;
        this.y = i2;
    }

    public String hf() {
        return this.xj;
    }

    public int kd() {
        return this.u;
    }

    public boolean u() {
        return this.w;
    }

    public String w() {
        return this.hf;
    }

    public JSONObject xj() {
        if (this.kd == null) {
            this.kd = new JSONObject();
        }
        return this.kd;
    }

    public void xj(int i) {
        this.u = i;
    }
}
