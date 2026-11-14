package com.kwad.sdk.core.b.a;

import J3FDQU.A2egSU;
import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class jl implements com.kwad.sdk.core.d<AdInfo.RewardFraudVerifyInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdInfo.RewardFraudVerifyInfo rewardFraudVerifyInfo, JSONObject jSONObject) {
        a2(rewardFraudVerifyInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdInfo.RewardFraudVerifyInfo rewardFraudVerifyInfo, JSONObject jSONObject) {
        return b2(rewardFraudVerifyInfo, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(AdInfo.RewardFraudVerifyInfo rewardFraudVerifyInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        rewardFraudVerifyInfo.fraudVerifyAdvanceMs = A2egSU.A5SV6n("2000", "fraudVerifyAdvanceMs", jSONObject);
        rewardFraudVerifyInfo.fraudVerifySwitch = jSONObject.optBoolean("fraudVerifySwitch");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdInfo.RewardFraudVerifyInfo rewardFraudVerifyInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "fraudVerifyAdvanceMs", rewardFraudVerifyInfo.fraudVerifyAdvanceMs);
        boolean z = rewardFraudVerifyInfo.fraudVerifySwitch;
        if (z) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "fraudVerifySwitch", z);
        }
        return jSONObject;
    }
}
