package com.kwad.sdk.core.b.a;

import com.bykv.vk.component.ttvideo.player.MediaFormat;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class ch implements com.kwad.sdk.core.d<com.kwad.sdk.core.webview.d.b.c> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.webview.d.b.c cVar, JSONObject jSONObject) {
        a2(cVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.webview.d.b.c cVar, JSONObject jSONObject) {
        return b2(cVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.core.webview.d.b.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        cVar.x = jSONObject.optDouble("x");
        cVar.y = jSONObject.optDouble("y");
        cVar.width = jSONObject.optInt(MediaFormat.KEY_WIDTH);
        cVar.height = jSONObject.optInt(MediaFormat.KEY_HEIGHT);
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.core.webview.d.b.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        double d = cVar.x;
        if (d != 0.0d) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "x", d);
        }
        double d2 = cVar.y;
        if (d2 != 0.0d) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "y", d2);
        }
        int i = cVar.width;
        if (i != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, MediaFormat.KEY_WIDTH, i);
        }
        int i2 = cVar.height;
        if (i2 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, MediaFormat.KEY_HEIGHT, i2);
        }
        return jSONObject;
    }
}
