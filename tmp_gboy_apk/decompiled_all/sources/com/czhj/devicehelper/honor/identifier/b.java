package com.czhj.devicehelper.honor.identifier;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import com.czhj.devicehelper.honor.identifier.a;
import com.czhj.devicehelper.honor.oaid.a;
import com.czhj.devicehelper.honor.oaid.b;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class b implements ServiceConnection {
    public Context b;

    /* renamed from: a, reason: collision with root package name */
    public a.C0213a f10527a = new a.C0213a();
    public a c = new a();
    public BinderC0214b d = new BinderC0214b();
    public CountDownLatch e = new CountDownLatch(2);

    public class a extends a.AbstractBinderC0215a {
        public a() {
        }

        @Override // com.czhj.devicehelper.honor.oaid.a
        public void a(int i, long j, boolean z, float f, double d, String str) {
        }

        @Override // com.czhj.devicehelper.honor.oaid.a
        public void a(int i, Bundle bundle) {
            Objects.toString(bundle);
            if (i == 0 && bundle != null && b.this.f10527a != null) {
                b.this.f10527a.f10526a = bundle.getString("oa_id_flag");
            }
            b.this.e.countDown();
        }
    }

    /* renamed from: com.czhj.devicehelper.honor.identifier.b$b, reason: collision with other inner class name */
    public class BinderC0214b extends a.AbstractBinderC0215a {
        public BinderC0214b() {
        }

        @Override // com.czhj.devicehelper.honor.oaid.a
        public void a(int i, long j, boolean z, float f, double d, String str) {
        }

        @Override // com.czhj.devicehelper.honor.oaid.a
        public void a(int i, Bundle bundle) {
            Objects.toString(bundle);
            if (i == 0 && bundle != null && b.this.f10527a != null) {
                b.this.f10527a.b = bundle.getBoolean("oa_id_limit_state");
            }
            b.this.e.countDown();
        }
    }

    public final void a() {
        try {
            this.b.unbindService(this);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, final IBinder iBinder) {
        new Thread(new Runnable() { // from class: com.czhj.devicehelper.honor.identifier.b.1
            @Override // java.lang.Runnable
            public void run() {
                com.czhj.devicehelper.honor.oaid.b c0216a;
                try {
                    Binder.getCallingPid();
                    IBinder iBinder2 = iBinder;
                    if (iBinder2 == null) {
                        c0216a = null;
                    } else {
                        IInterface queryLocalInterface = iBinder2.queryLocalInterface("com.hihonor.cloudservice.oaid.IOAIDService");
                        c0216a = (queryLocalInterface == null || !(queryLocalInterface instanceof com.czhj.devicehelper.honor.oaid.b)) ? new b.a.C0216a(iBinder) : (com.czhj.devicehelper.honor.oaid.b) queryLocalInterface;
                    }
                    Objects.toString(c0216a);
                    c0216a.a(b.this.c);
                    c0216a.b(b.this.d);
                } catch (Exception e) {
                    e.getMessage();
                    b.this.e.countDown();
                    b.this.e.countDown();
                    b.this.a();
                }
            }
        }).start();
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        this.e.countDown();
        this.e.countDown();
    }

    public boolean a(Context context) {
        try {
            context.getPackageManager().getPackageInfo("com.hihonor.id", 0);
            new Intent("com.hihonor.id.HnOaIdService").setPackage("com.hihonor.id");
            return !r5.queryIntentServices(r2, 0).isEmpty();
        } catch (Exception unused) {
            return false;
        }
    }
}
