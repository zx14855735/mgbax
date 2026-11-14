package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.config.item.i;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class fv implements com.kwad.sdk.core.d<i.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(i.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(i.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(i.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.aGW = jSONObject.optString("imei");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(aVar.aGW)) {
            aVar.aGW = "";
        }
        aVar.aGX = jSONObject.optString("oaid");
        if (obj.toString().equals(aVar.aGX)) {
            aVar.aGX = "";
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(i.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = aVar.aGW;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "imei", aVar.aGW);
        }
        String str2 = aVar.aGX;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "oaid", aVar.aGX);
        }
        return jSONObject;
    }
}
