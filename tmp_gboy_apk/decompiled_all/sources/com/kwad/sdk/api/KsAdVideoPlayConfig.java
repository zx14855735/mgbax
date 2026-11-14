package com.kwad.sdk.api;

import A5SV6n.A2egSU;
import com.kwad.sdk.api.core.KsAdSdkApi;
import com.kwad.sdk.api.loader.Loader;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@KsAdSdkApi
@A2egSU
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public interface KsAdVideoPlayConfig {

    @KsAdSdkApi
    @A2egSU
    public static class Builder {
        private boolean dataFlowAutoStart;
        private boolean videoSoundEnable;
        private boolean isNoCache = false;
        KsAdVideoPlayConfig config = (KsAdVideoPlayConfig) Loader.get().newInstance(KsAdVideoPlayConfig.class);

        @KsAdSdkApi
        @A2egSU
        public KsAdVideoPlayConfig build() {
            return this.config;
        }

        @KsAdSdkApi
        @A2egSU
        @Deprecated
        public Builder dataFlowAutoStart(boolean z) {
            this.config.setDataFlowAutoStart(z);
            return this;
        }

        @KsAdSdkApi
        @A2egSU
        public Builder noCache() {
            this.config.setNoCache();
            return this;
        }

        @KsAdSdkApi
        @A2egSU
        public Builder videoAutoPlayType(int i) {
            this.config.setVideoAutoPlayType(i);
            return this;
        }

        @KsAdSdkApi
        @A2egSU
        public Builder videoSoundEnable(boolean z) {
            this.config.setVideoSoundEnable(z);
            return this;
        }
    }

    @KsAdSdkApi
    @A2egSU
    @Retention(RetentionPolicy.SOURCE)
    public @interface VideoAutoPlayType {
        public static final int AUTO_PLAY = 1;
        public static final int AUTO_PLAY_WIFI = 2;
        public static final int NO_AUTO_PLAY = 3;
        public static final int UNKNOWN = 0;
    }

    @KsAdSdkApi
    @A2egSU
    int getVideoAutoPlayType();

    @KsAdSdkApi
    @A2egSU
    boolean isDataFlowAutoStart();

    @KsAdSdkApi
    @A2egSU
    boolean isNoCache();

    @KsAdSdkApi
    @A2egSU
    boolean isVideoSoundEnable();

    @KsAdSdkApi
    @A2egSU
    @Deprecated
    void setDataFlowAutoStart(boolean z);

    @KsAdSdkApi
    @A2egSU
    void setNoCache();

    @KsAdSdkApi
    @A2egSU
    void setVideoAutoPlayType(int i);

    @KsAdSdkApi
    @A2egSU
    void setVideoSoundEnable(boolean z);
}
