package NUY5pn;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class B25kr6 implements ServiceConnection {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final BJ7GGh f5966A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final int f5967A4TApA;

    public B25kr6(BJ7GGh bJ7GGh, int i) {
        this.f5966A2egSU = bJ7GGh;
        this.f5967A4TApA = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v7, types: [NUY5pn.ASJ6gh] */
    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        AMqCpz aMqCpz;
        if (iBinder == null) {
            BJ7GGh bJ7GGh = this.f5966A2egSU;
            NOd7IU.A2egSU a2egSU = new NOd7IU.A2egSU(1, 8, null, "ServiceBroker IBinder is null");
            int i = bJ7GGh.f5986A5SV6n.get();
            PendingIntent pendingIntent = a2egSU.f5855AmA8tU;
            DG07BK.A2egSU a2egSU2 = bJ7GGh.f5984A2egSU;
            a2egSU2.sendMessage(a2egSU2.obtainMessage(3, i, a2egSU.f5854AlLFFp, pendingIntent));
            return;
        }
        synchronized (this.f5966A2egSU.f5994AcNBzu) {
            BJ7GGh bJ7GGh2 = this.f5966A2egSU;
            int i2 = ARc23Z.f5946A2egSU;
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof ASJ6gh)) {
                AMqCpz aMqCpz2 = new AMqCpz();
                aMqCpz2.f5945A2egSU = iBinder;
                aMqCpz = aMqCpz2;
            } else {
                aMqCpz = (ASJ6gh) queryLocalInterface;
            }
            bJ7GGh2.f5995AlLFFp = aMqCpz;
        }
        BJ7GGh bJ7GGh3 = this.f5966A2egSU;
        int i3 = this.f5967A4TApA;
        bJ7GGh3.getClass();
        B4ZgIw b4ZgIw = new B4ZgIw(bJ7GGh3, 0);
        DG07BK.A2egSU a2egSU3 = bJ7GGh3.f5984A2egSU;
        a2egSU3.sendMessage(a2egSU3.obtainMessage(5, i3, -1, b4ZgIw));
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        BJ7GGh bJ7GGh;
        synchronized (this.f5966A2egSU.f5994AcNBzu) {
            bJ7GGh = this.f5966A2egSU;
            bJ7GGh.f5995AlLFFp = null;
        }
        DG07BK.A2egSU a2egSU = bJ7GGh.f5984A2egSU;
        a2egSU.sendMessage(a2egSU.obtainMessage(4, this.f5967A4TApA, 1));
    }
}
