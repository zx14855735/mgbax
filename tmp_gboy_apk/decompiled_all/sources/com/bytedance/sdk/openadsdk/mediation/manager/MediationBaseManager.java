package com.bytedance.sdk.openadsdk.mediation.manager;

import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public interface MediationBaseManager {
    List<MediationAdLoadInfo> getAdLoadInfo();

    MediationAdEcpmInfo getBestEcpm();

    List<MediationAdEcpmInfo> getCacheList();

    List<MediationAdEcpmInfo> getMultiBiddingEcpm();

    MediationAdEcpmInfo getShowEcpm();

    boolean isReady();
}
