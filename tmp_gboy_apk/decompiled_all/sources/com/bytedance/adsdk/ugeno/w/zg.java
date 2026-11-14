package com.bytedance.adsdk.ugeno.w;

import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class zg {
    private int hf;
    private zg kd;
    private zg u;
    private JSONObject w;
    private com.bytedance.adsdk.ugeno.hf.w xj;

    public int hf() {
        return this.hf;
    }

    public String toString() {
        return "UGenEvent{mWidget=" + this.xj + ", mEventType=" + this.hf + ", mEvent=" + this.w + '}';
    }

    public zg u() {
        return this.u;
    }

    public JSONObject w() {
        return this.w;
    }

    public com.bytedance.adsdk.ugeno.hf.w xj() {
        return this.xj;
    }

    public void hf(zg zgVar) {
        this.kd = zgVar;
    }

    public void xj(com.bytedance.adsdk.ugeno.hf.w wVar) {
        this.xj = wVar;
    }

    public void xj(int i) {
        this.hf = i;
    }

    public void xj(JSONObject jSONObject) {
        this.w = jSONObject;
    }

    public void xj(zg zgVar) {
        this.u = zgVar;
    }
}
