package FOAO9d;

import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AlLFFp extends H0qugq.AZkASS implements DvK7DB.A2egSU {
    public static final Object AMqCpz = new Object();

    /* renamed from: A4TApA, reason: collision with root package name */
    public DvK7DB.A4TApA f2670A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public int f2671A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public AcNBzu f2672ADYaiT;

    static {
        jzqZF();
    }

    private static /* synthetic */ void jzqZF() {
        char[] charArray = ".\" c*, (c/\"4c>%(!!c\u0007#$\u000f?$)*(".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'M');
        }
        String str = new String(charArray);
        char[] charArray2 = ".!$#$9".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'M');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
