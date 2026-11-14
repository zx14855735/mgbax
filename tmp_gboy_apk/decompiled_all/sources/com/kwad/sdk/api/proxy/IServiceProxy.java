package com.kwad.sdk.api.proxy;

import A5SV6n.A2egSU;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.kwad.sdk.api.core.KsAdSdkDynamicApi;

@KsAdSdkDynamicApi
@A2egSU
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public interface IServiceProxy extends IComponentProxy {
    @KsAdSdkDynamicApi
    @A2egSU
    IBinder onBind(Service service, Intent intent);

    @KsAdSdkDynamicApi
    @A2egSU
    void onCreate(Service service);

    @KsAdSdkDynamicApi
    @A2egSU
    void onDestroy(Service service);

    @KsAdSdkDynamicApi
    @A2egSU
    void onRebind(Service service, Intent intent);

    @KsAdSdkDynamicApi
    @A2egSU
    int onStartCommand(Service service, Intent intent, int i, int i2);

    boolean onUnbind(Service service, Intent intent);
}
