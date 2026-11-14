package NGepWW;

import android.os.Bundle;
import android.util.Pair;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class DvK7DB implements NSK3xo.AZkASS {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final AtomicReference f5773A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final ADYaiT f5774A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final EH1KK8 f5775A5SV6n;

    public DvK7DB(EH1KK8 eh1kk8, AtomicReference atomicReference, ADYaiT aDYaiT) {
        this.f5775A5SV6n = eh1kk8;
        this.f5773A2egSU = atomicReference;
        this.f5774A4TApA = aDYaiT;
    }

    @Override // NSK3xo.AZkASS
    public final void A2egSU(Bundle bundle) {
        NSK3xo.AcNBzu acNBzu = (NSK3xo.AcNBzu) this.f5773A2egSU.get();
        EH1KK8 eh1kk8 = this.f5775A5SV6n;
        ADYaiT aDYaiT = this.f5774A4TApA;
        AZOQYO.f5686A5SV6n.getClass();
        NCeV4Q.ASJ6gh A5SV6n2 = acNBzu.A5SV6n(new NCeV4Q.ASJ6gh(AZOQYO.f5685A4TApA, acNBzu, 1));
        ECyGFg eCyGFg = new ECyGFg(eh1kk8, aDYaiT, true, acNBzu);
        synchronized (A5SV6n2.f5725A5SV6n) {
            try {
                NUY5pn.AYUAbz.AMqCpz(!A5SV6n2.f5730AZOQYO, "Result has already been consumed.");
                if (!A5SV6n2.AYUAbz()) {
                    if (A5SV6n2.ARc23Z()) {
                        DG07BK dg07bk = A5SV6n2.f5723A2egSU;
                        NSK3xo.AmA8tU A5SV6n3 = A5SV6n2.A5SV6n();
                        dg07bk.getClass();
                        dg07bk.sendMessage(dg07bk.obtainMessage(1, new Pair(eCyGFg, A5SV6n3)));
                    } else {
                        A5SV6n2.f5727ARc23Z = eCyGFg;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // NSK3xo.AZkASS
    public final void a(int i) {
    }
}
