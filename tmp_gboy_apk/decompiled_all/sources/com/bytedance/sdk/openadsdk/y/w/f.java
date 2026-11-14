package com.bytedance.sdk.openadsdk.y.w;

import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class f implements u {
    private long hf;
    private Map<String, Object> u;
    private int w;
    private long xj;

    @Override // com.bytedance.sdk.openadsdk.y.w.u
    public void a_(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        Map<String, Object> map = this.u;
        if (map != null) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                try {
                    jSONObject.put(entry.getKey(), entry.getValue());
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.pl.xj(th);
                }
            }
        }
        try {
            jSONObject.put("buffers_time", this.xj);
            jSONObject.put("total_duration", this.hf);
            jSONObject.put("vbtt_skip_type", this.w);
        } catch (Throwable th2) {
            com.bytedance.sdk.component.utils.pl.xj(th2);
        }
    }

    public void hf(long j) {
        this.hf = j;
    }

    public void xj(int i) {
        this.w = i;
    }

    public void xj(long j) {
        this.xj = j;
    }

    public void xj(Map<String, Object> map) {
        this.u = map;
    }
}
