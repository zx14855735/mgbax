package BI9f7h;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class AYUAbz {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static final A4TApA f1306A2egSU = new A4TApA();

    static {
        TGTVC();
    }

    public static boolean A2egSU(BChYOn.ARc23Z aRc23Z) {
        int[] iArr = aRc23Z.f1195Dphsd2;
        int i = iArr[0];
        int i2 = iArr[1];
        BChYOn.ARc23Z aRc23Z2 = aRc23Z.f1175CrfGsy;
        BChYOn.ASJ6gh aSJ6gh = aRc23Z2 != null ? (BChYOn.ASJ6gh) aRc23Z2 : null;
        if (aSJ6gh != null) {
            int i3 = aSJ6gh.f1195Dphsd2[0];
        }
        if (aSJ6gh != null) {
            int i4 = aSJ6gh.f1195Dphsd2[1];
        }
        boolean z = i == 1 || aRc23Z.BPw6Q8() || i == 2 || (i == 3 && aRc23Z.f1148B4ZgIw == 0 && aRc23Z.f1178D07BeM == 0.0f && aRc23Z.B7CMnp(0)) || (i == 3 && aRc23Z.f1148B4ZgIw == 1 && aRc23Z.B9tovu(0, aRc23Z.B2KMhB()));
        boolean z2 = i2 == 1 || aRc23Z.BTvldC() || i2 == 2 || (i2 == 3 && aRc23Z.f1149B7CMnp == 0 && aRc23Z.f1178D07BeM == 0.0f && aRc23Z.B7CMnp(1)) || (i2 == 3 && aRc23Z.f1149B7CMnp == 1 && aRc23Z.B9tovu(1, aRc23Z.AaHO0E()));
        return (aRc23Z.f1178D07BeM > 0.0f && (z || z2)) || (z && z2);
    }

    public static void A4TApA(int i, BChYOn.ARc23Z aRc23Z, BJ7GGh.AMqCpz aMqCpz, boolean z) {
        BChYOn.AMqCpz aMqCpz2;
        BChYOn.AMqCpz aMqCpz3;
        char c;
        BChYOn.AMqCpz aMqCpz4;
        BChYOn.AMqCpz aMqCpz5;
        if (aRc23Z.f1143AmA8tU) {
            return;
        }
        if (!(aRc23Z instanceof BChYOn.ASJ6gh) && aRc23Z.BNL6CD() && A2egSU(aRc23Z)) {
            BChYOn.ASJ6gh.CtFAbx(aRc23Z, aMqCpz, new A4TApA());
        }
        BChYOn.AMqCpz AZOQYO2 = aRc23Z.AZOQYO(BChYOn.ADYaiT.f1114AcNBzu);
        BChYOn.AMqCpz AZOQYO3 = aRc23Z.AZOQYO(BChYOn.ADYaiT.f1116AmA8tU);
        int ADYaiT2 = AZOQYO2.ADYaiT();
        int ADYaiT3 = AZOQYO3.ADYaiT();
        HashSet hashSet = AZOQYO2.f1123A2egSU;
        if (hashSet != null && AZOQYO2.f1125A5SV6n) {
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                BChYOn.AMqCpz aMqCpz6 = (BChYOn.AMqCpz) it.next();
                BChYOn.ARc23Z aRc23Z2 = aMqCpz6.f1126ADYaiT;
                int i2 = i + 1;
                boolean A2egSU2 = A2egSU(aRc23Z2);
                if (aRc23Z2.BNL6CD() && A2egSU2) {
                    c = 0;
                    BChYOn.ASJ6gh.CtFAbx(aRc23Z2, aMqCpz, new A4TApA());
                } else {
                    c = 0;
                }
                BChYOn.AMqCpz aMqCpz7 = aRc23Z2.f1164CNPG0E;
                BChYOn.AMqCpz aMqCpz8 = aRc23Z2.f1166CQhlFr;
                boolean z2 = (aMqCpz6 == aMqCpz7 && (aMqCpz5 = aMqCpz8.f1127ARc23Z) != null && aMqCpz5.f1125A5SV6n) || (aMqCpz6 == aMqCpz8 && (aMqCpz4 = aMqCpz7.f1127ARc23Z) != null && aMqCpz4.f1125A5SV6n);
                int i3 = aRc23Z2.f1195Dphsd2[c];
                if (i3 != 3 || A2egSU2) {
                    if (!aRc23Z2.BNL6CD()) {
                        if (aMqCpz6 == aMqCpz7 && aMqCpz8.f1127ARc23Z == null) {
                            int AMqCpz = aMqCpz7.AMqCpz() + ADYaiT2;
                            aRc23Z2.CNPG0E(AMqCpz, aRc23Z2.B2KMhB() + AMqCpz);
                            A4TApA(i2, aRc23Z2, aMqCpz, z);
                        } else if (aMqCpz6 == aMqCpz8 && aMqCpz7.f1127ARc23Z == null) {
                            int AMqCpz2 = ADYaiT2 - aMqCpz8.AMqCpz();
                            aRc23Z2.CNPG0E(AMqCpz2 - aRc23Z2.B2KMhB(), AMqCpz2);
                            A4TApA(i2, aRc23Z2, aMqCpz, z);
                        } else if (z2 && !aRc23Z2.BIYEnU()) {
                            A5SV6n(i2, aRc23Z2, aMqCpz, z);
                        }
                    }
                } else if (i3 == 3 && aRc23Z2.f1152BI9f7h >= 0 && aRc23Z2.f1151BChYOn >= 0 && (aRc23Z2.f1188DV2E8K == 8 || (aRc23Z2.f1148B4ZgIw == 0 && aRc23Z2.f1178D07BeM == 0.0f))) {
                    if (!aRc23Z2.BIYEnU() && !aRc23Z2.f1161C2rE4F && z2 && !aRc23Z2.BIYEnU()) {
                        ADYaiT(i2, aRc23Z, aMqCpz, aRc23Z2, z);
                    }
                }
            }
        }
        if (aRc23Z instanceof BChYOn.AZkASS) {
            return;
        }
        HashSet hashSet2 = AZOQYO3.f1123A2egSU;
        if (hashSet2 != null && AZOQYO3.f1125A5SV6n) {
            Iterator it2 = hashSet2.iterator();
            while (it2.hasNext()) {
                BChYOn.AMqCpz aMqCpz9 = (BChYOn.AMqCpz) it2.next();
                BChYOn.ARc23Z aRc23Z3 = aMqCpz9.f1126ADYaiT;
                int i4 = i + 1;
                boolean A2egSU3 = A2egSU(aRc23Z3);
                if (aRc23Z3.BNL6CD() && A2egSU3) {
                    BChYOn.ASJ6gh.CtFAbx(aRc23Z3, aMqCpz, new A4TApA());
                }
                BChYOn.AMqCpz aMqCpz10 = aRc23Z3.f1164CNPG0E;
                BChYOn.AMqCpz aMqCpz11 = aRc23Z3.f1166CQhlFr;
                boolean z3 = (aMqCpz9 == aMqCpz10 && (aMqCpz3 = aMqCpz11.f1127ARc23Z) != null && aMqCpz3.f1125A5SV6n) || (aMqCpz9 == aMqCpz11 && (aMqCpz2 = aMqCpz10.f1127ARc23Z) != null && aMqCpz2.f1125A5SV6n);
                int i5 = aRc23Z3.f1195Dphsd2[0];
                if (i5 != 3 || A2egSU3) {
                    if (!aRc23Z3.BNL6CD()) {
                        if (aMqCpz9 == aMqCpz10 && aMqCpz11.f1127ARc23Z == null) {
                            int AMqCpz3 = aMqCpz10.AMqCpz() + ADYaiT3;
                            aRc23Z3.CNPG0E(AMqCpz3, aRc23Z3.B2KMhB() + AMqCpz3);
                            A4TApA(i4, aRc23Z3, aMqCpz, z);
                        } else if (aMqCpz9 == aMqCpz11 && aMqCpz10.f1127ARc23Z == null) {
                            int AMqCpz4 = ADYaiT3 - aMqCpz11.AMqCpz();
                            aRc23Z3.CNPG0E(AMqCpz4 - aRc23Z3.B2KMhB(), AMqCpz4);
                            A4TApA(i4, aRc23Z3, aMqCpz, z);
                        } else if (z3 && !aRc23Z3.BIYEnU()) {
                            A5SV6n(i4, aRc23Z3, aMqCpz, z);
                        }
                    }
                } else if (i5 == 3 && aRc23Z3.f1152BI9f7h >= 0 && aRc23Z3.f1151BChYOn >= 0) {
                    if (aRc23Z3.f1188DV2E8K == 8 || (aRc23Z3.f1148B4ZgIw == 0 && aRc23Z3.f1178D07BeM == 0.0f)) {
                        if (!aRc23Z3.BIYEnU() && !aRc23Z3.f1161C2rE4F && z3 && !aRc23Z3.BIYEnU()) {
                            ADYaiT(i4, aRc23Z, aMqCpz, aRc23Z3, z);
                        }
                    }
                }
            }
        }
        aRc23Z.f1143AmA8tU = true;
    }

    public static void A5SV6n(int i, BChYOn.ARc23Z aRc23Z, BJ7GGh.AMqCpz aMqCpz, boolean z) {
        float f = aRc23Z.f1185DG07BK;
        BChYOn.AMqCpz aMqCpz2 = aRc23Z.f1164CNPG0E;
        int ADYaiT2 = aMqCpz2.f1127ARc23Z.ADYaiT();
        BChYOn.AMqCpz aMqCpz3 = aRc23Z.f1166CQhlFr;
        int ADYaiT3 = aMqCpz3.f1127ARc23Z.ADYaiT();
        int AMqCpz = aMqCpz2.AMqCpz() + ADYaiT2;
        int AMqCpz2 = ADYaiT3 - aMqCpz3.AMqCpz();
        if (ADYaiT2 == ADYaiT3) {
            f = 0.5f;
        } else {
            ADYaiT2 = AMqCpz;
            ADYaiT3 = AMqCpz2;
        }
        int B2KMhB2 = aRc23Z.B2KMhB();
        int i2 = (ADYaiT3 - ADYaiT2) - B2KMhB2;
        if (ADYaiT2 > ADYaiT3) {
            i2 = (ADYaiT2 - ADYaiT3) - B2KMhB2;
        }
        int i3 = ((int) (i2 > 0 ? (f * i2) + 0.5f : f * i2)) + ADYaiT2;
        int i4 = i3 + B2KMhB2;
        if (ADYaiT2 > ADYaiT3) {
            i4 = i3 - B2KMhB2;
        }
        aRc23Z.CNPG0E(i3, i4);
        A4TApA(i + 1, aRc23Z, aMqCpz, z);
    }

    public static void ADYaiT(int i, BChYOn.ARc23Z aRc23Z, BJ7GGh.AMqCpz aMqCpz, BChYOn.ARc23Z aRc23Z2, boolean z) {
        float f = aRc23Z2.f1185DG07BK;
        BChYOn.AMqCpz aMqCpz2 = aRc23Z2.f1164CNPG0E;
        int AMqCpz = aMqCpz2.AMqCpz() + aMqCpz2.f1127ARc23Z.ADYaiT();
        BChYOn.AMqCpz aMqCpz3 = aRc23Z2.f1166CQhlFr;
        int ADYaiT2 = aMqCpz3.f1127ARc23Z.ADYaiT() - aMqCpz3.AMqCpz();
        if (ADYaiT2 >= AMqCpz) {
            int B2KMhB2 = aRc23Z2.B2KMhB();
            if (aRc23Z2.f1188DV2E8K != 8) {
                int i2 = aRc23Z2.f1148B4ZgIw;
                if (i2 == 2) {
                    B2KMhB2 = (int) (aRc23Z2.f1185DG07BK * 0.5f * (aRc23Z instanceof BChYOn.ASJ6gh ? aRc23Z.B2KMhB() : aRc23Z.f1175CrfGsy.B2KMhB()));
                } else if (i2 == 0) {
                    B2KMhB2 = ADYaiT2 - AMqCpz;
                }
                B2KMhB2 = Math.max(aRc23Z2.f1151BChYOn, B2KMhB2);
                int i3 = aRc23Z2.f1152BI9f7h;
                if (i3 > 0) {
                    B2KMhB2 = Math.min(i3, B2KMhB2);
                }
            }
            int i4 = AMqCpz + ((int) ((f * ((ADYaiT2 - AMqCpz) - B2KMhB2)) + 0.5f));
            aRc23Z2.CNPG0E(i4, B2KMhB2 + i4);
            A4TApA(i + 1, aRc23Z2, aMqCpz, z);
        }
    }

    public static void AMqCpz(int i, BChYOn.ARc23Z aRc23Z, BJ7GGh.AMqCpz aMqCpz) {
        float f = aRc23Z.f1186DRlcZ9;
        BChYOn.AMqCpz aMqCpz2 = aRc23Z.f1165COJEAR;
        int ADYaiT2 = aMqCpz2.f1127ARc23Z.ADYaiT();
        BChYOn.AMqCpz aMqCpz3 = aRc23Z.f1167CSDoyG;
        int ADYaiT3 = aMqCpz3.f1127ARc23Z.ADYaiT();
        int AMqCpz = aMqCpz2.AMqCpz() + ADYaiT2;
        int AMqCpz2 = ADYaiT3 - aMqCpz3.AMqCpz();
        if (ADYaiT2 == ADYaiT3) {
            f = 0.5f;
        } else {
            ADYaiT2 = AMqCpz;
            ADYaiT3 = AMqCpz2;
        }
        int AaHO0E2 = aRc23Z.AaHO0E();
        int i2 = (ADYaiT3 - ADYaiT2) - AaHO0E2;
        if (ADYaiT2 > ADYaiT3) {
            i2 = (ADYaiT2 - ADYaiT3) - AaHO0E2;
        }
        int i3 = (int) (i2 > 0 ? (f * i2) + 0.5f : f * i2);
        int i4 = ADYaiT2 + i3;
        int i5 = i4 + AaHO0E2;
        if (ADYaiT2 > ADYaiT3) {
            i4 = ADYaiT2 - i3;
            i5 = i4 - AaHO0E2;
        }
        aRc23Z.COJEAR(i4, i5);
        ASJ6gh(i + 1, aRc23Z, aMqCpz);
    }

    public static void ARc23Z(int i, BChYOn.ARc23Z aRc23Z, BJ7GGh.AMqCpz aMqCpz, BChYOn.ARc23Z aRc23Z2) {
        float f = aRc23Z2.f1186DRlcZ9;
        BChYOn.AMqCpz aMqCpz2 = aRc23Z2.f1165COJEAR;
        int AMqCpz = aMqCpz2.AMqCpz() + aMqCpz2.f1127ARc23Z.ADYaiT();
        BChYOn.AMqCpz aMqCpz3 = aRc23Z2.f1167CSDoyG;
        int ADYaiT2 = aMqCpz3.f1127ARc23Z.ADYaiT() - aMqCpz3.AMqCpz();
        if (ADYaiT2 >= AMqCpz) {
            int AaHO0E2 = aRc23Z2.AaHO0E();
            if (aRc23Z2.f1188DV2E8K != 8) {
                int i2 = aRc23Z2.f1149B7CMnp;
                if (i2 == 2) {
                    AaHO0E2 = (int) (f * 0.5f * (aRc23Z instanceof BChYOn.ASJ6gh ? aRc23Z.AaHO0E() : aRc23Z.f1175CrfGsy.AaHO0E()));
                } else if (i2 == 0) {
                    AaHO0E2 = ADYaiT2 - AMqCpz;
                }
                AaHO0E2 = Math.max(aRc23Z2.f1154BJ7GGh, AaHO0E2);
                int i3 = aRc23Z2.f1155BNL6CD;
                if (i3 > 0) {
                    AaHO0E2 = Math.min(i3, AaHO0E2);
                }
            }
            int i4 = AMqCpz + ((int) ((f * ((ADYaiT2 - AMqCpz) - AaHO0E2)) + 0.5f));
            aRc23Z2.COJEAR(i4, AaHO0E2 + i4);
            ASJ6gh(i + 1, aRc23Z2, aMqCpz);
        }
    }

    public static void ASJ6gh(int i, BChYOn.ARc23Z aRc23Z, BJ7GGh.AMqCpz aMqCpz) {
        BChYOn.AMqCpz aMqCpz2;
        BChYOn.AMqCpz aMqCpz3;
        BChYOn.AMqCpz aMqCpz4;
        BChYOn.AMqCpz aMqCpz5;
        if (aRc23Z.f1144AzWtSf) {
            return;
        }
        if (!(aRc23Z instanceof BChYOn.ASJ6gh) && aRc23Z.BNL6CD() && A2egSU(aRc23Z)) {
            BChYOn.ASJ6gh.CtFAbx(aRc23Z, aMqCpz, new A4TApA());
        }
        BChYOn.AMqCpz AZOQYO2 = aRc23Z.AZOQYO(BChYOn.ADYaiT.f1115AlLFFp);
        BChYOn.AMqCpz AZOQYO3 = aRc23Z.AZOQYO(BChYOn.ADYaiT.f1117AzWtSf);
        int ADYaiT2 = AZOQYO2.ADYaiT();
        int ADYaiT3 = AZOQYO3.ADYaiT();
        HashSet hashSet = AZOQYO2.f1123A2egSU;
        if (hashSet != null && AZOQYO2.f1125A5SV6n) {
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                BChYOn.AMqCpz aMqCpz6 = (BChYOn.AMqCpz) it.next();
                BChYOn.ARc23Z aRc23Z2 = aMqCpz6.f1126ADYaiT;
                int i2 = i + 1;
                boolean A2egSU2 = A2egSU(aRc23Z2);
                if (aRc23Z2.BNL6CD() && A2egSU2) {
                    BChYOn.ASJ6gh.CtFAbx(aRc23Z2, aMqCpz, new A4TApA());
                }
                BChYOn.AMqCpz aMqCpz7 = aRc23Z2.f1165COJEAR;
                BChYOn.AMqCpz aMqCpz8 = aRc23Z2.f1167CSDoyG;
                boolean z = (aMqCpz6 == aMqCpz7 && (aMqCpz5 = aMqCpz8.f1127ARc23Z) != null && aMqCpz5.f1125A5SV6n) || (aMqCpz6 == aMqCpz8 && (aMqCpz4 = aMqCpz7.f1127ARc23Z) != null && aMqCpz4.f1125A5SV6n);
                int i3 = aRc23Z2.f1195Dphsd2[1];
                if (i3 != 3 || A2egSU2) {
                    if (!aRc23Z2.BNL6CD()) {
                        if (aMqCpz6 == aMqCpz7 && aMqCpz8.f1127ARc23Z == null) {
                            int AMqCpz = aMqCpz7.AMqCpz() + ADYaiT2;
                            aRc23Z2.COJEAR(AMqCpz, aRc23Z2.AaHO0E() + AMqCpz);
                            ASJ6gh(i2, aRc23Z2, aMqCpz);
                        } else if (aMqCpz6 == aMqCpz8 && aMqCpz7.f1127ARc23Z == null) {
                            int AMqCpz2 = ADYaiT2 - aMqCpz8.AMqCpz();
                            aRc23Z2.COJEAR(AMqCpz2 - aRc23Z2.AaHO0E(), AMqCpz2);
                            ASJ6gh(i2, aRc23Z2, aMqCpz);
                        } else if (z && !aRc23Z2.BJ7GGh()) {
                            AMqCpz(i2, aRc23Z2, aMqCpz);
                        }
                    }
                } else if (i3 == 3 && aRc23Z2.f1155BNL6CD >= 0 && aRc23Z2.f1154BJ7GGh >= 0 && (aRc23Z2.f1188DV2E8K == 8 || (aRc23Z2.f1149B7CMnp == 0 && aRc23Z2.f1178D07BeM == 0.0f))) {
                    if (!aRc23Z2.BJ7GGh() && !aRc23Z2.f1161C2rE4F && z && !aRc23Z2.BJ7GGh()) {
                        ARc23Z(i2, aRc23Z, aMqCpz, aRc23Z2);
                    }
                }
            }
        }
        char c = 1;
        if (aRc23Z instanceof BChYOn.AZkASS) {
            return;
        }
        HashSet hashSet2 = AZOQYO3.f1123A2egSU;
        if (hashSet2 != null && AZOQYO3.f1125A5SV6n) {
            Iterator it2 = hashSet2.iterator();
            while (it2.hasNext()) {
                BChYOn.AMqCpz aMqCpz9 = (BChYOn.AMqCpz) it2.next();
                BChYOn.ARc23Z aRc23Z3 = aMqCpz9.f1126ADYaiT;
                int i4 = i + 1;
                boolean A2egSU3 = A2egSU(aRc23Z3);
                if (aRc23Z3.BNL6CD() && A2egSU3) {
                    BChYOn.ASJ6gh.CtFAbx(aRc23Z3, aMqCpz, new A4TApA());
                }
                BChYOn.AMqCpz aMqCpz10 = aRc23Z3.f1165COJEAR;
                BChYOn.AMqCpz aMqCpz11 = aRc23Z3.f1167CSDoyG;
                boolean z2 = (aMqCpz9 == aMqCpz10 && (aMqCpz3 = aMqCpz11.f1127ARc23Z) != null && aMqCpz3.f1125A5SV6n) || (aMqCpz9 == aMqCpz11 && (aMqCpz2 = aMqCpz10.f1127ARc23Z) != null && aMqCpz2.f1125A5SV6n);
                int i5 = aRc23Z3.f1195Dphsd2[1];
                if (i5 != 3 || A2egSU3) {
                    if (!aRc23Z3.BNL6CD()) {
                        if (aMqCpz9 == aMqCpz10 && aMqCpz11.f1127ARc23Z == null) {
                            int AMqCpz3 = aMqCpz10.AMqCpz() + ADYaiT3;
                            aRc23Z3.COJEAR(AMqCpz3, aRc23Z3.AaHO0E() + AMqCpz3);
                            ASJ6gh(i4, aRc23Z3, aMqCpz);
                        } else if (aMqCpz9 == aMqCpz11 && aMqCpz10.f1127ARc23Z == null) {
                            int AMqCpz4 = ADYaiT3 - aMqCpz11.AMqCpz();
                            aRc23Z3.COJEAR(AMqCpz4 - aRc23Z3.AaHO0E(), AMqCpz4);
                            ASJ6gh(i4, aRc23Z3, aMqCpz);
                        } else if (z2 && !aRc23Z3.BJ7GGh()) {
                            AMqCpz(i4, aRc23Z3, aMqCpz);
                        }
                    }
                } else if (i5 == 3 && aRc23Z3.f1155BNL6CD >= 0 && aRc23Z3.f1154BJ7GGh >= 0 && (aRc23Z3.f1188DV2E8K == 8 || (aRc23Z3.f1149B7CMnp == 0 && aRc23Z3.f1178D07BeM == 0.0f))) {
                    if (!aRc23Z3.BJ7GGh() && !aRc23Z3.f1161C2rE4F && z2 && !aRc23Z3.BJ7GGh()) {
                        ARc23Z(i4, aRc23Z, aMqCpz, aRc23Z3);
                    }
                }
            }
        }
        BChYOn.AMqCpz AZOQYO4 = aRc23Z.AZOQYO(BChYOn.ADYaiT.f1118B25kr6);
        if (AZOQYO4.f1123A2egSU != null && AZOQYO4.f1125A5SV6n) {
            int ADYaiT4 = AZOQYO4.ADYaiT();
            Iterator it3 = AZOQYO4.f1123A2egSU.iterator();
            while (it3.hasNext()) {
                BChYOn.AMqCpz aMqCpz12 = (BChYOn.AMqCpz) it3.next();
                BChYOn.ARc23Z aRc23Z4 = aMqCpz12.f1126ADYaiT;
                int i6 = i + 1;
                boolean A2egSU4 = A2egSU(aRc23Z4);
                if (aRc23Z4.BNL6CD() && A2egSU4) {
                    BChYOn.ASJ6gh.CtFAbx(aRc23Z4, aMqCpz, new A4TApA());
                }
                if (aRc23Z4.f1195Dphsd2[c] != 3 || A2egSU4) {
                    if (aRc23Z4.BNL6CD()) {
                        continue;
                    } else {
                        BChYOn.AMqCpz aMqCpz13 = aRc23Z4.f1168CTkVKb;
                        if (aMqCpz12 == aMqCpz13) {
                            int AMqCpz5 = aMqCpz12.AMqCpz() + ADYaiT4;
                            if (aRc23Z4.BpkvW3) {
                                int i7 = AMqCpz5 - aRc23Z4.f1182D8cQ8b;
                                int i8 = aRc23Z4.f1177CtxOCS + i7;
                                aRc23Z4.f1181D8MqeW = i7;
                                aRc23Z4.f1165COJEAR.AcNBzu(i7);
                                aRc23Z4.f1167CSDoyG.AcNBzu(i8);
                                aMqCpz13.AcNBzu(AMqCpz5);
                                aRc23Z4.f1142AlLFFp = true;
                            }
                            ASJ6gh(i6, aRc23Z4, aMqCpz);
                        }
                    }
                }
                c = 1;
            }
        }
        aRc23Z.f1144AzWtSf = true;
    }

    private static /* synthetic */ void TGTVC() {
        char[] charArray = "ÀÌÎ\u008dÄÂÎÆ\u008dÁÌÚ\u008dÐËÆÏÏ\u008déÍÊáÑÊÇÄÆ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 163);
        }
        String str = new String(charArray);
        char[] charArray2 = "ÀÏÊÍÊ×".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 163);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
