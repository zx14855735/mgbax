package DaOi9o;

import android.os.Build;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class BV3sI0 {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static final boolean f2280A2egSU;

    static {
        f2280A2egSU = Build.VERSION.SDK_INT >= 28;
        VHcI();
    }

    private static /* synthetic */ void VHcI() {
        char[] charArray = "`ln-dbnf-alz-pkfoo-ImjAqjgdf".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 3);
        }
        String str = new String(charArray);
        char[] charArray2 = "`ojmjw".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 3);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
