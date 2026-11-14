package H0qugq;

import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class AaHO0E {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static final AcNBzu f3256A2egSU = new AcNBzu();

    static {
        jFmAMA();
    }

    private static /* synthetic */ void jFmAMA() {
        char[] charArray = "ÏÃÁ\u0082ËÍÁÉ\u0082ÎÃÕ\u0082ßÄÉÀÀ\u0082æÂÅîÞÅÈËÉ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 172);
        }
        String str = new String(charArray);
        char[] charArray2 = "ÏÀÅÂÅØ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 172);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
