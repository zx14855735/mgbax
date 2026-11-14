package com.kwad.components.core.webview.jshandler;

import com.ksad.json.annotation.KsJson;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class h implements com.kwad.sdk.core.webview.c.a {
    private int GJ;
    private com.kwad.sdk.core.webview.c.c agg;

    @KsJson
    public static class a extends com.kwad.sdk.core.response.a.a {
        public int loadType;
    }

    public h(int i) {
        this.GJ = i;
    }

    private void bw(int i) {
        if (this.agg == null) {
            return;
        }
        a aVar = new a();
        aVar.loadType = i;
        this.agg.a(aVar);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        this.agg = cVar;
        bw(this.GJ);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "getLoadInfo";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.agg = null;
    }
}
