package ItGa5w;

import ADYaiT.BIYEnU;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class ARc23Z {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static final BIYEnU f4079A2egSU = new BIYEnU(1);

    /* renamed from: A4TApA, reason: collision with root package name */
    public static final BIYEnU f4080A4TApA = new BIYEnU(2);

    static {
        aSQpei();
    }

    public static void A2egSU(boolean z, String str) {
        if (!z) {
            throw new IllegalArgumentException(str);
        }
    }

    public static void A4TApA(Object obj) {
        A5SV6n(obj, "Argument must not be null");
    }

    public static void A5SV6n(Object obj, String str) {
        if (obj == null) {
            throw new NullPointerException(str);
        }
    }

    private static /* synthetic */ void aSQpei() {
        char[] charArray = "ãïí®çáíå®âïù®óèåìì®ÊîéÂòéäçå".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 128);
        }
        String str = new String(charArray);
        char[] charArray2 = "ãìéîéô".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 128);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
