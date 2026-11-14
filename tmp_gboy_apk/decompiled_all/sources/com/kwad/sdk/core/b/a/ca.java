package com.kwad.sdk.core.b.a;

import J3FDQU.A2egSU;
import com.sigmob.sdk.base.mta.PointType;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class ca implements com.kwad.sdk.core.d<com.kwad.sdk.crash.online.monitor.a.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.crash.online.monitor.a.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.crash.online.monitor.a.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.crash.online.monitor.a.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.aUT = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("systemFilterList");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                aVar.aUT.add((String) optJSONArray.opt(i));
            }
        }
        aVar.aUU = new ArrayList();
        JSONArray optJSONArray2 = jSONObject.optJSONArray("sdkFilterList");
        if (optJSONArray2 != null) {
            for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                aVar.aUU.add((String) optJSONArray2.opt(i2));
            }
        }
        aVar.aUV = new ArrayList();
        JSONArray optJSONArray3 = jSONObject.optJSONArray("matrixPrinterNameList");
        if (optJSONArray3 != null) {
            for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                aVar.aUV.add((String) optJSONArray3.opt(i3));
            }
        }
        aVar.aUW = new ArrayList();
        JSONArray optJSONArray4 = jSONObject.optJSONArray("commonPrinterNameList");
        if (optJSONArray4 != null) {
            for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                aVar.aUW.add((String) optJSONArray4.opt(i4));
            }
        }
        aVar.aUX = new ArrayList();
        JSONArray optJSONArray5 = jSONObject.optJSONArray("featureConfigList");
        if (optJSONArray5 != null) {
            for (int i5 = 0; i5 < optJSONArray5.length(); i5++) {
                com.kwad.sdk.crash.online.monitor.a.b bVar = new com.kwad.sdk.crash.online.monitor.a.b();
                bVar.parseJson(optJSONArray5.optJSONObject(i5));
                aVar.aUX.add(bVar);
            }
        }
        aVar.aUZ = A2egSU.A5SV6n("5", "afterFilterSystemCheckNum", jSONObject);
        aVar.aVa = A2egSU.A5SV6n(PointType.SIGMOB_APP, "batchNum", jSONObject);
        aVar.aAi = jSONObject.optDouble(com.sigmob.sdk.base.n.C, new Double("0.01").doubleValue());
        aVar.aVb = jSONObject.optInt("monitorSwitch");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.crash.online.monitor.a.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "systemFilterList", aVar.aUT);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "sdkFilterList", aVar.aUU);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "matrixPrinterNameList", aVar.aUV);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "commonPrinterNameList", aVar.aUW);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "featureConfigList", aVar.aUX);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "afterFilterSystemCheckNum", aVar.aUZ);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "batchNum", aVar.aVa);
        com.kwad.sdk.utils.aa.putValue(jSONObject, com.sigmob.sdk.base.n.C, aVar.aAi);
        int i = aVar.aVb;
        if (i != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "monitorSwitch", i);
        }
        return jSONObject;
    }
}
