package HXc4pW;

import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class AlLFFp {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static final AcNBzu f3555A2egSU = new AcNBzu(0);

    /* renamed from: A4TApA, reason: collision with root package name */
    public static final AcNBzu f3556A4TApA = new AcNBzu(1);

    /* renamed from: A5SV6n, reason: collision with root package name */
    public static final AcNBzu f3557A5SV6n = new AcNBzu(2);

    /* renamed from: ADYaiT, reason: collision with root package name */
    public static final AcNBzu f3558ADYaiT;

    static {
        new AcNBzu(3);
        f3558ADYaiT = new AcNBzu(4);
        mrisRs();
    }

    private static /* synthetic */ void mrisRs() {
        char[] charArray = "\r\u0001\u0003@\t\u000f\u0003\u000b@\f\u0001\u0017@\u001d\u0006\u000b\u0002\u0002@$\u0000\u0007,\u001c\u0007\n\t\u000b".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'n');
        }
        String str = new String(charArray);
        char[] charArray2 = "\r\u0002\u0007\u0000\u0007\u001a".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'n');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public abstract boolean A2egSU();

    public abstract boolean A4TApA();

    public abstract boolean A5SV6n(int i);

    public abstract boolean ADYaiT(int i, int i2, boolean z);
}
