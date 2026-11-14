package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class id implements com.kwad.sdk.core.d<com.kwad.sdk.core.request.model.d> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.request.model.d dVar, JSONObject jSONObject) {
        a2(dVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.request.model.d dVar, JSONObject jSONObject) {
        return b2(dVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.core.request.model.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        dVar.aNn = jSONObject.optString("mac");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(dVar.aNn)) {
            dVar.aNn = "";
        }
        dVar.aNo = jSONObject.optString("kMac");
        if (obj.toString().equals(dVar.aNo)) {
            dVar.aNo = "";
        }
        dVar.aNp = jSONObject.optInt("connectionType");
        dVar.operatorType = jSONObject.optInt("operatorType");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.core.request.model.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = dVar.aNn;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "mac", dVar.aNn);
        }
        String str2 = dVar.aNo;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "kMac", dVar.aNo);
        }
        int i = dVar.aNp;
        if (i != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "connectionType", i);
        }
        int i2 = dVar.operatorType;
        if (i2 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "operatorType", i2);
        }
        return jSONObject;
    }
}
