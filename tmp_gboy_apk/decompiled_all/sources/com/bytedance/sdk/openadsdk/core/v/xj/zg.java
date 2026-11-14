package com.bytedance.sdk.openadsdk.core.v.xj;

import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class zg extends com.bytedance.sdk.component.xj.kd<JSONObject, JSONObject> {
    private WeakReference<com.bytedance.sdk.openadsdk.core.j> xj;

    public zg(com.bytedance.sdk.openadsdk.core.j jVar) {
        this.xj = new WeakReference<>(jVar);
    }

    public static void xj(com.bytedance.sdk.component.xj.e eVar, com.bytedance.sdk.openadsdk.core.j jVar) {
        eVar.xj("getPlayTimeCurrent", (com.bytedance.sdk.component.xj.kd<?, ?>) new zg(jVar));
    }

    @Override // com.bytedance.sdk.component.xj.kd
    public JSONObject xj(JSONObject jSONObject, com.bytedance.sdk.component.xj.y yVar) {
        JSONObject jSONObject2 = new JSONObject();
        WeakReference<com.bytedance.sdk.openadsdk.core.j> weakReference = this.xj;
        if (weakReference != null && weakReference.get() != null) {
            com.bytedance.sdk.openadsdk.core.j jVar = this.xj.get();
            jSONObject2.put("currentTime", jVar != null ? jVar.j() : 0);
        }
        return jSONObject2;
    }
}
