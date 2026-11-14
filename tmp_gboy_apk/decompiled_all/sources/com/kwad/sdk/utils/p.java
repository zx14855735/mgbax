package com.kwad.sdk.utils;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class p {
    public static long bdV;
    public static long sLaunchTime;

    public static long RE() {
        return bdV - sLaunchTime;
    }

    public static String a(StackTraceElement stackTraceElement) {
        return stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName();
    }

    public static void setInitStartTime(long j) {
        bdV = j;
    }

    public static void setLaunchTime(long j) {
        sLaunchTime = j;
    }
}
