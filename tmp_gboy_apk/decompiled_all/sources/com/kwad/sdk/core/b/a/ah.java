package com.kwad.sdk.core.b.a;

import J3FDQU.A2egSU;
import com.czhj.sdk.common.Constants;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class ah implements com.kwad.sdk.core.d<com.kwad.sdk.core.adlog.b.d> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.adlog.b.d dVar, JSONObject jSONObject) {
        a2(dVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.adlog.b.d dVar, JSONObject jSONObject) {
        return b2(dVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.core.adlog.b.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        dVar.status = jSONObject.optInt("status");
        dVar.aAO = jSONObject.optString("final_url");
        if (JSONObject.NULL.toString().equals(dVar.aAO)) {
            dVar.aAO = "";
        }
        dVar.aAV = jSONObject.optInt("ad_action_type");
        dVar.aCk = A2egSU.A5SV6n(Constants.FAIL, "cache_type", jSONObject);
        dVar.retryCount = A2egSU.A5SV6n(Constants.FAIL, "retry_count", jSONObject);
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.core.adlog.b.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = dVar.status;
        if (i != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "status", i);
        }
        String str = dVar.aAO;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "final_url", dVar.aAO);
        }
        int i2 = dVar.aAV;
        if (i2 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "ad_action_type", i2);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "cache_type", dVar.aCk);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "retry_count", dVar.retryCount);
        return jSONObject;
    }
}
