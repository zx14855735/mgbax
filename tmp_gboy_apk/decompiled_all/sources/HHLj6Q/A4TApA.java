package HHLj6Q;

import H0qugq.AZkASS;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class A4TApA extends AZkASS implements ECyGFg.A2egSU {

    /* renamed from: A5SV6n, reason: collision with root package name */
    public static final Object f3357A5SV6n = new Object();

    /* renamed from: A4TApA, reason: collision with root package name */
    public ECyGFg.A4TApA f3358A4TApA = null;

    static {
        hWCP();
    }

    private static /* synthetic */ void hWCP() {
        char[] charArray = "\u0000\f\u000eM\u0004\u0002\u000e\u0006M\u0001\f\u001aM\u0010\u000b\u0006\u000f\u000fM)\r\n!\u0011\n\u0007\u0004\u0006".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'c');
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0000\u000f\n\r\n\u0017".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'c');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
