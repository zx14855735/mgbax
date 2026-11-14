package com.baidu.mobads.sdk.api;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public interface IPromoteInstallAdInfo {
    String getAppPublisher();

    String getAppVersion();

    String getBrandName();

    String getECPMLevel();

    String getFunctionUrl();

    String getIconUrl();

    String getPermissionUrl();

    String getPrivacyUrl();

    String getUnionLogoUrl();

    void handleAdInstall();
}
