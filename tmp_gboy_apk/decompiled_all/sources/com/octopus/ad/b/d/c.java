package com.octopus.ad.b.d;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.octopus.ad.b.d.a;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class c {
    private static String b = "OpenDeviceId library";
    private static boolean c;

    /* renamed from: a, reason: collision with root package name */
    private com.octopus.ad.b.d.a f12360a;
    private ServiceConnection d;
    private Context e = null;
    private a f = null;

    public interface a<T> {
        void a(T t, c cVar);
    }

    public boolean b() {
        try {
            com.octopus.ad.b.d.a aVar = this.f12360a;
            if (aVar != null) {
                return aVar.c();
            }
            return false;
        } catch (RemoteException unused) {
            return false;
        }
    }

    public int a(Context context, a<String> aVar) {
        if (context != null) {
            this.e = context;
            this.f = aVar;
            this.d = new ServiceConnection() { // from class: com.octopus.ad.b.d.c.1
                @Override // android.content.ServiceConnection
                public synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                    c.this.f12360a = a.AbstractBinderC0400a.a(iBinder);
                    if (c.this.f != null) {
                        c.this.f.a("Deviceid Service Connected", c.this);
                    }
                }

                @Override // android.content.ServiceConnection
                public void onServiceDisconnected(ComponentName componentName) {
                    c.this.f12360a = null;
                }
            };
            Intent intent = new Intent();
            intent.setClassName("org.repackage.com.zui.deviceidservice", "org.repackage.com.zui.deviceidservice.DeviceidService");
            return this.e.bindService(intent, this.d, 1) ? 1 : -1;
        }
        throw new NullPointerException("Context can not be null.");
    }

    public String a() {
        if (this.e != null) {
            try {
                com.octopus.ad.b.d.a aVar = this.f12360a;
                if (aVar != null) {
                    return aVar.a();
                }
                return null;
            } catch (RemoteException e) {
                e.printStackTrace();
                return null;
            }
        }
        throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
    }
}
