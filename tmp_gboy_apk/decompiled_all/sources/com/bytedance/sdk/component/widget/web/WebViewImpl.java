package com.bytedance.sdk.component.widget.web;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.bytedance.android.live.base.api.push.model.PushUIConfig;
import com.bytedance.sdk.component.g.hf;
import com.bytedance.sdk.component.g.w;
import com.bytedance.sdk.component.utils.f;
import com.bytedance.sdk.component.widget.SSWebView;
import com.sigmob.sdk.base.n;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class WebViewImpl extends BaseWebView implements w {
    private static boolean z;
    private volatile boolean en;
    private Map<String, xj> j;
    private final com.bytedance.sdk.component.g.xj l;

    public WebViewImpl(com.bytedance.sdk.component.g.xj xjVar, Context context) {
        super(xj(context));
        this.en = false;
        this.l = xjVar;
        hf(context);
    }

    private void w(Context context) {
    }

    @Override // android.webkit.WebView, com.bytedance.sdk.component.g.w
    @SuppressLint({"JavascriptInterface"})
    public void addJavascriptInterface(final Object obj, final String str) {
        xj(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.19
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (WebViewImpl.this.j == null) {
                        WebViewImpl.this.j = new HashMap();
                    }
                    hf hfVar = new hf(obj, str, WebViewImpl.this.l, WebViewImpl.this);
                    WebViewImpl.this.hashCode();
                    WebViewImpl.super.addJavascriptInterface(hfVar, str);
                    WebViewImpl.this.j.put(str, hfVar);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.webkit.WebView, com.bytedance.sdk.component.g.w
    public boolean canGoBack() {
        if (!xj()) {
            return false;
        }
        try {
            return super.canGoBack();
        } catch (Throwable unused) {
            return false;
        }
    }

    @Override // android.webkit.WebView
    public boolean canGoBackOrForward(int i) {
        try {
            return super.canGoBackOrForward(i);
        } catch (Throwable unused) {
            return false;
        }
    }

    @Override // android.webkit.WebView
    public boolean canGoForward() {
        try {
            return super.canGoForward();
        } catch (Throwable unused) {
            return false;
        }
    }

    @Override // android.webkit.WebView, com.bytedance.sdk.component.g.w
    public void clearCache(final boolean z2) {
        xj(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.8
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.super.clearCache(z2);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.webkit.WebView
    public void clearFormData() {
        xj(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.9
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.super.clearFormData();
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.webkit.WebView, com.bytedance.sdk.component.g.w
    public void clearHistory() {
        xj(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.10
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.super.clearHistory();
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.webkit.WebView, com.bytedance.sdk.component.g.w
    public void clearView() {
        xj(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.47
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.super.clearView();
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.webkit.WebView, android.view.View, com.bytedance.sdk.component.g.w
    public void computeScroll() {
        xj(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.16
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.super.computeScroll();
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.widget.web.BaseWebView, android.webkit.WebView
    public void destroy() {
        if (this.en) {
            return;
        }
        xj(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.27
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (WebViewImpl.this.en) {
                        return;
                    }
                    WebViewImpl.this.hf();
                    if (WebViewImpl.this.j != null) {
                        Iterator it = WebViewImpl.this.j.keySet().iterator();
                        while (it.hasNext()) {
                            WebViewImpl.super.removeJavascriptInterface((String) it.next());
                        }
                        WebViewImpl.this.j = null;
                    }
                    WebViewImpl.super.destroy();
                    WebViewImpl.this.hashCode();
                    WebViewImpl.this.l.hashCode();
                    WebViewImpl.this.en = true;
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.webkit.WebView, com.bytedance.sdk.component.g.w
    public void evaluateJavascript(final String str, final ValueCallback<String> valueCallback) {
        xj(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.26
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.super.evaluateJavascript(str, valueCallback);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.widget.web.BaseWebView
    public WebChromeClient getChromeClient() {
        return this.w;
    }

    @Override // com.bytedance.sdk.component.widget.web.BaseWebView
    public com.bytedance.sdk.component.widget.hf getClient() {
        return this.hf;
    }

    @Override // android.webkit.WebView, com.bytedance.sdk.component.g.w
    public int getContentHeight() {
        if (xj()) {
            try {
                return super.getContentHeight();
            } catch (Throwable unused) {
                return 1;
            }
        }
        final Object obj = new Object();
        final int[] iArr = {-1};
        xj(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.7
            @Override // java.lang.Runnable
            public void run() {
                iArr[0] = WebViewImpl.super.getContentHeight();
                synchronized (obj) {
                    obj.notifyAll();
                }
            }
        });
        try {
            if (iArr[0] < 0) {
                synchronized (obj) {
                    obj.wait(PushUIConfig.dismissTime);
                }
            }
        } catch (InterruptedException unused2) {
        }
        return iArr[0];
    }

    @Override // com.bytedance.sdk.component.widget.web.BaseWebView
    public Map<String, xj> getJavascriptInterfaces() {
        return this.j;
    }

    @Override // android.webkit.WebView, com.bytedance.sdk.component.g.w
    public int getProgress() {
        if (xj()) {
            try {
                return super.getProgress();
            } catch (Throwable unused) {
                return 100;
            }
        }
        final Object obj = new Object();
        final int[] iArr = {-1};
        xj(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.6
            @Override // java.lang.Runnable
            public void run() {
                iArr[0] = WebViewImpl.super.getProgress();
                synchronized (obj) {
                    obj.notifyAll();
                }
            }
        });
        try {
            if (iArr[0] < 0) {
                synchronized (obj) {
                    obj.wait(PushUIConfig.dismissTime);
                }
            }
        } catch (InterruptedException unused2) {
        }
        return iArr[0];
    }

    @Override // android.webkit.WebView, com.bytedance.sdk.component.g.w
    public String getUrl() {
        if (xj()) {
            try {
                return super.getUrl();
            } catch (Throwable unused) {
            }
        }
        com.bytedance.sdk.component.widget.hf hfVar = this.hf;
        if (hfVar != null) {
            return hfVar.hf();
        }
        return null;
    }

    @Override // com.bytedance.sdk.component.g.w
    public String getUserAgentString() {
        if (xj()) {
            try {
                return getSettings().getUserAgentString();
            } catch (Throwable unused) {
                return "";
            }
        }
        final Object obj = new Object();
        final String[] strArr = {""};
        xj(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.25
            @Override // java.lang.Runnable
            public void run() {
                strArr[0] = WebViewImpl.this.getSettings().getUserAgentString();
                synchronized (obj) {
                    obj.notifyAll();
                }
            }
        });
        try {
            String str = strArr[0];
            if (str == null || str.length() == 0) {
                synchronized (obj) {
                    obj.wait(PushUIConfig.dismissTime);
                }
            }
        } catch (InterruptedException unused2) {
        }
        return strArr[0];
    }

    @Override // com.bytedance.sdk.component.g.w
    public View getView() {
        return this;
    }

    @Override // com.bytedance.sdk.component.g.w
    public WebView getWebView() {
        return this;
    }

    @Override // android.webkit.WebView, com.bytedance.sdk.component.g.w
    public void goBack() {
        xj(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.super.goBack();
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.webkit.WebView
    public void goBackOrForward(final int i) {
        xj(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.super.goBackOrForward(i);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.webkit.WebView
    public void goForward() {
        xj(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.super.goForward();
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.view.View
    public boolean hasOverlappingRendering() {
        return false;
    }

    @Override // android.webkit.WebView
    public void loadData(final String str, final String str2, final String str3) {
        xj(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.56
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.super.loadData(str, str2, str3);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.webkit.WebView
    public void loadDataWithBaseURL(final String str, final String str2, final String str3, final String str4, final String str5) {
        xj(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.58
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.setJavaScriptEnabled(str);
                    WebViewImpl.super.loadDataWithBaseURL(str, str2, str3, str4, str5);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.webkit.WebView
    @TargetApi(19)
    public void loadUrl(final String str, final Map<String, String> map) {
        xj(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.23
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.setJavaScriptEnabled(str);
                    WebViewImpl.super.loadUrl(str, map);
                    com.bytedance.sdk.component.widget.hf hfVar = WebViewImpl.this.hf;
                    if (hfVar != null) {
                        hfVar.xj(str);
                    }
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.webkit.WebView, com.bytedance.sdk.component.g.w
    public void onPause() {
        xj(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.24
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.super.onPause();
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.webkit.WebView, com.bytedance.sdk.component.g.w
    public void onResume() {
        xj(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.4
            @Override // java.lang.Runnable
            public void run() {
                WebViewImpl.super.onResume();
            }
        });
    }

    @Override // android.webkit.WebView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        Pair<Boolean, Boolean> xj;
        hf.xj xjVar = this.q;
        return (xjVar == null || (xj = xjVar.xj(this, motionEvent)) == null || !((Boolean) xj.first).booleanValue()) ? super.onTouchEvent(motionEvent) : ((Boolean) xj.second).booleanValue();
    }

    @Override // android.webkit.WebView, com.bytedance.sdk.component.g.w
    public void pauseTimers() {
        xj(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.48
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.super.pauseTimers();
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.webkit.WebView
    public void postUrl(final String str, final byte[] bArr) {
        xj(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.45
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.setJavaScriptEnabled(str);
                    WebViewImpl.super.postUrl(str, bArr);
                    com.bytedance.sdk.component.widget.hf hfVar = WebViewImpl.this.hf;
                    if (hfVar != null) {
                        hfVar.xj(str);
                    }
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.webkit.WebView
    public void reload() {
        xj(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.60
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.super.reload();
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.view.ViewGroup, com.bytedance.sdk.component.g.w
    public void removeAllViews() {
        xj(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.50
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.super.removeAllViews();
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.webkit.WebView, com.bytedance.sdk.component.g.w
    public void removeJavascriptInterface(final String str) {
        xj(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.28
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (WebViewImpl.this.en) {
                        return;
                    }
                    WebViewImpl.this.hashCode();
                    WebViewImpl.super.removeJavascriptInterface(str);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.webkit.WebView, com.bytedance.sdk.component.g.w
    public void resumeTimers() {
        xj(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.49
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.super.resumeTimers();
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.g.w
    public void setAllowFileAccess(final boolean z2) {
        xj(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.46
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.f10255pl = Boolean.valueOf(z2);
                    WebViewImpl.this.getSettings().setAllowFileAccess(z2);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.g.w
    public void setAllowFileAccessFromFileURLs(final boolean z2) {
        xj(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.52
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.tf = Boolean.valueOf(z2);
                    WebViewImpl.this.getSettings().setAllowFileAccessFromFileURLs(z2);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.g.w
    public void setAllowUniversalAccessFromFileURLs(final boolean z2) {
        xj(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.53
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.d = Boolean.valueOf(z2);
                    WebViewImpl.this.getSettings().setAllowUniversalAccessFromFileURLs(z2);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.view.View, com.bytedance.sdk.component.g.w
    public void setAlpha(final float f) {
        super.setAlpha(f);
        xj(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.44
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.super.setAlpha(f);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.g.w
    public void setAppCacheEnabled(final boolean z2) {
        xj(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.29
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.dk = Boolean.valueOf(z2);
                    WebViewImpl.this.getSettings().setAppCacheEnabled(z2);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.webkit.WebView, android.view.View, com.bytedance.sdk.component.g.w
    public void setBackgroundColor(final int i) {
        xj(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.15
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.kd = Integer.valueOf(i);
                    WebViewImpl.super.setBackgroundColor(i);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.g.w
    public void setBlockNetworkImage(final boolean z2) {
        xj(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.51
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.p = Boolean.valueOf(z2);
                    WebViewImpl.this.getSettings().setBlockNetworkImage(z2);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.g.w
    public void setBuiltInZoomControls(final boolean z2) {
        xj(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.35
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.v = Boolean.valueOf(z2);
                    WebViewImpl.this.getSettings().setBuiltInZoomControls(z2);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.g.w
    public void setCacheMode(final int i) {
        xj(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.22
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.et = Integer.valueOf(i);
                    WebViewImpl.this.getSettings().setCacheMode(i);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.g.w
    public void setDatabaseEnabled(final boolean z2) {
        xj(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.42
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.g = Boolean.valueOf(z2);
                    WebViewImpl.this.getSettings().setDatabaseEnabled(z2);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.g.w
    public void setDefaultFontSize(final int i) {
        xj(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.40
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.qt = Integer.valueOf(i);
                    WebViewImpl.this.getSettings().setDefaultFontSize(i);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.g.w
    public void setDefaultTextEncodingName(final String str) {
        xj(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.39
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl webViewImpl = WebViewImpl.this;
                    webViewImpl.zg = str;
                    webViewImpl.getSettings().setDefaultTextEncodingName(str);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.g.w
    public void setDisplayZoomControls(final boolean z2) {
        xj(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.21
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.f10254io = Boolean.valueOf(z2);
                    WebViewImpl.this.getSettings().setDisplayZoomControls(z2);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.g.w
    public void setDomStorageEnabled(final boolean z2) {
        xj(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.33
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.jk = Boolean.valueOf(z2);
                    WebViewImpl.this.getSettings().setDomStorageEnabled(z2);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.webkit.WebView, com.bytedance.sdk.component.g.w
    public void setDownloadListener(final DownloadListener downloadListener) {
        xj(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.13
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl webViewImpl = WebViewImpl.this;
                    DownloadListener downloadListener2 = downloadListener;
                    webViewImpl.u = downloadListener2;
                    WebViewImpl.super.setDownloadListener(downloadListener2);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.g.w
    public void setJavaScriptCanOpenWindowsAutomatically(final boolean z2) {
        xj(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.32
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.pz = Boolean.valueOf(z2);
                    WebViewImpl.this.getSettings().setJavaScriptCanOpenWindowsAutomatically(z2);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.g.w
    public void setJavaScriptEnabled(final boolean z2) {
        xj(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.20
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.x = Boolean.valueOf(z2);
                    WebViewImpl.this.getSettings().setJavaScriptEnabled(z2);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.webkit.WebView, android.view.View, com.bytedance.sdk.component.g.w
    public void setLayerType(final int i, final Paint paint) {
        xj(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.17
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.super.setLayerType(i, paint);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.g.w
    public void setLayoutAlgorithm(final WebSettings.LayoutAlgorithm layoutAlgorithm) {
        xj(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.36
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl webViewImpl = WebViewImpl.this;
                    webViewImpl.yo = layoutAlgorithm;
                    webViewImpl.getSettings().setLayoutAlgorithm(layoutAlgorithm);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.g.w
    public void setLoadWithOverviewMode(final boolean z2) {
        xj(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.37
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.e = Boolean.valueOf(z2);
                    WebViewImpl.this.getSettings().setLoadWithOverviewMode(z2);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.g.w
    public void setMediaPlaybackRequiresUserGesture(final boolean z2) {
        xj(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.55
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.c = Boolean.valueOf(z2);
                    WebViewImpl.this.getSettings().setMediaPlaybackRequiresUserGesture(z2);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.g.w
    public void setMixedContentMode(final int i) {
        xj(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.41
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.am = Integer.valueOf(i);
                    WebViewImpl.this.getSettings().setMixedContentMode(i);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.webkit.WebView, com.bytedance.sdk.component.g.w
    public void setNetworkAvailable(final boolean z2) {
        xj(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.12
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.ai = Boolean.valueOf(z2);
                    WebViewImpl.super.setNetworkAvailable(z2);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.view.View, com.bytedance.sdk.component.g.w
    public void setOnScrollChangeListener(final View.OnScrollChangeListener onScrollChangeListener) {
        xj(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.57
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (Build.VERSION.SDK_INT >= 23) {
                        WebViewImpl webViewImpl = WebViewImpl.this;
                        View.OnScrollChangeListener onScrollChangeListener2 = onScrollChangeListener;
                        webViewImpl.y = onScrollChangeListener2;
                        WebViewImpl.super.setOnScrollChangeListener(onScrollChangeListener2);
                    }
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.webkit.WebView, android.view.View, com.bytedance.sdk.component.g.w
    public void setOverScrollMode(final int i) {
        super.setOverScrollMode(i);
        f.hf().post(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.18
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.super.setOverScrollMode(i);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.g.w
    public void setSavePassword(final boolean z2) {
        xj(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.54
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.f = Boolean.valueOf(z2);
                    WebViewImpl.this.getSettings().setSavePassword(z2);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.g.w
    public void setSupportZoom(final boolean z2) {
        xj(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.30
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.ht = Boolean.valueOf(z2);
                    WebViewImpl.this.getSettings().setSupportZoom(z2);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.g.hf
    public void setTouchEventListener(hf.xj xjVar) {
        this.q = xjVar;
    }

    @Override // com.bytedance.sdk.component.g.w
    public void setUseWideViewPort(final boolean z2) {
        xj(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.31
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.ra = Boolean.valueOf(z2);
                    WebViewImpl.this.getSettings().setUseWideViewPort(z2);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.g.w
    public void setUserAgentString(final String str) {
        xj(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.38
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.getSettings().setUserAgentString(str);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.view.View, com.bytedance.sdk.component.g.w
    public void setVisibility(final int i) {
        xj(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.43
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.super.setVisibility(i);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.webkit.WebView, com.bytedance.sdk.component.g.w
    public void setWebChromeClient(final WebChromeClient webChromeClient) {
        xj(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.14
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl webViewImpl = WebViewImpl.this;
                    WebChromeClient webChromeClient2 = webChromeClient;
                    webViewImpl.w = webChromeClient2;
                    WebViewImpl.super.setWebChromeClient(webChromeClient2);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.webkit.WebView, com.bytedance.sdk.component.g.w
    public void setWebViewClient(final WebViewClient webViewClient) {
        xj(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.11
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewClient webViewClient2 = webViewClient;
                    if (webViewClient2 == null) {
                        webViewClient2 = new SSWebView.xj();
                    } else if (webViewClient2 instanceof com.bytedance.sdk.component.widget.hf) {
                        webViewClient2 = ((com.bytedance.sdk.component.widget.hf) webViewClient2).xj();
                    }
                    WebViewImpl.this.hf = new com.bytedance.sdk.component.widget.hf(webViewClient2);
                    WebViewImpl webViewImpl = WebViewImpl.this;
                    WebViewImpl.super.setWebViewClient(webViewImpl.hf);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.webkit.WebView
    public void stopLoading() {
        xj(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.59
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.super.stopLoading();
                } catch (Throwable unused) {
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setJavaScriptEnabled(String str) {
        WebSettings settings;
        try {
            if (!TextUtils.isEmpty(str) && (settings = getSettings()) != null && !z) {
                if (Uri.parse(str).getScheme().equals(n.z)) {
                    settings.setJavaScriptEnabled(false);
                } else {
                    settings.setJavaScriptEnabled(true);
                }
            }
        } catch (Throwable unused) {
        }
    }

    @Override // android.webkit.WebView, com.bytedance.sdk.component.g.w
    public void loadUrl(final String str) {
        xj(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.34
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewImpl.this.setJavaScriptEnabled(str);
                    WebViewImpl.super.loadUrl(str);
                    com.bytedance.sdk.component.widget.hf hfVar = WebViewImpl.this.hf;
                    if (hfVar != null) {
                        hfVar.xj(str);
                    }
                } catch (Throwable unused) {
                }
            }
        });
    }

    private void u() {
        try {
            WebSettings settings = getSettings();
            if (settings != null) {
                settings.setSavePassword(false);
            }
        } catch (Throwable unused) {
        }
    }

    public WebViewImpl(com.bytedance.sdk.component.g.xj xjVar, Context context, AttributeSet attributeSet) {
        super(xj(context), attributeSet);
        this.en = false;
        this.l = xjVar;
        hf(context);
    }

    private void hf(Context context) {
        w(context);
        u();
        w();
    }

    private void w() {
        try {
            removeJavascriptInterface("searchBoxJavaBridge_");
            removeJavascriptInterface("accessibility");
            removeJavascriptInterface("accessibilityTraversal");
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.sdk.component.widget.web.BaseWebView
    public void hf() {
        super.hf();
        xj(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.WebViewImpl.1
            @Override // java.lang.Runnable
            @SuppressLint({"[ByDesign3.3]AvoidContentOrFileExecuteJS", "SetJavaScriptEnabled"})
            public void run() {
                try {
                    WebSettings settings = WebViewImpl.this.getSettings();
                    WebViewImpl.this.removeAllViews();
                    WebViewImpl.this.stopLoading();
                    WebViewImpl.this.setWebChromeClient(null);
                    WebViewImpl.this.setWebViewClient(null);
                    WebViewImpl.this.setDownloadListener(null);
                    settings.setJavaScriptEnabled(true);
                    settings.setAppCacheEnabled(false);
                    settings.setSupportZoom(false);
                    settings.setUseWideViewPort(true);
                    settings.setJavaScriptCanOpenWindowsAutomatically(true);
                    settings.setDomStorageEnabled(true);
                    settings.setBuiltInZoomControls(false);
                    settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NORMAL);
                    settings.setLoadWithOverviewMode(false);
                    settings.setDefaultTextEncodingName("UTF-8");
                    settings.setDefaultFontSize(16);
                    if (WebViewImpl.this.j != null) {
                        Iterator it = WebViewImpl.this.j.keySet().iterator();
                        while (it.hasNext()) {
                            WebViewImpl.this.removeJavascriptInterface((String) it.next());
                        }
                        WebViewImpl.this.j = null;
                    }
                } catch (Throwable unused) {
                }
            }
        });
    }

    public WebViewImpl(com.bytedance.sdk.component.g.xj xjVar, Context context, AttributeSet attributeSet, int i) {
        super(xj(context), attributeSet, i);
        this.en = false;
        this.l = xjVar;
        hf(context);
    }

    private static Context xj(Context context) {
        return Build.VERSION.SDK_INT < 23 ? context.createConfigurationContext(new Configuration()) : context;
    }

    @Override // com.bytedance.sdk.component.g.w
    public void xj(String str, String str2, Object obj) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("event", str2);
            jSONObject.putOpt("param", obj);
            hf(str, "csjEventListener", jSONObject);
        } catch (JSONException unused) {
        }
    }
}
