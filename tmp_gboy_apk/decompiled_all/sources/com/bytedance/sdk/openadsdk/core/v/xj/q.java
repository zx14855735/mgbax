package com.bytedance.sdk.openadsdk.core.v.xj;

import com.baidu.mobads.sdk.internal.cb;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class q extends com.bytedance.sdk.component.xj.kd<JSONObject, JSONObject> {
    private WeakReference<com.bytedance.sdk.openadsdk.core.ugeno.c.hf> hf;
    private com.bytedance.sdk.openadsdk.core.j xj;

    public q(com.bytedance.sdk.openadsdk.core.j jVar, WeakReference<com.bytedance.sdk.openadsdk.core.ugeno.c.hf> weakReference) {
        this.xj = jVar;
        this.hf = weakReference;
    }

    public static void xj(com.bytedance.sdk.component.xj.e eVar, com.bytedance.sdk.openadsdk.core.j jVar, WeakReference<com.bytedance.sdk.openadsdk.core.ugeno.c.hf> weakReference) {
        eVar.xj("resumeRewardCountDown", (com.bytedance.sdk.component.xj.kd<?, ?>) new q(jVar, weakReference));
    }

    @Override // com.bytedance.sdk.component.xj.kd
    public JSONObject xj(JSONObject jSONObject, com.bytedance.sdk.component.xj.y yVar) {
        JSONObject jSONObject2 = new JSONObject();
        WeakReference<com.bytedance.sdk.openadsdk.core.ugeno.c.hf> weakReference = this.hf;
        if (weakReference != null && weakReference.get() != null) {
            this.hf.get().hf();
            jSONObject2.put(cb.o, true);
            return jSONObject2;
        }
        jSONObject2.put(cb.o, false);
        return jSONObject2;
    }
}
