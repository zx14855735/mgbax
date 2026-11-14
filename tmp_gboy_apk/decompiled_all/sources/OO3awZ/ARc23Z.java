package OO3awZ;

import java.util.HashMap;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final /* synthetic */ class ARc23Z implements Function {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f6404AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ Object f6405AlLFFp;

    public /* synthetic */ ARc23Z(int i, Object obj) {
        this.f6404AcNBzu = i;
        this.f6405AlLFFp = obj;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        Object apply;
        Object apply2;
        Object apply3;
        switch (this.f6404AcNBzu) {
            case 0:
                AZOQYO azoqyo = (AZOQYO) this.f6405AlLFFp;
                return new AlLFFp(azoqyo.AYUAbz(), azoqyo.ASJ6gh());
            case 1:
                AZOQYO azoqyo2 = (AZOQYO) this.f6405AlLFFp;
                return new AlLFFp(azoqyo2.AcNBzu(), azoqyo2.AaHO0E());
            case 2:
                AZkASS aZkASS = (AZkASS) obj;
                ((AZOQYO) this.f6405AlLFFp).getClass();
                boolean z = aZkASS.f6410A5SV6n;
                double d = z ? 30.0d : 90.0d;
                if (aZkASS.f6409A4TApA == 1) {
                    return Double.valueOf(z ? 30.0d : 85.0d);
                }
                if (!AZOQYO.AMqCpz(aZkASS)) {
                    return Double.valueOf(d);
                }
                AcNBzu acNBzu = aZkASS.f6412ARc23Z;
                double d2 = acNBzu.f6420A2egSU;
                double d3 = acNBzu.f6421A4TApA;
                ADYaiT A2egSU2 = ADYaiT.A2egSU(d2, d3, d);
                double d4 = A2egSU2.f6400A4TApA;
                if (d4 < d3) {
                    double d5 = d4;
                    while (A2egSU2.f6400A4TApA < d3) {
                        double d6 = (!aZkASS.f6410A5SV6n ? -1.0d : 1.0d) + d;
                        ADYaiT A2egSU3 = ADYaiT.A2egSU(d2, d3, d6);
                        double d7 = A2egSU3.f6400A4TApA;
                        if (d5 <= d7 && Math.abs(d7 - d3) >= 0.4d) {
                            if (Math.abs(A2egSU3.f6400A4TApA - d3) < Math.abs(A2egSU2.f6400A4TApA - d3)) {
                                A2egSU2 = A2egSU3;
                            }
                            d5 = Math.max(d5, A2egSU3.f6400A4TApA);
                            d = d6;
                        } else {
                            d = d6;
                        }
                    }
                }
                return Double.valueOf(d);
            case 3:
                ((AZOQYO) this.f6405AlLFFp).getClass();
                return AZOQYO.A5SV6n((AZkASS) obj);
            case 4:
                AZOQYO azoqyo3 = (AZOQYO) this.f6405AlLFFp;
                return new AlLFFp(azoqyo3.AZkASS(), azoqyo3.AZOQYO());
            case 5:
                AZkASS aZkASS2 = (AZkASS) obj;
                ((AZOQYO) this.f6405AlLFFp).getClass();
                if (AZOQYO.AMqCpz(aZkASS2)) {
                    return Double.valueOf(aZkASS2.f6408A2egSU.f6401A5SV6n);
                }
                int i = aZkASS2.f6409A4TApA;
                boolean z2 = aZkASS2.f6410A5SV6n;
                if (i == 1) {
                    return Double.valueOf(z2 ? 85.0d : 25.0d);
                }
                return Double.valueOf(z2 ? 30.0d : 90.0d);
            case 6:
                AZOQYO azoqyo4 = (AZOQYO) this.f6405AlLFFp;
                return new AlLFFp(azoqyo4.AYUAbz(), azoqyo4.ASJ6gh());
            case 7:
                return ((AZOQYO) this.f6405AlLFFp).ASJ6gh();
            case 8:
                return ((AZOQYO) this.f6405AlLFFp).A2egSU();
            case 9:
                AZOQYO azoqyo5 = (AZOQYO) this.f6405AlLFFp;
                AZkASS aZkASS3 = (AZkASS) obj;
                if (AZOQYO.AMqCpz(aZkASS3)) {
                    apply = azoqyo5.AYUAbz().f6393A5SV6n.apply(aZkASS3);
                    return Double.valueOf(A5SV6n.A2egSU(((Double) apply).doubleValue(), 4.5d));
                }
                int i2 = aZkASS3.f6409A4TApA;
                boolean z3 = aZkASS3.f6410A5SV6n;
                if (i2 == 1) {
                    return Double.valueOf(z3 ? 0.0d : 100.0d);
                }
                return Double.valueOf(z3 ? 90.0d : 30.0d);
            case 10:
                return ((AZOQYO) this.f6405AlLFFp).AYUAbz();
            case 11:
                AZkASS aZkASS4 = (AZkASS) obj;
                ((AZOQYO) this.f6405AlLFFp).getClass();
                boolean ARc23Z2 = AZOQYO.ARc23Z(aZkASS4);
                boolean z4 = aZkASS4.f6410A5SV6n;
                if (ARc23Z2) {
                    return Double.valueOf(z4 ? 60.0d : 49.0d);
                }
                if (!AZOQYO.AMqCpz(aZkASS4)) {
                    return Double.valueOf(z4 ? 30.0d : 90.0d);
                }
                double d8 = aZkASS4.f6408A2egSU.f6401A5SV6n;
                AcNBzu acNBzu2 = aZkASS4.f6413ASJ6gh;
                return Double.valueOf(A2egSU.ADYaiT(ADYaiT.A2egSU(acNBzu2.f6420A2egSU, acNBzu2.f6421A4TApA, d8)).f6401A5SV6n);
            case 12:
                AZOQYO azoqyo6 = (AZOQYO) this.f6405AlLFFp;
                return new AlLFFp(azoqyo6.AcNBzu(), azoqyo6.AaHO0E());
            case 13:
                return ((AZOQYO) this.f6405AlLFFp).AZOQYO();
            case 14:
                AZOQYO azoqyo7 = (AZOQYO) this.f6405AlLFFp;
                return new AlLFFp(azoqyo7.AZkASS(), azoqyo7.AZOQYO());
            case 15:
                return ((AZOQYO) this.f6405AlLFFp).AaHO0E();
            case 16:
                AZOQYO azoqyo8 = (AZOQYO) this.f6405AlLFFp;
                AZkASS aZkASS5 = (AZkASS) obj;
                boolean ARc23Z3 = AZOQYO.ARc23Z(aZkASS5);
                boolean z5 = aZkASS5.f6410A5SV6n;
                if (ARc23Z3) {
                    return Double.valueOf(z5 ? 0.0d : 100.0d);
                }
                if (!AZOQYO.AMqCpz(aZkASS5)) {
                    return Double.valueOf(z5 ? 90.0d : 30.0d);
                }
                apply2 = azoqyo8.AcNBzu().f6393A5SV6n.apply(aZkASS5);
                return Double.valueOf(A5SV6n.A2egSU(((Double) apply2).doubleValue(), 4.5d));
            case 17:
                return ((AZOQYO) this.f6405AlLFFp).AcNBzu();
            case 18:
                AZOQYO azoqyo9 = (AZOQYO) this.f6405AlLFFp;
                AZkASS aZkASS6 = (AZkASS) obj;
                boolean ARc23Z4 = AZOQYO.ARc23Z(aZkASS6);
                boolean z6 = aZkASS6.f6410A5SV6n;
                if (ARc23Z4) {
                    return Double.valueOf(z6 ? 90.0d : 10.0d);
                }
                if (!AZOQYO.AMqCpz(aZkASS6)) {
                    return Double.valueOf(z6 ? 90.0d : 30.0d);
                }
                apply3 = azoqyo9.AZkASS().f6393A5SV6n.apply(aZkASS6);
                return Double.valueOf(A5SV6n.A2egSU(((Double) apply3).doubleValue(), 4.5d));
            case 19:
                return ((AZOQYO) this.f6405AlLFFp).AZkASS();
            case 20:
                AZOQYO azoqyo10 = (AZOQYO) this.f6405AlLFFp;
                return new AlLFFp(azoqyo10.A4TApA(), azoqyo10.A2egSU());
            case 21:
                return ((AZOQYO) this.f6405AlLFFp).A4TApA();
            case 22:
                AZOQYO azoqyo11 = (AZOQYO) this.f6405AlLFFp;
                return new AlLFFp(azoqyo11.A4TApA(), azoqyo11.A2egSU());
            default:
                return (Double) ((HashMap) ((AZOQYO.ARc23Z) this.f6405AlLFFp).AaHO0E()).get((ADYaiT) obj);
        }
    }
}
