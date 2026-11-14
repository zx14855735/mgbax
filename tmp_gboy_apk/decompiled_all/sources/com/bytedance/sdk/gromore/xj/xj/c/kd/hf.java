package com.bytedance.sdk.gromore.xj.xj.c.kd;

import com.bytedance.msdk.w.u.pl;
import com.bytedance.sdk.gromore.xj.xj.u;
import com.bytedance.sdk.gromore.xj.xj.u.kd;
import com.bytedance.sdk.gromore.xj.xj.u.y;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class hf implements com.bytedance.sdk.gromore.xj.xj.kd.w {
    private pl xj;

    public hf(pl plVar) {
        this.xj = plVar;
    }

    @Override // com.bytedance.sdk.gromore.xj.xj.kd.w
    public void c() {
        pl plVar = this.xj;
        if (plVar != null) {
            plVar.xj();
        }
    }

    @Override // com.bytedance.sdk.gromore.xj.xj.w
    public List<u> hf() {
        List<com.bytedance.msdk.api.hf> tf;
        ArrayList arrayList = new ArrayList();
        pl plVar = this.xj;
        if (plVar != null && (tf = plVar.tf()) != null) {
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
        pl plVar = this.xj;
        if (plVar != null && (pl2 = plVar.pl()) != null) {
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
        pl plVar = this.xj;
        return plVar != null ? new y(plVar.zg()) : new kd();
    }

    @Override // com.bytedance.sdk.gromore.xj.xj.w
    public List<com.bytedance.sdk.gromore.xj.xj.hf> w() {
        List<com.bytedance.msdk.api.w> p;
        ArrayList arrayList = new ArrayList();
        pl plVar = this.xj;
        if (plVar != null && (p = plVar.p()) != null) {
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
        pl plVar = this.xj;
        if (plVar != null) {
            return plVar.x();
        }
        return false;
    }

    @Override // com.bytedance.sdk.gromore.xj.xj.w
    public com.bytedance.sdk.gromore.xj.xj.hf y() {
        pl plVar = this.xj;
        return plVar != null ? new y(plVar.qt()) : new kd();
    }
}
