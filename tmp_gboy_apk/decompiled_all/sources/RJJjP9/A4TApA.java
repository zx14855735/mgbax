package RJJjP9;

import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class A4TApA {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static final /* synthetic */ A4TApA f7863A2egSU = new A4TApA();

    static {
        RfbioE();
    }

    private static /* synthetic */ void RfbioE() {
        char[] charArray = "\u007fsq2{}qy2~se2otypp2Vru^nux{y".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 28);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u007fpuruh".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 28);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
