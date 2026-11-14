package com.bytedance.msdk.xj.kd;

import java.util.IllegalFormatException;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class u {
    public static void xj(Object obj) {
        xj(obj, true, "Object can not be null.", "");
    }

    private static boolean xj(Object obj, boolean z, String str, Object... objArr) {
        if (obj != null) {
            return true;
        }
        String xj = xj(str, objArr);
        if (z) {
            throw new NullPointerException(xj);
        }
        w.u("TTMediationSDK_ADAPTER", xj);
        return false;
    }

    private static String xj(String str, Object... objArr) {
        String valueOf = String.valueOf(str);
        try {
            return String.format(valueOf, objArr);
        } catch (IllegalFormatException e) {
            w.u("TTMediationSDK_ADAPTER", "MoPub preconditions had a format exception: " + e.getMessage());
            return valueOf;
        }
    }
}
