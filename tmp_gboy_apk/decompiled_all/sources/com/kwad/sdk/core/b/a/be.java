package com.kwad.sdk.core.b.a;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class be implements com.kwad.sdk.core.d<com.kwad.sdk.n.a.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.n.a.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.n.a.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.n.a.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.bcj = jSONObject.optInt("aggregationType");
        aVar.bck = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("sdkCheckList");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                aVar.bck.add((String) optJSONArray.opt(i));
            }
        }
        com.kwad.sdk.n.a.b bVar = new com.kwad.sdk.n.a.b();
        aVar.bcl = bVar;
        bVar.parseJson(jSONObject.optJSONObject("anchorNode"));
        aVar.bcm = new ArrayList();
        JSONArray optJSONArray2 = jSONObject.optJSONArray("stackCheckList");
        if (optJSONArray2 != null) {
            for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                aVar.bcm.add((String) optJSONArray2.opt(i2));
            }
        }
        aVar.bcn = new ArrayList();
        JSONArray optJSONArray3 = jSONObject.optJSONArray("callStackList");
        if (optJSONArray3 != null) {
            for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                aVar.bcn.add((String) optJSONArray3.opt(i3));
            }
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.n.a.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = aVar.bcj;
        if (i != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "aggregationType", i);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "sdkCheckList", aVar.bck);
        com.kwad.sdk.utils.aa.a(jSONObject, "anchorNode", aVar.bcl);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "stackCheckList", aVar.bcm);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "callStackList", aVar.bcn);
        return jSONObject;
    }
}
