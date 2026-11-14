package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdGlobalConfigInfo;
import com.kwad.sdk.core.response.model.AdVideoPreCacheConfig;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class w implements com.kwad.sdk.core.d<AdGlobalConfigInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdGlobalConfigInfo adGlobalConfigInfo, JSONObject jSONObject) {
        a2(adGlobalConfigInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdGlobalConfigInfo adGlobalConfigInfo, JSONObject jSONObject) {
        return b2(adGlobalConfigInfo, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(AdGlobalConfigInfo adGlobalConfigInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adGlobalConfigInfo.neoPageType = jSONObject.optInt("neoPageType");
        AdGlobalConfigInfo.NeoScanAggregationSceneInfo neoScanAggregationSceneInfo = new AdGlobalConfigInfo.NeoScanAggregationSceneInfo();
        adGlobalConfigInfo.neoScanAggregationSceneInfo = neoScanAggregationSceneInfo;
        neoScanAggregationSceneInfo.parseJson(jSONObject.optJSONObject("neoScanAggregationSceneInfo"));
        AdGlobalConfigInfo.CycleAggregationInfo cycleAggregationInfo = new AdGlobalConfigInfo.CycleAggregationInfo();
        adGlobalConfigInfo.cycleAggregationInfo = cycleAggregationInfo;
        cycleAggregationInfo.parseJson(jSONObject.optJSONObject("cycleAggregationInfo"));
        adGlobalConfigInfo.uaidEnable = jSONObject.optBoolean("uaidEnable");
        AdVideoPreCacheConfig adVideoPreCacheConfig = new AdVideoPreCacheConfig();
        adGlobalConfigInfo.adVideoPreCacheConfig = adVideoPreCacheConfig;
        adVideoPreCacheConfig.parseJson(jSONObject.optJSONObject("adVideoPreCacheConfig"));
        AdGlobalConfigInfo.RefreshToken refreshToken = new AdGlobalConfigInfo.RefreshToken();
        adGlobalConfigInfo.refreshToken = refreshToken;
        refreshToken.parseJson(jSONObject.optJSONObject("refreshToken"));
        adGlobalConfigInfo.authError = jSONObject.optLong("authError");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdGlobalConfigInfo adGlobalConfigInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = adGlobalConfigInfo.neoPageType;
        if (i != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "neoPageType", i);
        }
        com.kwad.sdk.utils.aa.a(jSONObject, "neoScanAggregationSceneInfo", adGlobalConfigInfo.neoScanAggregationSceneInfo);
        com.kwad.sdk.utils.aa.a(jSONObject, "cycleAggregationInfo", adGlobalConfigInfo.cycleAggregationInfo);
        boolean z = adGlobalConfigInfo.uaidEnable;
        if (z) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "uaidEnable", z);
        }
        com.kwad.sdk.utils.aa.a(jSONObject, "adVideoPreCacheConfig", adGlobalConfigInfo.adVideoPreCacheConfig);
        com.kwad.sdk.utils.aa.a(jSONObject, "refreshToken", adGlobalConfigInfo.refreshToken);
        long j = adGlobalConfigInfo.authError;
        if (j != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "authError", j);
        }
        return jSONObject;
    }
}
