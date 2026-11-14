package com.bytedance.sdk.openadsdk.y.w;

import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class qt implements u {
    private int c;
    private long d;
    private long f;
    private long hf;
    private String kd;
    private boolean p;
    private int tf;
    private int u;
    private int w;
    private long xj;
    private JSONArray y;

    @Override // com.bytedance.sdk.openadsdk.y.w.u
    public void a_(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("buffers_time", this.xj);
            jSONObject.put("total_duration", this.hf);
            jSONObject.put("error_code", this.w);
            jSONObject.put("extra_error_code", this.u);
            jSONObject.put("error_message", this.kd);
            jSONObject.put("event_list", this.y);
            jSONObject.put("vbtt_skip_type", this.c);
            jSONObject.put("video_cache_size", this.f);
            jSONObject.put("current", this.d);
            jSONObject.put("percent", this.tf);
            jSONObject.put("has_endcard_skip", this.p);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.pl.xj(th);
        }
    }

    public void hf(long j) {
        this.f = j;
    }

    public void u(long j) {
        this.hf = j;
    }

    public void w(long j) {
        this.xj = j;
    }

    public void xj(boolean z) {
        this.p = z;
    }

    public void hf(int i) {
        this.c = i;
    }

    public void u(int i) {
        this.u = i;
    }

    public void w(int i) {
        this.w = i;
    }

    public void xj(long j) {
        this.d = j;
    }

    public void xj(int i) {
        this.tf = i;
    }

    public void xj(JSONArray jSONArray) {
        this.y = jSONArray;
    }

    public void xj(String str) {
        this.kd = str;
    }
}
