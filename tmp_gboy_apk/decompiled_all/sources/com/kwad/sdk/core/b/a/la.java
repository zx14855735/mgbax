package com.kwad.sdk.core.b.a;

import com.kwad.sdk.o.l;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class la implements com.kwad.sdk.core.d<l.a.C0386a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(l.a.C0386a c0386a, JSONObject jSONObject) {
        a2(c0386a, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(l.a.C0386a c0386a, JSONObject jSONObject) {
        return b2(c0386a, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(l.a.C0386a c0386a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0386a.bje = jSONObject.optString("s_cn");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(c0386a.bje)) {
            c0386a.bje = "";
        }
        c0386a.bjf = jSONObject.optString("s_mn");
        if (obj.toString().equals(c0386a.bjf)) {
            c0386a.bjf = "";
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(l.a.C0386a c0386a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = c0386a.bje;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "s_cn", c0386a.bje);
        }
        String str2 = c0386a.bjf;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "s_mn", c0386a.bjf);
        }
        return jSONObject;
    }
}
