package com.kwad.sdk.core.b.a;

import J3FDQU.A2egSU;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.czhj.sdk.common.Constants;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.sigmob.sdk.base.mta.PointType;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class js implements com.kwad.sdk.core.d<AdMatrixInfo.RewardVideoTaskInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdMatrixInfo.RewardVideoTaskInfo rewardVideoTaskInfo, JSONObject jSONObject) {
        a2(rewardVideoTaskInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdMatrixInfo.RewardVideoTaskInfo rewardVideoTaskInfo, JSONObject jSONObject) {
        return b2(rewardVideoTaskInfo, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(AdMatrixInfo.RewardVideoTaskInfo rewardVideoTaskInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        rewardVideoTaskInfo.templateId = jSONObject.optString("templateId");
        if (JSONObject.NULL.toString().equals(rewardVideoTaskInfo.templateId)) {
            rewardVideoTaskInfo.templateId = "";
        }
        rewardVideoTaskInfo.showTime = A2egSU.A5SV6n("15", "showTime", jSONObject);
        rewardVideoTaskInfo.duration = A2egSU.A5SV6n(PointType.SIGMOB_APP, MediationConstant.EXTRA_DURATION, jSONObject);
        rewardVideoTaskInfo.taskType = A2egSU.A5SV6n(Constants.FAIL, "taskType", jSONObject);
        rewardVideoTaskInfo.thresholdTime = A2egSU.A5SV6n(PointType.SIGMOB_APP, "thresholdTime", jSONObject);
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdMatrixInfo.RewardVideoTaskInfo rewardVideoTaskInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = rewardVideoTaskInfo.templateId;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "templateId", rewardVideoTaskInfo.templateId);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "showTime", rewardVideoTaskInfo.showTime);
        com.kwad.sdk.utils.aa.putValue(jSONObject, MediationConstant.EXTRA_DURATION, rewardVideoTaskInfo.duration);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "taskType", rewardVideoTaskInfo.taskType);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "thresholdTime", rewardVideoTaskInfo.thresholdTime);
        return jSONObject;
    }
}
