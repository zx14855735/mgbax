package com.kwad.components.ad.reward.model;

import com.bytedance.android.live.base.api.push.ILivePush;
import com.kwad.sdk.core.response.model.AdInfo;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class d {
    public static String m(AdInfo adInfo) {
        return com.kwad.sdk.core.response.b.a.cS(adInfo) ? ILivePush.ClickType.LIVE : com.kwad.sdk.core.response.b.a.be(adInfo) ? "image" : com.kwad.sdk.core.response.b.a.cg(adInfo) ? "reward_preview" : "video";
    }
}
