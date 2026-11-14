package com.kwad.sdk.core.b.a;

import J3FDQU.A2egSU;
import com.sigmob.sdk.base.mta.PointType;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class aj implements com.kwad.sdk.core.d<com.kwad.sdk.core.adlog.a.c> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.adlog.a.c cVar, JSONObject jSONObject) {
        a2(cVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.adlog.a.c cVar, JSONObject jSONObject) {
        return b2(cVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.core.adlog.a.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        cVar.aCc = jSONObject.optBoolean("retrySwitch");
        cVar.aCd = A2egSU.A5SV6n("1", "retryCountConfig", jSONObject);
        cVar.aCe = jSONObject.optLong("cacheExpireTime", new Long("600").longValue());
        cVar.aCf = A2egSU.A5SV6n(PointType.SIGMOB_APP, "retryQueueSize", jSONObject);
        cVar.aCg = jSONObject.optBoolean("retryCountFeeOnly");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.core.adlog.a.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z = cVar.aCc;
        if (z) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "retrySwitch", z);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "retryCountConfig", cVar.aCd);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "cacheExpireTime", cVar.aCe);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "retryQueueSize", cVar.aCf);
        boolean z2 = cVar.aCg;
        if (z2) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "retryCountFeeOnly", z2);
        }
        return jSONObject;
    }
}
