package com.fl.saas.base.inner;

import android.view.View;
import android.view.ViewGroup;
import com.fl.saas.api.mixNative.NativeAdView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public interface InnerNativeView {
    View getCATView();

    View[] getClicks();

    NativeAdView getNativeAdView();

    ViewGroup getSelfView();

    void onClicked();
}
