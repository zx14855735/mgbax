package com.bytedance.sdk.openadsdk.w;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.lang.ref.WeakReference;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
class xj implements Application.ActivityLifecycleCallbacks {
    private static volatile boolean xj;
    private int hf = 0;
    private InterfaceC0209xj u;
    private volatile WeakReference<Activity> w;

    /* renamed from: com.bytedance.sdk.openadsdk.w.xj$xj, reason: collision with other inner class name */
    public interface InterfaceC0209xj {
        void hf();

        void xj();
    }

    public Activity hf() {
        if (this.w == null) {
            return null;
        }
        return this.w.get();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        this.w = new WeakReference<>(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        this.hf++;
        xj = false;
        InterfaceC0209xj interfaceC0209xj = this.u;
        if (interfaceC0209xj != null) {
            interfaceC0209xj.hf();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        int i = this.hf - 1;
        this.hf = i;
        if (i == 0) {
            xj = true;
            InterfaceC0209xj interfaceC0209xj = this.u;
            if (interfaceC0209xj != null) {
                interfaceC0209xj.xj();
            }
        }
    }

    public Boolean xj() {
        return Boolean.valueOf(xj);
    }

    public void xj(InterfaceC0209xj interfaceC0209xj) {
        this.u = interfaceC0209xj;
    }
}
