package com.bytedance.sdk.openadsdk.mediation;

import com.bytedance.sdk.openadsdk.AdSlot;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public interface IMediationPreloadRequestInfo {
    AdSlot getAdSlot();

    int getAdType();

    List<String> getPrimeRitList();
}
