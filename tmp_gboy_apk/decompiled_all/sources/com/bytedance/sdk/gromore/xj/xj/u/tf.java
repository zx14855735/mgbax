package com.bytedance.sdk.gromore.xj.xj.u;

import java.util.LinkedList;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class tf extends com.bytedance.sdk.openadsdk.mediation.manager.xj.hf.xj.kd {
    private am xj;

    public tf(am amVar) {
        this.xj = amVar;
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
        am amVar = this.xj;
        return amVar != null ? new c(amVar.u()) : new c(null);
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
        am amVar = this.xj;
        return amVar != null ? new c(amVar.y()) : new c(null);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.xj.hf.xj.kd
    public boolean hasDislike() {
        am amVar = this.xj;
        if (amVar != null) {
            return amVar.c();
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.xj.hf.xj.kd
    public boolean isExpress() {
        am amVar = this.xj;
        if (amVar != null) {
            return amVar.f();
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.xj.hf.xj.w
    public boolean isReady() {
        am amVar = this.xj;
        if (amVar != null) {
            return amVar.xj();
        }
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.xj.hf.xj.kd
    public void onPause() {
        am amVar = this.xj;
        if (amVar != null) {
            amVar.tf();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.xj.hf.xj.kd
    public void onResume() {
        am amVar = this.xj;
        if (amVar != null) {
            amVar.d();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.xj.hf.xj.kd
    public void setShakeViewListener(final com.bytedance.sdk.openadsdk.mediation.ad.xj.hf.xj.y yVar) {
        am amVar = this.xj;
        if (amVar != null) {
            amVar.xj(new qt() { // from class: com.bytedance.sdk.gromore.xj.xj.u.tf.1
                @Override // com.bytedance.sdk.gromore.xj.xj.u.qt
                public void xj() {
                    com.bytedance.sdk.openadsdk.mediation.ad.xj.hf.xj.y yVar2 = yVar;
                    if (yVar2 != null) {
                        yVar2.xj();
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.xj.hf.xj.kd
    public void setUseCustomVideo(boolean z) {
        am amVar = this.xj;
        if (amVar != null) {
            amVar.xj(z);
        }
    }
}
