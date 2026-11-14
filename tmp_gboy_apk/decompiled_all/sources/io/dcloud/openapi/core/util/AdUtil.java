package io.dcloud.openapi.core.util;

import android.content.Context;
import android.text.TextUtils;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.acaaaaaa.aaaaaaau;
import io.dcloud.openapi.core.DCloudAOLManager;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class AdUtil {
    private static DCloudAOLManager.PrivacyConfig aaaaaaaa;

    public static String getCustomPrivacyConfig(Context context) {
        return aaaaaaau.aaaaaaaa(context, "dcloud-ads", "CustomPrivacyConfig");
    }

    public static DCloudAOLManager.PrivacyConfig getDCloudPrivacyConfig(Context context) {
        String customPrivacyConfig = getCustomPrivacyConfig(context);
        if (TextUtils.isEmpty(customPrivacyConfig)) {
            return null;
        }
        try {
            return getPrivacyConfig(new JSONObject(customPrivacyConfig));
        } catch (Exception unused) {
            return null;
        }
    }

    public static <T> T getOrDefault(Map<String, T> map, Object obj, T t) {
        T t2;
        return (map != null && ((t2 = map.get(obj)) != null || map.containsKey(obj))) ? t2 : t;
    }

    public static boolean getPersonalAd(Context context) {
        String aaaaaaaa2 = aaaaaaau.aaaaaaaa(context, "dcloud-ads", "PersonalizedAdEnable");
        if (TextUtils.isEmpty(aaaaaaaa2)) {
            aaaaaaaa2 = "true";
        }
        return Boolean.parseBoolean(aaaaaaaa2);
    }

    public static DCloudAOLManager.PrivacyConfig getPrivacyConfig(final JSONObject jSONObject) {
        return new DCloudAOLManager.PrivacyConfig() { // from class: io.dcloud.openapi.core.util.AdUtil.1
            @Override // io.dcloud.openapi.core.DCloudAOLManager.PrivacyConfig
            public boolean isAdult() {
                return jSONObject.optBoolean("isAdult", true);
            }

            @Override // io.dcloud.openapi.core.DCloudAOLManager.PrivacyConfig
            public boolean isCanGetAndroidId() {
                return jSONObject.optBoolean("isCanGetAndroidId", true);
            }

            @Override // io.dcloud.openapi.core.DCloudAOLManager.PrivacyConfig
            public boolean isCanGetIP() {
                return jSONObject.optBoolean("isCanGetIP", true);
            }

            @Override // io.dcloud.openapi.core.DCloudAOLManager.PrivacyConfig
            public boolean isCanGetInstallAppList() {
                return jSONObject.optBoolean("isCanGetInstallAppList", true);
            }

            @Override // io.dcloud.openapi.core.DCloudAOLManager.PrivacyConfig
            public boolean isCanGetMacAddress() {
                return jSONObject.optBoolean("isCanGetMacAddress", true);
            }

            @Override // io.dcloud.openapi.core.DCloudAOLManager.PrivacyConfig
            public boolean isCanGetOAID() {
                return jSONObject.optBoolean("isCanGetOAID", true);
            }

            @Override // io.dcloud.openapi.core.DCloudAOLManager.PrivacyConfig
            public boolean isCanGetRunningApps() {
                return jSONObject.optBoolean("isCanGetRunningApps", true);
            }

            @Override // io.dcloud.openapi.core.DCloudAOLManager.PrivacyConfig
            public boolean isCanUseLocation() {
                return jSONObject.optBoolean("isCanUseLocation", true);
            }

            @Override // io.dcloud.openapi.core.DCloudAOLManager.PrivacyConfig
            public boolean isCanUsePhoneState() {
                return jSONObject.optBoolean("isCanUsePhoneState", true);
            }

            @Override // io.dcloud.openapi.core.DCloudAOLManager.PrivacyConfig
            public boolean isCanUseRecordPermission() {
                return jSONObject.optBoolean("isCanUseRecordPermission", true);
            }

            @Override // io.dcloud.openapi.core.DCloudAOLManager.PrivacyConfig
            public boolean isCanUseSensor() {
                return jSONObject.optBoolean("isCanUseSensor", true);
            }

            @Override // io.dcloud.openapi.core.DCloudAOLManager.PrivacyConfig
            public boolean isCanUseSimOperator() {
                return jSONObject.optBoolean("isCanUseSimOperator", true);
            }

            @Override // io.dcloud.openapi.core.DCloudAOLManager.PrivacyConfig
            public boolean isCanUseStorage() {
                return jSONObject.optBoolean("isCanUseStorage", true);
            }

            @Override // io.dcloud.openapi.core.DCloudAOLManager.PrivacyConfig
            public boolean isCanUseWifiState() {
                return jSONObject.optBoolean("isCanUseWifiState", true);
            }

            @Override // io.dcloud.openapi.core.DCloudAOLManager.PrivacyConfig
            public boolean isGDTAgreeStrategy() {
                return jSONObject.optBoolean("isGDTAgreeStrategy", true);
            }
        };
    }

    public static void setCustomPrivacyConfig(Context context, String str) {
        aaaaaaau.aaaaaaaa(context, "dcloud-ads", "CustomPrivacyConfig", str);
    }

    public static void setPersonalAd(Context context, boolean z) {
        aaaaaaau.aaaaaaaa(context, "dcloud-ads", "PersonalizedAdEnable", String.valueOf(z));
    }

    public static DCloudAOLManager.PrivacyConfig getCustomPrivacyConfig() {
        return aaaaaaaa;
    }

    public static void setCustomPrivacyConfig(DCloudAOLManager.PrivacyConfig privacyConfig) {
        aaaaaaaa = privacyConfig;
    }
}
