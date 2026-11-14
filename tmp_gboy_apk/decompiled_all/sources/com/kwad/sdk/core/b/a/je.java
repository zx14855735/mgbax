package com.kwad.sdk.core.b.a;

import com.kwad.sdk.n.d;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class je implements com.kwad.sdk.core.d<com.kwad.sdk.n.d> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.n.d dVar, JSONObject jSONObject) {
        a2(dVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.n.d dVar, JSONObject jSONObject) {
        return b2(dVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.n.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        dVar.funcSwitch = jSONObject.optLong("funcSwitch");
        dVar.bca = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("urlList");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                dVar.bca.add((String) optJSONArray.opt(i));
            }
        }
        dVar.bcb = new ArrayList();
        JSONArray optJSONArray2 = jSONObject.optJSONArray("actConfigList");
        if (optJSONArray2 != null) {
            for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                d.a aVar = new d.a();
                aVar.parseJson(optJSONArray2.optJSONObject(i2));
                dVar.bcb.add(aVar);
            }
        }
        dVar.byteCount = jSONObject.optLong("byteCount");
        dVar.sampleRate = jSONObject.optDouble("sampleRate");
        dVar.bcc = new ArrayList();
        JSONArray optJSONArray3 = jSONObject.optJSONArray("anchorNodeList");
        if (optJSONArray3 != null) {
            for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                com.kwad.sdk.n.a.b bVar = new com.kwad.sdk.n.a.b();
                bVar.parseJson(optJSONArray3.optJSONObject(i3));
                dVar.bcc.add(bVar);
            }
        }
        dVar.bbS = new ArrayList();
        JSONArray optJSONArray4 = jSONObject.optJSONArray("aggregationCheckConfigList");
        if (optJSONArray4 != null) {
            for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                com.kwad.sdk.n.a.a aVar2 = new com.kwad.sdk.n.a.a();
                aVar2.parseJson(optJSONArray4.optJSONObject(i4));
                dVar.bbS.add(aVar2);
            }
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.n.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j = dVar.funcSwitch;
        if (j != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "funcSwitch", j);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "urlList", dVar.bca);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "actConfigList", dVar.bcb);
        long j2 = dVar.byteCount;
        if (j2 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "byteCount", j2);
        }
        double d = dVar.sampleRate;
        if (d != 0.0d) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "sampleRate", d);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "anchorNodeList", dVar.bcc);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "aggregationCheckConfigList", dVar.bbS);
        return jSONObject;
    }
}
