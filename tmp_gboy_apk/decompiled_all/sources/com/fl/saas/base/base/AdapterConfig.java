package com.fl.saas.base.base;

import com.fl.saas.base.base.AdapterAPI;
import com.fl.saas.common.saas.bean.AdSource;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public interface AdapterConfig<T extends AdapterAPI> {
    T initAdapterConfig(T t);

    void requestAd(AdSource adSource);
}
