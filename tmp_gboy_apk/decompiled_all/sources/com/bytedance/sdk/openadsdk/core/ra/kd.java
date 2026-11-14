package com.bytedance.sdk.openadsdk.core.ra;

import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class kd {
    private String c;
    private String hf;
    private int kd;
    private int u;
    private String w;
    private String xj;
    private int y;

    public int c() {
        return this.y;
    }

    public JSONObject f() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("app_name", w());
            jSONObject.put("app_size", c());
            jSONObject.put("comment_num", y());
            jSONObject.put("download_url", hf());
            jSONObject.put(com.sigmob.sdk.base.n.p, u());
            jSONObject.put("score", kd());
            return jSONObject;
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.pl.w(e.toString());
            return jSONObject;
        }
    }

    public String hf() {
        return this.xj;
    }

    public int kd() {
        return this.u;
    }

    public String u() {
        return this.w;
    }

    public String w() {
        return this.hf;
    }

    public String xj() {
        return this.c;
    }

    public int y() {
        return this.kd;
    }

    public void hf(String str) {
        this.xj = str;
    }

    public void u(String str) {
        this.w = str;
    }

    public void w(String str) {
        this.hf = str;
    }

    public void xj(String str) {
        this.c = str;
    }

    public void hf(int i) {
        this.kd = i;
    }

    public void w(int i) {
        this.y = i;
    }

    public void xj(int i) {
        this.u = i;
    }
}
