package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaua;

import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public abstract class aaaaaaaa {
    public static final String aaaaaaaa = aaaaaaae.aaaaaaac("&ixc");
    public static final String aaaaaaa0 = aaaaaaae.aaaaaaac("'lkdg}lWil'ixc'");

    static {
        kQypkD();
    }

    private static /* synthetic */ void kQypkD() {
        char[] charArray = "±½¿üµ³¿·ü°½«ü¡º·¾¾ü\u0098¼»\u0090 »¶µ·".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 210);
        }
        String str = new String(charArray);
        char[] charArray2 = "±¾»¼»¦".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 210);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
