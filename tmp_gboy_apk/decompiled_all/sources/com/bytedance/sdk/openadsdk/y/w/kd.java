package com.bytedance.sdk.openadsdk.y.w;

import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class kd implements u {
    public long hf;
    private int kd;
    public int u = 0;
    public int w;
    public long xj;

    @Override // com.bytedance.sdk.openadsdk.y.w.u
    public void a_(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("total_duration", this.xj);
            jSONObject.put("buffers_time", this.hf);
            jSONObject.put("break_reason", this.w);
            jSONObject.put("video_backup", this.u);
            jSONObject.put("vbtt_skip_type", this.kd);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.pl.xj(th);
        }
    }

    public void hf(long j) {
        this.hf = j;
    }

    public void w(int i) {
        this.u = i;
    }

    public void xj(int i) {
        this.kd = i;
    }

    public void hf(int i) {
        this.w = i;
    }

    public void xj(long j) {
        this.xj = j;
    }
}
