package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class il implements com.kwad.sdk.core.d<com.kwad.sdk.h.a.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.h.a.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.h.a.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.h.a.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.aWm = jSONObject.optString("packageId");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(bVar.aWm)) {
            bVar.aWm = "";
        }
        bVar.aWn = jSONObject.optString("zipFileName");
        if (obj.toString().equals(bVar.aWn)) {
            bVar.aWn = "";
        }
        bVar.aWo = jSONObject.optString("zipPath");
        if (obj.toString().equals(bVar.aWo)) {
            bVar.aWo = "";
        }
        bVar.packageUrl = jSONObject.optString("packageUrl");
        if (obj.toString().equals(bVar.packageUrl)) {
            bVar.packageUrl = "";
        }
        bVar.version = jSONObject.optString("version");
        if (obj.toString().equals(bVar.version)) {
            bVar.version = "";
        }
        bVar.avr = jSONObject.optString("checksum");
        if (obj.toString().equals(bVar.avr)) {
            bVar.avr = "";
        }
        bVar.loadType = jSONObject.optInt("loadType");
        bVar.packageType = jSONObject.optInt("packageType");
        bVar.aWq = jSONObject.optBoolean("public");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.h.a.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = bVar.aWm;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "packageId", bVar.aWm);
        }
        String str2 = bVar.aWn;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "zipFileName", bVar.aWn);
        }
        String str3 = bVar.aWo;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "zipPath", bVar.aWo);
        }
        String str4 = bVar.packageUrl;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "packageUrl", bVar.packageUrl);
        }
        String str5 = bVar.version;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "version", bVar.version);
        }
        String str6 = bVar.avr;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "checksum", bVar.avr);
        }
        int i = bVar.loadType;
        if (i != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "loadType", i);
        }
        int i2 = bVar.packageType;
        if (i2 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "packageType", i2);
        }
        boolean z = bVar.aWq;
        if (z) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "public", z);
        }
        return jSONObject;
    }
}
