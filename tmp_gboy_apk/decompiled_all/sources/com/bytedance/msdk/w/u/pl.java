package com.bytedance.msdk.w.u;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.bytedance.msdk.f.am;
import com.bytedance.msdk.f.v;
import com.bytedance.msdk.f.zg;
import com.bytedance.msdk.w.u.tf;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class pl extends tf implements com.bytedance.msdk.xj.hf.u {
    private boolean dk;
    private final com.bytedance.msdk.xj.hf.hf et;
    private com.bytedance.msdk.api.u.xj.f.hf hf;
    private com.bytedance.msdk.core.admanager.reward.xj ht;
    private com.bytedance.msdk.api.u.xj.f.xj jk;
    private com.bytedance.msdk.core.admanager.reward.xj pz;
    private com.bytedance.msdk.core.admanager.reward.rewardagain.w ra;
    com.bytedance.msdk.api.u.xj.f.xj xj;
    private com.bytedance.msdk.api.u.xj.f.xj zg;

    /* renamed from: com.bytedance.msdk.w.u.pl$6, reason: invalid class name */
    public class AnonymousClass6 implements com.bytedance.msdk.xj.hf.hf {
        private volatile boolean hf = false;
        private volatile boolean w = false;
        private final Handler u = new Handler(Looper.getMainLooper());

        public AnonymousClass6() {
        }

        private void f() {
            this.u.postDelayed(new Runnable() { // from class: com.bytedance.msdk.w.u.pl.6.2
                @Override // java.lang.Runnable
                public void run() {
                    if (AnonymousClass6.this.w || AnonymousClass6.this.hf) {
                        AnonymousClass6.this.c();
                        return;
                    }
                    pl.this.xj(new com.bytedance.msdk.api.w.xj() { // from class: com.bytedance.msdk.w.u.pl.6.2.1
                        @Override // com.bytedance.msdk.api.w.xj
                        public float hf() {
                            if (pl.this.y != null) {
                                return r0.z();
                            }
                            return 0.0f;
                        }

                        @Override // com.bytedance.msdk.api.w.xj
                        public Map<String, Object> u() {
                            return new HashMap();
                        }

                        @Override // com.bytedance.msdk.api.w.xj
                        public String w() {
                            com.bytedance.msdk.api.xj.hf hfVar = pl.this.y;
                            return hfVar != null ? hfVar.q() : "";
                        }

                        @Override // com.bytedance.msdk.api.w.xj
                        public boolean xj() {
                            return true;
                        }
                    });
                    AnonymousClass6.this.c();
                }
            }, com.bytedance.msdk.c.xj.xj.xj().y());
        }

        public void c() {
            this.u.removeCallbacksAndMessages(null);
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x0061  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0076  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x00b0  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0114  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0133  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x013f  */
        @Override // com.bytedance.msdk.api.u.xj.u.xj
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void g_() {
            /*
                Method dump skipped, instructions count: 384
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.w.u.pl.AnonymousClass6.g_():void");
        }

        @Override // com.bytedance.msdk.api.u.xj.u.xj
        public void h_() {
            String str;
            long j;
            String str2;
            String str3 = null;
            if (zg.xj()) {
                com.bytedance.msdk.hf.w wVar = pl.this.u;
                if (wVar != null && MediationConstant.ADN_PANGLE.equals(wVar.lw())) {
                    if (!zg.w()) {
                        String xj = v.xj();
                        pl plVar = pl.this;
                        com.bytedance.msdk.kd.y.xj(plVar.u, plVar.y, 5, 1, 0, xj);
                        return;
                    } else if (zg.f()) {
                        str2 = v.xj();
                        if (!pl.this.et() && pl.this.zg != null) {
                            pl.this.zg.j_();
                        }
                        str = str2;
                    }
                }
                str2 = null;
                if (!pl.this.et()) {
                    pl.this.zg.j_();
                }
                str = str2;
            } else {
                if (pl.this.zg != null) {
                    pl.this.zg.j_();
                }
                str = null;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (v.xj(pl.this.u)) {
                str3 = v.hf();
                j = System.currentTimeMillis() - currentTimeMillis;
            } else {
                j = -1;
            }
            long j2 = j;
            String str4 = str3;
            com.bytedance.msdk.core.hf.xj.kd(pl.this.kd);
            pl plVar2 = pl.this;
            com.bytedance.msdk.hf.w wVar2 = plVar2.u;
            com.bytedance.msdk.kd.y.hf(wVar2, plVar2.y, 0, str4, j2, str, wVar2.en());
        }

        @Override // com.bytedance.msdk.api.u.xj.u.xj
        public void kd() {
            pl.this.kd();
        }

        @Override // com.bytedance.msdk.api.u.xj.u.xj
        public void u() {
            if (!zg.xj()) {
                pl.this.io();
                if (pl.this.pz.xj()) {
                    pl.this.pz.kd();
                }
                if (pl.this.zg != null) {
                    pl.this.zg.u();
                    return;
                }
                return;
            }
            com.bytedance.msdk.hf.w wVar = pl.this.u;
            if (wVar != null && MediationConstant.ADN_PANGLE.equals(wVar.lw())) {
                if (!zg.w()) {
                    String xj = v.xj();
                    pl plVar = pl.this;
                    com.bytedance.msdk.kd.y.xj(plVar.u, plVar.y, 1, 1, 0, xj);
                    return;
                }
                pl plVar2 = pl.this;
                com.bytedance.msdk.kd.y.xj(plVar2.u, plVar2.y, 1, 0, 0, (String) null);
            }
            if (pl.this.et()) {
                return;
            }
            pl.this.io();
            if (pl.this.pz.xj()) {
                pl.this.pz.kd();
            }
            if (pl.this.zg != null) {
                pl.this.zg.u();
            }
        }

        @Override // com.bytedance.msdk.api.u.xj.u.xj
        public void w() {
            c();
            this.w = true;
            if (!zg.xj()) {
                pl.this.io();
                if (pl.this.ht() || pl.this.zg == null) {
                    return;
                }
                pl.this.zg.w();
                return;
            }
            com.bytedance.msdk.hf.w wVar = pl.this.u;
            if (wVar != null && MediationConstant.ADN_PANGLE.equals(wVar.lw())) {
                if (!zg.w()) {
                    String xj = v.xj();
                    pl plVar = pl.this;
                    com.bytedance.msdk.kd.y.xj(plVar.u, plVar.y, 2, 1, 0, xj);
                    return;
                }
                pl plVar2 = pl.this;
                com.bytedance.msdk.kd.y.xj(plVar2.u, plVar2.y, 2, 0, 0, (String) null);
            }
            if (pl.this.et()) {
                return;
            }
            pl.this.io();
            if (pl.this.ht() || pl.this.zg == null) {
                return;
            }
            pl.this.zg.w();
        }

        @Override // com.bytedance.msdk.api.u.xj.u.xj
        public void xj(com.bytedance.msdk.api.w.xj xjVar) {
        }

        @Override // com.bytedance.msdk.api.u.xj.u.xj
        public void y() {
            c();
            this.hf = true;
            if (!zg.xj()) {
                pl.this.io();
                if (pl.this.pz.xj()) {
                    pl.this.pz.hf();
                }
                if (pl.this.zg != null) {
                    pl.this.zg.y();
                    return;
                }
                return;
            }
            com.bytedance.msdk.hf.w wVar = pl.this.u;
            if (wVar != null && MediationConstant.ADN_PANGLE.equals(wVar.lw())) {
                if (!zg.w()) {
                    String xj = v.xj();
                    pl plVar = pl.this;
                    com.bytedance.msdk.kd.y.xj(plVar.u, plVar.y, 3, 1, 0, xj);
                    return;
                }
                pl plVar2 = pl.this;
                com.bytedance.msdk.kd.y.xj(plVar2.u, plVar2.y, 3, 0, 0, (String) null);
            }
            if (pl.this.et()) {
                return;
            }
            pl.this.io();
            if (pl.this.pz.xj()) {
                pl.this.pz.hf();
            }
            if (pl.this.zg != null) {
                pl.this.zg.y();
            }
        }

        @Override // com.bytedance.msdk.api.u.xj.u.xj
        public void xj(com.bytedance.msdk.api.xj xjVar) {
            String str;
            long j;
            long currentTimeMillis = System.currentTimeMillis();
            if (v.xj(pl.this.u)) {
                str = v.hf();
                j = System.currentTimeMillis() - currentTimeMillis;
            } else {
                str = null;
                j = -1;
            }
            String str2 = str;
            long j2 = j;
            pl plVar = pl.this;
            com.bytedance.msdk.kd.y.xj(plVar.u, plVar.y, xjVar, 1, 0, str2, j2);
            pl.this.u(xjVar);
        }
    }

    public pl(Context context) {
        super(context);
        this.xj = new AnonymousClass2();
        this.et = new AnonymousClass6();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ht() {
        com.bytedance.msdk.api.xj.hf hfVar = this.y;
        if (hfVar == null || hfVar.f() == 1) {
            A2egSU.BI9f7h(new StringBuilder("--==--ra: 激励再得，一次链路只展示一次激励再得: "), this.kd, MediationConstant.TAG);
            return false;
        }
        com.bytedance.msdk.core.admanager.reward.rewardagain.xj d = com.bytedance.msdk.core.admanager.reward.rewardagain.w.d(this.kd);
        if (d == null) {
            A2egSU.BI9f7h(new StringBuilder("--==--ra: 激励再得开关未开启: "), this.kd, MediationConstant.TAG);
            return false;
        }
        if (this.dk) {
            A2egSU.BI9f7h(new StringBuilder("--==--ra: 激励再得，adn已经触发了再看一个: "), this.kd, MediationConstant.TAG);
            return false;
        }
        com.bytedance.msdk.core.admanager.reward.rewardagain.w wVar = this.ra;
        if (wVar != null) {
            int xj = wVar.xj(this.y, d, this.u);
            com.bytedance.msdk.kd.y.xj(this.y, xj, com.bytedance.msdk.core.kd.hf.u.xj().w(this.kd, this.y.kd()) ? this.yo ? 4 : 2 : 1);
            if (xj == 0) {
                this.ra.xj(d, this.u);
                return true;
            }
        }
        return false;
    }

    @Override // com.bytedance.msdk.w.u.hf, com.bytedance.msdk.w.hf.xj.xj
    public void c() {
        com.bytedance.msdk.api.u.xj.f.hf hfVar = this.hf;
        if (hfVar != null) {
            hfVar.xj();
        }
    }

    @Override // com.bytedance.msdk.w.u.hf, com.bytedance.msdk.w.hf.xj.xj
    public void f() {
        com.bytedance.msdk.api.u.xj.f.hf hfVar = this.hf;
        if (hfVar != null) {
            hfVar.hf();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0106  */
    @Override // com.bytedance.msdk.api.u.xj.f.xj
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void i_() {
        /*
            Method dump skipped, instructions count: 321
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.w.u.pl.i_():void");
    }

    @Override // com.bytedance.msdk.api.u.xj.f.xj
    public void j_() {
        String str;
        long j;
        String str2;
        com.bytedance.msdk.api.u.xj.f.xj xjVar;
        com.bytedance.msdk.core.hf.xj.kd(this.y.ra());
        String str3 = null;
        if (zg.xj()) {
            com.bytedance.msdk.hf.w wVar = this.u;
            if (wVar != null && MediationConstant.ADN_PANGLE.equals(wVar.lw())) {
                if (!zg.hf()) {
                    com.bytedance.msdk.kd.y.xj(this.u, this.y, 5, 1, 0, v.xj());
                    return;
                } else if (zg.kd()) {
                    str2 = v.xj();
                    if (!et() && (xjVar = this.zg) != null) {
                        xjVar.j_();
                    }
                    str = str2;
                }
            }
            str2 = null;
            if (!et()) {
                xjVar.j_();
            }
            str = str2;
        } else {
            com.bytedance.msdk.api.u.xj.f.xj xjVar2 = this.zg;
            if (xjVar2 != null) {
                xjVar2.j_();
            }
            str = null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (v.xj(this.u)) {
            str3 = v.hf();
            j = System.currentTimeMillis() - currentTimeMillis;
        } else {
            j = -1;
        }
        long j2 = j;
        String str4 = str3;
        com.bytedance.msdk.hf.w wVar2 = this.u;
        com.bytedance.msdk.kd.y.hf(wVar2, this.y, 0, str4, j2, str, wVar2.en());
    }

    @Override // com.bytedance.msdk.api.u.xj.f.xj
    public void y() {
        if (!zg.xj()) {
            io();
            if (this.pz.xj()) {
                this.pz.hf();
            }
            com.bytedance.msdk.api.u.xj.f.xj xjVar = this.zg;
            if (xjVar != null) {
                xjVar.y();
                return;
            }
            return;
        }
        com.bytedance.msdk.hf.w wVar = this.u;
        if (wVar != null && MediationConstant.ADN_PANGLE.equals(wVar.lw())) {
            if (!zg.hf()) {
                com.bytedance.msdk.kd.y.xj(this.u, this.y, 3, 1, 0, v.xj());
                return;
            }
            com.bytedance.msdk.kd.y.xj(this.u, this.y, 3, 0, 0, (String) null);
        }
        if (et()) {
            return;
        }
        io();
        if (this.pz.xj()) {
            this.pz.hf();
        }
        com.bytedance.msdk.api.u.xj.f.xj xjVar2 = this.zg;
        if (xjVar2 != null) {
            xjVar2.y();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(final com.bytedance.msdk.api.xj xjVar) {
        com.bytedance.msdk.xj.kd.y.w(new Runnable() { // from class: com.bytedance.msdk.w.u.pl.5
            @Override // java.lang.Runnable
            public void run() {
                if (pl.this.zg != null) {
                    pl.this.zg.xj(xjVar);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(final com.bytedance.msdk.api.xj xjVar) {
        com.bytedance.msdk.xj.kd.y.w(new Runnable() { // from class: com.bytedance.msdk.w.u.pl.3
            @Override // java.lang.Runnable
            public void run() {
                if (pl.this.jk != null) {
                    pl.this.jk.xj(xjVar);
                }
            }
        });
    }

    @Override // com.bytedance.msdk.api.u.xj.f.xj
    public void kd() {
        String str;
        long j;
        long currentTimeMillis = System.currentTimeMillis();
        if (v.xj(this.u)) {
            str = v.hf();
            j = System.currentTimeMillis() - currentTimeMillis;
        } else {
            str = null;
            j = -1;
        }
        com.bytedance.msdk.kd.y.xj(this.u, this.y, (com.bytedance.msdk.api.xj) null, 2, 0, str, j);
        com.bytedance.msdk.api.u.xj.f.xj xjVar = this.zg;
        if (xjVar != null) {
            xjVar.kd();
        }
    }

    @Override // com.bytedance.msdk.w.u.hf, com.bytedance.msdk.w.hf.xj.xj
    public void hf(com.bytedance.msdk.api.xj xjVar) {
        com.bytedance.msdk.api.u.xj.f.hf hfVar = this.hf;
        if (hfVar != null) {
            hfVar.xj(xjVar);
        }
    }

    @Override // com.bytedance.msdk.api.u.xj.f.xj
    public void u() {
        if (zg.xj()) {
            com.bytedance.msdk.hf.w wVar = this.u;
            if (wVar != null && MediationConstant.ADN_PANGLE.equals(wVar.lw())) {
                if (!zg.hf()) {
                    com.bytedance.msdk.kd.y.xj(this.u, this.y, 1, 1, 0, v.xj());
                    return;
                }
                com.bytedance.msdk.kd.y.xj(this.u, this.y, 1, 0, 0, (String) null);
            }
            if (et()) {
                return;
            }
            io();
            if (this.pz.xj()) {
                this.pz.kd();
            }
            com.bytedance.msdk.api.u.xj.f.xj xjVar = this.zg;
            if (xjVar != null) {
                xjVar.u();
                return;
            }
            return;
        }
        io();
        if (this.pz.xj()) {
            this.pz.kd();
        }
        com.bytedance.msdk.api.u.xj.f.xj xjVar2 = this.zg;
        if (xjVar2 != null) {
            xjVar2.u();
        }
    }

    @Override // com.bytedance.msdk.api.u.xj.f.xj
    public void w() {
        com.bytedance.msdk.api.u.xj.f.xj xjVar;
        com.bytedance.msdk.api.u.xj.f.xj xjVar2;
        if (zg.xj()) {
            com.bytedance.msdk.hf.w wVar = this.u;
            if (wVar != null && MediationConstant.ADN_PANGLE.equals(wVar.lw())) {
                if (!zg.hf()) {
                    com.bytedance.msdk.kd.y.xj(this.u, this.y, 2, 1, 0, v.xj());
                    return;
                }
                com.bytedance.msdk.kd.y.xj(this.u, this.y, 2, 0, 0, (String) null);
            }
            if (et()) {
                return;
            }
            io();
            if (ht() || (xjVar2 = this.zg) == null) {
                return;
            }
            xjVar2.w();
            return;
        }
        io();
        if (ht() || (xjVar = this.zg) == null) {
            return;
        }
        xjVar.w();
    }

    public void hf(com.bytedance.msdk.api.u.xj.f.xj xjVar) {
        this.jk = xjVar;
        com.bytedance.msdk.core.admanager.reward.rewardagain.w wVar = this.ra;
        if (wVar != null) {
            wVar.hf(xjVar);
        }
    }

    public void xj(com.bytedance.msdk.api.xj.hf hfVar, com.bytedance.msdk.api.u.xj.f.hf hfVar2) {
        xj(hfVar);
        this.pz = new com.bytedance.msdk.core.admanager.reward.xj(this.kd);
        this.ht = new com.bytedance.msdk.core.admanager.reward.xj(this.kd);
        this.hf = hfVar2;
        this.d = this;
        this.v = this.xj;
        if (com.bytedance.msdk.core.admanager.reward.rewardagain.w.d(this.kd) != null) {
            this.ra = new com.bytedance.msdk.core.admanager.reward.rewardagain.w(this.f.get(), this.y, this.zg, this.jk);
        }
        d();
    }

    /* renamed from: com.bytedance.msdk.w.u.pl$2, reason: invalid class name */
    public class AnonymousClass2 implements com.bytedance.msdk.api.u.xj.f.xj {
        public AnonymousClass2() {
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x0063  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0078  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x00b2  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0108  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0127  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x0133  */
        @Override // com.bytedance.msdk.api.u.xj.f.xj
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void i_() {
            /*
                Method dump skipped, instructions count: 322
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.w.u.pl.AnonymousClass2.i_():void");
        }

        @Override // com.bytedance.msdk.api.u.xj.f.xj
        public void j_() {
            String str;
            long j;
            String str2;
            String str3 = null;
            if (zg.xj()) {
                com.bytedance.msdk.hf.w wVar = pl.this.u;
                if (wVar != null && MediationConstant.ADN_PANGLE.equals(wVar.lw())) {
                    if (!zg.hf()) {
                        String xj = v.xj();
                        pl plVar = pl.this;
                        com.bytedance.msdk.kd.y.xj(plVar.u, plVar.y, 5, 1, 1, xj);
                        return;
                    } else if (zg.kd()) {
                        str2 = v.xj();
                        if (!pl.this.et() && pl.this.jk != null) {
                            pl.this.jk.j_();
                        }
                        str = str2;
                    }
                }
                str2 = null;
                if (!pl.this.et()) {
                    pl.this.jk.j_();
                }
                str = str2;
            } else {
                if (pl.this.jk != null) {
                    pl.this.jk.j_();
                }
                str = null;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (v.xj(pl.this.u)) {
                str3 = v.hf();
                j = System.currentTimeMillis() - currentTimeMillis;
            } else {
                j = -1;
            }
            long j2 = j;
            String str4 = str3;
            pl plVar2 = pl.this;
            com.bytedance.msdk.hf.w wVar2 = plVar2.u;
            com.bytedance.msdk.kd.y.hf(wVar2, plVar2.y, 1, str4, j2, str, wVar2.l());
        }

        @Override // com.bytedance.msdk.api.u.xj.f.xj
        public void kd() {
            String str;
            long j;
            long currentTimeMillis = System.currentTimeMillis();
            if (v.xj(pl.this.u)) {
                str = v.hf();
                j = System.currentTimeMillis() - currentTimeMillis;
            } else {
                str = null;
                j = -1;
            }
            String str2 = str;
            long j2 = j;
            pl plVar = pl.this;
            com.bytedance.msdk.kd.y.xj(plVar.u, plVar.y, (com.bytedance.msdk.api.xj) null, 2, 1, str2, j2);
            if (pl.this.jk != null) {
                pl.this.jk.kd();
            }
        }

        @Override // com.bytedance.msdk.api.u.xj.f.xj
        public void u() {
            if (!zg.xj()) {
                if (pl.this.ht.xj()) {
                    pl.this.ht.kd();
                }
                if (pl.this.jk != null) {
                    pl.this.jk.u();
                    return;
                }
                return;
            }
            com.bytedance.msdk.hf.w wVar = pl.this.u;
            if (wVar != null && MediationConstant.ADN_PANGLE.equals(wVar.lw())) {
                if (!zg.hf()) {
                    String xj = v.xj();
                    pl plVar = pl.this;
                    com.bytedance.msdk.kd.y.xj(plVar.u, plVar.y, 1, 1, 1, xj);
                    return;
                }
                pl plVar2 = pl.this;
                com.bytedance.msdk.kd.y.xj(plVar2.u, plVar2.y, 1, 0, 1, (String) null);
            }
            if (pl.this.et()) {
                return;
            }
            if (pl.this.ht.xj()) {
                pl.this.ht.kd();
            }
            if (pl.this.jk != null) {
                pl.this.jk.u();
            }
        }

        @Override // com.bytedance.msdk.api.u.xj.f.xj
        public void w() {
            if (!zg.xj()) {
                if (pl.this.jk != null) {
                    pl.this.jk.w();
                    return;
                }
                return;
            }
            com.bytedance.msdk.hf.w wVar = pl.this.u;
            if (wVar != null && MediationConstant.ADN_PANGLE.equals(wVar.lw())) {
                if (!zg.hf()) {
                    String xj = v.xj();
                    pl plVar = pl.this;
                    com.bytedance.msdk.kd.y.xj(plVar.u, plVar.y, 2, 1, 1, xj);
                    return;
                }
                pl plVar2 = pl.this;
                com.bytedance.msdk.kd.y.xj(plVar2.u, plVar2.y, 2, 0, 1, (String) null);
            }
            if (pl.this.et() || pl.this.jk == null) {
                return;
            }
            pl.this.jk.w();
        }

        @Override // com.bytedance.msdk.api.u.xj.f.xj
        public void xj(com.bytedance.msdk.api.xj xjVar) {
            String str;
            long j;
            long currentTimeMillis = System.currentTimeMillis();
            if (v.xj(pl.this.u)) {
                str = v.hf();
                j = System.currentTimeMillis() - currentTimeMillis;
            } else {
                str = null;
                j = -1;
            }
            String str2 = str;
            long j2 = j;
            pl plVar = pl.this;
            com.bytedance.msdk.kd.y.xj(plVar.u, plVar.y, xjVar, 1, 1, str2, j2);
            pl.this.w(xjVar);
        }

        @Override // com.bytedance.msdk.api.u.xj.f.xj
        public void y() {
            if (!zg.xj()) {
                if (pl.this.ht.xj()) {
                    pl.this.ht.hf();
                }
                if (pl.this.jk != null) {
                    pl.this.jk.y();
                    return;
                }
                return;
            }
            com.bytedance.msdk.hf.w wVar = pl.this.u;
            if (wVar != null && MediationConstant.ADN_PANGLE.equals(wVar.lw())) {
                if (!zg.hf()) {
                    String xj = v.xj();
                    pl plVar = pl.this;
                    com.bytedance.msdk.kd.y.xj(plVar.u, plVar.y, 3, 1, 1, xj);
                    return;
                }
                pl plVar2 = pl.this;
                com.bytedance.msdk.kd.y.xj(plVar2.u, plVar2.y, 3, 0, 1, (String) null);
            }
            if (pl.this.et()) {
                return;
            }
            if (pl.this.ht.xj()) {
                pl.this.ht.hf();
            }
            if (pl.this.jk != null) {
                pl.this.jk.y();
            }
        }

        @Override // com.bytedance.msdk.api.u.xj.f.xj
        public void xj(com.bytedance.msdk.api.w.xj xjVar) {
            if (!zg.xj()) {
                if (pl.this.ht.xj()) {
                    pl.this.ht.u();
                    return;
                } else {
                    if (pl.this.jk != null) {
                        com.bytedance.msdk.api.u.xj.f.xj xjVar2 = pl.this.jk;
                        pl plVar = pl.this;
                        xjVar2.xj(pl.xj(plVar.y, xjVar, plVar.u));
                        pl.this.xj((com.bytedance.msdk.api.w.xj) null, 1);
                        return;
                    }
                    return;
                }
            }
            com.bytedance.msdk.hf.w wVar = pl.this.u;
            if (wVar != null && MediationConstant.ADN_PANGLE.equals(wVar.lw())) {
                if (!zg.hf()) {
                    String xj = v.xj();
                    pl plVar2 = pl.this;
                    com.bytedance.msdk.kd.y.xj(plVar2.u, plVar2.y, 4, 1, 1, xj);
                    return;
                } else {
                    String xj2 = zg.y() ? v.xj() : null;
                    pl plVar3 = pl.this;
                    com.bytedance.msdk.kd.y.xj(plVar3.u, plVar3.y, 4, 0, 1, xj2);
                }
            }
            if (pl.this.et()) {
                return;
            }
            if (pl.this.ht.xj()) {
                pl.this.ht.u();
            } else if (pl.this.jk != null) {
                com.bytedance.msdk.api.u.xj.f.xj xjVar3 = pl.this.jk;
                pl plVar4 = pl.this;
                xjVar3.xj(pl.xj(plVar4.y, xjVar, plVar4.u));
                pl.this.xj((com.bytedance.msdk.api.w.xj) null, 1);
            }
        }
    }

    public void xj(Activity activity, Object obj, String str) {
        com.bytedance.msdk.core.admanager.reward.rewardagain.w wVar = this.ra;
        if (wVar != null) {
            wVar.xj(activity, obj, str);
        }
        xj(activity, obj, str, new tf.xj() { // from class: com.bytedance.msdk.w.u.pl.1
            @Override // com.bytedance.msdk.w.u.tf.xj
            public void xj() {
                pl.this.u(new com.bytedance.msdk.api.xj(40052, com.bytedance.msdk.api.xj.xj(40052)));
            }
        });
        if (this.zg == null) {
            com.bytedance.msdk.xj.kd.w.xj(MediationConstant.TAG, "注意：未设置GMRewardedAdListener，将收不到广告播放/点击/关闭等回调信息");
        }
        xj(this.u);
    }

    public void xj(Activity activity) {
        xj(activity, (Object) null, (String) null);
    }

    @Override // com.bytedance.msdk.w.u.tf
    public void xj(com.bytedance.msdk.hf.w wVar, Activity activity, Object obj, String str) {
        if (wVar != null) {
            if (wVar.tj() != 6 && wVar.tj() == 7) {
                this.d = this.et;
            } else {
                this.d = this;
            }
        }
        super.xj(wVar, activity, obj, str);
    }

    public void xj(com.bytedance.msdk.api.u.xj.f.xj xjVar) {
        this.zg = xjVar;
        com.bytedance.msdk.core.admanager.reward.rewardagain.w wVar = this.ra;
        if (wVar != null) {
            wVar.xj(xjVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(com.bytedance.msdk.api.w.xj xjVar, int i) {
        String str;
        long j;
        String str2;
        int i2;
        int i3;
        Map<String, Object> u;
        long currentTimeMillis = System.currentTimeMillis();
        if (v.xj(this.u)) {
            str = v.hf();
            j = System.currentTimeMillis() - currentTimeMillis;
        } else {
            str = null;
            j = -1;
        }
        String str3 = str;
        long j2 = j;
        if (xjVar != null && (u = xjVar.u()) != null) {
            Integer num = (Integer) u.get(MediationConstant.KEY_REASON);
            int intValue = num != null ? num.intValue() : 0;
            Integer num2 = (Integer) u.get(MediationConstant.KEY_ERROR_CODE);
            int intValue2 = num2 != null ? num2.intValue() : 0;
            str2 = (String) u.get(MediationConstant.KEY_ERROR_MSG);
            i3 = intValue2;
            i2 = intValue;
        } else {
            str2 = "";
            i2 = 0;
            i3 = 0;
        }
        com.bytedance.msdk.kd.y.xj(this.u, this.y, i, str3, j2, i2, i3, str2);
    }

    public static com.bytedance.msdk.api.w.xj xj(final com.bytedance.msdk.api.xj.hf hfVar, final com.bytedance.msdk.api.w.xj xjVar, final com.bytedance.msdk.hf.w wVar) {
        if (xjVar == null) {
            return null;
        }
        return new com.bytedance.msdk.api.w.xj() { // from class: com.bytedance.msdk.w.u.pl.4
            @Override // com.bytedance.msdk.api.w.xj
            public float hf() {
                return com.bytedance.msdk.api.w.xj.this.hf();
            }

            @Override // com.bytedance.msdk.api.w.xj
            public Map<String, Object> u() {
                Map<String, Object> u = com.bytedance.msdk.api.w.xj.this.u();
                HashMap hashMap = (u == null || u.size() <= 0) ? new HashMap() : new HashMap(u);
                com.bytedance.msdk.api.w xj = am.xj(hfVar, wVar, true);
                hashMap.put(MediationConstant.KEY_ADN_NAME, xj != null ? xj.pl() : "");
                hashMap.put("ecpm", xj != null ? xj.g() : "");
                return hashMap;
            }

            @Override // com.bytedance.msdk.api.w.xj
            public String w() {
                return com.bytedance.msdk.api.w.xj.this.w();
            }

            @Override // com.bytedance.msdk.api.w.xj
            public boolean xj() {
                return com.bytedance.msdk.api.w.xj.this.xj();
            }
        };
    }

    @Override // com.bytedance.msdk.w.u.tf, com.bytedance.msdk.w.u.hf
    public void xj() {
        if (this.u == null) {
            com.bytedance.msdk.core.kd.xj.xj xj = com.bytedance.msdk.core.kd.xj.xj.xj();
            List<com.bytedance.msdk.hf.w> jk = this.w.jk();
            String str = this.kd;
            com.bytedance.msdk.api.xj.hf hfVar = this.y;
            xj.xj(jk, str, hfVar, hfVar.kd(), this.u);
        }
        super.xj();
        this.pz.w();
        this.ht.w();
        this.hf = null;
        this.zg = null;
    }

    @Override // com.bytedance.msdk.api.u.xj.f.xj
    public void xj(com.bytedance.msdk.api.xj xjVar) {
        String str;
        long j;
        long currentTimeMillis = System.currentTimeMillis();
        if (v.xj(this.u)) {
            str = v.hf();
            j = System.currentTimeMillis() - currentTimeMillis;
        } else {
            str = null;
            j = -1;
        }
        com.bytedance.msdk.kd.y.xj(this.u, this.y, xjVar, 1, 0, str, j);
        u(xjVar);
    }

    @Override // com.bytedance.msdk.api.u.xj.f.xj
    public void xj(com.bytedance.msdk.api.w.xj xjVar) {
        if (zg.xj()) {
            com.bytedance.msdk.hf.w wVar = this.u;
            if (wVar != null && MediationConstant.ADN_PANGLE.equals(wVar.lw())) {
                if (!zg.hf()) {
                    com.bytedance.msdk.kd.y.xj(this.u, this.y, 4, 1, 0, v.xj());
                    return;
                }
                com.bytedance.msdk.kd.y.xj(this.u, this.y, 4, 0, 0, zg.y() ? v.xj() : null);
            }
            if (et()) {
                return;
            }
            com.bytedance.msdk.core.admanager.reward.rewardagain.w wVar2 = this.ra;
            if (wVar2 != null) {
                wVar2.hf();
            }
            if (this.pz.xj()) {
                this.pz.u();
                return;
            }
            com.bytedance.msdk.api.u.xj.f.xj xjVar2 = this.zg;
            if (xjVar2 != null) {
                xjVar2.xj(xj(this.y, xjVar, this.u));
                xj((com.bytedance.msdk.api.w.xj) null, 0);
                return;
            }
            return;
        }
        com.bytedance.msdk.core.admanager.reward.rewardagain.w wVar3 = this.ra;
        if (wVar3 != null) {
            wVar3.hf();
        }
        if (this.pz.xj()) {
            this.pz.u();
            return;
        }
        com.bytedance.msdk.api.u.xj.f.xj xjVar3 = this.zg;
        if (xjVar3 != null) {
            xjVar3.xj(xj(this.y, xjVar, this.u));
            xj((com.bytedance.msdk.api.w.xj) null, 0);
        }
    }
}
