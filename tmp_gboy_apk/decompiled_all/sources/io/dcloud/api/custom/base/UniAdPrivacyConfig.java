package io.dcloud.api.custom.base;

import io.dcloud.openapi.core.DCloudAOLManager;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class UniAdPrivacyConfig {
    private DCloudAOLManager.PrivacyConfig aaaaaaaa;

    public UniAdPrivacyConfig(DCloudAOLManager.PrivacyConfig privacyConfig) {
        this.aaaaaaaa = privacyConfig;
    }

    public boolean isAdult() {
        DCloudAOLManager.PrivacyConfig privacyConfig = this.aaaaaaaa;
        if (privacyConfig == null) {
            return true;
        }
        return privacyConfig.isAdult();
    }

    public boolean isCanGetAndroidId() {
        DCloudAOLManager.PrivacyConfig privacyConfig = this.aaaaaaaa;
        if (privacyConfig == null) {
            return true;
        }
        return privacyConfig.isCanGetAndroidId();
    }

    public boolean isCanGetIP() {
        DCloudAOLManager.PrivacyConfig privacyConfig = this.aaaaaaaa;
        if (privacyConfig == null) {
            return true;
        }
        return privacyConfig.isCanGetIP();
    }

    public boolean isCanGetInstallAppList() {
        DCloudAOLManager.PrivacyConfig privacyConfig = this.aaaaaaaa;
        if (privacyConfig == null) {
            return true;
        }
        return privacyConfig.isCanGetInstallAppList();
    }

    public boolean isCanGetMacAddress() {
        DCloudAOLManager.PrivacyConfig privacyConfig = this.aaaaaaaa;
        if (privacyConfig == null) {
            return true;
        }
        return privacyConfig.isCanGetMacAddress();
    }

    public boolean isCanGetOAID() {
        DCloudAOLManager.PrivacyConfig privacyConfig = this.aaaaaaaa;
        if (privacyConfig == null) {
            return true;
        }
        return privacyConfig.isCanGetOAID();
    }

    public boolean isCanGetRunningApps() {
        DCloudAOLManager.PrivacyConfig privacyConfig = this.aaaaaaaa;
        if (privacyConfig == null) {
            return true;
        }
        return privacyConfig.isCanGetRunningApps();
    }

    public boolean isCanUseLocation() {
        DCloudAOLManager.PrivacyConfig privacyConfig = this.aaaaaaaa;
        if (privacyConfig == null) {
            return true;
        }
        return privacyConfig.isCanUseLocation();
    }

    public boolean isCanUsePhoneState() {
        DCloudAOLManager.PrivacyConfig privacyConfig = this.aaaaaaaa;
        if (privacyConfig == null) {
            return true;
        }
        return privacyConfig.isCanUsePhoneState();
    }

    public boolean isCanUseSensor() {
        DCloudAOLManager.PrivacyConfig privacyConfig = this.aaaaaaaa;
        if (privacyConfig == null) {
            return true;
        }
        return privacyConfig.isCanUseSensor();
    }

    public boolean isCanUseSimOperator() {
        DCloudAOLManager.PrivacyConfig privacyConfig = this.aaaaaaaa;
        if (privacyConfig == null) {
            return true;
        }
        return privacyConfig.isCanUseSimOperator();
    }

    public boolean isCanUseStorage() {
        DCloudAOLManager.PrivacyConfig privacyConfig = this.aaaaaaaa;
        if (privacyConfig == null) {
            return true;
        }
        return privacyConfig.isCanUseStorage();
    }

    public boolean isCanUseWifiState() {
        DCloudAOLManager.PrivacyConfig privacyConfig = this.aaaaaaaa;
        if (privacyConfig == null) {
            return true;
        }
        return privacyConfig.isCanUseWifiState();
    }

    public boolean isGDTAgreeStrategy() {
        DCloudAOLManager.PrivacyConfig privacyConfig = this.aaaaaaaa;
        if (privacyConfig == null) {
            return true;
        }
        return privacyConfig.isGDTAgreeStrategy();
    }
}
