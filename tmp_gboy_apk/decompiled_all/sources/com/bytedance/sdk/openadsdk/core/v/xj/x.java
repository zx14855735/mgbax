package com.bytedance.sdk.openadsdk.core.v.xj;

import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class x extends com.bytedance.sdk.component.xj.kd<JSONObject, JSONObject> {
    private com.bytedance.sdk.openadsdk.core.ugeno.hf xj;

    public x(com.bytedance.sdk.openadsdk.core.ugeno.hf hfVar) {
        this.xj = hfVar;
    }

    public JSONObject w() {
        return new JSONObject();
    }

    public static void xj(com.bytedance.sdk.component.xj.e eVar, com.bytedance.sdk.openadsdk.core.ugeno.hf hfVar) {
        eVar.xj("RendUgenDownloadDialogState", (com.bytedance.sdk.component.xj.kd<?, ?>) new x(hfVar));
    }

    @Override // com.bytedance.sdk.component.xj.kd
    public JSONObject xj(JSONObject jSONObject, com.bytedance.sdk.component.xj.y yVar) {
        xj(jSONObject);
        return w();
    }

    private void xj(JSONObject jSONObject) {
        if (jSONObject == null || this.xj == null) {
            return;
        }
        int optInt = jSONObject.optInt(PluginConstants.KEY_ERROR_CODE);
        if (optInt == 200) {
            this.xj.xj();
        } else {
            this.xj.xj(optInt, jSONObject.optString(MediationConstant.KEY_ERROR_MSG));
        }
    }
}
