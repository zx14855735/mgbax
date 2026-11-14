package com.kwad.sdk.core.webview.c;

import com.kwad.sdk.utils.aa;
import com.sigmob.sdk.base.mta.PointParamKey;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class f implements com.kwad.sdk.core.b {
    public final com.kwad.sdk.core.b aSF;
    public final int result = 1;

    public f(com.kwad.sdk.core.b bVar) {
        this.aSF = bVar;
    }

    @Override // com.kwad.sdk.core.b
    public final void parseJson(JSONObject jSONObject) {
    }

    @Override // com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        aa.putValue(jSONObject, "result", this.result);
        aa.a(jSONObject, PointParamKey.DATA, this.aSF);
        return jSONObject;
    }
}
