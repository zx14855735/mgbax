package com.bytedance.sdk.openadsdk.core.v.xj;

import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class p extends com.bytedance.sdk.component.xj.kd<JSONObject, JSONObject> {
    private WeakReference<com.bytedance.sdk.openadsdk.core.j> xj;

    public p(com.bytedance.sdk.openadsdk.core.j jVar) {
        this.xj = new WeakReference<>(jVar);
    }

    public JSONObject w() {
        com.bytedance.sdk.openadsdk.core.j jVar;
        JSONObject jSONObject = new JSONObject();
        try {
            WeakReference<com.bytedance.sdk.openadsdk.core.j> weakReference = this.xj;
            if (weakReference != null && (jVar = weakReference.get()) != null) {
                return jVar.et();
            }
            return jSONObject;
        } catch (Throwable unused) {
            return jSONObject;
        }
    }

    public static void xj(com.bytedance.sdk.component.xj.e eVar, com.bytedance.sdk.openadsdk.core.j jVar) {
        eVar.xj("getAppManage", (com.bytedance.sdk.component.xj.kd<?, ?>) new p(jVar));
    }

    @Override // com.bytedance.sdk.component.xj.kd
    public JSONObject xj(JSONObject jSONObject, com.bytedance.sdk.component.xj.y yVar) {
        return w();
    }
}
