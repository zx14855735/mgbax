package com.kwad.components.ad.fullscreen.c.c;

import android.widget.FrameLayout;
import com.kwad.components.ad.reward.e.j;
import com.kwad.components.ad.reward.e.n;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.webview.jshandler.ae;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.sdk.R;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class b extends com.kwad.components.ad.reward.presenter.f.a {
    private FrameLayout dm;
    private j kF = new j() { // from class: com.kwad.components.ad.fullscreen.c.c.b.1
        @Override // com.kwad.components.ad.reward.e.j
        public final void a(PlayableSource playableSource, n nVar) {
        }

        @Override // com.kwad.components.ad.reward.e.j
        public final void dl() {
            b.this.dm.setVisibility(0);
        }

        @Override // com.kwad.components.ad.reward.e.j
        public final void dm() {
            b.this.dm.setVisibility(4);
        }
    };

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void as() {
        super.as();
        this.tq.rX = true;
        com.kwad.components.ad.reward.a.gh().a(this.kF);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final FrameLayout getTKContainer() {
        return this.dm;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTKReaderScene() {
        return "tk_fullscreen";
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTkTemplateId() {
        return com.kwad.sdk.core.response.b.b.dM(this.tq.mAdTemplate);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.dm = (FrameLayout) findViewById(R.id.ksad_js_full_card);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.ad.reward.a.gh().b(this.kF);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(TKRenderFailReason tKRenderFailReason) {
        super.a(tKRenderFailReason);
        com.kwad.components.ad.reward.monitor.c.a(this.mAdTemplate, tKRenderFailReason);
        this.dm.setVisibility(8);
        this.tq.rX = false;
    }

    @Override // com.kwad.components.ad.reward.presenter.f.a, com.kwad.components.core.webview.tachikoma.j
    public final void a(ae.a aVar) {
        float f;
        float f2;
        float bs = com.kwad.sdk.c.a.a.bs(getContext());
        FrameLayout frameLayout = this.dm;
        if (frameLayout != null) {
            f = frameLayout.getHeight();
            f2 = this.dm.getWidth();
        } else {
            f = 0.0f;
            f2 = 0.0f;
        }
        if (f != 0.0f && f2 != 0.0f) {
            aVar.width = (int) ((f2 / bs) + 0.5f);
            aVar.height = (int) ((f / bs) + 0.5f);
        } else {
            super.a(aVar);
        }
    }
}
