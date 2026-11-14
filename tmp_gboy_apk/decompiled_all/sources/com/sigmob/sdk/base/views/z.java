package com.sigmob.sdk.base.views;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import com.czhj.sdk.common.Constants;
import com.czhj.sdk.common.utils.Dips;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.PlacementType;
import com.sigmob.sdk.base.mta.PointParamKey;
import com.sigmob.sdk.mraid.b;
import com.sigmob.sdk.mraid.h;
import com.sigmob.windad.WindAdError;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class z extends Dialog implements DialogInterface.OnShowListener {

    /* renamed from: a, reason: collision with root package name */
    protected com.sigmob.sdk.base.common.u f13331a;
    private View b;
    private Window c;
    private a d;
    private RelativeLayout e;
    private com.sigmob.sdk.videoAd.a f;
    private BaseAdUnit g;
    private com.sigmob.sdk.mraid.h h;
    private Context i;
    private int j;
    private int k;
    private boolean l;

    public interface a {
        void onCloseClick();
    }

    public z(Context context, BaseAdUnit baseAdUnit, com.sigmob.sdk.videoAd.a aVar) {
        super(context, com.sigmob.sdk.base.k.e());
        this.c = null;
        this.j = 0;
        this.k = 0;
        this.l = false;
        this.i = context.getApplicationContext();
        this.g = baseAdUnit;
        this.f = aVar;
        this.b = b();
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        this.e = relativeLayout;
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.e.setBackgroundColor(0);
        setContentView(this.e);
        setOnShowListener(this);
        SigmobLog.i("RecommendDialog onCreate:" + this.k + ":" + this.j);
        View view = this.b;
        if (view != null) {
            this.e.addView(view);
        }
        setCanceledOnTouchOutside(false);
        setCancelable(true);
        d();
    }

    @Override // android.content.DialogInterface.OnShowListener
    public void onShow(DialogInterface dialogInterface) {
        SigmobLog.i("RecommendDialog  onShow");
        a(com.sigmob.sdk.base.common.a.d);
        this.h.a(0);
    }

    @Override // android.app.Dialog
    public void onStart() {
        super.onStart();
        Window window = getWindow();
        this.c = window;
        com.sigmob.sdk.videoplayer.c.a(window);
    }

    private void d() {
        Window window = getWindow();
        this.c = window;
        if (window == null) {
            return;
        }
        window.setGravity(80);
        int g = com.sigmob.sdk.base.k.g();
        if (g != 0) {
            this.c.setWindowAnimations(g);
        }
        this.c.getDecorView().setPadding(0, 0, 0, 0);
        WindowManager.LayoutParams attributes = this.c.getAttributes();
        int i = this.i.getResources().getDisplayMetrics().widthPixels;
        int i2 = this.i.getResources().getDisplayMetrics().heightPixels;
        int i3 = this.k;
        if (i3 - 1 <= i) {
            attributes.width = -1;
        } else {
            attributes.width = i3;
        }
        int i4 = this.j;
        if (i4 - 1 <= i2) {
            attributes.height = -1;
        } else {
            attributes.height = i4;
        }
        StringBuilder B7CMnp2 = J3FDQU.A2egSU.B7CMnp(i, i2, "RecommendDialog windowDeploy: ", "====", "====");
        B7CMnp2.append(attributes.width);
        B7CMnp2.append("====");
        B7CMnp2.append(attributes.height);
        SigmobLog.i(B7CMnp2.toString());
        this.c.setAttributes(attributes);
    }

    public View b() {
        if (this.h == null) {
            this.h = new com.sigmob.sdk.mraid.h(this.i, this.g, PlacementType.INTERSTITIAL);
        }
        this.h.a(new h.f() { // from class: com.sigmob.sdk.base.views.z.1
            @Override // com.sigmob.sdk.mraid.h.f
            public void a() {
            }

            @Override // com.sigmob.sdk.mraid.h.f
            public void b() {
            }

            @Override // com.sigmob.sdk.mraid.h.f
            public void c() {
            }

            @Override // com.sigmob.sdk.mraid.h.f
            public void d() {
            }

            @Override // com.sigmob.sdk.mraid.h.f
            public void e() {
            }

            @Override // com.sigmob.sdk.mraid.h.f
            public void f() {
            }

            @Override // com.sigmob.sdk.mraid.h.f
            public void g() {
            }

            @Override // com.sigmob.sdk.mraid.h.f
            public void h() {
            }

            @Override // com.sigmob.sdk.mraid.h.f
            public void a(Integer num) {
            }

            @Override // com.sigmob.sdk.mraid.h.f
            public void b(Map<String, String> map) {
            }

            @Override // com.sigmob.sdk.mraid.h.f
            public void a(Map<String, String> map) {
            }
        });
        this.h.a(new h.a() { // from class: com.sigmob.sdk.base.views.z.2
            /* JADX WARN: Code restructure failed: missing block: B:3:0x0006, code lost:
            
                r0 = r2.f13333a.getWindow().getDecorView().getRootWindowInsets();
             */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            private int i() {
                /*
                    r2 = this;
                    int r0 = android.os.Build.VERSION.SDK_INT
                    r1 = 28
                    if (r0 < r1) goto L25
                    com.sigmob.sdk.base.views.z r0 = com.sigmob.sdk.base.views.z.this
                    android.view.Window r0 = r0.getWindow()
                    android.view.View r0 = r0.getDecorView()
                    android.view.WindowInsets r0 = com.bytedance.pangle.wrapper.AMqCpz.AaHO0E(r0)
                    if (r0 == 0) goto L25
                    android.view.DisplayCutout r1 = CASmeH.ASJ6gh.AaHO0E(r0)
                    if (r1 == 0) goto L25
                    android.view.DisplayCutout r0 = CASmeH.ASJ6gh.AaHO0E(r0)
                    int r0 = I3HV03.ADYaiT.A5SV6n(r0)
                    return r0
                L25:
                    r0 = 0
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.base.views.z.AnonymousClass2.i():int");
            }

            @Override // com.sigmob.sdk.mraid.h.a
            public void a() {
                SigmobLog.d("RecommendDialog onEndCardShow()");
            }

            @Override // com.sigmob.sdk.mraid.h.a
            public void b() {
                SigmobLog.d("RecommendDialog onShowSkipTime()");
            }

            @Override // com.sigmob.sdk.mraid.h.a
            public void c() {
            }

            @Override // com.sigmob.sdk.mraid.h.a
            public void d() {
                SigmobLog.d("RecommendDialog onExpand()");
            }

            @Override // com.sigmob.sdk.mraid.h.a
            public void e() {
                SigmobLog.i("RecommendDialog onFailedToLoad()");
                z.this.l = true;
            }

            @Override // com.sigmob.sdk.mraid.h.a
            public void f() {
                SigmobLog.i("RecommendDialog onUnload()");
                z.this.dismiss();
                z.this.a(com.sigmob.sdk.base.common.a.e);
                z.this.c();
            }

            @Override // com.sigmob.sdk.mraid.h.a
            public void g() {
            }

            @Override // com.sigmob.sdk.mraid.h.a
            public void h() {
                SigmobLog.i("RecommendDialog onClose()");
                if (z.this.d != null) {
                    z.this.d.onCloseClick();
                }
            }

            @Override // com.sigmob.sdk.mraid.h.a
            public void a(float f) {
                SigmobLog.d("RecommendDialog onReward()");
            }

            @Override // com.sigmob.sdk.mraid.h.a
            public void b(float f) {
                SigmobLog.d("RecommendDialog onSkip()");
            }

            @Override // com.sigmob.sdk.mraid.h.a
            public void a(int i, int i2, int i3, int i4, b.a aVar, boolean z) {
                int i5 = z.this.i.getResources().getDisplayMetrics().widthPixels;
                int i6 = z.this.i.getResources().getDisplayMetrics().heightPixels;
                int n = com.sigmob.sdk.videoplayer.c.n(z.this.getContext());
                int i7 = i();
                StringBuilder B7CMnp2 = J3FDQU.A2egSU.B7CMnp(i, i2, "RecommendDialog Origin onResize :", "==", "==");
                B7CMnp2.append(i3);
                B7CMnp2.append("==");
                B7CMnp2.append(i4);
                B7CMnp2.append("==");
                B7CMnp2.append(z);
                SigmobLog.i(B7CMnp2.toString());
                z zVar = z.this;
                zVar.k = Dips.dipsToIntPixels(i, zVar.i);
                z zVar2 = z.this;
                zVar2.j = Dips.dipsToIntPixels(i2, zVar2.i);
                int dipsToIntPixels = Dips.dipsToIntPixels(i3, z.this.i);
                int dipsToIntPixels2 = Dips.dipsToIntPixels(i4, z.this.i) - Math.max(n, i7);
                if (z.this.b == null) {
                    return;
                }
                if (!z) {
                    dipsToIntPixels = Math.min(Math.max(dipsToIntPixels, 0), i5);
                    dipsToIntPixels2 = Math.min(Math.max(dipsToIntPixels2, 0), i6);
                    if (z.this.k + dipsToIntPixels > i5) {
                        z.this.k = i5 - dipsToIntPixels;
                    }
                    if (z.this.j + dipsToIntPixels2 > i6) {
                        z.this.j = i6 - dipsToIntPixels2;
                    }
                }
                SigmobLog.i("RecommendDialog onResize: " + z.this.k + "==" + z.this.j + "==" + dipsToIntPixels + "==" + dipsToIntPixels2);
                if (z.this.k <= 0 || z.this.j <= 0) {
                    z.this.l = true;
                }
                z.this.b.setX(dipsToIntPixels);
                z.this.b.setY(dipsToIntPixels2);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(z.this.k, z.this.j);
                layoutParams.addRule(12);
                z.this.b.setLayoutParams(layoutParams);
                z.this.b.requestLayout();
            }

            @Override // com.sigmob.sdk.mraid.h.a
            public void a(View view) {
                SigmobLog.d("RecommendDialog onLoaded()");
            }

            @Override // com.sigmob.sdk.mraid.h.a
            public void a(WindAdError windAdError) {
                SigmobLog.i("RecommendDialog onRenderProcessGone:" + windAdError.toString());
                z.this.l = true;
            }

            @Override // com.sigmob.sdk.mraid.h.a
            public void a(String str) {
                SigmobLog.i("RecommendDialog onCompanionClick:" + str);
                boolean z = true;
                if (com.sigmob.sdk.base.utils.o.b(str)) {
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        int optInt = jSONObject.optInt(PointParamKey.TYPE);
                        z.this.h.a(String.valueOf(jSONObject.optInt("x")), String.valueOf(jSONObject.optInt("y")));
                        if (optInt == 1) {
                            z = false;
                        } else {
                            z.this.a(com.sigmob.sdk.base.common.a.s);
                        }
                    } catch (Exception unused) {
                        z.this.h.a(Constants.FAIL, Constants.FAIL);
                        z.this.a(com.sigmob.sdk.base.common.a.s);
                    }
                }
                z.this.f.a(com.sigmob.sdk.base.a.ENDCARD, z.this.h.a(), z);
            }

            /* JADX WARN: Removed duplicated region for block: B:5:0x009f  */
            @Override // com.sigmob.sdk.mraid.h.a
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public void a(java.net.URI r11, int r12, java.lang.String r13) {
                /*
                    r10 = this;
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder
                    java.lang.String r1 = "RecommendDialog  onOpen:"
                    r0.<init>(r1)
                    r0.append(r11)
                    java.lang.String r1 = "======"
                    r0.append(r1)
                    r0.append(r12)
                    java.lang.String r12 = "====="
                    r0.append(r12)
                    r0.append(r13)
                    java.lang.String r12 = r0.toString()
                    com.czhj.sdk.logger.SigmobLog.i(r12)
                    boolean r12 = com.sigmob.sdk.base.utils.o.b(r13)
                    java.lang.String r0 = "click"
                    java.lang.String r1 = "0"
                    r2 = 0
                    r3 = 1
                    r4 = 0
                    if (r12 == 0) goto L8c
                    org.json.JSONObject r12 = new org.json.JSONObject     // Catch: java.lang.Exception -> L76
                    r12.<init>(r13)     // Catch: java.lang.Exception -> L76
                    java.lang.String r13 = "type"
                    int r13 = r12.optInt(r13)     // Catch: java.lang.Exception -> L78
                    java.lang.String r4 = "x"
                    int r4 = r12.optInt(r4)     // Catch: java.lang.Exception -> L78
                    java.lang.String r5 = "y"
                    int r5 = r12.optInt(r5)     // Catch: java.lang.Exception -> L78
                    java.lang.String r6 = "disable_landing"
                    boolean r6 = r12.optBoolean(r6)     // Catch: java.lang.Exception -> L78
                    java.lang.String r7 = "feDisable"
                    boolean r7 = r12.optBoolean(r7)     // Catch: java.lang.Exception -> L74
                    r7 = r7 ^ r3
                    com.sigmob.sdk.base.views.z r8 = com.sigmob.sdk.base.views.z.this     // Catch: java.lang.Exception -> L6c
                    com.sigmob.sdk.mraid.h r8 = com.sigmob.sdk.base.views.z.b(r8)     // Catch: java.lang.Exception -> L6c
                    java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch: java.lang.Exception -> L6c
                    java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch: java.lang.Exception -> L6c
                    r8.a(r4, r5)     // Catch: java.lang.Exception -> L6c
                    if (r13 == r3) goto L6f
                    com.sigmob.sdk.base.views.z r13 = com.sigmob.sdk.base.views.z.this     // Catch: java.lang.Exception -> L6c
                    r13.a(r0)     // Catch: java.lang.Exception -> L6c
                    r2 = 1
                    goto L6f
                L6c:
                    r4 = r12
                    r2 = r6
                    goto L7a
                L6f:
                    r9 = r12
                    r8 = r7
                    r7 = r2
                    r2 = r6
                    goto L9d
                L74:
                    r4 = r12
                    r2 = r6
                L76:
                    r7 = 1
                    goto L7a
                L78:
                    r4 = r12
                    goto L76
                L7a:
                    com.sigmob.sdk.base.views.z r12 = com.sigmob.sdk.base.views.z.this
                    com.sigmob.sdk.mraid.h r12 = com.sigmob.sdk.base.views.z.b(r12)
                    r12.a(r1, r1)
                    com.sigmob.sdk.base.views.z r12 = com.sigmob.sdk.base.views.z.this
                    r12.a(r0)
                    r9 = r4
                    r8 = r7
                    r7 = 1
                    goto L9d
                L8c:
                    com.sigmob.sdk.base.views.z r12 = com.sigmob.sdk.base.views.z.this
                    com.sigmob.sdk.mraid.h r12 = com.sigmob.sdk.base.views.z.b(r12)
                    r12.a(r1, r1)
                    com.sigmob.sdk.base.views.z r12 = com.sigmob.sdk.base.views.z.this
                    r12.a(r0)
                    r9 = r4
                    r7 = 1
                    r8 = 1
                L9d:
                    if (r2 != 0) goto Lc7
                    com.sigmob.sdk.base.views.z r12 = com.sigmob.sdk.base.views.z.this
                    com.sigmob.sdk.base.models.BaseAdUnit r12 = com.sigmob.sdk.base.views.z.h(r12)
                    java.lang.String r12 = r12.getLanding_page()
                    boolean r12 = com.sigmob.sdk.base.utils.o.a(r12)
                    if (r12 == 0) goto Lb0
                    goto Lc7
                Lb0:
                    com.sigmob.sdk.base.views.z r11 = com.sigmob.sdk.base.views.z.this
                    com.sigmob.sdk.videoAd.a r3 = com.sigmob.sdk.base.views.z.c(r11)
                    com.sigmob.sdk.base.a r4 = com.sigmob.sdk.base.a.ENDCARD
                    com.sigmob.sdk.base.views.z r11 = com.sigmob.sdk.base.views.z.this
                    com.sigmob.sdk.mraid.h r11 = com.sigmob.sdk.base.views.z.b(r11)
                    java.lang.String r6 = r11.a()
                    r5 = 0
                    r3.a(r4, r5, r6, r7, r8)
                    goto Le0
                Lc7:
                    com.sigmob.sdk.base.views.z r12 = com.sigmob.sdk.base.views.z.this
                    com.sigmob.sdk.videoAd.a r3 = com.sigmob.sdk.base.views.z.c(r12)
                    com.sigmob.sdk.base.a r4 = com.sigmob.sdk.base.a.ENDCARD
                    java.lang.String r5 = r11.toString()
                    com.sigmob.sdk.base.views.z r11 = com.sigmob.sdk.base.views.z.this
                    com.sigmob.sdk.mraid.h r11 = com.sigmob.sdk.base.views.z.b(r11)
                    java.lang.String r6 = r11.a()
                    r3.a(r4, r5, r6, r7, r8, r9)
                Le0:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.base.views.z.AnonymousClass2.a(java.net.URI, int, java.lang.String):void");
            }

            @Override // com.sigmob.sdk.mraid.h.a
            public void a(boolean z) {
                SigmobLog.d("RecommendDialog onMute()");
            }
        });
        String closeCardHtmlData = this.g.getCloseCardHtmlData();
        if (com.sigmob.sdk.base.utils.o.b(closeCardHtmlData)) {
            this.h.a(closeCardHtmlData, new ADYaiT(this));
        }
        return this.h.q();
    }

    public void c() {
        com.sigmob.sdk.mraid.h hVar = this.h;
        if (hVar == null) {
            return;
        }
        this.d = null;
        hVar.m();
        this.h = null;
    }

    public void a(a aVar) {
        this.d = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(com.sigmob.sdk.mraid.v vVar, com.sigmob.sdk.base.common.u uVar) {
        if (uVar != null) {
            this.f13331a = uVar;
            return;
        }
        com.sigmob.sdk.base.common.u uVar2 = new com.sigmob.sdk.base.common.u();
        this.f13331a = uVar2;
        uVar2.a(this.g);
    }

    public void a(String str) {
        com.sigmob.sdk.base.common.u uVar = this.f13331a;
        if (uVar == null) {
            return;
        }
        uVar.a(str, 0);
    }

    public boolean a() {
        if (this.k <= 0 || this.j <= 0) {
            this.l = true;
        }
        return this.l;
    }
}
