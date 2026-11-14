package com.bytedance.sdk.openadsdk.y.w;

import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class w implements u {
    private int c;
    private long hf;
    private long kd;
    private int u;
    private int w;
    private long xj;
    private long y;

    @Override // com.bytedance.sdk.openadsdk.y.w.u
    public void a_(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("buffers_time", this.xj);
            jSONObject.put("total_duration", this.hf);
            jSONObject.put("vbtt_skip_type", this.w);
            jSONObject.put("skip_reason", this.u);
            jSONObject.put("video_cache_size", this.kd);
            jSONObject.put("current", this.y);
            jSONObject.put("percent", this.c);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.pl.xj(th);
        }
    }

    public void hf(long j) {
        this.kd = j;
    }

    public void u(long j) {
        this.hf = j;
    }

    public void w(long j) {
        this.xj = j;
    }

    public void xj(long j) {
        this.y = j;
    }

    public void hf(int i) {
        this.w = i;
    }

    public void w(int i) {
        this.u = i;
    }

    public void xj(int i) {
        this.c = i;
    }
}
