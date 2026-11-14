package com.bytedance.sdk.openadsdk.core.am;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.bytedance.pangle.annotations.ForbidWrapParam;
import java.lang.ref.WeakReference;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class f {

    public interface xj {
        void xj();

        void xj(String str);

        void xj(boolean z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj() {
        com.bytedance.sdk.openadsdk.core.a.xj u = com.bytedance.sdk.openadsdk.core.f.zg().u();
        if (u == null) {
            return;
        }
        u.xj((Application.ActivityLifecycleCallbacks) null);
    }

    public void xj(final xj xjVar) {
        com.bytedance.sdk.openadsdk.core.a.xj u;
        if (xjVar == null || (u = com.bytedance.sdk.openadsdk.core.f.zg().u()) == null) {
            return;
        }
        u.xj(new Application.ActivityLifecycleCallbacks() { // from class: com.bytedance.sdk.openadsdk.core.am.f.1
            private WeakReference<Object> w;

            private boolean xj(@ForbidWrapParam Activity activity) {
                WeakReference<Object> weakReference;
                return (activity == null || (weakReference = this.w) == null || activity != weakReference.get()) ? false : true;
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(@ForbidWrapParam Activity activity, Bundle bundle) {
                f.this.xj();
                xjVar.xj("create");
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(@ForbidWrapParam Activity activity) {
                f.this.xj();
                xjVar.xj("destroy");
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(@ForbidWrapParam Activity activity) {
                this.w = new WeakReference<>(activity);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(@ForbidWrapParam Activity activity) {
                f.this.xj();
                xjVar.xj();
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivitySaveInstanceState(@ForbidWrapParam Activity activity, Bundle bundle) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(@ForbidWrapParam Activity activity) {
                f.this.xj();
                xjVar.xj("start");
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(@ForbidWrapParam Activity activity) {
                f.this.xj();
                xjVar.xj(xj(activity));
            }
        });
    }
}
