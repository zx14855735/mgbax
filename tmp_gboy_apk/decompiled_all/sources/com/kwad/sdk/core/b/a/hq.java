package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class hq implements com.kwad.sdk.core.d<com.kwad.components.core.webview.tachikoma.c.n> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.webview.tachikoma.c.n nVar, JSONObject jSONObject) {
        a2(nVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.webview.tachikoma.c.n nVar, JSONObject jSONObject) {
        return b2(nVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.components.core.webview.tachikoma.c.n nVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        nVar.alc = jSONObject.optBoolean("muted");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.components.core.webview.tachikoma.c.n nVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z = nVar.alc;
        if (z) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "muted", z);
        }
        return jSONObject;
    }
}
