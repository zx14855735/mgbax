package D8MqeW;

import java.util.Arrays;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class A4TApA {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final float[] f2011A2egSU;

    public A4TApA() {
        this(0);
    }

    public final float A2egSU() {
        return this.f2011A2egSU[6];
    }

    public final float A4TApA() {
        return this.f2011A2egSU[7];
    }

    public final long A5SV6n(float f) {
        float f2 = 1 - f;
        float[] fArr = this.f2011A2egSU;
        float f3 = f2 * f2 * f2;
        float f4 = 3 * f;
        float f5 = f4 * f2 * f2;
        float f6 = f4 * f * f2;
        float f7 = f * f * f;
        return B25kr6.ARc23Z.A2egSU((A2egSU() * f7) + (fArr[4] * f6) + (fArr[2] * f5) + (fArr[0] * f3), (A4TApA() * f7) + (fArr[5] * f6) + (fArr[3] * f5) + (fArr[1] * f3));
    }

    public final R8Rbcg.A4TApA ADYaiT(float f) {
        float f2 = 1 - f;
        long A5SV6n2 = A5SV6n(f);
        float[] fArr = this.f2011A2egSU;
        float f3 = fArr[0];
        float f4 = fArr[1];
        float f5 = fArr[2];
        float f6 = fArr[3];
        float f7 = f2 * f2;
        float f8 = 2 * f2 * f;
        float f9 = f * f;
        return new R8Rbcg.A4TApA(NOd7IU.AlLFFp.A2egSU(f3, f4, (f5 * f) + (f3 * f2), (f6 * f) + (f4 * f2), (fArr[4] * f9) + (f5 * f8) + (f3 * f7), (fArr[5] * f9) + (f6 * f8) + (f4 * f7), JrXYwF.A4TApA.COJEAR(A5SV6n2), JrXYwF.A4TApA.CQhlFr(A5SV6n2)), NOd7IU.AlLFFp.A2egSU(JrXYwF.A4TApA.COJEAR(A5SV6n2), JrXYwF.A4TApA.CQhlFr(A5SV6n2), (A2egSU() * f9) + (fArr[4] * f8) + (fArr[2] * f7), (A4TApA() * f9) + (fArr[5] * f8) + (fArr[3] * f7), (A2egSU() * f) + (fArr[4] * f2), (A4TApA() * f) + (fArr[5] * f2), A2egSU(), A4TApA()));
    }

    public final B25kr6 AMqCpz(K1Z3yj.A2egSU a2egSU) {
        B25kr6 b25kr6 = new B25kr6();
        float[] fArr = this.f2011A2egSU;
        int length = fArr.length;
        float[] fArr2 = b25kr6.f2011A2egSU;
        RXb0Sz.ARc23Z.AMqCpz(fArr2, "destination");
        System.arraycopy(fArr, 0, fArr2, 0, length);
        b25kr6.ARc23Z(a2egSU, 0);
        b25kr6.ARc23Z(a2egSU, 2);
        b25kr6.ARc23Z(a2egSU, 4);
        b25kr6.ARc23Z(a2egSU, 6);
        return b25kr6;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof A4TApA)) {
            return false;
        }
        return Arrays.equals(this.f2011A2egSU, ((A4TApA) obj).f2011A2egSU);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f2011A2egSU);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("anchor0: (");
        float[] fArr = this.f2011A2egSU;
        sb.append(fArr[0]);
        sb.append(", ");
        sb.append(fArr[1]);
        sb.append(") control0: (");
        sb.append(fArr[2]);
        sb.append(", ");
        sb.append(fArr[3]);
        sb.append("), control1: (");
        sb.append(fArr[4]);
        sb.append(", ");
        sb.append(fArr[5]);
        sb.append("), anchor1: (");
        sb.append(A2egSU());
        sb.append(", ");
        sb.append(A4TApA());
        sb.append(')');
        return sb.toString();
    }

    public /* synthetic */ A4TApA(int i) {
        this(new float[8]);
    }

    public A4TApA(float[] fArr) {
        this.f2011A2egSU = fArr;
        if (fArr.length != 8) {
            throw new IllegalArgumentException("Points array size should be 8");
        }
    }
}
