package com.kwad.sdk.api.proxy.app;

import A5SV6n.A2egSU;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.kwad.sdk.api.loader.Loader;
import com.kwad.sdk.api.proxy.BaseProxyService;
import com.kwad.sdk.api.proxy.IServiceProxy;

@A2egSU
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class ServiceProxyRemote extends BaseProxyService {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public static final /* synthetic */ int f12321AcNBzu = 0;

    @Override // com.kwad.sdk.api.proxy.BaseProxyService
    public IServiceProxy getDelegate(Context context) {
        IServiceProxy iServiceProxy;
        try {
            iServiceProxy = (IServiceProxy) Loader.get().newComponentProxy(context, ServiceProxyRemote.class, this);
        } catch (Throwable unused) {
            iServiceProxy = null;
        }
        return iServiceProxy == null ? new IServiceProxy() { // from class: com.kwad.sdk.api.proxy.app.ServiceProxyRemote.1
            @Override // com.kwad.sdk.api.proxy.IServiceProxy
            public IBinder onBind(Service service, Intent intent) {
                return null;
            }

            @Override // com.kwad.sdk.api.proxy.IServiceProxy
            public void onCreate(Service service) {
            }

            @Override // com.kwad.sdk.api.proxy.IServiceProxy
            public void onDestroy(Service service) {
            }

            @Override // com.kwad.sdk.api.proxy.IServiceProxy
            public void onRebind(Service service, Intent intent) {
            }

            @Override // com.kwad.sdk.api.proxy.IServiceProxy
            public int onStartCommand(Service service, Intent intent, int i, int i2) {
                return 0;
            }

            @Override // com.kwad.sdk.api.proxy.IServiceProxy
            public boolean onUnbind(Service service, Intent intent) {
                return false;
            }
        } : iServiceProxy;
    }
}
