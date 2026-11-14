package BmvVmW;

import android.graphics.drawable.Icon;
import android.net.Uri;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class AMqCpz {
    public static int A2egSU(Object obj) {
        return ((Icon) obj).getResId();
    }

    public static String A4TApA(Object obj) {
        return ((Icon) obj).getResPackage();
    }

    public static Uri A5SV6n(Object obj) {
        return ((Icon) obj).getUri();
    }

    public static int getType(Object obj) {
        return ((Icon) obj).getType();
    }
}
