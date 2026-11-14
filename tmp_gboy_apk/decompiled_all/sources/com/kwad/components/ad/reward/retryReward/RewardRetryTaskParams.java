package com.kwad.components.ad.reward.retryReward;

import android.text.TextUtils;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.service.ServiceProvider;
import com.sigmob.sdk.base.mta.PointParamKey;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class RewardRetryTaskParams extends BaseResultData {
    private final Map<Long, a> mTaskResultMap = new HashMap();

    public static class a {
        public int conversionStatus;
        public long creativeId;
        public long llsid;

        public a(long j, long j2, int i) {
            this.llsid = j;
            this.conversionStatus = i;
            this.creativeId = j2;
        }
    }

    public Map<Long, a> getTaskResultMap() {
        return this.mTaskResultMap;
    }

    @Override // com.kwad.sdk.core.response.model.BaseResultData, com.kwad.sdk.core.b
    public void parseJson(JSONObject jSONObject) {
        super.parseJson(jSONObject);
        if (jSONObject == null) {
            return;
        }
        try {
            String optString = jSONObject.optString(PointParamKey.DATA);
            if (TextUtils.isEmpty(optString)) {
                return;
            }
            com.kwad.sdk.core.a.e eVar = (com.kwad.sdk.core.a.e) com.kwad.sdk.components.d.f(com.kwad.sdk.core.a.e.class);
            if (eVar != null) {
                optString = eVar.getResponseData(optString);
            }
            JSONArray optJSONArray = new JSONObject(optString).optJSONArray("taskInfoList");
            if (optJSONArray == null) {
                return;
            }
            for (int i = 0; optJSONArray.length() > i; i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                long optLong = optJSONObject.optLong("llsid");
                this.mTaskResultMap.put(Long.valueOf(optLong), new a(optLong, optJSONObject.optLong("creativeId"), optJSONObject.optInt("conversionStatus")));
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }
}
