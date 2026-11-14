package com.bytedance.sdk.openadsdk.core.pz;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class hf {
    public static boolean hf(long j) {
        return xj(j, xj.USE_PITAYA.xj());
    }

    public static boolean xj(long j, long j2) {
        return (j & j2) == j2;
    }

    public static boolean xj(long j) {
        return xj(j, xj.USE_ALOG.xj());
    }
}
