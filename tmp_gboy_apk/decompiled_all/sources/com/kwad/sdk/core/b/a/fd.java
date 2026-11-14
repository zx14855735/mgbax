package com.kwad.sdk.core.b.a;

import com.kwad.components.core.webview.jshandler.g;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class fd implements com.kwad.sdk.core.d<g.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(g.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(g.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(g.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.showLiveStatus = jSONObject.optInt("showLiveStatus");
        aVar.showLiveStyle = jSONObject.optInt("showLiveStyle");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(g.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = aVar.showLiveStatus;
        if (i != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "showLiveStatus", i);
        }
        int i2 = aVar.showLiveStyle;
        if (i2 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "showLiveStyle", i2);
        }
        return jSONObject;
    }
}
