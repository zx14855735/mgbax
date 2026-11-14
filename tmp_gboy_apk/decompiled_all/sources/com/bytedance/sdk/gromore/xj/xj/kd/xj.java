package com.bytedance.sdk.gromore.xj.xj.kd;

import com.bytedance.sdk.gromore.xj.xj.u.c;
import com.bytedance.sdk.gromore.xj.xj.u.f;
import com.bytedance.sdk.openadsdk.mediation.manager.xj.hf.xj.y;
import java.util.LinkedList;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj extends y {
    private w xj;

    public xj(w wVar) {
        this.xj = wVar;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.xj.hf.xj.y
    public void destroy() {
        w wVar = this.xj;
        if (wVar != null) {
            wVar.c();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.xj.hf.xj.w
    public List<com.bytedance.sdk.openadsdk.mediation.manager.xj.hf.xj.hf> getAdLoadInfo() {
        if (this.xj == null) {
            return new LinkedList();
        }
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < this.xj.hf().size(); i++) {
            linkedList.add(new f(this.xj.hf().get(i)));
        }
        return linkedList;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.xj.hf.xj.w
    public com.bytedance.sdk.openadsdk.mediation.manager.xj.hf.xj.xj getBestEcpm() {
        w wVar = this.xj;
        return wVar != null ? new c(wVar.u()) : new c(null);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.xj.hf.xj.w
    public List<com.bytedance.sdk.openadsdk.mediation.manager.xj.hf.xj.xj> getCacheList() {
        if (this.xj == null) {
            return new LinkedList();
        }
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < this.xj.kd().size(); i++) {
            linkedList.add(new c(this.xj.kd().get(i)));
        }
        return linkedList;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.xj.hf.xj.w
    public List<com.bytedance.sdk.openadsdk.mediation.manager.xj.hf.xj.xj> getMultiBiddingEcpm() {
        if (this.xj == null) {
            return new LinkedList();
        }
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < this.xj.w().size(); i++) {
            linkedList.add(new c(this.xj.w().get(i)));
        }
        return linkedList;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.xj.hf.xj.w
    public com.bytedance.sdk.openadsdk.mediation.manager.xj.hf.xj.xj getShowEcpm() {
        w wVar = this.xj;
        return wVar != null ? new c(wVar.y()) : new c(null);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.xj.hf.xj.w
    public boolean isReady() {
        w wVar = this.xj;
        if (wVar != null) {
            return wVar.xj();
        }
        return false;
    }
}
