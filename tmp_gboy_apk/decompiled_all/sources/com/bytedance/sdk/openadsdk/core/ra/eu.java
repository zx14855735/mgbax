package com.bytedance.sdk.openadsdk.core.ra;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class eu {
    private long c;
    private int d;
    private long f;
    private int hf;
    private int kd;
    private int tf = 0;
    private int u;
    private int w;
    ws xj;
    private long y;

    public eu(ws wsVar) {
        this.xj = wsVar;
    }

    public void hf(int i) {
        this.w = i;
        if (i == 2) {
            this.kd++;
        }
    }

    public void u(int i) {
        this.d = i;
        this.f = System.currentTimeMillis();
    }

    public void w(int i) {
        this.u = i;
    }

    public void xj(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("ca_send_ts", this.xj.a());
            jSONObject.put("ca_bid_rst", this.u);
            jSONObject.put("ca_reuse_cnt", this.kd);
            jSONObject.put("ca_obj_ts", this.y);
            jSONObject.put("ca_fnl_st", this.d);
            jSONObject.put("ca_rpt_show_cnt", this.tf);
        } catch (JSONException unused) {
        }
    }

    public void w() {
        this.c = System.currentTimeMillis();
        this.tf++;
        u(1);
    }

    public void hf() {
        this.y = System.currentTimeMillis();
    }

    public eu(ws wsVar, JSONObject jSONObject) {
        this.xj = wsVar;
        if (jSONObject != null) {
            this.hf = jSONObject.optInt("req_type", 0);
            this.w = jSONObject.optInt("load_type", 0);
            this.u = jSONObject.optInt("bidding_result", 0);
            this.kd = jSONObject.optInt("reuse_count", 0);
            this.y = jSONObject.optLong("object_create_time", 0L);
            this.c = jSONObject.optLong("show_time", 0L);
            this.f = jSONObject.optLong("final_ts", 0L);
            this.d = jSONObject.optInt("final_status", 0);
        }
    }

    public JSONObject xj() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("req_type", this.hf);
            jSONObject.put("load_type", this.w);
            jSONObject.put("bidding_result", this.u);
            jSONObject.put("reuse_count", this.kd);
            jSONObject.put("object_create_time", this.y);
            jSONObject.put("show_time", this.c);
            jSONObject.put("final_ts", this.f);
            jSONObject.put("final_status", this.d);
            jSONObject.put("show_count", this.tf);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public void xj(int i) {
        this.hf = i;
    }
}
