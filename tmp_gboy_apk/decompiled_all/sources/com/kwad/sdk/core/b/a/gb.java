package com.kwad.sdk.core.b.a;

import J3FDQU.A2egSU;
import com.kwad.sdk.core.config.item.k;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class gb implements com.kwad.sdk.core.d<k.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(k.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(k.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(k.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.aGY = A2egSU.A5SV6n("180000", "horizontalShowDuration", jSONObject);
        aVar.aGZ = A2egSU.A5SV6n("90000", "verticalShowDuration", jSONObject);
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(k.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "horizontalShowDuration", aVar.aGY);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "verticalShowDuration", aVar.aGZ);
        return jSONObject;
    }
}
