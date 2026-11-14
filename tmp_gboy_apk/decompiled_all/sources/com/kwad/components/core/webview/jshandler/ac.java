package com.kwad.components.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import com.kwad.components.core.e.d.a;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class ac implements com.kwad.sdk.core.webview.c.a {
    private boolean agF;
    private Handler agN;
    private boolean agR;
    private boolean agS;
    private final com.kwad.sdk.core.webview.b ags;
    private com.kwad.sdk.core.webview.d.a.a eT;
    private final com.kwad.components.core.e.d.d mApkDownloadHelper;

    public ac(com.kwad.sdk.core.webview.b bVar, com.kwad.components.core.e.d.d dVar, com.kwad.sdk.core.webview.d.a.a aVar, boolean z, boolean z2, boolean z3) {
        this.agR = false;
        this.agS = false;
        this.agF = z;
        this.agN = new Handler(Looper.getMainLooper());
        this.ags = bVar;
        this.mApkDownloadHelper = dVar;
        this.agR = false;
        if (dVar != null) {
            dVar.aI(1);
        }
        this.eT = aVar;
        this.agS = z3;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "convert";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.agN.removeCallbacksAndMessages(null);
        this.eT = null;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        if (this.ags.MD()) {
            cVar.onError(-1, "native adTemplate is null");
            return;
        }
        final com.kwad.sdk.core.webview.d.b.a aVar = new com.kwad.sdk.core.webview.d.b.a();
        try {
            aVar.parseJson(new JSONObject(str));
            aVar.Pt = true;
        } catch (JSONException e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
        }
        if (this.ags.aRN) {
            this.agN.post(new com.kwad.sdk.utils.bg() { // from class: com.kwad.components.core.webview.jshandler.ac.1
                @Override // com.kwad.sdk.utils.bg
                public final void doTask() {
                    if (ac.this.ags.aRO || aVar.ahH) {
                        ac.this.ags.getAdTemplate();
                        com.kwad.components.core.e.d.a.a(ac.this.ags.Vs.getContext(), ac.this.ags.getAdTemplate(), new a.b() { // from class: com.kwad.components.core.webview.jshandler.ac.1.1
                            @Override // com.kwad.components.core.e.d.a.b
                            public final void onAdClicked() {
                                if (ac.this.eT != null) {
                                    ac.this.eT.a(aVar);
                                }
                            }
                        }, ac.this.mApkDownloadHelper, aVar.ahH, ac.this.agF, ac.this.agR, ac.this.agS);
                    }
                }
            });
        } else if (this.eT != null) {
            this.agN.post(new com.kwad.sdk.utils.bg() { // from class: com.kwad.components.core.webview.jshandler.ac.2
                @Override // com.kwad.sdk.utils.bg
                public final void doTask() {
                    if (ac.this.eT != null) {
                        ac.this.eT.a(aVar);
                    }
                }
            });
        }
        cVar.a(null);
    }

    public ac(com.kwad.sdk.core.webview.b bVar, com.kwad.components.core.e.d.d dVar, com.kwad.sdk.core.webview.d.a.a aVar) {
        this(bVar, dVar, aVar, false, false, false);
    }

    public ac(com.kwad.sdk.core.webview.b bVar, com.kwad.components.core.e.d.d dVar, com.kwad.sdk.core.webview.d.a.a aVar, byte b) {
        this(bVar, dVar, aVar, false, false, false);
    }
}
