package B25kr6;

import java.util.Arrays;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AaHO0E {

    /* renamed from: A2egSU, reason: collision with root package name */
    public float[] f999A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public int f1000A4TApA;

    public AaHO0E(int i) {
        this.f999A2egSU = i == 0 ? ASJ6gh.f987A2egSU : new float[i];
    }

    public static String A5SV6n(AaHO0E aaHO0E, int i) {
        String str = (i & 2) != 0 ? "" : "[";
        String str2 = (i & 4) == 0 ? "]" : "";
        aaHO0E.getClass();
        StringBuilder sb = new StringBuilder();
        sb.append((CharSequence) str);
        float[] fArr = aaHO0E.f999A2egSU;
        int i2 = aaHO0E.f1000A4TApA;
        int i3 = 0;
        while (true) {
            if (i3 >= i2) {
                sb.append((CharSequence) str2);
                break;
            }
            float f = fArr[i3];
            if (i3 == -1) {
                sb.append((CharSequence) "...");
                break;
            }
            if (i3 != 0) {
                sb.append((CharSequence) ", ");
            }
            sb.append(f);
            i3++;
        }
        String sb2 = sb.toString();
        RXb0Sz.ARc23Z.ADYaiT(sb2, "toString(...)");
        return sb2;
    }

    public final void A2egSU(float f) {
        int i = this.f1000A4TApA + 1;
        float[] fArr = this.f999A2egSU;
        if (fArr.length < i) {
            float[] copyOf = Arrays.copyOf(fArr, Math.max(i, (fArr.length * 3) / 2));
            RXb0Sz.ARc23Z.ADYaiT(copyOf, "copyOf(...)");
            this.f999A2egSU = copyOf;
        }
        float[] fArr2 = this.f999A2egSU;
        int i2 = this.f1000A4TApA;
        fArr2[i2] = f;
        this.f1000A4TApA = i2 + 1;
    }

    public final float A4TApA(int i) {
        if (i < 0 || i >= this.f1000A4TApA) {
            throw new IndexOutOfBoundsException("Index must be between 0 and size");
        }
        return this.f999A2egSU[i];
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof AaHO0E)) {
            return false;
        }
        AaHO0E aaHO0E = (AaHO0E) obj;
        int i = aaHO0E.f1000A4TApA;
        int i2 = this.f1000A4TApA;
        if (i != i2) {
            return false;
        }
        float[] fArr = this.f999A2egSU;
        float[] fArr2 = aaHO0E.f999A2egSU;
        RfS3U2.A5SV6n A2egSU2 = RfS3U2.AMqCpz.A2egSU(i2);
        int i3 = A2egSU2.f7896AcNBzu;
        int i4 = A2egSU2.f7897AlLFFp;
        if (i3 > i4) {
            return true;
        }
        while (fArr[i3] == fArr2[i3]) {
            if (i3 == i4) {
                return true;
            }
            i3++;
        }
        return false;
    }

    public final int hashCode() {
        float[] fArr = this.f999A2egSU;
        int i = this.f1000A4TApA;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            i2 += Float.floatToIntBits(fArr[i3]) * 31;
        }
        return i2;
    }

    public final String toString() {
        return A5SV6n(this, 25);
    }

    public AaHO0E() {
        this(16);
    }
}
