package com.kwad.sdk.core.b.a;

import com.kwad.components.core.webview.jshandler.ak;
import com.sigmob.sdk.base.mta.PointParamKey;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class fr implements com.kwad.sdk.core.d<ak.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(ak.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(ak.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(ak.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.type = jSONObject.optInt(PointParamKey.TYPE);
        aVar.ahu = jSONObject.optInt("playDuration");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(ak.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = aVar.type;
        if (i != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, PointParamKey.TYPE, i);
        }
        int i2 = aVar.ahu;
        if (i2 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "playDuration", i2);
        }
        return jSONObject;
    }
}
