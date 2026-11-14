package com.kwad.sdk.core.b.a;

import com.kwad.components.core.webview.jshandler.a.a;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class cg implements com.kwad.sdk.core.d<a.C0316a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(a.C0316a c0316a, JSONObject jSONObject) {
        a2(c0316a, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(a.C0316a c0316a, JSONObject jSONObject) {
        return b2(c0316a, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(a.C0316a c0316a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0316a.aiE = jSONObject.optString("android");
        if (JSONObject.NULL.toString().equals(c0316a.aiE)) {
            c0316a.aiE = "";
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(a.C0316a c0316a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = c0316a.aiE;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "android", c0316a.aiE);
        }
        return jSONObject;
    }
}
