package com.kwad.components.ad.reward.n;

import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class r {
    private AdTemplate mAdTemplate;
    private com.kwad.components.core.e.d.d mApkDownloadHelper;

    private r() {
    }

    public static r a(AdTemplate adTemplate, com.kwad.components.core.e.d.d dVar) {
        r rVar = new r();
        rVar.setAdTemplate(adTemplate);
        rVar.setApkDownloadHelper(dVar);
        return rVar;
    }

    public static r ad(AdTemplate adTemplate) {
        r rVar = new r();
        rVar.setAdTemplate(adTemplate);
        return rVar;
    }

    private void setAdTemplate(AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
    }

    private void setApkDownloadHelper(com.kwad.components.core.e.d.d dVar) {
        this.mApkDownloadHelper = dVar;
    }

    public final AdTemplate getAdTemplate() {
        return this.mAdTemplate;
    }

    public final com.kwad.components.core.e.d.d ik() {
        return this.mApkDownloadHelper;
    }
}
