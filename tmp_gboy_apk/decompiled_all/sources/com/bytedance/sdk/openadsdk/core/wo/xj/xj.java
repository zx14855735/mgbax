package com.bytedance.sdk.openadsdk.core.wo.xj;

import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xj {
    private static Boolean xj;

    private static boolean xj() {
        if (xj == null) {
            try {
                MediationConstant.AdIsReadyStatus adIsReadyStatus = MediationConstant.AdIsReadyStatus.ADN_NO_READY_API;
                xj = Boolean.TRUE;
            } catch (Throwable unused) {
                xj = Boolean.FALSE;
            }
        }
        return xj.booleanValue();
    }

    public static Integer xj(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Integer) {
            return (Integer) obj;
        }
        try {
            if (xj()) {
                if (obj == MediationConstant.AdIsReadyStatus.ADN_NO_READY_API) {
                    return 1;
                }
                if (obj == MediationConstant.AdIsReadyStatus.AD_IS_READY) {
                    return 2;
                }
                if (obj == MediationConstant.AdIsReadyStatus.AD_IS_EXPIRED) {
                    return 3;
                }
                if (obj == MediationConstant.AdIsReadyStatus.AD_IS_NOT_READY) {
                    return 4;
                }
            }
        } catch (Throwable th) {
            pl.xj(th);
        }
        return null;
    }
}
