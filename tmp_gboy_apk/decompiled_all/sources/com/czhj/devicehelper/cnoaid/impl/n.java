package com.czhj.devicehelper.cnoaid.impl;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
class n implements ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    private final Context f10515a;
    private final com.czhj.devicehelper.cnoaid.c b;
    private final a c;

    @FunctionalInterface
    public interface a {
        String a(IBinder iBinder);
    }

    private n(Context context, com.czhj.devicehelper.cnoaid.c cVar, a aVar) {
        this.f10515a = context instanceof Application ? context : context.getApplicationContext();
        this.b = cVar;
        this.c = aVar;
    }

    public static void a(Context context, Intent intent, com.czhj.devicehelper.cnoaid.c cVar, a aVar) {
        new n(context, cVar, aVar).a(intent);
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        com.czhj.devicehelper.cnoaid.g.a("Service has been connected: " + componentName.getClassName());
        try {
            try {
                try {
                    String a2 = this.c.a(iBinder);
                    if (a2 == null || a2.length() == 0) {
                        throw new com.czhj.devicehelper.cnoaid.f("OAID/AAID acquire failed");
                    }
                    com.czhj.devicehelper.cnoaid.g.a("OAID/AAID acquire success: ".concat(a2));
                    this.b.a(a2);
                    this.f10515a.unbindService(this);
                    com.czhj.devicehelper.cnoaid.g.a("Service has been unbound: " + componentName.getClassName());
                } catch (Throwable th) {
                    try {
                        this.f10515a.unbindService(this);
                        com.czhj.devicehelper.cnoaid.g.a("Service has been unbound: " + componentName.getClassName());
                    } catch (Exception e) {
                        com.czhj.devicehelper.cnoaid.g.a(e);
                    }
                    throw th;
                }
            } catch (Exception e2) {
                com.czhj.devicehelper.cnoaid.g.a(e2);
                this.b.a(e2);
                this.f10515a.unbindService(this);
                com.czhj.devicehelper.cnoaid.g.a("Service has been unbound: " + componentName.getClassName());
            }
        } catch (Exception e3) {
            com.czhj.devicehelper.cnoaid.g.a(e3);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        com.czhj.devicehelper.cnoaid.g.a("Service has been disconnected: " + componentName.getClassName());
    }

    private void a(Intent intent) {
        try {
            if (!this.f10515a.bindService(intent, this, 1)) {
                throw new com.czhj.devicehelper.cnoaid.f("Service binding failed");
            }
            com.czhj.devicehelper.cnoaid.g.a("Service has been bound: " + intent);
        } catch (Exception e) {
            this.b.a(e);
        }
    }
}
