package com.bytedance.sdk.openadsdk.y.w;

import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class am implements u {
    public int hf;
    public long w;
    public long xj;

    @Override // com.bytedance.sdk.openadsdk.y.w.u
    public void a_(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("buffers_time", this.xj);
            jSONObject.put("buffers_count", this.hf);
            jSONObject.put("total_duration", this.w);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.pl.xj(th);
        }
    }

    public void hf(long j) {
        this.w = j;
    }

    public void xj(long j) {
        this.xj = j;
    }

    public void xj(int i) {
        this.hf = i;
    }
}
