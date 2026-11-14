package RujA7D;

import java.lang.reflect.Method;
import java.util.concurrent.ThreadPoolExecutor;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public abstract class A4TApA {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static final A5SV6n f7915A2egSU = new A5SV6n(1, new ThreadPoolExecutor.DiscardPolicy());

    static {
        eURVGyF();
    }

    private static /* synthetic */ void eURVGyF() {
        char[] charArray = "BNL\u000fF@LD\u000fCNX\u000fRIDMM\u000fkOHcSHEFD".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '!');
        }
        String str = new String(charArray);
        char[] charArray2 = "BMHOHU".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '!');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
