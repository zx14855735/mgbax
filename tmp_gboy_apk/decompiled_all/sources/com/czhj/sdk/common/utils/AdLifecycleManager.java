package com.czhj.sdk.common.utils;

import android.app.Activity;
import android.app.Application;
import android.os.Build;
import android.os.Bundle;
import android.view.WindowInsets;
import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.logger.SigmobLog;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class AdLifecycleManager {
    private static AdLifecycleManager b;

    /* renamed from: a, reason: collision with root package name */
    private final Set<WeakReference<LifecycleListener>> f10587a = new HashSet();
    private boolean c;

    public interface LifecycleListener {
        void onCreate(Activity activity);

        void onDestroy(Activity activity);

        void onPause(Activity activity);

        void onResume(Activity activity);

        void onStart(Activity activity);

        void onStop(Activity activity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(Activity activity) {
        try {
            Iterator it = new CopyOnWriteArraySet(this.f10587a).iterator();
            while (it.hasNext()) {
                LifecycleListener lifecycleListener = (LifecycleListener) ((WeakReference) it.next()).get();
                if (lifecycleListener != null) {
                    lifecycleListener.onCreate(activity);
                }
            }
        } catch (Throwable unused) {
        }
    }

    private synchronized WeakReference<LifecycleListener> b(LifecycleListener lifecycleListener) {
        try {
            Iterator it = new CopyOnWriteArraySet(this.f10587a).iterator();
            while (it.hasNext()) {
                WeakReference<LifecycleListener> weakReference = (WeakReference) it.next();
                if (weakReference.get() == lifecycleListener) {
                    return weakReference;
                }
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void c(Activity activity) {
        try {
            Iterator it = new CopyOnWriteArraySet(this.f10587a).iterator();
            while (it.hasNext()) {
                LifecycleListener lifecycleListener = (LifecycleListener) ((WeakReference) it.next()).get();
                if (lifecycleListener != null) {
                    lifecycleListener.onPause(activity);
                }
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void d(Activity activity) {
        try {
            Iterator it = new CopyOnWriteArraySet(this.f10587a).iterator();
            while (it.hasNext()) {
                LifecycleListener lifecycleListener = (LifecycleListener) ((WeakReference) it.next()).get();
                if (lifecycleListener != null) {
                    lifecycleListener.onResume(activity);
                }
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void e(Activity activity) {
        try {
            Iterator it = new CopyOnWriteArraySet(this.f10587a).iterator();
            while (it.hasNext()) {
                LifecycleListener lifecycleListener = (LifecycleListener) ((WeakReference) it.next()).get();
                if (lifecycleListener != null) {
                    lifecycleListener.onStop(activity);
                }
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void f(Activity activity) {
        try {
            Iterator it = new CopyOnWriteArraySet(this.f10587a).iterator();
            while (it.hasNext()) {
                LifecycleListener lifecycleListener = (LifecycleListener) ((WeakReference) it.next()).get();
                if (lifecycleListener != null) {
                    lifecycleListener.onDestroy(activity);
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static AdLifecycleManager getInstance() {
        if (b == null) {
            synchronized (AdLifecycleManager.class) {
                try {
                    if (b == null) {
                        b = new AdLifecycleManager();
                    }
                } finally {
                }
            }
        }
        return b;
    }

    public void addLifecycleListener(LifecycleListener lifecycleListener) {
        if (lifecycleListener == null || this.f10587a == null || a(lifecycleListener)) {
            return;
        }
        this.f10587a.add(new WeakReference<>(lifecycleListener));
    }

    public void initialize(Application application) {
        try {
            if (this.c) {
                return;
            }
            a(application);
            this.c = true;
        } catch (Throwable th) {
            SigmobLog.e(th.getMessage());
        }
    }

    public void removeLifecycleListener(LifecycleListener lifecycleListener) {
        WeakReference<LifecycleListener> b2;
        if (lifecycleListener == null || this.f10587a == null || (b2 = b(lifecycleListener)) == null) {
            return;
        }
        this.f10587a.remove(b2);
    }

    private void a(Application application) {
        if (application == null) {
            SigmobLog.e("activityCallBack error, application is null");
        } else {
            application.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() { // from class: com.czhj.sdk.common.utils.AdLifecycleManager.1
                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityCreated(Activity activity, Bundle bundle) {
                    SigmobLog.d("onActivityCreated() called with: activity = [" + activity + "], savedInstanceState = [" + bundle + "]");
                    AdLifecycleManager.this.a(activity);
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityDestroyed(Activity activity) {
                    SigmobLog.d("onActivityDestroyed() called with: activity = [" + activity + "]");
                    AdLifecycleManager.this.f(activity);
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityPaused(Activity activity) {
                    SigmobLog.d("onActivityPaused() called with: activity = [" + activity + "]");
                    AdLifecycleManager.this.c(activity);
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityResumed(Activity activity) {
                    WindowInsets rootWindowInsets;
                    SigmobLog.d("onActivityResumed() called with: activity = [" + activity + "]");
                    if (Build.VERSION.SDK_INT >= 23) {
                        rootWindowInsets = activity.getWindow().getDecorView().getRootWindowInsets();
                        ClientMetadata.getInstance().setWindInsets(rootWindowInsets);
                    }
                    AdLifecycleManager.this.d(activity);
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                    SigmobLog.d("onActivitySaveInstanceState() called with: activity = [" + activity + "], outState = [" + bundle + "]");
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityStarted(Activity activity) {
                    SigmobLog.d("onActivityStarted() called with: activity = [" + activity + "]");
                    AdLifecycleManager.this.b(activity);
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityStopped(Activity activity) {
                    SigmobLog.d("onActivityStopped() called with: activity = [" + activity + "]");
                    AdLifecycleManager.this.e(activity);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b(Activity activity) {
        try {
            Iterator it = new CopyOnWriteArraySet(this.f10587a).iterator();
            while (it.hasNext()) {
                LifecycleListener lifecycleListener = (LifecycleListener) ((WeakReference) it.next()).get();
                if (lifecycleListener != null) {
                    lifecycleListener.onStart(activity);
                }
            }
        } catch (Throwable unused) {
        }
    }

    private synchronized boolean a(LifecycleListener lifecycleListener) {
        return b(lifecycleListener) != null;
    }
}
