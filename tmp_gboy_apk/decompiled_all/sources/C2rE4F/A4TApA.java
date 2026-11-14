package C2rE4F;

import android.os.Build;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class A4TApA {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static final /* synthetic */ int f1532A2egSU = 0;

    static {
        int i = Build.VERSION.SDK_INT;
        A2egSU a2egSU = A2egSU.f1531A2egSU;
        if (i >= 30) {
            a2egSU.A2egSU(30);
        }
        if (i >= 30) {
            a2egSU.A2egSU(31);
        }
        if (i >= 30) {
            a2egSU.A2egSU(33);
        }
        if (i >= 30) {
            a2egSU.A2egSU(1000000);
        }
        kJxw();
    }

    private static /* synthetic */ void kJxw() {
        char[] charArray = "þòð³úüðø³ÿòä³îõøññ³×óôßïôùúø".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 157);
        }
        String str = new String(charArray);
        char[] charArray2 = "þñôóôé".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 157);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
