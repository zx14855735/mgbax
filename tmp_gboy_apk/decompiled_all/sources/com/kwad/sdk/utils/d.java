package com.kwad.sdk.utils;

import android.content.Context;
import android.os.Build;
import android.os.Environment;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class d {
    public static boolean cA(Context context) {
        boolean isExternalStorageLegacy;
        try {
            if (context.getApplicationInfo().targetSdkVersion < 29 || Build.VERSION.SDK_INT < 29) {
                return false;
            }
            isExternalStorageLegacy = Environment.isExternalStorageLegacy();
            if (isExternalStorageLegacy) {
                return false;
            }
            return !bc.useStoragePermissionDisable();
        } catch (Throwable unused) {
            return false;
        }
    }
}
