package BI9f7h;

import ADYaiT.CtFAbx;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AMqCpz {

    /* renamed from: A2egSU, reason: collision with root package name */
    public BChYOn.ASJ6gh f1287A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public boolean f1288A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public boolean f1289A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public BChYOn.ASJ6gh f1290ADYaiT;
    public ArrayList AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public BJ7GGh.AMqCpz f1291ARc23Z;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public A4TApA f1292ASJ6gh;

    /* renamed from: AYUAbz, reason: collision with root package name */
    public ArrayList f1293AYUAbz;

    public final void A2egSU(ARc23Z aRc23Z, int i, ArrayList arrayList, AlLFFp alLFFp) {
        B25kr6 b25kr6 = aRc23Z.f1297ADYaiT;
        if (b25kr6.f1319A5SV6n == null) {
            BChYOn.ASJ6gh aSJ6gh = this.f1287A2egSU;
            if (b25kr6 == aSJ6gh.f1134ADYaiT || b25kr6 == aSJ6gh.AMqCpz) {
                return;
            }
            if (alLFFp == null) {
                alLFFp = new AlLFFp();
                alLFFp.f1308A2egSU = null;
                alLFFp.f1309A4TApA = new ArrayList();
                alLFFp.f1308A2egSU = b25kr6;
                arrayList.add(alLFFp);
            }
            b25kr6.f1319A5SV6n = alLFFp;
            alLFFp.f1309A4TApA.add(b25kr6);
            ARc23Z aRc23Z2 = b25kr6.f1323AYUAbz;
            Iterator it = aRc23Z2.f1303AaHO0E.iterator();
            while (it.hasNext()) {
                ADYaiT aDYaiT = (ADYaiT) it.next();
                if (aDYaiT instanceof ARc23Z) {
                    A2egSU((ARc23Z) aDYaiT, i, arrayList, alLFFp);
                }
            }
            ARc23Z aRc23Z3 = b25kr6.f1324AZOQYO;
            Iterator it2 = aRc23Z3.f1303AaHO0E.iterator();
            while (it2.hasNext()) {
                ADYaiT aDYaiT2 = (ADYaiT) it2.next();
                if (aDYaiT2 instanceof ARc23Z) {
                    A2egSU((ARc23Z) aDYaiT2, i, arrayList, alLFFp);
                }
            }
            if (i == 1 && (b25kr6 instanceof AmA8tU)) {
                Iterator it3 = ((AmA8tU) b25kr6).f1310AaHO0E.f1303AaHO0E.iterator();
                while (it3.hasNext()) {
                    ADYaiT aDYaiT3 = (ADYaiT) it3.next();
                    if (aDYaiT3 instanceof ARc23Z) {
                        A2egSU((ARc23Z) aDYaiT3, i, arrayList, alLFFp);
                    }
                }
            }
            Iterator it4 = aRc23Z2.f1304AcNBzu.iterator();
            while (it4.hasNext()) {
                A2egSU((ARc23Z) it4.next(), i, arrayList, alLFFp);
            }
            Iterator it5 = aRc23Z3.f1304AcNBzu.iterator();
            while (it5.hasNext()) {
                A2egSU((ARc23Z) it5.next(), i, arrayList, alLFFp);
            }
            if (i == 1 && (b25kr6 instanceof AmA8tU)) {
                Iterator it6 = ((AmA8tU) b25kr6).f1310AaHO0E.f1304AcNBzu.iterator();
                while (it6.hasNext()) {
                    A2egSU((ARc23Z) it6.next(), i, arrayList, alLFFp);
                }
            }
        }
    }

    public final void A4TApA(BChYOn.ASJ6gh aSJ6gh) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        Iterator it = aSJ6gh.f1275DuwtYk.iterator();
        while (it.hasNext()) {
            BChYOn.ARc23Z aRc23Z = (BChYOn.ARc23Z) it.next();
            int[] iArr = aRc23Z.f1195Dphsd2;
            int i10 = iArr[0];
            int i11 = iArr[1];
            if (aRc23Z.f1188DV2E8K == 8) {
                aRc23Z.f1131A2egSU = true;
            } else {
                float f = aRc23Z.f1153BIYEnU;
                if (f < 1.0f && i10 == 3) {
                    aRc23Z.f1148B4ZgIw = 2;
                }
                float f2 = aRc23Z.f1156BPw6Q8;
                if (f2 < 1.0f && i11 == 3) {
                    aRc23Z.f1149B7CMnp = 2;
                }
                if (aRc23Z.f1178D07BeM > 0.0f) {
                    if (i10 == 3 && (i11 == 2 || i11 == 1)) {
                        aRc23Z.f1148B4ZgIw = 3;
                    } else if (i11 == 3 && (i10 == 2 || i10 == 1)) {
                        aRc23Z.f1149B7CMnp = 3;
                    } else if (i10 == 3 && i11 == 3) {
                        if (aRc23Z.f1148B4ZgIw == 0) {
                            aRc23Z.f1148B4ZgIw = 3;
                        }
                        if (aRc23Z.f1149B7CMnp == 0) {
                            aRc23Z.f1149B7CMnp = 3;
                        }
                    }
                }
                BChYOn.AMqCpz aMqCpz = aRc23Z.f1166CQhlFr;
                BChYOn.AMqCpz aMqCpz2 = aRc23Z.f1164CNPG0E;
                if (i10 == 3 && aRc23Z.f1148B4ZgIw == 1 && (aMqCpz2.f1127ARc23Z == null || aMqCpz.f1127ARc23Z == null)) {
                    i10 = 2;
                }
                BChYOn.AMqCpz aMqCpz3 = aRc23Z.f1167CSDoyG;
                BChYOn.AMqCpz aMqCpz4 = aRc23Z.f1165COJEAR;
                if (i11 == 3 && aRc23Z.f1149B7CMnp == 1 && (aMqCpz4.f1127ARc23Z == null || aMqCpz3.f1127ARc23Z == null)) {
                    i11 = 2;
                }
                AcNBzu acNBzu = aRc23Z.f1134ADYaiT;
                acNBzu.f1320ADYaiT = i10;
                int i12 = aRc23Z.f1148B4ZgIw;
                acNBzu.f1317A2egSU = i12;
                AmA8tU amA8tU = aRc23Z.AMqCpz;
                amA8tU.f1320ADYaiT = i11;
                int i13 = aRc23Z.f1149B7CMnp;
                amA8tU.f1317A2egSU = i13;
                if ((i10 == 4 || i10 == 1 || i10 == 2) && (i11 == 4 || i11 == 1 || i11 == 2)) {
                    int i14 = i11;
                    int B2KMhB2 = aRc23Z.B2KMhB();
                    if (i10 == 4) {
                        B2KMhB2 = (aSJ6gh.B2KMhB() - aMqCpz2.f1128ASJ6gh) - aMqCpz.f1128ASJ6gh;
                        i10 = 1;
                    }
                    int i15 = B2KMhB2;
                    int AaHO0E2 = aRc23Z.AaHO0E();
                    if (i14 == 4) {
                        AaHO0E2 = (aSJ6gh.AaHO0E() - aMqCpz4.f1128ASJ6gh) - aMqCpz3.f1128ASJ6gh;
                        i14 = 1;
                    }
                    ARc23Z(aRc23Z, i10, i15, i14, AaHO0E2);
                    aRc23Z.f1134ADYaiT.AMqCpz.A5SV6n(aRc23Z.B2KMhB());
                    aRc23Z.AMqCpz.AMqCpz.A5SV6n(aRc23Z.AaHO0E());
                    aRc23Z.f1131A2egSU = true;
                } else {
                    int[] iArr2 = aSJ6gh.f1195Dphsd2;
                    BChYOn.AMqCpz[] aMqCpzArr = aRc23Z.f1172CkXcdM;
                    if (i10 != 3 || (i11 != 2 && i11 != 1)) {
                        i = i10;
                        i3 = i13;
                        i5 = 2;
                        i2 = 1;
                        i4 = i11;
                    } else if (i12 == 3) {
                        if (i11 == 2) {
                            ARc23Z(aRc23Z, 2, 0, 2, 0);
                        }
                        int AaHO0E3 = aRc23Z.AaHO0E();
                        ARc23Z(aRc23Z, 1, (int) ((AaHO0E3 * aRc23Z.f1178D07BeM) + 0.5f), 1, AaHO0E3);
                        aRc23Z.f1134ADYaiT.AMqCpz.A5SV6n(aRc23Z.B2KMhB());
                        aRc23Z.AMqCpz.AMqCpz.A5SV6n(aRc23Z.AaHO0E());
                        aRc23Z.f1131A2egSU = true;
                    } else {
                        i = i10;
                        i5 = 2;
                        i2 = 1;
                        if (i12 == 1) {
                            ARc23Z(aRc23Z, 2, 0, i11, 0);
                            aRc23Z.f1134ADYaiT.AMqCpz.f1305AlLFFp = aRc23Z.B2KMhB();
                        } else {
                            i3 = i13;
                            i4 = i11;
                            if (i12 == 2) {
                                int i16 = iArr2[0];
                                if (i16 == 1 || i16 == 4) {
                                    ARc23Z(aRc23Z, 1, (int) ((f * aSJ6gh.B2KMhB()) + 0.5f), i4, aRc23Z.AaHO0E());
                                    aRc23Z.f1134ADYaiT.AMqCpz.A5SV6n(aRc23Z.B2KMhB());
                                    aRc23Z.AMqCpz.AMqCpz.A5SV6n(aRc23Z.AaHO0E());
                                    aRc23Z.f1131A2egSU = true;
                                }
                            } else if (aMqCpzArr[0].f1127ARc23Z == null || aMqCpzArr[1].f1127ARc23Z == null) {
                                ARc23Z(aRc23Z, 2, 0, i4, 0);
                                aRc23Z.f1134ADYaiT.AMqCpz.A5SV6n(aRc23Z.B2KMhB());
                                aRc23Z.AMqCpz.AMqCpz.A5SV6n(aRc23Z.AaHO0E());
                                aRc23Z.f1131A2egSU = true;
                            }
                        }
                    }
                    if (i4 != 3) {
                        i6 = i;
                        i7 = 1;
                        i8 = 2;
                    } else if (i != i5 && i != i2) {
                        i6 = i;
                        i7 = 1;
                        i9 = 3;
                        i8 = 2;
                        if (i6 == i9 && i4 == i9) {
                            if (i12 != i7 || i3 == i7) {
                                ARc23Z(aRc23Z, 2, 0, i8, 0);
                                aRc23Z.f1134ADYaiT.AMqCpz.f1305AlLFFp = aRc23Z.B2KMhB();
                                aRc23Z.AMqCpz.AMqCpz.f1305AlLFFp = aRc23Z.AaHO0E();
                            } else if (i3 == 2 && i12 == 2 && iArr2[0] == i2 && iArr2[i7] == i2) {
                                ARc23Z(aRc23Z, 1, (int) ((f * aSJ6gh.B2KMhB()) + 0.5f), i2, (int) ((f2 * aSJ6gh.AaHO0E()) + 0.5f));
                                aRc23Z.f1134ADYaiT.AMqCpz.A5SV6n(aRc23Z.B2KMhB());
                                aRc23Z.AMqCpz.AMqCpz.A5SV6n(aRc23Z.AaHO0E());
                                aRc23Z.f1131A2egSU = true;
                            }
                        }
                    } else if (i3 == 3) {
                        if (i == i5) {
                            ARc23Z(aRc23Z, i5, 0, i5, 0);
                        }
                        int B2KMhB3 = aRc23Z.B2KMhB();
                        float f3 = aRc23Z.f1178D07BeM;
                        if (aRc23Z.f1179D6DOie == -1) {
                            f3 = 1.0f / f3;
                        }
                        ARc23Z(aRc23Z, 1, B2KMhB3, i2, (int) ((B2KMhB3 * f3) + 0.5f));
                        aRc23Z.f1134ADYaiT.AMqCpz.A5SV6n(aRc23Z.B2KMhB());
                        aRc23Z.AMqCpz.AMqCpz.A5SV6n(aRc23Z.AaHO0E());
                        aRc23Z.f1131A2egSU = true;
                    } else if (i3 == 1) {
                        ARc23Z(aRc23Z, i, 0, 2, 0);
                        aRc23Z.AMqCpz.AMqCpz.f1305AlLFFp = aRc23Z.AaHO0E();
                    } else {
                        int i17 = i;
                        i8 = 2;
                        if (i3 == 2) {
                            int i18 = iArr2[1];
                            if (i18 == i2 || i18 == 4) {
                                ARc23Z(aRc23Z, i17, aRc23Z.B2KMhB(), 1, (int) ((f2 * aSJ6gh.AaHO0E()) + 0.5f));
                                aRc23Z.f1134ADYaiT.AMqCpz.A5SV6n(aRc23Z.B2KMhB());
                                aRc23Z.AMqCpz.AMqCpz.A5SV6n(aRc23Z.AaHO0E());
                                aRc23Z.f1131A2egSU = true;
                            } else {
                                i6 = i17;
                                i7 = 1;
                            }
                        } else {
                            i6 = i17;
                            if (aMqCpzArr[2].f1127ARc23Z == null || aMqCpzArr[3].f1127ARc23Z == null) {
                                ARc23Z(aRc23Z, 2, 0, i4, 0);
                                aRc23Z.f1134ADYaiT.AMqCpz.A5SV6n(aRc23Z.B2KMhB());
                                aRc23Z.AMqCpz.AMqCpz.A5SV6n(aRc23Z.AaHO0E());
                                aRc23Z.f1131A2egSU = true;
                            } else {
                                i7 = 1;
                            }
                        }
                    }
                    i9 = 3;
                    if (i6 == i9) {
                        if (i12 != i7) {
                        }
                        ARc23Z(aRc23Z, 2, 0, i8, 0);
                        aRc23Z.f1134ADYaiT.AMqCpz.f1305AlLFFp = aRc23Z.B2KMhB();
                        aRc23Z.AMqCpz.AMqCpz.f1305AlLFFp = aRc23Z.AaHO0E();
                    }
                }
            }
        }
    }

    public final void A5SV6n() {
        ArrayList arrayList = this.AMqCpz;
        arrayList.clear();
        BChYOn.ASJ6gh aSJ6gh = this.f1290ADYaiT;
        aSJ6gh.f1134ADYaiT.AMqCpz();
        aSJ6gh.AMqCpz.AMqCpz();
        arrayList.add(aSJ6gh.f1134ADYaiT);
        arrayList.add(aSJ6gh.AMqCpz);
        Iterator it = aSJ6gh.f1275DuwtYk.iterator();
        HashSet hashSet = null;
        while (it.hasNext()) {
            BChYOn.ARc23Z aRc23Z = (BChYOn.ARc23Z) it.next();
            if (aRc23Z instanceof BChYOn.AZkASS) {
                AZkASS aZkASS = new AZkASS(aRc23Z);
                aRc23Z.f1134ADYaiT.AMqCpz();
                aRc23Z.AMqCpz.AMqCpz();
                aZkASS.f1321ARc23Z = ((BChYOn.AZkASS) aRc23Z).f1260EGM26s;
                arrayList.add(aZkASS);
            } else {
                if (aRc23Z.BIYEnU()) {
                    if (aRc23Z.f1132A4TApA == null) {
                        aRc23Z.f1132A4TApA = new A5SV6n(aRc23Z, 0);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(aRc23Z.f1132A4TApA);
                } else {
                    arrayList.add(aRc23Z.f1134ADYaiT);
                }
                if (aRc23Z.BJ7GGh()) {
                    if (aRc23Z.f1133A5SV6n == null) {
                        aRc23Z.f1133A5SV6n = new A5SV6n(aRc23Z, 1);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(aRc23Z.f1133A5SV6n);
                } else {
                    arrayList.add(aRc23Z.AMqCpz);
                }
                if (aRc23Z instanceof BChYOn.AaHO0E) {
                    arrayList.add(new AaHO0E(aRc23Z));
                }
            }
        }
        if (hashSet != null) {
            arrayList.addAll(hashSet);
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            ((B25kr6) it2.next()).AMqCpz();
        }
        Iterator it3 = arrayList.iterator();
        while (it3.hasNext()) {
            B25kr6 b25kr6 = (B25kr6) it3.next();
            if (b25kr6.f1318A4TApA != aSJ6gh) {
                b25kr6.A5SV6n();
            }
        }
        ArrayList arrayList2 = this.f1293AYUAbz;
        arrayList2.clear();
        BChYOn.ASJ6gh aSJ6gh2 = this.f1287A2egSU;
        AMqCpz(aSJ6gh2.f1134ADYaiT, 0, arrayList2);
        AMqCpz(aSJ6gh2.AMqCpz, 1, arrayList2);
        this.f1288A4TApA = false;
    }

    public final int ADYaiT(BChYOn.ASJ6gh aSJ6gh, int i) {
        ArrayList arrayList;
        int i2;
        int i3;
        long max;
        float f;
        BChYOn.ASJ6gh aSJ6gh2 = aSJ6gh;
        ArrayList arrayList2 = this.f1293AYUAbz;
        int size = arrayList2.size();
        int i4 = 0;
        long j = 0;
        while (i4 < size) {
            B25kr6 b25kr6 = ((AlLFFp) arrayList2.get(i4)).f1308A2egSU;
            if (!(b25kr6 instanceof A5SV6n) ? !(i != 0 ? (b25kr6 instanceof AmA8tU) : (b25kr6 instanceof AcNBzu)) : ((A5SV6n) b25kr6).f1321ARc23Z != i) {
                ARc23Z aRc23Z = (i == 0 ? aSJ6gh2.f1134ADYaiT : aSJ6gh2.AMqCpz).f1323AYUAbz;
                ARc23Z aRc23Z2 = (i == 0 ? aSJ6gh2.f1134ADYaiT : aSJ6gh2.AMqCpz).f1324AZOQYO;
                boolean contains = b25kr6.f1323AYUAbz.f1304AcNBzu.contains(aRc23Z);
                ARc23Z aRc23Z3 = b25kr6.f1324AZOQYO;
                boolean contains2 = aRc23Z3.f1304AcNBzu.contains(aRc23Z2);
                long AZOQYO2 = b25kr6.AZOQYO();
                ARc23Z aRc23Z4 = b25kr6.f1323AYUAbz;
                if (contains && contains2) {
                    long A4TApA2 = AlLFFp.A4TApA(aRc23Z4, 0L);
                    ArrayList arrayList3 = arrayList2;
                    i2 = size;
                    long A2egSU2 = AlLFFp.A2egSU(aRc23Z3, 0L);
                    long j2 = A4TApA2 - AZOQYO2;
                    int i5 = aRc23Z3.f1298ARc23Z;
                    arrayList = arrayList3;
                    i3 = i4;
                    if (j2 >= (-i5)) {
                        j2 += i5;
                    }
                    long j3 = (-A2egSU2) - AZOQYO2;
                    long j4 = aRc23Z4.f1298ARc23Z;
                    long j5 = j3 - j4;
                    if (j5 >= j4) {
                        j5 -= j4;
                    }
                    BChYOn.ARc23Z aRc23Z5 = b25kr6.f1318A4TApA;
                    if (i == 0) {
                        f = aRc23Z5.f1185DG07BK;
                    } else if (i == 1) {
                        f = aRc23Z5.f1186DRlcZ9;
                    } else {
                        aRc23Z5.getClass();
                        f = -1.0f;
                    }
                    float f2 = f > 0.0f ? (long) ((j2 / (1.0f - f)) + (j5 / f)) : 0L;
                    max = (aRc23Z4.f1298ARc23Z + ((((long) ((f2 * f) + 0.5f)) + AZOQYO2) + ((long) CtFAbx.A4TApA(1.0f, f, f2, 0.5f)))) - aRc23Z3.f1298ARc23Z;
                } else {
                    arrayList = arrayList2;
                    i2 = size;
                    i3 = i4;
                    max = contains ? Math.max(AlLFFp.A4TApA(aRc23Z4, aRc23Z4.f1298ARc23Z), aRc23Z4.f1298ARc23Z + AZOQYO2) : contains2 ? Math.max(-AlLFFp.A2egSU(aRc23Z3, aRc23Z3.f1298ARc23Z), (-aRc23Z3.f1298ARc23Z) + AZOQYO2) : (b25kr6.AZOQYO() + aRc23Z4.f1298ARc23Z) - aRc23Z3.f1298ARc23Z;
                }
            } else {
                arrayList = arrayList2;
                i2 = size;
                i3 = i4;
                max = 0;
            }
            j = Math.max(j, max);
            i4 = i3 + 1;
            aSJ6gh2 = aSJ6gh;
            size = i2;
            arrayList2 = arrayList;
        }
        return (int) j;
    }

    public final void AMqCpz(B25kr6 b25kr6, int i, ArrayList arrayList) {
        ARc23Z aRc23Z;
        Iterator it = b25kr6.f1323AYUAbz.f1303AaHO0E.iterator();
        while (true) {
            boolean hasNext = it.hasNext();
            aRc23Z = b25kr6.f1324AZOQYO;
            if (!hasNext) {
                break;
            }
            ADYaiT aDYaiT = (ADYaiT) it.next();
            if (aDYaiT instanceof ARc23Z) {
                A2egSU((ARc23Z) aDYaiT, i, arrayList, null);
            } else if (aDYaiT instanceof B25kr6) {
                A2egSU(((B25kr6) aDYaiT).f1323AYUAbz, i, arrayList, null);
            }
        }
        Iterator it2 = aRc23Z.f1303AaHO0E.iterator();
        while (it2.hasNext()) {
            ADYaiT aDYaiT2 = (ADYaiT) it2.next();
            if (aDYaiT2 instanceof ARc23Z) {
                A2egSU((ARc23Z) aDYaiT2, i, arrayList, null);
            } else if (aDYaiT2 instanceof B25kr6) {
                A2egSU(((B25kr6) aDYaiT2).f1324AZOQYO, i, arrayList, null);
            }
        }
        if (i == 1) {
            Iterator it3 = ((AmA8tU) b25kr6).f1310AaHO0E.f1303AaHO0E.iterator();
            while (it3.hasNext()) {
                ADYaiT aDYaiT3 = (ADYaiT) it3.next();
                if (aDYaiT3 instanceof ARc23Z) {
                    A2egSU((ARc23Z) aDYaiT3, i, arrayList, null);
                }
            }
        }
    }

    public final void ARc23Z(BChYOn.ARc23Z aRc23Z, int i, int i2, int i3, int i4) {
        A4TApA a4TApA = this.f1292ASJ6gh;
        a4TApA.f1276A2egSU = i;
        a4TApA.f1277A4TApA = i3;
        a4TApA.f1278A5SV6n = i2;
        a4TApA.f1279ADYaiT = i4;
        this.f1291ARc23Z.A4TApA(aRc23Z, a4TApA);
        aRc23Z.CcAIMM(a4TApA.AMqCpz);
        aRc23Z.CQhlFr(a4TApA.f1280ARc23Z);
        aRc23Z.BpkvW3 = a4TApA.f1282AYUAbz;
        aRc23Z.CASmeH(a4TApA.f1281ASJ6gh);
    }

    public final void ASJ6gh() {
        A2egSU a2egSU;
        Iterator it = this.f1287A2egSU.f1275DuwtYk.iterator();
        while (it.hasNext()) {
            BChYOn.ARc23Z aRc23Z = (BChYOn.ARc23Z) it.next();
            if (!aRc23Z.f1131A2egSU) {
                int[] iArr = aRc23Z.f1195Dphsd2;
                boolean z = false;
                int i = iArr[0];
                int i2 = iArr[1];
                int i3 = aRc23Z.f1148B4ZgIw;
                int i4 = aRc23Z.f1149B7CMnp;
                boolean z2 = i == 2 || (i == 3 && i3 == 1);
                if (i2 == 2 || (i2 == 3 && i4 == 1)) {
                    z = true;
                }
                ASJ6gh aSJ6gh = aRc23Z.f1134ADYaiT.AMqCpz;
                boolean z3 = aSJ6gh.f1302AZkASS;
                ASJ6gh aSJ6gh2 = aRc23Z.AMqCpz.AMqCpz;
                boolean z4 = aSJ6gh2.f1302AZkASS;
                boolean z5 = z2;
                if (z3 && z4) {
                    ARc23Z(aRc23Z, 1, aSJ6gh.f1299ASJ6gh, 1, aSJ6gh2.f1299ASJ6gh);
                    aRc23Z.f1131A2egSU = true;
                } else if (z3 && z) {
                    ARc23Z(aRc23Z, 1, aSJ6gh.f1299ASJ6gh, 2, aSJ6gh2.f1299ASJ6gh);
                    if (i2 == 3) {
                        aRc23Z.AMqCpz.AMqCpz.f1305AlLFFp = aRc23Z.AaHO0E();
                    } else {
                        aRc23Z.AMqCpz.AMqCpz.A5SV6n(aRc23Z.AaHO0E());
                        aRc23Z.f1131A2egSU = true;
                    }
                } else if (z4 && z5) {
                    ARc23Z(aRc23Z, 2, aSJ6gh.f1299ASJ6gh, 1, aSJ6gh2.f1299ASJ6gh);
                    if (i == 3) {
                        aRc23Z.f1134ADYaiT.AMqCpz.f1305AlLFFp = aRc23Z.B2KMhB();
                    } else {
                        aRc23Z.f1134ADYaiT.AMqCpz.A5SV6n(aRc23Z.B2KMhB());
                        aRc23Z.f1131A2egSU = true;
                    }
                }
                if (aRc23Z.f1131A2egSU && (a2egSU = aRc23Z.AMqCpz.f1311AcNBzu) != null) {
                    a2egSU.A5SV6n(aRc23Z.f1182D8cQ8b);
                }
            }
        }
    }
}
