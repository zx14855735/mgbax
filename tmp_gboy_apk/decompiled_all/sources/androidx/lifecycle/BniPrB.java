package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class BniPrB {
    public static final void A2egSU(Activity activity, Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        RXb0Sz.ARc23Z.AMqCpz(activity, TTDownloadField.TT_ACTIVITY);
        RXb0Sz.ARc23Z.AMqCpz(activityLifecycleCallbacks, "callback");
        activity.registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
    }
}
