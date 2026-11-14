package com.bytedance.sdk.openadsdk.core.pz;

import com.bytedance.sdk.openadsdk.core.j;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class kd implements com.bytedance.sdk.openadsdk.am.w {
    j xj;

    public kd(j jVar) {
        this.xj = jVar;
    }

    @Override // com.bytedance.sdk.openadsdk.am.w
    public void xj(String str, JSONObject jSONObject) {
        j jVar = this.xj;
        if (jVar != null) {
            jVar.xj(str, jSONObject);
        }
    }
}
