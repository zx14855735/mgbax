package com.bytedance.sdk.openadsdk.core.pl.u;

import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class f {
    private String hf;
    private JSONObject u;
    private JSONObject w;
    private String xj;

    public static f xj() {
        return new f();
    }

    public f hf(String str) {
        this.hf = str;
        return this;
    }

    public JSONObject kd() {
        return this.u;
    }

    public JSONObject u() {
        return this.w;
    }

    public String w() {
        return this.hf;
    }

    public f hf(JSONObject jSONObject) {
        this.w = jSONObject;
        return this;
    }

    public f xj(JSONObject jSONObject) {
        this.u = jSONObject;
        return this;
    }

    public String hf() {
        return this.xj;
    }

    public f xj(String str) {
        this.xj = str;
        return this;
    }
}
