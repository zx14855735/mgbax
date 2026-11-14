package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class gz implements com.kwad.sdk.core.d<com.kwad.sdk.utils.b.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.utils.b.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.utils.b.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.utils.b.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.bhQ = jSONObject.optInt("put_count");
        aVar.bhR = jSONObject.optInt("get_failed_count");
        aVar.bhS = jSONObject.optInt("get_success_count");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.utils.b.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = aVar.bhQ;
        if (i != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "put_count", i);
        }
        int i2 = aVar.bhR;
        if (i2 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "get_failed_count", i2);
        }
        int i3 = aVar.bhS;
        if (i3 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "get_success_count", i3);
        }
        return jSONObject;
    }
}
