package com.kwad.sdk.core.b.a;

import J3FDQU.A2egSU;
import com.kwad.sdk.core.response.model.AdInfo;
import com.sigmob.sdk.base.mta.PointType;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class ap implements com.kwad.sdk.core.d<AdInfo.AdRewardInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdInfo.AdRewardInfo adRewardInfo, JSONObject jSONObject) {
        a2(adRewardInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdInfo.AdRewardInfo adRewardInfo, JSONObject jSONObject) {
        return b2(adRewardInfo, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(AdInfo.AdRewardInfo adRewardInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adRewardInfo.skipShowTime = A2egSU.A5SV6n(PointType.DOWNLOAD_TRACKING, "skipShowTime", jSONObject);
        adRewardInfo.rewardTime = A2egSU.A5SV6n(PointType.DOWNLOAD_TRACKING, "rewardTime", jSONObject);
        adRewardInfo.showLandingPage = jSONObject.optInt("showLandingPage");
        adRewardInfo.rewardVideoEndCardSwitch = jSONObject.optBoolean("rewardVideoEndCardSwitch");
        adRewardInfo.recommendAggregateSwitch = jSONObject.optBoolean("recommendAggregateSwitch");
        AdInfo.CallBackStrategyInfo callBackStrategyInfo = new AdInfo.CallBackStrategyInfo();
        adRewardInfo.callBackStrategyInfo = callBackStrategyInfo;
        callBackStrategyInfo.parseJson(jSONObject.optJSONObject("callBackStrategyInfo"));
        AdInfo.RewardFraudVerifyInfo rewardFraudVerifyInfo = new AdInfo.RewardFraudVerifyInfo();
        adRewardInfo.rewardFraudVerifyInfo = rewardFraudVerifyInfo;
        rewardFraudVerifyInfo.parseJson(jSONObject.optJSONObject("rewardFraudVerifyInfo"));
        AdInfo.RewardRetryTaskInfo rewardRetryTaskInfo = new AdInfo.RewardRetryTaskInfo();
        adRewardInfo.rewardRetryTaskInfo = rewardRetryTaskInfo;
        rewardRetryTaskInfo.parseJson(jSONObject.optJSONObject("rewardRetryTaskInfo"));
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdInfo.AdRewardInfo adRewardInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "skipShowTime", adRewardInfo.skipShowTime);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "rewardTime", adRewardInfo.rewardTime);
        int i = adRewardInfo.showLandingPage;
        if (i != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "showLandingPage", i);
        }
        boolean z = adRewardInfo.rewardVideoEndCardSwitch;
        if (z) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "rewardVideoEndCardSwitch", z);
        }
        boolean z2 = adRewardInfo.recommendAggregateSwitch;
        if (z2) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "recommendAggregateSwitch", z2);
        }
        com.kwad.sdk.utils.aa.a(jSONObject, "callBackStrategyInfo", adRewardInfo.callBackStrategyInfo);
        com.kwad.sdk.utils.aa.a(jSONObject, "rewardFraudVerifyInfo", adRewardInfo.rewardFraudVerifyInfo);
        com.kwad.sdk.utils.aa.a(jSONObject, "rewardRetryTaskInfo", adRewardInfo.rewardRetryTaskInfo);
        return jSONObject;
    }
}
