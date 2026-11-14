package com.kwad.sdk.core.b.a;

import com.kwad.components.core.webview.jshandler.ap;
import com.sigmob.sdk.base.mta.PointCategory;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class gq implements com.kwad.sdk.core.d<ap.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(ap.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(ap.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(ap.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.ahP = jSONObject.optDouble(PointCategory.PROGRESS);
        bVar.status = jSONObject.optInt("status");
        bVar.totalBytes = jSONObject.optLong("totalBytes");
        bVar.soFarBytes = jSONObject.optLong("soFarBytes");
        bVar.ahQ = jSONObject.optDouble("realProgress");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(ap.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        double d = bVar.ahP;
        if (d != 0.0d) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, PointCategory.PROGRESS, d);
        }
        int i = bVar.status;
        if (i != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "status", i);
        }
        long j = bVar.totalBytes;
        if (j != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "totalBytes", j);
        }
        long j2 = bVar.soFarBytes;
        if (j2 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "soFarBytes", j2);
        }
        double d2 = bVar.ahQ;
        if (d2 != 0.0d) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "realProgress", d2);
        }
        return jSONObject;
    }
}
