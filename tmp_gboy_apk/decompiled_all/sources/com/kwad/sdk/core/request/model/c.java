package com.kwad.sdk.core.request.model;

import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.aa;
import com.kwad.sdk.utils.bd;
import com.sigmob.sdk.base.mta.PointParamKey;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class c implements com.kwad.sdk.core.b {
    private static c aNm;
    private double latitude;
    private double longitude;
    private int type;

    public static c KD() {
        com.kwad.sdk.internal.api.a aVar;
        c cVar = aNm;
        if (cVar != null) {
            return cVar;
        }
        try {
            aNm = new c();
            com.kwad.sdk.utils.c.a cU = bd.cU(((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext());
            if (cU != null && (aVar = cU.bhT) != null) {
                aNm.latitude = aVar.getLatitude();
                aNm.longitude = cU.bhT.getLongitude();
                aNm.type = cU.type;
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
        return aNm;
    }

    @Override // com.kwad.sdk.core.b
    public final void parseJson(JSONObject jSONObject) {
    }

    @Override // com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        aa.putValue(jSONObject, "latitude", this.latitude);
        aa.putValue(jSONObject, "longitude", this.longitude);
        aa.putValue(jSONObject, PointParamKey.TYPE, this.type);
        return jSONObject;
    }
}
