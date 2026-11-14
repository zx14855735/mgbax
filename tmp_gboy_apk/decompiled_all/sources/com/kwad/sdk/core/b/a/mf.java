package com.kwad.sdk.core.b.a;

import J3FDQU.A2egSU;
import com.czhj.sdk.common.Constants;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class mf implements com.kwad.sdk.core.d<com.kwad.components.core.webview.tachikoma.c.x> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.webview.tachikoma.c.x xVar, JSONObject jSONObject) {
        a2(xVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.webview.tachikoma.c.x xVar, JSONObject jSONObject) {
        return b2(xVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.components.core.webview.tachikoma.c.x xVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        xVar.ali = A2egSU.A5SV6n(Constants.FAIL, "videoCloseTime", jSONObject);
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.components.core.webview.tachikoma.c.x xVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "videoCloseTime", xVar.ali);
        return jSONObject;
    }
}
