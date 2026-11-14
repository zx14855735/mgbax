package com.sigmob.sdk.mraid;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowInsets;
import android.webkit.ConsoleMessage;
import android.webkit.JsResult;
import android.webkit.ValueCallback;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.common.Constants;
import com.czhj.sdk.common.utils.Dips;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.common.ac;
import com.sigmob.sdk.base.common.ae;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.ClickCommon;
import com.sigmob.sdk.base.models.IntentActions;
import com.sigmob.sdk.base.models.LoadAdRequest;
import com.sigmob.sdk.base.models.PlacementType;
import com.sigmob.sdk.base.mta.PointParamKey;
import com.sigmob.sdk.base.views.ar;
import com.sigmob.sdk.base.views.q;
import com.sigmob.sdk.mraid.b;
import com.sigmob.sdk.mraid.h;
import com.sigmob.sdk.mraid.z;
import com.sigmob.windad.WindAdError;
import com.sigmob.windad.WindAdRequest;
import com.sigmob.windad.natives.WindNativeAdData;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class s extends com.sigmob.sdk.videoAd.b implements ac {
    public static final String f = "s";
    protected com.sigmob.sdk.base.common.u g;
    private final Bundle h;
    private int i;
    private final com.sigmob.sdk.videoAd.a j;
    private int k;
    private boolean l;
    private final BaseAdUnit m;
    private h n;
    private x o;
    private ar p;
    private int q;
    private boolean r;
    private boolean s;
    private boolean t;
    private com.sigmob.sdk.base.views.q u;
    private boolean v;
    private com.sigmob.sdk.nativead.b w;
    private com.sigmob.sdk.base.views.w x;
    private JSONObject y;
    private final View.OnClickListener z;

    /* renamed from: com.sigmob.sdk.mraid.s$3, reason: invalid class name */
    public class AnonymousClass3 implements h.a {
        public AnonymousClass3() {
        }

        @Override // com.sigmob.sdk.mraid.h.a
        public void a() {
            s.this.b("show");
        }

        @Override // com.sigmob.sdk.mraid.h.a
        public void b() {
            s.this.b("show_skip");
        }

        @Override // com.sigmob.sdk.mraid.h.a
        public void c() {
            Activity n = s.this.n();
            if (n == null || s.this.m == null) {
                return;
            }
            s sVar = s.this;
            if (sVar.a(sVar.w)) {
                return;
            }
            s.this.w = new com.sigmob.sdk.nativead.b(n, s.this.m);
            s.this.w.a();
            s.this.w.a(new WindNativeAdData.DislikeInteractionCallback() { // from class: com.sigmob.sdk.mraid.s.3.1
                @Override // com.sigmob.windad.natives.WindNativeAdData.DislikeInteractionCallback
                public void onCancel() {
                    s.this.c("feedbackDidDisappear");
                    s.this.s();
                }

                @Override // com.sigmob.windad.natives.WindNativeAdData.DislikeInteractionCallback
                public void onSelected(int i, String str, boolean z) {
                    s.this.c("feedbackDidDisappear");
                    s.this.s();
                }

                @Override // com.sigmob.windad.natives.WindNativeAdData.DislikeInteractionCallback
                public void onShow() {
                    s.this.c("feedbackDidAppear");
                }
            });
        }

        @Override // com.sigmob.sdk.mraid.h.a
        public void d() {
        }

        @Override // com.sigmob.sdk.mraid.h.a
        public void e() {
            SigmobLog.d("MraidActivity failed to load. Finishing the activity");
            if (((com.sigmob.sdk.base.common.j) s.this).b != null) {
                s.this.a(IntentActions.ACTION_INTERSTITIAL_FAIL);
            }
            ((com.sigmob.sdk.base.common.j) s.this).d.a();
        }

        @Override // com.sigmob.sdk.mraid.h.a
        public void f() {
        }

        @Override // com.sigmob.sdk.mraid.h.a
        public void g() {
            if (s.this.u == null) {
                s.this.u = new com.sigmob.sdk.base.views.q(s.this.n(), s.this.m);
                s.this.u.a(new q.b() { // from class: com.sigmob.sdk.mraid.s.3.2
                    @Override // com.sigmob.sdk.base.views.q.b
                    public void a() {
                        s.this.p();
                        com.sigmob.sdk.base.common.u uVar = s.this.g;
                        if (uVar != null) {
                            uVar.a(com.sigmob.sdk.base.common.a.g, 0);
                        }
                        s.this.c("fourElementsDidDisappear");
                    }

                    @Override // com.sigmob.sdk.base.views.q.b
                    public void b() {
                        com.sigmob.sdk.base.common.u uVar = s.this.g;
                        if (uVar != null) {
                            uVar.a(com.sigmob.sdk.base.common.a.f, 0);
                        }
                        s.this.c("fourElementsDidAppear");
                    }

                    @Override // com.sigmob.sdk.base.views.q.b
                    public void a(Error error) {
                    }

                    @Override // com.sigmob.sdk.base.views.q.b
                    public void a(String str, String str2) {
                        if (s.this.j == null) {
                            return;
                        }
                        s.this.j.a(com.sigmob.sdk.base.a.ENDCARD, str, str2, true);
                    }
                });
            }
            if (s.this.u == null || !s.this.u.a() || s.this.v) {
                return;
            }
            s.this.u.show();
            s.this.v = true;
        }

        @Override // com.sigmob.sdk.mraid.h.a
        public void h() {
            s.this.n.a(new AMqCpz(0, this));
            s.this.a(IntentActions.ACTION_REWARDED_VIDEO_CLOSE);
            s.this.s = true;
            ((com.sigmob.sdk.base.common.j) s.this).d.a();
        }

        @Override // com.sigmob.sdk.mraid.h.a
        public void a(float f) {
            s.this.l = true;
            s.this.b("reward");
            s.this.a(IntentActions.ACTION_REWARDED_VIDEO_COMPLETE);
        }

        @Override // com.sigmob.sdk.mraid.h.a
        public void b(float f) {
            if (s.this.r) {
                return;
            }
            s.this.r = true;
            s.this.b("skip");
            s.this.a(IntentActions.ACTION_REWARDED_VIDEO_SKIP);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(String str) {
            if (c.a(str) == null || s.this.g == null) {
                return;
            }
            float parseFloat = Float.parseFloat(str);
            if (parseFloat < 0.999f && !s.this.r) {
                s.this.r = true;
                s.this.b("skip");
            }
            if (s.this.l || s.this.m.getAd_type() == 4 || parseFloat <= s.this.m.getFinishedTime()) {
                return;
            }
            s.this.l = true;
            s sVar = s.this;
            sVar.g.a("reward", sVar.n.f().intValue());
            s.this.a(IntentActions.ACTION_REWARDED_VIDEO_COMPLETE);
        }

        @Override // com.sigmob.sdk.mraid.h.a
        public void a(int i, int i2, int i3, int i4, b.a aVar, boolean z) {
        }

        @Override // com.sigmob.sdk.mraid.h.a
        public void a(View view) {
            s.this.b("start");
            s.this.a(IntentActions.ACTION_INTERSTITIAL_SHOW);
            SigmobLog.d("onLoaded() called");
        }

        @Override // com.sigmob.sdk.mraid.h.a
        public void a(WindAdError windAdError) {
            SigmobLog.d("Finishing the activity due to a problem: " + windAdError);
            s.this.b("error");
            if (((com.sigmob.sdk.base.common.j) s.this).b != null) {
                s.this.a(IntentActions.ACTION_INTERSTITIAL_FAIL);
            }
            ((com.sigmob.sdk.base.common.j) s.this).d.a();
        }

        @Override // com.sigmob.sdk.mraid.h.a
        public void a(String str) {
            boolean z = true;
            if (!TextUtils.isEmpty(str)) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    int optInt = jSONObject.optInt(PointParamKey.TYPE);
                    if (jSONObject.has("x") && jSONObject.has("y")) {
                        s.this.n.a(String.valueOf(jSONObject.optInt("x")), String.valueOf(jSONObject.optInt("y")));
                    }
                    if (optInt != 1) {
                        s.this.y = jSONObject.optJSONObject("log_data");
                    } else {
                        z = false;
                    }
                } catch (Exception unused) {
                    s.this.n.a(Constants.FAIL, Constants.FAIL);
                }
            }
            s.this.j.a(com.sigmob.sdk.base.a.COMPANION, s.this.n.a(), z);
        }

        /* JADX WARN: Removed duplicated region for block: B:5:0x0075  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x008f  */
        @Override // com.sigmob.sdk.mraid.h.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void a(java.net.URI r13, int r14, java.lang.String r15) {
            /*
                r12 = this;
                java.lang.String r14 = "y"
                java.lang.String r0 = "x"
                boolean r1 = android.text.TextUtils.isEmpty(r15)
                r2 = 1
                r3 = 0
                r4 = 0
                if (r1 != 0) goto L70
                org.json.JSONObject r1 = new org.json.JSONObject     // Catch: java.lang.Exception -> L6a
                r1.<init>(r15)     // Catch: java.lang.Exception -> L6a
                java.lang.String r15 = "type"
                int r15 = r1.optInt(r15)     // Catch: java.lang.Exception -> L3e
                boolean r4 = r1.has(r0)     // Catch: java.lang.Exception -> L3e
                if (r4 == 0) goto L42
                boolean r4 = r1.has(r14)     // Catch: java.lang.Exception -> L3e
                if (r4 == 0) goto L42
                int r0 = r1.optInt(r0)     // Catch: java.lang.Exception -> L3e
                int r14 = r1.optInt(r14)     // Catch: java.lang.Exception -> L3e
                com.sigmob.sdk.mraid.s r4 = com.sigmob.sdk.mraid.s.this     // Catch: java.lang.Exception -> L3e
                com.sigmob.sdk.mraid.h r4 = com.sigmob.sdk.mraid.s.b(r4)     // Catch: java.lang.Exception -> L3e
                java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch: java.lang.Exception -> L3e
                java.lang.String r14 = java.lang.String.valueOf(r14)     // Catch: java.lang.Exception -> L3e
                r4.a(r0, r14)     // Catch: java.lang.Exception -> L3e
                goto L42
            L3e:
            L3f:
                r4 = r1
            L40:
                r0 = 1
                goto L6c
            L42:
                java.lang.String r14 = "disable_landing"
                boolean r14 = r1.optBoolean(r14)     // Catch: java.lang.Exception -> L3e
                java.lang.String r0 = "feDisable"
                boolean r0 = r1.optBoolean(r0)     // Catch: java.lang.Exception -> L67
                r0 = r0 ^ r2
                if (r15 == r2) goto L61
                com.sigmob.sdk.mraid.s r15 = com.sigmob.sdk.mraid.s.this     // Catch: java.lang.Exception -> L5d
                java.lang.String r3 = "log_data"
                org.json.JSONObject r3 = r1.optJSONObject(r3)     // Catch: java.lang.Exception -> L5d
                com.sigmob.sdk.mraid.s.a(r15, r3)     // Catch: java.lang.Exception -> L5d
                goto L62
            L5d:
                r3 = r14
                r4 = r1
                goto L6c
            L61:
                r2 = 0
            L62:
                r3 = r14
                r10 = r0
                r11 = r1
                r9 = r2
                goto L73
            L67:
                r3 = r14
                goto L3f
            L6a:
                goto L40
            L6c:
                r10 = r0
                r11 = r4
                r9 = 1
                goto L73
            L70:
                r11 = r4
                r9 = 1
                r10 = 1
            L73:
                if (r3 == 0) goto L8f
                com.sigmob.sdk.mraid.s r14 = com.sigmob.sdk.mraid.s.this
                com.sigmob.sdk.videoAd.a r5 = com.sigmob.sdk.mraid.s.c(r14)
                com.sigmob.sdk.base.a r6 = com.sigmob.sdk.base.a.ENDCARD
                java.lang.String r7 = r13.toString()
                com.sigmob.sdk.mraid.s r13 = com.sigmob.sdk.mraid.s.this
                com.sigmob.sdk.mraid.h r13 = com.sigmob.sdk.mraid.s.b(r13)
                java.lang.String r8 = r13.a()
                r5.a(r6, r7, r8, r9, r10, r11)
                goto La5
            L8f:
                com.sigmob.sdk.mraid.s r13 = com.sigmob.sdk.mraid.s.this
                com.sigmob.sdk.videoAd.a r5 = com.sigmob.sdk.mraid.s.c(r13)
                com.sigmob.sdk.base.a r6 = com.sigmob.sdk.base.a.ENDCARD
                com.sigmob.sdk.mraid.s r13 = com.sigmob.sdk.mraid.s.this
                com.sigmob.sdk.mraid.h r13 = com.sigmob.sdk.mraid.s.b(r13)
                java.lang.String r8 = r13.a()
                r7 = 0
                r5.a(r6, r7, r8, r9, r10)
            La5:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.mraid.s.AnonymousClass3.a(java.net.URI, int, java.lang.String):void");
        }

        @Override // com.sigmob.sdk.mraid.h.a
        public void a(boolean z) {
            s sVar;
            String str;
            if (z) {
                sVar = s.this;
                str = com.sigmob.sdk.base.common.a.z;
            } else {
                sVar = s.this;
                str = com.sigmob.sdk.base.common.a.A;
            }
            sVar.b(str);
        }
    }

    /* renamed from: com.sigmob.sdk.mraid.s$7, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass7 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f13497a;
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
            int[] iArr2 = new int[ConsoleMessage.MessageLevel.values().length];
            f13497a = iArr2;
            try {
                iArr2[ConsoleMessage.MessageLevel.ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public s(Activity activity, BaseAdUnit baseAdUnit, Bundle bundle, Bundle bundle2, String str, com.sigmob.sdk.base.common.k kVar) {
        super(activity, str, kVar);
        this.s = false;
        this.t = false;
        this.v = false;
        this.z = new View.OnClickListener() { // from class: com.sigmob.sdk.mraid.s.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Activity n = s.this.n();
                if (n == null || s.this.m == null) {
                    return;
                }
                s sVar = s.this;
                if (sVar.a(sVar.w)) {
                    return;
                }
                s.this.w = new com.sigmob.sdk.nativead.b(n, s.this.m);
                s.this.w.a();
                s.this.w.a(new WindNativeAdData.DislikeInteractionCallback() { // from class: com.sigmob.sdk.mraid.s.5.1
                    @Override // com.sigmob.windad.natives.WindNativeAdData.DislikeInteractionCallback
                    public void onCancel() {
                        s.this.s();
                    }

                    @Override // com.sigmob.windad.natives.WindNativeAdData.DislikeInteractionCallback
                    public void onSelected(int i, String str2, boolean z) {
                        s.this.s();
                    }

                    @Override // com.sigmob.windad.natives.WindNativeAdData.DislikeInteractionCallback
                    public void onShow() {
                    }
                });
            }
        };
        this.m = baseAdUnit;
        this.h = bundle;
        com.sigmob.sdk.videoAd.a aVar = (com.sigmob.sdk.videoAd.a) baseAdUnit.getAdConfig();
        this.j = aVar;
        aVar.a(n(), baseAdUnit, new q.b() { // from class: com.sigmob.sdk.mraid.s.1
            @Override // com.sigmob.sdk.base.views.q.b
            public void a() {
                s.this.c("fourElementsDidDisappear");
            }

            @Override // com.sigmob.sdk.base.views.q.b
            public void b() {
                s.this.c("fourElementsDidAppear");
            }

            @Override // com.sigmob.sdk.base.views.q.b
            public void a(Error error) {
            }

            @Override // com.sigmob.sdk.base.views.q.b
            public void a(String str2, String str3) {
                ClickCommon clickCommon = s.this.m.getClickCommon();
                clickCommon.click_area = ClickCommon.CLICK_AREA_BTN;
                clickCommon.click_scene = "appinfo";
                clickCommon.is_final_click = true;
            }
        });
        aVar.a((ac) this);
        this.k = ClientMetadata.getInstance().getInsetBottom();
        m().setBackgroundColor(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        com.sigmob.sdk.base.views.q qVar = this.u;
        if (qVar == null) {
            return;
        }
        qVar.dismiss();
        this.u.c();
        this.u = null;
        this.v = false;
    }

    private void q() {
        ar arVar = this.p;
        if (arVar != null) {
            arVar.setVisibility(4);
        }
        com.sigmob.sdk.base.views.w wVar = this.x;
        if (wVar != null) {
            wVar.setVisibility(4);
        }
    }

    private void r() {
        if (this.p == null) {
            a(this.f13143a, 0);
        }
        this.p.setVisibility(0);
        b(l(), 0);
    }

    @Override // com.sigmob.sdk.base.common.j
    public boolean j() {
        return false;
    }

    @Override // com.sigmob.sdk.base.common.ac
    public void onAdClick(boolean z, com.sigmob.sdk.base.a aVar) {
        com.sigmob.sdk.base.a aVar2;
        String str;
        com.sigmob.sdk.base.utils.c.a(f, this.m);
        a(IntentActions.ACTION_INTERSTITIAL_CLICK);
        if (z) {
            int i = AnonymousClass7.b[aVar.ordinal()];
            if (i == 1) {
                aVar2 = com.sigmob.sdk.base.a.COMPANION;
                str = com.sigmob.sdk.base.common.a.s;
            } else if (i != 2) {
                aVar2 = com.sigmob.sdk.base.a.ENDCARD;
                str = "click";
            } else {
                aVar2 = com.sigmob.sdk.base.a.VIDEO_CLICK;
                str = com.sigmob.sdk.base.common.a.t;
            }
            a(aVar2, str);
        }
        this.y = null;
    }

    private void b(Context context, int i) {
        if (this.x == null) {
            com.sigmob.sdk.base.views.w wVar = new com.sigmob.sdk.base.views.w(context);
            this.x = wVar;
            wVar.setText("反馈");
            this.x.setOnClickListener(this.z);
            this.x.setId(ClientMetadata.generateViewId());
            int dipsToIntPixels = Dips.dipsToIntPixels(3.0f, this.f13143a);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(Dips.dipsToIntPixels(45.0f, context), Dips.dipsToIntPixels(30.0f, context));
            layoutParams.addRule(0, this.p.getId());
            layoutParams.addRule(6, this.p.getId());
            layoutParams.setMargins(0, -dipsToIntPixels, 0, 0);
            m().addView(this.x, layoutParams);
        }
        com.sigmob.sdk.base.views.w wVar2 = this.x;
        if (wVar2 != null) {
            wVar2.setVisibility(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        com.sigmob.sdk.nativead.b bVar = this.w;
        if (bVar == null) {
            return;
        }
        bVar.dismiss();
        this.w.b();
        this.w = null;
    }

    public View a() {
        String str = this.b;
        z.a a2 = str != null ? z.a(str) : null;
        this.n = (a2 == null || a2.d() == null) ? new h(this.f13143a, this.m, PlacementType.INTERSTITIAL) : a2.d();
        a(new View.OnApplyWindowInsetsListener() { // from class: com.sigmob.sdk.mraid.A4TApA
            @Override // android.view.View.OnApplyWindowInsetsListener
            public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                WindowInsets a3;
                a3 = s.this.a(view, windowInsets);
                return a3;
            }
        });
        this.n.a(this.e);
        this.n.a(new h.f() { // from class: com.sigmob.sdk.mraid.s.2
            private boolean b;

            @Override // com.sigmob.sdk.mraid.h.f
            public void a() {
                SigmobLog.d("adImpression() called");
            }

            @Override // com.sigmob.sdk.mraid.h.f
            public void b() {
                if (this.b) {
                    return;
                }
                s.this.b(com.sigmob.sdk.base.common.a.j);
            }

            @Override // com.sigmob.sdk.mraid.h.f
            public void c() {
                SigmobLog.d("adPlaying() called");
            }

            @Override // com.sigmob.sdk.mraid.h.f
            public void d() {
                this.b = true;
                s.this.b("complete");
                SigmobLog.d("adVideoComplete() called");
            }

            @Override // com.sigmob.sdk.mraid.h.f
            public void e() {
                s.this.b(com.sigmob.sdk.base.common.a.k);
                SigmobLog.d("adVideoFirstQuartile() called");
            }

            @Override // com.sigmob.sdk.mraid.h.f
            public void f() {
                s.this.b(com.sigmob.sdk.base.common.a.n);
                SigmobLog.d("adVideoThirdQuartile() called");
            }

            @Override // com.sigmob.sdk.mraid.h.f
            public void g() {
                s.this.b(com.sigmob.sdk.base.common.a.m);
                SigmobLog.d("adVideoMidpoint() called");
            }

            @Override // com.sigmob.sdk.mraid.h.f
            public void h() {
                s.this.b(com.sigmob.sdk.base.common.a.L);
                s.this.a(IntentActions.ACTION_REWARDED_VIDEO_PLAY);
                SigmobLog.d("adVideoStart() called");
            }

            @Override // com.sigmob.sdk.mraid.h.f
            public void a(Integer num) {
                s.this.q = num == null ? -1 : num.intValue();
                s sVar = s.this;
                sVar.g.a(sVar.q, s.this.j.l());
            }

            @Override // com.sigmob.sdk.mraid.h.f
            public void b(Map<String, String> map) {
                SigmobLog.d("adError() called " + map);
            }

            @Override // com.sigmob.sdk.mraid.h.f
            public void a(Map<String, String> map) {
                try {
                    map.get(com.sigmob.sdk.downloader.core.breakpoint.f.f13353a);
                    String str2 = map.get("url");
                    if (!map.get("playerHandles").equalsIgnoreCase("false")) {
                        if (!TextUtils.isEmpty(str2)) {
                            if (str2.startsWith(Constants.HTTP)) {
                                s.this.m.setCustomLandPageUrl(str2);
                            } else {
                                s.this.m.setCustomDeeplink(str2);
                            }
                        }
                        s.this.j.a(com.sigmob.sdk.base.a.ENDCARD, s.this.n.a(), true);
                    }
                    SigmobLog.d("adClickThru() called" + map);
                } catch (Throwable th) {
                    SigmobLog.e("adClickThru", th);
                }
            }
        });
        this.n.a(new AnonymousClass3());
        this.n.a(new A5SV6n(0, this));
        if (a2 != null) {
            this.g = a2.c();
        } else if (!TextUtils.isEmpty(this.m.getHtmlData())) {
            this.n.a(this.m.getHtmlData(), new A5SV6n(1, this));
        } else if (!TextUtils.isEmpty(this.m.getHtmlUrl())) {
            this.n.b(this.m.getHtmlUrl(), new A5SV6n(2, this));
        }
        return this.n.q();
    }

    @Override // com.sigmob.sdk.videoAd.b, com.sigmob.sdk.base.common.j
    public void e() {
        super.e();
        b(n(), this.i, this.h);
        n().getWindow().addFlags(16778240);
        com.sigmob.sdk.base.common.u uVar = this.g;
        if (uVar != null) {
            uVar.a("show", 0);
        }
        m().addView(a(), new FrameLayout.LayoutParams(-1, -1));
        h hVar = this.n;
        if (hVar != null) {
            hVar.a(n());
        }
        a(IntentActions.ACTION_INTERSTITIAL_VOPEN);
        a(new x() { // from class: com.sigmob.sdk.mraid.s.6
            @Override // com.sigmob.sdk.mraid.x
            public boolean a(ConsoleMessage consoleMessage) {
                if (AnonymousClass7.f13497a[consoleMessage.messageLevel().ordinal()] != 1) {
                    return false;
                }
                SigmobLog.e("onConsoleMessage " + consoleMessage.message());
                ae.a("h5_error", "mraid1", 0, consoleMessage.message(), (WindAdRequest) null, (LoadAdRequest) null, s.this.m, (ae.a) null);
                return false;
            }

            @Override // com.sigmob.sdk.mraid.x
            public boolean a(String str, JsResult jsResult) {
                return false;
            }
        });
    }

    @Override // com.sigmob.sdk.base.common.j
    public void f() {
        if (!this.s) {
            this.n.b();
        } else {
            this.t = true;
            a(IntentActions.ACTION_INTERSTITIAL_DISMISS);
        }
    }

    @Override // com.sigmob.sdk.base.common.j
    public void g() {
        this.n.c();
    }

    @Override // com.sigmob.sdk.base.common.j
    public void h() {
        com.sigmob.sdk.base.common.u uVar = this.g;
        if (uVar != null) {
            uVar.a();
            this.g = null;
        }
        h hVar = this.n;
        if (hVar != null) {
            hVar.m();
        }
        s();
        p();
        if (!this.s || !this.t) {
            this.t = true;
            a(IntentActions.ACTION_INTERSTITIAL_DISMISS);
        }
        BaseAdUnit baseAdUnit = this.m;
        if (baseAdUnit != null) {
            baseAdUnit.destroy();
        }
        super.h();
    }

    @Override // com.sigmob.sdk.base.common.j
    public void i() {
    }

    @Override // com.sigmob.sdk.base.common.j
    public void o() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ WindowInsets a(View view, WindowInsets windowInsets) {
        this.n.a(windowInsets);
        return windowInsets;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        c e;
        h hVar = this.n;
        if (hVar == null || hVar.g() == null || (e = this.n.e()) == null) {
            return;
        }
        e.a(str, (HashMap<String, Object>) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(v vVar, com.sigmob.sdk.base.common.u uVar) {
        if (uVar != null) {
            this.g = uVar;
            return;
        }
        com.sigmob.sdk.base.common.u uVar2 = new com.sigmob.sdk.base.common.u();
        this.g = uVar2;
        uVar2.a(this.m);
    }

    public void b(final String str) {
        final Integer f2 = this.n.f();
        this.n.a(new ValueCallback() { // from class: com.sigmob.sdk.mraid.ADYaiT
            @Override // android.webkit.ValueCallback
            public final void onReceiveValue(Object obj) {
                s.this.a(str, f2, (String) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(boolean z) {
        if (z) {
            q();
        } else {
            r();
        }
    }

    private void a(Context context, int i) {
        if (this.p != null) {
            return;
        }
        ar arVar = new ar(context);
        this.p = arVar;
        arVar.setVisibility(i);
        this.p.setId(ClientMetadata.generateViewId());
        int dipsToIntPixels = Dips.dipsToIntPixels(10.0f, this.f13143a);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(Dips.dipsToIntPixels(22.0f, context), Dips.dipsToIntPixels(22.0f, context));
        layoutParams.addRule(10);
        layoutParams.addRule(11);
        layoutParams.setMargins(dipsToIntPixels, dipsToIntPixels * 2, dipsToIntPixels, dipsToIntPixels);
        m().addView(this.p, layoutParams);
        this.p.setOnTouchListener(new View.OnTouchListener() { // from class: com.sigmob.sdk.mraid.s.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    s.this.s = true;
                    s.this.j.b(s.this.l(), s.this.q, s.this.m);
                    s.this.k().a();
                }
                return true;
            }
        });
        this.p.a(this.m);
        String f2 = this.j.f();
        if (f2 != null) {
            this.p.a(f2);
        }
    }

    @Override // com.sigmob.sdk.base.common.j
    public void a(Configuration configuration) {
        this.n.a(configuration.orientation);
    }

    @Override // com.sigmob.sdk.base.common.j
    public void a(Bundle bundle) {
    }

    private void a(com.sigmob.sdk.base.a aVar, String str) {
        BaseAdUnit baseAdUnit = this.m;
        if (baseAdUnit == null) {
            return;
        }
        ClickCommon clickCommon = baseAdUnit.getClickCommon();
        ae.a(aVar, "click", this.m, clickCommon.isDeeplink, clickCommon.clickUrl, clickCommon.clickCoordinate, this.q, this.y);
        b(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(v vVar, com.sigmob.sdk.base.common.u uVar) {
        if (uVar != null) {
            this.g = uVar;
            return;
        }
        com.sigmob.sdk.base.common.u uVar2 = new com.sigmob.sdk.base.common.u();
        this.g = uVar2;
        uVar2.a(this.m);
    }

    public void a(x xVar) {
        this.o = xVar;
        h hVar = this.n;
        if (hVar == null) {
            return;
        }
        hVar.a(xVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(String str, Integer num, String str2) {
        if (this.g == null) {
            return;
        }
        try {
            if (c.a(str2) == null) {
                if (str.equals("show_skip")) {
                    this.g.a(false, 0);
                }
                this.g.a(str, 0);
            } else {
                float parseFloat = Float.parseFloat(str2);
                float intValue = (((double) parseFloat) <= 1.0E-7d || num == null || num.intValue() <= 0) ? -1.0f : parseFloat * num.intValue();
                if (str.equals("show_skip")) {
                    this.g.a(false, (int) intValue);
                }
                this.g.a(str, (int) intValue);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
