package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdMatrixInfo;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class ki implements com.kwad.sdk.core.d<AdMatrixInfo.SlideInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdMatrixInfo.SlideInfo slideInfo, JSONObject jSONObject) {
        a2(slideInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdMatrixInfo.SlideInfo slideInfo, JSONObject jSONObject) {
        return b2(slideInfo, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(AdMatrixInfo.SlideInfo slideInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        slideInfo.angle = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("angle");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                slideInfo.angle.add((Integer) optJSONArray.opt(i));
            }
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdMatrixInfo.SlideInfo slideInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "angle", slideInfo.angle);
        return jSONObject;
    }
}
