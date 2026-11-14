package com.sigmob.sdk.nativead;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.AlphaAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.common.Constants;
import com.czhj.sdk.common.utils.Dips;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.common.ah;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.ClickCommon;
import com.sigmob.sdk.base.models.IntentActions;
import com.sigmob.sdk.base.models.PlacementType;
import com.sigmob.sdk.base.mta.PointParamKey;
import com.sigmob.sdk.base.views.q;
import com.sigmob.sdk.mraid.b;
import com.sigmob.sdk.mraid.h;
import com.sigmob.windad.WindAdError;
import com.sigmob.windad.natives.WindNativeAdData;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class z extends com.sigmob.sdk.base.common.j {
    private static r g;
    public final long f;
    private ae h;
    private ae i;
    private RelativeLayout j;
    private FrameLayout k;
    private BaseAdUnit l;
    private e m;
    private com.sigmob.sdk.mraid.h n;
    private View o;
    private WindNativeAdData p;
    private APKStatusBroadcastReceiver q;
    private ImageView r;
    private com.sigmob.sdk.base.views.q s;
    private boolean t;
    private boolean u;

    public z(Activity activity, BaseAdUnit baseAdUnit, Bundle bundle, Bundle bundle2, String str, com.sigmob.sdk.base.common.k kVar) {
        super(activity, str, kVar);
        this.f = 300L;
        this.t = false;
        this.l = baseAdUnit;
        e eVar = (e) baseAdUnit.getAdConfig();
        this.m = eVar;
        eVar.a(n(), this.l, (q.b) null);
        this.h = (ae) bundle.getParcelable("attr");
        k().a(1);
        int a2 = com.sigmob.sdk.base.k.a();
        if (a2 == 0) {
            return;
        }
        n().getTheme().applyStyle(a2, true);
    }

    private int r() {
        DisplayMetrics displayMetrics = ClientMetadata.getInstance().getDisplayMetrics();
        return Math.min((int) (Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels) / this.l.getAdPercent()), Math.max(displayMetrics.heightPixels, displayMetrics.widthPixels) / 2);
    }

    private void s() {
        ImageView imageView = this.r;
        if (imageView == null) {
            return;
        }
        imageView.setVisibility(4);
    }

    private void t() {
        if (this.r == null) {
            a(n());
        }
        this.r.setVisibility(0);
    }

    private void u() {
        this.u = true;
        if (g == null) {
            k().a();
            return;
        }
        new af(this.k, this.i, this.h, 300L).a();
        this.j.setVisibility(8);
        this.k.postDelayed(new ARc23Z(7, this), 300L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v() {
        r rVar = g;
        if (rVar != null) {
            rVar.setUIStyle(j.PREVIEW);
        }
        k().a();
    }

    @Override // com.sigmob.sdk.base.common.j
    public void i() {
    }

    @Override // com.sigmob.sdk.base.common.j
    public void o() {
    }

    public View p() {
        if (this.n == null) {
            this.n = new com.sigmob.sdk.mraid.h(this.f13143a, this.l, PlacementType.INTERSTITIAL);
        }
        this.n.a(new h.a() { // from class: com.sigmob.sdk.nativead.z.2
            @Override // com.sigmob.sdk.mraid.h.a
            public void a() {
                SigmobLog.d("SigNativeAdLandViewController onEndCardShow()");
            }

            @Override // com.sigmob.sdk.mraid.h.a
            public void b() {
                SigmobLog.d("SigNativeAdLandViewController onShowSkipTime()");
            }

            @Override // com.sigmob.sdk.mraid.h.a
            public void c() {
                SigmobLog.d("SigNativeAdLandViewController onFeedBack()");
            }

            @Override // com.sigmob.sdk.mraid.h.a
            public void d() {
                SigmobLog.d("SigNativeAdLandViewController onExpand()");
            }

            @Override // com.sigmob.sdk.mraid.h.a
            public void e() {
                SigmobLog.i("SigNativeAdLandViewController onFailedToLoad()");
            }

            @Override // com.sigmob.sdk.mraid.h.a
            public void f() {
                SigmobLog.i("SigNativeAdLandViewController onUnload()");
            }

            @Override // com.sigmob.sdk.mraid.h.a
            public void g() {
                SigmobLog.i("SigNativeAdLandViewController onOpenFourElements()");
                if (z.this.s == null) {
                    z.this.s = new com.sigmob.sdk.base.views.q(z.this.n(), z.this.l);
                    z.this.s.a(new q.b() { // from class: com.sigmob.sdk.nativead.z.2.1
                        @Override // com.sigmob.sdk.base.views.q.b
                        public void a() {
                            if (z.this.s != null) {
                                z.this.s.dismiss();
                                z.this.s.c();
                                z.this.s = null;
                                z.this.t = false;
                            }
                            z.this.l.getClickCommon().click_scene = ClickCommon.CLICK_SCENE_TEMPLATE;
                            z.this.a().a(com.sigmob.sdk.base.common.a.g, 0);
                        }

                        @Override // com.sigmob.sdk.base.views.q.b
                        public void b() {
                            z.this.a().a(com.sigmob.sdk.base.common.a.f, 0);
                        }

                        @Override // com.sigmob.sdk.base.views.q.b
                        public void a(Error error) {
                        }

                        @Override // com.sigmob.sdk.base.views.q.b
                        public void a(String str, String str2) {
                            z.this.l.getClickCommon().click_area = ClickCommon.CLICK_AREA_BTN;
                            z.this.l.getClickCommon().click_scene = "appinfo";
                            z.this.l.getClickCommon().is_final_click = true;
                            if (z.this.m != null) {
                                z.this.m.a(com.sigmob.sdk.base.a.COMPANION, str, str2, true);
                                z.this.a(IntentActions.ACTION_NATIVE_TEMPLE_CLICK);
                            }
                        }
                    });
                }
                if (z.this.s == null || !z.this.s.a() || z.this.t) {
                    return;
                }
                z.this.l.getClickCommon().click_area = "appinfo";
                z.this.l.getClickCommon().is_final_click = false;
                z.this.a().a("click", 0);
                z.this.s.show();
                z.this.t = true;
            }

            @Override // com.sigmob.sdk.mraid.h.a
            public void h() {
                SigmobLog.i("SigNativeAdLandViewController onClose()");
                z.this.k().onBackPressed();
            }

            @Override // com.sigmob.sdk.mraid.h.a
            public void a(float f) {
                SigmobLog.d("SigNativeAdLandViewController onReward()");
            }

            @Override // com.sigmob.sdk.mraid.h.a
            public void b(float f) {
                SigmobLog.d("SigNativeAdLandViewController onSkip()");
            }

            @Override // com.sigmob.sdk.mraid.h.a
            public void a(int i, int i2, int i3, int i4, b.a aVar, boolean z) {
                SigmobLog.i("SigNativeAdLandViewController onResize()");
            }

            @Override // com.sigmob.sdk.mraid.h.a
            public void a(View view) {
                SigmobLog.d("SigNativeAdLandViewController onLoaded()");
            }

            @Override // com.sigmob.sdk.mraid.h.a
            public void a(WindAdError windAdError) {
                SigmobLog.i("SigNativeAdLandViewController onRenderProcessGone:" + windAdError.toString());
            }

            @Override // com.sigmob.sdk.mraid.h.a
            public void a(String str) {
                SigmobLog.i("SigNativeAdLandViewController onCompanionClick:" + str);
                boolean z = true;
                if (!TextUtils.isEmpty(str)) {
                    try {
                        z.this.l.getClickCommon().click_area = ClickCommon.CLICK_AREA_BTN;
                        z.this.l.getClickCommon().is_final_click = true;
                        JSONObject jSONObject = new JSONObject(str);
                        int optInt = jSONObject.optInt(PointParamKey.TYPE);
                        z.this.n.a(String.valueOf(jSONObject.optInt("x")), String.valueOf(jSONObject.optInt("y")));
                        if (optInt != 1) {
                            z.this.a().a("click", 0);
                        } else {
                            z = false;
                        }
                    } catch (Exception unused) {
                        z.this.n.a(Constants.FAIL, Constants.FAIL);
                        z.this.a().a("click", 0);
                    }
                }
                z.this.m.a(com.sigmob.sdk.base.a.COMPANION, z.this.n.a(), z);
                z.this.a(IntentActions.ACTION_NATIVE_TEMPLE_CLICK);
            }

            /* JADX WARN: Removed duplicated region for block: B:5:0x008f  */
            @Override // com.sigmob.sdk.mraid.h.a
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public void a(java.net.URI r9, int r10, java.lang.String r11) {
                /*
                    r8 = this;
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder
                    java.lang.String r1 = "SigNativeAdLandViewController  onOpen:"
                    r0.<init>(r1)
                    r0.append(r9)
                    java.lang.String r1 = "======"
                    r0.append(r1)
                    r0.append(r10)
                    java.lang.String r10 = "====="
                    r0.append(r10)
                    r0.append(r11)
                    java.lang.String r10 = r0.toString()
                    com.czhj.sdk.logger.SigmobLog.i(r10)
                    boolean r10 = android.text.TextUtils.isEmpty(r11)
                    r0 = 1
                    r1 = 0
                    if (r10 != 0) goto L8b
                    com.sigmob.sdk.nativead.z r10 = com.sigmob.sdk.nativead.z.this     // Catch: java.lang.Exception -> L86
                    com.sigmob.sdk.base.models.BaseAdUnit r10 = com.sigmob.sdk.nativead.z.g(r10)     // Catch: java.lang.Exception -> L86
                    com.sigmob.sdk.base.models.ClickCommon r10 = r10.getClickCommon()     // Catch: java.lang.Exception -> L86
                    java.lang.String r2 = "btn"
                    r10.click_area = r2     // Catch: java.lang.Exception -> L86
                    com.sigmob.sdk.nativead.z r10 = com.sigmob.sdk.nativead.z.this     // Catch: java.lang.Exception -> L86
                    com.sigmob.sdk.base.models.BaseAdUnit r10 = com.sigmob.sdk.nativead.z.g(r10)     // Catch: java.lang.Exception -> L86
                    com.sigmob.sdk.base.models.ClickCommon r10 = r10.getClickCommon()     // Catch: java.lang.Exception -> L86
                    r10.is_final_click = r0     // Catch: java.lang.Exception -> L86
                    org.json.JSONObject r10 = new org.json.JSONObject     // Catch: java.lang.Exception -> L86
                    r10.<init>(r11)     // Catch: java.lang.Exception -> L86
                    java.lang.String r11 = "type"
                    int r11 = r10.optInt(r11)     // Catch: java.lang.Exception -> L86
                    java.lang.String r2 = "x"
                    int r2 = r10.optInt(r2)     // Catch: java.lang.Exception -> L86
                    java.lang.String r3 = "y"
                    int r3 = r10.optInt(r3)     // Catch: java.lang.Exception -> L86
                    java.lang.String r4 = "disable_landing"
                    boolean r4 = r10.optBoolean(r4)     // Catch: java.lang.Exception -> L86
                    java.lang.String r5 = "feDisable"
                    boolean r10 = r10.optBoolean(r5)     // Catch: java.lang.Exception -> L82
                    r10 = r10 ^ r0
                    com.sigmob.sdk.nativead.z r5 = com.sigmob.sdk.nativead.z.this     // Catch: java.lang.Exception -> L7f
                    com.sigmob.sdk.mraid.h r5 = com.sigmob.sdk.nativead.z.k(r5)     // Catch: java.lang.Exception -> L7f
                    java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch: java.lang.Exception -> L7f
                    java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch: java.lang.Exception -> L7f
                    r5.a(r2, r3)     // Catch: java.lang.Exception -> L7f
                    if (r11 != r0) goto L7b
                    r0 = 0
                L7b:
                    r7 = r10
                    r6 = r0
                    r1 = r4
                    goto L8d
                L7f:
                    r1 = r4
                    goto L88
                L82:
                    r1 = r4
                L84:
                    r10 = 1
                    goto L88
                L86:
                    goto L84
                L88:
                    r7 = r10
                    r6 = 1
                    goto L8d
                L8b:
                    r6 = 1
                    r7 = 1
                L8d:
                    if (r1 != 0) goto Lb7
                    com.sigmob.sdk.nativead.z r10 = com.sigmob.sdk.nativead.z.this
                    com.sigmob.sdk.base.models.BaseAdUnit r10 = com.sigmob.sdk.nativead.z.g(r10)
                    java.lang.String r10 = r10.getLanding_page()
                    boolean r10 = android.text.TextUtils.isEmpty(r10)
                    if (r10 == 0) goto La0
                    goto Lb7
                La0:
                    com.sigmob.sdk.nativead.z r9 = com.sigmob.sdk.nativead.z.this
                    com.sigmob.sdk.nativead.e r2 = com.sigmob.sdk.nativead.z.h(r9)
                    com.sigmob.sdk.base.a r3 = com.sigmob.sdk.base.a.ENDCARD
                    com.sigmob.sdk.nativead.z r9 = com.sigmob.sdk.nativead.z.this
                    com.sigmob.sdk.mraid.h r9 = com.sigmob.sdk.nativead.z.k(r9)
                    java.lang.String r5 = r9.a()
                    r4 = 0
                Lb3:
                    r2.a(r3, r4, r5, r6, r7)
                    goto Lce
                Lb7:
                    com.sigmob.sdk.nativead.z r10 = com.sigmob.sdk.nativead.z.this
                    com.sigmob.sdk.nativead.e r2 = com.sigmob.sdk.nativead.z.h(r10)
                    com.sigmob.sdk.base.a r3 = com.sigmob.sdk.base.a.ENDCARD
                    java.lang.String r4 = r9.toString()
                    com.sigmob.sdk.nativead.z r9 = com.sigmob.sdk.nativead.z.this
                    com.sigmob.sdk.mraid.h r9 = com.sigmob.sdk.nativead.z.k(r9)
                    java.lang.String r5 = r9.a()
                    goto Lb3
                Lce:
                    com.sigmob.sdk.nativead.z r9 = com.sigmob.sdk.nativead.z.this
                    java.lang.String r10 = "action.native.temple.click"
                    com.sigmob.sdk.nativead.z.c(r9, r10)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.nativead.z.AnonymousClass2.a(java.net.URI, int, java.lang.String):void");
            }

            @Override // com.sigmob.sdk.mraid.h.a
            public void a(boolean z) {
                SigmobLog.d("SigNativeAdLandViewController onMute()");
            }
        });
        if (!TextUtils.isEmpty(this.l.getHtmlUrl())) {
            this.n.b(this.l.getHtmlUrl(), new com.fl.saas.base.manager.loader.ADYaiT(22));
        } else if (!TextUtils.isEmpty(this.l.getHtmlData())) {
            this.n.a(this.l.getHtmlData(), new com.fl.saas.base.manager.loader.ADYaiT(23));
        }
        this.n.a(new AMqCpz(this));
        return this.n.q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        k().onBackPressed();
    }

    public ah a() {
        ah sessionManager = this.l.getSessionManager();
        if (sessionManager != null) {
            return sessionManager;
        }
        i iVar = new i();
        iVar.a(this.l);
        return iVar;
    }

    @Override // com.sigmob.sdk.base.common.j
    public void e() {
        m().removeAllViews();
        k().onSetContentView(m());
        this.l.getClickCommon().click_scene = ClickCommon.CLICK_SCENE_TEMPLATE;
        RelativeLayout relativeLayout = new RelativeLayout(l());
        this.j = relativeLayout;
        relativeLayout.setBackgroundColor(-1);
        this.o = p();
        com.sigmob.sdk.mraid.h hVar = this.n;
        if (hVar != null) {
            hVar.a(n());
        }
        this.j.addView(this.o, new RelativeLayout.LayoutParams(-1, -1));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        r rVar = g;
        if (rVar != null) {
            WindNativeAdData nativeAdUnit = rVar.getNativeAdUnit();
            this.p = nativeAdUnit;
            if (nativeAdUnit != null) {
                layoutParams.setMargins(0, r(), 0, 0);
            }
        }
        m().addView(this.j, layoutParams);
        if (g != null) {
            this.k = new FrameLayout(n());
            g.setBackClickListener(new AZkASS(this, 0));
            m().addView(this.k, new RelativeLayout.LayoutParams(-1, r()));
            g.getSigVideoAdController().c();
            this.k.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: com.sigmob.sdk.nativead.z.1
                @Override // android.view.ViewTreeObserver.OnPreDrawListener
                public boolean onPreDraw() {
                    if (z.g == null || z.this.k == null) {
                        return false;
                    }
                    z.this.k.getViewTreeObserver().removeOnPreDrawListener(this);
                    z.g.setUIStyle(j.DETAIL_PAGE);
                    ViewGroup videoContainer = z.g.getVideoContainer();
                    if (videoContainer != null) {
                        com.sigmob.sdk.base.utils.r.a(videoContainer);
                        z.this.k.addView(videoContainer, new FrameLayout.LayoutParams(-1, -1));
                    }
                    z.this.i = new ae();
                    int[] iArr = new int[2];
                    z.this.k.getLocationOnScreen(iArr);
                    z.this.i.a(iArr[0]);
                    z.this.i.b(0);
                    z.this.i.c(z.this.k.getMeasuredWidth());
                    z.this.i.d(z.this.k.getMeasuredHeight());
                    new af(z.this.k, z.this.h, z.this.i, 300L).a();
                    z.this.h.b(z.this.h.b() - iArr[1]);
                    if (z.this.j != null) {
                        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                        alphaAnimation.setDuration(300L);
                        z.this.j.setAnimation(alphaAnimation);
                        alphaAnimation.start();
                    }
                    return true;
                }
            });
        }
        a(IntentActions.ACTION_NATIVE_TEMPLIE_SHOW, 100);
    }

    @Override // com.sigmob.sdk.base.common.j
    public void f() {
        t sigVideoAdController;
        r rVar = g;
        if (rVar == null || this.u || (sigVideoAdController = rVar.getSigVideoAdController()) == null) {
            return;
        }
        sigVideoAdController.a();
    }

    @Override // com.sigmob.sdk.base.common.j
    public void g() {
        t sigVideoAdController;
        r rVar = g;
        if (rVar != null && (sigVideoAdController = rVar.getSigVideoAdController()) != null) {
            sigVideoAdController.c();
        }
        com.sigmob.sdk.mraid.h hVar = this.n;
        if (hVar != null) {
            hVar.c();
        }
    }

    @Override // com.sigmob.sdk.base.common.j
    public void h() {
        APKStatusBroadcastReceiver aPKStatusBroadcastReceiver = this.q;
        if (aPKStatusBroadcastReceiver != null) {
            aPKStatusBroadcastReceiver.b(aPKStatusBroadcastReceiver);
            this.q = null;
        }
        com.sigmob.sdk.base.views.q qVar = this.s;
        if (qVar != null) {
            qVar.dismiss();
            this.s.c();
            this.s = null;
        }
        com.sigmob.sdk.mraid.h hVar = this.n;
        if (hVar != null) {
            hVar.m();
            this.n = null;
        }
        r rVar = g;
        if (rVar != null) {
            rVar.setBackClickListener(null);
            g = null;
        }
        a(IntentActions.ACTION_NATIVE_TEMPLE_DISMISS);
        super.h();
    }

    @Override // com.sigmob.sdk.base.common.j
    public boolean j() {
        r rVar = g;
        if (rVar != null && rVar.b()) {
            return false;
        }
        u();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(com.sigmob.sdk.mraid.v vVar, com.sigmob.sdk.base.common.u uVar) {
    }

    private void a(Context context) {
        if (this.r != null) {
            return;
        }
        ImageView imageView = new ImageView(context);
        this.r = imageView;
        imageView.setImageBitmap(com.sigmob.sdk.base.views.s.CLOSE.a());
        this.r.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.r.setImageAlpha(127);
        this.r.setClickable(true);
        this.r.setOnClickListener(new AZkASS(this, 1));
        int dipsToIntPixels = Dips.dipsToIntPixels(20.0f, this.f13143a);
        RelativeLayout.LayoutParams BTvldC2 = com.bykv.vk.component.ttvideo.player.A2egSU.BTvldC(dipsToIntPixels, dipsToIntPixels, 10, 9);
        int i = dipsToIntPixels / 2;
        BTvldC2.setMargins(i, i, 0, 0);
        RelativeLayout relativeLayout = this.j;
        if (relativeLayout != null) {
            relativeLayout.addView(this.r, BTvldC2);
        }
    }

    @Override // com.sigmob.sdk.base.common.j
    public void a(Configuration configuration) {
    }

    @Override // com.sigmob.sdk.base.common.j
    public void a(Bundle bundle) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        k().onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(com.sigmob.sdk.mraid.v vVar, com.sigmob.sdk.base.common.u uVar) {
    }

    public static void a(m mVar) {
        if (mVar instanceof r) {
            g = (r) mVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(boolean z) {
        if (z) {
            s();
        } else if (g == null) {
            t();
        }
    }
}
