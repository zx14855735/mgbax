package com.kwad.sdk.core.b.a;

import J3FDQU.A2egSU;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class e implements com.kwad.sdk.core.d<com.kwad.sdk.core.webview.d.b.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.webview.d.b.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.webview.d.b.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.core.webview.d.b.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.ahH = jSONObject.optBoolean("clickActionButton");
        aVar.ahJ = jSONObject.optInt("area");
        aVar.mH = jSONObject.optInt("itemClickType");
        aVar.aSM = A2egSU.A5SV6n("-1", "convertPageType", jSONObject);
        com.kwad.sdk.core.webview.d.b.d dVar = new com.kwad.sdk.core.webview.d.b.d();
        aVar.ahK = dVar;
        dVar.parseJson(jSONObject.optJSONObject("logParam"));
        aVar.PG = jSONObject.optBoolean("needReport", new Boolean("true").booleanValue());
        aVar.creativeId = jSONObject.optLong("creativeId", new Long("-1").longValue());
        aVar.PU = jSONObject.optString("liveItemId");
        if (JSONObject.NULL.toString().equals(aVar.PU)) {
            aVar.PU = "";
        }
        aVar.aSN = jSONObject.optInt("sceneType");
        aVar.adStyle = A2egSU.A5SV6n("-1", "adStyle", jSONObject);
        aVar.aSO = jSONObject.optBoolean("isCallbackOnly");
        aVar.aSP = jSONObject.optBoolean("disableCallback");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.core.webview.d.b.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z = aVar.ahH;
        if (z) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "clickActionButton", z);
        }
        int i = aVar.ahJ;
        if (i != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "area", i);
        }
        int i2 = aVar.mH;
        if (i2 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "itemClickType", i2);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "convertPageType", aVar.aSM);
        com.kwad.sdk.utils.aa.a(jSONObject, "logParam", aVar.ahK);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "needReport", aVar.PG);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "creativeId", aVar.creativeId);
        String str = aVar.PU;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "liveItemId", aVar.PU);
        }
        int i3 = aVar.aSN;
        if (i3 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "sceneType", i3);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "adStyle", aVar.adStyle);
        boolean z2 = aVar.aSO;
        if (z2) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "isCallbackOnly", z2);
        }
        boolean z3 = aVar.aSP;
        if (z3) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "disableCallback", z3);
        }
        return jSONObject;
    }
}
