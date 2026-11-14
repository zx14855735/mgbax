package com.qq.e.ads.cfg;

import com.qq.e.comm.util.GDTLogger;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class MultiProcessFlag {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static boolean f12757A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public static boolean f12758A4TApA;

    public static boolean isMultiProcess() {
        return f12757A2egSU;
    }

    public static void setMultiProcess(boolean z) {
        if (f12758A4TApA) {
            GDTLogger.w("MultiProcessFlag已经设置过，再次设置无效");
        } else {
            f12758A4TApA = true;
            f12757A2egSU = z;
        }
    }
}
