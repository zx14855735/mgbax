package BChYOn;

import ADYaiT.CtFAbx;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class A2egSU extends AaHO0E {

    /* renamed from: DyaChj, reason: collision with root package name */
    public int f1094DyaChj = 0;

    /* renamed from: ECyGFg, reason: collision with root package name */
    public boolean f1095ECyGFg = true;

    /* renamed from: EGM26s, reason: collision with root package name */
    public int f1096EGM26s = 0;

    /* renamed from: EH1KK8, reason: collision with root package name */
    public boolean f1097EH1KK8 = false;

    @Override // BChYOn.ARc23Z
    public final void A4TApA(B4ZgIw.ADYaiT aDYaiT, boolean z) {
        boolean z2;
        int i;
        int i2;
        AMqCpz[] aMqCpzArr = this.f1172CkXcdM;
        AMqCpz aMqCpz = this.f1164CNPG0E;
        aMqCpzArr[0] = aMqCpz;
        AMqCpz aMqCpz2 = this.f1165COJEAR;
        int i3 = 2;
        aMqCpzArr[2] = aMqCpz2;
        AMqCpz aMqCpz3 = this.f1166CQhlFr;
        aMqCpzArr[1] = aMqCpz3;
        AMqCpz aMqCpz4 = this.f1167CSDoyG;
        aMqCpzArr[3] = aMqCpz4;
        for (AMqCpz aMqCpz5 : aMqCpzArr) {
            aMqCpz5.f1130AZOQYO = aDYaiT.AaHO0E(aMqCpz5);
        }
        int i4 = this.f1094DyaChj;
        if (i4 < 0 || i4 >= 4) {
            return;
        }
        AMqCpz aMqCpz6 = aMqCpzArr[i4];
        if (!this.f1097EH1KK8) {
            CqNSpT();
        }
        if (this.f1097EH1KK8) {
            this.f1097EH1KK8 = false;
            int i5 = this.f1094DyaChj;
            if (i5 == 0 || i5 == 1) {
                aDYaiT.ADYaiT(aMqCpz.f1130AZOQYO, this.f1180D6yqiO);
                aDYaiT.ADYaiT(aMqCpz3.f1130AZOQYO, this.f1180D6yqiO);
                return;
            } else {
                if (i5 == 2 || i5 == 3) {
                    aDYaiT.ADYaiT(aMqCpz2.f1130AZOQYO, this.f1181D8MqeW);
                    aDYaiT.ADYaiT(aMqCpz4.f1130AZOQYO, this.f1181D8MqeW);
                    return;
                }
                return;
            }
        }
        for (int i6 = 0; i6 < this.f1263DvK7DB; i6++) {
            ARc23Z aRc23Z = this.f1262DuwtYk[i6];
            if ((this.f1095ECyGFg || aRc23Z.A5SV6n()) && ((((i2 = this.f1094DyaChj) == 0 || i2 == 1) && aRc23Z.f1195Dphsd2[0] == 3 && aRc23Z.f1164CNPG0E.f1127ARc23Z != null && aRc23Z.f1166CQhlFr.f1127ARc23Z != null) || ((i2 == 2 || i2 == 3) && aRc23Z.f1195Dphsd2[1] == 3 && aRc23Z.f1165COJEAR.f1127ARc23Z != null && aRc23Z.f1167CSDoyG.f1127ARc23Z != null))) {
                z2 = true;
                break;
            }
        }
        z2 = false;
        boolean z3 = aMqCpz.ASJ6gh() || aMqCpz3.ASJ6gh();
        boolean z4 = aMqCpz2.ASJ6gh() || aMqCpz4.ASJ6gh();
        int i7 = (z2 || !(((i = this.f1094DyaChj) == 0 && z3) || ((i == 2 && z4) || ((i == 1 && z3) || (i == 3 && z4))))) ? 4 : 5;
        int i8 = 0;
        while (i8 < this.f1263DvK7DB) {
            ARc23Z aRc23Z2 = this.f1262DuwtYk[i8];
            if (this.f1095ECyGFg || aRc23Z2.A5SV6n()) {
                B4ZgIw.AZOQYO AaHO0E2 = aDYaiT.AaHO0E(aRc23Z2.f1172CkXcdM[this.f1094DyaChj]);
                int i9 = this.f1094DyaChj;
                AMqCpz aMqCpz7 = aRc23Z2.f1172CkXcdM[i9];
                aMqCpz7.f1130AZOQYO = AaHO0E2;
                AMqCpz aMqCpz8 = aMqCpz7.f1127ARc23Z;
                int i10 = (aMqCpz8 == null || aMqCpz8.f1126ADYaiT != this) ? 0 : aMqCpz7.f1128ASJ6gh;
                if (i9 == 0 || i9 == i3) {
                    B4ZgIw.AZOQYO azoqyo = aMqCpz6.f1130AZOQYO;
                    int i11 = this.f1096EGM26s - i10;
                    B4ZgIw.A4TApA AcNBzu2 = aDYaiT.AcNBzu();
                    B4ZgIw.AZOQYO AlLFFp2 = aDYaiT.AlLFFp();
                    AlLFFp2.f1082AzWtSf = 0;
                    AcNBzu2.A5SV6n(azoqyo, AaHO0E2, AlLFFp2, i11);
                    aDYaiT.A5SV6n(AcNBzu2);
                } else {
                    B4ZgIw.AZOQYO azoqyo2 = aMqCpz6.f1130AZOQYO;
                    int i12 = this.f1096EGM26s + i10;
                    B4ZgIw.A4TApA AcNBzu3 = aDYaiT.AcNBzu();
                    B4ZgIw.AZOQYO AlLFFp3 = aDYaiT.AlLFFp();
                    AlLFFp3.f1082AzWtSf = 0;
                    AcNBzu3.A4TApA(azoqyo2, AaHO0E2, AlLFFp3, i12);
                    aDYaiT.A5SV6n(AcNBzu3);
                }
                aDYaiT.AMqCpz(aMqCpz6.f1130AZOQYO, AaHO0E2, this.f1096EGM26s + i10, i7);
            }
            i8++;
            i3 = 2;
        }
        int i13 = this.f1094DyaChj;
        if (i13 == 0) {
            aDYaiT.AMqCpz(aMqCpz3.f1130AZOQYO, aMqCpz.f1130AZOQYO, 0, 8);
            aDYaiT.AMqCpz(aMqCpz.f1130AZOQYO, this.f1175CrfGsy.f1166CQhlFr.f1130AZOQYO, 0, 4);
            aDYaiT.AMqCpz(aMqCpz.f1130AZOQYO, this.f1175CrfGsy.f1164CNPG0E.f1130AZOQYO, 0, 0);
            return;
        }
        if (i13 == 1) {
            aDYaiT.AMqCpz(aMqCpz.f1130AZOQYO, aMqCpz3.f1130AZOQYO, 0, 8);
            aDYaiT.AMqCpz(aMqCpz.f1130AZOQYO, this.f1175CrfGsy.f1164CNPG0E.f1130AZOQYO, 0, 4);
            aDYaiT.AMqCpz(aMqCpz.f1130AZOQYO, this.f1175CrfGsy.f1166CQhlFr.f1130AZOQYO, 0, 0);
        } else if (i13 == 2) {
            aDYaiT.AMqCpz(aMqCpz4.f1130AZOQYO, aMqCpz2.f1130AZOQYO, 0, 8);
            aDYaiT.AMqCpz(aMqCpz2.f1130AZOQYO, this.f1175CrfGsy.f1167CSDoyG.f1130AZOQYO, 0, 4);
            aDYaiT.AMqCpz(aMqCpz2.f1130AZOQYO, this.f1175CrfGsy.f1165COJEAR.f1130AZOQYO, 0, 0);
        } else if (i13 == 3) {
            aDYaiT.AMqCpz(aMqCpz2.f1130AZOQYO, aMqCpz4.f1130AZOQYO, 0, 8);
            aDYaiT.AMqCpz(aMqCpz2.f1130AZOQYO, this.f1175CrfGsy.f1165COJEAR.f1130AZOQYO, 0, 4);
            aDYaiT.AMqCpz(aMqCpz2.f1130AZOQYO, this.f1175CrfGsy.f1167CSDoyG.f1130AZOQYO, 0, 0);
        }
    }

    @Override // BChYOn.ARc23Z
    public final boolean A5SV6n() {
        return true;
    }

    @Override // BChYOn.ARc23Z
    public final boolean BPw6Q8() {
        return this.f1097EH1KK8;
    }

    @Override // BChYOn.ARc23Z
    public final boolean BTvldC() {
        return this.f1097EH1KK8;
    }

    public final boolean CqNSpT() {
        int i;
        int i2;
        int i3;
        int i4 = 0;
        boolean z = true;
        while (true) {
            i = this.f1263DvK7DB;
            if (i4 >= i) {
                break;
            }
            ARc23Z aRc23Z = this.f1262DuwtYk[i4];
            if ((this.f1095ECyGFg || aRc23Z.A5SV6n()) && ((((i2 = this.f1094DyaChj) == 0 || i2 == 1) && !aRc23Z.BPw6Q8()) || (((i3 = this.f1094DyaChj) == 2 || i3 == 3) && !aRc23Z.BTvldC()))) {
                z = false;
            }
            i4++;
        }
        if (!z || i <= 0) {
            return false;
        }
        int i5 = 0;
        boolean z2 = false;
        for (int i6 = 0; i6 < this.f1263DvK7DB; i6++) {
            ARc23Z aRc23Z2 = this.f1262DuwtYk[i6];
            if (this.f1095ECyGFg || aRc23Z2.A5SV6n()) {
                ADYaiT aDYaiT = ADYaiT.f1117AzWtSf;
                ADYaiT aDYaiT2 = ADYaiT.f1115AlLFFp;
                ADYaiT aDYaiT3 = ADYaiT.f1116AmA8tU;
                ADYaiT aDYaiT4 = ADYaiT.f1114AcNBzu;
                if (!z2) {
                    int i7 = this.f1094DyaChj;
                    if (i7 == 0) {
                        i5 = aRc23Z2.AZOQYO(aDYaiT4).ADYaiT();
                    } else if (i7 == 1) {
                        i5 = aRc23Z2.AZOQYO(aDYaiT3).ADYaiT();
                    } else if (i7 == 2) {
                        i5 = aRc23Z2.AZOQYO(aDYaiT2).ADYaiT();
                    } else if (i7 == 3) {
                        i5 = aRc23Z2.AZOQYO(aDYaiT).ADYaiT();
                    }
                    z2 = true;
                }
                int i8 = this.f1094DyaChj;
                if (i8 == 0) {
                    i5 = Math.min(i5, aRc23Z2.AZOQYO(aDYaiT4).ADYaiT());
                } else if (i8 == 1) {
                    i5 = Math.max(i5, aRc23Z2.AZOQYO(aDYaiT3).ADYaiT());
                } else if (i8 == 2) {
                    i5 = Math.min(i5, aRc23Z2.AZOQYO(aDYaiT2).ADYaiT());
                } else if (i8 == 3) {
                    i5 = Math.max(i5, aRc23Z2.AZOQYO(aDYaiT).ADYaiT());
                }
            }
        }
        int i9 = i5 + this.f1096EGM26s;
        int i10 = this.f1094DyaChj;
        if (i10 == 0 || i10 == 1) {
            CNPG0E(i9, i9);
        } else {
            COJEAR(i9, i9);
        }
        this.f1097EH1KK8 = true;
        return true;
    }

    public final int CrfGsy() {
        int i = this.f1094DyaChj;
        if (i == 0 || i == 1) {
            return 0;
        }
        return (i == 2 || i == 3) ? 1 : -1;
    }

    @Override // BChYOn.ARc23Z
    public final String toString() {
        String B25kr62 = CtFAbx.B25kr6(new StringBuilder("[Barrier] "), this.f1189DXnQ0V, " {");
        for (int i = 0; i < this.f1263DvK7DB; i++) {
            ARc23Z aRc23Z = this.f1262DuwtYk[i];
            if (i > 0) {
                B25kr62 = CtFAbx.AcNBzu(B25kr62, ", ");
            }
            StringBuilder A4TApA2 = B4ZgIw.AYUAbz.A4TApA(B25kr62);
            A4TApA2.append(aRc23Z.f1189DXnQ0V);
            B25kr62 = A4TApA2.toString();
        }
        return CtFAbx.AcNBzu(B25kr62, "}");
    }
}
