package com.bytedance.sdk.openadsdk.y.w;

import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class c implements u {
    private long hf;
    private int w = 0;
    private long xj;

    @Override // com.bytedance.sdk.openadsdk.y.w.u
    public void a_(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("total_duration", this.xj);
            jSONObject.put("buffers_time", this.hf);
            jSONObject.put("video_backup", this.w);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.pl.xj(th);
        }
    }

    public void hf(long j) {
        this.hf = j;
    }

    public void xj(long j) {
        this.xj = j;
    }

    public void xj(int i) {
        this.w = i;
    }
}
