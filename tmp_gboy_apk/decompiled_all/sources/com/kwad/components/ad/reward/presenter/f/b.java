package com.kwad.components.ad.reward.presenter.f;

import android.widget.FrameLayout;
import com.kwad.components.ad.reward.page.BackPressHandleResult;
import com.kwad.components.core.webview.jshandler.ae;
import com.kwad.components.core.webview.jshandler.x;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.components.core.webview.tachikoma.b;
import com.kwad.components.core.webview.tachikoma.c.u;
import com.kwad.components.core.webview.tachikoma.c.y;
import com.kwad.sdk.R;
import com.kwad.sdk.components.t;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bw;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class b extends d {
    private FrameLayout zF;
    private boolean zG = false;

    private void V(boolean z) {
        this.zF.setVisibility(z ? 0 : 8);
    }

    private com.kwad.components.core.webview.tachikoma.c eE() {
        return new com.kwad.components.core.webview.tachikoma.c() { // from class: com.kwad.components.ad.reward.presenter.f.b.1
            @Override // com.kwad.components.core.webview.tachikoma.c, com.kwad.sdk.core.webview.c.a
            public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
                super.a(str, cVar);
                com.kwad.components.core.webview.tachikoma.c.c cVar2 = new com.kwad.components.core.webview.tachikoma.c.c();
                cVar2.akS = com.kwad.components.ad.reward.model.b.dR();
                cVar.a(cVar2);
            }
        };
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void as() {
        super.as();
        if (this.zG) {
            return;
        }
        V(true);
    }

    public int dv() {
        return R.id.ksad_js_reward_card;
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void f(AdTemplate adTemplate) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public FrameLayout getTKContainer() {
        return this.zF;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public String getTKReaderScene() {
        return "tk_live_video";
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public String getTkTemplateId() {
        return com.kwad.sdk.core.response.b.b.dK(this.tq.mAdTemplate);
    }

    public final BackPressHandleResult hy() {
        com.kwad.components.ad.reward.k.a.d dVar = this.zJ;
        return dVar == null ? BackPressHandleResult.NOT_HANDLED : dVar.hy();
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d
    public final boolean jX() {
        return true;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.zF = (FrameLayout) findViewById(dv());
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(t tVar, com.kwad.sdk.core.webview.b bVar) {
        super.a(tVar, bVar);
        tVar.c(eE());
        tVar.c(new com.kwad.components.core.webview.tachikoma.b(new b.a() { // from class: com.kwad.components.ad.reward.presenter.f.b.2
            @Override // com.kwad.components.core.webview.tachikoma.b.a
            public final void eO() {
                com.kwad.components.ad.reward.model.b.L(b.this.tq.mContext);
            }
        }));
        tVar.c(new x() { // from class: com.kwad.components.ad.reward.presenter.f.b.3
            @Override // com.kwad.components.core.webview.jshandler.x
            public final void a(y yVar) {
                super.a(yVar);
                long xf = yVar.xf();
                b.this.tq.rG.onVideoPlayError(yVar.errorCode, (int) xf);
                com.kwad.components.ad.reward.monitor.d.a(b.this.tq.rW, b.this.tq.mAdTemplate, b.this.tq.sv, yVar.errorCode, xf);
                com.kwad.components.ad.reward.monitor.c.c(b.this.tq.rW, b.this.mAdTemplate);
            }

            @Override // com.kwad.components.core.webview.jshandler.x
            public final void b(y yVar) {
                super.b(yVar);
                b.this.tq.rG.onVideoPlayStart();
                com.kwad.components.ad.reward.monitor.d.b(b.this.tq.rW, b.this.tq.mAdTemplate, b.this.tq.mPageEnterTime);
            }

            @Override // com.kwad.components.core.webview.jshandler.x
            public final void c(y yVar) {
                super.c(yVar);
                b.this.tq.rG.onVideoPlayEnd();
                b.this.tq.mAdTemplate.setmCurPlayTime(-1L);
                com.kwad.components.ad.reward.presenter.f.u(b.this.tq);
            }

            @Override // com.kwad.components.core.webview.jshandler.x
            public final void d(y yVar) {
                super.d(yVar);
                b.this.tq.mAdTemplate.setmCurPlayTime(yVar.qy);
            }
        });
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(final u uVar) {
        com.kwad.sdk.core.d.c.d("TKLivePresenter", "onSkipClick: " + uVar.age);
        bw.postOnUiThread(new bg() { // from class: com.kwad.components.ad.reward.presenter.f.b.4
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                if (b.this.tq != null && b.this.tq.rG != null) {
                    b.this.tq.rG.onVideoSkipToEnd(uVar.age * 1000);
                }
                com.kwad.components.ad.reward.presenter.f.u(b.this.tq);
            }
        });
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(TKRenderFailReason tKRenderFailReason) {
        super.a(tKRenderFailReason);
        com.kwad.components.ad.reward.monitor.c.a(this.mAdTemplate, tKRenderFailReason);
        this.zG = true;
        V(false);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(ae.a aVar) {
        float f;
        float f2;
        float bs = com.kwad.sdk.c.a.a.bs(getContext());
        FrameLayout frameLayout = this.zF;
        if (frameLayout != null) {
            f = frameLayout.getHeight();
            f2 = this.zF.getWidth();
        } else {
            f = 0.0f;
            f2 = 0.0f;
        }
        if (f == 0.0f || f2 == 0.0f) {
            f = com.kwad.sdk.c.a.a.getScreenHeight(getContext());
            f2 = com.kwad.sdk.c.a.a.getScreenWidth(getContext());
        }
        aVar.width = (int) ((f2 / bs) + 0.5f);
        aVar.height = (int) ((f / bs) + 0.5f);
    }
}
