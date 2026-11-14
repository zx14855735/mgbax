package com.kwad.sdk.utils;

import java.util.Iterator;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class an {
    private Map<String, com.kwad.sdk.core.webview.a> beQ;
    private Map<String, com.kwad.sdk.core.webview.c.c> beR;

    public final void a(String str, com.kwad.sdk.core.webview.a aVar) {
        this.beQ.put(str, aVar);
    }

    public final void b(String str, com.kwad.sdk.core.webview.c.c cVar) {
        this.beR.put(str, cVar);
    }

    public final com.kwad.sdk.core.webview.a hq(String str) {
        return this.beQ.get(str);
    }

    public final com.kwad.sdk.core.webview.c.c hr(String str) {
        return this.beR.get(str);
    }

    public final void release() {
        Iterator<com.kwad.sdk.core.webview.a> it = this.beQ.values().iterator();
        while (it.hasNext()) {
            it.next().qg();
        }
        this.beQ.clear();
        this.beR.clear();
    }
}
