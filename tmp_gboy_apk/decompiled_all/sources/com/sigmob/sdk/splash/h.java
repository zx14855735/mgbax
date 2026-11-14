package com.sigmob.sdk.splash;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.czhj.sdk.common.Constants;
import com.czhj.sdk.common.utils.Dips;
import com.czhj.sdk.common.utils.FileUtil;
import com.czhj.sdk.common.utils.Preconditions;
import com.czhj.sdk.logger.SigmobLog;
import com.czhj.wire.Wire;
import com.sigmob.sdk.base.common.BaseBroadcastReceiver;
import com.sigmob.sdk.base.common.ae;
import com.sigmob.sdk.base.common.ah;
import com.sigmob.sdk.base.common.am;
import com.sigmob.sdk.base.common.an;
import com.sigmob.sdk.base.common.ao;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.ClickCommon;
import com.sigmob.sdk.base.models.IntentActions;
import com.sigmob.sdk.base.models.SensorEntity;
import com.sigmob.sdk.base.models.SigMacroCommon;
import com.sigmob.sdk.base.models.rtb.AndroidMarket;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.base.mta.PointEntitySigmob;
import com.sigmob.sdk.base.utils.k;
import com.sigmob.sdk.base.utils.r;
import com.sigmob.sdk.base.views.aa;
import com.sigmob.sdk.base.views.ac;
import com.sigmob.sdk.base.views.ag;
import com.sigmob.sdk.base.views.ai;
import com.sigmob.sdk.base.views.ak;
import com.sigmob.sdk.base.views.ap;
import com.sigmob.sdk.base.views.aq;
import com.sigmob.sdk.base.views.aw;
import com.sigmob.sdk.base.views.q;
import com.sigmob.sdk.base.views.v;
import com.sigmob.sdk.base.views.x;
import com.sigmob.sdk.splash.h;
import com.sigmob.windad.WindAdError;
import com.ss.android.download.api.constant.BaseConstants;
import java.io.File;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class h extends RelativeLayout {

    /* renamed from: a, reason: collision with root package name */
    public static final String f13672a = "h";
    private static float b = 25.0f;
    private final RelativeLayout c;
    private b d;
    private final Context e;
    private BaseAdUnit f;
    private a g;
    private RelativeLayout h;
    private View.OnTouchListener i;
    private volatile boolean j;
    private boolean k;
    private boolean l;
    private ag m;
    private am.a n;
    private v o;
    private boolean p;
    private float q;

    /* renamed from: com.sigmob.sdk.splash.h$2, reason: invalid class name */
    public class AnonymousClass2 implements am.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ aw f13676a;

        public AnonymousClass2(aw awVar) {
            this.f13676a = awVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b() {
            h.this.f();
        }

        @Override // com.sigmob.sdk.base.common.am.b
        public void a() {
        }

        @Override // com.sigmob.sdk.base.common.am.b
        public void a(float f) {
        }

        @Override // com.sigmob.sdk.base.common.am.b
        public void a(Map<String, Number> map) {
            if (map == null || h.this.f == null || h.this.j) {
                return;
            }
            h.this.j = true;
            Number number = map.get("turn_x");
            Number number2 = map.get("turn_y");
            Number number3 = map.get("turn_z");
            Number number4 = map.get("turn_time");
            if (number != null) {
                h.this.f.getClickCommon().turn_x = String.valueOf(number.intValue());
            }
            if (number2 != null) {
                h.this.f.getClickCommon().turn_y = String.valueOf(number2.intValue());
            }
            if (number3 != null) {
                h.this.f.getClickCommon().turn_z = String.valueOf(number3.intValue());
            }
            h.this.f.getClickCommon().turn_time = String.valueOf(number4);
            h.this.f.getClickCommon().sld = "5";
            h.this.f.getClickCommon().click_area = ClickCommon.CLICK_AREA_COMPONENT;
            h.this.f.getClickCommon().click_scene = ClickCommon.CLICK_SCENE_AD;
            this.f13676a.postDelayed(new ARc23Z(0, this), 400L);
        }
    }

    /* renamed from: com.sigmob.sdk.splash.h$3, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass3 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f13677a;

        static {
            int[] iArr = new int[an.values().length];
            f13677a = iArr;
            try {
                iArr[an.FOLLOW_PACKAGE_NAME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f13677a[an.IGNORE_ABOUT_SCHEME.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f13677a[an.MINI_PROGRAM.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f13677a[an.FOLLOW_DEEP_LINK.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f13677a[an.MARKET_SCHEME.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f13677a[an.DOWNLOAD_APK.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f13677a[an.OPEN_WITH_BROWSER.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f13677a[an.NOOP.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    /* renamed from: com.sigmob.sdk.splash.h$5, reason: invalid class name */
    public class AnonymousClass5 implements ao.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ BaseAdUnit f13679a;

        public AnonymousClass5(BaseAdUnit baseAdUnit) {
            this.f13679a = baseAdUnit;
        }

        @Override // com.sigmob.sdk.base.common.ao.b
        public void a(String str, an anVar) {
            SigmobLog.i("urlHandlingSucceeded: " + anVar.name() + " url: " + str);
            if (h.this.f == null) {
                SigmobLog.e("adUnit is null");
                return;
            }
            h.this.f.getClickCommon().is_final_click = true;
            if (!this.f13679a.getAd().forbiden_parse_landingpage.booleanValue()) {
                ae.a(this.f13679a, anVar.name(), str);
            }
            h.this.g();
            int i = AnonymousClass3.f13677a[anVar.ordinal()];
            if (i == 3) {
                anVar.toString();
                com.sigmob.sdk.manager.b.b(this.f13679a, com.sigmob.sdk.base.common.a.G, str);
            } else if (i == 5) {
                AndroidMarket androidMarket = h.this.f.getAndroidMarket();
                if (androidMarket != null) {
                    ae.a(PointCategory.APK_CLICK, ((Integer) Wire.get(androidMarket.type, 0)).intValue() == 0 ? BaseConstants.SCHEME_MARKET : "mimarket", h.this.f);
                    if (!TextUtils.isEmpty(androidMarket.app_package_name)) {
                        try {
                            FileUtil.writeToCache(h.this.f, new File(k.g(), androidMarket.app_package_name + ".log").getAbsolutePath());
                        } catch (Throwable th) {
                            com.bykv.vk.component.ttvideo.player.A2egSU.BJ7GGh(th, new StringBuilder("write ad info with package error "));
                        }
                    }
                }
                ae.a(PointCategory.OPEN_MARKET, (String) null, h.this.f, new ASJ6gh(this, str, 1));
            } else if (i == 6) {
                if (h.this.g.j()) {
                    h.this.f.getClickCommon().is_final_click = false;
                } else {
                    h.this.a(true);
                    h.this.g.f(str);
                }
            }
            ah sessionManager = this.f13679a.getSessionManager();
            if (sessionManager == null) {
                return;
            }
            sessionManager.a("click", 0);
        }

        @Override // com.sigmob.sdk.base.common.ao.b
        public void b(String str, an anVar) {
            SigmobLog.i("urlHandlingFailed: " + anVar.name() + " url: " + str);
            if (h.this.f == null) {
                return;
            }
            h.this.f.getClickCommon().is_final_click = true;
            int i = AnonymousClass3.f13677a[anVar.ordinal()];
            if (i == 3 || i == 4) {
                anVar.toString();
                com.sigmob.sdk.manager.b.b(this.f13679a, com.sigmob.sdk.base.common.a.H, str);
                return;
            }
            if (i == 5) {
                ae.a(PointCategory.OPEN_MARKET_FAILED, (String) null, h.this.f, new ASJ6gh(this, str, 0));
                return;
            }
            if (i != 8) {
                return;
            }
            if (!this.f13679a.getAd().forbiden_parse_landingpage.booleanValue()) {
                ae.a(this.f13679a, anVar.name(), str);
            }
            h.this.f.getClickCommon().is_final_click = true;
            ah sessionManager = this.f13679a.getSessionManager();
            if (sessionManager != null) {
                sessionManager.a("click", 0);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(String str, Object obj) {
            if (obj instanceof PointEntitySigmob) {
                PointEntitySigmob pointEntitySigmob = (PointEntitySigmob) obj;
                pointEntitySigmob.setFinal_url(str);
                Map<String, String> options = pointEntitySigmob.getOptions();
                options.put("app_package_name", h.this.f.getAndroidMarket().app_package_name);
                options.put("store_package_name", h.this.f.getAndroidMarket().appstore_package_name);
                pointEntitySigmob.setOptions(options);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(String str, Object obj) {
            if (obj instanceof PointEntitySigmob) {
                PointEntitySigmob pointEntitySigmob = (PointEntitySigmob) obj;
                pointEntitySigmob.setFinal_url(str);
                Map<String, String> options = pointEntitySigmob.getOptions();
                options.put("app_package_name", h.this.f.getAndroidMarket().app_package_name);
                options.put("store_package_name", h.this.f.getAndroidMarket().appstore_package_name);
                pointEntitySigmob.setOptions(options);
            }
        }
    }

    /* renamed from: com.sigmob.sdk.splash.h$6, reason: invalid class name */
    public class AnonymousClass6 implements am.b {
        public AnonymousClass6() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b() {
            h.this.f();
        }

        @Override // com.sigmob.sdk.base.common.am.b
        public void a() {
        }

        @Override // com.sigmob.sdk.base.common.am.b
        public void a(float f) {
        }

        @Override // com.sigmob.sdk.base.common.am.b
        public void a(Map<String, Number> map) {
            if (map == null || h.this.f == null || h.this.j) {
                return;
            }
            h.this.j = true;
            Number number = map.get("x_max_acc");
            Number number2 = map.get("y_max_acc");
            Number number3 = map.get("z_max_acc");
            h.this.f.getClickCommon().sld = "2";
            h.this.f.getClickCommon().click_area = ClickCommon.CLICK_AREA_COMPONENT;
            h.this.f.getClickCommon().click_scene = ClickCommon.CLICK_SCENE_AD;
            if (number != null) {
                h.this.f.getClickCommon().x_max_acc = String.valueOf(number.intValue());
            }
            if (number2 != null) {
                h.this.f.getClickCommon().y_max_acc = String.valueOf(number2.intValue());
            }
            if (number3 != null) {
                h.this.f.getClickCommon().z_max_acc = String.valueOf(number3.intValue());
            }
            h.this.o.postDelayed(new ARc23Z(1, this), 400L);
        }
    }

    /* renamed from: com.sigmob.sdk.splash.h$7, reason: invalid class name */
    public class AnonymousClass7 implements am.b {
        public AnonymousClass7() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b() {
            h.this.f();
        }

        @Override // com.sigmob.sdk.base.common.am.b
        public void a() {
        }

        @Override // com.sigmob.sdk.base.common.am.b
        public void a(float f) {
            if (h.this.o instanceof com.sigmob.sdk.base.views.am) {
                ((com.sigmob.sdk.base.views.am) h.this.o).a(f);
            }
        }

        @Override // com.sigmob.sdk.base.common.am.b
        public void a(Map<String, Number> map) {
            if (map == null || h.this.f == null || h.this.j) {
                return;
            }
            h.this.j = true;
            Number number = map.get("turn_x");
            Number number2 = map.get("turn_y");
            Number number3 = map.get("turn_z");
            Number number4 = map.get("turn_time");
            if (number != null) {
                h.this.f.getClickCommon().turn_x = String.valueOf(number.intValue());
            }
            if (number2 != null) {
                h.this.f.getClickCommon().turn_y = String.valueOf(number2.intValue());
            }
            if (number3 != null) {
                h.this.f.getClickCommon().turn_z = String.valueOf(number3.intValue());
            }
            h.this.f.getClickCommon().turn_time = String.valueOf(number4);
            h.this.f.getClickCommon().sld = "5";
            h.this.f.getClickCommon().click_area = ClickCommon.CLICK_AREA_COMPONENT;
            h.this.f.getClickCommon().click_scene = ClickCommon.CLICK_SCENE_AD;
            h.this.o.postDelayed(new ARc23Z(2, this), 400L);
        }
    }

    /* renamed from: com.sigmob.sdk.splash.h$9, reason: invalid class name */
    public class AnonymousClass9 implements am.b {
        public AnonymousClass9() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b() {
            if (h.this.o instanceof ap) {
                ((ap) h.this.o).a(0.0f);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c() {
            h.this.f();
        }

        @Override // com.sigmob.sdk.base.common.am.b
        public void a() {
        }

        @Override // com.sigmob.sdk.base.common.am.b
        public void a(float f) {
            if (h.this.o instanceof ap) {
                ((ap) h.this.o).a(f);
            }
        }

        @Override // com.sigmob.sdk.base.common.am.b
        public void a(Map<String, Number> map) {
            if (map == null || h.this.f == null || h.this.j) {
                return;
            }
            h.this.j = true;
            Number number = map.get("x_max_acc");
            Number number2 = map.get("y_max_acc");
            Number number3 = map.get("z_max_acc");
            if (number != null) {
                h.this.f.getClickCommon().x_max_acc = String.valueOf(number.intValue());
            }
            if (number2 != null) {
                h.this.f.getClickCommon().y_max_acc = String.valueOf(number2.intValue());
            }
            if (number3 != null) {
                h.this.f.getClickCommon().z_max_acc = String.valueOf(number3.intValue());
            }
            h.this.f.getClickCommon().sld = "2";
            h.this.f.getClickCommon().click_area = ClickCommon.CLICK_AREA_COMPONENT;
            h.this.f.getClickCommon().click_scene = ClickCommon.CLICK_SCENE_AD;
            final int i = 0;
            h.this.o.postDelayed(new Runnable(this) { // from class: com.sigmob.sdk.splash.AYUAbz

                /* renamed from: AlLFFp, reason: collision with root package name */
                public final /* synthetic */ h.AnonymousClass9 f13667AlLFFp;

                {
                    this.f13667AlLFFp = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    switch (i) {
                        case 0:
                            this.f13667AlLFFp.c();
                            break;
                        default:
                            this.f13667AlLFFp.b();
                            break;
                    }
                }
            }, 400L);
            final int i2 = 1;
            h.this.o.postDelayed(new Runnable(this) { // from class: com.sigmob.sdk.splash.AYUAbz

                /* renamed from: AlLFFp, reason: collision with root package name */
                public final /* synthetic */ h.AnonymousClass9 f13667AlLFFp;

                {
                    this.f13667AlLFFp = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    switch (i2) {
                        case 0:
                            this.f13667AlLFFp.c();
                            break;
                        default:
                            this.f13667AlLFFp.b();
                            break;
                    }
                }
            }, 800L);
        }
    }

    public h(Context context) {
        super(context);
        Context applicationContext = context.getApplicationContext();
        this.e = applicationContext;
        RelativeLayout relativeLayout = new RelativeLayout(applicationContext);
        this.c = relativeLayout;
        addView(relativeLayout, new RelativeLayout.LayoutParams(-1, -1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        com.sigmob.sdk.base.utils.c.a(f13672a, this.f);
        BaseBroadcastReceiver.a(this.e, this.f.getUuid(), IntentActions.ACTION_INTERSTITIAL_CLICK);
    }

    private void i() {
        Context context = getContext();
        this.o = new ac(context);
        int dipsToIntPixels = Dips.dipsToIntPixels(100.0f, context);
        int dipsToIntPixels2 = Dips.dipsToIntPixels(145.0f, context);
        RelativeLayout.LayoutParams BTvldC2 = com.bykv.vk.component.ttvideo.player.A2egSU.BTvldC(dipsToIntPixels, dipsToIntPixels, 14, 12);
        BTvldC2.setMargins(0, 0, 0, dipsToIntPixels2);
        if (this.f.getClickType() == 1) {
            this.o.setOnTouchListener(this.i);
        }
        am.a aVar = new am.a(context, new AnonymousClass6(), am.c.SHAKE);
        this.n = aVar;
        aVar.a(SensorEntity.format(this.f));
        this.n.a();
        addView(this.o, BTvldC2);
    }

    private void j() {
        Context context = getContext();
        this.o = new com.sigmob.sdk.base.views.am(context);
        int dipsToIntPixels = Dips.dipsToIntPixels(92.0f, context);
        int dipsToIntPixels2 = Dips.dipsToIntPixels(145.0f, context);
        RelativeLayout.LayoutParams BTvldC2 = com.bykv.vk.component.ttvideo.player.A2egSU.BTvldC(dipsToIntPixels, dipsToIntPixels, 14, 12);
        BTvldC2.setMargins(0, 0, 0, dipsToIntPixels2);
        if (this.f.getClickType() == 1) {
            this.o.setOnTouchListener(this.i);
        }
        am.a aVar = new am.a(context, new AnonymousClass7(), am.c.SLOPE);
        this.n = aVar;
        aVar.a(SensorEntity.format(this.f));
        this.n.a();
        addView(this.o, BTvldC2);
    }

    private void k() {
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.sigmob.sdk.splash.h.8
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Context context;
                h.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                if (h.this.f == null || (context = h.this.getContext()) == null) {
                    return;
                }
                h.this.getLocationOnScreen(new int[2]);
                h.this.f.getClickCommon().adarea_x = String.valueOf(Dips.pixelsToIntDips(r1[0], context));
                h.this.f.getClickCommon().adarea_y = String.valueOf(Dips.pixelsToIntDips(r1[1], context));
                h.this.f.getClickCommon().adarea_w = String.valueOf(Dips.pixelsToIntDips(h.this.getWidth(), context));
                h.this.f.getClickCommon().adarea_h = String.valueOf(Dips.pixelsToIntDips(h.this.getHeight(), context));
            }
        });
    }

    private void l() {
        Context context = getContext();
        this.o = new ap(context);
        int dipsToIntPixels = Dips.dipsToIntPixels(100.0f, context);
        int dipsToIntPixels2 = Dips.dipsToIntPixels(145.0f, context);
        RelativeLayout.LayoutParams BTvldC2 = com.bykv.vk.component.ttvideo.player.A2egSU.BTvldC(dipsToIntPixels, dipsToIntPixels, 14, 12);
        BTvldC2.setMargins(0, 0, 0, dipsToIntPixels2);
        if (this.f.getClickType() == 1) {
            this.o.setOnTouchListener(this.i);
        }
        am.a aVar = new am.a(context, new AnonymousClass9(), am.c.SWING);
        this.n = aVar;
        aVar.a(SensorEntity.format(this.f));
        this.n.a();
        addView(this.o, BTvldC2);
    }

    private void m() {
        Context context = getContext();
        View akVar = new ak(context);
        int dipsToIntPixels = Dips.dipsToIntPixels(100.0f, context);
        if (this.f.getClickType() == 1) {
            akVar.setOnTouchListener(this.i);
        }
        int sensitivity = this.f.getSensitivity();
        final int dipsToIntPixels2 = Dips.dipsToIntPixels(sensitivity == 10 ? 0 : (sensitivity <= 0 || sensitivity >= 10) ? 50 : (11 - sensitivity) * 10, com.sigmob.sdk.b.e());
        this.h.setOnTouchListener(new View.OnTouchListener() { // from class: com.sigmob.sdk.splash.h.10
            private MotionEvent c;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (h.this.f == null) {
                    return false;
                }
                if (motionEvent.getAction() == 0) {
                    this.c = MotionEvent.obtain(motionEvent);
                    h.this.j = false;
                } else {
                    if ((motionEvent.getAction() != 2 && motionEvent.getAction() != 1) || h.this.j) {
                        return true;
                    }
                    float x = motionEvent.getX();
                    float y = motionEvent.getY();
                    float abs = Math.abs(x - this.c.getX());
                    if (((float) Math.sqrt(Math.pow(Math.abs(y - this.c.getY()), 2.0d) + Math.pow(abs, 2.0d))) >= dipsToIntPixels2) {
                        h.this.j = true;
                        SigMacroCommon macroCommon = h.this.f.getMacroCommon();
                        if (macroCommon != null) {
                            macroCommon.updateClickMarco(this.c, motionEvent, false);
                        }
                        h.this.f();
                    }
                }
                return true;
            }
        });
        int dipsToIntPixels3 = Dips.dipsToIntPixels(145.0f, context);
        RelativeLayout.LayoutParams BTvldC2 = com.bykv.vk.component.ttvideo.player.A2egSU.BTvldC(dipsToIntPixels, dipsToIntPixels, 14, 12);
        BTvldC2.setMargins(0, 0, 0, dipsToIntPixels3);
        addView(akVar, BTvldC2);
    }

    private void n() {
        Context context = getContext();
        aa aaVar = new aa(context);
        aaVar.setButtonColor(this.f.getButtonColor());
        aaVar.a(this.f.getDesc(), null);
        int dipsToIntPixels = Dips.dipsToIntPixels(100.0f, context);
        aaVar.setOnTouchListener(this.i);
        int dipsToIntPixels2 = Dips.dipsToIntPixels(100.0f, context);
        RelativeLayout.LayoutParams BTvldC2 = com.bykv.vk.component.ttvideo.player.A2egSU.BTvldC(-1, dipsToIntPixels, 14, 12);
        BTvldC2.setMargins(0, 0, 0, dipsToIntPixels2);
        addView(aaVar, BTvldC2);
    }

    private void o() {
        Context context = getContext();
        ai aiVar = new ai(context);
        String title = this.f.getTitle();
        if (TextUtils.isEmpty(title)) {
            title = "点击查看详情";
        }
        aiVar.a(title, this.f.getDesc());
        int dipsToIntPixels = Dips.dipsToIntPixels(100.0f, context);
        int dipsToIntPixels2 = Dips.dipsToIntPixels(40.0f, context);
        aiVar.setOnTouchListener(this.i);
        int dipsToIntPixels3 = Dips.dipsToIntPixels(100.0f, context);
        RelativeLayout.LayoutParams BTvldC2 = com.bykv.vk.component.ttvideo.player.A2egSU.BTvldC(-1, dipsToIntPixels, 14, 12);
        BTvldC2.setMargins(dipsToIntPixels2, 0, dipsToIntPixels2, dipsToIntPixels3);
        addView(aiVar, BTvldC2);
    }

    private void p() {
        Context context = getContext();
        View iVar = new com.sigmob.sdk.base.views.i(context);
        int dipsToIntPixels = Dips.dipsToIntPixels(183.0f, context);
        int dipsToIntPixels2 = Dips.dipsToIntPixels(40.0f, context);
        addView(iVar, com.bykv.vk.component.ttvideo.player.A2egSU.BTvldC(-1, dipsToIntPixels, 14, 12));
        iVar.setOnTouchListener(this.i);
        String title = this.f.getTitle();
        if (TextUtils.isEmpty(title)) {
            title = "点击前往";
        }
        aq aqVar = new aq(context);
        aqVar.setTitle(title);
        aqVar.setDescription(this.f.getDesc());
        aqVar.setOnTouchListener(this.i);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        layoutParams.setMargins(0, 0, 0, dipsToIntPixels2);
        addView(aqVar, layoutParams);
    }

    private void q() {
        Context context = getContext();
        x xVar = new x(context);
        int dipsToIntPixels = Dips.dipsToIntPixels(20.0f, context);
        boolean z = this.f.getadPrivacy() != null;
        if (z) {
            xVar.setOnTouchListener(new View.OnTouchListener() { // from class: com.sigmob.sdk.splash.h.11
                private MotionEvent b;

                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (h.this.f == null) {
                        return false;
                    }
                    if (motionEvent.getAction() == 0) {
                        this.b = MotionEvent.obtain(motionEvent);
                    } else if (motionEvent.getAction() == 1) {
                        h.this.f.getClickCommon().click_area = "appinfo";
                        h.this.f.getClickCommon().click_scene = ClickCommon.CLICK_SCENE_AD;
                        com.sigmob.sdk.base.utils.c.a(h.f13672a, h.this.f);
                        if (this.b == null) {
                            this.b = motionEvent;
                        }
                        try {
                            h.this.f.getMacroCommon().updateClickMarco(this.b, motionEvent, false);
                        } catch (Throwable th) {
                            com.bykv.vk.component.ttvideo.player.A2egSU.BJ7GGh(th, new StringBuilder("splash click macro set "));
                        }
                        h.this.g.i();
                    }
                    return true;
                }
            });
        }
        xVar.a(this.f.getAd_source_logo(), z);
        xVar.setAlpha(0.5f);
        int dipsToIntPixels2 = Dips.dipsToIntPixels(5.0f, context);
        RelativeLayout.LayoutParams BTvldC2 = com.bykv.vk.component.ttvideo.player.A2egSU.BTvldC(-1, dipsToIntPixels, 14, 12);
        BTvldC2.setMargins(dipsToIntPixels2, 0, dipsToIntPixels2, dipsToIntPixels2);
        addView(xVar, BTvldC2);
    }

    private void r() {
        Context context = getContext();
        aw awVar = new aw(context);
        int dipsToIntPixels = Dips.dipsToIntPixels(100.0f, context);
        int dipsToIntPixels2 = Dips.dipsToIntPixels(145.0f, context);
        RelativeLayout.LayoutParams BTvldC2 = com.bykv.vk.component.ttvideo.player.A2egSU.BTvldC(dipsToIntPixels, dipsToIntPixels, 14, 12);
        BTvldC2.setMargins(0, 0, 0, dipsToIntPixels2);
        if (this.f.getClickType() == 1) {
            awVar.setOnTouchListener(this.i);
        }
        am.a aVar = new am.a(context, new AnonymousClass2(awVar), am.c.WRING);
        this.n = aVar;
        aVar.a(SensorEntity.format(this.f));
        this.n.a();
        addView(awVar, BTvldC2);
    }

    public void a() {
        super.setVisibility(8);
        b bVar = this.d;
        if (bVar != null) {
            bVar.setVisibility(8);
        }
    }

    public void d() {
        this.j = false;
        am.a aVar = this.n;
        if (aVar != null) {
            aVar.b();
        }
        this.d.b();
    }

    public void e() {
        am.a aVar = this.n;
        if (aVar != null) {
            aVar.a();
        }
        v vVar = this.o;
        if (vVar != null) {
            vVar.a();
        }
        this.d.c();
    }

    public int getDuration() {
        return this.d.getDuration();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f == null) {
            SigmobLog.e("adUnit is null");
            return;
        }
        a aVar = this.g;
        if (aVar == null) {
            return;
        }
        aVar.a(r.c(this), this.f, new q.b() { // from class: com.sigmob.sdk.splash.h.1
            @Override // com.sigmob.sdk.base.views.q.b
            public void a() {
                SigmobLog.d(h.f13672a + "#onCloseClick");
                h.this.k = false;
                h.this.j = false;
                if (h.this.l) {
                    h.this.a(true);
                } else if (h.this.n != null) {
                    h.this.n.a();
                }
            }

            @Override // com.sigmob.sdk.base.views.q.b
            public void b() {
                SigmobLog.d(h.f13672a + "#onShowSuccess");
                if (h.this.n != null) {
                    h.this.n.b();
                }
                h.this.k = true;
            }

            @Override // com.sigmob.sdk.base.views.q.b
            public void a(Error error) {
            }

            @Override // com.sigmob.sdk.base.views.q.b
            public void a(String str, String str2) {
                SigmobLog.d(h.f13672a + "#onCloseClick");
                if (h.this.f == null) {
                    return;
                }
                ClickCommon clickCommon = h.this.f.getClickCommon();
                clickCommon.click_scene = "appinfo";
                clickCommon.click_area = ClickCommon.CLICK_AREA_BTN;
                clickCommon.is_final_click = true;
                h.this.g();
                ah sessionManager = h.this.f.getSessionManager();
                if (sessionManager == null) {
                    return;
                }
                sessionManager.a("click", 0);
            }
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        am.a aVar = this.n;
        if (aVar != null) {
            aVar.c();
        }
        v vVar = this.o;
        if (vVar != null) {
            vVar.b();
        }
        removeAllViews();
    }

    public void setAspectRatio(float f) {
        this.q = f;
    }

    public void setDuration(int i) {
        if (this.f == null) {
            return;
        }
        if (i > 0 && com.sigmob.sdk.base.utils.q.b(this.m)) {
            this.m.a(i);
            return;
        }
        this.l = true;
        ae.a("complete", (String) null, this.f);
        if (com.sigmob.sdk.base.utils.q.b(Boolean.valueOf(this.k)) || this.p) {
            a(true);
        }
    }

    @Override // android.view.View
    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        b bVar = this.d;
        if (bVar == null) {
            return;
        }
        bVar.setOnTouchListener(onTouchListener);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        if (i == 0) {
            this.m.setVisibility(0);
            this.d.a();
            if (com.sigmob.sdk.base.utils.q.b(this.f)) {
                ah sessionManager = this.f.getSessionManager();
                if (com.sigmob.sdk.base.utils.q.b(sessionManager)) {
                    sessionManager.a("start", 0);
                }
            }
            super.setVisibility(i);
            return;
        }
        try {
            ae.a(PointCategory.SPLASHADBLOCK, WindAdError.ERROR_SPLASH_ADBLOCK.getErrorCode(), Preconditions.NoThrow.getLineInfo(), this.f);
            SigmobLog.e("debug " + Preconditions.NoThrow.getLineInfo());
        } catch (Throwable th) {
            SigmobLog.e(th.getMessage());
        }
    }

    private void a(Activity activity) {
        Context context = getContext();
        com.sigmob.sdk.videoplayer.c.c(activity);
        com.sigmob.sdk.videoplayer.c.f(activity);
        int dipsToIntPixels = Dips.dipsToIntPixels(12.0f, context);
        int dipsToIntPixels2 = Dips.dipsToIntPixels(68.0f, context);
        int dipsToIntPixels3 = Dips.dipsToIntPixels(25.0f, context);
        ag agVar = new ag(context);
        this.m = agVar;
        agVar.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dipsToIntPixels2, dipsToIntPixels3);
        layoutParams.addRule(11);
        this.m.setOnClickListener(new View.OnClickListener() { // from class: com.sigmob.sdk.splash.AMqCpz
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                h.this.a(view);
            }
        });
        layoutParams.setMargins(0, dipsToIntPixels * 3, dipsToIntPixels, 0);
        addView(this.m, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        SigmobLog.d("handleClick");
        if (this.f == null) {
            SigmobLog.e("adUnit is null");
            return;
        }
        this.j = true;
        if (com.sigmob.sdk.b.i() == null) {
            com.sigmob.sdk.b.a(r.c(this));
        }
        a(this.f);
    }

    private void h() {
        Context context = getContext();
        int dipsToIntPixels = Dips.dipsToIntPixels(10.0f, context);
        Dips.dipsToIntPixels(75.0f, context);
        int dipsToIntPixels2 = Dips.dipsToIntPixels(25.0f, context);
        TextView textView = new TextView(context);
        textView.setText("互动广告");
        textView.setTextSize(2, 12.0f);
        textView.setTextColor(Color.parseColor("#ccffffff"));
        textView.setGravity(17);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, dipsToIntPixels2);
        layoutParams.addRule(0, this.m.getId());
        layoutParams.addRule(6, this.m.getId());
        layoutParams.setMargins(0, 0, dipsToIntPixels, 0);
        addView(textView, layoutParams);
    }

    public void b() {
        super.setVisibility(4);
    }

    public boolean c() {
        BaseAdUnit baseAdUnit = this.f;
        if (baseAdUnit != null && baseAdUnit.getSplashFilePath() != null) {
            return this.d.a(this.f);
        }
        SigmobLog.e("adUnit or splashFilePath is null");
        return false;
    }

    private void a(Context context) {
        b a2 = b.a(context, this.f);
        this.d = a2;
        if (a2 == null) {
            return;
        }
        a2.setAspectRatio(this.q);
        this.c.addView(this.d, new RelativeLayout.LayoutParams(-1, -1));
        this.h = new RelativeLayout(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        int dipsToIntPixels = Dips.dipsToIntPixels(b, this.e);
        layoutParams.setMargins(dipsToIntPixels, (int) (dipsToIntPixels * 2.5d), dipsToIntPixels, dipsToIntPixels);
        this.h.setClickable(true);
        this.h.setOnTouchListener(new HFjH17.AMqCpz(3));
        this.c.addView(this.h, layoutParams);
        this.i = new View.OnTouchListener() { // from class: com.sigmob.sdk.splash.h.4
            private MotionEvent b;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (h.this.f == null) {
                    SigmobLog.e("adUnit is null");
                    return false;
                }
                if (motionEvent.getAction() == 0) {
                    this.b = MotionEvent.obtain(motionEvent);
                } else if (motionEvent.getAction() == 1) {
                    if (this.b == null) {
                        this.b = motionEvent;
                    }
                    try {
                        h.this.f.getClickCommon().sld = Constants.FAIL;
                        h.this.f.getClickCommon().click_area = ClickCommon.CLICK_AREA_COMPANION;
                        h.this.f.getClickCommon().click_scene = ClickCommon.CLICK_SCENE_AD;
                        h.this.f.getMacroCommon().updateClickMarco(this.b, motionEvent, false);
                    } catch (Throwable th) {
                        com.bykv.vk.component.ttvideo.player.A2egSU.BJ7GGh(th, new StringBuilder("splash click macro set "));
                    }
                    h.this.f();
                }
                return true;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        this.p = true;
        BaseAdUnit baseAdUnit = this.f;
        if (baseAdUnit == null) {
            return;
        }
        ah sessionManager = baseAdUnit.getSessionManager();
        if (sessionManager != null) {
            sessionManager.a("skip", 0);
        }
        BaseBroadcastReceiver.a(this.e, this.f.getUuid(), IntentActions.ACTION_SPLAH_SKIP);
    }

    private void a(BaseAdUnit baseAdUnit) {
        SigmobLog.d("handleUrlAction");
        if (baseAdUnit == null) {
            SigmobLog.e("adUnit is null");
        } else {
            new ao.a().a(an.IGNORE_ABOUT_SCHEME, an.DOWNLOAD_APK, an.MARKET_SCHEME, an.OPEN_WITH_BROWSER, an.FOLLOW_PACKAGE_NAME, an.FOLLOW_DEEP_LINK, an.MINI_PROGRAM).a(new AnonymousClass5(baseAdUnit)).a(baseAdUnit.isSkipSigmobBrowser()).a(baseAdUnit).b(baseAdUnit.getAd().forbiden_parse_landingpage.booleanValue()).a().a(com.sigmob.sdk.b.e(), null);
        }
    }

    private void a(String str, String str2) {
        Context context = getContext();
        aq aqVar = new aq(context);
        aqVar.setTitle(str);
        aqVar.setDescription(str2);
        int dipsToIntPixels = Dips.dipsToIntPixels(82.0f, context);
        if (this.f.getClickType() == 1) {
            aqVar.setOnTouchListener(this.i);
        }
        RelativeLayout.LayoutParams BTvldC2 = com.bykv.vk.component.ttvideo.player.A2egSU.BTvldC(-1, -2, 14, 12);
        BTvldC2.setMargins(0, 0, 0, dipsToIntPixels);
        addView(aqVar, BTvldC2);
    }

    public void a(boolean z) {
        if (z) {
            BaseBroadcastReceiver.a(this.e, this.f.getUuid(), IntentActions.ACTION_INTERSTITIAL_DISMISS);
            this.m.setOnClickListener(null);
            com.sigmob.sdk.base.common.h.b(this.f);
            this.f = null;
        }
        am.a aVar = this.n;
        if (aVar != null) {
            aVar.c();
            this.n = null;
        }
        v vVar = this.o;
        if (vVar != null) {
            vVar.b();
        }
        this.d.setOnTouchListener(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean a(View view, MotionEvent motionEvent) {
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0133 A[Catch: all -> 0x0043, TryCatch #0 {all -> 0x0043, blocks: (B:3:0x0003, B:6:0x0033, B:9:0x0046, B:10:0x012f, B:12:0x0133, B:13:0x0136, B:15:0x0063, B:16:0x0080, B:17:0x009d, B:20:0x00af, B:21:0x00cf, B:22:0x00d3, B:25:0x00e5, B:26:0x00ea, B:29:0x00fc, B:30:0x0101, B:33:0x0113, B:34:0x0118, B:37:0x012a), top: B:2:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean a(com.sigmob.sdk.base.models.BaseAdUnit r6, android.app.Activity r7) {
        /*
            Method dump skipped, instructions count: 342
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.splash.h.a(com.sigmob.sdk.base.models.BaseAdUnit, android.app.Activity):boolean");
    }
}
