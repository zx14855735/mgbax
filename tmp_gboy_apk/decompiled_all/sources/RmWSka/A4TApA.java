package RmWSka;

import java.io.File;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public interface A4TApA {
    public static final A4TApA SYSTEM = new A2egSU();

    static {
        UwyDBGU();
    }

    private static /* synthetic */ void UwyDBGU() {
        char[] charArray = "ZVT\u0017^XT\\\u0017[V@\u0017JQ\\UU\u0017sWP{KP]^\\".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '9');
        }
        String str = new String(charArray);
        char[] charArray2 = "ZUPWPM".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '9');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    void delete(File file);
}
