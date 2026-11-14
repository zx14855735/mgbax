package com.kwad.components.ad.c;

import android.content.Context;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.l;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class a extends com.kwad.sdk.components.e implements com.kwad.components.ad.b.a {
    @Override // com.kwad.sdk.components.b
    public final Class getComponentsType() {
        return com.kwad.components.ad.b.a.class;
    }

    @Override // com.kwad.sdk.components.b
    public final void init(Context context) {
    }

    @Override // com.kwad.components.ad.b.a
    public final void loadBannerAd(KsScene ksScene, KsLoadManager.BannerAdListener bannerAdListener) {
        if (l.DP().Eq()) {
            g.loadBannerAd(ksScene, bannerAdListener);
        } else {
            com.kwad.sdk.core.network.e eVar = com.kwad.sdk.core.network.e.aJl;
            bannerAdListener.onError(eVar.errorCode, eVar.msg);
        }
    }
}
