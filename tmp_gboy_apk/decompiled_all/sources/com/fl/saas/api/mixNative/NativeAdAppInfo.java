package com.fl.saas.api.mixNative;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public interface NativeAdAppInfo {

    public interface ClickEvent {
        void onClick();
    }

    String getAppName();

    String getAppPermissionUrl();

    String getAppPrivacyUrl();

    String getAppVersion();

    ClickEvent getFunctionClick();

    String getFunctionUrl();

    ClickEvent getPermissonClick();

    ClickEvent getPrivacyClick();

    String getPublisher();
}
