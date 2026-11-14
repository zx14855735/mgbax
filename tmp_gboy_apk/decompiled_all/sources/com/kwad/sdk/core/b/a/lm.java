package com.kwad.sdk.core.b.a;

import com.kwad.sdk.n.a.b;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class lm implements com.kwad.sdk.core.d<b.C0384b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(b.C0384b c0384b, JSONObject jSONObject) {
        a2(c0384b, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(b.C0384b c0384b, JSONObject jSONObject) {
        return b2(c0384b, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(b.C0384b c0384b, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0384b.name = jSONObject.optString("name");
        if (JSONObject.NULL.toString().equals(c0384b.name)) {
            c0384b.name = "";
        }
        c0384b.bcC = jSONObject.optBoolean("isStatic");
        c0384b.bcD = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("paramList");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                b.a aVar = new b.a();
                aVar.parseJson(optJSONArray.optJSONObject(i));
                c0384b.bcD.add(aVar);
            }
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(b.C0384b c0384b, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = c0384b.name;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "name", c0384b.name);
        }
        boolean z = c0384b.bcC;
        if (z) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "isStatic", z);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "paramList", c0384b.bcD);
        return jSONObject;
    }
}
