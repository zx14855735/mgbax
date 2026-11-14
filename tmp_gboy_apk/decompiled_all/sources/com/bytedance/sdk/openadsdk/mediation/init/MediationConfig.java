package com.bytedance.sdk.openadsdk.mediation.init;

import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class MediationConfig implements IMediationConfig {
    private boolean c;
    private boolean d;
    private String f;
    private boolean hf;
    private boolean kd;
    private String p;
    private boolean tf;
    private Map<String, Object> u;
    private MediationConfigUserInfoForSegment w;
    private String xj;
    private JSONObject y;

    public static class Builder {
        private boolean c;
        private boolean d;
        private String f;
        private boolean hf;
        private boolean kd;
        private String p;
        private boolean tf;
        private Map<String, Object> u;
        private MediationConfigUserInfoForSegment w;
        private String xj;
        private JSONObject y;

        public MediationConfig build() {
            MediationConfig mediationConfig = new MediationConfig();
            mediationConfig.xj = this.xj;
            mediationConfig.hf = this.hf;
            mediationConfig.w = this.w;
            mediationConfig.u = this.u;
            mediationConfig.kd = this.kd;
            mediationConfig.y = this.y;
            mediationConfig.c = this.c;
            mediationConfig.f = this.f;
            mediationConfig.d = this.d;
            mediationConfig.tf = this.tf;
            mediationConfig.p = this.p;
            return mediationConfig;
        }

        public Builder setCustomLocalConfig(JSONObject jSONObject) {
            this.y = jSONObject;
            return this;
        }

        public Builder setHttps(boolean z) {
            this.kd = z;
            return this;
        }

        @Deprecated
        public Builder setLocalExtra(Map<String, Object> map) {
            this.u = map;
            return this;
        }

        public Builder setMediationConfigUserInfoForSegment(MediationConfigUserInfoForSegment mediationConfigUserInfoForSegment) {
            this.w = mediationConfigUserInfoForSegment;
            return this;
        }

        public Builder setOpenAdnTest(boolean z) {
            this.hf = z;
            return this;
        }

        public Builder setOpensdkVer(String str) {
            this.f = str;
            return this;
        }

        public Builder setPublisherDid(String str) {
            this.xj = str;
            return this;
        }

        public Builder setSupportH265(boolean z) {
            this.d = z;
            return this;
        }

        public Builder setSupportSplashZoomout(boolean z) {
            this.tf = z;
            return this;
        }

        public Builder setWxAppId(String str) {
            this.p = str;
            return this;
        }

        public Builder setWxInstalled(boolean z) {
            this.c = z;
            return this;
        }
    }

    private MediationConfig() {
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public JSONObject getCustomLocalConfig() {
        return this.y;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public boolean getHttps() {
        return this.kd;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public Map<String, Object> getLocalExtra() {
        return this.u;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public MediationConfigUserInfoForSegment getMediationConfigUserInfoForSegment() {
        return this.w;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public String getOpensdkVer() {
        return this.f;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public String getPublisherDid() {
        return this.xj;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public boolean isOpenAdnTest() {
        return this.hf;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public boolean isSupportH265() {
        return this.d;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public boolean isSupportSplashZoomout() {
        return this.tf;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public boolean isWxInstalled() {
        return this.c;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public String wxAppId() {
        return this.p;
    }
}
