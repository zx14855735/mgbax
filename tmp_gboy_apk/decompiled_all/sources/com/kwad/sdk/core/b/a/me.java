package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class me implements com.kwad.sdk.core.d<com.kwad.sdk.core.request.model.g> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.request.model.g gVar, JSONObject jSONObject) {
        a2(gVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.request.model.g gVar, JSONObject jSONObject) {
        return b2(gVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.core.request.model.g gVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        gVar.aNx = jSONObject.optString("thirdUserId");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(gVar.aNx)) {
            gVar.aNx = "";
        }
        gVar.aNy = jSONObject.optString("thirdUserName");
        if (obj.toString().equals(gVar.aNy)) {
            gVar.aNy = "";
        }
        gVar.thirdAge = jSONObject.optInt("thirdAge");
        gVar.thirdGender = jSONObject.optInt("thirdGender");
        gVar.thirdInterest = jSONObject.optString("thirdInterest");
        if (obj.toString().equals(gVar.thirdInterest)) {
            gVar.thirdInterest = "";
        }
        gVar.aNz = jSONObject.optString("authCode");
        if (obj.toString().equals(gVar.aNz)) {
            gVar.aNz = "";
        }
        gVar.serviceToken = jSONObject.optString("serviceToken");
        if (obj.toString().equals(gVar.serviceToken)) {
            gVar.serviceToken = "";
        }
        gVar.aNA = jSONObject.optString("authAppId");
        if (obj.toString().equals(gVar.aNA)) {
            gVar.aNA = "";
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.core.request.model.g gVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = gVar.aNx;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "thirdUserId", gVar.aNx);
        }
        String str2 = gVar.aNy;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "thirdUserName", gVar.aNy);
        }
        int i = gVar.thirdAge;
        if (i != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "thirdAge", i);
        }
        int i2 = gVar.thirdGender;
        if (i2 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "thirdGender", i2);
        }
        String str3 = gVar.thirdInterest;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "thirdInterest", gVar.thirdInterest);
        }
        String str4 = gVar.aNz;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "authCode", gVar.aNz);
        }
        String str5 = gVar.serviceToken;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "serviceToken", gVar.serviceToken);
        }
        String str6 = gVar.aNA;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "authAppId", gVar.aNA);
        }
        return jSONObject;
    }
}
