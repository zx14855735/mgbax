package com.bytedance.sdk.openadsdk.mediation.ad;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class MediationSplashRequestInfo implements IMediationSplashRequestInfo {
    private String hf;
    private String u;
    private String w;
    private String xj;

    public MediationSplashRequestInfo(String str, String str2, String str3, String str4) {
        this.xj = str;
        this.hf = str2;
        this.w = str3;
        this.u = str4;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationSplashRequestInfo
    public String getAdnName() {
        return this.xj;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationSplashRequestInfo
    public String getAdnSlotId() {
        return this.hf;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationSplashRequestInfo
    public String getAppId() {
        return this.w;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationSplashRequestInfo
    public String getAppkey() {
        return this.u;
    }
}
