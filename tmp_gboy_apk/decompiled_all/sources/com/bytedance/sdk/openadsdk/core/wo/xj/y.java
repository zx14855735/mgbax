package com.bytedance.sdk.openadsdk.core.wo.xj;

import com.bytedance.sdk.openadsdk.TTAdLoadType;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class y {
    private static Boolean xj;

    private static boolean xj() {
        if (xj == null) {
            try {
                TTAdLoadType tTAdLoadType = TTAdLoadType.UNKNOWN;
                xj = Boolean.TRUE;
            } catch (Throwable unused) {
                xj = Boolean.FALSE;
            }
        }
        return xj.booleanValue();
    }

    public static int xj(Object obj) {
        if (obj == null) {
            return -1;
        }
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        if (xj()) {
            try {
                if (TTAdLoadType.LOAD == obj) {
                    return 3;
                }
                if (TTAdLoadType.PRELOAD == obj) {
                    return 1;
                }
                TTAdLoadType tTAdLoadType = TTAdLoadType.UNKNOWN;
            } catch (Throwable unused) {
            }
        }
        return -1;
    }
}
