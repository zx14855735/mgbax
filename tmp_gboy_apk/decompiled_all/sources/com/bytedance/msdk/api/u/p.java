package com.bytedance.msdk.api.u;

import com.bytedance.sdk.openadsdk.mediation.MediationConstant;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class p {
    public String hf;
    public String u;
    public String w;
    public int xj;

    public String hf() {
        return this.hf;
    }

    public String kd() {
        switch (this.xj) {
            case 1:
                return MediationConstant.ADN_PANGLE;
            case 2:
                return MediationConstant.ADN_ADMOB;
            case 3:
                return "gdt";
            case 4:
                return MediationConstant.ADN_MINTEGRAL;
            case 5:
                return MediationConstant.ADN_UNITY;
            case 6:
                return "baidu";
            case 7:
                return "ks";
            case 8:
                return "sigmob";
            case 9:
                return MediationConstant.ADN_KLEVIN;
            case 10:
                return MediationConstant.ADN_XIAOMI;
            default:
                return "";
        }
    }

    public String u() {
        return this.u;
    }

    public String w() {
        return this.w;
    }

    public int xj() {
        return this.xj;
    }
}
