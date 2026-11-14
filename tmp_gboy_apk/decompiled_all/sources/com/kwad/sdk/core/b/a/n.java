package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class n implements com.kwad.sdk.core.d<com.kwad.sdk.commercial.d.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.commercial.d.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.commercial.d.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.commercial.d.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.methodName = jSONObject.optString("method_name");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(bVar.methodName)) {
            bVar.methodName = "";
        }
        bVar.aAB = jSONObject.optBoolean("is_convert");
        bVar.adNum = jSONObject.optInt("ad_num");
        bVar.aAC = jSONObject.optBoolean("is_api_native");
        bVar.aAD = jSONObject.optString("ad_request_type");
        if (obj.toString().equals(bVar.aAD)) {
            bVar.aAD = "";
        }
        bVar.adSource = jSONObject.optString("ad_require_source");
        if (obj.toString().equals(bVar.adSource)) {
            bVar.adSource = "";
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.commercial.d.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = bVar.methodName;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "method_name", bVar.methodName);
        }
        boolean z = bVar.aAB;
        if (z) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "is_convert", z);
        }
        int i = bVar.adNum;
        if (i != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "ad_num", i);
        }
        boolean z2 = bVar.aAC;
        if (z2) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "is_api_native", z2);
        }
        String str2 = bVar.aAD;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "ad_request_type", bVar.aAD);
        }
        String str3 = bVar.adSource;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "ad_require_source", bVar.adSource);
        }
        return jSONObject;
    }
}
