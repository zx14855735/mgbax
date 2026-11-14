package com.kwad.components.ad.splashscreen.presenter;

import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bw;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class j extends e {
    /* JADX INFO: Access modifiers changed from: private */
    public void db() {
        AdInfo er = com.kwad.sdk.core.response.b.e.er(this.GC.mAdTemplate);
        a(new b(), true);
        a(new c(), true);
        if (com.kwad.sdk.core.response.b.a.bd(er)) {
            a(new d(), true);
            a(new t(), true);
        } else {
            a(new h(), true);
        }
        if (this.GC.FV) {
            a(new s(), true);
        } else {
            boolean dQ = com.kwad.sdk.core.response.b.b.dQ(er);
            boolean dU = com.kwad.sdk.core.response.b.b.dU(er);
            boolean ec = com.kwad.sdk.core.response.b.b.ec(er);
            if (com.kwad.sdk.core.response.b.b.dW(er)) {
                a(new q(), true);
            } else if (dQ) {
                a(new o(), true);
            } else if (dU) {
                a(new m(), true);
            } else if (ec) {
                a(new s(), true);
            } else {
                a(new s(), true);
            }
        }
        if (com.kwad.sdk.core.response.b.a.aQ(er)) {
            a(new f(), true);
        }
        if (!this.GC.bO) {
            a(new com.kwad.components.ad.splashscreen.presenter.playcard.b(), true);
        }
        a(new a(), true);
        a(new g(), true);
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.e, com.kwad.sdk.mvp.Presenter
    public final void as() {
        super.as();
        bw.postOnUiThread(new bg() { // from class: com.kwad.components.ad.splashscreen.presenter.j.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                j.this.db();
            }
        });
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        findViewById(R.id.splash_play_card_view).setVisibility(0);
    }
}
