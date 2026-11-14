package B4ZgIw;

import java.util.ArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class A4TApA {

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final A2egSU f1051ADYaiT;

    /* renamed from: A2egSU, reason: collision with root package name */
    public AZOQYO f1048A2egSU = null;

    /* renamed from: A4TApA, reason: collision with root package name */
    public float f1049A4TApA = 0.0f;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final ArrayList f1050A5SV6n = new ArrayList();
    public boolean AMqCpz = false;

    public A4TApA() {
    }

    public final void A2egSU(ADYaiT aDYaiT, int i) {
        this.f1051ADYaiT.ASJ6gh(aDYaiT.AZkASS(i), 1.0f);
        this.f1051ADYaiT.ASJ6gh(aDYaiT.AZkASS(i), -1.0f);
    }

    public final void A4TApA(AZOQYO azoqyo, AZOQYO azoqyo2, AZOQYO azoqyo3, int i) {
        boolean z = false;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                z = true;
            }
            this.f1049A4TApA = i;
        }
        if (z) {
            this.f1051ADYaiT.ASJ6gh(azoqyo, 1.0f);
            this.f1051ADYaiT.ASJ6gh(azoqyo2, -1.0f);
            this.f1051ADYaiT.ASJ6gh(azoqyo3, -1.0f);
        } else {
            this.f1051ADYaiT.ASJ6gh(azoqyo, -1.0f);
            this.f1051ADYaiT.ASJ6gh(azoqyo2, 1.0f);
            this.f1051ADYaiT.ASJ6gh(azoqyo3, 1.0f);
        }
    }

    public final void A5SV6n(AZOQYO azoqyo, AZOQYO azoqyo2, AZOQYO azoqyo3, int i) {
        boolean z = false;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                z = true;
            }
            this.f1049A4TApA = i;
        }
        if (z) {
            this.f1051ADYaiT.ASJ6gh(azoqyo, 1.0f);
            this.f1051ADYaiT.ASJ6gh(azoqyo2, -1.0f);
            this.f1051ADYaiT.ASJ6gh(azoqyo3, 1.0f);
        } else {
            this.f1051ADYaiT.ASJ6gh(azoqyo, -1.0f);
            this.f1051ADYaiT.ASJ6gh(azoqyo2, 1.0f);
            this.f1051ADYaiT.ASJ6gh(azoqyo3, -1.0f);
        }
    }

    public AZOQYO ADYaiT(boolean[] zArr) {
        return ARc23Z(zArr, null);
    }

    public boolean AMqCpz() {
        return this.f1048A2egSU == null && this.f1049A4TApA == 0.0f && this.f1051ADYaiT.ADYaiT() == 0;
    }

    public final AZOQYO ARc23Z(boolean[] zArr, AZOQYO azoqyo) {
        int i;
        int ADYaiT2 = this.f1051ADYaiT.ADYaiT();
        AZOQYO azoqyo2 = null;
        float f = 0.0f;
        for (int i2 = 0; i2 < ADYaiT2; i2++) {
            float ARc23Z2 = this.f1051ADYaiT.ARc23Z(i2);
            if (ARc23Z2 < 0.0f) {
                AZOQYO AMqCpz = this.f1051ADYaiT.AMqCpz(i2);
                if ((zArr == null || !zArr[AMqCpz.f1080AlLFFp]) && AMqCpz != azoqyo && (((i = AMqCpz.f1090BI9f7h) == 3 || i == 4) && ARc23Z2 < f)) {
                    f = ARc23Z2;
                    azoqyo2 = AMqCpz;
                }
            }
        }
        return azoqyo2;
    }

    public final void ASJ6gh(AZOQYO azoqyo) {
        AZOQYO azoqyo2 = this.f1048A2egSU;
        if (azoqyo2 != null) {
            this.f1051ADYaiT.ASJ6gh(azoqyo2, -1.0f);
            this.f1048A2egSU.f1081AmA8tU = -1;
            this.f1048A2egSU = null;
        }
        float AYUAbz2 = this.f1051ADYaiT.AYUAbz(azoqyo, true) * (-1.0f);
        this.f1048A2egSU = azoqyo;
        if (AYUAbz2 == 1.0f) {
            return;
        }
        this.f1049A4TApA /= AYUAbz2;
        A2egSU a2egSU = this.f1051ADYaiT;
        int i = a2egSU.f1045AYUAbz;
        for (int i2 = 0; i != -1 && i2 < a2egSU.f1039A2egSU; i2++) {
            float[] fArr = a2egSU.f1044ASJ6gh;
            fArr[i] = fArr[i] / AYUAbz2;
            i = a2egSU.f1043ARc23Z[i];
        }
    }

    public final void AYUAbz(ADYaiT aDYaiT, AZOQYO azoqyo, boolean z) {
        if (azoqyo == null || !azoqyo.f1084B2KMhB) {
            return;
        }
        float A5SV6n2 = this.f1051ADYaiT.A5SV6n(azoqyo);
        this.f1049A4TApA = (azoqyo.f1083B25kr6 * A5SV6n2) + this.f1049A4TApA;
        this.f1051ADYaiT.AYUAbz(azoqyo, z);
        if (z) {
            azoqyo.A4TApA(this);
        }
        if (this.f1051ADYaiT.ADYaiT() == 0) {
            this.AMqCpz = true;
            aDYaiT.f1057A2egSU = true;
        }
    }

    public void AZOQYO(ADYaiT aDYaiT, A4TApA a4TApA, boolean z) {
        A2egSU a2egSU = this.f1051ADYaiT;
        a2egSU.getClass();
        float A5SV6n2 = a2egSU.A5SV6n(a4TApA.f1048A2egSU);
        a2egSU.AYUAbz(a4TApA.f1048A2egSU, z);
        A2egSU a2egSU2 = a4TApA.f1051ADYaiT;
        int ADYaiT2 = a2egSU2.ADYaiT();
        for (int i = 0; i < ADYaiT2; i++) {
            AZOQYO AMqCpz = a2egSU2.AMqCpz(i);
            a2egSU.A2egSU(AMqCpz, a2egSU2.A5SV6n(AMqCpz) * A5SV6n2, z);
        }
        this.f1049A4TApA = (a4TApA.f1049A4TApA * A5SV6n2) + this.f1049A4TApA;
        if (z) {
            a4TApA.f1048A2egSU.A4TApA(this);
        }
        if (this.f1048A2egSU == null || this.f1051ADYaiT.ADYaiT() != 0) {
            return;
        }
        this.AMqCpz = true;
        aDYaiT.f1057A2egSU = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0082  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String toString() {
        /*
            r10 = this;
            B4ZgIw.AZOQYO r0 = r10.f1048A2egSU
            if (r0 != 0) goto L7
            java.lang.String r0 = "0"
            goto L17
        L7:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = ""
            r0.<init>(r1)
            B4ZgIw.AZOQYO r1 = r10.f1048A2egSU
            r0.append(r1)
            java.lang.String r0 = r0.toString()
        L17:
            java.lang.String r1 = " = "
            java.lang.String r0 = ADYaiT.CtFAbx.AcNBzu(r0, r1)
            float r1 = r10.f1049A4TApA
            r2 = 1
            r3 = 0
            r4 = 0
            int r1 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r1 == 0) goto L35
            java.lang.StringBuilder r0 = B4ZgIw.AYUAbz.A4TApA(r0)
            float r1 = r10.f1049A4TApA
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r1 = 1
            goto L36
        L35:
            r1 = 0
        L36:
            B4ZgIw.A2egSU r5 = r10.f1051ADYaiT
            int r5 = r5.ADYaiT()
        L3c:
            if (r3 >= r5) goto L9d
            B4ZgIw.A2egSU r6 = r10.f1051ADYaiT
            B4ZgIw.AZOQYO r6 = r6.AMqCpz(r3)
            if (r6 != 0) goto L47
            goto L9a
        L47:
            B4ZgIw.A2egSU r7 = r10.f1051ADYaiT
            float r7 = r7.ARc23Z(r3)
            int r8 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r8 != 0) goto L52
            goto L9a
        L52:
            java.lang.String r6 = r6.toString()
            r9 = -1082130432(0xffffffffbf800000, float:-1.0)
            if (r1 != 0) goto L67
            int r1 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r1 >= 0) goto L77
            java.lang.String r1 = "- "
            java.lang.String r0 = ADYaiT.CtFAbx.AcNBzu(r0, r1)
        L64:
            float r7 = r7 * r9
            goto L77
        L67:
            if (r8 <= 0) goto L70
            java.lang.String r1 = " + "
            java.lang.String r0 = ADYaiT.CtFAbx.AcNBzu(r0, r1)
            goto L77
        L70:
            java.lang.String r1 = " - "
            java.lang.String r0 = ADYaiT.CtFAbx.AcNBzu(r0, r1)
            goto L64
        L77:
            r1 = 1065353216(0x3f800000, float:1.0)
            int r1 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r1 != 0) goto L82
            java.lang.String r0 = ADYaiT.CtFAbx.AcNBzu(r0, r6)
            goto L99
        L82:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            r1.append(r7)
            java.lang.String r0 = " "
            r1.append(r0)
            r1.append(r6)
            java.lang.String r0 = r1.toString()
        L99:
            r1 = 1
        L9a:
            int r3 = r3 + 1
            goto L3c
        L9d:
            if (r1 != 0) goto La5
            java.lang.String r1 = "0.0"
            java.lang.String r0 = ADYaiT.CtFAbx.AcNBzu(r0, r1)
        La5:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: B4ZgIw.A4TApA.toString():java.lang.String");
    }

    public A4TApA(A5SV6n a5SV6n) {
        this.f1051ADYaiT = new A2egSU(this, a5SV6n);
    }
}
