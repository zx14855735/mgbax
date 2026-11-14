package com.bytedance.sdk.openadsdk.d.xj;

import com.bytedance.sdk.component.xj.e;
import com.bytedance.sdk.openadsdk.core.j;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class y extends com.bytedance.sdk.component.xj.kd<JSONObject, JSONObject> {
    private WeakReference<j> xj;

    public y(j jVar) {
        this.xj = new WeakReference<>(jVar);
    }

    public static void xj(e eVar, j jVar) {
        eVar.xj("startVideoTransform", (com.bytedance.sdk.component.xj.kd<?, ?>) new y(jVar));
    }

    @Override // com.bytedance.sdk.component.xj.kd
    public JSONObject xj(JSONObject jSONObject, com.bytedance.sdk.component.xj.y yVar) {
        j jVar;
        JSONObject optJSONObject;
        JSONObject jSONObject2 = new JSONObject();
        WeakReference<j> weakReference = this.xj;
        if (weakReference != null && weakReference.get() != null && jSONObject != null && (jVar = this.xj.get()) != null && (optJSONObject = jSONObject.optJSONObject("videoInfo")) != null) {
            jVar.xj((float) optJSONObject.optDouble("toX"), (float) optJSONObject.optDouble("toY"), (float) optJSONObject.optDouble("pivotX"), (float) optJSONObject.optDouble("pivotY"), jSONObject.optInt(MediationConstant.EXTRA_DURATION));
        }
        return jSONObject2;
    }
}
