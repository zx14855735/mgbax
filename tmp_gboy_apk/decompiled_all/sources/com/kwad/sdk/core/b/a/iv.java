package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class iv implements com.kwad.sdk.core.d<com.kwad.components.core.webview.tachikoma.c.q> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.webview.tachikoma.c.q qVar, JSONObject jSONObject) {
        a2(qVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.webview.tachikoma.c.q qVar, JSONObject jSONObject) {
        return b2(qVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.components.core.webview.tachikoma.c.q qVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        qVar.ale = jSONObject.optBoolean("isEnd");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.components.core.webview.tachikoma.c.q qVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z = qVar.ale;
        if (z) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "isEnd", z);
        }
        return jSONObject;
    }
}
