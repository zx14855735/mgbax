package com.bytedance.msdk.w.u;

import android.app.Activity;
import android.content.Context;
import com.bytedance.msdk.f.v;
import com.bytedance.msdk.f.zg;
import com.bytedance.msdk.w.u.tf;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj extends u {
    com.bytedance.msdk.xj.hf.w hf;
    private com.bytedance.msdk.api.u.xj.y.hf jk;
    private com.bytedance.msdk.api.u.xj.y.xj pz;
    com.bytedance.msdk.xj.hf.hf xj;

    public xj(Context context) {
        super(context);
        this.xj = new com.bytedance.msdk.xj.hf.hf() { // from class: com.bytedance.msdk.w.u.xj.3
            /* JADX WARN: Removed duplicated region for block: B:17:0x0066  */
            /* JADX WARN: Removed duplicated region for block: B:20:0x008c  */
            /* JADX WARN: Removed duplicated region for block: B:23:0x00f0  */
            /* JADX WARN: Removed duplicated region for block: B:26:0x010f  */
            /* JADX WARN: Removed duplicated region for block: B:30:0x011b  */
            @Override // com.bytedance.msdk.api.u.xj.u.xj
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public void g_() {
                /*
                    Method dump skipped, instructions count: 351
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.w.u.xj.AnonymousClass3.g_():void");
            }

            @Override // com.bytedance.msdk.api.u.xj.u.xj
            public void h_() {
                String str;
                long j;
                String str2;
                xj.this.dk();
                String str3 = null;
                if (zg.xj()) {
                    com.bytedance.msdk.hf.w wVar = xj.this.u;
                    if (wVar != null && MediationConstant.ADN_PANGLE.equals(wVar.lw())) {
                        if (!zg.w()) {
                            String xj = v.xj();
                            xj xjVar = xj.this;
                            com.bytedance.msdk.kd.y.xj(xjVar.u, xjVar.y, 5, 1, xjVar.pz() ? 1 : 0, xj);
                            return;
                        } else if (zg.f()) {
                            str2 = v.xj();
                            if (!xj.this.et() && xj.this.pz != null) {
                                xj.this.pz.hf();
                            }
                            str = str2;
                        }
                    }
                    str2 = null;
                    if (!xj.this.et()) {
                        xj.this.pz.hf();
                    }
                    str = str2;
                } else {
                    if (xj.this.pz != null) {
                        xj.this.pz.hf();
                    }
                    str = null;
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (v.xj(xj.this.u)) {
                    str3 = v.hf();
                    j = System.currentTimeMillis() - currentTimeMillis;
                } else {
                    j = -1;
                }
                long j2 = j;
                String str4 = str3;
                com.bytedance.msdk.core.hf.xj.kd(xj.this.kd);
                xj xjVar2 = xj.this;
                com.bytedance.msdk.kd.y.hf(xjVar2.u, xjVar2.y, xjVar2.pz() ? 1 : 0, str4, j2, str, xj.this.u.en());
            }

            @Override // com.bytedance.msdk.api.u.xj.u.xj
            public void kd() {
                String str;
                long j;
                long currentTimeMillis = System.currentTimeMillis();
                if (v.xj(xj.this.u)) {
                    str = v.hf();
                    j = System.currentTimeMillis() - currentTimeMillis;
                } else {
                    str = null;
                    j = -1;
                }
                String str2 = str;
                long j2 = j;
                xj xjVar = xj.this;
                com.bytedance.msdk.kd.y.xj(xjVar.u, xjVar.y, (com.bytedance.msdk.api.xj) null, 2, xjVar.pz() ? 1 : 0, str2, j2);
                if (xj.this.pz != null) {
                    xj.this.pz.kd();
                }
            }

            @Override // com.bytedance.msdk.api.u.xj.u.xj
            public void u() {
                if (!zg.xj()) {
                    xj.this.io();
                    if (xj.this.pz != null) {
                        xj.this.pz.u();
                        return;
                    }
                    return;
                }
                com.bytedance.msdk.hf.w wVar = xj.this.u;
                if (wVar != null && MediationConstant.ADN_PANGLE.equals(wVar.lw())) {
                    if (!zg.w()) {
                        String xj = v.xj();
                        xj xjVar = xj.this;
                        com.bytedance.msdk.kd.y.xj(xjVar.u, xjVar.y, 1, 1, xjVar.pz() ? 1 : 0, xj);
                        return;
                    }
                    xj xjVar2 = xj.this;
                    com.bytedance.msdk.kd.y.xj(xjVar2.u, xjVar2.y, 1, 0, xjVar2.pz() ? 1 : 0, (String) null);
                }
                if (xj.this.et()) {
                    return;
                }
                xj.this.io();
                if (xj.this.pz != null) {
                    xj.this.pz.u();
                }
            }

            @Override // com.bytedance.msdk.api.u.xj.u.xj
            public void w() {
                xj.this.ra();
                if (xj.this.zg) {
                    if (!zg.xj()) {
                        xj.this.io();
                        if (xj.this.pz != null) {
                            xj.this.pz.w();
                            return;
                        }
                        return;
                    }
                    com.bytedance.msdk.hf.w wVar = xj.this.u;
                    if (wVar != null && MediationConstant.ADN_PANGLE.equals(wVar.lw())) {
                        if (!zg.w()) {
                            String xj = v.xj();
                            xj xjVar = xj.this;
                            com.bytedance.msdk.kd.y.xj(xjVar.u, xjVar.y, 2, 1, xjVar.pz() ? 1 : 0, xj);
                            return;
                        }
                        xj xjVar2 = xj.this;
                        com.bytedance.msdk.kd.y.xj(xjVar2.u, xjVar2.y, 2, 0, xjVar2.pz() ? 1 : 0, (String) null);
                    }
                    if (xj.this.et()) {
                        return;
                    }
                    xj.this.io();
                    if (xj.this.pz != null) {
                        xj.this.pz.w();
                    }
                }
            }

            @Override // com.bytedance.msdk.api.u.xj.u.xj
            public void xj(com.bytedance.msdk.api.xj xjVar) {
                String str;
                long j;
                long currentTimeMillis = System.currentTimeMillis();
                if (v.xj(xj.this.u)) {
                    str = v.hf();
                    j = System.currentTimeMillis() - currentTimeMillis;
                } else {
                    str = null;
                    j = -1;
                }
                String str2 = str;
                long j2 = j;
                xj xjVar2 = xj.this;
                com.bytedance.msdk.kd.y.xj(xjVar2.u, xjVar2.y, xjVar, 1, xjVar2.pz() ? 1 : 0, str2, j2);
                xj.this.xj(xjVar);
            }

            @Override // com.bytedance.msdk.api.u.xj.u.xj
            public void y() {
                if (!zg.xj()) {
                    xj.this.io();
                    if (xj.this.pz != null) {
                        xj.this.pz.y();
                        return;
                    }
                    return;
                }
                com.bytedance.msdk.hf.w wVar = xj.this.u;
                if (wVar != null && MediationConstant.ADN_PANGLE.equals(wVar.lw())) {
                    if (!zg.w()) {
                        String xj = v.xj();
                        xj xjVar = xj.this;
                        com.bytedance.msdk.kd.y.xj(xjVar.u, xjVar.y, 3, 1, xjVar.pz() ? 1 : 0, xj);
                        return;
                    }
                    xj xjVar2 = xj.this;
                    com.bytedance.msdk.kd.y.xj(xjVar2.u, xjVar2.y, 3, 0, xjVar2.pz() ? 1 : 0, (String) null);
                }
                if (xj.this.et()) {
                    return;
                }
                xj.this.io();
                if (xj.this.pz != null) {
                    xj.this.pz.y();
                }
            }

            @Override // com.bytedance.msdk.api.u.xj.u.xj
            public void xj(com.bytedance.msdk.api.w.xj xjVar) {
                if (xj.this.pz != null) {
                    com.bytedance.msdk.api.u.xj.y.xj xjVar2 = xj.this.pz;
                    xj xjVar3 = xj.this;
                    xjVar2.xj(pl.xj(xjVar3.y, xjVar, xjVar3.u));
                }
            }
        };
        this.hf = new com.bytedance.msdk.xj.hf.w() { // from class: com.bytedance.msdk.w.u.xj.4
            @Override // com.bytedance.msdk.api.u.xj.kd.xj
            public void hf() {
                String str;
                long j;
                xj.this.dk();
                if (xj.this.pz != null) {
                    xj.this.pz.hf();
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (v.xj(xj.this.u)) {
                    str = v.hf();
                    j = System.currentTimeMillis() - currentTimeMillis;
                } else {
                    str = null;
                    j = -1;
                }
                String str2 = str;
                long j2 = j;
                xj xjVar = xj.this;
                com.bytedance.msdk.hf.w wVar = xjVar.u;
                com.bytedance.msdk.api.xj.hf hfVar = xjVar.y;
                boolean pz = xjVar.pz();
                com.bytedance.msdk.kd.y.hf(wVar, hfVar, pz ? 1 : 0, str2, j2, xj.this.u.en());
            }

            @Override // com.bytedance.msdk.api.u.xj.kd.xj
            public void kd() {
                if (xj.this.pz != null) {
                    xj.this.pz.f();
                }
            }

            @Override // com.bytedance.msdk.api.u.xj.kd.xj
            public void u() {
                if (xj.this.pz != null) {
                    xj.this.pz.c();
                }
            }

            @Override // com.bytedance.msdk.api.u.xj.kd.xj
            public void w() {
                xj.this.ra();
                xj xjVar = xj.this;
                if (xjVar.zg) {
                    xjVar.io();
                    if (xj.this.pz != null) {
                        xj.this.pz.w();
                    }
                }
            }

            @Override // com.bytedance.msdk.api.u.xj.kd.xj
            public void xj() {
                String str;
                long j;
                xj.this.ht();
                if (xj.this.pz != null) {
                    xj.this.pz.xj();
                }
                com.bytedance.msdk.core.f.g.xj().c(xj.this.kd);
                if (xj.this.u != null) {
                    com.bytedance.msdk.xj.kd.w.xj(MediationConstant.TAG, com.bytedance.msdk.xj.kd.kd.xj(xj.this.kd, "show_listen") + "adSlotId：" + xj.this.u.cy() + "，广告类型：" + com.bytedance.msdk.hf.xj.xj(xj.this.u.gj()));
                    com.bytedance.msdk.core.f.p xj = com.bytedance.msdk.core.f.p.xj();
                    xj xjVar = xj.this;
                    xj.hf(xjVar.kd, xjVar.u.cy());
                }
                xj xjVar2 = xj.this;
                xjVar2.xj(xjVar2.w);
                xj xjVar3 = xj.this;
                xjVar3.w(xjVar3.u);
                com.bytedance.msdk.hf.w wVar = xj.this.u;
                if (wVar != null) {
                    String gh = wVar.gh();
                    xj xjVar4 = xj.this;
                    com.bytedance.msdk.core.w.w.xj(gh, xjVar4.kd, xjVar4.u.cy());
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (v.xj(xj.this.u)) {
                    str = v.hf();
                    j = System.currentTimeMillis() - currentTimeMillis;
                } else {
                    str = null;
                    j = -1;
                }
                String str2 = str;
                long j2 = j;
                xj xjVar5 = xj.this;
                com.bytedance.msdk.kd.y.xj(xjVar5.u, xjVar5.y, xjVar5.pz() ? 1 : 0, str2, j2, false);
                xj xjVar6 = xj.this;
                com.bytedance.msdk.core.c.w.xj(xjVar6.kd, xjVar6.u);
            }

            @Override // com.bytedance.msdk.api.u.xj.kd.xj
            public void xj(com.bytedance.msdk.api.xj xjVar) {
                String str;
                long j;
                long currentTimeMillis = System.currentTimeMillis();
                if (v.xj(xj.this.u)) {
                    str = v.hf();
                    j = System.currentTimeMillis() - currentTimeMillis;
                } else {
                    str = null;
                    j = -1;
                }
                String str2 = str;
                long j2 = j;
                xj xjVar2 = xj.this;
                com.bytedance.msdk.kd.y.xj(xjVar2.u, xjVar2.y, xjVar, 1, xjVar2.pz() ? 1 : 0, str2, j2);
                xj.this.xj(xjVar);
            }
        };
    }

    private void hf(Activity activity, Object obj, String str) {
        super.xj(activity, obj, str, new tf.xj() { // from class: com.bytedance.msdk.w.u.xj.1
            @Override // com.bytedance.msdk.w.u.tf.xj
            public void xj() {
                xj.this.xj(new com.bytedance.msdk.api.xj(40052, com.bytedance.msdk.api.xj.xj(40052)));
            }
        });
    }

    @Override // com.bytedance.msdk.w.u.hf, com.bytedance.msdk.w.hf.xj.xj
    public void c() {
        com.bytedance.msdk.api.u.xj.y.hf hfVar = this.jk;
        if (hfVar != null) {
            hfVar.xj();
        }
    }

    @Override // com.bytedance.msdk.w.u.hf, com.bytedance.msdk.w.hf.xj.xj
    public void f() {
        com.bytedance.msdk.api.u.xj.y.hf hfVar = this.jk;
        if (hfVar != null) {
            hfVar.hf();
        }
    }

    @Override // com.bytedance.msdk.w.u.hf, com.bytedance.msdk.w.hf.xj.xj
    public void hf(com.bytedance.msdk.api.xj xjVar) {
        com.bytedance.msdk.api.u.xj.y.hf hfVar = this.jk;
        if (hfVar != null) {
            hfVar.xj(xjVar);
        }
    }

    public void xj(com.bytedance.msdk.api.xj.hf hfVar, com.bytedance.msdk.api.u.xj.y.hf hfVar2) {
        super.hf(hfVar);
        this.y = hfVar;
        this.jk = hfVar2;
        this.d = this.xj;
        d();
    }

    public void xj(Activity activity) {
        xj(activity, (Object) null, (String) null);
    }

    @Override // com.bytedance.msdk.w.u.u
    public void xj(Activity activity, Object obj, String str) {
        if (activity == null) {
            com.bytedance.msdk.xj.kd.w.u(MediationConstant.TAG, "activity can not be null !");
        } else {
            hf(activity, obj, str);
            xj(this.u);
        }
    }

    public void xj(com.bytedance.msdk.api.u.xj.y.xj xjVar) {
        this.pz = xjVar;
    }

    @Override // com.bytedance.msdk.w.u.tf, com.bytedance.msdk.w.u.hf
    public void xj() {
        if (this.u == null) {
            com.bytedance.msdk.core.kd.xj.xj.xj().xj(this.w.jk(), this.kd, this.y, v(), this.u);
        }
        super.xj();
        this.pz = null;
        this.jk = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(final com.bytedance.msdk.api.xj xjVar) {
        com.bytedance.msdk.xj.kd.y.w(new Runnable() { // from class: com.bytedance.msdk.w.u.xj.2
            @Override // java.lang.Runnable
            public void run() {
                if (xj.this.pz != null) {
                    xj.this.pz.xj(xjVar);
                }
            }
        });
    }

    @Override // com.bytedance.msdk.w.u.u, com.bytedance.msdk.w.u.tf
    public void xj(com.bytedance.msdk.hf.w wVar, Activity activity, Object obj, String str) {
        if (wVar != null) {
            if (wVar.tj() == 1) {
                this.d = this.hf;
            } else if (wVar.tj() == 2) {
                this.d = this.xj;
            }
        }
        super.xj(wVar, activity, obj, str);
    }
}
