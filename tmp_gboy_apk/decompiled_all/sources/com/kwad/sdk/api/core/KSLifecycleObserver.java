package com.kwad.sdk.api.core;

import A5SV6n.A2egSU;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class KSLifecycleObserver {
    private static volatile KSLifecycleObserver sKSLifecycleObserver;
    private WeakReference<Activity> currentActivity;
    private Application mApplication;
    private boolean mIsInBackground = true;
    private Set<Integer> mStartedActivitySet = new HashSet();
    private final List<KSLifecycleListener> mListeners = new CopyOnWriteArrayList();
    private boolean mHasInit = false;
    private boolean mEnable = false;

    private KSLifecycleObserver() {
    }

    public static KSLifecycleObserver getInstance() {
        if (sKSLifecycleObserver == null) {
            synchronized (KSLifecycleObserver.class) {
                try {
                    if (sKSLifecycleObserver == null) {
                        sKSLifecycleObserver = new KSLifecycleObserver();
                    }
                } finally {
                }
            }
        }
        return sKSLifecycleObserver;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onAppBackToForeground() {
        try {
            this.mIsInBackground = false;
            Iterator<KSLifecycleListener> it = this.mListeners.iterator();
            while (it.hasNext()) {
                it.next().onBackToForeground();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onAppGoToBackground() {
        try {
            this.mIsInBackground = true;
            Iterator<KSLifecycleListener> it = this.mListeners.iterator();
            while (it.hasNext()) {
                it.next().onBackToBackground();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @A2egSU
    public Application getApplication() {
        return this.mApplication;
    }

    @A2egSU
    public Activity getCurrentActivity() {
        WeakReference<Activity> weakReference = this.currentActivity;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public void init(Context context) {
        try {
            if ((context instanceof Application) && !this.mHasInit) {
                this.mHasInit = true;
                Application application = (Application) context;
                this.mApplication = application;
                application.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() { // from class: com.kwad.sdk.api.core.KSLifecycleObserver.1
                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityCreated(Activity activity, Bundle bundle) {
                        KSLifecycleObserver.this.mEnable = true;
                        try {
                            Iterator it = KSLifecycleObserver.this.mListeners.iterator();
                            while (it.hasNext()) {
                                ((KSLifecycleListener) it.next()).onActivityCreated(activity, bundle);
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityDestroyed(Activity activity) {
                        try {
                            Iterator it = KSLifecycleObserver.this.mListeners.iterator();
                            while (it.hasNext()) {
                                ((KSLifecycleListener) it.next()).onActivityDestroyed(activity);
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityPaused(Activity activity) {
                        try {
                            if (KSLifecycleObserver.this.currentActivity != null && KSLifecycleObserver.this.currentActivity.get() != null && ((Activity) KSLifecycleObserver.this.currentActivity.get()).equals(activity)) {
                                KSLifecycleObserver.this.currentActivity = null;
                            }
                            Iterator it = KSLifecycleObserver.this.mListeners.iterator();
                            while (it.hasNext()) {
                                ((KSLifecycleListener) it.next()).onActivityPaused(activity);
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityResumed(Activity activity) {
                        try {
                            KSLifecycleObserver.this.currentActivity = new WeakReference(activity);
                            Iterator it = KSLifecycleObserver.this.mListeners.iterator();
                            while (it.hasNext()) {
                                ((KSLifecycleListener) it.next()).onActivityResumed(activity);
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityStarted(Activity activity) {
                        try {
                            KSLifecycleObserver.this.mStartedActivitySet.add(Integer.valueOf(activity.hashCode()));
                            if (KSLifecycleObserver.this.mStartedActivitySet.size() == 1) {
                                KSLifecycleObserver.this.onAppBackToForeground();
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityStopped(Activity activity) {
                        try {
                            Iterator it = KSLifecycleObserver.this.mListeners.iterator();
                            while (it.hasNext()) {
                                ((KSLifecycleListener) it.next()).onActivityStopped(activity);
                            }
                            KSLifecycleObserver.this.mStartedActivitySet.remove(Integer.valueOf(activity.hashCode()));
                            if (KSLifecycleObserver.this.mStartedActivitySet.size() == 0) {
                                KSLifecycleObserver.this.onAppGoToBackground();
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                });
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @A2egSU
    public boolean isAppOnForeground() {
        return !this.mIsInBackground;
    }

    @A2egSU
    public boolean isEnable() {
        return this.mEnable;
    }

    @A2egSU
    public void registerLifecycleListener(KSLifecycleListener kSLifecycleListener) {
        this.mListeners.add(kSLifecycleListener);
    }

    @A2egSU
    public void unRegisterLifecycleListener(KSLifecycleListener kSLifecycleListener) {
        this.mListeners.remove(kSLifecycleListener);
    }
}
