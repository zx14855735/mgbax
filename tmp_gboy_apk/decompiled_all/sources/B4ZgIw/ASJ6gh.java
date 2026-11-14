package B4ZgIw;

import java.util.Arrays;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class ASJ6gh extends A4TApA {

    /* renamed from: ARc23Z, reason: collision with root package name */
    public AZOQYO[] f1074ARc23Z;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public AZOQYO[] f1075ASJ6gh;

    /* renamed from: AYUAbz, reason: collision with root package name */
    public int f1076AYUAbz;

    /* renamed from: AZOQYO, reason: collision with root package name */
    public K1Z3yj.A2egSU f1077AZOQYO;

    @Override // B4ZgIw.A4TApA
    public final AZOQYO ADYaiT(boolean[] zArr) {
        int i = -1;
        for (int i2 = 0; i2 < this.f1076AYUAbz; i2++) {
            AZOQYO[] azoqyoArr = this.f1074ARc23Z;
            AZOQYO azoqyo = azoqyoArr[i2];
            if (!zArr[azoqyo.f1080AlLFFp]) {
                K1Z3yj.A2egSU a2egSU = this.f1077AZOQYO;
                a2egSU.f4174AlLFFp = azoqyo;
                int i3 = 8;
                if (i == -1) {
                    while (i3 >= 0) {
                        float f = ((AZOQYO) a2egSU.f4174AlLFFp).f1086B4ZgIw[i3];
                        if (f <= 0.0f) {
                            if (f < 0.0f) {
                                i = i2;
                                break;
                            }
                            i3--;
                        }
                    }
                } else {
                    AZOQYO azoqyo2 = azoqyoArr[i];
                    while (true) {
                        if (i3 >= 0) {
                            float f2 = azoqyo2.f1086B4ZgIw[i3];
                            float f3 = ((AZOQYO) a2egSU.f4174AlLFFp).f1086B4ZgIw[i3];
                            if (f3 == f2) {
                                i3--;
                            } else if (f3 >= f2) {
                            }
                        }
                    }
                }
            }
        }
        if (i == -1) {
            return null;
        }
        return this.f1074ARc23Z[i];
    }

    @Override // B4ZgIw.A4TApA
    public final boolean AMqCpz() {
        return this.f1076AYUAbz == 0;
    }

    @Override // B4ZgIw.A4TApA
    public final void AZOQYO(ADYaiT aDYaiT, A4TApA a4TApA, boolean z) {
        AZOQYO azoqyo = a4TApA.f1048A2egSU;
        if (azoqyo == null) {
            return;
        }
        A2egSU a2egSU = a4TApA.f1051ADYaiT;
        int ADYaiT2 = a2egSU.ADYaiT();
        for (int i = 0; i < ADYaiT2; i++) {
            AZOQYO AMqCpz = a2egSU.AMqCpz(i);
            float ARc23Z2 = a2egSU.ARc23Z(i);
            K1Z3yj.A2egSU a2egSU2 = this.f1077AZOQYO;
            a2egSU2.f4174AlLFFp = AMqCpz;
            boolean z2 = AMqCpz.f1079AcNBzu;
            float[] fArr = azoqyo.f1086B4ZgIw;
            if (z2) {
                boolean z3 = true;
                for (int i2 = 0; i2 < 9; i2++) {
                    float[] fArr2 = ((AZOQYO) a2egSU2.f4174AlLFFp).f1086B4ZgIw;
                    float f = (fArr[i2] * ARc23Z2) + fArr2[i2];
                    fArr2[i2] = f;
                    if (Math.abs(f) < 1.0E-4f) {
                        ((AZOQYO) a2egSU2.f4174AlLFFp).f1086B4ZgIw[i2] = 0.0f;
                    } else {
                        z3 = false;
                    }
                }
                if (z3) {
                    ((ASJ6gh) a2egSU2.f4175AmA8tU).AaHO0E((AZOQYO) a2egSU2.f4174AlLFFp);
                }
            } else {
                for (int i3 = 0; i3 < 9; i3++) {
                    float f2 = fArr[i3];
                    if (f2 != 0.0f) {
                        float f3 = f2 * ARc23Z2;
                        if (Math.abs(f3) < 1.0E-4f) {
                            f3 = 0.0f;
                        }
                        ((AZOQYO) a2egSU2.f4174AlLFFp).f1086B4ZgIw[i3] = f3;
                    } else {
                        ((AZOQYO) a2egSU2.f4174AlLFFp).f1086B4ZgIw[i3] = 0.0f;
                    }
                }
                AZkASS(AMqCpz);
            }
            this.f1049A4TApA = (a4TApA.f1049A4TApA * ARc23Z2) + this.f1049A4TApA;
        }
        AaHO0E(azoqyo);
    }

    public final void AZkASS(AZOQYO azoqyo) {
        int i;
        int i2 = this.f1076AYUAbz + 1;
        AZOQYO[] azoqyoArr = this.f1074ARc23Z;
        if (i2 > azoqyoArr.length) {
            AZOQYO[] azoqyoArr2 = (AZOQYO[]) Arrays.copyOf(azoqyoArr, azoqyoArr.length * 2);
            this.f1074ARc23Z = azoqyoArr2;
            this.f1075ASJ6gh = (AZOQYO[]) Arrays.copyOf(azoqyoArr2, azoqyoArr2.length * 2);
        }
        AZOQYO[] azoqyoArr3 = this.f1074ARc23Z;
        int i3 = this.f1076AYUAbz;
        azoqyoArr3[i3] = azoqyo;
        int i4 = i3 + 1;
        this.f1076AYUAbz = i4;
        if (i4 > 1 && azoqyoArr3[i3].f1080AlLFFp > azoqyo.f1080AlLFFp) {
            int i5 = 0;
            while (true) {
                i = this.f1076AYUAbz;
                if (i5 >= i) {
                    break;
                }
                this.f1075ASJ6gh[i5] = this.f1074ARc23Z[i5];
                i5++;
            }
            Arrays.sort(this.f1075ASJ6gh, 0, i, new ARc23Z(0));
            for (int i6 = 0; i6 < this.f1076AYUAbz; i6++) {
                this.f1074ARc23Z[i6] = this.f1075ASJ6gh[i6];
            }
        }
        azoqyo.f1079AcNBzu = true;
        azoqyo.A2egSU(this);
    }

    public final void AaHO0E(AZOQYO azoqyo) {
        int i = 0;
        while (i < this.f1076AYUAbz) {
            if (this.f1074ARc23Z[i] == azoqyo) {
                while (true) {
                    int i2 = this.f1076AYUAbz;
                    if (i >= i2 - 1) {
                        this.f1076AYUAbz = i2 - 1;
                        azoqyo.f1079AcNBzu = false;
                        return;
                    } else {
                        AZOQYO[] azoqyoArr = this.f1074ARc23Z;
                        int i3 = i + 1;
                        azoqyoArr[i] = azoqyoArr[i3];
                        i = i3;
                    }
                }
            } else {
                i++;
            }
        }
    }

    @Override // B4ZgIw.A4TApA
    public final String toString() {
        String str = " goal -> (" + this.f1049A4TApA + ") : ";
        for (int i = 0; i < this.f1076AYUAbz; i++) {
            AZOQYO azoqyo = this.f1074ARc23Z[i];
            K1Z3yj.A2egSU a2egSU = this.f1077AZOQYO;
            a2egSU.f4174AlLFFp = azoqyo;
            str = str + a2egSU + " ";
        }
        return str;
    }
}
