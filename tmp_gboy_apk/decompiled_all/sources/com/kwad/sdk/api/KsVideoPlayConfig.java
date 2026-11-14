package com.kwad.sdk.api;

import A5SV6n.A2egSU;
import com.kwad.sdk.api.core.KsAdSdkApi;
import com.kwad.sdk.api.loader.Loader;
import java.io.Serializable;

@KsAdSdkApi
@A2egSU
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public interface KsVideoPlayConfig extends Serializable {

    @KsAdSdkApi
    @A2egSU
    public static class Builder {
        private boolean showLandscape;
        private String showScene;
        private boolean skipLongTime;
        private boolean videoSoundEnable = true;

        @KsAdSdkApi
        @A2egSU
        public KsVideoPlayConfig build() {
            KsVideoPlayConfig ksVideoPlayConfig = (KsVideoPlayConfig) Loader.get().newInstance(KsVideoPlayConfig.class);
            ksVideoPlayConfig.setShowScene(this.showScene);
            ksVideoPlayConfig.setShowLandscape(this.showLandscape);
            ksVideoPlayConfig.setSkipThirtySecond(this.skipLongTime);
            ksVideoPlayConfig.setVideoSoundEnable(this.videoSoundEnable);
            return ksVideoPlayConfig;
        }

        @KsAdSdkApi
        @A2egSU
        public Builder showLandscape(boolean z) {
            this.showLandscape = z;
            return this;
        }

        @KsAdSdkApi
        @A2egSU
        public Builder showScene(String str) {
            this.showScene = str;
            return this;
        }

        @KsAdSdkApi
        @A2egSU
        public Builder skipThirtySecond(boolean z) {
            this.skipLongTime = z;
            return this;
        }

        @KsAdSdkApi
        @A2egSU
        public Builder videoSoundEnable(boolean z) {
            this.videoSoundEnable = z;
            return this;
        }
    }

    @KsAdSdkApi
    @A2egSU
    String getShowScene();

    @KsAdSdkApi
    @A2egSU
    boolean isShowLandscape();

    @KsAdSdkApi
    @A2egSU
    boolean isSkipThirtySecond();

    @KsAdSdkApi
    @A2egSU
    boolean isVideoSoundEnable();

    @KsAdSdkApi
    @A2egSU
    void setShowLandscape(boolean z);

    @KsAdSdkApi
    @A2egSU
    void setShowScene(String str);

    @KsAdSdkApi
    @A2egSU
    void setSkipThirtySecond(boolean z);

    @KsAdSdkApi
    @A2egSU
    void setVideoSoundEnable(boolean z);
}
