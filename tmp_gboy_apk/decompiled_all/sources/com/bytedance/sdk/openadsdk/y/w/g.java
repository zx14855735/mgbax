package com.bytedance.sdk.openadsdk.y.w;

import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class g extends xj {
    private long hf;
    private long u;
    private long w;
    private String xj;

    @Override // com.bytedance.sdk.openadsdk.y.w.u
    public void a_(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("preload_url", this.xj);
            jSONObject.put("preload_size", this.hf);
            jSONObject.put("load_time", this.w);
            jSONObject.put("local_cache", this.u);
            xj(jSONObject);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.pl.xj(th);
        }
    }

    public void hf(long j) {
        this.w = j;
    }

    public void w(long j) {
        this.u = j;
    }

    public void xj(String str) {
        this.xj = str;
    }

    public void xj(long j) {
        this.hf = j;
    }
}
