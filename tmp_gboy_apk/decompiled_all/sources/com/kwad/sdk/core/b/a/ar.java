package com.kwad.sdk.core.b.a;

import J3FDQU.A2egSU;
import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class ar implements com.kwad.sdk.core.d<AdInfo.AdSplashInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdInfo.AdSplashInfo adSplashInfo, JSONObject jSONObject) {
        a2(adSplashInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdInfo.AdSplashInfo adSplashInfo, JSONObject jSONObject) {
        return b2(adSplashInfo, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(AdInfo.AdSplashInfo adSplashInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adSplashInfo.logoPosition = A2egSU.A5SV6n("1", "logoPosition", jSONObject);
        adSplashInfo.mute = A2egSU.A5SV6n("1", com.sigmob.sdk.base.common.a.z, jSONObject);
        adSplashInfo.skipType = jSONObject.optInt("skipType");
        adSplashInfo.skipTips = jSONObject.optString("skipTips");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(adSplashInfo.skipTips)) {
            adSplashInfo.skipTips = "";
        }
        adSplashInfo.speakerMuteIconUrl = jSONObject.optString("speakerMuteIconUrl");
        if (obj.toString().equals(adSplashInfo.speakerMuteIconUrl)) {
            adSplashInfo.speakerMuteIconUrl = "";
        }
        adSplashInfo.speakerIconUrl = jSONObject.optString("speakerIconUrl");
        if (obj.toString().equals(adSplashInfo.speakerIconUrl)) {
            adSplashInfo.speakerIconUrl = "";
        }
        adSplashInfo.imageDisplaySecond = A2egSU.A5SV6n("5", "imageDisplaySecond", jSONObject);
        adSplashInfo.videoDisplaySecond = A2egSU.A5SV6n("5", "videoDisplaySecond", jSONObject);
        adSplashInfo.countdownShow = jSONObject.optInt("countdownShow");
        adSplashInfo.fullScreenClickSwitch = jSONObject.optInt("fullScreenClickSwitch");
        adSplashInfo.skipButtonPosition = jSONObject.optInt("skipButtonPosition");
        adSplashInfo.splashShowClickButtonSwitch = A2egSU.A5SV6n("1", "splashShowClickButtonSwitch", jSONObject);
        adSplashInfo.skipSecond = jSONObject.optInt("skipSecond");
        adSplashInfo.impressionStatisticalChangeSwitch = jSONObject.optBoolean("impressionStatisticalChangeSwitch");
        adSplashInfo.impressionLimitSize = jSONObject.optDouble("impressionLimitSize");
        AdInfo.CutRuleInfo cutRuleInfo = new AdInfo.CutRuleInfo();
        adSplashInfo.cutRuleInfo = cutRuleInfo;
        cutRuleInfo.parseJson(jSONObject.optJSONObject("cutRuleInfo"));
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdInfo.AdSplashInfo adSplashInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "logoPosition", adSplashInfo.logoPosition);
        com.kwad.sdk.utils.aa.putValue(jSONObject, com.sigmob.sdk.base.common.a.z, adSplashInfo.mute);
        int i = adSplashInfo.skipType;
        if (i != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "skipType", i);
        }
        String str = adSplashInfo.skipTips;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "skipTips", adSplashInfo.skipTips);
        }
        String str2 = adSplashInfo.speakerMuteIconUrl;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "speakerMuteIconUrl", adSplashInfo.speakerMuteIconUrl);
        }
        String str3 = adSplashInfo.speakerIconUrl;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "speakerIconUrl", adSplashInfo.speakerIconUrl);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "imageDisplaySecond", adSplashInfo.imageDisplaySecond);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "videoDisplaySecond", adSplashInfo.videoDisplaySecond);
        int i2 = adSplashInfo.countdownShow;
        if (i2 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "countdownShow", i2);
        }
        int i3 = adSplashInfo.fullScreenClickSwitch;
        if (i3 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "fullScreenClickSwitch", i3);
        }
        int i4 = adSplashInfo.skipButtonPosition;
        if (i4 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "skipButtonPosition", i4);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "splashShowClickButtonSwitch", adSplashInfo.splashShowClickButtonSwitch);
        int i5 = adSplashInfo.skipSecond;
        if (i5 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "skipSecond", i5);
        }
        boolean z = adSplashInfo.impressionStatisticalChangeSwitch;
        if (z) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "impressionStatisticalChangeSwitch", z);
        }
        double d = adSplashInfo.impressionLimitSize;
        if (d != 0.0d) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "impressionLimitSize", d);
        }
        com.kwad.sdk.utils.aa.a(jSONObject, "cutRuleInfo", adSplashInfo.cutRuleInfo);
        return jSONObject;
    }
}
