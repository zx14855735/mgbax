package HIguqb;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class A5SV6n implements ServiceConnection {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final ADYaiT f3361A2egSU;

    public A5SV6n(ADYaiT aDYaiT) {
        this.f3361A2egSU = aDYaiT;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v5, types: [HIguqb.AlLFFp] */
    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        AaHO0E aaHO0E;
        int i = AcNBzu.f3373A2egSU;
        if (iBinder == null) {
            aaHO0E = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.bda.controller.IControllerService");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof AlLFFp)) {
                AaHO0E aaHO0E2 = new AaHO0E();
                aaHO0E2.f3372A2egSU = iBinder;
                aaHO0E = aaHO0E2;
            } else {
                aaHO0E = (AlLFFp) queryLocalInterface;
            }
        }
        ADYaiT aDYaiT = this.f3361A2egSU;
        aDYaiT.f3368AYUAbz = aaHO0E;
        aDYaiT.A2egSU();
        if (aDYaiT.f3362A2egSU == 5) {
            aDYaiT.A4TApA(5);
            aDYaiT.A4TApA(7);
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        this.f3361A2egSU.f3368AYUAbz = null;
    }
}
