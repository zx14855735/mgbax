package com.bytedance.sdk.gromore.xj.xj.c.y;

import com.bytedance.msdk.w.u.g;
import com.bytedance.sdk.gromore.xj.xj.u;
import com.bytedance.sdk.gromore.xj.xj.u.kd;
import com.bytedance.sdk.gromore.xj.xj.u.y;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class hf implements com.bytedance.sdk.gromore.xj.xj.kd.w {
    private g xj;

    public hf(g gVar) {
        this.xj = gVar;
    }

    @Override // com.bytedance.sdk.gromore.xj.xj.kd.w
    public void c() {
        g gVar = this.xj;
        if (gVar != null) {
            gVar.xj();
        }
    }

    @Override // com.bytedance.sdk.gromore.xj.xj.w
    public List<u> hf() {
        List<com.bytedance.msdk.api.hf> tf;
        ArrayList arrayList = new ArrayList();
        g gVar = this.xj;
        if (gVar != null && (tf = gVar.tf()) != null) {
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
        g gVar = this.xj;
        if (gVar != null && (pl2 = gVar.pl()) != null) {
            for (com.bytedance.msdk.api.w wVar : pl2) {
                if (wVar != null) {
                    arrayList.add(new y(wVar));
                }
            }
        }
        return arrayList;
    }

    @Override // com.bytedance.sdk.gromore.xj.xj.w
    public com.bytedance.sdk.gromore.xj.xj.hf u() {
        g gVar = this.xj;
        return gVar != null ? new y(gVar.zg()) : new kd();
    }

    @Override // com.bytedance.sdk.gromore.xj.xj.w
    public List<com.bytedance.sdk.gromore.xj.xj.hf> w() {
        List<com.bytedance.msdk.api.w> p;
        ArrayList arrayList = new ArrayList();
        g gVar = this.xj;
        if (gVar != null && (p = gVar.p()) != null) {
            for (com.bytedance.msdk.api.w wVar : p) {
                if (wVar != null) {
                    arrayList.add(new y(wVar));
                }
            }
        }
        return arrayList;
    }

    @Override // com.bytedance.sdk.gromore.xj.xj.w
    public boolean xj() {
        g gVar = this.xj;
        if (gVar != null) {
            return gVar.pz();
        }
        return false;
    }

    @Override // com.bytedance.sdk.gromore.xj.xj.w
    public com.bytedance.sdk.gromore.xj.xj.hf y() {
        g gVar = this.xj;
        return gVar != null ? new y(gVar.qt()) : new kd();
    }
}
