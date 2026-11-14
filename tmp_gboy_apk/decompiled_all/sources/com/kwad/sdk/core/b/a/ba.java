package com.kwad.sdk.core.b.a;

import J3FDQU.A2egSU;
import com.kwad.sdk.core.response.model.AdVideoPreCacheConfig;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class ba implements com.kwad.sdk.core.d<AdVideoPreCacheConfig> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdVideoPreCacheConfig adVideoPreCacheConfig, JSONObject jSONObject) {
        a2(adVideoPreCacheConfig, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdVideoPreCacheConfig adVideoPreCacheConfig, JSONObject jSONObject) {
        return b2(adVideoPreCacheConfig, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(AdVideoPreCacheConfig adVideoPreCacheConfig, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adVideoPreCacheConfig.adVideoPreCacheSize = A2egSU.A5SV6n("800", "adVideoPreCacheSize", jSONObject);
        adVideoPreCacheConfig.continueLoadingAll = jSONObject.optBoolean("continueLoadingAll");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdVideoPreCacheConfig adVideoPreCacheConfig, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "adVideoPreCacheSize", adVideoPreCacheConfig.adVideoPreCacheSize);
        boolean z = adVideoPreCacheConfig.continueLoadingAll;
        if (z) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "continueLoadingAll", z);
        }
        return jSONObject;
    }
}
