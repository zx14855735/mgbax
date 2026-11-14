package HXc4pW;

import ADYaiT.DUi7mC;
import android.util.Log;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AaHO0E {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final Class f3551A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final List f3552A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final IOxIEW.A5SV6n f3553A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final DUi7mC f3554ADYaiT;
    public final String AMqCpz;

    public AaHO0E(Class cls, Class cls2, Class cls3, List list, IOxIEW.A5SV6n a5SV6n, DUi7mC dUi7mC) {
        this.f3551A2egSU = cls;
        this.f3552A4TApA = list;
        this.f3553A5SV6n = a5SV6n;
        this.f3554ADYaiT = dUi7mC;
        this.AMqCpz = "Failed DecodePath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
    }

    public final BTvldC A2egSU(int i, int i2, C4FrIb.AmA8tU amA8tU, HSHyT0.AmA8tU amA8tU2, com.bumptech.glide.load.data.ASJ6gh aSJ6gh) {
        BTvldC bTvldC;
        HSHyT0.B3GDIM b3gdim;
        int i3;
        boolean z;
        boolean z2;
        HSHyT0.AZkASS aMqCpz;
        DUi7mC dUi7mC = this.f3554ADYaiT;
        List list = (List) dUi7mC.AYUAbz();
        try {
            BTvldC A4TApA2 = A4TApA(aSJ6gh, i, i2, amA8tU2, list);
            dUi7mC.B7CMnp(list);
            AZkASS aZkASS = (AZkASS) amA8tU.f1575AlLFFp;
            aZkASS.getClass();
            Class<?> cls = A4TApA2.get().getClass();
            int i4 = amA8tU.f1574AcNBzu;
            AYUAbz aYUAbz = aZkASS.f3522AcNBzu;
            HSHyT0.B2KMhB b2KMhB = null;
            if (i4 != 4) {
                HSHyT0.B3GDIM AMqCpz = aYUAbz.AMqCpz(cls);
                b3gdim = AMqCpz;
                bTvldC = AMqCpz.A4TApA(aZkASS.f3529B4ZgIw, A4TApA2, aZkASS.f3533BI9f7h, aZkASS.f3534BIYEnU);
            } else {
                bTvldC = A4TApA2;
                b3gdim = null;
            }
            if (!A4TApA2.equals(bTvldC)) {
                A4TApA2.A2egSU();
            }
            if (aYUAbz.f3504A5SV6n.f9920A4TApA.f9937ADYaiT.A2egSU(bTvldC.A4TApA()) != null) {
                com.bumptech.glide.AaHO0E aaHO0E = aYUAbz.f3504A5SV6n.f9920A4TApA;
                aaHO0E.getClass();
                b2KMhB = aaHO0E.f9937ADYaiT.A2egSU(bTvldC.A4TApA());
                if (b2KMhB == null) {
                    throw new com.bumptech.glide.AcNBzu(bTvldC.A4TApA());
                }
                i3 = b2KMhB.A4TApA(aZkASS.f3536BNL6CD);
            } else {
                i3 = 3;
            }
            HSHyT0.B2KMhB b2KMhB2 = b2KMhB;
            HSHyT0.AZkASS aZkASS2 = aZkASS.f3541BniPrB;
            ArrayList A4TApA3 = aYUAbz.A4TApA();
            int size = A4TApA3.size();
            int i5 = 0;
            while (true) {
                if (i5 >= size) {
                    z = false;
                    break;
                }
                if (((Hjvs0g.BChYOn) A4TApA3.get(i5)).f3742A2egSU.equals(aZkASS2)) {
                    z = true;
                    break;
                }
                i5++;
            }
            if (aZkASS.f3535BJ7GGh.ADYaiT(i4, i3, !z)) {
                if (b2KMhB2 == null) {
                    throw new com.bumptech.glide.AcNBzu(bTvldC.get().getClass());
                }
                int ADYaiT2 = B4ZgIw.AYUAbz.ADYaiT(i3);
                if (ADYaiT2 == 0) {
                    z2 = true;
                    aMqCpz = new AMqCpz(aZkASS.f3541BniPrB, aZkASS.f3530B7CMnp);
                } else {
                    if (ADYaiT2 != 1) {
                        throw new IllegalArgumentException("Unknown strategy: ".concat(i3 != 1 ? i3 != 2 ? i3 != 3 ? "null" : "NONE" : "TRANSFORMED" : "SOURCE"));
                    }
                    z2 = true;
                    aMqCpz = new BmvVmW(aYUAbz.f3504A5SV6n.f9919A2egSU, aZkASS.f3541BniPrB, aZkASS.f3530B7CMnp, aZkASS.f3533BI9f7h, aZkASS.f3534BIYEnU, b3gdim, cls, aZkASS.f3536BNL6CD);
                }
                BPw6Q8 bPw6Q8 = (BPw6Q8) BPw6Q8.f3623B25kr6.AYUAbz();
                bPw6Q8.f3627AzWtSf = false;
                bPw6Q8.f3626AmA8tU = z2;
                bPw6Q8.f3625AlLFFp = bTvldC;
                DUi7mC dUi7mC2 = aZkASS.f3527B2KMhB;
                dUi7mC2.f239AlLFFp = aMqCpz;
                dUi7mC2.f240AmA8tU = b2KMhB2;
                dUi7mC2.f241AzWtSf = bPw6Q8;
                bTvldC = bPw6Q8;
            }
            return this.f3553A5SV6n.ARc23Z(bTvldC, amA8tU2);
        } catch (Throwable th) {
            dUi7mC.B7CMnp(list);
            throw th;
        }
    }

    public final BTvldC A4TApA(com.bumptech.glide.load.data.ASJ6gh aSJ6gh, int i, int i2, HSHyT0.AmA8tU amA8tU, List list) {
        List list2 = this.f3552A4TApA;
        int size = list2.size();
        BTvldC bTvldC = null;
        for (int i3 = 0; i3 < size; i3++) {
            HSHyT0.B25kr6 b25kr6 = (HSHyT0.B25kr6) list2.get(i3);
            try {
                if (b25kr6.A4TApA(aSJ6gh.AYUAbz(), amA8tU)) {
                    bTvldC = b25kr6.A2egSU(aSJ6gh.AYUAbz(), i, i2, amA8tU);
                }
            } catch (IOException | OutOfMemoryError | RuntimeException e) {
                if (Log.isLoggable("DecodePath", 2)) {
                    Objects.toString(b25kr6);
                }
                list.add(e);
            }
            if (bTvldC != null) {
                break;
            }
        }
        if (bTvldC != null) {
            return bTvldC;
        }
        throw new BI9f7h(this.AMqCpz, new ArrayList(list));
    }

    public final String toString() {
        return "DecodePath{ dataClass=" + this.f3551A2egSU + ", decoders=" + this.f3552A4TApA + ", transcoder=" + this.f3553A5SV6n + '}';
    }
}
