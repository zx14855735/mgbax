package B4ZgIw;

import com.sigmob.sdk.base.views.r;
import java.util.Arrays;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class ADYaiT {

    /* renamed from: B25kr6, reason: collision with root package name */
    public static boolean f1055B25kr6 = false;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public static int f1056B2KMhB = 1000;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final ASJ6gh f1059A5SV6n;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public A4TApA[] f1061ARc23Z;

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final A5SV6n f1067AcNBzu;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public A4TApA f1070AzWtSf;

    /* renamed from: A2egSU, reason: collision with root package name */
    public boolean f1057A2egSU = false;

    /* renamed from: A4TApA, reason: collision with root package name */
    public int f1058A4TApA = 0;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public int f1060ADYaiT = 32;
    public int AMqCpz = 32;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public boolean f1062ASJ6gh = false;

    /* renamed from: AYUAbz, reason: collision with root package name */
    public boolean[] f1063AYUAbz = new boolean[32];

    /* renamed from: AZOQYO, reason: collision with root package name */
    public int f1064AZOQYO = 1;

    /* renamed from: AZkASS, reason: collision with root package name */
    public int f1065AZkASS = 0;

    /* renamed from: AaHO0E, reason: collision with root package name */
    public int f1066AaHO0E = 32;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public AZOQYO[] f1068AlLFFp = new AZOQYO[f1056B2KMhB];

    /* renamed from: AmA8tU, reason: collision with root package name */
    public int f1069AmA8tU = 0;

    public ADYaiT() {
        this.f1061ARc23Z = null;
        this.f1061ARc23Z = new A4TApA[32];
        B4ZgIw();
        A5SV6n a5SV6n = new A5SV6n();
        this.f1067AcNBzu = a5SV6n;
        ASJ6gh aSJ6gh = new ASJ6gh(a5SV6n);
        aSJ6gh.f1074ARc23Z = new AZOQYO[r.b.d];
        aSJ6gh.f1075ASJ6gh = new AZOQYO[r.b.d];
        aSJ6gh.f1076AYUAbz = 0;
        aSJ6gh.f1077AZOQYO = new K1Z3yj.A2egSU(4, aSJ6gh);
        this.f1059A5SV6n = aSJ6gh;
        this.f1070AzWtSf = new A4TApA(a5SV6n);
    }

    public static int AmA8tU(Object obj) {
        AZOQYO azoqyo = ((BChYOn.AMqCpz) obj).f1130AZOQYO;
        if (azoqyo != null) {
            return (int) (azoqyo.f1083B25kr6 + 0.5f);
        }
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r4v0 */
    public final AZOQYO A2egSU(int i) {
        AMqCpz aMqCpz = this.f1067AcNBzu.f1053A4TApA;
        int i2 = aMqCpz.f1072A4TApA;
        AZOQYO azoqyo = null;
        if (i2 > 0) {
            int i3 = i2 - 1;
            ?? r3 = aMqCpz.f1071A2egSU;
            ?? r4 = r3[i3];
            r3[i3] = 0;
            aMqCpz.f1072A4TApA = i3;
            azoqyo = r4;
        }
        AZOQYO azoqyo2 = azoqyo;
        if (azoqyo2 == null) {
            azoqyo2 = new AZOQYO(i);
            azoqyo2.f1090BI9f7h = i;
        } else {
            azoqyo2.A5SV6n();
            azoqyo2.f1090BI9f7h = i;
        }
        int i4 = this.f1069AmA8tU;
        int i5 = f1056B2KMhB;
        if (i4 >= i5) {
            int i6 = i5 * 2;
            f1056B2KMhB = i6;
            this.f1068AlLFFp = (AZOQYO[]) Arrays.copyOf(this.f1068AlLFFp, i6);
        }
        AZOQYO[] azoqyoArr = this.f1068AlLFFp;
        int i7 = this.f1069AmA8tU;
        this.f1069AmA8tU = i7 + 1;
        azoqyoArr[i7] = azoqyo2;
        return azoqyo2;
    }

    public final void A4TApA(AZOQYO azoqyo, AZOQYO azoqyo2, int i, float f, AZOQYO azoqyo3, AZOQYO azoqyo4, int i2, int i3) {
        A4TApA AcNBzu2 = AcNBzu();
        if (azoqyo2 == azoqyo3) {
            AcNBzu2.f1051ADYaiT.ASJ6gh(azoqyo, 1.0f);
            AcNBzu2.f1051ADYaiT.ASJ6gh(azoqyo4, 1.0f);
            AcNBzu2.f1051ADYaiT.ASJ6gh(azoqyo2, -2.0f);
        } else if (f == 0.5f) {
            AcNBzu2.f1051ADYaiT.ASJ6gh(azoqyo, 1.0f);
            AcNBzu2.f1051ADYaiT.ASJ6gh(azoqyo2, -1.0f);
            AcNBzu2.f1051ADYaiT.ASJ6gh(azoqyo3, -1.0f);
            AcNBzu2.f1051ADYaiT.ASJ6gh(azoqyo4, 1.0f);
            if (i > 0 || i2 > 0) {
                AcNBzu2.f1049A4TApA = (-i) + i2;
            }
        } else if (f <= 0.0f) {
            AcNBzu2.f1051ADYaiT.ASJ6gh(azoqyo, -1.0f);
            AcNBzu2.f1051ADYaiT.ASJ6gh(azoqyo2, 1.0f);
            AcNBzu2.f1049A4TApA = i;
        } else if (f >= 1.0f) {
            AcNBzu2.f1051ADYaiT.ASJ6gh(azoqyo4, -1.0f);
            AcNBzu2.f1051ADYaiT.ASJ6gh(azoqyo3, 1.0f);
            AcNBzu2.f1049A4TApA = -i2;
        } else {
            float f2 = 1.0f - f;
            AcNBzu2.f1051ADYaiT.ASJ6gh(azoqyo, f2 * 1.0f);
            AcNBzu2.f1051ADYaiT.ASJ6gh(azoqyo2, f2 * (-1.0f));
            AcNBzu2.f1051ADYaiT.ASJ6gh(azoqyo3, (-1.0f) * f);
            AcNBzu2.f1051ADYaiT.ASJ6gh(azoqyo4, 1.0f * f);
            if (i > 0 || i2 > 0) {
                AcNBzu2.f1049A4TApA = (i2 * f) + ((-i) * f2);
            }
        }
        if (i3 != 8) {
            AcNBzu2.A2egSU(this, i3);
        }
        A5SV6n(AcNBzu2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:66:0x00d5, code lost:
    
        if (r4.f1089BChYOn <= 1) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00d7, code lost:
    
        r12 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x00d9, code lost:
    
        r12 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x00e3, code lost:
    
        if (r4.f1089BChYOn <= 1) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x00fa, code lost:
    
        if (r4.f1089BChYOn <= 1) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x00fc, code lost:
    
        r14 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x00fe, code lost:
    
        r14 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0108, code lost:
    
        if (r4.f1089BChYOn <= 1) goto L76;
     */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:150:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void A5SV6n(B4ZgIw.A4TApA r18) {
        /*
            Method dump skipped, instructions count: 455
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: B4ZgIw.ADYaiT.A5SV6n(B4ZgIw.A4TApA):void");
    }

    public final void ADYaiT(AZOQYO azoqyo, int i) {
        int i2 = azoqyo.f1081AmA8tU;
        if (i2 == -1) {
            azoqyo.ADYaiT(this, i);
            for (int i3 = 0; i3 < this.f1058A4TApA + 1; i3++) {
                AZOQYO azoqyo2 = this.f1067AcNBzu.f1054A5SV6n[i3];
            }
            return;
        }
        if (i2 == -1) {
            A4TApA AcNBzu2 = AcNBzu();
            AcNBzu2.f1048A2egSU = azoqyo;
            float f = i;
            azoqyo.f1083B25kr6 = f;
            AcNBzu2.f1049A4TApA = f;
            AcNBzu2.AMqCpz = true;
            A5SV6n(AcNBzu2);
            return;
        }
        A4TApA a4TApA = this.f1061ARc23Z[i2];
        if (a4TApA.AMqCpz) {
            a4TApA.f1049A4TApA = i;
            return;
        }
        if (a4TApA.f1051ADYaiT.ADYaiT() == 0) {
            a4TApA.AMqCpz = true;
            a4TApA.f1049A4TApA = i;
            return;
        }
        A4TApA AcNBzu3 = AcNBzu();
        if (i < 0) {
            AcNBzu3.f1049A4TApA = i * (-1);
            AcNBzu3.f1051ADYaiT.ASJ6gh(azoqyo, 1.0f);
        } else {
            AcNBzu3.f1049A4TApA = i;
            AcNBzu3.f1051ADYaiT.ASJ6gh(azoqyo, -1.0f);
        }
        A5SV6n(AcNBzu3);
    }

    public final void AMqCpz(AZOQYO azoqyo, AZOQYO azoqyo2, int i, int i2) {
        if (i2 == 8 && azoqyo2.f1084B2KMhB && azoqyo.f1081AmA8tU == -1) {
            azoqyo.ADYaiT(this, azoqyo2.f1083B25kr6 + i);
            return;
        }
        A4TApA AcNBzu2 = AcNBzu();
        boolean z = false;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                z = true;
            }
            AcNBzu2.f1049A4TApA = i;
        }
        if (z) {
            AcNBzu2.f1051ADYaiT.ASJ6gh(azoqyo, 1.0f);
            AcNBzu2.f1051ADYaiT.ASJ6gh(azoqyo2, -1.0f);
        } else {
            AcNBzu2.f1051ADYaiT.ASJ6gh(azoqyo, -1.0f);
            AcNBzu2.f1051ADYaiT.ASJ6gh(azoqyo2, 1.0f);
        }
        if (i2 != 8) {
            AcNBzu2.A2egSU(this, i2);
        }
        A5SV6n(AcNBzu2);
    }

    public final void ARc23Z(AZOQYO azoqyo, AZOQYO azoqyo2, int i, int i2) {
        A4TApA AcNBzu2 = AcNBzu();
        AZOQYO AlLFFp2 = AlLFFp();
        AlLFFp2.f1082AzWtSf = 0;
        AcNBzu2.A4TApA(azoqyo, azoqyo2, AlLFFp2, i);
        if (i2 != 8) {
            AcNBzu2.f1051ADYaiT.ASJ6gh(AZkASS(i2), (int) (AcNBzu2.f1051ADYaiT.A5SV6n(AlLFFp2) * (-1.0f)));
        }
        A5SV6n(AcNBzu2);
    }

    public final void ASJ6gh(AZOQYO azoqyo, AZOQYO azoqyo2, int i, int i2) {
        A4TApA AcNBzu2 = AcNBzu();
        AZOQYO AlLFFp2 = AlLFFp();
        AlLFFp2.f1082AzWtSf = 0;
        AcNBzu2.A5SV6n(azoqyo, azoqyo2, AlLFFp2, i);
        if (i2 != 8) {
            AcNBzu2.f1051ADYaiT.ASJ6gh(AZkASS(i2), (int) (AcNBzu2.f1051ADYaiT.A5SV6n(AlLFFp2) * (-1.0f)));
        }
        A5SV6n(AcNBzu2);
    }

    public final void AYUAbz(A4TApA a4TApA) {
        int i;
        if (a4TApA.AMqCpz) {
            a4TApA.f1048A2egSU.ADYaiT(this, a4TApA.f1049A4TApA);
        } else {
            A4TApA[] a4TApAArr = this.f1061ARc23Z;
            int i2 = this.f1065AZkASS;
            a4TApAArr[i2] = a4TApA;
            AZOQYO azoqyo = a4TApA.f1048A2egSU;
            azoqyo.f1081AmA8tU = i2;
            this.f1065AZkASS = i2 + 1;
            azoqyo.AMqCpz(this, a4TApA);
        }
        if (this.f1057A2egSU) {
            int i3 = 0;
            while (i3 < this.f1065AZkASS) {
                if (this.f1061ARc23Z[i3] == null) {
                    System.out.getClass();
                }
                A4TApA a4TApA2 = this.f1061ARc23Z[i3];
                if (a4TApA2 != null && a4TApA2.AMqCpz) {
                    a4TApA2.f1048A2egSU.ADYaiT(this, a4TApA2.f1049A4TApA);
                    this.f1067AcNBzu.f1052A2egSU.A4TApA(a4TApA2);
                    this.f1061ARc23Z[i3] = null;
                    int i4 = i3 + 1;
                    int i5 = i4;
                    while (true) {
                        i = this.f1065AZkASS;
                        if (i4 >= i) {
                            break;
                        }
                        A4TApA[] a4TApAArr2 = this.f1061ARc23Z;
                        int i6 = i4 - 1;
                        A4TApA a4TApA3 = a4TApAArr2[i4];
                        a4TApAArr2[i6] = a4TApA3;
                        AZOQYO azoqyo2 = a4TApA3.f1048A2egSU;
                        if (azoqyo2.f1081AmA8tU == i4) {
                            azoqyo2.f1081AmA8tU = i6;
                        }
                        i5 = i4;
                        i4++;
                    }
                    if (i5 < i) {
                        this.f1061ARc23Z[i5] = null;
                    }
                    this.f1065AZkASS = i - 1;
                    i3--;
                }
                i3++;
            }
            this.f1057A2egSU = false;
        }
    }

    public final void AZOQYO() {
        for (int i = 0; i < this.f1065AZkASS; i++) {
            A4TApA a4TApA = this.f1061ARc23Z[i];
            a4TApA.f1048A2egSU.f1083B25kr6 = a4TApA.f1049A4TApA;
        }
    }

    public final AZOQYO AZkASS(int i) {
        if (this.f1064AZOQYO + 1 >= this.AMqCpz) {
            AzWtSf();
        }
        AZOQYO A2egSU2 = A2egSU(4);
        int i2 = this.f1058A4TApA + 1;
        this.f1058A4TApA = i2;
        this.f1064AZOQYO++;
        A2egSU2.f1080AlLFFp = i2;
        A2egSU2.f1082AzWtSf = i;
        this.f1067AcNBzu.f1054A5SV6n[i2] = A2egSU2;
        ASJ6gh aSJ6gh = this.f1059A5SV6n;
        aSJ6gh.f1077AZOQYO.f4174AlLFFp = A2egSU2;
        float[] fArr = A2egSU2.f1086B4ZgIw;
        Arrays.fill(fArr, 0.0f);
        fArr[A2egSU2.f1082AzWtSf] = 1.0f;
        aSJ6gh.AZkASS(A2egSU2);
        return A2egSU2;
    }

    public final AZOQYO AaHO0E(Object obj) {
        if (obj == null) {
            return null;
        }
        if (this.f1064AZOQYO + 1 >= this.AMqCpz) {
            AzWtSf();
        }
        if (!(obj instanceof BChYOn.AMqCpz)) {
            return null;
        }
        BChYOn.AMqCpz aMqCpz = (BChYOn.AMqCpz) obj;
        AZOQYO azoqyo = aMqCpz.f1130AZOQYO;
        if (azoqyo == null) {
            aMqCpz.AaHO0E();
            azoqyo = aMqCpz.f1130AZOQYO;
        }
        int i = azoqyo.f1080AlLFFp;
        A5SV6n a5SV6n = this.f1067AcNBzu;
        if (i != -1 && i <= this.f1058A4TApA && a5SV6n.f1054A5SV6n[i] != null) {
            return azoqyo;
        }
        if (i != -1) {
            azoqyo.A5SV6n();
        }
        int i2 = this.f1058A4TApA + 1;
        this.f1058A4TApA = i2;
        this.f1064AZOQYO++;
        azoqyo.f1080AlLFFp = i2;
        azoqyo.f1090BI9f7h = 1;
        a5SV6n.f1054A5SV6n[i2] = azoqyo;
        return azoqyo;
    }

    public final A4TApA AcNBzu() {
        Object obj;
        A5SV6n a5SV6n = this.f1067AcNBzu;
        AMqCpz aMqCpz = a5SV6n.f1052A2egSU;
        int i = aMqCpz.f1072A4TApA;
        if (i > 0) {
            int i2 = i - 1;
            Object[] objArr = aMqCpz.f1071A2egSU;
            obj = objArr[i2];
            objArr[i2] = null;
            aMqCpz.f1072A4TApA = i2;
        } else {
            obj = null;
        }
        A4TApA a4TApA = (A4TApA) obj;
        if (a4TApA == null) {
            return new A4TApA(a5SV6n);
        }
        a4TApA.f1048A2egSU = null;
        a4TApA.f1051ADYaiT.A4TApA();
        a4TApA.f1049A4TApA = 0.0f;
        a4TApA.AMqCpz = false;
        return a4TApA;
    }

    public final AZOQYO AlLFFp() {
        if (this.f1064AZOQYO + 1 >= this.AMqCpz) {
            AzWtSf();
        }
        AZOQYO A2egSU2 = A2egSU(3);
        int i = this.f1058A4TApA + 1;
        this.f1058A4TApA = i;
        this.f1064AZOQYO++;
        A2egSU2.f1080AlLFFp = i;
        this.f1067AcNBzu.f1054A5SV6n[i] = A2egSU2;
        return A2egSU2;
    }

    public final void AzWtSf() {
        int i = this.f1060ADYaiT * 2;
        this.f1060ADYaiT = i;
        this.f1061ARc23Z = (A4TApA[]) Arrays.copyOf(this.f1061ARc23Z, i);
        A5SV6n a5SV6n = this.f1067AcNBzu;
        a5SV6n.f1054A5SV6n = (AZOQYO[]) Arrays.copyOf(a5SV6n.f1054A5SV6n, this.f1060ADYaiT);
        int i2 = this.f1060ADYaiT;
        this.f1063AYUAbz = new boolean[i2];
        this.AMqCpz = i2;
        this.f1066AaHO0E = i2;
    }

    public final void B25kr6() {
        ASJ6gh aSJ6gh = this.f1059A5SV6n;
        if (aSJ6gh.AMqCpz()) {
            AZOQYO();
            return;
        }
        if (!this.f1062ASJ6gh) {
            B2KMhB(aSJ6gh);
            return;
        }
        for (int i = 0; i < this.f1065AZkASS; i++) {
            if (!this.f1061ARc23Z[i].AMqCpz) {
                B2KMhB(aSJ6gh);
                return;
            }
        }
        AZOQYO();
    }

    public final void B2KMhB(ASJ6gh aSJ6gh) {
        int i = 0;
        while (true) {
            if (i >= this.f1065AZkASS) {
                break;
            }
            A4TApA a4TApA = this.f1061ARc23Z[i];
            int i2 = 1;
            if (a4TApA.f1048A2egSU.f1090BI9f7h != 1) {
                float f = 0.0f;
                if (a4TApA.f1049A4TApA < 0.0f) {
                    boolean z = false;
                    int i3 = 0;
                    while (!z) {
                        i3 += i2;
                        float f2 = Float.MAX_VALUE;
                        int i4 = 0;
                        int i5 = -1;
                        int i6 = -1;
                        int i7 = 0;
                        while (i4 < this.f1065AZkASS) {
                            A4TApA a4TApA2 = this.f1061ARc23Z[i4];
                            if (a4TApA2.f1048A2egSU.f1090BI9f7h != i2 && !a4TApA2.AMqCpz && a4TApA2.f1049A4TApA < f) {
                                int ADYaiT2 = a4TApA2.f1051ADYaiT.ADYaiT();
                                int i8 = 0;
                                while (i8 < ADYaiT2) {
                                    AZOQYO AMqCpz = a4TApA2.f1051ADYaiT.AMqCpz(i8);
                                    float A5SV6n2 = a4TApA2.f1051ADYaiT.A5SV6n(AMqCpz);
                                    if (A5SV6n2 > f) {
                                        for (int i9 = 0; i9 < 9; i9++) {
                                            float f3 = AMqCpz.f1085B3GDIM[i9] / A5SV6n2;
                                            if ((f3 < f2 && i9 == i7) || i9 > i7) {
                                                i7 = i9;
                                                i6 = AMqCpz.f1080AlLFFp;
                                                i5 = i4;
                                                f2 = f3;
                                            }
                                        }
                                    }
                                    i8++;
                                    f = 0.0f;
                                }
                            }
                            i4++;
                            f = 0.0f;
                            i2 = 1;
                        }
                        if (i5 != -1) {
                            A4TApA a4TApA3 = this.f1061ARc23Z[i5];
                            a4TApA3.f1048A2egSU.f1081AmA8tU = -1;
                            a4TApA3.ASJ6gh(this.f1067AcNBzu.f1054A5SV6n[i6]);
                            AZOQYO azoqyo = a4TApA3.f1048A2egSU;
                            azoqyo.f1081AmA8tU = i5;
                            azoqyo.AMqCpz(this, a4TApA3);
                        } else {
                            z = true;
                        }
                        if (i3 > this.f1064AZOQYO / 2) {
                            z = true;
                        }
                        f = 0.0f;
                        i2 = 1;
                    }
                }
            }
            i++;
        }
        B3GDIM(aSJ6gh);
        AZOQYO();
    }

    public final void B3GDIM(A4TApA a4TApA) {
        boolean z;
        for (int i = 0; i < this.f1064AZOQYO; i++) {
            this.f1063AYUAbz[i] = false;
        }
        boolean z2 = false;
        int i2 = 0;
        while (!z2) {
            int i3 = 1;
            i2++;
            if (i2 >= this.f1064AZOQYO * 2) {
                return;
            }
            AZOQYO azoqyo = a4TApA.f1048A2egSU;
            if (azoqyo != null) {
                this.f1063AYUAbz[azoqyo.f1080AlLFFp] = true;
            }
            AZOQYO ADYaiT2 = a4TApA.ADYaiT(this.f1063AYUAbz);
            if (ADYaiT2 != null) {
                boolean[] zArr = this.f1063AYUAbz;
                int i4 = ADYaiT2.f1080AlLFFp;
                if (zArr[i4]) {
                    return;
                } else {
                    zArr[i4] = true;
                }
            }
            if (ADYaiT2 != null) {
                float f = Float.MAX_VALUE;
                int i5 = 0;
                int i6 = -1;
                while (i5 < this.f1065AZkASS) {
                    A4TApA a4TApA2 = this.f1061ARc23Z[i5];
                    if (a4TApA2.f1048A2egSU.f1090BI9f7h != i3 && !a4TApA2.AMqCpz) {
                        A2egSU a2egSU = a4TApA2.f1051ADYaiT;
                        int i7 = a2egSU.f1045AYUAbz;
                        if (i7 != -1) {
                            for (int i8 = 0; i7 != -1 && i8 < a2egSU.f1039A2egSU; i8++) {
                                if (a2egSU.AMqCpz[i7] == ADYaiT2.f1080AlLFFp) {
                                    z = true;
                                    break;
                                }
                                i7 = a2egSU.f1043ARc23Z[i7];
                            }
                        }
                        z = false;
                        if (z) {
                            float A5SV6n2 = a4TApA2.f1051ADYaiT.A5SV6n(ADYaiT2);
                            if (A5SV6n2 < 0.0f) {
                                float f2 = (-a4TApA2.f1049A4TApA) / A5SV6n2;
                                if (f2 < f) {
                                    f = f2;
                                    i6 = i5;
                                }
                            }
                        }
                    }
                    i5++;
                    i3 = 1;
                }
                if (i6 > -1) {
                    A4TApA a4TApA3 = this.f1061ARc23Z[i6];
                    a4TApA3.f1048A2egSU.f1081AmA8tU = -1;
                    a4TApA3.ASJ6gh(ADYaiT2);
                    AZOQYO azoqyo2 = a4TApA3.f1048A2egSU;
                    azoqyo2.f1081AmA8tU = i6;
                    azoqyo2.AMqCpz(this, a4TApA3);
                }
            } else {
                z2 = true;
            }
        }
    }

    public final void B4ZgIw() {
        for (int i = 0; i < this.f1065AZkASS; i++) {
            A4TApA a4TApA = this.f1061ARc23Z[i];
            if (a4TApA != null) {
                this.f1067AcNBzu.f1052A2egSU.A4TApA(a4TApA);
            }
            this.f1061ARc23Z[i] = null;
        }
    }

    public final void B7CMnp() {
        A5SV6n a5SV6n;
        int i = 0;
        while (true) {
            a5SV6n = this.f1067AcNBzu;
            AZOQYO[] azoqyoArr = a5SV6n.f1054A5SV6n;
            if (i >= azoqyoArr.length) {
                break;
            }
            AZOQYO azoqyo = azoqyoArr[i];
            if (azoqyo != null) {
                azoqyo.A5SV6n();
            }
            i++;
        }
        AMqCpz aMqCpz = a5SV6n.f1053A4TApA;
        AZOQYO[] azoqyoArr2 = this.f1068AlLFFp;
        int i2 = this.f1069AmA8tU;
        aMqCpz.getClass();
        if (i2 > azoqyoArr2.length) {
            i2 = azoqyoArr2.length;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            AZOQYO azoqyo2 = azoqyoArr2[i3];
            int i4 = aMqCpz.f1072A4TApA;
            Object[] objArr = aMqCpz.f1071A2egSU;
            if (i4 < objArr.length) {
                objArr[i4] = azoqyo2;
                aMqCpz.f1072A4TApA = i4 + 1;
            }
        }
        this.f1069AmA8tU = 0;
        Arrays.fill(a5SV6n.f1054A5SV6n, (Object) null);
        this.f1058A4TApA = 0;
        ASJ6gh aSJ6gh = this.f1059A5SV6n;
        aSJ6gh.f1076AYUAbz = 0;
        aSJ6gh.f1049A4TApA = 0.0f;
        this.f1064AZOQYO = 1;
        for (int i5 = 0; i5 < this.f1065AZkASS; i5++) {
            A4TApA a4TApA = this.f1061ARc23Z[i5];
        }
        B4ZgIw();
        this.f1065AZkASS = 0;
        this.f1070AzWtSf = new A4TApA(a5SV6n);
    }
}
