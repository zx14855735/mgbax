package com.kwad.components.core.webview.tachikoma;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class b implements com.kwad.sdk.core.webview.c.a {
    private a aiM;

    public interface a {
        void eO();
    }

    public b(a aVar) {
        this.aiM = aVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        a aVar = this.aiM;
        if (aVar != null) {
            aVar.eO();
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "cardImpression";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }
}
