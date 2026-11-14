package BI9f7h;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class B25kr6 implements ADYaiT {

    /* renamed from: A2egSU, reason: collision with root package name */
    public int f1317A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public BChYOn.ARc23Z f1318A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public AlLFFp f1319A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public int f1320ADYaiT;
    public final ASJ6gh AMqCpz = new ASJ6gh(this);

    /* renamed from: ARc23Z, reason: collision with root package name */
    public int f1321ARc23Z = 0;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public boolean f1322ASJ6gh = false;

    /* renamed from: AYUAbz, reason: collision with root package name */
    public final ARc23Z f1323AYUAbz = new ARc23Z(this);

    /* renamed from: AZOQYO, reason: collision with root package name */
    public final ARc23Z f1324AZOQYO = new ARc23Z(this);

    /* renamed from: AZkASS, reason: collision with root package name */
    public int f1325AZkASS = 1;

    public B25kr6(BChYOn.ARc23Z aRc23Z) {
        this.f1318A4TApA = aRc23Z;
    }

    public static void A2egSU(ARc23Z aRc23Z, ARc23Z aRc23Z2, int i) {
        aRc23Z.f1304AcNBzu.add(aRc23Z2);
        aRc23Z.f1298ARc23Z = i;
        aRc23Z2.f1303AaHO0E.add(aRc23Z);
    }

    public static ARc23Z ASJ6gh(BChYOn.AMqCpz aMqCpz) {
        BChYOn.AMqCpz aMqCpz2 = aMqCpz.f1127ARc23Z;
        if (aMqCpz2 == null) {
            return null;
        }
        BChYOn.ARc23Z aRc23Z = aMqCpz2.f1126ADYaiT;
        int ordinal = aMqCpz2.AMqCpz.ordinal();
        if (ordinal == 1) {
            return aRc23Z.f1134ADYaiT.f1323AYUAbz;
        }
        if (ordinal == 2) {
            return aRc23Z.AMqCpz.f1323AYUAbz;
        }
        if (ordinal == 3) {
            return aRc23Z.f1134ADYaiT.f1324AZOQYO;
        }
        if (ordinal == 4) {
            return aRc23Z.AMqCpz.f1324AZOQYO;
        }
        if (ordinal != 5) {
            return null;
        }
        return aRc23Z.AMqCpz.f1310AaHO0E;
    }

    public static ARc23Z AYUAbz(BChYOn.AMqCpz aMqCpz, int i) {
        BChYOn.AMqCpz aMqCpz2 = aMqCpz.f1127ARc23Z;
        if (aMqCpz2 == null) {
            return null;
        }
        BChYOn.ARc23Z aRc23Z = aMqCpz2.f1126ADYaiT;
        B25kr6 b25kr6 = i == 0 ? aRc23Z.f1134ADYaiT : aRc23Z.AMqCpz;
        int ordinal = aMqCpz2.AMqCpz.ordinal();
        if (ordinal == 1 || ordinal == 2) {
            return b25kr6.f1323AYUAbz;
        }
        if (ordinal == 3 || ordinal == 4) {
            return b25kr6.f1324AZOQYO;
        }
        return null;
    }

    public final void A4TApA(ARc23Z aRc23Z, ARc23Z aRc23Z2, int i, ASJ6gh aSJ6gh) {
        aRc23Z.f1304AcNBzu.add(aRc23Z2);
        aRc23Z.f1304AcNBzu.add(this.AMqCpz);
        aRc23Z.f1300AYUAbz = i;
        aRc23Z.f1301AZOQYO = aSJ6gh;
        aRc23Z2.f1303AaHO0E.add(aRc23Z);
        aSJ6gh.f1303AaHO0E.add(aRc23Z);
    }

    public abstract void A5SV6n();

    public abstract void ADYaiT();

    public abstract void AMqCpz();

    public final int ARc23Z(int i, int i2) {
        if (i2 == 0) {
            BChYOn.ARc23Z aRc23Z = this.f1318A4TApA;
            int i3 = aRc23Z.f1152BI9f7h;
            int max = Math.max(aRc23Z.f1151BChYOn, i);
            if (i3 > 0) {
                max = Math.min(i3, i);
            }
            if (max != i) {
                return max;
            }
        } else {
            BChYOn.ARc23Z aRc23Z2 = this.f1318A4TApA;
            int i4 = aRc23Z2.f1155BNL6CD;
            int max2 = Math.max(aRc23Z2.f1154BJ7GGh, i);
            if (i4 > 0) {
                max2 = Math.min(i4, i);
            }
            if (max2 != i) {
                return max2;
            }
        }
        return i;
    }

    public long AZOQYO() {
        if (this.AMqCpz.f1302AZkASS) {
            return r0.f1299ASJ6gh;
        }
        return 0L;
    }

    public abstract boolean AZkASS();

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0051, code lost:
    
        if (r9.f1317A2egSU == 3) goto L50;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void AaHO0E(BChYOn.AMqCpz r12, BChYOn.AMqCpz r13, int r14) {
        /*
            Method dump skipped, instructions count: 236
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: BI9f7h.B25kr6.AaHO0E(BChYOn.AMqCpz, BChYOn.AMqCpz, int):void");
    }

    @Override // BI9f7h.ADYaiT
    public void update(ADYaiT aDYaiT) {
    }
}
