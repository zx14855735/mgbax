package com.fl.saas.base.cache;

import com.fl.saas.base.base.AdapterAPI;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class AdCacheValue {
    private final AdapterAPI adapter;
    private final long cacheTime;
    private final String placeId;
    private final int price;

    public AdCacheValue(long j, String str, int i, AdapterAPI adapterAPI) {
        this.cacheTime = j;
        this.placeId = str;
        this.price = i;
        this.adapter = adapterAPI;
    }

    public AdapterAPI getAdapter() {
        return this.adapter;
    }

    public long getCacheTime() {
        return this.cacheTime;
    }

    public String getPlaceId() {
        return this.placeId;
    }

    public int getPrice() {
        return this.price;
    }
}
