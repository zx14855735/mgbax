package com.kwad.components.core.webview.jshandler;

import com.ksad.json.annotation.KsJson;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class ay implements com.kwad.sdk.core.webview.c.a {
    private com.kwad.sdk.core.webview.c.c agg;

    @KsJson
    public static final class a extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b {
        public String aic;
    }

    private void bk(String str) {
        if (this.agg != null) {
            a aVar = new a();
            aVar.aic = str;
            this.agg.a(aVar);
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        this.agg = cVar;
    }

    public final void bb(boolean z) {
        if (z) {
            bk("windowFocusGet");
        } else {
            bk("windowFocusLost");
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "registerFocusListener";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.agg = null;
    }
}
