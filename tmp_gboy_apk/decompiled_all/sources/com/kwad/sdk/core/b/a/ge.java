package com.kwad.sdk.core.b.a;

import com.kwad.components.core.webview.jshandler.m;
import com.sigmob.sdk.base.mta.PointCategory;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class ge implements com.kwad.sdk.core.d<m.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(m.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(m.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(m.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.status = jSONObject.optInt("status");
        bVar.progress = jSONObject.optInt(PointCategory.PROGRESS);
        bVar.soFarBytes = jSONObject.optLong("soFarBytes");
        bVar.totalBytes = jSONObject.optLong("totalBytes");
        bVar.agr = jSONObject.optInt("realProgress");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(m.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = bVar.status;
        if (i != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "status", i);
        }
        int i2 = bVar.progress;
        if (i2 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, PointCategory.PROGRESS, i2);
        }
        long j = bVar.soFarBytes;
        if (j != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "soFarBytes", j);
        }
        long j2 = bVar.totalBytes;
        if (j2 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "totalBytes", j2);
        }
        int i3 = bVar.agr;
        if (i3 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "realProgress", i3);
        }
        return jSONObject;
    }
}
