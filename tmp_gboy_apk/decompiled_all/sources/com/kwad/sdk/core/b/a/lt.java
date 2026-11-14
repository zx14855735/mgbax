package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class lt implements com.kwad.sdk.core.d<com.kwad.sdk.core.threads.d> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.threads.d dVar, JSONObject jSONObject) {
        a2(dVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.threads.d dVar, JSONObject jSONObject) {
        return b2(dVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.core.threads.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        dVar.aOy = jSONObject.optInt("rate_reciprocal");
        dVar.aOE = jSONObject.optInt("threshold");
        dVar.interval = jSONObject.optLong("interval");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.core.threads.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = dVar.aOy;
        if (i != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "rate_reciprocal", i);
        }
        int i2 = dVar.aOE;
        if (i2 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "threshold", i2);
        }
        long j = dVar.interval;
        if (j != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "interval", j);
        }
        return jSONObject;
    }
}
