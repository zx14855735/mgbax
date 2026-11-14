package com.kwad.components.ad.nativead;

import android.content.Context;
import com.kwad.components.ad.b.g;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.l;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class a extends com.kwad.sdk.components.e implements g {
    @Override // com.kwad.sdk.components.b
    public final Class getComponentsType() {
        return g.class;
    }

    @Override // com.kwad.sdk.components.b
    public final void init(Context context) {
    }

    @Override // com.kwad.components.ad.b.g
    public final void loadNativeAd(KsScene ksScene, KsLoadManager.NativeAdListener nativeAdListener) {
        if (l.DP().Eq()) {
            c.loadNativeAd(ksScene, nativeAdListener);
        } else {
            com.kwad.sdk.core.network.e eVar = com.kwad.sdk.core.network.e.aJl;
            nativeAdListener.onError(eVar.errorCode, eVar.msg);
        }
    }

    @Override // com.kwad.components.ad.b.g
    public final void loadNativeAd(String str, KsLoadManager.NativeAdListener nativeAdListener) {
        c.loadNativeAd(str, nativeAdListener);
    }
}
