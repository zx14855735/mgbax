package com.kwad.sdk.core.b.a;

import com.sigmob.sdk.base.mta.PointParamKey;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class kd implements com.kwad.sdk.core.d<com.kwad.components.core.webview.tachikoma.c.r> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.webview.tachikoma.c.r rVar, JSONObject jSONObject) {
        a2(rVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.webview.tachikoma.c.r rVar, JSONObject jSONObject) {
        return b2(rVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.components.core.webview.tachikoma.c.r rVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        rVar.alf = jSONObject.optBoolean("userForce");
        rVar.type = jSONObject.optInt(PointParamKey.TYPE);
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.components.core.webview.tachikoma.c.r rVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z = rVar.alf;
        if (z) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "userForce", z);
        }
        int i = rVar.type;
        if (i != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, PointParamKey.TYPE, i);
        }
        return jSONObject;
    }
}
