package com.bytedance.msdk.w.y.hf;

import android.text.TextUtils;
import com.bytedance.msdk.core.tf.f;
import com.bytedance.msdk.core.tf.tf;
import com.bytedance.msdk.hf.w;
import com.bytedance.msdk.xj.kd.y;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class hf implements xj {
    private boolean c;
    private int d;
    private long f = -1;
    private com.bytedance.msdk.w.hf.hf.xj hf;
    private int kd;
    private String u;
    private String w;
    private tf xj;
    private int y;

    private hf() {
    }

    public Object a() {
        if (ra() && j() != null) {
            return j().hf();
        }
        return null;
    }

    public double ai() {
        tf tfVar;
        if (ra() || xj() || dk() || (tfVar = this.xj) == null) {
            return 0.0d;
        }
        return tfVar.ra();
    }

    public int am() {
        tf tfVar = this.xj;
        if (tfVar != null) {
            return tfVar.tf();
        }
        return 0;
    }

    public int c() {
        return this.kd;
    }

    public void d() {
        y.xj(new Runnable() { // from class: com.bytedance.msdk.w.y.hf.hf.3
            @Override // java.lang.Runnable
            public void run() {
                if (hf.this.hf != null) {
                    hf.this.hf.xj();
                }
            }
        });
    }

    public boolean dk() {
        tf tfVar = this.xj;
        return tfVar != null && tfVar.v() == 3;
    }

    public String e() {
        return this.w;
    }

    public String en() {
        tf tfVar = this.xj;
        return tfVar != null ? tfVar.am() : "";
    }

    public String et() {
        return (ra() && j() != null) ? j().tf() : "";
    }

    public tf f() {
        return this.xj;
    }

    public String ff() {
        tf tfVar = this.xj;
        return tfVar != null ? tfVar.wo() : "";
    }

    public String g() {
        tf tfVar = this.xj;
        return tfVar != null ? tfVar.qt() : "";
    }

    public void hf(int i) {
        this.y = i;
    }

    public String ht() {
        tf tfVar = this.xj;
        return tfVar != null ? tfVar.qt() : "";
    }

    public int io() {
        tf tfVar = this.xj;
        if (tfVar != null) {
            return tfVar.g();
        }
        return 0;
    }

    public f j() {
        tf tfVar = this.xj;
        if (tfVar != null) {
            return tfVar.ai();
        }
        return null;
    }

    public int jk() {
        tf tfVar = this.xj;
        if (tfVar != null) {
            return tfVar.dk();
        }
        return 0;
    }

    public boolean kd() {
        return this.c;
    }

    public int l() {
        tf tfVar = this.xj;
        if (tfVar != null) {
            return tfVar.d();
        }
        return 0;
    }

    public boolean p() {
        tf tfVar = this.xj;
        if (tfVar != null) {
            return TextUtils.equals(tfVar.qt(), MediationConstant.ADN_PANGLE);
        }
        return false;
    }

    public String pl() {
        tf tfVar = this.xj;
        return tfVar != null ? tfVar.yo() : "";
    }

    public int pz() {
        tf tfVar = this.xj;
        if (tfVar != null) {
            return tfVar.et();
        }
        return 0;
    }

    public double q() {
        tf tfVar = this.xj;
        if (tfVar != null) {
            return tfVar.pz();
        }
        return 0.0d;
    }

    public int qt() {
        tf tfVar = this.xj;
        if (tfVar != null) {
            return tfVar.y();
        }
        return 0;
    }

    public boolean ra() {
        tf tfVar = this.xj;
        return tfVar != null && tfVar.v() == 2;
    }

    public boolean tf() {
        tf tfVar = this.xj;
        if (tfVar != null) {
            return tfVar.r();
        }
        return false;
    }

    public long u() {
        return this.f;
    }

    public int v() {
        tf tfVar = this.xj;
        if (tfVar != null) {
            return tfVar.v();
        }
        return 0;
    }

    public int w() {
        return this.d;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0024 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int wo() {
        /*
            r7 = this;
            com.bytedance.msdk.core.tf.tf r0 = r7.xj
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            int r0 = r0.y()
            com.bytedance.msdk.core.tf.tf r2 = r7.xj
            int r2 = r2.g()
            r3 = 20001(0x4e21, float:2.8027E-41)
            r4 = 20002(0x4e22, float:2.8029E-41)
            r5 = 20004(0x4e24, float:2.8032E-41)
            r6 = 20003(0x4e23, float:2.803E-41)
            switch(r2) {
                case 1: goto L45;
                case 2: goto L44;
                case 3: goto L41;
                case 4: goto L1b;
                case 5: goto L32;
                case 6: goto L1b;
                case 7: goto L27;
                case 8: goto L26;
                case 9: goto L25;
                case 10: goto L1c;
                default: goto L1b;
            }
        L1b:
            goto L24
        L1c:
            r2 = 1
            if (r0 != r2) goto L20
            return r5
        L20:
            r2 = 2
            if (r0 != r2) goto L24
            return r6
        L24:
            return r1
        L25:
            return r4
        L26:
            return r6
        L27:
            r1 = 6
            r2 = 20006(0x4e26, float:2.8034E-41)
            if (r0 != r1) goto L2d
            return r2
        L2d:
            r1 = 7
            if (r0 != r1) goto L31
            return r6
        L31:
            return r2
        L32:
            r1 = 4
            r2 = 20005(0x4e25, float:2.8033E-41)
            if (r0 != r1) goto L38
            return r2
        L38:
            r1 = 5
            if (r0 != r1) goto L3c
            return r4
        L3c:
            r1 = 3
            if (r0 != r1) goto L40
            return r3
        L40:
            return r2
        L41:
            r0 = 20007(0x4e27, float:2.8036E-41)
            return r0
        L44:
            return r5
        L45:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.w.y.hf.hf.wo():int");
    }

    public int x() {
        tf tfVar = this.xj;
        if (tfVar != null) {
            return tfVar.xj();
        }
        return 0;
    }

    public int y() {
        return this.y;
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x00d0, code lost:
    
        if (r9 == 2) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00db, code lost:
    
        if (r9 != 7) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00e6, code lost:
    
        if (r9 == 3) goto L79;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String yo() {
        /*
            Method dump skipped, instructions count: 332
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.w.y.hf.hf.yo():java.lang.String");
    }

    public double z() {
        tf tfVar = this.xj;
        if (tfVar != null) {
            return tfVar.ht();
        }
        return 0.0d;
    }

    public String zg() {
        tf tfVar = this.xj;
        return tfVar != null ? tfVar.io() : "";
    }

    public static hf xj(tf tfVar, com.bytedance.msdk.w.hf.hf.xj xjVar) {
        hf hfVar = new hf();
        hfVar.xj = tfVar;
        hfVar.hf = xjVar;
        return hfVar;
    }

    public void hf(String str) {
        this.u = str;
    }

    public void w(int i) {
        this.kd = i;
    }

    @Override // com.bytedance.msdk.w.y.hf.xj
    public String hf() {
        return this.u;
    }

    public void xj(int i) {
        this.d = i;
    }

    public void xj(long j) {
        this.f = j;
    }

    public void xj(boolean z) {
        this.c = z;
    }

    public void xj(final List<w> list, final tf tfVar) {
        y.xj(new Runnable() { // from class: com.bytedance.msdk.w.y.hf.hf.1
            @Override // java.lang.Runnable
            public void run() {
                if (hf.this.hf != null) {
                    hf.this.hf.xj(list, tfVar);
                }
            }
        });
    }

    public void xj(final com.bytedance.msdk.api.xj xjVar, final tf tfVar) {
        y.xj(new Runnable() { // from class: com.bytedance.msdk.w.y.hf.hf.2
            @Override // java.lang.Runnable
            public void run() {
                if (hf.this.hf != null) {
                    hf.this.hf.xj(xjVar, tfVar);
                }
            }
        });
    }

    public void xj(String str) {
        this.w = str;
    }

    @Override // com.bytedance.msdk.w.y.hf.xj
    public boolean xj() {
        tf tfVar = this.xj;
        return tfVar != null && tfVar.v() == 1;
    }
}
