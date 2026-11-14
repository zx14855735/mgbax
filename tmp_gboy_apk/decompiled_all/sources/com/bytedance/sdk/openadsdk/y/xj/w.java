package com.bytedance.sdk.openadsdk.y.xj;

import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class w implements hf {
    hf xj;

    @Override // com.bytedance.sdk.openadsdk.y.xj.hf
    public void xj(JSONObject jSONObject) {
        hf hfVar = this.xj;
        if (hfVar != null) {
            hfVar.xj(jSONObject);
        }
        jSONObject.put("event_ts", System.currentTimeMillis());
    }
}
