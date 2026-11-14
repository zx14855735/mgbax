package BChYOn;

import java.util.ArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class AZOQYO extends AlLFFp {

    /* renamed from: GEYgCP, reason: collision with root package name */
    public ARc23Z[] f1254GEYgCP;

    /* renamed from: EicXu4, reason: collision with root package name */
    public int f1233EicXu4 = -1;

    /* renamed from: EmJGcg, reason: collision with root package name */
    public int f1234EmJGcg = -1;

    /* renamed from: ErKPGd, reason: collision with root package name */
    public int f1235ErKPGd = -1;

    /* renamed from: EsrwYR, reason: collision with root package name */
    public int f1236EsrwYR = -1;

    /* renamed from: EwN40Z, reason: collision with root package name */
    public int f1237EwN40Z = -1;

    /* renamed from: ExjC7D, reason: collision with root package name */
    public int f1238ExjC7D = -1;

    /* renamed from: F1loUV, reason: collision with root package name */
    public float f1239F1loUV = 0.5f;

    /* renamed from: F32kj0, reason: collision with root package name */
    public float f1240F32kj0 = 0.5f;

    /* renamed from: F508T2, reason: collision with root package name */
    public float f1241F508T2 = 0.5f;

    /* renamed from: FG7pZc, reason: collision with root package name */
    public float f1242FG7pZc = 0.5f;

    /* renamed from: FM663C, reason: collision with root package name */
    public float f1243FM663C = 0.5f;

    /* renamed from: FOAO9d, reason: collision with root package name */
    public float f1244FOAO9d = 0.5f;

    /* renamed from: FSFw2u, reason: collision with root package name */
    public int f1245FSFw2u = 0;

    /* renamed from: FZu94u, reason: collision with root package name */
    public int f1246FZu94u = 0;

    /* renamed from: FdMWEC, reason: collision with root package name */
    public int f1247FdMWEC = 2;

    /* renamed from: Ff5QvW, reason: collision with root package name */
    public int f1248Ff5QvW = 2;

    /* renamed from: Fmmv0E, reason: collision with root package name */
    public int f1249Fmmv0E = 0;

    /* renamed from: FmyuN2, reason: collision with root package name */
    public int f1250FmyuN2 = -1;

    /* renamed from: FpcJKS, reason: collision with root package name */
    public int f1251FpcJKS = 0;

    /* renamed from: Fyurov, reason: collision with root package name */
    public final ArrayList f1252Fyurov = new ArrayList();
    public ARc23Z[] G16Pvp = null;
    public ARc23Z[] G2rdQT = null;

    /* renamed from: G58fqA, reason: collision with root package name */
    public int[] f1253G58fqA = null;

    /* renamed from: GGG1xW, reason: collision with root package name */
    public int f1255GGG1xW = 0;

    @Override // BChYOn.ARc23Z
    public final void A4TApA(B4ZgIw.ADYaiT aDYaiT, boolean z) {
        ARc23Z aRc23Z;
        float f;
        int i;
        super.A4TApA(aDYaiT, z);
        ARc23Z aRc23Z2 = this.f1175CrfGsy;
        boolean z2 = aRc23Z2 != null && ((ASJ6gh) aRc23Z2).f1200EH1KK8;
        int i2 = this.f1249Fmmv0E;
        ArrayList arrayList = this.f1252Fyurov;
        if (i2 != 0) {
            if (i2 == 1) {
                int size = arrayList.size();
                int i3 = 0;
                while (i3 < size) {
                    ((AYUAbz) arrayList.get(i3)).A4TApA(z2, i3, i3 == size + (-1));
                    i3++;
                }
            } else if (i2 != 2) {
                if (i2 == 3) {
                    int size2 = arrayList.size();
                    int i4 = 0;
                    while (i4 < size2) {
                        ((AYUAbz) arrayList.get(i4)).A4TApA(z2, i4, i4 == size2 + (-1));
                        i4++;
                    }
                }
            } else if (this.f1253G58fqA != null && this.G2rdQT != null && this.G16Pvp != null) {
                for (int i5 = 0; i5 < this.f1255GGG1xW; i5++) {
                    this.f1254GEYgCP[i5].BmvVmW();
                }
                int[] iArr = this.f1253G58fqA;
                int i6 = iArr[0];
                int i7 = iArr[1];
                float f2 = this.f1239F1loUV;
                ARc23Z aRc23Z3 = null;
                int i8 = 0;
                while (i8 < i6) {
                    if (z2) {
                        i = (i6 - i8) - 1;
                        f = 1.0f - this.f1239F1loUV;
                    } else {
                        f = f2;
                        i = i8;
                    }
                    ARc23Z aRc23Z4 = this.G2rdQT[i];
                    if (aRc23Z4 != null && aRc23Z4.f1188DV2E8K != 8) {
                        AMqCpz aMqCpz = aRc23Z4.f1164CNPG0E;
                        if (i8 == 0) {
                            aRc23Z4.ARc23Z(aMqCpz, this.f1164CNPG0E, this.f1269EPdU4G);
                            aRc23Z4.DXuj49 = this.f1233EicXu4;
                            aRc23Z4.f1185DG07BK = f;
                        }
                        if (i8 == i6 - 1) {
                            aRc23Z4.ARc23Z(aRc23Z4.f1166CQhlFr, this.f1166CQhlFr, this.f1270EQurEW);
                        }
                        if (i8 > 0 && aRc23Z3 != null) {
                            int i9 = this.f1245FSFw2u;
                            AMqCpz aMqCpz2 = aRc23Z3.f1166CQhlFr;
                            aRc23Z4.ARc23Z(aMqCpz, aMqCpz2, i9);
                            aRc23Z3.ARc23Z(aMqCpz2, aMqCpz, 0);
                        }
                        aRc23Z3 = aRc23Z4;
                    }
                    i8++;
                    f2 = f;
                }
                for (int i10 = 0; i10 < i7; i10++) {
                    ARc23Z aRc23Z5 = this.G16Pvp[i10];
                    if (aRc23Z5 != null && aRc23Z5.f1188DV2E8K != 8) {
                        AMqCpz aMqCpz3 = aRc23Z5.f1165COJEAR;
                        if (i10 == 0) {
                            aRc23Z5.ARc23Z(aMqCpz3, this.f1165COJEAR, this.f1265DyaChj);
                            aRc23Z5.f1190DaOi9o = this.f1234EmJGcg;
                            aRc23Z5.f1186DRlcZ9 = this.f1240F32kj0;
                        }
                        if (i10 == i7 - 1) {
                            aRc23Z5.ARc23Z(aRc23Z5.f1167CSDoyG, this.f1167CSDoyG, this.f1266ECyGFg);
                        }
                        if (i10 > 0 && aRc23Z3 != null) {
                            int i11 = this.f1246FZu94u;
                            AMqCpz aMqCpz4 = aRc23Z3.f1167CSDoyG;
                            aRc23Z5.ARc23Z(aMqCpz3, aMqCpz4, i11);
                            aRc23Z3.ARc23Z(aMqCpz4, aMqCpz3, 0);
                        }
                        aRc23Z3 = aRc23Z5;
                    }
                }
                for (int i12 = 0; i12 < i6; i12++) {
                    for (int i13 = 0; i13 < i7; i13++) {
                        int i14 = (i13 * i6) + i12;
                        if (this.f1251FpcJKS == 1) {
                            i14 = (i12 * i7) + i13;
                        }
                        ARc23Z[] aRc23ZArr = this.f1254GEYgCP;
                        if (i14 < aRc23ZArr.length && (aRc23Z = aRc23ZArr[i14]) != null && aRc23Z.f1188DV2E8K != 8) {
                            ARc23Z aRc23Z6 = this.G2rdQT[i12];
                            ARc23Z aRc23Z7 = this.G16Pvp[i13];
                            if (aRc23Z != aRc23Z6) {
                                aRc23Z.ARc23Z(aRc23Z.f1164CNPG0E, aRc23Z6.f1164CNPG0E, 0);
                                aRc23Z.ARc23Z(aRc23Z.f1166CQhlFr, aRc23Z6.f1166CQhlFr, 0);
                            }
                            if (aRc23Z != aRc23Z7) {
                                aRc23Z.ARc23Z(aRc23Z.f1165COJEAR, aRc23Z7.f1165COJEAR, 0);
                                aRc23Z.ARc23Z(aRc23Z.f1167CSDoyG, aRc23Z7.f1167CSDoyG, 0);
                            }
                        }
                    }
                }
            }
        } else if (arrayList.size() > 0) {
            ((AYUAbz) arrayList.get(0)).A4TApA(z2, 0, true);
        }
        this.f1271EUIRHA = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:230:0x036e  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0698  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x06a7  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x06c5  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x06c7  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x06aa  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x069a  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:257:0x0422 -> B:202:0x0369). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:258:0x0424 -> B:202:0x0369). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:260:0x042a -> B:202:0x0369). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:261:0x042c -> B:202:0x0369). Please report as a decompilation issue!!! */
    @Override // BChYOn.AlLFFp
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void CqNSpT(int r38, int r39, int r40, int r41) {
        /*
            Method dump skipped, instructions count: 1739
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: BChYOn.AZOQYO.CqNSpT(int, int, int, int):void");
    }

    public final int CtFAbx(ARc23Z aRc23Z, int i) {
        ARc23Z aRc23Z2;
        if (aRc23Z != null) {
            int[] iArr = aRc23Z.f1195Dphsd2;
            if (iArr[1] == 3) {
                int i2 = aRc23Z.f1149B7CMnp;
                if (i2 != 0) {
                    if (i2 == 2) {
                        int i3 = (int) (aRc23Z.f1156BPw6Q8 * i);
                        if (i3 != aRc23Z.AaHO0E()) {
                            aRc23Z.f1136ASJ6gh = true;
                            CrfGsy(aRc23Z, iArr[0], aRc23Z.B2KMhB(), 1, i3);
                        }
                        return i3;
                    }
                    aRc23Z2 = aRc23Z;
                    if (i2 == 1) {
                        return aRc23Z2.AaHO0E();
                    }
                    if (i2 == 3) {
                        return (int) ((aRc23Z2.B2KMhB() * aRc23Z2.f1178D07BeM) + 0.5f);
                    }
                }
            } else {
                aRc23Z2 = aRc23Z;
            }
            return aRc23Z2.AaHO0E();
        }
        return 0;
    }

    public final int CtxOCS(ARc23Z aRc23Z, int i) {
        ARc23Z aRc23Z2;
        if (aRc23Z != null) {
            int[] iArr = aRc23Z.f1195Dphsd2;
            if (iArr[0] == 3) {
                int i2 = aRc23Z.f1148B4ZgIw;
                if (i2 != 0) {
                    if (i2 == 2) {
                        int i3 = (int) (aRc23Z.f1153BIYEnU * i);
                        if (i3 != aRc23Z.B2KMhB()) {
                            aRc23Z.f1136ASJ6gh = true;
                            CrfGsy(aRc23Z, 1, i3, iArr[1], aRc23Z.AaHO0E());
                        }
                        return i3;
                    }
                    aRc23Z2 = aRc23Z;
                    if (i2 == 1) {
                        return aRc23Z2.B2KMhB();
                    }
                    if (i2 == 3) {
                        return (int) ((aRc23Z2.AaHO0E() * aRc23Z2.f1178D07BeM) + 0.5f);
                    }
                }
            } else {
                aRc23Z2 = aRc23Z;
            }
            return aRc23Z2.B2KMhB();
        }
        return 0;
    }
}
