package com.fl.saas.api.mixNative;

import android.view.View;
import com.fl.saas.api.AdParams;
import com.fl.saas.base.manager.MixNativeManager;
import com.fl.saas.ydsdk.api.MediaExtraInfo;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public interface NativeAd extends MediaExtraInfo {
    @Deprecated
    void destroy();

    NativeMaterial getAdMaterial();

    NativeCustomizeVideo getCustomizeVideo();

    String getReqId();

    boolean isNativeExpress();

    boolean isShakeType();

    void onDetachedVideo();

    void onPause();

    void onResume();

    void prepare(NativePrepareInfo nativePrepareInfo);

    void release();

    void renderAdContainer(NativeAdView nativeAdView, View view);

    void setCanRefresh(boolean z);

    void setClickCallBackListener(NativeClickCallbackListener nativeClickCallbackListener);

    void setNativeAdParams(AdParams adParams);

    void setNativeEventListener(NativeEventListener nativeEventListener);

    void setOnNativeReleaseListener(MixNativeManager.OnNativeReleaseListener onNativeReleaseListener);
}
