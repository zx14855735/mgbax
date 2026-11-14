package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class jq implements com.kwad.sdk.core.d<AdInfo.RewardRetryTaskInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdInfo.RewardRetryTaskInfo rewardRetryTaskInfo, JSONObject jSONObject) {
        a2(rewardRetryTaskInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdInfo.RewardRetryTaskInfo rewardRetryTaskInfo, JSONObject jSONObject) {
        return b2(rewardRetryTaskInfo, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(AdInfo.RewardRetryTaskInfo rewardRetryTaskInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        rewardRetryTaskInfo.retryMaxTime = jSONObject.optInt("retryMaxTime");
        rewardRetryTaskInfo.rewardRetryTaskType = jSONObject.optInt("rewardRetryTaskType");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdInfo.RewardRetryTaskInfo rewardRetryTaskInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = rewardRetryTaskInfo.retryMaxTime;
        if (i != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "retryMaxTime", i);
        }
        int i2 = rewardRetryTaskInfo.rewardRetryTaskType;
        if (i2 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "rewardRetryTaskType", i2);
        }
        return jSONObject;
    }
}
