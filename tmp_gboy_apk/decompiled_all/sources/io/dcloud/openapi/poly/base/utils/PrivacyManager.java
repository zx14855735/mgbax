package io.dcloud.openapi.poly.base.utils;

import io.dcloud.openapi.core.DCloudAOLManager;
import io.dcloud.openapi.core.util.Const;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class PrivacyManager {
    private static volatile PrivacyManager aaaaaaao;
    private final Map aaaaaaa0 = new HashMap();
    private DCloudAOLManager.PrivacyConfig aaaaaaaa;

    private PrivacyManager() {
    }

    public static PrivacyManager getInstance() {
        if (aaaaaaao == null) {
            synchronized (PrivacyManager.class) {
                try {
                    if (aaaaaaao == null) {
                        aaaaaaao = new PrivacyManager();
                    }
                } finally {
                }
            }
        }
        return aaaaaaao;
    }

    public String aaaaaaa0() {
        return "";
    }

    public String[] aaaaaaaa() {
        return null;
    }

    public boolean aaaaaaac() {
        return true;
    }

    public String aaaaaaao() {
        return "";
    }

    public boolean aaaaaaau() {
        return this.aaaaaaaa != null;
    }

    public Map<String, Boolean> getPrivacyMap() {
        return this.aaaaaaa0;
    }

    public void updateConfig(DCloudAOLManager.PrivacyConfig privacyConfig) {
        this.aaaaaaaa = privacyConfig;
        this.aaaaaaa0.put(Const.PrivacyType.IS_ADULT, Boolean.valueOf(privacyConfig.isAdult()));
        this.aaaaaaa0.put(Const.PrivacyType.IS_CAN_USE_PHONE_STATE, Boolean.valueOf(privacyConfig.isCanUsePhoneState()));
        this.aaaaaaa0.put(Const.PrivacyType.IS_CAN_USE_STORAGE, Boolean.valueOf(privacyConfig.isCanUseStorage()));
        this.aaaaaaa0.put(Const.PrivacyType.IS_CAN_USE_LOCATION, Boolean.valueOf(privacyConfig.isCanUseLocation()));
        this.aaaaaaa0.put(Const.PrivacyType.IS_CAN_USE_WIFI_STATE, Boolean.valueOf(privacyConfig.isCanUseWifiState()));
        this.aaaaaaa0.put(Const.PrivacyType.IS_CAN_GET_INSTALL_APP_LIST, Boolean.valueOf(privacyConfig.isCanGetInstallAppList()));
        this.aaaaaaa0.put(Const.PrivacyType.IS_CAN_GET_RUNNING_APPS, Boolean.valueOf(privacyConfig.isCanGetRunningApps()));
        this.aaaaaaa0.put(Const.PrivacyType.IS_CAN_GET_MAC, Boolean.valueOf(privacyConfig.isCanGetMacAddress()));
        this.aaaaaaa0.put(Const.PrivacyType.IS_CAN_GET_ANDROID_ID, Boolean.valueOf(privacyConfig.isCanGetAndroidId()));
    }
}
