package com.kwad.sdk.core.b.a;

import com.kwad.sdk.commercial.j.a;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class lw implements com.kwad.sdk.core.d<a.C0351a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(a.C0351a c0351a, JSONObject jSONObject) {
        a2(c0351a, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(a.C0351a c0351a, JSONObject jSONObject) {
        return b2(c0351a, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(a.C0351a c0351a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0351a.aAU = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("blackList");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                c0351a.aAU.add((String) optJSONArray.opt(i));
            }
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(a.C0351a c0351a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "blackList", c0351a.aAU);
        return jSONObject;
    }
}
