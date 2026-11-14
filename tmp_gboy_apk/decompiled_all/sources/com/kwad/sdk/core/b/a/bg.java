package com.kwad.sdk.core.b.a;

import com.kwad.sdk.n.a.b;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class bg implements com.kwad.sdk.core.d<com.kwad.sdk.n.a.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.n.a.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.n.a.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.n.a.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.bcp = jSONObject.optString("nodeClassName");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(bVar.bcp)) {
            bVar.bcp = "";
        }
        bVar.bcq = jSONObject.optString("childFieldName");
        if (obj.toString().equals(bVar.bcq)) {
            bVar.bcq = "";
        }
        bVar.bcr = jSONObject.optBoolean("childFieldIsStatic");
        bVar.bcs = jSONObject.optString("reportKey");
        if (obj.toString().equals(bVar.bcs)) {
            bVar.bcs = "";
        }
        b.C0384b c0384b = new b.C0384b();
        bVar.bct = c0384b;
        c0384b.parseJson(jSONObject.optJSONObject("childMethod"));
        com.kwad.sdk.n.a.b bVar2 = new com.kwad.sdk.n.a.b();
        bVar.bcu = bVar2;
        bVar2.parseJson(jSONObject.optJSONObject("deepNode"));
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.n.a.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = bVar.bcp;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "nodeClassName", bVar.bcp);
        }
        String str2 = bVar.bcq;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "childFieldName", bVar.bcq);
        }
        boolean z = bVar.bcr;
        if (z) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "childFieldIsStatic", z);
        }
        String str3 = bVar.bcs;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "reportKey", bVar.bcs);
        }
        com.kwad.sdk.utils.aa.a(jSONObject, "childMethod", bVar.bct);
        com.kwad.sdk.utils.aa.a(jSONObject, "deepNode", bVar.bcu);
        return jSONObject;
    }
}
