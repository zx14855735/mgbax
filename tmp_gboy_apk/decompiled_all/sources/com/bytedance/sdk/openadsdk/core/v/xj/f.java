package com.bytedance.sdk.openadsdk.core.v.xj;

import com.bytedance.sdk.openadsdk.core.ra.ws;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class f extends com.bytedance.sdk.component.xj.kd<JSONObject, JSONObject> {
    private com.bytedance.sdk.openadsdk.core.j hf;
    private String w;
    private ws xj;

    public f(ws wsVar, com.bytedance.sdk.openadsdk.core.j jVar, String str) {
        this.xj = wsVar;
        this.hf = jVar;
        this.w = str;
    }

    public static void xj(com.bytedance.sdk.component.xj.e eVar, ws wsVar, com.bytedance.sdk.openadsdk.core.j jVar) {
        eVar.xj("getEstimatedInteractionAreaInfo", (com.bytedance.sdk.component.xj.kd<?, ?>) new f(wsVar, jVar, "getEstimatedInteractionAreaInfo"));
        eVar.xj("interactionAreaInfo", (com.bytedance.sdk.component.xj.kd<?, ?>) new f(wsVar, jVar, "interactionAreaInfo"));
    }

    @Override // com.bytedance.sdk.component.xj.kd
    public JSONObject xj(JSONObject jSONObject, com.bytedance.sdk.component.xj.y yVar) {
        com.bytedance.sdk.openadsdk.core.ra.qt qtVar;
        com.bytedance.sdk.openadsdk.core.ra.qt qtVar2;
        JSONObject jSONObject2;
        com.bytedance.sdk.openadsdk.core.ugeno.component.interact.d w = this.hf.w();
        String str = this.w;
        str.getClass();
        if (str.equals("interactionAreaInfo")) {
            JSONArray optJSONArray = jSONObject.optJSONArray("areas");
            if (optJSONArray == null || optJSONArray.length() <= 0 || (jSONObject2 = optJSONArray.getJSONObject(0)) == null) {
                qtVar = null;
                qtVar2 = null;
            } else {
                qtVar = com.bytedance.sdk.openadsdk.core.ra.qt.xj(jSONObject2);
                if (w != null) {
                    w.setEasyPlayInteractionAreaInfo(qtVar);
                    qtVar2 = com.bytedance.sdk.openadsdk.core.ra.qt.xj(w.getEstimatedInteractionAreaInfo());
                } else {
                    qtVar2 = null;
                }
            }
            if (qtVar2 == null) {
                if (w != null) {
                    w.xj(com.bytedance.sdk.openadsdk.core.ra.qt.hf(null, qtVar), 1.0d);
                    this.hf.xj("canMakeVisiable", (JSONObject) null);
                }
            } else if (qtVar == null) {
                w.xj(null, -1.0d);
                w.w();
                this.hf.xj("expressWebviewRecycle", (JSONObject) null);
            } else {
                double xj = com.bytedance.sdk.openadsdk.core.ra.qt.xj(qtVar2, qtVar);
                double d = qtVar.w * qtVar.u;
                double d2 = qtVar2.w * qtVar2.u;
                if (d2 == 0.0d) {
                    w.xj(com.bytedance.sdk.openadsdk.core.ra.qt.hf(qtVar2, qtVar), 1.0d);
                    this.hf.xj("canMakeVisiable", (JSONObject) null);
                    return null;
                }
                if (d == 0.0d) {
                    w.xj(null, -1.0d);
                    w.w();
                    this.hf.xj("expressWebviewRecycle", (JSONObject) null);
                    return null;
                }
                double d3 = xj / d;
                boolean z = d3 >= 0.8d;
                com.bytedance.sdk.component.utils.pl.xj("xeasy", "A:" + d2 + " B:" + d + " o:" + xj + " R:" + d3);
                if (!z) {
                    w.xj(null, -1.0d);
                    w.w();
                    this.hf.xj("expressWebviewRecycle", (JSONObject) null);
                    return null;
                }
                w.xj(com.bytedance.sdk.openadsdk.core.ra.qt.hf(qtVar2, qtVar), (xj - d2) / d2);
                this.hf.xj("canMakeVisiable", (JSONObject) null);
                return null;
            }
        } else if (str.equals("getEstimatedInteractionAreaInfo") && w != null) {
            return w.getEstimatedInteractionAreaInfo();
        }
        return null;
    }
}
