package com.kwad.sdk.core.webview.d.b;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bp;
import org.json.JSONException;
import org.json.JSONObject;

@KsJson
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class b extends com.kwad.sdk.core.response.a.a {
    public AdTemplate adTemplate;
    public String extra;
    public String llsid;

    @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
    public final void parseJson(JSONObject jSONObject) {
        super.parseJson(jSONObject);
        try {
            String optString = jSONObject.optString("adTemplate");
            if (bp.isNullString(optString)) {
                return;
            }
            try {
                JSONObject jSONObject2 = new JSONObject(optString);
                AdTemplate adTemplate = new AdTemplate();
                this.adTemplate = adTemplate;
                adTemplate.parseJson(jSONObject2);
            } catch (JSONException e) {
                ServiceProvider.reportSdkCaughtException(e);
            }
        } catch (Throwable unused) {
        }
    }
}
