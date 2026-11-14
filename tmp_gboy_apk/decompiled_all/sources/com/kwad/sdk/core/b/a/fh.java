package com.kwad.sdk.core.b.a;

import com.kwad.components.core.webview.jshandler.j;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class fh implements com.kwad.sdk.core.d<j.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(j.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(j.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(j.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.agm = jSONObject.optInt("playableSrc");
        bVar.agn = jSONObject.optInt("isMiddleEnd");
        bVar.SA = jSONObject.optInt("adType");
        bVar.ago = jSONObject.optString("showTime");
        if (JSONObject.NULL.toString().equals(bVar.ago)) {
            bVar.ago = "";
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(j.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = bVar.agm;
        if (i != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "playableSrc", i);
        }
        int i2 = bVar.agn;
        if (i2 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "isMiddleEnd", i2);
        }
        int i3 = bVar.SA;
        if (i3 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adType", i3);
        }
        String str = bVar.ago;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "showTime", bVar.ago);
        }
        return jSONObject;
    }
}
