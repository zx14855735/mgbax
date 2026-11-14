package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class ag implements com.kwad.sdk.core.d<com.kwad.sdk.core.adlog.b.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.adlog.b.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.adlog.b.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.core.adlog.b.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.status = jSONObject.optInt("status");
        bVar.aAV = jSONObject.optInt("ad_action_type");
        bVar.retryCount = jSONObject.optInt("retry_count");
        bVar.aBW = jSONObject.optInt("retry_error_code");
        bVar.aBX = jSONObject.optString("retry_error_msg");
        if (JSONObject.NULL.toString().equals(bVar.aBX)) {
            bVar.aBX = "";
        }
        bVar.aCh = jSONObject.optInt("cache_total_num");
        bVar.aCi = jSONObject.optInt("cache_num");
        bVar.aCj = jSONObject.optLong("cacheTimeMs");
        bVar.aCg = jSONObject.optBoolean("retry_only");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.core.adlog.b.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = bVar.status;
        if (i != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "status", i);
        }
        int i2 = bVar.aAV;
        if (i2 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "ad_action_type", i2);
        }
        int i3 = bVar.retryCount;
        if (i3 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "retry_count", i3);
        }
        int i4 = bVar.aBW;
        if (i4 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "retry_error_code", i4);
        }
        String str = bVar.aBX;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "retry_error_msg", bVar.aBX);
        }
        int i5 = bVar.aCh;
        if (i5 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "cache_total_num", i5);
        }
        int i6 = bVar.aCi;
        if (i6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "cache_num", i6);
        }
        long j = bVar.aCj;
        if (j != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "cacheTimeMs", j);
        }
        boolean z = bVar.aCg;
        if (z) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "retry_only", z);
        }
        return jSONObject;
    }
}
