package com.bytedance.sdk.openadsdk.core.v.xj;

import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.sigmob.sdk.base.mta.PointParamKey;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class tf extends com.bytedance.sdk.component.xj.kd<JSONObject, JSONObject> {
    private List<JSONObject> hf;
    private ws xj;

    public tf(ws wsVar, List<JSONObject> list) {
        this.xj = wsVar;
        this.hf = list;
    }

    public static void xj(com.bytedance.sdk.component.xj.e eVar, ws wsVar, List<JSONObject> list) {
        eVar.xj("getAdsData", (com.bytedance.sdk.component.xj.kd<?, ?>) new tf(wsVar, list));
    }

    @Override // com.bytedance.sdk.component.xj.kd
    public JSONObject xj(JSONObject jSONObject, com.bytedance.sdk.component.xj.y yVar) {
        JSONObject jSONObject2 = new JSONObject();
        int optInt = jSONObject != null ? jSONObject.optInt("ads_num", 3) : -1;
        if (optInt < 0) {
            optInt = 3;
        }
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("creatives", new JSONArray().put(this.xj.ac()));
        jSONObject2.put("firstRes", jSONObject3);
        JSONArray jSONArray = new JSONArray();
        List<JSONObject> list = this.hf;
        if (list != null && list.size() > 0) {
            if (optInt > this.hf.size()) {
                optInt = this.hf.size();
            }
            int min = Math.min(optInt, 3);
            for (int i = 0; i < min; i++) {
                jSONArray.put(i, this.hf.get(i));
            }
        }
        JSONObject jSONObject4 = new JSONObject();
        jSONObject4.put("creatives", jSONArray);
        jSONObject2.put("secondRes", jSONObject4);
        JSONObject jSONObject5 = new JSONObject();
        jSONObject5.put(PointParamKey.DATA, jSONObject2);
        return jSONObject5;
    }
}
