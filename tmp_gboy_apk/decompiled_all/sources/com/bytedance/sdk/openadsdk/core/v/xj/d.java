package com.bytedance.sdk.openadsdk.core.v.xj;

import com.bytedance.sdk.openadsdk.core.ra.ws;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class d extends com.bytedance.sdk.component.xj.kd<JSONObject, JSONObject> {
    private com.bytedance.sdk.openadsdk.core.j hf;
    private ws xj;

    public d(ws wsVar, com.bytedance.sdk.openadsdk.core.j jVar) {
        this.xj = wsVar;
        this.hf = jVar;
    }

    public static void xj(com.bytedance.sdk.component.xj.e eVar, ws wsVar, com.bytedance.sdk.openadsdk.core.j jVar) {
        eVar.xj("adViewInfo", (com.bytedance.sdk.component.xj.kd<?, ?>) new d(wsVar, jVar));
    }

    @Override // com.bytedance.sdk.component.xj.kd
    public JSONObject xj(JSONObject jSONObject, com.bytedance.sdk.component.xj.y yVar) {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("container", this.hf.xj());
        jSONObject2.put("creative", this.hf.hf());
        return jSONObject2;
    }
}
