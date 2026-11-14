package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class in implements com.kwad.sdk.core.d<com.kwad.components.core.webview.tachikoma.c.p> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.webview.tachikoma.c.p pVar, JSONObject jSONObject) {
        a2(pVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.webview.tachikoma.c.p pVar, JSONObject jSONObject) {
        return b2(pVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.components.core.webview.tachikoma.c.p pVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        pVar.scene = jSONObject.optInt("scene");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.components.core.webview.tachikoma.c.p pVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = pVar.scene;
        if (i != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "scene", i);
        }
        return jSONObject;
    }
}
