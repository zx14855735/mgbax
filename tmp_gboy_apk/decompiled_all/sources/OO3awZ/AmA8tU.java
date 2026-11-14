package OO3awZ;

import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class AmA8tU {

    /* renamed from: AaHO0E, reason: collision with root package name */
    public static final AmA8tU f6424AaHO0E;

    /* renamed from: A2egSU, reason: collision with root package name */
    public final double f6425A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final double f6426A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final double f6427A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final double f6428ADYaiT;
    public final double AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public final double f6429ARc23Z;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public final double[] f6430ASJ6gh;

    /* renamed from: AYUAbz, reason: collision with root package name */
    public final double f6431AYUAbz;

    /* renamed from: AZOQYO, reason: collision with root package name */
    public final double f6432AZOQYO;

    /* renamed from: AZkASS, reason: collision with root package name */
    public final double f6433AZkASS;

    static {
        double[] dArr = A2egSU.f6383A5SV6n;
        double B2KMhB2 = (A2egSU.B2KMhB(50.0d) * 63.66197723675813d) / 100.0d;
        double max = Math.max(0.1d, 50.0d);
        double[][] dArr2 = A2egSU.f6381A2egSU;
        double d = dArr[0];
        double[] dArr3 = dArr2[0];
        double d2 = dArr3[0] * d;
        double d3 = dArr[1];
        double d4 = (dArr3[1] * d3) + d2;
        double d5 = dArr[2];
        double d6 = (dArr3[2] * d5) + d4;
        double[] dArr4 = dArr2[1];
        double d7 = (dArr4[2] * d5) + (dArr4[1] * d3) + (dArr4[0] * d);
        double[] dArr5 = dArr2[2];
        double d8 = (d5 * dArr5[2]) + (d3 * dArr5[1]) + (d * dArr5[0]);
        double AZkASS2 = A2egSU.AZkASS(0.59d, 0.69d, 0.9999999999999998d);
        double exp = (1.0d - (Math.exp(((-B2KMhB2) - 42.0d) / 92.0d) * 0.2777777777777778d)) * 1.0d;
        if (exp < 0.0d) {
            exp = 0.0d;
        } else if (exp > 1.0d) {
            exp = 1.0d;
        }
        double[] dArr6 = {(((100.0d / d6) * exp) + 1.0d) - exp, (((100.0d / d7) * exp) + 1.0d) - exp, (((100.0d / d8) * exp) + 1.0d) - exp};
        double d9 = 5.0d * B2KMhB2;
        double d10 = 1.0d / (d9 + 1.0d);
        double d11 = d10 * d10 * d10 * d10;
        double d12 = 1.0d - d11;
        double cbrt = (Math.cbrt(d9) * 0.1d * d12 * d12) + (d11 * B2KMhB2);
        double B2KMhB3 = A2egSU.B2KMhB(max) / dArr[1];
        double sqrt = Math.sqrt(B2KMhB3) + 1.48d;
        double pow = 0.725d / Math.pow(B2KMhB3, 0.2d);
        double[] dArr7 = {Math.pow(((dArr6[0] * cbrt) * d6) / 100.0d, 0.42d), Math.pow(((dArr6[1] * cbrt) * d7) / 100.0d, 0.42d), Math.pow(((dArr6[2] * cbrt) * d8) / 100.0d, 0.42d)};
        double d13 = dArr7[0];
        double d14 = (d13 * 400.0d) / (d13 + 27.13d);
        double d15 = dArr7[1];
        double d16 = (d15 * 400.0d) / (d15 + 27.13d);
        double d17 = dArr7[2];
        double[] dArr8 = {d14, d16, (400.0d * d17) / (d17 + 27.13d)};
        f6424AaHO0E = new AmA8tU(B2KMhB3, ((dArr8[2] * 0.05d) + (dArr8[0] * 2.0d) + dArr8[1]) * pow, pow, pow, AZkASS2, 1.0d, dArr6, cbrt, Math.pow(cbrt, 0.25d), sqrt);
        MxXm();
    }

    public AmA8tU(double d, double d2, double d3, double d4, double d5, double d6, double[] dArr, double d7, double d8, double d9) {
        this.f6429ARc23Z = d;
        this.f6425A2egSU = d2;
        this.f6426A4TApA = d3;
        this.f6427A5SV6n = d4;
        this.f6428ADYaiT = d5;
        this.AMqCpz = d6;
        this.f6430ASJ6gh = dArr;
        this.f6431AYUAbz = d7;
        this.f6432AZOQYO = d8;
        this.f6433AZkASS = d9;
    }

    private static /* synthetic */ void MxXm() {
        char[] charArray = " ,.m$\".&m!,:m0+&//m\t-*\u00011*'$&".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'C');
        }
        String str = new String(charArray);
        char[] charArray2 = " /*-*7".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'C');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
