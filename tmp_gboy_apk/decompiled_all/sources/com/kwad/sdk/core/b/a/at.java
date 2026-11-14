package com.kwad.sdk.core.b.a;

import J3FDQU.A2egSU;
import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class at implements com.kwad.sdk.core.d<AdInfo.AdStyleConfInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdInfo.AdStyleConfInfo adStyleConfInfo, JSONObject jSONObject) {
        a2(adStyleConfInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdInfo.AdStyleConfInfo adStyleConfInfo, JSONObject jSONObject) {
        return b2(adStyleConfInfo, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(AdInfo.AdStyleConfInfo adStyleConfInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adStyleConfInfo.fullScreenSkipShowTime = A2egSU.A5SV6n("5", "fullScreenSkipShowTime", jSONObject);
        adStyleConfInfo.rewardSkipConfirmSwitch = A2egSU.A5SV6n("1", "rewardSkipConfirmSwitch", jSONObject);
        adStyleConfInfo.closeDelaySeconds = jSONObject.optLong("closeDelaySeconds");
        adStyleConfInfo.playableCloseSeconds = jSONObject.optLong("playableCloseSeconds");
        adStyleConfInfo.rewardVideoInteractSwitch = jSONObject.optBoolean("rewardVideoInteractSwitch");
        AdInfo.AdShowVideoH5Info adShowVideoH5Info = new AdInfo.AdShowVideoH5Info();
        adStyleConfInfo.adShowVideoH5Info = adShowVideoH5Info;
        adShowVideoH5Info.parseJson(jSONObject.optJSONObject("adShowVideoH5Info"));
        adStyleConfInfo.adPushSwitch = jSONObject.optBoolean("adPushSwitch");
        adStyleConfInfo.adPushShowAfterTime = jSONObject.optInt("adPushShowAfterTime");
        adStyleConfInfo.adPushIntervalTime = A2egSU.A5SV6n("900", "adPushIntervalTime", jSONObject);
        AdInfo.NativeAdInfo nativeAdInfo = new AdInfo.NativeAdInfo();
        adStyleConfInfo.nativeAdInfo = nativeAdInfo;
        nativeAdInfo.parseJson(jSONObject.optJSONObject("nativeAdInfo"));
        adStyleConfInfo.useNativeForOuterLiveAd = jSONObject.optBoolean("useNativeForOuterLiveAd");
        adStyleConfInfo.adPushDownloadJumpType = jSONObject.optInt("adPushDownloadJumpType");
        adStyleConfInfo.actionBarType = jSONObject.optInt("actionBarType");
        adStyleConfInfo.endCardType = jSONObject.optInt("endCardType");
        adStyleConfInfo.confirmCardType = jSONObject.optInt("confirmCardType");
        adStyleConfInfo.innerAdType = jSONObject.optInt("innerAdType");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdInfo.AdStyleConfInfo adStyleConfInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "fullScreenSkipShowTime", adStyleConfInfo.fullScreenSkipShowTime);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "rewardSkipConfirmSwitch", adStyleConfInfo.rewardSkipConfirmSwitch);
        long j = adStyleConfInfo.closeDelaySeconds;
        if (j != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "closeDelaySeconds", j);
        }
        long j2 = adStyleConfInfo.playableCloseSeconds;
        if (j2 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "playableCloseSeconds", j2);
        }
        boolean z = adStyleConfInfo.rewardVideoInteractSwitch;
        if (z) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "rewardVideoInteractSwitch", z);
        }
        com.kwad.sdk.utils.aa.a(jSONObject, "adShowVideoH5Info", adStyleConfInfo.adShowVideoH5Info);
        boolean z2 = adStyleConfInfo.adPushSwitch;
        if (z2) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adPushSwitch", z2);
        }
        int i = adStyleConfInfo.adPushShowAfterTime;
        if (i != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adPushShowAfterTime", i);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "adPushIntervalTime", adStyleConfInfo.adPushIntervalTime);
        com.kwad.sdk.utils.aa.a(jSONObject, "nativeAdInfo", adStyleConfInfo.nativeAdInfo);
        boolean z3 = adStyleConfInfo.useNativeForOuterLiveAd;
        if (z3) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "useNativeForOuterLiveAd", z3);
        }
        int i2 = adStyleConfInfo.adPushDownloadJumpType;
        if (i2 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adPushDownloadJumpType", i2);
        }
        int i3 = adStyleConfInfo.actionBarType;
        if (i3 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "actionBarType", i3);
        }
        int i4 = adStyleConfInfo.endCardType;
        if (i4 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "endCardType", i4);
        }
        int i5 = adStyleConfInfo.confirmCardType;
        if (i5 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "confirmCardType", i5);
        }
        int i6 = adStyleConfInfo.innerAdType;
        if (i6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "innerAdType", i6);
        }
        return jSONObject;
    }
}
