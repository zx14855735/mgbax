package com.sigmob.sdk.mraid;

import ADYaiT.CtFAbx;
import DaOi9o.AYUAbz;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.location.Location;
import android.net.Uri;
import android.os.Build;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.bykv.vk.component.ttvideo.log.LiveError;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.bytedance.pangle.provider.ContentProviderManager;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.common.Constants;
import com.czhj.sdk.common.json.JSONSerializer;
import com.czhj.sdk.common.network.Networking;
import com.czhj.sdk.common.utils.Md5Util;
import com.czhj.sdk.common.utils.TouchLocation;
import com.czhj.sdk.logger.SigmobLog;
import com.czhj.sdk.logger.SigmobLogger;
import com.czhj.volley.toolbox.StringUtil;
import com.sigmob.sdk.base.BaseAdActivity;
import com.sigmob.sdk.base.common.ae;
import com.sigmob.sdk.base.common.aq;
import com.sigmob.sdk.base.models.AppInfo;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.ClickCommon;
import com.sigmob.sdk.base.models.CurrentAppOrientation;
import com.sigmob.sdk.base.models.ExposureChange;
import com.sigmob.sdk.base.models.LoadAdRequest;
import com.sigmob.sdk.base.models.MraidEnv;
import com.sigmob.sdk.base.models.PlacementType;
import com.sigmob.sdk.base.models.VideoItem;
import com.sigmob.sdk.base.models.ViewState;
import com.sigmob.sdk.base.models.rtb.Ad;
import com.sigmob.sdk.base.models.rtb.AdSetting;
import com.sigmob.sdk.base.models.rtb.MaterialMeta;
import com.sigmob.sdk.base.models.rtb.RvAdSetting;
import com.sigmob.sdk.base.models.rtb.SlotAdSetting;
import com.sigmob.sdk.mraid.b;
import com.sigmob.windad.WindAdRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public static final String f13461a = "MraidBridge";
    static final String b = "mraid://open?url=";
    BaseAdUnit c;
    d d;
    v e;
    private final PlacementType f;
    private final m g;
    private String h;
    private aq i;
    private boolean j;
    private final w k;
    private e l;

    /* renamed from: com.sigmob.sdk.mraid.c$3, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass3 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f13463a;

        static {
            int[] iArr = new int[k.values().length];
            f13463a = iArr;
            try {
                iArr[k.CLOSE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f13463a[k.UNLOAD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f13463a[k.OPENFOURELEMENTS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f13463a[k.RESIZE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f13463a[k.EXPAND.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f13463a[k.USE_CUSTOM_CLOSE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f13463a[k.OPEN.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f13463a[k.feedBack.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f13463a[k.SET_ORIENTATION_PROPERTIES.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f13463a[k.PLAY_VIDEO.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f13463a[k.STORE_PICTURE.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f13463a[k.CREATE_CALENDAR_EVENT.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f13463a[k.VPAID.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f13463a[k.EXTENSION.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f13463a[k.UNSPECIFIED.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
        }
    }

    public c(BaseAdUnit baseAdUnit, PlacementType placementType) {
        this(baseAdUnit, placementType, new m());
    }

    private int a(int i, int i2, int i3) {
        if (i < i2 || i > i3) {
            throw new f(CtFAbx.ARc23Z(i, "Integer parameter out of range: "));
        }
        return i;
    }

    private String b(Rect rect) {
        return rect.width() + "," + rect.height();
    }

    private URI c(String str, String str2) {
        try {
            try {
                return str == null ? new URI(str2) : new URI(str);
            } catch (URISyntaxException unused) {
                return new URI(str2);
            }
        } catch (URISyntaxException unused2) {
            throw new f(CtFAbx.BChYOn("Invalid URL parameter: ", str));
        }
    }

    private int f(String str) {
        try {
            return Integer.parseInt(str, 10);
        } catch (NumberFormatException unused) {
            throw new f(CtFAbx.BChYOn("Invalid numeric parameter: ", str));
        }
    }

    private p g(String str) {
        if ("portrait".equals(str)) {
            return p.PORTRAIT;
        }
        if ("landscape".equals(str)) {
            return p.LANDSCAPE;
        }
        if ("none".equals(str)) {
            return p.NONE;
        }
        throw new f(CtFAbx.BChYOn("Invalid orientation: ", str));
    }

    private URI i(String str) {
        if (str == null) {
            throw new f("Parameter cannot be null");
        }
        try {
            return new URI(str);
        } catch (URISyntaxException unused) {
            throw new f("Invalid URL parameter: ".concat(str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        if (this.j) {
            return;
        }
        this.j = true;
        d dVar = this.d;
        if (dVar != null) {
            dVar.a();
        }
    }

    public void d() {
        c("mraidbridge.fireChangeEvent({\"hostSDKVersion\":4.24.7});");
    }

    public void e() {
        c("mraidbridge.notifyReadyEvent();");
    }

    public void h() {
        c("bridge.notifyApkDownloadEndEvent();");
    }

    public void j() {
        c("mraidbridge.startAd();");
    }

    public boolean k() {
        aq aqVar = this.i;
        return aqVar != null && aqVar.c();
    }

    public boolean l() {
        v vVar = this.e;
        return vVar != null && vVar.j();
    }

    public boolean m() {
        return this.e != null;
    }

    public boolean n() {
        return this.j;
    }

    public c(BaseAdUnit baseAdUnit, PlacementType placementType, m mVar) {
        this.k = new w() { // from class: com.sigmob.sdk.mraid.c.1
            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                c.this.o();
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                ae.a("h5_error", "mraid1", i, CtFAbx.AlLFFp(str2, " error:", str), (WindAdRequest) null, (LoadAdRequest) null, c.this.c, (ae.a) null);
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                ae.a("h5_error", "mraid1", webResourceResponse.getStatusCode(), webResourceRequest.getUrl().toString(), (WindAdRequest) null, (LoadAdRequest) null, c.this.c, (ae.a) null);
            }

            @Override // android.webkit.WebViewClient
            public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
                c.this.a(renderProcessGoneDetail);
                return true;
            }

            @Override // com.sigmob.sdk.mraid.w, com.sigmob.sdk.base.l, android.webkit.WebViewClient
            public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
                if (!com.sigmob.sdk.base.utils.o.a((CharSequence) c.this.c.getVideoPath()) && str.endsWith(c.this.c.getVideoPath()) && c.this.c.isVideoExist()) {
                    try {
                        return new WebResourceResponse("video/mp4", "UTF-8", new FileInputStream(c.this.c.getVideoPath()));
                    } catch (FileNotFoundException e) {
                        SigmobLog.e(e.getMessage());
                    }
                }
                return super.shouldInterceptRequest(webView, str);
            }

            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                return c.this.a(webView, str);
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
                    ae.a("h5_error", "mraid1", 0, sb.toString(), (WindAdRequest) null, (LoadAdRequest) null, c.this.c, (ae.a) null);
                }
            }
        };
        this.c = baseAdUnit;
        this.f = placementType;
        this.g = mVar;
    }

    private boolean h(String str) {
        if ("true".equals(str)) {
            return true;
        }
        if ("false".equals(str)) {
            return false;
        }
        throw new f(CtFAbx.BChYOn("Invalid boolean parameter: ", str));
    }

    public void b() {
        this.d = null;
        this.l = null;
        v vVar = this.e;
        if (vVar == null) {
            return;
        }
        vVar.destroy();
        this.e = null;
    }

    public void d(String str) {
        c("mraidbridge.fireVideoSrc(\"" + str + "\")");
    }

    public void e(String str) {
        c("mraidbridge.nativeCallCompleteV2(" + JSONObject.quote(str) + ")");
    }

    public void i() {
        c("bridge.notifyApkDownloadInstalledEvent();");
    }

    public void b(ValueCallback valueCallback) {
        a("mraidbridge.getAdDuration();", valueCallback);
    }

    @SuppressLint({"JavascriptInterface"})
    public void b(String str) {
        v vVar = this.e;
        if (vVar == null) {
            SigmobLog.e("MRAID bridge called setContentHtml while WebView was not attached");
            return;
        }
        vVar.addJavascriptInterface(new a(this), "sigandroid");
        this.j = false;
        this.e.loadUrl(str);
    }

    public void b(String str, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("uniqueId", str);
            jSONObject.put("state", i);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        c("mraidbridge.setvdLoadStateChanged(" + jSONObject + ")");
    }

    public void b(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("uniqueId", str);
            jSONObject.put("error", str2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        c("mraidbridge.setvdPlayError(" + jSONObject + ")");
    }

    private b.a a(String str, b.a aVar) {
        if (com.sigmob.sdk.base.utils.o.a((CharSequence) str)) {
            return aVar;
        }
        str.getClass();
        switch (str) {
            case "center":
                return b.a.CENTER;
            case "top-right":
                return b.a.TOP_RIGHT;
            case "top-left":
                return b.a.TOP_LEFT;
            case "bottom-left":
                return b.a.BOTTOM_LEFT;
            case "bottom-right":
                return b.a.BOTTOM_RIGHT;
            case "bottom-center":
                return b.a.BOTTOM_CENTER;
            case "top-center":
                return b.a.TOP_CENTER;
            default:
                throw new f("Invalid close position: ".concat(str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(boolean z) {
        d dVar = this.d;
        if (dVar == null) {
            return;
        }
        dVar.a(z);
    }

    public void c() {
        c("bridge.fireChangeEvent({\"osType\":2});");
    }

    public void f() {
        c("bridge.notifyApkDownloadStartEvent();");
    }

    public void g() {
        c("bridge.notifyApkDownloadFailEvent();");
    }

    public String a() {
        return this.h;
    }

    public void c(String str) {
        if (this.e == null) {
            SigmobLog.e("Attempted to inject Javascript into MRAID WebView while was not attached:\n\t" + str);
        } else {
            if (str.startsWith("bridge")) {
                str = str.replaceFirst("bridge", StringUtil.decode(StringUtil.s));
            }
            SigmobLog.d("Injecting Javascript into MRAID WebView:\n\t" + str);
            this.e.evaluateJavascript(str, null);
        }
    }

    private String a(Rect rect) {
        return rect.left + "," + rect.top + "," + rect.width() + "," + rect.height();
    }

    public void c(String str, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("uniqueId", str);
            jSONObject.put("state", i);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        c("mraidbridge.setvdPlayStateChanged(" + jSONObject + ")");
    }

    public static String a(String str) {
        if (str == null || str.equalsIgnoreCase("null") || str.equalsIgnoreCase("undefined")) {
            return null;
        }
        return str;
    }

    private URI a(String str, URI uri) {
        return str == null ? uri : i(str);
    }

    public void a(int i) {
        c("bridge.notifyApkDownloadProcessEvent(" + i + ");");
    }

    public void a(int i, int i2, int i3, int i4) {
        c("mraidbridge.setSafeAreaInsets(" + (i + "," + i2 + "," + i3 + "," + i4) + ")");
    }

    @SuppressLint({"JavascriptInterface", "AddJavascriptInterface"})
    public void a(Context context, String str) {
        v vVar = this.e;
        if (vVar == null) {
            SigmobLog.e("MRAID bridge called setContentHtml before WebView was attached");
            return;
        }
        vVar.addJavascriptInterface(new a(this), "sigandroid");
        this.j = false;
        File b2 = com.sigmob.sdk.base.utils.k.b(str, Md5Util.md5(str) + ".html");
        if (b2 != null && !com.sigmob.sdk.base.utils.o.a((CharSequence) b2.getAbsolutePath())) {
            this.e.loadUrl("file://" + b2.getAbsolutePath());
            return;
        }
        this.e.loadDataWithBaseURL(Networking.getBaseUrlScheme() + "://localhost/", str, "text/html", "UTF-8", null);
    }

    public void a(Location location) {
        c("mraidbridge.setLocation(" + location.getLatitude() + "," + location.getLongitude() + ",\"" + location.getProvider() + "\");");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0025  */
    @android.annotation.TargetApi(26)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(android.webkit.RenderProcessGoneDetail r3) {
        /*
            r2 = this;
            if (r3 == 0) goto Lb
            boolean r3 = com.game.boy.activity.ADYaiT.BTvldC(r3)
            if (r3 == 0) goto Lb
            com.sigmob.windad.WindAdError r3 = com.sigmob.windad.WindAdError.RENDER_PROCESS_GONE_WITH_CRASH
            goto Ld
        Lb:
            com.sigmob.windad.WindAdError r3 = com.sigmob.windad.WindAdError.RENDER_PROCESS_GONE_UNSPECIFIED
        Ld:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "handleRenderProcessGone "
            r0.<init>(r1)
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            com.czhj.sdk.logger.SigmobLog.e(r0)
            r2.b()
            com.sigmob.sdk.mraid.d r0 = r2.d
            if (r0 == 0) goto L28
            r0.a(r3)
        L28:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.mraid.c.a(android.webkit.RenderProcessGoneDetail):void");
    }

    public void a(ValueCallback valueCallback) {
        a("mraidbridge.getPlayProgress();", valueCallback);
    }

    public void a(AppInfo appInfo) {
        c("bridge.fireChangeEvent({" + appInfo.toString().replace("=", ":") + "});");
    }

    public void a(CurrentAppOrientation currentAppOrientation) {
        c("mraidbridge.fireChangeEvent({" + currentAppOrientation.toString().replace("=", ":") + "});");
    }

    public void a(ExposureChange exposureChange) {
        c("mraidbridge.fireChangeEvent({" + exposureChange.toString().replace("=", ":") + "});");
    }

    public void a(MraidEnv mraidEnv) {
        c("mraidbridge.fireChangeEvent(" + JSONSerializer.Serialize(mraidEnv, "env", true) + ");");
    }

    public void a(PlacementType placementType) {
        c("mraidbridge.setPlacementType(" + JSONObject.quote(placementType.toJavascriptString()) + ")");
    }

    public void a(VideoItem videoItem) {
        c("bridge.fireChangeEvent(" + JSONSerializer.Serialize(videoItem, "video", false) + ");");
    }

    public void a(ViewState viewState) {
        c("mraidbridge.setState(" + JSONObject.quote(viewState.toJavascriptString()) + ")");
    }

    public void a(Ad ad, SlotAdSetting slotAdSetting) {
        String Serialize = JSONSerializer.Serialize(ad, ClickCommon.CLICK_SCENE_AD, true);
        try {
            String Serialize2 = JSONSerializer.Serialize(slotAdSetting, null, true);
            JSONObject jSONObject = new JSONObject(Serialize);
            jSONObject.getJSONObject(ClickCommon.CLICK_SCENE_AD).put("slotAdSetting", new JSONObject(Serialize2));
            c("bridge.fireChangeEvent(" + jSONObject.toString() + ");");
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public void a(MaterialMeta materialMeta) {
        c("bridge.fireChangeEvent(" + JSONSerializer.Serialize(materialMeta, ClickCommon.CLICK_AREA_MATERIAL, true) + ");");
    }

    public void a(RvAdSetting rvAdSetting) {
        c("bridge.fireChangeEvent(" + JSONSerializer.Serialize(rvAdSetting, "rvSetting", false) + ");");
    }

    public void a(d dVar) {
        this.d = dVar;
    }

    public void a(e eVar) {
        this.l = eVar;
    }

    private void a(k kVar) {
        c("window.mraidbridge.nativeCallComplete(" + JSONObject.quote(kVar.a()) + ")");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(k kVar, f fVar) {
        a(kVar, fVar.getMessage());
    }

    private void a(k kVar, String str) {
        c("window.mraidbridge.notifyErrorEvent(" + JSONObject.quote(kVar.a()) + ", " + JSONObject.quote(str) + ")");
    }

    public void a(k kVar, Map<String, String> map) {
        if (this.d == null) {
            throw new f("Invalid state to execute this command.");
        }
        if (this.e == null) {
            throw new f("The current WebView is being destroyed.");
        }
        switch (AnonymousClass3.f13463a[kVar.ordinal()]) {
            case 1:
                this.d.d();
                return;
            case 2:
                this.d.e();
                return;
            case 3:
                this.d.f();
                return;
            case 4:
                this.d.a(a(f(map.get(MediaFormat.KEY_WIDTH)), 0, 100000), a(f(map.get(MediaFormat.KEY_HEIGHT)), 0, 100000), a(f(map.get("offsetX")), LiveError.PARSE_JSON, 100000), a(f(map.get("offsetY")), LiveError.PARSE_JSON, 100000), a(map.get("customClosePosition"), b.a.TOP_RIGHT), a(map.get("allowOffscreen"), true));
                return;
            case 5:
                this.d.a(a(map.get("url"), (URI) null), a(map.get("shouldUseCustomClose"), false));
                return;
            case 6:
                this.d.b(a(map.get("shouldUseCustomClose"), false));
                return;
            case 7:
                SigmobLogger.d(f13461a, "runCommand: command = " + kVar.a(), new Object[0]);
                this.d.a(c(map.get("url"), ""), 1, a(map.get(com.sigmob.sdk.base.n.m)));
                return;
            case 8:
                this.d.g();
                return;
            case 9:
                this.d.a(h(map.get("allowOrientationChange")), g(map.get("forceOrientation")));
                return;
            case 10:
                this.d.a(i(map.get(ContentProviderManager.PROVIDER_URI)));
                return;
            case 11:
                this.g.a(this.e.getContext(), i(map.get(ContentProviderManager.PROVIDER_URI)).toString(), new AYUAbz(this, 9, kVar));
                return;
            case 12:
                this.g.a(this.e.getContext(), map);
                return;
            case 13:
                this.d.a(map.get("event"), map);
                return;
            case 14:
                this.d.b(map.get("event"), map);
                return;
            case 15:
                throw new f("Unspecified MRAID Javascript command");
            default:
                return;
        }
    }

    public void a(q qVar) {
        c("mraidbridge.setScreenSize(" + b(qVar.c()) + ");mraidbridge.setMaxSize(" + b(qVar.e()) + ");mraidbridge.setCurrentPosition(" + a(qVar.g()) + ");mraidbridge.setDefaultPosition(" + a(qVar.i()) + ")");
        StringBuilder sb = new StringBuilder("mraidbridge.notifySizeChangeEvent(");
        sb.append(b(qVar.g()));
        sb.append(")");
        c(sb.toString());
    }

    public void a(v vVar) {
        this.e = vVar;
        WebSettings settings = vVar.getSettings();
        com.sigmob.sdk.base.utils.h.a(f13461a, settings);
        if (this.f == PlacementType.INTERSTITIAL) {
            settings.setMediaPlaybackRequiresUserGesture(false);
        }
        this.k.b(this.c.isDisablexRequestWith());
        this.k.a(com.sigmob.sdk.base.o.a().ag());
        this.e.setScrollContainer(false);
        this.e.setVerticalScrollBarEnabled(false);
        this.e.setHorizontalScrollBarEnabled(false);
        this.e.setBackgroundColor(0);
        this.e.setAdUnit(this.c);
        this.e.a((com.sigmob.sdk.base.common.b) null);
        this.e.setWebViewClient(this.k);
        this.e.setWebChromeClient(new WebChromeClient() { // from class: com.sigmob.sdk.mraid.c.2
            @Override // android.webkit.WebChromeClient
            public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                d dVar = c.this.d;
                return dVar == null ? super.onConsoleMessage(consoleMessage) : dVar.a(consoleMessage);
            }

            @Override // android.webkit.WebChromeClient
            public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
                d dVar = c.this.d;
                return dVar == null ? super.onJsAlert(webView, str, str2, jsResult) : dVar.a(str2, jsResult);
            }

            @Override // android.webkit.WebChromeClient
            public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
                return super.onJsPrompt(webView, str, str2, str3, jsPromptResult);
            }

            @Override // android.webkit.WebChromeClient
            public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
                super.onShowCustomView(view, customViewCallback);
            }
        });
        this.i = new aq(this.e.getContext(), this.e, this.c);
        this.e.setVisibilityChangedListener(new A5SV6n(3, this));
    }

    public void a(String str, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("uniqueId", str);
            jSONObject.put("currentTime", i / 1000.0f);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        c("mraidbridge.setvdPlayToEnd(" + jSONObject + ")");
    }

    public void a(String str, int i, int i2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("uniqueId", str);
            jSONObject.put("currentTime", i / 1000.0f);
            jSONObject.put(MediationConstant.EXTRA_DURATION, i2 / 1000.0f);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        c("mraidbridge.setvdPlayCurrentTime(" + jSONObject + ")");
    }

    public void a(String str, int i, int i2, int i3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("uniqueId", str);
            jSONObject.put(MediationConstant.EXTRA_DURATION, i / 1000.0f);
            jSONObject.put(MediaFormat.KEY_WIDTH, i2);
            jSONObject.put(MediaFormat.KEY_HEIGHT, i3);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        c("mraidbridge.setvdReadyToPlay(" + jSONObject + ")");
    }

    public void a(String str, ValueCallback valueCallback) {
        if (this.e == null) {
            SigmobLog.e("Attempted to inject Javascript into MRAID WebView while was not attached:\n\t" + str);
        } else {
            if (str.startsWith("bridge")) {
                str = str.replaceFirst("bridge", StringUtil.decode(StringUtil.s));
            }
            SigmobLog.d("Injecting Javascript into MRAID WebView:\n\t" + str);
            this.e.evaluateJavascript(str, valueCallback);
        }
    }

    public void a(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(",");
        sb.append(str2);
        sb.append(",");
        sb.append(str);
        this.h = CtFAbx.B25kr6(sb, ",", str2);
        this.c.getMacroCommon().updateClickMarco(str, str2, str, str2);
        this.c.getClickCommon().down = new TouchLocation(Integer.parseInt(str), Integer.parseInt(str2));
        this.c.getClickCommon().up = new TouchLocation(Integer.parseInt(str), Integer.parseInt(str2));
    }

    public void a(String str, String str2, String str3, HashMap<String, Object> hashMap) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("event", str3);
            jSONObject2.put("uniqueId", str);
            if (hashMap != null) {
                jSONObject2.put("args", new JSONObject(hashMap));
            }
            jSONObject.put("onChangeFired", jSONObject2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        c("mraidbridge.fireChangeEvent(" + jSONObject + ");");
    }

    public void a(String str, String str2, JSONObject jSONObject) {
        if (this.l == null) {
            return;
        }
        str.getClass();
        switch (str) {
            case "motion":
                this.l.d(str2, jSONObject);
                break;
            case "motionView":
                this.l.e(str2, jSONObject);
                break;
            case "addSubview":
                this.l.c(str2, jSONObject);
                break;
            case "vpaid":
                this.l.a(str2, jSONObject);
                break;
            case "belowSubview":
                this.l.b(str2, jSONObject);
                break;
        }
    }

    public void a(String str, HashMap<String, Object> hashMap) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("event", str);
            if (hashMap != null) {
                jSONObject2.put("args", new JSONObject(hashMap));
            }
            jSONObject.put("onChangeEvent", jSONObject2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        c("mraidbridge.fireChangeEvent(" + jSONObject + ");");
    }

    public void a(boolean z) {
        c("mraidbridge.setIsViewable(" + z + ")");
    }

    public void a(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
        c("mraidbridge.setSupports(" + z + "," + z2 + "," + z3 + "," + z4 + "," + z5 + "," + z6 + "," + z7 + ")");
    }

    public boolean a(WebView webView, String str) {
        int i;
        d dVar;
        SigmobLog.d("MraidBridge#handleShouldOverrideUrl: url = " + str);
        try {
            new URI(str);
            Uri parse = Uri.parse(str);
            String scheme = parse.getScheme();
            String host = parse.getHost();
            if (StringUtil.decode(StringUtil.s).equals(scheme)) {
                if ("failLoad".equals(host) && this.f == PlacementType.INLINE && (dVar = this.d) != null) {
                    dVar.c();
                }
                return true;
            }
            if (BaseAdActivity.c.equals(scheme)) {
                SigmobLogger.d(f13461a, "handleShouldOverrideUrl: uri = " + parse, new Object[0]);
                k a2 = k.a(host);
                try {
                    a(a2, ClientMetadata.getQueryParamMap(parse));
                } catch (Throwable th) {
                    a(a2, th.getMessage());
                }
                a(a2);
                return true;
            }
            if (com.sigmob.sdk.base.utils.o.b(str)) {
                if (str.startsWith(Constants.HTTP)) {
                    webView.loadUrl(str);
                } else {
                    try {
                        AdSetting adSetting = this.c.getAdSetting();
                        List<String> list = adSetting == null ? null : adSetting.scheme_white_list;
                        if (com.sigmob.sdk.base.utils.e.a(list)) {
                            return true;
                        }
                        while (i < list.size()) {
                            String str2 = list.get(i);
                            i = (str.startsWith(str2) || str2.equals("*")) ? 0 : i + 1;
                            com.sigmob.sdk.base.common.v.a(this.e.getContext(), Uri.parse(str));
                            return true;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            return true;
        } catch (URISyntaxException unused) {
            SigmobLog.e("Invalid MRAID URL: " + str);
            a(k.UNSPECIFIED, "Mraid command sent an invalid URL");
            return true;
        }
    }

    private boolean a(String str, boolean z) {
        return str == null ? z : h(str);
    }
}
