package com.kwad.components.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import com.sigmob.sdk.base.mta.PointCategory;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class ad implements com.kwad.sdk.core.webview.c.a {
    private a agV;
    private final com.kwad.sdk.core.webview.b ags;
    private Handler iK = new Handler(Looper.getMainLooper());

    public interface a {
        void cJ();
    }

    public ad(com.kwad.sdk.core.webview.b bVar, a aVar) {
        this.ags = bVar;
        this.agV = aVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return PointCategory.DISLIKE;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.iK.removeCallbacksAndMessages(null);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        this.iK.post(new com.kwad.sdk.utils.bg() { // from class: com.kwad.components.core.webview.jshandler.ad.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                ad.this.agV.cJ();
            }
        });
        cVar.a(null);
    }
}
