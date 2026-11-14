package com.kwad.sdk.core.b.a;

import com.kwad.components.ad.reward.k.t;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class ke implements com.kwad.sdk.core.d<t.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(t.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(t.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(t.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.Bk = jSONObject.optBoolean("needCloseNeo");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(t.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z = aVar.Bk;
        if (z) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "needCloseNeo", z);
        }
        return jSONObject;
    }
}
