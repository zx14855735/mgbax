package com.bytedance.sdk.openadsdk.mediation.bridge.custom;

import ADYaiT.CtFAbx;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.api.proto.ValueSet;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class MediationCustomServiceConfig {
    private String hf;
    private String kd;
    private int u;
    private int w;
    private String xj;

    public MediationCustomServiceConfig(String str, String str2, int i, int i2, String str3) {
        this.xj = str;
        this.hf = str2;
        this.w = i;
        this.u = i2;
        this.kd = str3;
    }

    public String getADNNetworkName() {
        return this.xj;
    }

    public String getADNNetworkSlotId() {
        return this.hf;
    }

    public int getAdStyleType() {
        return this.w;
    }

    public String getCustomAdapterJson() {
        return this.kd;
    }

    public int getSubAdtype() {
        return this.u;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("MediationCustomServiceConfig{mADNNetworkName='");
        sb.append(this.xj);
        sb.append("', mADNNetworkSlotId='");
        sb.append(this.hf);
        sb.append("', mAdStyleType=");
        sb.append(this.w);
        sb.append(", mSubAdtype=");
        sb.append(this.u);
        sb.append(", mCustomAdapterJson='");
        return CtFAbx.B25kr6(sb, this.kd, "'}");
    }

    public MediationCustomServiceConfig(ValueSet valueSet) {
        if (valueSet != null) {
            this.xj = valueSet.stringValue(AVMDLDataLoader.KeyIsLiveGetPlayCacheSec);
            this.hf = valueSet.stringValue(2);
            this.w = valueSet.intValue(AVMDLDataLoader.KeyIsLiveMaxTrySwitchP2pTimes);
            this.u = valueSet.intValue(8094);
            this.kd = valueSet.stringValue(8547);
        }
    }
}
