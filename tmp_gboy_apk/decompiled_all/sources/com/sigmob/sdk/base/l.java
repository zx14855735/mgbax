package com.sigmob.sdk.base;

import ADYaiT.CtFAbx;
import android.annotation.SuppressLint;
import android.net.Uri;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.baidu.mobads.sdk.internal.an;
import com.czhj.sdk.common.Constants;
import com.czhj.sdk.common.utils.FileUtil;
import com.czhj.sdk.logger.SigmobLog;
import com.czhj.sdk.logger.SigmobLogger;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.CookieManager;
import java.net.HttpCookie;
import java.net.HttpURLConnection;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class l extends WebViewClient {

    /* renamed from: a, reason: collision with root package name */
    static final String f13178a = "Set-Cookie";
    static final String b = "Referer";
    private static final String c = "l";
    private static final String d = "mraid.js";
    private static final String e = "mraid2.js";
    private final boolean f = false;
    private boolean g = false;
    private String h;

    public static WebResourceResponse a(Uri uri) {
        String scheme;
        if (uri != null && (scheme = uri.getScheme()) != null && scheme.startsWith(n.z)) {
            String path = uri.getPath();
            if (!com.sigmob.sdk.base.utils.o.a((CharSequence) path) && !path.contains("../") && !path.contains("..%2F")) {
                try {
                    File file = new File(path);
                    if (file.getCanonicalPath().equals(file.getAbsolutePath()) && file.exists()) {
                        return new WebResourceResponse("text/html", "utf-8", new FileInputStream(file));
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
        return null;
    }

    private WebResourceResponse c(String str) {
        Uri parse;
        String host;
        String scheme;
        String lastPathSegment;
        try {
            parse = Uri.parse(str);
            host = parse.getHost();
            scheme = parse.getScheme();
            lastPathSegment = parse.getLastPathSegment();
        } catch (Throwable th) {
            com.bykv.vk.component.ttvideo.player.A2egSU.BJ7GGh(th, new StringBuilder("useWebResourceCache: error = "));
        }
        if (host != null && !a(str) && scheme.startsWith(Constants.HTTP) && !host.equals("127.0.0.1") && com.sigmob.sdk.base.utils.o.a((CharSequence) parse.getQueryParameter("no-cache")) && ((lastPathSegment.endsWith(".js") || lastPathSegment.endsWith(".css")) && !lastPathSegment.contains("../") && !lastPathSegment.contains("..%2F"))) {
            File file = new File(com.sigmob.sdk.base.utils.k.c(), lastPathSegment);
            if (!file.getCanonicalPath().startsWith(new File(com.sigmob.sdk.base.utils.k.c()).getCanonicalPath())) {
                return null;
            }
            String str2 = lastPathSegment.endsWith(".js") ? "text/javascript" : lastPathSegment.endsWith(".css") ? "text/css" : null;
            if (file.exists()) {
                WebResourceResponse webResourceResponse = new WebResourceResponse(str2, "UTF-8", new FileInputStream(file));
                HashMap hashMap = new HashMap();
                hashMap.put("Cache-Control", "no-store");
                webResourceResponse.setResponseHeaders(hashMap);
                return webResourceResponse;
            }
            return null;
        }
        return null;
    }

    public void b(String str) {
        try {
            Uri parse = Uri.parse(str);
            this.h = parse.getScheme() + "://" + parse.getHost() + "/" + parse.getPath();
        } catch (Throwable unused) {
        }
    }

    @Override // android.webkit.WebViewClient
    @SuppressLint({"NewApi"})
    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        WebResourceResponse webResourceResponse;
        File a2;
        try {
            webResourceResponse = a(webResourceRequest.getUrl());
            if (webResourceResponse != null) {
                return webResourceResponse;
            }
        } catch (Throwable unused) {
            webResourceResponse = null;
        }
        if (this.g && (webResourceResponse = c(webResourceRequest.getUrl().toString())) != null) {
            return webResourceResponse;
        }
        if (this.g && !d.a(webResourceRequest.getUrl().toString()) && !a(webResourceRequest.getUrl().toString())) {
            webResourceResponse = d.a(webResourceRequest.getUrl().toString(), webResourceRequest.getMethod(), webResourceRequest.getRequestHeaders());
        }
        if (webResourceResponse == null) {
            webResourceResponse = super.shouldInterceptRequest(webView, webResourceRequest);
        }
        if (this.g && webResourceResponse != null && (a2 = a(webResourceResponse, webResourceRequest.getUrl().toString())) != null && a2.exists()) {
            try {
                return new WebResourceResponse(webResourceResponse.getMimeType(), webResourceResponse.getEncoding(), new FileInputStream(a2));
            } catch (FileNotFoundException unused2) {
            }
        }
        return webResourceResponse;
    }

    private static File a(WebResourceResponse webResourceResponse, String str) {
        String lastPathSegment;
        try {
            Uri parse = Uri.parse(str);
            if (d.a(str) || (lastPathSegment = parse.getLastPathSegment()) == null) {
                return null;
            }
            File file = new File(com.sigmob.sdk.base.utils.k.c(), lastPathSegment);
            FileUtil.writeToCache(webResourceResponse.getData(), file.getAbsolutePath());
            return file;
        } catch (Throwable unused) {
            return null;
        }
    }

    public void b(boolean z) {
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        WebResourceResponse webResourceResponse;
        File a2;
        try {
            webResourceResponse = a(Uri.parse(str));
            if (webResourceResponse != null) {
                return webResourceResponse;
            }
        } catch (Throwable unused) {
            webResourceResponse = null;
        }
        if (this.g && (webResourceResponse = c(str)) != null) {
            return webResourceResponse;
        }
        if (this.g && !d.a(str) && !a(str)) {
            webResourceResponse = d.a(str, an.c, null);
        }
        if (webResourceResponse == null) {
            webResourceResponse = super.shouldInterceptRequest(webView, str);
        }
        if (this.g && webResourceResponse != null && (a2 = a(webResourceResponse, str)) != null && a2.exists()) {
            try {
                return new WebResourceResponse(webResourceResponse.getMimeType(), webResourceResponse.getEncoding(), new FileInputStream(a2));
            } catch (FileNotFoundException unused2) {
            }
        }
        return webResourceResponse;
    }

    public static void a(HttpURLConnection httpURLConnection, CookieManager cookieManager) {
        if (cookieManager == null || httpURLConnection == null) {
            return;
        }
        Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
        SigmobLog.d("headerFields : " + headerFields.toString());
        List<String> list = headerFields.get(f13178a);
        if (list == null) {
            return;
        }
        for (String str : list) {
            try {
                List<HttpCookie> parse = HttpCookie.parse(str);
                if (!com.sigmob.sdk.base.utils.e.a(parse)) {
                    SigmobLog.d("{0} -- Reading Cookies from the response :" + httpURLConnection.getURL().toString());
                    SigmobLog.d("{0} -- Reading Cookies from the response :" + parse.get(0));
                    for (HttpCookie httpCookie : parse) {
                        SigmobLog.d(httpCookie.toString());
                        android.webkit.CookieManager.getInstance().setCookie(httpURLConnection.getURL().toString(), httpCookie.getName() + "=" + httpCookie.getValue());
                    }
                }
            } catch (NullPointerException unused) {
                SigmobLog.e(MessageFormat.format("{0} -- Null header for the cookie : {1}", httpURLConnection.getURL().toString(), str));
            }
        }
        android.webkit.CookieManager.getInstance().flush();
    }

    public void a(boolean z) {
        this.g = z;
    }

    public static boolean a(String str) {
        String lastPathSegment = Uri.parse(str.toLowerCase(Locale.US)).getLastPathSegment();
        SigmobLogger.d(c, CtFAbx.BChYOn("matchesInjectionUrl: lastPathSegment = ", lastPathSegment), new Object[0]);
        return d.equals(lastPathSegment) || e.equals(lastPathSegment);
    }
}
