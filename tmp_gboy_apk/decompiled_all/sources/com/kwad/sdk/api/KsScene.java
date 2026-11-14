package com.kwad.sdk.api;

import A5SV6n.A2egSU;
import com.kwad.sdk.api.core.KsAdSdkApi;
import com.kwad.sdk.api.loader.Loader;
import com.kwad.sdk.api.model.IKsAdLabel;
import com.kwad.sdk.api.model.NativeAdExtraData;
import com.kwad.sdk.api.model.SplashAdExtraData;
import java.io.Serializable;
import java.util.Map;
import org.json.JSONObject;

@KsAdSdkApi
@A2egSU
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public interface KsScene extends Serializable {

    @KsAdSdkApi
    @A2egSU
    public static class Builder {
        private KsScene scene;

        @KsAdSdkApi
        @A2egSU
        public Builder(long j) {
            KsScene ksScene = (KsScene) Loader.get().newInstance(KsScene.class);
            this.scene = ksScene;
            ksScene.setPosId(j);
        }

        @KsAdSdkApi
        @A2egSU
        public Builder action(int i) {
            this.scene.setAction(i);
            return this;
        }

        @KsAdSdkApi
        @A2egSU
        public Builder adLabel(com.kwad.sdk.api.model.a aVar) {
            this.scene.setKsAdLabel(aVar);
            return this;
        }

        @KsAdSdkApi
        @A2egSU
        public Builder adNum(int i) {
            this.scene.setAdNum(i);
            return this;
        }

        @KsAdSdkApi
        @A2egSU
        public KsScene build() {
            return this.scene;
        }

        @KsAdSdkApi
        @A2egSU
        public Builder height(int i) {
            this.scene.setHeight(i);
            return this;
        }

        @KsAdSdkApi
        @A2egSU
        public Builder posId(long j) {
            this.scene.setPosId(j);
            return this;
        }

        @KsAdSdkApi
        @A2egSU
        public Builder promoteId(String str) {
            this.scene.setPromoteId(str);
            return this;
        }

        @KsAdSdkApi
        @A2egSU
        public Builder rewardCallbackExtraData(Map<String, String> map) {
            this.scene.setRewardCallbackExtraData(map);
            return this;
        }

        @KsAdSdkApi
        @A2egSU
        public Builder screenOrientation(int i) {
            this.scene.setScreenOrientation(i);
            return this;
        }

        @KsAdSdkApi
        @A2egSU
        public Builder setBackUrl(String str) {
            this.scene.setBackUrl(str);
            return this;
        }

        @KsAdSdkApi
        @A2egSU
        public Builder setBidResponse(String str) {
            this.scene.setBidResponse(str);
            return this;
        }

        @KsAdSdkApi
        @A2egSU
        public Builder setBidResponseV2(String str) {
            this.scene.setBidResponseV2(str);
            return this;
        }

        @KsAdSdkApi
        @A2egSU
        public Builder setComment(String str) {
            this.scene.setComment(str);
            return this;
        }

        @KsAdSdkApi
        @A2egSU
        public Builder setNativeAdExtraData(NativeAdExtraData nativeAdExtraData) {
            this.scene.setNativeAdExtraData(nativeAdExtraData);
            return this;
        }

        @KsAdSdkApi
        @A2egSU
        public Builder setSensorType(int i) {
            this.scene.setSensorType(i);
            return this;
        }

        @KsAdSdkApi
        @A2egSU
        public Builder setSplashExtraData(SplashAdExtraData splashAdExtraData) {
            this.scene.setSplashExtraData(splashAdExtraData);
            return this;
        }

        @KsAdSdkApi
        @A2egSU
        public Builder setUserCommRateBuying(int i) {
            this.scene.setUserCommRateBuying(i);
            return this;
        }

        @KsAdSdkApi
        @A2egSU
        public Builder setUserCommRateSharing(int i) {
            this.scene.setUserCommRateSharing(i);
            return this;
        }

        @KsAdSdkApi
        @A2egSU
        public Builder width(int i) {
            this.scene.setWidth(i);
            return this;
        }
    }

    @KsAdSdkApi
    @A2egSU
    int getAction();

    @KsAdSdkApi
    @A2egSU
    int getAdNum();

    @KsAdSdkApi
    @A2egSU
    int getAdStyle();

    @KsAdSdkApi
    @A2egSU
    String getBackUrl();

    @KsAdSdkApi
    @A2egSU
    String getBidResponse();

    @KsAdSdkApi
    @A2egSU
    String getBidResponseV2();

    @KsAdSdkApi
    @A2egSU
    String getComment();

    @KsAdSdkApi
    @A2egSU
    int getHeight();

    @KsAdSdkApi
    @A2egSU
    long getPosId();

    @KsAdSdkApi
    @A2egSU
    String getPromoteId();

    @KsAdSdkApi
    @A2egSU
    Map<String, String> getRewardCallbackExtraData();

    @KsAdSdkApi
    @A2egSU
    int getScreenOrientation();

    @KsAdSdkApi
    @A2egSU
    long getUserCommRateBuying();

    @KsAdSdkApi
    @A2egSU
    long getUserCommRateSharing();

    @KsAdSdkApi
    @A2egSU
    int getWidth();

    @KsAdSdkApi
    @A2egSU
    void setAction(int i);

    @KsAdSdkApi
    @A2egSU
    void setAdNum(int i);

    @KsAdSdkApi
    @A2egSU
    void setAdStyle(int i);

    @KsAdSdkApi
    @A2egSU
    void setBackUrl(String str);

    @KsAdSdkApi
    @A2egSU
    void setBidResponse(String str);

    @KsAdSdkApi
    @A2egSU
    void setBidResponseV2(String str);

    @KsAdSdkApi
    @A2egSU
    void setComment(String str);

    @KsAdSdkApi
    @A2egSU
    void setHeight(int i);

    @KsAdSdkApi
    @A2egSU
    void setKsAdLabel(IKsAdLabel iKsAdLabel);

    @KsAdSdkApi
    @A2egSU
    void setNativeAdExtraData(NativeAdExtraData nativeAdExtraData);

    @KsAdSdkApi
    @A2egSU
    void setPosId(long j);

    @KsAdSdkApi
    @A2egSU
    void setPromoteId(String str);

    @KsAdSdkApi
    @A2egSU
    void setRewardCallbackExtraData(Map<String, String> map);

    @KsAdSdkApi
    @A2egSU
    void setScreenOrientation(int i);

    @KsAdSdkApi
    @A2egSU
    void setSensorType(int i);

    @KsAdSdkApi
    @A2egSU
    void setSplashExtraData(SplashAdExtraData splashAdExtraData);

    @KsAdSdkApi
    @A2egSU
    void setUserCommRateBuying(int i);

    @KsAdSdkApi
    @A2egSU
    void setUserCommRateSharing(int i);

    @KsAdSdkApi
    @A2egSU
    void setWidth(int i);

    @KsAdSdkApi
    @A2egSU
    JSONObject toJson();
}
