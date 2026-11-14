package com.bytedance.sdk.openadsdk.d.xj;

import com.bytedance.sdk.component.xj.e;
import com.bytedance.sdk.openadsdk.core.j;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class w extends com.bytedance.sdk.component.xj.kd<JSONObject, JSONObject> {
    private WeakReference<j> xj;

    public w(j jVar) {
        this.xj = new WeakReference<>(jVar);
    }

    public static void xj(e eVar, j jVar) {
        eVar.xj("rewardPlayAgain", (com.bytedance.sdk.component.xj.kd<?, ?>) new w(jVar));
    }

    @Override // com.bytedance.sdk.component.xj.kd
    public JSONObject xj(JSONObject jSONObject, com.bytedance.sdk.component.xj.y yVar) {
        j jVar;
        JSONObject jSONObject2 = new JSONObject();
        WeakReference<j> weakReference = this.xj;
        if (weakReference != null && weakReference.get() != null && (jVar = this.xj.get()) != null) {
            jVar.yo();
        }
        return jSONObject2;
    }
}
