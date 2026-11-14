package com.bytedance.sdk.openadsdk.core.component.splash.xj;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.sdk.component.y.zg;
import com.bytedance.sdk.openadsdk.core.a.wo;
import com.bytedance.sdk.openadsdk.core.a.yo;
import com.bytedance.sdk.openadsdk.core.component.splash.w.xj.c;
import com.bytedance.sdk.openadsdk.core.component.splash.w.xj.d;
import com.bytedance.sdk.openadsdk.core.component.splash.w.xj.y;
import com.bytedance.sdk.openadsdk.core.dk;
import com.bytedance.sdk.openadsdk.core.f;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.core.ra.gh;
import com.bytedance.sdk.openadsdk.core.ra.h;
import com.bytedance.sdk.openadsdk.core.ra.qd;
import com.bytedance.sdk.openadsdk.core.ra.tj;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.core.ra.z;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class xj {
    protected kd y;
    protected long xj = 0;
    protected long hf = 0;
    protected AtomicBoolean w = new AtomicBoolean(false);
    protected AtomicBoolean u = new AtomicBoolean(false);
    protected AtomicBoolean kd = new AtomicBoolean(false);

    /* renamed from: com.bytedance.sdk.openadsdk.core.component.splash.xj.xj$xj, reason: collision with other inner class name */
    public interface InterfaceC0156xj {
        void xj();

        void xj(y yVar);
    }

    public static xj xj() {
        return (com.bytedance.sdk.openadsdk.core.w.kd.xj().p() & 16) == 16 ? new w() : new u();
    }

    public abstract void hf();

    public void hf(com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar, tj tjVar) {
        if (pz.hf().hf(wo.hf(hfVar)) && hfVar != null && TextUtils.isEmpty(hfVar.pz())) {
            com.bytedance.sdk.openadsdk.core.c.xj.xj("lqmt", "preLoadSplashAd... ");
            tj tjVar2 = tjVar == null ? new tj() : tjVar.xj();
            tjVar2.c = System.currentTimeMillis();
            tjVar2.g = f.zg().dq();
            xj(hfVar, tjVar2);
        }
    }

    public abstract void w();

    public abstract void xj(com.bytedance.sdk.openadsdk.core.component.splash.w.w.u<d, c> uVar, ws wsVar, com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar, boolean z);

    public abstract void xj(c cVar, String str, InterfaceC0156xj interfaceC0156xj, kd kdVar);

    public abstract void xj(qd qdVar, com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar, boolean z);

    public abstract void xj(String str, ws wsVar);

    public abstract void xj(String str, String str2, boolean z, boolean z2, Object obj);

    public void xj(y yVar, com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar, boolean z, int i) {
        if (xj(i) && com.bytedance.sdk.openadsdk.core.kd.u.kd.xj(yVar.hf()) && !this.w.get()) {
            this.w.set(true);
            com.bytedance.sdk.openadsdk.core.c.xj.xj("Splash_FullLink", "cacheRealTimeAdWhenTimeout start");
            xj(new qd(yVar.u(), yVar.hf(), null), hfVar, false);
            if (z) {
                xj(yVar.u(), yVar.hf(), hfVar);
            }
            com.bytedance.sdk.openadsdk.core.c.xj.xj("Splash_FullLink", "cacheRealTimeAdWhenTimeout end");
        }
    }

    public static boolean xj(int i) {
        int p = com.bytedance.sdk.openadsdk.core.w.kd.xj().p();
        return i == 2 ? (p & 2) == 2 : (i == 3 || i == 1) && (p & 32) == 32;
    }

    public void xj(final com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar, tj tjVar) {
        if (this.w.get()) {
            com.bytedance.sdk.openadsdk.core.c.xj.xj("lqmt", "已经存储了一个实时广告");
            return;
        }
        if (this.u.getAndSet(true)) {
            com.bytedance.sdk.openadsdk.core.c.xj.xj("lqmt", "已在预加载开屏广告....不再发出");
            return;
        }
        if (pz.hf().p(hfVar.u()) && tjVar != null) {
            tjVar.y = 2;
        }
        pz.xj().xj(hfVar, tjVar, 4, new dk.hf() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.xj.xj.1
            @Override // com.bytedance.sdk.openadsdk.core.dk.hf
            public void xj(int i, String str, com.bytedance.sdk.openadsdk.core.ra.hf hfVar2) {
                xj.this.u.set(false);
                hfVar2.xj(i);
                com.bytedance.sdk.openadsdk.core.ra.hf.xj(hfVar2);
            }

            @Override // com.bytedance.sdk.openadsdk.core.dk.hf
            public void xj(com.bytedance.sdk.openadsdk.core.ra.xj xjVar, com.bytedance.sdk.openadsdk.core.ra.hf hfVar2) {
                if (com.bytedance.sdk.openadsdk.core.component.splash.c.hf(xjVar)) {
                    ws wsVar = xjVar.hf().get(0);
                    if (wsVar.ap()) {
                        AtomicBoolean atomicBoolean = xj.this.w;
                        if ((atomicBoolean == null || !atomicBoolean.get()) && com.bytedance.sdk.openadsdk.core.kd.u.kd.xj(wsVar)) {
                            xj.this.xj(new qd(xjVar, wsVar, null), hfVar, false);
                            xj.this.xj(xjVar, wsVar, hfVar);
                            return;
                        }
                        return;
                    }
                    hfVar2.xj(-4);
                    com.bytedance.sdk.openadsdk.core.ra.hf.xj(hfVar2);
                    return;
                }
                xj.this.u.set(false);
            }
        });
    }

    public void xj(final com.bytedance.sdk.openadsdk.core.ra.xj xjVar, final ws wsVar, com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar) {
        if (wsVar.lx() == null || wsVar.lx().size() <= 0) {
            return;
        }
        z zVar = wsVar.lx().get(0);
        String xj = zVar.xj();
        int hf = zVar.hf();
        int w = zVar.w();
        this.xj = System.currentTimeMillis();
        this.hf = SystemClock.elapsedRealtime();
        gh w2 = com.bytedance.sdk.openadsdk.core.et.kd.xj().w().w();
        if (w2 != null) {
            w2.xj(false);
        }
        final boolean z = h.am(wsVar) != null;
        yo.xj(new com.bytedance.sdk.openadsdk.g.hf(xj, zVar.c()), hf, w, new yo.xj() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.xj.xj.2
            @Override // com.bytedance.sdk.openadsdk.core.a.yo.xj
            public void xj(com.bytedance.sdk.openadsdk.core.et.xj.hf hfVar2, zg zgVar) {
                com.bytedance.sdk.openadsdk.core.component.splash.c.xj(xjVar);
                if (!z) {
                    com.bytedance.sdk.openadsdk.core.am.u.xj(wsVar, "splash_ad", System.currentTimeMillis() - xj.this.xj);
                }
                xj xjVar2 = xj.this;
                xjVar2.xj = 0L;
                if (z) {
                    com.bytedance.sdk.openadsdk.core.component.splash.c.xj(xjVar2.hf, false, true, wsVar, 0L, "preLoadImageSuccess");
                }
                xj.this.u.set(false);
            }

            @Override // com.bytedance.sdk.openadsdk.core.a.yo.xj
            public void xj() {
                com.bytedance.sdk.openadsdk.core.component.splash.c.xj(xjVar);
                if (z) {
                    com.bytedance.sdk.openadsdk.core.component.splash.c.xj(xj.this.hf, false, false, wsVar, -7L, "preLoadImageFailed");
                }
                xj.this.u.set(false);
            }
        }, com.bytedance.sdk.openadsdk.x.d.kd(), 4, null, false);
    }
}
