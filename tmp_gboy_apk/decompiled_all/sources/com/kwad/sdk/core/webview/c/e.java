package com.kwad.sdk.core.webview.c;

import com.kwad.sdk.utils.aa;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class e implements com.kwad.sdk.core.b {
    private final String ayG;
    private final int result;

    public e(int i, String str) {
        this.result = i;
        this.ayG = str;
    }

    @Override // com.kwad.sdk.core.b
    public final void parseJson(JSONObject jSONObject) {
    }

    @Override // com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        aa.putValue(jSONObject, "result", this.result);
        aa.putValue(jSONObject, "error_msg", this.ayG);
        return jSONObject;
    }
}
