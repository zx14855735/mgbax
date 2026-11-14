package BChYOn;

import ADYaiT.DUi7mC;
import BI9f7h.B25kr6;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class ASJ6gh extends AmA8tU {

    /* renamed from: DvK7DB, reason: collision with root package name */
    public final DUi7mC f1196DvK7DB = new DUi7mC(this);

    /* renamed from: DyaChj, reason: collision with root package name */
    public final BI9f7h.AMqCpz f1197DyaChj;

    /* renamed from: ECyGFg, reason: collision with root package name */
    public int f1198ECyGFg;

    /* renamed from: EGM26s, reason: collision with root package name */
    public BJ7GGh.AMqCpz f1199EGM26s;

    /* renamed from: EH1KK8, reason: collision with root package name */
    public boolean f1200EH1KK8;

    /* renamed from: EPdU4G, reason: collision with root package name */
    public final B4ZgIw.ADYaiT f1201EPdU4G;

    /* renamed from: EQurEW, reason: collision with root package name */
    public int f1202EQurEW;

    /* renamed from: EUIRHA, reason: collision with root package name */
    public int f1203EUIRHA;

    /* renamed from: EY4UKY, reason: collision with root package name */
    public int f1204EY4UKY;
    public int EdQ5bb;

    /* renamed from: EdhSi6, reason: collision with root package name */
    public A5SV6n[] f1205EdhSi6;

    /* renamed from: EiK8oA, reason: collision with root package name */
    public A5SV6n[] f1206EiK8oA;

    /* renamed from: EicXu4, reason: collision with root package name */
    public int f1207EicXu4;

    /* renamed from: EmJGcg, reason: collision with root package name */
    public boolean f1208EmJGcg;

    /* renamed from: ErKPGd, reason: collision with root package name */
    public boolean f1209ErKPGd;

    /* renamed from: EsrwYR, reason: collision with root package name */
    public WeakReference f1210EsrwYR;

    /* renamed from: EwN40Z, reason: collision with root package name */
    public WeakReference f1211EwN40Z;

    /* renamed from: ExjC7D, reason: collision with root package name */
    public WeakReference f1212ExjC7D;

    /* renamed from: F1loUV, reason: collision with root package name */
    public WeakReference f1213F1loUV;

    /* renamed from: F32kj0, reason: collision with root package name */
    public final HashSet f1214F32kj0;

    /* renamed from: F508T2, reason: collision with root package name */
    public final BI9f7h.A4TApA f1215F508T2;

    public ASJ6gh() {
        BI9f7h.AMqCpz aMqCpz = new BI9f7h.AMqCpz();
        aMqCpz.f1288A4TApA = true;
        aMqCpz.f1289A5SV6n = true;
        aMqCpz.AMqCpz = new ArrayList();
        new ArrayList();
        aMqCpz.f1291ARc23Z = null;
        aMqCpz.f1292ASJ6gh = new BI9f7h.A4TApA();
        aMqCpz.f1293AYUAbz = new ArrayList();
        aMqCpz.f1287A2egSU = this;
        aMqCpz.f1290ADYaiT = this;
        this.f1197DyaChj = aMqCpz;
        this.f1199EGM26s = null;
        this.f1200EH1KK8 = false;
        this.f1201EPdU4G = new B4ZgIw.ADYaiT();
        this.f1204EY4UKY = 0;
        this.EdQ5bb = 0;
        this.f1205EdhSi6 = new A5SV6n[4];
        this.f1206EiK8oA = new A5SV6n[4];
        this.f1207EicXu4 = 257;
        this.f1208EmJGcg = false;
        this.f1209ErKPGd = false;
        this.f1210EsrwYR = null;
        this.f1211EwN40Z = null;
        this.f1212ExjC7D = null;
        this.f1213F1loUV = null;
        this.f1214F32kj0 = new HashSet();
        this.f1215F508T2 = new BI9f7h.A4TApA();
    }

    public static void CtFAbx(ARc23Z aRc23Z, BJ7GGh.AMqCpz aMqCpz, BI9f7h.A4TApA a4TApA) {
        int i;
        int i2;
        if (aMqCpz == null) {
            return;
        }
        if (aRc23Z.f1188DV2E8K == 8 || (aRc23Z instanceof AZkASS) || (aRc23Z instanceof A2egSU)) {
            a4TApA.AMqCpz = 0;
            a4TApA.f1280ARc23Z = 0;
            return;
        }
        int[] iArr = aRc23Z.f1195Dphsd2;
        a4TApA.f1276A2egSU = iArr[0];
        a4TApA.f1277A4TApA = iArr[1];
        a4TApA.f1278A5SV6n = aRc23Z.B2KMhB();
        a4TApA.f1279ADYaiT = aRc23Z.AaHO0E();
        a4TApA.f1283AZOQYO = false;
        a4TApA.f1284AZkASS = 0;
        boolean z = a4TApA.f1276A2egSU == 3;
        boolean z2 = a4TApA.f1277A4TApA == 3;
        boolean z3 = z && aRc23Z.f1178D07BeM > 0.0f;
        boolean z4 = z2 && aRc23Z.f1178D07BeM > 0.0f;
        if (z && aRc23Z.B7CMnp(0) && aRc23Z.f1148B4ZgIw == 0 && !z3) {
            a4TApA.f1276A2egSU = 2;
            if (z2 && aRc23Z.f1149B7CMnp == 0) {
                a4TApA.f1276A2egSU = 1;
            }
            z = false;
        }
        if (z2 && aRc23Z.B7CMnp(1) && aRc23Z.f1149B7CMnp == 0 && !z4) {
            a4TApA.f1277A4TApA = 2;
            if (z && aRc23Z.f1148B4ZgIw == 0) {
                a4TApA.f1277A4TApA = 1;
            }
            z2 = false;
        }
        if (aRc23Z.BPw6Q8()) {
            a4TApA.f1276A2egSU = 1;
            z = false;
        }
        if (aRc23Z.BTvldC()) {
            a4TApA.f1277A4TApA = 1;
            z2 = false;
        }
        int[] iArr2 = aRc23Z.f1150B9tovu;
        if (z3) {
            if (iArr2[0] == 4) {
                a4TApA.f1276A2egSU = 1;
            } else if (!z2) {
                if (a4TApA.f1277A4TApA == 1) {
                    i2 = a4TApA.f1279ADYaiT;
                } else {
                    a4TApA.f1276A2egSU = 2;
                    aMqCpz.A4TApA(aRc23Z, a4TApA);
                    i2 = a4TApA.f1280ARc23Z;
                }
                a4TApA.f1276A2egSU = 1;
                a4TApA.f1278A5SV6n = (int) (aRc23Z.f1178D07BeM * i2);
            }
        }
        if (z4) {
            if (iArr2[1] == 4) {
                a4TApA.f1277A4TApA = 1;
            } else if (!z) {
                if (a4TApA.f1276A2egSU == 1) {
                    i = a4TApA.f1278A5SV6n;
                } else {
                    a4TApA.f1277A4TApA = 2;
                    aMqCpz.A4TApA(aRc23Z, a4TApA);
                    i = a4TApA.AMqCpz;
                }
                a4TApA.f1277A4TApA = 1;
                if (aRc23Z.f1179D6DOie == -1) {
                    a4TApA.f1279ADYaiT = (int) (i / aRc23Z.f1178D07BeM);
                } else {
                    a4TApA.f1279ADYaiT = (int) (aRc23Z.f1178D07BeM * i);
                }
            }
        }
        aMqCpz.A4TApA(aRc23Z, a4TApA);
        aRc23Z.CcAIMM(a4TApA.AMqCpz);
        aRc23Z.CQhlFr(a4TApA.f1280ARc23Z);
        aRc23Z.BpkvW3 = a4TApA.f1282AYUAbz;
        aRc23Z.CASmeH(a4TApA.f1281ASJ6gh);
        a4TApA.f1284AZkASS = 0;
    }

    @Override // BChYOn.ARc23Z
    public final void AmA8tU(StringBuilder sb) {
        sb.append(this.f1140AaHO0E + ":{\n");
        StringBuilder sb2 = new StringBuilder("  actualWidth:");
        sb2.append(this.f1176CtFAbx);
        sb.append(sb2.toString());
        sb.append("\n");
        sb.append("  actualHeight:" + this.f1177CtxOCS);
        sb.append("\n");
        Iterator it = this.f1275DuwtYk.iterator();
        while (it.hasNext()) {
            ((ARc23Z) it.next()).AmA8tU(sb);
            sb.append(",\n");
        }
        sb.append("}");
    }

    @Override // BChYOn.AmA8tU, BChYOn.ARc23Z
    public final void BV3sI0() {
        this.f1201EPdU4G.B7CMnp();
        this.f1202EQurEW = 0;
        this.f1203EUIRHA = 0;
        super.BV3sI0();
    }

    @Override // BChYOn.ARc23Z
    public final void Cd8JRx(boolean z, boolean z2) {
        super.Cd8JRx(z, z2);
        int size = this.f1275DuwtYk.size();
        for (int i = 0; i < size; i++) {
            ((ARc23Z) this.f1275DuwtYk.get(i)).Cd8JRx(z, z2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:234:0x03ad  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x03d3  */
    /* JADX WARN: Removed duplicated region for block: B:416:0x063d  */
    /* JADX WARN: Removed duplicated region for block: B:435:0x066b A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:438:0x0670  */
    /* JADX WARN: Removed duplicated region for block: B:445:0x0686  */
    /* JADX WARN: Removed duplicated region for block: B:515:0x07dd  */
    /* JADX WARN: Removed duplicated region for block: B:528:0x0847 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:546:0x08c4  */
    /* JADX WARN: Removed duplicated region for block: B:549:0x08e4  */
    /* JADX WARN: Removed duplicated region for block: B:551:0x08f1  */
    /* JADX WARN: Removed duplicated region for block: B:564:0x092d  */
    /* JADX WARN: Removed duplicated region for block: B:567:0x092f  */
    /* JADX WARN: Removed duplicated region for block: B:570:0x0929  */
    /* JADX WARN: Removed duplicated region for block: B:571:0x08ed  */
    /* JADX WARN: Removed duplicated region for block: B:572:0x08d1  */
    /* JADX WARN: Removed duplicated region for block: B:574:0x0826  */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v7, types: [boolean] */
    @Override // BChYOn.AmA8tU
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void CkXcdM() {
        /*
            Method dump skipped, instructions count: 2381
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: BChYOn.ASJ6gh.CkXcdM():void");
    }

    public final void CmUvjW(ARc23Z aRc23Z, int i) {
        if (i == 0) {
            int i2 = this.f1204EY4UKY + 1;
            A5SV6n[] a5SV6nArr = this.f1206EiK8oA;
            if (i2 >= a5SV6nArr.length) {
                this.f1206EiK8oA = (A5SV6n[]) Arrays.copyOf(a5SV6nArr, a5SV6nArr.length * 2);
            }
            A5SV6n[] a5SV6nArr2 = this.f1206EiK8oA;
            int i3 = this.f1204EY4UKY;
            a5SV6nArr2[i3] = new A5SV6n(aRc23Z, 0, this.f1200EH1KK8);
            this.f1204EY4UKY = i3 + 1;
            return;
        }
        if (i == 1) {
            int i4 = this.EdQ5bb + 1;
            A5SV6n[] a5SV6nArr3 = this.f1205EdhSi6;
            if (i4 >= a5SV6nArr3.length) {
                this.f1205EdhSi6 = (A5SV6n[]) Arrays.copyOf(a5SV6nArr3, a5SV6nArr3.length * 2);
            }
            A5SV6n[] a5SV6nArr4 = this.f1205EdhSi6;
            int i5 = this.EdQ5bb;
            a5SV6nArr4[i5] = new A5SV6n(aRc23Z, 1, this.f1200EH1KK8);
            this.EdQ5bb = i5 + 1;
        }
    }

    public final void CqNSpT(B4ZgIw.ADYaiT aDYaiT) {
        ASJ6gh aSJ6gh;
        B4ZgIw.ADYaiT aDYaiT2;
        boolean CtxOCS2 = CtxOCS(64);
        A4TApA(aDYaiT, CtxOCS2);
        int size = this.f1275DuwtYk.size();
        boolean z = false;
        for (int i = 0; i < size; i++) {
            ARc23Z aRc23Z = (ARc23Z) this.f1275DuwtYk.get(i);
            boolean[] zArr = aRc23Z.f1174CqNSpT;
            zArr[0] = false;
            zArr[1] = false;
            if (aRc23Z instanceof A2egSU) {
                z = true;
            }
        }
        if (z) {
            for (int i2 = 0; i2 < size; i2++) {
                ARc23Z aRc23Z2 = (ARc23Z) this.f1275DuwtYk.get(i2);
                if (aRc23Z2 instanceof A2egSU) {
                    A2egSU a2egSU = (A2egSU) aRc23Z2;
                    for (int i3 = 0; i3 < a2egSU.f1263DvK7DB; i3++) {
                        ARc23Z aRc23Z3 = a2egSU.f1262DuwtYk[i3];
                        if (a2egSU.f1095ECyGFg || aRc23Z3.A5SV6n()) {
                            int i4 = a2egSU.f1094DyaChj;
                            if (i4 == 0 || i4 == 1) {
                                aRc23Z3.f1174CqNSpT[0] = true;
                            } else if (i4 == 2 || i4 == 3) {
                                aRc23Z3.f1174CqNSpT[1] = true;
                            }
                        }
                    }
                }
            }
        }
        HashSet hashSet = this.f1214F32kj0;
        hashSet.clear();
        for (int i5 = 0; i5 < size; i5++) {
            ARc23Z aRc23Z4 = (ARc23Z) this.f1275DuwtYk.get(i5);
            aRc23Z4.getClass();
            boolean z2 = aRc23Z4 instanceof AlLFFp;
            if (z2 || (aRc23Z4 instanceof AZkASS)) {
                if (z2) {
                    hashSet.add(aRc23Z4);
                } else {
                    aRc23Z4.A4TApA(aDYaiT, CtxOCS2);
                }
            }
        }
        while (hashSet.size() > 0) {
            int size2 = hashSet.size();
            Iterator it = hashSet.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                AlLFFp alLFFp = (AlLFFp) ((ARc23Z) it.next());
                for (int i6 = 0; i6 < alLFFp.f1263DvK7DB; i6++) {
                    if (hashSet.contains(alLFFp.f1262DuwtYk[i6])) {
                        alLFFp.A4TApA(aDYaiT, CtxOCS2);
                        hashSet.remove(alLFFp);
                        break;
                    }
                }
            }
            if (size2 == hashSet.size()) {
                Iterator it2 = hashSet.iterator();
                while (it2.hasNext()) {
                    ((ARc23Z) it2.next()).A4TApA(aDYaiT, CtxOCS2);
                }
                hashSet.clear();
            }
        }
        if (B4ZgIw.ADYaiT.f1055B25kr6) {
            HashSet hashSet2 = new HashSet();
            for (int i7 = 0; i7 < size; i7++) {
                ARc23Z aRc23Z5 = (ARc23Z) this.f1275DuwtYk.get(i7);
                aRc23Z5.getClass();
                if (!(aRc23Z5 instanceof AlLFFp) && !(aRc23Z5 instanceof AZkASS)) {
                    hashSet2.add(aRc23Z5);
                }
            }
            aSJ6gh = this;
            aDYaiT2 = aDYaiT;
            aSJ6gh.A2egSU(this, aDYaiT2, hashSet2, this.f1195Dphsd2[0] == 2 ? 0 : 1, false);
            Iterator it3 = hashSet2.iterator();
            while (it3.hasNext()) {
                ARc23Z aRc23Z6 = (ARc23Z) it3.next();
                AcNBzu.A2egSU(this, aDYaiT2, aRc23Z6);
                aRc23Z6.A4TApA(aDYaiT2, CtxOCS2);
            }
        } else {
            aSJ6gh = this;
            aDYaiT2 = aDYaiT;
            for (int i8 = 0; i8 < size; i8++) {
                ARc23Z aRc23Z7 = (ARc23Z) aSJ6gh.f1275DuwtYk.get(i8);
                if (aRc23Z7 instanceof ASJ6gh) {
                    int[] iArr = aRc23Z7.f1195Dphsd2;
                    int i9 = iArr[0];
                    int i10 = iArr[1];
                    if (i9 == 2) {
                        aRc23Z7.CSDoyG(1);
                    }
                    if (i10 == 2) {
                        aRc23Z7.CTkVKb(1);
                    }
                    aRc23Z7.A4TApA(aDYaiT2, CtxOCS2);
                    if (i9 == 2) {
                        aRc23Z7.CSDoyG(i9);
                    }
                    if (i10 == 2) {
                        aRc23Z7.CTkVKb(i10);
                    }
                } else {
                    AcNBzu.A2egSU(this, aDYaiT2, aRc23Z7);
                    if (!(aRc23Z7 instanceof AlLFFp) && !(aRc23Z7 instanceof AZkASS)) {
                        aRc23Z7.A4TApA(aDYaiT2, CtxOCS2);
                    }
                }
            }
        }
        if (aSJ6gh.f1204EY4UKY > 0) {
            A4TApA.A2egSU(this, aDYaiT2, null, 0);
        }
        if (aSJ6gh.EdQ5bb > 0) {
            A4TApA.A2egSU(this, aDYaiT2, null, 1);
        }
    }

    public final boolean CrfGsy(int i, boolean z) {
        boolean z2;
        BI9f7h.AMqCpz aMqCpz = this.f1197DyaChj;
        ASJ6gh aSJ6gh = aMqCpz.f1287A2egSU;
        boolean z3 = false;
        int AZkASS2 = aSJ6gh.AZkASS(0);
        int AZkASS3 = aSJ6gh.AZkASS(1);
        int B3GDIM2 = aSJ6gh.B3GDIM();
        int B4ZgIw2 = aSJ6gh.B4ZgIw();
        ArrayList arrayList = aMqCpz.AMqCpz;
        if (z && (AZkASS2 == 2 || AZkASS3 == 2)) {
            Iterator it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                B25kr6 b25kr6 = (B25kr6) it.next();
                if (b25kr6.f1321ARc23Z == i && !b25kr6.AZkASS()) {
                    z = false;
                    break;
                }
            }
            if (i == 0) {
                if (z && AZkASS2 == 2) {
                    aSJ6gh.CSDoyG(1);
                    aSJ6gh.CcAIMM(aMqCpz.ADYaiT(aSJ6gh, 0));
                    aSJ6gh.f1134ADYaiT.AMqCpz.A5SV6n(aSJ6gh.B2KMhB());
                }
            } else if (z && AZkASS3 == 2) {
                aSJ6gh.CTkVKb(1);
                aSJ6gh.CQhlFr(aMqCpz.ADYaiT(aSJ6gh, 1));
                aSJ6gh.AMqCpz.AMqCpz.A5SV6n(aSJ6gh.AaHO0E());
            }
        }
        int[] iArr = aSJ6gh.f1195Dphsd2;
        if (i == 0) {
            int i2 = iArr[0];
            if (i2 == 1 || i2 == 4) {
                int B2KMhB2 = aSJ6gh.B2KMhB() + B3GDIM2;
                aSJ6gh.f1134ADYaiT.f1324AZOQYO.A5SV6n(B2KMhB2);
                aSJ6gh.f1134ADYaiT.AMqCpz.A5SV6n(B2KMhB2 - B3GDIM2);
                z2 = true;
            }
            z2 = false;
        } else {
            int i3 = iArr[1];
            if (i3 == 1 || i3 == 4) {
                int AaHO0E2 = aSJ6gh.AaHO0E() + B4ZgIw2;
                aSJ6gh.AMqCpz.f1324AZOQYO.A5SV6n(AaHO0E2);
                aSJ6gh.AMqCpz.AMqCpz.A5SV6n(AaHO0E2 - B4ZgIw2);
                z2 = true;
            }
            z2 = false;
        }
        aMqCpz.ASJ6gh();
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            B25kr6 b25kr62 = (B25kr6) it2.next();
            if (b25kr62.f1321ARc23Z == i && (b25kr62.f1318A4TApA != aSJ6gh || b25kr62.f1322ASJ6gh)) {
                b25kr62.ADYaiT();
            }
        }
        Iterator it3 = arrayList.iterator();
        while (true) {
            if (!it3.hasNext()) {
                z3 = true;
                break;
            }
            B25kr6 b25kr63 = (B25kr6) it3.next();
            if (b25kr63.f1321ARc23Z == i && (z2 || b25kr63.f1318A4TApA != aSJ6gh)) {
                if (!b25kr63.f1323AYUAbz.f1302AZkASS) {
                    break;
                }
                if (!b25kr63.f1324AZOQYO.f1302AZkASS) {
                    break;
                }
                if (!(b25kr63 instanceof BI9f7h.A5SV6n) && !b25kr63.AMqCpz.f1302AZkASS) {
                    break;
                }
            }
        }
        aSJ6gh.CSDoyG(AZkASS2);
        aSJ6gh.CTkVKb(AZkASS3);
        return z3;
    }

    public final boolean CtxOCS(int i) {
        return (this.f1207EicXu4 & i) == i;
    }

    @Override // BChYOn.ARc23Z
    public String getType() {
        return "ConstraintLayout";
    }
}
