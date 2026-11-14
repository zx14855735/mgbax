package com.bytedance.sdk.gromore.xj.xj.c.xj;

import com.bytedance.msdk.w.u.p;
import com.bytedance.sdk.gromore.xj.xj.u;
import com.bytedance.sdk.gromore.xj.xj.u.am;
import com.bytedance.sdk.gromore.xj.xj.u.kd;
import com.bytedance.sdk.gromore.xj.xj.u.qt;
import com.bytedance.sdk.gromore.xj.xj.u.y;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class hf implements am {
    private p xj;

    public hf(p pVar) {
        this.xj = pVar;
    }

    @Override // com.bytedance.sdk.gromore.xj.xj.u.am
    public boolean c() {
        return false;
    }

    @Override // com.bytedance.sdk.gromore.xj.xj.u.am
    public void d() {
        p pVar = this.xj;
        if (pVar != null) {
            pVar.xj();
        }
    }

    @Override // com.bytedance.sdk.gromore.xj.xj.u.am
    public boolean f() {
        return false;
    }

    @Override // com.bytedance.sdk.gromore.xj.xj.w
    public List<u> hf() {
        List<com.bytedance.msdk.api.hf> f;
        ArrayList arrayList = new ArrayList();
        p pVar = this.xj;
        if (pVar != null && (f = pVar.f()) != null) {
            for (com.bytedance.msdk.api.hf hfVar : f) {
                if (hfVar != null) {
                    arrayList.add(new com.bytedance.sdk.gromore.xj.xj.u.xj(hfVar));
                }
            }
        }
        return arrayList;
    }

    @Override // com.bytedance.sdk.gromore.xj.xj.w
    public List<com.bytedance.sdk.gromore.xj.xj.hf> kd() {
        List<com.bytedance.msdk.api.w> p;
        ArrayList arrayList = new ArrayList();
        p pVar = this.xj;
        if (pVar != null && (p = pVar.p()) != null) {
            for (com.bytedance.msdk.api.w wVar : p) {
                if (wVar != null) {
                    arrayList.add(new y(wVar));
                }
            }
        }
        return arrayList;
    }

    @Override // com.bytedance.sdk.gromore.xj.xj.u.am
    public void tf() {
        p pVar = this.xj;
        if (pVar != null) {
            pVar.hf();
        }
    }

    @Override // com.bytedance.sdk.gromore.xj.xj.w
    public com.bytedance.sdk.gromore.xj.xj.hf u() {
        p pVar = this.xj;
        return pVar != null ? new y(pVar.tf()) : new kd();
    }

    @Override // com.bytedance.sdk.gromore.xj.xj.w
    public List<com.bytedance.sdk.gromore.xj.xj.hf> w() {
        List<com.bytedance.msdk.api.w> d;
        ArrayList arrayList = new ArrayList();
        p pVar = this.xj;
        if (pVar != null && (d = pVar.d()) != null) {
            for (com.bytedance.msdk.api.w wVar : d) {
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
        p pVar = this.xj;
        return pVar != null ? new y(pVar.pl()) : new kd();
    }

    @Override // com.bytedance.sdk.gromore.xj.xj.u.am
    public void xj(boolean z) {
    }

    @Override // com.bytedance.sdk.gromore.xj.xj.w
    public boolean xj() {
        p pVar = this.xj;
        if (pVar != null) {
            return pVar.u();
        }
        return false;
    }
}
