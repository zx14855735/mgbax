package com.bytedance.sdk.component.w.xj;

import ADYaiT.CtFAbx;
import java.lang.reflect.Method;
import java.nio.charset.Charset;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
final class pz {
    public static final Charset xj = Charset.forName("UTF-8");

    static {
        iXGg();
    }

    private static <T extends Throwable> void hf(Throwable th) {
        throw th;
    }

    private static /* synthetic */ void iXGg() {
        char[] charArray = "P\\^\u001dTR^V\u001dQ\\J\u001d@[V__\u001dy]ZqAZWTV".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '3');
        }
        String str = new String(charArray);
        char[] charArray2 = "P_Z]ZG".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '3');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static int xj(int i) {
        return ((i & 255) << 24) | (((-16777216) & i) >>> 24) | ((16711680 & i) >>> 8) | ((65280 & i) << 8);
    }

    public static short xj(short s) {
        return (short) (((s & 255) << 8) | ((65280 & s) >>> 8));
    }

    public static void xj(long j, long j2, long j3) {
        if ((j2 | j3) < 0 || j2 > j || j - j2 < j3) {
            StringBuilder B2KMhB2 = CtFAbx.B2KMhB("size=", j, " offset=");
            B2KMhB2.append(j2);
            B2KMhB2.append(" byteCount=");
            B2KMhB2.append(j3);
            throw new ArrayIndexOutOfBoundsException(B2KMhB2.toString());
        }
    }

    public static void xj(Throwable th) {
        hf(th);
    }

    public static boolean xj(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            if (bArr[i4 + i] != bArr2[i4 + i2]) {
                return false;
            }
        }
        return true;
    }
}
