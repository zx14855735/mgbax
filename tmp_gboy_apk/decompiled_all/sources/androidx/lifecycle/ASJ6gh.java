package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class ASJ6gh implements Application.ActivityLifecycleCallbacks {
    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        RXb0Sz.ARc23Z.AMqCpz(activity, TTDownloadField.TT_ACTIVITY);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        RXb0Sz.ARc23Z.AMqCpz(activity, TTDownloadField.TT_ACTIVITY);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        RXb0Sz.ARc23Z.AMqCpz(activity, TTDownloadField.TT_ACTIVITY);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        RXb0Sz.ARc23Z.AMqCpz(activity, TTDownloadField.TT_ACTIVITY);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        RXb0Sz.ARc23Z.AMqCpz(activity, TTDownloadField.TT_ACTIVITY);
        RXb0Sz.ARc23Z.AMqCpz(bundle, "outState");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        RXb0Sz.ARc23Z.AMqCpz(activity, TTDownloadField.TT_ACTIVITY);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        RXb0Sz.ARc23Z.AMqCpz(activity, TTDownloadField.TT_ACTIVITY);
    }
}
