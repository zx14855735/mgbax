package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class F1loUV {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final B25kr6.AzWtSf f9406A2egSU = new B25kr6.AzWtSf();

    /* renamed from: A4TApA, reason: collision with root package name */
    public final B25kr6.AYUAbz f9407A4TApA = new B25kr6.AYUAbz();

    public final void A2egSU(Dphsd2 dphsd2, RecyclerView.ADYaiT.A2egSU a2egSU) {
        B25kr6.AzWtSf azWtSf = this.f9406A2egSU;
        EwN40Z ewN40Z = (EwN40Z) azWtSf.get(dphsd2);
        if (ewN40Z == null) {
            ewN40Z = EwN40Z.A2egSU();
            azWtSf.put(dphsd2, ewN40Z);
        }
        ewN40Z.f9405A5SV6n = a2egSU;
        ewN40Z.f9403A2egSU |= 8;
    }

    public final RecyclerView.ADYaiT.A2egSU A4TApA(Dphsd2 dphsd2, int i) {
        EwN40Z ewN40Z;
        RecyclerView.ADYaiT.A2egSU a2egSU;
        B25kr6.AzWtSf azWtSf = this.f9406A2egSU;
        int ADYaiT2 = azWtSf.ADYaiT(dphsd2);
        if (ADYaiT2 >= 0 && (ewN40Z = (EwN40Z) azWtSf.AZkASS(ADYaiT2)) != null) {
            int i2 = ewN40Z.f9403A2egSU;
            if ((i2 & i) != 0) {
                int i3 = i2 & (~i);
                ewN40Z.f9403A2egSU = i3;
                if (i == 4) {
                    a2egSU = ewN40Z.f9404A4TApA;
                } else {
                    if (i != 8) {
                        throw new IllegalArgumentException("Must provide flag PRE or POST");
                    }
                    a2egSU = ewN40Z.f9405A5SV6n;
                }
                if ((i3 & 12) == 0) {
                    azWtSf.AYUAbz(ADYaiT2);
                    ewN40Z.f9403A2egSU = 0;
                    ewN40Z.f9404A4TApA = null;
                    ewN40Z.f9405A5SV6n = null;
                    EwN40Z.f9402ADYaiT.A5SV6n(ewN40Z);
                }
                return a2egSU;
            }
        }
        return null;
    }

    public final void A5SV6n(Dphsd2 dphsd2) {
        EwN40Z ewN40Z = (EwN40Z) this.f9406A2egSU.get(dphsd2);
        if (ewN40Z == null) {
            return;
        }
        ewN40Z.f9403A2egSU &= -2;
    }

    public final void ADYaiT(Dphsd2 dphsd2) {
        B25kr6.AYUAbz aYUAbz = this.f9407A4TApA;
        int AZkASS2 = aYUAbz.AZkASS() - 1;
        while (true) {
            if (AZkASS2 < 0) {
                break;
            }
            if (dphsd2 == aYUAbz.AaHO0E(AZkASS2)) {
                Object[] objArr = aYUAbz.f990AmA8tU;
                Object obj = objArr[AZkASS2];
                Object obj2 = B25kr6.AZOQYO.f992A2egSU;
                if (obj != obj2) {
                    objArr[AZkASS2] = obj2;
                    aYUAbz.f988AcNBzu = true;
                }
            } else {
                AZkASS2--;
            }
        }
        EwN40Z ewN40Z = (EwN40Z) this.f9406A2egSU.remove(dphsd2);
        if (ewN40Z != null) {
            ewN40Z.f9403A2egSU = 0;
            ewN40Z.f9404A4TApA = null;
            ewN40Z.f9405A5SV6n = null;
            EwN40Z.f9402ADYaiT.A5SV6n(ewN40Z);
        }
    }
}
