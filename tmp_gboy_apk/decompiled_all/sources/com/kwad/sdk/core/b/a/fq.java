package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class fq implements com.kwad.sdk.core.d<com.kwad.sdk.core.webview.b.a.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.webview.b.a.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.webview.b.a.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.core.webview.b.a.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.aSr = jSONObject.optString("Access-Control-Allow-Origin");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(aVar.aSr)) {
            aVar.aSr = "";
        }
        aVar.aSs = jSONObject.optString("Timing-Allow-Origin");
        if (obj.toString().equals(aVar.aSs)) {
            aVar.aSs = "";
        }
        aVar.aSt = jSONObject.optString("content-type");
        if (obj.toString().equals(aVar.aSt)) {
            aVar.aSt = "";
        }
        aVar.aSu = jSONObject.optString("Date");
        if (obj.toString().equals(aVar.aSu)) {
            aVar.aSu = "";
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.core.webview.b.a.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = aVar.aSr;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "Access-Control-Allow-Origin", aVar.aSr);
        }
        String str2 = aVar.aSs;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "Timing-Allow-Origin", aVar.aSs);
        }
        String str3 = aVar.aSt;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "content-type", aVar.aSt);
        }
        String str4 = aVar.aSu;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "Date", aVar.aSu);
        }
        return jSONObject;
    }
}
