package com.bytedance.pangle.kd;

import com.bytedance.pangle.y;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class kd {
    private static y xj;

    public static void hf(Runnable runnable) {
        xj.hf(runnable);
    }

    public static void w(Runnable runnable) {
        xj.w(runnable);
    }

    public static void xj(y yVar) {
        xj = yVar;
    }

    public static void xj(Runnable runnable, boolean z) {
        if (z) {
            xj(runnable);
        } else {
            hf(runnable);
        }
    }

    public static void xj(Runnable runnable) {
        xj.xj(runnable);
    }
}
