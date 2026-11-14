package D8MqeW;

import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class A2egSU {

    /* renamed from: A5SV6n, reason: collision with root package name */
    public static final A2egSU f2008A5SV6n = new A2egSU(3);

    /* renamed from: A2egSU, reason: collision with root package name */
    public final float f2009A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final float f2010A4TApA;

    static {
        VhBkQ();
    }

    public A2egSU() {
        this(3);
    }

    private static /* synthetic */ void VhBkQ() {
        char[] charArray = "íáã éïãë ìá÷ ýæëââ ÄàçÌüçêéë".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 142);
        }
        String str = new String(charArray);
        char[] charArray2 = "íâçàçú".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 142);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public A2egSU(float f, float f2) {
        this.f2009A2egSU = f;
        this.f2010A4TApA = f2;
    }

    public /* synthetic */ A2egSU(int i) {
        this((i & 1) != 0 ? 0.0f : 1.0f, 0.0f);
    }
}
