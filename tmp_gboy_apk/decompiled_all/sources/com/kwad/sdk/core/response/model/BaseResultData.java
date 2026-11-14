package com.kwad.sdk.core.response.model;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.kwad.sdk.components.d;
import com.kwad.sdk.components.h;
import com.kwad.sdk.core.a.e;
import com.kwad.sdk.core.response.b.f;
import com.kwad.sdk.utils.aa;
import com.kwad.sdk.utils.bp;
import com.ss.android.download.api.constant.BaseConstants;
import java.io.Serializable;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public abstract class BaseResultData implements com.kwad.sdk.core.b, Serializable {
    private static final int CODE_RESULT_OK = 1;
    private static final long serialVersionUID = -8657363515914699792L;
    public String cookie;
    public String errorMsg;
    public String extra;
    public boolean hasAd;
    public long llsid;
    public int result;
    public String testErrorMsg;

    public JSONObject baseToJson() {
        JSONObject jSONObject = new JSONObject();
        aa.putValue(jSONObject, "llsid", this.llsid);
        aa.putValue(jSONObject, BaseConstants.EVENT_LABEL_EXTRA, this.extra);
        aa.putValue(jSONObject, "result", this.result);
        aa.putValue(jSONObject, "hasAd", this.hasAd);
        aa.putValue(jSONObject, MediationConstant.KEY_ERROR_MSG, this.errorMsg);
        aa.putValue(jSONObject, "testErrorMsg", this.testErrorMsg);
        aa.putValue(jSONObject, "cookie", this.cookie);
        return jSONObject;
    }

    public boolean hasData() {
        return this.hasAd;
    }

    public boolean isDataEmpty() {
        return false;
    }

    public boolean isResultOk() {
        return this.result == 1;
    }

    public boolean notifyFailOnResultError() {
        return true;
    }

    @Override // com.kwad.sdk.core.b
    public void parseJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.llsid = jSONObject.optLong("llsid");
        this.result = jSONObject.optInt("result");
        this.hasAd = jSONObject.optBoolean("hasAd");
        this.errorMsg = jSONObject.optString(MediationConstant.KEY_ERROR_MSG);
        this.testErrorMsg = jSONObject.optString("testErrorMsg");
        String optString = jSONObject.optString(BaseConstants.EVENT_LABEL_EXTRA);
        if (!bp.isNullString(optString)) {
            this.extra = ((e) d.f(e.class)).getResponseData(optString);
        }
        h hVar = (h) d.f(h.class);
        if (hVar != null) {
            hVar.at(jSONObject.optString("egid"));
            hVar.C(jSONObject.optLong("gidExpireTimeMs"));
        }
        String optString2 = jSONObject.optString("cookie");
        this.cookie = optString2;
        if (TextUtils.isEmpty(optString2)) {
            return;
        }
        f.KK().eP(this.cookie);
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        return baseToJson();
    }
}
