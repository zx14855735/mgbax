package com.kwad.components.ad.nativead.a;

import com.kwad.components.ad.nativead.d;
import com.kwad.components.core.e.d.d;
import com.kwad.sdk.api.KsNativeAd;
import com.kwad.sdk.core.view.AdBasePvFrameLayout;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class b extends com.kwad.sdk.mvp.a {
    public d mApkDownloadHelper;
    public KsNativeAd.VideoPlayListener oP;
    public d.a oV;
    public AdBasePvFrameLayout pk;
    public com.kwad.components.ad.nativead.c.a pq;
    public boolean pv = false;
    public boolean pw = false;

    @Override // com.kwad.sdk.mvp.a
    public final void release() {
        com.kwad.components.core.e.d.d dVar = this.mApkDownloadHelper;
        if (dVar != null) {
            dVar.clear();
        }
        this.pq.release();
    }
}
