package com.bytedance.sdk.openadsdk.core.v.xj;

import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class ff extends com.bytedance.sdk.component.xj.kd<JSONObject, JSONObject> {
    private com.bytedance.sdk.openadsdk.core.j xj;

    public ff(com.bytedance.sdk.openadsdk.core.j jVar) {
        this.xj = jVar;
    }

    public JSONObject w() {
        JSONObject jSONObject = new JSONObject();
        com.bytedance.sdk.openadsdk.core.j jVar = this.xj;
        if (jVar != null) {
            return jVar.p();
        }
        try {
            jSONObject.put(PluginConstants.KEY_ERROR_CODE, -1);
            jSONObject.put("codeMsg", "JsObject is null");
            return jSONObject;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public static void xj(com.bytedance.sdk.component.xj.e eVar, com.bytedance.sdk.openadsdk.core.j jVar) {
        eVar.xj("ShowUgenDownloadDialog", (com.bytedance.sdk.component.xj.kd<?, ?>) new ff(jVar));
    }

    @Override // com.bytedance.sdk.component.xj.kd
    public JSONObject xj(JSONObject jSONObject, com.bytedance.sdk.component.xj.y yVar) {
        return w();
    }
}
