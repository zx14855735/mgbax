package com.kwad.sdk.api.model;

import A5SV6n.A2egSU;
import com.kwad.sdk.api.core.KsAdSdkApi;

@KsAdSdkApi
@A2egSU
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class KSAdRewardRetryTaskResult {
    public int conversionStatus;
    public KSAdInfoData ksAdInfoData;

    public KSAdRewardRetryTaskResult(KSAdInfoData kSAdInfoData) {
        this.conversionStatus = 0;
        this.ksAdInfoData = kSAdInfoData;
    }

    public KSAdRewardRetryTaskResult(KSAdInfoData kSAdInfoData, int i) {
        this.ksAdInfoData = kSAdInfoData;
        this.conversionStatus = i;
    }
}
