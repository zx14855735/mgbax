package com.bytedance.sdk.openadsdk.core.component.splash.presentation;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bykv.vk.openvk.component.video.api.u.w;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.core.a.r;
import com.bytedance.sdk.openadsdk.core.a.wo;
import com.bytedance.sdk.openadsdk.core.component.splash.TsView;
import com.bytedance.sdk.openadsdk.core.component.splash.countdown.hf;
import com.bytedance.sdk.openadsdk.core.component.splash.presentation.SlideInterceptView;
import com.bytedance.sdk.openadsdk.core.component.splash.presentation.xj;
import com.bytedance.sdk.openadsdk.core.component.splash.w.xj.c;
import com.bytedance.sdk.openadsdk.core.component.splash.w.xj.d;
import com.bytedance.sdk.openadsdk.core.multipro.hf.xj;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressVideoView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.SplashExpressBackupView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.dk;
import com.bytedance.sdk.openadsdk.core.nativeexpress.kd;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.core.ra.h;
import com.bytedance.sdk.openadsdk.core.ra.hl;
import com.bytedance.sdk.openadsdk.core.ra.io;
import com.bytedance.sdk.openadsdk.core.ra.op;
import com.bytedance.sdk.openadsdk.core.ra.ra;
import com.bytedance.sdk.openadsdk.core.ra.tf;
import com.bytedance.sdk.openadsdk.core.ra.wa;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.core.ugeno.component.interact.u;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class hf extends xj implements w.u, w.InterfaceC0013w, xj.hf, xj.InterfaceC0173xj {
    private NativeExpressView b;
    private SlideInterceptView dc;
    private com.bytedance.sdk.openadsdk.zg.w.w.hf eu;
    private WeakReference<ViewGroup> hl;
    private int n;
    private String tj;
    private u vm;
    private Context ws;
    private final AtomicBoolean yy = new AtomicBoolean(false);
    private final SlideInterceptView.xj wn = new SlideInterceptView.xj() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.presentation.hf.1
        @Override // com.bytedance.sdk.openadsdk.core.component.splash.presentation.SlideInterceptView.xj
        public void xj(View view, tf tfVar) {
            com.bytedance.sdk.openadsdk.core.hf.xj xjVar = hf.this.kd;
            if (xjVar != null) {
                xjVar.xj(view, tfVar);
            }
            hf.this.qt();
        }
    };

    /* renamed from: com.bytedance.sdk.openadsdk.core.component.splash.presentation.hf$2, reason: invalid class name */
    public class AnonymousClass2 implements Runnable {
        final /* synthetic */ com.bytedance.sdk.openadsdk.core.component.splash.xj.xj c;
        final /* synthetic */ com.bytedance.sdk.openadsdk.zg.w.w.hf hf;
        final /* synthetic */ com.bytedance.sdk.openadsdk.core.component.splash.w.xj.w kd;
        final /* synthetic */ int u;
        final /* synthetic */ String w;
        final /* synthetic */ Context xj;
        final /* synthetic */ com.bytedance.sdk.openadsdk.core.component.splash.w.w.u y;

        public AnonymousClass2(Context context, com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar, String str, int i, com.bytedance.sdk.openadsdk.core.component.splash.w.xj.w wVar, com.bytedance.sdk.openadsdk.core.component.splash.w.w.u uVar, com.bytedance.sdk.openadsdk.core.component.splash.xj.xj xjVar) {
            this.xj = context;
            this.hf = hfVar;
            this.w = str;
            this.u = i;
            this.kd = wVar;
            this.y = uVar;
            this.c = xjVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                hf.this.ws = this.xj;
                hf.this.eu = this.hf;
                hf.this.tj = this.w;
                hf.this.n = this.u;
                hf hfVar = hf.this;
                hfVar.xj((xj.hf) hfVar);
                hf.this.xj(this.kd, this.y, this.c);
                hf hfVar2 = hf.this;
                hfVar2.vm = new u(hfVar2.hf, false, new com.bytedance.sdk.openadsdk.core.ugeno.component.interact.xj() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.presentation.hf.2.1
                    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
                    public long getActualPlayDuration() {
                        return 0L;
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
                    public int hf() {
                        return 0;
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
                    public void kd() {
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
                    public void setPauseFromExpressView(boolean z) {
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
                    public void u() {
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
                    public int w() {
                        return 0;
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
                    public long xj() {
                        return 0L;
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
                    public void y() {
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
                    public void hf(int i) {
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
                    public void w(int i) {
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
                    public void xj(float f) {
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.xj
                    public void hf(View view, int i, com.bytedance.sdk.component.adexpress.w wVar) {
                        if (hf.this.b != null) {
                            hf.this.b.xj(view, i, wVar);
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
                    public void xj(int i) {
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
                    public void xj(int i, String str) {
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.xj
                    public void xj(View view) {
                        hf hfVar3 = hf.this;
                        com.bytedance.sdk.openadsdk.u.xj.hf.xj.xj xjVar = hfVar3.f;
                        if (xjVar != null) {
                            xjVar.hf(hfVar3);
                        }
                        hf.this.qt();
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.xj
                    public void xj(View view, int i, com.bytedance.sdk.component.adexpress.w wVar) {
                        if (hf.this.b != null) {
                            hf.this.b.xj(view, i, wVar);
                        }
                        hf.this.qt();
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.xj
                    public void xj(ViewGroup viewGroup) {
                        if (io.y(hf.this.hf).y()) {
                            TextView textView = new TextView(hf.this.ws);
                            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                            textView.setTextSize(1, 20.0f);
                            int w = r.w(pz.getContext(), 80.0f);
                            textView.setText("跳转至详情页或第三方应用");
                            layoutParams.bottomMargin = w;
                            int i = w / 3;
                            layoutParams.leftMargin = i;
                            layoutParams.rightMargin = i;
                            layoutParams.gravity = 81;
                            textView.setTextColor(-1);
                            int i2 = w / 6;
                            textView.setPadding(0, i2, 0, i2);
                            textView.setGravity(17);
                            textView.setLayoutParams(layoutParams);
                            textView.setClickable(true);
                            textView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.presentation.hf.2.1.1
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view) {
                                    if (hf.this.b != null) {
                                        hf.this.b.xj(view, 2, new ra.xj().xj());
                                    }
                                }
                            });
                            textView.bringToFront();
                            viewGroup.addView(textView);
                        }
                    }
                });
            } catch (Throwable th) {
                pl.u("splrender", th.getMessage());
            }
        }
    }

    public hf(Context context, com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar, String str, int i, com.bytedance.sdk.openadsdk.core.component.splash.w.xj.w wVar, com.bytedance.sdk.openadsdk.core.component.splash.w.w.u<d, c> uVar, com.bytedance.sdk.openadsdk.core.component.splash.xj.xj xjVar) {
        com.bytedance.sdk.openadsdk.x.c.xj(new AnonymousClass2(context, hfVar, str, i, wVar, uVar, xjVar));
    }

    private void e() {
        if (this.hf.rs() == 2) {
            this.b = new NativeExpressView(true, this.ws, this.hf, this.eu, this.tj, true);
        } else {
            this.b = new NativeExpressView(false, this.ws, this.hf, this.eu, this.tj, true);
        }
    }

    private void jk() {
        if (this.ff > 0) {
            return;
        }
        if (this.l == 1) {
            this.ff = 1;
        } else {
            this.ff = 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pz() {
        NativeExpressView nativeExpressView = this.b;
        if (nativeExpressView == null) {
            return;
        }
        nativeExpressView.hf(this.f10337pl, 0);
        this.b.setDynamicSkipListener(new com.bytedance.sdk.openadsdk.core.component.splash.countdown.w() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.presentation.hf.7
            @Override // com.bytedance.sdk.openadsdk.core.component.splash.countdown.w
            public void xj() {
                hf.this.tf();
            }
        });
        ((xj) this).xj.hf();
        com.bytedance.sdk.openadsdk.core.component.splash.countdown.hf hfVar = new com.bytedance.sdk.openadsdk.core.component.splash.countdown.hf();
        this.r = hfVar;
        hfVar.xj(this.f10337pl);
        this.r.xj(new hf.xj() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.presentation.hf.8
            @Override // com.bytedance.sdk.openadsdk.core.component.splash.countdown.hf.xj
            public void xj() {
                hf.this.g();
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.splash.countdown.hf.xj
            public void xj(int i) {
                if (hf.this.b != null) {
                    hf.this.b.hf(hf.this.f10337pl, i);
                }
            }
        });
        if (this.f10335a.get()) {
            this.r.hf();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        final wa mg = this.hf.mg();
        if (mg == null || ((xj) this).xj == null) {
            return;
        }
        if ((this.wo.get() != 1 || mg.e() == 1) && mg.zg() > 0.0f) {
            ((xj) this).xj.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.presentation.hf.5
                @Override // java.lang.Runnable
                public void run() {
                    View rootView = ((xj) hf.this).xj.getRootView();
                    if (rootView instanceof FrameLayout) {
                        ViewGroup viewGroup = (ViewGroup) rootView;
                        int height = ((xj) hf.this).xj.getHeight();
                        int d = r.d(hf.this.ws);
                        if (mg.zg() >= 1.0f) {
                            float f = d;
                            if (height <= mg.zg() * f && !hf.this.p) {
                                int et = mg.jk() == 1 ? d - height : mg.et() > 0.0f ? (int) (mg.et() * f) : 0;
                                hf.this.dc = new SlideInterceptView(hf.this.ws, mg, hf.this.wn);
                                if (et <= 0) {
                                    et = -1;
                                }
                                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, et);
                                layoutParams.gravity = 80;
                                viewGroup.addView(hf.this.dc, layoutParams);
                            }
                        }
                    }
                }
            }, mg.pz());
        }
    }

    private void yo() {
        if (this.hf.rs() == 2) {
            this.b = new NativeExpressVideoView(true, this.ws, this.hf, this.eu, this.tj);
        } else {
            this.b = new NativeExpressVideoView(false, this.ws, this.hf, this.eu, this.tj);
        }
        if (this.b.getVideoController() instanceof com.bytedance.sdk.openadsdk.core.video.nativevideo.u) {
            this.j = (com.bytedance.sdk.openadsdk.core.video.nativevideo.u) this.b.getVideoController();
        }
        this.b.setVideoAdListener(this);
        this.b.setVideoAdInteractionListener(this);
    }

    @Override // com.bytedance.sdk.openadsdk.core.multipro.hf.xj.InterfaceC0173xj
    public com.bytedance.sdk.openadsdk.core.multipro.hf.xj j() {
        NativeExpressView nativeExpressView;
        com.bytedance.sdk.openadsdk.core.multipro.hf.xj xjVar = new com.bytedance.sdk.openadsdk.core.multipro.hf.xj();
        w wVar = this.j;
        if (wVar == null && (nativeExpressView = this.b) != null) {
            wVar = nativeExpressView.getVideoController();
        }
        if (wVar != null) {
            xjVar.c = wVar.p();
            xjVar.xj = wVar.jk();
            xjVar.f = wVar.v();
        }
        return xjVar;
    }

    @Override // com.bykv.vk.openvk.component.video.api.u.w.u
    public void p_() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.multipro.hf.xj.InterfaceC0173xj
    public boolean q() {
        return false;
    }

    @Override // com.bykv.vk.openvk.component.video.api.u.w.InterfaceC0013w
    public void q_() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.presentation.xj
    public void qt() {
        try {
            SlideInterceptView slideInterceptView = this.dc;
            if (slideInterceptView == null) {
                return;
            }
            slideInterceptView.xj();
            if (((ViewGroup) this.dc.getParent()) == null) {
                return;
            }
            this.dc.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.presentation.hf.6
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        ViewGroup viewGroup = (ViewGroup) hf.this.dc.getParent();
                        if (viewGroup == null) {
                            return;
                        }
                        viewGroup.removeView(hf.this.dc);
                    } catch (Exception unused) {
                    }
                }
            });
        } catch (Exception unused) {
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.u.w.InterfaceC0013w
    public void r_() {
    }

    @Override // com.bykv.vk.openvk.component.video.api.u.w.InterfaceC0013w
    public void s_() {
    }

    @Override // com.bykv.vk.openvk.component.video.api.u.w.InterfaceC0013w
    public void t_() {
        this.ra = false;
        com.bytedance.sdk.openadsdk.core.am.u.hf(this.zg, this.hf);
        com.bytedance.sdk.openadsdk.u.xj.hf.xj.xj xjVar = this.f;
        if (xjVar != null) {
            this.p = true;
            xjVar.xj(this, 4);
            w(false);
        }
        am();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.presentation.xj.hf
    public void w_() {
        ws wsVar = this.hf;
        if (wsVar == null || this.v == null) {
            return;
        }
        if (hl.xj(wsVar) == 2) {
            if (this.yy.get()) {
                NativeExpressView nativeExpressView = this.b;
                if (nativeExpressView != null) {
                    nativeExpressView.zg();
                    dk.xj(this.v, this.hf, this.b);
                }
                this.v.put("splash_show_type", 3);
            }
        } else if (this.q) {
            if (TextUtils.isEmpty(h.xj(this.hf))) {
                this.v.put("splash_show_type", 2);
            }
            this.v.put("splash_show_type", 1);
        } else {
            this.v.put("splash_show_type", 0);
        }
        xj(this.hf);
    }

    @Override // com.bykv.vk.openvk.component.video.api.u.w.InterfaceC0013w
    public void xj(long j, long j2) {
    }

    public void zg() {
        NativeExpressView nativeExpressView = this.b;
        if (nativeExpressView == null) {
            return;
        }
        nativeExpressView.y(this.n);
        this.b.e();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.presentation.xj, com.bytedance.sdk.openadsdk.core.component.splash.TsView.xj
    public void d() {
        super.d();
        NativeExpressView nativeExpressView = this.b;
        if (nativeExpressView != null) {
            nativeExpressView.g();
        }
        this.b = null;
        this.c = null;
        this.y = null;
        Map<String, Object> map = this.tf;
        if (map != null) {
            map.clear();
        }
        u uVar = this.vm;
        if (uVar != null) {
            uVar.hf();
        }
        qt();
        w(false);
        am();
    }

    public void hf(int i) {
        this.n = i;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.presentation.xj, com.bytedance.sdk.openadsdk.zg.w.hf.hf
    public View hf() {
        if (this.ff == -1) {
            this.ff = 0;
        }
        return ((xj) this).xj;
    }

    public void xj(com.bytedance.sdk.openadsdk.core.component.splash.w.xj.w wVar, com.bytedance.sdk.openadsdk.core.component.splash.w.w.u<d, c> uVar) {
        this.g = 3;
        xj(uVar);
        zg();
    }

    private void xj(final com.bytedance.sdk.openadsdk.core.component.splash.w.w.u<d, c> uVar) {
        if (uVar == null || this.hf == null) {
            return;
        }
        if (this.q) {
            this.pz = true;
            yo();
        } else {
            this.pz = false;
            e();
        }
        this.et.xj(this);
        NativeExpressView nativeExpressView = this.b;
        if (nativeExpressView == null) {
            this.et.hf(3);
            this.et.xj("no render express");
            uVar.xj(this.et);
        } else {
            nativeExpressView.setBackupListener(new com.bytedance.sdk.component.adexpress.hf.w() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.presentation.hf.3
                @Override // com.bytedance.sdk.component.adexpress.hf.w
                public boolean xj(ViewGroup viewGroup, int i) {
                    try {
                        SplashExpressBackupView splashExpressBackupView = new SplashExpressBackupView(hf.this.ws);
                        hf hfVar = hf.this;
                        splashExpressBackupView.xj(hfVar.ai, hfVar.hf, (NativeExpressView) viewGroup);
                        if (splashExpressBackupView.getVideoController() instanceof com.bytedance.sdk.openadsdk.core.video.nativevideo.u) {
                            hf.this.j = (com.bytedance.sdk.openadsdk.core.video.nativevideo.u) splashExpressBackupView.getVideoController();
                        }
                        splashExpressBackupView.setVideoAdListener(hf.this);
                        hf.this.pl();
                        TsView tsView = ((xj) hf.this).xj;
                        if (tsView == null) {
                            return true;
                        }
                        tsView.xj();
                        return true;
                    } catch (Exception unused) {
                        return false;
                    }
                }
            });
            this.g = 3;
            this.b.setExpressInteractionListener(new com.bytedance.sdk.openadsdk.core.nativeexpress.xj() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.presentation.hf.4
                @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.xj
                public void xj(View view, int i) {
                    hf hfVar = hf.this;
                    com.bytedance.sdk.openadsdk.core.am.u.hf(hfVar.zg, hfVar.hf);
                    hf hfVar2 = hf.this;
                    com.bytedance.sdk.openadsdk.u.xj.hf.xj.xj xjVar = hfVar2.f;
                    if (xjVar != null) {
                        xjVar.hf(hfVar2);
                    }
                    hf.this.p();
                }

                @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.xj
                public void xj(View view, String str, int i) {
                    pl.u(MediationConstant.RIT_TYPE_SPLASH, "onRenderFail:".concat(String.valueOf(str)));
                    hf.this.et.hf(3);
                    hf.this.et.xj("render splash express fail");
                    uVar.xj(hf.this.et);
                }

                @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.xj
                public void xj(View view, float f, float f2) {
                    if (view != null && f > 0.0f && f2 > 0.0f) {
                        d dVar = new d(hf.this.en.get(), hf.this);
                        boolean pz = hf.this.b.pz();
                        if (hf.this.b != null && !pz) {
                            ((xj) hf.this).xj.setComplianceBarVisibility(8);
                        }
                        dVar.xj(pz);
                        hf.this.wo.set(pz ? 1 : 2);
                        hf.this.f10336io.set(true);
                        hf hfVar = hf.this;
                        ((xj) hfVar).xj.setExpressView(hfVar.b);
                        hf.this.yy.set(true);
                        if (hf.this.x.get()) {
                            hf hfVar2 = hf.this;
                            hfVar2.xj((WeakReference<ViewGroup>) hfVar2.hl);
                            hf.this.x.set(false);
                        }
                        if (!hf.this.d.get() && !pz && op.xj(hf.this.hf)) {
                            hf.this.pz();
                        }
                        uVar.hf(dVar);
                        hf.this.vm.xj(((xj) hf.this).xj.getEasyPlayableLayout(), hf.this.b.getVideoContainer());
                        hf.this.v();
                        return;
                    }
                    hf.this.et.hf(3);
                    hf.this.et.xj("render splash view error");
                    uVar.xj(hf.this.et);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.presentation.xj, com.bytedance.sdk.openadsdk.zg.w.hf.hf
    public void xj(ViewGroup viewGroup) {
        if (viewGroup == null) {
            pl.u(MediationConstant.RIT_TYPE_SPLASH, "展示开屏的容器不能为空");
            return;
        }
        jk();
        WeakReference<ViewGroup> weakReference = new WeakReference<>(viewGroup);
        this.hl = weakReference;
        if (this.f10336io.get() && ((xj) this).xj != null) {
            xj(weakReference);
        } else {
            this.x.set(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(WeakReference<ViewGroup> weakReference) {
        ViewGroup viewGroup;
        if (weakReference == null || (viewGroup = weakReference.get()) == null) {
            return;
        }
        if (((xj) this).xj.getParent() != null) {
            ((ViewGroup) ((xj) this).xj.getParent()).removeView(((xj) this).xj);
        }
        viewGroup.addView(((xj) this).xj);
    }

    private void xj(ws wsVar) {
        if (this.b == null || wsVar == null) {
            return;
        }
        Context context = this.ws;
        String str = this.tj;
        kd kdVar = new kd(context, wsVar, str, wo.hf(str));
        kdVar.xj(this.b);
        ((com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj) kdVar.xj(com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj.class)).xj(this.w);
        ((com.bytedance.sdk.openadsdk.core.hf.xj.w.xj) kdVar.xj(com.bytedance.sdk.openadsdk.core.hf.xj.w.xj.class)).xj(this.tf);
        this.b.setClickListener(kdVar);
        Context context2 = this.ws;
        String str2 = this.tj;
        com.bytedance.sdk.openadsdk.core.nativeexpress.u uVar = new com.bytedance.sdk.openadsdk.core.nativeexpress.u(context2, wsVar, str2, wo.hf(str2));
        ((com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj) uVar.xj(com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj.class)).xj(this);
        uVar.xj(this.b);
        ((com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj) uVar.xj(com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj.class)).xj(this.w);
        ((com.bytedance.sdk.openadsdk.core.hf.xj.w.xj) uVar.xj(com.bytedance.sdk.openadsdk.core.hf.xj.w.xj.class)).xj(this.tf);
        this.b.setClickCreativeListener(uVar);
        com.bytedance.sdk.openadsdk.core.pl.hf.w wVar = this.w;
        if (wVar != null) {
            wVar.xj(this);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.u.w.u
    public void xj(int i, int i2) {
        this.ra = false;
    }
}
