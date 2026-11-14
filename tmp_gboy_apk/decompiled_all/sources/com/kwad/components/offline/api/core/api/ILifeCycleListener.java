package com.kwad.components.offline.api.core.api;

import A5SV6n.A2egSU;
import android.app.Activity;
import android.os.Bundle;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public interface ILifeCycleListener {
    @A2egSU
    void onActivityCreated(Activity activity, Bundle bundle);

    @A2egSU
    void onActivityDestroyed(Activity activity);

    @A2egSU
    void onActivityPaused(Activity activity);

    @A2egSU
    void onActivityResumed(Activity activity);

    @A2egSU
    void onBackToBackground();

    @A2egSU
    void onBackToForeground();
}
