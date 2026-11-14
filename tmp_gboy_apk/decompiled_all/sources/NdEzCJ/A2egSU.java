package NdEzCJ;

import ADYaiT.CtFAbx;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class A2egSU {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static final LinearInterpolator f6036A2egSU = new LinearInterpolator();

    /* renamed from: A4TApA, reason: collision with root package name */
    public static final D8cQ8b.A4TApA f6037A4TApA = new D8cQ8b.A4TApA();

    /* renamed from: A5SV6n, reason: collision with root package name */
    public static final D8cQ8b.A2egSU f6038A5SV6n = new D8cQ8b.A2egSU();

    /* renamed from: ADYaiT, reason: collision with root package name */
    public static final D8cQ8b.A5SV6n f6039ADYaiT = new D8cQ8b.A5SV6n();
    public static final DecelerateInterpolator AMqCpz = new DecelerateInterpolator();

    static {
        qnHob();
    }

    public static float A2egSU(float f, float f2, float f3) {
        return CtFAbx.A4TApA(f2, f, f3, f);
    }

    public static float A4TApA(float f, float f2, float f3, float f4, float f5) {
        return f5 <= f3 ? f : f5 >= f4 ? f2 : A2egSU(f, f2, (f5 - f3) / (f4 - f3));
    }

    public static int A5SV6n(float f, int i, int i2) {
        return Math.round(f * (i2 - i)) + i;
    }

    private static /* synthetic */ void qnHob() {
        char[] charArray = "ðüþ½ôòþö½ñüê½àûöÿÿ½ÙýúÑáú÷ôö".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 147);
        }
        String str = new String(charArray);
        char[] charArray2 = "ðÿúýúç".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 147);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
