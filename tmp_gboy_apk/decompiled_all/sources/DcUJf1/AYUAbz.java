package DcUJf1;

import ADYaiT.CtFAbx;
import android.animation.TypeEvaluator;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class AYUAbz implements TypeEvaluator {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static final AYUAbz f2330A2egSU = new AYUAbz();

    static {
        rAMRA();
    }

    private static /* synthetic */ void rAMRA() {
        char[] charArray = "\u0000\f\u000eM\u0004\u0002\u000e\u0006M\u0001\f\u001aM\u0010\u000b\u0006\u000f\u000fM)\r\n!\u0011\n\u0007\u0004\u0006".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'c');
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0000\u000f\n\r\n\u0017".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'c');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // android.animation.TypeEvaluator
    public final Object evaluate(float f, Object obj, Object obj2) {
        int intValue = ((Integer) obj).intValue();
        float f2 = ((intValue >> 24) & 255) / 255.0f;
        int intValue2 = ((Integer) obj2).intValue();
        float f3 = ((intValue2 >> 24) & 255) / 255.0f;
        float pow = (float) Math.pow(((intValue >> 16) & 255) / 255.0f, 2.2d);
        float pow2 = (float) Math.pow(((intValue >> 8) & 255) / 255.0f, 2.2d);
        float pow3 = (float) Math.pow((intValue & 255) / 255.0f, 2.2d);
        float pow4 = (float) Math.pow(((intValue2 >> 16) & 255) / 255.0f, 2.2d);
        float pow5 = (float) Math.pow(((intValue2 >> 8) & 255) / 255.0f, 2.2d);
        float pow6 = (float) Math.pow((intValue2 & 255) / 255.0f, 2.2d);
        float A4TApA2 = CtFAbx.A4TApA(f3, f2, f, f2);
        float A4TApA3 = CtFAbx.A4TApA(pow4, pow, f, pow);
        float A4TApA4 = CtFAbx.A4TApA(pow5, pow2, f, pow2);
        float A4TApA5 = CtFAbx.A4TApA(pow6, pow3, f, pow3);
        float pow7 = ((float) Math.pow(A4TApA3, 0.45454545454545453d)) * 255.0f;
        float pow8 = ((float) Math.pow(A4TApA4, 0.45454545454545453d)) * 255.0f;
        return Integer.valueOf(Math.round(((float) Math.pow(A4TApA5, 0.45454545454545453d)) * 255.0f) | (Math.round(pow7) << 16) | (Math.round(A4TApA2 * 255.0f) << 24) | (Math.round(pow8) << 8));
    }
}
