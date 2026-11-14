package com.kwad.sdk.core.b.a;

import com.kwad.components.core.webview.tachikoma.b.x;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class bo implements com.kwad.sdk.core.d<x.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(x.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(x.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(x.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.akL = jSONObject.optBoolean("hasLoseAudioFocus");
        aVar.akM = jSONObject.optInt("audioFocusStatus");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(x.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z = aVar.akL;
        if (z) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "hasLoseAudioFocus", z);
        }
        int i = aVar.akM;
        if (i != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "audioFocusStatus", i);
        }
        return jSONObject;
    }
}
