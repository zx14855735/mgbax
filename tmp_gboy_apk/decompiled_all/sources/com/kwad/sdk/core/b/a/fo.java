package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class fo implements com.kwad.sdk.core.d<com.kwad.sdk.f.a.a.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.f.a.a.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.f.a.a.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.f.a.a.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.aWc = jSONObject.optInt("apiLevel");
        aVar.aWd = jSONObject.optInt("colorModeSupport");
        aVar.aWe = jSONObject.optInt("screenHdrAvailable");
        aVar.aWf = jSONObject.optInt("hdrSupport");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.f.a.a.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = aVar.aWc;
        if (i != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "apiLevel", i);
        }
        int i2 = aVar.aWd;
        if (i2 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "colorModeSupport", i2);
        }
        int i3 = aVar.aWe;
        if (i3 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "screenHdrAvailable", i3);
        }
        int i4 = aVar.aWf;
        if (i4 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "hdrSupport", i4);
        }
        return jSONObject;
    }
}
