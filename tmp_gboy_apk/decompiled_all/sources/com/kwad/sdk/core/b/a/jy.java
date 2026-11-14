package com.kwad.sdk.core.b.a;

import com.kwad.sdk.j.a;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class jy implements com.kwad.sdk.core.d<a.C0380a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(a.C0380a c0380a, JSONObject jSONObject) {
        a2(c0380a, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(a.C0380a c0380a, JSONObject jSONObject) {
        return b2(c0380a, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(a.C0380a c0380a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0380a.aYq = jSONObject.optInt("ds");
        c0380a.sdkVersion = jSONObject.optString("sv");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(c0380a.sdkVersion)) {
            c0380a.sdkVersion = "";
        }
        c0380a.aTr = jSONObject.optString("spv");
        if (obj.toString().equals(c0380a.aTr)) {
            c0380a.aTr = "";
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(a.C0380a c0380a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = c0380a.aYq;
        if (i != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "ds", i);
        }
        String str = c0380a.sdkVersion;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "sv", c0380a.sdkVersion);
        }
        String str2 = c0380a.aTr;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "spv", c0380a.aTr);
        }
        return jSONObject;
    }
}
