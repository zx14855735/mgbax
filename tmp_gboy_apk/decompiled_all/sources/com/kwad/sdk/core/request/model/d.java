package com.kwad.sdk.core.request.model;

import android.content.Context;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.bc;
import com.kwad.sdk.utils.bd;

@KsJson
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class d extends com.kwad.sdk.core.response.a.a {
    public String aNn;
    public String aNo;
    public int aNp;
    public int operatorType;

    public static d KE() {
        d dVar = new d();
        try {
            Context Re = ServiceProvider.Re();
            dVar.aNn = bd.dC(Re);
            dVar.aNo = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).CX();
            dVar.aNp = ao.dp(Re);
            dVar.operatorType = ao.e(Re, bd.dF(Re), bc.useNetworkStateDisable());
            return dVar;
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
            return dVar;
        }
    }

    public static d KF() {
        d dVar = new d();
        dVar.aNp = ao.dp(ServiceProvider.getContext());
        return dVar;
    }
}
