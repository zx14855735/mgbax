package com.bytedance.sdk.component.widget.web;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.g.hf;
import com.bytedance.sdk.component.g.w;
import com.bytedance.sdk.component.g.xj;
import com.bytedance.sdk.component.utils.f;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class MultiWebview extends FrameLayout implements com.bytedance.sdk.component.g.xj {
    private static int kd = 1;
    public static com.bytedance.sdk.component.widget.xj u;
    private xj.InterfaceC0112xj c;
    private Map<w, Set<String>> d;
    private Deque<w> f;
    protected volatile w hf;
    protected WebViewImpl w;
    protected final AtomicInteger xj;
    private long y;

    public MultiWebview(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public w c() {
        if (this.f.size() < 2) {
            this.hf = this.w;
            return null;
        }
        w pollLast = this.f.pollLast();
        if (pollLast != null) {
            removeView(pollLast.getView());
            pollLast.destroy();
            this.d.remove(pollLast);
        }
        w last = this.f.getLast();
        if (last != null) {
            last.setVisibility(0);
            last.onResume();
            this.hf = last;
        }
        return pollLast;
    }

    public static void setExceptionReport(com.bytedance.sdk.component.widget.xj xjVar) {
        u = xjVar;
    }

    public static void setMaxWebViewCount(int i) {
        kd = i + 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        if (this.w == null) {
            return;
        }
        removeAllViews();
        setBackground(null);
        try {
            this.w.getView().setId(2064056317);
        } catch (Throwable unused) {
        }
        addView(this.w.getView(), new FrameLayout.LayoutParams(-1, -1));
        this.f.add(this.w);
        this.hf = this.w;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        while (true) {
            w xj = xj();
            if (xj == null) {
                break;
            } else {
                removeView(xj.getView());
            }
        }
        WebViewImpl webViewImpl = this.w;
        if (webViewImpl != null) {
            webViewImpl.hf();
        }
    }

    public void G_() {
        this.d.clear();
        this.c = null;
        xj(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.MultiWebview.2
            @Override // java.lang.Runnable
            public void run() {
                MultiWebview.this.y();
            }
        });
    }

    public void destroy() {
        while (true) {
            w pollLast = this.f.pollLast();
            if (pollLast == null) {
                this.w = null;
                this.hf = null;
                this.d.clear();
                this.c = null;
                return;
            }
            pollLast.destroy();
        }
    }

    public long getCreateDuration() {
        return this.y;
    }

    public w getCurrentWebView() {
        return this.hf;
    }

    public int getWebViewCount() {
        return this.f.size();
    }

    public boolean kd() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    public MultiWebview(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public w hf(String str) {
        w w = w();
        if (w != null) {
            w wVar = this.hf;
            this.f.add(w);
            this.hf = w;
            addView(w.getView(), new FrameLayout.LayoutParams(-1, -1));
            xj(w);
            w.loadUrl(str);
            if (wVar != null) {
                wVar.onPause();
                wVar.setVisibility(8);
            }
        }
        return w;
    }

    private w w() {
        String name = Thread.currentThread().getName();
        try {
            return new WebViewImpl(this, getContext());
        } catch (Throwable th) {
            com.bytedance.sdk.component.widget.xj xjVar = u;
            if (xjVar == null) {
                return null;
            }
            xjVar.xj(name, th);
            return null;
        }
    }

    public MultiWebview(final Context context, final AttributeSet attributeSet, final int i) {
        super(context, attributeSet, i);
        AtomicInteger atomicInteger = new AtomicInteger();
        this.xj = atomicInteger;
        this.f = new LinkedList();
        this.d = new ConcurrentHashMap();
        final long currentTimeMillis = System.currentTimeMillis();
        atomicInteger.set(1);
        if (kd()) {
            this.w = xj(context, attributeSet, i);
            u();
            this.y = System.currentTimeMillis() - currentTimeMillis;
            return;
        }
        xj(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.MultiWebview.1
            @Override // java.lang.Runnable
            public void run() {
                MultiWebview multiWebview = MultiWebview.this;
                multiWebview.w = multiWebview.xj(context, attributeSet, i);
                MultiWebview.this.u();
                MultiWebview.this.y = System.currentTimeMillis() - currentTimeMillis;
            }
        }, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public WebViewImpl xj(Context context, AttributeSet attributeSet, int i) {
        WebViewImpl webViewImpl;
        try {
            this.xj.set(2);
            if (i == 0) {
                webViewImpl = new WebViewImpl(this, context, attributeSet);
            } else {
                webViewImpl = new WebViewImpl(this, context, attributeSet, i);
            }
            this.xj.set(3);
            return webViewImpl;
        } catch (Throwable th) {
            this.xj.set(4);
            if (u == null) {
                return null;
            }
            u.xj(Thread.currentThread().getName(), th);
            return null;
        }
    }

    @Override // com.bytedance.sdk.component.g.xj
    public void hf(w wVar, String str) {
        Set<String> set;
        if (wVar == null || str == null || (set = this.d.get(wVar)) == null) {
            return;
        }
        set.remove(str);
    }

    @Override // com.bytedance.sdk.component.g.xj
    public int xj(final String str) {
        w wVar;
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (kd == 1) {
            return 2;
        }
        if (getWebViewCount() >= kd) {
            return 1;
        }
        if (kd()) {
            wVar = hf(str);
        } else {
            final w[] wVarArr = new w[1];
            final Object obj = new Object();
            xj(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.MultiWebview.3
                @Override // java.lang.Runnable
                public void run() {
                    wVarArr[0] = MultiWebview.this.hf(str);
                    synchronized (obj) {
                        obj.notifyAll();
                    }
                }
            });
            try {
                if (wVarArr[0] == null) {
                    synchronized (obj) {
                        obj.wait(2500L);
                    }
                }
            } catch (InterruptedException unused) {
            }
            wVar = wVarArr[0];
        }
        return wVar != null ? 0 : -999;
    }

    private void xj(w wVar) {
        xj xjVar;
        Object xj;
        WebViewImpl webViewImpl = this.w;
        if (webViewImpl == null || wVar == null) {
            return;
        }
        Integer backgroundColor = webViewImpl.getBackgroundColor();
        if (backgroundColor != null) {
            wVar.setBackgroundColor(backgroundColor.intValue());
        }
        Boolean allowFileAccess = webViewImpl.getAllowFileAccess();
        if (allowFileAccess != null) {
            wVar.setAllowFileAccess(allowFileAccess.booleanValue());
        }
        Boolean databaseEnabled = webViewImpl.getDatabaseEnabled();
        if (databaseEnabled != null) {
            wVar.setDatabaseEnabled(databaseEnabled.booleanValue());
        }
        Boolean appCacheEnabled = webViewImpl.getAppCacheEnabled();
        if (appCacheEnabled != null) {
            wVar.setAppCacheEnabled(appCacheEnabled.booleanValue());
        }
        Boolean domStorageEnabled = webViewImpl.getDomStorageEnabled();
        if (domStorageEnabled != null) {
            wVar.setDomStorageEnabled(domStorageEnabled.booleanValue());
        }
        Boolean supportZoom = webViewImpl.getSupportZoom();
        if (supportZoom != null) {
            wVar.setSupportZoom(supportZoom.booleanValue());
        }
        Boolean builtInZoomControls = webViewImpl.getBuiltInZoomControls();
        if (builtInZoomControls != null) {
            wVar.setBuiltInZoomControls(builtInZoomControls.booleanValue());
        }
        Boolean useWideViewPort = webViewImpl.getUseWideViewPort();
        if (useWideViewPort != null) {
            wVar.setUseWideViewPort(useWideViewPort.booleanValue());
        }
        WebSettings.LayoutAlgorithm layoutAlgorithm = webViewImpl.getLayoutAlgorithm();
        if (layoutAlgorithm != null) {
            wVar.setLayoutAlgorithm(layoutAlgorithm);
        }
        Boolean javaScriptEnabled = webViewImpl.getJavaScriptEnabled();
        if (javaScriptEnabled != null) {
            wVar.setJavaScriptEnabled(javaScriptEnabled.booleanValue());
        }
        Boolean javaScriptCanOpenWindowsAutomatically = webViewImpl.getJavaScriptCanOpenWindowsAutomatically();
        if (javaScriptCanOpenWindowsAutomatically != null) {
            wVar.setJavaScriptCanOpenWindowsAutomatically(javaScriptCanOpenWindowsAutomatically.booleanValue());
        }
        View.OnScrollChangeListener onScrollChangeListener = webViewImpl.getOnScrollChangeListener();
        if (onScrollChangeListener != null) {
            wVar.setOnScrollChangeListener(onScrollChangeListener);
        }
        Boolean mediaPlaybackRequiresUserGesture = webViewImpl.getMediaPlaybackRequiresUserGesture();
        if (mediaPlaybackRequiresUserGesture != null) {
            wVar.setMediaPlaybackRequiresUserGesture(mediaPlaybackRequiresUserGesture.booleanValue());
        }
        Boolean savePassword = webViewImpl.getSavePassword();
        if (savePassword != null) {
            wVar.setSavePassword(savePassword.booleanValue());
        }
        Boolean allowFileAccessFromFileURLs = webViewImpl.getAllowFileAccessFromFileURLs();
        if (allowFileAccessFromFileURLs != null) {
            wVar.setAllowFileAccessFromFileURLs(allowFileAccessFromFileURLs.booleanValue());
        }
        Boolean allowUniversalAccessFromFileURLs = webViewImpl.getAllowUniversalAccessFromFileURLs();
        if (allowUniversalAccessFromFileURLs != null) {
            wVar.setAllowUniversalAccessFromFileURLs(allowUniversalAccessFromFileURLs.booleanValue());
        }
        Boolean blockNetworkImage = webViewImpl.getBlockNetworkImage();
        if (blockNetworkImage != null) {
            wVar.setBlockNetworkImage(blockNetworkImage.booleanValue());
        }
        Integer defaultFontSize = webViewImpl.getDefaultFontSize();
        if (defaultFontSize != null) {
            wVar.setDefaultFontSize(defaultFontSize.intValue());
        }
        String defaultTextEncodingName = webViewImpl.getDefaultTextEncodingName();
        if (defaultTextEncodingName != null) {
            wVar.setDefaultTextEncodingName(defaultTextEncodingName);
        }
        Integer cacheMode = webViewImpl.getCacheMode();
        if (cacheMode != null) {
            wVar.setCacheMode(cacheMode.intValue());
        }
        Boolean displayZoomControls = webViewImpl.getDisplayZoomControls();
        if (displayZoomControls != null) {
            wVar.setDisplayZoomControls(displayZoomControls.booleanValue());
        }
        Boolean loadWithOverviewMod = webViewImpl.getLoadWithOverviewMod();
        if (loadWithOverviewMod != null) {
            wVar.setLoadWithOverviewMode(loadWithOverviewMod.booleanValue());
        }
        String userAgentString = webViewImpl.getUserAgentString();
        if (userAgentString != null) {
            wVar.setUserAgentString(userAgentString);
        }
        hf.xj onTouchEventListener = webViewImpl.getOnTouchEventListener();
        if (onTouchEventListener != null) {
            wVar.setTouchEventListener(onTouchEventListener);
        }
        DownloadListener downloadListener = webViewImpl.getDownloadListener();
        if (downloadListener != null) {
            wVar.setDownloadListener(downloadListener);
        }
        WebChromeClient chromeClient = webViewImpl.getChromeClient();
        if (chromeClient != null) {
            wVar.setWebChromeClient(chromeClient);
        }
        com.bytedance.sdk.component.widget.hf client = webViewImpl.getClient();
        if (client != null) {
            wVar.setWebViewClient(client.xj());
        }
        Map<String, xj> javascriptInterfaces = webViewImpl.getJavascriptInterfaces();
        if (javascriptInterfaces != null) {
            for (String str : javascriptInterfaces.keySet()) {
                if (str != null && (xjVar = javascriptInterfaces.get(str)) != null && (xj = xjVar.xj()) != null) {
                    wVar.addJavascriptInterface(xj, str);
                }
            }
        }
    }

    @Override // com.bytedance.sdk.component.g.xj
    public w xj() {
        if (kd()) {
            return c();
        }
        final w[] wVarArr = new w[1];
        final Object obj = new Object();
        xj(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.MultiWebview.4
            @Override // java.lang.Runnable
            public void run() {
                wVarArr[0] = MultiWebview.this.c();
                synchronized (obj) {
                    obj.notifyAll();
                }
            }
        });
        try {
            if (wVarArr[0] == null) {
                synchronized (obj) {
                    obj.wait(2500L);
                }
            }
        } catch (InterruptedException unused) {
        }
        return wVarArr[0];
    }

    @Override // com.bytedance.sdk.component.g.xj
    public void xj(w wVar, String str, String str2, Object obj) {
        if (str2 == null || wVar == null) {
            return;
        }
        for (w wVar2 : this.d.keySet()) {
            if (wVar2 != null && wVar != wVar2) {
                Set<String> set = this.d.get(wVar2);
                if (set == null) {
                    return;
                }
                if (set.contains(str2)) {
                    wVar2.xj(str, str2, obj);
                }
            }
        }
    }

    @Override // com.bytedance.sdk.component.g.xj
    public void xj(w wVar, String str) {
        if (wVar == null || str == null) {
            return;
        }
        Set<String> set = this.d.get(wVar);
        if (set == null) {
            set = new HashSet<>();
            this.d.put(wVar, set);
        }
        set.add(str);
    }

    public void xj(Runnable runnable) {
        xj(runnable, false);
    }

    public void xj(final Runnable runnable, boolean z) {
        if (kd()) {
            runnable.run();
        } else if (z) {
            post(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.MultiWebview.5
                @Override // java.lang.Runnable
                public void run() {
                    if (MultiWebview.this.kd()) {
                        runnable.run();
                    } else {
                        f.hf().post(runnable);
                    }
                }
            });
        } else {
            f.hf().post(runnable);
        }
    }
}
