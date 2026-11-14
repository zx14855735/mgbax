package com.octopus.ad.internal.utilities;

import android.annotation.SuppressLint;
import android.webkit.CookieManager;
import android.webkit.WebView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class WebviewUtil {
    private static final String VERSION_ZERO_HEADER = "Set-cookie";

    public static String getCookie() {
        return null;
    }

    public static void onPause(WebView webView) {
        if (webView == null) {
            return;
        }
        try {
            WebView.class.getDeclaredMethod("onPause", new Class[0]).invoke(webView, new Object[0]);
        } catch (Exception unused) {
        }
    }

    public static void onResume(WebView webView) {
        if (webView == null) {
            return;
        }
        try {
            WebView.class.getDeclaredMethod("onResume", new Class[0]).invoke(webView, new Object[0]);
        } catch (Exception unused) {
        }
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public static void setWebViewSettings(WebView webView) {
        if (webView == null) {
            return;
        }
        try {
            webView.getSettings().setBuiltInZoomControls(false);
            webView.getSettings().setSupportZoom(true);
            webView.getSettings().setUseWideViewPort(true);
            webView.getSettings().setJavaScriptEnabled(true);
            webView.getSettings().setMixedContentMode(0);
            webView.getSettings().setDomStorageEnabled(true);
            webView.getSettings().setMediaPlaybackRequiresUserGesture(false);
            webView.getSettings().setAllowFileAccess(true);
            webView.getSettings().setAllowContentAccess(false);
            webView.getSettings().setSavePassword(false);
            webView.getSettings().setAllowFileAccessFromFileURLs(false);
            webView.getSettings().setAllowUniversalAccessFromFileURLs(false);
            CookieManager cookieManager = CookieManager.getInstance();
            if (cookieManager != null) {
                cookieManager.setAcceptThirdPartyCookies(webView, true);
            } else {
                HaoboLog.d(HaoboLog.baseLogTag, "Failed to set Webview to accept 3rd party cookie");
            }
            webView.getSettings().setAppCachePath(webView.getContext().getCacheDir().getAbsolutePath());
            webView.getSettings().setAppCacheEnabled(true);
            webView.getSettings().setCacheMode(-1);
            WebView.setWebContentsDebuggingEnabled(false);
        } catch (Exception e) {
            HaoboLog.e(HaoboLog.httpRespLogTag, "Unable update webview settings - Exception: " + e.getMessage());
        }
    }
}
