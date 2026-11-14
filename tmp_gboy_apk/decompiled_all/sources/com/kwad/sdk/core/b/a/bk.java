package com.kwad.sdk.core.b.a;

import com.kwad.components.core.webview.jshandler.au;
import com.sigmob.sdk.base.mta.PointCategory;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class bk implements com.kwad.sdk.core.d<au.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(au.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(au.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(au.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.ahP = jSONObject.optDouble(PointCategory.PROGRESS);
        aVar.status = jSONObject.optInt("status");
        aVar.totalBytes = jSONObject.optLong("totalBytes");
        aVar.soFarBytes = jSONObject.optLong("soFarBytes");
        aVar.ahQ = jSONObject.optDouble("realProgress");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(au.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        double d = aVar.ahP;
        if (d != 0.0d) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, PointCategory.PROGRESS, d);
        }
        int i = aVar.status;
        if (i != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "status", i);
        }
        long j = aVar.totalBytes;
        if (j != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "totalBytes", j);
        }
        long j2 = aVar.soFarBytes;
        if (j2 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "soFarBytes", j2);
        }
        double d2 = aVar.ahQ;
        if (d2 != 0.0d) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "realProgress", d2);
        }
        return jSONObject;
    }
}
