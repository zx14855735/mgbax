package com.fl.saas.base.manager.api;

import com.fl.saas.base.base.AdapterAPI;
import com.fl.saas.base.cache.AdCacheManager;
import com.fl.saas.common.saas.bean.AdPlace;
import com.fl.saas.common.saas.bean.AdSource;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public interface AdapterGenerator extends FailedLoader {
    AdapterAPI popCacheAdapter(AdCacheManager.CacheType cacheType, String str, long j);

    void pushCacheAdapter(AdCacheManager.CacheType cacheType, String str, long j, List<AdapterAPI> list);

    void reportFullAd(AdSource adSource);

    void reqSdkBidAd(AdPlace adPlace);

    void requestAd(AdSource adSource);
}
