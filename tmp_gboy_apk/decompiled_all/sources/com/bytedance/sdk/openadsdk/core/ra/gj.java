package com.bytedance.sdk.openadsdk.core.ra;

import android.text.TextUtils;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class gj {
    private String hf;
    private String kd;
    private String u;
    private String w;
    private String xj;
    private String y;

    public gj(String str, String str2, String str3, String str4) {
        this.xj = str3;
        this.hf = str2;
        this.u = str;
        this.w = str4;
    }

    public String hf() {
        return this.xj;
    }

    public String toString() {
        JSONObject w = w();
        return w.length() > 0 ? w.toString() : "";
    }

    public JSONObject w() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("tk", this.xj).put("vd", this.u).put("cr", this.w).put("err", this.hf);
            if (!TextUtils.isEmpty(this.w) && this.w.equals("2")) {
                if (!TextUtils.isEmpty(this.kd)) {
                    jSONObject.put("i6", this.kd);
                }
                if (!TextUtils.isEmpty(this.y)) {
                    jSONObject.put("prov", this.y);
                }
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public void xj(String str, String str2, String str3, String str4) {
        this.xj = str3;
        this.hf = str2;
        this.u = str;
        this.w = str4;
    }

    public void hf(String str) {
        this.y = str;
    }

    public String xj() {
        return this.hf;
    }

    public void xj(String str) {
        this.kd = str;
    }
}
