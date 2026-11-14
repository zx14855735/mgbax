package com.bytedance.adsdk.lottie.kd;

import ADYaiT.CtFAbx;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class w {
    private static float hf(float f) {
        return f <= 0.04045f ? f / 12.92f : (float) Math.pow((f + 0.055f) / 1.055f, 2.4000000953674316d);
    }

    private static float xj(float f) {
        return f <= 0.0031308f ? f * 12.92f : (float) ((Math.pow(f, 0.4166666567325592d) * 1.0549999475479126d) - 0.054999999701976776d);
    }

    public static int xj(float f, int i, int i2) {
        if (i == i2) {
            return i;
        }
        float f2 = ((i >> 24) & 255) / 255.0f;
        float f3 = ((i2 >> 24) & 255) / 255.0f;
        float hf = hf(((i >> 16) & 255) / 255.0f);
        float hf2 = hf(((i >> 8) & 255) / 255.0f);
        float hf3 = hf((i & 255) / 255.0f);
        float hf4 = hf(((i2 >> 16) & 255) / 255.0f);
        float hf5 = hf(((i2 >> 8) & 255) / 255.0f);
        float hf6 = hf((i2 & 255) / 255.0f);
        float A4TApA2 = CtFAbx.A4TApA(f3, f2, f, f2);
        float A4TApA3 = CtFAbx.A4TApA(hf4, hf, f, hf);
        float A4TApA4 = CtFAbx.A4TApA(hf5, hf2, f, hf2);
        float A4TApA5 = CtFAbx.A4TApA(hf6, hf3, f, hf3);
        float xj = xj(A4TApA3) * 255.0f;
        float xj2 = xj(A4TApA4) * 255.0f;
        return Math.round(xj(A4TApA5) * 255.0f) | (Math.round(xj) << 16) | (Math.round(A4TApA2 * 255.0f) << 24) | (Math.round(xj2) << 8);
    }
}
