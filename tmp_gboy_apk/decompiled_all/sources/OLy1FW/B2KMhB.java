package OLy1FW;

import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class B2KMhB {

    /* renamed from: A5SV6n, reason: collision with root package name */
    public static final AzWtSf f6377A5SV6n = new AzWtSf(1, (byte) 0);

    /* renamed from: A2egSU, reason: collision with root package name */
    public final AlLFFp f6378A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final Integer f6379A4TApA;

    static {
        wDRo();
    }

    public B2KMhB(B25kr6 b25kr6) {
        b25kr6.getClass();
        this.f6378A2egSU = b25kr6.f6375A2egSU;
        Integer num = b25kr6.f6376A4TApA;
        if (num != null) {
            this.f6379A4TApA = num;
        }
    }

    private static /* synthetic */ void wDRo() {
        char[] charArray = "\u0006\n\bK\u0002\u0004\b\u0000K\u0007\n\u001cK\u0016\r\u0000\t\tK/\u000b\f'\u0017\f\u0001\u0002\u0000".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'e');
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0006\t\f\u000b\f\u0011".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'e');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
