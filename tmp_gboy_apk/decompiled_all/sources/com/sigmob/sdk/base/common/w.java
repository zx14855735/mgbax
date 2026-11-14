package com.sigmob.sdk.base.common;

import ADYaiT.CtFAbx;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Base64;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.common.Constants;
import com.czhj.sdk.common.utils.Dips;
import com.czhj.sdk.logger.SigmobLog;
import com.czhj.volley.toolbox.StringUtil;
import com.sigmob.sdk.base.common.ae;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.IntentActions;
import com.sigmob.sdk.base.models.LoadAdRequest;
import com.sigmob.sdk.base.models.SigMacroCommon;
import com.sigmob.sdk.base.models.rtb.LinkAction;
import com.sigmob.sdk.base.mta.PointEntitySigmob;
import com.sigmob.sdk.base.mta.PointParamKey;
import com.sigmob.windad.WindAdRequest;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class w extends j {
    com.sigmob.sdk.base.views.g f;
    private int g;
    private final BaseAdUnit h;
    private RelativeLayout i;
    private TextView j;
    private ImageView k;
    private String l;

    /* renamed from: com.sigmob.sdk.base.common.w$4, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass4 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f13164a;

        static {
            int[] iArr = new int[ConsoleMessage.MessageLevel.values().length];
            f13164a = iArr;
            try {
                iArr[ConsoleMessage.MessageLevel.ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public w(Activity activity, BaseAdUnit baseAdUnit, Bundle bundle, Bundle bundle2, String str, k kVar) {
        super(activity, str, kVar);
        this.h = baseAdUnit;
        if (baseAdUnit != null) {
            n().requestWindowFeature(8);
        } else {
            a(IntentActions.ACTION_INTERSTITIAL_FAIL);
            k().a();
        }
    }

    private void p() {
        if (this.i == null) {
            RelativeLayout.LayoutParams ASJ6gh2 = J3FDQU.A2egSU.ASJ6gh(-1, -1, 13);
            int dipsToIntPixels = Dips.dipsToIntPixels(20.0f, this.f13143a);
            RelativeLayout.LayoutParams BTvldC2 = com.bykv.vk.component.ttvideo.player.A2egSU.BTvldC(dipsToIntPixels, dipsToIntPixels, 15, 9);
            int i = dipsToIntPixels / 2;
            BTvldC2.setMargins(i, i, 0, 0);
            ImageView imageView = new ImageView(this.f13143a);
            this.k = imageView;
            imageView.setImageBitmap(com.sigmob.sdk.base.views.s.BACK.a());
            this.k.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.k.setClickable(true);
            this.k.setId(ClientMetadata.generateViewId());
            this.k.setOnClickListener(new View.OnClickListener() { // from class: com.sigmob.sdk.base.common.B4ZgIw
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    w.this.a(view);
                }
            });
            RelativeLayout relativeLayout = new RelativeLayout(l());
            this.i = relativeLayout;
            relativeLayout.setLayoutParams(ASJ6gh2);
            this.i.setBackgroundColor(-1);
            this.i.addView(this.k, BTvldC2);
            TextView textView = new TextView(this.f13143a);
            this.j = textView;
            textView.setTextColor(com.sigmob.sdk.base.blurkit.d.f13043a);
            this.j.setTextSize(18.0f);
            this.j.setVisibility(8);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13);
            this.i.addView(this.j, layoutParams);
        }
    }

    private void q() {
        ActionBar.LayoutParams layoutParams = new ActionBar.LayoutParams(-1, -1, 17);
        ActionBar actionBar = n().getActionBar();
        if (actionBar == null) {
            return;
        }
        p();
        actionBar.setCustomView(this.i, layoutParams);
        actionBar.setDisplayOptions(16);
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayShowHomeEnabled(false);
        actionBar.setDisplayShowTitleEnabled(false);
    }

    @Override // com.sigmob.sdk.base.common.j
    public void e() {
        int c = com.sigmob.sdk.base.k.c();
        if (c > 0) {
            n().getTheme().applyStyle(c, true);
        }
        n().getWindow().addFlags(1024);
        q();
        a();
        String macroProcess = this.h.getMacroCommon().macroProcess(this.h.getMaterial().landing_page);
        String landUrl = this.h.getLandUrl();
        if (com.sigmob.sdk.base.utils.o.a((CharSequence) landUrl)) {
            this.f.loadUrl(macroProcess);
        } else {
            this.f.loadUrl(landUrl);
        }
        a(IntentActions.ACTION_LANDPAGE_SHOW);
    }

    @Override // com.sigmob.sdk.base.common.j
    public void f() {
    }

    @Override // com.sigmob.sdk.base.common.j
    public void g() {
        com.sigmob.sdk.base.views.g gVar = this.f;
        if (gVar != null) {
            gVar.resumeTimers();
        }
    }

    @Override // com.sigmob.sdk.base.common.j
    public void h() {
        a(IntentActions.ACTION_LANDPAGE_DISMISS);
        ImageView imageView = this.k;
        if (imageView != null) {
            imageView.setOnClickListener(null);
            this.k = null;
        }
        com.sigmob.sdk.base.views.g gVar = this.f;
        if (gVar != null) {
            gVar.destroy();
            this.f = null;
        }
        super.h();
    }

    @Override // com.sigmob.sdk.base.common.j
    public void i() {
        if (j()) {
            k().a();
        }
    }

    @Override // com.sigmob.sdk.base.common.j
    public boolean j() {
        if (!this.f.canGoBack()) {
            return true;
        }
        this.f.goBack();
        return false;
    }

    @Override // com.sigmob.sdk.base.common.j
    public void o() {
    }

    private void a() {
        if (this.f == null) {
            try {
                com.sigmob.sdk.base.views.g gVar = new com.sigmob.sdk.base.views.g(n());
                this.f = gVar;
                gVar.setScrollBarStyle(0);
                this.f.setAdUnit(this.h);
                this.f.setWebViewClient(new AnonymousClass1());
                this.f.setWebChromeClient(new WebChromeClient() { // from class: com.sigmob.sdk.base.common.w.2
                    @Override // android.webkit.WebChromeClient
                    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                        if (AnonymousClass4.f13164a[consoleMessage.messageLevel().ordinal()] != 1) {
                            return false;
                        }
                        SigmobLog.e("onConsoleMessage " + consoleMessage.message());
                        ae.a("h5_error", "landpage", 0, consoleMessage.message(), (WindAdRequest) null, (LoadAdRequest) null, w.this.h, (ae.a) null);
                        return false;
                    }

                    @Override // android.webkit.WebChromeClient
                    public void onReceivedTitle(WebView webView, String str) {
                        if (str == null || str.isEmpty() || str.startsWith(Constants.HTTP) || str.length() > 10) {
                            if (w.this.j != null) {
                                w.this.j.setVisibility(8);
                            }
                        } else if (w.this.j != null) {
                            w.this.j.setVisibility(0);
                            w.this.j.setText(str);
                        }
                    }
                });
            } catch (Throwable th) {
                SigmobLog.e(th.getMessage());
                this.d.a();
            }
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        LinearLayout linearLayout = new LinearLayout(n());
        linearLayout.addView(this.f, 0, layoutParams);
        this.d.onSetContentView(linearLayout);
        if (!this.h.isDisable_download_listener()) {
            this.f.setDownloadListener(new DownloadListener() { // from class: com.sigmob.sdk.base.common.B3GDIM
                @Override // android.webkit.DownloadListener
                public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                    w.this.a(str, str2, str3, str4, j);
                }
            });
        }
        this.f.setOnTouchListener(new View.OnTouchListener() { // from class: com.sigmob.sdk.base.common.w.3

            /* renamed from: a, reason: collision with root package name */
            MotionEvent f13163a = null;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                SigmobLog.d(motionEvent.toString());
                if (motionEvent.getAction() == 0) {
                    this.f13163a = MotionEvent.obtain(motionEvent);
                    return false;
                }
                if (motionEvent.getAction() != 1) {
                    return false;
                }
                MotionEvent motionEvent2 = this.f13163a;
                if (motionEvent2 == null) {
                    w.this.l = SigMacroCommon.getCoordinate(motionEvent, motionEvent, true);
                    return false;
                }
                w.this.l = SigMacroCommon.getCoordinate(motionEvent2, motionEvent, true);
                return false;
            }
        });
    }

    @Override // com.sigmob.sdk.base.common.j
    public void a(Configuration configuration) {
    }

    @Override // com.sigmob.sdk.base.common.j
    public void a(Bundle bundle) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        k().a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(String str, Object obj) {
        if (obj instanceof PointEntitySigmob) {
            ((PointEntitySigmob) obj).setCoordinate(str);
        }
    }

    /* renamed from: com.sigmob.sdk.base.common.w$1, reason: invalid class name */
    public class AnonymousClass1 extends com.sigmob.sdk.base.l {
        public AnonymousClass1() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void a(String str, Object obj) {
            if (obj instanceof PointEntitySigmob) {
                ((PointEntitySigmob) obj).setUrl(str);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            ae.a("h5_error", "landpage", i, CtFAbx.AlLFFp(str2, " error:", str), (WindAdRequest) null, (LoadAdRequest) null, w.this.h, (ae.a) null);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            ae.a("h5_error", "landpage", webResourceResponse.getStatusCode(), webResourceRequest.getUrl().toString(), (WindAdRequest) null, (LoadAdRequest) null, w.this.h, (ae.a) null);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            Context context;
            Uri parse;
            String scheme;
            String host;
            try {
                context = webView.getContext();
                parse = Uri.parse(str);
                scheme = parse.getScheme();
                host = parse.getHost();
            } catch (Throwable th) {
                SigmobLog.e(th.getMessage());
            }
            if (!StringUtil.scheme().equalsIgnoreCase(scheme) || com.sigmob.sdk.base.utils.o.a((CharSequence) host) || (!"track".equals(host) && !"active".equals(host))) {
                if (com.sigmob.sdk.base.utils.o.a((CharSequence) scheme)) {
                    SigmobLog.i("load Url: " + str);
                } else {
                    LinkAction a2 = com.sigmob.sdk.videoplayer.c.a(w.this.h.getAdLinkActions(), parse);
                    if (a2 == null) {
                        a2 = com.sigmob.sdk.videoplayer.c.a(w.this.h.getSlotAdLinkActions(), parse);
                    }
                    int redirectCount = w.this.h.getRedirectCount(parse);
                    if (a2 != null && a2.redirect_count.intValue() <= redirectCount) {
                        return true;
                    }
                    if (!com.sigmob.sdk.base.utils.o.a(host, "hapjs.org") || (!scheme.equalsIgnoreCase(Constants.HTTP) && !scheme.equalsIgnoreCase("https"))) {
                        w.this.h.addRedirectCount(parse);
                        v.a(context, parse, com.sigmob.sdk.base.utils.o.a(host, "hapjs.org") ? com.sigmob.sdk.b.a() : v.a(context, parse, w.this.h.getMarketPackageNameList()));
                        ae.a(com.sigmob.sdk.base.a.LAND_PAGE, "click", w.this.h, "1", str, w.this.l);
                        return true;
                    }
                }
                webView.loadUrl(str);
                return true;
            }
            String queryParameter = parse.getQueryParameter(PointParamKey.DATA);
            String queryParameter2 = parse.getQueryParameter("event");
            if (!com.sigmob.sdk.base.utils.o.a((CharSequence) queryParameter2) && !com.sigmob.sdk.base.utils.o.a((CharSequence) queryParameter)) {
                ae.a(host, queryParameter2, w.this.h, new AaHO0E(new String(Base64.decode(queryParameter, 0), "utf-8"), 9));
                return true;
            }
            return true;
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            CharSequence description;
            SigmobLog.i("onReceivedError:" + webResourceError.toString());
            if (Build.VERSION.SDK_INT >= 23) {
                StringBuilder sb = new StringBuilder();
                sb.append(webResourceRequest.getUrl());
                sb.append(" error:");
                description = webResourceError.getDescription();
                sb.append((Object) description);
                ae.a("h5_error", "landpage", 0, sb.toString(), (WindAdRequest) null, (LoadAdRequest) null, w.this.h, (ae.a) null);
            }
        }
    }

    private void a(String str, String str2, BaseAdUnit baseAdUnit, String str3) {
        ae.a(str2, str, baseAdUnit, new AaHO0E(str3, 22));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(String str, String str2, String str3, String str4, long j) {
        q.a(str, this.h);
        ae.a(com.sigmob.sdk.base.a.LAND_PAGE, "click", this.h, Constants.FAIL, str, this.l);
        StringBuilder BChYOn2 = J3FDQU.A2egSU.BChYOn("onDownloadStart() called with: url = [", str, "], userAgent = [", str2, "], contentDisposition = [");
        com.bykv.vk.component.ttvideo.player.A2egSU.BIYEnU(BChYOn2, str3, "], mimetype = [", str4, "], contentLength = [");
        BChYOn2.append(j);
        BChYOn2.append("]");
        SigmobLog.d(BChYOn2.toString());
    }
}
