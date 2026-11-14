package com.bytedance.sdk.openadsdk.core.wo.xj;

import com.bytedance.sdk.openadsdk.mediation.MediationConstant;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class hf {
    private static Boolean xj;

    private static boolean xj() {
        if (xj == null) {
            try {
                MediationConstant.BiddingLossReason biddingLossReason = MediationConstant.BiddingLossReason.LOW_PRICE;
                xj = Boolean.TRUE;
            } catch (Throwable unused) {
                xj = Boolean.FALSE;
            }
        }
        return xj.booleanValue();
    }

    public static Object xj(int i) {
        if (!xj()) {
            return Integer.valueOf(i);
        }
        try {
            if (i == 1) {
                return MediationConstant.BiddingLossReason.LOW_PRICE;
            }
            if (i == 2) {
                return MediationConstant.BiddingLossReason.TIME_OUT;
            }
            if (i == 3) {
                return MediationConstant.BiddingLossReason.NO_AD;
            }
            if (i == 4) {
                return MediationConstant.BiddingLossReason.AD_DATA_ERROR;
            }
            if (i != 10001) {
                return null;
            }
            return MediationConstant.BiddingLossReason.OTHER;
        } catch (Throwable unused) {
            return null;
        }
    }
}
