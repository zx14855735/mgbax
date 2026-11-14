package com.kwad.sdk.core.b.a;

import com.kwad.components.ad.j.b;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class gh implements com.kwad.sdk.core.d<b.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(b.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(b.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(b.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.Mh = jSONObject.optString("device_model");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(aVar.Mh)) {
            aVar.Mh = "";
        }
        aVar.Mi = jSONObject.optString("device_brand");
        if (obj.toString().equals(aVar.Mi)) {
            aVar.Mi = "";
        }
        aVar.Mj = jSONObject.optString("os_version");
        if (obj.toString().equals(aVar.Mj)) {
            aVar.Mj = "";
        }
        aVar.Mk = jSONObject.optString("rom_name");
        if (obj.toString().equals(aVar.Mk)) {
            aVar.Mk = "";
        }
        aVar.Ml = jSONObject.optString("device_id");
        if (obj.toString().equals(aVar.Ml)) {
            aVar.Ml = "";
        }
        aVar.status = jSONObject.optInt("status");
        aVar.Mm = jSONObject.optString("install_check_record");
        if (obj.toString().equals(aVar.Mm)) {
            aVar.Mm = "";
        }
        aVar.Mn = jSONObject.optString("local_installer_pkgs");
        if (obj.toString().equals(aVar.Mn)) {
            aVar.Mn = "";
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(b.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = aVar.Mh;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "device_model", aVar.Mh);
        }
        String str2 = aVar.Mi;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "device_brand", aVar.Mi);
        }
        String str3 = aVar.Mj;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "os_version", aVar.Mj);
        }
        String str4 = aVar.Mk;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "rom_name", aVar.Mk);
        }
        String str5 = aVar.Ml;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "device_id", aVar.Ml);
        }
        int i = aVar.status;
        if (i != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "status", i);
        }
        String str6 = aVar.Mm;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "install_check_record", aVar.Mm);
        }
        String str7 = aVar.Mn;
        if (str7 != null && !str7.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "local_installer_pkgs", aVar.Mn);
        }
        return jSONObject;
    }
}
