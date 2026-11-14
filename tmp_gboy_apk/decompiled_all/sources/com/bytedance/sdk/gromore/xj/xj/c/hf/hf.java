package com.bytedance.sdk.gromore.xj.xj.c.hf;

import com.bytedance.msdk.f.e;
import com.bytedance.msdk.w.u.c;
import com.bytedance.sdk.gromore.xj.xj.u.am;
import com.bytedance.sdk.gromore.xj.xj.u.kd;
import com.bytedance.sdk.gromore.xj.xj.u.qt;
import com.bytedance.sdk.gromore.xj.xj.u.y;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class hf implements am {
    private com.bytedance.msdk.api.xj.hf hf;
    private c w;
    private com.bytedance.msdk.hf.w xj;

    public hf(c cVar, com.bytedance.msdk.hf.w wVar, com.bytedance.msdk.api.xj.hf hfVar) {
        this.xj = wVar;
        this.hf = hfVar;
        this.w = cVar;
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
        c cVar = this.w;
        if (cVar != null && (tf = cVar.tf()) != null) {
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
        c cVar = this.w;
        if (cVar != null && (pl2 = cVar.pl()) != null) {
            for (com.bytedance.msdk.api.w wVar : pl2) {
                if (wVar != null) {
                    arrayList.add(new y(wVar));
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
        return (this.xj == null || !com.bytedance.msdk.core.hf.hf().dk()) ? new kd() : new y(com.bytedance.msdk.f.am.xj(this.hf, this.xj, false));
    }

    @Override // com.bytedance.sdk.gromore.xj.xj.w
    public List<com.bytedance.sdk.gromore.xj.xj.hf> w() {
        List<com.bytedance.msdk.api.w> p;
        ArrayList arrayList = new ArrayList();
        c cVar = this.w;
        if (cVar != null && (p = cVar.p()) != null) {
            for (com.bytedance.msdk.api.w wVar : p) {
                if (wVar != null) {
                    arrayList.add(new y(wVar));
                }
            }
        }
        return arrayList;
    }

    @Override // com.bytedance.sdk.gromore.xj.xj.u.am
    public void xj(qt qtVar) {
    }

    @Override // com.bytedance.sdk.gromore.xj.xj.w
    public com.bytedance.sdk.gromore.xj.xj.hf y() {
        com.bytedance.msdk.hf.w wVar = this.xj;
        return (wVar == null || !wVar.s() || e.xj()) ? new kd() : new y(com.bytedance.msdk.f.am.xj(this.hf, this.xj, true));
    }

    @Override // com.bytedance.sdk.gromore.xj.xj.w
    public boolean xj() {
        if (this.xj == null) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.xj);
        com.bytedance.msdk.kd.y.xj(arrayList, (List<com.bytedance.msdk.hf.w>) null, (List<com.bytedance.msdk.hf.w>) null, this.hf, 0);
        com.bytedance.msdk.api.xj.hf hfVar = this.hf;
        if (hfVar != null) {
            return this.xj.ff(hfVar.ra());
        }
        return false;
    }

    @Override // com.bytedance.sdk.gromore.xj.xj.u.am
    public void xj(boolean z) {
        com.bytedance.msdk.hf.w wVar = this.xj;
        if (wVar != null) {
            wVar.u(z);
        }
    }
}
