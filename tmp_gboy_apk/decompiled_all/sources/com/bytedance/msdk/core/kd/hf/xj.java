package com.bytedance.msdk.core.kd.hf;

import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj {
    private int c;
    private int hf;
    private int kd;
    private String u;
    private String w;
    private int xj;
    private int y;

    public void hf(int i) {
        this.xj = i;
    }

    public void kd(int i) {
        this.y = i;
    }

    public void u(int i) {
        this.kd = i;
    }

    public void w(int i) {
        this.hf = i;
    }

    public String xj() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(MediationConstant.KEY_REASON, this.xj);
            jSONObject.put("fill_error_code", this.hf);
            jSONObject.put("fill_error_msg", this.w);
            jSONObject.put("mediation_rit", this.u);
            jSONObject.put("load_sort", this.kd);
            jSONObject.put("show_sort", this.y);
            jSONObject.put("has_shown", this.c);
            return jSONObject.toString();
        } catch (JSONException e) {
            pl.xj(e);
            return "{\"name\": \"json err\"}";
        }
    }

    public void hf(String str) {
        this.u = str;
    }

    public void xj(int i) {
        this.c = i;
    }

    public void xj(String str) {
        this.w = str;
    }
}
