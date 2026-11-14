package com.bytedance.sdk.openadsdk.core.widget.xj;

import android.annotation.TargetApi;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.component.utils.p;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.core.a.eu;
import com.bytedance.sdk.openadsdk.core.am.kd;
import com.bytedance.sdk.openadsdk.core.j;
import com.bytedance.sdk.openadsdk.core.nativeexpress.y;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.core.ra.ai;
import com.bytedance.sdk.openadsdk.core.ra.en;
import com.fl.saas.common.util.FileTypeUtils;
import java.io.File;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class u extends WebViewClient implements SSWebView.w {
    private static final HashSet<String> p;
    protected final j hf;
    protected kd kd;
    protected final String u;
    protected final Context w;
    private com.bytedance.sdk.openadsdk.pl.u xj;
    protected boolean y = true;
    protected boolean c = true;
    protected volatile AtomicInteger f = new AtomicInteger(0);
    private long d = -1;
    private boolean tf = false;

    static {
        HashSet<String> hashSet = new HashSet<>();
        p = hashSet;
        hashSet.add(FileTypeUtils.FILE_TYPE_PNG);
        hashSet.add("ico");
        hashSet.add(FileTypeUtils.FILE_TYPE_JPEG);
        hashSet.add("gif");
        hashSet.add("svg");
        hashSet.add("jpeg");
        LpGTwYx();
    }

    public u(Context context, j jVar, String str) {
        this.w = context;
        this.hf = jVar;
        this.u = str;
    }

    private static /* synthetic */ void LpGTwYx() {
        char[] charArray = "ÞÒÐ\u0093ÚÜÐØ\u0093ßÒÄ\u0093ÎÕØÑÑ\u0093÷ÓÔÿÏÔÙÚØ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 189);
        }
        String str = new String(charArray);
        char[] charArray2 = "ÞÑÔÓÔÉ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 189);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private static String hf(String str) {
        int lastIndexOf;
        String substring;
        if (str == null || (lastIndexOf = str.lastIndexOf(46)) < 0 || lastIndexOf == str.length() - 1 || (substring = str.substring(lastIndexOf)) == null || !p.contains(substring.toLowerCase(Locale.getDefault()))) {
            return null;
        }
        return "image/".concat(substring);
    }

    private boolean xj(Uri uri) {
        File hf = com.bytedance.sdk.openadsdk.api.plugin.hf.hf(pz.getContext());
        if (uri == null) {
            return false;
        }
        try {
            String lastPathSegment = uri.getLastPathSegment();
            if (lastPathSegment == null) {
                return false;
            }
            File canonicalFile = new File(hf, lastPathSegment).getCanonicalFile();
            if (canonicalFile.exists()) {
                return !canonicalFile.getPath().startsWith(hf.toString());
            }
            return false;
        } catch (Exception e) {
            pl.xj(e);
            return false;
        }
    }

    @Override // android.webkit.WebViewClient
    public void onLoadResource(WebView webView, String str) {
        super.onLoadResource(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        kd kdVar = this.kd;
        if (kdVar != null) {
            kdVar.xj(webView);
        }
        if (webView != null && this.y) {
            try {
                String xj = hf.xj(pz.hf().r(), this.u);
                if (!TextUtils.isEmpty(xj)) {
                    p.xj(webView, xj);
                }
            } catch (Throwable unused) {
            }
        }
        super.onPageFinished(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        kd kdVar = this.kd;
        if (kdVar != null) {
            kdVar.xj(webView, str, bitmap);
        }
        if (this.c) {
            hf.xj(this.w).xj(true).xj(webView);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
        kd kdVar = this.kd;
        if (kdVar != null) {
            kdVar.xj(i, str, str2, hf(str2));
        }
    }

    @Override // android.webkit.WebViewClient
    @TargetApi(21)
    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        if (this.kd == null || webResourceResponse == null) {
            return;
        }
        Uri url = webResourceRequest.getUrl();
        String str = "";
        String uri = url != null ? url.toString() : "";
        Map<String, String> requestHeaders = webResourceRequest.getRequestHeaders();
        if (requestHeaders.containsKey("Accept")) {
            str = requestHeaders.get("Accept");
        } else if (requestHeaders.containsKey("accept")) {
            str = requestHeaders.get("accept");
        }
        this.kd.xj(webResourceResponse.getStatusCode(), String.valueOf(webResourceResponse.getReasonPhrase()), uri, str);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        if (sslErrorHandler != null) {
            try {
                sslErrorHandler.cancel();
            } catch (Throwable unused) {
            }
        }
        if (this.kd != null) {
            int i = 0;
            String str = "SslError: unknown";
            String str2 = null;
            if (sslError != null) {
                try {
                    i = sslError.getPrimaryError();
                    str = "SslError: ".concat(String.valueOf(sslError));
                    str2 = sslError.getUrl();
                } catch (Throwable unused2) {
                }
            }
            this.kd.xj(i, str, str2, hf(str2));
        }
    }

    @Override // android.webkit.WebViewClient
    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        if (Build.VERSION.SDK_INT < 26) {
            return super.onRenderProcessGone(webView, renderProcessGoneDetail);
        }
        if (renderProcessGoneDetail.didCrash()) {
            pl.u("WebChromeClient", "The WebView rendering process crashed!");
            if (webView != null) {
                ViewGroup viewGroup = (ViewGroup) webView.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(webView);
                }
                webView.destroy();
                com.bytedance.sdk.component.adexpress.kd.kd.xj().hf();
            }
            return true;
        }
        pl.u("WebChromeClient", "System killed the WebView rendering process to reclaim memory. Recreating...");
        if (webView != null) {
            ViewGroup viewGroup2 = (ViewGroup) webView.getParent();
            if (viewGroup2 != null) {
                viewGroup2.removeView(webView);
            }
            webView.destroy();
            com.bytedance.sdk.component.adexpress.kd.kd.xj().hf();
        }
        return true;
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        if (webResourceRequest != null && xj(webResourceRequest.getUrl())) {
            return null;
        }
        WebResourceResponse shouldInterceptRequest = super.shouldInterceptRequest(webView, webResourceRequest);
        if (this.xj != null) {
            shouldInterceptRequest = this.xj.xj(webView, new com.bytedance.sdk.openadsdk.pl.hf(webResourceRequest, null), shouldInterceptRequest);
        }
        if (xj(webView, webResourceRequest)) {
            return new WebResourceResponse("", "", null);
        }
        List<ai.w> xj = eu.xj().xj(webResourceRequest.getUrl().toString());
        if (xj == null || xj.isEmpty()) {
            return shouldInterceptRequest;
        }
        eu xj2 = eu.xj();
        String uri = webResourceRequest.getUrl().toString();
        kd kdVar = this.kd;
        return xj2.xj(shouldInterceptRequest, uri, xj, kdVar != null ? kdVar.f() : null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:66:0x016a, code lost:
    
        if (r1.d() != false) goto L62;
     */
    @Override // android.webkit.WebViewClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean shouldOverrideUrlLoading(android.webkit.WebView r9, java.lang.String r10) {
        /*
            Method dump skipped, instructions count: 370
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.widget.xj.u.shouldOverrideUrlLoading(android.webkit.WebView, java.lang.String):boolean");
    }

    public void w() {
        this.tf = true;
    }

    @Override // android.webkit.WebViewClient
    @TargetApi(23)
    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        super.onReceivedError(webView, webResourceRequest, webResourceError);
        if (this.kd == null || webResourceError == null) {
            return;
        }
        Uri url = webResourceRequest.getUrl();
        String str = "";
        String uri = url != null ? url.toString() : "";
        Map<String, String> requestHeaders = webResourceRequest.getRequestHeaders();
        if (requestHeaders.containsKey("Accept")) {
            str = requestHeaders.get("Accept");
        } else if (requestHeaders.containsKey("accept")) {
            str = requestHeaders.get("accept");
        }
        this.kd.xj(webResourceError.getErrorCode(), String.valueOf(webResourceError.getDescription()), uri, str);
    }

    public boolean hf() {
        return System.currentTimeMillis() - this.d < 1000;
    }

    public boolean xj(WebView webView, WebResourceRequest webResourceRequest) {
        return en.xj(webView, this.f, this.hf, webResourceRequest, false, hf()) && !(this instanceof y);
    }

    public void hf(boolean z) {
        if (!z || this.tf) {
            this.d = System.currentTimeMillis();
        }
    }

    public boolean xj(WebView webView, String str) {
        return en.xj(webView, this.f, this.hf, str, false, hf()) && !(this instanceof y);
    }

    private void xj(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (str.contains("weixin://wap/pay") || str.contains("weixin://dl/business/?ticket") || str.contains("alipays://platformapi/startapp?appId")) {
            com.bytedance.sdk.openadsdk.core.am.u.w(this.hf.f(), "landingpage", "lp_pay");
        }
    }

    public u(Context context, j jVar, String str, kd kdVar) {
        this.w = context;
        this.hf = jVar;
        this.u = str;
        this.kd = kdVar;
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        if (str != null && xj(Uri.parse(str))) {
            return null;
        }
        WebResourceResponse shouldInterceptRequest = super.shouldInterceptRequest(webView, str);
        if (this.xj != null) {
            shouldInterceptRequest = this.xj.xj(webView, new com.bytedance.sdk.openadsdk.pl.hf(null, str), shouldInterceptRequest);
        }
        if (xj(webView, str)) {
            return new WebResourceResponse("", "", null);
        }
        List<ai.w> xj = eu.xj().xj(str);
        if (xj == null || xj.isEmpty()) {
            return shouldInterceptRequest;
        }
        eu xj2 = eu.xj();
        kd kdVar = this.kd;
        return xj2.xj(shouldInterceptRequest, str, xj, kdVar != null ? kdVar.f() : null);
    }

    private void xj(Context context, Intent intent) {
        if (intent != null) {
            try {
                ComponentName resolveActivity = intent.resolveActivity(context.getPackageManager());
                if ((resolveActivity == null || !resolveActivity.getPackageName().equals(context.getPackageName())) && (intent.getFlags() & MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_PERFER_VIDEO) == 0) {
                    com.bytedance.sdk.component.utils.hf.xj(context, intent, null, TextUtils.equals("main", "internal"));
                }
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.bytedance.sdk.component.widget.SSWebView.w
    public void xj(boolean z) {
        j jVar = this.hf;
        if (jVar != null) {
            jVar.w(z);
        }
    }

    public u(Context context, j jVar, String str, kd kdVar, com.bytedance.sdk.openadsdk.pl.u uVar) {
        this.w = context;
        this.hf = jVar;
        this.u = str;
        this.kd = kdVar;
        this.xj = uVar;
    }
}
