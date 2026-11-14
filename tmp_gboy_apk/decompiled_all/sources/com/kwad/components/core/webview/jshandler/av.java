package com.kwad.components.core.webview.jshandler;

import com.ksad.json.annotation.KsJson;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class av implements com.kwad.sdk.core.webview.c.a {
    private com.kwad.sdk.core.webview.c.c agg;
    private b ahY;

    @KsJson
    public static final class a extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b {
        public int status;
    }

    public interface b {
        void sv();
    }

    public av(b bVar) {
        this.ahY = bVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        this.agg = cVar;
        b bVar = this.ahY;
        if (bVar != null) {
            bVar.sv();
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "registerBackClickListener";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.agg = null;
    }

    public final void wf() {
        if (this.agg != null) {
            a aVar = new a();
            aVar.status = 1;
            this.agg.a(aVar);
        }
    }
}
