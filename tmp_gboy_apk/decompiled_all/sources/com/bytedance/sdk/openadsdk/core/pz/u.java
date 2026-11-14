package com.bytedance.sdk.openadsdk.core.pz;

import com.bytedance.sdk.openadsdk.core.f;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class u extends com.bytedance.sdk.openadsdk.am.xj {
    private com.bytedance.sdk.openadsdk.am.u kd() {
        String y = com.bytedance.sdk.openadsdk.core.f.xj.y();
        y.getClass();
        switch (y) {
            case "2g":
                return com.bytedance.sdk.openadsdk.am.u.TYPE_2G;
            case "3g":
                return com.bytedance.sdk.openadsdk.am.u.TYPE_3G;
            case "4g":
                return com.bytedance.sdk.openadsdk.am.u.TYPE_4G;
            case "5g":
                return com.bytedance.sdk.openadsdk.am.u.TYPE_5G;
            case "wifi":
                return com.bytedance.sdk.openadsdk.am.u.TYPE_WIFI;
            default:
                return com.bytedance.sdk.openadsdk.am.u.TYPE_UNKNOWN;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.am.xj
    public boolean hf() {
        return f.zg().kd();
    }

    @Override // com.bytedance.sdk.openadsdk.am.xj
    public com.bytedance.sdk.openadsdk.am.u u() {
        return kd();
    }

    @Override // com.bytedance.sdk.openadsdk.am.xj
    public boolean w() {
        return super.w();
    }
}
