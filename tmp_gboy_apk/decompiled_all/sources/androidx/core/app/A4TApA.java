package androidx.core.app;

import android.app.Activity;
import android.app.SharedElementCallback;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class A4TApA {
    public static void A2egSU(Object obj) {
        ((SharedElementCallback.OnSharedElementsReadyListener) obj).onSharedElementsReady();
    }

    public static boolean A4TApA(Activity activity, String str) {
        return activity.shouldShowRequestPermissionRationale(str);
    }

    public static void requestPermissions(Activity activity, String[] strArr, int i) {
        activity.requestPermissions(strArr, i);
    }
}
