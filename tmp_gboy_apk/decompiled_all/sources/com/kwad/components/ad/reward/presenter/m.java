package com.kwad.components.ad.reward.presenter;

import com.kwad.sdk.core.response.model.AdInfo;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class m extends b {
    private long jX;
    private com.kwad.components.ad.reward.e.b rG;
    private com.kwad.components.core.video.m vU;
    private com.kwad.components.core.video.m vV = new com.kwad.components.core.video.m() { // from class: com.kwad.components.ad.reward.presenter.m.1
        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayCompleted() {
            super.onMediaPlayCompleted();
            m mVar = m.this;
            com.kwad.components.ad.reward.g gVar = mVar.tq;
            if (gVar.rW && gVar.sb) {
                mVar.rG.onVideoSkipToEnd(m.this.jX);
            } else {
                gVar.sw = true;
                mVar.rG.onVideoPlayEnd();
            }
            AdInfo er = com.kwad.sdk.core.response.b.e.er(m.this.tq.mAdTemplate);
            if (com.kwad.sdk.core.response.b.a.aP(er) && com.kwad.sdk.core.response.b.a.aO(er) == 1) {
                return;
            }
            f.u(m.this.tq);
            com.kwad.components.ad.reward.g gVar2 = m.this.tq;
            if (gVar2.sw) {
                com.kwad.components.ad.reward.l.j(gVar2);
            }
        }

        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayProgress(long j, long j2) {
            super.onMediaPlayProgress(j, j2);
            m mVar = m.this;
            com.kwad.components.ad.reward.g gVar = mVar.tq;
            gVar.sv = j2;
            if (gVar.sb) {
                return;
            }
            mVar.jX = j2;
        }

        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayStart() {
            super.onMediaPlayStart();
            m.this.rG.onVideoPlayStart();
            m.this.tq.sw = false;
        }
    };
    private final com.kwad.components.core.video.m jE = new com.kwad.components.core.video.m() { // from class: com.kwad.components.ad.reward.presenter.m.2
        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayCompleted() {
            m mVar = m.this;
            if (mVar.tq.sb) {
                mVar.rG.onVideoSkipToEnd(m.this.jX);
            } else {
                mVar.rG.onVideoPlayEnd();
            }
            AdInfo er = com.kwad.sdk.core.response.b.e.er(m.this.tq.mAdTemplate);
            if (com.kwad.sdk.core.response.b.a.aP(er) && com.kwad.sdk.core.response.b.a.aO(er) == 1) {
                return;
            }
            f.u(m.this.tq);
            com.kwad.components.ad.reward.g gVar = m.this.tq;
            if (gVar.sw) {
                com.kwad.components.ad.reward.l.j(gVar);
            }
        }

        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayError(int i, int i2) {
            m.this.rG.onVideoPlayError(i, i2);
            m.this.iA();
        }

        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayProgress(long j, long j2) {
            m mVar = m.this;
            com.kwad.components.ad.reward.g gVar = mVar.tq;
            gVar.sv = j2;
            gVar.sw = j - j2 < 800;
            if (gVar.sb) {
                return;
            }
            mVar.jX = j2;
        }

        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayStart() {
            m.this.rG.onVideoPlayStart();
        }
    };

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void as() {
        super.as();
        com.kwad.components.ad.reward.g gVar = this.tq;
        gVar.sv = 0L;
        gVar.sw = false;
        this.rG = gVar.rG;
        if (gVar.rH.lh()) {
            this.vU = this.vV;
        } else {
            this.vU = this.jE;
        }
        this.tq.rH.a(this.vU);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.tq.rH.b(this.vU);
    }
}
