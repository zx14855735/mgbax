package com.fl.saas.base.inner;

import com.fl.saas.base.inner.InnerNativeView;
import com.fl.saas.config.exception.YdError;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public interface InnerViewLoaderEvent<T extends InnerNativeView> {
    void onAdFailed(YdError ydError);

    void onLoaded(T t);
}
