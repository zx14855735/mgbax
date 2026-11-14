package androidx.core.app;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AZOQYO implements Application.ActivityLifecycleCallbacks {

    /* renamed from: A2egSU, reason: collision with root package name */
    public Object f8473A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public Activity f8474A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final int f8475A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public boolean f8476ADYaiT = false;
    public boolean AMqCpz = false;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public boolean f8477ARc23Z = false;

    public AZOQYO(Activity activity) {
        this.f8474A4TApA = activity;
        this.f8475A5SV6n = activity.hashCode();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        if (this.f8474A4TApA == activity) {
            this.f8474A4TApA = null;
            this.AMqCpz = true;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        if (!this.AMqCpz || this.f8477ARc23Z || this.f8476ADYaiT) {
            return;
        }
        Object obj = this.f8473A2egSU;
        try {
            Object obj2 = AZkASS.f8480A5SV6n.get(activity);
            if (obj2 == obj && activity.hashCode() == this.f8475A5SV6n) {
                AZkASS.f8483ASJ6gh.postAtFrontOfQueue(new MOpbMP.A2egSU(AZkASS.f8479A4TApA.get(activity), obj2, 20, false));
                this.f8477ARc23Z = true;
                this.f8473A2egSU = null;
            }
        } catch (Throwable unused) {
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        if (this.f8474A4TApA == activity) {
            this.f8476ADYaiT = true;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }
}
