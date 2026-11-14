package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class bj implements com.kwad.sdk.core.d<com.kwad.sdk.commercial.a.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.commercial.a.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.commercial.a.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.commercial.a.b bVar, JSONObject jSONObject) {
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
        bVar.downloadId = jSONObject.optString("download_id");
        if (obj.toString().equals(bVar.downloadId)) {
            bVar.downloadId = "";
        }
        bVar.aAm = jSONObject.optString("apk_package");
        if (obj.toString().equals(bVar.aAm)) {
            bVar.aAm = "";
        }
        bVar.aAn = jSONObject.optString("apk_name");
        if (obj.toString().equals(bVar.aAn)) {
            bVar.aAn = "";
        }
        bVar.aAo = jSONObject.optLong("apk_size");
        bVar.downloadTime = jSONObject.optLong("download_time");
        bVar.aAp = jSONObject.optLong("apk_cur_size");
        bVar.aAq = jSONObject.optInt("apk_install_type");
        bVar.aAr = jSONObject.optInt("apk_install_source");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.commercial.a.b bVar, JSONObject jSONObject) {
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
        String str3 = bVar.downloadId;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "download_id", bVar.downloadId);
        }
        String str4 = bVar.aAm;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "apk_package", bVar.aAm);
        }
        String str5 = bVar.aAn;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "apk_name", bVar.aAn);
        }
        long j = bVar.aAo;
        if (j != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "apk_size", j);
        }
        long j2 = bVar.downloadTime;
        if (j2 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "download_time", j2);
        }
        long j3 = bVar.aAp;
        if (j3 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "apk_cur_size", j3);
        }
        int i2 = bVar.aAq;
        if (i2 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "apk_install_type", i2);
        }
        int i3 = bVar.aAr;
        if (i3 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "apk_install_source", i3);
        }
        return jSONObject;
    }
}
