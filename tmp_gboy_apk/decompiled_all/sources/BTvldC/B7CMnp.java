package BTvldC;

import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class B7CMnp {

    /* renamed from: AaHO0E, reason: collision with root package name */
    public static final B7CMnp f1471AaHO0E;

    /* renamed from: A2egSU, reason: collision with root package name */
    public final float f1472A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final float f1473A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final float f1474A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final float f1475ADYaiT;
    public final float AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public final float f1476ARc23Z;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public final float[] f1477ASJ6gh;

    /* renamed from: AYUAbz, reason: collision with root package name */
    public final float f1478AYUAbz;

    /* renamed from: AZOQYO, reason: collision with root package name */
    public final float f1479AZOQYO;

    /* renamed from: AZkASS, reason: collision with root package name */
    public final float f1480AZkASS;

    static {
        float[] fArr = A4TApA.f1442A5SV6n;
        float AZOQYO2 = (float) ((A4TApA.AZOQYO() * 63.66197723675813d) / 100.0d);
        float[][] fArr2 = A4TApA.f1440A2egSU;
        float f = fArr[0];
        float[] fArr3 = fArr2[0];
        float f2 = fArr3[0] * f;
        float f3 = fArr[1];
        float f4 = (fArr3[1] * f3) + f2;
        float f5 = fArr[2];
        float f6 = (fArr3[2] * f5) + f4;
        float[] fArr4 = fArr2[1];
        float f7 = (fArr4[2] * f5) + (fArr4[1] * f3) + (fArr4[0] * f);
        float[] fArr5 = fArr2[2];
        float f8 = (f5 * fArr5[2]) + (f3 * fArr5[1]) + (f * fArr5[0]);
        float f9 = ((double) 1.0f) >= 0.9d ? 0.69f : 0.655f;
        float exp = (1.0f - (((float) Math.exp(((-AZOQYO2) - 42.0f) / 92.0f)) * 0.2777778f)) * 1.0f;
        double d = exp;
        if (d > 1.0d) {
            exp = 1.0f;
        } else if (d < 0.0d) {
            exp = 0.0f;
        }
        float f10 = 1.0f / ((5.0f * AZOQYO2) + 1.0f);
        float f11 = f10 * f10 * f10 * f10;
        float f12 = 1.0f - f11;
        float cbrt = (0.1f * f12 * f12 * ((float) Math.cbrt(AZOQYO2 * 5.0d))) + (f11 * AZOQYO2);
        float AZOQYO3 = A4TApA.AZOQYO() / fArr[1];
        double d2 = AZOQYO3;
        float sqrt = ((float) Math.sqrt(d2)) + 1.48f;
        float pow = 0.725f / ((float) Math.pow(d2, 0.2d));
        float[] fArr6 = {(float) Math.pow(((r9[0] * cbrt) * f6) / 100.0d, 0.42d), (float) Math.pow(((r9[1] * cbrt) * f7) / 100.0d, 0.42d), (float) Math.pow(((r9[2] * cbrt) * f8) / 100.0d, 0.42d)};
        float f13 = fArr6[0];
        float f14 = (f13 * 400.0f) / (f13 + 27.13f);
        float f15 = fArr6[1];
        float f16 = (f15 * 400.0f) / (f15 + 27.13f);
        float f17 = fArr6[2];
        float[] fArr7 = {f14, f16, (400.0f * f17) / (f17 + 27.13f)};
        f1471AaHO0E = new B7CMnp(AZOQYO3, ((fArr7[2] * 0.05f) + (fArr7[0] * 2.0f) + fArr7[1]) * pow, pow, pow, f9, 1.0f, new float[]{(((100.0f / f6) * exp) + 1.0f) - exp, (((100.0f / f7) * exp) + 1.0f) - exp, (((100.0f / f8) * exp) + 1.0f) - exp}, cbrt, (float) Math.pow(cbrt, 0.25d), sqrt);
        YDUND();
    }

    public B7CMnp(float f, float f2, float f3, float f4, float f5, float f6, float[] fArr, float f7, float f8, float f9) {
        this.f1476ARc23Z = f;
        this.f1472A2egSU = f2;
        this.f1473A4TApA = f3;
        this.f1474A5SV6n = f4;
        this.f1475ADYaiT = f5;
        this.AMqCpz = f6;
        this.f1477ASJ6gh = fArr;
        this.f1478AYUAbz = f7;
        this.f1479AZOQYO = f8;
        this.f1480AZkASS = f9;
    }

    private static /* synthetic */ void YDUND() {
        char[] charArray = "l`b!hnbj!m`v!|gjcc!EafM}fkhj".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 15);
        }
        String str = new String(charArray);
        char[] charArray2 = "lcfaf{".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 15);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
