package com.kwad.components.ad.draw.b;

import android.content.Context;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.e.d.d;
import com.kwad.components.offline.api.core.adlive.IAdLiveOfflineView;
import com.kwad.components.offline.api.core.adlive.IAdLivePlayModule;
import com.kwad.sdk.api.KsDrawAd;
import com.kwad.sdk.core.adlog.c;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.service.ServiceProvider;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class b extends com.kwad.sdk.mvp.a {
    private boolean dA;
    public com.kwad.components.ad.draw.c.a dB;
    public IAdLivePlayModule dC;
    public IAdLiveOfflineView dD;
    public com.kwad.components.ad.draw.presenter.b.a dE;
    public com.kwad.components.ad.l.b dF;
    public KsDrawAd.AdInteractionListener dh;
    public d mApkDownloadHelper;
    public AdBaseFrameLayout mRootContainer;

    @Override // com.kwad.sdk.mvp.a
    public final void release() {
        d dVar = this.mApkDownloadHelper;
        if (dVar != null) {
            dVar.clear();
        }
        IAdLivePlayModule iAdLivePlayModule = this.dC;
        if (iAdLivePlayModule != null) {
            iAdLivePlayModule.release();
            this.dC = null;
        }
        IAdLiveOfflineView iAdLiveOfflineView = this.dD;
        if (iAdLiveOfflineView != null) {
            iAdLiveOfflineView.onDestroy();
            this.dD = null;
        }
        com.kwad.components.ad.draw.c.a aVar = this.dB;
        if (aVar != null) {
            aVar.release();
        }
    }

    public final void a(int i, Context context, final int i2, int i3) {
        a.C0291a aD = new a.C0291a(context).aE(this.mAdTemplate).b(this.mApkDownloadHelper).as(false).aD(i3);
        IAdLivePlayModule iAdLivePlayModule = this.dC;
        com.kwad.components.core.e.d.a.a(aD.A(iAdLivePlayModule == null ? 0L : iAdLivePlayModule.getPlayDuration()).aA(true).aC(i2).aB(i).a(new a.b() { // from class: com.kwad.components.ad.draw.b.b.1
            @Override // com.kwad.components.core.e.d.a.b
            public final void onAdClicked() {
                try {
                    b.this.a(i2, null);
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, com.kwad.sdk.core.adlog.c.b bVar) {
        if (bVar == null) {
            bVar = new com.kwad.sdk.core.adlog.c.b();
        }
        bVar.dv(i);
        bVar.f(this.mRootContainer.getTouchCoords());
        c.a(this.mAdTemplate, bVar, (JSONObject) null);
        KsDrawAd.AdInteractionListener adInteractionListener = this.dh;
        if (adInteractionListener != null) {
            adInteractionListener.onAdClicked();
        }
        if (this.dA) {
            return;
        }
        AdTemplate adTemplate = this.mAdTemplate;
        com.kwad.components.ad.draw.a.c.b(adTemplate, 1, com.kwad.sdk.core.response.b.b.di(adTemplate) ? 2 : 1);
        this.dA = true;
    }
}
