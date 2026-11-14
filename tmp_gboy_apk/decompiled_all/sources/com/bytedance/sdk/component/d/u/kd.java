package com.bytedance.sdk.component.d.u;

import com.bytedance.sdk.component.utils.pl;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class kd {
    private static int hf = 4;
    private static boolean xj;

    public static boolean xj() {
        return xj;
    }

    public static void xj(String str, String str2) {
        if (xj && str2 != null && hf <= 4) {
            pl.xj(pl.u(str), str2);
        }
    }
}
