package com.sigmob.sdk.mraid;

import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.czhj.volley.toolbox.StringUtil;
import java.io.ByteArrayInputStream;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class w extends com.sigmob.sdk.base.l {
    private String c;

    private WebResourceResponse c(String str) {
        return new WebResourceResponse("text/javascript", "UTF-8", new ByteArrayInputStream(str.getBytes()));
    }

    @Override // com.sigmob.sdk.base.l, android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        if (!com.sigmob.sdk.base.l.a(str)) {
            return super.shouldInterceptRequest(webView, str);
        }
        if (this.c == null) {
            this.c = j.b.replaceAll("xxx", StringUtil.decode(StringUtil.s));
        }
        return c(this.c);
    }
}
