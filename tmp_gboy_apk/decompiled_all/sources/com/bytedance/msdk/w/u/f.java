package com.bytedance.msdk.w.u;

import android.app.Activity;
import android.content.Context;
import com.bytedance.msdk.f.v;
import com.bytedance.msdk.f.zg;
import com.bytedance.msdk.w.u.tf;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class f extends u implements com.bytedance.msdk.xj.hf.hf {
    private com.bytedance.msdk.api.u.xj.u.xj hf;
    private com.bytedance.msdk.api.u.xj.u.hf xj;

    public f(Context context) {
        super(context);
    }

    @Override // com.bytedance.msdk.w.u.hf, com.bytedance.msdk.w.hf.xj.xj
    public void c() {
        com.bytedance.msdk.api.u.xj.u.hf hfVar = this.xj;
        if (hfVar != null) {
            hfVar.xj();
        }
    }

    @Override // com.bytedance.msdk.w.u.hf, com.bytedance.msdk.w.hf.xj.xj
    public void f() {
        com.bytedance.msdk.api.u.xj.u.hf hfVar = this.xj;
        if (hfVar != null) {
            hfVar.hf();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00f1  */
    @Override // com.bytedance.msdk.api.u.xj.u.xj
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void g_() {
        /*
            Method dump skipped, instructions count: 303
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.w.u.f.g_():void");
    }

    @Override // com.bytedance.msdk.api.u.xj.u.xj
    public void h_() {
        String str;
        long j;
        String str2;
        com.bytedance.msdk.api.u.xj.u.xj xjVar;
        dk();
        String str3 = null;
        if (zg.xj()) {
            com.bytedance.msdk.hf.w wVar = this.u;
            if (wVar != null && MediationConstant.ADN_PANGLE.equals(wVar.lw())) {
                if (!zg.w()) {
                    com.bytedance.msdk.kd.y.xj(this.u, this.y, 5, 1, pz() ? 1 : 0, v.xj());
                    return;
                } else if (zg.f()) {
                    str2 = v.xj();
                    if (!et() && (xjVar = this.hf) != null) {
                        xjVar.h_();
                    }
                    str = str2;
                }
            }
            str2 = null;
            if (!et()) {
                xjVar.h_();
            }
            str = str2;
        } else {
            com.bytedance.msdk.api.u.xj.u.xj xjVar2 = this.hf;
            if (xjVar2 != null) {
                xjVar2.h_();
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
        com.bytedance.msdk.core.hf.xj.kd(this.y.ra());
        com.bytedance.msdk.kd.y.hf(this.u, this.y, pz() ? 1 : 0, str4, j2, str, this.u.en());
    }

    public void hf(Activity activity, Object obj, String str) {
        xj(activity, obj, str);
    }

    @Override // com.bytedance.msdk.api.u.xj.u.xj
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
        com.bytedance.msdk.kd.y.xj(this.u, this.y, (com.bytedance.msdk.api.xj) null, 2, pz() ? 1 : 0, str, j);
        com.bytedance.msdk.api.u.xj.u.xj xjVar = this.hf;
        if (xjVar != null) {
            xjVar.kd();
        }
    }

    @Override // com.bytedance.msdk.api.u.xj.u.xj
    public void u() {
        if (!zg.xj()) {
            io();
            com.bytedance.msdk.api.u.xj.u.xj xjVar = this.hf;
            if (xjVar != null) {
                xjVar.u();
                return;
            }
            return;
        }
        com.bytedance.msdk.hf.w wVar = this.u;
        if (wVar != null && MediationConstant.ADN_PANGLE.equals(wVar.lw())) {
            if (!zg.w()) {
                com.bytedance.msdk.kd.y.xj(this.u, this.y, 1, 1, pz() ? 1 : 0, v.xj());
                return;
            }
            com.bytedance.msdk.kd.y.xj(this.u, this.y, 1, 0, pz() ? 1 : 0, (String) null);
        }
        if (et()) {
            return;
        }
        io();
        com.bytedance.msdk.api.u.xj.u.xj xjVar2 = this.hf;
        if (xjVar2 != null) {
            xjVar2.u();
        }
    }

    @Override // com.bytedance.msdk.api.u.xj.u.xj
    public void w() {
        ra();
        if (this.zg) {
            if (!zg.xj()) {
                io();
                com.bytedance.msdk.api.u.xj.u.xj xjVar = this.hf;
                if (xjVar != null) {
                    xjVar.w();
                    return;
                }
                return;
            }
            com.bytedance.msdk.hf.w wVar = this.u;
            if (wVar != null && MediationConstant.ADN_PANGLE.equals(wVar.lw())) {
                if (!zg.w()) {
                    com.bytedance.msdk.kd.y.xj(this.u, this.y, 2, 1, pz() ? 1 : 0, v.xj());
                    return;
                }
                com.bytedance.msdk.kd.y.xj(this.u, this.y, 2, 0, pz() ? 1 : 0, (String) null);
            }
            if (et()) {
                return;
            }
            io();
            com.bytedance.msdk.api.u.xj.u.xj xjVar2 = this.hf;
            if (xjVar2 != null) {
                xjVar2.w();
            }
        }
    }

    @Override // com.bytedance.msdk.api.u.xj.u.xj
    public void y() {
        if (!zg.xj()) {
            io();
            com.bytedance.msdk.api.u.xj.u.xj xjVar = this.hf;
            if (xjVar != null) {
                xjVar.y();
                return;
            }
            return;
        }
        com.bytedance.msdk.hf.w wVar = this.u;
        if (wVar != null && MediationConstant.ADN_PANGLE.equals(wVar.lw())) {
            if (!zg.w()) {
                com.bytedance.msdk.kd.y.xj(this.u, this.y, 3, 1, pz() ? 1 : 0, v.xj());
                return;
            }
            com.bytedance.msdk.kd.y.xj(this.u, this.y, 3, 0, pz() ? 1 : 0, (String) null);
        }
        if (et()) {
            return;
        }
        io();
        com.bytedance.msdk.api.u.xj.u.xj xjVar2 = this.hf;
        if (xjVar2 != null) {
            xjVar2.y();
        }
    }

    @Override // com.bytedance.msdk.w.u.hf, com.bytedance.msdk.w.hf.xj.xj
    public void hf(com.bytedance.msdk.api.xj xjVar) {
        com.bytedance.msdk.api.u.xj.u.hf hfVar = this.xj;
        if (hfVar != null) {
            hfVar.xj(xjVar);
        }
    }

    public void xj(com.bytedance.msdk.api.xj.hf hfVar, com.bytedance.msdk.api.u.xj.u.hf hfVar2) {
        super.hf(hfVar);
        this.xj = hfVar2;
        this.y = hfVar;
        this.d = this;
        d();
    }

    public void xj(Activity activity) {
        hf(activity, null, null);
    }

    @Override // com.bytedance.msdk.w.u.u
    public void xj(Activity activity, Object obj, String str) {
        super.xj(activity, obj, str, new tf.xj() { // from class: com.bytedance.msdk.w.u.f.1
            @Override // com.bytedance.msdk.w.u.tf.xj
            public void xj() {
                f.this.w(new com.bytedance.msdk.api.xj(40052, com.bytedance.msdk.api.xj.xj(40052)));
            }
        });
        if (this.hf == null) {
            com.bytedance.msdk.xj.kd.w.xj(MediationConstant.TAG, "注意：未设置GMFullVideoAdListener，将收不到广告播放/点击/关闭等回调信息");
        }
        xj(this.u);
    }

    public void xj(com.bytedance.msdk.api.u.xj.u.xj xjVar) {
        this.hf = xjVar;
    }

    @Override // com.bytedance.msdk.w.u.tf, com.bytedance.msdk.w.u.hf
    public void xj() {
        if (this.u == null) {
            com.bytedance.msdk.core.kd.xj.xj.xj().xj(this.w.jk(), this.kd, this.y, v(), this.u);
        }
        super.xj();
        this.hf = null;
        this.xj = null;
    }

    @Override // com.bytedance.msdk.api.u.xj.u.xj
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
        com.bytedance.msdk.kd.y.xj(this.u, this.y, xjVar, 1, pz() ? 1 : 0, str, j);
        w(xjVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(final com.bytedance.msdk.api.xj xjVar) {
        com.bytedance.msdk.xj.kd.y.w(new Runnable() { // from class: com.bytedance.msdk.w.u.f.2
            @Override // java.lang.Runnable
            public void run() {
                if (f.this.hf != null) {
                    f.this.hf.xj(xjVar);
                }
            }
        });
    }

    @Override // com.bytedance.msdk.api.u.xj.u.xj
    public void xj(com.bytedance.msdk.api.w.xj xjVar) {
        com.bytedance.msdk.api.u.xj.u.xj xjVar2 = this.hf;
        if (xjVar2 != null) {
            xjVar2.xj(pl.xj(this.y, xjVar, this.u));
        }
    }
}
