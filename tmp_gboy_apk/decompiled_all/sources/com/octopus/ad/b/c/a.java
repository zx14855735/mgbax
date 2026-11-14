package com.octopus.ad.b.c;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.octopus.ad.b.c;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class a implements c {

    /* renamed from: com.octopus.ad.b.c.a$a, reason: collision with other inner class name */
    public static final class ServiceConnectionC0399a implements ServiceConnection {

        /* renamed from: a, reason: collision with root package name */
        boolean f12356a;
        private final LinkedBlockingQueue<IBinder> b;

        public IBinder a() {
            if (this.f12356a) {
                throw new IllegalStateException();
            }
            this.f12356a = true;
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

        private ServiceConnectionC0399a() {
            this.f12356a = false;
            this.b = new LinkedBlockingQueue<>();
        }
    }

    public static final class b implements IInterface {

        /* renamed from: a, reason: collision with root package name */
        private IBinder f12357a;

        public b(IBinder iBinder) {
            this.f12357a = iBinder;
        }

        public String a() {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                this.f12357a.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readString();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.f12357a;
        }
    }

    @Override // com.octopus.ad.b.c
    public String a(Context context) {
        ServiceConnectionC0399a serviceConnectionC0399a = new ServiceConnectionC0399a();
        Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
        intent.setPackage("com.huawei.hwid");
        if (context.bindService(intent, serviceConnectionC0399a, 1)) {
            try {
                return new b(serviceConnectionC0399a.a()).a();
            } catch (Exception unused) {
            } finally {
                context.unbindService(serviceConnectionC0399a);
            }
        }
        return null;
    }
}
