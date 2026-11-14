package org.apache.commons.codec.digest;

import java.lang.reflect.Method;
import java.security.SecureRandom;
import java.util.Random;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
class B64 {
    static final String B64T_STRING = "./0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    static final char[] B64T_ARRAY = B64T_STRING.toCharArray();

    static {
        HtPg();
    }

    private static /* synthetic */ void HtPg() {
        char[] charArray = "YUW\u0014][W_\u0014XUC\u0014IR_VV\u0014pTSxHS^]_".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ ':');
        }
        String str = new String(charArray);
        char[] charArray2 = "YVSTSN".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ ':');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static void b64from24bit(byte b, byte b2, byte b3, int i, StringBuilder sb) {
        int i2 = ((b << 16) & 16777215) | ((b2 << 8) & 65535) | (b3 & 255);
        while (true) {
            int i3 = i - 1;
            if (i <= 0) {
                return;
            }
            sb.append(B64T_ARRAY[i2 & 63]);
            i2 >>= 6;
            i = i3;
        }
    }

    public static String getRandomSalt(int i) {
        return getRandomSalt(i, new SecureRandom());
    }

    public static String getRandomSalt(int i, Random random) {
        StringBuilder sb = new StringBuilder(i);
        for (int i2 = 1; i2 <= i; i2++) {
            sb.append(B64T_STRING.charAt(random.nextInt(64)));
        }
        return sb.toString();
    }
}
