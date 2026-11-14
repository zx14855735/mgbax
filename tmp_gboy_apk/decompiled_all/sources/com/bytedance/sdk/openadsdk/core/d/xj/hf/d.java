package com.bytedance.sdk.openadsdk.core.d.xj.hf;

import ADYaiT.CtFAbx;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.webkit.DownloadListener;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.baidu.mobads.sdk.internal.br;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.bytedance.sdk.openadsdk.core.a;
import com.bytedance.sdk.openadsdk.core.a.pz;
import com.bytedance.sdk.openadsdk.core.a.r;
import com.bytedance.sdk.openadsdk.core.a.wo;
import com.bytedance.sdk.openadsdk.core.ai;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.j;
import com.bytedance.sdk.openadsdk.core.ra.h;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

@com.bytedance.sdk.component.p.hf.hf
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class d implements com.bytedance.sdk.component.p.xj.xj.w {

    /* renamed from: a, reason: collision with root package name */
    private String f10344a;

    @com.bytedance.sdk.component.p.hf.xj(xj = "end_card_height")
    private int ai;
    protected com.bytedance.sdk.openadsdk.core.widget.xj.u c;

    @com.bytedance.sdk.component.p.hf.xj(xj = "show_type")
    private int dk;

    @com.bytedance.sdk.component.p.hf.xj(xj = "web_view")
    private WeakReference<SSWebView> e;
    private double en;

    @com.bytedance.sdk.component.p.hf.xj(xj = "end_card_param")
    private com.bytedance.sdk.openadsdk.core.d.xj.w.xj et;
    com.bytedance.sdk.openadsdk.core.am.kd f;
    private double ff;

    @com.bytedance.sdk.component.p.hf.xj(xj = "close_button")
    private View ht;

    /* renamed from: io, reason: collision with root package name */
    @com.bytedance.sdk.component.p.hf.xj(xj = "orientation")
    private int f10345io;
    private double j;

    @com.bytedance.sdk.component.p.hf.xj(xj = "is_reward")
    private boolean jk;
    protected com.bytedance.sdk.openadsdk.core.am.d kd;
    private double l;

    @com.bytedance.sdk.component.p.hf.xj(xj = "extra_map")
    private Map<String, Object> pz;

    @com.bytedance.sdk.component.p.hf.xj(xj = "action_type")
    private int q;

    @com.bytedance.sdk.component.p.hf.xj(xj = "download_listener")
    private DownloadListener ra;
    protected j u;

    @com.bytedance.sdk.component.p.hf.xj(xj = "event_tag")
    private String v;
    private boolean wo;

    @com.bytedance.sdk.component.p.hf.xj(xj = "end_card_width")
    private int x;

    @com.bytedance.sdk.component.p.hf.xj(xj = TTDownloadField.TT_ACTIVITY)
    protected TTBaseVideoActivity xj;
    protected String y;

    @com.bytedance.sdk.component.p.hf.xj(xj = "material_meta")
    private ws yo;
    private final Map<String, Bitmap> z = new HashMap();
    int hf = 0;
    int w = 0;
    int d = 0;
    String tf = "";
    protected boolean p = false;

    /* renamed from: pl, reason: collision with root package name */
    protected boolean f10346pl = false;
    protected final AtomicBoolean g = new AtomicBoolean(true);
    private Handler r = new Handler(Looper.myLooper()) { // from class: com.bytedance.sdk.openadsdk.core.d.xj.hf.d.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case 1:
                    d.this.g();
                    break;
                case 2:
                    d.this.kd();
                    break;
                case 3:
                    d.this.c();
                    break;
                case 4:
                    d.this.f();
                    break;
                case 5:
                    d.this.d();
                    break;
                case 6:
                    d.this.tf();
                    break;
                case 7:
                    d.this.p();
                    break;
                case 8:
                    d.this.pl();
                    break;
                case 9:
                    d.this.am();
                    break;
                case 10:
                    d.this.qt();
                    break;
                case 11:
                    d.this.zg();
                    break;
                case 12:
                    d.this.e();
                    break;
                case 13:
                    d.this.yo();
                    break;
                case 14:
                    d.this.v();
                    break;
            }
        }
    };
    protected AtomicBoolean am = new AtomicBoolean(false);
    protected com.bytedance.sdk.openadsdk.core.jk.xj qt = new com.bytedance.sdk.openadsdk.core.jk.xj() { // from class: com.bytedance.sdk.openadsdk.core.d.xj.hf.d.6
        @Override // com.bytedance.sdk.openadsdk.core.jk.xj
        public int hf() {
            SSWebView sSWebView = d.this.e != null ? (SSWebView) d.this.e.get() : null;
            int measuredWidth = sSWebView != null ? sSWebView.getMeasuredWidth() : -1;
            return measuredWidth <= 0 ? r.u((Context) d.this.xj) : measuredWidth;
        }

        @Override // com.bytedance.sdk.openadsdk.core.jk.xj
        public int xj() {
            SSWebView sSWebView = d.this.e != null ? (SSWebView) d.this.e.get() : null;
            int measuredHeight = sSWebView != null ? sSWebView.getMeasuredHeight() : -1;
            return measuredHeight <= 0 ? r.kd((Context) d.this.xj) : measuredHeight;
        }
    };
    protected com.bytedance.sdk.openadsdk.core.jk.y zg = new com.bytedance.sdk.openadsdk.core.jk.y() { // from class: com.bytedance.sdk.openadsdk.core.d.xj.hf.d.7
        @Override // com.bytedance.sdk.openadsdk.core.jk.y
        public void hf() {
            SSWebView sSWebView = d.this.e != null ? (SSWebView) d.this.e.get() : null;
            if (sSWebView == null) {
                return;
            }
            sSWebView.pauseTimers();
        }

        @Override // com.bytedance.sdk.openadsdk.core.jk.y
        public void xj() {
            SSWebView sSWebView = d.this.e != null ? (SSWebView) d.this.e.get() : null;
            if (sSWebView == null) {
                return;
            }
            sSWebView.onPause();
        }
    };
    private final com.bytedance.sdk.openadsdk.core.jk.hf b = new com.bytedance.sdk.openadsdk.core.jk.hf() { // from class: com.bytedance.sdk.openadsdk.core.d.xj.hf.d.8
        @Override // com.bytedance.sdk.openadsdk.core.jk.hf
        public void xj(boolean z, int i, String str) {
            if (z) {
                d dVar = d.this;
                dVar.f10346pl = true;
                if (dVar.wo) {
                    d dVar2 = d.this;
                    dVar2.xj(dVar2.j, d.this.en, d.this.l, d.this.ff, d.this.f10344a);
                    d.this.wo = false;
                }
            }
            if (h.tf(d.this.yo)) {
                d.this.xj(z, i, str);
            }
        }
    };
    private final com.bytedance.sdk.openadsdk.tf.xj ws = new com.bytedance.sdk.openadsdk.tf.xj() { // from class: com.bytedance.sdk.openadsdk.core.d.xj.hf.d.9
        @Override // com.bytedance.sdk.openadsdk.tf.xj
        public void xj() {
            d.this.xj.f(1);
        }
    };

    private void dk() {
        j jVar = this.u;
        if (jVar == null) {
            return;
        }
        jVar.xj(new SSWebView.hf() { // from class: com.bytedance.sdk.openadsdk.core.d.xj.hf.d.5
            @Override // com.bytedance.sdk.component.widget.SSWebView.hf
            public void xj(int i) {
                j jVar2 = d.this.u;
                if (jVar2 != null) {
                    jVar2.xj(i);
                }
            }
        });
    }

    private void ht() {
        WeakReference<SSWebView> weakReference;
        if (this.am.getAndSet(true) || (weakReference = this.e) == null) {
            return;
        }
        try {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(weakReference.get(), "translationY", r.kd((Context) this.xj), 0.0f);
            ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
            ofFloat.setDuration(1000L);
            ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.openadsdk.core.d.xj.hf.d.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    d.this.am.set(false);
                }
            });
            ofFloat.start();
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.pl.xj(th);
        }
    }

    private void jk() {
        com.bytedance.sdk.openadsdk.core.d.xj.w.xj xjVar = this.et;
        if (xjVar == null) {
            return;
        }
        xjVar.xj(new com.bytedance.sdk.openadsdk.core.d.xj.w.xj() { // from class: com.bytedance.sdk.openadsdk.core.d.xj.hf.d.10
        });
    }

    private void pz() {
        this.y = h.f(this.yo);
        float yq = this.yo.yq();
        if (TextUtils.isEmpty(this.y)) {
            return;
        }
        if (this.f10345io == 1) {
            if (this.y.contains("?")) {
                this.y = CtFAbx.B25kr6(new StringBuilder(), this.y, "&orientation=portrait");
            } else {
                this.y = CtFAbx.B25kr6(new StringBuilder(), this.y, "?orientation=portrait");
            }
        }
        if (this.y.contains("?")) {
            this.y += "&height=" + this.ai + "&width=" + this.x + "&aspect_ratio=" + yq;
        } else {
            this.y += "?height=" + this.ai + "&width=" + this.x + "&aspect_ratio=" + yq;
        }
        this.y = com.bytedance.sdk.openadsdk.core.component.reward.kd.xj.xj(this.y);
    }

    private void ra() {
        WeakReference<SSWebView> weakReference;
        final SSWebView sSWebView;
        if (this.am.getAndSet(true) || (weakReference = this.e) == null || (sSWebView = weakReference.get()) == null) {
            return;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(sSWebView, "translationY", 0.0f, r.kd((Context) this.xj));
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.setDuration(1000L);
        ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.openadsdk.core.d.xj.hf.d.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                r.xj((View) sSWebView, 8);
                d.this.am.set(false);
            }
        });
        ofFloat.start();
    }

    public void am() {
        SSWebView sSWebView;
        WeakReference<SSWebView> weakReference = this.e;
        if (weakReference == null || (sSWebView = weakReference.get()) == null) {
            return;
        }
        sSWebView.onResume();
        sSWebView.resumeTimers();
        r.xj((View) sSWebView, 1.0f);
        dk();
    }

    public void d() {
        this.kd = null;
    }

    public void e() {
        com.bytedance.sdk.openadsdk.core.am.d dVar = this.kd;
        if (dVar != null) {
            dVar.pl();
        }
    }

    public void g() {
        WeakReference<SSWebView> weakReference = this.e;
        SSWebView sSWebView = weakReference != null ? weakReference.get() : null;
        if (sSWebView != null) {
            a.xj(this.xj, sSWebView);
            a.xj(sSWebView);
            sSWebView.destroy();
        }
        WeakReference<SSWebView> weakReference2 = this.e;
        if (weakReference2 != null) {
            weakReference2.clear();
        }
        j jVar = this.u;
        if (jVar != null) {
            jVar.q();
        }
        com.bytedance.sdk.openadsdk.core.am.d dVar = this.kd;
        if (dVar != null) {
            dVar.xj(true);
            this.kd.zg();
        }
        com.bytedance.sdk.openadsdk.core.am.kd kdVar = this.f;
        if (kdVar != null) {
            kdVar.y();
        }
        this.z.clear();
    }

    public void p() {
        WeakReference<SSWebView> weakReference = this.e;
        SSWebView sSWebView = weakReference != null ? weakReference.get() : null;
        if (sSWebView != null) {
            sSWebView.onPause();
        }
        j jVar = this.u;
        if (jVar != null) {
            jVar.ai();
            this.u.y(false);
            xj(false);
            xj(true, false);
        }
        com.bytedance.sdk.openadsdk.core.widget.xj.u uVar = this.c;
        if (uVar != null) {
            uVar.w();
        }
    }

    public void pl() {
        com.bytedance.sdk.openadsdk.core.am.kd kdVar = this.f;
        if (kdVar != null) {
            kdVar.kd();
        }
    }

    public void qt() {
        com.bytedance.sdk.openadsdk.core.am.d dVar = this.kd;
        if (dVar != null) {
            dVar.d();
        }
    }

    public void tf() {
        WeakReference<SSWebView> weakReference = this.e;
        SSWebView sSWebView = weakReference != null ? weakReference.get() : null;
        if (sSWebView != null) {
            sSWebView.onResume();
        }
        j jVar = this.u;
        if (jVar != null) {
            jVar.x();
            if (sSWebView != null) {
                if (sSWebView.getVisibility() == 0) {
                    this.u.y(true);
                    xj(true);
                    xj(false, true);
                } else {
                    this.u.y(false);
                    xj(false);
                    xj(true, false);
                }
            }
        }
        com.bytedance.sdk.openadsdk.core.am.kd kdVar = this.f;
        if (kdVar != null) {
            kdVar.u();
        }
        com.bytedance.sdk.openadsdk.core.widget.xj.u uVar = this.c;
        if (uVar != null) {
            uVar.hf(false);
        }
    }

    public void v() {
        SSWebView sSWebView;
        WeakReference<SSWebView> weakReference = this.e;
        if (weakReference == null || (sSWebView = weakReference.get()) == null) {
            return;
        }
        sSWebView.loadUrl("about:blank");
    }

    public void yo() {
        com.bytedance.sdk.openadsdk.core.am.d dVar = this.kd;
        if (dVar != null) {
            dVar.w();
            this.kd.u();
        }
    }

    public void zg() {
        com.bytedance.sdk.openadsdk.core.am.d dVar = this.kd;
        if (dVar != null) {
            dVar.p();
        }
    }

    public void c() {
        com.bytedance.sdk.openadsdk.core.am.kd kdVar = this.f;
        if (kdVar != null) {
            kdVar.xj(System.currentTimeMillis());
        }
    }

    public void f() {
        if (this.xj.aq() instanceof com.bytedance.sdk.openadsdk.core.component.reward.u.d) {
            ra();
            return;
        }
        WeakReference<SSWebView> weakReference = this.e;
        if (weakReference == null) {
            return;
        }
        r.xj((View) weakReference.get(), 8);
    }

    public void hf() {
        SSWebView sSWebView;
        WeakReference<SSWebView> weakReference = this.e;
        if (weakReference == null || (sSWebView = weakReference.get()) == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        com.bytedance.sdk.openadsdk.core.am.d dVar = new com.bytedance.sdk.openadsdk.core.am.d(this.v, this.yo, jSONObject);
        this.kd = dVar;
        dVar.xj(jSONObject, "webview_source", (Object) 2);
        com.bytedance.sdk.openadsdk.core.am.kd hf = new com.bytedance.sdk.openadsdk.core.am.kd(this.yo, sSWebView).hf(true);
        this.f = hf;
        hf.xj(true);
        pz();
        this.f.xj(u() ? "landingpage_endcard" : this.jk ? "reward_endcard" : "fullscreen_endcard");
        j jVar = new j(this.xj) { // from class: com.bytedance.sdk.openadsdk.core.d.xj.hf.d.12
        };
        this.u = jVar;
        jVar.hf(sSWebView).xj(this.yo).hf(this.yo.ho()).u(this.yo.jf()).w(this.jk ? 7 : 5).xj(this.qt).kd(wo.zg(this.yo)).xj(sSWebView).hf(com.bytedance.sdk.openadsdk.core.pl.w.tf.xj(this.yo)).xj(this.kd).xj(this.v).xj(this.pz).xj(this.zg).xj(this.ht).xj(this.ws);
        this.u.xj(this.b);
    }

    public void kd() {
        SSWebView sSWebView;
        WeakReference<SSWebView> weakReference = this.e;
        if (weakReference == null || (sSWebView = weakReference.get()) == null || this.p) {
            return;
        }
        sSWebView.loadUrl(this.y);
        this.p = true;
    }

    public boolean u() {
        String str = this.y;
        if (str == null) {
            return false;
        }
        try {
            return Uri.parse(str).getQueryParameterNames().contains("show_landingpage");
        } catch (Exception unused) {
            return false;
        }
    }

    public void w() {
        SSWebView sSWebView;
        WeakReference<SSWebView> weakReference = this.e;
        if (weakReference == null || (sSWebView = weakReference.get()) == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.widget.xj.u uVar = new com.bytedance.sdk.openadsdk.core.widget.xj.u(this.xj, this.u, this.yo.ho(), this.f) { // from class: com.bytedance.sdk.openadsdk.core.d.xj.hf.d.13
            @Override // com.bytedance.sdk.openadsdk.core.widget.xj.u, android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                com.bytedance.sdk.openadsdk.core.am.d dVar = d.this.kd;
                if (dVar != null) {
                    dVar.c();
                }
                super.onPageFinished(webView, str);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.xj.u, android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                com.bytedance.sdk.openadsdk.core.am.d dVar = d.this.kd;
                if (dVar != null) {
                    dVar.y();
                }
                super.onPageStarted(webView, str, bitmap);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.xj.u, android.webkit.WebViewClient
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                d.this.g.set(false);
                d dVar = d.this;
                dVar.d = i;
                dVar.tf = str;
                if (dVar.kd != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        if (Build.VERSION.SDK_INT >= 23) {
                            jSONObject.put(PluginConstants.KEY_ERROR_CODE, i);
                            jSONObject.put(br.c, str);
                        }
                        d.this.kd.hf(jSONObject);
                    } catch (JSONException unused) {
                    }
                }
                super.onReceivedError(webView, i, str, str2);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.xj.u, android.webkit.WebViewClient
            @TargetApi(21)
            public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                if (d.this.kd != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(PluginConstants.KEY_ERROR_CODE, webResourceResponse.getStatusCode());
                        jSONObject.put(br.c, webResourceResponse.getReasonPhrase());
                        d.this.kd.hf(jSONObject);
                    } catch (JSONException unused) {
                    }
                }
                if (d.this.y.equals(String.valueOf(webResourceRequest.getUrl()))) {
                    if (webResourceRequest.isForMainFrame()) {
                        d.this.g.set(false);
                    }
                    if (webResourceResponse != null) {
                        d.this.d = webResourceResponse.getStatusCode();
                        d.this.tf = "onReceivedHttpError";
                    }
                }
                super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.xj.u, android.webkit.WebViewClient
            public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
                WebResourceResponse xj = d.this.xj(str);
                return xj != null ? xj : super.shouldInterceptRequest(webView, str);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.xj.u, android.webkit.WebViewClient
            public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
                try {
                    String uri = webResourceRequest.getUrl().toString();
                    if (d.this.yo != null) {
                        WebResourceResponse xj = d.this.xj(uri);
                        if (xj != null) {
                            return xj;
                        }
                        if (TextUtils.isEmpty(d.this.yo.db())) {
                            return super.shouldInterceptRequest(webView, uri);
                        }
                        d.this.hf++;
                        return super.shouldInterceptRequest(webView, uri);
                    }
                    return super.shouldInterceptRequest(webView, uri);
                } catch (Throwable unused) {
                    return super.shouldInterceptRequest(webView, webResourceRequest);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.xj.u, android.webkit.WebViewClient
            @TargetApi(23)
            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                int errorCode;
                CharSequence description;
                int errorCode2;
                CharSequence description2;
                if (webResourceRequest.isForMainFrame()) {
                    d.this.g.set(false);
                }
                if (d.this.kd != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        if (Build.VERSION.SDK_INT >= 23) {
                            errorCode = webResourceError.getErrorCode();
                            jSONObject.put(PluginConstants.KEY_ERROR_CODE, errorCode);
                            description = webResourceError.getDescription();
                            jSONObject.put(br.c, description);
                        }
                        d.this.kd.hf(jSONObject);
                    } catch (JSONException unused) {
                    }
                }
                d dVar = d.this;
                errorCode2 = webResourceError.getErrorCode();
                dVar.d = errorCode2;
                d dVar2 = d.this;
                description2 = webResourceError.getDescription();
                dVar2.tf = String.valueOf(description2);
                super.onReceivedError(webView, webResourceRequest, webResourceError);
            }
        };
        this.c = uVar;
        sSWebView.setWebViewClient(uVar);
        xj(sSWebView);
        sSWebView.setBackgroundColor(-1);
        sSWebView.setDisplayZoomControls(false);
        sSWebView.setWebChromeClient(new com.bytedance.sdk.openadsdk.core.widget.xj.w(this.u, this.f) { // from class: com.bytedance.sdk.openadsdk.core.d.xj.hf.d.2
            @Override // com.bytedance.sdk.openadsdk.core.widget.xj.w, android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i) {
                super.onProgressChanged(webView, i);
            }
        });
        sSWebView.setDownloadListener(this.ra);
    }

    public void y() {
        SSWebView sSWebView;
        WeakReference<SSWebView> weakReference = this.e;
        if (weakReference == null || (sSWebView = weakReference.get()) == null) {
            return;
        }
        r.xj((View) sSWebView, 0);
        if (this.dk == 1) {
            r.xj((View) sSWebView, 0.0f);
        }
        if (this.dk == 2) {
            ht();
        }
        j jVar = this.u;
        if (jVar != null) {
            jVar.xj(wo.zg(this.yo), false);
        }
        xj(true);
        hf(true);
        xj(false, true);
    }

    @Override // com.bytedance.sdk.component.p.xj.xj.w
    public boolean xj(Map<String, Object> map, Map<String, Object> map2, com.bytedance.sdk.component.p.xj.xj xjVar) {
        if (this.q != 0) {
            y();
            return true;
        }
        xj();
        hf();
        w();
        jk();
        return true;
    }

    public void xj(boolean z, int i, String str) {
        com.bytedance.sdk.openadsdk.core.am.d dVar = this.kd;
        if (dVar == null) {
            return;
        }
        if (z) {
            dVar.hf();
        } else {
            dVar.xj(i, str);
        }
    }

    public void xj() {
        final SSWebView sSWebView;
        WeakReference<SSWebView> weakReference = this.e;
        if (weakReference == null || (sSWebView = weakReference.get()) == null) {
            return;
        }
        sSWebView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.bytedance.sdk.openadsdk.core.d.xj.hf.d.11
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                SSWebView sSWebView2 = sSWebView;
                if (sSWebView2 == null || sSWebView2.getViewTreeObserver() == null) {
                    return;
                }
                sSWebView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                int measuredWidth = sSWebView.getMeasuredWidth();
                int measuredHeight = sSWebView.getMeasuredHeight();
                if (sSWebView.getVisibility() == 0) {
                    d.this.xj(measuredWidth, measuredHeight);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(int i, int i2) {
        if (this.u == null || this.xj.isFinishing()) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(MediaFormat.KEY_WIDTH, i);
            jSONObject.put(MediaFormat.KEY_HEIGHT, i2);
            this.u.xj("resize", jSONObject);
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
        }
    }

    public void xj(SSWebView sSWebView) {
        if (sSWebView == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.widget.xj.hf.xj(this.xj).xj(false).hf(false).xj(sSWebView);
        pz.xj(sSWebView, ai.w, ws.u(this.yo));
        r.xj((com.bytedance.sdk.component.g.w) sSWebView);
        int i = Build.VERSION.SDK_INT;
        sSWebView.setMixedContentMode(0);
        if (i < 24) {
            sSWebView.setLayerType(0, null);
        }
    }

    public void hf(boolean z) {
        if (this.u == null || this.xj.isFinishing()) {
            return;
        }
        try {
            this.u.y(z);
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
        }
    }

    public void xj(boolean z) {
        if (this.u == null || this.xj.isFinishing()) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("viewStatus", z ? 1 : 0);
            this.u.xj("viewableChange", jSONObject);
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
        }
    }

    public void xj(boolean z, boolean z2) {
        if (this.u == null || this.xj.isFinishing()) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("endcard_mute", z);
            jSONObject.put("endcard_show", z2);
            this.u.xj("endcard_control_event", jSONObject);
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
        }
    }

    public void xj(double d, double d2, double d3, double d4, String str) {
        if (this.u == null || this.xj.isFinishing()) {
            return;
        }
        if (!this.f10346pl) {
            this.j = d;
            this.en = d2;
            this.ff = d4;
            this.l = d3;
            this.f10344a = str;
            this.wo = true;
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("x", d);
            jSONObject.put("y", d2);
            jSONObject.put(MediaFormat.KEY_WIDTH, d3);
            jSONObject.put(MediaFormat.KEY_HEIGHT, d4);
            jSONObject.put("videoFrameKey", str);
            this.u.xj("endcardTransform", jSONObject);
        } catch (JSONException unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public WebResourceResponse xj(String str) {
        if (!str.startsWith("csjclientimg://")) {
            return null;
        }
        Bitmap bitmap = this.z.get(str.replace("csjclientimg://", ""));
        if (bitmap == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        return new WebResourceResponse("text/html", "UTF-8", new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
    }
}
