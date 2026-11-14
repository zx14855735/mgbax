package com.kwad.components.ad.c;

import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class c extends com.kwad.sdk.mvp.a {
    public SceneImpl mAdScene;
    public com.kwad.components.core.e.d.d mApkDownloadHelper;

    @Override // com.kwad.sdk.mvp.a
    public final void release() {
    }

    public final void setAdTemplate(AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
    }
}
