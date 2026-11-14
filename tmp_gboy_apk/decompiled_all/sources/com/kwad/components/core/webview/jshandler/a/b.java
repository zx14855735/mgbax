package com.kwad.components.core.webview.jshandler.a;

import com.kwad.sdk.utils.bw;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class b implements com.kwad.sdk.core.webview.c.a {
    private c afM;

    public b(c cVar) {
        this.afM = cVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "exitWebView";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.afM = null;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        bw.runOnUiThread(new Runnable() { // from class: com.kwad.components.core.webview.jshandler.a.b.1
            @Override // java.lang.Runnable
            public final void run() {
                if (b.this.afM != null) {
                    b.this.afM.sb();
                }
            }
        });
    }
}
