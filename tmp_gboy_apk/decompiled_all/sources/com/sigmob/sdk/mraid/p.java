package com.sigmob.sdk.mraid;

import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public enum p {
    PORTRAIT(1),
    LANDSCAPE(0),
    NONE(-1);

    private final int d;

    static {
        pmxSMdM();
    }

    p(int i) {
        this.d = i;
    }

    private static /* synthetic */ void pmxSMdM() {
        char[] charArray = "¾²°óº¼°¸ó¿²¤ó®µ¸±±ó\u0097³´\u009f¯´¹º¸".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 221);
        }
        String str = new String(charArray);
        char[] charArray2 = "¾±´³´©".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 221);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public int a() {
        return this.d;
    }
}
