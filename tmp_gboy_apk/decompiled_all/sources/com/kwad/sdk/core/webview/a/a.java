package com.kwad.sdk.core.webview.a;

import android.annotation.TargetApi;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.kwad.sdk.core.config.e;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class a extends WebViewClient {
    private boolean aRY = true;
    protected String mUniqueId = "";

    public final void setNeedHybridLoad(boolean z) {
        this.aRY = z;
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        if (!this.aRY || !e.Hu()) {
            return super.shouldInterceptRequest(webView, str);
        }
        com.kwad.sdk.core.d.c.d("HybridWebViewClient", "shouldInterceptRequest: " + str);
        WebResourceResponse ab = com.kwad.sdk.core.webview.b.a.MN().ab(str, this.mUniqueId);
        return ab == null ? super.shouldInterceptRequest(webView, str) : ab;
    }

    @Override // android.webkit.WebViewClient
    @TargetApi(21)
    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        if (this.aRY && e.Hu()) {
            String uri = webResourceRequest.getUrl().toString();
            com.kwad.sdk.core.d.c.d("HybridWebViewClient", "shouldInterceptRequestAPI 21: " + uri);
            WebResourceResponse ab = com.kwad.sdk.core.webview.b.a.MN().ab(uri, this.mUniqueId);
            return ab == null ? super.shouldInterceptRequest(webView, webResourceRequest) : ab;
        }
        return super.shouldInterceptRequest(webView, webResourceRequest);
    }
}
