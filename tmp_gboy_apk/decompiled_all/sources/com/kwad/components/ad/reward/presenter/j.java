package com.kwad.components.ad.reward.presenter;

import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bw;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class j extends b {
    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void as() {
        super.as();
        try {
            this.tq.rH.ld();
        } catch (Throwable th) {
            bw.postOnUiThread(new bg() { // from class: com.kwad.components.ad.reward.presenter.j.1
                @Override // com.kwad.sdk.utils.bg
                public final void doTask() {
                    ServiceProvider.reportSdkCaughtException(th);
                    j.this.iA();
                }
            });
        }
    }
}
