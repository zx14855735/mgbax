package com.kwad.components.ad.reward.k;

import android.content.DialogInterface;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.webview.jshandler.z;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.lang.ref.WeakReference;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class q extends z {
    private WeakReference<com.kwad.components.ad.reward.g> Bh;
    private long yY;

    public q(com.kwad.sdk.core.webview.b bVar, com.kwad.components.core.e.d.d dVar, com.kwad.components.ad.reward.g gVar, long j, com.kwad.sdk.core.webview.d.a.a aVar, DialogInterface.OnDismissListener onDismissListener) {
        super(bVar, dVar, aVar, onDismissListener);
        this.yY = j;
        if (gVar != null) {
            this.Bh = new WeakReference<>(gVar);
        }
    }

    @Override // com.kwad.components.core.webview.jshandler.z
    public final a.C0291a a(a.C0291a c0291a, com.kwad.sdk.core.webview.d.b.a aVar, AdTemplate adTemplate) {
        long j;
        WeakReference<com.kwad.components.ad.reward.g> weakReference = this.Bh;
        if (weakReference == null || weakReference.get() == null) {
            j = this.yY;
            if (j <= 0) {
                j = 0;
            }
        } else {
            j = this.Bh.get().rH.getPlayDuration();
        }
        return super.a(c0291a, aVar, adTemplate).B(j);
    }

    @Override // com.kwad.components.core.webview.jshandler.z
    public final void kC() {
        super.kC();
        if (this.ags != null) {
            com.kwad.components.ad.reward.c.a.hW().c(this.ags.getAdTemplate(), com.kwad.components.ad.reward.c.b.STATUS_NONE);
        }
    }
}
