package L2suez;

import android.graphics.Color;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class AMqCpz {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static final int f4363A2egSU = Color.argb(50, 0, 0, 0);

    /* renamed from: A4TApA, reason: collision with root package name */
    public static final int f4364A4TApA = Color.argb(100, 255, 0, 0);

    static {
        Saxltu();
    }

    private static /* synthetic */ void Saxltu() {
        char[] charArray = "\u0001\r\u000fL\u0005\u0003\u000f\u0007L\u0000\r\u001bL\u0011\n\u0007\u000e\u000eL(\f\u000b \u0010\u000b\u0006\u0005\u0007".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'b');
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0001\u000e\u000b\f\u000b\u0016".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'b');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
