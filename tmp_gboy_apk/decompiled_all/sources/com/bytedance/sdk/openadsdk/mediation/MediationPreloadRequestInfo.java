package com.bytedance.sdk.openadsdk.mediation;

import com.bytedance.sdk.openadsdk.AdSlot;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class MediationPreloadRequestInfo implements IMediationPreloadRequestInfo {
    private AdSlot hf;
    private List<String> w;
    private int xj;

    public MediationPreloadRequestInfo(int i, AdSlot adSlot, List<String> list) {
        this.xj = i;
        this.hf = adSlot;
        this.w = list;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationPreloadRequestInfo
    public AdSlot getAdSlot() {
        return this.hf;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationPreloadRequestInfo
    public int getAdType() {
        return this.xj;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationPreloadRequestInfo
    public List<String> getPrimeRitList() {
        return this.w;
    }
}
