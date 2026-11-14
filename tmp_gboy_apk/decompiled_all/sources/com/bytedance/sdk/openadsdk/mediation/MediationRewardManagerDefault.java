package com.bytedance.sdk.openadsdk.mediation;

import com.bytedance.sdk.openadsdk.mediation.manager.xj.hf.xj.hf;
import com.bytedance.sdk.openadsdk.mediation.manager.xj.hf.xj.xj;
import com.bytedance.sdk.openadsdk.mediation.manager.xj.hf.xj.y;
import java.util.LinkedList;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class MediationRewardManagerDefault extends y {
    @Override // com.bytedance.sdk.openadsdk.mediation.manager.xj.hf.xj.y
    public void destroy() {
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.xj.hf.xj.w
    public List<hf> getAdLoadInfo() {
        return new LinkedList();
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
    public boolean isReady() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.xj.hf.xj.w
    public MediationAdEcpmInfoDefault getBestEcpm() {
        return new MediationAdEcpmInfoDefault();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.xj.hf.xj.w
    public MediationAdEcpmInfoDefault getShowEcpm() {
        return new MediationAdEcpmInfoDefault();
    }
}
