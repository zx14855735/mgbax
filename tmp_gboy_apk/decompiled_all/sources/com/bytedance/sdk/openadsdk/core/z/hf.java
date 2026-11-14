package com.bytedance.sdk.openadsdk.core.z;

import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class hf {
    private Map<String, String> hf;
    private JSONObject kd;
    private int u;
    private JSONObject w;
    private byte[] xj;

    public int hf() {
        return this.u;
    }

    public Map<String, String> kd() {
        return this.hf;
    }

    public JSONObject u() {
        return this.w;
    }

    public byte[] w() {
        return this.xj;
    }

    public JSONObject xj() {
        return this.kd;
    }

    public void hf(JSONObject jSONObject) {
        this.w = jSONObject;
    }

    public void xj(JSONObject jSONObject) {
        this.kd = jSONObject;
    }

    public void xj(int i) {
        this.u = i;
    }

    public void xj(byte[] bArr) {
        this.xj = bArr;
    }

    public void xj(Map<String, String> map) {
        this.hf = map;
    }
}
