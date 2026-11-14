package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdMatrixInfo;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class lg implements com.kwad.sdk.core.d<AdMatrixInfo.StyleComponentInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdMatrixInfo.StyleComponentInfo styleComponentInfo, JSONObject jSONObject) {
        a2(styleComponentInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdMatrixInfo.StyleComponentInfo styleComponentInfo, JSONObject jSONObject) {
        return b2(styleComponentInfo, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(AdMatrixInfo.StyleComponentInfo styleComponentInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        AdMatrixInfo.ComponentTemplateInfo componentTemplateInfo = new AdMatrixInfo.ComponentTemplateInfo();
        styleComponentInfo.playCardInfo = componentTemplateInfo;
        componentTemplateInfo.parseJson(jSONObject.optJSONObject("playCardInfo"));
        AdMatrixInfo.ComponentTemplateInfo componentTemplateInfo2 = new AdMatrixInfo.ComponentTemplateInfo();
        styleComponentInfo.endCardInfo = componentTemplateInfo2;
        componentTemplateInfo2.parseJson(jSONObject.optJSONObject("endCardInfo"));
        styleComponentInfo.styleComponentFlag = jSONObject.optBoolean("styleComponentFlag");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdMatrixInfo.StyleComponentInfo styleComponentInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.aa.a(jSONObject, "playCardInfo", styleComponentInfo.playCardInfo);
        com.kwad.sdk.utils.aa.a(jSONObject, "endCardInfo", styleComponentInfo.endCardInfo);
        boolean z = styleComponentInfo.styleComponentFlag;
        if (z) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "styleComponentFlag", z);
        }
        return jSONObject;
    }
}
