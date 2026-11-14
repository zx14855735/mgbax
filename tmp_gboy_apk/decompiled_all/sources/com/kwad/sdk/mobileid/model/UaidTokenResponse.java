package com.kwad.sdk.mobileid.model;

import android.text.TextUtils;
import com.kwad.sdk.components.d;
import com.kwad.sdk.core.a.e;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.utils.bp;
import com.sigmob.sdk.base.mta.PointParamKey;
import java.io.Serializable;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class UaidTokenResponse extends BaseResultData implements Serializable {
    private static final long serialVersionUID = -8501365728042530876L;
    public String uaid;

    @Override // com.kwad.sdk.core.response.model.BaseResultData, com.kwad.sdk.core.b
    public void parseJson(JSONObject jSONObject) {
        super.parseJson(jSONObject);
        if (jSONObject == null) {
            return;
        }
        try {
            String optString = jSONObject.optString(PointParamKey.DATA);
            e eVar = (e) d.f(e.class);
            if (bp.isNullString(optString)) {
                return;
            }
            String responseData = eVar.getResponseData(optString);
            if (TextUtils.isEmpty(responseData)) {
                return;
            }
            this.uaid = new JSONObject(responseData).optString("uaid");
        } catch (Exception e) {
            c.printStackTraceOnly(e);
        }
    }
}
