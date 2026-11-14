package com.fl.saas.base.innterNative;

import android.content.Context;
import com.fl.saas.api.mixNative.NativeLoadListener;
import com.fl.saas.common.util.Check;
import com.fl.saas.common.util.CommConstant;
import com.fl.saas.config.exception.ErrorCodeConstant;
import com.fl.saas.config.exception.YdError;
import com.fl.saas.config.utils.LogcatUtil;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class BaseLoadNativeAd<T> extends BaseNativeAd<T> {
    private final String TAG;
    private final NativeLoadListener mLoadListener;

    public BaseLoadNativeAd(Context context, NativeLoadListener nativeLoadListener) {
        super(context);
        this.TAG = CommConstant.getObjTag("Native", this);
        this.mLoadListener = nativeLoadListener;
    }

    public void handleAd(T t) {
        handleAd(t, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void handleListAd(List<T> list) {
        handleAd(Check.findFirstNonNull(list), null);
    }

    public void onLoadFailed(YdError ydError) {
        this.mLoadListener.onAdFailed(ydError);
    }

    public void handleAd(T t, AmA8tU.A2egSU a2egSU) {
        if (t == null) {
            LogcatUtil.e(this.TAG, "onLoadFailed, native is empty");
        }
        if (a2egSU == null || ((Boolean) a2egSU.apply(t)).booleanValue()) {
            bindNativeAd(t);
            this.mLoadListener.onNativeAdLoaded(this);
            return;
        }
        LogcatUtil.e(this.TAG, "onLoadFailed, native is invalid");
        LogcatUtil.e(this.TAG, "onLoadFailed, native is empty");
        this.mLoadListener.onAdFailed(YdError.create(ErrorCodeConstant.RENDER_ERROR, this.TAG + ",native is empty"));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void handleListAd(List<T> list, AmA8tU.A2egSU a2egSU) {
        handleAd(Check.findFirstNonNull(list), a2egSU);
    }
}
