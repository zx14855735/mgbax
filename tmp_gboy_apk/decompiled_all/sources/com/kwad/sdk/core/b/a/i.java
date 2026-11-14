package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class i implements com.kwad.sdk.core.d<AdInfo.AdBannerInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdInfo.AdBannerInfo adBannerInfo, JSONObject jSONObject) {
        a2(adBannerInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdInfo.AdBannerInfo adBannerInfo, JSONObject jSONObject) {
        return b2(adBannerInfo, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(AdInfo.AdBannerInfo adBannerInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adBannerInfo.videoSoundType = jSONObject.optInt("videoSoundType");
        adBannerInfo.videoAutoPlayType = jSONObject.optInt("videoAutoPlayType");
        adBannerInfo.isSupportCarousel = jSONObject.optBoolean("isSupportCarousel");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdInfo.AdBannerInfo adBannerInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = adBannerInfo.videoSoundType;
        if (i != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "videoSoundType", i);
        }
        int i2 = adBannerInfo.videoAutoPlayType;
        if (i2 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "videoAutoPlayType", i2);
        }
        boolean z = adBannerInfo.isSupportCarousel;
        if (z) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "isSupportCarousel", z);
        }
        return jSONObject;
    }
}
