package com.fl.saas.base.interfaces;

import android.content.Context;
import android.graphics.Rect;
import android.view.ViewGroup;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public interface ISplashEyeAd {
    void destroy();

    int[] getSuggestedSize(Context context);

    void onFinished();

    void setEyeAdContainer(ViewGroup viewGroup);

    void show(Context context, Rect rect, SplashEyeAdListener splashEyeAdListener);
}
