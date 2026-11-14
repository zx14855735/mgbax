package com.bytedance.sdk.openadsdk.y.w;

import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class d implements u {
    private long hf;
    private int u;
    private int w;
    private long xj;

    @Override // com.bytedance.sdk.openadsdk.y.w.u
    public void a_(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("video_start_duration", this.xj);
            jSONObject.put("video_cache_size", this.hf);
            jSONObject.put("is_auto_play", this.w);
            jSONObject.put("is_supplement_replay", this.u);
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

    public void hf(int i) {
        this.w = i;
    }

    public void xj(int i) {
        this.u = i;
    }
}
