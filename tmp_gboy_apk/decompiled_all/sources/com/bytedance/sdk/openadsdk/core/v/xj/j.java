package com.bytedance.sdk.openadsdk.core.v.xj;

import com.bytedance.sdk.openadsdk.core.ra.ws;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class j extends com.bytedance.sdk.component.xj.kd<JSONObject, JSONObject> {
    private ws xj;

    public j(ws wsVar) {
        this.xj = wsVar;
    }

    public static void xj(com.bytedance.sdk.component.xj.e eVar, ws wsVar) {
        eVar.xj("sendEventCode", (com.bytedance.sdk.component.xj.kd<?, ?>) new j(wsVar));
    }

    @Override // com.bytedance.sdk.component.xj.kd
    public JSONObject xj(JSONObject jSONObject, com.bytedance.sdk.component.xj.y yVar) {
        com.bytedance.sdk.openadsdk.zg.w.xj.hf hfVar;
        JSONObject jSONObject2 = new JSONObject();
        ws wsVar = this.xj;
        if (wsVar != null && (hfVar = (com.bytedance.sdk.openadsdk.zg.w.xj.hf) com.bytedance.sdk.openadsdk.core.ht.xj(wsVar.ke(), com.bytedance.sdk.openadsdk.zg.w.xj.hf.class)) != null) {
            HashMap hashMap = new HashMap();
            int optInt = jSONObject.optInt("event_code", -1);
            if (optInt >= 200) {
                JSONObject optJSONObject = jSONObject.optJSONObject("info");
                if (optJSONObject != null) {
                    Iterator<String> keys = optJSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        hashMap.put(next, optJSONObject.opt(next));
                    }
                }
                hfVar.xj(optInt, hashMap);
            }
        }
        return jSONObject2;
    }
}
