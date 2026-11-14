package com.kwad.sdk.core.b.a;

import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class mj implements com.kwad.sdk.core.d<com.kwad.components.core.webview.tachikoma.c.y> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.webview.tachikoma.c.y yVar, JSONObject jSONObject) {
        a2(yVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.webview.tachikoma.c.y yVar, JSONObject jSONObject) {
        return b2(yVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.components.core.webview.tachikoma.c.y yVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        yVar.alj = jSONObject.optString("status");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(yVar.alj)) {
            yVar.alj = "";
        }
        yVar.errorCode = jSONObject.optInt(MediationConstant.KEY_ERROR_CODE);
        yVar.errorReason = jSONObject.optString("errorReason");
        if (obj.toString().equals(yVar.errorReason)) {
            yVar.errorReason = "";
        }
        yVar.qy = jSONObject.optInt("currentTime");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.components.core.webview.tachikoma.c.y yVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = yVar.alj;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "status", yVar.alj);
        }
        int i = yVar.errorCode;
        if (i != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, MediationConstant.KEY_ERROR_CODE, i);
        }
        String str2 = yVar.errorReason;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "errorReason", yVar.errorReason);
        }
        int i2 = yVar.qy;
        if (i2 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "currentTime", i2);
        }
        return jSONObject;
    }
}
