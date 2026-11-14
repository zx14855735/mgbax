package com.kwad.components.ad.reward.presenter;

import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.webview.jshandler.as;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bw;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class r extends b implements com.kwad.components.ad.reward.e.g, com.kwad.components.ad.reward.e.j, as.b {
    private com.kwad.components.core.webview.tachikoma.f.g jM;
    private float wc;
    private boolean wr;
    private a ws;
    private q wt;
    private o wu;
    private p wv;
    private int ww;
    private boolean wx;
    private boolean wy;
    private boolean wz;

    public class a extends com.kwad.components.core.video.m {
        private long videoDuration;
        private long wB;

        private a() {
        }

        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayProgress(long j, long j2) {
            super.onMediaPlayProgress(j, j2);
            this.wB = j2;
            this.videoDuration = j;
            if (r.this.tq.gH()) {
                return;
            }
            r.this.b(j, j2, false);
        }

        public /* synthetic */ a(r rVar, byte b) {
            this();
        }
    }

    public r(AdTemplate adTemplate, boolean z, boolean z2) {
        this.ww = 0;
        this.wx = false;
        this.wy = z;
        this.wz = z2;
        if (com.kwad.sdk.core.response.b.a.bL(com.kwad.sdk.core.response.b.e.er(adTemplate))) {
            p pVar = new p();
            this.wv = pVar;
            a(pVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(long j, long j2, boolean z) {
        q qVar;
        if (!iR() || j2 < ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT || j2 < j * this.wc) {
            return;
        }
        if (!com.kwad.components.ad.reward.a.b.hI()) {
            o oVar = this.wu;
            if (oVar != null) {
                oVar.J(true ^ z);
                this.ww = 2;
                return;
            }
            return;
        }
        if (this.wx || (qVar = this.wt) == null) {
            return;
        }
        qVar.iM();
        this.ww = 1;
        this.wx = true;
    }

    private com.kwad.components.core.webview.tachikoma.f.g dg() {
        if (this.jM == null) {
            this.jM = new com.kwad.components.core.webview.tachikoma.f.g() { // from class: com.kwad.components.ad.reward.presenter.r.2
                @Override // com.kwad.components.core.webview.tachikoma.f.b
                public final void v(String str) {
                    r.this.iQ();
                }
            };
        }
        return this.jM;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iQ() {
        if (this.wz) {
            q qVar = new q(this);
            this.wt = qVar;
            a((Presenter) qVar, true);
        }
        if (this.wy) {
            o oVar = new o(this);
            this.wu = oVar;
            a((Presenter) oVar, true);
        }
    }

    private boolean iR() {
        return this.wr;
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void as() {
        super.as();
        AdInfo er = com.kwad.sdk.core.response.b.e.er(this.tq.mAdTemplate);
        if (com.kwad.sdk.core.response.b.a.bL(er)) {
            if (this.tq.rX) {
                com.kwad.components.core.webview.tachikoma.e.c.xp().a(dg());
            } else {
                bw.runOnUiThreadDelay(new bg() { // from class: com.kwad.components.ad.reward.presenter.r.1
                    @Override // com.kwad.sdk.utils.bg
                    public final void doTask() {
                        r.this.iQ();
                    }
                }, 100L);
            }
        } else if (!com.kwad.sdk.core.response.b.a.bO(er)) {
            com.kwad.components.core.o.a.tz().aM(this.tq.mAdTemplate);
        }
        this.tq.b(this);
        com.kwad.components.core.playable.a aVar = this.tq.rI;
        if (aVar != null) {
            aVar.a(this);
        }
        boolean hH = com.kwad.components.ad.reward.a.b.hH();
        this.wc = com.kwad.components.ad.reward.a.b.hG();
        if (hH) {
            a aVar2 = new a(this, (byte) 0);
            this.ws = aVar2;
            com.kwad.components.ad.reward.m.e eVar = this.tq.rH;
            if (eVar != null) {
                eVar.a(aVar2);
            }
        }
        com.kwad.components.ad.reward.a.gh().a(this);
    }

    @Override // com.kwad.components.ad.reward.e.g
    public final void cW() {
        RewardActionBarControl.ShowActionBarResult js = this.tq.rJ.js();
        if (js != null) {
            js.equals(RewardActionBarControl.ShowActionBarResult.SHOW_NATIVE_PLAYABLE_PORTRAIT);
        }
        if (this.wv == null || this.tq.gR()) {
            return;
        }
        if (iR()) {
            this.wv.e(PlayableSource.PLAY_FINISHED_NORMAL);
        } else {
            this.wv.iL();
        }
    }

    @Override // com.kwad.components.ad.reward.e.j
    public final void dl() {
        this.tq.A(false);
        a aVar = this.ws;
        if (aVar == null || this.ww != 2) {
            return;
        }
        b(aVar.videoDuration, this.ws.wB, true);
    }

    @Override // com.kwad.components.ad.reward.e.j
    public final void dm() {
    }

    @Override // com.kwad.components.ad.reward.e.g
    public final int getPriority() {
        return 0;
    }

    public final boolean onBackPressed() {
        boolean gV = this.tq.gV();
        if (!this.tq.gH() || gV) {
            return false;
        }
        com.kwad.components.ad.reward.a.gh().gi();
        this.tq.A(false);
        return true;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        com.kwad.components.ad.reward.m.e eVar;
        super.onUnbind();
        this.tq.c(this);
        com.kwad.components.core.playable.a aVar = this.tq.rI;
        if (aVar != null) {
            aVar.b(this);
        }
        a aVar2 = this.ws;
        if (aVar2 != null && (eVar = this.tq.rH) != null) {
            eVar.b(aVar2);
        }
        com.kwad.components.ad.reward.a.gh().b(this);
        com.kwad.components.core.webview.tachikoma.e.c.xp().b(this.jM);
    }

    @Override // com.kwad.components.core.webview.jshandler.as.b
    public final void a(as.a aVar) {
        a aVar2;
        boolean isSuccess = aVar.isSuccess();
        this.wr = isSuccess;
        if (!isSuccess || (aVar2 = this.ws) == null) {
            return;
        }
        b(aVar2.videoDuration, this.ws.wB, false);
    }

    @Override // com.kwad.components.ad.reward.e.j
    public final void a(PlayableSource playableSource, com.kwad.components.ad.reward.e.n nVar) {
        o oVar;
        q qVar;
        this.tq.A(true);
        int i = this.ww;
        if (i == 1 && (qVar = this.wt) != null) {
            qVar.iN();
        } else {
            if (i != 2 || (oVar = this.wu) == null) {
                return;
            }
            oVar.hide();
        }
    }

    public r(AdTemplate adTemplate) {
        this(adTemplate, true, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(com.kwad.components.ad.reward.e.g gVar) {
        return getPriority() - gVar.getPriority();
    }
}
