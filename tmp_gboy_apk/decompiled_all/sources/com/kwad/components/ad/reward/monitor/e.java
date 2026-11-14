package com.kwad.components.ad.reward.monitor;

import android.os.SystemClock;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.AdVideoPreCacheConfig;
import com.tencent.mm.opensdk.constants.ConstantsAPI;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class e {
    public static void a(AdTemplate adTemplate, boolean z, AdVideoPreCacheConfig adVideoPreCacheConfig) {
        adTemplate.setLoadDataTime(SystemClock.elapsedRealtime());
        adTemplate.setLoadFromCache(z);
        long adVideoPreCacheSize = adVideoPreCacheConfig.getAdVideoPreCacheSize() * ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_XLS;
        if (adVideoPreCacheSize > 0) {
            adTemplate.setDownloadType(3);
            adTemplate.setDownloadSize(adVideoPreCacheSize);
        } else if (adVideoPreCacheSize < 0) {
            adTemplate.setDownloadType(2);
        } else {
            adTemplate.setDownloadType(1);
            adTemplate.setDownloadSize(0L);
        }
    }
}
