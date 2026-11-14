package com.kwad.sdk.mobileid.model;

import ADYaiT.CtFAbx;
import com.czhj.sdk.common.Constants;
import com.fl.saas.base.custom.MedProConst;
import com.kwad.sdk.core.response.a.a;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bp;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class CMTokenResponse extends BaseResultData implements Serializable {
    private static final long serialVersionUID = -8501365728042530876L;
    public Header mHeader = new Header();
    public Body mBody = new Body();

    public static class Body extends a implements Serializable {
        private static final long serialVersionUID = -4941153252697477901L;
        public String mResultCode;
        public String mResultDesc;
        public String mToken;

        @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
        public void parseJson(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.mResultCode = jSONObject.optString("resultCode");
            this.mResultDesc = jSONObject.optString("resultDesc");
            this.mToken = jSONObject.optString(Constants.TOKEN);
        }

        @Override // com.kwad.sdk.core.response.a.a
        public String toString() {
            StringBuilder sb = new StringBuilder("Body{mResultCode='");
            sb.append(this.mResultCode);
            sb.append("', mResultDesc='");
            sb.append(this.mResultDesc);
            sb.append("', mToken='");
            return CtFAbx.B25kr6(sb, this.mToken, "'}");
        }
    }

    public static class Header extends a implements Serializable {
        private static final long serialVersionUID = -1244494639407773564L;
        public String mAppId;
        public String mTimestamp;
        public String mTraceId;

        @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
        public void parseJson(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.mTraceId = jSONObject.optString("traceId");
            this.mTimestamp = jSONObject.optString("timestamp");
            this.mAppId = jSONObject.optString(MedProConst.AD_APPID);
        }

        @Override // com.kwad.sdk.core.response.a.a
        public String toString() {
            StringBuilder sb = new StringBuilder("Header{mTraceId='");
            sb.append(this.mTraceId);
            sb.append("', mTimestamp='");
            sb.append(this.mTimestamp);
            sb.append("', mAppId='");
            return CtFAbx.B25kr6(sb, this.mAppId, "'}");
        }
    }

    public String getResultCode() {
        return this.mBody.mResultCode;
    }

    public String getResultMsg() {
        return this.mBody.mResultDesc;
    }

    public String getResultToken() {
        return this.mBody.mToken;
    }

    @Override // com.kwad.sdk.core.response.model.BaseResultData
    public boolean isResultOk() {
        String str = this.mBody.mResultCode;
        return str != null && str.equals("103000");
    }

    @Override // com.kwad.sdk.core.response.model.BaseResultData, com.kwad.sdk.core.b
    public void parseJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            String optString = jSONObject.optString("header");
            String optString2 = jSONObject.optString("body");
            if (bp.isNullString(optString)) {
                return;
            }
            try {
                JSONObject jSONObject2 = new JSONObject(optString);
                Header header = new Header();
                this.mHeader = header;
                header.parseJson(jSONObject2);
                JSONObject jSONObject3 = new JSONObject(optString2);
                Body body = new Body();
                this.mBody = body;
                body.parseJson(jSONObject3);
            } catch (JSONException e) {
                ServiceProvider.reportSdkCaughtException(e);
            }
        } catch (Throwable unused) {
        }
    }

    public String toString() {
        return "UaidTokenResponse{mHeader=" + this.mHeader + ", mBody=" + this.mBody + '}';
    }
}
