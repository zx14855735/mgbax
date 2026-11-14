package OO3awZ;

import java.util.HashMap;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class A5SV6n {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final String f6391A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final Function f6392A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final Function f6393A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final boolean f6394ADYaiT;
    public final Function AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public final A4TApA f6395ARc23Z;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public final Function f6396ASJ6gh;

    /* renamed from: AYUAbz, reason: collision with root package name */
    public final AMqCpz f6397AYUAbz;

    /* renamed from: AZOQYO, reason: collision with root package name */
    public final HashMap f6398AZOQYO;

    public A5SV6n(String str, Function function, Function function2, boolean z, Function function3, A4TApA a4TApA, Function function4) {
        this.f6398AZOQYO = new HashMap();
        this.f6391A2egSU = str;
        this.f6392A4TApA = function;
        this.f6393A5SV6n = function2;
        this.f6394ADYaiT = z;
        this.AMqCpz = function3;
        this.f6395ARc23Z = a4TApA;
        this.f6396ASJ6gh = function4;
        this.f6397AYUAbz = null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x005f, code lost:
    
        if (r10 <= 100.0d) goto L25;
     */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a8 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a7 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static double A2egSU(double r17, double r19) {
        /*
            r0 = r17
            double r2 = OO3awZ.A2egSU.AaHO0E(r17, r19)
            r4 = 0
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 >= 0) goto Le
            r2 = 4636737291354636288(0x4059000000000000, double:100.0)
        Le:
            r6 = 0
            int r8 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r8 < 0) goto L61
            r8 = 4636737291354636288(0x4059000000000000, double:100.0)
            int r10 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            if (r10 <= 0) goto L1b
            goto L61
        L1b:
            double r10 = OO3awZ.A2egSU.B2KMhB(r0)
            r12 = 4617315517961601024(0x4014000000000000, double:5.0)
            double r14 = r10 + r12
            double r14 = r14 / r19
            double r14 = r14 - r12
            int r12 = (r14 > r6 ? 1 : (r14 == r6 ? 0 : -1))
            if (r12 < 0) goto L61
            int r12 = (r14 > r8 ? 1 : (r14 == r8 ? 0 : -1))
            if (r12 <= 0) goto L2f
            goto L61
        L2f:
            double r10 = OO3awZ.A2egSU.AzWtSf(r10, r14)
            double r12 = r10 - r19
            double r12 = java.lang.Math.abs(r12)
            int r16 = (r10 > r19 ? 1 : (r10 == r19 ? 0 : -1))
            if (r16 >= 0) goto L47
            r10 = 4585925428558828667(0x3fa47ae147ae147b, double:0.04)
            int r16 = (r12 > r10 ? 1 : (r12 == r10 ? 0 : -1))
            if (r16 <= 0) goto L47
            goto L61
        L47:
            double r14 = r14 / r8
            double r10 = OO3awZ.A2egSU.AYUAbz(r14)
            r12 = 4637863191261478912(0x405d000000000000, double:116.0)
            double r10 = r10 * r12
            r12 = 4625196817309499392(0x4030000000000000, double:16.0)
            double r10 = r10 - r12
            r12 = 4600877379321698714(0x3fd999999999999a, double:0.4)
            double r10 = r10 - r12
            int r12 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
            if (r12 < 0) goto L61
            int r6 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1))
            if (r6 <= 0) goto L63
        L61:
            r10 = -4616189618054758400(0xbff0000000000000, double:-1.0)
        L63:
            double r4 = java.lang.Math.max(r4, r10)
            double r6 = OO3awZ.A2egSU.AmA8tU(r2, r0)
            double r8 = OO3awZ.A2egSU.AmA8tU(r4, r0)
            long r0 = java.lang.Math.round(r0)
            r10 = 60
            int r12 = (r0 > r10 ? 1 : (r0 == r10 ? 0 : -1))
            if (r12 >= 0) goto L9e
            double r0 = r6 - r8
            double r0 = java.lang.Math.abs(r0)
            r10 = 4591870180066957722(0x3fb999999999999a, double:0.1)
            int r12 = (r0 > r10 ? 1 : (r0 == r10 ? 0 : -1))
            if (r12 >= 0) goto L92
            int r0 = (r6 > r19 ? 1 : (r6 == r19 ? 0 : -1))
            if (r0 >= 0) goto L92
            int r0 = (r8 > r19 ? 1 : (r8 == r19 ? 0 : -1))
            if (r0 >= 0) goto L92
            r0 = 1
            goto L93
        L92:
            r0 = 0
        L93:
            int r1 = (r6 > r19 ? 1 : (r6 == r19 ? 0 : -1))
            if (r1 >= 0) goto La7
            int r1 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r1 >= 0) goto La7
            if (r0 == 0) goto La8
            goto La7
        L9e:
            int r0 = (r8 > r19 ? 1 : (r8 == r19 ? 0 : -1))
            if (r0 >= 0) goto La8
            int r0 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r0 < 0) goto La7
            goto La8
        La7:
            return r2
        La8:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: OO3awZ.A5SV6n.A2egSU(double, double):double");
    }

    public static A5SV6n A4TApA(String str, Function function, Function function2) {
        return new A5SV6n(str, function, function2, false, null, null, null);
    }

    public final double A5SV6n(AZkASS aZkASS) {
        Object apply;
        Object apply2;
        Object apply3;
        Object apply4;
        Object apply5;
        Object apply6;
        double d = aZkASS.f6411ADYaiT;
        boolean z = d < 0.0d;
        Function function = this.f6396ASJ6gh;
        if (function == null) {
            apply = this.f6393A5SV6n.apply(aZkASS);
            double doubleValue = ((Double) apply).doubleValue();
            Function function2 = this.AMqCpz;
            if (function2 == null) {
                return doubleValue;
            }
            apply2 = function2.apply(aZkASS);
            double A5SV6n2 = ((A5SV6n) apply2).A5SV6n(aZkASS);
            double A2egSU2 = this.f6395ARc23Z.A2egSU(d);
            if (A2egSU.AmA8tU(A5SV6n2, doubleValue) < A2egSU2) {
                doubleValue = A2egSU(A5SV6n2, A2egSU2);
            }
            if (z) {
                doubleValue = A2egSU(A5SV6n2, A2egSU2);
            }
            return (!this.f6394ADYaiT || 50.0d > doubleValue || doubleValue >= 60.0d) ? doubleValue : A2egSU.AmA8tU(49.0d, A5SV6n2) >= A2egSU2 ? 49.0d : 60.0d;
        }
        apply3 = function.apply(aZkASS);
        AlLFFp alLFFp = (AlLFFp) apply3;
        A5SV6n a5SV6n = alLFFp.f6422A2egSU;
        apply4 = this.AMqCpz.apply(aZkASS);
        double A5SV6n3 = ((A5SV6n) apply4).A5SV6n(aZkASS);
        boolean equals = this.f6391A2egSU.equals(a5SV6n.f6391A2egSU);
        double d2 = aZkASS.f6410A5SV6n ? 1.0d : -1.0d;
        double A2egSU3 = a5SV6n.f6395ARc23Z.A2egSU(d);
        A5SV6n a5SV6n2 = alLFFp.f6423A4TApA;
        double A2egSU4 = a5SV6n2.f6395ARc23Z.A2egSU(d);
        apply5 = a5SV6n.f6393A5SV6n.apply(aZkASS);
        double doubleValue2 = ((Double) apply5).doubleValue();
        if (A2egSU.AmA8tU(A5SV6n3, doubleValue2) < A2egSU3) {
            doubleValue2 = A2egSU(A5SV6n3, A2egSU3);
        }
        apply6 = a5SV6n2.f6393A5SV6n.apply(aZkASS);
        double doubleValue3 = ((Double) apply6).doubleValue();
        if (A2egSU.AmA8tU(A5SV6n3, doubleValue3) < A2egSU4) {
            doubleValue3 = A2egSU(A5SV6n3, A2egSU4);
        }
        if (z) {
            doubleValue2 = A2egSU(A5SV6n3, A2egSU3);
            doubleValue3 = A2egSU(A5SV6n3, A2egSU4);
        }
        if ((doubleValue3 - doubleValue2) * d2 < 10.0d) {
            double d3 = 10.0d * d2;
            double d4 = doubleValue2 + d3;
            if (d4 < 0.0d) {
                d4 = 0.0d;
            } else if (d4 > 100.0d) {
                d4 = 100.0d;
            }
            if ((d4 - doubleValue2) * d2 < 10.0d) {
                double d5 = d4 - d3;
                doubleValue2 = d5 < 0.0d ? 0.0d : d5 > 100.0d ? 100.0d : d5;
            }
            doubleValue3 = d4;
        }
        if (50.0d > doubleValue2 || doubleValue2 >= 60.0d) {
            if (50.0d <= doubleValue3 && doubleValue3 < 60.0d) {
                doubleValue3 = d2 > 0.0d ? 60.0d : 49.0d;
            }
        } else if (d2 > 0.0d) {
            doubleValue3 = Math.max(doubleValue3, (10.0d * d2) + 60.0d);
            doubleValue2 = 60.0d;
        } else {
            doubleValue3 = Math.min(doubleValue3, (10.0d * d2) + 49.0d);
            doubleValue2 = 49.0d;
        }
        return equals ? doubleValue2 : doubleValue3;
    }

    public A5SV6n(AMqCpz aMqCpz, AMqCpz aMqCpz2, AMqCpz aMqCpz3) {
        this.f6398AZOQYO = new HashMap();
        this.f6391A2egSU = "control_highlight";
        this.f6392A4TApA = aMqCpz;
        this.f6393A5SV6n = aMqCpz2;
        this.f6394ADYaiT = false;
        this.AMqCpz = null;
        this.f6395ARc23Z = null;
        this.f6396ASJ6gh = null;
        this.f6397AYUAbz = aMqCpz3;
    }
}
