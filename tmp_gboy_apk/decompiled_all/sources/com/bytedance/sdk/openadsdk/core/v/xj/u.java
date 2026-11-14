package com.bytedance.sdk.openadsdk.core.v.xj;

import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class u extends com.bytedance.sdk.component.xj.kd<JSONObject, JSONObject> {
    private com.bytedance.sdk.openadsdk.core.j xj;

    public u(com.bytedance.sdk.openadsdk.core.j jVar) {
        this.xj = jVar;
    }

    public static void xj(com.bytedance.sdk.component.xj.e eVar, com.bytedance.sdk.openadsdk.core.j jVar) {
        eVar.xj("businessStatusNotify", (com.bytedance.sdk.component.xj.kd<?, ?>) new u(jVar));
    }

    @Override // com.bytedance.sdk.component.xj.kd
    public JSONObject xj(JSONObject jSONObject, com.bytedance.sdk.component.xj.y yVar) {
        com.bytedance.sdk.openadsdk.core.j jVar;
        JSONObject jSONObject2 = new JSONObject();
        if (jSONObject != null && (jVar = this.xj) != null) {
            jVar.ff();
        }
        return jSONObject2;
    }
}
