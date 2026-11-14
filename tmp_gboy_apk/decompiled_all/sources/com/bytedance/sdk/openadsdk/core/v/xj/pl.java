package com.bytedance.sdk.openadsdk.core.v.xj;

import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class pl extends com.bytedance.sdk.component.xj.kd<JSONObject, JSONObject> {
    private JSONObject xj;

    public pl(JSONObject jSONObject) {
        this.xj = jSONObject;
    }

    public static void xj(com.bytedance.sdk.component.xj.e eVar, JSONObject jSONObject) {
        eVar.xj("getData", (com.bytedance.sdk.component.xj.kd<?, ?>) new pl(jSONObject));
    }

    @Override // com.bytedance.sdk.component.xj.kd
    public JSONObject xj(JSONObject jSONObject, com.bytedance.sdk.component.xj.y yVar) {
        return com.bytedance.sdk.openadsdk.core.nativeexpress.hf.hf.xj(this.xj, jSONObject);
    }
}
