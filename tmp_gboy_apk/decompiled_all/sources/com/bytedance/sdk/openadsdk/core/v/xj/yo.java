package com.bytedance.sdk.openadsdk.core.v.xj;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class yo extends com.bytedance.sdk.component.xj.kd<JSONObject, JSONObject> {
    private com.bytedance.sdk.openadsdk.core.j hf;
    private ws u;
    private Context w;
    private String xj;

    public yo(String str, com.bytedance.sdk.openadsdk.core.j jVar, Context context, ws wsVar) {
        this.xj = str;
        this.hf = jVar;
        this.w = context;
        this.u = wsVar;
    }

    public static void xj(com.bytedance.sdk.component.xj.e eVar, com.bytedance.sdk.openadsdk.core.j jVar, Context context, ws wsVar) {
        eVar.xj("supportHaptic", (com.bytedance.sdk.component.xj.kd<?, ?>) new yo("supportHaptic", jVar, context, wsVar));
        eVar.xj("playHaptic", (com.bytedance.sdk.component.xj.kd<?, ?>) new yo("playHaptic", jVar, context, wsVar));
        eVar.xj("stopHaptic", (com.bytedance.sdk.component.xj.kd<?, ?>) new yo("stopHaptic", jVar, context, wsVar));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.bytedance.sdk.component.xj.kd
    public JSONObject xj(JSONObject jSONObject, com.bytedance.sdk.component.xj.y yVar) {
        JSONObject jSONObject2;
        jSONObject2 = new JSONObject();
        String str = this.xj;
        str.getClass();
        switch (str) {
            case "stopHaptic":
                Context context = this.w;
                if (context != null) {
                    com.bytedance.sdk.openadsdk.core.ugeno.component.interact.xj.w.hf(context);
                }
                return jSONObject2;
            case "supportHaptic":
                Context context2 = this.w;
                jSONObject2.put("supportHaptic", context2 != null ? com.bytedance.sdk.openadsdk.core.ugeno.component.interact.xj.w.xj(context2) : false);
                return jSONObject2;
            case "playHaptic":
                com.bytedance.sdk.openadsdk.core.ugeno.component.interact.xj.w.xj(jSONObject, this.w, this.u);
                return jSONObject2;
            default:
                return jSONObject2;
        }
    }
}
