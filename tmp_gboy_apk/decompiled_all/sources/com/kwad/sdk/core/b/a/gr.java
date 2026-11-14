package com.kwad.sdk.core.b.a;

import com.sigmob.sdk.base.mta.PointParamKey;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class gr implements com.kwad.sdk.core.d<com.kwad.components.core.webview.tachikoma.c.k> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.webview.tachikoma.c.k kVar, JSONObject jSONObject) {
        a2(kVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.webview.tachikoma.c.k kVar, JSONObject jSONObject) {
        return b2(kVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.components.core.webview.tachikoma.c.k kVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        kVar.data = jSONObject.optString(PointParamKey.DATA);
        if (JSONObject.NULL.toString().equals(kVar.data)) {
            kVar.data = "";
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.components.core.webview.tachikoma.c.k kVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = kVar.data;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, PointParamKey.DATA, kVar.data);
        }
        return jSONObject;
    }
}
