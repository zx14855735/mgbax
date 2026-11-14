package com.bytedance.sdk.openadsdk.core.component.splash;

import B4ZgIw.AYUAbz;
import J3FDQU.A2egSU;
import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.bytedance.sdk.component.utils.ai;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.core.a.wo;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.core.ra.gh;
import com.bytedance.sdk.openadsdk.core.ra.hl;
import com.bytedance.sdk.openadsdk.core.ra.qd;
import com.bytedance.sdk.openadsdk.core.ra.tj;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class kd implements ai.xj {
    private long am;
    private int c;
    private com.bytedance.sdk.openadsdk.core.component.splash.xj.xj d;
    private com.bytedance.sdk.openadsdk.core.component.splash.w.xj.u dk;
    private com.bytedance.sdk.openadsdk.core.component.splash.w.xj.y e;
    private com.bytedance.sdk.openadsdk.core.component.splash.w.xj.u et;
    private com.bytedance.sdk.openadsdk.core.component.splash.w.xj.c eu;
    private int f;
    private long g;
    private com.bytedance.sdk.openadsdk.zg.w.w.hf hf;
    private gh ht;
    private com.bytedance.sdk.openadsdk.core.component.splash.w.xj.d jk;
    private Context kd;
    private long p;

    /* renamed from: pl, reason: collision with root package name */
    private long f10334pl;
    private com.bytedance.sdk.openadsdk.core.component.splash.w.xj.d pz;
    private long qt;
    private gh ra;
    private xj tf;
    private com.bytedance.sdk.openadsdk.zg.w.hf.hf v;
    private tj w;
    private com.bytedance.sdk.openadsdk.core.component.splash.w.w.kd ws;
    private final ai y;
    private com.bytedance.sdk.openadsdk.core.component.splash.w.xj.f yo;
    private com.bytedance.sdk.openadsdk.core.component.splash.w.xj.y zg;
    private int xj = 2;
    private com.bytedance.sdk.openadsdk.jk.xj.hf.xj.xj u = null;

    /* renamed from: io, reason: collision with root package name */
    private final AtomicBoolean f10333io = new AtomicBoolean(false);
    private final AtomicBoolean x = new AtomicBoolean(false);
    private final AtomicBoolean ai = new AtomicBoolean(false);
    private final AtomicBoolean q = new AtomicBoolean(false);
    private final AtomicBoolean z = new AtomicBoolean(false);
    private final AtomicBoolean j = new AtomicBoolean(false);
    private final AtomicInteger en = new AtomicInteger(0);
    private final AtomicBoolean l = new AtomicBoolean(false);
    private final AtomicBoolean ff = new AtomicBoolean(false);

    /* renamed from: a, reason: collision with root package name */
    private final AtomicBoolean f10332a = new AtomicBoolean(false);
    private final AtomicBoolean wo = new AtomicBoolean(false);
    private final AtomicInteger r = new AtomicInteger(0);
    private boolean b = false;
    private final hf tj = new hf();

    public class xj {
        private final AtomicBoolean hf = new AtomicBoolean(false);

        public xj() {
        }

        private void u(final com.bytedance.sdk.openadsdk.core.component.splash.w.xj.c cVar) {
            if (cVar == null) {
                return;
            }
            com.bytedance.sdk.openadsdk.x.c.xj(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.kd.xj.1
                @Override // java.lang.Runnable
                public void run() {
                    if (kd.this.u != null) {
                        kd.this.u.xj(cVar.d(), new com.bytedance.sdk.openadsdk.zg.w.w(cVar.u(), cVar.kd()));
                        com.bytedance.sdk.openadsdk.core.c.xj.xj("Splash_FullLink", "onSplashRenderFail回调 true " + cVar.u());
                    }
                }
            });
            kd.this.w();
        }

        public void hf(final com.bytedance.sdk.openadsdk.core.component.splash.w.xj.c cVar) {
            if (cVar == null) {
                return;
            }
            kd.this.d();
            if (this.hf.get()) {
                return;
            }
            this.hf.set(true);
            com.bytedance.sdk.openadsdk.x.c.xj(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.kd.xj.3
                @Override // java.lang.Runnable
                public void run() {
                    if (kd.this.u != null) {
                        if (kd.this.en.get() > 0) {
                            kd.this.u.xj(null, new com.bytedance.sdk.openadsdk.zg.w.w(1, "load splash material fail"));
                        } else {
                            kd.this.u.xj(new com.bytedance.sdk.openadsdk.zg.w.w(cVar.u(), cVar.kd()));
                        }
                    }
                }
            });
            kd.this.w();
            com.bytedance.sdk.openadsdk.core.c.xj.u("Splash_FullLink", "onSplashLoadFail 素材加载加载失败 code: " + cVar.u());
            y.xj(cVar.f(), kd.this.xj(cVar.f()), kd.this.hf, cVar);
        }

        public void w(com.bytedance.sdk.openadsdk.core.component.splash.w.xj.c cVar) {
            kd.this.d();
            if (this.hf.get()) {
                return;
            }
            this.hf.set(true);
            y.xj(cVar.f(), kd.this.xj(cVar.f()), kd.this.hf, cVar);
            u(cVar);
            pl.u("SplashLoadManager", "渲染失败 code " + cVar.u() + " msg " + cVar.kd());
        }

        public void xj(final com.bytedance.sdk.openadsdk.core.component.splash.w.xj.c cVar) {
            if (cVar == null) {
                return;
            }
            kd.this.d();
            if (this.hf.get()) {
                return;
            }
            this.hf.set(true);
            com.bytedance.sdk.openadsdk.x.c.xj(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.kd.xj.2
                @Override // java.lang.Runnable
                public void run() {
                    if (kd.this.u != null) {
                        if (cVar.u() == 22) {
                            cVar.hf(1);
                        }
                        kd.this.u.xj(new com.bytedance.sdk.openadsdk.zg.w.w(cVar.u(), cVar.kd()));
                        com.bytedance.sdk.openadsdk.core.c.xj.xj("Splash_FullLink", "onSplashLoadFail 回调");
                    }
                }
            });
            xj(false, true, (Object) null);
            kd.this.w();
            com.bytedance.sdk.openadsdk.core.c.xj.xj("Splash_FullLink", "onLoadSplashAdFail回调 广告获取失败");
            y.xj(cVar.f(), kd.this.xj(cVar.f()), kd.this.hf, cVar);
        }

        public boolean w() {
            return this.hf.get();
        }

        public void hf() {
            if (this.hf.get()) {
                return;
            }
            com.bytedance.sdk.openadsdk.core.c.xj.xj("Splash_FullLink", "触发 buffer_time超时 开始给加载成功回调以及开始渲染");
            kd.this.f();
        }

        public void xj(com.bytedance.sdk.openadsdk.core.component.splash.w.xj.f fVar) {
            if (this.hf.get() || fVar == null) {
                return;
            }
            gh ghVar = fVar.p() ? kd.this.ra : kd.this.ht;
            if (ghVar != null) {
                ghVar.y(fVar.xj());
                ghVar.yo(fVar.am());
                ghVar.pz(System.currentTimeMillis() - ghVar.dk());
            }
            xj(kd.this.u, ghVar, fVar.hf(), fVar.pl(), fVar.p(), fVar.qt());
        }

        private void xj(com.bytedance.sdk.openadsdk.jk.xj.hf.xj.xj xjVar, gh ghVar, ws wsVar, com.bytedance.sdk.openadsdk.zg.w.hf.hf hfVar, boolean z, boolean z2) {
            if (xjVar == null || ghVar == null || kd.this.en.get() > 0) {
                return;
            }
            if (kd.this.xj(wsVar)) {
                kd kdVar = kd.this;
                y.xj(z ? kdVar.ra : kdVar.ht, 2);
                kd.this.d();
            }
            kd.this.f10332a.set(z);
            kd.this.en.set(1);
            long currentTimeMillis = System.currentTimeMillis();
            xj(hfVar, 1);
            xjVar.xj(hfVar);
            kd.this.en.set(2);
            com.bytedance.sdk.openadsdk.core.c.xj.xj("Splash_FullLink", "onSplashLoadSuccess() 媒体处理完成");
            xj(z, false, (Object) hfVar);
            ghVar.e(System.currentTimeMillis() - currentTimeMillis);
            if (z2) {
                y.xj(kd.this.kd, ghVar, wsVar, z, currentTimeMillis);
            }
        }

        public void xj(final com.bytedance.sdk.openadsdk.core.component.splash.w.xj.d dVar) {
            kd.this.d();
            if (this.hf.get()) {
                return;
            }
            this.hf.set(true);
            boolean z = dVar != null && dVar.w();
            kd.this.xj(dVar);
            kd kdVar = kd.this;
            kdVar.xj(z, z ? kdVar.ra : kdVar.ht);
            com.bytedance.sdk.openadsdk.x.c.xj(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.kd.xj.4
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.openadsdk.core.component.splash.w.xj.d dVar2;
                    if (kd.this.u == null || (dVar2 = dVar) == null) {
                        return;
                    }
                    xj.this.xj(dVar2.xj(), 2);
                    kd.this.u.hf(dVar.xj());
                }
            });
        }

        public void xj() {
            com.bytedance.sdk.openadsdk.core.c.xj.xj("Splash_FullLink", "onTimeOut start");
            kd.this.f10333io.set(true);
            if (this.hf.get()) {
                return;
            }
            this.hf.set(true);
            if (kd.this.ws != null) {
                kd.this.ws.xj();
            }
            com.bytedance.sdk.openadsdk.core.c.xj.xj("Splash_FullLink", "开屏超时");
            if (kd.this.u != null) {
                if (kd.this.en.get() > 0) {
                    kd.this.u.xj(null, new com.bytedance.sdk.openadsdk.zg.w.w(3, "load success but render fail"));
                } else {
                    kd.this.u.xj(new com.bytedance.sdk.openadsdk.zg.w.w(23, "load splash time out"));
                }
                com.bytedance.sdk.openadsdk.core.c.xj.xj("Splash_FullLink", "回调开屏超时 true");
                kd.this.w();
            }
            boolean z = kd.this.b;
            kd kdVar = kd.this;
            y.xj(z, kdVar.xj(kdVar.b), kd.this.hf, new com.bytedance.sdk.openadsdk.core.component.splash.w.xj.c(23, "load splash time out", kd.this.b));
            boolean z2 = kd.this.b;
            kd kdVar2 = kd.this;
            y.xj(z2, kdVar2.xj(kdVar2.b), kd.this.hf);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void xj(com.bytedance.sdk.openadsdk.zg.w.hf.hf hfVar, int i) {
            if (hfVar instanceof com.bytedance.sdk.openadsdk.core.component.splash.presentation.xj) {
                ((com.bytedance.sdk.openadsdk.core.component.splash.presentation.xj) hfVar).xj(i);
            }
        }

        private void xj(boolean z, boolean z2, Object obj) {
            ws xj = kd.this.xj(true);
            if (kd.this.d == null || xj == null) {
                return;
            }
            String zf = xj.zf();
            kd.this.d.xj(kd.this.hf.u(), zf, z, z2, obj);
        }
    }

    private kd(Context context) {
        if (context != null) {
            this.kd = context.getApplicationContext();
        } else {
            this.kd = pz.getContext();
        }
        this.y = new ai(Looper.getMainLooper(), this);
        this.tf = new xj();
        com.bytedance.sdk.openadsdk.core.f.zg().f(false);
        p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        com.bytedance.sdk.openadsdk.core.c.xj.xj("Splash_FullLink", "startCallBackWhenBufferTimeout ");
        this.tf.xj(this.yo);
        this.ff.set(true);
        if (!this.q.get() || this.l.get()) {
            return;
        }
        this.l.set(true);
        com.bytedance.sdk.openadsdk.core.c.xj.xj("Splash_FullLink", "素材加载和渲染并发 buffer_time超时 缓存素材加载成功，渲染成功开始给 onRenderSplashSuccess回调");
        this.tf.xj(this.pz);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        ai aiVar = this.y;
        if (aiVar != null) {
            aiVar.removeMessages(4);
        }
        ai aiVar2 = this.y;
        if (aiVar2 != null) {
            aiVar2.removeMessages(2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (this.tf == null) {
            return;
        }
        if (hf(xj(true), true)) {
            AtomicBoolean atomicBoolean = this.x;
            if (atomicBoolean == null || !atomicBoolean.get()) {
                return;
            }
            com.bytedance.sdk.openadsdk.core.c.xj.xj("Splash_FullLink", "buffer_time超时-并发 缓存素材加载成功，开始给加载成功回调");
            com.bytedance.sdk.openadsdk.core.component.splash.w.xj.f fVar = this.yo;
            if (fVar != null) {
                fVar.xj(this.v);
            }
            final long currentTimeMillis = System.currentTimeMillis();
            com.bytedance.sdk.openadsdk.x.c.xj(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.kd.4
                @Override // java.lang.Runnable
                public void run() {
                    y.u(kd.this.ra, currentTimeMillis);
                    kd.this.c();
                }
            });
            return;
        }
        AtomicBoolean atomicBoolean2 = this.x;
        if (atomicBoolean2 == null || !atomicBoolean2.get()) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.c.xj.xj("Splash_FullLink", "buffer_time超时-串行 缓存素材加载成功，开始给加载成功回调以及开始渲染");
        final com.bytedance.sdk.openadsdk.core.component.splash.w.w.xj hf = hf(this.e, this.yo, this.tf);
        com.bytedance.sdk.openadsdk.core.component.splash.w.xj.f fVar2 = this.yo;
        if (fVar2 != null) {
            fVar2.xj(hf.xj());
        }
        final long currentTimeMillis2 = System.currentTimeMillis();
        com.bytedance.sdk.openadsdk.x.c.xj(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.kd.5
            @Override // java.lang.Runnable
            public void run() {
                y.u(kd.this.ra, currentTimeMillis2);
                kd.this.tf.xj(kd.this.yo);
                kd kdVar = kd.this;
                kdVar.xj(kdVar.e, hf, kd.this.yo.kd());
            }
        });
    }

    private boolean g() {
        return (com.bytedance.sdk.openadsdk.core.w.kd.xj().p() & 4) == 4;
    }

    private void p() {
        this.ht = new gh();
        gh ghVar = new gh();
        this.ra = ghVar;
        y.xj(this.ht, ghVar);
        this.dk = new com.bytedance.sdk.openadsdk.core.component.splash.w.xj.u();
        this.et = new com.bytedance.sdk.openadsdk.core.component.splash.w.xj.u();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean pl() {
        return this.xj == 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tf() {
        if (com.bytedance.sdk.openadsdk.core.component.splash.w.w.kd.xj(this.hf, this.w)) {
            return;
        }
        this.d.xj(new qd(this.zg.u(), this.zg.hf(), null), this.hf, true);
    }

    private void y() {
        ai aiVar = this.y;
        if (aiVar != null) {
            aiVar.removeMessages(4);
        }
        xj xjVar = this.tf;
        if (xjVar != null) {
            xjVar.hf();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kd() {
        int optInt;
        com.bytedance.sdk.openadsdk.core.component.splash.w.xj.y yVar = this.e;
        if (yVar != null && yVar.hf() != null && this.e.hf().m7if() != null && (optInt = this.e.hf().m7if().optInt("real_drop_cache_type", 0)) == 1) {
            com.bytedance.sdk.openadsdk.core.c.xj.xj("SplashLoadManager", "loadCacheWhenRealAdDrop - 缓存兜底返回配置 realDropCacheType： " + optInt);
            y();
            return;
        }
        if (this.tj.xj()) {
            com.bytedance.sdk.openadsdk.core.c.xj.xj("SplashLoadManager", "loadCacheWhenRealAdDrop - 计分模式下允许兜底缓存： ");
            y();
        } else {
            xj xjVar = this.tf;
            if (xjVar != null) {
                xjVar.xj(this.eu);
            }
        }
    }

    private void u() {
        com.bytedance.sdk.openadsdk.core.component.splash.xj.xj xjVar = this.d;
        if (xjVar != null) {
            xjVar.hf(this.hf, this.w);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        int i;
        if (com.bytedance.sdk.openadsdk.core.component.splash.xj.xj.xj(this.xj) && ((i = this.xj) == 1 || i == 3)) {
            return;
        }
        u();
    }

    private void hf() {
        this.f10333io.set(false);
        this.x.set(false);
        this.ai.set(false);
        this.q.set(false);
        this.l.set(false);
        this.ff.set(false);
        this.z.set(false);
        this.j.set(false);
        this.f10332a.set(false);
        this.wo.set(false);
    }

    private void u(boolean z) {
        if (z) {
            this.qt = System.currentTimeMillis();
        } else {
            this.am = System.currentTimeMillis();
        }
    }

    private void y(boolean z) {
        if (this.y != null) {
            if (pl()) {
                if (z) {
                    return;
                } else {
                    this.y.removeMessages(4);
                }
            }
            this.y.removeMessages(2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean w(boolean z) {
        return z && pl();
    }

    private int w(ws wsVar) {
        return Math.max(com.bytedance.sdk.openadsdk.core.w.kd.xj().am(), (this.f - ((int) (System.currentTimeMillis() - this.p))) - (wsVar != null ? hl.kd(wsVar) : 100));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kd(boolean z) {
        if (z) {
            this.et.w(System.currentTimeMillis() - this.qt);
        } else {
            this.dk.w(System.currentTimeMillis() - this.am);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean hf(boolean z) {
        com.bytedance.sdk.openadsdk.core.component.splash.w.xj.y yVar;
        return (z || this.d == null || (yVar = this.zg) == null || yVar.u() == null || this.zg.hf() == null || !com.bytedance.sdk.openadsdk.core.kd.u.kd.xj(this.zg.hf())) ? false : true;
    }

    public static kd xj(Context context) {
        return new kd(context);
    }

    public void xj(com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar, com.bytedance.sdk.openadsdk.jk.xj.hf.xj.xj xjVar, int i) {
        this.u = xjVar;
        xj(hfVar, i);
    }

    private void hf(com.bytedance.sdk.openadsdk.core.component.splash.w.xj.f fVar, long j) {
        if (fVar.p()) {
            if (this.j.get()) {
                return;
            }
            this.et.hf(j - this.g);
            this.ra.w(fVar.y());
            this.ra.hf(fVar.kd());
            return;
        }
        if (this.z.get()) {
            return;
        }
        this.dk.hf(j - this.f10334pl);
        this.ht.w(fVar.y());
        this.ht.hf(fVar.kd());
    }

    private void xj(com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar, int i) {
        com.bytedance.sdk.openadsdk.core.c.xj.xj("Splash_FullLink", "加载开屏广告--begin ");
        this.p = System.currentTimeMillis();
        this.w = hf(hfVar);
        this.hf = hfVar;
        this.c = wo.hf(hfVar);
        this.d = com.bytedance.sdk.openadsdk.core.component.splash.xj.xj.xj();
        int xj2 = this.tj.xj(this.c);
        this.xj = xj2;
        com.bytedance.sdk.openadsdk.core.c.xj.xj("Splash_FullLink", "当前rit位 " + this.c);
        int y = pz.hf().y(hfVar.u());
        xj(hfVar.u(), y, i);
        tj tjVar = this.w;
        long j = i;
        tjVar.d = j;
        tjVar.tf = y;
        tjVar.p = this.f;
        y.xj(hfVar, j);
        hf();
        xj(hfVar, this.w, xj2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hf(com.bytedance.sdk.openadsdk.core.component.splash.w.xj.y yVar, xj xjVar) {
        if (yVar == null || xjVar == null) {
            return;
        }
        ws hf = yVar.hf();
        boolean kd = yVar.kd();
        com.bytedance.sdk.openadsdk.core.component.splash.w.w.xj xj2 = xj(yVar, new com.bytedance.sdk.openadsdk.core.component.splash.w.xj.f(hf, kd), xjVar);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        com.bytedance.sdk.openadsdk.core.component.splash.w.xj.hf hfVar = new com.bytedance.sdk.openadsdk.core.component.splash.w.xj.hf(hf, kd);
        hfVar.xj(kd);
        hfVar.xj(yVar.u());
        hfVar.xj(yVar.xj());
        hfVar.xj(yVar.w());
        com.bytedance.sdk.openadsdk.core.component.splash.w.w.y xj3 = xj(yVar, xjVar, xj2.xj(), hfVar, elapsedRealtime);
        xj2.xj(xj3);
        y.w(kd ? this.ra : this.ht, System.currentTimeMillis());
        xj3.hf();
        int w = w(hf);
        if (this.f10333io.get()) {
            return;
        }
        if (xj(hf, hfVar.u()) && this.y != null && w <= 0) {
            w = 0;
        }
        xj(kd, 1);
        xj(xj2, kd, w);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar, tj tjVar, int i) {
        if (hfVar == null) {
            return;
        }
        y.xj(this.ht, this.ra, tjVar, this.xj, i);
        xj(hfVar, tjVar, this.tf);
    }

    private void xj(final com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar, tj tjVar, final xj xjVar) {
        if (xjVar == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.component.splash.xj.kd kdVar = new com.bytedance.sdk.openadsdk.core.component.splash.xj.kd();
        kdVar.xj = this.tj.hf;
        com.bytedance.sdk.openadsdk.core.component.splash.w.w.kd kdVar2 = new com.bytedance.sdk.openadsdk.core.component.splash.w.w.kd(new com.bytedance.sdk.openadsdk.core.component.splash.w.xj.kd(hfVar, tjVar, kdVar), new com.bytedance.sdk.openadsdk.core.component.splash.w.w.hf<com.bytedance.sdk.openadsdk.core.component.splash.w.xj.y, com.bytedance.sdk.openadsdk.core.component.splash.w.xj.c>() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.kd.1
            @Override // com.bytedance.sdk.openadsdk.core.component.splash.w.w.hf
            /* renamed from: xj, reason: merged with bridge method [inline-methods] */
            public void hf(com.bytedance.sdk.openadsdk.core.component.splash.w.xj.y yVar) {
                if (yVar == null || yVar.hf() == null) {
                    xjVar.xj(new com.bytedance.sdk.openadsdk.core.component.splash.w.xj.c(1, "no ad model", false));
                    return;
                }
                ws hf = yVar.hf();
                if (yVar.kd()) {
                    kd.this.r.set(1);
                    kd.this.e = yVar;
                    if (!kd.this.pl()) {
                        kd.this.b = true;
                    }
                } else {
                    kd.this.zg = yVar;
                    kd.this.b = false;
                }
                if (kd.this.f10333io.get() || kd.this.tf.w() || kd.this.en.get() > 0) {
                    kd.this.xj(yVar, yVar.kd(), true);
                    return;
                }
                kd.this.xj(yVar);
                if (kd.this.hf(hf, yVar.kd())) {
                    com.bytedance.sdk.openadsdk.core.c.xj.xj("Splash_FullLink", "开始并发加载素材 ");
                    kd.this.hf(yVar, xjVar);
                } else {
                    com.bytedance.sdk.openadsdk.core.c.xj.xj("Splash_FullLink", "开始串行加载素材 getReqId " + yVar.hf().zf());
                    kd.this.xj(yVar, xjVar);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.splash.w.w.hf
            public void xj(com.bytedance.sdk.openadsdk.core.component.splash.w.xj.c cVar) {
                if (kd.this.xj == 1 && kd.this.tj.w == 2) {
                    kd.this.xj = 2;
                    kd kdVar3 = kd.this;
                    kdVar3.xj(hfVar, kdVar3.w, kd.this.xj);
                    return;
                }
                boolean f = cVar.f();
                if (f) {
                    kd.this.r.set(-1);
                }
                if (kd.this.w(f)) {
                    if (kd.this.wo.get()) {
                        xjVar.xj(kd.this.eu);
                        return;
                    }
                    return;
                }
                kd.this.eu = cVar;
                if (kd.this.pl()) {
                    if (kd.this.r.get() != -1) {
                        if (kd.this.r.get() == 1) {
                            kd.this.kd();
                        }
                    } else {
                        xjVar.xj(cVar);
                    }
                    kd.this.wo.set(true);
                    return;
                }
                xjVar.xj(cVar);
            }
        }, this.d, this.tj);
        this.ws = kdVar2;
        kdVar2.xj(this.xj);
    }

    @Override // com.bytedance.sdk.component.utils.ai.xj
    public void xj(Message message) {
        if (message.what == 2) {
            xj xjVar = this.tf;
            if (xjVar != null) {
                xjVar.xj();
            }
            ai aiVar = this.y;
            if (aiVar != null) {
                aiVar.removeMessages(2);
            }
        }
        if (message.what == 4) {
            y();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean hf(ws wsVar, boolean z) {
        if (wsVar == null) {
            return false;
        }
        if (pl() && z && g()) {
            return false;
        }
        if ((com.bytedance.sdk.openadsdk.core.w.kd.xj().g() & 1) == 1) {
            return true;
        }
        return c.hf(wsVar) && hf(wsVar) && wsVar.zb() == 1;
    }

    private boolean xj(ws wsVar, boolean z) {
        return (wsVar == null || z || wsVar.cy() != 3) ? false : true;
    }

    private boolean hf(ws wsVar) {
        return wsVar != null && hl.xj(wsVar) == 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean xj(ws wsVar) {
        return (wsVar != null ? wsVar.cy() : 0) == 4;
    }

    private com.bytedance.sdk.openadsdk.core.component.splash.w.w.xj hf(final com.bytedance.sdk.openadsdk.core.component.splash.w.xj.y yVar, com.bytedance.sdk.openadsdk.core.component.splash.w.xj.f fVar, final xj xjVar) {
        if (yVar == null || fVar == null || xjVar == null) {
            return null;
        }
        return new com.bytedance.sdk.openadsdk.core.component.splash.w.w.xj(new com.bytedance.sdk.openadsdk.core.component.splash.w.xj.w(this.kd, "splash_ad", yVar, fVar, this.hf), new com.bytedance.sdk.openadsdk.core.component.splash.w.w.u<com.bytedance.sdk.openadsdk.core.component.splash.w.xj.d, com.bytedance.sdk.openadsdk.core.component.splash.w.xj.c>() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.kd.3
            @Override // com.bytedance.sdk.openadsdk.core.component.splash.w.w.u
            /* renamed from: xj, reason: merged with bridge method [inline-methods] */
            public void hf(com.bytedance.sdk.openadsdk.core.component.splash.w.xj.d dVar) {
                kd.this.kd(yVar.kd());
                if (kd.this.f10332a.get()) {
                    if (yVar.kd()) {
                        xjVar.xj(dVar);
                    }
                } else {
                    if (yVar.kd()) {
                        return;
                    }
                    xjVar.xj(dVar);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.splash.w.w.u
            public void xj(com.bytedance.sdk.openadsdk.core.component.splash.w.xj.c cVar) {
                xjVar.w(cVar);
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.splash.w.w.u
            public void xj() {
                kd.this.hf(yVar);
            }
        }, this.d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ws xj(boolean z) {
        if (z) {
            com.bytedance.sdk.openadsdk.core.component.splash.w.xj.y yVar = this.e;
            if (yVar == null) {
                return null;
            }
            return yVar.hf();
        }
        com.bytedance.sdk.openadsdk.core.component.splash.w.xj.y yVar2 = this.zg;
        if (yVar2 == null) {
            return null;
        }
        return yVar2.hf();
    }

    private tj hf(com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar) {
        long currentTimeMillis = System.currentTimeMillis();
        tj tjVar = new tj();
        tjVar.c = currentTimeMillis;
        tjVar.g = com.bytedance.sdk.openadsdk.core.f.zg().dq();
        Object obj = this.u;
        if (obj != null && (obj instanceof com.bytedance.sdk.openadsdk.core.xj.hf)) {
            tjVar.f = ((com.bytedance.sdk.openadsdk.core.xj.hf) obj).hf();
        }
        return tjVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(final boolean z, final gh ghVar) {
        com.bytedance.sdk.openadsdk.x.c.xj(new com.bytedance.sdk.component.tf.d("preloadSplash") { // from class: com.bytedance.sdk.openadsdk.core.component.splash.kd.6
            @Override // java.lang.Runnable
            public void run() {
                if (kd.this.hf(z)) {
                    kd.this.tf();
                } else {
                    kd.this.w();
                }
                gh ghVar2 = ghVar;
                boolean z2 = false;
                boolean z3 = ghVar2 != null && ghVar2.ff();
                gh ghVar3 = ghVar;
                if (ghVar3 != null && ghVar3.en()) {
                    z2 = true;
                }
                boolean z4 = z;
                y.xj(z4, kd.this.xj(z4), kd.this.hf, z3, z2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(com.bytedance.sdk.openadsdk.core.component.splash.w.xj.y yVar) {
        boolean kd = yVar.kd();
        long currentTimeMillis = System.currentTimeMillis();
        long j = currentTimeMillis - this.p;
        if (kd) {
            y.xj(this.ra);
            this.et.xj(hl.xj(xj(kd)));
            this.et.hf(hl.hf(xj(kd)));
            this.et.xj(j);
            this.g = currentTimeMillis;
            com.bytedance.sdk.openadsdk.core.c.xj.xj("Splash_FullLink", "缓存加载物料--end 耗时S1： " + j);
            return;
        }
        y.xj(this.ht);
        this.dk.xj(hl.xj(xj(kd)));
        this.dk.hf(hl.hf(xj(kd)));
        this.dk.xj(j);
        this.f10334pl = currentTimeMillis;
        y.xj(this.ht, yVar);
        com.bytedance.sdk.openadsdk.core.et.kd.xj().w().xj(this.ht);
        com.bytedance.sdk.openadsdk.core.c.xj.xj("Splash_FullLink", "实时加载物料--end 耗时S1： " + j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hf(com.bytedance.sdk.openadsdk.core.component.splash.w.xj.y yVar) {
        if (yVar == null || !yVar.kd()) {
            u();
        }
    }

    private void xj(final com.bytedance.sdk.openadsdk.core.component.splash.w.xj.f fVar, final com.bytedance.sdk.openadsdk.core.component.splash.w.xj.y yVar, final xj xjVar) {
        if (fVar != null && this.en.get() <= 0) {
            final boolean p = fVar.p();
            final com.bytedance.sdk.openadsdk.core.component.splash.w.w.xj hf = hf(yVar, fVar, xjVar);
            fVar.xj(hf.xj());
            if (!w(fVar.p())) {
                com.bytedance.sdk.openadsdk.core.c.xj.xj("Splash_FullLink", "不需要等待实时广告 isCacheAd " + p);
                if (xj()) {
                    xjVar.xj(fVar);
                    xj(yVar, hf, fVar.kd());
                    return;
                } else {
                    final long currentTimeMillis = System.currentTimeMillis();
                    com.bytedance.sdk.openadsdk.x.c.xj(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.kd.7
                        @Override // java.lang.Runnable
                        public void run() {
                            y.u(p ? kd.this.ra : kd.this.ht, currentTimeMillis);
                            xjVar.xj(fVar);
                            kd.this.xj(yVar, hf, fVar.kd());
                        }
                    });
                    return;
                }
            }
            com.bytedance.sdk.openadsdk.core.c.xj.xj("Splash_FullLink", "缓存素材加载成功，等待实时广告 isCacheAd " + p);
            this.yo = fVar;
            this.v = hf.xj();
            this.x.set(true);
            if (this.wo.get()) {
                kd();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(final com.bytedance.sdk.openadsdk.core.component.splash.w.xj.y yVar, final xj xjVar) {
        if (yVar == null || xjVar == null) {
            return;
        }
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        y.w(yVar.kd() ? this.ra : this.ht, System.currentTimeMillis());
        com.bytedance.sdk.openadsdk.core.component.splash.w.xj.hf hfVar = new com.bytedance.sdk.openadsdk.core.component.splash.w.xj.hf(yVar.hf(), yVar.kd());
        hfVar.xj(yVar.u());
        hfVar.xj(yVar.kd());
        hfVar.xj(yVar.xj());
        hfVar.xj(yVar.w());
        new com.bytedance.sdk.openadsdk.core.component.splash.w.w.y(hfVar, new com.bytedance.sdk.openadsdk.core.component.splash.w.w.w<com.bytedance.sdk.openadsdk.core.component.splash.w.xj.f, com.bytedance.sdk.openadsdk.core.component.splash.w.xj.c>() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.kd.8
            private com.bytedance.sdk.openadsdk.core.component.splash.w.xj.f kd;

            @Override // com.bytedance.sdk.openadsdk.core.component.splash.w.w.w
            public void hf(com.bytedance.sdk.openadsdk.core.component.splash.w.xj.f fVar) {
                com.bytedance.sdk.openadsdk.core.component.splash.w.xj.f fVar2 = this.kd;
                if (fVar2 != null) {
                    fVar2.kd(true);
                }
                kd.this.xj(fVar, yVar, xjVar, (com.bytedance.sdk.openadsdk.zg.w.hf.hf) null, elapsedRealtime, true);
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.splash.w.w.w
            /* renamed from: xj, reason: merged with bridge method [inline-methods] */
            public void w(com.bytedance.sdk.openadsdk.core.component.splash.w.xj.f fVar) {
                this.kd = fVar;
                kd.this.xj(fVar, yVar, xjVar, (com.bytedance.sdk.openadsdk.zg.w.hf.hf) null, true);
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.splash.w.w.w
            public void xj(com.bytedance.sdk.openadsdk.core.component.splash.w.xj.c cVar) {
                kd.this.xj(yVar, cVar, xjVar, elapsedRealtime);
            }
        }).hf();
        xj(yVar.kd(), 0);
    }

    private void xj(final com.bytedance.sdk.openadsdk.core.component.splash.w.w.xj xjVar, boolean z, final int i) {
        u(z);
        com.bytedance.sdk.openadsdk.x.c.xj(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.kd.9
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.core.component.splash.w.w.xj xjVar2 = xjVar;
                if (xjVar2 == null) {
                    return;
                }
                xjVar2.xj(i);
                xjVar.hf();
            }
        });
    }

    private void xj(com.bytedance.sdk.openadsdk.core.component.splash.w.xj.f fVar, long j) {
        long currentTimeMillis = System.currentTimeMillis();
        boolean p = fVar.p();
        if (p) {
            y.xj(this.ra, fVar);
            y.xj(this.ra, fVar, j, xj(p));
            y.xj(xj(p), this.ra, fVar);
            xj(p, fVar, currentTimeMillis - this.g);
            com.bytedance.sdk.openadsdk.core.component.splash.w.xj.f fVar2 = this.yo;
            if (fVar2 != null) {
                fVar2.kd(true);
            }
        } else {
            y.xj(this.ht, fVar);
            y.xj(this.ht, fVar, j, xj(p));
            y.xj(xj(p), this.ht, fVar);
            xj(p, fVar, currentTimeMillis - this.f10334pl);
        }
        hf(fVar, currentTimeMillis);
        if (this.en.get() <= 0 || this.f10333io.get()) {
            return;
        }
        if (this.f10332a.get()) {
            if (p) {
                y.xj(this.kd, this.ra, fVar.hf(), true, currentTimeMillis);
            }
        } else {
            if (p) {
                return;
            }
            y.xj(this.kd, this.ht, fVar.hf(), false, currentTimeMillis);
        }
    }

    private void xj(boolean z, com.bytedance.sdk.openadsdk.core.component.splash.w.xj.f fVar, long j) {
        String str = z ? "缓存广告" : "实时广告";
        if (fVar.kd()) {
            if (fVar.tf()) {
                com.bytedance.sdk.openadsdk.core.c.xj.xj("Splash_FullLink", str + "： 加载缓存视频素材--end, 耗时S2： " + j);
                return;
            }
            com.bytedance.sdk.openadsdk.core.c.xj.xj("Splash_FullLink", str + "： 加载网络视频素材--end, 耗时S2： " + j);
            return;
        }
        if (fVar.y()) {
            com.bytedance.sdk.openadsdk.core.c.xj.xj("Splash_FullLink", str + "： 加载缓存图片素材--end, 耗时S2： " + j);
            return;
        }
        com.bytedance.sdk.openadsdk.core.c.xj.xj("Splash_FullLink", str + "： 加载网络图片素材--end, 耗时S2：" + j);
    }

    private void xj(final com.bytedance.sdk.openadsdk.core.component.splash.w.xj.f fVar, com.bytedance.sdk.openadsdk.core.component.splash.w.xj.y yVar, final xj xjVar, com.bytedance.sdk.openadsdk.zg.w.hf.hf hfVar) {
        if (fVar != null && this.en.get() <= 0) {
            final boolean p = fVar.p();
            if (!w(p)) {
                com.bytedance.sdk.openadsdk.core.c.xj.xj("Splash_FullLink", "实时素材加载成功，不需要等待实时广告, 此时渲染结果: " + this.ai.get());
                fVar.xj(hfVar);
                if (xj()) {
                    xjVar.xj(fVar);
                    if (this.ai.get()) {
                        xjVar.xj(this.jk);
                    }
                } else {
                    final long currentTimeMillis = System.currentTimeMillis();
                    com.bytedance.sdk.openadsdk.x.c.xj(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.kd.10
                        @Override // java.lang.Runnable
                        public void run() {
                            y.u(p ? kd.this.ra : kd.this.ht, currentTimeMillis);
                            xjVar.xj(fVar);
                            if (kd.this.ai.get()) {
                                xjVar.xj(kd.this.jk);
                            }
                        }
                    });
                }
            } else {
                com.bytedance.sdk.openadsdk.core.c.xj.xj("Splash_FullLink", "缓存广告: 素材加载成功，需要等待实时广告");
                this.yo = fVar;
                this.v = hfVar;
                this.x.set(true);
                if (this.wo.get()) {
                    kd();
                }
            }
        }
    }

    private com.bytedance.sdk.openadsdk.core.component.splash.w.w.y xj(final com.bytedance.sdk.openadsdk.core.component.splash.w.xj.y yVar, final xj xjVar, final com.bytedance.sdk.openadsdk.zg.w.hf.hf hfVar, com.bytedance.sdk.openadsdk.core.component.splash.w.xj.hf hfVar2, final long j) {
        return new com.bytedance.sdk.openadsdk.core.component.splash.w.w.y(hfVar2, new com.bytedance.sdk.openadsdk.core.component.splash.w.w.w<com.bytedance.sdk.openadsdk.core.component.splash.w.xj.f, com.bytedance.sdk.openadsdk.core.component.splash.w.xj.c>() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.kd.11
            private com.bytedance.sdk.openadsdk.core.component.splash.w.xj.f y;

            @Override // com.bytedance.sdk.openadsdk.core.component.splash.w.w.w
            public void hf(com.bytedance.sdk.openadsdk.core.component.splash.w.xj.f fVar) {
                com.bytedance.sdk.openadsdk.core.component.splash.w.xj.f fVar2 = this.y;
                if (fVar2 != null) {
                    fVar2.kd(true);
                }
                kd.this.xj(fVar, yVar, xjVar, hfVar, j, false);
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.splash.w.w.w
            /* renamed from: xj, reason: merged with bridge method [inline-methods] */
            public void w(com.bytedance.sdk.openadsdk.core.component.splash.w.xj.f fVar) {
                this.y = fVar;
                kd.this.xj(fVar, yVar, xjVar, hfVar, false);
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.splash.w.w.w
            public void xj(com.bytedance.sdk.openadsdk.core.component.splash.w.xj.c cVar) {
                kd.this.xj(yVar, cVar, xjVar, j);
            }
        });
    }

    private com.bytedance.sdk.openadsdk.core.component.splash.w.w.xj xj(final com.bytedance.sdk.openadsdk.core.component.splash.w.xj.y yVar, com.bytedance.sdk.openadsdk.core.component.splash.w.xj.f fVar, final xj xjVar) {
        return new com.bytedance.sdk.openadsdk.core.component.splash.w.w.xj(new com.bytedance.sdk.openadsdk.core.component.splash.w.xj.w(this.kd, "splash_ad", yVar, fVar, this.hf), new com.bytedance.sdk.openadsdk.core.component.splash.w.w.u<com.bytedance.sdk.openadsdk.core.component.splash.w.xj.d, com.bytedance.sdk.openadsdk.core.component.splash.w.xj.c>() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.kd.2
            @Override // com.bytedance.sdk.openadsdk.core.component.splash.w.w.u
            /* renamed from: xj, reason: merged with bridge method [inline-methods] */
            public void hf(com.bytedance.sdk.openadsdk.core.component.splash.w.xj.d dVar) {
                kd.this.kd(yVar.kd());
                if (kd.this.w(dVar.w())) {
                    com.bytedance.sdk.openadsdk.core.c.xj.xj("Splash_FullLink", "缓存渲染成功 需要等待实时广告: ");
                    if (kd.this.ff.get() && !kd.this.l.get()) {
                        com.bytedance.sdk.openadsdk.core.c.xj.xj("Splash_FullLink", "已经超时走缓存广告");
                        kd.this.l.set(true);
                        xjVar.xj(dVar);
                    }
                    kd.this.q.set(true);
                    kd.this.pz = dVar;
                    return;
                }
                kd.this.ai.set(true);
                kd.this.jk = dVar;
                if (kd.this.en.get() == 2) {
                    if (!kd.this.pl()) {
                        xjVar.xj(dVar);
                    } else {
                        if (kd.this.f10332a.get()) {
                            return;
                        }
                        xjVar.xj(dVar);
                    }
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.splash.w.w.u
            public void xj(com.bytedance.sdk.openadsdk.core.component.splash.w.xj.c cVar) {
                if (!kd.this.w(cVar.f())) {
                    kd.this.ai.set(false);
                    xjVar.w(cVar);
                } else {
                    kd.this.q.set(false);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.splash.w.w.u
            public void xj() {
                kd.this.hf(yVar);
            }
        }, this.d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(com.bytedance.sdk.openadsdk.core.component.splash.w.xj.y yVar, com.bytedance.sdk.openadsdk.core.component.splash.w.w.xj xjVar, boolean z) {
        if (xjVar == null) {
            return;
        }
        int w = w(xj(yVar.kd()));
        com.bytedance.sdk.openadsdk.core.c.xj.xj("Splash_FullLink", "渲染 timeout " + w);
        if (this.f10333io.get()) {
            return;
        }
        if (xj(yVar.hf(), z) && this.y != null && w <= 0) {
            w = 0;
        }
        com.bytedance.sdk.openadsdk.core.c.xj.xj("Splash_FullLink", "开始渲染 isCache " + yVar.kd());
        xj(xjVar, yVar.kd(), w);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(com.bytedance.sdk.openadsdk.core.component.splash.w.xj.d dVar) {
        if (dVar == null) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean w = dVar.w();
        if (w) {
            y.xj(xj(w), this.et, dVar);
            this.et.u(currentTimeMillis - this.p);
            this.et.u(this.xj);
            this.et.xj(w);
            y.xj(xj(w), this.et);
            y.hf(xj(w), this.et);
        } else {
            y.xj(xj(w), this.dk, dVar);
            this.dk.u(currentTimeMillis - this.p);
            this.dk.u(this.xj);
            this.dk.xj(w);
            y.xj(xj(w), this.dk);
            y.hf(xj(w), this.dk);
            com.bytedance.sdk.openadsdk.core.c.xj.xj("Splash_FullLink", "开屏广告渲染--end, 耗时S3： " + (currentTimeMillis - this.am));
        }
        com.bytedance.sdk.openadsdk.core.c.xj.xj("Splash_FullLink", "渲染成功回调 开屏广告类型： ".concat(w ? "缓存" : "实时"));
        com.bytedance.sdk.openadsdk.core.c.xj.xj("Splash_FullLink", "加载开屏广告--end，总耗时： " + (currentTimeMillis - this.p));
        com.bytedance.sdk.openadsdk.core.c.xj.xj("Splash_FullLink", "加载开屏广告--end，getReqId： " + xj(w).zf());
    }

    private void xj(String str, int i, int i2) {
        int qt = pz.hf().qt(str);
        if (qt == 1) {
            this.f = i > 0 ? Math.min(i, i2) : Math.max(i2, 500);
        } else if (qt != 2) {
            this.f = i > 0 ? Math.max(i, i2) : Math.max(i2, 500);
        } else {
            this.f = i > 0 ? i : Math.max(i2, 500);
        }
        int currentTimeMillis = (int) (this.f - (System.currentTimeMillis() - this.w.f));
        if (currentTimeMillis <= 0) {
            currentTimeMillis = this.f;
        }
        this.f = currentTimeMillis;
        StringBuilder B7CMnp2 = A2egSU.B7CMnp(qt, i2, "splashTimeOutControlType = ", "; devTimeOut = ", "; cloudTimeOut = ");
        B7CMnp2.append(i);
        B7CMnp2.append("; realTimeOut = ");
        B7CMnp2.append(this.f);
        com.bytedance.sdk.openadsdk.core.c.xj.xj("Splash_FullLink", B7CMnp2.toString());
        this.y.sendEmptyMessageDelayed(2, this.f);
        xj(this.f);
    }

    private void xj(int i) {
        int tf = pz.hf().tf(this.c);
        if (tf >= i || tf <= 0 || !pl() || this.y == null) {
            return;
        }
        int i2 = i - tf;
        com.bytedance.sdk.openadsdk.core.c.xj.xj("Splash_FullLink", "buffer time: " + tf + "  减去buffer time后超时时间：" + i2);
        this.y.sendEmptyMessageDelayed(4, (long) i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(com.bytedance.sdk.openadsdk.core.component.splash.w.xj.f fVar, com.bytedance.sdk.openadsdk.core.component.splash.w.xj.y yVar, xj xjVar, com.bytedance.sdk.openadsdk.zg.w.hf.hf hfVar, boolean z) {
        if (this.f10333io.get()) {
            return;
        }
        hf(fVar, System.currentTimeMillis());
        if (fVar.p()) {
            com.bytedance.sdk.openadsdk.core.c.xj.xj("Splash_FullLink", "缓存广告： 素材首包回调");
            this.j.set(true);
        } else {
            com.bytedance.sdk.openadsdk.core.c.xj.xj("Splash_FullLink", "实时广告： 素材首包回调");
            this.z.set(true);
        }
        y.xj(fVar.p() ? this.ra : this.ht, 3);
        y(fVar.p());
        if (z) {
            xj(fVar, yVar, xjVar);
        } else {
            xj(fVar, yVar, xjVar, hfVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(com.bytedance.sdk.openadsdk.core.component.splash.w.xj.f fVar, com.bytedance.sdk.openadsdk.core.component.splash.w.xj.y yVar, xj xjVar, com.bytedance.sdk.openadsdk.zg.w.hf.hf hfVar, long j, boolean z) {
        if (fVar == null) {
            return;
        }
        xj(yVar, yVar.kd(), false);
        if (this.f10333io.get()) {
            return;
        }
        if (hfVar instanceof com.bytedance.sdk.openadsdk.core.component.splash.presentation.xj) {
            ((com.bytedance.sdk.openadsdk.core.component.splash.presentation.xj) hfVar).xj(fVar, false);
        }
        xj(fVar, j);
        if (fVar.p() && this.j.get()) {
            return;
        }
        if (fVar.p() || !this.z.get()) {
            if (xj(fVar.hf(), fVar.kd()) || xj(yVar.hf())) {
                y.xj(fVar.p() ? this.ra : this.ht, 2);
                y(fVar.p());
            }
            if (z) {
                xj(fVar, yVar, xjVar);
            } else {
                xj(fVar, yVar, xjVar, hfVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(com.bytedance.sdk.openadsdk.core.component.splash.w.xj.y yVar, com.bytedance.sdk.openadsdk.core.component.splash.w.xj.c cVar, xj xjVar, long j) {
        if (cVar == null) {
            return;
        }
        boolean f = cVar.f();
        if (!w(f)) {
            com.bytedance.sdk.openadsdk.core.c.xj.xj("Splash_FullLink", "实时cac广告: 素材加载失败，直接给回调");
            xjVar.hf(cVar);
        } else {
            com.bytedance.sdk.openadsdk.core.c.xj.xj("Splash_FullLink", "缓存广告: 素材加载失败");
            this.x.set(false);
            if (this.wo.get()) {
                xjVar.hf(cVar);
            }
        }
        xj(yVar, f, false);
        int i = cVar.y() ? -14 : -7;
        if (!cVar.y()) {
            c.xj(j, false, false, xj(cVar.f()), i, cVar.kd());
        }
        StringBuilder A5SV6n2 = AYUAbz.A5SV6n(f ? "缓存广告" : "实时广告", "加载素材失败 ");
        A5SV6n2.append(cVar.u());
        com.bytedance.sdk.openadsdk.core.c.xj.xj("Splash_FullLink", A5SV6n2.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(com.bytedance.sdk.openadsdk.core.component.splash.w.xj.y yVar, boolean z, boolean z2) {
        if (z) {
            return;
        }
        try {
            if (this.en.get() > 0 && !this.f10332a.get()) {
                com.bytedance.sdk.openadsdk.core.c.xj.xj("lqmt", "该实时广告已回调媒体");
            } else {
                if (com.bytedance.sdk.openadsdk.core.component.splash.w.w.kd.xj(this.hf, this.w)) {
                    return;
                }
                if (this.en.get() > 0 || this.tf.w()) {
                    this.d.xj(yVar, this.hf, z2, this.xj);
                }
            }
        } catch (Exception unused) {
        }
    }

    private void xj(boolean z, int i) {
        (z ? this.et : this.dk).kd(i);
    }

    public static boolean xj() {
        return (com.bytedance.sdk.openadsdk.core.w.kd.xj().pl() & 256) == 256;
    }

    public static boolean xj(com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar) {
        return com.bytedance.sdk.openadsdk.core.component.splash.w.w.kd.xj(hfVar, new tj()) && (com.bytedance.sdk.openadsdk.core.w.kd.xj().pl() & 4) == 4;
    }
}
