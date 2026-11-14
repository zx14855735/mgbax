package com.bytedance.sdk.openadsdk.core.ra;

import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class ne {
    private String c;
    private String f;
    private int hf;
    private int kd;
    private String u;
    private String w;
    private String xj;
    private int y;

    public String c() {
        return this.c;
    }

    public JSONObject d() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("wc_skip_type", hf());
            jSONObject.put("wc_miniapp_link", xj());
            jSONObject.put("adv_id", w());
            jSONObject.put("site_id", u());
            jSONObject.put("wc_open_method", y());
            jSONObject.put("wc_miniapp_sdk", c());
            jSONObject.put("wc_appid", f());
            return jSONObject;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.pl.hf("toString failed:" + th.getMessage());
            return jSONObject;
        }
    }

    public String f() {
        return this.f;
    }

    public int hf() {
        return this.hf;
    }

    public int kd() {
        return this.kd;
    }

    public String toString() {
        return d().toString();
    }

    public String u() {
        return this.u;
    }

    public String w() {
        return this.w;
    }

    public String xj() {
        return this.xj;
    }

    public int y() {
        return this.y;
    }

    public void hf(String str) {
        this.w = str;
    }

    public void kd(String str) {
        this.f = str;
    }

    public void u(String str) {
        this.c = str;
    }

    public void w(String str) {
        this.u = str;
    }

    public void xj(String str) {
        this.xj = str;
    }

    public void hf(int i) {
        this.kd = i;
    }

    public void w(int i) {
        this.y = i;
    }

    public void xj(int i) {
        this.hf = i;
    }

    public static ne xj(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        ne neVar = new ne();
        try {
            neVar.xj(jSONObject.optInt("wc_skip_type"));
            neVar.xj(jSONObject.optString("wc_miniapp_link"));
            neVar.hf(jSONObject.optString("adv_id"));
            neVar.w(jSONObject.optString("site_id"));
            neVar.w(jSONObject.optInt("wc_open_method"));
            neVar.u(jSONObject.optString("wc_miniapp_sdk"));
            neVar.kd(jSONObject.optString("wc_appid"));
            return neVar;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.pl.hf("parse WechatData failed:" + th.getMessage());
            return neVar;
        }
    }
}
