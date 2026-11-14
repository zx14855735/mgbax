package com.fl.saas.base.manager;

import android.content.Context;
import com.fl.saas.base.manager.loader.AdViewManager;
import com.fl.saas.common.saas.bean.AdSource;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public interface AdAdapterAPI {
    void destroy();

    AdSource getAdSource();

    boolean isCache();

    void load();

    void reportRequestShow();

    AdAdapterAPI setAdAdapter(AdViewManager adViewManager);

    AdAdapterAPI setAdSource(AdSource adSource);

    void setCache();

    AdAdapterAPI setContext(Context context);

    void showAd();
}
