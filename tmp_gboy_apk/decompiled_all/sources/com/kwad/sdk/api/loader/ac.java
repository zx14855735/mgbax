package com.kwad.sdk.api.loader;

import android.os.Build;
import android.os.Process;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
final class ac {
    public static String Cd() {
        return is64Bit() ? "arm64-v8a" : "armeabi-v7a";
    }

    public static boolean is64Bit() {
        boolean is64Bit;
        if (Build.VERSION.SDK_INT >= 23) {
            is64Bit = Process.is64Bit();
            return is64Bit;
        }
        try {
            return ((Boolean) ApiReflect.cz("dalvik.system.VMRuntime").cC("getRuntime").cC("is64Bit").get()).booleanValue();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
