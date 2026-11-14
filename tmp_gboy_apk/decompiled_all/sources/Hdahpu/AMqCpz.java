package Hdahpu;

import HXc4pW.AzWtSf;
import HXc4pW.BTvldC;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AMqCpz extends ItGa5w.AZOQYO {

    /* renamed from: ADYaiT, reason: collision with root package name */
    public AzWtSf f3690ADYaiT;

    @Override // ItGa5w.AZOQYO
    public final int A4TApA(Object obj) {
        BTvldC bTvldC = (BTvldC) obj;
        if (bTvldC == null) {
            return 1;
        }
        return bTvldC.getSize();
    }

    @Override // ItGa5w.AZOQYO
    public final void A5SV6n(Object obj, Object obj2) {
        BTvldC bTvldC = (BTvldC) obj2;
        AzWtSf azWtSf = this.f3690ADYaiT;
        if (azWtSf == null || bTvldC == null) {
            return;
        }
        azWtSf.AMqCpz.ARc23Z(bTvldC, true);
    }

    public final void ARc23Z(int i) {
        long j;
        if (i >= 40) {
            AMqCpz(0L);
        } else if (i >= 20 || i == 15) {
            synchronized (this) {
                j = this.f4085A4TApA;
            }
            AMqCpz(j / 2);
        }
    }
}
