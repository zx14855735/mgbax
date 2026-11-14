package com.kwad.components.ad.interstitial.f;

import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.kwad.components.core.video.a;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bw;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class e extends b implements a.c {
    private static long na = 1000;
    private AdTemplate mAdTemplate;
    private c mi;
    private a nb;
    private int nc;

    /* JADX INFO: Access modifiers changed from: private */
    public void P(int i) {
        c cVar = this.mi;
        com.kwad.components.ad.interstitial.h.d dVar = cVar.mj;
        if (dVar == null) {
            return;
        }
        if (i != 0) {
            dVar.b(true, i);
        } else {
            if (cVar.dW()) {
                return;
            }
            this.mi.c(getContext(), this.mAdTemplate);
            ew();
            c cVar2 = this.mi;
            cVar2.a(true, -1, cVar2.cq);
        }
    }

    private void ew() {
        com.kwad.sdk.core.video.videoview.a aVar = this.mi.cq;
        if (aVar != null) {
            aVar.release();
        }
        this.mi.kV.dismiss();
        this.mi.Y();
    }

    @Override // com.kwad.components.core.video.a.c
    public final void ap() {
    }

    @Override // com.kwad.components.core.video.a.c
    public final void aq() {
        if (this.mi.dW()) {
            return;
        }
        this.mi.c(getContext(), this.mAdTemplate);
        ew();
    }

    @Override // com.kwad.components.ad.interstitial.f.b, com.kwad.sdk.mvp.Presenter
    public final void as() {
        super.as();
        com.kwad.sdk.core.d.c.d("InterstitialPlayablePresenter", this + " onBind");
        c cVar = (c) PC();
        this.mi = cVar;
        AdTemplate adTemplate = cVar.mAdTemplate;
        this.mAdTemplate = adTemplate;
        AdInfo er = com.kwad.sdk.core.response.b.e.er(adTemplate);
        long j = er.adInsertScreenInfo.autoCloseTime;
        if (j > 0) {
            this.nc = (int) Math.min(com.kwad.components.ad.interstitial.b.b.b(er), j);
        } else {
            this.nc = com.kwad.components.ad.interstitial.b.b.b(er);
        }
        com.kwad.components.ad.interstitial.h.d dVar = this.mi.mj;
        if (dVar != null) {
            dVar.b(true, this.nc);
        }
        if (com.kwad.sdk.core.response.b.a.bd(er)) {
            this.nb = null;
            this.mi.a(this);
        } else {
            a aVar = new a(this, (byte) 0);
            this.nb = aVar;
            bw.a(aVar, null, 1000L);
        }
    }

    @Override // com.kwad.components.core.video.a.c
    public final void d(long j) {
        P(this.nc - ((int) (j / 1000)));
    }

    @Override // com.kwad.components.ad.interstitial.f.b
    public final void dS() {
        super.dS();
        a aVar = this.nb;
        if (aVar != null) {
            aVar.s(false);
        }
    }

    @Override // com.kwad.components.ad.interstitial.f.b
    public final void dT() {
        super.dT();
        a aVar = this.nb;
        if (aVar != null) {
            aVar.s(true);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.sdk.core.d.c.d("InterstitialPlayablePresenter", this + " onUnbind");
        this.mi.b(this);
        a aVar = this.nb;
        if (aVar != null) {
            aVar.r(true);
            bw.c(this.nb);
            this.nb = null;
        }
    }

    @Override // com.kwad.components.core.video.a.c
    public final void onVideoPlayStart() {
    }

    public class a implements Runnable {
        private int nd;
        private boolean ne;
        private boolean nf;

        private a() {
            this.nd = Integer.MIN_VALUE;
            this.ne = false;
            this.nf = false;
        }

        public final void r(boolean z) {
            this.nf = true;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.nf) {
                return;
            }
            if (this.ne) {
                bw.a(this, null, e.na);
                return;
            }
            if (this.nd == Integer.MIN_VALUE) {
                this.nd = e.this.nc;
            }
            if (this.nd < 0) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(e.this.toString());
            sb.append(", this: ");
            sb.append(toString());
            sb.append(" PlayableTimerRunnable run : ");
            A2egSU.BChYOn(sb, this.nd, "InterstitialPlayablePresenter");
            e.this.P(this.nd);
            this.nd--;
            bw.a(this, null, e.na);
        }

        public final void s(boolean z) {
            this.ne = z;
        }

        public /* synthetic */ a(e eVar, byte b) {
            this();
        }
    }
}
