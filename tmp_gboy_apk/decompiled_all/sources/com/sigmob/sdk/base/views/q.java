package com.sigmob.sdk.base.views;

import ADYaiT.CtFAbx;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Base64;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.ConsoleMessage;
import android.webkit.JavascriptInterface;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.bytedance.android.live.base.api.push.model.PushUIConfig;
import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.common.utils.Dips;
import com.czhj.sdk.common.utils.Md5Util;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.common.ae;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.LoadAdRequest;
import com.sigmob.sdk.base.models.rtb.AdPrivacy;
import com.sigmob.sdk.base.models.rtb.MaterialMeta;
import com.sigmob.windad.WindAdRequest;
import java.io.File;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class q extends Dialog implements DialogInterface.OnDismissListener, DialogInterface.OnShowListener {

    /* renamed from: a, reason: collision with root package name */
    private static final String f13317a = "q";
    private b b;
    private Map<String, String> c;
    private Context d;
    private Window e;
    private g f;
    private final BaseAdUnit g;
    private ImageView h;
    private String i;
    private File j;
    private boolean k;
    private RelativeLayout l;
    private Handler m;
    private Activity n;
    private int o;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private final Map<String, String> f13320a;

        public a(Map<String, String> map) {
            this.f13320a = map;
        }

        @JavascriptInterface
        public String getPrivacyInfo() {
            Map<String, String> map = this.f13320a;
            if (map != null && !map.isEmpty()) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    for (Map.Entry<String, String> entry : this.f13320a.entrySet()) {
                        jSONObject.put(entry.getKey(), entry.getValue());
                    }
                    return jSONObject.toString();
                } catch (Throwable th) {
                    com.sigmob.sdk.base.utils.i.f(q.f13317a, J3FDQU.A2egSU.B4ZgIw(th, new StringBuilder("getPrivacyInfo: error = ")), new Object[0]);
                }
            }
            return null;
        }
    }

    public interface b {
        void a();

        void a(Error error);

        void a(String str, String str2);

        void b();
    }

    public q(Context context, BaseAdUnit baseAdUnit) {
        super(context, com.sigmob.sdk.base.k.f());
        this.e = null;
        this.i = "";
        this.d = context.getApplicationContext();
        this.g = baseAdUnit;
        this.f = b();
        this.h = f();
    }

    private void e() {
        AdPrivacy adPrivacy;
        if (com.sigmob.sdk.base.utils.q.b(this.g)) {
            MaterialMeta material = this.g.getMaterial();
            if (material == null || (adPrivacy = material.ad_privacy) == null) {
                SigmobLog.d("showWebView: ad_privacy is null.");
            } else {
                if (com.sigmob.sdk.base.utils.e.b(adPrivacy.privacy_template_info)) {
                    this.c = adPrivacy.privacy_template_info;
                }
                if (com.sigmob.sdk.base.utils.o.b(adPrivacy.privacy_template_url)) {
                    String md5 = Md5Util.md5(adPrivacy.privacy_template_url);
                    this.j = com.sigmob.sdk.base.utils.k.a(com.sigmob.sdk.base.utils.k.d(com.sigmob.sdk.base.utils.k.b), md5 + ".html");
                }
            }
        }
        boolean z = com.sigmob.sdk.base.utils.q.b(this.j) && this.j.exists();
        if (com.sigmob.sdk.base.utils.o.b(this.i)) {
            this.f.loadUrl(this.i);
            return;
        }
        this.f.addJavascriptInterface(new a(this.c), "sigPrivacy");
        if (z) {
            this.f.loadUrl("file://" + this.j.getAbsolutePath());
            return;
        }
        this.f.loadDataWithBaseURL(null, new String(Base64.decode("PCFET0NUWVBFIGh0bWw+CjxodG1sIGxhbmc9ImVuIj4KPGhlYWQ+CiAgICA8bWV0YSBjaGFyc2V0PSJVVEYtOCI+CiAgICA8bWV0YSBuYW1lPSJ2aWV3cG9ydCIKICAgICAgICAgIGNvbnRlbnQ9IndpZHRoPWRldmljZS13aWR0aCxpbml0aWFsLXNjYWxlPTEsbWF4aW11bS1zY2FsZT0xLHVzZXItc2NhbGFibGU9MCI+CiAgICA8bWV0YSBjb250ZW50PSJ5ZXMiIG5hbWU9ImFwcGxlLW1vYmlsZS13ZWItYXBwLWNhcGFibGUiPgogICAgPG1ldGEgaHR0cC1lcXVpdj0iWC1VQS1Db21wYXRpYmxlIiBjb250ZW50PSJJRT1lZGdlLGNocm9tZT0xIj4KICAgIDxtZXRhIG5hbWU9InJlbmRlcmVyIiBjb250ZW50PSJ3ZWJraXQiPgogICAgPGxpbmsgcmVsPSJpY29uIiBocmVmPSJkYXRhOmltYWdlL2ljbztiYXNlNjQsYVdOdiI+CiAgICA8dGl0bGU+5paw54mINuimgee0oDY2NjI8L3RpdGxlPgogICAgPHN0eWxlPmh0bWwsIGJvZHksICNhcHAgewogICAgICBtYXJnaW46IDA7CiAgICAgIHdpZHRoOiAxMDB2dzsKICAgICAgaGVpZ2h0OiAxMDB2aDsKICAgICAgb3ZlcmZsb3c6IGhpZGRlbjsKICAgICAgYmFja2dyb3VuZDogdHJhbnNwYXJlbnQgIWltcG9ydGFudDsKICAgIH0KICAgICNlcnJvcl9tYXNrIHsKICAgICAgZGlzcGxheTogbm9uZTsKICAgICAgZmxleC1kaXJlY3Rpb246IGNvbHVtbjsKICAgICAgd2lkdGg6IDEwMHZ3OwogICAgICBoZWlnaHQ6IDEwMHZoOwogICAgICBhbGlnbi1pdGVtczogY2VudGVyOwogICAgICBqdXN0aWZ5LWNvbnRlbnQ6IGNlbnRlcjsKICAgICAgYmFja2dyb3VuZDogcmdiYSgwLDAsMCwwLjYpOwogICAgfQogICAgI2Vycm9yX21hc2sgLmNsb3NlIHsKICAgICAgei1pbmRleDogOTk5OTsKICAgICAgd2lkdGg6IDI4cHg7CiAgICAgIGhlaWdodDogMjhweDsKICAgICAgYmFja2dyb3VuZC1jb2xvcjogI2UzMzEyMjsKICAgICAgY29sb3I6ICNmZmY7CiAgICAgIHBhZGRpbmc6IDRweDsKICAgICAgYm9yZGVyLXJhZGl1czogNTAlOwogICAgICB0b3A6IDEwcHg7CiAgICAgIHJpZ2h0OiAxMHB4OwogICAgfQogICAgI2Vycm9yX21hc2sgLmVycm9yIHsKICAgICAgZm9udC1zaXplOiAyMHB4OwogICAgICBjb2xvcjogI2UzMzEyMjsKICAgICAgbWFyZ2luLWJvdHRvbTogMjBweDsKICAgIH0KICAgIDwvc3R5bGU+CiAgICA8ZGl2IGlkPSJlcnJvcl9tYXNrIj48cCBjbGFzcz0iZXJyb3IiPuWFreimgee0oOWKoOi9veWksei0pX48L3A+CiAgICAgICAgPHN2ZyBjbGFzcz0iY2xvc2UiIGlkPSJjbG9zZSIgZmlsbD0iY3VycmVudENvbG9yIiB0PSIxNTk1NDc1OTMzNzE2IiBjbGFzcz0iaWNvbiIKICAgICAgICAgICAgIHZpZXdCb3g9IjAgMCAxMDI0IDEwMjQiIHZlcnNpb249IjEuMSIgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIiBwLWlkPSIyMDExIgogICAgICAgICAgICAgeG1sbnM6eGxpbms9Imh0dHA6Ly93d3cudzMub3JnLzE5OTkveGxpbmsiPgogICAgICAgICAgICA8cGF0aCBkPSJNMTAzLjY4OCA5MzguNTc2YTI4IDI4IDAgMCAxLTE5LjgtNDcuOEw4OTguMTUyIDc2LjUyYTI4IDI4IDAgMSAxIDM5LjYgMzkuNTkyTDEyMy40ODggOTMwLjRhMjcuOTIgMjcuOTIgMCAwIDEtMTkuOCA4LjE3NnoiPjwvcGF0aD4KICAgICAgICAgICAgPHBhdGggZD0iTTkxNy45NTIgOTM4LjU3NmEyNy45MjggMjcuOTI4IDAgMCAxLTE5LjgtOC4yTDgzLjg4OCAxMTYuMTEyYTI4IDI4IDAgMCAxIDM5LjYtMzkuNTkybDgxNC4yNjQgODE0LjI1NmEyOCAyOCAwIDAgMS0xOS44IDQ3Ljh6Ij48L3BhdGg+CiAgICAgICAgPC9zdmc+CiAgICA8L2Rpdj4KICAgIDxzY3JpcHQ+ZnVuY3Rpb24gaWZyYW1lU2VuZFNyYyhzcmMpIHsKICAgICAgdmFyIGlmcmFtZSA9IGRvY3VtZW50LmNyZWF0ZUVsZW1lbnQoJ2lmcmFtZScpCiAgICAgIGlmcmFtZS5zZXRBdHRyaWJ1dGUoJ3NyYycsIHNyYykKICAgICAgZG9jdW1lbnQuZG9jdW1lbnRFbGVtZW50LmFwcGVuZENoaWxkKGlmcmFtZSkKICAgICAgaWZyYW1lLnBhcmVudE5vZGUucmVtb3ZlQ2hpbGQoaWZyYW1lKQogICAgICBpZnJhbWUgPSBudWxsCiAgICB9CgogICAgc2V0VGltZW91dCgoKSA9PiB7CiAgICAgIGlmICghd2luZG93LklOSVQpIHsKICAgICAgICBjb25zdCBlcnJvck1hc2sgPSBkb2N1bWVudC5nZXRFbGVtZW50QnlJZCgnZXJyb3JfbWFzaycpCiAgICAgICAgY29uc3QgY2xvc2VEb20gPSBkb2N1bWVudC5nZXRFbGVtZW50QnlJZCgnY2xvc2UnKQogICAgICAgIGVycm9yTWFzay5zdHlsZS5kaXNwbGF5ID0gJ2ZsZXgnCiAgICAgICAgY2xvc2VEb20ub25jbGljayA9IGZ1bmN0aW9uICgpIHsKICAgICAgICAgIGlmcmFtZVNlbmRTcmMoJ3NpZ21vYkFkOi8vY2xvc2VGb3VyRWxlbWVudHMnKQogICAgICAgIH0KICAgICAgfQogICAgfSwgMzAwMCkKICAgIDwvc2NyaXB0PgogICAgPGxpbmsgaHJlZj0iaHR0cHM6Ly9uLnNpZ21vYi5jbi9tcmFpZC9wcm9kLzY2NjIvNjY2Mi5hMzM2ZDVlMS5qcyIgcmVsPSJwcmVsb2FkIiBhcz0ic2NyaXB0Ij4KICAgIDxsaW5rIGhyZWY9Imh0dHBzOi8vbi5zaWdtb2IuY24vbXJhaWQvcHJvZC82NjYyLzY2NjIuYzc1MDZhMDcuY3NzIiByZWw9InByZWxvYWQiIGFzPSJzdHlsZSI+CiAgICA8bGluayBocmVmPSJodHRwczovL24uc2lnbW9iLmNuL21yYWlkL3Byb2QvNjY2Mi82NjYyLmM3NTA2YTA3LmNzcyIgcmVsPSJzdHlsZXNoZWV0Ij4KICAgIDxzY3JpcHQ+CiAgICAgICAgdmFyIHNpZ21vYj13aW5kb3cuc2lnbW9iPXt9LHByaXZhY3lJbmZvPXt9LGlmcmFtZVNlbmRTcmM9ZnVuY3Rpb24oaSl7dmFyIG89ZG9jdW1lbnQuY3JlYXRlRWxlbWVudCgiaWZyYW1lIik7by5zZXRBdHRyaWJ1dGUoInNyYyIsaSksZG9jdW1lbnQuZG9jdW1lbnRFbGVtZW50LmFwcGVuZENoaWxkKG8pLG8ucGFyZW50Tm9kZS5yZW1vdmVDaGlsZChvKX0saW5pdFByaXZhY3lJbmZvPShzaWdtb2IuZ2V0UHJpdmFjeUluZm89ZnVuY3Rpb24oKXtyZXR1cm4gcHJpdmFjeUluZm99LHNpZ21vYi5jbG9zZUZvdXJFbGVtZW50cz1mdW5jdGlvbigpe2lmcmFtZVNlbmRTcmMoInNpZ21vYkFkOi8vY2xvc2VGb3VyRWxlbWVudHMiKX0sc2lnbW9iLnVzZUN1c3RvbUNsb3NlPWZ1bmN0aW9uKCl7aWZyYW1lU2VuZFNyYygic2lnbW9iQWQ6Ly91c2VDdXN0b21DbG9zZSIpfSxzaWdtb2IuYnV0dG9uQ2xpY2s9ZnVuY3Rpb24oaSxvLG4pe2lmcmFtZVNlbmRTcmMobj8ic2lnbW9iQWQ6Ly9idXR0b25DbGljaz91cmw9IituKyImeD0iK2krIiZ5PSIrbzoic2lnbW9iQWQ6Ly9idXR0b25DbGljaz94PSIraSsiJnk9IitvKX0sZnVuY3Rpb24oKXt3aW5kb3cuc2lnUHJpdmFjeT9wcml2YWN5SW5mbz13aW5kb3cuc2lnUHJpdmFjeS5nZXRQcml2YWN5SW5mbygpOmNvbnNvbGUuZXJyb3IoInNpZ1ByaXZhY3nms6jlhozlpLHotKU9PT0iKX0pO2luaXRQcml2YWN5SW5mbygpOwogICAgPC9zY3JpcHQ+CjwvaGVhZD4KPGJvZHk+CjxkaXYgaWQ9ImFwcCI+PC9kaXY+CjxzY3JpcHQgc3JjPSJodHRwczovL24uc2lnbW9iLmNuL21yYWlkL3Byb2QvNjY2Mi82NjYyLmEzMzZkNWUxLmpzIj48L3NjcmlwdD4KPC9ib2R5Pgo8L2h0bWw+", 0)), "text/html", "utf-8", null);
        com.sigmob.sdk.base.common.ae.a("h5_error", "download_dialog", 0, " error: htmlUrl: " + this.i + " htmlFile " + this.j + " exists " + z, (WindAdRequest) null, (LoadAdRequest) null, this.g, (ae.a) null);
    }

    private ImageView f() {
        ImageView imageView = new ImageView(this.d);
        this.h = imageView;
        imageView.setImageBitmap(s.CLOSE.a());
        this.h.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.h.setImageAlpha(127);
        this.h.setClickable(true);
        this.h.setOnClickListener(new A2egSU(this, 1));
        return this.h;
    }

    private void g() {
        if (this.h == null) {
            return;
        }
        int dipsToIntPixels = Dips.dipsToIntPixels(18.0f, this.d);
        RelativeLayout.LayoutParams BTvldC2 = com.bykv.vk.component.ttvideo.player.A2egSU.BTvldC(dipsToIntPixels, dipsToIntPixels, 10, 11);
        int i = dipsToIntPixels / 2;
        BTvldC2.setMargins(0, i, i, 0);
        this.l.addView(this.h, BTvldC2);
    }

    private void h() {
        Window window = getWindow();
        this.e = window;
        if (window == null) {
            return;
        }
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = -1;
        this.e.setAttributes(attributes);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i() {
        if (this.k) {
            return;
        }
        g();
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        this.l = relativeLayout;
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        Window window = getWindow();
        this.e = window;
        com.sigmob.sdk.videoplayer.c.a(window);
        this.l.setBackgroundColor(0);
        setContentView(this.l);
        setOnShowListener(this);
        setOnDismissListener(this);
        if (this.f != null) {
            this.l.addView(this.f, new RelativeLayout.LayoutParams(-1, -1));
        }
        Handler handler = new Handler(Looper.getMainLooper());
        this.m = handler;
        handler.postDelayed(new A4TApA(4, this), PushUIConfig.dismissTime);
        setCanceledOnTouchOutside(true);
        setCancelable(true);
        h();
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        com.sigmob.sdk.base.utils.i.b(f13317a, "onDismiss", new Object[0]);
        Activity activity = this.n;
        if (activity != null) {
            activity.setRequestedOrientation(this.o);
            this.n = null;
        }
        b bVar = this.b;
        if (bVar != null) {
            bVar.a();
        }
    }

    @Override // android.content.DialogInterface.OnShowListener
    public void onShow(DialogInterface dialogInterface) {
        com.sigmob.sdk.base.utils.i.b(3, f13317a, "onShow", this.g, null);
        b bVar = this.b;
        if (bVar != null) {
            bVar.b();
        }
    }

    @Override // android.app.Dialog
    public void show() {
        Activity activity;
        super.show();
        Activity i = com.sigmob.sdk.b.i();
        this.n = i;
        if (com.sigmob.sdk.base.utils.q.b(i)) {
            this.n = com.sigmob.sdk.b.c();
        }
        if (com.sigmob.sdk.base.utils.q.b(this.n)) {
            this.o = this.n.getRequestedOrientation();
            Integer orientationInt = ClientMetadata.getInstance().getOrientationInt();
            if (com.sigmob.sdk.base.utils.q.b(orientationInt)) {
                int i2 = 1;
                if (orientationInt.intValue() == 1) {
                    activity = this.n;
                } else {
                    activity = this.n;
                    i2 = 0;
                }
                activity.setRequestedOrientation(i2);
            }
        }
        e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        b bVar = this.b;
        if (bVar == null) {
            return;
        }
        bVar.a();
    }

    public g b() {
        g gVar = new g(this.d);
        this.f = gVar;
        gVar.a(true);
        this.f.setAdUnit(this.g);
        this.f.a((com.sigmob.sdk.base.common.b) null);
        this.f.setBackgroundColor(0);
        this.f.setWebChromeClient(new WebChromeClient() { // from class: com.sigmob.sdk.base.views.q.1
            @Override // android.webkit.WebChromeClient
            public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                ConsoleMessage.MessageLevel messageLevel = consoleMessage.messageLevel();
                if (messageLevel != null && messageLevel == ConsoleMessage.MessageLevel.ERROR) {
                    SigmobLog.e(q.f13317a + "onConsoleMessage: msg = " + consoleMessage.message());
                    com.sigmob.sdk.base.common.ae.a("h5_error", "download_dialog", 0, consoleMessage.message(), (WindAdRequest) null, (LoadAdRequest) null, q.this.g, (ae.a) null);
                }
                return false;
            }
        });
        this.f.setWebViewClient(new WebViewClient() { // from class: com.sigmob.sdk.base.views.q.2
            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
            }

            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                com.sigmob.sdk.base.common.ae.a("h5_error", "download_dialog", 0, CtFAbx.AlLFFp(str2, " error:", str), (WindAdRequest) null, (LoadAdRequest) null, q.this.g, (ae.a) null);
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                com.sigmob.sdk.base.common.ae.a("h5_error", "download_dialog", 0, webResourceRequest.getUrl() + " error:" + webResourceResponse.getStatusCode(), (WindAdRequest) null, (LoadAdRequest) null, q.this.g, (ae.a) null);
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                com.sigmob.sdk.base.utils.i.f(q.f13317a, "onReceivedSslError: error = " + sslError.toString(), new Object[0]);
                super.onReceivedSslError(webView, sslErrorHandler, sslError);
            }

            @Override // android.webkit.WebViewClient
            public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
                try {
                    return com.sigmob.sdk.base.l.a(webResourceRequest.getUrl());
                } catch (Throwable unused) {
                    return super.shouldInterceptRequest(webView, webResourceRequest);
                }
            }

            /* JADX WARN: Removed duplicated region for block: B:16:0x0074  */
            /* JADX WARN: Removed duplicated region for block: B:34:0x0133 A[Catch: all -> 0x005a, TRY_LEAVE, TryCatch #0 {all -> 0x005a, blocks: (B:3:0x0004, B:5:0x0031, B:7:0x003b, B:21:0x007a, B:25:0x0097, B:28:0x00a6, B:30:0x0117, B:31:0x0121, B:33:0x0129, B:34:0x0133, B:35:0x0050, B:38:0x005d, B:41:0x0067), top: B:2:0x0004 }] */
            @Override // android.webkit.WebViewClient
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public boolean shouldOverrideUrlLoading(android.webkit.WebView r11, java.lang.String r12) {
                /*
                    Method dump skipped, instructions count: 361
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.base.views.q.AnonymousClass2.shouldOverrideUrlLoading(android.webkit.WebView, java.lang.String):boolean");
            }

            @Override // android.webkit.WebViewClient
            public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
                try {
                    return com.sigmob.sdk.base.l.a(Uri.parse(str));
                } catch (Throwable unused) {
                    return super.shouldInterceptRequest(webView, str);
                }
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                com.sigmob.sdk.base.utils.i.f(q.f13317a, "onReceivedError: error = " + webResourceError.toString(), new Object[0]);
                if (Build.VERSION.SDK_INT >= 23) {
                    com.sigmob.sdk.base.common.ae.a("h5_error", "download_dialog", 0, webResourceRequest.getUrl() + " error:" + ((Object) webResourceError.getDescription()), (WindAdRequest) null, (LoadAdRequest) null, q.this.g, (ae.a) null);
                }
                super.onReceivedError(webView, webResourceRequest, webResourceError);
            }
        });
        return this.f;
    }

    public void c() {
        g gVar = this.f;
        if (gVar != null) {
            gVar.destroy();
            this.f = null;
        }
        Handler handler = this.m;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.m = null;
        }
        ImageView imageView = this.h;
        if (imageView != null) {
            com.sigmob.sdk.base.utils.r.a(imageView);
            this.h = null;
        }
        if (this.d != null) {
            this.d = null;
        }
        if (this.b != null) {
            this.b = null;
        }
    }

    public void a(b bVar) {
        this.b = bVar;
    }

    public boolean a() {
        return true;
    }
}
