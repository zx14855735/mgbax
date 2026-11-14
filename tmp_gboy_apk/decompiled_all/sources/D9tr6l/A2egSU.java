package D9tr6l;

import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class A2egSU extends A4TApA {

    /* renamed from: A4TApA, reason: collision with root package name */
    public static final A2egSU f2051A4TApA = new A2egSU();

    static {
        WHZQ();
    }

    private static /* synthetic */ void WHZQ() {
        char[] charArray = "ëçå¦ïéåí¦êçñ¦ûàíää¦ÂæáÊúáìïí".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 136);
        }
        String str = new String(charArray);
        char[] charArray2 = "ëäáæáü".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 136);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
