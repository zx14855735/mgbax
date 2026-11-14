package com.sigmob.sdk.base.views;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.webkit.CookieManager;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.czhj.sdk.common.ThreadPool.ThreadPoolFactory;
import com.czhj.sdk.logger.SigmobLog;
import com.czhj.volley.toolbox.StringUtil;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.views.af;
import com.sigmob.sdk.nativead.APKStatusBroadcastReceiver;
import java.io.File;
import java.io.RandomAccessFile;
import java.lang.ref.WeakReference;
import java.nio.channels.FileLock;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class g extends WebView {

    /* renamed from: a, reason: collision with root package name */
    private static final String f13288a = "g";
    private static boolean b;
    private APKStatusBroadcastReceiver c;
    private WeakReference<com.sigmob.sdk.base.common.b> d;
    private BaseAdUnit e;
    private final Set<String> f;
    private final Map<String, String> g;

    /* renamed from: com.sigmob.sdk.base.views.g$1, reason: invalid class name */
    public class AnonymousClass1 implements af.a {
        public AnonymousClass1() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c() {
            Activity c = com.sigmob.sdk.base.utils.r.c(g.this);
            if (c == null) {
                return;
            }
            com.sigmob.sdk.videoplayer.c.h((Context) c);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d() {
            Activity c = com.sigmob.sdk.base.utils.r.c(g.this);
            if (c == null) {
                return;
            }
            com.sigmob.sdk.videoplayer.c.j(c);
        }

        @Override // com.sigmob.sdk.base.views.af.a
        public void a() {
            ThreadPoolFactory.MainThreadRun(new AMqCpz(this, 0));
        }

        @Override // com.sigmob.sdk.base.views.af.a
        public void b() {
            ThreadPoolFactory.MainThreadRun(new AMqCpz(this, 1));
        }
    }

    public g(Context context) {
        super(context);
        this.f = new HashSet();
        this.g = new HashMap();
        removeJavascriptInterface("searchBoxJavaBridge_");
        removeJavascriptInterface("accessibility");
        removeJavascriptInterface("accessibilityTraversal");
        a(getSettings());
        if (!b) {
            b(getContext());
            b = true;
        }
        resumeTimers();
        a(context);
    }

    public static void d() {
        CookieManager cookieManager = CookieManager.getInstance();
        if (com.sigmob.sdk.base.i.a().i()) {
            cookieManager.setAcceptCookie(true);
            CookieManager.setAcceptFileSchemeCookies(true);
            return;
        }
        cookieManager.setAcceptCookie(false);
        CookieManager.setAcceptFileSchemeCookies(false);
        cookieManager.removeSessionCookies(null);
        cookieManager.removeAllCookies(null);
        cookieManager.flush();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.sigmob.sdk.base.common.b getListener() {
        WeakReference<com.sigmob.sdk.base.common.b> weakReference = this.d;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    @Override // android.webkit.WebView
    @SuppressLint({"JavascriptInterface"})
    public void addJavascriptInterface(Object obj, String str) {
        super.addJavascriptInterface(obj, str);
        this.f.add(str);
    }

    public void b() {
        com.sigmob.sdk.base.utils.r.a(this);
        APKStatusBroadcastReceiver aPKStatusBroadcastReceiver = this.c;
        if (aPKStatusBroadcastReceiver != null) {
            aPKStatusBroadcastReceiver.b(aPKStatusBroadcastReceiver);
            this.c = null;
        }
        setWebViewClient(null);
        removeAllViews();
        Iterator<String> it = this.f.iterator();
        while (it.hasNext()) {
            removeJavascriptInterface(it.next());
        }
        this.f.clear();
        setWebChromeClient(null);
        loadUrl("");
        this.e = null;
    }

    public void c() {
        setWebChromeClient(new WebChromeClient() { // from class: com.sigmob.sdk.base.views.g.3
            @Override // android.webkit.WebChromeClient
            public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
                SigmobLog.i(str2);
                jsResult.confirm();
                return true;
            }

            @Override // android.webkit.WebChromeClient
            public boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
                SigmobLog.i(str2);
                jsResult.confirm();
                return true;
            }

            @Override // android.webkit.WebChromeClient
            public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
                SigmobLog.i(str2);
                jsResult.confirm();
                return true;
            }

            @Override // android.webkit.WebChromeClient
            public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
                SigmobLog.i(str2);
                jsPromptResult.confirm();
                return true;
            }
        });
    }

    @Override // android.webkit.WebView
    public void destroy() {
        b();
        SigmobLog.d(" BaseWebView destroy called ");
        super.destroy();
    }

    public void e() {
        a("bridge.notifyApkDownloadStartEvent();", (ValueCallback) null);
    }

    public void f() {
        a("bridge.notifyApkDownloadFailEvent();", (ValueCallback) null);
    }

    public void g() {
        a("bridge.notifyApkDownloadPauseEvent();", (ValueCallback) null);
    }

    public void h() {
        a("bridge.notifyApkDownloadEndEvent();", (ValueCallback) null);
    }

    public void i() {
        a("bridge.notifyApkDownloadInstalledEvent();", (ValueCallback) null);
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str) {
        String url = StringUtil.getUrl(str);
        this.g.put("Referer", "");
        BaseAdUnit baseAdUnit = this.e;
        if (baseAdUnit != null && baseAdUnit.isDisablexRequestWith()) {
            this.g.put("X-Requested-With", "");
        }
        loadUrl(url, this.g);
    }

    public void setAdUnit(BaseAdUnit baseAdUnit) {
        this.e = baseAdUnit;
        if (baseAdUnit == null) {
            return;
        }
        addJavascriptInterface(new af(baseAdUnit, new AnonymousClass1()), "sigandroidh5");
    }

    private void b(Context context) {
    }

    public void a() {
        if (this.e == null || this.c != null) {
            return;
        }
        APKStatusBroadcastReceiver aPKStatusBroadcastReceiver = new APKStatusBroadcastReceiver(new com.sigmob.sdk.base.common.b() { // from class: com.sigmob.sdk.base.views.g.2
            @Override // com.sigmob.sdk.base.common.b
            public void a(boolean z) {
                com.sigmob.sdk.base.common.b listener = g.this.getListener();
                if (listener != null) {
                    listener.a(z);
                }
            }

            @Override // com.sigmob.sdk.base.common.b
            public void b(boolean z) {
                com.sigmob.sdk.base.common.b listener = g.this.getListener();
                if (listener != null) {
                    listener.b(z);
                } else if (z) {
                    g.this.i();
                } else {
                    g.this.f();
                }
            }

            @Override // com.sigmob.sdk.base.common.b
            public void c(boolean z, long j) {
                com.sigmob.sdk.base.common.b listener = g.this.getListener();
                if (listener != null) {
                    listener.c(z, j);
                }
                g.this.g();
            }

            @Override // com.sigmob.sdk.base.common.b
            public void a(boolean z, long j) {
                com.sigmob.sdk.base.common.b listener = g.this.getListener();
                if (listener != null) {
                    listener.b(z, j);
                } else if (z) {
                    g.this.e();
                } else {
                    g.this.f();
                }
            }

            @Override // com.sigmob.sdk.base.common.b
            public void b(boolean z, long j) {
                com.sigmob.sdk.base.common.b listener = g.this.getListener();
                if (listener != null) {
                    listener.b(z, j);
                } else if (z) {
                    g.this.h();
                } else {
                    g.this.f();
                }
            }
        }, this.e.getUuid());
        this.c = aPKStatusBroadcastReceiver;
        aPKStatusBroadcastReceiver.a(aPKStatusBroadcastReceiver);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x00e9 A[Catch: Exception -> 0x00fe, TryCatch #0 {Exception -> 0x00fe, blocks: (B:4:0x000c, B:7:0x002f, B:9:0x0035, B:10:0x0039, B:12:0x0066, B:13:0x0077, B:14:0x00df, B:15:0x00e3, B:17:0x00e9, B:20:0x00fa, B:27:0x007f, B:29:0x00bb), top: B:3:0x000c }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void a(android.content.Context r10) {
        /*
            java.lang.String r0 = "/app_hws_webview/webview_data.lock"
            java.lang.String r1 = "/app_webview/webview_data.lock"
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 28
            if (r2 >= r3) goto Lc
            goto L102
        Lc:
            java.lang.String r2 = "/app_webview"
            java.lang.String r3 = "/app_hws_webview"
            java.lang.String r4 = "/webview_data.lock"
            java.io.File r5 = com.google.android.material.datepicker.BPw6Q8.AMqCpz(r10)     // Catch: java.lang.Exception -> Lfe
            java.lang.String r5 = r5.getAbsolutePath()     // Catch: java.lang.Exception -> Lfe
            java.util.HashSet r6 = new java.util.HashSet     // Catch: java.lang.Exception -> Lfe
            r6.<init>()     // Catch: java.lang.Exception -> Lfe
            java.lang.String r7 = I3HV03.ADYaiT.AzWtSf()     // Catch: java.lang.Exception -> Lfe
            java.lang.String r8 = r10.getPackageName()     // Catch: java.lang.Exception -> Lfe
            boolean r8 = android.text.TextUtils.equals(r8, r7)     // Catch: java.lang.Exception -> Lfe
            java.lang.String r9 = "_"
            if (r8 != 0) goto L7f
            boolean r0 = android.text.TextUtils.isEmpty(r7)     // Catch: java.lang.Exception -> Lfe
            if (r0 == 0) goto L39
            java.lang.String r7 = r10.getPackageName()     // Catch: java.lang.Exception -> Lfe
        L39:
            I3HV03.ADYaiT.B9tovu(r7)     // Catch: java.lang.Exception -> Lfe
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Lfe
            r10.<init>(r9)     // Catch: java.lang.Exception -> Lfe
            r10.append(r7)     // Catch: java.lang.Exception -> Lfe
            java.lang.String r10 = r10.toString()     // Catch: java.lang.Exception -> Lfe
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Lfe
            r0.<init>()     // Catch: java.lang.Exception -> Lfe
            r0.append(r5)     // Catch: java.lang.Exception -> Lfe
            r0.append(r2)     // Catch: java.lang.Exception -> Lfe
            r0.append(r10)     // Catch: java.lang.Exception -> Lfe
            r0.append(r4)     // Catch: java.lang.Exception -> Lfe
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Exception -> Lfe
            r6.add(r0)     // Catch: java.lang.Exception -> Lfe
            boolean r0 = com.czhj.sdk.common.utils.RomUtils.isHuawei()     // Catch: java.lang.Exception -> Lfe
            if (r0 == 0) goto Ldf
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Lfe
            r0.<init>()     // Catch: java.lang.Exception -> Lfe
            r0.append(r5)     // Catch: java.lang.Exception -> Lfe
            r0.append(r3)     // Catch: java.lang.Exception -> Lfe
            r0.append(r10)     // Catch: java.lang.Exception -> Lfe
            r0.append(r4)     // Catch: java.lang.Exception -> Lfe
        L77:
            java.lang.String r10 = r0.toString()     // Catch: java.lang.Exception -> Lfe
            r6.add(r10)     // Catch: java.lang.Exception -> Lfe
            goto Ldf
        L7f:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Lfe
            r10.<init>(r9)     // Catch: java.lang.Exception -> Lfe
            r10.append(r7)     // Catch: java.lang.Exception -> Lfe
            java.lang.String r10 = r10.toString()     // Catch: java.lang.Exception -> Lfe
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Lfe
            r7.<init>()     // Catch: java.lang.Exception -> Lfe
            r7.append(r5)     // Catch: java.lang.Exception -> Lfe
            r7.append(r1)     // Catch: java.lang.Exception -> Lfe
            java.lang.String r1 = r7.toString()     // Catch: java.lang.Exception -> Lfe
            r6.add(r1)     // Catch: java.lang.Exception -> Lfe
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Lfe
            r1.<init>()     // Catch: java.lang.Exception -> Lfe
            r1.append(r5)     // Catch: java.lang.Exception -> Lfe
            r1.append(r2)     // Catch: java.lang.Exception -> Lfe
            r1.append(r10)     // Catch: java.lang.Exception -> Lfe
            r1.append(r4)     // Catch: java.lang.Exception -> Lfe
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Exception -> Lfe
            r6.add(r1)     // Catch: java.lang.Exception -> Lfe
            boolean r1 = com.czhj.sdk.common.utils.RomUtils.isHuawei()     // Catch: java.lang.Exception -> Lfe
            if (r1 == 0) goto Ldf
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Lfe
            r1.<init>()     // Catch: java.lang.Exception -> Lfe
            r1.append(r5)     // Catch: java.lang.Exception -> Lfe
            r1.append(r0)     // Catch: java.lang.Exception -> Lfe
            java.lang.String r0 = r1.toString()     // Catch: java.lang.Exception -> Lfe
            r6.add(r0)     // Catch: java.lang.Exception -> Lfe
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Lfe
            r0.<init>()     // Catch: java.lang.Exception -> Lfe
            r0.append(r5)     // Catch: java.lang.Exception -> Lfe
            r0.append(r3)     // Catch: java.lang.Exception -> Lfe
            r0.append(r10)     // Catch: java.lang.Exception -> Lfe
            r0.append(r4)     // Catch: java.lang.Exception -> Lfe
            goto L77
        Ldf:
            java.util.Iterator r10 = r6.iterator()     // Catch: java.lang.Exception -> Lfe
        Le3:
            boolean r0 = r10.hasNext()     // Catch: java.lang.Exception -> Lfe
            if (r0 == 0) goto L102
            java.lang.Object r0 = r10.next()     // Catch: java.lang.Exception -> Lfe
            java.lang.String r0 = (java.lang.String) r0     // Catch: java.lang.Exception -> Lfe
            java.io.File r1 = new java.io.File     // Catch: java.lang.Exception -> Lfe
            r1.<init>(r0)     // Catch: java.lang.Exception -> Lfe
            boolean r0 = r1.exists()     // Catch: java.lang.Exception -> Lfe
            if (r0 == 0) goto Le3
            a(r1)     // Catch: java.lang.Exception -> Lfe
            return
        Lfe:
            r10 = move-exception
            r10.printStackTrace()
        L102:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.base.views.g.a(android.content.Context):void");
    }

    public void b(boolean z) {
        if (z) {
            stopLoading();
            loadUrl("");
        }
        onPause();
    }

    private void a(WebSettings webSettings) {
        com.sigmob.sdk.base.utils.h.a(f13288a, webSettings);
        webSettings.setDomStorageEnabled(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setBuiltInZoomControls(false);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setSupportZoom(true);
        webSettings.setDefaultTextEncodingName("UTF-8");
        webSettings.setBlockNetworkImage(false);
        webSettings.setBlockNetworkLoads(false);
        webSettings.setCacheMode(-1);
        int i = Build.VERSION.SDK_INT;
        webSettings.setMediaPlaybackRequiresUserGesture(false);
        webSettings.setLoadsImagesAutomatically(true);
        webSettings.setAllowContentAccess(true);
        if (i >= 26) {
            try {
                webSettings.setSafeBrowsingEnabled(false);
            } catch (Throwable unused) {
            }
        }
        try {
            webSettings.setMixedContentMode(0);
        } catch (Throwable unused2) {
        }
        addJavascriptInterface(new ae(getContext(), this.e, new ADYaiT(this)), "sigandroidapk");
    }

    public static void a(WebView webView) {
        CookieManager.getInstance().setAcceptThirdPartyCookies(webView, com.sigmob.sdk.base.i.a().i());
    }

    public void a(com.sigmob.sdk.base.common.b bVar) {
        this.d = new WeakReference<>(bVar);
    }

    @TargetApi(28)
    private static void a(File file) {
        try {
            FileLock tryLock = new RandomAccessFile(file, "rw").getChannel().tryLock();
            if (tryLock != null) {
                tryLock.close();
            } else {
                a(file, file.delete());
            }
        } catch (Exception e) {
            e.printStackTrace();
            a(file, file.exists() ? file.delete() : false);
        }
    }

    private static void a(File file, boolean z) {
        if (z) {
            try {
                if (file.exists()) {
                    return;
                }
                file.createNewFile();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void a(String str, ValueCallback valueCallback) {
        SigmobLog.d("Injecting Javascript into MRAID WebView:\n\t" + str);
        if (str.startsWith("bridge")) {
            str = str.replaceFirst("bridge", StringUtil.decode(StringUtil.s));
        }
        evaluateJavascript(str, valueCallback);
    }

    public void a(boolean z) {
    }
}
