package com.kwad.sdk.core.b.a;

import com.kwad.components.core.webview.jshandler.at;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class bh implements com.kwad.sdk.core.d<at.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(at.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(at.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(at.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.id = jSONObject.optInt(com.sigmob.sdk.downloader.core.breakpoint.f.f13353a);
        aVar.status = jSONObject.optInt("status");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(at.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = aVar.id;
        if (i != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, com.sigmob.sdk.downloader.core.breakpoint.f.f13353a, i);
        }
        int i2 = aVar.status;
        if (i2 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "status", i2);
        }
        return jSONObject;
    }
}
