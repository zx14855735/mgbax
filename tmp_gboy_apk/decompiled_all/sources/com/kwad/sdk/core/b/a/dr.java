package com.kwad.sdk.core.b.a;

import com.kwad.components.core.webview.a.a;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class dr implements com.kwad.sdk.core.d<a.C0314a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(a.C0314a c0314a, JSONObject jSONObject) {
        a2(c0314a, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(a.C0314a c0314a, JSONObject jSONObject) {
        return b2(c0314a, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(a.C0314a c0314a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0314a.url = jSONObject.optString("url");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(c0314a.url)) {
            c0314a.url = "";
        }
        c0314a.packageName = jSONObject.optString("packageName");
        if (obj.toString().equals(c0314a.packageName)) {
            c0314a.packageName = "";
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(a.C0314a c0314a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = c0314a.url;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "url", c0314a.url);
        }
        String str2 = c0314a.packageName;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "packageName", c0314a.packageName);
        }
        return jSONObject;
    }
}
