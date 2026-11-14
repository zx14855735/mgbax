package com.kwad.sdk.liteapi.report;

import A5SV6n.A2egSU;
import ADYaiT.CtFAbx;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import org.json.JSONObject;

@A2egSU
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class LiteApiReportResponse {
    String errorMsg;
    long result;

    public boolean isLegal() {
        return this.result == 1;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.result = jSONObject.optLong("result");
        this.errorMsg = jSONObject.optString(MediationConstant.KEY_ERROR_MSG);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("LiteApiReportResponse{result=");
        sb.append(this.result);
        sb.append(", errorMsg='");
        return CtFAbx.B25kr6(sb, this.errorMsg, "'}");
    }
}
