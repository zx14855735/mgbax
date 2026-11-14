package BI9f7h;

import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AcNBzu extends B25kr6 {

    /* renamed from: AaHO0E, reason: collision with root package name */
    public static final int[] f1307AaHO0E = new int[2];

    static {
        zgNKlIm();
    }

    public static void AcNBzu(int[] iArr, int i, int i2, int i3, int i4, float f, int i5) {
        int i6 = i2 - i;
        int i7 = i4 - i3;
        if (i5 != -1) {
            if (i5 == 0) {
                iArr[0] = (int) ((i7 * f) + 0.5f);
                iArr[1] = i7;
                return;
            } else {
                if (i5 != 1) {
                    return;
                }
                iArr[0] = i6;
                iArr[1] = (int) ((i6 * f) + 0.5f);
                return;
            }
        }
        int i8 = (int) ((i7 * f) + 0.5f);
        int i9 = (int) ((i6 / f) + 0.5f);
        if (i8 <= i6) {
            iArr[0] = i8;
            iArr[1] = i7;
        } else if (i9 <= i7) {
            iArr[0] = i6;
            iArr[1] = i9;
        }
    }

    private static /* synthetic */ void zgNKlIm() {
        char[] charArray = "\u0000\f\u000eM\u0004\u0002\u000e\u0006M\u0001\f\u001aM\u0010\u000b\u0006\u000f\u000fM)\r\n!\u0011\n\u0007\u0004\u0006".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'c');
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0000\u000f\n\r\n\u0017".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'c');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // BI9f7h.B25kr6
    public final void A5SV6n() {
        BChYOn.ARc23Z aRc23Z;
        BChYOn.ARc23Z aRc23Z2;
        int i;
        BChYOn.ARc23Z aRc23Z3;
        BChYOn.ARc23Z aRc23Z4;
        int i2;
        BChYOn.ARc23Z aRc23Z5 = this.f1318A4TApA;
        boolean z = aRc23Z5.f1131A2egSU;
        ASJ6gh aSJ6gh = this.AMqCpz;
        if (z) {
            aSJ6gh.A5SV6n(aRc23Z5.B2KMhB());
        }
        boolean z2 = aSJ6gh.f1302AZkASS;
        ARc23Z aRc23Z6 = this.f1324AZOQYO;
        ARc23Z aRc23Z7 = this.f1323AYUAbz;
        if (!z2) {
            BChYOn.ARc23Z aRc23Z8 = this.f1318A4TApA;
            int i3 = aRc23Z8.f1195Dphsd2[0];
            this.f1320ADYaiT = i3;
            if (i3 != 3) {
                if (i3 == 4 && (aRc23Z4 = aRc23Z8.f1175CrfGsy) != null && ((i2 = aRc23Z4.f1195Dphsd2[0]) == 1 || i2 == 4)) {
                    int B2KMhB2 = (aRc23Z4.B2KMhB() - this.f1318A4TApA.f1164CNPG0E.AMqCpz()) - this.f1318A4TApA.f1166CQhlFr.AMqCpz();
                    B25kr6.A2egSU(aRc23Z7, aRc23Z4.f1134ADYaiT.f1323AYUAbz, this.f1318A4TApA.f1164CNPG0E.AMqCpz());
                    B25kr6.A2egSU(aRc23Z6, aRc23Z4.f1134ADYaiT.f1324AZOQYO, -this.f1318A4TApA.f1166CQhlFr.AMqCpz());
                    aSJ6gh.A5SV6n(B2KMhB2);
                    return;
                }
                if (i3 == 1) {
                    aSJ6gh.A5SV6n(aRc23Z8.B2KMhB());
                }
            }
        } else if (this.f1320ADYaiT == 4 && (aRc23Z2 = (aRc23Z = this.f1318A4TApA).f1175CrfGsy) != null && ((i = aRc23Z2.f1195Dphsd2[0]) == 1 || i == 4)) {
            B25kr6.A2egSU(aRc23Z7, aRc23Z2.f1134ADYaiT.f1323AYUAbz, aRc23Z.f1164CNPG0E.AMqCpz());
            B25kr6.A2egSU(aRc23Z6, aRc23Z2.f1134ADYaiT.f1324AZOQYO, -this.f1318A4TApA.f1166CQhlFr.AMqCpz());
            return;
        }
        if (aSJ6gh.f1302AZkASS) {
            BChYOn.ARc23Z aRc23Z9 = this.f1318A4TApA;
            if (aRc23Z9.f1131A2egSU) {
                BChYOn.AMqCpz[] aMqCpzArr = aRc23Z9.f1172CkXcdM;
                BChYOn.AMqCpz aMqCpz = aMqCpzArr[0];
                BChYOn.AMqCpz aMqCpz2 = aMqCpz.f1127ARc23Z;
                if (aMqCpz2 != null && aMqCpzArr[1].f1127ARc23Z != null) {
                    if (aRc23Z9.BIYEnU()) {
                        aRc23Z7.f1298ARc23Z = this.f1318A4TApA.f1172CkXcdM[0].AMqCpz();
                        aRc23Z6.f1298ARc23Z = -this.f1318A4TApA.f1172CkXcdM[1].AMqCpz();
                        return;
                    }
                    ARc23Z ASJ6gh2 = B25kr6.ASJ6gh(this.f1318A4TApA.f1172CkXcdM[0]);
                    if (ASJ6gh2 != null) {
                        B25kr6.A2egSU(aRc23Z7, ASJ6gh2, this.f1318A4TApA.f1172CkXcdM[0].AMqCpz());
                    }
                    ARc23Z ASJ6gh3 = B25kr6.ASJ6gh(this.f1318A4TApA.f1172CkXcdM[1]);
                    if (ASJ6gh3 != null) {
                        B25kr6.A2egSU(aRc23Z6, ASJ6gh3, -this.f1318A4TApA.f1172CkXcdM[1].AMqCpz());
                    }
                    aRc23Z7.f1295A4TApA = true;
                    aRc23Z6.f1295A4TApA = true;
                    return;
                }
                if (aMqCpz2 != null) {
                    ARc23Z ASJ6gh4 = B25kr6.ASJ6gh(aMqCpz);
                    if (ASJ6gh4 != null) {
                        B25kr6.A2egSU(aRc23Z7, ASJ6gh4, this.f1318A4TApA.f1172CkXcdM[0].AMqCpz());
                        B25kr6.A2egSU(aRc23Z6, aRc23Z7, aSJ6gh.f1299ASJ6gh);
                        return;
                    }
                    return;
                }
                BChYOn.AMqCpz aMqCpz3 = aMqCpzArr[1];
                if (aMqCpz3.f1127ARc23Z != null) {
                    ARc23Z ASJ6gh5 = B25kr6.ASJ6gh(aMqCpz3);
                    if (ASJ6gh5 != null) {
                        B25kr6.A2egSU(aRc23Z6, ASJ6gh5, -this.f1318A4TApA.f1172CkXcdM[1].AMqCpz());
                        B25kr6.A2egSU(aRc23Z7, aRc23Z6, -aSJ6gh.f1299ASJ6gh);
                        return;
                    }
                    return;
                }
                if ((aRc23Z9 instanceof BChYOn.AaHO0E) || aRc23Z9.f1175CrfGsy == null || aRc23Z9.AZOQYO(BChYOn.ADYaiT.f1119B2KMhB).f1127ARc23Z != null) {
                    return;
                }
                BChYOn.ARc23Z aRc23Z10 = this.f1318A4TApA;
                B25kr6.A2egSU(aRc23Z7, aRc23Z10.f1175CrfGsy.f1134ADYaiT.f1323AYUAbz, aRc23Z10.B3GDIM());
                B25kr6.A2egSU(aRc23Z6, aRc23Z7, aSJ6gh.f1299ASJ6gh);
                return;
            }
        }
        if (this.f1320ADYaiT == 3) {
            BChYOn.ARc23Z aRc23Z11 = this.f1318A4TApA;
            int i4 = aRc23Z11.f1148B4ZgIw;
            if (i4 == 2) {
                BChYOn.ARc23Z aRc23Z12 = aRc23Z11.f1175CrfGsy;
                if (aRc23Z12 != null) {
                    ASJ6gh aSJ6gh2 = aRc23Z12.AMqCpz.AMqCpz;
                    aSJ6gh.f1304AcNBzu.add(aSJ6gh2);
                    aSJ6gh2.f1303AaHO0E.add(aSJ6gh);
                    aSJ6gh.f1295A4TApA = true;
                    aSJ6gh.f1303AaHO0E.add(aRc23Z7);
                    aSJ6gh.f1303AaHO0E.add(aRc23Z6);
                }
            } else if (i4 == 3) {
                if (aRc23Z11.f1149B7CMnp == 3) {
                    aRc23Z7.f1294A2egSU = this;
                    aRc23Z6.f1294A2egSU = this;
                    AmA8tU amA8tU = aRc23Z11.AMqCpz;
                    amA8tU.f1323AYUAbz.f1294A2egSU = this;
                    amA8tU.f1324AZOQYO.f1294A2egSU = this;
                    aSJ6gh.f1294A2egSU = this;
                    if (aRc23Z11.BJ7GGh()) {
                        aSJ6gh.f1304AcNBzu.add(this.f1318A4TApA.AMqCpz.AMqCpz);
                        this.f1318A4TApA.AMqCpz.AMqCpz.f1303AaHO0E.add(aSJ6gh);
                        AmA8tU amA8tU2 = this.f1318A4TApA.AMqCpz;
                        amA8tU2.AMqCpz.f1294A2egSU = this;
                        aSJ6gh.f1304AcNBzu.add(amA8tU2.f1323AYUAbz);
                        aSJ6gh.f1304AcNBzu.add(this.f1318A4TApA.AMqCpz.f1324AZOQYO);
                        this.f1318A4TApA.AMqCpz.f1323AYUAbz.f1303AaHO0E.add(aSJ6gh);
                        this.f1318A4TApA.AMqCpz.f1324AZOQYO.f1303AaHO0E.add(aSJ6gh);
                    } else if (this.f1318A4TApA.BIYEnU()) {
                        this.f1318A4TApA.AMqCpz.AMqCpz.f1304AcNBzu.add(aSJ6gh);
                        aSJ6gh.f1303AaHO0E.add(this.f1318A4TApA.AMqCpz.AMqCpz);
                    } else {
                        this.f1318A4TApA.AMqCpz.AMqCpz.f1304AcNBzu.add(aSJ6gh);
                    }
                } else {
                    ASJ6gh aSJ6gh3 = aRc23Z11.AMqCpz.AMqCpz;
                    aSJ6gh.f1304AcNBzu.add(aSJ6gh3);
                    aSJ6gh3.f1303AaHO0E.add(aSJ6gh);
                    this.f1318A4TApA.AMqCpz.f1323AYUAbz.f1303AaHO0E.add(aSJ6gh);
                    this.f1318A4TApA.AMqCpz.f1324AZOQYO.f1303AaHO0E.add(aSJ6gh);
                    aSJ6gh.f1295A4TApA = true;
                    aSJ6gh.f1303AaHO0E.add(aRc23Z7);
                    aSJ6gh.f1303AaHO0E.add(aRc23Z6);
                    aRc23Z7.f1304AcNBzu.add(aSJ6gh);
                    aRc23Z6.f1304AcNBzu.add(aSJ6gh);
                }
            }
        }
        BChYOn.ARc23Z aRc23Z13 = this.f1318A4TApA;
        BChYOn.AMqCpz[] aMqCpzArr2 = aRc23Z13.f1172CkXcdM;
        BChYOn.AMqCpz aMqCpz4 = aMqCpzArr2[0];
        BChYOn.AMqCpz aMqCpz5 = aMqCpz4.f1127ARc23Z;
        if (aMqCpz5 != null && aMqCpzArr2[1].f1127ARc23Z != null) {
            if (aRc23Z13.BIYEnU()) {
                aRc23Z7.f1298ARc23Z = this.f1318A4TApA.f1172CkXcdM[0].AMqCpz();
                aRc23Z6.f1298ARc23Z = -this.f1318A4TApA.f1172CkXcdM[1].AMqCpz();
                return;
            }
            ARc23Z ASJ6gh6 = B25kr6.ASJ6gh(this.f1318A4TApA.f1172CkXcdM[0]);
            ARc23Z ASJ6gh7 = B25kr6.ASJ6gh(this.f1318A4TApA.f1172CkXcdM[1]);
            if (ASJ6gh6 != null) {
                ASJ6gh6.A2egSU(this);
            }
            if (ASJ6gh7 != null) {
                ASJ6gh7.A2egSU(this);
            }
            this.f1325AZkASS = 4;
            return;
        }
        if (aMqCpz5 != null) {
            ARc23Z ASJ6gh8 = B25kr6.ASJ6gh(aMqCpz4);
            if (ASJ6gh8 != null) {
                B25kr6.A2egSU(aRc23Z7, ASJ6gh8, this.f1318A4TApA.f1172CkXcdM[0].AMqCpz());
                A4TApA(aRc23Z6, aRc23Z7, 1, aSJ6gh);
                return;
            }
            return;
        }
        BChYOn.AMqCpz aMqCpz6 = aMqCpzArr2[1];
        if (aMqCpz6.f1127ARc23Z != null) {
            ARc23Z ASJ6gh9 = B25kr6.ASJ6gh(aMqCpz6);
            if (ASJ6gh9 != null) {
                B25kr6.A2egSU(aRc23Z6, ASJ6gh9, -this.f1318A4TApA.f1172CkXcdM[1].AMqCpz());
                A4TApA(aRc23Z7, aRc23Z6, -1, aSJ6gh);
                return;
            }
            return;
        }
        if ((aRc23Z13 instanceof BChYOn.AaHO0E) || (aRc23Z3 = aRc23Z13.f1175CrfGsy) == null) {
            return;
        }
        B25kr6.A2egSU(aRc23Z7, aRc23Z3.f1134ADYaiT.f1323AYUAbz, aRc23Z13.B3GDIM());
        A4TApA(aRc23Z6, aRc23Z7, 1, aSJ6gh);
    }

    @Override // BI9f7h.B25kr6
    public final void ADYaiT() {
        ARc23Z aRc23Z = this.f1323AYUAbz;
        if (aRc23Z.f1302AZkASS) {
            this.f1318A4TApA.f1180D6yqiO = aRc23Z.f1299ASJ6gh;
        }
    }

    @Override // BI9f7h.B25kr6
    public final void AMqCpz() {
        this.f1319A5SV6n = null;
        this.f1323AYUAbz.A4TApA();
        this.f1324AZOQYO.A4TApA();
        this.AMqCpz.A4TApA();
        this.f1322ASJ6gh = false;
    }

    @Override // BI9f7h.B25kr6
    public final boolean AZkASS() {
        return this.f1320ADYaiT != 3 || this.f1318A4TApA.f1148B4ZgIw == 0;
    }

    public final void AlLFFp() {
        this.f1322ASJ6gh = false;
        ARc23Z aRc23Z = this.f1323AYUAbz;
        aRc23Z.A4TApA();
        aRc23Z.f1302AZkASS = false;
        ARc23Z aRc23Z2 = this.f1324AZOQYO;
        aRc23Z2.A4TApA();
        aRc23Z2.f1302AZkASS = false;
        this.AMqCpz.f1302AZkASS = false;
    }

    public final String toString() {
        return "HorizontalRun " + this.f1318A4TApA.f1189DXnQ0V;
    }

    /* JADX WARN: Code restructure failed: missing block: B:154:0x0246, code lost:
    
        if (r7 != 1) goto L125;
     */
    @Override // BI9f7h.B25kr6, BI9f7h.ADYaiT
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void update(BI9f7h.ADYaiT r24) {
        /*
            Method dump skipped, instructions count: 920
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: BI9f7h.AcNBzu.update(BI9f7h.ADYaiT):void");
    }
}
