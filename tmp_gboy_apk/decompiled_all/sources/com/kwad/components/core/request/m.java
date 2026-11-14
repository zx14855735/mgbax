package com.kwad.components.core.request;

import android.text.TextUtils;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.aa;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class m extends com.kwad.sdk.core.network.d {
    public m(AdTemplate adTemplate) {
        String bT = com.kwad.sdk.core.response.b.a.bT(com.kwad.sdk.core.response.b.e.er(adTemplate));
        try {
            String bU = com.kwad.sdk.core.response.b.a.bU(com.kwad.sdk.core.response.b.e.er(adTemplate));
            String bV = com.kwad.sdk.core.response.b.a.bV(com.kwad.sdk.core.response.b.e.er(adTemplate));
            if (!TextUtils.isEmpty(bV)) {
                putBody("adExt", bV);
            }
            if (!TextUtils.isEmpty(bU)) {
                putBody("serverExt", new JSONObject(bU));
            }
            if (!TextUtils.isEmpty(bT) && bT != null) {
                putBody("callbackUrlInfo", new JSONObject(bT).toString());
            }
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
        }
        ImpInfo impInfo = new ImpInfo(adTemplate.mAdScene);
        JSONArray jSONArray = new JSONArray();
        aa.a(jSONArray, impInfo.toJson());
        putBody("impInfo", jSONArray);
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final String getUrl() {
        return com.kwad.sdk.h.CD();
    }
}
