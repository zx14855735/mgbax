package com.octopus.ad.utils.a.b;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class l implements ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    private final Context f12691a;
    private final com.octopus.ad.utils.a.c b;
    private final a c;

    @FunctionalInterface
    public interface a {
        String a(IBinder iBinder);
    }

    private l(Context context, com.octopus.ad.utils.a.c cVar, a aVar) {
        if (context instanceof Application) {
            this.f12691a = context;
        } else {
            this.f12691a = context.getApplicationContext();
        }
        this.b = cVar;
        this.c = aVar;
    }

    public static void a(Context context, Intent intent, com.octopus.ad.utils.a.c cVar, a aVar) {
        new l(context, cVar, aVar).a(intent);
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        com.octopus.ad.utils.a.f.a("Service has been connected: " + componentName.getClassName());
        try {
            try {
                try {
                    String a2 = this.c.a(iBinder);
                    if (a2 == null || a2.length() == 0) {
                        throw new com.octopus.ad.utils.a.e("OAID/GAID acquire failed");
                    }
                    com.octopus.ad.utils.a.f.a("OAID/GAID acquire success: ".concat(a2));
                    this.b.a(a2);
                    this.f12691a.unbindService(this);
                    com.octopus.ad.utils.a.f.a("Service has been unbound: " + componentName.getClassName());
                } catch (Throwable th) {
                    try {
                        this.f12691a.unbindService(this);
                        com.octopus.ad.utils.a.f.a("Service has been unbound: " + componentName.getClassName());
                    } catch (Exception e) {
                        com.octopus.ad.utils.a.f.a(e);
                    }
                    throw th;
                }
            } catch (Exception e2) {
                com.octopus.ad.utils.a.f.a(e2);
                this.b.a(e2);
                this.f12691a.unbindService(this);
                com.octopus.ad.utils.a.f.a("Service has been unbound: " + componentName.getClassName());
            }
        } catch (Exception e3) {
            com.octopus.ad.utils.a.f.a(e3);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        com.octopus.ad.utils.a.f.a("Service has been disconnected: " + componentName.getClassName());
    }

    private void a(Intent intent) {
        try {
            if (!this.f12691a.bindService(intent, this, 1)) {
                throw new com.octopus.ad.utils.a.e("Service binding failed");
            }
            com.octopus.ad.utils.a.f.a("Service has been bound: " + intent);
        } catch (Exception e) {
            this.b.a(e);
        }
    }
}
