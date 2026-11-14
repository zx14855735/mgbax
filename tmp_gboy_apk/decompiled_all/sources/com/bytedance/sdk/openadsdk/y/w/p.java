package com.bytedance.sdk.openadsdk.y.w;

import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class p extends xj {
    private long hf;
    private String kd;
    private int u;
    private long w;
    private String xj;
    private String y;

    @Override // com.bytedance.sdk.openadsdk.y.w.u
    public void a_(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("preload_url", this.xj);
            jSONObject.put("preload_size", this.hf);
            jSONObject.put("load_time", this.w);
            jSONObject.put("error_code", this.u);
            jSONObject.put("error_message", this.kd);
            jSONObject.put("error_message_server", this.y);
            xj(jSONObject);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.pl.xj(th);
        }
    }

    public void hf(long j) {
        this.w = j;
    }

    public void w(String str) {
        this.y = str;
    }

    public void xj(String str) {
        this.xj = str;
    }

    public void hf(String str) {
        this.kd = str;
    }

    public void xj(long j) {
        this.hf = j;
    }

    public void xj(int i) {
        this.u = i;
    }
}
