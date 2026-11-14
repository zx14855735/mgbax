package com.sigmob.sdk.videoAd;

import ADYaiT.BChYOn;
import BTvldC.B25kr6;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.webkit.DownloadListener;
import android.webkit.JavascriptInterface;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.bytedance.android.live.base.api.push.model.PushUIConfig;
import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.common.Constants;
import com.czhj.sdk.common.ThreadPool.ThreadPoolFactory;
import com.czhj.sdk.common.utils.Dips;
import com.czhj.sdk.common.utils.Preconditions;
import com.czhj.sdk.common.utils.ResourceUtil;
import com.czhj.sdk.common.utils.ViewUtil;
import com.czhj.sdk.logger.SigmobLog;
import com.czhj.volley.toolbox.ImageLoader;
import com.czhj.volley.toolbox.StringUtil;
import com.sigmob.sdk.base.common.ac;
import com.sigmob.sdk.base.common.ae;
import com.sigmob.sdk.base.common.am;
import com.sigmob.sdk.base.common.h;
import com.sigmob.sdk.base.common.n;
import com.sigmob.sdk.base.common.u;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.ClickCommon;
import com.sigmob.sdk.base.models.IntentActions;
import com.sigmob.sdk.base.models.SensorEntity;
import com.sigmob.sdk.base.models.SigMacroCommon;
import com.sigmob.sdk.base.models.rtb.ClickAreaSetting;
import com.sigmob.sdk.base.models.rtb.LinkAction;
import com.sigmob.sdk.base.models.rtb.MaterialMeta;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.base.mta.PointEntitySigmob;
import com.sigmob.sdk.base.mta.PointParamKey;
import com.sigmob.sdk.base.views.ap;
import com.sigmob.sdk.base.views.ar;
import com.sigmob.sdk.base.views.as;
import com.sigmob.sdk.base.views.aw;
import com.sigmob.sdk.base.views.d;
import com.sigmob.sdk.base.views.o;
import com.sigmob.sdk.base.views.q;
import com.sigmob.sdk.base.views.s;
import com.sigmob.sdk.base.views.v;
import com.sigmob.sdk.base.views.w;
import com.sigmob.sdk.base.views.z;
import com.sigmob.sdk.videoAd.f;
import com.sigmob.windad.natives.WindNativeAdData;
import com.ss.android.download.api.constant.BaseConstants;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class j extends b implements ac, h.a, com.sigmob.sdk.videocache.d {
    public static final String f = "j";
    static final String g = "video_config";
    private static final String i = "current_position";
    private static final String j = "video_finished";
    private static final String k = "companionAd_visable";
    private static final long l = 50;
    private static final int m = -1;
    private static final int n = 0;
    private static int o;
    private String A;
    private boolean B;
    private final Handler C;
    private boolean D;
    private com.sigmob.sdk.base.views.d E;
    private String F;
    private int G;
    private boolean H;
    private com.sigmob.sdk.videoAd.a I;
    private int J;
    private com.sigmob.sdk.videoplayer.a K;
    private BaseAdUnit L;
    private View M;
    private u N;
    private final MediaMetadataRetriever O;
    private as P;
    private ar Q;
    private w R;
    private f S;
    private int T;
    private int U;
    private boolean V;
    private boolean W;
    private int X;
    private boolean Y;
    private RelativeLayout Z;
    private boolean aa;
    private ar ab;
    private boolean ac;
    private boolean ad;
    private ImageLoader.ImageContainer ae;
    private com.sigmob.sdk.base.views.m af;
    private boolean ag;
    private boolean ah;
    private z ai;
    private boolean aj;
    private q ak;
    private boolean al;
    private w am;
    private w an;
    private am.a ao;
    private v ap;
    private boolean aq;
    private com.sigmob.sdk.nativead.b ar;
    private w as;
    private boolean at;
    private boolean au;
    private boolean av;
    private boolean aw;
    private String ax;
    private final View.OnClickListener ay;
    private boolean az;
    String h;
    private final int p;
    private com.sigmob.sdk.base.views.b q;
    private ImageView r;
    private RelativeLayout s;
    private int t;
    private boolean u;
    private int v;
    private String w;
    private final List<String> x;
    private final List<String> y;
    private long z;

    /* renamed from: com.sigmob.sdk.videoAd.j$10, reason: invalid class name */
    public class AnonymousClass10 implements am.b {
        public AnonymousClass10() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b() {
            j.this.J();
        }

        @Override // com.sigmob.sdk.base.common.am.b
        public void a() {
        }

        @Override // com.sigmob.sdk.base.common.am.b
        public void a(float f) {
        }

        @Override // com.sigmob.sdk.base.common.am.b
        public void a(Map<String, Number> map) {
            if (map == null || j.this.L == null || j.this.aq) {
                return;
            }
            j.this.aq = true;
            j.this.L.getClickCommon().sld = "2";
            Number number = map.get("x_max_acc");
            Number number2 = map.get("y_max_acc");
            Number number3 = map.get("z_max_acc");
            if (number != null) {
                j.this.L.getClickCommon().x_max_acc = String.valueOf(number.intValue());
            }
            if (number2 != null) {
                j.this.L.getClickCommon().y_max_acc = String.valueOf(number2.intValue());
            }
            if (number3 != null) {
                j.this.L.getClickCommon().z_max_acc = String.valueOf(number3.intValue());
            }
            j.this.ap.postDelayed(new ARc23Z(this, 0), 400L);
        }
    }

    /* renamed from: com.sigmob.sdk.videoAd.j$11, reason: invalid class name */
    public class AnonymousClass11 implements am.b {
        public AnonymousClass11() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b() {
            j.this.J();
        }

        @Override // com.sigmob.sdk.base.common.am.b
        public void a() {
        }

        @Override // com.sigmob.sdk.base.common.am.b
        public void a(float f) {
        }

        @Override // com.sigmob.sdk.base.common.am.b
        public void a(Map<String, Number> map) {
            if (map == null || j.this.L == null || j.this.aq) {
                return;
            }
            j.this.aq = true;
            Number number = map.get("turn_x");
            Number number2 = map.get("turn_y");
            Number number3 = map.get("turn_z");
            Number number4 = map.get("turn_time");
            if (number != null) {
                j.this.L.getClickCommon().turn_x = String.valueOf(number.intValue());
            }
            if (number2 != null) {
                j.this.L.getClickCommon().turn_y = String.valueOf(number2.intValue());
            }
            if (number3 != null) {
                j.this.L.getClickCommon().turn_z = String.valueOf(number3.intValue());
            }
            j.this.L.getClickCommon().turn_time = String.valueOf(number4);
            j.this.L.getClickCommon().sld = "5";
            j.this.ap.postDelayed(new ARc23Z(this, 1), 400L);
        }
    }

    /* renamed from: com.sigmob.sdk.videoAd.j$12, reason: invalid class name */
    public class AnonymousClass12 implements am.b {
        public AnonymousClass12() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b() {
            j.this.J();
        }

        @Override // com.sigmob.sdk.base.common.am.b
        public void a() {
        }

        @Override // com.sigmob.sdk.base.common.am.b
        public void a(float f) {
            if (j.this.ap instanceof ap) {
                ((ap) j.this.ap).a(f);
            }
        }

        @Override // com.sigmob.sdk.base.common.am.b
        public void a(Map<String, Number> map) {
            if (map == null || j.this.L == null || j.this.aq) {
                return;
            }
            j.this.aq = true;
            Number number = map.get("x_max_acc");
            Number number2 = map.get("y_max_acc");
            Number number3 = map.get("z_max_acc");
            if (number != null) {
                j.this.L.getClickCommon().x_max_acc = String.valueOf(number.intValue());
            }
            if (number2 != null) {
                j.this.L.getClickCommon().y_max_acc = String.valueOf(number2.intValue());
            }
            if (number3 != null) {
                j.this.L.getClickCommon().z_max_acc = String.valueOf(number3.intValue());
            }
            j.this.L.getClickCommon().sld = "2";
            j.this.ap.postDelayed(new ARc23Z(this, 2), 400L);
        }
    }

    /* renamed from: com.sigmob.sdk.videoAd.j$13, reason: invalid class name */
    public class AnonymousClass13 implements am.b {
        public AnonymousClass13() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b() {
            j.this.J();
        }

        @Override // com.sigmob.sdk.base.common.am.b
        public void a() {
        }

        @Override // com.sigmob.sdk.base.common.am.b
        public void a(float f) {
            if (j.this.ap instanceof com.sigmob.sdk.base.views.am) {
                ((com.sigmob.sdk.base.views.am) j.this.ap).a(f);
            }
        }

        @Override // com.sigmob.sdk.base.common.am.b
        public void a(Map<String, Number> map) {
            if (map == null || j.this.L == null || j.this.aq) {
                return;
            }
            j.this.aq = true;
            Number number = map.get("turn_x");
            Number number2 = map.get("turn_y");
            Number number3 = map.get("turn_z");
            Number number4 = map.get("turn_time");
            if (number != null) {
                j.this.L.getClickCommon().turn_x = String.valueOf(number.intValue());
            }
            if (number2 != null) {
                j.this.L.getClickCommon().turn_y = String.valueOf(number2.intValue());
            }
            if (number3 != null) {
                j.this.L.getClickCommon().turn_z = String.valueOf(number3.intValue());
            }
            j.this.L.getClickCommon().turn_time = String.valueOf(number4);
            j.this.L.getClickCommon().sld = "5";
            j.this.ap.postDelayed(new ARc23Z(this, 3), 400L);
        }
    }

    /* renamed from: com.sigmob.sdk.videoAd.j$6, reason: invalid class name */
    public class AnonymousClass6 extends com.sigmob.sdk.base.l {
        public AnonymousClass6() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void a(String str, Object obj) {
            if (obj instanceof PointEntitySigmob) {
                ((PointEntitySigmob) obj).setUrl(str);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            SigmobLog.d("onPageFinished: ");
            j.this.w = "done";
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            SigmobLog.d("onPageStarted: ");
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            if (str2.startsWith("http://")) {
                return;
            }
            j.this.w = "error";
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            Uri parse;
            String host;
            String scheme;
            try {
                SigmobLog.d("load url " + str);
                parse = Uri.parse(str);
                host = parse.getHost();
                scheme = parse.getScheme();
            } catch (Throwable unused) {
                SigmobLog.e("webview");
            }
            if (!TextUtils.isEmpty(host)) {
                if (!"track".equals(host) && !"active".equals(host)) {
                    if ("openFourElements".equals(host)) {
                        j.this.b(2);
                        return true;
                    }
                }
                String queryParameter = parse.getQueryParameter(PointParamKey.DATA);
                String queryParameter2 = parse.getQueryParameter("event");
                if (!TextUtils.isEmpty(queryParameter2) && !TextUtils.isEmpty(queryParameter)) {
                    ae.a(host, queryParameter2, j.this.L, new ASJ6gh(new String(Base64.decode(queryParameter, 0), "utf-8"), 0));
                    return true;
                }
                return true;
            }
            if (!j.this.aa) {
                if (!j.this.L.getMaterial().disable_auto_deeplink.booleanValue() || j.this.B) {
                    if (j.this.L.getMaterial().click_type.intValue() != com.sigmob.sdk.base.common.m.Button.a() && !TextUtils.isEmpty(j.this.L.getLanding_page()) && j.this.L.getMaterial().creative_type.intValue() != n.CreativeTypeVideo_EndCardURL.a()) {
                        if (j.this.L.getMaterial().click_type.intValue() == com.sigmob.sdk.base.common.m.FullScreen.a()) {
                            TextUtils.isEmpty(j.this.L.getLanding_page());
                            return true;
                        }
                    }
                    j.this.L.getClickCommon().click_area = ClickCommon.CLICK_AREA_BTN;
                    j.this.L.getClickCommon().click_scene = "endcard";
                    if (j.this.Q.getVisibility() != 0 || TextUtils.isEmpty(scheme)) {
                        if (!TextUtils.isEmpty(scheme) && (scheme.equals(Constants.HTTP) || scheme.equals("https"))) {
                            if (j.this.ah) {
                                j.this.W();
                                j.this.ah = false;
                            }
                            webView.loadUrl(str);
                        }
                    } else if (!StringUtil.scheme().equalsIgnoreCase(scheme) || TextUtils.isEmpty(host) || !host.equalsIgnoreCase("download") || TextUtils.isEmpty(j.this.L.getMaterial().landing_page)) {
                        try {
                            LinkAction a2 = com.sigmob.sdk.videoplayer.c.a(j.this.L.getAdLinkActions(), parse);
                            if (a2 == null) {
                                a2 = com.sigmob.sdk.videoplayer.c.a(j.this.L.getSlotAdLinkActions(), parse);
                            }
                            int redirectCount = j.this.L.getRedirectCount(parse);
                            if (a2 == null || a2.redirect_count.intValue() > redirectCount) {
                                if (!scheme.equalsIgnoreCase(Constants.HTTP) && !scheme.equalsIgnoreCase("https")) {
                                    j.this.L.addRedirectCount(parse);
                                    j.this.L.setCustomDeeplink(str);
                                    j.this.I.a(com.sigmob.sdk.base.a.ENDCARD, j.this.h, true);
                                    return true;
                                }
                                webView.loadUrl(str);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else {
                        j.this.I.a(com.sigmob.sdk.base.a.ENDCARD, j.this.h, true);
                    }
                } else if (!TextUtils.isEmpty(scheme) && scheme.startsWith(Constants.HTTP)) {
                    return false;
                }
            }
            return true;
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            super.onReceivedError(webView, webResourceRequest, webResourceError);
            String host = webResourceRequest.getUrl().getHost();
            if (TextUtils.isEmpty(host) || !host.equals("localhost")) {
                return;
            }
            j.this.w = "error";
        }
    }

    /* renamed from: com.sigmob.sdk.videoAd.j$7, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass7 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f13713a;
        static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[com.sigmob.sdk.base.a.values().length];
            b = iArr;
            try {
                iArr[com.sigmob.sdk.base.a.COMPANION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[com.sigmob.sdk.base.a.VIDEO_CLICK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                b[com.sigmob.sdk.base.a.MOTION.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[com.sigmob.sdk.videoplayer.d.values().length];
            f13713a = iArr2;
            try {
                iArr2[com.sigmob.sdk.videoplayer.d.STATE_PREPARED.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f13713a[com.sigmob.sdk.videoplayer.d.STATE_PLAYING.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f13713a[com.sigmob.sdk.videoplayer.d.STATE_AUTO_COMPLETE.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f13713a[com.sigmob.sdk.videoplayer.d.STATE_STOP.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f13713a[com.sigmob.sdk.videoplayer.d.STATE_BUFFERING_START.ordinal()] = 5;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f13713a[com.sigmob.sdk.videoplayer.d.STATE_BUFFERING_END.ordinal()] = 6;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f13713a[com.sigmob.sdk.videoplayer.d.STATE_PAUSE.ordinal()] = 7;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f13713a[com.sigmob.sdk.videoplayer.d.STATE_ERROR.ordinal()] = 8;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    public static class a {
        @JavascriptInterface
        public int getInteractionType() {
            return j.o;
        }

        @JavascriptInterface
        public String getSdkVersion() {
            return com.sigmob.sdk.base.n.k;
        }
    }

    public j(Activity activity, BaseAdUnit baseAdUnit, Bundle bundle, Bundle bundle2, String str, com.sigmob.sdk.base.common.k kVar) {
        super(activity, str, kVar);
        this.t = 0;
        this.u = false;
        this.v = 0;
        this.w = "undone";
        this.x = new ArrayList();
        this.y = new ArrayList();
        this.A = "none";
        this.C = new Handler(Looper.getMainLooper());
        this.D = true;
        this.L = null;
        this.O = new MediaMetadataRetriever();
        this.T = 0;
        this.Y = false;
        this.aa = false;
        this.ac = false;
        this.ad = false;
        this.ag = false;
        this.aj = false;
        this.al = false;
        this.ay = new View.OnClickListener() { // from class: com.sigmob.sdk.videoAd.j.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Activity n2 = j.this.n();
                if (n2 == null || j.this.L == null) {
                    return;
                }
                j jVar = j.this;
                if (jVar.a((Dialog) jVar.ar)) {
                    return;
                }
                j.this.ar = new com.sigmob.sdk.nativead.b(n2, j.this.L);
                j.this.ar.a();
                j.this.ar.a(new WindNativeAdData.DislikeInteractionCallback() { // from class: com.sigmob.sdk.videoAd.j.9.1
                    @Override // com.sigmob.windad.natives.WindNativeAdData.DislikeInteractionCallback
                    public void onCancel() {
                        j.this.N();
                        j.this.G();
                        if (j.this.ao == null) {
                            return;
                        }
                        j.this.ao.a();
                    }

                    @Override // com.sigmob.windad.natives.WindNativeAdData.DislikeInteractionCallback
                    public void onSelected(int i2, String str2, boolean z) {
                        j.this.N();
                        j.this.G();
                        if (j.this.ao == null) {
                            return;
                        }
                        j.this.ao.a();
                    }

                    @Override // com.sigmob.windad.natives.WindNativeAdData.DislikeInteractionCallback
                    public void onShow() {
                        j.this.O();
                        if (j.this.ao == null) {
                            return;
                        }
                        j.this.ao.b();
                    }
                });
            }
        };
        this.L = baseAdUnit;
        this.I = (com.sigmob.sdk.videoAd.a) baseAdUnit.getAdConfig();
        this.p = Dips.dipsToIntPixels(10.0f, this.f13143a);
        this.I.a(n(), this.L, new q.b() { // from class: com.sigmob.sdk.videoAd.j.1
            @Override // com.sigmob.sdk.base.views.q.b
            public void a() {
                j.this.al = false;
                j.this.aq = false;
                j.this.N();
                if (j.this.ao != null) {
                    j.this.ao.a();
                }
            }

            @Override // com.sigmob.sdk.base.views.q.b
            public void b() {
                j.this.al = true;
                j.this.aq = true;
                j.this.O();
                if (j.this.ao != null) {
                    j.this.ao.b();
                }
            }

            @Override // com.sigmob.sdk.base.views.q.b
            public void a(Error error) {
            }

            @Override // com.sigmob.sdk.base.views.q.b
            public void a(String str2, String str3) {
                j.this.L.getClickCommon().click_area = ClickCommon.CLICK_AREA_BTN;
                j.this.L.getClickCommon().click_scene = "appinfo";
                j.this.L.getClickCommon().is_final_click = true;
            }
        });
        this.I.a((ac) this);
        this.F = this.L.getAdslot_id();
        o = this.L.getInteractionType();
        b(activity, this.J, bundle);
        this.L.getMacroCommon().addMarcoKey(SigMacroCommon._PLAYLASTFRAME_, "1");
        this.D = this.L.getMaterial().creative_type.intValue() != n.CreativeTypeVideo_transparent_html.a();
        if (bundle2 != null) {
            this.U = bundle2.getInt(i, -1);
            this.V = bundle2.getBoolean(j, false);
            this.Y = bundle2.getBoolean(k, false);
        }
        if (this.e == null) {
            int b = com.sigmob.sdk.base.k.b();
            if (b != 0) {
                n().setTheme(b);
            }
            m().setBackgroundColor(com.sigmob.sdk.base.blurkit.d.f13043a);
        } else {
            m().setBackgroundColor(0);
        }
        RelativeLayout relativeLayout = new RelativeLayout(this.f13143a);
        this.s = relativeLayout;
        relativeLayout.setBackgroundColor(com.sigmob.sdk.base.blurkit.d.f13043a);
        this.K = d(this.f13143a, 0);
        this.s.addView(this.K, J3FDQU.A2egSU.ASJ6gh(-1, -2, 13));
        m().addView(this.s, new RelativeLayout.LayoutParams(-1, -1));
        if (this.u) {
            a(this.f13143a);
            E();
        }
        q();
        this.s.setClickable(true);
        this.s.setOnTouchListener(new View.OnTouchListener() { // from class: com.sigmob.sdk.videoAd.j.8

            /* renamed from: a, reason: collision with root package name */
            MotionEvent f13714a = null;

            /* JADX WARN: Code restructure failed: missing block: B:16:0x0039, code lost:
            
                if (r5.getAction() == 0) goto L16;
             */
            /* JADX WARN: Code restructure failed: missing block: B:17:0x003b, code lost:
            
                r3.f13714a = android.view.MotionEvent.obtain(r5);
             */
            /* JADX WARN: Code restructure failed: missing block: B:32:0x009e, code lost:
            
                if (r5.getAction() == 0) goto L16;
             */
            @Override // android.view.View.OnTouchListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public boolean onTouch(android.view.View r4, android.view.MotionEvent r5) {
                /*
                    r3 = this;
                    com.sigmob.sdk.videoAd.j r4 = com.sigmob.sdk.videoAd.j.this
                    com.sigmob.sdk.base.models.BaseAdUnit r4 = com.sigmob.sdk.videoAd.j.c(r4)
                    boolean r4 = r4.getFullClickOnVideo()
                    r0 = 1
                    if (r4 == 0) goto L42
                    com.sigmob.sdk.videoAd.j r4 = com.sigmob.sdk.videoAd.j.this
                    com.sigmob.sdk.base.views.d r4 = com.sigmob.sdk.videoAd.j.e(r4)
                    if (r4 == 0) goto L21
                    com.sigmob.sdk.videoAd.j r4 = com.sigmob.sdk.videoAd.j.this
                    com.sigmob.sdk.base.views.d r4 = com.sigmob.sdk.videoAd.j.e(r4)
                    int r4 = r4.getVisibility()
                    if (r4 == 0) goto La1
                L21:
                    int r4 = r5.getAction()
                    if (r4 != r0) goto L35
                    android.view.MotionEvent r4 = r3.f13714a
                    if (r4 != 0) goto L2d
                    r3.f13714a = r5
                L2d:
                    com.sigmob.sdk.videoAd.j r4 = com.sigmob.sdk.videoAd.j.this
                    android.view.MotionEvent r1 = r3.f13714a
                    com.sigmob.sdk.videoAd.j.a(r4, r1, r5)
                    goto La1
                L35:
                    int r4 = r5.getAction()
                    if (r4 != 0) goto La1
                L3b:
                    android.view.MotionEvent r4 = android.view.MotionEvent.obtain(r5)
                    r3.f13714a = r4
                    goto La1
                L42:
                    int r4 = r5.getAction()
                    if (r4 != r0) goto L9a
                    com.sigmob.sdk.videoAd.j r4 = com.sigmob.sdk.videoAd.j.this
                    com.sigmob.sdk.base.models.BaseAdUnit r4 = com.sigmob.sdk.videoAd.j.c(r4)
                    com.sigmob.sdk.base.models.rtb.MaterialMeta r4 = r4.getMaterial()
                    java.lang.Boolean r4 = r4.enable_collapse_tool_bar
                    boolean r4 = r4.booleanValue()
                    r1 = 0
                    if (r4 == 0) goto L8f
                    com.sigmob.sdk.videoAd.j r4 = com.sigmob.sdk.videoAd.j.this
                    com.sigmob.sdk.base.views.m r4 = com.sigmob.sdk.videoAd.j.f(r4)
                    if (r4 == 0) goto L8f
                    com.sigmob.sdk.videoAd.j r4 = com.sigmob.sdk.videoAd.j.this
                    com.sigmob.sdk.base.views.m r4 = com.sigmob.sdk.videoAd.j.f(r4)
                    boolean r4 = r4.a()
                    if (r4 == 0) goto L8f
                    com.sigmob.sdk.videoAd.j r4 = com.sigmob.sdk.videoAd.j.this
                    com.sigmob.sdk.base.views.m r4 = com.sigmob.sdk.videoAd.j.f(r4)
                    boolean r4 = r4.b()
                    if (r4 == 0) goto L85
                    com.sigmob.sdk.videoAd.j r4 = com.sigmob.sdk.videoAd.j.this
                    com.sigmob.sdk.base.views.m r4 = com.sigmob.sdk.videoAd.j.f(r4)
                    r4.setVisibility(r1)
                    goto L8f
                L85:
                    com.sigmob.sdk.videoAd.j r4 = com.sigmob.sdk.videoAd.j.this
                    com.sigmob.sdk.base.views.m r4 = com.sigmob.sdk.videoAd.j.f(r4)
                    r2 = 4
                    r4.setVisibility(r2)
                L8f:
                    com.sigmob.sdk.videoAd.j r4 = com.sigmob.sdk.videoAd.j.this
                    com.sigmob.sdk.base.models.BaseAdUnit r4 = com.sigmob.sdk.videoAd.j.c(r4)
                    java.lang.String r2 = "useless_video_click"
                    com.sigmob.sdk.base.common.ae.a(r4, r5, r2, r1)
                L9a:
                    int r4 = r5.getAction()
                    if (r4 != 0) goto La1
                    goto L3b
                La1:
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.videoAd.j.AnonymousClass8.onTouch(android.view.View, android.view.MotionEvent):boolean");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F() {
        RelativeLayout relativeLayout = this.Z;
        if (relativeLayout != null && relativeLayout.getVisibility() == 0) {
            this.x.add(String.format(Locale.getDefault(), "%d", Long.valueOf(System.currentTimeMillis() - this.z)));
            this.y.add(String.format(Locale.getDefault(), "%.2f", Float.valueOf(((int) this.K.getCurrentPositionWhenPlaying()) / 1000.0f)));
            this.A = PointCategory.PLAY;
            this.C.removeCallbacksAndMessages(null);
            this.Z.setVisibility(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G() {
        com.sigmob.sdk.nativead.b bVar = this.ar;
        if (bVar == null) {
            return;
        }
        bVar.dismiss();
        this.ar.b();
        this.ar = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J() {
        this.aq = true;
        this.L.getClickCommon().click_area = ClickCommon.CLICK_AREA_COMPONENT;
        this.L.getClickCommon().click_scene = ClickCommon.CLICK_SCENE_AD;
        this.L.getClickCommon().is_final_click = true;
        this.I.a(com.sigmob.sdk.base.a.MOTION, (String) null, true);
    }

    private void L() {
        Context l2 = l();
        this.ap = new ap(l2);
        int dipsToIntPixels = Dips.dipsToIntPixels(100.0f, l2);
        RelativeLayout.LayoutParams BTvldC2 = com.bykv.vk.component.ttvideo.player.A2egSU.BTvldC(dipsToIntPixels, dipsToIntPixels, 14, 12);
        BTvldC2.setMargins(0, 0, 0, Dips.dipsToIntPixels(145.0f, l2));
        am.a aVar = new am.a(l2, new AnonymousClass12(), am.c.SWING);
        this.ao = aVar;
        aVar.a(SensorEntity.format(this.L));
        this.ao.a();
        m().addView(this.ap, BTvldC2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float P() {
        if (y() <= 0) {
            return 0.0f;
        }
        return ((int) this.K.getCurrentPositionWhenPlaying()) / y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R() {
        if (this.as == null || this.L.getAd_type() == 4) {
            return;
        }
        int B = B();
        if (B <= 0) {
            this.as.setText("已获得奖励");
            return;
        }
        this.as.setText(B + "s 后获取奖励");
    }

    private void S() {
        ae.a(PointCategory.PLAY_LOADING, (String) null, this.L, new A2egSU(this));
    }

    private void U() {
        z zVar = this.ai;
        if (zVar == null) {
            return;
        }
        zVar.dismiss();
        this.ai.c();
        this.ai = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V() {
        ImageView imageView;
        w wVar = this.as;
        if (wVar != null) {
            ViewUtil.removeFromParent(wVar);
        }
        w wVar2 = this.an;
        if (wVar2 != null) {
            ViewUtil.removeFromParent(wVar2);
        }
        v vVar = this.ap;
        if (vVar != null) {
            ViewUtil.removeFromParent(vVar);
        }
        z();
        am.a aVar = this.ao;
        if (aVar != null) {
            aVar.c();
            this.ao = null;
        }
        if (!this.D && (imageView = this.r) != null) {
            ViewParent parent = imageView.getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                ((ViewGroup) parent).removeView(this.r);
            }
            m().addView(this.r, 0);
        }
        com.sigmob.sdk.base.common.h.g().b(this);
        h(l(), 0);
        com.sigmob.sdk.base.views.b bVar = this.q;
        if (bVar != null) {
            bVar.setVisibility(8);
        }
        S();
        F();
        if (this.M == null) {
            SigmobLog.e("endcard can't show " + this.L.getEndCardIndexPath());
            HashMap hashMap = new HashMap();
            hashMap.put("error", "endcard can't show");
            a(IntentActions.ACTION_REWARDED_VIDEO_PLAYFAIL, hashMap);
            this.d.a();
        }
        View view = this.M;
        if (view != null) {
            view.setVisibility(0);
            this.M.bringToFront();
        }
        RelativeLayout relativeLayout = this.s;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(4);
            a(IntentActions.ACTION_REWARDED_VIDEO_CLOSE);
        }
        w wVar3 = this.R;
        if (wVar3 != null) {
            ViewUtil.removeFromParent(wVar3);
        }
        ar arVar = this.ab;
        if (arVar != null) {
            ViewUtil.removeFromParent(arVar);
        }
        if (this.ag) {
            ViewUtil.removeFromParent(this.P);
        }
        com.sigmob.sdk.base.views.m mVar = this.af;
        if (mVar != null) {
            ViewUtil.removeFromParent(mVar);
        }
        this.Y = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W() {
        com.sigmob.sdk.base.utils.c.a(f, this.L);
        this.C.post(new A4TApA(this, 2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void X() {
        a(IntentActions.ACTION_INTERSTITIAL_CLICK);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Y() {
        a(IntentActions.ACTION_REWARDED_VIDEO_COMPLETE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Z() {
        U();
        this.aa = true;
        this.I.b(l(), y(), this.L);
        k().a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void aa() {
        if (new File(this.L.getVideoPath()).exists()) {
            this.O.setDataSource(this.L.getVideoPath());
        } else {
            this.O.setDataSource(this.L.getVideo_url(), new HashMap());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ab() {
        this.C.removeCallbacksAndMessages(null);
        a((int) this.K.getCurrentPositionWhenPlaying(), true);
    }

    private ImageView b(Context context) {
        ImageView imageView = new ImageView(context);
        imageView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        return imageView;
    }

    private com.sigmob.sdk.videoplayer.a d(Context context, int i2) {
        if (this.L.getProxyVideoUrl() == null) {
            throw new IllegalStateException("BaseVideoConfig does not have a video disk path");
        }
        final com.sigmob.sdk.videoplayer.a aVar = new com.sigmob.sdk.videoplayer.a(context);
        aVar.setVideoPlayerStatusListener(new com.sigmob.sdk.videoplayer.k() { // from class: com.sigmob.sdk.videoAd.j.14
            @Override // com.sigmob.sdk.videoplayer.k
            public void a(long j2, long j3) {
                int y = j.this.y();
                j.this.R();
                if (j.this.C()) {
                    j.this.b(false);
                }
                if (j.this.u()) {
                    j.this.c(false);
                }
                int B = j.this.B();
                if (j.this.E != null) {
                    j.this.E.setDuration(B);
                }
                if (j.this.ag) {
                    j.this.P.a((int) j.this.K.getCurrentPositionWhenPlaying());
                }
                long j4 = y;
                if (1000 + j2 < j4) {
                    if (j.this.t()) {
                        j.this.A();
                    } else if (!j.this.au) {
                        j.this.R.setText(String.valueOf((int) ((j4 - j.this.K.getCurrentPositionWhenPlaying()) / 1000.0f)));
                    }
                }
                if (j.this.v()) {
                    j.this.w();
                }
                for (d dVar : j.this.I.a(j2, j4)) {
                    j.this.b(dVar.getEvent());
                    dVar.setTracked();
                }
                if (j2 > j4) {
                    j.this.a(true, false);
                }
            }

            @Override // com.sigmob.sdk.videoplayer.k
            public void a(com.sigmob.sdk.videoplayer.d dVar) {
                SigmobLog.i("video player state change " + dVar);
                int i3 = AnonymousClass7.f13713a[dVar.ordinal()];
                if (i3 != 1) {
                    if (i3 == 3) {
                        j.this.A = "none";
                        j.this.a(true, false);
                        return;
                    }
                    if (i3 == 8) {
                        ae.a("video", aVar.getErrorCode(), aVar.getErrorMessage(), j.this.L);
                        j.this.a(false, true);
                        return;
                    } else if (i3 == 5) {
                        j.this.E();
                        aVar.j();
                        return;
                    } else {
                        if (i3 != 6) {
                            return;
                        }
                        j.this.F();
                        aVar.d();
                        return;
                    }
                }
                j.this.X = (int) aVar.getDuration();
                if (j.this.X == 0) {
                    j jVar = j.this;
                    jVar.X = jVar.L.getDuration();
                }
                if (!j.this.au) {
                    j.this.R.setText(String.valueOf((int) (j.this.y() / 1000.0f)));
                    j.this.R.setVisibility(0);
                }
                j jVar2 = j.this;
                jVar2.b(jVar2.l(), 0);
                aVar.getVideoWidth();
                aVar.getVideoHeight();
                if (j.this.S != null) {
                    j.this.S.a(j.this.y());
                }
                if (j.this.ac) {
                    j.this.ab.a(ResourceUtil.getDrawableId(j.this.l(), "sig_image_video_mute"));
                    j.this.K.setMute(true);
                }
                j.this.r().a(j.this.X, j.this.I.l());
                if (!j.this.V && (j.this.U == 0 || j.this.U == -1)) {
                    SigMacroCommon macroCommon = j.this.L.getMacroCommon();
                    macroCommon.addMarcoKey(SigMacroCommon._COMPLETED_, Constants.FAIL);
                    macroCommon.addMarcoKey(SigMacroCommon._VIDEOTIME_, String.valueOf(j.this.y() / 1000));
                }
                if (j.this.ag) {
                    j.this.P.a(j.this.y(), 0);
                }
            }
        });
        try {
            if (!this.D) {
                ThreadPoolFactory.getFixIOExecutor().submit(new A4TApA(this, 4));
                this.r = b(context);
            }
        } catch (Throwable th) {
            SigmobLog.e(th.getMessage());
        }
        String proxyVideoUrl = this.L.getProxyVideoUrl();
        aVar.setUp(proxyVideoUrl);
        c(proxyVideoUrl);
        aVar.setVisibility(i2);
        return aVar;
    }

    private void j(Context context, int i2) {
        ar arVar = new ar(context);
        this.ab = arVar;
        arVar.setId(ClientMetadata.generateViewId());
        this.ab.setVisibility(i2);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(Dips.dipsToIntPixels(22.0f, context), Dips.dipsToIntPixels(22.0f, context));
        layoutParams.addRule(4, this.an.getId());
        layoutParams.addRule(11);
        int i3 = this.p;
        layoutParams.setMargins(i3, i3 * 2, i3, 0);
        m().addView(this.ab, layoutParams);
        this.ab.setOnTouchListener(new View.OnTouchListener() { // from class: com.sigmob.sdk.videoAd.j.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    if (j.this.ac) {
                        j.this.r().a(com.sigmob.sdk.base.common.a.A, (int) j.this.K.getCurrentPositionWhenPlaying());
                        j.this.ab.a(ResourceUtil.getDrawableId(j.this.l(), "sig_image_video_unmute"));
                        j.this.K.setMute(false);
                    } else {
                        j.this.r().a(com.sigmob.sdk.base.common.a.z, (int) j.this.K.getCurrentPositionWhenPlaying());
                        j.this.ab.a(ResourceUtil.getDrawableId(j.this.l(), "sig_image_video_mute"));
                        j.this.K.setMute(true);
                    }
                    j.this.ac = !r3.ac;
                }
                return true;
            }
        });
        if (this.L.getIsMute() == 0) {
            this.ab.a(ResourceUtil.getDrawableId(l(), "sig_image_video_unmute"));
        } else {
            this.ab.a(ResourceUtil.getDrawableId(l(), "sig_image_video_mute"));
            this.K.setMute(true);
            this.ac = true;
        }
    }

    public static int p() {
        return 0;
    }

    public void A() {
        if (this.L.getMaterial().disable_auto_deeplink.booleanValue()) {
            z();
        }
        a((int) this.K.getCurrentPositionWhenPlaying(), false);
        int B = B();
        com.sigmob.sdk.base.views.d dVar = this.E;
        if (dVar != null) {
            dVar.setDuration(B);
        }
    }

    public int B() {
        try {
            int rewardSeconds = this.L.getRewardSeconds();
            if (rewardSeconds > -1) {
                if (y() > 0 && rewardSeconds * 1000 > y()) {
                    rewardSeconds = (int) (y() / 1000.0f);
                }
                return (int) (rewardSeconds - (this.K.getCurrentPositionWhenPlaying() / 1000.0f));
            }
            if (y() <= 0) {
                return -1;
            }
            return (int) (((this.L.getRewardPercent() * 0.01d) * (y() / 1000.0f)) - (this.K.getCurrentPositionWhenPlaying() / 1000.0f));
        } catch (Throwable unused) {
            return -1;
        }
    }

    @Override // com.sigmob.sdk.base.common.j
    public void i() {
    }

    @Override // com.sigmob.sdk.base.common.ac
    public void onAdClick(boolean z, com.sigmob.sdk.base.a aVar) {
        u r;
        int currentPositionWhenPlaying;
        String str;
        this.az = true;
        W();
        if (z) {
            ClickCommon clickCommon = this.L.getClickCommon();
            int i2 = AnonymousClass7.b[aVar.ordinal()];
            if (i2 == 1) {
                ae.a(com.sigmob.sdk.base.a.COMPANION, "click", this.L, clickCommon.isDeeplink, clickCommon.clickUrl, clickCommon.clickCoordinate, y());
                r = r();
                currentPositionWhenPlaying = (int) this.K.getCurrentPositionWhenPlaying();
                str = com.sigmob.sdk.base.common.a.s;
            } else if (i2 == 2) {
                ae.a(com.sigmob.sdk.base.a.VIDEO_CLICK, "click", this.L, clickCommon.isDeeplink, clickCommon.clickUrl, clickCommon.clickCoordinate, y());
                r = r();
                currentPositionWhenPlaying = (int) this.K.getCurrentPositionWhenPlaying();
                str = com.sigmob.sdk.base.common.a.t;
            } else if (i2 != 3) {
                ae.a(com.sigmob.sdk.base.a.ENDCARD, "click", this.L, clickCommon.isDeeplink, clickCommon.clickUrl, clickCommon.clickCoordinate, y());
                r = r();
                currentPositionWhenPlaying = (int) this.K.getCurrentPositionWhenPlaying();
                str = "click";
            } else {
                r = r();
                currentPositionWhenPlaying = (int) this.K.getCurrentPositionWhenPlaying();
                str = com.sigmob.sdk.base.common.a.i;
            }
            r.a(str, currentPositionWhenPlaying);
        }
    }

    public u r() {
        if (this.N == null) {
            u uVar = new u();
            this.N = uVar;
            uVar.a(a());
        }
        return this.N;
    }

    public void w() {
        com.sigmob.sdk.base.views.m mVar;
        if (this.H || (mVar = this.af) == null) {
            return;
        }
        mVar.setVisibility(0);
        this.H = true;
    }

    public int y() {
        com.sigmob.sdk.videoplayer.a aVar = this.K;
        if (aVar == null) {
            return 0;
        }
        int i2 = this.X;
        return i2 > 0 ? this.I.b(i2) : this.I.b((int) aVar.getDuration());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E() {
        RelativeLayout relativeLayout = this.Z;
        if (relativeLayout == null || relativeLayout.getVisibility() == 0) {
            return;
        }
        this.z = System.currentTimeMillis();
        this.Z.setVisibility(0);
        this.A = "loading";
        int i2 = this.v + 1;
        this.v = i2;
        if (i2 > 2) {
            a((int) this.K.getCurrentPositionWhenPlaying(), true);
        } else {
            this.C.postDelayed(new A4TApA(this, 1), PushUIConfig.dismissTime);
        }
    }

    private void H() {
        switch ((int) this.L.getWidgetId(0)) {
            case 138731:
                L();
                break;
            case 138733:
                M();
                break;
            case 138757:
                I();
                break;
            case 138758:
                K();
                break;
        }
        v vVar = this.ap;
        if (vVar == null) {
            return;
        }
        vVar.a();
    }

    private void I() {
        Context l2 = l();
        this.ap = new com.sigmob.sdk.base.views.ac(l2);
        int dipsToIntPixels = Dips.dipsToIntPixels(100.0f, l2);
        int dipsToIntPixels2 = Dips.dipsToIntPixels(145.0f, l2);
        RelativeLayout.LayoutParams BTvldC2 = com.bykv.vk.component.ttvideo.player.A2egSU.BTvldC(dipsToIntPixels, dipsToIntPixels, 14, 12);
        BTvldC2.setMargins(0, 0, 0, dipsToIntPixels2);
        am.a aVar = new am.a(l2, new AnonymousClass10(), am.c.SHAKE);
        this.ao = aVar;
        aVar.a(SensorEntity.format(this.L));
        this.ao.a();
        m().addView(this.ap, BTvldC2);
    }

    private void K() {
        Context l2 = l();
        this.ap = new aw(l2);
        int dipsToIntPixels = Dips.dipsToIntPixels(100.0f, l2);
        RelativeLayout.LayoutParams BTvldC2 = com.bykv.vk.component.ttvideo.player.A2egSU.BTvldC(dipsToIntPixels, dipsToIntPixels, 14, 12);
        BTvldC2.setMargins(0, 0, 0, Dips.dipsToIntPixels(145.0f, l2));
        am.a aVar = new am.a(l2, new AnonymousClass11(), am.c.WRING);
        this.ao = aVar;
        aVar.a(SensorEntity.format(this.L));
        this.ao.a();
        m().addView(this.ap, BTvldC2);
    }

    private void M() {
        Context l2 = l();
        this.ap = new com.sigmob.sdk.base.views.am(l2);
        int dipsToIntPixels = Dips.dipsToIntPixels(92.0f, l2);
        RelativeLayout.LayoutParams BTvldC2 = com.bykv.vk.component.ttvideo.player.A2egSU.BTvldC(dipsToIntPixels, dipsToIntPixels, 14, 12);
        BTvldC2.setMargins(0, 0, 0, Dips.dipsToIntPixels(145.0f, l2));
        am.a aVar = new am.a(l2, new AnonymousClass13(), am.c.SLOPE);
        this.ao = aVar;
        aVar.a(SensorEntity.format(this.L));
        this.ao.a();
        m().addView(this.ap, BTvldC2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N() {
        if (this.V) {
            return;
        }
        try {
            int currentPositionWhenPlaying = (int) this.K.getCurrentPositionWhenPlaying();
            if (this.U > 0 && currentPositionWhenPlaying == 0) {
                SigmobLog.d("video seek to " + this.U);
                this.K.a(this.U);
            }
            com.sigmob.sdk.base.views.d dVar = this.E;
            if ((dVar == null || dVar.getVisibility() != 0) && !this.al) {
                this.K.d();
            }
            if (this.U != -1) {
                this.I.a(l(), this.U);
            }
        } catch (Throwable th) {
            SigmobLog.e(th.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O() {
        if (this.V) {
            return;
        }
        try {
            this.K.j();
            SigmobLog.i("videoView.pause()");
            this.U = (int) this.K.getCurrentPositionWhenPlaying();
            r().a(com.sigmob.sdk.base.common.a.j, (int) this.K.getCurrentPositionWhenPlaying());
            this.I.b(l(), this.U);
        } catch (Throwable th) {
            SigmobLog.e(th.getMessage());
        }
    }

    private void Q() {
        try {
            this.T = this.I.e(y());
        } catch (Throwable th) {
            SigmobLog.e(th.getMessage());
        }
    }

    private void T() {
        int i2;
        int o2 = this.I.o();
        int y = y() - 2;
        if (o2 == 99999999) {
            i2 = 0;
        } else if (o2 == -99999999) {
            a(y);
            return;
        } else {
            if (o2 > 0) {
                a(o2);
                return;
            }
            i2 = o2 + y;
        }
        a(i2);
    }

    private View a(Context context, f fVar, int i2) {
        Preconditions.NoThrow.checkNotNull(context);
        if (fVar == null) {
            View view = new View(context);
            view.setVisibility(4);
            return view;
        }
        RelativeLayout relativeLayout = new RelativeLayout(context);
        relativeLayout.setGravity(17);
        m().addView(relativeLayout, 0, new RelativeLayout.LayoutParams(-1, -1));
        o a2 = a(context, fVar);
        a2.setVisibility(i2);
        relativeLayout.addView(a2, new LinearLayout.LayoutParams(-1, -1));
        return a2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(int i2) {
        Bitmap frameAtTime = this.O.getFrameAtTime(i2 * 1000, 2);
        if (frameAtTime == null) {
            return;
        }
        this.C.post(new BChYOn(this, 29, frameAtTime));
    }

    private void i(Context context, int i2) {
        w wVar = new w(context);
        this.R = wVar;
        wVar.setId(ClientMetadata.generateViewId());
        this.R.setVisibility(i2);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(Dips.dipsToIntPixels(22.0f, context), Dips.dipsToIntPixels(22.0f, context));
        layoutParams.addRule(10);
        ar arVar = this.ab;
        if (arVar != null) {
            layoutParams.addRule(0, arVar.getId());
            layoutParams.setMargins(0, this.p * 2, 0, 0);
        }
        m().addView(this.R, layoutParams);
        this.R.setEnabled(false);
        this.R.setOnClickListener(new A5SV6n(this, 0));
        if ((this.L.getSkipPercent() != 0 || this.L.getSkipSeconds() >= 0) && this.L.getSkipSeconds() != 0) {
            return;
        }
        a(0, false);
    }

    public boolean C() {
        return B() <= 0;
    }

    @Override // com.sigmob.sdk.videoAd.b, com.sigmob.sdk.base.common.j
    public void e() {
        super.e();
        n().getWindow().addFlags(1024);
        MaterialMeta material = this.L.getMaterial();
        this.t = ClientMetadata.getInstance().getInsetBottom();
        if (this.Y) {
            V();
        } else {
            if (this.I == null) {
                throw new IllegalStateException("BaseVideoConfig does not have a video disk path");
            }
            if (this.ag) {
                e(l(), 4);
            }
            Boolean bool = material.has_companion_endcard;
            if (bool != null && bool.booleanValue() && material.companion != null) {
                g(l(), 4);
                this.G = material.companion.show_delay_secs.intValue();
            }
            a(l(), 0);
            j(l(), 0);
            i(l(), 4);
            ArrayList arrayList = new ArrayList();
            arrayList.add(new d("start", 0.0f));
            arrayList.add(new d(com.sigmob.sdk.base.common.a.k, 0.25f));
            arrayList.add(new d(com.sigmob.sdk.base.common.a.m, 0.5f));
            arrayList.add(new d(com.sigmob.sdk.base.common.a.n, 0.75f));
            this.I.a((List<d>) arrayList);
            a(IntentActions.ACTION_INTERSTITIAL_VOPEN);
        }
        f(l(), 4);
        H();
    }

    @Override // com.sigmob.sdk.base.common.j
    public void f() {
        if (this.aa) {
            a(IntentActions.ACTION_INTERSTITIAL_DISMISS);
            return;
        }
        am.a aVar = this.ao;
        if (aVar != null) {
            aVar.b();
            v vVar = this.ap;
            if (vVar != null) {
                vVar.b();
            }
        }
        if (this.Y) {
            return;
        }
        O();
    }

    @Override // com.sigmob.sdk.base.common.j
    public void g() {
        am.a aVar;
        if (!this.Y && this.ar == null) {
            N();
        }
        View view = this.M;
        if (view != null && (view instanceof o)) {
            ((o) view).resumeTimers();
        }
        this.aq = false;
        if (this.ar != null || (aVar = this.ao) == null) {
            return;
        }
        aVar.a();
        v vVar = this.ap;
        if (vVar != null) {
            vVar.a();
        }
    }

    @Override // com.sigmob.sdk.base.common.j
    public void h() {
        try {
            SigmobLog.d("VideoViewController onDestroy() called");
            com.sigmob.sdk.base.common.h.g().b(this);
            if (!this.aa) {
                a(IntentActions.ACTION_INTERSTITIAL_DISMISS);
            }
            if (this.ax != null) {
                com.sigmob.sdk.base.common.h.d().b(this, this.ax);
            }
            w wVar = this.an;
            if (wVar != null) {
                wVar.setOnClickListener(null);
                ViewUtil.removeFromParent(this.an);
            }
            w wVar2 = this.am;
            if (wVar2 != null) {
                wVar2.setOnClickListener(null);
                ViewUtil.removeFromParent(this.am);
            }
            com.sigmob.sdk.nativead.b bVar = this.ar;
            if (bVar != null) {
                bVar.a((WindNativeAdData.DislikeInteractionCallback) null);
                this.ar.dismiss();
                this.ar.b();
            }
            this.I.k();
            ImageLoader.ImageContainer imageContainer = this.ae;
            if (imageContainer != null) {
                imageContainer.cancelRequest();
                this.ae = null;
            }
            u uVar = this.N;
            if (uVar != null) {
                uVar.a();
                this.N = null;
            }
            f fVar = this.S;
            if (fVar != null) {
                fVar.a((f.a) null);
            }
            MediaMetadataRetriever mediaMetadataRetriever = this.O;
            if (mediaMetadataRetriever != null) {
                mediaMetadataRetriever.release();
            }
            ar arVar = this.Q;
            if (arVar != null) {
                arVar.setOnTouchListener(null);
            }
            w wVar3 = this.R;
            if (wVar3 != null) {
                wVar3.setOnTouchListener(null);
            }
            ar arVar2 = this.ab;
            if (arVar2 != null) {
                arVar2.setOnTouchListener(null);
            }
            com.sigmob.sdk.videoplayer.a aVar = this.K;
            if (aVar != null) {
                aVar.r();
            }
            View view = this.M;
            if (view != null && (view instanceof o)) {
                ((o) view).setWebViewClickListener(null);
                ((o) this.M).setLogoClickListener(null);
                ((o) this.M).destroy();
            }
            U();
            am.a aVar2 = this.ao;
            if (aVar2 != null) {
                aVar2.c();
                this.ao = null;
            }
            BaseAdUnit baseAdUnit = this.L;
            if (baseAdUnit != null) {
                baseAdUnit.destroy();
            }
            this.M = null;
            this.P = null;
            super.h();
        } catch (Throwable th) {
            SigmobLog.e(th.getMessage());
        }
    }

    @Override // com.sigmob.sdk.base.common.j
    public boolean j() {
        return false;
    }

    @Override // com.sigmob.sdk.base.common.j
    public void o() {
    }

    public void q() {
        com.sigmob.sdk.base.views.b bVar = new com.sigmob.sdk.base.views.b(l().getApplicationContext(), 0);
        this.q = bVar;
        bVar.setId(ClientMetadata.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, Dips.dipsToIntPixels(16.0f, l()));
        com.sigmob.sdk.base.views.m mVar = this.af;
        if (mVar != null) {
            layoutParams.addRule(8, mVar.getId());
        } else {
            layoutParams.addRule(12);
            layoutParams.setMargins(0, 0, 0, this.p);
        }
        try {
            this.q.a(this.L.getAd_source_logo());
            if (!this.L.getInvisibleAdLabel()) {
                this.q.b(com.sigmob.sdk.base.k.h());
            }
        } catch (Throwable unused) {
        }
        m().addView(this.q, layoutParams);
    }

    public String s() {
        return this.F;
    }

    public boolean t() {
        long currentPositionWhenPlaying;
        try {
            currentPositionWhenPlaying = (int) this.K.getCurrentPositionWhenPlaying();
        } catch (Throwable th) {
            SigmobLog.e(th.getMessage());
        }
        if (this.L.getSkipSeconds() > -1) {
            return (((float) currentPositionWhenPlaying) / 1000.0f) + 0.3f >= ((float) this.L.getSkipSeconds());
        }
        if (y() > 0) {
            return ((((float) y()) / 1000.0f) * ((float) this.L.getSkipPercent())) * 0.01f < ((float) currentPositionWhenPlaying) / 1000.0f;
        }
        return true;
    }

    public boolean u() {
        try {
            if (this.L.getAd_type() == 1) {
                long currentPositionWhenPlaying = (int) this.K.getCurrentPositionWhenPlaying();
                if (this.L.getChargeSeconds() > -1) {
                    return (((float) currentPositionWhenPlaying) / 1000.0f) + 0.3f >= ((float) this.L.getChargeSeconds());
                }
                if (y() > 0 && (currentPositionWhenPlaying * 100) / y() >= this.L.getChargePercent()) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
            SigmobLog.e(th.getMessage());
            return true;
        }
    }

    public boolean v() {
        com.sigmob.sdk.base.views.m mVar = this.af;
        if (mVar != null && mVar.a()) {
            return true;
        }
        try {
            boolean z = ((long) ((int) this.K.getCurrentPositionWhenPlaying())) / 1000 >= ((long) this.G);
            if (!z) {
                return z;
            }
            SigmobLog.d("showAble CompanionAds");
            return z;
        } catch (Throwable th) {
            SigmobLog.e("shouldBeShowCompanionAds", th);
            return true;
        }
    }

    public void x() {
        if (this.av) {
            return;
        }
        this.av = true;
        this.L.getMacroCommon().addMarcoKey(SigMacroCommon._PLAYLASTFRAME_, "1");
        if (this.W) {
            return;
        }
        r().a("complete", (int) this.K.getCurrentPositionWhenPlaying());
    }

    public void z() {
        if (this.M == null && this.L.isEndCardIndexExist()) {
            try {
                f e = com.sigmob.sdk.videoAd.a.e(this.L);
                this.S = e;
                e.a(this.I);
                this.M = a(n(), this.S, 4);
                this.S.a(y());
                h(l(), 4);
            } catch (Throwable th) {
                this.S = null;
                SigmobLog.e(th.getMessage());
                HashMap hashMap = new HashMap();
                hashMap.put("error", th.getMessage());
                a(IntentActions.ACTION_REWARDED_VIDEO_PLAYFAIL, hashMap);
                this.d.a();
            }
        }
    }

    private void c(Context context, int i2) {
        if (this.am == null) {
            w wVar = new w(context);
            this.am = wVar;
            wVar.setText("反馈");
            this.am.setOnClickListener(this.ay);
            this.am.setId(ClientMetadata.generateViewId());
            int dipsToIntPixels = Dips.dipsToIntPixels(3.0f, this.f13143a);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(Dips.dipsToIntPixels(45.0f, context), Dips.dipsToIntPixels(30.0f, context));
            layoutParams.addRule(0, this.Q.getId());
            layoutParams.addRule(6, this.Q.getId());
            layoutParams.setMargins(0, -dipsToIntPixels, 0, 0);
            m().addView(this.am, layoutParams);
        }
        w wVar2 = this.am;
        if (wVar2 != null) {
            wVar2.setVisibility(i2);
        }
    }

    private void e(Context context, int i2) {
        as asVar = new as(context);
        this.P = asVar;
        asVar.setAnchorId(this.K.getId());
        this.P.setVisibility(i2);
        m().addView(this.P);
    }

    private void f(Context context, int i2) {
        if (this.E != null) {
            return;
        }
        com.sigmob.sdk.base.views.d dVar = new com.sigmob.sdk.base.views.d(context, this.I.q());
        this.E = dVar;
        dVar.setVisibility(i2);
        m().addView(this.E);
        this.E.setDialogListener(new d.a() { // from class: com.sigmob.sdk.videoAd.j.15
            @Override // com.sigmob.sdk.base.views.d.a
            public void a() {
                if (!j.this.V) {
                    j.this.r().a("skip", (int) j.this.K.getCurrentPositionWhenPlaying());
                    j.this.I.b(((com.sigmob.sdk.base.common.j) j.this).f13143a, (int) j.this.K.getCurrentPositionWhenPlaying(), j.this.y(), j.this.L);
                }
                j.this.E.setVisibility(8);
                if (j.this.af != null && j.this.af.getFourElementsLayout() != null) {
                    j.this.af.getFourElementsLayout().setClickable(true);
                }
                if (j.this.I.m()) {
                    j.this.k().a();
                    return;
                }
                if (!j.this.D) {
                    j jVar = j.this;
                    jVar.a((int) jVar.K.getCurrentPositionWhenPlaying());
                }
                j.this.K.i();
                j.this.V();
                j.this.V = true;
                if (j.this.r() != null) {
                    j.this.N.a("show", 0);
                }
            }

            @Override // com.sigmob.sdk.base.views.d.a
            public void b() {
                j.this.K.d();
                j.this.E.setVisibility(8);
                if (j.this.af == null || j.this.af.getFourElementsLayout() == null) {
                    return;
                }
                j.this.af.getFourElementsLayout().setClickable(true);
            }
        });
    }

    /* JADX WARN: Can't wrap try/catch for region: R(26:11|12|13|(2:18|19)|22|(3:24|25|(19:27|28|29|30|(3:32|33|(2:35|36))|40|41|42|43|(1:45)(1:66)|46|47|(2:61|(1:63)(1:64))|51|(1:53)|54|(1:56)(1:60)|57|58))|74|29|30|(0)|40|41|42|43|(0)(0)|46|47|(1:49)|61|(0)(0)|51|(0)|54|(0)(0)|57|58) */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00fd, code lost:
    
        r13 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00eb, code lost:
    
        r14 = -1;
        r15 = 229;
     */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00b4 A[Catch: all -> 0x00eb, TRY_LEAVE, TryCatch #4 {all -> 0x00eb, blocks: (B:30:0x00b0, B:32:0x00b4), top: B:29:0x00b0 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00f3 A[Catch: all -> 0x00f8, TRY_LEAVE, TryCatch #2 {all -> 0x00f8, blocks: (B:43:0x00ef, B:45:0x00f3), top: B:42:0x00ef }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00fa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void g(android.content.Context r18, int r19) {
        /*
            Method dump skipped, instructions count: 482
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.videoAd.j.g(android.content.Context, int):void");
    }

    private void h(Context context, int i2) {
        if (this.Q == null) {
            ar arVar = new ar(context);
            this.Q = arVar;
            arVar.setId(ClientMetadata.generateViewId());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(Dips.dipsToIntPixels(22.0f, context), Dips.dipsToIntPixels(22.0f, context));
            layoutParams.addRule(10);
            layoutParams.addRule(11);
            int i3 = this.p;
            layoutParams.setMargins(i3, i3 * 2, i3, i3);
            m().addView(this.Q, layoutParams);
            BaseAdUnit baseAdUnit = this.L;
            if (baseAdUnit != null && !TextUtils.isEmpty(baseAdUnit.getCloseCardHtmlData()) && !this.az) {
                z zVar = new z(n(), this.L, this.I);
                this.ai = zVar;
                zVar.a(new A2egSU(this));
            }
            this.Q.setOnTouchListener(new View.OnTouchListener() { // from class: com.sigmob.sdk.videoAd.j.3
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 1) {
                        if (j.this.az || j.this.ai == null || j.this.ai.a() || j.this.aj) {
                            j.this.aa = true;
                            j.this.I.b(j.this.l(), j.this.y(), j.this.L);
                            j.this.k().a();
                        } else {
                            j.this.ai.show();
                            j.this.aj = true;
                        }
                    }
                    return true;
                }
            });
            this.Q.a(this.L);
            String f2 = this.I.f();
            if (f2 != null) {
                this.Q.a(f2);
            }
        }
        ar arVar2 = this.Q;
        if (arVar2 != null) {
            arVar2.setVisibility(i2);
        }
        c(l(), i2);
    }

    @Override // com.sigmob.sdk.base.common.h.a
    public BaseAdUnit a() {
        return this.L;
    }

    private o a(Context context, f fVar) {
        Preconditions.NoThrow.checkNotNull(context);
        Preconditions.NoThrow.checkNotNull(fVar);
        Preconditions.NoThrow.checkNotNull(fVar.a());
        o a2 = o.a(context, this.L.getAd_source_logo(), false, this.L.getInvisibleAdLabel());
        a2.addJavascriptInterface(new a(), "sigVersion");
        a2.setWebViewClickListener(new A2egSU(this));
        a2.setDownloadListener(new DownloadListener() { // from class: com.sigmob.sdk.videoAd.ADYaiT
            @Override // android.webkit.DownloadListener
            public final void onDownloadStart(String str, String str2, String str3, String str4, long j2) {
                j.this.a(str, str2, str3, str4, j2);
            }
        });
        a2.setAdUnit(this.L);
        a2.setWebViewClient(new AnonymousClass6());
        fVar.a().a(a2);
        a2.a((com.sigmob.sdk.base.common.b) null);
        return a2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final int i2) {
        if (this.ak == null) {
            q qVar = new q(n(), this.L);
            this.ak = qVar;
            qVar.a(new q.b() { // from class: com.sigmob.sdk.videoAd.j.5
                @Override // com.sigmob.sdk.base.views.q.b
                public void a() {
                    if (j.this.ak != null) {
                        j.this.ak.dismiss();
                        j.this.ak.c();
                        j.this.ak = null;
                        j.this.al = false;
                    }
                    if (j.this.K != null && i2 == 1) {
                        j.this.K.d();
                    }
                    if (j.this.ao != null) {
                        j.this.ao.a();
                    }
                    j.this.r().a(com.sigmob.sdk.base.common.a.g, (int) j.this.K.getCurrentPositionWhenPlaying());
                }

                @Override // com.sigmob.sdk.base.views.q.b
                public void b() {
                    if (j.this.K != null && i2 == 1) {
                        j.this.K.j();
                    }
                    if (j.this.ao != null) {
                        j.this.ao.b();
                    }
                    j.this.r().a(com.sigmob.sdk.base.common.a.f, (int) j.this.K.getCurrentPositionWhenPlaying());
                }

                @Override // com.sigmob.sdk.base.views.q.b
                public void a(Error error) {
                }

                @Override // com.sigmob.sdk.base.views.q.b
                public void a(String str, String str2) {
                    if (j.this.S == null) {
                        j.this.z();
                    }
                    j.this.L.getClickCommon().click_area = ClickCommon.CLICK_AREA_BTN;
                    j.this.L.getClickCommon().click_scene = "appinfo";
                    j.this.I.a(com.sigmob.sdk.base.a.ENDCARD, str, str2, true);
                }
            });
        }
        q qVar2 = this.ak;
        if (qVar2 == null || !qVar2.a() || this.al) {
            return;
        }
        this.ak.show();
        this.al = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Context context, int i2) {
        if (this.L.getRewardStyle() == 1) {
            this.as = new w(context);
            int B = B();
            if (B > 0) {
                this.as.setText(B + "s 后获取奖励");
            } else {
                this.as.setText("已获得奖励");
                b(false);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(Dips.dipsToIntPixels(97.0f, context), Dips.dipsToIntPixels(22.0f, context));
            layoutParams.addRule(1, this.an.getId());
            int i3 = this.p;
            layoutParams.setMargins(i3, i3 * 2, 0, 0);
            m().addView(this.as, layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(MotionEvent motionEvent, MotionEvent motionEvent2) {
        if (this.Q.getVisibility() != 0 || this.aa) {
            SigmobLog.w("ignore invalid click");
            return;
        }
        this.L.getClickCommon().sld = Constants.FAIL;
        ae.a(this.L, motionEvent2, PointCategory.ENDCARDCLICK, true);
        SigMacroCommon macroCommon = this.L.getMacroCommon();
        macroCommon.updateClickMarco(motionEvent, motionEvent2, true);
        this.h = macroCommon.getCoordinate();
        this.B = true;
        if (this.L.getMaterial().click_type.intValue() != com.sigmob.sdk.base.common.m.FullScreen.a() || TextUtils.isEmpty(this.L.getLanding_page()) || this.L.getMaterial().creative_type.intValue() == n.CreativeTypeVideo_EndCardURL.a()) {
            this.ah = true;
            return;
        }
        this.L.getClickCommon().click_area = ClickCommon.CLICK_AREA_MATERIAL;
        this.L.getClickCommon().click_scene = "endcard";
        this.I.a(com.sigmob.sdk.base.a.ENDCARD, this.h, true);
    }

    private void c(String str) {
        Uri parse;
        if (TextUtils.isEmpty(str) || (parse = Uri.parse(str)) == null) {
            return;
        }
        String host = parse.getHost();
        if (!TextUtils.isEmpty(host) && host.equalsIgnoreCase("127.0.0.1")) {
            Pattern compile = Pattern.compile("/(.*)");
            String path = parse.getPath();
            if (TextUtils.isEmpty(path)) {
                return;
            }
            Matcher matcher = compile.matcher(path);
            if (matcher.find()) {
                this.ax = matcher.group(1);
                com.sigmob.sdk.base.common.h.d().a(this, this.ax);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        b(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z) {
        if (this.at || this.L.getAd_type() == 4) {
            return;
        }
        this.at = true;
        int y = z ? y() : (int) this.K.getCurrentPositionWhenPlaying();
        r().a("finish", y);
        this.I.c(l().getApplicationContext(), y, y(), a());
    }

    private String a(List<String> list) {
        if (list == null || list.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder("[");
        int i2 = 0;
        do {
            if (i2 != 0) {
                sb.append(',');
            }
            sb.append(list.get(i2));
            i2++;
        } while (i2 < list.size());
        sb.append(']');
        return sb.toString();
    }

    @Override // com.sigmob.sdk.base.common.h.a
    public void b(BaseAdUnit baseAdUnit) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2) {
        try {
            ThreadPoolFactory.getFixIOExecutor().submit(new B25kr6(i2, 3, this));
        } catch (RuntimeException e) {
            SigmobLog.e(e.getMessage());
        }
    }

    @Override // com.sigmob.sdk.base.common.j
    public void a(int i2, int i3, Intent intent) {
        if (i3 == -1) {
            k().a();
        }
    }

    public void b(String str) {
        if ("start".equals(str)) {
            a(IntentActions.ACTION_INTERSTITIAL_SHOW);
            a(IntentActions.ACTION_REWARDED_VIDEO_PLAY);
        }
        if (r() != null) {
            r().a(str, (int) this.K.getCurrentPositionWhenPlaying());
        }
    }

    private void a(int i2, boolean z) {
        w wVar = this.R;
        if (wVar == null || this.au) {
            return;
        }
        this.au = true;
        wVar.setText("跳过");
        this.R.setEnabled(true);
        ValueAnimator duration = ValueAnimator.ofInt(Dips.dipsToIntPixels(22.0f, l()), Dips.dipsToIntPixels(45.0f, l())).setDuration(300L);
        duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.sigmob.sdk.videoAd.AMqCpz
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                j.this.a(valueAnimator);
            }
        });
        duration.start();
        this.R.setVisibility(0);
        r().a(z, i2);
        r().a("show_skip", i2);
    }

    public void b(boolean z) {
        if (this.L.getAd_type() == 4 || this.ad) {
            return;
        }
        this.ad = true;
        int y = z ? y() : (int) this.K.getCurrentPositionWhenPlaying();
        this.C.postDelayed(new A4TApA(this, 3), 100L);
        r().a("reward", y);
        this.I.c(l().getApplicationContext(), y, y(), a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(ValueAnimator valueAnimator) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.R.getLayoutParams();
        layoutParams.width = intValue;
        this.R.setLayoutParams(layoutParams);
        this.R.invalidate();
    }

    public void a(Context context) {
        this.Z = new RelativeLayout(context);
        ImageView imageView = new ImageView(context);
        imageView.setImageBitmap(s.LOADING.a());
        imageView.setId(ClientMetadata.generateViewId());
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, BaseConstants.Time.HOUR, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setDuration(8000000);
        rotateAnimation.setInterpolator(new LinearInterpolator());
        rotateAnimation.setRepeatCount(-1);
        rotateAnimation.setRepeatMode(1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        imageView.setAnimation(rotateAnimation);
        this.Z.addView(imageView, layoutParams);
        this.Z.setVisibility(4);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        m().addView(this.Z, layoutParams2);
    }

    private void a(Context context, int i2) {
        if (this.an == null) {
            w wVar = new w(context);
            this.an = wVar;
            wVar.setText("反馈");
            this.an.setId(ClientMetadata.generateViewId());
            this.an.setOnClickListener(this.ay);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(Dips.dipsToIntPixels(45.0f, context), Dips.dipsToIntPixels(22.0f, context));
            layoutParams.addRule(9);
            layoutParams.addRule(10);
            int i3 = this.p;
            layoutParams.setMargins(i3, i3 * 2, 0, 0);
            m().addView(this.an, layoutParams);
        }
        w wVar2 = this.an;
        if (wVar2 != null) {
            wVar2.setVisibility(i2);
        }
    }

    @Override // com.sigmob.sdk.base.common.j
    public void a(Configuration configuration) {
        if (this.I != null && this.S == null) {
            f e = com.sigmob.sdk.videoAd.a.e(this.L);
            this.S = e;
            e.a(this.I);
        }
        u r = r();
        if (r == null) {
            return;
        }
        r.a(com.sigmob.sdk.base.common.a.B, (int) this.K.getCurrentPositionWhenPlaying());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(Bitmap bitmap) {
        this.r.setScaleType(ImageView.ScaleType.FIT_XY);
        this.r.setImageBitmap(bitmap);
    }

    @Override // com.sigmob.sdk.base.common.j
    public void a(Bundle bundle) {
        try {
            bundle.putBoolean(j, this.V);
            bundle.putInt(i, this.U);
            bundle.putBoolean(k, this.Y);
        } catch (Throwable th) {
            SigmobLog.e(th.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MotionEvent motionEvent, MotionEvent motionEvent2) {
        boolean z;
        this.L.getClickCommon().click_area = ClickCommon.CLICK_AREA_MATERIAL;
        this.L.getClickCommon().click_scene = ClickCommon.CLICK_SCENE_AD;
        ClickAreaSetting clickAreaSetting = this.L.getClickAreaSetting();
        float floatValue = clickAreaSetting.left.floatValue() * ClientMetadata.getInstance().getDisplayMetrics().widthPixels;
        float floatValue2 = (1.0f - clickAreaSetting.right.floatValue()) * ClientMetadata.getInstance().getDisplayMetrics().widthPixels;
        float floatValue3 = clickAreaSetting.top.floatValue() * ClientMetadata.getInstance().getDisplayMetrics().heightPixels;
        float floatValue4 = (1.0f - clickAreaSetting.bottom.floatValue()) * ClientMetadata.getInstance().getDisplayMetrics().heightPixels;
        if (floatValue >= motionEvent2.getRawX() || motionEvent2.getRawX() >= floatValue2 || floatValue3 >= motionEvent2.getRawY() || motionEvent2.getRawY() >= floatValue4) {
            z = false;
        } else {
            SigMacroCommon macroCommon = this.L.getMacroCommon();
            macroCommon.addMarcoKey(SigMacroCommon._PROGRESS_, String.valueOf(((int) P()) * 100));
            z = true;
            macroCommon.updateClickMarco(motionEvent, motionEvent2, true);
            this.h = macroCommon.getCoordinate();
            if (this.S == null) {
                z();
            }
            this.I.a(com.sigmob.sdk.base.a.VIDEO_CLICK, this.h, true);
        }
        ae.a(this.L, motionEvent2, "useless_video_click", z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        r().a(com.sigmob.sdk.base.common.a.r, (int) this.K.getCurrentPositionWhenPlaying());
        if (C()) {
            b(false);
        }
        if (this.ad || this.L.getConfirmDialog() == 2 || this.L.getAd_type() == 4) {
            r().a("skip", (int) this.K.getCurrentPositionWhenPlaying());
            this.I.b(this.f13143a, (int) this.K.getCurrentPositionWhenPlaying(), y(), this.L);
            a(false, false);
            return;
        }
        this.K.j();
        SigmobLog.i("videoView.pause()");
        this.E.setDuration(B());
        this.E.setVisibility(0);
        com.sigmob.sdk.base.views.m mVar = this.af;
        if (mVar == null || mVar.getFourElementsLayout() == null) {
            return;
        }
        this.af.getFourElementsLayout().setClickable(false);
    }

    @Override // com.sigmob.sdk.base.common.h.a
    public void a(BaseAdUnit baseAdUnit) {
        if (baseAdUnit.getUuid().equals(this.L.getUuid()) && baseAdUnit.isEndCardIndexExist()) {
            this.C.post(new A4TApA(this, 0));
        }
    }

    @Override // com.sigmob.sdk.videocache.d
    public void a(File file, String str, int i2) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(Object obj) {
        if (obj instanceof PointEntitySigmob) {
            PointEntitySigmob pointEntitySigmob = (PointEntitySigmob) obj;
            Map<String, String> options = pointEntitySigmob.getOptions();
            options.put("duration_seq", a(this.x));
            options.put("video_time_seq", a(this.y));
            options.put("skip_state", this.A);
            options.put("video_duration", String.format(Locale.getDefault(), "%.2f", Float.valueOf(y() / 1000.0f)));
            options.put("endcard_loading_state", this.w);
            pointEntitySigmob.setOptions(options);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(String str, String str2, String str3, String str4, long j2) {
        if (this.B) {
            if (TextUtils.isEmpty(this.L.getLanding_page()) || this.L.getInteractionType() == 2) {
                this.L.setCustomLandPageUrl(str);
            }
            this.L.getClickCommon().click_area = ClickCommon.CLICK_AREA_COMPANION;
            this.L.getClickCommon().click_scene = "endcard";
            this.I.a(com.sigmob.sdk.base.a.ENDCARD, this.h, true);
            StringBuilder sb = new StringBuilder("onDownloadStart() called with: url = [");
            com.bykv.vk.component.ttvideo.player.A2egSU.BIYEnU(sb, str, "], userAgent = [", str2, "], contentDisposition = [");
            com.bykv.vk.component.ttvideo.player.A2egSU.BIYEnU(sb, str3, "], mimetype = [", str4, "], contentLength = [");
            sb.append(j2);
            sb.append("]");
            SigmobLog.d(sb.toString());
        }
    }

    @Override // com.sigmob.sdk.videocache.d
    public void a(String str, Throwable th) {
        SigmobLog.e("url", th);
        ae.a("video", 0, th.getMessage(), this.L);
        a(false, true);
    }

    public void a(boolean z, boolean z2) {
        if (this.aw) {
            return;
        }
        this.aw = true;
        F();
        boolean videoErrorReward = this.L.getVideoErrorReward();
        c(z);
        if (z || (z2 && videoErrorReward)) {
            b(z);
            if (z) {
                x();
            }
        } else if (this.I.m()) {
            k().a();
            return;
        }
        if (!this.D) {
            if (z) {
                T();
            } else {
                a((int) this.K.getCurrentPositionWhenPlaying());
            }
        }
        this.K.i();
        V();
        this.V = true;
        if (r() != null) {
            this.N.a("show", 0);
        }
    }
}
