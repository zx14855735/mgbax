package com.kwad.components.core.webview.tachikoma.b;

import com.kwad.components.core.webview.tachikoma.c.z;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class p extends w {
    private boolean enable = true;

    public final void a(z zVar) {
        if (this.enable) {
            b(zVar);
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "registerVideoProgressListener";
    }

    @Override // com.kwad.components.core.webview.tachikoma.b.w, com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        super.a(str, cVar);
    }
}
