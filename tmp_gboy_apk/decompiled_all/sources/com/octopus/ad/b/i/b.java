package com.octopus.ad.b.i;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.octopus.ad.b.c;
import com.octopus.ad.b.i.a;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class b implements c {

    public static final class a implements ServiceConnection {

        /* renamed from: a, reason: collision with root package name */
        boolean f12378a;
        private final LinkedBlockingQueue<IBinder> b;

        public IBinder a() {
            if (this.f12378a) {
                throw new IllegalStateException();
            }
            this.f12378a = true;
            return this.b.poll(5L, TimeUnit.SECONDS);
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.b.put(iBinder);
            } catch (InterruptedException unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }

        private a() {
            this.f12378a = false;
            this.b = new LinkedBlockingQueue<>();
        }
    }

    @Override // com.octopus.ad.b.c
    public String a(Context context) {
        a aVar = new a();
        Intent intent = new Intent();
        intent.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
        if (context.bindService(intent, aVar, 1)) {
            try {
                return a.AbstractBinderC0404a.a(aVar.a()).a();
            } catch (Exception unused) {
            } finally {
                context.unbindService(aVar);
            }
        }
        return null;
    }
}
