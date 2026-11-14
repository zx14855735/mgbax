package com.kwad.sdk.liteapi;

import A5SV6n.A2egSU;
import com.kwad.sdk.api.SdkConfig;

@A2egSU
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class InputParamHolder {
    private static SdkConfig mSdkConfig;

    public static String getAppId() {
        SdkConfig sdkConfig = mSdkConfig;
        return sdkConfig == null ? "" : sdkConfig.appId;
    }

    public static String getAppName() {
        SdkConfig sdkConfig = mSdkConfig;
        return sdkConfig == null ? "" : sdkConfig.appName;
    }

    public static SdkConfig getSDKConfig() {
        return mSdkConfig;
    }

    public static void holderSdkConfig(SdkConfig sdkConfig) {
        mSdkConfig = sdkConfig;
    }
}
