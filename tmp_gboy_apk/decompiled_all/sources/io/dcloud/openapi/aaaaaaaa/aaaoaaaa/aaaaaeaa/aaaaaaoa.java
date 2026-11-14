package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa;

import ADYaiT.CtFAbx;
import java.lang.reflect.Method;
import java.nio.charset.Charset;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
abstract class aaaaaaoa {
    public static final Charset aaaaaaaa = Charset.forName("UTF-8");

    static {
        GkOa();
    }

    private static /* synthetic */ void GkOa() {
        char[] charArray = "\u0095\u0099\u009bØ\u0091\u0097\u009b\u0093Ø\u0094\u0099\u008fØ\u0085\u009e\u0093\u009a\u009aØ¼\u0098\u009f´\u0084\u009f\u0092\u0091\u0093".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 246);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0095\u009a\u009f\u0098\u009f\u0082".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 246);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private static void aaaaaaa0(Throwable th) {
        throw th;
    }

    public static int aaaaaaaa(int i) {
        return ((i & 255) << 24) | (((-16777216) & i) >>> 24) | ((16711680 & i) >>> 8) | ((65280 & i) << 8);
    }

    public static short aaaaaaaa(short s) {
        return (short) (((s & 255) << 8) | ((65280 & s) >>> 8));
    }

    public static void aaaaaaaa(long j, long j2, long j3) {
        if ((j2 | j3) < 0 || j2 > j || j - j2 < j3) {
            StringBuilder B2KMhB2 = CtFAbx.B2KMhB("size=", j, " offset=");
            B2KMhB2.append(j2);
            B2KMhB2.append(" byteCount=");
            B2KMhB2.append(j3);
            throw new ArrayIndexOutOfBoundsException(B2KMhB2.toString());
        }
    }

    public static void aaaaaaaa(Throwable th) {
        aaaaaaa0(th);
    }

    public static boolean aaaaaaaa(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            if (bArr[i4 + i] != bArr2[i4 + i2]) {
                return false;
            }
        }
        return true;
    }
}
