package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aauaaaaa;

import android.content.Context;
import android.os.Build;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public abstract class aaaaaaao {
    public static boolean aaaaaaaa(Context context) {
        int i = Build.VERSION.SDK_INT;
        return (i >= 29 && context.getApplicationInfo().targetSdkVersion >= 29) || i >= 30;
    }
}
