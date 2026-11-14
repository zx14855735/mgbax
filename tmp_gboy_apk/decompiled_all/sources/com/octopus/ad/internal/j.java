package com.octopus.ad.internal;

import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public enum j {
    VIDEO,
    IMAGE;

    static {
        opGuX();
    }

    private static /* synthetic */ void opGuX() {
        char[] charArray = ", \"a(.\"*a- 6a<'*##a\u0005!&\r=&+(*".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'O');
        }
        String str = new String(charArray);
        char[] charArray2 = ",#&!&;".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'O');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
