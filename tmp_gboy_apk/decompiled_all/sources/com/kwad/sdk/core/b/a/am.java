package com.kwad.sdk.core.b.a;

import com.kwad.components.core.webview.jshandler.a;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class am implements com.kwad.sdk.core.d<a.C0315a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(a.C0315a c0315a, JSONObject jSONObject) {
        a2(c0315a, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(a.C0315a c0315a, JSONObject jSONObject) {
        return b2(c0315a, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(a.C0315a c0315a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0315a.Om = jSONObject.optString("creativeId");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(c0315a.Om)) {
            c0315a.Om = "";
        }
        c0315a.agb = jSONObject.optString("targetMethod");
        if (obj.toString().equals(c0315a.agb)) {
            c0315a.agb = "";
        }
        c0315a.agc = jSONObject.optString("methodParams");
        if (obj.toString().equals(c0315a.agc)) {
            c0315a.agc = "";
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(a.C0315a c0315a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = c0315a.Om;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "creativeId", c0315a.Om);
        }
        String str2 = c0315a.agb;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "targetMethod", c0315a.agb);
        }
        String str3 = c0315a.agc;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "methodParams", c0315a.agc);
        }
        return jSONObject;
    }
}
