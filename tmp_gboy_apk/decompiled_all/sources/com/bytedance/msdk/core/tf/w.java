package com.bytedance.msdk.core.tf;

import android.text.TextUtils;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class w {
    private double c;
    private String hf;
    private String kd;
    private int u;
    private String w;
    private String xj;
    private double y;

    public w(String str, String str2, String str3, int i, String str4, double d, double d2) {
        this.xj = str;
        this.hf = str2;
        this.w = str3;
        this.u = i;
        this.kd = str4;
        this.y = d;
        this.c = d2;
    }

    public String hf() {
        return this.w;
    }

    public double kd() {
        return this.y;
    }

    public String u() {
        return this.kd;
    }

    public int w() {
        return this.u;
    }

    public String xj() {
        return this.hf;
    }

    public double y() {
        return this.c;
    }

    public static w xj(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str) || jSONObject == null) {
            return null;
        }
        return new w(str, jSONObject.optString("label_name"), jSONObject.optString("timestamp"), jSONObject.optInt("label_id"), jSONObject.optString("label_version"), jSONObject.optDouble("upper_bound"), jSONObject.optDouble("lower_bound"));
    }
}
