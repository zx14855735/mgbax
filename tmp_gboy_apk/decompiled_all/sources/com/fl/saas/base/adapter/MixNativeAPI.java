package com.fl.saas.base.adapter;

import android.app.Activity;
import android.content.Context;
import com.fl.saas.api.AdParams;
import com.fl.saas.api.mixNative.NativeLoadListener;
import com.fl.saas.common.saas.bean.AdSource;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public interface MixNativeAPI {
    void clearCache();

    void destroy();

    void load(Activity activity);

    MixNativeAPI setAdId(String str, String str2);

    MixNativeAPI setAdParams(AdParams adParams);

    MixNativeAPI setAdSource(AdSource adSource);

    void setCache();

    MixNativeAPI setContext(Context context);

    MixNativeAPI setLoadListener(NativeLoadListener nativeLoadListener);
}
