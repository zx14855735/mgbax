package com.kwad.sdk.api;

import A5SV6n.A2egSU;
import com.kwad.sdk.api.core.KsAdSdkApi;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@KsAdSdkApi
@A2egSU
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public interface KsInnerAd {

    @KsAdSdkApi
    @A2egSU
    public interface KsInnerAdInteractionListener {
        @KsAdSdkApi
        @A2egSU
        void onAdClicked(KsInnerAd ksInnerAd);

        @KsAdSdkApi
        @A2egSU
        void onAdShow(KsInnerAd ksInnerAd);
    }

    @A2egSU
    @Retention(RetentionPolicy.SOURCE)
    public @interface KsInnerAdType {
        public static final int AGGREGATION = 1;
        public static final int REFLOW = 2;
        public static final int UNKNOWN = 0;
    }

    int getType();
}
