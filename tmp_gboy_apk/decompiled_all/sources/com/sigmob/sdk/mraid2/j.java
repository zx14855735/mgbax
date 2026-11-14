package com.sigmob.sdk.mraid2;

import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import java.io.ByteArrayInputStream;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class j extends com.sigmob.sdk.base.l {
    private WebResourceResponse a() {
        return new WebResourceResponse("text/javascript", "UTF-8", new ByteArrayInputStream(g.b.getBytes()));
    }

    @Override // com.sigmob.sdk.base.l, android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        return com.sigmob.sdk.base.l.a(str) ? a() : super.shouldInterceptRequest(webView, str);
    }
}
