package com.kwad.components.core.proxy;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import androidx.lifecycle.AlLFFp;
import java.util.HashSet;
import java.util.Set;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class b implements Application.ActivityLifecycleCallbacks {
    private k ZO;
    private Set<c> ZP = new HashSet();

    public b(k kVar) {
        this.ZO = kVar;
    }

    private c c(Activity activity) {
        for (c cVar : this.ZP) {
            if (cVar.d(activity)) {
                return cVar;
            }
        }
        return null;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        c c = c(activity);
        if (c != null) {
            c.a(AlLFFp.ON_CREATE);
            k kVar = this.ZO;
            if (kVar != null) {
                kVar.a(c);
            }
        }
        com.kwad.sdk.core.d.c.d("ActivityLifecycleAdapter", "onActivityCreated : " + activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        c c = c(activity);
        if (c != null) {
            k kVar = this.ZO;
            if (kVar != null) {
                kVar.f(c);
            }
            this.ZP.remove(c);
        }
        com.kwad.sdk.core.d.c.d("ActivityLifecycleAdapter", "onActivityDestroyed : " + activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        c c = c(activity);
        if (c != null) {
            c.a(AlLFFp.ON_PAUSE);
            k kVar = this.ZO;
            if (kVar != null) {
                kVar.d(c);
            }
        }
        com.kwad.sdk.core.d.c.d("ActivityLifecycleAdapter", "onActivityPaused : " + activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPreCreated(Activity activity, Bundle bundle) {
        this.ZP.add(new c(activity));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        c c = c(activity);
        if (c != null) {
            c.a(AlLFFp.ON_RESUME);
            k kVar = this.ZO;
            if (kVar != null) {
                kVar.c(c);
            }
        }
        com.kwad.sdk.core.d.c.d("ActivityLifecycleAdapter", "onActivityResumed : " + activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        c c = c(activity);
        if (c != null) {
            c.a(AlLFFp.ON_START);
            k kVar = this.ZO;
            if (kVar != null) {
                kVar.b(c);
            }
        }
        com.kwad.sdk.core.d.c.d("ActivityLifecycleAdapter", "onActivityStarted : " + activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        c c = c(activity);
        if (c != null) {
            c.a(AlLFFp.ON_STOP);
            k kVar = this.ZO;
            if (kVar != null) {
                kVar.e(c);
            }
        }
        com.kwad.sdk.core.d.c.d("ActivityLifecycleAdapter", "onActivityStopped : " + activity);
    }
}
