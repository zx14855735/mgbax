package com.kwad.sdk.core.b.a;

import com.kwad.sdk.j.a;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class jz implements com.kwad.sdk.core.d<a.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(a.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(a.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(a.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.aYr = jSONObject.optInt("enable_monitor");
        bVar.aYs = jSONObject.optString("c_sc_name");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(bVar.aYs)) {
            bVar.aYs = "";
        }
        bVar.aYt = jSONObject.optString("c_pcl_name");
        if (obj.toString().equals(bVar.aYt)) {
            bVar.aYt = "";
        }
        bVar.aYu = jSONObject.optString("m_gam_name");
        if (obj.toString().equals(bVar.aYu)) {
            bVar.aYu = "";
        }
        bVar.aYv = jSONObject.optString("m_gsv_name");
        if (obj.toString().equals(bVar.aYv)) {
            bVar.aYv = "";
        }
        bVar.aYw = jSONObject.optString("m_gpv_name");
        if (obj.toString().equals(bVar.aYw)) {
            bVar.aYw = "";
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(a.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = bVar.aYr;
        if (i != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "enable_monitor", i);
        }
        String str = bVar.aYs;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "c_sc_name", bVar.aYs);
        }
        String str2 = bVar.aYt;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "c_pcl_name", bVar.aYt);
        }
        String str3 = bVar.aYu;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "m_gam_name", bVar.aYu);
        }
        String str4 = bVar.aYv;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "m_gsv_name", bVar.aYv);
        }
        String str5 = bVar.aYw;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "m_gpv_name", bVar.aYw);
        }
        return jSONObject;
    }
}
