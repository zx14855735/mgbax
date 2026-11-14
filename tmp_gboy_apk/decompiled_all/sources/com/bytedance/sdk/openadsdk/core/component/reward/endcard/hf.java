package com.bytedance.sdk.openadsdk.core.component.reward.endcard;

import ADYaiT.CtFAbx;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.baidu.mobads.sdk.internal.br;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.bykv.vk.openvk.component.video.xj.kd.hf;
import com.bytedance.sdk.component.adexpress.hf.am;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.bytedance.sdk.openadsdk.core.a.wo;
import com.bytedance.sdk.openadsdk.core.am.d;
import com.bytedance.sdk.openadsdk.core.am.kd;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.endcard.layout.AbstractEndCardFrameLayout;
import com.bytedance.sdk.openadsdk.core.j;
import com.bytedance.sdk.openadsdk.core.pl.w.tf;
import com.bytedance.sdk.openadsdk.core.ra.aq;
import com.bytedance.sdk.openadsdk.core.ra.h;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class hf extends xj {
    private double ai;
    private String en;
    private final Map<String, Bitmap> et;

    /* renamed from: io, reason: collision with root package name */
    private final com.bytedance.sdk.openadsdk.tf.xj f10305io;
    private double j;
    private boolean l;
    private double q;
    private final com.bytedance.sdk.openadsdk.core.jk.hf x;
    private double z;

    public hf(TTBaseVideoActivity tTBaseVideoActivity, ws wsVar, String str, int i, int i2, boolean z, AbstractEndCardFrameLayout abstractEndCardFrameLayout) {
        super(tTBaseVideoActivity, wsVar, str, i, i2, z);
        this.et = new HashMap();
        this.f10305io = new com.bytedance.sdk.openadsdk.tf.xj() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.hf.1
            @Override // com.bytedance.sdk.openadsdk.tf.xj
            public void xj() {
                hf.this.xj.f(1);
            }
        };
        this.x = new com.bytedance.sdk.openadsdk.core.jk.hf() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.hf.2
            @Override // com.bytedance.sdk.openadsdk.core.jk.hf
            public void xj(boolean z2, int i3, String str2) {
                if (z2) {
                    hf hfVar = hf.this;
                    hfVar.zg = true;
                    if (hfVar.l) {
                        hf hfVar2 = hf.this;
                        hfVar2.xj(hfVar2.ai, hf.this.q, hf.this.z, hf.this.j, hf.this.en);
                        hf.this.l = false;
                    }
                }
                if (h.tf(hf.this.hf)) {
                    hf.this.xj(z2, i3, str2);
                }
            }
        };
        this.c = abstractEndCardFrameLayout.getEndCardWebView();
        xj();
    }

    private void q() {
        this.tf = h.f(this.hf);
        float yq = this.hf.yq();
        if (TextUtils.isEmpty(this.tf)) {
            return;
        }
        if (this.v == 1) {
            if (this.tf.contains("?")) {
                this.tf = CtFAbx.B25kr6(new StringBuilder(), this.tf, "&orientation=portrait");
            } else {
                this.tf = CtFAbx.B25kr6(new StringBuilder(), this.tf, "?orientation=portrait");
            }
        }
        if (this.tf.contains("?")) {
            this.tf += "&height=" + this.pz + "&width=" + this.jk + "&aspect_ratio=" + yq;
        } else {
            this.tf += "?height=" + this.pz + "&width=" + this.jk + "&aspect_ratio=" + yq;
        }
        this.tf = com.bytedance.sdk.openadsdk.core.component.reward.kd.xj.xj(this.tf);
    }

    public void ai() {
        SSWebView sSWebView;
        if (this.qt || (sSWebView = this.c) == null || sSWebView.getWebView() == null) {
            return;
        }
        this.c.loadUrl(this.tf);
        this.qt = true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.xj
    public String dk() {
        return "endcard";
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.xj
    public void qt() {
        super.qt();
        this.et.clear();
    }

    public boolean x() {
        String str = this.tf;
        if (str == null) {
            return false;
        }
        try {
            return Uri.parse(str).getQueryParameterNames().contains("show_landingpage");
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.xj
    public void xj(boolean z, Map<String, Object> map, View view) {
        if (this.c == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        d dVar = new d(this.w, this.hf, jSONObject);
        this.d = dVar;
        dVar.xj(jSONObject, "webview_source", (Object) 2);
        kd hf = new kd(this.hf, this.c).hf(true);
        this.f10308pl = hf;
        hf.xj(true);
        q();
        this.f10308pl.xj(x() ? "landingpage_endcard" : z ? "reward_endcard" : "fullscreen_endcard");
        j jVar = new j(this.xj);
        this.f = jVar;
        jVar.hf(this.c).xj(this.hf).hf(this.hf.ho()).u(this.hf.jf()).w(z ? 7 : 5).xj(this.ra).kd(wo.zg(this.hf)).xj(this.c).hf(tf.xj(this.hf)).xj(this.d).xj(this.w).xj(map).xj(this.dk).xj(view).w(this.xj.xj()).xj(this.f10305io);
        this.f.xj(this.x);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.xj
    public void xj(DownloadListener downloadListener, com.bytedance.sdk.openadsdk.core.hf.hf hfVar) {
        if (this.c == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.widget.xj.u uVar = new com.bytedance.sdk.openadsdk.core.widget.xj.u(this.xj, this.f, this.hf.ho(), this.f10308pl) { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.hf.3
            @Override // com.bytedance.sdk.openadsdk.core.widget.xj.u, android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                d dVar = hf.this.d;
                if (dVar != null) {
                    dVar.c();
                }
                super.onPageFinished(webView, str);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.xj.u, android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                d dVar = hf.this.d;
                if (dVar != null) {
                    dVar.y();
                }
                super.onPageStarted(webView, str, bitmap);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.xj.u, android.webkit.WebViewClient
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                hf.this.e.set(false);
                hf.this.yo = this.f;
                hf hfVar2 = hf.this;
                hfVar2.g = i;
                hfVar2.am = str;
                if (hfVar2.d != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        if (Build.VERSION.SDK_INT >= 23) {
                            jSONObject.put(PluginConstants.KEY_ERROR_CODE, i);
                            jSONObject.put(br.c, str);
                        }
                        hf.this.d.hf(jSONObject);
                    } catch (JSONException unused) {
                    }
                }
                super.onReceivedError(webView, i, str, str2);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.xj.u, android.webkit.WebViewClient
            @TargetApi(21)
            public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                if (hf.this.d != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(PluginConstants.KEY_ERROR_CODE, webResourceResponse.getStatusCode());
                        jSONObject.put(br.c, webResourceResponse.getReasonPhrase());
                        hf.this.d.hf(jSONObject);
                    } catch (JSONException unused) {
                    }
                }
                if (hf.this.tf.equals(String.valueOf(webResourceRequest.getUrl()))) {
                    if (webResourceRequest.isForMainFrame()) {
                        hf.this.e.set(false);
                        hf.this.yo = this.f;
                    }
                    if (webResourceResponse != null) {
                        hf.this.g = webResourceResponse.getStatusCode();
                        hf.this.am = "onReceivedHttpError";
                    }
                }
                super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.xj.u, android.webkit.WebViewClient
            public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
                WebResourceResponse xj = hf.this.xj(str);
                return xj != null ? xj : super.shouldInterceptRequest(webView, str);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.xj.u, android.webkit.WebViewClient
            public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
                try {
                    String uri = webResourceRequest.getUrl().toString();
                    hf hfVar2 = hf.this;
                    if (hfVar2.hf != null) {
                        WebResourceResponse xj = hfVar2.xj(uri);
                        if (xj != null) {
                            return xj;
                        }
                        if (TextUtils.isEmpty(hf.this.hf.db())) {
                            return super.shouldInterceptRequest(webView, uri);
                        }
                        hf.this.kd++;
                        return super.shouldInterceptRequest(webView, uri);
                    }
                    return super.shouldInterceptRequest(webView, uri);
                } catch (Throwable th) {
                    pl.w("CommonEndCard", "shouldInterceptRequest error1", th);
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
                    hf.this.e.set(false);
                    hf.this.yo = this.f;
                }
                if (hf.this.d != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        if (Build.VERSION.SDK_INT >= 23) {
                            errorCode = webResourceError.getErrorCode();
                            jSONObject.put(PluginConstants.KEY_ERROR_CODE, errorCode);
                            description = webResourceError.getDescription();
                            jSONObject.put(br.c, description);
                        }
                        hf.this.d.hf(jSONObject);
                    } catch (JSONException unused) {
                    }
                }
                hf hfVar2 = hf.this;
                errorCode2 = webResourceError.getErrorCode();
                hfVar2.g = errorCode2;
                hf hfVar3 = hf.this;
                description2 = webResourceError.getDescription();
                hfVar3.am = String.valueOf(description2);
                super.onReceivedError(webView, webResourceRequest, webResourceError);
            }
        };
        this.p = uVar;
        this.c.setWebViewClient(uVar);
        xj(this.c);
        this.c.setBackgroundColor(-1);
        this.c.setDisplayZoomControls(false);
        this.c.setWebChromeClient(new com.bytedance.sdk.openadsdk.core.widget.xj.w(this.f, this.f10308pl) { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.hf.4
            @Override // com.bytedance.sdk.openadsdk.core.widget.xj.w, android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i) {
                super.onProgressChanged(webView, i);
            }
        });
        this.c.setDownloadListener(downloadListener);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.xj
    public void xj(int i) {
        super.xj(i);
        xj(true);
        w(true);
        xj(false, true);
    }

    public void xj(double d, double d2, double d3, double d4, String str) {
        if (this.f == null || this.xj.isFinishing()) {
            return;
        }
        if (!this.zg) {
            this.ai = d;
            this.q = d2;
            this.j = d4;
            this.z = d3;
            this.en = str;
            this.l = true;
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("x", d);
            jSONObject.put("y", d2);
            jSONObject.put(MediaFormat.KEY_WIDTH, d3);
            jSONObject.put(MediaFormat.KEY_HEIGHT, d4);
            jSONObject.put("videoFrameKey", str);
            this.f.xj("endcardTransform", jSONObject);
        } catch (JSONException unused) {
        }
    }

    public void xj(am amVar) {
        double d;
        double d2;
        double d3;
        double d4;
        if (aq.dk(this.hf)) {
            double d5 = this.jk;
            double d6 = this.pz;
            if (amVar == null || !this.xj.aq().c() || (amVar.f() == 0.0d && amVar.d() == 0.0d)) {
                d = d6;
                d2 = 0.0d;
                d3 = d5;
                d4 = 0.0d;
            } else {
                double y = amVar.y();
                double c = amVar.c();
                double f = amVar.f();
                d = amVar.d();
                d2 = c;
                d4 = y;
                d3 = f;
            }
            xj(d4, d2, d3, d, null);
            if (this.xj.aq() instanceof com.bytedance.sdk.openadsdk.core.component.reward.u.kd) {
                return;
            }
            final double d7 = d;
            final double d8 = d3;
            final double d9 = d2;
            final double d10 = d4;
            com.bykv.vk.openvk.component.video.xj.kd.hf.xj(2147483647L, h.xj(this.hf), new hf.InterfaceC0019hf() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.hf.5
                @Override // com.bykv.vk.openvk.component.video.xj.kd.hf.InterfaceC0019hf
                public void xj(Bitmap bitmap) {
                    if (bitmap != null) {
                        String valueOf = String.valueOf(bitmap.hashCode());
                        hf.this.et.put(valueOf, bitmap);
                        hf.this.xj(d10, d9, d8, d7, valueOf);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public WebResourceResponse xj(String str) {
        if (!str.startsWith("csjclientimg://")) {
            return null;
        }
        Bitmap bitmap = this.et.get(str.replace("csjclientimg://", ""));
        if (bitmap == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        return new WebResourceResponse("text/html", "UTF-8", new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
    }
}
