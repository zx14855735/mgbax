package com.bytedance.adsdk.ugeno.swiper;

import java.util.Collection;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class hf {
    public static int xj(boolean z, int i, int i2) {
        if (i2 == 0 || !z) {
            return i;
        }
        int i3 = i - 512;
        int abs = Math.abs(i3) % i2;
        return (i3 >= 0 || abs == 0) ? abs : i2 - abs;
    }

    public static boolean xj(int i, Collection<?> collection) {
        return i >= 0 && i < collection.size();
    }
}
