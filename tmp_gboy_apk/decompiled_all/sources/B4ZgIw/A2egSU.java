package B4ZgIw;

import ADYaiT.CtFAbx;
import java.util.Arrays;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class A2egSU {

    /* renamed from: A4TApA, reason: collision with root package name */
    public final A4TApA f1040A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final A5SV6n f1041A5SV6n;

    /* renamed from: A2egSU, reason: collision with root package name */
    public int f1039A2egSU = 0;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public int f1042ADYaiT = 8;
    public int[] AMqCpz = new int[8];

    /* renamed from: ARc23Z, reason: collision with root package name */
    public int[] f1043ARc23Z = new int[8];

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public float[] f1044ASJ6gh = new float[8];

    /* renamed from: AYUAbz, reason: collision with root package name */
    public int f1045AYUAbz = -1;

    /* renamed from: AZOQYO, reason: collision with root package name */
    public int f1046AZOQYO = -1;

    /* renamed from: AZkASS, reason: collision with root package name */
    public boolean f1047AZkASS = false;

    public A2egSU(A4TApA a4TApA, A5SV6n a5SV6n) {
        this.f1040A4TApA = a4TApA;
        this.f1041A5SV6n = a5SV6n;
    }

    public final void A2egSU(AZOQYO azoqyo, float f, boolean z) {
        if (f <= -0.001f || f >= 0.001f) {
            int i = this.f1045AYUAbz;
            A4TApA a4TApA = this.f1040A4TApA;
            if (i == -1) {
                this.f1045AYUAbz = 0;
                this.f1044ASJ6gh[0] = f;
                this.AMqCpz[0] = azoqyo.f1080AlLFFp;
                this.f1043ARc23Z[0] = -1;
                azoqyo.f1089BChYOn++;
                azoqyo.A2egSU(a4TApA);
                this.f1039A2egSU++;
                if (this.f1047AZkASS) {
                    return;
                }
                int i2 = this.f1046AZOQYO + 1;
                this.f1046AZOQYO = i2;
                int[] iArr = this.AMqCpz;
                if (i2 >= iArr.length) {
                    this.f1047AZkASS = true;
                    this.f1046AZOQYO = iArr.length - 1;
                    return;
                }
                return;
            }
            int i3 = -1;
            for (int i4 = 0; i != -1 && i4 < this.f1039A2egSU; i4++) {
                int i5 = this.AMqCpz[i];
                int i6 = azoqyo.f1080AlLFFp;
                if (i5 == i6) {
                    float[] fArr = this.f1044ASJ6gh;
                    float f2 = fArr[i] + f;
                    if (f2 > -0.001f && f2 < 0.001f) {
                        f2 = 0.0f;
                    }
                    fArr[i] = f2;
                    if (f2 == 0.0f) {
                        if (i == this.f1045AYUAbz) {
                            this.f1045AYUAbz = this.f1043ARc23Z[i];
                        } else {
                            int[] iArr2 = this.f1043ARc23Z;
                            iArr2[i3] = iArr2[i];
                        }
                        if (z) {
                            azoqyo.A4TApA(a4TApA);
                        }
                        if (this.f1047AZkASS) {
                            this.f1046AZOQYO = i;
                        }
                        azoqyo.f1089BChYOn--;
                        this.f1039A2egSU--;
                        return;
                    }
                    return;
                }
                if (i5 < i6) {
                    i3 = i;
                }
                i = this.f1043ARc23Z[i];
            }
            int i7 = this.f1046AZOQYO;
            int i8 = i7 + 1;
            if (this.f1047AZkASS) {
                int[] iArr3 = this.AMqCpz;
                if (iArr3[i7] != -1) {
                    i7 = iArr3.length;
                }
            } else {
                i7 = i8;
            }
            int[] iArr4 = this.AMqCpz;
            if (i7 >= iArr4.length && this.f1039A2egSU < iArr4.length) {
                int i9 = 0;
                while (true) {
                    int[] iArr5 = this.AMqCpz;
                    if (i9 >= iArr5.length) {
                        break;
                    }
                    if (iArr5[i9] == -1) {
                        i7 = i9;
                        break;
                    }
                    i9++;
                }
            }
            int[] iArr6 = this.AMqCpz;
            if (i7 >= iArr6.length) {
                i7 = iArr6.length;
                int i10 = this.f1042ADYaiT * 2;
                this.f1042ADYaiT = i10;
                this.f1047AZkASS = false;
                this.f1046AZOQYO = i7 - 1;
                this.f1044ASJ6gh = Arrays.copyOf(this.f1044ASJ6gh, i10);
                this.AMqCpz = Arrays.copyOf(this.AMqCpz, this.f1042ADYaiT);
                this.f1043ARc23Z = Arrays.copyOf(this.f1043ARc23Z, this.f1042ADYaiT);
            }
            this.AMqCpz[i7] = azoqyo.f1080AlLFFp;
            this.f1044ASJ6gh[i7] = f;
            if (i3 != -1) {
                int[] iArr7 = this.f1043ARc23Z;
                iArr7[i7] = iArr7[i3];
                iArr7[i3] = i7;
            } else {
                this.f1043ARc23Z[i7] = this.f1045AYUAbz;
                this.f1045AYUAbz = i7;
            }
            azoqyo.f1089BChYOn++;
            azoqyo.A2egSU(a4TApA);
            this.f1039A2egSU++;
            if (!this.f1047AZkASS) {
                this.f1046AZOQYO++;
            }
            int i11 = this.f1046AZOQYO;
            int[] iArr8 = this.AMqCpz;
            if (i11 >= iArr8.length) {
                this.f1047AZkASS = true;
                this.f1046AZOQYO = iArr8.length - 1;
            }
        }
    }

    public final void A4TApA() {
        int i = this.f1045AYUAbz;
        for (int i2 = 0; i != -1 && i2 < this.f1039A2egSU; i2++) {
            AZOQYO azoqyo = this.f1041A5SV6n.f1054A5SV6n[this.AMqCpz[i]];
            if (azoqyo != null) {
                azoqyo.A4TApA(this.f1040A4TApA);
            }
            i = this.f1043ARc23Z[i];
        }
        this.f1045AYUAbz = -1;
        this.f1046AZOQYO = -1;
        this.f1047AZkASS = false;
        this.f1039A2egSU = 0;
    }

    public final float A5SV6n(AZOQYO azoqyo) {
        int i = this.f1045AYUAbz;
        for (int i2 = 0; i != -1 && i2 < this.f1039A2egSU; i2++) {
            if (this.AMqCpz[i] == azoqyo.f1080AlLFFp) {
                return this.f1044ASJ6gh[i];
            }
            i = this.f1043ARc23Z[i];
        }
        return 0.0f;
    }

    public final int ADYaiT() {
        return this.f1039A2egSU;
    }

    public final AZOQYO AMqCpz(int i) {
        int i2 = this.f1045AYUAbz;
        for (int i3 = 0; i2 != -1 && i3 < this.f1039A2egSU; i3++) {
            if (i3 == i) {
                return this.f1041A5SV6n.f1054A5SV6n[this.AMqCpz[i2]];
            }
            i2 = this.f1043ARc23Z[i2];
        }
        return null;
    }

    public final float ARc23Z(int i) {
        int i2 = this.f1045AYUAbz;
        for (int i3 = 0; i2 != -1 && i3 < this.f1039A2egSU; i3++) {
            if (i3 == i) {
                return this.f1044ASJ6gh[i2];
            }
            i2 = this.f1043ARc23Z[i2];
        }
        return 0.0f;
    }

    public final void ASJ6gh(AZOQYO azoqyo, float f) {
        if (f == 0.0f) {
            AYUAbz(azoqyo, true);
            return;
        }
        int i = this.f1045AYUAbz;
        A4TApA a4TApA = this.f1040A4TApA;
        if (i == -1) {
            this.f1045AYUAbz = 0;
            this.f1044ASJ6gh[0] = f;
            this.AMqCpz[0] = azoqyo.f1080AlLFFp;
            this.f1043ARc23Z[0] = -1;
            azoqyo.f1089BChYOn++;
            azoqyo.A2egSU(a4TApA);
            this.f1039A2egSU++;
            if (this.f1047AZkASS) {
                return;
            }
            int i2 = this.f1046AZOQYO + 1;
            this.f1046AZOQYO = i2;
            int[] iArr = this.AMqCpz;
            if (i2 >= iArr.length) {
                this.f1047AZkASS = true;
                this.f1046AZOQYO = iArr.length - 1;
                return;
            }
            return;
        }
        int i3 = -1;
        for (int i4 = 0; i != -1 && i4 < this.f1039A2egSU; i4++) {
            int i5 = this.AMqCpz[i];
            int i6 = azoqyo.f1080AlLFFp;
            if (i5 == i6) {
                this.f1044ASJ6gh[i] = f;
                return;
            }
            if (i5 < i6) {
                i3 = i;
            }
            i = this.f1043ARc23Z[i];
        }
        int i7 = this.f1046AZOQYO;
        int i8 = i7 + 1;
        if (this.f1047AZkASS) {
            int[] iArr2 = this.AMqCpz;
            if (iArr2[i7] != -1) {
                i7 = iArr2.length;
            }
        } else {
            i7 = i8;
        }
        int[] iArr3 = this.AMqCpz;
        if (i7 >= iArr3.length && this.f1039A2egSU < iArr3.length) {
            int i9 = 0;
            while (true) {
                int[] iArr4 = this.AMqCpz;
                if (i9 >= iArr4.length) {
                    break;
                }
                if (iArr4[i9] == -1) {
                    i7 = i9;
                    break;
                }
                i9++;
            }
        }
        int[] iArr5 = this.AMqCpz;
        if (i7 >= iArr5.length) {
            i7 = iArr5.length;
            int i10 = this.f1042ADYaiT * 2;
            this.f1042ADYaiT = i10;
            this.f1047AZkASS = false;
            this.f1046AZOQYO = i7 - 1;
            this.f1044ASJ6gh = Arrays.copyOf(this.f1044ASJ6gh, i10);
            this.AMqCpz = Arrays.copyOf(this.AMqCpz, this.f1042ADYaiT);
            this.f1043ARc23Z = Arrays.copyOf(this.f1043ARc23Z, this.f1042ADYaiT);
        }
        this.AMqCpz[i7] = azoqyo.f1080AlLFFp;
        this.f1044ASJ6gh[i7] = f;
        if (i3 != -1) {
            int[] iArr6 = this.f1043ARc23Z;
            iArr6[i7] = iArr6[i3];
            iArr6[i3] = i7;
        } else {
            this.f1043ARc23Z[i7] = this.f1045AYUAbz;
            this.f1045AYUAbz = i7;
        }
        azoqyo.f1089BChYOn++;
        azoqyo.A2egSU(a4TApA);
        int i11 = this.f1039A2egSU + 1;
        this.f1039A2egSU = i11;
        if (!this.f1047AZkASS) {
            this.f1046AZOQYO++;
        }
        int[] iArr7 = this.AMqCpz;
        if (i11 >= iArr7.length) {
            this.f1047AZkASS = true;
        }
        if (this.f1046AZOQYO >= iArr7.length) {
            this.f1047AZkASS = true;
            this.f1046AZOQYO = iArr7.length - 1;
        }
    }

    public final float AYUAbz(AZOQYO azoqyo, boolean z) {
        int i = this.f1045AYUAbz;
        if (i == -1) {
            return 0.0f;
        }
        int i2 = 0;
        int i3 = -1;
        while (i != -1 && i2 < this.f1039A2egSU) {
            if (this.AMqCpz[i] == azoqyo.f1080AlLFFp) {
                if (i == this.f1045AYUAbz) {
                    this.f1045AYUAbz = this.f1043ARc23Z[i];
                } else {
                    int[] iArr = this.f1043ARc23Z;
                    iArr[i3] = iArr[i];
                }
                if (z) {
                    azoqyo.A4TApA(this.f1040A4TApA);
                }
                azoqyo.f1089BChYOn--;
                this.f1039A2egSU--;
                this.AMqCpz[i] = -1;
                if (this.f1047AZkASS) {
                    this.f1046AZOQYO = i;
                }
                return this.f1044ASJ6gh[i];
            }
            i2++;
            i3 = i;
            i = this.f1043ARc23Z[i];
        }
        return 0.0f;
    }

    public final String toString() {
        int i = this.f1045AYUAbz;
        String str = "";
        for (int i2 = 0; i != -1 && i2 < this.f1039A2egSU; i2++) {
            StringBuilder A4TApA2 = AYUAbz.A4TApA(CtFAbx.AcNBzu(str, " -> "));
            A4TApA2.append(this.f1044ASJ6gh[i]);
            A4TApA2.append(" : ");
            StringBuilder A4TApA3 = AYUAbz.A4TApA(A4TApA2.toString());
            A4TApA3.append(this.f1041A5SV6n.f1054A5SV6n[this.AMqCpz[i]]);
            str = A4TApA3.toString();
            i = this.f1043ARc23Z[i];
        }
        return str;
    }
}
