package com.bytedance.sdk.openadsdk.core.y;

import com.bytedance.sdk.openadsdk.core.pz;
import java.util.Random;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class hf {
    private static volatile boolean hf;
    private static volatile Random xj;

    public static void hf() {
        xj(pz.hf().eu(), true);
    }

    private static Random w() {
        if (xj != null) {
            return xj;
        }
        Random w = com.bytedance.sdk.component.utils.xj.w();
        xj = w;
        return w;
    }

    public static boolean xj() {
        return hf;
    }

    public static boolean xj(float f, boolean z) {
        if (f <= 0.0f) {
            if (z) {
                hf = false;
            }
            return false;
        }
        int nextInt = w().nextInt(100);
        int i = (int) (f * 100.0f);
        if (z) {
            hf = nextInt < i;
        }
        return nextInt < i;
    }
}
