package com.bytedance.sdk.openadsdk.core.v.xj;

import com.bytedance.sdk.openadsdk.core.widget.c;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class a extends com.bytedance.sdk.component.xj.kd<JSONObject, JSONObject> {
    private c.xj xj;

    public a(c.xj xjVar) {
        this.xj = xjVar;
    }

    public JSONObject w() {
        return new JSONObject();
    }

    public static void xj(com.bytedance.sdk.component.xj.e eVar, c.xj xjVar) {
        eVar.xj("UgenDownloadDialogInteraction", (com.bytedance.sdk.component.xj.kd<?, ?>) new a(xjVar));
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
        int optInt = jSONObject.optInt("InteractionType");
        if (optInt == 1) {
            this.xj.w(null);
            return;
        }
        if (optInt == 2) {
            this.xj.xj(null);
            return;
        }
        if (optInt == 3) {
            this.xj.xj();
        } else if (optInt == 4) {
            this.xj.hf(null);
        } else {
            if (optInt != 5) {
                return;
            }
            this.xj.u(null);
        }
    }
}
