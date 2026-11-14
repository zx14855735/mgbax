package CASmeH;

import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class A4TApA {
    public static final byte[] AMqCpz = new byte[1792];

    /* renamed from: A2egSU, reason: collision with root package name */
    public final CharSequence f1589A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final int f1590A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public int f1591A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public char f1592ADYaiT;

    static {
        for (int i = 0; i < 1792; i++) {
            AMqCpz[i] = Character.getDirectionality(i);
        }
        haVIg();
    }

    public A4TApA(CharSequence charSequence) {
        this.f1589A2egSU = charSequence;
        this.f1590A4TApA = charSequence.length();
    }

    private static /* synthetic */ void haVIg() {
        char[] charArray = ";75v?95=v:7!v+0=44v\u001261\u001a*1<?=".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'X');
        }
        String str = new String(charArray);
        char[] charArray2 = ";4161,".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'X');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public final byte A2egSU() {
        int i = this.f1591A5SV6n - 1;
        CharSequence charSequence = this.f1589A2egSU;
        char charAt = charSequence.charAt(i);
        this.f1592ADYaiT = charAt;
        if (Character.isLowSurrogate(charAt)) {
            int codePointBefore = Character.codePointBefore(charSequence, this.f1591A5SV6n);
            this.f1591A5SV6n -= Character.charCount(codePointBefore);
            return Character.getDirectionality(codePointBefore);
        }
        this.f1591A5SV6n--;
        char c = this.f1592ADYaiT;
        return c < 1792 ? AMqCpz[c] : Character.getDirectionality(c);
    }
}
