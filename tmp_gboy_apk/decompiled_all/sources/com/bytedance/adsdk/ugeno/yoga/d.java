package com.bytedance.adsdk.ugeno.yoga;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class d {
    public static long xj(float f, float f2) {
        return Float.floatToRawIntBits(f2) | (Float.floatToRawIntBits(f) << 32);
    }

    public static long xj(int i, int i2) {
        return xj(i, i2);
    }
}
