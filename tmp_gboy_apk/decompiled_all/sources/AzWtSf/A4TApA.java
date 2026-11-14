package AzWtSf;

import android.graphics.drawable.Drawable;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class A4TApA extends Drawable {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static final double f967A2egSU = Math.cos(Math.toRadians(45.0d));

    static {
        QKES();
    }

    public static float A2egSU(float f, float f2, boolean z) {
        if (!z) {
            return f;
        }
        return (float) (((1.0d - f967A2egSU) * f2) + f);
    }

    public static float A4TApA(float f, float f2, boolean z) {
        if (!z) {
            return f * 1.5f;
        }
        return (float) (((1.0d - f967A2egSU) * f2) + (f * 1.5f));
    }

    private static /* synthetic */ void QKES() {
        char[] charArray = "\u0010\u001c\u001e]\u0014\u0012\u001e\u0016]\u0011\u001c\n]\u0000\u001b\u0016\u001f\u001f]9\u001d\u001a1\u0001\u001a\u0017\u0014\u0016".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 's');
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0010\u001f\u001a\u001d\u001a\u0007".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 's');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
