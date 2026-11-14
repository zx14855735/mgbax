package androidx.core.app;

import android.app.Activity;
import android.app.SharedElementCallback;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class A2egSU {
    public static void A2egSU(Activity activity) {
        activity.finishAfterTransition();
    }

    public static void A4TApA(Activity activity) {
        activity.postponeEnterTransition();
    }

    public static void A5SV6n(Activity activity, SharedElementCallback sharedElementCallback) {
        activity.setEnterSharedElementCallback(sharedElementCallback);
    }

    public static void ADYaiT(Activity activity, SharedElementCallback sharedElementCallback) {
        activity.setExitSharedElementCallback(sharedElementCallback);
    }

    public static void AMqCpz(Activity activity) {
        activity.startPostponedEnterTransition();
    }
}
