package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class t implements com.kwad.sdk.core.d<AdInfo.AdDrawInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdInfo.AdDrawInfo adDrawInfo, JSONObject jSONObject) {
        a2(adDrawInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdInfo.AdDrawInfo adDrawInfo, JSONObject jSONObject) {
        return b2(adDrawInfo, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(AdInfo.AdDrawInfo adDrawInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adDrawInfo.videoSoundType = jSONObject.optInt("videoSoundType");
        AdInfo.AdLiveTypeInfo adLiveTypeInfo = new AdInfo.AdLiveTypeInfo();
        adDrawInfo.liveTypeInfo = adLiveTypeInfo;
        adLiveTypeInfo.parseJson(jSONObject.optJSONObject("liveTypeInfo"));
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdInfo.AdDrawInfo adDrawInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = adDrawInfo.videoSoundType;
        if (i != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "videoSoundType", i);
        }
        com.kwad.sdk.utils.aa.a(jSONObject, "liveTypeInfo", adDrawInfo.liveTypeInfo);
        return jSONObject;
    }
}
