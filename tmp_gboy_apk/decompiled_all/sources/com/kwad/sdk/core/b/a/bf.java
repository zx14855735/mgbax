package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class bf implements com.kwad.sdk.core.d<com.kwad.sdk.n.b.a.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.n.b.a.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.n.b.a.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.n.b.a.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.bcF = jSONObject.optInt("aggregation_sdk_type");
        aVar.bcG = jSONObject.optString("aggregation_version");
        if (JSONObject.NULL.toString().equals(aVar.bcG)) {
            aVar.bcG = "";
        }
        aVar.bcH = jSONObject.optInt("crash_times");
        aVar.bcI = jSONObject.optInt("call_ks_union_times");
        aVar.bcJ = jSONObject.optLong("ks_launch_delay");
        aVar.bcK = jSONObject.optLong("aggregation_launch_delay");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.n.b.a.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = aVar.bcF;
        if (i != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "aggregation_sdk_type", i);
        }
        String str = aVar.bcG;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "aggregation_version", aVar.bcG);
        }
        int i2 = aVar.bcH;
        if (i2 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "crash_times", i2);
        }
        int i3 = aVar.bcI;
        if (i3 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "call_ks_union_times", i3);
        }
        long j = aVar.bcJ;
        if (j != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "ks_launch_delay", j);
        }
        long j2 = aVar.bcK;
        if (j2 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "aggregation_launch_delay", j2);
        }
        return jSONObject;
    }
}
