package com.bytedance.sdk.openadsdk.core.component.w;

import J3FDQU.A2egSU;
import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bykv.vk.openvk.component.video.api.u.w;
import com.bytedance.sdk.component.utils.am;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.core.a.ff;
import com.bytedance.sdk.openadsdk.core.a.r;
import com.bytedance.sdk.openadsdk.core.a.wo;
import com.bytedance.sdk.openadsdk.core.f;
import com.bytedance.sdk.openadsdk.core.live.EcMallWebView;
import com.bytedance.sdk.openadsdk.core.multipro.hf.xj;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.core.ra.h;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeDrawVideoTsView;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.mediation.MediationNativeManagerDefault;
import com.bytedance.sdk.openadsdk.mediation.manager.xj.hf.xj.kd;
import com.bytedance.sdk.openadsdk.res.layout.LazeLayout;
import com.bytedance.sdk.openadsdk.upie.image.lottie.UpieImageView;
import com.bytedance.sdk.openadsdk.x.c;
import com.bytedance.sdk.openadsdk.x.tf;
import com.bytedance.sdk.openadsdk.y.w.e;
import com.bytedance.sdk.openadsdk.zg.w.hf.g;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class u extends com.bytedance.sdk.openadsdk.zg.w.hf implements com.bykv.vk.openvk.component.video.api.hf.xj, w.u, w.InterfaceC0013w, xj.InterfaceC0173xj, LazeLayout.xj<NativeVideoTsView>, com.bytedance.sdk.openadsdk.res.layout.xj<NativeVideoTsView> {
    private volatile int am;
    private int c;
    private boolean d;
    private UpieImageView e;
    private com.bytedance.sdk.openadsdk.ht.xj.hf.hf.xj f;
    private com.bytedance.sdk.openadsdk.ht.xj.hf.xj.hf g;
    com.bytedance.sdk.openadsdk.zg.w.w.hf hf;
    private com.bytedance.sdk.openadsdk.ht.xj.hf.xj.xj kd;
    private volatile WeakReference<NativeVideoTsView> p;

    /* renamed from: pl, reason: collision with root package name */
    private WeakReference<View> f10341pl;
    private volatile boolean qt;
    private LazeLayout tf;
    private int[] u;
    int w;
    protected com.bytedance.sdk.openadsdk.core.multipro.hf.xj xj;
    private com.bytedance.sdk.openadsdk.core.dk.u y;
    private com.bytedance.sdk.openadsdk.dk.xj.hf.xj.xj yo;
    private ws zg;

    public u(Context context, ws wsVar, int i, com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar) {
        super(new com.bytedance.sdk.openadsdk.core.dk.u(context, wsVar, i, hfVar, true));
        this.u = null;
        this.d = false;
        this.tf = null;
        this.p = null;
        this.f10341pl = null;
        this.yo = new com.bytedance.sdk.openadsdk.dk.xj.hf.xj.xj(null) { // from class: com.bytedance.sdk.openadsdk.core.component.w.u.4
            @Override // com.bytedance.sdk.openadsdk.dk.xj.hf.xj.xj
            public void hf(View view, g gVar) {
                if (u.this.p == null || u.this.p.get() == null) {
                    return;
                }
                ((NativeVideoTsView) u.this.p.get()).tf();
            }

            @Override // com.bytedance.sdk.openadsdk.dk.xj.hf.xj.xj
            public void xj(g gVar) {
            }

            @Override // com.bytedance.sdk.openadsdk.dk.xj.hf.xj.xj
            public void xj(View view, g gVar) {
                if (u.this.p == null || u.this.p.get() == null) {
                    return;
                }
                ((NativeVideoTsView) u.this.p.get()).tf();
            }
        };
        com.bytedance.sdk.openadsdk.core.dk.u uVar = (com.bytedance.sdk.openadsdk.core.dk.u) en();
        this.y = uVar;
        uVar.u().xj(this);
        this.w = i;
        this.hf = hfVar;
        this.xj = new com.bytedance.sdk.openadsdk.core.multipro.hf.xj();
        this.zg = wsVar;
        int d = wo.d(wsVar);
        this.c = d;
        xj(d);
        this.y.xj(this.yo);
        if (context == null || z() || !com.bytedance.sdk.openadsdk.kd.xj.f(wsVar)) {
            return;
        }
        this.e = new UpieImageView(context, com.bytedance.sdk.openadsdk.kd.xj.d(wsVar), null);
    }

    private boolean a() {
        if (this.y.io() == null || this.g == null) {
            return false;
        }
        int qd = this.y.io().qd();
        return qd == 1 || qd == 2;
    }

    private int[] ff() {
        if (this.y.io() == null) {
            return null;
        }
        if (this.y.io().rx() == 166 && com.bytedance.sdk.openadsdk.core.ra.wo.xj(this.y.io())) {
            return new int[]{com.bytedance.sdk.openadsdk.core.ra.wo.pl(this.y.io()), com.bytedance.sdk.openadsdk.core.ra.wo.g(this.y.io())};
        }
        if (this.y.io().ul() == 1 && this.y.io().ic() == 1 && h.qt(this.y.io()) != null) {
            return h.qt(this.y.io()).tf();
        }
        if (h.am(this.y.io()) != null) {
            return h.am(this.y.io()).tf();
        }
        return null;
    }

    private View l() {
        View view;
        WeakReference<View> weakReference = this.f10341pl;
        if (weakReference != null && (view = weakReference.get()) != null) {
            return view;
        }
        EcMallWebView ecMallWebView = new EcMallWebView(this.y.getContext(), this.y.io(), this.w == 9 ? 6 : 1);
        ecMallWebView.setMaterialMeta(ff.xj(this.zg));
        this.f10341pl = new WeakReference<>(ecMallWebView);
        return ecMallWebView;
    }

    public int ai() {
        return this.c;
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf, com.bytedance.sdk.openadsdk.zg.w.hf.g
    public void dk() {
        NativeVideoTsView nativeVideoTsView;
        if (this.p != null && (nativeVideoTsView = this.p.get()) != null) {
            nativeVideoTsView.v();
        }
        LazeLayout lazeLayout = this.tf;
        if (lazeLayout != null) {
            lazeLayout.xj();
        }
        UpieImageView upieImageView = this.e;
        if (upieImageView != null) {
            upieImageView.setOnClickListener(null);
        }
        super.dk();
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.g
    public kd et() {
        return new MediationNativeManagerDefault();
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf, com.bytedance.sdk.openadsdk.zg.w.hf.g
    public Map<String, Object> ht() {
        Map<String, Object> ht = this.y.ht();
        if (this.y.io() != null && this.y.io().rx() == 166 && com.bytedance.sdk.openadsdk.core.video.w.xj.xj(this.y.io())) {
            int u = com.bytedance.sdk.openadsdk.core.ra.wo.u(this.y.io());
            int kd = com.bytedance.sdk.openadsdk.core.ra.wo.kd(this.y.io());
            if (ht == null) {
                ht = new HashMap<>();
            }
            ht.put("live_author_follower_count", Integer.valueOf(u));
            ht.put("live_watch_count", Integer.valueOf(kd));
        }
        return ht;
    }

    public NativeVideoTsView io() {
        if (this.p != null) {
            return this.p.get();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.multipro.hf.xj.InterfaceC0173xj
    public com.bytedance.sdk.openadsdk.core.multipro.hf.xj j() {
        return this.xj;
    }

    @Override // com.bykv.vk.openvk.component.video.api.u.w.u
    public void p_() {
        com.bytedance.sdk.openadsdk.ht.xj.hf.xj.xj xjVar = this.kd;
        if (xjVar != null) {
            xjVar.xj(this);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf, com.bytedance.sdk.openadsdk.zg.w.hf.g
    public View pz() {
        NativeVideoTsView nativeVideoTsView;
        NativeVideoTsView nativeVideoTsView2 = null;
        if (this.y.io() == null || this.y.getContext() == null) {
            return null;
        }
        if (com.bytedance.sdk.openadsdk.core.live.kd.u.xj(this.y.io())) {
            return l();
        }
        Context context = this.y.getContext();
        if (z()) {
            if (!c.xj() || !pz.hf().az().hf) {
                try {
                    nativeVideoTsView2 = hf(context);
                } catch (Throwable unused) {
                }
                if (nativeVideoTsView2 != null) {
                    xj(nativeVideoTsView2);
                }
                pl.u("wzj", "5-如果本身不在主线程，直接按原来的逻辑处理-TTAdFeedAd:140016:view=".concat(String.valueOf(nativeVideoTsView2)));
                return nativeVideoTsView2;
            }
            if (this.p != null && (nativeVideoTsView = this.p.get()) != null) {
                return nativeVideoTsView;
            }
            this.tf = new LazeLayout(context, this, this);
            pl.u("wzj", "4-验证子线程创建的效果-TTAdFeedAd:140016:lazeLayout=" + this.tf);
        } else if (this.e != null) {
            com.bytedance.sdk.openadsdk.core.dk.u uVar = this.y;
            if (uVar != null && uVar.u() != null) {
                this.y.u().xj(this.e);
            }
            return this.e;
        }
        com.bytedance.sdk.openadsdk.core.c.u.xj().xj(this.y.io()).xj(this.w).hf(this.c);
        pl.u("wzj", "6-TTAdFeedAd:140016:lazeLayout=" + this.tf);
        return this.tf;
    }

    @Override // com.bytedance.sdk.openadsdk.core.multipro.hf.xj.InterfaceC0173xj
    public boolean q() {
        return this.d;
    }

    @Override // com.bykv.vk.openvk.component.video.api.u.w.InterfaceC0013w
    public void q_() {
        com.bytedance.sdk.openadsdk.ht.xj.hf.xj.xj xjVar = this.kd;
        if (xjVar != null) {
            xjVar.hf(this);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.u.w.InterfaceC0013w
    public void r_() {
        com.bytedance.sdk.openadsdk.ht.xj.hf.xj.xj xjVar = this.kd;
        if (xjVar != null) {
            xjVar.w(this);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.u.w.InterfaceC0013w
    public void s_() {
        com.bytedance.sdk.openadsdk.ht.xj.hf.xj.xj xjVar = this.kd;
        if (xjVar != null) {
            xjVar.u(this);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.u.w.InterfaceC0013w
    public void t_() {
        com.bytedance.sdk.openadsdk.ht.xj.hf.xj.xj xjVar = this.kd;
        if (xjVar != null) {
            xjVar.kd(this);
        }
        if (!a() || this.qt) {
            return;
        }
        this.g.xj(0);
        this.qt = true;
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.tf
    public int u() {
        com.bytedance.sdk.openadsdk.core.dk.u uVar = this.y;
        if (uVar != null) {
            ws io2 = uVar.io();
            int e = this.y.e();
            if (com.bytedance.sdk.openadsdk.kd.xj.f(io2) && (e == 5 || e == 15)) {
                return io2.lx().get(0).w();
            }
        }
        try {
            if (this.u == null) {
                this.u = ff();
            }
            int[] iArr = this.u;
            if (iArr != null && iArr.length >= 2) {
                return iArr[1];
            }
            return 720;
        } catch (Throwable th) {
            pl.w("TTFeedAdImpl", "getAdViewHeight error", th);
            return 720;
        }
    }

    public int x() {
        return this.w;
    }

    public boolean z() {
        return ws.hf(this.y.io());
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.tf
    public int w() {
        com.bytedance.sdk.openadsdk.core.dk.u uVar = this.y;
        if (uVar != null) {
            ws io2 = uVar.io();
            int e = this.y.e();
            if (com.bytedance.sdk.openadsdk.kd.xj.f(io2) && (e == 5 || e == 15)) {
                return io2.lx().get(0).hf();
            }
        }
        try {
            if (this.u == null) {
                this.u = ff();
            }
            int[] iArr = this.u;
            if (iArr != null && iArr.length >= 2) {
                return iArr[0];
            }
            return 1280;
        } catch (Throwable th) {
            pl.w("TTFeedAdImpl", "getAdViewWidth error", th);
            return 1280;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.tf
    public com.bytedance.sdk.openadsdk.ht.xj.hf.hf.xj hf() {
        if (!ws.xj(this.y.io())) {
            return null;
        }
        if (this.f == null) {
            this.f = new com.bytedance.sdk.openadsdk.ht.xj.hf.hf.xj() { // from class: com.bytedance.sdk.openadsdk.core.component.w.u.3
                private long hf = 0;

                @Override // com.bytedance.sdk.openadsdk.ht.xj.hf.hf.xj
                public void hf() {
                    this.hf = SystemClock.elapsedRealtime();
                    e.xj xjVar = new e.xj();
                    xjVar.hf(true);
                    xjVar.xj(true);
                    com.bytedance.sdk.openadsdk.y.hf.u.xj(u.this, xjVar);
                }

                @Override // com.bytedance.sdk.openadsdk.ht.xj.hf.hf.xj
                public void u() {
                    com.bytedance.sdk.openadsdk.core.am.u.xj(u.this.y.io(), wo.hf(u.this.y.io()), "feed_auto_play", 0L, 0, (Map<String, Object>) null);
                    if (h.am(u.this.y.io()) != null) {
                        com.bykv.vk.openvk.component.video.api.w.u xj = h.xj(4, u.this.y.io());
                        xj.xj("material_meta", u.this.y.io());
                        com.bytedance.sdk.openadsdk.zg.w.w.hf gh = u.this.y.io().gh();
                        xj.xj("ad_slot", Integer.valueOf(gh != null ? gh.jk() : 0));
                        xj.kd(-1);
                        com.bytedance.sdk.openadsdk.y.hf.u.xj(u.this.y.io(), (com.bykv.vk.openvk.component.video.api.hf.xj) u.this, xj, true);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.ht.xj.hf.hf.xj
                public void w() {
                    if (this.hf == 0) {
                        this.hf = SystemClock.elapsedRealtime();
                    }
                    long xj = ((long) u.this.xj()) * 1000;
                    long elapsedRealtime = (SystemClock.elapsedRealtime() - this.hf) - xj;
                    long j = elapsedRealtime >= 0 ? elapsedRealtime : 0L;
                    e.xj xjVar = new e.xj();
                    xjVar.xj(xj);
                    xjVar.w(xj);
                    xjVar.hf(j);
                    xjVar.y(0);
                    xjVar.xj(true);
                    com.bytedance.sdk.openadsdk.y.hf.u.u(u.this, xjVar);
                }

                @Override // com.bytedance.sdk.openadsdk.ht.xj.hf.hf.xj
                public String xj() {
                    if (u.this.y.io() == null || u.this.y.io().eu() != 1 || h.am(u.this.y.io()) == null) {
                        return null;
                    }
                    if (!u.this.d) {
                        u.this.d = true;
                    }
                    return h.xj(u.this.y.io());
                }

                @Override // com.bytedance.sdk.openadsdk.ht.xj.hf.hf.xj
                public void hf(long j) {
                    if (this.hf == 0) {
                        this.hf = SystemClock.elapsedRealtime();
                    }
                    long elapsedRealtime = (SystemClock.elapsedRealtime() - this.hf) - j;
                    long j2 = elapsedRealtime >= 0 ? elapsedRealtime : 0L;
                    e.xj xjVar = new e.xj();
                    xjVar.xj(j);
                    xjVar.w(((long) u.this.xj()) * 1000);
                    xjVar.hf(j2);
                    xjVar.xj(true);
                    com.bytedance.sdk.openadsdk.y.hf.u.hf(u.this, xjVar);
                }

                @Override // com.bytedance.sdk.openadsdk.ht.xj.hf.hf.xj
                public void xj(long j) {
                    if (this.hf == 0) {
                        this.hf = SystemClock.elapsedRealtime();
                    }
                    long elapsedRealtime = (SystemClock.elapsedRealtime() - this.hf) - j;
                    long j2 = elapsedRealtime >= 0 ? elapsedRealtime : 0L;
                    e.xj xjVar = new e.xj();
                    xjVar.xj(j);
                    xjVar.w(((long) u.this.xj()) * 1000);
                    xjVar.hf(j2);
                    xjVar.xj(true);
                    com.bytedance.sdk.openadsdk.y.hf.u.xj(u.this, xjVar, -1);
                }

                @Override // com.bytedance.sdk.openadsdk.ht.xj.hf.hf.xj
                public void w(long j) {
                    if (this.hf == 0) {
                        this.hf = SystemClock.elapsedRealtime();
                    }
                    long xj = ((long) u.this.xj()) * 1000;
                    long elapsedRealtime = (SystemClock.elapsedRealtime() - this.hf) - j;
                    long j2 = elapsedRealtime >= 0 ? elapsedRealtime : 0L;
                    e.xj xjVar = new e.xj();
                    xjVar.xj(j);
                    xjVar.w(xj);
                    xjVar.hf(j2);
                    xjVar.kd(0);
                    xjVar.y(0);
                    xjVar.xj(true);
                    com.bytedance.sdk.openadsdk.y.hf.u.xj(u.this, xjVar, (Map<String, Object>) null, -1);
                }

                @Override // com.bytedance.sdk.openadsdk.ht.xj.hf.hf.xj
                public void xj(int i, int i2) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("creative_id", u.this.y.io().ho());
                    hashMap.put("error_code", Integer.valueOf(i));
                    A2egSU.BNL6CD(i2, hashMap, "extra_error_code", 1, "is_customer");
                    com.bykv.vk.openvk.component.video.api.w.w am = h.am(u.this.y.io());
                    if (am != null) {
                        hashMap.put("video_size", Long.valueOf(am.kd()));
                        hashMap.put("video_resolution", am.d());
                    }
                    com.bytedance.sdk.openadsdk.core.am.u.w(u.this.y.io(), wo.hf(u.this.y.io()), "play_start_error", hashMap);
                }

                @Override // com.bytedance.sdk.openadsdk.ht.xj.hf.hf.xj
                public void xj(long j, int i, int i2) {
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    if (this.hf == 0) {
                        this.hf = elapsedRealtime;
                    }
                    long j2 = elapsedRealtime - this.hf;
                    long xj = ((long) u.this.xj()) * 1000;
                    long j3 = j2 - j;
                    if (j3 < 0) {
                        j3 = 0;
                    }
                    int i3 = j2 == 0 ? 1 : 0;
                    e.xj xjVar = new e.xj();
                    xjVar.hf(j3);
                    xjVar.w(xj);
                    xjVar.xj(j);
                    xjVar.xj(i);
                    xjVar.hf(i2);
                    xjVar.xj(true);
                    com.bytedance.sdk.openadsdk.y.hf.u.xj(u.this, xjVar, "customer error", i3, false);
                }
            };
        }
        return this.f;
    }

    public NativeVideoTsView xj(boolean z) {
        NativeVideoTsView nativeVideoTsView;
        if (z) {
            nativeVideoTsView = new NativeDrawVideoTsView(this.y.getContext(), this.y.io());
        } else {
            nativeVideoTsView = new NativeVideoTsView(this.y.getContext(), this.y.io(), false, false, wo.hf(this.w), false, false);
        }
        this.p = new WeakReference<>(nativeVideoTsView);
        this.y.xj(this.p);
        this.y.hf();
        return nativeVideoTsView;
    }

    private void hf(long j, long j2) {
        int i;
        if (a() && !this.qt) {
            int qd = this.y.io().qd();
            long j3 = qd == 1 ? 15000L : qd == 2 ? 30000L : 0L;
            if (j2 <= j3) {
                i = (int) ((j2 - j) / 1000);
            } else {
                i = (int) ((j3 - j) / 1000);
            }
            if (i < 0) {
                i = 0;
            }
            if (i == this.am) {
                return;
            }
            this.am = i;
            if (this.am == 0) {
                this.qt = true;
            }
            this.g.xj(this.am);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.res.layout.xj
    /* renamed from: xj, reason: merged with bridge method [inline-methods] */
    public NativeVideoTsView hf(Context context) {
        NativeVideoTsView xj = xj(false);
        xj.setVideoAdClickListenerTTNativeAd(this);
        xj.setAdCreativeClickListener(new NativeVideoTsView.xj() { // from class: com.bytedance.sdk.openadsdk.core.component.w.u.1
            @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.xj
            public void xj(View view, int i) {
                if (u.this.y.u() != null) {
                    u.this.y.u().xj(view, i);
                }
            }
        });
        f.zg().xj(-1L);
        xj.setControllerStatusCallBack(new NativeVideoTsView.u() { // from class: com.bytedance.sdk.openadsdk.core.component.w.u.2
            @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.u
            public void xj(boolean z, long j, long j2, long j3, boolean z2, boolean z3) {
                com.bytedance.sdk.openadsdk.core.multipro.hf.xj xjVar = u.this.xj;
                if (xjVar != null) {
                    xjVar.xj = z;
                    xjVar.kd = j;
                    xjVar.y = j2;
                    xjVar.c = j3;
                    xjVar.u = z2;
                    xjVar.f = z3;
                }
            }
        });
        xj.setVideoAdLoadListener(this);
        xj.setVideoAdInteractionListener(this);
        if (5 == this.w) {
            xj.setIsAutoPlay(this.y.ai() ? this.hf.kd() : this.y.x());
        } else {
            xj.setIsAutoPlay(this.y.x());
        }
        xj.setIsQuiet(pz.hf().u(this.c));
        com.bytedance.sdk.openadsdk.core.pl.hf.w xj2 = this.y.u().xj();
        if (xj2 != null) {
            xj2.xj(this);
        }
        return xj;
    }

    @Override // com.bytedance.sdk.openadsdk.res.layout.LazeLayout.xj
    public void xj(NativeVideoTsView nativeVideoTsView) {
        if (nativeVideoTsView != null) {
            nativeVideoTsView.xj(0L, true, false);
        }
    }

    private void xj(int i) {
        int c = pz.hf().c(i);
        if (3 == c) {
            this.y.hf(false);
            this.y.xj(false);
            return;
        }
        if (1 == c && am.u(this.y.getContext())) {
            this.y.hf(false);
        } else if (2 == c) {
            if (!am.kd(this.y.getContext()) && !am.u(this.y.getContext()) && !am.y(this.y.getContext())) {
                return;
            } else {
                this.y.hf(false);
            }
        } else if (4 == c) {
            this.y.hf(true);
            return;
        } else {
            if (5 != c) {
                return;
            }
            if (!am.u(this.y.getContext()) && !am.y(this.y.getContext())) {
                return;
            }
        }
        this.y.xj(true);
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.tf
    public void xj(com.bytedance.sdk.openadsdk.ht.xj.hf.xj.xj xjVar) {
        this.kd = xjVar;
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.tf
    public double xj() {
        if (tf.xj(this.y.io())) {
            return 0.0d;
        }
        return h.y(this.y.io());
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.tf
    public void xj(com.bytedance.sdk.openadsdk.ht.xj.hf.xj.hf hfVar) {
        this.g = hfVar;
    }

    @Override // com.bykv.vk.openvk.component.video.api.u.w.u
    public void xj(int i, int i2) {
        com.bytedance.sdk.openadsdk.ht.xj.hf.xj.xj xjVar = this.kd;
        if (xjVar != null) {
            xjVar.xj(i, i2);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.u.w.InterfaceC0013w
    public void xj(long j, long j2) {
        com.bytedance.sdk.openadsdk.ht.xj.hf.xj.xj xjVar = this.kd;
        if (xjVar != null) {
            xjVar.xj(j, j2);
        }
        hf(j, j2);
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.g
    public void xj(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, com.bytedance.sdk.openadsdk.dk.xj.hf.xj.xj xjVar, com.bytedance.sdk.openadsdk.mediation.ad.xj.hf.xj.u uVar) {
        View pz;
        try {
            xj(viewGroup, (List<View>) null, list, list2, list3, (View) null, xjVar);
            if (uVar != null) {
                View findViewById = viewGroup.findViewById(uVar.pl());
                if (findViewById != null && y() != null) {
                    findViewById.setVisibility(0);
                    if (findViewById instanceof ViewGroup) {
                        ((ViewGroup) findViewById).removeAllViews();
                        ImageView imageView = new ImageView(viewGroup.getContext());
                        imageView.setImageBitmap(y());
                        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                        ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
                        layoutParams.width = r.w(viewGroup.getContext(), 38.0f);
                        layoutParams.height = r.w(viewGroup.getContext(), 38.0f);
                        findViewById.setLayoutParams(layoutParams);
                        ((ViewGroup) findViewById).addView(imageView, -1, -1);
                    } else if (findViewById instanceof ImageView) {
                        ((ImageView) findViewById).setImageBitmap(y());
                    }
                }
                FrameLayout frameLayout = (FrameLayout) viewGroup.findViewById(uVar.c());
                if (frameLayout != null && (pz = pz()) != null) {
                    r.f(pz);
                    frameLayout.removeAllViews();
                    frameLayout.addView(pz, -1, -1);
                }
            }
        } catch (Throwable th) {
            pl.xj(th);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.g
    public void xj(com.bytedance.sdk.openadsdk.dk.xj.hf.xj.hf hfVar) {
        com.bytedance.sdk.openadsdk.core.dk.u uVar = this.y;
        if (uVar != null) {
            uVar.xj(hfVar);
        }
    }
}
