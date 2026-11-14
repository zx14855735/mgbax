package com.bytedance.sdk.gromore.xj.xj.c.w;

import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class y implements com.bytedance.sdk.gromore.xj.xj.kd.w {
    private com.bytedance.msdk.w.u.xj xj;

    public y(com.bytedance.msdk.w.u.xj xjVar) {
        this.xj = xjVar;
    }

    @Override // com.bytedance.sdk.gromore.xj.xj.kd.w
    public void c() {
        com.bytedance.msdk.w.u.xj xjVar = this.xj;
        if (xjVar != null) {
            xjVar.xj();
        }
    }

    @Override // com.bytedance.sdk.gromore.xj.xj.w
    public List<com.bytedance.sdk.gromore.xj.xj.u> hf() {
        List<com.bytedance.msdk.api.hf> tf;
        ArrayList arrayList = new ArrayList();
        com.bytedance.msdk.w.u.xj xjVar = this.xj;
        if (xjVar != null && (tf = xjVar.tf()) != null) {
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
        com.bytedance.msdk.w.u.xj xjVar = this.xj;
        if (xjVar != null && (pl2 = xjVar.pl()) != null) {
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
        com.bytedance.msdk.w.u.xj xjVar = this.xj;
        return xjVar != null ? new com.bytedance.sdk.gromore.xj.xj.u.y(xjVar.zg()) : new com.bytedance.sdk.gromore.xj.xj.u.kd();
    }

    @Override // com.bytedance.sdk.gromore.xj.xj.w
    public List<com.bytedance.sdk.gromore.xj.xj.hf> w() {
        List<com.bytedance.msdk.api.w> p;
        ArrayList arrayList = new ArrayList();
        com.bytedance.msdk.w.u.xj xjVar = this.xj;
        if (xjVar != null && (p = xjVar.p()) != null) {
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
        com.bytedance.msdk.w.u.xj xjVar = this.xj;
        if (xjVar != null) {
            return xjVar.x();
        }
        return false;
    }

    @Override // com.bytedance.sdk.gromore.xj.xj.w
    public com.bytedance.sdk.gromore.xj.xj.hf y() {
        com.bytedance.msdk.w.u.xj xjVar = this.xj;
        return xjVar != null ? new com.bytedance.sdk.gromore.xj.xj.u.y(xjVar.qt()) : new com.bytedance.sdk.gromore.xj.xj.u.kd();
    }
}
