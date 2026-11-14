package com.bytedance.sdk.component.xj;

import ADYaiT.CtFAbx;
import android.text.TextUtils;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
class dk {
    private static boolean xj;

    public static String xj(Throwable th) {
        return CtFAbx.AZkASS("}", th instanceof yo ? ((yo) th).xj : 0, new StringBuilder("{\"code\":"));
    }

    public static String xj(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return "{\"code\":1}";
        }
        if (xj) {
            str2 = CtFAbx.AMqCpz(1, 1, str);
        } else {
            str2 = "";
        }
        String BChYOn2 = CtFAbx.BChYOn("{\"code\":1,\"__data\":", str);
        if (!str2.isEmpty()) {
            return BChYOn2 + "," + str2 + "}";
        }
        return CtFAbx.AcNBzu(BChYOn2, "}");
    }

    public static String xj() {
        return "";
    }

    public static void xj(boolean z) {
        xj = z;
    }
}
