package com.bytedance.sdk.openadsdk.y.w;

import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class pl extends xj {
    private long hf;
    private String xj;

    public pl(String str, long j) {
        this.xj = str;
        this.hf = j;
    }

    @Override // com.bytedance.sdk.openadsdk.y.w.u
    public void a_(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("preload_url", this.xj);
            jSONObject.put("preload_size", this.hf);
            com.bykv.vk.openvk.component.video.api.w.u xj = xj();
            if (xj != null) {
                jSONObject.put("run_task_mills", xj.xj().optLong("run_task_mills"));
            }
            xj(jSONObject);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.pl.xj(th);
        }
    }
}
