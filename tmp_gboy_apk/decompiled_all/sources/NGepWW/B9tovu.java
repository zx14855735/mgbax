package NGepWW;

import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class B9tovu {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static final N8uUiS.A2egSU f5695A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public static final NSK3xo.AYUAbz f5696A4TApA;

    static {
        NSK3xo.ASJ6gh aSJ6gh = new NSK3xo.ASJ6gh();
        new NSK3xo.ASJ6gh();
        N8uUiS.A2egSU a2egSU = new N8uUiS.A2egSU(5);
        f5695A2egSU = a2egSU;
        new N8uUiS.A2egSU(6);
        new NSK3xo.A2egSU(1, "profile");
        new NSK3xo.A2egSU(1, "email");
        f5696A4TApA = new NSK3xo.AYUAbz("SignIn.API", a2egSU, aSJ6gh);
        KIYPam();
    }

    private static /* synthetic */ void KIYPam() {
        char[] charArray = "YUW\u0014][W_\u0014XUC\u0014IR_VV\u0014pTSxHS^]_".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ ':');
        }
        String str = new String(charArray);
        char[] charArray2 = "YVSTSN".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ ':');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
