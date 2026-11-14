package NGepWW;

import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.RemoteException;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class DcUJf1 implements EPdU4G {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final EUIRHA f5740AcNBzu;

    public DcUJf1(EUIRHA euirha) {
        this.f5740AcNBzu = euirha;
    }

    @Override // NGepWW.EPdU4G
    public final void A2egSU(Bundle bundle) {
    }

    public final void A4TApA(NCeV4Q.ASJ6gh aSJ6gh) {
        EUIRHA euirha = this.f5740AcNBzu;
        ARc23Z aRc23Z = euirha.f5809ASJ6gh.f5789B7CMnp;
        aRc23Z.f5681A2egSU.add(aSJ6gh);
        aSJ6gh.f5728ASJ6gh.set(aRc23Z.f5682A4TApA);
        NSK3xo.ASJ6gh aSJ6gh2 = aSJ6gh.f5645AmA8tU;
        NSK3xo.ARc23Z aRc23Z2 = (NSK3xo.ARc23Z) euirha.f5809ASJ6gh.f5784AzWtSf.get(aSJ6gh2);
        NUY5pn.AYUAbz.A5SV6n(aRc23Z2, "Appropriate Api was not requested.");
        if (!((NUY5pn.BJ7GGh) aRc23Z2).AZOQYO() && euirha.f5805A4TApA.containsKey(aSJ6gh2)) {
            aSJ6gh.AaHO0E(new NSK3xo.A4TApA(17, null));
            return;
        }
        try {
            aSJ6gh.AZkASS(aRc23Z2);
        } catch (DeadObjectException e) {
            aSJ6gh.AaHO0E(new NSK3xo.A4TApA(1, 8, null, e.getLocalizedMessage()));
            throw e;
        } catch (RemoteException e2) {
            aSJ6gh.AaHO0E(new NSK3xo.A4TApA(1, 8, null, e2.getLocalizedMessage()));
        }
    }

    @Override // NGepWW.EPdU4G
    public final NCeV4Q.ASJ6gh A5SV6n(NCeV4Q.ASJ6gh aSJ6gh) {
        try {
            A4TApA(aSJ6gh);
            return aSJ6gh;
        } catch (DeadObjectException unused) {
            DaOi9o daOi9o = new DaOi9o(this, this);
            DG07BK.A2egSU a2egSU = this.f5740AcNBzu.f5815AlLFFp;
            a2egSU.sendMessage(a2egSU.obtainMessage(1, daOi9o));
            return aSJ6gh;
        }
    }

    @Override // NGepWW.EPdU4G
    public final void ADYaiT(NOd7IU.A2egSU a2egSU, NSK3xo.AYUAbz aYUAbz) {
    }

    @Override // NGepWW.EPdU4G
    public final void a() {
    }

    @Override // NGepWW.EPdU4G
    public final boolean b() {
        EUIRHA euirha = this.f5740AcNBzu;
        ReentrantLock reentrantLock = euirha.f5809ASJ6gh.f5790B9tovu;
        reentrantLock.lock();
        reentrantLock.unlock();
        euirha.ARc23Z(null);
        return true;
    }

    @Override // NGepWW.EPdU4G
    public final void c() {
    }

    @Override // NGepWW.EPdU4G
    public final void a(int i) {
        EUIRHA euirha = this.f5740AcNBzu;
        euirha.ARc23Z(null);
        euirha.f5810AYUAbz.a(i);
    }
}
