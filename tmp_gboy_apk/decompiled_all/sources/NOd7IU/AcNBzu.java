package NOd7IU;

import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class AcNBzu {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static final AZOQYO[] f5874A2egSU = {new AaHO0E(AZOQYO.A2egSU("0\u0082\u0004C0\u0082\u0003+ \u0003\u0002\u0001\u0002\u0002\t\u0000Âà\u0087FdJ0\u008d0"), 0), new AaHO0E(AZOQYO.A2egSU("0\u0082\u0004¨0\u0082\u0003\u0090 \u0003\u0002\u0001\u0002\u0002\t\u0000Õ\u0085¸l}ÓNõ0"), 1)};

    static {
        LCbGn();
    }

    private static /* synthetic */ void LCbGn() {
        char[] charArray = "\u0084\u0088\u008aÉ\u0080\u0086\u008a\u0082É\u0085\u0088\u009eÉ\u0094\u008f\u0082\u008b\u008bÉ\u00ad\u0089\u008e¥\u0095\u008e\u0083\u0080\u0082".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 231);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0084\u008b\u008e\u0089\u008e\u0093".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 231);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
