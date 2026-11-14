package com.kwad.sdk.api;

import A5SV6n.A2egSU;
import com.fl.saas.base.custom.MedProConst;
import com.kwad.sdk.api.core.KsAdSdkApi;
import org.json.JSONException;
import org.json.JSONObject;

@KsAdSdkApi
@A2egSU
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class SdkConfig {
    public static final String DEF_NIGHT_THEME_STYLE_FILE_NAME = "ks_adsdk_night_styles.xml";

    @KsAdSdkApi
    @A2egSU
    public static final int SCREEN_ORIENTATION_LANDSCAPE = 2;

    @KsAdSdkApi
    @A2egSU
    public static final int SCREEN_ORIENTATION_PORTRAIT = 1;

    @KsAdSdkApi
    @A2egSU
    public static final int SCREEN_ORIENTATION_UNKNOWN = 0;

    @KsAdSdkApi
    @A2egSU
    public String appId;

    @KsAdSdkApi
    @A2egSU
    public String appKey;

    @KsAdSdkApi
    @A2egSU
    public String appName;

    @KsAdSdkApi
    @A2egSU
    public String appWebKey;

    @KsAdSdkApi
    @A2egSU
    private boolean canReadICCID;

    @KsAdSdkApi
    @A2egSU
    private boolean canReadMacAddress;

    @KsAdSdkApi
    @A2egSU
    private boolean canReadNearbyWifiList;

    @KsAdSdkApi
    @A2egSU
    public boolean enableDebug;

    @KsAdSdkApi
    @A2egSU
    public KsCustomController ksCustomController;
    public KsInitCallback ksInitCallback;
    public KsInitCallback ksStartCallback;

    @KsAdSdkApi
    @A2egSU
    public String nightThemeStyleAssetsFileName;

    @KsAdSdkApi
    @A2egSU
    public boolean showNotification;

    @KsAdSdkApi
    @A2egSU
    public static class Builder {
        private String appId;
        private String appKey;
        private String appName;
        private String appWebKey;
        private boolean enableDebug;
        private KsCustomController ksCustomController;
        private KsInitCallback ksInitCallback;
        private KsInitCallback ksStartCallback;
        private boolean showNotification = true;
        private boolean canReadMacAddress = true;
        private boolean canReadNearbyWifiList = true;
        private boolean canReadICCID = true;
        private String nightThemeStyleAssetsFileName = SdkConfig.DEF_NIGHT_THEME_STYLE_FILE_NAME;

        @KsAdSdkApi
        @A2egSU
        public Builder() {
        }

        @KsAdSdkApi
        @A2egSU
        public Builder appId(String str) {
            this.appId = str;
            return this;
        }

        @KsAdSdkApi
        @A2egSU
        public Builder appKey(String str) {
            this.appKey = str;
            return this;
        }

        @KsAdSdkApi
        @A2egSU
        public Builder appName(String str) {
            this.appName = str;
            return this;
        }

        @KsAdSdkApi
        @A2egSU
        public Builder appWebKey(String str) {
            this.appWebKey = str;
            return this;
        }

        @KsAdSdkApi
        @A2egSU
        public SdkConfig build() {
            return new SdkConfig(this);
        }

        @KsAdSdkApi
        @A2egSU
        @Deprecated
        public Builder canReadICCID(boolean z) {
            this.canReadICCID = z;
            return this;
        }

        @KsAdSdkApi
        @A2egSU
        @Deprecated
        public Builder canReadMacAddress(boolean z) {
            this.canReadMacAddress = z;
            return this;
        }

        @KsAdSdkApi
        @A2egSU
        public Builder canReadNearbyWifiList(boolean z) {
            this.canReadNearbyWifiList = z;
            return this;
        }

        @KsAdSdkApi
        @A2egSU
        public Builder customController(KsCustomController ksCustomController) {
            this.ksCustomController = ksCustomController;
            return this;
        }

        @KsAdSdkApi
        @A2egSU
        public Builder debug(boolean z) {
            this.enableDebug = z;
            return this;
        }

        @KsAdSdkApi
        @A2egSU
        public Builder nightThemeStyleAssetsFileName(String str) {
            this.nightThemeStyleAssetsFileName = str;
            return this;
        }

        @KsAdSdkApi
        @A2egSU
        public Builder setInitCallback(KsInitCallback ksInitCallback) {
            this.ksInitCallback = ksInitCallback;
            return this;
        }

        @KsAdSdkApi
        @A2egSU
        public Builder setStartCallback(KsInitCallback ksInitCallback) {
            this.ksStartCallback = ksInitCallback;
            return this;
        }

        @KsAdSdkApi
        @A2egSU
        public Builder showNotification(boolean z) {
            this.showNotification = z;
            return this;
        }
    }

    public static SdkConfig create(String str) {
        Builder builder = new Builder();
        try {
            JSONObject jSONObject = new JSONObject(str);
            builder.enableDebug = jSONObject.optBoolean("enableDebug");
            builder.appId = jSONObject.optString(MedProConst.AD_APPID);
            builder.appName = jSONObject.optString("appName");
            builder.appKey = jSONObject.optString(MedProConst.AD_APPKEY);
            builder.appWebKey = jSONObject.optString("appWebKey");
            builder.showNotification = jSONObject.optBoolean("showNotification");
            builder.canReadMacAddress = jSONObject.optBoolean("canReadMacAddress");
            builder.canReadNearbyWifiList = jSONObject.optBoolean("canReadNearbyWifiList");
            builder.canReadICCID = jSONObject.optBoolean("canReadICCID");
            builder.nightThemeStyleAssetsFileName = jSONObject.optString("nightThemeStyleAssetsFileName");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return builder.build();
    }

    @KsAdSdkApi
    @A2egSU
    public boolean canReadICCID() {
        return this.canReadICCID;
    }

    @KsAdSdkApi
    @A2egSU
    public boolean canReadMacAddress() {
        return this.canReadMacAddress;
    }

    @KsAdSdkApi
    @A2egSU
    public boolean canReadNearbyWifiList() {
        return this.canReadNearbyWifiList;
    }

    public String toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("enableDebug", this.enableDebug);
            jSONObject.put(MedProConst.AD_APPID, this.appId);
            jSONObject.put("appName", this.appName);
            jSONObject.put(MedProConst.AD_APPKEY, this.appKey);
            jSONObject.put("appWebKey", this.appWebKey);
            jSONObject.put("showNotification", this.showNotification);
            jSONObject.put("canReadMacAddress", this.canReadMacAddress);
            jSONObject.put("canReadNearbyWifiList", this.canReadNearbyWifiList);
            jSONObject.put("canReadICCID", this.canReadICCID);
            jSONObject.put("nightThemeStyleAssetsFileName", this.nightThemeStyleAssetsFileName);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    @KsAdSdkApi
    @A2egSU
    private SdkConfig(Builder builder) {
        this.enableDebug = builder.enableDebug;
        this.appId = builder.appId;
        this.appName = builder.appName;
        this.appKey = builder.appKey;
        this.appWebKey = builder.appWebKey;
        this.showNotification = builder.showNotification;
        this.canReadMacAddress = builder.canReadMacAddress;
        this.canReadNearbyWifiList = builder.canReadNearbyWifiList;
        this.canReadICCID = builder.canReadICCID;
        this.nightThemeStyleAssetsFileName = builder.nightThemeStyleAssetsFileName;
        this.ksCustomController = builder.ksCustomController;
        this.ksInitCallback = builder.ksInitCallback;
        this.ksStartCallback = builder.ksStartCallback;
    }
}
