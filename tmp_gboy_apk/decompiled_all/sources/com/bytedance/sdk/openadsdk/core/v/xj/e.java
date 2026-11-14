package com.bytedance.sdk.openadsdk.core.v.xj;

import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class e extends com.bytedance.sdk.component.xj.kd<JSONObject, JSONObject> {
    private WeakReference<com.bytedance.sdk.openadsdk.core.j> xj;

    public e(com.bytedance.sdk.openadsdk.core.j jVar) {
        this.xj = new WeakReference<>(jVar);
    }

    public static void xj(com.bytedance.sdk.component.xj.e eVar, com.bytedance.sdk.openadsdk.core.j jVar) {
        eVar.xj("getSendRewardStatus", (com.bytedance.sdk.component.xj.kd<?, ?>) new e(jVar));
    }

    @Override // com.bytedance.sdk.component.xj.kd
    public JSONObject xj(JSONObject jSONObject, com.bytedance.sdk.component.xj.y yVar) {
        com.bytedance.sdk.openadsdk.core.j jVar;
        JSONObject jSONObject2 = new JSONObject();
        WeakReference<com.bytedance.sdk.openadsdk.core.j> weakReference = this.xj;
        if (weakReference != null && weakReference.get() != null && (jVar = this.xj.get()) != null) {
            jSONObject2.put("isReward", jVar.c());
        }
        return jSONObject2;
    }
}
