package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class dy implements com.kwad.sdk.core.d<com.kwad.components.ad.draw.a.d> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.ad.draw.a.d dVar, JSONObject jSONObject) {
        a2(dVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.ad.draw.a.d dVar, JSONObject jSONObject) {
        return b2(dVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.components.ad.draw.a.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        dVar.status = jSONObject.optInt("status");
        dVar.materialType = jSONObject.optInt("material_type");
        dVar.materialUrl = jSONObject.optString("material_url");
        if (JSONObject.NULL.toString().equals(dVar.materialUrl)) {
            dVar.materialUrl = "";
        }
        dVar.dy = jSONObject.optLong("resource_load_time_ms");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.components.ad.draw.a.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = dVar.status;
        if (i != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "status", i);
        }
        int i2 = dVar.materialType;
        if (i2 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "material_type", i2);
        }
        String str = dVar.materialUrl;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "material_url", dVar.materialUrl);
        }
        long j = dVar.dy;
        if (j != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "resource_load_time_ms", j);
        }
        return jSONObject;
    }
}
