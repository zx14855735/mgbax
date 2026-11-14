package com.kwad.sdk.core.request.model;

import com.kwad.sdk.core.network.k;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.aa;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class e implements com.kwad.sdk.core.b {
    private com.kwad.sdk.core.b aNq;

    public static e KG() {
        e eVar = new e();
        try {
            eVar.aNq = ((k) ServiceProvider.get(k.class)).CO();
            return eVar;
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
            return eVar;
        }
    }

    @Override // com.kwad.sdk.core.b
    public final void parseJson(JSONObject jSONObject) {
    }

    @Override // com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        aa.a(jSONObject, "modeInfo", this.aNq);
        return jSONObject;
    }
}
