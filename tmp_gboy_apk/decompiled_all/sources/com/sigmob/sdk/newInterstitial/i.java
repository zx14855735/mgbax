package com.sigmob.sdk.newInterstitial;

import ADYaiT.CtFAbx;
import Cd8JRx.ADYaiT;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.bytedance.android.live.base.api.push.model.PushUIConfig;
import com.czhj.sdk.common.utils.Dips;
import com.czhj.sdk.common.utils.ResourceUtil;
import com.czhj.sdk.common.utils.ViewUtil;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.common.ac;
import com.sigmob.sdk.base.common.ae;
import com.sigmob.sdk.base.common.ah;
import com.sigmob.sdk.base.common.k;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.ClickCommon;
import com.sigmob.sdk.base.models.IntentActions;
import com.sigmob.sdk.base.models.SigMacroCommon;
import com.sigmob.sdk.base.models.rtb.InterstitialSetting;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.base.utils.l;
import com.sigmob.sdk.base.views.q;
import com.sigmob.sdk.newInterstitial.NewInterstitialHeaderView;
import com.sigmob.sdk.newInterstitial.i;
import com.sigmob.windad.natives.WindNativeAdData;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class i extends com.sigmob.sdk.videoAd.b {
    public static final String f = "i";
    private boolean A;
    private boolean B;
    private l C;
    private com.sigmob.sdk.nativead.b D;
    private final View.OnClickListener E;
    private final BaseAdUnit g;
    private final Bundle h;
    private final com.sigmob.sdk.base.common.i i;
    private g j;
    private RelativeLayout k;
    private final List<String> l;
    private final List<String> m;
    private com.sigmob.sdk.videoplayer.a n;
    private h o;
    private InterstitialSetting p;
    private final boolean q;
    private NewInterstitialHeaderView r;
    private int s;
    private String t;
    private long u;
    private int v;
    private final Handler w;
    private boolean x;
    private boolean y;
    private q z;

    /* renamed from: com.sigmob.sdk.newInterstitial.i$8, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass8 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f13652a;

        static {
            int[] iArr = new int[com.sigmob.sdk.videoplayer.d.values().length];
            f13652a = iArr;
            try {
                iArr[com.sigmob.sdk.videoplayer.d.STATE_PREPARED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f13652a[com.sigmob.sdk.videoplayer.d.STATE_PLAYING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f13652a[com.sigmob.sdk.videoplayer.d.STATE_ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f13652a[com.sigmob.sdk.videoplayer.d.STATE_AUTO_COMPLETE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f13652a[com.sigmob.sdk.videoplayer.d.STATE_STOP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f13652a[com.sigmob.sdk.videoplayer.d.STATE_BUFFERING_START.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f13652a[com.sigmob.sdk.videoplayer.d.STATE_BUFFERING_END.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f13652a[com.sigmob.sdk.videoplayer.d.STATE_PAUSE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    public i(Activity activity, BaseAdUnit baseAdUnit, Bundle bundle, Bundle bundle2, String str, k kVar) {
        super(activity, str, kVar);
        this.l = new ArrayList();
        this.m = new ArrayList();
        this.w = new Handler(Looper.getMainLooper());
        this.E = new View.OnClickListener() { // from class: com.sigmob.sdk.newInterstitial.i.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Activity n = i.this.n();
                if (n == null || i.this.g == null) {
                    return;
                }
                i iVar = i.this;
                if (iVar.a(iVar.D)) {
                    return;
                }
                i.this.D = new com.sigmob.sdk.nativead.b(n, i.this.g);
                i.this.D.a();
                i.this.D.a(new WindNativeAdData.DislikeInteractionCallback() { // from class: com.sigmob.sdk.newInterstitial.i.7.1
                    @Override // com.sigmob.windad.natives.WindNativeAdData.DislikeInteractionCallback
                    public void onCancel() {
                        i.this.g();
                        i.this.E();
                    }

                    @Override // com.sigmob.windad.natives.WindNativeAdData.DislikeInteractionCallback
                    public void onSelected(int i, String str2, boolean z) {
                        i.this.g();
                        i.this.E();
                    }

                    @Override // com.sigmob.windad.natives.WindNativeAdData.DislikeInteractionCallback
                    public void onShow() {
                        i.this.f();
                    }
                });
            }
        };
        this.g = baseAdUnit;
        this.h = bundle;
        com.sigmob.sdk.base.common.i adConfig = baseAdUnit.getAdConfig();
        this.i = adConfig;
        adConfig.a(n(), baseAdUnit, new q.b() { // from class: com.sigmob.sdk.newInterstitial.i.1
            @Override // com.sigmob.sdk.base.views.q.b
            public void a() {
                i.this.A = false;
                i.this.z();
            }

            @Override // com.sigmob.sdk.base.views.q.b
            public void b() {
                i.this.A = true;
                i.this.A();
            }

            @Override // com.sigmob.sdk.base.views.q.b
            public void a(Error error) {
            }

            @Override // com.sigmob.sdk.base.views.q.b
            public void a(String str2, String str3) {
                i.this.g.getClickCommon().click_area = "appinfo";
                i.this.g.getClickCommon().is_final_click = true;
                i.this.r();
                ah a2 = i.this.a();
                if (a2 == null) {
                    return;
                }
                a2.a("click", 0);
            }
        });
        k().a(7);
        this.q = baseAdUnit.getTemplateType() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A() {
        G();
        com.sigmob.sdk.videoplayer.a aVar = this.n;
        if (aVar == null) {
            return;
        }
        aVar.j();
    }

    private void B() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.sigmob.sdk.videoAd.d(com.sigmob.sdk.base.common.a.k, 0.25f));
        arrayList.add(new com.sigmob.sdk.videoAd.d(com.sigmob.sdk.base.common.a.m, 0.5f));
        arrayList.add(new com.sigmob.sdk.videoAd.d(com.sigmob.sdk.base.common.a.n, 0.75f));
        this.i.a((List<com.sigmob.sdk.videoAd.d>) arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C() {
        RelativeLayout relativeLayout = this.k;
        if (relativeLayout == null || relativeLayout.getVisibility() == 0) {
            return;
        }
        this.u = System.currentTimeMillis();
        this.k.setVisibility(0);
        this.t = "loading";
        int i = this.v + 1;
        this.v = i;
        if (i > 2) {
            return;
        }
        this.w.postDelayed(new A2egSU(this, 1), PushUIConfig.dismissTime);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D() {
        RelativeLayout relativeLayout = this.k;
        if (relativeLayout != null && relativeLayout.getVisibility() == 0) {
            this.l.add(String.format(Locale.getDefault(), "%d", Long.valueOf(System.currentTimeMillis() - this.u)));
            this.m.add(String.format(Locale.getDefault(), "%.2f", Float.valueOf(((int) this.n.getCurrentPositionWhenPlaying()) / 1000.0f)));
            this.t = PointCategory.PLAY;
            this.w.removeCallbacksAndMessages(null);
            this.k.setVisibility(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E() {
        com.sigmob.sdk.nativead.b bVar = this.D;
        if (bVar == null) {
            return;
        }
        bVar.dismiss();
        this.D.b();
        this.D = null;
    }

    private void F() {
        if (this.y) {
            return;
        }
        com.sigmob.sdk.videoplayer.a aVar = this.n;
        if (aVar != null) {
            aVar.r();
            this.n = null;
        }
        this.y = true;
        if (this.o == null) {
            h hVar = new h(this.f13143a);
            this.o = hVar;
            hVar.a(this.E);
            Button cTAButton = this.o.getCTAButton();
            com.sigmob.sdk.base.a aVar2 = com.sigmob.sdk.base.a.ENDCARD;
            a(cTAButton, aVar2);
            this.o.a(this.g.getIconUrl(), this.g.getEndCardImageUrl(), this.g.getAppName(), this.g.getCreativeTitle(), this.g.getCTAText());
            SigAdPrivacyInfoView adPrivacyInfo = this.o.getAdPrivacyInfo();
            if (com.sigmob.sdk.base.utils.q.b(adPrivacyInfo)) {
                View privacyLl = adPrivacyInfo.getPrivacyLl();
                if (com.sigmob.sdk.base.utils.q.b(privacyLl)) {
                    privacyLl.setBackgroundColor(0);
                    a(adPrivacyInfo, aVar2);
                }
            }
            this.o.getCloseButton().setOnClickListener(new A4TApA(this, 0));
        }
        this.r.hideSoundIcon();
        ViewUtil.removeFromParent(this.j);
        m().addView(this.o, new ViewGroup.LayoutParams(-1, -1));
    }

    private void G() {
        l lVar = this.C;
        if (lVar == null) {
            return;
        }
        lVar.c();
    }

    private void H() {
        l lVar = this.C;
        if (lVar == null) {
            return;
        }
        lVar.d();
    }

    private void I() {
        l lVar = this.C;
        if (lVar == null) {
            return;
        }
        lVar.e();
        this.C = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void J() {
        this.w.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(View view) {
        s();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(View view) {
        boolean z = !this.x;
        this.x = z;
        this.r.setSoundStatus(z);
        com.sigmob.sdk.videoplayer.a aVar = this.n;
        if (aVar == null) {
            return;
        }
        aVar.setMute(this.x);
    }

    private void q() {
        Context context;
        String str;
        this.j = new g(this.f13143a);
        int screenHeightAsIntDips = Dips.screenHeightAsIntDips(this.f13143a);
        int screenWidthAsIntDips = Dips.screenWidthAsIntDips(this.f13143a);
        if (this.q) {
            context = this.f13143a;
            str = "sig_new_interstitial_full_layout";
        } else if (screenHeightAsIntDips * 0.8f <= 553.0f || screenWidthAsIntDips * 0.8f <= 287.0f) {
            context = this.f13143a;
            str = "sig_new_interstitial_small_layout";
        } else {
            context = this.f13143a;
            str = "sig_new_interstitial_layout";
        }
        this.j.a(ResourceUtil.getLayoutId(context, str));
        a(IntentActions.ACTION_INTERSTITIAL_VOPEN);
        ViewGroup mainAdContainer = this.j.getMainAdContainer();
        this.p = this.g.getNewInterstitialSetting();
        m().addView(this.j, new ViewGroup.LayoutParams(-1, -1));
        a(mainAdContainer);
        w();
        t();
        a(this.j.getCTAButton(), com.sigmob.sdk.base.a.AD);
        if (this.p == null) {
            return;
        }
        m().postDelayed(new A2egSU(this, 0), this.p.charge_time.intValue() * 1000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        com.sigmob.sdk.base.utils.c.a(f, this.g);
        a(IntentActions.ACTION_INTERSTITIAL_CLICK);
    }

    private void s() {
        k().a();
    }

    private void t() {
        NewInterstitialHeaderView headerView = this.j.getHeaderView();
        this.r = headerView;
        headerView.showFeedback(this.n != null, this.E);
        this.r.setAdHeaderViewStateListener(new NewInterstitialHeaderView.a() { // from class: com.sigmob.sdk.newInterstitial.i.3
            @Override // com.sigmob.sdk.newInterstitial.NewInterstitialHeaderView.a
            public void a() {
                i.this.v();
                ah a2 = i.this.a();
                if (a2 == null) {
                    return;
                }
                a2.a("show_close", 0);
            }

            @Override // com.sigmob.sdk.newInterstitial.NewInterstitialHeaderView.a
            public void b() {
                i.this.v();
                ah a2 = i.this.a();
                if (a2 == null) {
                    return;
                }
                a2.a("show_skip", 0);
            }
        });
        this.r.setSoundClickListener(new A4TApA(this, 1));
        this.r.setCloseClickListener(new A4TApA(this, 2));
        this.r.setSkipClickListener(new A4TApA(this, 3));
        InterstitialSetting interstitialSetting = this.p;
        if (interstitialSetting == null) {
            return;
        }
        this.r.startAdTimer(this.p.show_skip_seconds.intValue(), interstitialSetting.skip_close_ad.booleanValue() || !this.g.hasEndCard());
    }

    private void u() {
        ah a2 = a();
        if (com.sigmob.sdk.base.utils.q.b(a2)) {
            a2.a("skip", 0);
        }
        F();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        if (this.B) {
            return;
        }
        this.B = true;
        ah a2 = a();
        if (a2 == null) {
            return;
        }
        a2.a("charge", 0);
    }

    private void w() {
        SigAdInfoView adInfView = this.j.getAdInfView();
        if (adInfView == null) {
            return;
        }
        adInfView.setAppInfoView(this.g.getIconUrl(), this.g.getAppName(), this.g.getCreativeTitle());
        SigAdPrivacyInfoView adPrivacyInfo = adInfView.getAdPrivacyInfo();
        if (adPrivacyInfo == null) {
            return;
        }
        adPrivacyInfo.getPrivacyAdText().setTextColor(-1);
        a(adInfView.getAdPrivacyInfo(), com.sigmob.sdk.base.a.AD);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        q qVar = this.z;
        if (qVar == null) {
            return;
        }
        qVar.dismiss();
        this.z.c();
        this.z = null;
    }

    private com.sigmob.sdk.videoplayer.a y() {
        if (this.n == null) {
            com.sigmob.sdk.videoplayer.a aVar = new com.sigmob.sdk.videoplayer.a(l());
            this.n = aVar;
            aVar.setVideoPlayerStatusListener(new AnonymousClass6());
            B();
        }
        this.n.setUp(this.g.getProxyVideoUrl());
        return this.n;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        H();
        com.sigmob.sdk.videoplayer.a aVar = this.n;
        if (aVar == null) {
            return;
        }
        aVar.d();
    }

    @Override // com.sigmob.sdk.videoAd.b, com.sigmob.sdk.base.common.j
    public void e() {
        super.e();
        n().getWindow().addFlags(1024);
        b();
        b(n(), 7, this.h);
        q();
        ah a2 = a();
        if (a2 == null) {
            return;
        }
        a2.a("start", 0);
        a(IntentActions.ACTION_INTERSTITIAL_SHOW);
    }

    @Override // com.sigmob.sdk.base.common.j
    public void f() {
        if (this.A) {
            return;
        }
        A();
    }

    public void p() {
        D();
        F();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        u();
    }

    public ah a() {
        BaseAdUnit baseAdUnit = this.g;
        if (baseAdUnit == null) {
            return null;
        }
        ah sessionManager = baseAdUnit.getSessionManager();
        if (sessionManager != null) {
            return sessionManager;
        }
        c cVar = new c();
        cVar.a(this.g);
        return cVar;
    }

    @Override // com.sigmob.sdk.base.common.j
    public void g() {
        if (this.A) {
            return;
        }
        z();
    }

    @Override // com.sigmob.sdk.base.common.j
    public void h() {
        a(IntentActions.ACTION_INTERSTITIAL_DISMISS);
        I();
        com.sigmob.sdk.videoplayer.a aVar = this.n;
        if (aVar != null) {
            aVar.r();
            this.n = null;
        }
        x();
        E();
        this.g.destroy();
        super.h();
    }

    @Override // com.sigmob.sdk.base.common.j
    public void i() {
    }

    @Override // com.sigmob.sdk.base.common.j
    public void o() {
    }

    public void b(String str) {
        ah a2 = a();
        if (a2 == null) {
            return;
        }
        a2.a(str, (int) this.n.getCurrentPositionWhenPlaying());
    }

    public void a(int i, l.a aVar) {
        this.C = new l(i * 1000, 1000L);
        if (com.sigmob.sdk.base.utils.q.b(aVar)) {
            this.C.a(aVar);
        }
        this.C.a();
    }

    @Override // com.sigmob.sdk.base.common.j
    public void a(Configuration configuration) {
    }

    /* renamed from: com.sigmob.sdk.newInterstitial.i$6, reason: invalid class name */
    public class AnonymousClass6 implements com.sigmob.sdk.videoplayer.k {
        private boolean b;

        public AnonymousClass6() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(com.sigmob.sdk.videoplayer.d dVar) {
            SigmobLog.i("video player state change " + dVar);
            switch (AnonymousClass8.f13652a[dVar.ordinal()]) {
                case 1:
                    if (i.this.n != null) {
                        i iVar = i.this;
                        iVar.s = (int) iVar.n.getDuration();
                        if (i.this.s == 0) {
                            i iVar2 = i.this;
                            iVar2.s = iVar2.g.getDuration();
                        }
                        i.this.g.getVideoCommon().video_time = (int) (i.this.s / 1000.0f);
                    }
                    i.this.g.getVideoCommon().is_first = 1;
                    i.this.g.getVideoCommon().type = 1;
                    i.this.g.getVideoCommon().scene = 1;
                    i.this.g.getVideoCommon().is_auto_play = 1;
                    i.this.g.getVideoCommon().is_last = 0;
                    i.this.g.getVideoCommon().end_time = 0;
                    i iVar3 = i.this;
                    iVar3.x = iVar3.g.getIsMute() != 0;
                    if (i.this.n != null) {
                        i.this.n.setMute(i.this.x);
                        i.this.r.setSoundStatus(i.this.x);
                        i.this.r.showSoundIcon();
                        return;
                    }
                    return;
                case 2:
                    if (this.b) {
                        i.this.g.getVideoCommon().type = 2;
                    }
                    this.b = false;
                    if (i.this.a() != null) {
                        i.this.a().a("video_start", 0);
                    }
                    if (i.this.n != null) {
                        i.this.g.getVideoCommon().begin_time = (int) (i.this.n.getCurrentPositionWhenPlaying() / 1000.0f);
                        return;
                    }
                    return;
                case 3:
                    if (i.this.n != null) {
                        ae.a("video", i.this.n.getErrorCode(), i.this.n.getErrorMessage(), i.this.g);
                    }
                    i.this.p();
                    return;
                case 4:
                    if (i.this.a() != null) {
                        i.this.a().a("complete", 0);
                    }
                    if (!i.this.g.hasEndCard()) {
                        i.this.g.getVideoCommon().type = 3;
                        i.this.z();
                        return;
                    }
                    break;
                case 5:
                    break;
                case 6:
                    i.this.C();
                    i.this.A();
                    return;
                case 7:
                    i.this.D();
                    i.this.z();
                    return;
                case 8:
                    if (i.this.a() != null) {
                        i.this.a().a("video_pause", 0);
                    }
                    this.b = true;
                    return;
                default:
                    return;
            }
            i.this.p();
        }

        @Override // com.sigmob.sdk.videoplayer.k
        public void a(long j, long j2) {
            StringBuilder B2KMhB2 = CtFAbx.B2KMhB("position ", j, " duration ");
            B2KMhB2.append(j2);
            SigmobLog.d(B2KMhB2.toString());
            for (com.sigmob.sdk.videoAd.d dVar : i.this.i.a(j, i.this.s)) {
                i.this.b(dVar.getEvent());
                dVar.setTracked();
            }
            if (j > i.this.s) {
                i.this.p();
            }
        }

        @Override // com.sigmob.sdk.videoplayer.k
        public void a(final com.sigmob.sdk.videoplayer.d dVar) {
            if (i.this.n == null) {
                return;
            }
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.sigmob.sdk.newInterstitial.A5SV6n
                @Override // java.lang.Runnable
                public final void run() {
                    i.AnonymousClass6.this.b(dVar);
                }
            });
        }
    }

    @Override // com.sigmob.sdk.base.common.j
    public void a(Bundle bundle) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        s();
    }

    private void a(ViewGroup viewGroup) {
        int templateId = this.g.getTemplateId();
        if (templateId == 6001) {
            com.sigmob.sdk.videoplayer.a y = y();
            this.n = y;
            viewGroup.addView(y, new ViewGroup.LayoutParams(-1, -1));
            this.n.a();
            return;
        }
        if (templateId != 6002) {
            return;
        }
        ImageView imageView = new ImageView(this.f13143a);
        viewGroup.addView(imageView, new ViewGroup.LayoutParams(-1, -1));
        com.sigmob.sdk.base.common.h.a().load(this.g.getMainImage()).into(imageView);
    }

    private void a(Button button, final com.sigmob.sdk.base.a aVar) {
        button.setText(this.g.getCTAText());
        button.setOnTouchListener(new View.OnTouchListener() { // from class: com.sigmob.sdk.newInterstitial.i.2
            private MotionEvent c;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                String str;
                if (motionEvent.getAction() == 0) {
                    this.c = motionEvent;
                } else if (motionEvent.getAction() == 1) {
                    SigMacroCommon macroCommon = i.this.g.getMacroCommon();
                    if (macroCommon != null) {
                        macroCommon.updateClickMarco(this.c, motionEvent, false);
                        str = macroCommon.getCoordinate();
                    } else {
                        str = "";
                    }
                    i.this.g.getClickCommon().click_area = ClickCommon.CLICK_AREA_BTN;
                    i.this.g.getClickCommon().click_scene = aVar == com.sigmob.sdk.base.a.AD ? ClickCommon.CLICK_SCENE_AD : "endcard";
                    i.this.g.getClickCommon().is_final_click = i.this.g.noHasDownloadDialog();
                    i.this.g.getAdConfig().a(aVar, str, true);
                }
                return false;
            }
        });
        this.g.getAdConfig().a((ac) new ADYaiT(17, this));
    }

    private void a(SigAdPrivacyInfoView sigAdPrivacyInfoView, final com.sigmob.sdk.base.a aVar) {
        if (sigAdPrivacyInfoView == null) {
            return;
        }
        sigAdPrivacyInfoView.a(this.g.getAd_source_logo(), com.sigmob.sdk.base.utils.q.b(this.g.getadPrivacy()));
        sigAdPrivacyInfoView.setOnTouchListener(new View.OnTouchListener() { // from class: com.sigmob.sdk.newInterstitial.i.4
            private MotionEvent c;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                if (action == 0) {
                    this.c = motionEvent;
                } else if (action == 1) {
                    SigMacroCommon macroCommon = i.this.g.getMacroCommon();
                    if (com.sigmob.sdk.base.utils.q.b(macroCommon)) {
                        macroCommon.updateClickMarco(this.c, motionEvent, false);
                    }
                    i.this.a(aVar);
                }
                return true;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(boolean z, com.sigmob.sdk.base.a aVar) {
        if (this.g.getClickCommon().is_final_click) {
            r();
        }
        ah a2 = a();
        if (a2 == null) {
            return;
        }
        a2.a("click", 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(final com.sigmob.sdk.base.a aVar) {
        try {
            Activity n = n();
            if (this.z == null && n != null) {
                q qVar = new q(n(), this.g);
                this.z = qVar;
                qVar.a(new q.b() { // from class: com.sigmob.sdk.newInterstitial.i.5
                    @Override // com.sigmob.sdk.base.views.q.b
                    public void a() {
                        i.this.z();
                        i.this.x();
                        i.this.A = false;
                        ah a2 = i.this.a();
                        if (a2 == null) {
                            return;
                        }
                        a2.a(com.sigmob.sdk.base.common.a.g, 0);
                    }

                    @Override // com.sigmob.sdk.base.views.q.b
                    public void b() {
                        i.this.A();
                        ah a2 = i.this.a();
                        if (a2 == null) {
                            return;
                        }
                        a2.a(com.sigmob.sdk.base.common.a.f, 0);
                    }

                    @Override // com.sigmob.sdk.base.views.q.b
                    public void a(Error error) {
                    }

                    @Override // com.sigmob.sdk.base.views.q.b
                    public void a(String str, String str2) {
                        if (i.this.g == null) {
                            return;
                        }
                        i.this.g.getClickCommon().is_final_click = true;
                        i.this.g.getAdConfig().a(aVar, str, str2, true);
                    }
                });
            }
            q qVar2 = this.z;
            if (qVar2 == null || !qVar2.a() || this.A) {
                return false;
            }
            this.g.getClickCommon().click_area = "appinfo";
            this.g.getClickCommon().click_scene = aVar == com.sigmob.sdk.base.a.AD ? ClickCommon.CLICK_SCENE_AD : "endcard";
            this.g.getClickCommon().is_final_click = false;
            ah a2 = a();
            if (com.sigmob.sdk.base.utils.q.b(a2)) {
                a2.a("click", 0);
            }
            this.z.show();
            this.A = true;
            return true;
        } catch (Exception e) {
            SigmobLog.e("openFourElements fail:" + e.getMessage());
            return false;
        }
    }
}
