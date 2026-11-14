package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class ln implements com.kwad.sdk.core.d<com.kwad.sdk.core.request.model.f> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.request.model.f fVar, JSONObject jSONObject) {
        a2(fVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.request.model.f fVar, JSONObject jSONObject) {
        return b2(fVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.core.request.model.f fVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        fVar.adStyle = jSONObject.optInt("adStyle");
        fVar.taskType = jSONObject.optInt("taskType");
        fVar.count = jSONObject.optInt("count");
        fVar.aNw = jSONObject.optLong("lastModifiedTime");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.core.request.model.f fVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = fVar.adStyle;
        if (i != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adStyle", i);
        }
        int i2 = fVar.taskType;
        if (i2 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "taskType", i2);
        }
        int i3 = fVar.count;
        if (i3 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "count", i3);
        }
        long j = fVar.aNw;
        if (j != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "lastModifiedTime", j);
        }
        return jSONObject;
    }
}
