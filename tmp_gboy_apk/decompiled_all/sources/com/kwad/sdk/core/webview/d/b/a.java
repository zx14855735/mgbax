package com.kwad.sdk.core.webview.d.b;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bp;
import org.json.JSONException;
import org.json.JSONObject;

@KsJson
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class a extends com.kwad.sdk.core.response.a.a {
    public String PU;

    @Deprecated
    public boolean Pt;
    public int aSM;
    public int aSN;
    public AdTemplate adTemplate;

    @Deprecated
    public boolean ahH;
    public int ahJ;
    public d ahK;
    public int mH;
    public boolean PG = true;
    public long creativeId = -1;
    public int adStyle = -1;
    public boolean aSO = false;
    public boolean aSP = false;

    public final boolean MS() {
        return 1 == this.ahJ;
    }

    @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
    public final void parseJson(JSONObject jSONObject) {
        super.parseJson(jSONObject);
        try {
            if (this.mH == 0 && this.aSN == 0) {
                if (jSONObject != null && jSONObject.has("logParam")) {
                    JSONObject optJSONObject = jSONObject.optJSONObject("logParam");
                    this.mH = optJSONObject.getInt("itemClickType");
                    this.aSN = optJSONObject.getInt("sceneType");
                    this.aSO = optJSONObject.optBoolean("isCallbackOnly");
                }
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
            }
        } catch (Throwable unused) {
        }
    }
}
