package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdMatrixInfo;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class fy implements com.kwad.sdk.core.d<AdMatrixInfo.InnerEcAuthInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdMatrixInfo.InnerEcAuthInfo innerEcAuthInfo, JSONObject jSONObject) {
        a2(innerEcAuthInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdMatrixInfo.InnerEcAuthInfo innerEcAuthInfo, JSONObject jSONObject) {
        return b2(innerEcAuthInfo, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(AdMatrixInfo.InnerEcAuthInfo innerEcAuthInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        innerEcAuthInfo.closureAuthToastSwitch = jSONObject.optBoolean("closureAuthToastSwitch");
        innerEcAuthInfo.closureAuthToastText = jSONObject.optString("closureAuthToastText");
        if (JSONObject.NULL.toString().equals(innerEcAuthInfo.closureAuthToastText)) {
            innerEcAuthInfo.closureAuthToastText = "";
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdMatrixInfo.InnerEcAuthInfo innerEcAuthInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z = innerEcAuthInfo.closureAuthToastSwitch;
        if (z) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "closureAuthToastSwitch", z);
        }
        String str = innerEcAuthInfo.closureAuthToastText;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "closureAuthToastText", innerEcAuthInfo.closureAuthToastText);
        }
        return jSONObject;
    }
}
