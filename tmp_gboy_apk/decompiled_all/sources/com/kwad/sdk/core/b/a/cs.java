package com.kwad.sdk.core.b.a;

import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class cs implements com.kwad.sdk.core.d<AdMatrixInfo.ComponentTemplateInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdMatrixInfo.ComponentTemplateInfo componentTemplateInfo, JSONObject jSONObject) {
        a2(componentTemplateInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdMatrixInfo.ComponentTemplateInfo componentTemplateInfo, JSONObject jSONObject) {
        return b2(componentTemplateInfo, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(AdMatrixInfo.ComponentTemplateInfo componentTemplateInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        componentTemplateInfo.pageId = jSONObject.optLong(MediationConstant.KEY_USE_POLICY_PAGE_ID);
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdMatrixInfo.ComponentTemplateInfo componentTemplateInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j = componentTemplateInfo.pageId;
        if (j != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, MediationConstant.KEY_USE_POLICY_PAGE_ID, j);
        }
        return jSONObject;
    }
}
