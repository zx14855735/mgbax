package com.fl.saas.base.base;

import android.content.Context;
import com.fl.saas.base.manager.loader.AdViewManager;
import com.fl.saas.common.saas.bean.AdSource;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public interface AdapterAPI {
    void clearCache();

    void destroy();

    AdSource getAdSource();

    boolean isCache();

    void load();

    void reportRequestShow();

    AdapterAPI setAdAdapter(AdViewManager adViewManager);

    AdapterAPI setAdSource(AdSource adSource);

    void setCache();

    AdapterAPI setContext(Context context);

    void showAd();
}
