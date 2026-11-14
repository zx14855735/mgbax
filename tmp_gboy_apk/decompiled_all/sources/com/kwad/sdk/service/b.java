package com.kwad.sdk.service;

import com.kwad.sdk.api.SdkConfig;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class b {
    private static SdkConfig mSdkConfig;

    public static String getAppId() {
        return mSdkConfig.appId;
    }

    public static String getAppName() {
        return mSdkConfig.appName;
    }

    public static SdkConfig getSDKConfig() {
        return mSdkConfig;
    }

    public static void holderSdkConfig(SdkConfig sdkConfig) {
        mSdkConfig = sdkConfig;
    }
}
