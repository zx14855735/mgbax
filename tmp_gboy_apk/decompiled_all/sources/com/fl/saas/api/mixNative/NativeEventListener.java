package com.fl.saas.api.mixNative;

import com.fl.saas.config.exception.YdError;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public interface NativeEventListener {
    void onAdClicked(NativeAdView nativeAdView);

    void onAdClose(NativeAdView nativeAdView);

    void onAdFailed(NativeAdView nativeAdView, YdError ydError);

    void onAdImpressed(NativeAdView nativeAdView);

    void onAdVideoEnd(NativeAdView nativeAdView);

    void onAdVideoProgress(NativeAdView nativeAdView, long j);

    void onAdVideoStart(NativeAdView nativeAdView);
}
