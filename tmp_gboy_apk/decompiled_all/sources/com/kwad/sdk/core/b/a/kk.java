package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class kk implements com.kwad.sdk.core.d<com.kwad.sdk.commercial.smallApp.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.commercial.smallApp.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.commercial.smallApp.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.commercial.smallApp.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.status = jSONObject.optInt("status");
        bVar.url = jSONObject.optString("url");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(bVar.url)) {
            bVar.url = "";
        }
        bVar.aAl = jSONObject.optString("url_host");
        if (obj.toString().equals(bVar.aAl)) {
            bVar.aAl = "";
        }
        bVar.aAs = jSONObject.optString("url_path");
        if (obj.toString().equals(bVar.aAs)) {
            bVar.aAs = "";
        }
        bVar.aAQ = jSONObject.optString("small_origin_id");
        if (obj.toString().equals(bVar.aAQ)) {
            bVar.aAQ = "";
        }
        bVar.aAR = jSONObject.optString("small_app_id");
        if (obj.toString().equals(bVar.aAR)) {
            bVar.aAR = "";
        }
        bVar.aAS = jSONObject.optString("jump_from");
        if (obj.toString().equals(bVar.aAS)) {
            bVar.aAS = "";
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.commercial.smallApp.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = bVar.status;
        if (i != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "status", i);
        }
        String str = bVar.url;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "url", bVar.url);
        }
        String str2 = bVar.aAl;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "url_host", bVar.aAl);
        }
        String str3 = bVar.aAs;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "url_path", bVar.aAs);
        }
        String str4 = bVar.aAQ;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "small_origin_id", bVar.aAQ);
        }
        String str5 = bVar.aAR;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "small_app_id", bVar.aAR);
        }
        String str6 = bVar.aAS;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "jump_from", bVar.aAS);
        }
        return jSONObject;
    }
}
