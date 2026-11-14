package BChYOn;

import java.util.ArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class AZkASS extends ARc23Z {

    /* renamed from: DuwtYk, reason: collision with root package name */
    public float f1256DuwtYk = -1.0f;

    /* renamed from: DvK7DB, reason: collision with root package name */
    public int f1257DvK7DB = -1;

    /* renamed from: DyaChj, reason: collision with root package name */
    public int f1258DyaChj = -1;

    /* renamed from: ECyGFg, reason: collision with root package name */
    public AMqCpz f1259ECyGFg = this.f1165COJEAR;

    /* renamed from: EGM26s, reason: collision with root package name */
    public int f1260EGM26s = 0;

    /* renamed from: EH1KK8, reason: collision with root package name */
    public boolean f1261EH1KK8;

    public AZkASS() {
        this.f1173CmUvjW.clear();
        this.f1173CmUvjW.add(this.f1259ECyGFg);
        int length = this.f1172CkXcdM.length;
        for (int i = 0; i < length; i++) {
            this.f1172CkXcdM[i] = this.f1259ECyGFg;
        }
    }

    @Override // BChYOn.ARc23Z
    public final void A4TApA(B4ZgIw.ADYaiT aDYaiT, boolean z) {
        ASJ6gh aSJ6gh = (ASJ6gh) this.f1175CrfGsy;
        if (aSJ6gh == null) {
            return;
        }
        Object AZOQYO2 = aSJ6gh.AZOQYO(ADYaiT.f1114AcNBzu);
        Object AZOQYO3 = aSJ6gh.AZOQYO(ADYaiT.f1116AmA8tU);
        ARc23Z aRc23Z = this.f1175CrfGsy;
        boolean z2 = aRc23Z != null && aRc23Z.f1195Dphsd2[0] == 2;
        if (this.f1260EGM26s == 0) {
            AZOQYO2 = aSJ6gh.AZOQYO(ADYaiT.f1115AlLFFp);
            AZOQYO3 = aSJ6gh.AZOQYO(ADYaiT.f1117AzWtSf);
            ARc23Z aRc23Z2 = this.f1175CrfGsy;
            z2 = aRc23Z2 != null && aRc23Z2.f1195Dphsd2[1] == 2;
        }
        if (this.f1261EH1KK8) {
            AMqCpz aMqCpz = this.f1259ECyGFg;
            if (aMqCpz.f1125A5SV6n) {
                B4ZgIw.AZOQYO AaHO0E2 = aDYaiT.AaHO0E(aMqCpz);
                aDYaiT.ADYaiT(AaHO0E2, this.f1259ECyGFg.ADYaiT());
                if (this.f1257DvK7DB != -1) {
                    if (z2) {
                        aDYaiT.ARc23Z(aDYaiT.AaHO0E(AZOQYO3), AaHO0E2, 0, 5);
                    }
                } else if (this.f1258DyaChj != -1 && z2) {
                    B4ZgIw.AZOQYO AaHO0E3 = aDYaiT.AaHO0E(AZOQYO3);
                    aDYaiT.ARc23Z(AaHO0E2, aDYaiT.AaHO0E(AZOQYO2), 0, 5);
                    aDYaiT.ARc23Z(AaHO0E3, AaHO0E2, 0, 5);
                }
                this.f1261EH1KK8 = false;
                return;
            }
        }
        if (this.f1257DvK7DB != -1) {
            B4ZgIw.AZOQYO AaHO0E4 = aDYaiT.AaHO0E(this.f1259ECyGFg);
            aDYaiT.AMqCpz(AaHO0E4, aDYaiT.AaHO0E(AZOQYO2), this.f1257DvK7DB, 8);
            if (z2) {
                aDYaiT.ARc23Z(aDYaiT.AaHO0E(AZOQYO3), AaHO0E4, 0, 5);
                return;
            }
            return;
        }
        if (this.f1258DyaChj != -1) {
            B4ZgIw.AZOQYO AaHO0E5 = aDYaiT.AaHO0E(this.f1259ECyGFg);
            B4ZgIw.AZOQYO AaHO0E6 = aDYaiT.AaHO0E(AZOQYO3);
            aDYaiT.AMqCpz(AaHO0E5, AaHO0E6, -this.f1258DyaChj, 8);
            if (z2) {
                aDYaiT.ARc23Z(AaHO0E5, aDYaiT.AaHO0E(AZOQYO2), 0, 5);
                aDYaiT.ARc23Z(AaHO0E6, AaHO0E5, 0, 5);
                return;
            }
            return;
        }
        if (this.f1256DuwtYk != -1.0f) {
            B4ZgIw.AZOQYO AaHO0E7 = aDYaiT.AaHO0E(this.f1259ECyGFg);
            B4ZgIw.AZOQYO AaHO0E8 = aDYaiT.AaHO0E(AZOQYO3);
            float f = this.f1256DuwtYk;
            B4ZgIw.A4TApA AcNBzu2 = aDYaiT.AcNBzu();
            AcNBzu2.f1051ADYaiT.ASJ6gh(AaHO0E7, -1.0f);
            AcNBzu2.f1051ADYaiT.ASJ6gh(AaHO0E8, f);
            aDYaiT.A5SV6n(AcNBzu2);
        }
    }

    @Override // BChYOn.ARc23Z
    public final boolean A5SV6n() {
        return true;
    }

    @Override // BChYOn.ARc23Z
    public final AMqCpz AZOQYO(ADYaiT aDYaiT) {
        int ordinal = aDYaiT.ordinal();
        if (ordinal != 1) {
            if (ordinal != 2) {
                if (ordinal != 3) {
                    if (ordinal != 4) {
                        return null;
                    }
                }
            }
            if (this.f1260EGM26s == 0) {
                return this.f1259ECyGFg;
            }
            return null;
        }
        if (this.f1260EGM26s == 1) {
            return this.f1259ECyGFg;
        }
        return null;
    }

    @Override // BChYOn.ARc23Z
    public final boolean BPw6Q8() {
        return this.f1261EH1KK8;
    }

    @Override // BChYOn.ARc23Z
    public final boolean BTvldC() {
        return this.f1261EH1KK8;
    }

    @Override // BChYOn.ARc23Z
    public final void CikNvS(B4ZgIw.ADYaiT aDYaiT, boolean z) {
        if (this.f1175CrfGsy == null) {
            return;
        }
        AMqCpz aMqCpz = this.f1259ECyGFg;
        aDYaiT.getClass();
        int AmA8tU2 = B4ZgIw.ADYaiT.AmA8tU(aMqCpz);
        if (this.f1260EGM26s == 1) {
            this.f1180D6yqiO = AmA8tU2;
            this.f1181D8MqeW = 0;
            CQhlFr(this.f1175CrfGsy.AaHO0E());
            CcAIMM(0);
            return;
        }
        this.f1180D6yqiO = 0;
        this.f1181D8MqeW = AmA8tU2;
        CcAIMM(this.f1175CrfGsy.B2KMhB());
        CQhlFr(0);
    }

    public final void CkXcdM(int i) {
        this.f1259ECyGFg.AcNBzu(i);
        this.f1261EH1KK8 = true;
    }

    public final void CmUvjW(int i) {
        if (this.f1260EGM26s == i) {
            return;
        }
        this.f1260EGM26s = i;
        ArrayList arrayList = this.f1173CmUvjW;
        arrayList.clear();
        if (this.f1260EGM26s == 1) {
            this.f1259ECyGFg = this.f1164CNPG0E;
        } else {
            this.f1259ECyGFg = this.f1165COJEAR;
        }
        arrayList.add(this.f1259ECyGFg);
        AMqCpz[] aMqCpzArr = this.f1172CkXcdM;
        int length = aMqCpzArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            aMqCpzArr[i2] = this.f1259ECyGFg;
        }
    }

    @Override // BChYOn.ARc23Z
    public String getType() {
        return "Guideline";
    }
}
