package NGepWW;

import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class BI9f7h {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static final BI9f7h f5697A2egSU;

    static {
        new BChYOn();
        f5697A2egSU = new BI9f7h();
        tHuV();
    }

    private static /* synthetic */ void tHuV() {
        char[] charArray = "L@B\u0001HNBJ\u0001M@V\u0001\\GJCC\u0001eAFm]FKHJ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '/');
        }
        String str = new String(charArray);
        char[] charArray2 = "LCFAF[".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '/');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
