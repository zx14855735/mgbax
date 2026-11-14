package com.bytedance.sdk.openadsdk;

import com.bytedance.sdk.openadsdk.CSJConfig;
import com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class TTAdConfig extends CSJConfig {

    public static class Builder {
        private CSJConfig.xj xj = new CSJConfig.xj();

        public Builder addExtra(String str, Object obj) {
            this.xj.xj(str, obj);
            return this;
        }

        public Builder allowShowNotify(boolean z) {
            this.xj.hf(z);
            return this;
        }

        public Builder appId(String str) {
            this.xj.xj(str);
            return this;
        }

        public Builder appName(String str) {
            this.xj.hf(str);
            return this;
        }

        public TTAdConfig build() {
            return new TTAdConfig(this.xj);
        }

        public Builder customController(TTCustomController tTCustomController) {
            this.xj.xj(tTCustomController);
            return this;
        }

        public Builder data(String str) {
            this.xj.u(str);
            return this;
        }

        public Builder debug(boolean z) {
            this.xj.w(z);
            return this;
        }

        public Builder directDownloadNetworkType(int... iArr) {
            this.xj.xj(iArr);
            return this;
        }

        public Builder keywords(String str) {
            this.xj.w(str);
            return this;
        }

        public Builder paid(boolean z) {
            this.xj.xj(z);
            return this;
        }

        public Builder setAgeGroup(int i) {
            this.xj.u(i);
            return this;
        }

        public Builder setMediationConfig(IMediationConfig iMediationConfig) {
            this.xj.xj(iMediationConfig);
            return this;
        }

        public Builder setPluginUpdateConfig(int i) {
            this.xj.w(i);
            return this;
        }

        public Builder supportMultiProcess(boolean z) {
            this.xj.u(z);
            return this;
        }

        public Builder themeStatus(int i) {
            this.xj.hf(i);
            return this;
        }

        public Builder titleBarTheme(int i) {
            this.xj.xj(i);
            return this;
        }

        public Builder useMediation(boolean z) {
            this.xj.kd(z);
            return this;
        }
    }

    private TTAdConfig(CSJConfig.xj xjVar) {
        super(xjVar);
    }
}
