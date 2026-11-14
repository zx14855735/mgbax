package com.octopus.ad.b.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.octopus.ad.b.a.b;
import com.octopus.ad.b.c;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class a implements c {

    /* renamed from: a, reason: collision with root package name */
    private static b f12349a;
    private CountDownLatch b;
    private Context c;
    private String d = "";
    private final ServiceConnection e = new ServiceConnection() { // from class: com.octopus.ad.b.a.a.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                try {
                    b a2 = b.a.a(iBinder);
                    b unused = a.f12349a = a2;
                    String packageName = a.this.c.getPackageName();
                    a.this.d = a2.b(packageName);
                    a.f12349a.b(a.this.c.getPackageName());
                } finally {
                    a.this.b.countDown();
                }
            } catch (RemoteException | NullPointerException e) {
                e.getMessage();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            b unused = a.f12349a = null;
        }
    };

    private void c(Context context) {
        try {
            context.unbindService(this.e);
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    private void b(Context context) {
        try {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.coolpad.deviceidsupport", "com.coolpad.deviceidsupport.DeviceIdService"));
            context.bindService(intent, this.e, 1);
        } catch (Throwable th) {
            th.getMessage();
            this.b.countDown();
        }
    }

    @Override // com.octopus.ad.b.c
    public String a(Context context) {
        if (context == null) {
            return null;
        }
        this.c = context.getApplicationContext();
        this.b = new CountDownLatch(1);
        try {
            b(context);
            this.b.await(500L, TimeUnit.MILLISECONDS);
            return this.d;
        } catch (InterruptedException e) {
            e.getMessage();
            return null;
        } finally {
            c(context);
        }
    }
}
