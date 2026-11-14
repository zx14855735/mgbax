package B3GDIM;

import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class A5SV6n {

    /* renamed from: A4TApA, reason: collision with root package name */
    public static final A5SV6n f1022A4TApA = new A5SV6n();

    /* renamed from: A2egSU, reason: collision with root package name */
    public A5SV6n f1023A2egSU;

    static {
        FDqhkV();
    }

    private static /* synthetic */ void FDqhkV() {
        char[] charArray = "uy{8qw{s8tyo8e~szz8\\x\u007fTd\u007frqs".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 22);
        }
        String str = new String(charArray);
        char[] charArray2 = "uz\u007fx\u007fb".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 22);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
