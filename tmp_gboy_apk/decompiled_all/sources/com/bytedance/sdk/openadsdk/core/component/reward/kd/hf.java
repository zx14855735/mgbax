package com.bytedance.sdk.openadsdk.core.component.reward.kd;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.a.r;
import com.bytedance.sdk.openadsdk.core.a.tf;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class hf {
    public static float[] xj(Context context, float f, int i) {
        float min;
        float max;
        float u = r.u(context, r.d(context));
        float u2 = r.u(context, r.tf(context));
        if (i == 2) {
            min = Math.max(u, u2);
            max = Math.min(u, u2);
        } else {
            min = Math.min(u, u2);
            max = Math.max(u, u2);
        }
        int u3 = r.u(context, r.p(context));
        if (r.hf() || f != 100.0f) {
            if (i != 2) {
                max -= u3;
            } else {
                if ("SM-A207F".equals(tf.hf())) {
                    u3 *= 2;
                }
                min -= u3;
            }
        }
        return new float[]{min, max};
    }

    public static int[] xj(Context context, float f, float f2, int i) {
        int i2;
        float[] xj = xj(context, f, i);
        float f3 = xj[0];
        float f4 = xj[1];
        int min = (int) (Math.min(f3, f4) * f2);
        if (i != 2) {
            float f5 = min;
            i2 = (int) Math.max((f4 - (((f3 - f5) - f5) / f)) / 2.0f, 0.0f);
        } else {
            float f6 = min;
            min = (int) Math.max((f3 - (((f4 - f6) - f6) * f)) / 2.0f, 0.0f);
            i2 = min;
        }
        return new int[]{min, i2, min, i2};
    }
}
