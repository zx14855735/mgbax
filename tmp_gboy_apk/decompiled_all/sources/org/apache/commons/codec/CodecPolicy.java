package org.apache.commons.codec;

import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public enum CodecPolicy {
    STRICT,
    LENIENT;

    static {
        jQiT();
    }

    private static /* synthetic */ void jQiT() {
        char[] charArray = "!-/l%#/'l -;l1*'..l\b,+\u00000+&%'".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'B');
        }
        String str = new String(charArray);
        char[] charArray2 = "!.+,+6".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'B');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
