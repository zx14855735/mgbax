package com.bytedance.sdk.gromore.xj.xj.c.w;

import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class hf implements com.bytedance.sdk.gromore.xj.xj.kd.w {
    private com.bytedance.msdk.w.u.f xj;

    public hf(com.bytedance.msdk.w.u.f fVar) {
        this.xj = fVar;
    }

    @Override // com.bytedance.sdk.gromore.xj.xj.kd.w
    public void c() {
        com.bytedance.msdk.w.u.f fVar = this.xj;
        if (fVar != null) {
            fVar.xj();
        }
    }

    @Override // com.bytedance.sdk.gromore.xj.xj.w
    public List<com.bytedance.sdk.gromore.xj.xj.u> hf() {
        List<com.bytedance.msdk.api.hf> tf;
        ArrayList arrayList = new ArrayList();
        com.bytedance.msdk.w.u.f fVar = this.xj;
        if (fVar != null && (tf = fVar.tf()) != null) {
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
        com.bytedance.msdk.w.u.f fVar = this.xj;
        if (fVar != null && (pl2 = fVar.pl()) != null) {
            for (com.bytedance.msdk.api.w wVar : pl2) {
                if (wVar != null) {
                    arrayList.add(new com.bytedance.sdk.gromore.xj.xj.u.y(wVar));
                }
            }
        }
        return arrayList;
    }

    @Override // com.bytedance.sdk.gromore.xj.xj.w
    public com.bytedance.sdk.gromore.xj.xj.hf u() {
        com.bytedance.msdk.w.u.f fVar = this.xj;
        return fVar != null ? new com.bytedance.sdk.gromore.xj.xj.u.y(fVar.zg()) : new com.bytedance.sdk.gromore.xj.xj.u.kd();
    }

    @Override // com.bytedance.sdk.gromore.xj.xj.w
    public List<com.bytedance.sdk.gromore.xj.xj.hf> w() {
        List<com.bytedance.msdk.api.w> p;
        ArrayList arrayList = new ArrayList();
        com.bytedance.msdk.w.u.f fVar = this.xj;
        if (fVar != null && (p = fVar.p()) != null) {
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
        com.bytedance.msdk.w.u.f fVar = this.xj;
        if (fVar != null) {
            return fVar.x();
        }
        return false;
    }

    @Override // com.bytedance.sdk.gromore.xj.xj.w
    public com.bytedance.sdk.gromore.xj.xj.hf y() {
        com.bytedance.msdk.w.u.f fVar = this.xj;
        return fVar != null ? new com.bytedance.sdk.gromore.xj.xj.u.y(fVar.qt()) : new com.bytedance.sdk.gromore.xj.xj.u.kd();
    }
}
