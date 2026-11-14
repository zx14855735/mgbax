package com.kwad.components.core.webview.jshandler;

import com.kwad.sdk.utils.bw;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class bb implements com.kwad.sdk.core.webview.c.a {
    private final a aih;

    public interface a {
        void cK();
    }

    public bb(a aVar) {
        this.aih = aVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "registerMotionListener";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, final com.kwad.sdk.core.webview.c.c cVar) {
        bw.runOnUiThread(new com.kwad.sdk.utils.bg() { // from class: com.kwad.components.core.webview.jshandler.bb.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                if (bb.this.aih != null) {
                    bb.this.aih.cK();
                }
                cVar.a(null);
            }
        });
    }
}
