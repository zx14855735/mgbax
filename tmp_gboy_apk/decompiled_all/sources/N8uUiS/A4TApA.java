package N8uUiS;

import NCeV4Q.ADYaiT;
import NGepWW.COJEAR;
import NGepWW.Cd8JRx;
import NGepWW.D07BeM;
import NSK3xo.ASJ6gh;
import NSK3xo.AYUAbz;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class A4TApA {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static final AYUAbz f5594A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public static final ADYaiT f5595A4TApA;

    static {
        new ASJ6gh();
        new ASJ6gh();
        ASJ6gh aSJ6gh = new ASJ6gh();
        new A2egSU(0);
        new A2egSU(1);
        A2egSU a2egSU = new A2egSU(2);
        AYUAbz aYUAbz = A5SV6n.f5596A2egSU;
        f5594A2egSU = new AYUAbz("Auth.GOOGLE_SIGN_IN_API", a2egSU, aSJ6gh);
        new D07BeM();
        new Cd8JRx();
        new COJEAR();
        f5595A4TApA = new ADYaiT();
        bTxeCSy();
    }

    private static /* synthetic */ void bTxeCSy() {
        char[] charArray = "|pr1x~rz1}pf1lwzss1Uqv]mv{xz".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 31);
        }
        String str = new String(charArray);
        char[] charArray2 = "|svqvk".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 31);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
