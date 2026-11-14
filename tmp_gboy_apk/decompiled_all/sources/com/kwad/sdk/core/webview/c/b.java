package com.kwad.sdk.core.webview.c;

import com.kwad.sdk.utils.aa;
import com.sigmob.sdk.base.mta.PointParamKey;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class b implements com.kwad.sdk.core.b {
    public String aSD;
    public String aSE;
    public String data;

    @Override // com.kwad.sdk.core.b
    public final void parseJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.aSD = jSONObject.optString("action");
        this.data = jSONObject.optString(PointParamKey.DATA);
        this.aSE = jSONObject.optString("callback");
    }

    @Override // com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        aa.putValue(jSONObject, "action", this.aSD);
        aa.putValue(jSONObject, PointParamKey.DATA, this.data);
        aa.putValue(jSONObject, "callback", this.aSE);
        return jSONObject;
    }
}
