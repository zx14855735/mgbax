package com.kwad.sdk.core.b.a;

import J3FDQU.A2egSU;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class jb implements com.kwad.sdk.core.d<com.kwad.sdk.core.response.model.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.response.model.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.response.model.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.core.response.model.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.posId = jSONObject.optLong("posId");
        aVar.aNE = jSONObject.optInt("adPhotoCountForMedia");
        aVar.aNF = jSONObject.optBoolean("enablePreload");
        aVar.aNG = jSONObject.optLong("increaseAdLoadTime", new Long("10000").longValue());
        aVar.aNH = jSONObject.optInt("adLoadStrategy");
        aVar.aNI = A2egSU.A5SV6n("3", "drawAdForcedWatchTimes", jSONObject);
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.core.response.model.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j = aVar.posId;
        if (j != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "posId", j);
        }
        int i = aVar.aNE;
        if (i != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adPhotoCountForMedia", i);
        }
        boolean z = aVar.aNF;
        if (z) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "enablePreload", z);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "increaseAdLoadTime", aVar.aNG);
        int i2 = aVar.aNH;
        if (i2 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adLoadStrategy", i2);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "drawAdForcedWatchTimes", aVar.aNI);
        return jSONObject;
    }
}
