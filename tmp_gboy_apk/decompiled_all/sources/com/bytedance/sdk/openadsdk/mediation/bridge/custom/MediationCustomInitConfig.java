package com.bytedance.sdk.openadsdk.mediation.bridge.custom;

import ADYaiT.CtFAbx;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.api.proto.ValueSet;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class MediationCustomInitConfig {
    private String c;
    private String d;
    private String f;
    private String hf;
    private String kd;
    private String p;
    private String tf;
    private String u;
    private String w;
    private String xj;
    private String y;

    public MediationCustomInitConfig(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        this.w = str;
        this.xj = str2;
        this.hf = str3;
        this.u = str4;
        this.kd = str5;
        this.y = str6;
        this.c = str7;
        this.f = str8;
        this.d = str9;
        this.tf = str10;
        this.p = str11;
    }

    public String getADNName() {
        return this.w;
    }

    public String getAdnInitClassName() {
        return this.u;
    }

    public String getAppId() {
        return this.xj;
    }

    public String getAppKey() {
        return this.hf;
    }

    public String getBannerClassName() {
        return this.kd;
    }

    public String getDrawClassName() {
        return this.p;
    }

    public String getFeedClassName() {
        return this.tf;
    }

    public String getFullVideoClassName() {
        return this.f;
    }

    public String getInterstitialClassName() {
        return this.y;
    }

    public String getRewardClassName() {
        return this.c;
    }

    public String getSplashClassName() {
        return this.d;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("MediationCustomInitConfig{mAppId='");
        sb.append(this.xj);
        sb.append("', mAppKey='");
        sb.append(this.hf);
        sb.append("', mADNName='");
        sb.append(this.w);
        sb.append("', mAdnInitClassName='");
        sb.append(this.u);
        sb.append("', mBannerClassName='");
        sb.append(this.kd);
        sb.append("', mInterstitialClassName='");
        sb.append(this.y);
        sb.append("', mRewardClassName='");
        sb.append(this.c);
        sb.append("', mFullVideoClassName='");
        sb.append(this.f);
        sb.append("', mSplashClassName='");
        sb.append(this.d);
        sb.append("', mFeedClassName='");
        sb.append(this.tf);
        sb.append("', mDrawClassName='");
        return CtFAbx.B25kr6(sb, this.p, "'}");
    }

    public MediationCustomInitConfig(ValueSet valueSet) {
        if (valueSet != null) {
            this.w = valueSet.stringValue(AVMDLDataLoader.KeyIsLiveGetPlayCacheSec);
            this.xj = valueSet.stringValue(8534);
            this.hf = valueSet.stringValue(8535);
            this.u = valueSet.stringValue(8536);
            this.kd = valueSet.stringValue(8537);
            this.y = valueSet.stringValue(8538);
            this.c = valueSet.stringValue(8539);
            this.f = valueSet.stringValue(8540);
            this.d = valueSet.stringValue(8541);
            this.tf = valueSet.stringValue(8542);
            this.p = valueSet.stringValue(8543);
        }
    }
}
