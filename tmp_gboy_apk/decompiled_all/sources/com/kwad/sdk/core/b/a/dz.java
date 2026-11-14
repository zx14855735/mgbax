package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdMatrixInfo;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class dz implements com.kwad.sdk.core.d<AdMatrixInfo.DynamicAdStyleInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdMatrixInfo.DynamicAdStyleInfo dynamicAdStyleInfo, JSONObject jSONObject) {
        a2(dynamicAdStyleInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdMatrixInfo.DynamicAdStyleInfo dynamicAdStyleInfo, JSONObject jSONObject) {
        return b2(dynamicAdStyleInfo, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(AdMatrixInfo.DynamicAdStyleInfo dynamicAdStyleInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        AdMatrixInfo.SlideInfo slideInfo = new AdMatrixInfo.SlideInfo();
        dynamicAdStyleInfo.slideInfo = slideInfo;
        slideInfo.parseJson(jSONObject.optJSONObject("slideInfo"));
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdMatrixInfo.DynamicAdStyleInfo dynamicAdStyleInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.aa.a(jSONObject, "slideInfo", dynamicAdStyleInfo.slideInfo);
        return jSONObject;
    }
}
