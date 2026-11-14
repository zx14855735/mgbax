package D6yqiO;

import java.lang.reflect.Method;
import java.util.LinkedHashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class A5SV6n {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static final A5SV6n f2005A2egSU;

    static {
        A5SV6n a5SV6n = new A5SV6n();
        new LinkedHashMap();
        f2005A2egSU = a5SV6n;
        SOcPNr();
    }

    private static /* synthetic */ void SOcPNr() {
        char[] charArray = "àìî\u00adäâîæ\u00adáìú\u00adðëæïï\u00adÉíêÁñêçäæ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 131);
        }
        String str = new String(charArray);
        char[] charArray2 = "àïêíê÷".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 131);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
