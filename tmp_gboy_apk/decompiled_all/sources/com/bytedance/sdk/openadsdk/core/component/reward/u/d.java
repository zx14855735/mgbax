package com.bytedance.sdk.openadsdk.core.component.reward.u;

import J3FDQU.A2egSU;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.ra.aq;
import com.bytedance.sdk.openadsdk.core.ra.tu;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class d extends xj {

    /* renamed from: a, reason: collision with root package name */
    private final AtomicBoolean f10319a;
    private final com.bytedance.sdk.openadsdk.core.video.hf.hf b;
    private long en;
    private final AtomicBoolean ff;
    private final int j;
    private final AtomicBoolean l;
    private com.bytedance.sdk.openadsdk.core.component.reward.business.xj.xj r;
    private final AtomicBoolean wo;
    protected final AtomicLong z;

    public d(TTBaseVideoActivity tTBaseVideoActivity, ws wsVar) {
        super(tTBaseVideoActivity, wsVar);
        this.j = 4;
        this.en = 4L;
        this.l = new AtomicBoolean(false);
        this.ff = new AtomicBoolean(false);
        this.f10319a = new AtomicBoolean(false);
        this.wo = new AtomicBoolean(false);
        this.z = new AtomicLong();
        this.b = new com.bytedance.sdk.openadsdk.core.video.hf.hf() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.u.d.1
            @Override // com.bytedance.sdk.openadsdk.core.video.hf.hf
            public Map<String, Object> c() {
                return A2egSU.BI9f7h("refer", "in_video");
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.hf.hf
            public void d() {
                d.this.xj.eu();
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.hf.hf
            public void f() {
                d.this.gj();
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.hf.hf
            public void hf() {
                d.this.f10319a.set(false);
                d.this.d.kd(8);
                if (!d.this.c()) {
                    d.this.xj.eu();
                }
                d.this.xj.ra();
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.hf.hf
            public long kd() {
                return d.this.z.get();
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.hf.hf
            public int p() {
                return d.this.f10319a.get() ? 1 : 2;
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.hf.hf
            public void tf() {
                TTBaseVideoActivity tTBaseVideoActivity2 = d.this.xj;
                if (tTBaseVideoActivity2 != null) {
                    tTBaseVideoActivity2.p();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.hf.hf
            public boolean u() {
                return d.this.wo.get();
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.hf.hf
            public void w() {
                d.this.en();
                d.this.wo.set(true);
                d.this.xj.pl();
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.hf.hf
            public boolean xj() {
                if (!d.this.f10319a.get() && !tu.hf(d.this.hf)) {
                    return false;
                }
                d.this.ss();
                return true;
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.hf.hf
            public boolean y() {
                return d.this.pz.y();
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.hf.hf
            public void xj(long j, long j2) {
                d.this.v.hf(j);
                d.this.jk();
                d.this.z.set(j);
            }
        };
    }

    private void cy() {
        this.ff.set(true);
        this.r.xj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gj() {
        this.l.set(false);
    }

    public static int hf(ws wsVar) {
        return 10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ss() {
        this.d.kd(0);
        this.xj.ws();
        this.r.w();
        this.xj.ht();
    }

    private void vl() {
        if (this.ff.get()) {
            long j = this.en - 1;
            this.en = j;
            if (j != 0) {
                if (j > 0) {
                    this.r.xj(j);
                }
            } else {
                this.r.xj(j);
                this.f10319a.set(true);
                if (c()) {
                    this.r.xj(this.ra);
                } else {
                    this.r.xj(this.f);
                }
            }
        }
    }

    private void xv() {
        if (this.l.get()) {
            nb();
            vl();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.xj
    public void dk() {
        super.dk();
        this.yo.xj(false, "奖励已领取", "跳过", false, true);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.hf
    public boolean dq() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.xj
    public void en() {
        super.en();
        this.yo.xj(false, "奖励已领取", "跳过", false, true);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.hf
    public void gh() {
        this.d.kd(8);
        this.d.y(0);
        this.yo.kd(true);
        this.yo.w(true);
        this.yo.hf(true);
        this.yo.xj(true);
        this.xj.yy();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.xj
    public void jk() {
        super.jk();
        this.zg = false;
        boolean z = ((int) (this.v.z() / 1000)) >= this.q.w() || this.xj.vm();
        if (this.v.l()) {
            this.yo.xj(false, null, "跳过", false, true);
            return;
        }
        int q = this.v.q();
        if (this.v.xj()) {
            return;
        }
        this.yo.xj(false, q + "s", z ? "跳过" : "", false, z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.xj
    public com.bytedance.sdk.openadsdk.core.video.hf.hf l() {
        return this.b;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.hf
    public boolean lw() {
        return true;
    }

    public void nb() {
        if (this.ff.get()) {
            return;
        }
        int z = (int) this.v.z();
        int pz = (int) this.v.pz();
        int w = tu.w(this.hf);
        if (w == 1) {
            xj(tu.u(this.hf), pz, this.q.kd() * 1000, false);
        } else if (w == 2) {
            xj((int) (pz * 0.001f * 0.01f * tu.u(this.hf)), pz, z, false);
        } else {
            if (w != 3) {
                return;
            }
            xj(a(), pz, z, true);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.hf
    public void op() {
        com.bytedance.sdk.openadsdk.core.nativeexpress.u uVar = this.ra;
        if (uVar != null) {
            ((com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj) uVar.xj(com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj.class)).xj(this.b);
            ((com.bytedance.sdk.openadsdk.core.hf.xj.w.xj) this.ra.xj(com.bytedance.sdk.openadsdk.core.hf.xj.w.xj.class)).xj(this.b);
        }
        com.bytedance.sdk.openadsdk.core.hf.kd kdVar = this.f;
        if (kdVar != null) {
            ((com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj) kdVar.xj(com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj.class)).xj(this.b);
            ((com.bytedance.sdk.openadsdk.core.hf.xj.w.xj) this.f.xj(com.bytedance.sdk.openadsdk.core.hf.xj.w.xj.class)).xj(this.b);
        }
        com.bytedance.sdk.openadsdk.core.component.reward.business.xj.xj xjVar = new com.bytedance.sdk.openadsdk.core.component.reward.business.xj.xj(this.xj, this.hf, this.b);
        this.r = xjVar;
        xjVar.xj(this.xj.l().getSceneFrameContainer(), this.xj.l().getSceneFrame());
        this.l.set(tu.w(this.hf) != 0);
        if (this.l.get()) {
            this.zg = true;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.xj
    public int q() {
        return hf(this.hf);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.hf
    public boolean qd() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.hf
    public boolean s() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.hf
    public boolean tu() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.hf
    public void wa() {
        xv();
        if (aq.e(this.hf)) {
            this.xj.w(0);
            if (et() > ws() || this.qt) {
                com.bytedance.sdk.openadsdk.core.f.u.xj = 0;
            }
            hf(y(true));
            com.bytedance.sdk.openadsdk.core.f.u.xj = r();
        }
    }

    public static boolean xj(ws wsVar) {
        return tu.xj(wsVar);
    }

    private void xj(int i, long j, long j2, boolean z) {
        if (z) {
            if (i <= 3) {
                cy();
            }
        } else if (i > 0) {
            long j3 = i * 1000;
            if (j3 > j) {
                return;
            }
            long j4 = j3 - j2;
            if (j4 <= 0 || Math.abs(j4) > 3200) {
                return;
            }
            cy();
        }
    }
}
