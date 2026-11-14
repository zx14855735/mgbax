package EsrwYR;

import NOd7IU.AlLFFp;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.Objects;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AMqCpz implements ServiceConnection {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final Context f2554A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final GEYgCP.A2egSU f2555A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final ADYaiT f2556A5SV6n;

    public AMqCpz(Context context, GEYgCP.A2egSU a2egSU, ADYaiT aDYaiT) {
        if (context instanceof Application) {
            this.f2554A2egSU = context;
        } else {
            this.f2554A2egSU = context.getApplicationContext();
        }
        this.f2555A4TApA = a2egSU;
        this.f2556A5SV6n = aDYaiT;
    }

    public static void A2egSU(Context context, Intent intent, GEYgCP.A2egSU a2egSU, ADYaiT aDYaiT) {
        AMqCpz aMqCpz = new AMqCpz(context, a2egSU, aDYaiT);
        try {
            if (!aMqCpz.f2554A2egSU.bindService(intent, aMqCpz, 1)) {
                throw new GL2Jh7.A2egSU("Service binding failed");
            }
            Objects.toString(intent);
        } catch (Exception unused) {
            aMqCpz.f2555A4TApA.getClass();
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        String a2;
        GEYgCP.A2egSU a2egSU = this.f2555A4TApA;
        Context context = this.f2554A2egSU;
        componentName.getClassName();
        try {
            try {
                try {
                    a2 = this.f2556A5SV6n.a(iBinder);
                } catch (Exception unused) {
                    a2egSU.getClass();
                    context.unbindService(this);
                }
                if (a2 == null || a2.length() == 0) {
                    throw new GL2Jh7.A2egSU("OAID/AAID acquire failed");
                }
                a2egSU.getClass();
                AlLFFp.f5886AlLFFp = a2;
                context.unbindService(this);
                componentName.getClassName();
            } catch (Exception unused2) {
            }
        } catch (Throwable th) {
            try {
                context.unbindService(this);
                componentName.getClassName();
            } catch (Exception unused3) {
            }
            throw th;
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        componentName.getClassName();
    }
}
