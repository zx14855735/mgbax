package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class kf implements com.kwad.sdk.core.d<com.kwad.components.core.webview.tachikoma.c.s> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.webview.tachikoma.c.s sVar, JSONObject jSONObject) {
        a2(sVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.webview.tachikoma.c.s sVar, JSONObject jSONObject) {
        return b2(sVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.components.core.webview.tachikoma.c.s sVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        sVar.templateId = jSONObject.optString("templateId");
        if (JSONObject.NULL.toString().equals(sVar.templateId)) {
            sVar.templateId = "";
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.components.core.webview.tachikoma.c.s sVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = sVar.templateId;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "templateId", sVar.templateId);
        }
        return jSONObject;
    }
}
