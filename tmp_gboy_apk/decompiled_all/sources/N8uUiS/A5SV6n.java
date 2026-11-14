package N8uUiS;

import NSK3xo.ASJ6gh;
import NSK3xo.AYUAbz;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class A5SV6n {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static final AYUAbz f5596A2egSU = new AYUAbz("Auth.PROXY_API", new A2egSU(3), new ASJ6gh());

    static {
        HacPVWU();
    }

    private static /* synthetic */ void HacPVWU() {
        char[] charArray = "îâà£êìàè£ïâô£þåèáá£ÇãäÏÿäéêè".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 141);
        }
        String str = new String(charArray);
        char[] charArray2 = "îáäãäù".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 141);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
