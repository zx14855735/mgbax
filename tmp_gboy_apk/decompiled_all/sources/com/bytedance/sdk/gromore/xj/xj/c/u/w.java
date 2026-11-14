package com.bytedance.sdk.gromore.xj.xj.c.u;

import com.bytedance.msdk.f.e;
import com.bytedance.msdk.w.u.d;
import com.bytedance.sdk.gromore.xj.xj.u.am;
import com.bytedance.sdk.gromore.xj.xj.u.qt;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class w implements am {
    private com.bytedance.msdk.api.xj.hf hf;
    private d w;
    private com.bytedance.msdk.hf.w xj;

    public w(d dVar, com.bytedance.msdk.hf.w wVar, com.bytedance.msdk.api.xj.hf hfVar) {
        this.xj = wVar;
        this.hf = hfVar;
        this.w = dVar;
    }

    @Override // com.bytedance.sdk.gromore.xj.xj.u.am
    public boolean c() {
        com.bytedance.msdk.hf.w wVar = this.xj;
        if (wVar != null) {
            return wVar.jk();
        }
        return false;
    }

    @Override // com.bytedance.sdk.gromore.xj.xj.u.am
    public void d() {
        com.bytedance.msdk.hf.w wVar = this.xj;
        if (wVar != null) {
            wVar.e();
        }
    }

    @Override // com.bytedance.sdk.gromore.xj.xj.u.am
    public boolean f() {
        com.bytedance.msdk.hf.w wVar = this.xj;
        if (wVar != null) {
            return wVar.gy();
        }
        return false;
    }

    @Override // com.bytedance.sdk.gromore.xj.xj.w
    public List<com.bytedance.sdk.gromore.xj.xj.u> hf() {
        List<com.bytedance.msdk.api.hf> tf;
        ArrayList arrayList = new ArrayList();
        d dVar = this.w;
        if (dVar != null && (tf = dVar.tf()) != null) {
            for (com.bytedance.msdk.api.hf hfVar : tf) {
                if (hfVar != null) {
                    arrayList.add(new com.bytedance.sdk.gromore.xj.xj.u.xj(hfVar));
                }
            }
        }
        return arrayList;
    }

    @Override // com.bytedance.sdk.gromore.xj.xj.w
    public List<com.bytedance.sdk.gromore.xj.xj.hf> kd() {
        List<com.bytedance.msdk.api.w> pl2;
        ArrayList arrayList = new ArrayList();
        d dVar = this.w;
        if (dVar != null && (pl2 = dVar.pl()) != null) {
            for (com.bytedance.msdk.api.w wVar : pl2) {
                if (wVar != null) {
                    arrayList.add(new com.bytedance.sdk.gromore.xj.xj.u.y(wVar));
                }
            }
        }
        return arrayList;
    }

    @Override // com.bytedance.sdk.gromore.xj.xj.u.am
    public void tf() {
        com.bytedance.msdk.hf.w wVar = this.xj;
        if (wVar != null) {
            wVar.zg();
        }
    }

    @Override // com.bytedance.sdk.gromore.xj.xj.w
    public com.bytedance.sdk.gromore.xj.xj.hf u() {
        com.bytedance.msdk.api.xj.hf hfVar;
        return (this.xj == null || (hfVar = this.hf) == null) ? new com.bytedance.sdk.gromore.xj.xj.u.kd() : (hfVar.dq() || com.bytedance.msdk.core.hf.hf().dk()) ? new com.bytedance.sdk.gromore.xj.xj.u.y(com.bytedance.msdk.f.am.xj(this.hf, this.xj, false)) : new com.bytedance.sdk.gromore.xj.xj.u.kd();
    }

    @Override // com.bytedance.sdk.gromore.xj.xj.w
    public List<com.bytedance.sdk.gromore.xj.xj.hf> w() {
        List<com.bytedance.msdk.api.w> p;
        ArrayList arrayList = new ArrayList();
        d dVar = this.w;
        if (dVar != null && (p = dVar.p()) != null) {
            for (com.bytedance.msdk.api.w wVar : p) {
                if (wVar != null) {
                    arrayList.add(new com.bytedance.sdk.gromore.xj.xj.u.y(wVar));
                }
            }
        }
        return arrayList;
    }

    @Override // com.bytedance.sdk.gromore.xj.xj.w
    public boolean xj() {
        if (this.hf == null || this.xj == null) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.xj);
        com.bytedance.msdk.kd.y.xj(arrayList, (List<com.bytedance.msdk.hf.w>) null, (List<com.bytedance.msdk.hf.w>) null, this.hf, 0);
        return this.xj.ff(this.hf.ra());
    }

    @Override // com.bytedance.sdk.gromore.xj.xj.w
    public com.bytedance.sdk.gromore.xj.xj.hf y() {
        com.bytedance.msdk.hf.w wVar = this.xj;
        return (wVar == null || !wVar.s() || e.xj()) ? new com.bytedance.sdk.gromore.xj.xj.u.kd() : new com.bytedance.sdk.gromore.xj.xj.u.y(com.bytedance.msdk.f.am.xj(this.hf, this.xj, true));
    }

    @Override // com.bytedance.sdk.gromore.xj.xj.u.am
    public void xj(boolean z) {
        com.bytedance.msdk.hf.w wVar = this.xj;
        if (wVar != null) {
            wVar.u(z);
        }
    }

    @Override // com.bytedance.sdk.gromore.xj.xj.u.am
    public void xj(final qt qtVar) {
        com.bytedance.msdk.hf.w wVar = this.xj;
        if (wVar != null) {
            wVar.xj(new com.bytedance.msdk.api.u.xj.u() { // from class: com.bytedance.sdk.gromore.xj.xj.c.u.w.1
                @Override // com.bytedance.msdk.api.u.xj.u
                public void xj() {
                    qt qtVar2 = qtVar;
                    if (qtVar2 != null) {
                        qtVar2.xj();
                    }
                }
            });
        }
    }
}
