package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class br implements com.kwad.sdk.core.d<com.kwad.components.ad.reward.model.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.ad.reward.model.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.ad.reward.model.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.components.ad.reward.model.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.lX = jSONObject.optLong("lastShowCardTimeStamp");
        bVar.lY = jSONObject.optInt("cardShowCount");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.components.ad.reward.model.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j = bVar.lX;
        if (j != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "lastShowCardTimeStamp", j);
        }
        int i = bVar.lY;
        if (i != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "cardShowCount", i);
        }
        return jSONObject;
    }
}
