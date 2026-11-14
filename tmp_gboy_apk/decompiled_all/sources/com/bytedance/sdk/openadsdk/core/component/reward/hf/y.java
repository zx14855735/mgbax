package com.bytedance.sdk.openadsdk.core.component.reward.hf;

import android.widget.FrameLayout;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.u.d;
import com.bytedance.sdk.openadsdk.core.ra.h;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.core.video.hf.xj;
import com.bytedance.sdk.openadsdk.x.tf;
import com.bytedance.sdk.openadsdk.y.w.e;
import com.sigmob.sdk.base.views.r;
import java.io.File;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class y {
    private long am;
    com.bykv.vk.openvk.component.video.api.u.w c;
    long f;
    private String g;
    protected int kd;
    private ws p;

    /* renamed from: pl, reason: collision with root package name */
    private FrameLayout f10312pl;
    private com.bytedance.sdk.openadsdk.core.hf.xj qt;
    private TTBaseVideoActivity tf;
    protected long u;
    boolean y;
    private com.bykv.vk.openvk.component.video.api.w.u zg;
    private final int d = 210;
    boolean xj = false;
    protected boolean hf = false;
    protected boolean w = false;
    private boolean e = false;

    public y(TTBaseVideoActivity tTBaseVideoActivity) {
        this.tf = tTBaseVideoActivity;
    }

    private void n() {
        com.bykv.vk.openvk.component.video.api.u.w wVar = this.c;
        if (wVar == null || wVar.e() == null) {
            return;
        }
        this.f = this.c.p();
        if (this.c.e().tf() || !this.c.e().d()) {
            this.c.y();
            this.c.d();
            this.hf = true;
        }
    }

    public com.bykv.vk.openvk.component.video.api.u.hf a() {
        com.bykv.vk.openvk.component.video.api.u.w wVar = this.c;
        if (wVar != null) {
            return wVar.yo();
        }
        return null;
    }

    public double ai() {
        double y = h.y(this.p);
        return (h.am(this.p) == null || this.p.mq() <= 0 || y <= ((double) this.p.mq())) ? y : this.p.mq();
    }

    public long am() {
        com.bykv.vk.openvk.component.video.api.u.w wVar = this.c;
        if (wVar != null) {
            return wVar.am();
        }
        return 0L;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void b() {
        int i;
        e.xj xjVar = new e.xj();
        long jk = jk();
        long zg = zg();
        if (en() != null) {
            xjVar.xj(en().xj(zg, jk));
        }
        xjVar.w(jk);
        xjVar.hf(e());
        xjVar.kd(3);
        xjVar.y(yo());
        com.bykv.vk.openvk.component.video.api.u.w wVar = this.c;
        if (wVar instanceof com.bytedance.sdk.openadsdk.core.video.hf.xj) {
            ((com.bytedance.sdk.openadsdk.core.video.hf.xj) wVar).pz.w(32);
            i = ((com.bytedance.sdk.openadsdk.core.video.hf.xj) this.c).pz.xj(2);
        } else {
            i = 0;
        }
        com.bytedance.sdk.openadsdk.y.hf.u.xj(a(), xjVar, this.tf.f(), i ^ 1);
    }

    public void c() {
        com.bykv.vk.openvk.component.video.api.u.w wVar = this.c;
        if (wVar == null) {
            return;
        }
        wVar.d();
        this.c = null;
    }

    public void d() {
        com.bykv.vk.openvk.component.video.api.u.w wVar = this.c;
        if (wVar != null) {
            wVar.tf();
        }
    }

    public boolean dk() {
        com.bykv.vk.openvk.component.video.api.u.w wVar = this.c;
        return wVar != null && wVar.e() == null;
    }

    public long e() {
        com.bykv.vk.openvk.component.video.api.u.w wVar = this.c;
        if (wVar != null) {
            return wVar.pl();
        }
        return 0L;
    }

    public com.bytedance.sdk.openadsdk.core.video.hf.xj en() {
        return (com.bytedance.sdk.openadsdk.core.video.hf.xj) r();
    }

    public void et() {
        c();
    }

    public void eu() {
        this.w = true;
    }

    public void f() {
        if (this.c != null && hf()) {
            this.c.hf(true);
        }
    }

    public boolean ff() {
        com.bykv.vk.openvk.component.video.api.u.w wVar = this.c;
        if (wVar == null) {
            return false;
        }
        return wVar.w();
    }

    public boolean g() {
        com.bykv.vk.openvk.component.video.api.u.w wVar = this.c;
        if (wVar != null) {
            return wVar.v();
        }
        return false;
    }

    public boolean hf() {
        com.bykv.vk.openvk.component.video.api.u.w wVar = this.c;
        return (wVar == null || wVar.e() == null || !this.c.e().g()) ? false : true;
    }

    public boolean ht() {
        com.bykv.vk.openvk.component.video.api.u.w wVar = this.c;
        if (wVar != null) {
            if (wVar.e() != null) {
                com.bykv.vk.openvk.component.video.api.xj e = this.c.e();
                if (e.am() || e.qt()) {
                    ((com.bytedance.sdk.openadsdk.core.video.hf.xj) this.c).wn();
                    return true;
                }
            } else if (kd()) {
                xj(false);
                ((com.bytedance.sdk.openadsdk.core.video.hf.xj) this.c).wn();
                return true;
            }
        }
        return false;
    }

    public void io() {
        try {
            this.tf.g(1);
        } catch (Throwable th) {
            pl.u("TTBaseVideoActivity", "onPause throw Exception :" + th.getMessage());
        }
    }

    public long j() {
        if (p()) {
            double y = h.zg(this.p).y() * 1000.0d * en().vm();
            long j = this.u;
            if (y - j > 210.0d) {
                long j2 = (long) (j + y);
                this.am = j2;
                return j2;
            }
        }
        return Math.max(this.u, this.am);
    }

    public long jk() {
        com.bykv.vk.openvk.component.video.api.u.w wVar = this.c;
        if (wVar == null) {
            return 0L;
        }
        return this.c.pl() + wVar.am();
    }

    public boolean kd() {
        return this.hf;
    }

    public boolean l() {
        com.bytedance.sdk.openadsdk.core.video.hf.xj en = en();
        if (en == null) {
            return false;
        }
        return en.bl();
    }

    public boolean p() {
        com.bykv.vk.openvk.component.video.api.u.w wVar = this.c;
        if (wVar != null) {
            return wVar.u();
        }
        return false;
    }

    public boolean pl() {
        com.bykv.vk.openvk.component.video.api.u.w wVar = this.c;
        if (wVar != null) {
            return wVar.kd();
        }
        return false;
    }

    public long pz() {
        com.bykv.vk.openvk.component.video.api.u.w wVar = this.c;
        if (wVar != null) {
            return wVar.am();
        }
        return 0L;
    }

    public int q() {
        return this.kd;
    }

    public int qt() {
        com.bykv.vk.openvk.component.video.api.u.w wVar = this.c;
        if (wVar != null) {
            return wVar.qt();
        }
        return 0;
    }

    public com.bykv.vk.openvk.component.video.api.u.w r() {
        return this.c;
    }

    public boolean ra() {
        return this.c != null;
    }

    public void tf() {
        com.bykv.vk.openvk.component.video.api.u.w wVar = this.c;
        if (wVar != null) {
            wVar.hf();
        }
    }

    public void tj() {
        try {
            com.bykv.vk.openvk.component.video.api.u.w wVar = this.c;
            if (wVar instanceof com.bytedance.sdk.openadsdk.core.video.hf.xj) {
                ((com.bytedance.sdk.openadsdk.core.video.hf.xj) wVar).wa();
            }
        } catch (Throwable unused) {
        }
    }

    public boolean u() {
        com.bykv.vk.openvk.component.video.api.u.w wVar = this.c;
        return wVar != null && wVar.ht();
    }

    public void v() {
        com.bykv.vk.openvk.component.video.api.u.w wVar = this.c;
        if (wVar == null || wVar.e() == null) {
            return;
        }
        this.c.e().u();
    }

    public boolean w() {
        com.bykv.vk.openvk.component.video.api.u.w wVar = this.c;
        return (wVar == null || wVar.e() == null || !this.c.e().am()) ? false : true;
    }

    public boolean wo() {
        com.bykv.vk.openvk.component.video.api.u.w wVar = this.c;
        if (wVar == null || wVar.e() == null) {
            return false;
        }
        return this.c.e().y();
    }

    public boolean ws() {
        return this.w;
    }

    public void x() {
        try {
            this.tf.am(1);
        } catch (Throwable th) {
            pl.u("TTBaseVideoActivity", "onContinue throw Exception :" + th.getMessage());
        }
    }

    public void xj(ws wsVar) {
        this.p = wsVar;
    }

    public long y() {
        return this.f;
    }

    public int yo() {
        com.bykv.vk.openvk.component.video.api.u.w wVar = this.c;
        if (wVar != null) {
            return wVar.g();
        }
        return 0;
    }

    public long z() {
        long j = j();
        com.bytedance.sdk.openadsdk.core.video.hf.xj en = en();
        return (en == null || !en.l()) ? j : en.xj(this.u, pz());
    }

    public long zg() {
        com.bykv.vk.openvk.component.video.api.u.w wVar = this.c;
        return wVar != null ? wVar.p() : this.f;
    }

    public void hf(boolean z) {
        if (this.c == null) {
            return;
        }
        int i = z ? wo() ? 2 : 4 : wo() ? 0 : 1;
        e.xj xjVar = new e.xj();
        xjVar.hf(e());
        long jk = jk();
        xjVar.w(jk);
        long zg = zg();
        if (en() != null) {
            xjVar.xj(en().xj(zg, jk));
        }
        xjVar.w(1 ^ (wo() ? 1 : 0));
        xjVar.u(i);
        com.bykv.vk.openvk.component.video.api.u.w wVar = this.c;
        if (!(wVar instanceof com.bytedance.sdk.openadsdk.core.video.hf.xj) || ((com.bytedance.sdk.openadsdk.core.video.hf.xj) wVar).pz.xj(r.b.d)) {
            return;
        }
        ((com.bytedance.sdk.openadsdk.core.video.hf.xj) this.c).pz.w(r.b.d);
        com.bytedance.sdk.openadsdk.y.hf.u.w(this.c.yo(), xjVar);
    }

    public void w(boolean z) {
        com.bykv.vk.openvk.component.video.api.u.w wVar = this.c;
        if (wVar != null) {
            wVar.hf(z);
        }
    }

    public void xj(FrameLayout frameLayout, String str, boolean z) {
        if (this.e) {
            return;
        }
        this.e = true;
        this.f10312pl = frameLayout;
        this.g = str;
        this.y = z;
        if (z) {
            this.c = new com.bytedance.sdk.openadsdk.core.component.reward.y.hf(this.tf, frameLayout, this.p, this.qt);
        } else {
            this.c = new com.bytedance.sdk.openadsdk.core.component.reward.y.xj(this.tf, frameLayout, this.p, this.qt);
        }
        this.kd = (int) ai();
    }

    public boolean xj() {
        com.bykv.vk.openvk.component.video.api.u.w wVar = this.c;
        return (wVar == null || wVar.e() == null || !this.c.e().d()) ? false : true;
    }

    public void xj(boolean z) {
        this.hf = z;
    }

    public void xj(long j) {
        this.f = j;
    }

    public void xj(long j, boolean z) {
        com.bykv.vk.openvk.component.video.api.u.w wVar = this.c;
        if (wVar == null || this.w) {
            return;
        }
        if (j != 0) {
            wVar.xj(j);
            this.c.hf(z);
        } else {
            wVar.f();
        }
    }

    public void xj(Map<String, Object> map) {
        com.bykv.vk.openvk.component.video.api.u.w wVar = this.c;
        if (wVar == null || this.w) {
            return;
        }
        wVar.xj(map);
    }

    public void hf(Map<String, Object> map) {
        com.bykv.vk.openvk.component.video.api.u.w wVar = this.c;
        if (wVar != null) {
            wVar.hf(map);
        }
    }

    public void hf(long j) {
        this.u = j;
        com.bytedance.sdk.openadsdk.core.video.hf.xj en = en();
        if (!pl() && p()) {
            this.kd = (int) Math.max(0L, Math.round(ai() - ((this.u + (h.zg(this.p).y() * 1000.0d)) / 1000.0d)));
        } else if (en != null && !(this.tf.aq() instanceof d)) {
            this.kd = Math.max(0, (int) (ai() - (en.yy() / 1000)));
        } else {
            this.kd = Math.max(0, (int) (ai() - (this.u / 1000)));
        }
    }

    public void xj(xj.InterfaceC0194xj interfaceC0194xj) {
        com.bykv.vk.openvk.component.video.api.u.w wVar = this.c;
        if (wVar instanceof com.bytedance.sdk.openadsdk.core.video.hf.xj) {
            ((com.bytedance.sdk.openadsdk.core.video.hf.xj) wVar).xj(interfaceC0194xj);
        }
    }

    public boolean xj(long j, boolean z, int i) {
        if (this.c == null || h.am(this.p) == null) {
            return false;
        }
        com.bykv.vk.openvk.component.video.api.w.u uVar = this.zg;
        if (uVar == null) {
            File file = new File(com.bytedance.sdk.openadsdk.x.d.xj(this.p.ul()).xj(), h.c(this.p));
            if (file.exists() && file.length() > 0) {
                this.xj = true;
            }
            uVar = h.xj(1, this.p);
            uVar.hf(this.p.ho());
            FrameLayout frameLayout = this.f10312pl;
            uVar.hf(frameLayout == null ? 100 : frameLayout.getWidth());
            FrameLayout frameLayout2 = this.f10312pl;
            uVar.w(frameLayout2 != null ? frameLayout2.getHeight() : 100);
            uVar.w(this.p.jf());
            uVar.xj(j);
            uVar.hf(z);
            if (tf.xj(this.p)) {
                uVar.xj(true);
            }
        }
        return this.c.xj(uVar);
    }

    public void xj(boolean z, TTBaseVideoActivity tTBaseVideoActivity) {
        boolean z2;
        long j;
        boolean z3;
        if (z || this.tf.s()) {
            return;
        }
        if (w()) {
            com.bytedance.sdk.openadsdk.core.video.hf.hf l = this.tf.aq().l();
            if (l != null) {
                z2 = l.u();
                j = l.kd();
                z3 = l.y();
            } else {
                z2 = false;
                j = 0;
                z3 = false;
            }
            if (z2) {
                n();
                xj(tTBaseVideoActivity);
            } else {
                xj(j, z3);
            }
            pl.xj("TTBaseVideoActivity", "resumeOrRestartVideo: continue play");
            return;
        }
        n();
        xj(tTBaseVideoActivity);
        pl.xj("TTBaseVideoActivity", "resumeOrRestartVideo: recreate video player & exec play");
    }

    public void xj(TTBaseVideoActivity tTBaseVideoActivity) {
        if (!ht() || tTBaseVideoActivity == null) {
            return;
        }
        tTBaseVideoActivity.hf(y(), true);
    }

    public void xj(int i) {
        com.bykv.vk.openvk.component.video.api.u.w wVar = this.c;
        if (wVar != null) {
            wVar.xj(i);
        }
    }

    public void xj(ws wsVar, com.bykv.vk.openvk.component.video.api.u.w wVar, com.bykv.vk.openvk.component.video.api.w.u uVar) {
        this.p = wsVar;
        this.c = wVar;
        this.zg = uVar;
    }

    public void xj(com.bytedance.sdk.openadsdk.core.hf.xj xjVar) {
        this.qt = xjVar;
    }

    public void xj(float f) {
        if (this.c.e() != null) {
            this.c.e().xj(f);
        }
    }
}
