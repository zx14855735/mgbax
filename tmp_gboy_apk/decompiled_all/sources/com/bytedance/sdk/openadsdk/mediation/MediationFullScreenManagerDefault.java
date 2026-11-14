package com.bytedance.sdk.openadsdk.mediation;

import com.bytedance.sdk.openadsdk.mediation.manager.xj.hf.xj.hf;
import com.bytedance.sdk.openadsdk.mediation.manager.xj.hf.xj.u;
import com.bytedance.sdk.openadsdk.mediation.manager.xj.hf.xj.xj;
import java.util.LinkedList;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class MediationFullScreenManagerDefault extends u {
    @Override // com.bytedance.sdk.openadsdk.mediation.manager.xj.hf.xj.u
    public void destroy() {
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.xj.hf.xj.w
    public List<hf> getAdLoadInfo() {
        return new LinkedList();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.xj.hf.xj.w
    public xj getBestEcpm() {
        return new MediationAdEcpmInfoDefault();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.xj.hf.xj.w
    public List<xj> getCacheList() {
        return new LinkedList();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.xj.hf.xj.w
    public List<xj> getMultiBiddingEcpm() {
        return new LinkedList();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.xj.hf.xj.w
    public xj getShowEcpm() {
        return new MediationAdEcpmInfoDefault();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.xj.hf.xj.w
    public boolean isReady() {
        return true;
    }
}
