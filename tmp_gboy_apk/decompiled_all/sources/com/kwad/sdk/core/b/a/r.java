package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class r implements com.kwad.sdk.core.d<com.kwad.sdk.commercial.e.c> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.commercial.e.c cVar, JSONObject jSONObject) {
        a2(cVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.commercial.e.c cVar, JSONObject jSONObject) {
        return b2(cVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.commercial.e.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        cVar.aAH = jSONObject.optString("imp_ad_info");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(cVar.aAH)) {
            cVar.aAH = "";
        }
        cVar.aAI = jSONObject.optString("final_imp_ad_info");
        if (obj.toString().equals(cVar.aAI)) {
            cVar.aAI = "";
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.commercial.e.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = cVar.aAH;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "imp_ad_info", cVar.aAH);
        }
        String str2 = cVar.aAI;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "final_imp_ad_info", cVar.aAI);
        }
        return jSONObject;
    }
}
