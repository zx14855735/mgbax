package com.bytedance.sdk.openadsdk.core.v.xj;

import com.sigmob.sdk.base.n;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class kd extends com.bytedance.sdk.component.xj.kd<JSONObject, JSONObject> {
    private WeakReference<com.bytedance.sdk.openadsdk.core.j> xj;

    public kd(com.bytedance.sdk.openadsdk.core.j jVar) {
        this.xj = new WeakReference<>(jVar);
    }

    public static void xj(com.bytedance.sdk.component.xj.e eVar, com.bytedance.sdk.openadsdk.core.j jVar) {
        eVar.xj("changePlaySpeedRatio", (com.bytedance.sdk.component.xj.kd<?, ?>) new kd(jVar));
    }

    @Override // com.bytedance.sdk.component.xj.kd
    public JSONObject xj(JSONObject jSONObject, com.bytedance.sdk.component.xj.y yVar) {
        WeakReference<com.bytedance.sdk.openadsdk.core.j> weakReference = this.xj;
        if (weakReference != null && weakReference.get() != null) {
            float optDouble = (float) jSONObject.optDouble(n.C);
            if (optDouble > 0.0f && optDouble <= 3.0f) {
                this.xj.get().xj(optDouble);
            }
            return new JSONObject();
        }
        return new JSONObject();
    }
}
