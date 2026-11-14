package com.kwad.components.ad.reward.k;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class e implements com.kwad.sdk.core.webview.c.a {
    private a AX;

    public interface a {
        void kh();
    }

    public final void a(a aVar) {
        this.AX = aVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "clickGift";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.AX = null;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        a aVar = this.AX;
        if (aVar != null) {
            aVar.kh();
        }
    }
}
