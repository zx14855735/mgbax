package com.fl.saas.config;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.fl.saas.base.bean.KsConfigBean;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class ConfigLib {
    private static ConfigLib sInstance;
    private Map<String, KsConfigBean> ksAppConfig;
    private Map<String, KsConfigBean> ksSensorConfig;

    public static synchronized ConfigLib getInstance() {
        ConfigLib configLib;
        synchronized (ConfigLib.class) {
            try {
                if (sInstance == null) {
                    synchronized (ConfigLib.class) {
                        sInstance = new ConfigLib();
                    }
                }
                configLib = sInstance;
            } catch (Throwable th) {
                throw th;
            }
        }
        return configLib;
    }

    public KsConfigBean getKsAppConfig(String str) {
        if (this.ksAppConfig == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.ksAppConfig.get(str);
    }

    public KsConfigBean getKsSensorConfig(String str) {
        if (this.ksSensorConfig == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.ksSensorConfig.get(str);
    }

    public void setKsAppConfig(JSONObject jSONObject) {
        if (this.ksAppConfig == null) {
            this.ksAppConfig = new HashMap();
        }
        if (jSONObject != null) {
            try {
                String optString = jSONObject.optString(PluginConstants.KEY_APP_ID);
                String optString2 = jSONObject.optString("kuaishou_package_name");
                String optString3 = jSONObject.optString("kuaishou_version");
                String optString4 = jSONObject.optString("kuaishou_sha1");
                if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2) || TextUtils.isEmpty(optString3) || TextUtils.isEmpty(optString4)) {
                    return;
                }
                this.ksAppConfig.put(optString, new KsConfigBean(optString2, optString3, optString4));
            } catch (Exception unused) {
            }
        }
    }

    public void setKsSensorConfig(JSONObject jSONObject) {
        if (this.ksSensorConfig == null) {
            this.ksSensorConfig = new HashMap();
        }
        if (jSONObject != null) {
            try {
                String optString = jSONObject.optString("tagid");
                int optInt = jSONObject.optInt("kuaishou_shake_sensitivity", 0);
                int optInt2 = jSONObject.optInt("kuaishou_twist_sensitivity", 0);
                if (TextUtils.isEmpty(optString) || optInt <= 0 || optInt2 <= 0) {
                    return;
                }
                this.ksSensorConfig.put(optString, new KsConfigBean(optInt, optInt2));
            } catch (Exception unused) {
            }
        }
    }
}
