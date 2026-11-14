package AaHO0E;

import android.os.Build;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class HSHyT0 {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static boolean f933A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public static Method f934A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public static final boolean f935A5SV6n;

    static {
        f935A5SV6n = Build.VERSION.SDK_INT >= 27;
        kgJWrEV();
    }

    private static /* synthetic */ void kgJWrEV() {
        char[] charArray = "mac iock law }fkbb D`gL|gjik".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 14);
        }
        String str = new String(charArray);
        char[] charArray2 = "mbg`gz".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 14);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
