package D8MqeW;

import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class B7CMnp {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static final long f2044A2egSU = B25kr6.ARc23Z.A2egSU(0.0f, 0.0f);

    /* renamed from: A4TApA, reason: collision with root package name */
    public static final float f2045A4TApA = 3.1415927f;

    static {
        wQoW();
    }

    public static final long A2egSU(float f, float f2) {
        float sqrt = (float) Math.sqrt((f2 * f2) + (f * f));
        if (sqrt > 0.0f) {
            return B25kr6.ARc23Z.A2egSU(f / sqrt, f2 / sqrt);
        }
        throw new IllegalArgumentException("Required distance greater than zero");
    }

    public static final float A4TApA(float f, float f2, float f3) {
        return (f3 * f2) + ((1 - f3) * f);
    }

    public static final float A5SV6n(float f) {
        return ((f % 1.0f) + 1.0f) % 1.0f;
    }

    public static long ADYaiT(float f, float f2) {
        double d = f2;
        return JrXYwF.A4TApA.CqNSpT(JrXYwF.A4TApA.DXuj49(B25kr6.ARc23Z.A2egSU((float) Math.cos(d), (float) Math.sin(d)), f), f2044A2egSU);
    }

    private static /* synthetic */ void wQoW() {
        char[] charArray = "ÐÜÞ\u009dÔÒÞÖ\u009dÑÜÊ\u009dÀÛÖßß\u009dùÝÚñÁÚ×ÔÖ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 179);
        }
        String str = new String(charArray);
        char[] charArray2 = "ÐßÚÝÚÇ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 179);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
