package com.kwad.sdk.api.core;

import A5SV6n.A2egSU;
import android.app.Activity;
import android.os.Bundle;

@A2egSU
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public interface KSLifecycleListener {
    @A2egSU
    void onActivityCreated(Activity activity, Bundle bundle);

    @A2egSU
    void onActivityDestroyed(Activity activity);

    @A2egSU
    void onActivityPaused(Activity activity);

    @A2egSU
    void onActivityResumed(Activity activity);

    @A2egSU
    void onActivityStopped(Activity activity);

    @A2egSU
    void onBackToBackground();

    @A2egSU
    void onBackToForeground();
}
