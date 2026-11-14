package com.sigmob.sdk.mraid2;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.webkit.ConsoleMessage;
import android.webkit.JsResult;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.bytedance.android.live.base.api.push.model.PushUIConfig;
import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.common.Constants;
import com.czhj.sdk.common.utils.AppPackageUtil;
import com.czhj.sdk.common.utils.Dips;
import com.czhj.sdk.common.utils.FileUtil;
import com.czhj.sdk.logger.SigmobLog;
import com.czhj.sdk.logger.SigmobLogger;
import com.sigmob.sdk.Sigmob;
import com.sigmob.sdk.base.BaseAdActivity;
import com.sigmob.sdk.base.common.AdActivity;
import com.sigmob.sdk.base.common.MiMarketManager;
import com.sigmob.sdk.base.common.ae;
import com.sigmob.sdk.base.common.an;
import com.sigmob.sdk.base.common.ap;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.ClickCommon;
import com.sigmob.sdk.base.models.IntentActions;
import com.sigmob.sdk.base.models.LoadAdRequest;
import com.sigmob.sdk.base.models.SigMacroCommon;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.base.mta.PointEntitySigmob;
import com.sigmob.sdk.base.mta.PointParamKey;
import com.sigmob.sdk.base.views.ar;
import com.sigmob.sdk.mraid2.s;
import com.sigmob.windad.WindAdError;
import com.sigmob.windad.WindAdRequest;
import com.sigmob.windad.natives.WindNativeAdData;
import com.ss.android.download.api.constant.BaseConstants;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class s extends com.sigmob.sdk.videoAd.b {
    public static final String f = "s";
    List<BaseAdUnit> g;
    private final Bundle h;
    private int i;
    private boolean j;
    private e k;
    private ar l;
    private com.sigmob.sdk.nativead.b m;
    private boolean n;
    private boolean o;
    private boolean p;
    private boolean q;
    private com.sigmob.sdk.base.views.w r;
    private final Handler s;
    private boolean t;
    private final View.OnClickListener u;

    /* renamed from: com.sigmob.sdk.mraid2.s$2, reason: invalid class name */
    public class AnonymousClass2 implements m {
        public AnonymousClass2() {
        }

        @Override // com.sigmob.sdk.mraid2.m
        public void a() {
            SigmobLog.d("MraidActivity failed to load. Finishing the activity");
            if (((com.sigmob.sdk.base.common.j) s.this).b != null) {
                s.this.a(IntentActions.ACTION_INTERSTITIAL_FAIL);
            }
            ((com.sigmob.sdk.base.common.j) s.this).d.a();
        }

        @Override // com.sigmob.sdk.mraid2.m
        public void b() {
            s.this.a(IntentActions.ACTION_REWARDED_VIDEO_CLOSE);
            s.this.o = true;
            ((com.sigmob.sdk.base.common.j) s.this).d.a();
        }

        @Override // com.sigmob.sdk.mraid2.m
        public void c() {
            if (s.this.j) {
                return;
            }
            s.this.j = true;
            s.this.a(IntentActions.ACTION_REWARDED_VIDEO_COMPLETE);
        }

        @Override // com.sigmob.sdk.mraid2.m
        public void d() {
            s.this.p = true;
        }

        @Override // com.sigmob.sdk.mraid2.m
        public void a(View view) {
            SigmobLog.d("onLoaded() called");
        }

        @Override // com.sigmob.sdk.mraid2.m
        public void a(final i iVar, final BaseAdUnit baseAdUnit, JSONObject jSONObject) {
            String str;
            int interactionType = baseAdUnit == null ? -1 : baseAdUnit.getInteractionType();
            String deeplinkUrl = baseAdUnit == null ? null : baseAdUnit.getDeeplinkUrl();
            int i = 0;
            SigmobLogger.d(s.f, "open: deeplinkUrl = " + deeplinkUrl + ", interactionType = " + interactionType, new Object[0]);
            final String optString = jSONObject.optString("url");
            final String optString2 = jSONObject.optString("event");
            JSONObject optJSONObject = jSONObject.optJSONObject(PointParamKey.DATA);
            if (optJSONObject == null) {
                return;
            }
            final JSONObject optJSONObject2 = optJSONObject.optJSONObject("log_data");
            final String optString3 = optJSONObject.optString("default_url");
            final boolean optBoolean = optJSONObject.optBoolean("in_app");
            boolean optBoolean2 = optJSONObject.optBoolean("parse_302");
            int optInt = optJSONObject.optInt("interaction_type");
            if (optInt == 1) {
                if (optBoolean2) {
                    ap.a(optString, new ap.a() { // from class: com.sigmob.sdk.mraid2.s.2.1
                        @Override // com.sigmob.sdk.base.common.ap.a
                        public void a(String str2) {
                            s.this.a(iVar, baseAdUnit, optString2, str2, optJSONObject2, optString3, optBoolean);
                        }

                        @Override // com.sigmob.sdk.base.common.ap.a
                        public void a(String str2, Throwable th) {
                            s.this.a(iVar, baseAdUnit, optString2, optString, optJSONObject2, optString3, optBoolean);
                        }
                    });
                    return;
                } else {
                    s.this.a(iVar, baseAdUnit, optString2, optString, optJSONObject2, optString3, optBoolean);
                    return;
                }
            }
            String str2 = "";
            if (optInt == 2) {
                if (baseAdUnit != null) {
                    baseAdUnit.setRecord(true);
                    com.sigmob.sdk.base.common.i.a(baseAdUnit, optString, optBoolean2);
                    s.this.a(iVar, baseAdUnit, optString2, optJSONObject2, "");
                    return;
                }
                List<BaseAdUnit> adUnitList = iVar.getAdUnitList();
                if (adUnitList == null || adUnitList.isEmpty()) {
                    SigmobLog.d("adUnits is null or empty.");
                    return;
                }
                BaseAdUnit baseAdUnit2 = iVar.getAdUnitList().get(0);
                baseAdUnit2.setRecord(false);
                com.sigmob.sdk.base.common.i.a(baseAdUnit2, optString, optBoolean2);
                s.this.a(iVar, baseAdUnit2, optString2, optJSONObject2, "");
                return;
            }
            String str3 = "market_url is null";
            if (optInt != 3) {
                String str4 = Constants.FAIL;
                String str5 = com.sigmob.sdk.base.common.a.H;
                if (optInt == 7) {
                    JSONObject optJSONObject3 = optJSONObject.optJSONObject("program");
                    if (optJSONObject3 == null) {
                        return;
                    }
                    try {
                        com.sigmob.sdk.base.common.v.a(com.sigmob.sdk.b.e(), optJSONObject3.optString("wx_app_id"), optJSONObject3.optString("wx_app_username"), optJSONObject3.optString("wx_app_path"), optJSONObject3.optInt("wx_business_type"), optJSONObject3.optString("wx_ext_msg"));
                    } catch (Throwable th) {
                        str2 = th.getMessage();
                    }
                    str3 = str2;
                    if (baseAdUnit != null) {
                        try {
                            boolean a2 = com.sigmob.sdk.base.utils.o.a((CharSequence) str3);
                            if (a2) {
                                str5 = com.sigmob.sdk.base.common.a.G;
                            }
                            ClickCommon clickCommon = baseAdUnit.getClickCommon();
                            if (a2) {
                                str4 = "1";
                            }
                            clickCommon.isDeeplink = str4;
                            com.sigmob.sdk.manager.b.b(baseAdUnit, str5, optString);
                        } catch (Exception e) {
                            e = e;
                            e.printStackTrace();
                            s.this.a(iVar, baseAdUnit, optString2, optJSONObject2, str3);
                        }
                    }
                } else {
                    if (optInt != 8) {
                        return;
                    }
                    if (com.sigmob.sdk.base.utils.o.b(optString)) {
                        try {
                            com.sigmob.sdk.base.common.v.b(s.this.l(), new Intent("android.intent.action.VIEW", Uri.parse(optString)));
                        } catch (Throwable th2) {
                            str2 = th2.getMessage();
                        }
                        str3 = str2;
                    }
                    if (baseAdUnit != null) {
                        try {
                            boolean a3 = com.sigmob.sdk.base.utils.o.a((CharSequence) str3);
                            if (a3) {
                                str5 = com.sigmob.sdk.base.common.a.G;
                            }
                            ClickCommon clickCommon2 = baseAdUnit.getClickCommon();
                            if (a3) {
                                str4 = "1";
                            }
                            clickCommon2.isDeeplink = str4;
                            com.sigmob.sdk.manager.b.b(baseAdUnit, str5, optString);
                        } catch (Exception e2) {
                            e = e2;
                            e.printStackTrace();
                            s.this.a(iVar, baseAdUnit, optString2, optJSONObject2, str3);
                        }
                    }
                }
            } else {
                String str6 = BaseConstants.SCHEME_MARKET;
                JSONObject optJSONObject4 = optJSONObject.optJSONObject(BaseConstants.SCHEME_MARKET);
                if (optJSONObject4 == null) {
                    return;
                }
                final String optString4 = optJSONObject4.optString("market_url");
                final String optString5 = optJSONObject4.optString("app_package_name");
                final String optString6 = optJSONObject4.optString("appstore_package_name");
                String optString7 = optJSONObject4.optString(PointParamKey.TYPE);
                if (com.sigmob.sdk.base.utils.o.b(optString4)) {
                    if (com.sigmob.sdk.base.utils.o.b(optString7)) {
                        try {
                            i = Integer.parseInt(optString7);
                        } catch (Throwable unused) {
                        }
                    }
                    String str7 = (!com.sigmob.sdk.base.utils.o.b(optString6) || AppPackageUtil.getPackageVersionCode(((com.sigmob.sdk.base.common.j) s.this).f13143a, optString6) == -1) ? null : optString6;
                    Uri parse = Uri.parse(optString4);
                    if (com.sigmob.sdk.base.utils.o.a((CharSequence) str7) && baseAdUnit != null) {
                        str7 = com.sigmob.sdk.base.common.v.a(((com.sigmob.sdk.base.common.j) s.this).f13143a, parse, baseAdUnit.getMarketPackageNameList());
                    }
                    if (i == 1) {
                        new MiMarketManager.DirectMailStatusReceiver().a(com.sigmob.sdk.b.e(), baseAdUnit);
                    }
                    try {
                        com.sigmob.sdk.base.common.v.a(s.this.l(), parse, str7);
                    } catch (Throwable th3) {
                        str2 = th3.getMessage();
                    }
                    str3 = str2;
                }
                if (baseAdUnit != null) {
                    try {
                        if (com.sigmob.sdk.base.utils.o.a((CharSequence) str3)) {
                            str = PointCategory.OPEN_MARKET;
                            if (com.sigmob.sdk.base.utils.o.b(optString5)) {
                                FileUtil.writeToCache(baseAdUnit, new File(com.sigmob.sdk.base.utils.k.g(), optString5 + ".log").getAbsolutePath());
                            }
                            if (i == 1) {
                                str6 = "mimarket";
                            }
                            ae.a(PointCategory.APK_CLICK, str6, baseAdUnit);
                        } else {
                            str = PointCategory.OPEN_MARKET_FAILED;
                        }
                        ae.a(str, (String) null, baseAdUnit, new ae.a() { // from class: com.sigmob.sdk.mraid2.AmA8tU
                            @Override // com.sigmob.sdk.base.common.ae.a
                            public final void onAddExtra(Object obj) {
                                s.AnonymousClass2.a(optString4, baseAdUnit, optString5, optString6, obj);
                            }
                        });
                    } catch (Exception e3) {
                        e = e3;
                        e.printStackTrace();
                        s.this.a(iVar, baseAdUnit, optString2, optJSONObject2, str3);
                    }
                }
            }
            s.this.a(iVar, baseAdUnit, optString2, optJSONObject2, str3);
        }

        @Override // com.sigmob.sdk.mraid2.m
        public void a(WindAdError windAdError) {
            SigmobLog.d("Finishing the activity due to a problem: " + windAdError);
            if (((com.sigmob.sdk.base.common.j) s.this).b != null) {
                s.this.a(IntentActions.ACTION_INTERSTITIAL_FAIL);
            }
            ((com.sigmob.sdk.base.common.j) s.this).d.a();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void a(String str, BaseAdUnit baseAdUnit, String str2, String str3, Object obj) {
            if (obj instanceof PointEntitySigmob) {
                PointEntitySigmob pointEntitySigmob = (PointEntitySigmob) obj;
                pointEntitySigmob.setFinal_url(str);
                if (baseAdUnit.getAndroidMarket() == null) {
                    return;
                }
                Map<String, String> options = pointEntitySigmob.getOptions();
                options.put("app_package_name", str2);
                options.put("store_package_name", str3);
            }
        }

        @Override // com.sigmob.sdk.mraid2.m
        public void a(boolean z) {
            if (z) {
                s.this.r();
            } else {
                s.this.s();
            }
        }
    }

    /* renamed from: com.sigmob.sdk.mraid2.s$4, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass4 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f13569a;

        static {
            int[] iArr = new int[ConsoleMessage.MessageLevel.values().length];
            f13569a = iArr;
            try {
                iArr[ConsoleMessage.MessageLevel.ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public s(Activity activity, BaseAdUnit baseAdUnit, Bundle bundle, Bundle bundle2, String str, com.sigmob.sdk.base.common.k kVar) {
        super(activity, str, kVar);
        this.o = false;
        this.p = false;
        this.q = true;
        this.s = new Handler();
        this.u = new View.OnClickListener() { // from class: com.sigmob.sdk.mraid2.s.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BaseAdUnit baseAdUnit2;
                Activity n = s.this.n();
                if (n == null || com.sigmob.sdk.base.utils.e.a(s.this.g) || (baseAdUnit2 = s.this.g.get(0)) == null) {
                    return;
                }
                s sVar = s.this;
                if (sVar.a(sVar.m)) {
                    return;
                }
                s.this.m = new com.sigmob.sdk.nativead.b(n, baseAdUnit2);
                s.this.m.a();
                s.this.m.a(new WindNativeAdData.DislikeInteractionCallback() { // from class: com.sigmob.sdk.mraid2.s.3.1
                    @Override // com.sigmob.windad.natives.WindNativeAdData.DislikeInteractionCallback
                    public void onCancel() {
                        s.this.q();
                    }

                    @Override // com.sigmob.windad.natives.WindNativeAdData.DislikeInteractionCallback
                    public void onSelected(int i, String str2, boolean z) {
                        s.this.q();
                    }

                    @Override // com.sigmob.windad.natives.WindNativeAdData.DislikeInteractionCallback
                    public void onShow() {
                    }
                });
            }
        };
        this.g = com.sigmob.sdk.base.common.h.e(baseAdUnit.getUuid());
        this.h = bundle;
        e a2 = c.a().a(baseAdUnit.getUuid());
        this.k = a2;
        if (a2 == null) {
            this.k = new e(com.sigmob.sdk.b.e(), this.g);
        }
        a(new View.OnApplyWindowInsetsListener() { // from class: com.sigmob.sdk.mraid2.AlLFFp
            @Override // android.view.View.OnApplyWindowInsetsListener
            public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                WindowInsets a3;
                a3 = s.this.a(view, windowInsets);
                return a3;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        if (this.p || com.sigmob.sdk.base.utils.e.a(this.g)) {
            return;
        }
        ae.b("h5_state", Constants.FAIL, this.g.get(0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        ar arVar = this.l;
        if (arVar != null) {
            arVar.setVisibility(4);
        }
        com.sigmob.sdk.base.views.w wVar = this.r;
        if (wVar != null) {
            wVar.setVisibility(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        if (this.l == null) {
            b(this.f13143a, 0);
        }
        this.l.setVisibility(0);
        a(l(), 0);
    }

    public View a() {
        if (this.k == null) {
            this.k = new e(this.f13143a, this.g);
        }
        this.k.a(this.e);
        this.k.a(new f() { // from class: com.sigmob.sdk.mraid2.s.1
            @Override // com.sigmob.sdk.mraid2.f
            public void a() {
                s.this.c();
            }

            @Override // com.sigmob.sdk.mraid2.f
            public void b() {
                s.this.d();
            }

            @Override // com.sigmob.sdk.mraid2.f
            public void c() {
                s.this.t = true;
            }

            @Override // com.sigmob.sdk.mraid2.f
            public void d() {
                s.this.a(IntentActions.ACTION_INTERSTITIAL_SHOW);
            }

            @Override // com.sigmob.sdk.mraid2.f
            public void a(int i, int i2, int i3, int i4) {
                try {
                    ViewGroup m = s.this.m();
                    if (i4 == 0) {
                        m.setBackgroundColor(0);
                    } else {
                        m.setBackgroundColor(Color.argb((int) ((i4 / 100.0f) * 255.0f), i, i2, i3));
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }

            @Override // com.sigmob.sdk.mraid2.f
            public void a(BaseAdUnit baseAdUnit) {
                if (baseAdUnit == null && com.sigmob.sdk.base.utils.e.b(s.this.g)) {
                    baseAdUnit = s.this.g.get(0);
                }
                Activity n = s.this.n();
                if (n == null || baseAdUnit == null) {
                    return;
                }
                s sVar = s.this;
                if (sVar.a(sVar.m)) {
                    return;
                }
                s.this.m = new com.sigmob.sdk.nativead.b(n, baseAdUnit);
                s.this.m.a();
                s.this.m.a(new WindNativeAdData.DislikeInteractionCallback() { // from class: com.sigmob.sdk.mraid2.s.1.1
                    @Override // com.sigmob.windad.natives.WindNativeAdData.DislikeInteractionCallback
                    public void onCancel() {
                        s.this.a("feedbackDidDisappear", true);
                        s.this.q();
                    }

                    @Override // com.sigmob.windad.natives.WindNativeAdData.DislikeInteractionCallback
                    public void onSelected(int i, String str, boolean z) {
                        s.this.a("feedbackDidDisappear", true);
                        s.this.q();
                    }

                    @Override // com.sigmob.windad.natives.WindNativeAdData.DislikeInteractionCallback
                    public void onShow() {
                        s.this.a("feedbackDidAppear", false);
                    }
                });
            }

            @Override // com.sigmob.sdk.mraid2.f
            public boolean a(ConsoleMessage consoleMessage) {
                if (AnonymousClass4.f13569a[consoleMessage.messageLevel().ordinal()] == 1) {
                    SigmobLog.e("onConsoleMessage " + consoleMessage.message());
                    ae.a("h5_error", "mraid2", 0, consoleMessage.message(), (WindAdRequest) null, (LoadAdRequest) null, s.this.g.get(0), (ae.a) null);
                }
                return false;
            }

            @Override // com.sigmob.sdk.mraid2.f
            public boolean a(String str, JsResult jsResult) {
                return false;
            }
        });
        this.k.a(new AnonymousClass2());
        return this.k.e();
    }

    @Override // com.sigmob.sdk.base.common.j
    public boolean j() {
        return false;
    }

    @Override // com.sigmob.sdk.base.common.j
    public void o() {
        e eVar = this.k;
        if (eVar != null) {
            eVar.a(this.g.get(0));
        }
        this.s.postDelayed(new AaHO0E(3, this), PushUIConfig.dismissTime);
        a(IntentActions.ACTION_INTERSTITIAL_VOPEN);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void b(Context context, int i) {
        if (this.l != null) {
            return;
        }
        ar arVar = new ar(context);
        this.l = arVar;
        arVar.setVisibility(i);
        this.l.setId(ClientMetadata.generateViewId());
        int dipsToIntPixels = Dips.dipsToIntPixels(22.0f, context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dipsToIntPixels, dipsToIntPixels);
        a(3, layoutParams);
        m().addView(this.l, layoutParams);
        this.l.setOnTouchListener(new View.OnTouchListener() { // from class: com.sigmob.sdk.mraid2.AcNBzu
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean a2;
                a2 = s.this.a(view, motionEvent);
                return a2;
            }
        });
        this.l.a(this.g.get(0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        com.sigmob.sdk.nativead.b bVar = this.m;
        if (bVar == null) {
            return;
        }
        bVar.dismiss();
        this.m.b();
        this.m = null;
    }

    @Override // com.sigmob.sdk.videoAd.b, com.sigmob.sdk.base.common.j
    public void e() {
        super.e();
        n().getWindow().addFlags(16778240);
        b(n(), this.i, this.h);
        BaseAdUnit baseAdUnit = this.g.get(0);
        if (com.sigmob.sdk.base.utils.q.b(baseAdUnit) && (baseAdUnit.getMaterial().theme_data.intValue() == 1 || baseAdUnit.getTemplateType() == 1)) {
            b();
            m().setBackgroundColor(Color.argb(127, 0, 0, 0));
        }
        m().addView(a(), new FrameLayout.LayoutParams(-1, -1));
    }

    @Override // com.sigmob.sdk.base.common.j
    public void f() {
        if (!this.o) {
            this.k.a();
        } else {
            this.q = true;
            a(IntentActions.ACTION_INTERSTITIAL_DISMISS);
        }
    }

    @Override // com.sigmob.sdk.base.common.j
    public void g() {
        this.k.b();
    }

    @Override // com.sigmob.sdk.base.common.j
    public void h() {
        e eVar = this.k;
        if (eVar != null) {
            eVar.d();
        }
        q();
        if (com.sigmob.sdk.base.utils.e.b(this.g)) {
            if (this.n) {
                BaseAdUnit baseAdUnit = this.g.get(0);
                if (com.sigmob.sdk.base.utils.q.b(baseAdUnit)) {
                    com.sigmob.sdk.base.network.g.a(baseAdUnit, "ad_close");
                    ae.a("ad_close", (String) null, baseAdUnit);
                }
            }
            for (BaseAdUnit baseAdUnit2 : this.g) {
                if (baseAdUnit2 != null) {
                    baseAdUnit2.destroy();
                }
            }
        }
        if (!this.o || !this.q) {
            this.q = true;
            a(IntentActions.ACTION_INTERSTITIAL_DISMISS);
        }
        Sigmob.getInstance().getMacroCommon().clearMacro();
        super.h();
    }

    @Override // com.sigmob.sdk.base.common.j
    public void i() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ WindowInsets a(View view, WindowInsets windowInsets) {
        this.k.a(windowInsets, this.t);
        return windowInsets;
    }

    private void a(int i, RelativeLayout.LayoutParams layoutParams) {
        int i2;
        int dipsToIntPixels = Dips.dipsToIntPixels(10.0f, this.f13143a);
        if (i == 1 || i == 2) {
            layoutParams.addRule(10);
            i2 = 9;
        } else {
            if (i != 3 && i != 4) {
                return;
            }
            layoutParams.addRule(10);
            i2 = 11;
        }
        layoutParams.addRule(i2);
        layoutParams.setMargins(dipsToIntPixels, dipsToIntPixels * 2, dipsToIntPixels, dipsToIntPixels);
    }

    private void a(Context context, int i) {
        if (this.r == null) {
            com.sigmob.sdk.base.views.w wVar = new com.sigmob.sdk.base.views.w(context);
            this.r = wVar;
            wVar.setText("反馈");
            this.r.setOnClickListener(this.u);
            this.r.setId(ClientMetadata.generateViewId());
            int dipsToIntPixels = Dips.dipsToIntPixels(3.0f, this.f13143a);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(Dips.dipsToIntPixels(45.0f, context), Dips.dipsToIntPixels(30.0f, context));
            layoutParams.addRule(0, this.l.getId());
            layoutParams.addRule(6, this.l.getId());
            layoutParams.setMargins(0, -dipsToIntPixels, 0, 0);
            m().addView(this.r, layoutParams);
        }
        com.sigmob.sdk.base.views.w wVar2 = this.r;
        if (wVar2 != null) {
            wVar2.setVisibility(i);
        }
    }

    @Override // com.sigmob.sdk.base.common.j
    public void a(Configuration configuration) {
        e eVar = this.k;
        if (eVar == null) {
            return;
        }
        eVar.a(configuration.orientation);
    }

    @Override // com.sigmob.sdk.base.common.j
    public void a(Bundle bundle) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(BaseAdUnit baseAdUnit, ClickCommon clickCommon, JSONObject jSONObject, Object obj) {
        if (obj instanceof PointEntitySigmob) {
            PointEntitySigmob pointEntitySigmob = (PointEntitySigmob) obj;
            pointEntitySigmob.setScene_id(baseAdUnit.getAd_scene_id());
            pointEntitySigmob.setScene_desc(baseAdUnit.getAd_scene_desc());
            pointEntitySigmob.setIs_deeplink(clickCommon.isDeeplink);
            pointEntitySigmob.setFinal_url(clickCommon.clickUrl);
            pointEntitySigmob.setCoordinate(clickCommon.clickCoordinate);
            pointEntitySigmob.setVtime(String.format(Locale.getDefault(), "%.2f", Float.valueOf(0.0f)));
            Map<String, String> options = pointEntitySigmob.getOptions();
            if (com.sigmob.sdk.base.utils.q.b(jSONObject)) {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    options.put(next, jSONObject.optString(next));
                }
            }
            options.put("cwidth", String.valueOf(ClientMetadata.getInstance().getDeviceScreenRealWidthDip()));
            options.put("cheight", String.valueOf(ClientMetadata.getInstance().getDeviceScreenRealHeightDip()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(i iVar, BaseAdUnit baseAdUnit, String str, String str2, JSONObject jSONObject, String str3, boolean z) {
        BaseAdUnit baseAdUnit2;
        s sVar;
        i iVar2;
        BaseAdUnit baseAdUnit3;
        String str4;
        JSONObject jSONObject2;
        BaseAdUnit baseAdUnit4;
        String str5 = null;
        String str6 = "";
        if (an.OPEN_WITH_BROWSER.a(Uri.parse(str2), 0)) {
            try {
                if (z) {
                    if (baseAdUnit == null) {
                        baseAdUnit4 = iVar.getAdUnitList().get(0);
                        baseAdUnit4.setRecord(false);
                    } else {
                        baseAdUnit.setRecord(true);
                        baseAdUnit4 = baseAdUnit;
                    }
                    baseAdUnit4.setUrl(str2);
                    com.sigmob.sdk.base.common.h.a(baseAdUnit4);
                    BaseAdActivity.a(l(), (Class<? extends BaseAdActivity>) AdActivity.class, baseAdUnit4);
                } else {
                    com.sigmob.sdk.base.common.v.b(l(), new Intent("android.intent.action.VIEW", Uri.parse(str2)));
                }
                sVar = this;
                iVar2 = iVar;
                baseAdUnit3 = baseAdUnit;
                str4 = str;
                jSONObject2 = jSONObject;
                str5 = str6;
            } catch (Exception e) {
                String message = e.getMessage();
                if (com.sigmob.sdk.base.utils.o.b(str3)) {
                    try {
                        com.sigmob.sdk.base.common.v.b(l(), new Intent("android.intent.action.VIEW", Uri.parse(str3)));
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        str5 = e.getMessage();
                    }
                } else {
                    str5 = message;
                }
            }
            sVar.a(iVar2, baseAdUnit3, str4, jSONObject2, str5);
        }
        try {
            com.sigmob.sdk.base.common.h.d(baseAdUnit);
            Uri parse = Uri.parse(str2);
            com.sigmob.sdk.base.common.v.a(l(), parse, baseAdUnit == null ? null : com.sigmob.sdk.base.common.v.a(this.f13143a, parse, baseAdUnit.getMarketPackageNameList()), com.sigmob.sdk.base.utils.q.b(baseAdUnit) && baseAdUnit.enableSmallWindow(null));
        } catch (Exception e3) {
            com.sigmob.sdk.base.common.h.d((BaseAdUnit) null);
            str6 = e3.getMessage();
        }
        if (baseAdUnit != null) {
            try {
                if (com.sigmob.sdk.base.utils.o.b(str6)) {
                    baseAdUnit.getClickCommon().isDeeplink = Constants.FAIL;
                    com.sigmob.sdk.manager.b.b(baseAdUnit, com.sigmob.sdk.base.common.a.H, str2);
                }
            } catch (Exception e4) {
                str6 = e4.getMessage();
                e4.printStackTrace();
            }
        }
        if (!com.sigmob.sdk.base.utils.o.b(str6) || !com.sigmob.sdk.base.utils.o.b(str3)) {
            str5 = str6;
        } else if (z) {
            if (baseAdUnit != null) {
                baseAdUnit.setRecord(true);
                baseAdUnit2 = baseAdUnit;
            } else {
                baseAdUnit2 = iVar.getAdUnitList().get(0);
                baseAdUnit2.setRecord(false);
            }
            baseAdUnit2.setUrl(str3);
            com.sigmob.sdk.base.common.h.a(baseAdUnit2);
            BaseAdActivity.a(l(), (Class<? extends BaseAdActivity>) AdActivity.class, baseAdUnit2);
        } else {
            com.sigmob.sdk.base.common.v.b(l(), new Intent("android.intent.action.VIEW", Uri.parse(str3)));
        }
        sVar = this;
        iVar2 = iVar;
        baseAdUnit3 = baseAdUnit;
        str4 = str;
        jSONObject2 = jSONObject;
        sVar.a(iVar2, baseAdUnit3, str4, jSONObject2, str5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(i iVar, BaseAdUnit baseAdUnit, String str, JSONObject jSONObject, String str2) {
        d mraidBridge = iVar.getMraidBridge();
        try {
            if (com.sigmob.sdk.base.utils.o.b(str2) && com.sigmob.sdk.base.utils.q.b(mraidBridge)) {
                mraidBridge.b(str + "_failed", str2);
                return;
            }
            if (baseAdUnit != null && jSONObject != null) {
                String requestId = baseAdUnit.getRequestId();
                int optInt = jSONObject.optInt(ClickCommon.CLICK_LOSE_RATE, 0);
                int optInt2 = jSONObject.optInt(ClickCommon.CLICK_CB_STATE, com.sigmob.sdk.base.utils.c.b);
                com.sigmob.sdk.base.utils.c.a(requestId, Integer.valueOf(optInt), Integer.valueOf(optInt2));
                baseAdUnit.getMacroCommon().addMarcoKey(SigMacroCommon._ISNC_, String.valueOf(optInt2));
                baseAdUnit.getClickCommon().click_lose_rate = Integer.valueOf(optInt);
                baseAdUnit.getClickCommon().click_cb_state = Integer.valueOf(optInt2);
            }
            a(IntentActions.ACTION_INTERSTITIAL_CLICK);
            if (com.sigmob.sdk.base.utils.q.b(mraidBridge)) {
                mraidBridge.b(str + "_success", "");
            }
            if (baseAdUnit != null && baseAdUnit.isRecord()) {
                ClickCommon clickCommon = baseAdUnit.getClickCommon();
                String optString = jSONObject == null ? null : jSONObject.optString(PointParamKey.CATEGORY);
                if (!com.sigmob.sdk.base.utils.o.b(optString)) {
                    optString = com.sigmob.sdk.base.a.ENDCARD.name().toLowerCase();
                }
                ae.a(optString, "click", baseAdUnit, new GnQT2j.A4TApA(10, baseAdUnit, clickCommon, jSONObject));
                if (com.sigmob.sdk.base.utils.q.b(jSONObject) && com.sigmob.sdk.base.utils.o.a((CharSequence) jSONObject.optString(ClickCommon.CLICK_AREA), (CharSequence) ClickCommon.CLICK_AREA_COMPANION)) {
                    return;
                }
                com.sigmob.sdk.base.network.g.a(baseAdUnit, "click");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, boolean z) {
        i c;
        d mraidBridge;
        e eVar = this.k;
        if (eVar == null || (c = eVar.c()) == null || (mraidBridge = c.getMraidBridge()) == null) {
            return;
        }
        mraidBridge.a(str, (HashMap<String, Object>) null);
        mraidBridge.a(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean a(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            this.o = true;
            this.n = true;
            k().a();
        }
        return true;
    }
}
