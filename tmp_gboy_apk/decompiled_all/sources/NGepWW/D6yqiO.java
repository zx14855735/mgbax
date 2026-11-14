package NGepWW;

import android.os.DeadObjectException;
import android.os.RemoteException;
import android.util.Log;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class D6yqiO extends D8MqeW {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final NIA37H.A4TApA f5720A2egSU;

    public D6yqiO(NIA37H.A4TApA a4TApA) {
        this.f5720A2egSU = a4TApA;
    }

    @Override // NGepWW.D8MqeW
    public final void A4TApA(DXuj49 dXuj49, boolean z) {
    }

    @Override // NGepWW.D8MqeW
    public final void A5SV6n(EdhSi6 edhSi6) {
        try {
            AMqCpz(edhSi6);
        } catch (DeadObjectException e) {
            ADYaiT(D8MqeW.A2egSU(e));
            throw e;
        } catch (RemoteException e2) {
            ADYaiT(D8MqeW.A2egSU(e2));
        }
    }

    @Override // NGepWW.D8MqeW
    public final void ADYaiT(NSK3xo.A4TApA a4TApA) {
        this.f5720A2egSU.A2egSU(new NSK3xo.AzWtSf(a4TApA));
    }

    public final void AMqCpz(EdhSi6 edhSi6) {
        if (edhSi6.f5825ARc23Z.remove(null) != null) {
            throw new ClassCastException();
        }
        Log.wtf("UnregisterListenerTask", "Received call to unregister a listener without a matching registration call.", new Exception());
        this.f5720A2egSU.A2egSU(new NSK3xo.AzWtSf(NSK3xo.A4TApA.f5922B2KMhB));
    }
}
