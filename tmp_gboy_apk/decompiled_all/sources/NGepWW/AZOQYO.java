package NGepWW;

import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class AZOQYO {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static final NSK3xo.ASJ6gh f5684A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public static final NSK3xo.AYUAbz f5685A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public static final AaHO0E f5686A5SV6n;

    static {
        NSK3xo.ASJ6gh aSJ6gh = new NSK3xo.ASJ6gh();
        f5684A2egSU = aSJ6gh;
        f5685A4TApA = new NSK3xo.AYUAbz("Common.API", new N8uUiS.A2egSU(4), aSJ6gh);
        f5686A5SV6n = new AaHO0E();
        lmyh();
    }

    private static /* synthetic */ void lmyh() {
        char[] charArray = "bnl/f`ld/cnx/ridmm/KohCshefd".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 1);
        }
        String str = new String(charArray);
        char[] charArray2 = "bmhohu".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 1);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
