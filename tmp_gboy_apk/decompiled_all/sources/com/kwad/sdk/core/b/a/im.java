package com.kwad.sdk.core.b.a;

import J3FDQU.A2egSU;
import com.czhj.sdk.common.Constants;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class im implements com.kwad.sdk.core.d<com.kwad.sdk.core.config.d> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.config.d dVar, JSONObject jSONObject) {
        a2(dVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.config.d dVar, JSONObject jSONObject) {
        return b2(dVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.core.config.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        dVar.aGO = A2egSU.A5SV6n(Constants.FAIL, "enableDialog", jSONObject);
        dVar.aGP = A2egSU.A5SV6n("800", "delayTime", jSONObject);
        dVar.aGQ = A2egSU.A5SV6n("3", "showTimesPerDay", jSONObject);
        dVar.aGR = A2egSU.A5SV6n("100000", "maxShowTimes", jSONObject);
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.core.config.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "enableDialog", dVar.aGO);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "delayTime", dVar.aGP);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "showTimesPerDay", dVar.aGQ);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "maxShowTimes", dVar.aGR);
        return jSONObject;
    }
}
