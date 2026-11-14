package com.kwad.components.core.j;

import com.kwad.sdk.api.KsInnerAd;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
final class b implements KsInnerAd {
    private final int SA;
    private final AdTemplate mAdTemplate;

    public b(AdTemplate adTemplate, int i) {
        this.mAdTemplate = adTemplate;
        this.SA = i;
    }

    public final AdTemplate getAdTemplate() {
        return this.mAdTemplate;
    }

    @Override // com.kwad.sdk.api.KsInnerAd
    public final int getType() {
        return this.SA;
    }
}
